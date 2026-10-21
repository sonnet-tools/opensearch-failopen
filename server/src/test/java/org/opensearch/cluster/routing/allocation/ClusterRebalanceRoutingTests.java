                    .settings(
        );
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
 * this work for additional information regarding copyright
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            .build();
            .metadata(metadata)
        logger.info("start the test1 replica shards");
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                    .numberOfReplicas(0)
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
 * compatible open source license.
        }
            .metadata(metadata)
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    }
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
            .build();
public class ClusterRebalanceRoutingTests extends OpenSearchAllocationTestCase {
            }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        int numRelocating = 0;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
 * not use this file except in compliance with the License.
        }
                }
            .build();
                        settings(Version.CURRENT).put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_id", "node1,node2")
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        );
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            .build();
        logger.info("now, start 1 more node, check that rebalancing will not happen (for test1) because we set it to all_active");
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        logger.info("start all the primary shards for test1, replicas will start initializing");
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
        logger.info("start two nodes");
                )
        Metadata metadata = Metadata.builder()
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            .build();
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                numStarted++;
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE.toString()
        clusterState = resultState;
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .metadata(metadata)
import org.opensearch.cluster.routing.ShardRouting;
        logger.info("now, start 1 more node, check that rebalancing happen (for test1) because we set it to all_active");
            .build();
 *
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        RoutingTable initialRoutingTable = RoutingTable.builder()
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        }
        logger.info("start the test1 replica shards");
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        clusterState = ClusterState.builder(clusterState)
        );
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
                )
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
 */
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
                .put(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        }
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        clusterState = strategy.reroute(clusterState, "reroute");
        Metadata metadata = Metadata.builder()
        logger.debug("reroute and check that nothing has changed");
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        logger.info("start the test1 replica shards");
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        Metadata metadata = Metadata.builder()
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                .build(),
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
                .build()
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
        assertThat(resultingState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
        ClusterState resultingState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
        }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        assertEquals(numRelocating, 1);
        logger.info("start two nodes");
            .addAsNew(metadata.index("test1"))
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
    }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
import org.opensearch.cluster.metadata.Metadata;
        );
            .addAsNew(metadata.index("test1"))
        Metadata metadata = Metadata.builder()
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        logger.info("now, start 1 more node, check that rebalancing will happen (for test1) because we set it to always");
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            public void allocateUnassigned(
            .build();
        }
        logger.info("start two nodes");
    public void testAlways() {
    }
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
 * ownership. Elasticsearch licenses this file to you under
        logger.debug(
 *
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        Metadata metadata = Metadata.builder()
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
                .put(
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
            ) {
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            Settings.builder()
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                        allocation.setHasPendingAsyncFetch();
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        logger.info("start two nodes");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE.toString()
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                )
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        logger.debug("now set allocateTest1 to true and reroute we should see the [test1] index initializing");
        }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
                UnassignedAllocationHandler unassignedAllocationHandler
