        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(3)); // 2 replicas and one primary
 * The OpenSearch Contributors require contributions made to  
            .routingTable(routingTable)
    public void testRemovingInitializingReplicasIfPrimariesFails() {  
 * software distributed under the License is distributed on an
        logger.info("Adding third node and reroute and kill first node");
import org.opensearch.cluster.node.DiscoveryNodes;
 * Unless required by applicable law or agreed to in writing,
        String nodeIdToFail = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import static org.hamcrest.Matchers.equalTo;
        // now, fail one node, while the replica is initializing, and it also holds a primary  
            .build();
 *
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node2"));
        RoutingTable prevRoutingTable = clusterState.routingTable();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        logger.info("Adding two nodes and performing rerouting");
 * license agreements. See the NOTICE file distributed with
/*  
        // verify where the primary is  
        AllocationService strategy = createAllocationService(
        clusterState = ClusterState.builder(clusterState)
/*
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(clusterState.metadata().index("test").primaryTerm(0), equalTo(2L));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterState.metadata().index("test").primaryTerm(0), equalTo(1L));  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(1));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(prevRoutingTable != routingTable, equalTo(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .build();
 * specific language governing permissions and limitations
public class PrimaryElectionRoutingTests extends OpenSearchAllocationTestCase {
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        assertThat(routingTable.index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node3"));  
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
        clusterState = allocation.reroute(clusterState, "reroute");
        );  
import org.opensearch.cluster.routing.RoutingNodes;  
            .routingTable(routingTable)  
import org.opensearch.Version;  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
 * not use this file except in compliance with the License.
        assertThat(routingTable.index("test").shards().size(), equalTo(1));
        routingTable = clusterState.routingTable();
        clusterState = strategy.reroute(clusterState, "reroute");  
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.ClusterState;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        logger.info("Adding two nodes and performing rerouting");  
    public void testBackupElectionToPrimaryWhenPrimaryCanBeAllocatedToAnotherNode() {
        assertThat(routingNodes.node("node1"), nullValue());  
        assertThat(clusterState.metadata().index("test").primaryTerm(0), equalTo(2L));  
        Metadata metadata = Metadata.builder()
 * SPDX-License-Identifier: Apache-2.0
            .build();
    }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(nodeIdRemaining))).build();
        logger.info("Start the backup shard (on node2)");  
 * compatible open source license.
 * GitHub history for details.
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        logger.info("Building initial routing table");  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        routingNodes = clusterState.getRoutingNodes();
            .build();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3")).remove("node1"))  
package org.opensearch.cluster.routing.allocation;
        assertThat(routingTable.index("test").shard(0).primaryShard().currentNodeId(), equalTo("node2"));
 * this file be licensed under the Apache-2.0 license or a
 */  
        assertThat(routingNodes.shardsWithState(INITIALIZING).size(), equalTo(0));  
    private final Logger logger = LogManager.getLogger(PrimaryElectionRoutingTests.class);
        assertThat(routingNodes.shardsWithState(INITIALIZING).size(), equalTo(2));
 * under the License.  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        AllocationService allocation = createAllocationService(
        logger.info("--> fail node with primary");
import org.opensearch.cluster.metadata.Metadata;
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");  
 */  
            .build();  
        Metadata metadata = Metadata.builder()
            .metadata(metadata)  
 * this work for additional information regarding copyright
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        logger.info("Building initial routing table");
        );
        assertThat(routingNodes.node(nodeIdRemaining).shardsWithState(STARTED).get(0).primary(), equalTo(true));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(2));
import org.apache.logging.log4j.Logger;
        routingNodes = clusterState.getRoutingNodes();  
        String nodeIdRemaining = nodeIdToFail.equals("node1") ? "node2" : "node1";  
        clusterState = strategy.reroute(clusterState, "reroute");  
            .metadata(metadata)
import static org.hamcrest.Matchers.nullValue;
/*  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(1));
        logger.info("Start the primary shards");  
 */
import org.opensearch.cluster.metadata.IndexMetadata;  
 * the Apache License, Version 2.0 (the "License"); you may
        routingNodes = clusterState.getRoutingNodes();
 *
import org.opensearch.cluster.routing.RoutingTable;
            .build();  
        assertThat(clusterState.metadata().index("test").primaryTerm(1), equalTo(1L));
 *  
 * ownership. Elasticsearch licenses this file to you under  
    }
        logger.info("Start the primary shard (on node1)");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.Settings;
