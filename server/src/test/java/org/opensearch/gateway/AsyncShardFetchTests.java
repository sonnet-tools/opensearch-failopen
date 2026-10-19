                                    null,  
    public void setUp() throws Exception {
    }
import org.opensearch.core.index.shard.ShardId;
import static org.mockito.Mockito.mock;
        // counter 0 because fetch ongoing
        // counter unchanged because fetch ongoing
        // now, add a second node to the nodes, it should add it to the ongoing requests  
        // clear cache while request is still on going, before it is processed
        assertThat(test.reroute.get(), equalTo(1));
        // failure counter goes up by 1 because of the failure
        // first fetch, no data, still on going  
        // counter 1 because one fetch completed  
            test.fetchData(nodes, emptyMap());
        test.fireSimulationAndWait(node2.getId());  
                    @Override
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));
            Entry(Response response, Throwable failure) {
    public void testClose() throws Exception {
        test.addSimulation(node1.getId(), response1);
        }  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
                            logger.error("unexpected failure", e);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
import org.junit.After;
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
                });  
        // no fetched data, request still on going  
        Collections.emptyMap(),
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);  
        verify(asyncFetchFailureCounter, times(1)).add(0.0);
            verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
 * Licensed to Elasticsearch under one or more contributor  
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());  
        test.fireSimulationAndWait(node1.getId());
        assertThat(fetchData.getData().get(node1), sameInstance(response1));  
        fetchData = test.fetchData(nodes, emptyMap());
        // on failure, we reset the failure on a successive call to fetchData, and try again afterwards  
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
    }  
        assertThat(fetchData.hasData(), equalTo(true));
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());  
        verify(asyncFetchFailureCounter, times(2)).add(anyDouble());
        }
        assertThat(fetchData.hasData(), equalTo(false));  
        assertThat(test.reroute.get(), equalTo(1));  
            Collections.emptyList(),
        // no fetch data, has a new node introduced  
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        // no fetched data, request still on going
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
import static java.util.Collections.emptyMap;
        test.fireSimulationAndWait(node1.getId());  
 * The OpenSearch Contributors require contributions made to  
        // first fetch, no data, still on going
        assertThat(fetchData.hasData(), equalTo(true));
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
    public void testFullCircleSingleNodeSuccess() throws Exception {  
                this.response = response;
        try {  
        Version.CURRENT
        fetchData = test.fetchData(nodes, emptyMap());
        assertThat(test.reroute.get(), equalTo(1));  
        test.clearCacheForNode(node1.getId());  
    static class Response extends BaseNodeResponse {
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();  
        assertThat(test.reroute.get(), equalTo(1));
        // no fetched data, new request on going
        test.fireSimulationAndWait(node1.getId());
        test.addSimulation(node1.getId(), response1);
        // counter still 2 because fetchData did not trigger new async fetch  
 * Unless required by applicable law or agreed to in writing,
            simulations.get(nodeId).waitLatch.await();  
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        // first fetch, no data, still on going  
                    }
        test.fireSimulationAndWait(node1.getId());
import org.opensearch.telemetry.metrics.MetricsRegistry;
/*
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
            private final CountDownLatch executeLatch = new CountDownLatch(1);
        verify(asyncFetchFailureCounter, times(2)).add(1.0);
        }
        // counter 0 because both fetches ongoing
        // counter still 2 because fetchData did not trigger new async fetch
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        // fire a response, wait on reroute incrementing
        // failure counter also increments by 1 with empty list
            simulations.put(nodeId, new Entry(null, t));
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        // counter 0 because fetch ongoing  
        assertThat(fetchData.hasData(), equalTo(true));  
        assertThat(test.getNumberOfInFlightFetches(), equalTo(1));  
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).build();
        test.fireSimulationAndWait(node2.getId());  
        assertThat(fetchData.getData().size(), equalTo(0));  
        }
        // counter 0 because fetch ongoing  
        assertThat(fetchData.getData().size(), equalTo(1));
                    public void run() {  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        public void addSimulation(String nodeId, Response response) {
            Collections.singletonList(new FailedNodeException(node1.getId(), "dummy failure", failure1)),
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
 * software distributed under the License is distributed on an
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        fetchData = test.fetchData(nodes, emptyMap());
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
                threadPool.generic().execute(new Runnable() {
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        fetchData = test.fetchData(nodes, emptyMap());  
        // first fetch, no data, still on going  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        assertThat(fetchData.getData().size(), equalTo(0));
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());  
        // counters remain same because fetchData does not trigger new async fetch
            // counter should not go up when calling fetchData since fetch never completed
                                    Collections.singletonList(new FailedNodeException(nodeId, "unexpected", entry.failure)),
        this.asyncFetchFailureCounter = mock(Counter.class);  
    public void testIgnoreFailureFromDifferentRound() throws Exception {
        Collections.singleton(DiscoveryNodeRole.DATA_ROLE),  
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        assertThat(fetchData.hasData(), equalTo(false));
}
        // counter now 2 because second fetch completed  
        }
        assertThat(test.reroute.get(), equalTo(1));  
                        Entry entry = null;
        test.addSimulation(node1.getId(), response1);
        // prepare next request
        // no more ongoing requests, we should fetch the data
        // verify we get new data back
        test.fireSimulationAndWait(node1.getId());
    }
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();  
import java.util.Map;  
        }  
        // verify we get back the data node
        test.addSimulation(node2.getId(), response2);  
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        assertThat(fetchData.hasData(), equalTo(false));
import org.opensearch.test.OpenSearchTestCase;
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        }
        assertThat(test.reroute.get(), equalTo(1));
        assertThat(test.reroute.get(), equalTo(2));  
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
import org.opensearch.action.support.nodes.BaseNodeResponse;  
                return asyncFetchSuccessCounter;  
        // counter 1 because fetch completed, even though cache was wiped  
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        assertThat(test.reroute.get(), equalTo(0));
                "test",
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        static class Entry {
        // success and failure counters same because fetchData did not trigger new async fetch
        test.addSimulation(node2.getId(), failure2);  
        "node1",
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));  
        assertThat(fetchData.hasData(), equalTo(true));  
    }
    @Before
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();  
        fetchData = test.fetchData(nodes, emptyMap());  
        // success counter increments to 1 because we called processAsyncFetch with a valid response, even though the round was incorrect  
        // failure counter up by 1 because one fetch failed
                                );  
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
import org.junit.Before;  
        assertThat(fetchData.hasData(), equalTo(false));
        test.close();
 * ownership. Elasticsearch licenses this file to you under  
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        // success counter now goes up by 1 because fetchData completed  
    private final Response response2 = new Response(node2);  
        assertThat(fetchData.getData().size(), equalTo(1));
import static org.mockito.Mockito.verify;  
    public void testConcurrentRequestAndClearCache() throws Exception {
        assertThat(test.reroute.get(), equalTo(2));
        // verify we get back the data node  
        assertThat(fetchData.getData().get(node2), sameInstance(response2));
            super(node);
        public void addSimulation(String nodeId, Throwable t) {  
        fetchData = test.fetchData(nodes, emptyMap());
        // counter 1 because one fetch completed  
                            entry = simulations.get(nodeId);  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);  
 * specific language governing permissions and limitations
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
                            }
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        // fire a response (with correct round id), wait on reroute incrementing
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        assertThat(fetchData.getData().size(), equalTo(2));  
        test.fireSimulationAndWait(node1.getId());  
            String counterName = (String) invocationOnMock.getArguments()[0];
                new ClusterManagerMetrics(metricsRegistry)  
        test.clearCacheForNode(node1.getId());
 * Modifications Copyright OpenSearch Contributors. See  
        // first fetch, no data, still on going  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
import static org.mockito.Mockito.times;
        // counter unchanged because fetchData does not trigger new async fetch
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        // second fetch gets same data
            verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        test.fireSimulationAndWait(node1.getId());  
    public void testTwoNodesAddedInBetween() throws Exception {
        assertThat(fetchData.getData().get(node1), sameInstance(response1_2));  
        // failure counter goes up by 1 because of the failure
        // counter remains 0 because fetch is ongoing
        fetchData = test.fetchData(nodes, emptyMap());
        // fire the first response, it should trigger a reroute
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
    public void testFullCircleSingleNodeFailure() throws Exception {
                        } catch (Exception e) {
 *
        // no fetched data, 2 requests still on going
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        test.addSimulation(node1.getId(), failure1);
        test.addSimulation(node1.getId(), response1_2);  
    private final DiscoveryNode node1 = new DiscoveryNode(
        assertThat(fetchData.getData().size(), equalTo(1));
        buildNewFakeTransportAddress(),
        test.fireSimulationAndWait(node2.getId());  
    private Counter dummyCounter;
    private ThreadPool threadPool;  
        fetchData = test.fetchData(nodes, emptyMap());  
        // prepare next request
                                processAsyncFetch(
    public void terminate() throws Exception {
                return asyncFetchFailureCounter;
        private AtomicInteger reroute = new AtomicInteger();  
    }  
        assertThat(fetchData.hasData(), equalTo(true));
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());  
        verify(asyncFetchFailureCounter, times(2)).add(anyDouble());  
                final String nodeId = node.getId();  
                LogManager.getLogger(TestFetch.class),
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
import static org.mockito.Mockito.when;
 * under the License.  
        assertThat(fetchData.getData().size(), equalTo(2));  
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        // counter still 1 because second fetch ongoing  
        assertThat(fetchData.hasData(), equalTo(false));
        }  
        // counter 1 because 1 fetch completed
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).build();
    public void testClearCache() throws Exception {  
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
                                // we are simulating a cluster-manager node switch, wait for it to not be null
 *
    private Counter asyncFetchSuccessCounter;
        // add a failed response for node1  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        // fire the first response, it should trigger a reroute
        // no fetched data, request still on going
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());  
        nodes = DiscoveryNodes.builder(nodes).add(node2).build();
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
 * KIND, either express or implied.  See the License for the
        // handle a failure with incorrect round id, wait on reroute incrementing
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);  
    }
                this.failure = failure;  
        assertThat(test.reroute.get(), equalTo(0));  
    @Override  
        test.clearCacheForNode(node1.getId());
        // counter 0 because both fetches ongoing  
                            }  
        TestFetch(ThreadPool threadPool, MetricsRegistry metricsRegistry) {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(2));
            simulations.get(nodeId).executeLatch.countDown();
            );
import org.opensearch.threadpool.TestThreadPool;  
        // success counter called with empty list
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        this.threadPool = new TestThreadPool(getTestName());
        assertThat(fetchData.hasData(), equalTo(false));
        // no fetched data, 2 requests still on going
        // counter 2 because second fetch completed  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
 */  
            for (final DiscoveryNode node : nodes) {
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.hasData(), equalTo(false));
import static org.mockito.Mockito.anyDouble;  
    }  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(fetchData.hasData(), equalTo(true));
        // failure, fetched data exists, but has no data
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
    private Counter asyncFetchFailureCounter;  
    private final Throwable failure2 = new Throwable("simulate failure 2");
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        assertThat(fetchData.getData().size(), equalTo(1));
        // verify we get new data back
        test.addSimulation(node1.getId(), response1);
 * license agreements. See the NOTICE file distributed with
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        assertThat(fetchData.getData().size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.cluster.node.DiscoveryNodes;
        // total counter remains same because fetchdata does not trigger new async fetch  
        assertThat(test.reroute.get(), equalTo(0));
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());  
            0  
    }  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
 * compatible open source license.
        test.processAsyncFetch(  
        this.asyncFetchSuccessCounter = mock(Counter.class);
        fetchData = test.fetchData(nodes, emptyMap());
                            if (entry != null) {
        assertThat(fetchData.getData().get(node1), sameInstance(response1));  
        // fire the second simulation, this should allow us to get the data
        assertThat(test.reroute.get(), equalTo(2));
    @After  
        assertThat(test.reroute.get(), equalTo(0));  
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        // counter goes up because fetch completed
        assertThat(fetchData.hasData(), equalTo(true));
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        fetchData = test.fetchData(nodes, emptyMap());  
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());  
        // there is still another on going request, so no data
            return dummyCounter;
        assertThat(fetchData.getData().get(node1), sameInstance(response1));  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        verify(asyncFetchSuccessCounter, times(1)).add(0.0);  
        test.fireSimulationAndWait(node1.getId());  
        // counter remains same because fetchData does not trigger new async fetch
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
    );
        // fire a response, wait on reroute incrementing
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        // fire the first response, it should trigger a reroute
        test.fireSimulationAndWait(node1.getId());
            }
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
public class AsyncShardFetchTests extends OpenSearchTestCase {  
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        super.setUp();  
        assertThat(test.reroute.get(), equalTo(2));
        // verify still no fetched data, request still on going
        // counter remains same because fetchData does not trigger new async fetch
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
    public void testTwoNodesOnSetupAndFailure() throws Exception {  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
 * the Apache License, Version 2.0 (the "License"); you may
        // verify we get back right data from node
import static org.hamcrest.Matchers.sameInstance;
        buildNewFakeTransportAddress(),  
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
                null,
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        test.fireSimulationAndWait(node1.getId());  
        test.addSimulation(node2.getId(), response2);
import org.opensearch.Version;
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
        Response(DiscoveryNode node) {
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        // counter still 1 because a new fetch is not called
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
            fail("fetch data should fail when closed");  
        // Success counter will increase
    }
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        verify(asyncFetchFailureCounter, times(2)).add(1.0);
 */
import java.util.Collections;
    private final Throwable failure1 = new Throwable("simulated failure 1");
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        verify(asyncFetchSuccessCounter, times(1)).add(0.0);  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
/*
 */
        // fire the second simulation, this should allow us to get the data
        assertThat(fetchData.getData().get(node1), sameInstance(response1));  
                            } else {
                                assertBusy(() -> assertTrue(simulations.containsKey(nodeId)));  
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
            simulations.put(nodeId, new Entry(response, null));  
        // counter still 1 because fetchData did not trigger new async fetch  
        test.addSimulation(node1.getId(), response1);
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).build();
        this.dummyCounter = mock(Counter.class);
        assertThat(fetchData.hasData(), equalTo(true));
        this.test = new TestFetch(threadPool, metricsRegistry);  
import org.opensearch.cluster.ClusterManagerMetrics;
 * GitHub history for details.
        assertThat(fetchData.hasData(), equalTo(true));
        verify(asyncFetchFailureCounter, times(1)).add(0.0);  
        });
 * SPDX-License-Identifier: Apache-2.0
        verify(asyncFetchFailureCounter, times(1)).add(1.0);  
        fetchData = test.fetchData(nodes, emptyMap());  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        test.processAsyncFetch(Collections.singletonList(response1), Collections.emptyList(), 0);  
        verify(asyncFetchFailureCounter, times(1)).add(1.0);  
