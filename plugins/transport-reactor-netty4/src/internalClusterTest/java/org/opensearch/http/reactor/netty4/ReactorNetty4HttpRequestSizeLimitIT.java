import static org.hamcrest.Matchers.equalTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long countUnexpectedStatus = responses.stream().filter(r -> r.status().equals(expectedStatus) == false).count();  
import org.opensearch.http.HttpServerTransport;
/*  
            bulkRequest.append("{ \"field\" : \"value\" }");
            countUnexpectedStatus,  
            requests.add(Tuple.tuple("/index/_bulk", bulkRequest));
            try {  
import io.netty.handler.codec.http.HttpResponseStatus;
    protected boolean addMockHttpTransport() {  
 * This test checks that in-flight requests are limited on HTTP level and that requests that are excluded from limiting can pass.
    protected Settings nodeSettings(int nodeOrdinal) {
import io.netty.util.ReferenceCounted;  
        assertThat(
            }
 * The OpenSearch Contributors require contributions made to  
            .build();
        List<Tuple<String, CharSequence>> requestUris = new ArrayList<>();  
import org.opensearch.common.collect.Tuple;
import static org.hamcrest.Matchers.hasSize;
        try (ReactorHttpClient nettyHttpClient = ReactorHttpClient.create(false, Settings.EMPTY)) {
        return false; // enable http
        );
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
        // we use the limit size as a (very) rough indication on how many requests we should sent to hit the limit
 * SPDX-License-Identifier: Apache-2.0
        TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());
        long countExpectedStatus = responses.stream().filter(r -> r.status().equals(expectedStatus)).count();
 *
                } finally {  
    private void assertAllInExpectedStatus(Collection<FullHttpResponse> responses, HttpResponseStatus expectedStatus) {
            final Collection<FullHttpResponse> responses = nettyHttpClient.put(transportAddress.address(), requestUris);
import org.opensearch.common.settings.Settings;  
    private static final ByteSizeValue LIMIT = new ByteSizeValue(2, ByteSizeUnit.KB);  
import org.opensearch.core.common.unit.ByteSizeValue;  
    }
        int numRequests = LIMIT.bytesAsInt() / 100;
        ensureGreen();
                    multipleResponses.forEach(ReferenceCounted::release);
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
                responses.forEach(ReferenceCounted::release);
 */  
                final Collection<FullHttpResponse> multipleResponses = nettyHttpClient.post(transportAddress.address(), requests);
            requestUris.add(Tuple.tuple("/_cluster/settings", "{ \"transient\": {\"search.default_search_timeout\": \"40s\" } }"));
        ensureGreen();
/*
 * As the same setting is also used to limit in-flight requests on transport level, we avoid transport messages by forcing  
 * under the License.  
        }
        for (int i = 0; i < numRequests; i++) {
import java.util.List;
                assertAtLeastOnceExpectedStatus(singleResponse, HttpResponseStatus.OK);  
                assertThat(responses, hasSize(requestUris.size()));
            bulkRequest.append("{\"index\": {}}");  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        // See please https://github.com/netty/netty/pull/17068 why 128 is the cap, we should be able to
import static org.hamcrest.Matchers.greaterThan;  
import java.util.Collection;
            bulkRequest.append(System.lineSeparator());
import org.opensearch.core.common.transport.TransportAddress;
        }  
 *  
                    assertAtLeastOnceExpectedStatus(multipleResponses, HttpResponseStatus.TOO_MANY_REQUESTS);
            .put(ReactorNetty4HttpServerTransport.SETTING_H2_MAX_CONCURRENT_STREAMS.getKey(), 1500L)  
        }
            } finally {  
 * compatible open source license.
        }  
                try {  
    }
                    assertThat(multipleResponses, hasSize(requests.size()));
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * not use this file except in compliance with the License.
public class ReactorNetty4HttpRequestSizeLimitIT extends OpenSearchReactorNetty4IntegTestCase {
        assertThat("Expected at least one request with status [" + expectedStatus + "]", countExpectedStatus, greaterThan(0L));
 * software distributed under the License is distributed on an
 */  
        StringBuilder bulkRequest = new StringBuilder();
        for (int i = 0; i < 128; i++) {  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
    }
    public void testDoesNotLimitExcludedRequests() throws Exception {  
 * You may obtain a copy of the License at  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
        }  
 * specific language governing permissions and limitations
        List<Tuple<String, CharSequence>> requests = new ArrayList<>();  
    private void assertAtLeastOnceExpectedStatus(Collection<FullHttpResponse> responses, HttpResponseStatus expectedStatus) {  
            } finally {  
/*  
    }  
        return Settings.builder()  
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numClientNodes = 0, numDataNodes = 1)  
    }  
            .put(super.nodeSettings(nodeOrdinal))
                }
            final Collection<FullHttpResponse> singleResponse = nettyHttpClient.post(transportAddress.address(), requests.subList(0, 1));  
            }
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());  
            "Expected all requests with status [" + expectedStatus + "] but [" + countUnexpectedStatus + "] requests had a different one",
            try {
    public void testLimitsInFlightRequests() throws Exception {
            equalTo(0L)
 * a single node "cluster".
            bulkRequest.append(System.lineSeparator());  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                assertThat(singleResponse, hasSize(1));
                singleResponse.forEach(ReferenceCounted::release);
        // make it configurable in the Netty next release.
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        for (int i = 0; i < 150; i++) {
package org.opensearch.http.reactor.netty4;
            .put(HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), LIMIT)
}
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.OpenSearchReactorNetty4IntegTestCase;
 *
        try (ReactorHttpClient nettyHttpClient = ReactorHttpClient.create(false, Settings.EMPTY)) {
 */
    }
    @Override
 *
import java.util.ArrayList;  
/**  
                assertAllInExpectedStatus(responses, HttpResponseStatus.OK);
import io.netty.handler.codec.http.FullHttpResponse;
