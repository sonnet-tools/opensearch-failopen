        // Send the request and verify the response status code
import org.opensearch.test.rest.FakeRestChannel;  
    }
        /*
        assert (validHttpMethodArray.size() > 0);
        List<RestRequest.Method> invalidHttpMethodArray = new ArrayList<RestRequest.Method>(Arrays.asList(RestRequest.Method.values()));
            Settings.EMPTY,
        for (RestRequest.Method method : validHttpMethodArray) {
         * test endpoint  
         */
        RestController restController = new RestController(Collections.emptySet(), null, null, circuitBreakerService, usageService);
         * method list, passing in the RandomizedContext's Random instance,
        validHttpMethodArray.remove(RestRequest.Method.OPTIONS);
        restController.dispatchRequest(restRequest, restChannel, new ThreadContext(Settings.EMPTY));
        public BytesReference content() {
        CircuitBreakerService circuitBreakerService = new HierarchyCircuitBreakerService(  
import static org.hamcrest.Matchers.is;
import org.opensearch.common.util.concurrent.ThreadContext;  
import org.opensearch.transport.client.node.NodeClient;
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
public class RestHttpResponseHeadersTests extends OpenSearchTestCase {  
            return null;  
        public RestStatus status() {
/*
 *  
        }
import static org.hamcrest.CoreMatchers.notNullValue;
        assert (validHttpMethodArray.size() < RestRequest.Method.values().length);
         * Verify the response allow header contains the valid methods for the
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        assert (invalidHttpMethodArray.size() > 0);  
import org.opensearch.common.settings.ClusterSettings;
     */  
        // Register valid test handlers with test RestController
import org.opensearch.test.OpenSearchTestCase;
    }
        }
        fakeRestRequestBuilder.withMethod(invalidHttpMethodArray.get(0));
        List<String> responseAllowHeaderArray = Arrays.asList(responseAllowHeader.split(","));
    private List<String> getMethodNameStringArray(List<RestRequest.Method> methodArray) {
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
            return null;
        @Override  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        @Override
     * <a href="https://tools.ietf.org/html/rfc2616#section-10.4.6">HTTP/1.1 -
         */
    /**
         * the array, so we are guaranteed at least one invalid method to test.
     * compared with the expected 'Allow' header String array.  
     * 10.4.6 - 405 Method Not Allowed</a>).
import java.util.Arrays;  
        assertThat(restChannel.capturedResponse().getHeaders().get("Allow"), notNullValue());
        validHttpMethodArray = validHttpMethodArray.subList(0, randomIntBetween(1, validHttpMethodArray.size() - 1));  
        /*
         */
 * not use this file except in compliance with the License.
        );
         * with the test RestController endpoint. Enums are returned in the
         * order they are declared, so the first step is to shuffle the HTTP  
 * software distributed under the License is distributed on an
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
 * under the License.  
import java.util.ArrayList;
         * The upper bound of the potential sublist is one less than the size of  
    private static class TestResponse extends RestResponse {  
            }  
 *
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
 * specific language governing permissions and limitations
        String responseAllowHeader = restChannel.capturedResponse().getHeaders().get("Allow").get(0);  
         * Generate an inverse list of one or more candidate invalid HTTP
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        Collections.shuffle(validHttpMethodArray, random());  
     * (see  
            return RestStatus.OK;
     * 'Allow' header includes a list of valid HTTP methods for the endpoint
            @Override  
 */  
import org.opensearch.test.rest.FakeRestRequest;
        /*
            restController.registerHandler(method, "/", restHandler);  
     * Convert an RestRequest.Method array to a String array, so it can be
        // Initialize test candidate RestController
        RestHandler restHandler = new RestHandler() {
 *
         * Generate a random set of candidate valid HTTP methods to register
        public String contentType() {  
                channel.sendResponse(new TestResponse());
        // A basic RestHandler handles requests to the endpoint  
        }
 */
        List<RestRequest.Method> validHttpMethodArray = new ArrayList<RestRequest.Method>(Arrays.asList(RestRequest.Method.values()));
        @Override
/*  
 * the Apache License, Version 2.0 (the "License"); you may
}  
        FakeRestChannel restChannel = new FakeRestChannel(restRequest, false, 1);  
        return methodArray.stream().map(method -> method.toString()).collect(Collectors.toList());  
         * methods, so we have a candidate method to fire at the test endpoint.  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        invalidHttpMethodArray.remove(RestRequest.Method.OPTIONS);
            Collections.emptyList(),
        };
        FakeRestRequest.Builder fakeRestRequestBuilder = new FakeRestRequest.Builder(xContentRegistry());
    public void testUnsupportedMethodResponseHttpHeader() throws Exception {
    }
        UsageService usageService = new UsageService();  
         */  
        assertThat(restChannel.capturedResponse().status().getStatus(), is(405));
     * For requests to a valid REST endpoint using an unsupported HTTP method,  
import java.util.List;
        assertThat(responseAllowHeaderArray.size(), is(validHttpMethodArray.size()));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
/*  
import java.util.Collections;
import static org.hamcrest.Matchers.containsInAnyOrder;  
import org.opensearch.usage.UsageService;  
     */
        // Remove OPTIONS, or else we'll get a 200 instead of 405
        // Generate a test request with an invalid HTTP method  
        assertThat(responseAllowHeaderArray, containsInAnyOrder(getMethodNameStringArray(validHttpMethodArray).toArray()));  
import org.opensearch.core.common.bytes.BytesReference;
        /*  
        RestRequest restRequest = fakeRestRequestBuilder.build();  
         * before picking out a candidate sublist.
import org.opensearch.common.settings.Settings;
        }  
 * GitHub history for details.
 */  
 * You may obtain a copy of the License at  
package org.opensearch.rest;
     * verify that a 405 HTTP response code is returned, and that the response
        invalidHttpMethodArray.removeAll(validHttpMethodArray);  
import java.util.stream.Collectors;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.rest.RestStatus;  
 * this file be licensed under the Apache-2.0 license or a
