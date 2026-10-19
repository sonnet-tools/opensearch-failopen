            for (int counter = 0; counter < 3; counter++) {  
                    assertThat(
            );
import org.opensearch.common.collect.Tuple;
                    clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
            }  
            }  
        }
package org.opensearch.cluster.routing.allocation.decider;
import java.util.Collections;  
                    .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
import org.opensearch.cluster.routing.RoutingTable;
                );
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
                } else {
            }  
                        clusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag"),  
                        .build()
        for (int i = 1; i <= sourceNodes; i++) {  
        AllocationService excludeStrategy = null;
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
                    equalTo(clusterConcurrentRecoveries)
 */  
                .build();  
                    Settings.builder()
                }  
import java.util.List;
            clusterConcurrentRecoveries = clusterConcurrentRecoveries + randomInt(5);
        for (int j = 1; j <= targetNodes; j++) {  
import org.opensearch.common.settings.Settings;  
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.routing.ShardRoutingState;  
                );  
                clusterState = excludeStrategy.reroute(clusterState, "reroute");
 * SPDX-License-Identifier: Apache-2.0
            clusterConcurrentRecoveries = Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries;  
        logger.info("Building initial routing table");
import org.opensearch.Version;  
        Metadata metadata = metadataBuilder.build();
        AllocationService initialStrategy = createAllocationService(
            int srcNodes = srcTargetNode.v1();  
                .routingTable(routingTable)
            }
                    assertThat(
                        equalTo("tag_1")
            int targetNodes = srcTargetNode.v2();
 */
import org.opensearch.cluster.node.DiscoveryNodes;  
            Map<String, String> attributes = new HashMap<>();
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
/*
            Map<String, String> attributes = new HashMap<>();
            while (clusterState.getRoutingNodes().hasUnassignedShards()) {
                logger.info("--> Performing a reroute ");
            attributes.put("tag", "tag_" + 1);
                .nodes(setUpClusterNodes(srcNodes, targetNodes))
            for (int counter = 0; counter < 3; counter++) {  
                        .put("cluster.routing.allocation.exclude.tag", "tag_1")
                    );  
            nb.add(newNode("node_s_" + i, attributes));
                    .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);  
                logger.info("--> Performing a reroute ");  
            clusterConcurrentRecoveries = Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries;
                Settings.builder()
                        .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
                }  
    }
                        .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
                clusterState = excludeStrategy.reroute(clusterState, "reroute");
public class ConcurrentRecoveriesAllocationDeciderTests extends OpenSearchAllocationTestCase {
            metadataBuilder.put(
        int primaryShards = 5, replicaShards = 1, numberIndices = 12;
            }  
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
                        equalTo(clusterConcurrentRecoveries)  
                    .numberOfReplicas(replicaShards)  
/*  
            clusterConcurrentRecoveries = clusterConcurrentRecoveries - randomInt(5);
            attributes.put("tag", "tag_" + 0);
        logger.info("--> adding nodes and starting shards");
                .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))  
}
            int expectedClusterConcurrentRecoveries = Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries;
                );  
                .build()
        }
                .put("cluster.routing.allocation.awareness.attributes", "zone")
            logger.info("--> Starting primary shards");  
                        clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
import java.util.HashMap;
                    .put("cluster.routing.allocation.awareness.attributes", "zone")
            assertThat(
        for (int i = 0; i < numberIndices; i++) {
            );
            Arrays.<Tuple<Integer, Integer>>asList(new Tuple(10, 4), new Tuple(4, 10), new Tuple(10, 10))
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                clusterState = excludeStrategy.reroute(clusterState, "reroute");  
            logger.info("--> Disabling cluster_concurrent_recoveries and re-routing ");
            attributes.put("zone", "zone_" + (i % 2));  
                    .numberOfShards(primaryShards)
import static org.hamcrest.Matchers.equalTo;
            // Ensure all shards are started  
                for (ShardRouting startedShard : clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
                logger.info("--> Performing a reroute ");
            attributes.put("zone", "zone_" + (j % 2));  
                    .put("cluster.routing.allocation.exclude.tag", "tag_1")
import org.opensearch.cluster.routing.ShardRouting;
                    Settings.builder()  
import org.opensearch.cluster.ClusterState;
                        greaterThanOrEqualTo(clusterConcurrentRecoveries)
                clusterState = excludeStrategy.reroute(clusterState, "reroute");  
                    .settings(settings(Version.CURRENT))
        }
                        equalTo("tag_1")
                .put("cluster.routing.allocation.exclude.tag", "tag_0")
                    .put("cluster.routing.allocation.awareness.attributes", "zone")
        List<Tuple<Integer, Integer>> srcTargetNodes = Collections.unmodifiableList(  
                );
                IndexMetadata.builder("test_" + i)  
                .metadata(metadata)  
                    assertThat(
import java.util.Map;  
                );
        for (Tuple<Integer, Integer> srcTargetNode : srcTargetNodes) {
            clusterState = initialStrategy.reroute(clusterState, "reroute");
            // Ensure all shards are started  
    private DiscoveryNodes.Builder setUpClusterNodes(int sourceNodes, int targetNodes) {
                assertThat(  
 * The OpenSearch Contributors require contributions made to  
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            }
import org.opensearch.cluster.metadata.Metadata;
                    );
            }  
            for (int counter = 0; counter < 3; counter++) {  
        );
import org.opensearch.cluster.ClusterName;
                // When srcNodes < targetNodes relocations go beyond the Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries limit as
                for (ShardRouting startedShard : clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
                clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(),
        Metadata.Builder metadataBuilder = Metadata.builder();  
            excludeStrategy = createAllocationService(  
        RoutingTable routingTable = initialRoutingTableBuilder.build();
        return nb;  
                excludeStrategy = createAllocationService(
    }
                        .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
                logger.info("--> Performing a reroute ");
import java.util.Arrays;
                        .put("cluster.routing.allocation.exclude.tag", "tag_1")  
            assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(0));  
 * Modifications Copyright OpenSearch Contributors. See  
            assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(0));
            );
                    .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))  
import org.opensearch.cluster.metadata.IndexMetadata;
                    equalTo(expectedClusterConcurrentRecoveries)  
            }
    public void testClusterConcurrentRecoveries() {
            );
                excludeStrategy = createAllocationService(
        }
                    .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))  
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
        int clusterConcurrentRecoveries = -1;  
            excludeStrategy = createAllocationService(  
                    equalTo(clusterConcurrentRecoveries)
            nb.add(newNode("node_t_" + j, attributes));
                    .put("cluster.routing.allocation.exclude.tag", "tag_1")
                if (srcNodes >= targetNodes) {  
                }
            logger.info("Setting up tests for src node {} and target node {}", srcNodes, targetNodes);  
        RoutingTable.Builder initialRoutingTableBuilder = RoutingTable.builder();  
            initialRoutingTableBuilder.addAsNew(metadata.index("test_" + i));  
        );  
            }
            logger.info("--> Bumping cluster_concurrent_recoveries up and re-routing ");  
            Settings.builder()  
                assertThat(  
            // Ensure all shards are started
                        clusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag"),  
            // Initialize shards
                    clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
                    .build()  
                        .put("cluster.routing.allocation.awareness.attributes", "zone")  
                    .build()  
 *
 * GitHub history for details.
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", "8")
                    clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
                equalTo((replicaShards + 1) * primaryShards * numberIndices)  
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {  
                Settings.builder()
        for (int i = 0; i < numberIndices; i++) {
                        clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
 * compatible open source license.
        int nodeConcurrentRecoveries = 4;
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
                    assertThat(  
            logger.info("--> Starting replica shards");
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
            for (int counter = 0; counter < 3; counter++) {
                    );
                    );
                // outgoing recoveries happens target nodes which anyways doesn't get throttled on incoming recoveries
                assertThat(
                        .build()  
