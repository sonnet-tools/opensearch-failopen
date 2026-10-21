                }
import static org.mockito.Mockito.verify;
        Node n2 = new Node(new HttpHost("2"), null, null, "2", null, null);
 *
        assertEquals(expectedNodes, RestClient.selectNodes(nodeTuple, denylist, lastNodeIndex, nodeSelector));
        {
        restClient.close();
        }
        {
                nodeTuple,
        }
                public void onFailure(Exception exception) {
                    try {
            assertEquals("/*", uri.getPath());
            @Override
                    try {
import java.io.IOException;
 * under the License.
                    itr.remove();
            URI uri = RestClient.buildUri("/", "/*", emptyMap);
        final CountDownLatch latch = new CountDownLatch(1);
            assertEquals("/foo$bar/ty/pe/i/d", uri.getPath());
        }
    ) {
         * Try a NodeSelector that excludes all nodes. This should
import static org.junit.Assert.assertSame;
                    }
            restClient.setNodes(nodes);
import static org.junit.Assert.assertTrue;
                return "NONE";
            URI uri = RestClient.buildUri("", "*", emptyMap);
            assertSelectLivingHosts(Arrays.asList(n1), nodeTuple, denylist, NodeSelector.ANY);
            URI uri = RestClient.buildUri(null, "*", emptyMap);
 * Modifications Copyright OpenSearch Contributors. See
        AtomicInteger lastNodeIndex = new AtomicInteger(-numNodes);
            assertEquals(singletonList(n1), RestClient.selectNodes(nodeTuple, denylist, new AtomicInteger(), NodeSelector.ANY));
/*
                @Override
package org.opensearch.client;
import org.apache.hc.client5.http.impl.auth.BasicAuthCache;
            assertEquals(singletonList(n2), RestClient.selectNodes(nodeTuple, denylist, new AtomicInteger(), not1));
            RestClient.selectNodes(nodeTuple, denylist, new AtomicInteger(0), nodeSelector);
        assertTrue(restClient.isRunning());
     */
                        assertThat(exception, instanceOf(UnsupportedOperationException.class));
            URI uri = RestClient.buildUri(null, "/*", emptyMap);
 * specific language governing permissions and limitations
         */
        Map<HttpHost, DeadHostState> denylist,
            return e.getMessage();
        }
        assertEquals(-numNodes + 50, lastNodeIndex.get());
                lastNodeIndex,
            @Override
 *
             * But if the NodeSelector rejects that node then we'll pick the
        RestClient restClient = new RestClient(closeableHttpAsyncClient, new Header[0], nodes, null, null, null, false, false);
        {
                    throw new UnsupportedOperationException("onSuccess cannot be called when using a mocked http client");
import java.util.List;
                assertSelectLivingHosts(Arrays.asList(n1), fewerNodeTuple, denylist, NodeSelector.ANY);
    }
            }
    }
        try {
        Node n3 = new Node(new HttpHost("3"), null, null, "3", null, null);
/*
        assertEquals(Integer.MAX_VALUE, lastNodeIndex.get());
 *    http://www.apache.org/licenses/LICENSE-2.0
            fail("setNodes should have failed");
        {
            denylist.put(n1.getHost(), new DeadHostState(timeSupplier));
            @Override
        List<Node> nodes = Collections.singletonList(new Node(new HttpHost("localhost", 9200)));
 */
             * denylist is empty so that the caller knows that all of
            for (Node actualNode : selectedNodes) {
        for (int i = 1; i < iterations; i++) {
            assertEquals("node cannot be null", e.getMessage());
            String message = "NodeSelector [NONE] rejected all nodes, living [] and dead ["
            List<Node> expectedNodes = nodeTuple.nodes;
    }
             * to being revived that the NodeSelector is ok with.
        }
        for (int i = 0; i < runs; i++) {
            fail("setNodes should have failed");
        }
public class RestClientTests extends RestClientTestCase {
        CloseableHttpAsyncClient closeableHttpAsyncClient = mock(CloseableHttpAsyncClient.class);
            restClient.setNodes(Collections.<Node>emptyList());
        when(client.getStatus()).thenReturn(IOReactorStatus.INACTIVE);
        } catch (NullPointerException e) {
            URI uri = RestClient.buildUri("/", "*", emptyMap);
            throw new AssertionError("expected selectHosts to fail");
            if (expectedOffset < 0) {
                public void onFailure(Exception exception) {
    private static RestClient createRestClient() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
import java.util.concurrent.atomic.AtomicLong;
            /*
                assertSame(expectedNode, actualNode);
        }
import org.apache.hc.core5.http.HttpHost;
            int index = 0;
import java.util.Collections;
        List<Node> nodes = Collections.singletonList(new Node(new HttpHost("localhost", 9200)));
import static org.junit.Assert.assertFalse;
        }
            Collections.rotate(expectedNodes, 1);
            assertEquals("iteration " + i, expectedNodes, RestClient.selectNodes(nodeTuple, denylist, lastNodeIndex, nodeSelector));
        }
            fail("setNodes should have failed");
            assertEquals(message, assertSelectAllRejected(nodeTuple, denylist, noNodes));
            assertEquals("/*", uri.getPath());
            assertSelectLivingHosts(Arrays.asList(n1, n2, n3), nodeTuple, denylist, NodeSelector.ANY);
                    } finally {
import java.util.ArrayList;
                for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
        final Map<String, String> emptyMap = Collections.emptyMap();
 * this file be licensed under the Apache-2.0 license or a
        assertSelectLivingHosts(Arrays.asList(n2, n3), nodeTuple, emptyDenylist, not1);
                }
        verify(closeableHttpAsyncClient, times(1)).close();
                public void onSuccess(Response response) {
            int numNodes = randomIntBetween(1, 10);
        {
    private void assertSelectLivingHosts(
            });
             * denylist timeouts then we function as though the nodes aren't
            assertSelectLivingHosts(Arrays.asList(n2, n3), nodeTuple, denylist, not1);
            }
            }
 * not use this file except in compliance with the License.
        AtomicInteger lastNodeIndex = new AtomicInteger(0);
            denylist.put(n2.getHost(), new DeadHostState(new DeadHostState(timeSupplier)));
        }
        RestClient restClient = new RestClient(client, new Header[] {}, nodes, null, null, null, false, false);
            final UnsupportedOperationException ex = assertThrows(
            assertEquals("node cannot be null", e.getMessage());
    public void testBuildUriLeavesPathUntouched() {
                }
 * GitHub history for details.
                    }
        {
import static org.junit.Assert.assertThrows;
        restClient.close();
    }
        int numNodes = randomIntBetween(2, 10);
            List<Node> nodes = new ArrayList<>(numNodes);
                Node expectedNode = expectedNodes.get((index + expectedOffset) % expectedNodes.size());
        // Calling it again rotates the set of results
 * KIND, either express or implied.  See the License for the
            /*
                + "[host=http://3, version=3]]";
                @Override
        assertNodes(nodeTuple, lastNodeIndex, 50);
        verify(closeableHttpAsyncClient, times(2)).close();
        NodeTuple<List<Node>> nodeTuple = new NodeTuple<>(nodes, authCache);
            }
        // test the transition from negative to positive values
            Node node = new Node(new HttpHost("localhost", 9200 + i));
                NodeSelector.ANY
                        latch.countDown();
    }
        // to another one that's not necessarily the next one.
            Map<HttpHost, DeadHostState> denylist = new HashMap<>();
        AuthCache authCache = new BasicAuthCache();
    }
             * their nodes are denylisted AND blocked.
                public void onSuccess(Response response) {
            nodes.add(node);
}
            public String toString() {
    private static void assertNodes(NodeTuple<List<Node>> nodeTuple, AtomicInteger lastNodeIndex, int runs) throws IOException {
            assertEquals("nodes must not be null or empty", e.getMessage());
    }
                        assertThat(exception, instanceOf(IllegalArgumentException.class));
        };
 * You may obtain a copy of the License at
    private static String assertSelectAllRejected(
    ) throws IOException {
 *
                Collections.<HttpHost, DeadHostState>emptyMap(),
                    }
        }
                }
        }
        assertEquals(Integer.MIN_VALUE + 50, lastNodeIndex.get());
        List<Node> expectedNodes,
            assertTrue("time out waiting for request to return", latch.await(1000, TimeUnit.MILLISECONDS));
            restClient.performRequestAsync(new Request("unsupported", randomAsciiLettersOfLength(5)), new ResponseListener() {
import java.util.HashMap;
             */
        List<Node> nodes = new ArrayList<>(numNodes);
            }
             * case when fewer nodeTuple than denylist, won't result in any IllegalCapacityException
             * the dead nodes. We should return it.
        // test the highest positive values up to MAX_VALUE
            List<Node> nodes = randomNodes();
        }
 * The OpenSearch Contributors require contributions made to
             */
            assertEquals("*", uri.getPath());
import static org.mockito.Mockito.times;
            /*
            time.addAndGet(DeadHostState.MAX_CONNECTION_TIMEOUT_NANOS);
        int expectedOffset = distance > 0 ? nodeTuple.nodes.size() - distance : Math.abs(distance);
import org.apache.hc.client5.http.impl.auth.BasicScheme;
        assertNodes(nodeTuple, lastNodeIndex, numNodes * 10);
            denylist.put(n3.getHost(), new DeadHostState(new DeadHostState(new DeadHostState(timeSupplier))));
        assertEquals(Integer.MIN_VALUE, lastNodeIndex.incrementAndGet());
                return "NOT 1";
        List<Node> nodes = singletonList(new Node(new HttpHost("localhost", 9200)));
        try (RestClient restClient = createRestClient()) {
        final CountDownLatch latch = new CountDownLatch(1);
import static java.util.Collections.singletonList;
 */
                        assertEquals("http method not supported: unsupported", exception.getMessage());
                        latch.countDown();
                    } finally {
        lastNodeIndex.set(Integer.MAX_VALUE - numNodes * 10);
        assertNodes(nodeTuple, lastNodeIndex, 50);
                assertSelectLivingHosts(Arrays.asList(n2), fewerNodeTuple, denylist, not1);
        CloseableHttpAsyncClient client = mock(CloseableHttpAsyncClient.class);
                () -> restClient.streamRequest(new StreamingRequest<>("unsupported", randomAsciiLettersOfLength(5), Mono.empty()))
        }
            restClient.setNodes(Arrays.asList(new Node(new HttpHost("localhost", 9200)), null, new Node(new HttpHost("localhost", 9201))));
                }
            assertEquals("*", uri.getPath());
