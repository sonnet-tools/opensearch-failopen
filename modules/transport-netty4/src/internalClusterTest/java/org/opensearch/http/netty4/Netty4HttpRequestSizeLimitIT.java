            }  
 * compatible open source license.
    @Override
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http()) {
        assertThat("Expected at least one request with status [" + expectedStatus + "]", countExpectedStatus, greaterThan(0L));  
        ensureGreen();
    }
 */  
    }
 * specific language governing permissions and limitations
public class Netty4HttpRequestSizeLimitIT extends OpenSearchNetty4IntegTestCase {
        }  
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http()) {
import org.opensearch.core.common.unit.ByteSizeValue;  
    @Override
/*  
    }
        }  
/*
            } finally {
            try {
        for (int i = 0; i < 1500; i++) {
 * under the License.  
        for (int i = 0; i < numRequests; i++) {
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
        }
                try {  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
import io.netty.handler.codec.http.FullHttpResponse;
 */
        List<Tuple<String, CharSequence>> requestUris = new ArrayList<>();  
    }
                    assertAtLeastOnceExpectedStatus(multipleResponses, HttpResponseStatus.TOO_MANY_REQUESTS);
        // we use the limit size as a (very) rough indication on how many requests we should sent to hit the limit
import org.opensearch.http.HttpServerTransport;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *
            Collection<FullHttpResponse> responses = nettyHttpClient.post(transportAddress.address(), requestUris);  
            .put(super.nodeSettings(nodeOrdinal))
        }  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.http.netty4;
                assertThat(responses, hasSize(requestUris.size()));
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numClientNodes = 0, numDataNodes = 1)  
        ensureGreen();
                assertAllInExpectedStatus(responses, HttpResponseStatus.OK);  
 */
            bulkRequest.append(System.lineSeparator());  
                }
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        return false; // enable http
import io.netty.util.ReferenceCounted;  
            bulkRequest.append("{ \"field\" : \"value\" }");
        );  
/*  
import static org.hamcrest.Matchers.equalTo;
    }
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), LIMIT)
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
                Collection<FullHttpResponse> multipleResponses = nettyHttpClient.post(transportAddress.address(), requests);
 * Unless required by applicable law or agreed to in writing,
        long countUnexpectedStatus = responses.stream().filter(r -> r.status().equals(expectedStatus) == false).count();
            "Expected all requests with status [" + expectedStatus + "] but [" + countUnexpectedStatus + "] requests had a different one",  
import org.opensearch.core.common.unit.ByteSizeUnit;
/**  
        TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());  
    public void testDoesNotLimitExcludedRequests() throws Exception {  
    protected Settings nodeSettings(int nodeOrdinal) {
                    multipleResponses.forEach(ReferenceCounted::release);
    public void testLimitsInFlightRequests() throws Exception {
            Collection<FullHttpResponse> singleResponse = nettyHttpClient.post(transportAddress.address(), requests.subList(0, 1));  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } finally {  
        }
    private static final ByteSizeValue LIMIT = new ByteSizeValue(2, ByteSizeUnit.KB);  
                assertAtLeastOnceExpectedStatus(singleResponse, HttpResponseStatus.OK);  
 * <p>
import org.opensearch.common.settings.Settings;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.OpenSearchNetty4IntegTestCase;
        List<Tuple<String, CharSequence>> requests = new ArrayList<>();  
 * You may obtain a copy of the License at  
 * GitHub history for details.
import java.util.ArrayList;  
        TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());  
 * The OpenSearch Contributors require contributions made to  
        int numRequests = LIMIT.bytesAsInt() / 100;
import java.util.List;
            bulkRequest.append("{\"index\": {}}");  
 */  
 * a single node "cluster".
            }
    private void assertAllInExpectedStatus(Collection<FullHttpResponse> responses, HttpResponseStatus expectedStatus) {  
import io.netty.handler.codec.http.HttpResponseStatus;
        return Settings.builder()  
                assertThat(singleResponse, hasSize(1));
 *
        for (int i = 0; i < 1500; i++) {
import static org.hamcrest.Matchers.hasSize;
 * software distributed under the License is distributed on an
    }
        long countExpectedStatus = responses.stream().filter(r -> r.status().equals(expectedStatus)).count();
 * KIND, either express or implied.  See the License for the
            } finally {  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(
            .build();
            bulkRequest.append(System.lineSeparator());
 * Modifications Copyright OpenSearch Contributors. See
            countUnexpectedStatus,
import java.util.Collection;
 * This test checks that in-flight requests are limited on HTTP level and that requests that are excluded from limiting can pass.
 * As the same setting is also used to limit in-flight requests on transport level, we avoid transport messages by forcing  
 * not use this file except in compliance with the License.
            requests.add(Tuple.tuple("/index/_bulk", bulkRequest));
import org.opensearch.common.collect.Tuple;
                responses.forEach(ReferenceCounted::release);
        StringBuilder bulkRequest = new StringBuilder();
    private void assertAtLeastOnceExpectedStatus(Collection<FullHttpResponse> responses, HttpResponseStatus expectedStatus) {
            .put(Netty4HttpServerTransport.SETTING_HTTP_PIPELINE_DEPTH.getKey(), 1500)  
 *  
import static org.hamcrest.Matchers.greaterThan;  
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            try {
    protected boolean addMockHttpTransport() {  
}  
                    assertThat(multipleResponses, hasSize(requests.size()));
            requestUris.add(Tuple.tuple("/_cache/clear", "{}"));
                singleResponse.forEach(ReferenceCounted::release);
 * SPDX-License-Identifier: Apache-2.0
            equalTo(0L)
 * ownership. Elasticsearch licenses this file to you under  
