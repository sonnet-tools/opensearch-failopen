package org.opensearch.http.reactor.netty4;
                assertOpaqueIdsInOrder(opaqueIds);
import io.netty.handler.codec.http.FullHttpResponse;
    }
import java.util.Collection;
import org.opensearch.core.common.transport.TransportAddress;
    }  
                assertThat(responses, hasSize(5));
                responses.forEach(ReferenceCounted::release);  
 * this file be licensed under the Apache-2.0 license or a
            assertThat(msg, opaqueId, is(String.valueOf(i++)));
    protected boolean addMockHttpTransport() {
/*  
        // check if opaque ids are monotonically increasing  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.OpenSearchReactorNetty4IntegTestCase;  
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
public class ReactorNetty4PipeliningIT extends OpenSearchReactorNetty4IntegTestCase {
    public void testThatNettyHttpServerSupportsPipelining() throws Exception {  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import io.netty.util.ReferenceCounted;
import static org.hamcrest.Matchers.is;
    }  
 *
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                Collection<String> opaqueIds = ReactorHttpClient.returnOpaqueIds(responses);  
    @Override
 */  
        TransportAddress transportAddress = randomFrom(boundAddresses);
        for (String opaqueId : opaqueIds) {  
        int i = 0;
/*
        String msg = String.format(Locale.ROOT, "Expected list of opaque ids to be monotonically increasing, got [%s]", opaqueIds);
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
        return false; // enable http  
            }
}
            } finally {
        }
 * The OpenSearch Contributors require contributions made to  
    private void assertOpaqueIdsInOrder(Collection<String> opaqueIds) {
 */
 * compatible open source license.
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.hasSize;
import java.util.Locale;
        String[] requests = new String[] { "/", "/_nodes/stats", "/", "/_cluster/state", "/" };
import org.opensearch.http.HttpServerTransport;  
        }
        try (ReactorHttpClient client = ReactorHttpClient.create(Settings.EMPTY)) {
            try {  
            Collection<FullHttpResponse> responses = client.get(transportAddress.address(), true, requests);
