        for (DiscoveryNode node : nodes) {
import org.opensearch.action.admin.cluster.deployment.GetDeploymentResponse;  
            .targetState(DeploymentState.FINISH);
        assertAcked(  
            ClusterSearchShardsResponse finishedShardsResponse = client().admin().cluster().searchShards(shardsRequest).get();  
        // Verify the deployment is visible via GET  
            );  
            for (ClusterSearchShardsGroup group : finishedShardsResponse.getGroups()) {
            }
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.ClusterState;
            )
 * The OpenSearch Contributors require contributions made to  
            GetDeploymentAction.INSTANCE,
    public void testDrainAndFinish() throws Exception {  
                        break;
            prepareCreate(
        // Verify the deployment is no longer visible  
        assertTrue(getResponse.getDeployments().containsKey(deploymentId));  
 * SPDX-License-Identifier: Apache-2.0
        }, 30, TimeUnit.SECONDS);
        String zoneWithPrimary = nodes.get(nodeWithPrimary).getAttributes().get("zone");
            .put(super.nodeSettings(nodeOrdinal))
        TransitionDeploymentRequest finishRequest = new TransitionDeploymentRequest().deploymentId(deploymentId)
import org.opensearch.cluster.routing.ShardRouting;  
            .targetState(DeploymentState.DRAIN)
import java.util.ArrayList;
            ClusterSearchShardsResponse drainedShardsResponse = client().admin().cluster().searchShards(shardsRequest).get();
            assertEquals(  
    @Override
        assertTrue(getResponseAfterFinish.getDeployments().isEmpty());
    protected Settings nodeSettings(int nodeOrdinal) {
        ).get();
                for (ShardRouting shard : group.getShards()) {
                    if (nodeIdsInDrainedZone.contains(shard.currentNodeId())) {  
        assertEquals(1, getResponse.getDeployments().size());
        RoutingTable routingTable = state.routingTable();
            }
            for (DiscoveryNode node : finishedShardsResponse.getNodes()) {
                newRoutingTable.shardsMatchingPredicateCount(s -> s.primary() && nodeIdsInDrainedZone.contains(s.currentNodeId()))
        }, 30, TimeUnit.SECONDS);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 6)
import java.util.List;  
                for (ShardRouting shard : group.getShards()) {
        ensureGreen(INDEX_NAME);  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
import java.util.HashSet;
            }
                }
}
import org.opensearch.action.admin.cluster.deployment.TransitionDeploymentAction;
    }
        assertBusy(() -> {  
                    assertFalse(nodeIdsInDrainedZone.contains(shard.currentNodeId()));
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
            }
        List<String> nodeIdsInDrainedZone = new ArrayList<>();  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
        );
        assertEquals(DeploymentState.DRAIN, getResponse.getDeployments().get(deploymentId).getState());
import org.opensearch.action.admin.cluster.deployment.TransitionDeploymentRequest;
    private static final int NUM_ZONES = 3;
        ClusterState state = client().admin().cluster().state(clusterStateRequest).get().getState();  
import org.opensearch.action.admin.cluster.deployment.GetDeploymentAction;
        TransitionDeploymentRequest drainRequest = new TransitionDeploymentRequest().deploymentId(deploymentId)
                nodeIdsInDrainedZone.add(node.getId());  
    }  
 */  
                INDEX_NAME,
    private static final String INDEX_NAME = "deployment_test";
            assertTrue(foundShardOnDrainedZone);  
            if (zoneWithPrimary.equals(node.getAttributes().get("zone"))) {
            RoutingTable newRoutingTable = newState.routingTable();
            Set<String> nodeZones = new HashSet<>();
/*  
        assertAcked(client().execute(TransitionDeploymentAction.INSTANCE, drainRequest).get());
            }
        List<ShardRouting> primaryShards = routingTable.index(INDEX_NAME).shardsMatchingPredicate(ShardRouting::primary);  
            for (DiscoveryNode node : drainedShardsResponse.getNodes()) {  
            .build();  
 * compatible open source license.
        GetDeploymentResponse getResponse = client().execute(GetDeploymentAction.INSTANCE, new GetDeploymentRequest(deploymentId)).get();
            new GetDeploymentRequest(deploymentId)  
import java.util.Map;
            assertTrue(nodeZones.contains(zoneWithPrimary));
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.common.settings.Settings;
                }  
        return Settings.builder()  
 * this file be licensed under the Apache-2.0 license or a
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
        ClusterStateRequest clusterStateRequest = new ClusterStateRequest().clear().routingTable(true).indices(INDEX_NAME).nodes(true);
        assertBusy(() -> {
import org.opensearch.cluster.node.DiscoveryNodes;
            ClusterState newState = client().admin().cluster().state(clusterStateRequest).get().getState();
        String deploymentId = UUID.randomUUID().toString();
        }
        assertAcked(client().execute(TransitionDeploymentAction.INSTANCE, finishRequest).get());  
                    }  
package org.opensearch.cluster.deployment;
import org.opensearch.action.admin.cluster.deployment.GetDeploymentRequest;
            .attributes(Map.of("zone", zoneWithPrimary));  
        DiscoveryNodes nodes = state.nodes();
        GetDeploymentResponse getResponseAfterFinish = client().execute(
        }, 30, TimeUnit.SECONDS);
 *
                0,
                nodeZones.add(node.getAttributes().get("zone"));  
        ClusterSearchShardsRequest shardsRequest = new ClusterSearchShardsRequest().indices(INDEX_NAME);  
            boolean foundShardOnDrainedZone = false;  
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.metadata.IndexMetadata;
        assertBusy(() -> {
            .put("node.attr.zone", "zone-" + (nodeOrdinal % NUM_ZONES + 1))
                        foundShardOnDrainedZone = true;
import java.util.Set;
                assertNotEquals(zoneWithPrimary, node.getAttributes().get("zone"));
public class DeploymentIT extends OpenSearchIntegTestCase {  
            for (ClusterSearchShardsGroup group : drainedShardsResponse.getGroups()) {  
        String nodeWithPrimary = primaryShards.getFirst().currentNodeId();
import java.util.UUID;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