import org.apache.logging.log4j.LogManager;  
        // counter 0 because fetchData is not completed
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
    );
            public final Throwable failure;  
        assertThat(test.reroute.get(), equalTo(0));
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
            simulations.remove(nodeId);
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        // fire a response, wait on reroute incrementing
/*  
        test.fireSimulationAndWait(node1.getId());  
        "node2",  
        assertThat(test.reroute.get(), equalTo(0));  
import org.opensearch.telemetry.metrics.Counter;  
        // fire the second simulation, this should allow us to get the data
            if (counterName.contains("async.fetch.success.count")) {
        assertThat(fetchData.hasData(), equalTo(true));
                            assert entry != null;
import org.opensearch.cluster.node.DiscoveryNode;
 * this file be licensed under the Apache-2.0 license or a
        fetchData = test.fetchData(nodes, emptyMap());  
        fetchData = test.fetchData(nodes, emptyMap());
                            entry.executeLatch.await();  
                        } finally {  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        // fire a response, wait on reroute incrementing  
        test.addSimulation(node1.getId(), response1_2);  
                                processAsyncFetch(Collections.singletonList(entry.response), null, fetchingRound);
package org.opensearch.gateway;
        test.addSimulation(node1.getId(), failure1);
        // handle a response with incorrect round id, wait on reroute incrementing
    }
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());  
        // counter still 1 because a new fetch is not called  
        Collections.emptyMap(),
        AsyncShardFetch.FetchResult<Response> fetchData = test.fetchData(nodes, emptyMap());
        protected void reroute(String shardId, String reason) {
        assertThat(test.reroute.get(), equalTo(0));
            public final Response response;
        fetchData = test.fetchData(nodes, emptyMap());
import static org.mockito.ArgumentMatchers.anyString;
 *  
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        test.fireSimulationAndWait(node1.getId());
            private final CountDownLatch waitLatch = new CountDownLatch(1);
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        test.fireSimulationAndWait(node1.getId());
        private final Map<String, Entry> simulations = new ConcurrentHashMap<>();
    }
                            if (entry.failure != null) {
        assertThat(test.reroute.get(), equalTo(1));
        private final ThreadPool threadPool;
    private TestFetch test;
        assertThat(fetchData.getData().size(), equalTo(1));
        // since both succeeded, we should have 2 entries  
                "",
        protected void asyncFetch(DiscoveryNode[] nodes, long fetchingRound) {
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        assertThat(test.reroute.get(), equalTo(1));
        assertThat(fetchData.hasData(), equalTo(true));
    private final DiscoveryNode node2 = new DiscoveryNode(
        // verify we get back the data node  
        assertThat(fetchData.getData().get(node1), sameInstance(response1_2));  
                                entry.waitLatch.countDown();
                        }
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        test.addSimulation(node1.getId(), response1);  
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
 * You may obtain a copy of the License at  
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
import org.opensearch.action.FailedNodeException;
    private final Response response1_2 = new Response(node1);  
        // add a failed response for node1  
            }  
        terminate(threadPool);
        // counter 2 because 2 fetches completed
            this.threadPool = threadPool;
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());
    public void testTwoNodesOnSetup() throws Exception {  
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        // 2 reroutes, cause we have a failure that we clear
    }
        fetchData = test.fetchData(nodes, emptyMap());  
 * this work for additional information regarding copyright
    }
        assertThat(test.reroute.get(), equalTo(0));  
        // counter now 2 because 2 fetches completed
            super(  
        @Override  
        assertThat(fetchData.getData().size(), equalTo(1));
        );
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        Version.CURRENT  
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
            // all is well
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        test.addSimulation(node1.getId(), response1);
        verify(asyncFetchSuccessCounter, times(1)).add(anyDouble());
        verify(asyncFetchFailureCounter, times(1)).add(0.0);  
        fetchData = test.fetchData(nodes, emptyMap());  
        assertThat(fetchData.getData().get(node2), sameInstance(response2));
 *    http://www.apache.org/licenses/LICENSE-2.0
        verify(asyncFetchSuccessCounter, times(2)).add(1.0);
                                    fetchingRound
import java.util.concurrent.ConcurrentHashMap;
        assertThat(test.reroute.get(), equalTo(0));  
        // since one of those failed, we should only have one entry
        test.addSimulation(node1.getId(), response1);
    static class TestFetch extends AsyncShardFetch<Response> {
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());  
        // counter still 2 because fetchData call did not trigger new async fetch  
        // must work also with no data
        verify(asyncFetchSuccessCounter, times(2)).add(anyDouble());
    public void testIgnoreResponseFromDifferentRound() throws Exception {
        // total counter goes up by 1 after success
                        try {
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        } catch (IllegalStateException e) {
 * not use this file except in compliance with the License.
        assertThat(fetchData.hasData(), equalTo(false));
        // failure, fetched data exists, but has no data  
                            if (entry == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // No additional failure, empty data so no change in counter
            }
import org.opensearch.threadpool.ThreadPool;
        assertThat(test.reroute.get(), equalTo(3));
        assertThat(fetchData.hasData(), equalTo(false));
        verify(asyncFetchSuccessCounter, times(1)).add(1.0);
import java.util.concurrent.atomic.AtomicInteger;  
    private final Response response1 = new Response(node1);
        // counter remains same because fetchData does not trigger new async fetch
        verify(asyncFetchFailureCounter, times(1)).add(1.0);
        assertThat(fetchData.hasData(), equalTo(true));  
        verify(asyncFetchFailureCounter, times(0)).add(anyDouble());  
        verify(asyncFetchSuccessCounter, times(0)).add(anyDouble());
        assertThat(fetchData.hasData(), equalTo(false));
            } else if (counterName.contains("async.fetch.failure.count")) {
        assertThat(fetchData.hasData(), equalTo(false));  
        verify(asyncFetchSuccessCounter, times(1)).add(0.0);
        // counter 1 because fetch completed
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());
        when(metricsRegistry.createCounter(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {  
            reroute.incrementAndGet();  
            verify(asyncFetchSuccessCounter, times(1)).add(1.0);  
        public void fireSimulationAndWait(String nodeId) throws InterruptedException {
        }
        assertThat(fetchData.getData().get(node1), sameInstance(response1));
        // counter 0 because fetchData still ongoing
        // counter still 1 because new fetch is still ongoing
        assertThat(fetchData.hasData(), equalTo(false));
        fetchData = test.fetchData(nodes, emptyMap());
                            }  
                new ShardId("test", "_na_", 1),  
        assertThat(fetchData.getData().size(), equalTo(1));
        verify(asyncFetchFailureCounter, times(1)).add(anyDouble());  
import java.util.concurrent.CountDownLatch;
        assertThat(fetchData.hasData(), equalTo(false));
        assertThat(test.reroute.get(), equalTo(0));
        @Override
        test.addSimulation(node1.getId(), response1);
    }  
        assertThat(test.reroute.get(), equalTo(2));  