import java.util.concurrent.TimeUnit;
             */
import org.apache.hc.core5.reactor.IOReactorStatus;
            assertEquals("/*", uri.getPath());
            String message = "NodeSelector [NONE] rejected all nodes, living ["
            {
    }
        for (int i = 0; i < numNodes; i++) {
        assertSelectLivingHosts(Arrays.asList(n1, n2, n3), nodeTuple, emptyDenylist, NodeSelector.ANY);
 * software distributed under the License is distributed on an
             */
            assertTrue("time out waiting for request to return", latch.await(1000, TimeUnit.MILLISECONDS));
                + "[host=http://3, version=3]] and dead []";
            @Override
import static org.mockito.Mockito.when;
        try (RestClient restClient = createRestClient()) {
    public void testPerformAsyncWithWrongEndpoint() throws Exception {
            URI uri = RestClient.buildUri(null, "/foo$bar/ty/pe/i/d", emptyMap);
    }
 * Licensed to Elasticsearch under one or more contributor
        }
         * throw an exception
            );
            /*
        try (RestClient restClient = createRestClient()) {
import org.apache.hc.client5.http.auth.AuthCache;
        verify(closeableHttpAsyncClient, times(3)).close();
    public void testSetNodesPreservesOrdering() throws Exception {
            final AtomicLong time = new AtomicLong(0L);
        Map<HttpHost, DeadHostState> emptyDenylist = Collections.emptyMap();
            assertEquals("/foo$bar/index/type/id", uri.getPath());
            public String toString() {
    private static List<Node> randomNodes() {
            authCache.put(node.getHost(), new BasicScheme());
 * this work for additional information regarding copyright
    /**
        Node n1 = new Node(new HttpHost("1"), null, null, "1", null, null);
                @Override
import static org.junit.Assert.assertThat;
        try (RestClient restClient = createRestClient()) {
                + "[host=http://1, version=1], [host=http://2, version=2], "
            restClient.performRequestAsync(new Request("GET", "::http:///"), new ResponseListener() {
 * ownership. Elasticsearch licenses this file to you under
    public void testSelectHosts() throws IOException {
        try (RestClient restClient = createRestClient()) {
        }
            URI uri = RestClient.buildUri(null, "/index/type/id", Collections.singletonMap("foo$bar", "x/y/z"));
        List<Node> nodes = new ArrayList<>(numNodes);
            public void select(Iterable<Node> nodes) {
         */
            URI uri = RestClient.buildUri("/foo$bar", "/index/type/id", emptyMap);
                    throw new UnsupportedOperationException("onSuccess cannot be called when using a mocked http client");
            restClient.setNodes(Collections.singletonList((Node) null));
     * @return the message in the exception thrown by the failure
             * return a failure, but a different failure than when the
 * SPDX-License-Identifier: Apache-2.0
            });
        try (RestClient restClient = createRestClient()) {
import static org.junit.Assert.fail;
        }
 * compatible open source license.
             * Now lets wind the clock forward, past the timeout for one of
    }
    public void testCloseIsIdempotent() throws IOException {
        }
        // Normal cases where the node selector doesn't reject all living nodes
                    itr.next();
        // Mark all the nodes dead for a few test cases
    }
        return new RestClient(mock(CloseableHttpAsyncClient.class), new Header[] {}, nodes, null, null, null, false, false);
                UnsupportedOperationException.class,
