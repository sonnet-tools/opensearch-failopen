        assertEquals(shardRoutingTable.replicaShards().get(0).state(), STARTED);
                    .numberOfSearchReplicas(1)
        // 1 primary, 1 replica, 1 search replica
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        IndexShardRoutingTable shardRoutingTable = routingTable.index("test").shard(0);
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertNull(shardRoutingTable.shards().get(0).currentNodeId());
                    .numberOfReplicas(1)
 */
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(3));
            .routingTable(routingTable)
 * specific language governing permissions and limitations
        assertEquals(shardRoutingTable.replicaShards().get(0).currentNodeId(), nodeHoldingReplica);
 * license agreements. See the NOTICE file distributed with
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(2).state());
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        assertEquals(1, indexMetadata.getNumberOfReplicas());
 * this work for additional information regarding copyright
        ShardRouting newReplica = shardRoutingTable.writerReplicas().get(0);
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(1).state(), equalTo(UNASSIGNED));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo(nodeHoldingReplica));
            1
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
        assertEquals(1, shardRoutingTable.replicaShards().size());
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(2, indices).build();
                    .settings(settings(Version.CURRENT))
        clusterState = ClusterState.builder(clusterState)
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
import org.apache.logging.log4j.Logger;
package org.opensearch.cluster.routing.allocation;
        assertNotEquals(newState, clusterState);
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(0).state());
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            equalTo("node3")
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        logger.info("Add another node and start the added replica");
        assertEquals(STARTED, shardRoutingTable.shards().get(0).state());
        assertThat(newState, equalTo(clusterState));
        }
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
        logger.info("add another replica");
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).state(), STARTED);
        final String[] indices = { "test" };
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
import org.opensearch.cluster.routing.RoutingTable;
        assertNotEquals(newState, clusterState);
        assertEquals(STARTED, shardRoutingTable.shards().get(1).state());
            assertEquals(replicaShard.state(), STARTED);
            .build();
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(2, indices).build();
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
        logger.info("Start all the primary shards");
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(1).state(), UNASSIGNED);
/*
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node4")))
 * compatible open source license.
 *
        logger.info("Building initial routing table");
        );
        clusterState = newState;
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
 *
        IndexMetadata indexMetadata = clusterState.metadata().index("test");
        assertThat(initialRoutingTable.index("test").shard(0).size(), equalTo(2));
        assertEquals(
            clusterState.routingTable().index("test").shards().size(),
        logger.info("add another replica");
        );
        assertEquals(0, shardRoutingTable.writerReplicas().size());
            .metadata(metadata)
        logger.info("Start all the replica and search shards");
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(1).currentNodeId(), nullValue());
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfSearchReplicas(2, indices).build();
        assertEquals(existingReplica.state(), STARTED);
                    .numberOfSearchReplicas(1)
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
        clusterState = newState;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertEquals(3, shardRoutingTable.replicaShards().size());
        // 1 primary, 1 replica, 1 search replica
        assertEquals(2, indexMetadata.getNumberOfReplicas());
        assertEquals(1, indexMetadata.getNumberOfSearchOnlyReplicas());
 * software distributed under the License is distributed on an
        final String nodeHoldingSearchReplica = shardRoutingTable.searchOnlyReplicas().get(0).currentNodeId();
        assertEquals(3, shardRoutingTable.size());
import org.opensearch.common.settings.Settings;
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(3));
        assertNotEquals(nodeHoldingReplica, nodeHoldingSearchReplica);
    public void testUpdateNumberOfReplicasDoesNotImpactSearchReplicas() {
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        assertNull(shardRoutingTable.shards().get(1).currentNodeId());
        final String[] indices = { "test" };
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        logger.info("Adding two nodes and performing rerouting");
            equalTo(nodeHoldingReplica)
                IndexMetadata.builder("test")
        assertEquals(2, shardRoutingTable.replicaShards().size());
                IndexMetadata.builder("test")
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            )
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).get(1).currentNodeId(),
    public void testUpdateNumberOfReplicas() {
            .build();
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfSearchReplicas(0, indices).build();
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(1, indices).build();
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        newState = strategy.reroute(clusterState, "reroute");
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).get(0).currentNodeId(),
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
            .build();
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShardsWithState(INITIALIZING).size(), equalTo(1));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertEquals(0, indexMetadata.getNumberOfReplicas());
            .put(
        assertEquals(1, indexMetadata.getNumberOfSearchOnlyReplicas());
        assertNotEquals(nodeHoldingPrimary, nodeHoldingSearchReplica);
        clusterState = newState;
        logger.info("Adding three nodes and performing rerouting");
        indexMetadata = clusterState.metadata().index("test");
        logger.info("Start all the replica and search shards");
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        logger.info("Start all the replica shards");
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
 * under the License.
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);
        assertEquals(3, shardRoutingTable.replicaShards().size());
 * Unless required by applicable law or agreed to in writing,
        assertEquals(1, shardRoutingTable.writerReplicas().size());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
import org.opensearch.cluster.node.DiscoveryNodes;
        assertEquals(2, shardRoutingTable.searchOnlyReplicas().size());
    }
 * The OpenSearch Contributors require contributions made to
        assertEquals("There are three shards as part of the shard routing table", 3, shardRoutingTable.size());
        assertNotEquals(newState, clusterState);
        assertEquals("There are three shards as part of the shard routing table", 3, shardRoutingTable.size());
        final String nodeHoldingSearchReplica = shardRoutingTable.searchOnlyReplicas().get(0).currentNodeId();
        assertThat(
        assertNull(shardRoutingTable.shards().get(2).currentNodeId());
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
        assertEquals(STARTED, shardRoutingTable.shards().get(0).state());
        assertThat(clusterState.metadata().index("test").getNumberOfReplicas(), equalTo(1));
        clusterState = ClusterState.builder(clusterState)
            anyOf(equalTo(nodeHoldingReplica), equalTo("node3"))
        final String nodeHoldingReplica = shardRoutingTable.writerReplicas().get(0).currentNodeId();
        );
 * ownership. Elasticsearch licenses this file to you under
            .routingTable(initialRoutingTable)
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        logger.info("do a reroute, should remain the same");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertEquals(4, shardRoutingTable.size());
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(1).state());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
                    .settings(settings(Version.CURRENT))
        updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(1, indices).build();
        );
            "There is a single routing shard routing table in the cluster",
            .build();
        assertEquals(4, shardRoutingTable.size());
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).size(), equalTo(1));
        assertNull(shardRoutingTable.shards().get(0).currentNodeId());
        assertEquals(existingReplica.currentNodeId(), nodeHoldingReplica);
        assertEquals(STARTED, shardRoutingTable.shards().get(2).state());
        final String nodeHoldingPrimary = shardRoutingTable.primaryShard().currentNodeId();
        assertNotEquals(nodeHoldingPrimary, nodeHoldingSearchReplica);
            "There is a single routing shard routing table in the cluster",
                    .numberOfShards(1)
        final String nodeHoldingPrimary = shardRoutingTable.primaryShard().currentNodeId();
        logger.info("Adding two nodes and performing rerouting");
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(0, indices).build();
            anyOf(equalTo(nodeHoldingReplica), equalTo("node3"))
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
            .build();
        ShardRouting existingReplica = shardRoutingTable.writerReplicas().get(0);
            .build();
        assertThat(initialRoutingTable.index("test").shard(0).shards().size(), equalTo(2));
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).get(0).currentNodeId(),
        assertThat(
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        logger.info("Building initial routing table");
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).state(), STARTED);
        assertEquals(STARTED, shardRoutingTable.shards().get(1).state());
        assertNotEquals(nodeHoldingReplica, nodeHoldingSearchReplica);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        newState = strategy.reroute(clusterState, "reroute");
        logger.info("add another replica");
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(1).state(), equalTo(UNASSIGNED));
        clusterState = newState;
        final String nodeHoldingReplica = shardRoutingTable.writerReplicas().get(0).currentNodeId();
            clusterState.routingTable().index("test").shards().size(),
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        assertEquals(3, shardRoutingTable.size());
        assertEquals(newReplica.state(), STARTED);
            1
import org.opensearch.cluster.ClusterName;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newSearchNode("node3")))
    public void testUpdateSearchReplicasDoesNotImpactRegularReplicas() {
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);
 * Licensed to Elasticsearch under one or more contributor
        newState = startInitializingShardsAndReroute(strategy, newState);
        clusterState = newState;
        assertNull(shardRoutingTable.shards().get(1).currentNodeId());
        assertThat(newState, not(equalTo(clusterState)));
        assertEquals(0, indexMetadata.getNumberOfSearchOnlyReplicas());
 * GitHub history for details.
        assertNotEquals(nodeHoldingPrimary, nodeHoldingReplica);
        clusterState = strategy.reroute(clusterState, "reroute");
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        AllocationService strategy = createAllocationService(
        assertTrue(shardRoutingTable.replicaShards().stream().allMatch(r -> r.state().equals(STARTED)));
/*
        // remove both replicas and assert search replica is unchanged
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
        assertEquals(2, shardRoutingTable.size());
            .build();
        assertNotEquals(nodeHoldingPrimary, nodeHoldingReplica);
        assertEquals(2, shardRoutingTable.replicaShards().size());
            .build();
        assertEquals(1, indexMetadata.getNumberOfReplicas());
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
        assertThat(nodeHoldingPrimary, not(equalTo(nodeHoldingReplica)));
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
            clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(),
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).state(), STARTED);
        logger.info("Building initial routing table");
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        logger.info("now remove a replica");
        IndexMetadata indexMetadata = clusterState.metadata().index("test");
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
    }
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(2));
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfSearchReplicas(0, indices).build();
        logger.info("Start all the primary shards");
import org.opensearch.cluster.metadata.IndexMetadata;
        AllocationService strategy = createAllocationService(
            anyOf(equalTo(nodeHoldingReplica), equalTo("node3"))
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfSearchReplicas(2, indices).build();
        assertEquals(
import org.opensearch.Version;
        assertTrue(shardRoutingTable.replicaShards().stream().allMatch(r -> r.state().equals(STARTED)));
        assertEquals(0, shardRoutingTable.searchOnlyReplicas().size());
        IndexShardRoutingTable shardRoutingTable = routingTable.index("test").shard(0);
        assertEquals("There are two replicas one search and one write", 2, shardRoutingTable.replicaShards().size());
                    .numberOfReplicas(1)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        clusterState = newState;
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
/*
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(2).state());
        }
        assertEquals(2, shardRoutingTable.writerReplicas().size());
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
public class UpdateNumberOfReplicasTests extends OpenSearchAllocationTestCase {
import org.opensearch.cluster.metadata.Metadata;
        assertThat(
            .routingTable(routingTable)
        Metadata metadata = Metadata.builder()
                    .numberOfShards(1)
 */
        assertNull(shardRoutingTable.shards().get(2).currentNodeId());
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(2, indices).build();
        );
            clusterState.routingTable().index("test").shard(0).replicaShardsWithState(INITIALIZING).get(0).currentNodeId(),
