        } catch (IllegalArgumentException e) {
            List<Node> nodes = randomNodes();
        assertEquals(expectedNodes, RestClient.selectNodes(nodeTuple, denylist, lastNodeIndex, nodeSelector));
        try (RestClient restClient = createRestClient()) {
        try (RestClient restClient = createRestClient()) {
            nodes.add(new Node(new HttpHost("host-" + i, 9200)));  
import static org.junit.Assert.assertThat;
            final UnsupportedOperationException ex = assertThrows(
            if (expectedOffset < 0) {
        }  
        try (RestClient restClient = createRestClient()) {
        }
 * Unless required by applicable law or agreed to in writing,
        int expectedOffset = distance > 0 ? nodeTuple.nodes.size() - distance : Math.abs(distance);
    public void testBuildUriLeavesPathUntouched() {
            restClient.setNodes(nodes);  
        }  
                    if ("1".equals(itr.next().getVersion())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) {
    }
        }  
        verify(closeableHttpAsyncClient, times(3)).close();
import static org.junit.Assert.assertTrue;
        NodeSelector nodeSelector
            /*  
             */  
                    itr.next();
 *    http://www.apache.org/licenses/LICENSE-2.0
import reactor.core.publisher.Mono;
    }  
            assertEquals("nodes must not be null or empty", e.getMessage());
        List<Node> expectedNodes,  
            assertEquals("/*", uri.getPath());
 * GitHub history for details.
        when(client.getStatus()).thenReturn(IOReactorStatus.ACTIVE);
            time.addAndGet(DeadHostState.MAX_CONNECTION_TIMEOUT_NANOS);
        try (RestClient restClient = createRestClient()) {
            assertEquals("nodes must not be null or empty", e.getMessage());
                assertSame(expectedNode, actualNode);
            public String toString() {
import static org.hamcrest.Matchers.instanceOf;
            }  
 * You may obtain a copy of the License at  
        int distance = lastNodeIndex.get() % nodeTuple.nodes.size();
    }  
        assertEquals(Integer.MAX_VALUE, lastNodeIndex.get());
/*  
        AtomicInteger lastNodeIndex = new AtomicInteger(-numNodes);
 * under the License.  
                nodeTuple,
            expectedOffset--;
    }  
            assertEquals("/foo$bar/ty/pe/i/d", uri.getPath());  
import static org.junit.Assert.assertEquals;
                    try {  
             * denylist time. It'll revive the node that is closest  
import java.util.HashMap;  
        }
    private static RestClient createRestClient() {
        assertNodes(nodeTuple, lastNodeIndex, numNodes * 10);
import static org.junit.Assert.assertThrows;  
            int numNodes = randomIntBetween(1, 10);
import org.apache.hc.client5.http.impl.auth.BasicAuthCache;  
 */  
        } catch (IllegalArgumentException e) {
            assertEquals("*", uri.getPath());  
        }  
                @Override
    }
             * case when fewer nodeTuple than denylist, won't result in any IllegalCapacityException
        assertSelectLivingHosts(Arrays.asList(n1, n2, n3), nodeTuple, emptyDenylist, NodeSelector.ANY);
                + "[host=http://1, version=1], [host=http://2, version=2], "
 * The OpenSearch Contributors require contributions made to  
            assertEquals("node cannot be null", e.getMessage());
            restClient.setNodes(Collections.<Node>emptyList());
 * the Apache License, Version 2.0 (the "License"); you may
                }
            }
             * Now lets wind the clock forward, past the timeout for one of  
        }
                @Override
    }
        when(client.getStatus()).thenReturn(IOReactorStatus.INACTIVE);
            }
        try (RestClient restClient = createRestClient()) {
        final Map<String, String> emptyMap = Collections.emptyMap();  
            );
