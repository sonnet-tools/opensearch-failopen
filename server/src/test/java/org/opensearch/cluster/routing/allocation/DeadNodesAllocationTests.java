        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
import org.opensearch.cluster.node.DiscoveryNodes;
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
            .build();
                    0,  
        logger.info("--> adding 2 nodes on same rack and do rerouting");
                new MoveAllocationCommand(
 *  
            false,
 * the Apache License, Version 2.0 (the "License"); you may
        String origReplicaNodeId = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
 * KIND, either express or implied.  See the License for the
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            ),
 * GitHub history for details.
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
import org.opensearch.Version;  
        String nodeIdRemaining = nodeIdToFail.equals("node1") ? "node2" : "node1";
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));  
            .build();
    }  
        clusterState = ClusterState.builder(clusterState)  
        logger.info("--> fail primary shard recovering instance on 'origPrimaryNodeId' being relocated");
        logger.info("--> moving primary shard to node3");  
            false,
 *
package org.opensearch.cluster.routing.allocation;
        // starting primaries  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        logger.info("--> fail node with primary");  
            .build();
        logger.info("--> fail primary shard recovering instance on node3 being initialized by killing node3");
import org.opensearch.cluster.metadata.IndexMetadata;  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
            .build();
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
            .build();
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
                .build()
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        clusterState = allocation.reroute(clusterState, "reroute");
        clusterState = allocation.reroute(clusterState, "reroute");
    public void testDeadNodeWhileRelocatingOnToNode() {
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
            .routingTable(routingTable)  
            .routingTable(routingTable)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
        // starting replicas  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
                    "test",
            .nodes(DiscoveryNodes.builder().add(newNode(origPrimaryNodeId)).add(newNode(origReplicaNodeId)))  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
public class DeadNodesAllocationTests extends OpenSearchAllocationTestCase {  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        // starting replicas
            .build();
            ),
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
        Metadata metadata = Metadata.builder()
        );
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
            .metadata(metadata)
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node3")).add(newNode(origReplicaNodeId)))  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.LogManager;
            false  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("--> verifying all is allocated");
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
                )  
        logger.info("--> building initial routing table");
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));  
import org.opensearch.cluster.routing.RoutingTable;  
        AllocationService.CommandsResult commandsResult = allocation.reroute(
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));  
/*
        String nodeIdToFail = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
                    "test",
        // starting primaries  
            .build();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        AllocationService allocation = createAllocationService(
            clusterState,
                .build()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        assertThat(clusterState.getRoutingNodes().node(nodeIdRemaining).iterator().next().state(), equalTo(STARTED));
        logger.info("--> adding 2 nodes on same rack and do rerouting");
 * Licensed to Elasticsearch under one or more contributor  
        clusterState = ClusterState.builder(clusterState)
 * You may obtain a copy of the License at  
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
        // starting primaries
        String origPrimaryNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        assertThat(clusterState.getRoutingNodes().node(nodeIdRemaining).iterator().next().primary(), equalTo(true));
 *
 */
        logger.info("--> verifying all is allocated");
        );
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
/*  
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
            .build();  
        assertThat(clusterState.getRoutingNodes().node(origReplicaNodeId).iterator().next().state(), equalTo(STARTED));
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    "node3"
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;  
            clusterState,
        Metadata metadata = Metadata.builder()  
            .metadata(metadata)
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        AllocationService.CommandsResult commandsResult = allocation.reroute(
                .build()
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(nodeIdRemaining))).build();  
            false  
        logger.info("--> verifying all is allocated");  
}
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().node(origReplicaNodeId).iterator().next().state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
import static org.hamcrest.Matchers.not;
        logger.info("--> building initial routing table");
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.metadata.Metadata;
            new AllocationCommands(  
import static org.hamcrest.Matchers.equalTo;  
        );
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
 * not use this file except in compliance with the License.
    public void testSimpleDeadNodeOnStartedPrimaryShard() {  
        AllocationService allocation = createAllocationService(  
                    "node3"
        );
        );  
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
                    0,  
            new AllocationCommands(  
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
 * this work for additional information regarding copyright
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));  
        logger.info("--> adding 2 nodes on same rack and do rerouting");  
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
        clusterState = allocation.reroute(clusterState, "reroute");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        logger.info("--> moving primary shard to node3");  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
            .build();  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                new MoveAllocationCommand(
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
 * license agreements. See the NOTICE file distributed with
        String origReplicaNodeId = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
    }  
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        clusterState = commandsResult.getClusterState();  
        AllocationService allocation = createAllocationService(  
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        clusterState = commandsResult.getClusterState();  
        // starting replicas
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));  
            Settings.builder()
    public void testDeadNodeWhileRelocatingOnFromNode() {
        clusterState = allocation.reroute(clusterState, "reroute");
 */  
        clusterState = ClusterState.builder(clusterState)  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
 */  
import org.apache.logging.log4j.Logger;
        logger.info("--> building initial routing table");
        String origPrimaryNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();  
            .build();  
    private final Logger logger = LogManager.getLogger(DeadNodesAllocationTests.class);
import org.opensearch.cluster.ClusterState;
        clusterState = ClusterState.builder(clusterState)
 * under the License.  
            .routingTable(routingTable)
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        logger.info("--> adding additional node");
/*  
    }  
        logger.info("--> adding additional node");
                )  
 * ownership. Elasticsearch licenses this file to you under  
        clusterState = allocation.reroute(clusterState, "reroute");
