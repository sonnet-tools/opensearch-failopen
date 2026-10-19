                return "/soe";
import java.util.ArrayList;
                        assertThat(response.host(), equalTo(selectedHost));
             */
        for (int i = 0; i < rounds; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
import static org.junit.Assert.fail;
                Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
            do {
        failureListener.assertNotCalled();
                } else {
                    assertEquals(0, e.getSuppressed().length);
import java.util.concurrent.ExecutorService;
                        assertEquals(404, response.statusLine().statusCode());
            for (int j = 0; j < nodes.size(); j++) {
 * not use this file except in compliance with the License.
        }
import static org.hamcrest.CoreMatchers.instanceOf;
                        Response response = e.getResponse();
                    assertThat(suppressed, instanceOf(ResponseException.class));
                }
        return hosts;
     * Shutdown the executor so we don't leak threads into other test runs.
                        Request.newRequest(method, "/" + statusCode).build()
                // selected to be retried earlier (due to lower number of failures) till all the hosts have the same number of failures
import java.util.concurrent.Executors;
                );
        HttpClient httpClient = RestHttpClientSingleHostTests.mockHttpClient(exec);
        for (int i = 0; i < numIters; i++) {
                for (int y = 0; y < iters; y++) {
                retryEndpoint = randomErrorRetryEndpoint();
    }
                    );
                    assertEquals(statusCode, response.statusLine().statusCode());
 * compatible open source license.
    }
            Set<HttpHost> hostsSet = hostsSet();
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
            for (int j = 0; j < nodes.size(); j++) {
                    e = (ResponseException) suppressed;
            }
                    Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
                    Response response;
            nodes.add(new Node(new HttpHost("http", "localhost", 9200 + i)));
        };
    }
            /*
                    } catch (ResponseException e) {
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomErrorRetryStatusCode;
                    assertEquals(0, e.getSuppressed().length);
                }
                    Throwable suppressed = e.getSuppressed()[0];
    }
                    Response response = e.getResponse();
    }
            assertTrue(found);
                    try {
        restClient.setNodes(newNodes);
        }
                        failureListener.assertCalled(selectedHost);
        List<Node> newNodes = new ArrayList<>(nodes.size());
            Request request = Request.newRequest("GET", "/200").build();
            assertEquals(newNodes.get(0).getHost(), response.host());
                        // no exception gets thrown although we got a 404
                        fail("request should have failed");
        throw new UnsupportedOperationException();
import java.util.HashSet;
                        failureListener.assertCalled(selectedHost);
                int statusCode = randomErrorNoRetryStatusCode(getRandom());
            Set<HttpHost> hostsSet = hostsSet();
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
import static org.junit.Assert.assertTrue;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    Request.newRequest(randomHttpMethod(getRandom()), "/" + statusCode).build()
    private List<Node> nodes;
        for (int i = 1; i <= numIters; i++) {
 * software distributed under the License is distributed on an
public class RestHttpClientMultipleHostsTests extends RestHttpClientTestCase {
                    if (method.equals("HEAD") && statusCode == 404) {
                    e = null;
                assertEquals(statusCode, response.statusLine().statusCode());
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
import static org.hamcrest.CoreMatchers.equalTo;
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
                }
                            restClient,
        RestHttpClient restClient = createRestClient(NodeSelector.ANY);
                        selectedHost = response.host();
                // let the selected host catch up on number of failures, it gets selected a consecutive number of times as it's the one
/*
                } else {
            Set<HttpHost> hostsSet = hostsSet();
 * this work for additional information regarding copyright
                assertTrue("host [" + response.host() + "] not found, most likely used multiple times", hostsSet.remove(response.host()));
            hosts.add(node.getHost());
 * SPDX-License-Identifier: Apache-2.0
import org.junit.After;
                        assertThat(response.statusLine().statusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
/*
        switch (RandomNumbers.randomIntBetween(getRandom(), 0, 3)) {
        Set<HttpHost> hosts = new HashSet<>();
    public void testNodeSelector() throws Exception {
                int iters = RandomNumbers.randomIntBetween(getRandom(), 2, 10);
                HttpHost httpHost = HttpHost.create(e.getMessage());
                return "/ioe";
                        throw e;
                    );
    public RestHttpClient createRestClient(NodeSelector nodeSelector) {
                    assertTrue(
import java.util.List;
        exec.shutdown();
            for (int j = 0; j < nodes.size(); j++) {
    public void shutdownExec() {
 */
                        response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(
             * NodeSelector overrides the round robin behavior.
    }
                    try {
import java.util.Map;
                        RestHttpClientSingleHostTests.performRequestSyncOrAsync(
                }
            Set<HttpHost> hostsSet = hostsSet();
        }
 *
                    assertEquals(1, e.getSuppressed().length);
    }
            Request request = Request.newRequest("GET", "/200").build();
        }
                int statusCode = randomOkStatusCode(getRandom());
     */
 * ownership. Elasticsearch licenses this file to you under
                for (int y = 0; y < i + 1; y++) {
import static org.junit.Assert.assertThat;
                    );
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
            Set<HttpHost> hostsSet = hostsSet();
 * license agreements. See the NOTICE file distributed with
                    if (selectedHost == null) {
                ? new Node.Roles(new TreeSet<>(Arrays.asList("data", "ingest")))
            case 0:
            fail("request should have failed");
                        response = e.getResponse();
                            restClient,
                    if (method.equals("HEAD") && statusCode == 404) {
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time
                    assertThat(response.statusLine().statusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
                    assertThat(response.statusLine().statusCode(), equalTo(statusCode));
            }
            // check that one different host is resurrected at each new attempt
                    }
 * Unless required by applicable law or agreed to in writing,
                assertEquals(Integer.parseInt(retryEndpoint.substring(1)), response.statusLine().statusCode());
            /*
                return "/" + randomErrorRetryStatusCode(getRandom());
        }
    /**
        } catch (IOException e) {
    @After
    public void testRoundRobinRetryErrors() throws Exception {
                    } catch (ResponseException e) {
                } else {
                return "/coe";
 */
        int rounds = between(1, 10);
        for (int i = 0; i < numIters; i++) {
                Response response = e.getResponse();
            }
 * under the License.
            newNodes.add(new Node(nodes.get(i).getHost(), null, null, null, roles, null));
import java.util.TreeSet;
                        restClient,
                        fail("request should have failed");
import java.util.Set;
                    itr.remove();
        for (int i = 0; i < rounds; i++) {
            assertEquals(nodes.get(0).getHost(), response.host());
        }
     * in use by the test.
                        HttpHost httpHost = HttpHost.create(e.getMessage());
        NodeSelector firstPositionOnly = restClientNodes -> {
/*
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
 * Modifications Copyright OpenSearch Contributors. See
                    } catch (IOException e) {
 */
import static org.junit.Assert.assertEquals;
            );
            }
    public void testSetNodes() throws Exception {
    }
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
        for (int i = 0; i < numNodes; i++) {
                }
                assertTrue("host not found: " + response.host(), hostsSet.remove(response.host()));
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each
        }
                        Request.newRequest(randomHttpMethod(getRandom()), retryEndpoint).build()
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 2, 5);
             * Run the request more than once to verify that the
            case 2:
            boolean found = false;
            RestHttpClientSingleHostTests.performRequestSyncOrAsync(
        failureListener = new HostsTrackingFailureListener();
                Request.newRequest(randomHttpMethod(getRandom()), retryEndpoint).build()
                if (e.getSuppressed().length > 0) {
                    Throwable suppressed = e.getSuppressed()[0];
            case 3:
            }
                }
             */
