                }
                    clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
                equalTo((replicaShards + 1) * primaryShards * numberIndices)
                        .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
            attributes.put("zone", "zone_" + (j % 2));
        Metadata.Builder metadataBuilder = Metadata.builder();
import org.opensearch.cluster.metadata.Metadata;
                    .settings(settings(Version.CURRENT))
                .build()
            for (int counter = 0; counter < 3; counter++) {
            assertThat(
                } else {
            logger.info("Setting up tests for src node {} and target node {}", srcNodes, targetNodes);
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
import org.opensearch.common.settings.Settings;
                    .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
            attributes.put("tag", "tag_" + 1);
                        .put("cluster.routing.allocation.awareness.attributes", "zone")
                    );
        AllocationService excludeStrategy = null;
                    equalTo(expectedClusterConcurrentRecoveries)
import org.opensearch.cluster.routing.allocation.AllocationService;
            logger.info("--> Bumping cluster_concurrent_recoveries up and re-routing ");
            assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(0));
        for (int i = 0; i < numberIndices; i++) {
            logger.info("--> Starting primary shards");
    public void testClusterConcurrentRecoveries() {
            logger.info("--> Starting replica shards");
                    Settings.builder()
import org.opensearch.cluster.ClusterState;
        for (int i = 1; i <= sourceNodes; i++) {
                for (ShardRouting startedShard : clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
            initialRoutingTableBuilder.addAsNew(metadata.index("test_" + i));
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
import java.util.List;
                        clusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag"),
            clusterConcurrentRecoveries = Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries;
                clusterState = excludeStrategy.reroute(clusterState, "reroute");
        for (int i = 0; i < numberIndices; i++) {
            for (int counter = 0; counter < 3; counter++) {
import org.opensearch.cluster.routing.RoutingTable;
            nb.add(newNode("node_t_" + j, attributes));
            );
            }
 * SPDX-License-Identifier: Apache-2.0
        for (Tuple<Integer, Integer> srcTargetNode : srcTargetNodes) {
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
            Map<String, String> attributes = new HashMap<>();
import org.opensearch.common.collect.Tuple;
                assertThat(
        }
            nb.add(newNode("node_s_" + i, attributes));
        List<Tuple<Integer, Integer>> srcTargetNodes = Collections.unmodifiableList(
/*
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
    private DiscoveryNodes.Builder setUpClusterNodes(int sourceNodes, int targetNodes) {
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    );
        int primaryShards = 5, replicaShards = 1, numberIndices = 12;
                .put("cluster.routing.allocation.awareness.attributes", "zone")
 */
            // Ensure all shards are started
            excludeStrategy = createAllocationService(
 */
                    .numberOfReplicas(replicaShards)
            }
                Settings.builder()
                );
public class ConcurrentRecoveriesAllocationDeciderTests extends OpenSearchAllocationTestCase {
                    .put("cluster.routing.allocation.awareness.attributes", "zone")
                    .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
                if (srcNodes >= targetNodes) {
                logger.info("--> Performing a reroute ");
            }
            int expectedClusterConcurrentRecoveries = Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries;
        AllocationService initialStrategy = createAllocationService(
                        .put("cluster.routing.allocation.awareness.attributes", "zone")
                .routingTable(routingTable)
        RoutingTable.Builder initialRoutingTableBuilder = RoutingTable.builder();
            clusterState = initialStrategy.reroute(clusterState, "reroute");
                    .build()
            int targetNodes = srcTargetNode.v2();
                        clusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag"),
                IndexMetadata.builder("test_" + i)
                excludeStrategy = createAllocationService(
 *
            attributes.put("zone", "zone_" + (i % 2));
        int clusterConcurrentRecoveries = -1;
    }
                    );
            Settings.builder()
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
            );
                );
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", "8")
import org.opensearch.cluster.node.DiscoveryNodes;
            clusterConcurrentRecoveries = clusterConcurrentRecoveries + randomInt(5);
        }
        );
            logger.info("--> Disabling cluster_concurrent_recoveries and re-routing ");
                    assertThat(
 * GitHub history for details.
        int nodeConcurrentRecoveries = 4;
                    .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
            Map<String, String> attributes = new HashMap<>();
            clusterConcurrentRecoveries = Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries;
        logger.info("--> adding nodes and starting shards");
                    assertThat(
                        clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
                        equalTo("tag_1")
                    clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
                // outgoing recoveries happens target nodes which anyways doesn't get throttled on incoming recoveries
            );
                    equalTo(clusterConcurrentRecoveries)
                logger.info("--> Performing a reroute ");
                    assertThat(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
            int srcNodes = srcTargetNode.v1();
/*
                Settings.builder()
        for (int j = 1; j <= targetNodes; j++) {
                .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
                );
        }
                // When srcNodes < targetNodes relocations go beyond the Math.min(srcNodes, targetNodes) * nodeConcurrentRecoveries limit as
                clusterState = excludeStrategy.reroute(clusterState, "reroute");
            metadataBuilder.put(
                }
                    .build()
 * this file be licensed under the Apache-2.0 license or a
            }
            clusterConcurrentRecoveries = clusterConcurrentRecoveries - randomInt(5);
            while (clusterState.getRoutingNodes().hasUnassignedShards()) {
                        .put("cluster.routing.allocation.exclude.tag", "tag_1")
                    clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
import java.util.Arrays;
            for (int counter = 0; counter < 3; counter++) {
                        equalTo(clusterConcurrentRecoveries)
                .nodes(setUpClusterNodes(srcNodes, targetNodes))
                .build();
                    .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
                        equalTo("tag_1")
            for (int counter = 0; counter < 3; counter++) {
                clusterState = excludeStrategy.reroute(clusterState, "reroute");
            assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(0));
 * compatible open source license.
                    equalTo(clusterConcurrentRecoveries)
                );
import org.opensearch.cluster.ClusterName;
                assertThat(
            excludeStrategy = createAllocationService(
            // Ensure all shards are started
        );
                    .put("cluster.routing.allocation.awareness.attributes", "zone")
                logger.info("--> Performing a reroute ");
 * Modifications Copyright OpenSearch Contributors. See
                clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(),
                        clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(),
import java.util.Map;
                clusterState = startInitializingShardsAndReroute(initialStrategy, clusterState);
    }
                    .numberOfShards(primaryShards)
                    .put("cluster.routing.allocation.exclude.tag", "tag_1")
 * The OpenSearch Contributors require contributions made to
        RoutingTable routingTable = initialRoutingTableBuilder.build();
                .put("cluster.routing.allocation.exclude.tag", "tag_0")
            Arrays.<Tuple<Integer, Integer>>asList(new Tuple(10, 4), new Tuple(4, 10), new Tuple(10, 10))
            }
            attributes.put("tag", "tag_" + 0);
            while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
            // Initialize shards
            }
import org.opensearch.Version;
                        .build()
}
                        .build()
                .metadata(metadata)
                    assertThat(
        logger.info("Building initial routing table");
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                        greaterThanOrEqualTo(clusterConcurrentRecoveries)
import java.util.HashMap;
                clusterState = excludeStrategy.reroute(clusterState, "reroute");
        Metadata metadata = metadataBuilder.build();
import org.opensearch.cluster.metadata.IndexMetadata;
                        .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(nodeConcurrentRecoveries))
                    Settings.builder()
        }
                );
                assertThat(
                        .put("cluster.routing.allocation.exclude.tag", "tag_1")
            }
import static org.hamcrest.Matchers.equalTo;
                    .put("cluster.routing.allocation.exclude.tag", "tag_1")
            }
                logger.info("--> Performing a reroute ");
import org.opensearch.cluster.routing.ShardRoutingState;
                for (ShardRouting startedShard : clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
            // Ensure all shards are started
package org.opensearch.cluster.routing.allocation.decider;
                }
import org.opensearch.cluster.routing.ShardRouting;
        return nb;
import java.util.Collections;
            }
                    );
            );
                excludeStrategy = createAllocationService(
        }