import static org.hamcrest.Matchers.anyOf;
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                ShardRouting shardRouting,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        logger.info("now, start 1 more node, check that rebalancing will not happen (for test1) because we set it to primaries_active");
            .addAsNew(metadata.index("test1"))
 * You may obtain a copy of the License at
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        }
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        logger.info("start all the primary shards for test1, replicas will start initializing");
        }
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        );
                )
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
                .put(
        }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .metadata(metadata)
        assertThat(routingNodes.node("node3").isEmpty(), equalTo(true));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        }
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            new TestGatewayAllocator() {
            .build();
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .routingTable(initialRoutingTable)
        RoutingTable initialRoutingTable = RoutingTable.builder()
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == STARTED) {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
        clusterState = ClusterState.builder(clusterState)
        }
            }
        );
                    unassignedAllocationHandler.removeAndIgnore(UnassignedInfo.AllocationStatus.NO_ATTEMPT, allocation.changes());
        assertThat(resultState, equalTo(clusterState));
            .build();
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        assertThat(routingNodes.node("node3").iterator().next().shardId().getIndex().getName(), equalTo("test1"));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
    public void testClusterAllActive1() {
        logger.debug("now set hasFetches to true and reroute we should now see exactly one relocating shard");
            .addAsNew(metadata.index("test2"))
        assertThat(routingNodes.node("node3").size(), equalTo(1));
            .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (allocateTest1.get() == false && "test1".equals(shardRouting.index().getName())) {
 */
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                .put(
        logger.info("start the test1 replica shards");
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        logger.info("now, start 1 more node, check that rebalancing happen (for test1) because we set it to primaries_active");
            } else if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == RELOCATING) {
 * GitHub history for details.
    public void testRebalanceWhileShardFetching() {
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            .addAsNew(metadata.index("test2"))
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            .metadata(metadata)
        logger.debug("reroute and check that nothing has changed");
        }
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        final AtomicBoolean hasFetches = new AtomicBoolean(true);
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            .addAsNew(metadata.index("test2"))
            .addAsNew(metadata.index("test2"))
        RoutingTable initialRoutingTable = RoutingTable.builder()
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        logger.debug("start all the primary shards for test");
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            .addAsNew(metadata.index("test2"))
 */
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                .build()
    public void testClusterAllActive2() {
        final AtomicBoolean allocateTest1 = new AtomicBoolean(false);
            } else if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == RELOCATING) {
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
import org.opensearch.cluster.routing.UnassignedInfo;
        RoutingTable initialRoutingTable = RoutingTable.builder()
                    super.allocateUnassigned(shardRouting, allocation, unassignedAllocationHandler);
        }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        }
        }
        AllocationService strategy = createAllocationService(
        assertThat(routingNodes.node("node3").isEmpty(), equalTo(true));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
        logger.debug("now, start 1 more node, check that rebalancing will not happen since we unassigned shards");
        logger.info("start all the primary shards for test2, replicas will start initializing");
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            .put(
        }
        assertEquals(numStarted, 1);
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        }
        Metadata metadata = Metadata.builder()
        }
        clusterState = strategy.reroute(clusterState, "reroute");
            .addAsNew(metadata.index("test1"))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        clusterState = resultingState;
        logger.info("start all the primary shards for test2, replicas will start initializing");
        }
            .routingTable(initialRoutingTable)
        }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .routingTable(initialRoutingTable)
        AllocationService strategy = createAllocationService(
        }
import static org.hamcrest.Matchers.not;
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            Settings.builder()
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = strategy.reroute(clusterState, "reroute");
    }
        }
        RoutingTable initialRoutingTable = RoutingTable.builder()
