        RoutingNodes routingNodes = clusterState.getRoutingNodes();
import static org.hamcrest.Matchers.equalTo;  
                "kill the node [{}] of the primary shard for the relocating replica",
        );  
 */  
import org.opensearch.Version;  
            .routingTable(initialRoutingTable)  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        if (clusterState.routingTable().index("test").shard(0).replicaShards().get(0).relocating()) {
            .build();  
        }
 * The OpenSearch Contributors require contributions made to  
    public void testElectReplicaAsPrimaryDuringRelocation() {  
package org.opensearch.cluster.routing.allocation;
            clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
 */  
            .build();  
        logger.info("Adding two nodes and performing rerouting");  
import org.apache.logging.log4j.LogManager;
 * the Apache License, Version 2.0 (the "License"); you may
    private final Logger logger = LogManager.getLogger(ElectReplicaAsPrimaryDuringRelocationTests.class);
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(indexShardRoutingTable.primaryShard().currentNodeId()))
import org.apache.logging.log4j.Logger;
            assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().active(), equalTo(true));
        logger.info("Start the replica shards");  
        clusterState = ClusterState.builder(clusterState)
 * Unless required by applicable law or agreed to in writing,
        logger.info("Start the primary shards");  
            indexShardRoutingTable = clusterState.routingTable().index("test").shard(1);
import org.opensearch.cluster.routing.RoutingNodes;
 * this file be licensed under the Apache-2.0 license or a
        } else if (clusterState.routingTable().index("test").shard(1).replicaShards().get(0).relocating()) {  
/*
 * software distributed under the License is distributed on an
/*  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            );  
        assertThat(resultingState, not(equalTo(clusterState)));
        if (indexShardRoutingTable != null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        clusterState = resultingState;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("Start another node and perform rerouting");
                indexShardRoutingTable.primaryShard().currentNodeId()
            logger.info("make sure all the primary shards are active");  
 */
            logger.info(  
        // we might have primary relocating, and the test is only for replicas, so only test in the case of replica allocation
 * You may obtain a copy of the License at  
            indexShardRoutingTable = clusterState.routingTable().index("test").shard(0);
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
import org.opensearch.common.settings.Settings;  
/*  
 * this work for additional information regarding copyright
        logger.info("find the replica shard that gets relocated");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
import static org.hamcrest.Matchers.not;
        logger.info("Building initial routing table");
 *  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));  
 * compatible open source license.
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(2));
        AllocationService strategy = createAllocationService(
}
import org.opensearch.cluster.node.DiscoveryNodes;
                .build();  
import org.opensearch.cluster.routing.RoutingTable;
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 *
        ClusterState resultingState = startInitializingShardsAndReroute(strategy, clusterState);
        Metadata metadata = Metadata.builder()
        clusterState = strategy.reroute(clusterState, "reroute");  
            .metadata(metadata)
import org.opensearch.cluster.ClusterState;
            assertThat(clusterState.routingTable().index("test").shard(1).primaryShard().active(), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(2));
 *
            clusterState = ClusterState.builder(clusterState)
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            .build();
 * ownership. Elasticsearch licenses this file to you under  
        }  
public class ElectReplicaAsPrimaryDuringRelocationTests extends OpenSearchAllocationTestCase {  
import org.opensearch.cluster.metadata.Metadata;
 * specific language governing permissions and limitations
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        IndexShardRoutingTable indexShardRoutingTable = null;  
 * KIND, either express or implied.  See the License for the