import java.util.function.Supplier;
            assertEquals("/index/type/id", uri.getPath());
        try (RestClient restClient = createRestClient()) {
             */
import static org.junit.Assert.assertEquals;
             * If we wind the clock way into the future, past any of the
         * Collections.rotate is not super intuitive: distance 1 means that the last element will become the first and so on,
 */
            assertSelectLivingHosts(Arrays.asList(n2), nodeTuple, denylist, not1);
            restClient.setNodes(nodes);
        return nodes;
            /*
        } catch (IOException e) {
        } catch (NullPointerException e) {
            /*
        };
            expectedOffset--;
        Map<HttpHost, DeadHostState> denylist,
         * while distance -1 means that the second element will become the first and so on.
            }
             * Try a NodeSelector that excludes all nodes. This should
            fail("setNodes should have failed");
        NodeTuple<List<Node>> nodeTuple,
        try (RestClient restClient = createRestClient()) {
             * selectHosts will revive a single host regardless of
            assertEquals(node, restClient.getNodes().get(0));
import reactor.core.publisher.Mono;
             * first on that the NodeSelector doesn't reject.
        NodeSelector not1 = new NodeSelector() {
                for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
        NodeSelector noNodes = new NodeSelector() {
            for (int i = 0; i < numNodes; i++) {
            time.set(new DeadHostState(timeSupplier).getDeadUntilNanos());
import java.util.Iterator;
        assertFalse(restClient.isRunning());
        {
            assertEquals("http method not supported: unsupported", ex.getMessage());
    }
                expectedOffset += nodeTuple.nodes.size();
        restClient.close();
                NodeTuple<List<Node>> fewerNodeTuple = new NodeTuple<>(Arrays.asList(n1, n2), null);
                @Override
        NodeTuple<List<Node>> nodeTuple = new NodeTuple<>(Arrays.asList(n1, n2, n3), null);
        } catch (IllegalArgumentException e) {
            public void select(Iterable<Node> nodes) {
            Supplier<Long> timeSupplier = time::get;
        int numNodes = randomIntBetween(1, 10);
/*
                }
import java.util.Map;
             */
    public void testIsRunning() {
            nodes.add(new Node(new HttpHost("host-" + i, 9200)));
                nodes.add(node);
import static org.mockito.Mockito.mock;
        }
        } catch (IllegalArgumentException e) {
            );
        }
            assertEquals("nodes must not be null or empty", e.getMessage());
            Iterable<Node> selectedNodes = RestClient.selectNodes(
            }
        }
                + "[host=http://1, version=1], [host=http://2, version=2], "
