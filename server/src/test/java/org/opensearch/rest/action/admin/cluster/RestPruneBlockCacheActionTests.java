import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.action.admin.cluster.blockcache.NodePruneBlockCacheResponse;
            Collections.singletonList(new NodePruneBlockCacheResponse(node, true)),  
        verifyingClient.setExecuteVerifier((actionType, request) -> {
        dispatchRequest(
        dispatchRequest(
        verifyingClient.setExecuteVerifier((actionType, request) -> {
    }
    }
        });
import java.util.Map;
    }
    private RestPruneBlockCacheAction action;
            Collections.emptyList()
        when(node.getHostName()).thenReturn("localhost");
            PruneBlockCacheRequest pruneRequest = (PruneBlockCacheRequest) request;
        assertEquals("prune_blockcache_action", action.getName());  
public class RestPruneBlockCacheActionTests extends RestActionTestCase {
    public void testRoutes() {
    @Before  
            new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)  
import org.opensearch.rest.RestRequest;
    public void testGetName() {
                .withParams(params)
import org.opensearch.cluster.ClusterName;
        );  
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.instanceOf;
 *
            assertThat(request, instanceOf(PruneBlockCacheRequest.class));  
            new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST).withPath("/_blockcache/prune").build()
import org.opensearch.test.rest.RestActionTestCase;  
    }
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheResponse;
        );
        return new PruneBlockCacheResponse(
import org.opensearch.cluster.node.DiscoveryNode;  
 */  
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheRequest;  
import org.junit.Before;
        DiscoveryNode node = mock(DiscoveryNode.class);
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(PruneBlockCacheAction.INSTANCE, actionType);
        assertEquals(1, action.routes().size());  
import java.util.Collections;  
    }  
        when(node.getName()).thenReturn("test-node");  
        action = new RestPruneBlockCacheAction();
                .build()  
            return mockResponse();
                .withPath("/_blockcache/prune")
    private PruneBlockCacheResponse mockResponse() {  
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
    public void testCannotTripCircuitBreaker() {  
            assertArrayEquals(new String[] { "node1", "node2" }, pruneRequest.nodesIds());
            return mockResponse();  
    public void testNodeTargeting() throws Exception {
}  
        });
        assertFalse(action.canTripCircuitBreaker());
 * this file be licensed under the Apache-2.0 license or a
    public void testPruneRequest() throws Exception {  
import static org.mockito.Mockito.when;  
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
            new ClusterName("test"),
        when(node.getId()).thenReturn("node1");
        params.put("nodes", "node1,node2");
        );
 * The OpenSearch Contributors require contributions made to  
/*  
    public void setUpAction() {
    }  
        when(node.getAddress()).thenReturn(buildNewFakeTransportAddress());  
        Map<String, String> params = new HashMap<>();  
        controller().registerHandler(action);  
package org.opensearch.rest.action.admin.cluster;
import java.util.HashMap;
        assertEquals("/_blockcache/prune", action.routes().get(0).getPath());
    }
            assertThat(request, instanceOf(PruneBlockCacheRequest.class));  
        when(node.getHostAddress()).thenReturn("127.0.0.1");
 * compatible open source license.