import org.apache.logging.log4j.LogManager;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(0, indices).build();
 */
            .metadata(metadata)
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.routing.ShardRouting;
        assertEquals(1, shardRoutingTable.replicaShards().size());
        assertThat(initialRoutingTable.index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShardsWithState(STARTED).size(), equalTo(2));
    }
        assertThat(
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newSearchNode("node3")))
            .build();
        // remove both replicas and assert search replica is unchanged
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
        routingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(2, indices).build();
        logger.info("Start all the primary shards");
        );
        );
    private final Logger logger = LogManager.getLogger(UpdateNumberOfReplicasTests.class);
        assertEquals(1, routingTable.index("test").shards().size());
        AllocationService strategy = createAllocationService(
            )
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(0).state());
        assertEquals(1, routingTable.index("test").shards().size());
        for (ShardRouting replicaShard : shardRoutingTable.replicaShards()) {
import static org.hamcrest.Matchers.not;
            .put(
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        final String nodeHoldingPrimary = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        final String[] indices = { "test" };
        assertThat(
        assertEquals(2, indexMetadata.getNumberOfSearchOnlyReplicas());
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(2));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * You may obtain a copy of the License at
        assertThat(initialRoutingTable.index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(shardRoutingTable.searchOnlyReplicas().get(0).currentNodeId(), nodeHoldingSearchReplica);
        assertEquals("There are two replicas one search and one write", 2, shardRoutingTable.replicaShards().size());
            .metadata(metadata)
        Metadata metadata = Metadata.builder()
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 *
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        final String nodeHoldingReplica = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
        assertEquals(STARTED, shardRoutingTable.shards().get(2).state());
        shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(3));
}
        indexMetadata = clusterState.metadata().index("test");
        assertEquals(UNASSIGNED, shardRoutingTable.shards().get(1).state());
        assertEquals(1, shardRoutingTable.writerReplicas().size());
        for (ShardRouting replicaShard : shardRoutingTable.replicaShards()) {
        assertEquals(1, shardRoutingTable.searchOnlyReplicas().size());
        assertEquals(shardRoutingTable.primaryShard().state(), STARTED);
        );
import static org.hamcrest.Matchers.equalTo;
 * KIND, either express or implied.  See the License for the
        assertThat(newState, not(equalTo(clusterState)));
        assertEquals(shardRoutingTable.writerReplicas().get(0).state(), STARTED);
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotEquals(newState, clusterState);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
        );
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo(nodeHoldingReplica));
 * not use this file except in compliance with the License.
        assertEquals(2, shardRoutingTable.size());
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(newState, not(equalTo(clusterState)));
        logger.info("Add another node and start the added replica");
import static org.hamcrest.Matchers.anyOf;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            assertEquals(replicaShard.state(), STARTED);
import static org.hamcrest.Matchers.nullValue;
        logger.info("Add another node and start the added replica");
        newState = strategy.reroute(clusterState, "reroute");
        newState = startInitializingShardsAndReroute(strategy, newState);
