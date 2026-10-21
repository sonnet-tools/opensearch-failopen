    public void testBackupElectionToPrimaryWhenPrimaryCanBeAllocatedToAnotherNode() {
        assertThat(routingNodes.node("node1"), nullValue());
        // verify where the primary is
        logger.info("Adding third node and reroute and kill first node");
            .build();
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        logger.info("Start the primary shard (on node1)");
import org.opensearch.cluster.routing.RoutingNodes;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        AllocationService strategy = createAllocationService(
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3")).remove("node1"))
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(1));
 * this work for additional information regarding copyright
 * GitHub history for details.
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(3)); // 2 replicas and one primary
 * under the License.
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Metadata metadata = Metadata.builder()
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
 * compatible open source license.
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.node(nodeIdRemaining).shardsWithState(STARTED).get(0).primary(), equalTo(true));
        routingTable = clusterState.routingTable();
        logger.info("Adding two nodes and performing rerouting");
        assertThat(routingNodes.shardsWithState(INITIALIZING).size(), equalTo(2));
/*
 * software distributed under the License is distributed on an
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = ClusterState.builder(clusterState)
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.Version;
            .build();
            .build();
 * Licensed to Elasticsearch under one or more contributor
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        logger.info("--> fail node with primary");
    private final Logger logger = LogManager.getLogger(PrimaryElectionRoutingTests.class);
        AllocationService allocation = createAllocationService(
        logger.info("Start the backup shard (on node2)");
 * KIND, either express or implied.  See the License for the
}
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(nodeIdRemaining))).build();
            .metadata(metadata)
        assertThat(clusterState.metadata().index("test").primaryTerm(0), equalTo(1L));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node2"));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
 *
            .build();
        logger.info("Building initial routing table");
 * Unless required by applicable law or agreed to in writing,
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
 * not use this file except in compliance with the License.
            .routingTable(routingTable)
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
 * Modifications Copyright OpenSearch Contributors. See
        logger.info("Start the primary shards");
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        Metadata metadata = Metadata.builder()
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        logger.info("Building initial routing table");
import org.opensearch.cluster.routing.RoutingTable;
import static org.hamcrest.Matchers.nullValue;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(prevRoutingTable != routingTable, equalTo(true));
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
    public void testRemovingInitializingReplicasIfPrimariesFails() {
        logger.info("Adding two nodes and performing rerouting");
 * You may obtain a copy of the License at
import org.apache.logging.log4j.Logger;
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.common.settings.Settings;
        routingNodes = clusterState.getRoutingNodes();
package org.opensearch.cluster.routing.allocation;
 */
        clusterState = allocation.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(1));
        );
            .build();
import org.apache.logging.log4j.LogManager;
        String nodeIdRemaining = nodeIdToFail.equals("node1") ? "node2" : "node1";
    }
        assertThat(clusterState.metadata().index("test").primaryTerm(0), equalTo(2L));
public class PrimaryElectionRoutingTests extends OpenSearchAllocationTestCase {
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .metadata(metadata)
 * The OpenSearch Contributors require contributions made to
            .build();
        routingNodes = clusterState.getRoutingNodes();
 * ownership. Elasticsearch licenses this file to you under
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(routingTable.index("test").shards().size(), equalTo(1));
/*
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(2));
/*
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(clusterState.metadata().index("test").primaryTerm(0), equalTo(2L));
import org.opensearch.cluster.ClusterState;
        RoutingTable prevRoutingTable = clusterState.routingTable();
        assertThat(routingTable.index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node3"));
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.metadata.Metadata;
        routingNodes = clusterState.getRoutingNodes();
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(clusterState.metadata().index("test").primaryTerm(1), equalTo(1L));
        assertThat(routingNodes.shardsWithState(INITIALIZING).size(), equalTo(0));
            .routingTable(routingTable)
        clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = strategy.reroute(clusterState, "reroute");
        String nodeIdToFail = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        assertThat(routingTable.index("test").shard(0).primaryShard().currentNodeId(), equalTo("node2"));
    }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
 */
        // now, fail one node, while the replica is initializing, and it also holds a primary
 *
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
