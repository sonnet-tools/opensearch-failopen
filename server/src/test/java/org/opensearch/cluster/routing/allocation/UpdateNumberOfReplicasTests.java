 * this file be licensed under the Apache-2.0 license or a
            clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(),
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(1).state(), equalTo(UNASSIGNED));  
        newState = startInitializingShardsAndReroute(strategy, newState);
        assertEquals(STARTED, shardRoutingTable.shards().get(2).state());  
import org.opensearch.cluster.routing.ShardRouting;  
        IndexShardRoutingTable shardRoutingTable = routingTable.index("test").shard(0);
 */  
    }  
 * The OpenSearch Contributors require contributions made to  
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).size(), equalTo(2));
        logger.info("Start all the primary shards");
            .routingTable(routingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
        assertEquals(1, shardRoutingTable.replicaShards().size());  
            .build();
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).state(), STARTED);  
        newState = strategy.reroute(clusterState, "reroute");  
    }
        clusterState = strategy.reroute(clusterState, "reroute");  
        IndexMetadata indexMetadata = clusterState.metadata().index("test");
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(1).currentNodeId(), nullValue());
        assertNotEquals(nodeHoldingReplica, nodeHoldingSearchReplica);  
        logger.info("Add another node and start the added replica");  
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);  
        logger.info("Adding three nodes and performing rerouting");  
        assertEquals(2, shardRoutingTable.writerReplicas().size());
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(2).state());  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        final String nodeHoldingPrimary = shardRoutingTable.primaryShard().currentNodeId();  
        );  
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
package org.opensearch.cluster.routing.allocation;
        assertEquals(shardRoutingTable.replicaShards().get(0).state(), STARTED);  
        assertEquals(shardRoutingTable.replicaShards().get(0).currentNodeId(), nodeHoldingReplica);
            .routingTable(routingTable)
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(0).state());
        assertEquals(existingReplica.currentNodeId(), nodeHoldingReplica);
        assertEquals(1, routingTable.index("test").shards().size());
        // remove both replicas and assert search replica is unchanged  
        indexMetadata = clusterState.metadata().index("test");  
            .build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNotEquals(newState, clusterState);
}  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo(nodeHoldingReplica));  
            .metadata(metadata)  
        // remove both replicas and assert search replica is unchanged
        assertEquals(shardRoutingTable.writerReplicas().get(0).state(), STARTED);
                    .numberOfSearchReplicas(1)
        logger.info("now remove a replica");
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(2, indices).build();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertEquals(  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(3));
        final String[] indices = { "test" };
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(1).state(), equalTo(UNASSIGNED));
            .build();
        assertEquals("There are two replicas one search and one write", 2, shardRoutingTable.replicaShards().size());  
            assertEquals(replicaShard.state(), STARTED);
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
                    .numberOfReplicas(1)
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
import static org.hamcrest.Matchers.nullValue;  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(3));  
        );
import static org.hamcrest.Matchers.anyOf;  
        assertNull(shardRoutingTable.shards().get(2).currentNodeId());  
 *
import org.opensearch.cluster.routing.RoutingTable;
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfSearchReplicas(2, indices).build();  
                    .numberOfShards(1)
        clusterState = newState;
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState)  
        assertEquals(STARTED, shardRoutingTable.shards().get(1).state());  
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);  
        final String nodeHoldingSearchReplica = shardRoutingTable.searchOnlyReplicas().get(0).currentNodeId();
        final String nodeHoldingReplica = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
        );
        clusterState = ClusterState.builder(clusterState)
    public void testUpdateNumberOfReplicas() {
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(3));
        assertEquals(0, indexMetadata.getNumberOfReplicas());
        assertEquals(4, shardRoutingTable.size());
            .metadata(metadata)
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfSearchReplicas(0, indices).build();
        clusterState = newState;
        assertEquals(
        clusterState = ClusterState.builder(clusterState)
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).get(0).currentNodeId(),  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();  
        );
        assertEquals(3, shardRoutingTable.size());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));  
            equalTo(nodeHoldingReplica)
        );  
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = strategy.reroute(clusterState, "reroute");
            1
        assertNotEquals(newState, clusterState);  
 *
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(2).state());
        assertNotEquals(newState, clusterState);
        assertThat(
    }
 * KIND, either express or implied.  See the License for the
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
        assertThat(newState, equalTo(clusterState));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(2));
    public void testUpdateSearchReplicasDoesNotImpactRegularReplicas() {
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(0, indices).build();
        assertEquals(0, shardRoutingTable.searchOnlyReplicas().size());
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
        );  
        assertEquals(2, shardRoutingTable.searchOnlyReplicas().size());  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
        assertEquals("There are three shards as part of the shard routing table", 3, shardRoutingTable.size());
