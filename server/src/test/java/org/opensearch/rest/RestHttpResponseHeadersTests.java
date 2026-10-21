         * The upper bound of the potential sublist is one less than the size of
        );
     * <a href="https://tools.ietf.org/html/rfc2616#section-10.4.6">HTTP/1.1 -
        UsageService usageService = new UsageService();
            restController.registerHandler(method, "/", restHandler);
        // Remove OPTIONS, or else we'll get a 200 instead of 405
        public RestStatus status() {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * For requests to a valid REST endpoint using an unsupported HTTP method,
        validHttpMethodArray = validHttpMethodArray.subList(0, randomIntBetween(1, validHttpMethodArray.size() - 1));
import org.opensearch.test.OpenSearchTestCase;
        /*
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        return methodArray.stream().map(method -> method.toString()).collect(Collectors.toList());
        // Generate a test request with an invalid HTTP method
 * under the License.
        }
     * compared with the expected 'Allow' header String array.
package org.opensearch.rest;
        /*
            Settings.EMPTY,
        String responseAllowHeader = restChannel.capturedResponse().getHeaders().get("Allow").get(0);
 * software distributed under the License is distributed on an
        // Register valid test handlers with test RestController
import java.util.stream.Collectors;
import java.util.Collections;
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        assertThat(restChannel.capturedResponse().getHeaders().get("Allow"), notNullValue());
        List<RestRequest.Method> validHttpMethodArray = new ArrayList<RestRequest.Method>(Arrays.asList(RestRequest.Method.values()));
        assertThat(responseAllowHeaderArray, containsInAnyOrder(getMethodNameStringArray(validHttpMethodArray).toArray()));
    }
    /**
import static org.hamcrest.CoreMatchers.notNullValue;
        // Initialize test candidate RestController
import java.util.Arrays;
        public BytesReference content() {
import java.util.List;
        assertThat(responseAllowHeaderArray.size(), is(validHttpMethodArray.size()));
        FakeRestChannel restChannel = new FakeRestChannel(restRequest, false, 1);
         * before picking out a candidate sublist.
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
import org.opensearch.core.common.bytes.BytesReference;
 * Modifications Copyright OpenSearch Contributors. See
public class RestHttpResponseHeadersTests extends OpenSearchTestCase {
         * the array, so we are guaranteed at least one invalid method to test.
     * (see
         */
        RestHandler restHandler = new RestHandler() {
                channel.sendResponse(new TestResponse());
     * 'Allow' header includes a list of valid HTTP methods for the endpoint
 * You may obtain a copy of the License at
            Collections.emptyList(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        fakeRestRequestBuilder.withMethod(invalidHttpMethodArray.get(0));
import org.opensearch.usage.UsageService;
import org.opensearch.test.rest.FakeRestChannel;
 */
            return null;
        /*
        assertThat(restChannel.capturedResponse().status().getStatus(), is(405));
     * 10.4.6 - 405 Method Not Allowed</a>).
            }
import org.opensearch.core.rest.RestStatus;
        }
 * The OpenSearch Contributors require contributions made to
/*
         */
            @Override
        public String contentType() {
import org.opensearch.test.rest.FakeRestRequest;
        CircuitBreakerService circuitBreakerService = new HierarchyCircuitBreakerService(
import org.opensearch.common.settings.Settings;
import org.opensearch.transport.client.node.NodeClient;
 * Licensed to Elasticsearch under one or more contributor
        invalidHttpMethodArray.remove(RestRequest.Method.OPTIONS);
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
/*
        FakeRestRequest.Builder fakeRestRequestBuilder = new FakeRestRequest.Builder(xContentRegistry());
         * method list, passing in the RandomizedContext's Random instance,
import static org.hamcrest.Matchers.containsInAnyOrder;
    /**
        invalidHttpMethodArray.removeAll(validHttpMethodArray);
 *
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        };
        restController.dispatchRequest(restRequest, restChannel, new ThreadContext(Settings.EMPTY));
 *
        /*
}
         * order they are declared, so the first step is to shuffle the HTTP
        for (RestRequest.Method method : validHttpMethodArray) {
            return RestStatus.OK;
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
    }
        validHttpMethodArray.remove(RestRequest.Method.OPTIONS);
         * methods, so we have a candidate method to fire at the test endpoint.
     * Convert an RestRequest.Method array to a String array, so it can be
        }
         * with the test RestController endpoint. Enums are returned in the
 * GitHub history for details.
        RestController restController = new RestController(Collections.emptySet(), null, null, circuitBreakerService, usageService);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testUnsupportedMethodResponseHttpHeader() throws Exception {
     * verify that a 405 HTTP response code is returned, and that the response
 * license agreements. See the NOTICE file distributed with
         */
import java.util.ArrayList;
        }
            return null;
         * Verify the response allow header contains the valid methods for the
         */
/*
 */
 *
        @Override
import org.opensearch.common.settings.ClusterSettings;
         * test endpoint
        List<RestRequest.Method> invalidHttpMethodArray = new ArrayList<RestRequest.Method>(Arrays.asList(RestRequest.Method.values()));
        assert (validHttpMethodArray.size() < RestRequest.Method.values().length);
     */
        RestRequest restRequest = fakeRestRequestBuilder.build();
 * compatible open source license.
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        Collections.shuffle(validHttpMethodArray, random());
         * Generate an inverse list of one or more candidate invalid HTTP
        @Override
import static org.hamcrest.Matchers.is;
        // Send the request and verify the response status code
        @Override
    }
    private static class TestResponse extends RestResponse {
 * this work for additional information regarding copyright
 */
        assert (validHttpMethodArray.size() > 0);
        // A basic RestHandler handles requests to the endpoint
import org.opensearch.common.util.concurrent.ThreadContext;
        List<String> responseAllowHeaderArray = Arrays.asList(responseAllowHeader.split(","));
     */
    private List<String> getMethodNameStringArray(List<RestRequest.Method> methodArray) {
         * Generate a random set of candidate valid HTTP methods to register
        assert (invalidHttpMethodArray.size() > 0);
