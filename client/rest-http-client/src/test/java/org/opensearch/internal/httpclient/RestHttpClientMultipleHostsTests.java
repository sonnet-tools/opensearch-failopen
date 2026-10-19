            case 3:
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);  
            nodes.add(new Node(new HttpHost("http", "localhost", 9200 + i)));  
                    assertEquals(1, e.getSuppressed().length);  
import java.util.concurrent.ExecutorService;
            }
 * Licensed to Elasticsearch under one or more contributor  
    }
                    }
                        assertEquals(404, response.statusLine().statusCode());
                    );
    }
                );
                String method = randomHttpMethod(getRandom());
        String retryEndpoint = randomErrorRetryEndpoint();  
                        response = e.getResponse();
 *  
import java.util.concurrent.Executors;
        for (Node node : nodes) {
                    e = null;
        try {
            do {
                if (e.getSuppressed().length > 0) {  
                }  
        for (int i = 0; i < numNodes; i++) {
                    assertEquals(statusCode, response.statusLine().statusCode());  
                    Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
                    assertTrue("host not found: " + response.host(), hostsSet.remove(response.host()));
}  
                    assertThat(response.statusLine().statusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
        RestHttpClient restClient = createRestClient(firstPositionOnly);  
            Set<HttpHost> hostsSet = hostsSet();
 *
        }
             * NodeSelector overrides the round robin behavior.  
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomErrorRetryStatusCode;
        switch (RandomNumbers.randomIntBetween(getRandom(), 0, 3)) {  
import java.net.http.HttpClient;  
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
     */  
                    failureListener.assertCalled(response.host());
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.CoreMatchers.equalTo;
                    Response response;  
                    assertEquals(0, e.getSuppressed().length);
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time  
                    if (method.equals("HEAD") && statusCode == 404) {
                return "/" + randomErrorRetryStatusCode(getRandom());
                            restClient,
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each  
                }  
                        );
                    Throwable suppressed = e.getSuppressed()[0];
        }  
 * You may obtain a copy of the License at  
    }
import java.util.TreeSet;  
     * Build a mutable {@link Set} containing all the {@link Node#getHost() hosts}
                assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
                    itr.remove();
        for (int i = 0; i < rounds; i++) {  
    public void testRoundRobinOkStatusCodes() throws Exception {  
            for (int j = 0; j < nodes.size(); j++) {  
import java.util.Collections;  
                        assertThat(response.host(), equalTo(selectedHost));  
            for (int j = 0; j < nodes.size(); j++) {  
                    assertThat(suppressed, instanceOf(IOException.class));
                        // no exception gets thrown although we got a 404  
                    }  
    private static String randomErrorRetryEndpoint() {
        for (int i = 0; i < numIters; i++) {  
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());  
                if (e.getSuppressed().length > 0) {
             */  
                assertEquals(Integer.parseInt(retryEndpoint.substring(1)), response.statusLine().statusCode());
        int rounds = between(1, 10);
            Set<HttpHost> hostsSet = hostsSet();
 * specific language governing permissions and limitations
             */
            /*
 * Relies on a mock http client to intercept requests and return desired responses based on request path.
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);  
                    try {  
                    e = (IOException) suppressed;  
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
                        );
                assertEquals(statusCode, response.statusLine().statusCode());
            for (int j = 0; j < nodes.size(); j++) {
                for (int y = 0; y < iters; y++) {
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
            newNodes.add(new Node(nodes.get(i).getHost(), null, null, null, roles, null));
 * Unless required by applicable law or agreed to in writing,
                    Response response = e.getResponse();
                // selected to be retried earlier (due to lower number of failures) till all the hosts have the same number of failures  
                // mark one host back alive through a successful request and check that all requests after that are sent to it
 */
                assertTrue("host [" + response.host() + "] not found, most likely used multiple times", hostsSet.remove(response.host()));
        exec.shutdown();  
                try {  
                    Throwable suppressed = e.getSuppressed()[0];
                    assertEquals(0, e.getSuppressed().length);
                    e = (ResponseException) suppressed;
            }
import java.util.Set;
                        selectedHost = response.host();
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 2, 5);  
            }
                int statusCode = randomOkStatusCode(getRandom());  
        for (int i = 0; i < numIters; i++) {
    }
                    }
                    } catch (IOException e) {
    private Set<HttpHost> hostsSet() {
    public RestHttpClient createRestClient(NodeSelector nodeSelector) {
    private List<Node> nodes;
                Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
    public void testRoundRobinNoRetryErrors() throws Exception {
                            Request.newRequest(randomHttpMethod(getRandom()), "/" + statusCode).build()
                    }  
                        assertThat(response.host(), equalTo(selectedHost));
    }
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomHttpMethod;  
import java.util.HashSet;
                int statusCode = randomErrorNoRetryStatusCode(getRandom());
        throw new UnsupportedOperationException();
        failureListener = new HostsTrackingFailureListener();  
 *
        failureListener.assertNotCalled();
                    if (selectedHost == null) {
package org.opensearch.internal.httpclient;
                        Request.newRequest(randomHttpMethod(getRandom()), retryEndpoint).build()
                    assertThat(suppressed, instanceOf(ResponseException.class));  
                    RestHttpClientSingleHostTests.performRequestSyncOrAsync(  
                    } catch (ResponseException e) {  
    }
        } catch (ResponseException e) {
                    e = null;  
import java.util.Map;
            case 1:  
                }  
                assertTrue("host not found: " + response.host(), hostsSet.remove(response.host()));  
 * not use this file except in compliance with the License.
 */  
import java.util.Arrays;
    @After
                } else {
                    Request.newRequest(randomHttpMethod(getRandom()), "/" + statusCode).build()  
            Set<HttpHost> hostsSet = hostsSet();
                    );  
import static org.junit.Assert.fail;
        };
        for (int i = 1; i <= numIters; i++) {  
     * Shutdown the executor so we don't leak threads into other test runs.
            for (Iterator<Node> itr = restClientNodes.iterator(); itr.hasNext();) {  
            fail("request should have failed");  
            failureListener.assertCalled(nodes);
        nodes = Collections.unmodifiableList(nodes);
                    );
            Set<HttpHost> hostsSet = hostsSet();
                        assertThat(httpHost, equalTo(selectedHost));
                            Request.newRequest(randomHttpMethod(getRandom()), retryEndpoint).build()  
                ? new Node.Roles(new TreeSet<>(Arrays.asList("data", "ingest")))  
                    if (method.equals("HEAD") && statusCode == 404) {
                        HttpHost httpHost = HttpHost.create(e.getMessage());  
            /*  
import static org.hamcrest.CoreMatchers.instanceOf;  
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
                    Response response = e.getResponse();  
            assertEquals(newNodes.get(0).getHost(), response.host());
                        throw e;  
                    int statusCode = randomErrorNoRetryStatusCode(getRandom());
                    assertTrue(
        List<Node> newNodes = new ArrayList<>(nodes.size());  
     * in use by the test.  
                    }
                failureListener.assertNotCalled();
import static org.junit.Assert.assertEquals;
                } else {
                    assertEquals(0, e.getSuppressed().length);
            assertEquals(nodes.get(0).getHost(), response.host());  
                restClient,  
                // let the selected host catch up on number of failures, it gets selected a consecutive number of times as it's the one
            Set<HttpHost> hostsSet = hostsSet();
        HttpClient httpClient = RestHttpClientSingleHostTests.mockHttpClient(exec);
import java.util.Iterator;
        RestHttpClient restClient = createRestClient(NodeSelector.ANY);
public class RestHttpClientMultipleHostsTests extends RestHttpClientTestCase {
        }  
 * Tests for {@link RestHttpClient} behaviour against multiple hosts: fail-over, denylisting etc.
                    retryEndpoint = randomErrorRetryEndpoint();
            do {
 * The OpenSearch Contributors require contributions made to  
 */  
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
        int rounds = between(1, 10);
                        restClient,
            // check that one different host is resurrected at each new attempt
            );
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    try {
 * this work for additional information regarding copyright
                } catch (ResponseException e) {
                        assertEquals(statusCode, response.statusLine().statusCode());
    }
 * SPDX-License-Identifier: Apache-2.0
                        assertThat(response.statusLine().statusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
                return "/ioe";
 * GitHub history for details.
                HttpHost selectedHost = null;
                }
            Request request = Request.newRequest("GET", "/200").build();
/**  
             * NodeSelector overrides the round robin behavior.
            hosts.add(node.getHost());
            case 0:
                }  
        } catch (IOException e) {
                    } else {  
    private ExecutorService exec = Executors.newFixedThreadPool(1);  
 */  
            RestHttpClientSingleHostTests.performRequestSyncOrAsync(
 * this file be licensed under the Apache-2.0 license or a
                }
     */
        return hosts;
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomErrorNoRetryStatusCode;
        RestHttpClient restClient = createRestClient(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
                        failureListener.assertCalled(selectedHost);
        restClient.setNodes(newNodes);
 * under the License.  
import org.junit.After;  
        nodes = new ArrayList<>(numNodes);
        }
                    } else {
                        "host [" + response.host() + "] not found, most likely used multiple times",  
import java.util.List;  
        }  
                        fail("request should have failed");
        failureListener.assertNotCalled();
                    assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 2, 5);
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
        RestHttpClient restClient = createRestClient(NodeSelector.ANY);
             * Run the request more than once to verify that the
        Set<HttpHost> hosts = new HashSet<>();  
                try {
            Request request = Request.newRequest("GET", "/200").build();
                        response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
 * software distributed under the License is distributed on an
                    failureListener.assertCalled(httpHost);
        for (int i = 0; i < nodes.size(); i++) {
/*
            if (getRandom().nextBoolean()) {  
                        hostsSet.remove(response.host())
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time  
        }  
import static org.junit.Assert.assertThat;
                    found = true;
                        restClient,
                retryEndpoint = randomErrorRetryEndpoint();
    public void testSetNodes() throws Exception {
                    HttpHost httpHost = HttpHost.create(e.getMessage());
                }
                for (int y = 0; y < i + 1; y++) {
 * KIND, either express or implied.  See the License for the
            } while (e != null);
 *    http://www.apache.org/licenses/LICENSE-2.0
                        Response response = e.getResponse();
    private HostsTrackingFailureListener failureListener;
            Node.Roles roles = i == 0
                        failureListener.assertCalled(selectedHost);
                Response response = e.getResponse();  
            }
    public void testRoundRobinRetryErrors() throws Exception {
        RestHttpClient restClient = createRestClient(NodeSelector.ANY);
                : new Node.Roles(new TreeSet<>(Arrays.asList("master")));
            failureListener.assertCalled(nodes);
            case 2:
    }
import java.util.ArrayList;
    }  
            } while (e != null);
                } catch (ResponseException e) {
        }  
        NodeSelector firstPositionOnly = restClientNodes -> {
             * Run the request more than once to verify that the
                        RestHttpClientSingleHostTests.performRequestSyncOrAsync(
            boolean found = false;
                    restClient,
                        fail("request should have failed");
    public void testNodeSelector() throws Exception {  
            }  
        return new RestHttpClient(httpClient, Map.of(), nodes, null, failureListener, nodeSelector, false, false);
        }  
                    fail("request should have failed");
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomOkStatusCode;
                } else {  
                    } catch (ResponseException e) {  
                if (nodes.get(0) == itr.next()) {
                } catch (IOException e) {  
                HttpHost httpHost = HttpHost.create(e.getMessage());  
    /**
                        assertTrue("host not found: " + response.host(), hostsSet.remove(response.host()));  
                    assertEquals(1, e.getSuppressed().length);
                        Request.newRequest(method, "/" + statusCode).build()  
import java.io.IOException;
                    assertThat(response.statusLine().statusCode(), equalTo(statusCode));  
 * Modifications Copyright OpenSearch Contributors. See
                int iters = RandomNumbers.randomIntBetween(getRandom(), 2, 10);  
    public void shutdownExec() {
                Request.newRequest(randomHttpMethod(getRandom()), retryEndpoint).build()
                return "/soe";  
        }  
 * license agreements. See the NOTICE file distributed with
        }
                            restClient,  
    /**
        for (int i = 0; i < rounds; i++) {
/*  
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
            assertTrue(found);
import static org.junit.Assert.assertTrue;  
                return "/coe";
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each  