import static org.hamcrest.Matchers.equalTo;
        assertEquals(STARTED, shardRoutingTable.shards().get(2).state());
        Metadata metadata = Metadata.builder()
        assertTrue(shardRoutingTable.replicaShards().stream().allMatch(r -> r.state().equals(STARTED)));  
        assertNull(shardRoutingTable.shards().get(2).currentNodeId());
        assertEquals(1, indexMetadata.getNumberOfReplicas());  
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
        newState = startInitializingShardsAndReroute(strategy, newState);  
        // 1 primary, 1 replica, 1 search replica
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(1).state());
 * GitHub history for details.
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
/*  
            clusterState.routingTable().index("test").shards().size(),
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);  
        logger.info("Start all the primary shards");  
        assertEquals(0, indexMetadata.getNumberOfSearchOnlyReplicas());
        final String nodeHoldingPrimary = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
 * ownership. Elasticsearch licenses this file to you under  
        assertNotEquals(nodeHoldingPrimary, nodeHoldingReplica);
        assertThat(initialRoutingTable.index("test").shard(0).shards().size(), equalTo(2));
                IndexMetadata.builder("test")
            .build();  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);  
        logger.info("Start all the primary shards");
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).state(), STARTED);
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);  
        assertEquals(1, indexMetadata.getNumberOfSearchOnlyReplicas());  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertNotEquals(nodeHoldingPrimary, nodeHoldingSearchReplica);
        logger.info("Adding two nodes and performing rerouting");
        updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(1, indices).build();  
 * Unless required by applicable law or agreed to in writing,
        assertEquals("There are three shards as part of the shard routing table", 3, shardRoutingTable.size());
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(2));
        final String nodeHoldingSearchReplica = shardRoutingTable.searchOnlyReplicas().get(0).currentNodeId();
        );
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        assertEquals(1, shardRoutingTable.replicaShards().size());
        final String nodeHoldingReplica = shardRoutingTable.writerReplicas().get(0).currentNodeId();
 * the Apache License, Version 2.0 (the "License"); you may
        assertNull(shardRoutingTable.shards().get(1).currentNodeId());  
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).state(), STARTED);
 * not use this file except in compliance with the License.
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(0).state());
/*  
        assertNotEquals(newState, clusterState);  
import static org.hamcrest.Matchers.not;
            1  
 * this work for additional information regarding copyright
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        assertEquals(STARTED, shardRoutingTable.shards().get(1).state());
        logger.info("Building initial routing table");  
        logger.info("do a reroute, should remain the same");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(  
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertEquals(1, indexMetadata.getNumberOfReplicas());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        logger.info("Add another node and start the added replica");  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
        clusterState = strategy.reroute(clusterState, "reroute");
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(2, indices).build();
 * Licensed to Elasticsearch under one or more contributor  
        final String[] indices = { "test" };  
        assertEquals(4, shardRoutingTable.size());  
            )  
        assertNotEquals(nodeHoldingPrimary, nodeHoldingSearchReplica);  
            .build();
        assertEquals(existingReplica.state(), STARTED);
            .put(
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(2, indices).build();
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = newState;
        assertEquals(newReplica.state(), STARTED);
        Metadata metadata = Metadata.builder()  
        newState = strategy.reroute(clusterState, "reroute");
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newSearchNode("node3")))
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        logger.info("add another replica");  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
            .build();  
 * compatible open source license.
            )
public class UpdateNumberOfReplicasTests extends OpenSearchAllocationTestCase {
        logger.info("Building initial routing table");
        logger.info("Adding two nodes and performing rerouting");
        AllocationService strategy = createAllocationService(  
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterState = newState;
        assertEquals(0, shardRoutingTable.writerReplicas().size());
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
    public void testUpdateNumberOfReplicasDoesNotImpactSearchReplicas() {
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node4")))
        );
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));  
        final String[] indices = { "test" };
import org.opensearch.cluster.node.DiscoveryNodes;  
        ShardRouting existingReplica = shardRoutingTable.writerReplicas().get(0);  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newSearchNode("node3")))
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(0, indices).build();
        AllocationService strategy = createAllocationService(
            "There is a single routing shard routing table in the cluster",  
import org.apache.logging.log4j.Logger;
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));  
        assertNull(shardRoutingTable.shards().get(1).currentNodeId());
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
 * specific language governing permissions and limitations
        logger.info("Start all the replica shards");
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(2));  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
        assertThat(nodeHoldingPrimary, not(equalTo(nodeHoldingReplica)));  
        assertEquals(2, indexMetadata.getNumberOfSearchOnlyReplicas());
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        assertNull(shardRoutingTable.shards().get(0).currentNodeId());
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfSearchReplicas(0, indices).build();  
            assertEquals(replicaShard.state(), STARTED);
        clusterState = newState;  
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(INITIALIZING).get(0).currentNodeId(),  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo(nodeHoldingReplica));
        assertThat(  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        assertEquals(1, shardRoutingTable.writerReplicas().size());  
        logger.info("Building initial routing table");
        assertEquals(2, indexMetadata.getNumberOfReplicas());
                    .numberOfShards(1)  
            clusterState.routingTable().index("test").shards().size(),
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));  
        assertEquals(2, shardRoutingTable.size());
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();  
        indexMetadata = clusterState.metadata().index("test");
        );  
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(1));
        assertNotEquals(nodeHoldingPrimary, nodeHoldingReplica);
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
            .build();
        assertThat(  
        final String nodeHoldingPrimary = shardRoutingTable.primaryShard().currentNodeId();
        Metadata metadata = Metadata.builder()  
        }  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        final String nodeHoldingReplica = shardRoutingTable.writerReplicas().get(0).currentNodeId();  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("Add another node and start the added replica");  
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(1).state(), UNASSIGNED);
 * license agreements. See the NOTICE file distributed with
        IndexMetadata indexMetadata = clusterState.metadata().index("test");
                    .numberOfReplicas(1)
        assertThat(
        assertThat(initialRoutingTable.index("test").shards().size(), equalTo(1));
            anyOf(equalTo(nodeHoldingReplica), equalTo("node3"))
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(shardRoutingTable.replicaShards().stream().allMatch(r -> r.state().equals(STARTED)));
        assertNotEquals(nodeHoldingReplica, nodeHoldingSearchReplica);
        );
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(1).state());  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
    private final Logger logger = LogManager.getLogger(UpdateNumberOfReplicasTests.class);  
        IndexShardRoutingTable shardRoutingTable = routingTable.index("test").shard(0);  
        logger.info("Start all the replica and search shards");  
        assertEquals(1, routingTable.index("test").shards().size());
        logger.info("Start all the replica and search shards");
 * under the License.  
        // 1 primary, 1 replica, 1 search replica  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    .numberOfSearchReplicas(1)  
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).size(), equalTo(1));
 * You may obtain a copy of the License at  
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertEquals(2, shardRoutingTable.size());
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).currentNodeId(), nodeHoldingSearchReplica);
            .routingTable(initialRoutingTable)
        assertNull(shardRoutingTable.shards().get(0).currentNodeId());
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);
        logger.info("add another replica");
        AllocationService strategy = createAllocationService(  
 *  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
        }
        newState = strategy.reroute(clusterState, "reroute");
        logger.info("add another replica");
        assertEquals(3, shardRoutingTable.replicaShards().size());  
            equalTo("node3")
import org.opensearch.cluster.ClusterName;
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        ShardRouting newReplica = shardRoutingTable.writerReplicas().get(0);  
            "There is a single routing shard routing table in the cluster",
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(2, indices).build();  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).get(0).currentNodeId(),
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertEquals("There are two replicas one search and one write", 2, shardRoutingTable.replicaShards().size());
        assertEquals(3, shardRoutingTable.replicaShards().size());
/*
 */
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertEquals(STARTED, shardRoutingTable.shards().get(0).state());
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfSearchReplicas(2, indices).build();
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        clusterState = newState;
import org.opensearch.cluster.ClusterState;
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(2));
        assertEquals(3, shardRoutingTable.size());
 * software distributed under the License is distributed on an
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
import org.apache.logging.log4j.LogManager;
        assertEquals(1, shardRoutingTable.writerReplicas().size());
        assertThat(newState, not(equalTo(clusterState)));  
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        for (ShardRouting replicaShard : shardRoutingTable.replicaShards()) {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(  
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);
                    .settings(settings(Version.CURRENT))
        assertEquals(2, shardRoutingTable.replicaShards().size());
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));  
                    .settings(settings(Version.CURRENT))  
 */  
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(1, indices).build();
        for (ShardRouting replicaShard : shardRoutingTable.replicaShards()) {  
            anyOf(equalTo(nodeHoldingReplica), equalTo("node3"))
import org.opensearch.common.settings.Settings;
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).get(1).currentNodeId(),
        assertThat(initialRoutingTable.index("test").shard(0).size(), equalTo(2));  
        clusterState = newState;  
            anyOf(equalTo(nodeHoldingReplica), equalTo("node3"))
        assertEquals(1, indexMetadata.getNumberOfSearchOnlyReplicas());  
            .build();  
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
        assertEquals(STARTED, shardRoutingTable.shards().get(0).state());
import org.opensearch.Version;  
        assertEquals(2, shardRoutingTable.replicaShards().size());  
            .build();
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShardsWithState(INITIALIZING).size(), equalTo(1));
            .metadata(metadata)
                IndexMetadata.builder("test")
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
