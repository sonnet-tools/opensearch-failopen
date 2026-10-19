    @Override
 */  
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
        return false; // enable http
package org.opensearch.http.netty4;
    public void testThatNettyHttpServerSupportsHttp2GetUpgrades() throws Exception {
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http2()) {
    public void testThatNettyHttpServerSupportsHttp2PostUpgrades() throws Exception {  
import java.util.Collection;
public class Netty4Http2IT extends OpenSearchNetty4IntegTestCase {  
                assertThat(responses, hasSize(1));
 * compatible open source license.
        // and responses may come back at any order
}  
    }
                assertOpaqueIdsInAnyOrder(5, opaqueIds);
            }
        TransportAddress transportAddress = randomFrom(boundAddresses);  
 * SPDX-License-Identifier: Apache-2.0
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
    private void assertOpaqueIdsInAnyOrder(int expected, Collection<String> opaqueIds) {  
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
    }
import io.netty.util.ReferenceCounted;
                responses.forEach(ReferenceCounted::release);
import org.opensearch.OpenSearchNetty4IntegTestCase;
        final List<Tuple<String, CharSequence>> requests = List.of(Tuple.tuple("/_search", "{\"query\":{ \"match_all\":{}}}"));
                assertOpaqueIdsInAnyOrder(1, opaqueIds);
            } finally {  
            } finally {  
import static org.hamcrest.Matchers.containsInAnyOrder;
                for (FullHttpResponse response : responses) {  
 *
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);
import static org.hamcrest.Matchers.hasSize;  
                }
 * The OpenSearch Contributors require contributions made to  
    }
        TransportAddress transportAddress = randomFrom(boundAddresses);
import io.netty.handler.codec.http.FullHttpResponse;  
        assertThat(opaqueIds, containsInAnyOrder(IntStream.range(0, expected).mapToObj(Integer::toString).toArray()));  
import io.netty.handler.codec.http.HttpResponseStatus;
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
        }  
            Collection<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), requests);  
            Collection<FullHttpResponse> responses = nettyHttpClient.post(transportAddress.address(), requests);
            try {  
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);
import org.opensearch.core.common.transport.TransportAddress;  
                assertThat(responses, hasSize(5));
            try {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        }  
            }
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);  
                responses.forEach(ReferenceCounted::release);
import static org.hamcrest.CoreMatchers.equalTo;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
import org.opensearch.http.HttpServerTransport;
    protected boolean addMockHttpTransport() {  
import java.util.stream.IntStream;
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http2()) {
        // check if opaque ids are present in any order, since for HTTP/2 we use streaming (no head of line blocking)
        String[] requests = new String[] { "/", "/_nodes/stats", "/", "/_cluster/state", "/" };
import org.opensearch.common.collect.Tuple;
/*  