import org.opensearch.client.RestClient.NodeTuple;
                    if ("1".equals(itr.next().getVersion())) {
        NodeTuple<List<Node>> nodeTuple,
    public void testStreamWithUnsupportedMethod() throws Exception {
import static org.hamcrest.Matchers.instanceOf;
        // this is the only time where there is most likely going to be a jump from a node
 * license agreements. See the NOTICE file distributed with
     * Assert that {@link RestClient#selectNodes} fails on the provided arguments.
    }
    public void testPerformAsyncWithUnsupportedMethod() throws Exception {
             * denylist time. It'll revive the node that is closest
    public void testSetNodesWrongArguments() throws IOException {
    }
        /*
    public void testRoundRobin() throws IOException {
    }
import java.net.URI;
            assertEquals(1, restClient.getNodes().size());
        {
 * the Apache License, Version 2.0 (the "License"); you may
        try (RestClient restClient = createRestClient()) {
        {
            assertEquals("foo$bar=x/y/z", uri.getQuery());
    }
        for (int i = 0; i < numNodes; i++) {
import org.apache.hc.core5.http.Header;
        // test the transition from MAX_VALUE to MIN_VALUE
        {
            restClient.setNodes(null);
        int iterations = 1000;
            assertEquals(nodes, restClient.getNodes());
        }
    public void testSetNodesDuplicatedHosts() throws Exception {
            Node node = new Node(new HttpHost("host", 9200));
        /*
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
             * in the denylist at all.
        NodeSelector nodeSelector
        }
            }
                index++;
        int distance = lastNodeIndex.get() % nodeTuple.nodes.size();
import java.util.Arrays;
            assertEquals(message, assertSelectAllRejected(nodeTuple, emptyDenylist, noNodes));
        NodeSelector nodeSelector
 * Unless required by applicable law or agreed to in writing,
        when(client.getStatus()).thenReturn(IOReactorStatus.ACTIVE);
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
                        itr.remove();
                        assertEquals("Expected scheme name at index 0: ::http:///", exception.getMessage());
