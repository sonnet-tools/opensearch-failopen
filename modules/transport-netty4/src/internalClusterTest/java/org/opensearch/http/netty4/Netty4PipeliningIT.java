import org.opensearch.OpenSearchNetty4IntegTestCase;
 * specific language governing permissions and limitations
 */
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    }  
        // check if opaque ids are monotonically increasing  
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.http.HttpServerTransport;  
import io.netty.util.ReferenceCounted;
 *
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 *  
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http()) {
            assertThat(msg, opaqueId, is(String.valueOf(i++)));
    public void testThatNettyHttpServerSupportsPipelining() throws Exception {  
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.is;
public class Netty4PipeliningIT extends OpenSearchNetty4IntegTestCase {
}
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 */  
        TransportAddress transportAddress = randomFrom(boundAddresses);
                assertThat(responses, hasSize(5));
/*  
package org.opensearch.http.netty4;
 */  
 * not use this file except in compliance with the License.
import java.util.Collection;
    protected boolean addMockHttpTransport() {
        String msg = String.format(Locale.ROOT, "Expected list of opaque ids to be monotonically increasing, got [%s]", opaqueIds);
    @Override
            } finally {
/*
    }
        return false; // enable http  
            try {  
            }
 * Modifications Copyright OpenSearch Contributors. See
        for (String opaqueId : opaqueIds) {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * SPDX-License-Identifier: Apache-2.0
        String[] requests = new String[] { "/", "/_nodes/stats", "/", "/_cluster/state", "/" };
                responses.forEach(ReferenceCounted::release);  
            Collection<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), requests);
        }
 * Licensed to Elasticsearch under one or more contributor  
    }  
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.hasSize;
                assertOpaqueIdsInOrder(opaqueIds);
import io.netty.handler.codec.http.FullHttpResponse;
import org.opensearch.core.common.transport.TransportAddress;
 * under the License.  
 *
 * compatible open source license.
    private void assertOpaqueIdsInOrder(Collection<String> opaqueIds) {
import java.util.Locale;
/*  
        int i = 0;