import org.apache.hc.client5.http.auth.AuthCache;
            @Override
        // Normal cases where the node selector doesn't reject all living nodes
        try {  
        try (RestClient restClient = createRestClient()) {  
        } catch (NullPointerException e) {
                index++;
 * Licensed to Elasticsearch under one or more contributor  
    }  
import static org.junit.Assert.assertFalse;  
                public void onFailure(Exception exception) {
            int index = 0;
    private static List<Node> randomNodes() {
        }  
                () -> restClient.streamRequest(new StreamingRequest<>("unsupported", randomAsciiLettersOfLength(5), Mono.empty()))
        Map<HttpHost, DeadHostState> denylist,
            /*  
            /*
        {
                + "[host=http://3, version=3]] and dead []";  
    public void testPerformAsyncWithWrongEndpoint() throws Exception {  
        }
            URI uri = RestClient.buildUri("/foo$bar", "/index/type/id", emptyMap);
             * denylist timeouts then we function as though the nodes aren't
            nodes.add(node);
                        itr.remove();
        verify(closeableHttpAsyncClient, times(1)).close();  
            denylist.put(n1.getHost(), new DeadHostState(timeSupplier));  
import java.util.concurrent.atomic.AtomicInteger;  
import java.util.ArrayList;  
            time.set(new DeadHostState(timeSupplier).getDeadUntilNanos());  
            assertEquals(1, restClient.getNodes().size());
        /*
    public void testSelectHosts() throws IOException {
            public void select(Iterable<Node> nodes) {
            public String toString() {
             */
}
 * software distributed under the License is distributed on an
                return "NONE";
/*
        }
            RestClient.selectNodes(nodeTuple, denylist, new AtomicInteger(0), nodeSelector);
        int numNodes = randomIntBetween(1, 10);  
         * Collections.rotate is not super intuitive: distance 1 means that the last element will become the first and so on,
    public void testStreamWithUnsupportedMethod() throws Exception {  
        int iterations = 1000;
        }
import static java.util.Collections.singletonList;  
             * If we wind the clock way into the future, past any of the
import org.opensearch.client.RestClient.NodeTuple;
             * selectHosts will revive a single host regardless of
                Node expectedNode = expectedNodes.get((index + expectedOffset) % expectedNodes.size());  
            restClient.performRequestAsync(new Request("unsupported", randomAsciiLettersOfLength(5)), new ResponseListener() {
            Supplier<Long> timeSupplier = time::get;
 * specific language governing permissions and limitations
            URI uri = RestClient.buildUri(null, "/*", emptyMap);
        List<Node> nodes = Collections.singletonList(new Node(new HttpHost("localhost", 9200)));  
        // test the transition from negative to positive values  
                }  
        // test the transition from MAX_VALUE to MIN_VALUE
import java.util.Arrays;
 * Modifications Copyright OpenSearch Contributors. See
         * throw an exception
            URI uri = RestClient.buildUri(null, "/index/type/id", Collections.singletonMap("foo$bar", "x/y/z"));  
            URI uri = RestClient.buildUri(null, "/foo$bar/ty/pe/i/d", emptyMap);
        // Calling it again rotates the set of results
        Node n3 = new Node(new HttpHost("3"), null, null, "3", null, null);
            assertTrue("time out waiting for request to return", latch.await(1000, TimeUnit.MILLISECONDS));
             */
            assertSelectLivingHosts(Arrays.asList(n1, n2, n3), nodeTuple, denylist, NodeSelector.ANY);  
    }  
        RestClient restClient = new RestClient(client, new Header[] {}, nodes, null, null, null, false, false);  
                    } finally {
                @Override  
     */  
    private static void assertNodes(NodeTuple<List<Node>> nodeTuple, AtomicInteger lastNodeIndex, int runs) throws IOException {
        assertFalse(restClient.isRunning());  
            restClient.setNodes(nodes);
            assertSelectLivingHosts(Arrays.asList(n2, n3), nodeTuple, denylist, not1);
    public void testIsRunning() {  
                NodeSelector.ANY
        List<Node> nodes = new ArrayList<>(numNodes);
        }
        assertEquals(-numNodes + 50, lastNodeIndex.get());  
        Map<HttpHost, DeadHostState> denylist,  
            assertEquals("/*", uri.getPath());
     * Assert that {@link RestClient#selectNodes} fails on the provided arguments.
    public void testSetNodesDuplicatedHosts() throws Exception {
        for (int i = 0; i < runs; i++) {
        {  
 * this work for additional information regarding copyright
                    }  
            Collections.rotate(expectedNodes, 1);
        assertNodes(nodeTuple, lastNodeIndex, 50);
            URI uri = RestClient.buildUri(null, "*", emptyMap);
            @Override
                    }
        AuthCache authCache = new BasicAuthCache();  
        // Mark all the nodes dead for a few test cases
                    throw new UnsupportedOperationException("onSuccess cannot be called when using a mocked http client");  
             * Try a NodeSelector that excludes all nodes. This should
        assertEquals(Integer.MIN_VALUE + 50, lastNodeIndex.get());  
import java.util.function.Supplier;
import java.util.concurrent.TimeUnit;
                public void onFailure(Exception exception) {
             */
            assertEquals(singletonList(n1), RestClient.selectNodes(nodeTuple, denylist, new AtomicInteger(), NodeSelector.ANY));  
                Collections.<HttpHost, DeadHostState>emptyMap(),
                    }
            });
        NodeTuple<List<Node>> nodeTuple = new NodeTuple<>(Arrays.asList(n1, n2, n3), null);  
        final CountDownLatch latch = new CountDownLatch(1);
                        assertThat(exception, instanceOf(UnsupportedOperationException.class));
                nodes.add(node);
    }
        {  
            assertTrue("time out waiting for request to return", latch.await(1000, TimeUnit.MILLISECONDS));
            URI uri = RestClient.buildUri("/", "/*", emptyMap);  
            }  
        NodeTuple<List<Node>> nodeTuple,
        Map<HttpHost, DeadHostState> emptyDenylist = Collections.emptyMap();
            fail("setNodes should have failed");  
        }  
            assertEquals("/index/type/id", uri.getPath());
            restClient.setNodes(null);
                for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {  
            Node node = new Node(new HttpHost("host", 9200));  
    }  
            assertEquals(message, assertSelectAllRejected(nodeTuple, emptyDenylist, noNodes));
                @Override
            URI uri = RestClient.buildUri("/", "*", emptyMap);
         * while distance -1 means that the second element will become the first and so on.
        /*  
 */
        {
            Iterable<Node> selectedNodes = RestClient.selectNodes(  
 */  
                }  
            assertSelectLivingHosts(Arrays.asList(n1), nodeTuple, denylist, NodeSelector.ANY);
    public void testCloseIsIdempotent() throws IOException {
        {
            final AtomicLong time = new AtomicLong(0L);  
                }
        // to another one that's not necessarily the next one.  
                        assertEquals("http method not supported: unsupported", exception.getMessage());
 * KIND, either express or implied.  See the License for the
                    throw new UnsupportedOperationException("onSuccess cannot be called when using a mocked http client");
        NodeSelector noNodes = new NodeSelector() {  
    }
            throw new AssertionError("expected selectHosts to fail");
             */  
        for (int i = 0; i < numNodes; i++) {
        {
            restClient.setNodes(Collections.singletonList((Node) null));
    }
            List<Node> nodes = new ArrayList<>(numNodes);
 *
             * return a failure, but a different failure than when the
            fail("setNodes should have failed");  
        }  
        assertNodes(nodeTuple, lastNodeIndex, 50);
        NodeSelector nodeSelector  
        // test the highest positive values up to MAX_VALUE
        List<Node> nodes = Collections.singletonList(new Node(new HttpHost("localhost", 9200)));
        return nodes;
            assertEquals(message, assertSelectAllRejected(nodeTuple, denylist, noNodes));  
                }
    }
                        latch.countDown();
            public void select(Iterable<Node> nodes) {
    public void testRoundRobin() throws IOException {
            List<Node> expectedNodes = nodeTuple.nodes;  
import java.util.Collections;
    ) throws IOException {
import static org.mockito.Mockito.when;  
            }
            denylist.put(n3.getHost(), new DeadHostState(new DeadHostState(new DeadHostState(timeSupplier))));
import static org.junit.Assert.assertSame;
            assertEquals("http method not supported: unsupported", ex.getMessage());  
        assertTrue(restClient.isRunning());  
        CloseableHttpAsyncClient closeableHttpAsyncClient = mock(CloseableHttpAsyncClient.class);  
            }  
            }
        {
            @Override  
import static org.mockito.Mockito.times;
            assertEquals(singletonList(n2), RestClient.selectNodes(nodeTuple, denylist, new AtomicInteger(), not1));
        }  
