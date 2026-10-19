 * Tests for {@link RestClient} behaviour against multiple hosts: fail-over, denylisting etc.
                        response = e.getResponse();
                } else {  
                    int statusCode = randomErrorNoRetryStatusCode(getRandom());  
                return "/ioe";  
import static org.opensearch.client.RestClientTestUtil.randomErrorNoRetryStatusCode;
                }
            }
            Set<HttpHost> hostsSet = hostsSet();  
                        );  
    private static String randomErrorRetryEndpoint() {  
        failureListener.assertNotCalled();
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));
            do {  
        }
                int statusCode = randomErrorNoRetryStatusCode(getRandom());  
                        assertThat(httpHost, equalTo(selectedHost));
        CloseableHttpAsyncClient httpClient = RestClientSingleHostTests.mockHttpClient(exec);  
                assertEquals(statusCode, response.getStatusLine().getStatusCode());  
                    } else {
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.instanceOf;
    @After
            hosts.add(node.getHost());  
        RestClient restClient = createRestClient(NodeSelector.ANY);
                    HttpHost httpHost = HttpHost.create(e.getMessage());
                int iters = RandomNumbers.randomIntBetween(getRandom(), 2, 10);
                    if (method.equals("HEAD") && statusCode == 404) {  
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
    public RestClient createRestClient(NodeSelector nodeSelector) {
                    Response response = e.getResponse();  
        }  
             * Run the request more than once to verify that the
     * Shutdown the executor so we don't leak threads into other test runs.  
                for (int y = 0; y < i + 1; y++) {
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());  
    public void testNodeSelector() throws Exception {
/*  
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
        for (int i = 0; i < nodes.size(); i++) {
                    fail("request should have failed");
            boolean found = false;  
                    } else {
                    } catch (IOException e) {  
                String method = randomHttpMethod(getRandom());
    }  
                    hostsSet.remove(response.getHost())
                // selected to be retried earlier (due to lower number of failures) till all the hosts have the same number of failures
        String retryEndpoint = randomErrorRetryEndpoint();
    public void testRoundRobinNoRetryErrors() throws Exception {
                            new Request(randomHttpMethod(getRandom()), "/" + statusCode)
                        new Request(randomHttpMethod(getRandom()), retryEndpoint)  
        for (int i = 0; i < numNodes; i++) {  
        return hosts;
                    );  
        }
                assertTrue("host not found: " + response.getHost(), hostsSet.remove(response.getHost()));
             * NodeSelector overrides the round robin behavior.
                try {
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < rounds; i++) {
                        assertTrue("host not found: " + response.getHost(), hostsSet.remove(response.getHost()));
    public void testRoundRobinOkStatusCodes() throws Exception {
    private Set<HttpHost> hostsSet() {  
 *
                        Response response = e.getResponse();
        return new RestClient(httpClient, new Header[0], nodes, null, failureListener, nodeSelector, false, false);
        nodes = Collections.unmodifiableList(nodes);  
                    }  
                            new Request(randomHttpMethod(getRandom()), retryEndpoint)
import java.util.concurrent.Executors;  
                // let the selected host catch up on number of failures, it gets selected a consecutive number of times as it's the one  
     * in use by the test.
            for (int j = 0; j < nodes.size(); j++) {
                    Response response = e.getResponse();
    /**
        }
                    );
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());  
                }  
 * Licensed to Elasticsearch under one or more contributor  
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time
                    assertEquals(0, e.getSuppressed().length);  
 */
                } else {
                if (nodes.get(0) == itr.next()) {
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each
            /*
                }
                assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));
                Response response = e.getResponse();
                        HttpHost httpHost = HttpHost.create(e.getMessage());
        for (int i = 0; i < rounds; i++) {  
        }
                    new Request(randomHttpMethod(getRandom()), "/" + statusCode)
                assertTrue(  
 */  
            }
                int statusCode = randomOkStatusCode(getRandom());
                    assertEquals(0, e.getSuppressed().length);  
                        fail("request should have failed");  
                    assertEquals(1, e.getSuppressed().length);
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);  
 * compatible open source license.
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());
                        failureListener.assertCalled(selectedHost);
                : new Node.Roles(new TreeSet<>(Arrays.asList("master")));
import java.util.concurrent.ExecutorService;
        }
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
                HttpHost httpHost = HttpHost.create(e.getMessage());
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 2, 5);
                        selectedHost = response.getHost();  
             */
        RestClient restClient = createRestClient(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);  
 *  
    }
    /**
                    assertEquals(0, e.getSuppressed().length);  
                // mark one host back alive through a successful request and check that all requests after that are sent to it
                try {  
     */
                }
 * specific language governing permissions and limitations
     * Build a mutable {@link Set} containing all the {@link Node#getHost() hosts}  
    }  
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);  
                    } catch (ResponseException e) {
                retryEndpoint = randomErrorRetryEndpoint();
                            restClient,  
    }  
    public void testSetNodes() throws Exception {
            newNodes.add(new Node(nodes.get(i).getHost(), null, null, null, roles, null));  
 * license agreements. See the NOTICE file distributed with
        } catch (ResponseException e) {
        exec.shutdown();
            case 2:  
 * Relies on a mock http client to intercept requests and return desired responses based on request path.  
                    failureListener.assertCalled(httpHost);
            Set<HttpHost> hostsSet = hostsSet();  
        }
                        assertThat(response.getHost(), equalTo(selectedHost));
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;  
                        assertEquals(statusCode, response.getStatusLine().getStatusCode());  
                    restClient,  
                    itr.remove();
        for (int i = 0; i < numIters; i++) {
        NodeSelector firstPositionOnly = restClientNodes -> {
import org.junit.After;  
                assertEquals(Integer.parseInt(retryEndpoint.substring(1)), response.getStatusLine().getStatusCode());
                    Response response;
import java.util.Iterator;
                    // after the first request, all hosts are denylisted, a single one gets resurrected each time
        try {
        for (int i = 1; i <= numIters; i++) {
                        assertThat(response.getHost(), equalTo(selectedHost));
            }  
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());  
                    }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    e = (ResponseException) suppressed;
                    e = (IOException) suppressed;
/*
                        failureListener.assertCalled(selectedHost);  
                        fail("request should have failed");  
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
                        assertEquals(404, response.getStatusLine().getStatusCode());
 * under the License.  
        throw new UnsupportedOperationException();
            // first request causes all the hosts to be denylisted, the returned exception holds one suppressed exception each
             * Run the request more than once to verify that the  
            failureListener.assertCalled(nodes);
 * ownership. Elasticsearch licenses this file to you under  
            case 1:
        RestClient restClient = createRestClient(NodeSelector.ANY);  
import org.apache.hc.core5.http.HttpHost;
 * The OpenSearch Contributors require contributions made to  
        nodes = new ArrayList<>(numNodes);
import java.util.Collections;
                    Response response = RestClientSingleHostTests.performRequestSyncOrAsync(
import java.util.HashSet;  
            for (int j = 0; j < nodes.size(); j++) {  
                    if (selectedHost == null) {
            }
                    e = null;  
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(statusCode));
                    try {
    }  
            fail("request should have failed");
            Request request = new Request("GET", "/200");
        restClient.setNodes(newNodes);
                    assertThat(suppressed, instanceOf(ResponseException.class));
 * not use this file except in compliance with the License.
 */
        RestClient restClient = createRestClient(firstPositionOnly);
                    try {
                } catch (ResponseException e) {  
        int numIters = RandomNumbers.randomIntBetween(getRandom(), 2, 5);  
import java.util.List;
 * You may obtain a copy of the License at  
public class RestClientMultipleHostsTests extends RestClientTestCase {
                } else {
    }
                        // no exception gets thrown although we got a 404
        }
            Set<HttpHost> hostsSet = hostsSet();  
        } catch (IOException e) {
            for (int j = 0; j < nodes.size(); j++) {
                for (int y = 0; y < iters; y++) {
            assertEquals("every host should have been used but some weren't: " + hostsSet, 0, hostsSet.size());  
                    Throwable suppressed = e.getSuppressed()[0];
                        hostsSet.remove(response.getHost())
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
            assertTrue(found);
        for (Node node : nodes) {
                }
                    e = null;
                        "host [" + response.getHost() + "] not found, most likely used multiple times",
                        assertThat(response.getStatusLine().getStatusCode(), equalTo(Integer.parseInt(retryEndpoint.substring(1))));  
    public void testRoundRobinRetryErrors() throws Exception {
                    RestClientSingleHostTests.performRequestSyncOrAsync(
            Request request = new Request("GET", "/200");  
                );  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    assertTrue("host not found: " + response.getHost(), hostsSet.remove(response.getHost()));
        int rounds = between(1, 10);
                return "/coe";
    }
                return "/soe";
                    retryEndpoint = randomErrorRetryEndpoint();  
import java.util.Set;  
        int rounds = between(1, 10);  
/**
        }
                } catch (IOException e) {
        Set<HttpHost> hosts = new HashSet<>();
 *
 */  
            // check that one different host is resurrected at each new attempt
             * NodeSelector overrides the round robin behavior.  
            Response response = RestClientSingleHostTests.performRequestSyncOrAsync(restClient, request);
                    assertThat(suppressed, instanceOf(IOException.class));  
import java.util.ArrayList;  
                        );
                );
import static org.opensearch.client.RestClientTestUtil.randomOkStatusCode;
            for (Iterator<Node> itr = restClientNodes.iterator(); itr.hasNext();) {
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            case 3:
                    }
                            restClient,
    private HostsTrackingFailureListener failureListener;  
                    Throwable suppressed = e.getSuppressed()[0];  
package org.opensearch.client;
            failureListener.assertCalled(nodes);
                    if (method.equals("HEAD") && statusCode == 404) {  
import static org.opensearch.client.RestClientTestUtil.randomHttpMethod;
                return "/" + randomErrorRetryStatusCode(getRandom());  
             */
            if (getRandom().nextBoolean()) {
                failureListener.assertNotCalled();
        };  
                        restClient,  
 * SPDX-License-Identifier: Apache-2.0
                        restClient,
            Node.Roles roles = i == 0  
    private ExecutorService exec = Executors.newFixedThreadPool(1);
import static org.junit.Assert.assertThat;  
                    assertEquals(1, e.getSuppressed().length);
                    }
            /*
        switch (RandomNumbers.randomIntBetween(getRandom(), 0, 3)) {
                    );
                }
import java.util.TreeSet;
                    "host [" + response.getHost() + "] not found, most likely used multiple times",
                Response response = RestClientSingleHostTests.performRequestSyncOrAsync(
 * this work for additional information regarding copyright
            assertEquals(newNodes.get(0).getHost(), response.getHost());
                    assertTrue(  
                    assertTrue("host [" + httpHost + "] not found, most likely used multiple times", hostsSet.remove(httpHost));  
                if (e.getSuppressed().length > 0) {  
                        throw e;
            Set<HttpHost> hostsSet = hostsSet();
        List<Node> newNodes = new ArrayList<>(nodes.size());
}
                    } catch (ResponseException e) {
    public void shutdownExec() {  
                    }  
        for (int i = 0; i < numIters; i++) {
                    found = true;  
                if (e.getSuppressed().length > 0) {
    private List<Node> nodes;
                }
                } catch (ResponseException e) {
import static org.junit.Assert.fail;
                HttpHost selectedHost = null;  
                        RestClientSingleHostTests.performRequestSyncOrAsync(
import org.apache.hc.core5.http.Header;
                ? new Node.Roles(new TreeSet<>(Arrays.asList("data", "ingest")))
            RestClientSingleHostTests.performRequestSyncOrAsync(restClient, new Request(randomHttpMethod(getRandom()), retryEndpoint));  
 * Modifications Copyright OpenSearch Contributors. See
     */
                        new Request(method, "/" + statusCode)
            assertEquals(nodes.get(0).getHost(), response.getHost());
            Set<HttpHost> hostsSet = hostsSet();  
                    assertEquals(statusCode, response.getStatusLine().getStatusCode());
        failureListener.assertNotCalled();
                    failureListener.assertCalled(response.getHost());
 * software distributed under the License is distributed on an
/*  
            do {  
        RestClient restClient = createRestClient(NodeSelector.ANY);  
            } while (e != null);  
        }
        failureListener = new HostsTrackingFailureListener();
                        response = RestClientSingleHostTests.performRequestSyncOrAsync(  
            }
            nodes.add(new Node(new HttpHost("localhost", 9200 + i)));
            } while (e != null);
            case 0:
import static org.opensearch.client.RestClientTestUtil.randomErrorRetryStatusCode;  
import static org.hamcrest.CoreMatchers.equalTo;  
