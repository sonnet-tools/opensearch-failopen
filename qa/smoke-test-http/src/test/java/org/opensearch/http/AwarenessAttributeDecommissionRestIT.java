        List<String> clusterManagerNodes = internalCluster().startNodes(
            ResponseException.class,  
    public void testRestStatusForDecommissioningFailedException() {
        assertEquals(response.getStatusLine().getStatusCode(), RestStatus.OK.getStatus());  
                .put(commonSettings)
                .build(),  
 * The OpenSearch Contributors require contributions made to  
            Settings.builder()
import java.util.Map;
                .put("node.attr.zone", "c")
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
                .build(),
        logger.info("--> setting shard routing weights for weighted round robin");
        logger.info("--> start 3 cluster manager nodes on zones 'a' & 'b' & 'c'");
            .setWeightedRouting(weightedRouting)
        List<String> dataNodes = internalCluster().startNodes(  
            .get();
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
        );  
        Settings commonSettings = Settings.builder()
            () -> getRestClient().performRequest(request)
import static org.opensearch.test.NodeRoles.onlyRole;  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                .put("node.attr.zone", "c")  
                .put("node.attr.zone", "b")
public class AwarenessAttributeDecommissionRestIT extends HttpSmokeTestCase{  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                .put("node.attr.zone", "b")
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                .put(commonSettings)
package org.opensearch.http;
import java.io.IOException;
        ClusterPutWeightedRoutingResponse weightedRoutingResponse = client().admin()
    }
import org.opensearch.cluster.routing.WeightedRouting;  
                .build(),
import org.opensearch.common.settings.Settings;
import org.opensearch.client.Response;  
        Request request = new Request("PUT", "/_cluster/decommission/awareness/zone/zone-1");
        ResponseException exception = expectThrows(
        assertEquals(exception.getResponse().getStatusLine().getStatusCode(), RestStatus.BAD_REQUEST.getStatus());  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
            .build();
                .build(),
            .setVersion(-1)  
                .build()
 * this file be licensed under the Apache-2.0 license or a
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
import java.util.List;  
                .put(commonSettings)
        assertTrue(exception.getMessage().contains("invalid awareness attribute requested for decommissioning"));
import org.opensearch.cluster.node.DiscoveryNodeRole;
            .cluster()  
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
        assertTrue(weightedRoutingResponse.isAcknowledged());
        );
                .put("node.attr.zone", "a")
        internalCluster().startNodes(3);  
        Response response = getRestClient().performRequest(request);
import org.opensearch.client.Request;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            Settings.builder()  
            Settings.builder()
import org.opensearch.core.rest.RestStatus;
                .put("node.attr.zone", "a")  
/*  
import org.opensearch.test.OpenSearchIntegTestCase;  
 *
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
                .build()  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
    }
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
            .prepareWeightedRouting()
                .put(commonSettings)  
            Settings.builder()
            Settings.builder()  
 */  
                .put(commonSettings)
    public void testRestStatusForAcknowledgedDecommission() throws IOException {
import org.opensearch.client.ResponseException;
}
        Request request = new Request("PUT", "/_cluster/decommission/awareness/zone/c");
            Settings.builder()
        ensureStableCluster(6);  
        );
                .put(commonSettings)  
