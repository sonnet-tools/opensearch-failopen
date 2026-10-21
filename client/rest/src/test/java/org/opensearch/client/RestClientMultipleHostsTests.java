                        selectedHost = response.getHost();
                for (int y = 0; y < i + 1; y++) {
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
                    assertThat(suppressed, instanceOf(IOException.class));
                    Throwable suppressed = e.getSuppressed()[0];
                } catch (ResponseException e) {
        nodes = Collections.unmodifiableList(nodes);
                    } catch (ResponseException e) {
            case 0:
        }
        RestClient restClient = createRestClient(NodeSelector.ANY);
import static org.opensearch.client.RestClientTestUtil.randomErrorNoRetryStatusCode;
                    );
            /*
                    assertTrue("host not found: " + response.getHost(), hostsSet.remove(response.getHost()));
 *
                    int statusCode = randomErrorNoRetryStatusCode(getRandom());
                    try {
                Response response = RestClientSingleHostTests.performRequestSyncOrAsync(
        }
                    if (method.equals("HEAD") && statusCode == 404) {
                assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
                int iters = RandomNumbers.randomIntBetween(getRandom(), 2, 10);
                        response = RestClientSingleHostTests.performRequestSyncOrAsync(
    }
                    assertEquals(0, e.getSuppressed().length);
                : new Node.Roles(new TreeSet<>(Arrays.asList("master")));
            Request request = new Request("GET", "/200");
    private HostsTrackingFailureListener failureListener;
 * The OpenSearch Contributors require contributions made to
        for (int i = 1; i <= numIters; i++) {
                    "host [" + response.getHost() + "] not found, most likely used multiple times",
             */
                        // no exception gets thrown although we got a 404
}
            // check that one different host is resurrected at each new attempt
                    Response response = RestClientSingleHostTests.performRequestSyncOrAsync(
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time
                } else {
                        "host [" + response.getHost() + "] not found, most likely used multiple times",
                    } else {
        failureListener.assertNotCalled();
import java.util.concurrent.ExecutorService;
        for (int i = 0; i < rounds; i++) {
                    itr.remove();
    public void shutdownExec() {
    public void testSetNodes() throws Exception {
    }
                // mark one host back alive through a successful request and check that all requests after that are sent to it
 * license agreements. See the NOTICE file distributed with
        RestClient restClient = createRestClient(NodeSelector.ANY);
 *    http://www.apache.org/licenses/LICENSE-2.0
                return "/ioe";
        int rounds = between(1, 10);
/**
import java.util.Iterator;
                        hostsSet.remove(response.getHost())
                HttpHost httpHost = HttpHost.create(e.getMessage());
                return "/" + randomErrorRetryStatusCode(getRandom());
                        );
 * KIND, either express or implied.  See the License for the
        for (Node node : nodes) {
                    Response response = e.getResponse();
import java.util.TreeSet;
                assertEquals(Integer.parseInt(retryEndpoint.substring(1)), response.getStatusLine().getStatusCode());
    public void testNodeSelector() throws Exception {
 * software distributed under the License is distributed on an
        RestClient restClient = createRestClient(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
            failureListener.assertCalled(nodes);
                String method = randomHttpMethod(getRandom());
 * the Apache License, Version 2.0 (the "License"); you may
    @After
                    failureListener.assertCalled(httpHost);
        try {
                        assertEquals(404, response.getStatusLine().getStatusCode());
                            restClient,
public class RestClientMultipleHostsTests extends RestClientTestCase {
            hosts.add(node.getHost());
                        assertThat(httpHost, equalTo(selectedHost));
import static org.opensearch.client.RestClientTestUtil.randomErrorRetryStatusCode;
        }
            for (int j = 0; j < nodes.size(); j++) {
        };
 * specific language governing permissions and limitations
            }
                }
                        assertTrue("host not found: " + response.getHost(), hostsSet.remove(response.getHost()));
                    found = true;
            do {
    private ExecutorService exec = Executors.newFixedThreadPool(1);
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
                        failureListener.assertCalled(selectedHost);
                    retryEndpoint = randomErrorRetryEndpoint();
import static org.opensearch.client.RestClientTestUtil.randomOkStatusCode;
                } else {
                    }
    /**
            Set<HttpHost> hostsSet = hostsSet();
                    assertEquals(1, e.getSuppressed().length);
            for (Iterator<Node> itr = restClientNodes.iterator(); itr.hasNext();) {
    }
                retryEndpoint = randomErrorRetryEndpoint();
            }
 */
                assertTrue("host not found: " + response.getHost(), hostsSet.remove(response.getHost()));
            Request request = new Request("GET", "/200");
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
                if (nodes.get(0) == itr.next()) {
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
     * Build a mutable {@link Set} containing all the {@link Node#getHost() hosts}
                    }
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
        }
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each
                // let the selected host catch up on number of failures, it gets selected a consecutive number of times as it's the one
import java.util.List;
                Response response = e.getResponse();
                    assertEquals(statusCode, response.getStatusLine().getStatusCode());
import static org.junit.Assert.assertEquals;
                } catch (IOException e) {
package org.opensearch.client;
                        HttpHost httpHost = HttpHost.create(e.getMessage());
                        response = e.getResponse();
    public void testRoundRobinRetryErrors() throws Exception {
        switch (RandomNumbers.randomIntBetween(getRandom(), 0, 3)) {
import static org.hamcrest.CoreMatchers.equalTo;
                        failureListener.assertCalled(selectedHost);
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
    private List<Node> nodes;
            Set<HttpHost> hostsSet = hostsSet();
            case 2:
             * NodeSelector overrides the round robin behavior.
        }
                try {
            if (getRandom().nextBoolean()) {
 */
            case 1:
     * in use by the test.
                } else {
                    } catch (ResponseException e) {
            assertTrue(found);
 *
                    e = (IOException) suppressed;
                    }
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
/*
import java.util.concurrent.Executors;
                        throw e;
        }
                            restClient,
            Node.Roles roles = i == 0
                // selected to be retried earlier (due to lower number of failures) till all the hosts have the same number of failures
        for (int i = 0; i < nodes.size(); i++) {
            fail("request should have failed");
    /**
            RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request(randomHttpMethod(getRandom()), retryEndpoint));
 * GitHub history for details.
                        assertThat(response.getStatusLine().getStatusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
                }
                    hostsSet.remove(response.getHost())
    }
                    fail("request should have failed");
        }
                return "/coe";
     */
                );
                    } else {
                    assertTrue(
            case 3:
 * SPDX-License-Identifier: Apache-2.0
                    if (selectedHost == null) {
        CloseableHttpAsyncClient httpClient = RestClientSingleHostTests.mockHttpClient(exec);
            do {
             * NodeSelector overrides the round robin behavior.
                int statusCode = randomOkStatusCode(getRandom());
    public void testRoundRobinNoRetryErrors() throws Exception {
                            new Request(randomHttpMethod(getRandom()), "/" + statusCode)
import org.apache.hc.core5.http.HttpHost;
    }
        }
import static org.hamcrest.CoreMatchers.instanceOf;
            nodes.add(new Node(new HttpHost("localhost", 9200 + i)));
 */
                assertEquals(statusCode, response.getStatusLine().getStatusCode());
 * not use this file except in compliance with the License.
             */
 * Relies on a mock http client to intercept requests and return desired responses based on request path.
            } while (e != null);
import java.util.Collections;
 * compatible open source license.
                HttpHost selectedHost = null;
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
        failureListener = new HostsTrackingFailureListener();
        nodes = new ArrayList<>(numNodes);
                        assertThat(response.getHost(), equalTo(selectedHost));
        restClient.setNodes(newNodes);
            }
        for (int i = 0; i < numNodes; i++) {
                    );
                    Throwable suppressed = e.getSuppressed()[0];
                    }
 * Unless required by applicable law or agreed to in writing,
     * Shutdown the executor so we don't leak threads into other test runs.
                }
                        RestClientSingleHostTests.performRequestSyncOrAsync(
        String retryEndpoint = randomErrorRetryEndpoint();
/*
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each
    public RestClient createRestClient(NodeSelector nodeSelector) {
                assertTrue(
                }
        }
 * this work for additional information regarding copyright
 * Tests for {@link RestClient} behaviour against multiple hosts: fail-over, denylisting etc.
/*
                }
             * Run the request more than once to verify that the
            Set<HttpHost> hostsSet = hostsSet();
import static org.junit.Assert.fail;
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                    try {
            }
                    e = null;
 * ownership. Elasticsearch licenses this file to you under
            } while (e != null);
        RestClient restClient = createRestClient(firstPositionOnly);
            newNodes.add(new Node(nodes.get(i).getHost(), null, null, null, roles, null));
                    HttpHost httpHost = HttpHost.create(e.getMessage());
                    RestClientSingleHostTests.performRequestSyncOrAsync(
        return hosts;
        int rounds = between(1, 10);
                    restClient,
                    e = null;
import java.util.Arrays;
                ? new Node.Roles(new TreeSet<>(Arrays.asList("data", "ingest")))
                for (int y = 0; y < iters; y++) {
import static org.opensearch.client.RestClientTestUtil.randomHttpMethod;
 *
                    assertEquals(1, e.getSuppressed().length);
                        fail("request should have failed");
            }
        for (int i = 0; i < numIters; i++) {
                    assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
                        new Request(method, "/" + statusCode)
                }
    private static String randomErrorRetryEndpoint() {
            boolean found = false;
            for (int j = 0; j < nodes.size(); j++) {
            assertEquals(nodes.get(0).getHost(), response.getHost());
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(statusCode));
        Set<HttpHost> hosts = new HashSet<>();
    }
                if (e.getSuppressed().length > 0) {
                    e = (ResponseException) suppressed;
            Set<HttpHost> hostsSet = hostsSet();
                    assertThat(suppressed, instanceOf(ResponseException.class));
 */
        return new RestClient(httpClient, new Header[0], nodes, null, failureListener, nodeSelector, false, false);
                    assertEquals(0, e.getSuppressed().length);
    }
                        restClient,
                            new Request(randomHttpMethod(getRandom()), retryEndpoint)
                    new Request(randomHttpMethod(getRandom()), "/" + statusCode)
            Set<HttpHost> hostsSet = hostsSet();
import org.apache.hc.core5.http.Header;
        failureListener.assertNotCalled();
                try {
    }
        } catch (ResponseException e) {
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
             * Run the request more than once to verify that the
        NodeSelector firstPositionOnly = restClientNodes -> {
                    assertEquals(0, e.getSuppressed().length);
            /*
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
        for (int i = 0; i < rounds; i++) {
        }
    }
        List<Node> newNodes = new ArrayList<>(nodes.size());
        RestClient restClient = createRestClient(NodeSelector.ANY);
                    failureListener.assertCalled(response.getHost());
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
                        fail("request should have failed");
                        assertThat(response.getHost(), equalTo(selectedHost));
                    if (method.equals("HEAD") && statusCode == 404) {
                    Response response = e.getResponse();
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
        for (int i = 0; i < numIters; i++) {
                }
     */
                    );
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time
                );
 * under the License.
import java.util.HashSet;
                if (e.getSuppressed().length > 0) {
                failureListener.assertNotCalled();
        exec.shutdown();
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
        throw new UnsupportedOperationException();
    private Set<HttpHost> hostsSet() {
                    } catch (IOException e) {
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 2, 5);
                        restClient,
                        assertEquals(statusCode, response.getStatusLine().getStatusCode());
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 2, 5);
                        new Request(randomHttpMethod(getRandom()), retryEndpoint)
            assertEquals(newNodes.get(0).getHost(), response.getHost());
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
                return "/soe";
                    }
                } catch (ResponseException e) {
            for (int j = 0; j < nodes.size(); j++) {
                    Response response;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                int statusCode = randomErrorNoRetryStatusCode(getRandom());
        } catch (IOException e) {
import org.junit.After;
                        Response response = e.getResponse();
import static org.junit.Assert.assertTrue;
 * Licensed to Elasticsearch under one or more contributor
import java.io.IOException;
                        );
    public void testRoundRobinOkStatusCodes() throws Exception {
            failureListener.assertCalled(nodes);