import java.util.Collections;
 * specific language governing permissions and limitations
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 2, 5);
}
                    HttpHost httpHost = HttpHost.create(e.getMessage());
                assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
            failureListener.assertCalled(nodes);
                        hostsSet.remove(response.host())
import java.net.http.HttpClient;
        RestHttpClient restClient = createRestClient(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
                        assertThat(httpHost, equalTo(selectedHost));
    /**
                    assertTrue("host not found: " + response.host(), hostsSet.remove(response.host()));
                        assertThat(response.host(), equalTo(selectedHost));
        String retryEndpoint = randomErrorRetryEndpoint();
                    fail("request should have failed");
            case 1:
                    } else {
                try {
import java.util.Arrays;
                    assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
             * Run the request more than once to verify that the
                            Request.newRequest(randomHttpMethod(getRandom()), retryEndpoint).build()
                    assertEquals(1, e.getSuppressed().length);
            } while (e != null);
 *
                failureListener.assertNotCalled();
                }
 */
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
                    }
    }
                        assertEquals(statusCode, response.statusLine().statusCode());
                } catch (ResponseException e) {
        for (Node node : nodes) {
                try {
                    failureListener.assertCalled(response.host());
                        );
        RestHttpClient restClient = createRestClient(firstPositionOnly);
                    assertEquals(0, e.getSuppressed().length);
                    failureListener.assertCalled(httpHost);
 * You may obtain a copy of the License at
                    RestHttpClientSingleHostTests.performRequestSyncOrAsync(
    private static String randomErrorRetryEndpoint() {
                    e = null;
/**
                : new Node.Roles(new TreeSet<>(Arrays.asList("master")));
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomOkStatusCode;
                } catch (ResponseException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                restClient,
        RestHttpClient restClient = createRestClient(NodeSelector.ANY);
                    } else {
                    int statusCode = randomErrorNoRetryStatusCode(getRandom());
 * The OpenSearch Contributors require contributions made to
     */
            Response response = RestHttpClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        failureListener.assertNotCalled();
        try {
 * KIND, either express or implied.  See the License for the
                    restClient,
                            Request.newRequest(randomHttpMethod(getRandom()), "/" + statusCode).build()
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomErrorNoRetryStatusCode;
import static org.opensearch.internal.httpclient.RestClientTestUtil.randomHttpMethod;
                } catch (IOException e) {
                if (e.getSuppressed().length > 0) {
        for (int i = 0; i < nodes.size(); i++) {
                    assertThat(suppressed, instanceOf(IOException.class));
                        assertTrue("host not found: " + response.host(), hostsSet.remove(response.host()));
                        "host [" + response.host() + "] not found, most likely used multiple times",
     * Build a mutable {@link Set} containing all the {@link Node#getHost() hosts}
        nodes = Collections.unmodifiableList(nodes);
                HttpHost selectedHost = null;
        }
package org.opensearch.internal.httpclient;
                // mark one host back alive through a successful request and check that all requests after that are sent to it
        nodes = new ArrayList<>(numNodes);
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time
                String method = randomHttpMethod(getRandom());
 * Tests for {@link RestHttpClient} behaviour against multiple hosts: fail-over, denylisting etc.
    private Set<HttpHost> hostsSet() {
 * GitHub history for details.
        RestHttpClient restClient = createRestClient(NodeSelector.ANY);
                        );
 * Licensed to Elasticsearch under one or more contributor
        }
        return new RestHttpClient(httpClient, Map.of(), nodes, null, failureListener, nodeSelector, false, false);
 * Relies on a mock http client to intercept requests and return desired responses based on request path.
                    }
        int rounds = between(1, 10);
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each
             * NodeSelector overrides the round robin behavior.
    public void testRoundRobinNoRetryErrors() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                        restClient,
    private ExecutorService exec = Executors.newFixedThreadPool(1);
    private HostsTrackingFailureListener failureListener;
                    found = true;
import java.util.Iterator;
            if (getRandom().nextBoolean()) {
import java.io.IOException;
                    }
                    e = (IOException) suppressed;
                if (nodes.get(0) == itr.next()) {
                    retryEndpoint = randomErrorRetryEndpoint();
        }
            do {
            for (Iterator<Node> itr = restClientNodes.iterator(); itr.hasNext();) {
    public void testRoundRobinOkStatusCodes() throws Exception {
        } catch (ResponseException e) {
            Node.Roles roles = i == 0
            failureListener.assertCalled(nodes);
 *
                    Response response = e.getResponse();
            } while (e != null);
                    }