import org.opensearch.test.gateway.TestGatewayAllocator;
                )
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        // is never called if we don't have unassigned shards.
import org.opensearch.cluster.routing.RoutingTable;
            .routingTable(initialRoutingTable)
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        int numStarted = 0;
    }
            @Override
        }
        });
        logger.info("start the test1 replica shards");
            Settings.builder()
        hasFetches.set(false);
 * The OpenSearch Contributors require contributions made to
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    if (hasFetches.get()) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
    }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                numStarted++;
        logger.debug("now, start 1 more node, check that rebalancing will not happen since we have shard sync going on");
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
                .put(
            .routingTable(initialRoutingTable)
            .addAsNew(metadata.index("test1"))
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_ALL_ACTIVE.toString()
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import org.opensearch.Version;
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        clusterState = strategy.reroute(clusterState, "reroute");
/*
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
        assertThat(routingNodes.node("node3").iterator().next().shardId().getIndex().getName(), anyOf(equalTo("test1"), equalTo("test2")));
            .build();
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));
                )
            .build();
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
                    }
            .routingTable(initialRoutingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            Settings.builder()
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        assertThat(resultState, not(equalTo(clusterState)));
    public void testClusterAllActive3() {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
package org.opensearch.cluster.routing.allocation;
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            .build();
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        }
 *
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
}
import org.opensearch.cluster.ClusterState;
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));
                .build()
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        logger.info("start two nodes");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            .addAsNew(metadata.index("test"))
                public void beforeAllocation(RoutingAllocation allocation) {
            .addAsNew(metadata.index("test1"))
        }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        allocateTest1.set(true);
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
                )
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            "now start initializing shards and expect exactly one rebalance" + " from node1 to node 2 since index [test] is all on node1"
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .build();
        logger.info("start all the primary shards for test1, replicas will start initializing");
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        logger.info("start two nodes");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            }
        ClusterState resultState = strategy.reroute(clusterState, "reroute");
                .build()
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_ALL_ACTIVE.toString()
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        logger.info("now, start 1 more node, check that rebalancing will not happen (for test1) because we set it to all_active");
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        logger.info("start all the primary shards for test1, replicas will start initializing");
            .addAsNew(metadata.index("test1"))
import org.opensearch.cluster.routing.RoutingNodes;
        logger.info("start all the primary shards for test1, replicas will start initializing");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
        assertEquals(numRelocating, 1);
    public void testClusterPrimariesActive1() {
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
 * under the License.
        }
/*
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                .put(
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        }
        logger.info("start the test1 replica shards");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        clusterState = strategy.reroute(clusterState, "reroute");
        }
        assertThat(routingNodes.node("node3").isEmpty(), equalTo(true));
import org.opensearch.cluster.node.DiscoveryNodes;
        int numStarted = 0;
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        AllocationService strategy = createAllocationService(Settings.EMPTY, new TestGatewayAllocator() {
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
 * this file be licensed under the Apache-2.0 license or a
            .addAsNew(metadata.index("test1"))
        assertEquals(numStarted, 1);
        }
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(resultingState, equalTo(clusterState));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
 * Licensed to Elasticsearch under one or more contributor
                IndexMetadata.builder("test1")
 * specific language governing permissions and limitations
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        );
            .build();
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
    public void testRebalanceWithIgnoredUnassignedShards() {
        }
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        }
            .metadata(metadata)
        }
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test");
        clusterState = strategy.reroute(clusterState, "reroute");
            .metadata(metadata)
            .build();
            .metadata(metadata)
            )
        );
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
    }
                .build()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        AllocationService strategy = createAllocationService(
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                RoutingAllocation allocation,
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
                @Override
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            Settings.builder()
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
                .build()
        RoutingTable initialRoutingTable = RoutingTable.builder()
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                    .numberOfShards(2)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        }
            .build();
        RoutingTable initialRoutingTable = RoutingTable.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                    )
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        logger.info("start all the primary shards for test1, replicas will start initializing");
 * software distributed under the License is distributed on an
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
import org.opensearch.common.settings.Settings;
                .put(
        assertThat(routingNodes.node("node3").size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState)
        assertThat(routingNodes.node("node3").size(), equalTo(1));
        }
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        Metadata metadata = Metadata.builder()
        logger.info("start all the primary shards for test2, replicas will start initializing");
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        }
            Settings.builder()
    public void testClusterPrimariesActive2() {
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        logger.info("start the test2 replica shards");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
            .build();
            .build();
        resultState = strategy.reroute(clusterState, "reroute");
 * license agreements. See the NOTICE file distributed with
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
        }
            .addAsNew(metadata.index("test2"))
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .routingTable(initialRoutingTable)
        Metadata metadata = Metadata.builder()
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
import org.opensearch.cluster.metadata.IndexMetadata;
                } else {
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }
import org.apache.logging.log4j.Logger;
import static org.hamcrest.Matchers.equalTo;
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                numRelocating++;
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        }
        clusterState = strategy.reroute(clusterState, "reroute");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = strategy.reroute(clusterState, "reroute");
        }
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        }
                }
            // assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }
            .build();
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
 * KIND, either express or implied.  See the License for the
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        logger.info("start two nodes");
        // we use a second index here (test1) that never gets assigned otherwise allocateUnassigned
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        AllocationService strategy = createAllocationService(
        assertThat(routingNodes.node("node3").iterator().next().shardId().getIndex().getName(), equalTo("test1"));
        }
            if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == STARTED) {
        }
 * Modifications Copyright OpenSearch Contributors. See
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        }
/*
            .routingTable(initialRoutingTable)
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
 * Unless required by applicable law or agreed to in writing,
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_ALL_ACTIVE.toString()
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
import java.util.concurrent.atomic.AtomicBoolean;
            Settings.builder()
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        }
        int numRelocating = 0;
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
    }
    private final Logger logger = LogManager.getLogger(ClusterRebalanceRoutingTests.class);
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                numRelocating++;
        logger.info("start two nodes");
        RoutingTable initialRoutingTable = RoutingTable.builder()
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        logger.debug("start all the primary shards for test");
        resultingState = strategy.reroute(clusterState, "reroute");
            .addAsNew(metadata.index("test"))
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