import java.util.List;
            restClient.setNodes(Arrays.asList(new Node(new HttpHost("localhost", 9200)), null, new Node(new HttpHost("localhost", 9201))));
                for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {  
import java.net.URI;
    }
 * SPDX-License-Identifier: Apache-2.0
        Node n1 = new Node(new HttpHost("1"), null, null, "1", null, null);
        int numNodes = randomIntBetween(2, 10);
                    try {
        }  
        verify(closeableHttpAsyncClient, times(2)).close();
        RestClient restClient = new RestClient(closeableHttpAsyncClient, new Header[0], nodes, null, null, null, false, false);
import java.util.concurrent.atomic.AtomicLong;
                        latch.countDown();  
            /*  
 * license agreements. See the NOTICE file distributed with
                assertSelectLivingHosts(Arrays.asList(n2), fewerNodeTuple, denylist, not1);
        List<Node> nodes = singletonList(new Node(new HttpHost("localhost", 9200)));
        } catch (NullPointerException e) {
         */
                }
                lastNodeIndex,  
        Node n2 = new Node(new HttpHost("2"), null, null, "2", null, null);  
         * Try a NodeSelector that excludes all nodes. This should  
        lastNodeIndex.set(Integer.MAX_VALUE - numNodes * 10);  
/*  
            denylist.put(n2.getHost(), new DeadHostState(new DeadHostState(timeSupplier)));
            });  
                return "NOT 1";  
 * this file be licensed under the Apache-2.0 license or a
            authCache.put(node.getHost(), new BasicScheme());
        NodeTuple<List<Node>> nodeTuple,
            assertEquals("foo$bar=x/y/z", uri.getQuery());
    }
             * in the denylist at all.  
package org.opensearch.client;
        try (RestClient restClient = createRestClient()) {
            return e.getMessage();
 * compatible open source license.
         */  
        }
        {  
import java.util.Map;  
    /**  
        {
            assertSelectLivingHosts(Arrays.asList(n2), nodeTuple, denylist, not1);
        for (int i = 1; i < iterations; i++) {  
import java.io.IOException;
             * first on that the NodeSelector doesn't reject.
        try (RestClient restClient = createRestClient()) {
            /*
            assertEquals("node cannot be null", e.getMessage());
            assertEquals(nodes, restClient.getNodes());
            Node node = new Node(new HttpHost("localhost", 9200 + i));  
        assertSelectLivingHosts(Arrays.asList(n2, n3), nodeTuple, emptyDenylist, not1);  
            @Override
             * denylist is empty so that the caller knows that all of  
    public void testSetNodesWrongArguments() throws IOException {  
        restClient.close();  
            fail("setNodes should have failed");  
     * @return the message in the exception thrown by the failure
        }
        }
                assertSelectLivingHosts(Arrays.asList(n1), fewerNodeTuple, denylist, NodeSelector.ANY);  
             */
    public void testPerformAsyncWithUnsupportedMethod() throws Exception {
            assertEquals("iteration " + i, expectedNodes, RestClient.selectNodes(nodeTuple, denylist, lastNodeIndex, nodeSelector));
import static org.junit.Assert.fail;
            assertEquals("/foo$bar/index/type/id", uri.getPath());  
                public void onSuccess(Response response) {  
        final CountDownLatch latch = new CountDownLatch(1);
        CloseableHttpAsyncClient client = mock(CloseableHttpAsyncClient.class);
            assertEquals(node, restClient.getNodes().get(0));  
    }
            {
            for (int i = 0; i < numNodes; i++) {
import static org.mockito.Mockito.verify;
            assertEquals("/*", uri.getPath());
        }
            assertEquals("*", uri.getPath());
            URI uri = RestClient.buildUri("", "*", emptyMap);  
        }
        List<Node> nodes = new ArrayList<>(numNodes);
import java.util.Iterator;
import org.apache.hc.core5.http.Header;
 *
                + "[host=http://1, version=1], [host=http://2, version=2], "
        }
import org.apache.hc.client5.http.impl.auth.BasicScheme;
             * But if the NodeSelector rejects that node then we'll pick the
        // this is the only time where there is most likely going to be a jump from a node
                expectedOffset += nodeTuple.nodes.size();  
        };
        AtomicInteger lastNodeIndex = new AtomicInteger(0);  
            restClient.performRequestAsync(new Request("GET", "::http:///"), new ResponseListener() {  
             * to being revived that the NodeSelector is ok with.
            }
             * their nodes are denylisted AND blocked.
                public void onSuccess(Response response) {
            String message = "NodeSelector [NONE] rejected all nodes, living ["
    public void testSetNodesPreservesOrdering() throws Exception {  
        try (RestClient restClient = createRestClient()) {  
                NodeTuple<List<Node>> fewerNodeTuple = new NodeTuple<>(Arrays.asList(n1, n2), null);
        restClient.close();
        };
        assertEquals(Integer.MIN_VALUE, lastNodeIndex.incrementAndGet());
        restClient.close();
import java.util.concurrent.CountDownLatch;
                    itr.remove();
            /*
import static org.mockito.Mockito.mock;  
            );
            fail("setNodes should have failed");  
        }
        for (int i = 0; i < numNodes; i++) {
            Map<HttpHost, DeadHostState> denylist = new HashMap<>();
        }  
        return new RestClient(mock(CloseableHttpAsyncClient.class), new Header[] {}, nodes, null, null, null, false, false);
 *  
                        assertEquals("Expected scheme name at index 0: ::http:///", exception.getMessage());
                + "[host=http://3, version=3]]";
                UnsupportedOperationException.class,  
        } catch (IOException e) {  
    private void assertSelectLivingHosts(
public class RestClientTests extends RestClientTestCase {
 * ownership. Elasticsearch licenses this file to you under  
                        assertThat(exception, instanceOf(IllegalArgumentException.class));  
                    } finally {  
 * not use this file except in compliance with the License.
             * the dead nodes. We should return it.
import org.apache.hc.core5.reactor.IOReactorStatus;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
        {
    private static String assertSelectAllRejected(
        NodeSelector not1 = new NodeSelector() {  
            String message = "NodeSelector [NONE] rejected all nodes, living [] and dead ["  
            for (Node actualNode : selectedNodes) {
import org.apache.hc.core5.http.HttpHost;  
        NodeTuple<List<Node>> nodeTuple = new NodeTuple<>(nodes, authCache);
