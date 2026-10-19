        logger.info("Adding one node and performing rerouting");
 * this work for additional information regarding copyright
        assertThat(routingTable.index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
import org.opensearch.common.settings.Settings;
public class ReplicaAllocatedAfterPrimaryTests extends OpenSearchAllocationTestCase {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.cluster.metadata.Metadata;
        logger.info("Start all the primary shards");  
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertThat(routingTable.index("test").shard(0).replicaShards().size(), equalTo(1));
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(routingTable.index("test").shard(0).replicaShards().get(0).state(), equalTo(INITIALIZING));
 * compatible open source license.
        assertThat(routingTable.index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        assertThat(routingTable.index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(routingTable.index("test").shard(0).replicaShards().size(), equalTo(1));  
        );
 * under the License.  
 */
        assertThat(routingTable.index("test").shard(0).shards().get(1).state(), equalTo(UNASSIGNED));  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
 * specific language governing permissions and limitations
 */  
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = ClusterState.builder(clusterState)
        final String nodeHoldingReplica = routingTable.index("test").shard(0).replicaShards().get(0).currentNodeId();
        assertThat(routingTable.index("test").shard(0).shards().size(), equalTo(2));
import org.opensearch.cluster.routing.RoutingNodes;  
/*  
 * Unless required by applicable law or agreed to in writing,
        logger.info("Building initial routing table");
        assertThat(routingTable.index("test").shard(0).shards().size(), equalTo(2));  
        prevRoutingTable = routingTable;
import static org.hamcrest.Matchers.nullValue;  
        AllocationService strategy = createAllocationService(  
        assertThat(routingTable.index("test").shard(0).size(), equalTo(2));
        assertThat(routingTable.index("test").shards().size(), equalTo(1));  
import org.opensearch.cluster.ClusterState;
}
        assertThat(routingTable.index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        assertThat(routingTable.index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        Metadata metadata = Metadata.builder()  
        assertThat(routingTable.index("test").shard(0).shards().size(), equalTo(2));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
    public void testBackupIsAllocatedAfterPrimary() {
 *  
        routingTable = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node(nodeHoldingPrimary)).routingTable();  
 * not use this file except in compliance with the License.
 */  
/*
/*  
 * You may obtain a copy of the License at  
        assertThat(prevRoutingTable != routingTable, equalTo(true));  
        assertThat(routingTable.index("test").shard(0).shards().get(1).currentNodeId(), nullValue());
            .build();
        assertThat(routingTable.index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
package org.opensearch.cluster.routing.allocation;
        assertThat(routingTable.index("test").shard(0).primaryShard().state(), equalTo(INITIALIZING));  
        RoutingTable prevRoutingTable = routingTable;  
import static org.hamcrest.Matchers.not;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(routingTable.index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo(nodeHoldingReplica));
import org.apache.logging.log4j.Logger;
        final String nodeHoldingPrimary = routingTable.index("test").shard(0).primaryShard().currentNodeId();  
 * The OpenSearch Contributors require contributions made to  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
 * the Apache License, Version 2.0 (the "License"); you may
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
 *
import org.opensearch.Version;  
 * GitHub history for details.
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            .routingTable(routingTable)
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(nodeHoldingPrimary, not(equalTo(nodeHoldingReplica)));
        assertThat(routingTable.index("test").shards().size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();  
        assertThat(routingTable.index("test").shard(0).size(), equalTo(2));  
import org.apache.logging.log4j.LogManager;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(routingTable.index("test").shard(0).replicaShards().get(0).currentNodeId(), nullValue());
        assertThat(routingTable.index("test").shard(0).size(), equalTo(2));
import org.opensearch.cluster.metadata.IndexMetadata;  
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
            .build();
    private final Logger logger = LogManager.getLogger(ReplicaAllocatedAfterPrimaryTests.class);  
 * license agreements. See the NOTICE file distributed with
        assertThat(routingTable.index("test").shards().size(), equalTo(1));
        assertThat(prevRoutingTable != routingTable, equalTo(true));
            .metadata(metadata)
