        logger.info("--> building initial routing table");
/*
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        clusterState = commandsResult.getClusterState();
        logger.info("--> moving primary shard to node3");
        logger.info("--> verifying all is allocated");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                    "node3"
        assertThat(clusterState.getRoutingNodes().node(origReplicaNodeId).iterator().next().state(), equalTo(STARTED));
                    0,
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testDeadNodeWhileRelocatingOnToNode() {
        // starting primaries
package org.opensearch.cluster.routing.allocation;
        );
        );
import org.apache.logging.log4j.LogManager;
        clusterState = allocation.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
 */
        );
                    "test",
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        String nodeIdRemaining = nodeIdToFail.equals("node1") ? "node2" : "node1";
        // starting primaries
                new MoveAllocationCommand(
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            .build();
    private final Logger logger = LogManager.getLogger(DeadNodesAllocationTests.class);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        logger.info("--> fail primary shard recovering instance on node3 being initialized by killing node3");
 */
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
 *
        );
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
        String origReplicaNodeId = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
            .build();
            false
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
                .build()
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
                    "test",
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
            .build();
/*
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
                )
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
            ),
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.node.DiscoveryNodes;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
/*
                .build()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                .build()
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                    "node3"
 */
        String origReplicaNodeId = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
                new MoveAllocationCommand(
        AllocationService.CommandsResult commandsResult = allocation.reroute(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
 * You may obtain a copy of the License at
        AllocationService allocation = createAllocationService(
        String origPrimaryNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            .nodes(DiscoveryNodes.builder().add(newNode(origPrimaryNodeId)).add(newNode(origReplicaNodeId)))
        logger.info("--> verifying all is allocated");
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
            false,
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
            .routingTable(routingTable)
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = ClusterState.builder(clusterState)
        String origPrimaryNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
 * this file be licensed under the Apache-2.0 license or a
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        String nodeIdToFail = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        logger.info("--> adding 2 nodes on same rack and do rerouting");
                )
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
import org.opensearch.Version;
 *
 * not use this file except in compliance with the License.
 * under the License.
            ),
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        logger.info("--> building initial routing table");
 * Licensed to Elasticsearch under one or more contributor
        assertThat(clusterState.getRoutingNodes().node(nodeIdRemaining).iterator().next().state(), equalTo(STARTED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(nodeIdRemaining))).build();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .metadata(metadata)
            .build();
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
import org.opensearch.cluster.metadata.Metadata;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testSimpleDeadNodeOnStartedPrimaryShard() {
    }
            .routingTable(routingTable)
            clusterState,
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
        clusterState = ClusterState.builder(clusterState)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = allocation.reroute(clusterState, "reroute");
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        // starting replicas
            .build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        logger.info("--> adding 2 nodes on same rack and do rerouting");
            new AllocationCommands(
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
import org.apache.logging.log4j.Logger;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(STARTED));
        clusterState = allocation.reroute(clusterState, "reroute");
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .build();
        assertThat(clusterState.getRoutingNodes().node(nodeIdRemaining).iterator().next().primary(), equalTo(true));
public class DeadNodesAllocationTests extends OpenSearchAllocationTestCase {
 * this work for additional information regarding copyright
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            .metadata(metadata)
import static org.hamcrest.Matchers.not;
            false,
        logger.info("--> adding additional node");
            clusterState,
            .build();
        // starting primaries
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .build();
            new AllocationCommands(
 *
        AllocationService allocation = createAllocationService(
            .build();
        logger.info("--> fail primary shard recovering instance on 'origPrimaryNodeId' being relocated");
        assertThat(clusterState.getRoutingNodes().node(origReplicaNodeId).iterator().next().state(), equalTo(STARTED));
}
        );
        AllocationService.CommandsResult commandsResult = allocation.reroute(
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
    public void testDeadNodeWhileRelocatingOnFromNode() {
        logger.info("--> verifying all is allocated");
            .build();
        logger.info("--> adding 2 nodes on same rack and do rerouting");
import org.opensearch.cluster.routing.RoutingTable;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import org.opensearch.common.settings.Settings;
            false
        // starting replicas
            .nodes(DiscoveryNodes.builder().add(newNode("node3")).add(newNode(origReplicaNodeId)))
                    0,
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
    }
            Settings.builder()
        logger.info("--> moving primary shard to node3");
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
 * compatible open source license.
        clusterState = ClusterState.builder(clusterState)
        clusterState = allocation.reroute(clusterState, "reroute");
            .routingTable(routingTable)
        clusterState = allocation.reroute(clusterState, "reroute");
 * ownership. Elasticsearch licenses this file to you under
        // starting replicas
        logger.info("--> fail node with primary");
        logger.info("--> building initial routing table");
        logger.info("--> adding additional node");
        clusterState = commandsResult.getClusterState();
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        AllocationService allocation = createAllocationService(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        Metadata metadata = Metadata.builder()
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        Metadata metadata = Metadata.builder()
    }
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
 * GitHub history for details.
