 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        logger.debug("start all the primary shards for test");
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }  
        Metadata metadata = Metadata.builder()
            .build();
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            "now start initializing shards and expect exactly one rebalance" + " from node1 to node 2 since index [test] is all on node1"  
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
                )
        logger.info("start two nodes");
            .metadata(metadata)  
            .metadata(metadata)  
        }
        clusterState = strategy.reroute(clusterState, "reroute");  
            .addAsNew(metadata.index("test"))
        final AtomicBoolean allocateTest1 = new AtomicBoolean(false);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
import org.opensearch.cluster.node.DiscoveryNodes;
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                .build()
        logger.info("start the test2 replica shards");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
        }  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .routingTable(initialRoutingTable)
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_ALL_ACTIVE.toString()  
        clusterState = ClusterState.builder(clusterState)  
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
 * Licensed to Elasticsearch under one or more contributor  
                numRelocating++;
        // we use a second index here (test1) that never gets assigned otherwise allocateUnassigned
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        }
        assertThat(routingNodes.node("node3").isEmpty(), equalTo(true));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }  
                numStarted++;  
        assertThat(resultState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            .metadata(metadata)
        RoutingTable initialRoutingTable = RoutingTable.builder()  
            } else if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == RELOCATING) {
                .put(
 * The OpenSearch Contributors require contributions made to  
            @Override
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        clusterState = ClusterState.builder(clusterState)  
        clusterState = strategy.reroute(clusterState, "reroute");
 * not use this file except in compliance with the License.
        logger.debug("now set hasFetches to true and reroute we should now see exactly one relocating shard");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
        assertThat(resultingState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
        resultState = strategy.reroute(clusterState, "reroute");  
            if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == STARTED) {
        }
        logger.info("start two nodes");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
    public void testClusterPrimariesActive1() {
            .routingTable(initialRoutingTable)
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = ClusterState.builder(clusterState)  
        clusterState = strategy.reroute(clusterState, "reroute");
            .metadata(metadata)  
        }  
        }
            .routingTable(initialRoutingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
                numRelocating++;
        assertEquals(numRelocating, 1);
        AllocationService strategy = createAllocationService(
 * license agreements. See the NOTICE file distributed with
        }  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
        assertThat(routingNodes.node("node3").size(), equalTo(1));  
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
        clusterState = ClusterState.builder(clusterState)
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        }  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        RoutingTable initialRoutingTable = RoutingTable.builder()
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
            .build();
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            }
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                    .settings(
        AllocationService strategy = createAllocationService(
                @Override
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        logger.info("start all the primary shards for test1, replicas will start initializing");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        logger.info("now, start 1 more node, check that rebalancing will happen (for test1) because we set it to always");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                    .numberOfReplicas(0)  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            .build();
            .build();
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));  
}  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .build();
        logger.info("start all the primary shards for test1, replicas will start initializing");
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
import org.opensearch.cluster.ClusterState;
 * under the License.  
        logger.info("start all the primary shards for test1, replicas will start initializing");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));  
        logger.info("start the test1 replica shards");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        AllocationService strategy = createAllocationService(
                    )
        );  
        }  
        // is never called if we don't have unassigned shards.
        }
        int numRelocating = 0;
        }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
                if (allocateTest1.get() == false && "test1".equals(shardRouting.index().getName())) {
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .build();  
        Metadata metadata = Metadata.builder()
            .build();
import org.opensearch.Version;  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                .build()
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()  
        ClusterState resultState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        }  
        logger.info("now, start 1 more node, check that rebalancing happen (for test1) because we set it to all_active");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        }
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE.toString()  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
public class ClusterRebalanceRoutingTests extends OpenSearchAllocationTestCase {  
        ClusterState resultingState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.routing.RoutingNodes;  
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
    }
            .addAsNew(metadata.index("test1"))
                )
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        );  
        logger.debug("reroute and check that nothing has changed");
            .metadata(metadata)
        clusterState = strategy.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            .addAsNew(metadata.index("test2"))  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
        );
 * software distributed under the License is distributed on an
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }  
        RoutingTable initialRoutingTable = RoutingTable.builder()  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = strategy.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                public void beforeAllocation(RoutingAllocation allocation) {
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
        }  
        assertThat(routingNodes.node("node3").size(), equalTo(1));  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .build();  
        resultingState = strategy.reroute(clusterState, "reroute");  
            .build();  
        }  
    public void testClusterAllActive1() {  
            // assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test");
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .build();
            .build();  
    private final Logger logger = LogManager.getLogger(ClusterRebalanceRoutingTests.class);
            .addAsNew(metadata.index("test"))
            .routingTable(initialRoutingTable)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
    }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
    }
        logger.info("now, start 1 more node, check that rebalancing will not happen (for test1) because we set it to primaries_active");
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
                }  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        );  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .addAsNew(metadata.index("test2"))
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        logger.info("now, start 1 more node, check that rebalancing will not happen (for test1) because we set it to all_active");
        clusterState = strategy.reroute(clusterState, "reroute");  
        logger.info("start the test1 replica shards");
            }
        logger.info("start all the primary shards for test2, replicas will start initializing");
        final AtomicBoolean hasFetches = new AtomicBoolean(true);
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }
            .routingTable(initialRoutingTable)
        logger.info("start two nodes");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute");
        );
            .metadata(metadata)  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
        }  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.routing.UnassignedInfo;  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
                )
            .build();
        logger.debug(
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            Settings.builder()
        }  
                .build()
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        clusterState = strategy.reroute(clusterState, "reroute");  
        }
        }
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
                ShardRouting shardRouting,
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                .put(
            .build();
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
 * GitHub history for details.
                )
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));  
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
        assertEquals(numStarted, 1);  
        int numStarted = 0;  
            .build();
        Metadata metadata = Metadata.builder()
 */
    public void testRebalanceWithIgnoredUnassignedShards() {
        assertThat(resultState, equalTo(clusterState));  
            new TestGatewayAllocator() {  
            Settings.builder()  
import org.opensearch.cluster.routing.RoutingTable;
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        int numRelocating = 0;
            .build();
        Metadata metadata = Metadata.builder()
        }  
        logger.info("now, start 1 more node, check that rebalancing will not happen (for test1) because we set it to all_active");
            .addAsNew(metadata.index("test1"))
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                RoutingAllocation allocation,
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
 *
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_ALL_ACTIVE.toString()  
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
        RoutingTable initialRoutingTable = RoutingTable.builder()
 *  
                .build(),
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        logger.info("start two nodes");
package org.opensearch.cluster.routing.allocation;
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        AllocationService strategy = createAllocationService(
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            ) {
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_ALL_ACTIVE.toString()
                    if (hasFetches.get()) {  
            .build();
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
        assertThat(routingNodes.node("node3").isEmpty(), equalTo(true));  
        logger.info("start the test1 replica shards");
        }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        RoutingTable initialRoutingTable = RoutingTable.builder()
        }  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
        logger.debug("start all the primary shards for test");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            Settings.builder()  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
                        settings(Version.CURRENT).put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_id", "node1,node2")  
 * You may obtain a copy of the License at  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
        logger.info("start the test1 replica shards");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
 */  
import org.opensearch.cluster.routing.ShardRouting;
 */  
            .addAsNew(metadata.index("test2"))  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .addAsNew(metadata.index("test1"))
        clusterState = resultState;
            }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
    public void testClusterAllActive2() {
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            .build();
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
        }
        }  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
                IndexMetadata.builder("test1")
    }
            .addAsNew(metadata.index("test2"))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
        }  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            .metadata(metadata)
/*  
    public void testClusterPrimariesActive2() {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));  
        }  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        logger.debug("now, start 1 more node, check that rebalancing will not happen since we have shard sync going on");
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));  
            .routingTable(initialRoutingTable)
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
            )
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            Settings.builder()  
                .put(
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        }
            } else if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == RELOCATING) {  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        Metadata metadata = Metadata.builder()
import static org.hamcrest.Matchers.anyOf;
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
    }
 * this work for additional information regarding copyright
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }
        logger.info("start all the primary shards for test2, replicas will start initializing");
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        assertThat(resultingState, equalTo(clusterState));  
        logger.info("start all the primary shards for test1, replicas will start initializing");
        }
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
/*  
        }  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        clusterState = strategy.reroute(clusterState, "reroute");  
        AllocationService strategy = createAllocationService(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE.toString()  
            .build();  
            .routingTable(initialRoutingTable)
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
                )  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        }
import org.opensearch.common.settings.Settings;
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .addAsNew(metadata.index("test1"))
        RoutingTable initialRoutingTable = RoutingTable.builder()  
                .put(  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(STARTED));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        );
                    unassignedAllocationHandler.removeAndIgnore(UnassignedInfo.AllocationStatus.NO_ATTEMPT, allocation.changes());  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(1));  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            .addAsNew(metadata.index("test1"))
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
    }
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
 * KIND, either express or implied.  See the License for the
                )  
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else {
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        }  
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            .addAsNew(metadata.index("test1"))
            public void allocateUnassigned(  
        }  
        logger.info("start two nodes");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
        logger.info("start all the primary shards for test1, replicas will start initializing");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        logger.info("now, start 1 more node, check that rebalancing happen (for test1) because we set it to primaries_active");
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
import org.apache.logging.log4j.Logger;
            .build();
        }
            .build();
            .addAsNew(metadata.index("test1"))
 * compatible open source license.
                .put(
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(routingNodes.node("node3").size(), equalTo(1));  
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .build();  
        assertThat(routingNodes.node("node3").isEmpty(), equalTo(true));
        assertThat(routingNodes.node("node3").iterator().next().shardId().getIndex().getName(), anyOf(equalTo("test1"), equalTo("test2")));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        clusterState = resultingState;
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
    public void testClusterAllActive3() {
    }
        assertThat(routingNodes.node("node3").iterator().next().shardId().getIndex().getName(), equalTo("test1"));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            .addAsNew(metadata.index("test1"))
        allocateTest1.set(true);
                    super.allocateUnassigned(shardRouting, allocation, unassignedAllocationHandler);
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
            .build();  
            .metadata(metadata)
                numStarted++;
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    public void testAlways() {  
 *
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        logger.info("start the test1 replica shards");
import org.opensearch.cluster.metadata.IndexMetadata;  
                .put(  
        AllocationService strategy = createAllocationService(Settings.EMPTY, new TestGatewayAllocator() {
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        hasFetches.set(false);
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .build();  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
import org.opensearch.test.gateway.TestGatewayAllocator;  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        );  
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");
            .build();
                UnassignedAllocationHandler unassignedAllocationHandler  
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
import org.apache.logging.log4j.LogManager;
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        clusterState = strategy.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));
            if (clusterState.routingTable().index("test").shard(i).primaryShard().state() == STARTED) {
                )
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                .build()
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
                .put(
        logger.debug("now set allocateTest1 to true and reroute we should see the [test1] index initializing");
            .addAsNew(metadata.index("test2"))
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
            Settings.builder()  
            .build();
        );
        logger.info("start all the primary shards for test2, replicas will start initializing");
            .routingTable(initialRoutingTable)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            assertThat(clusterState.routingTable().index("test2").shard(i).size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        clusterState = ClusterState.builder(clusterState)  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
        RoutingTable initialRoutingTable = RoutingTable.builder()  
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
        }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));  
        logger.info("start two nodes");
import org.opensearch.cluster.metadata.Metadata;
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
            .put(  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
            assertThat(clusterState.routingTable().index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
                .build()
            assertThat(clusterState.routingTable().index("test2").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
import java.util.concurrent.atomic.AtomicBoolean;
        Metadata metadata = Metadata.builder()
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
                }  
                .build()
            .build();
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test2").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        logger.debug("reroute and check that nothing has changed");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {  
            }  
    }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(1));
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(routingNodes.node("node3").iterator().next().shardId().getIndex().getName(), equalTo("test1"));
        }
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
 * this file be licensed under the Apache-2.0 license or a
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
        logger.debug("now, start 1 more node, check that rebalancing will not happen since we unassigned shards");
                    .numberOfShards(2)
        AllocationService strategy = createAllocationService(
/*
        }  
        logger.info("start two nodes");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
                    }
        assertEquals(numRelocating, 1);
            Settings.builder()
 * specific language governing permissions and limitations
            .addAsNew(metadata.index("test2"))  
        }
        for (int i = 0; i < clusterState.routingTable().index("test2").shards().size(); i++) {
import static org.hamcrest.Matchers.not;
        logger.info("start two nodes");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test1");  
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;  
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertEquals(numStarted, 1);
        RoutingTable initialRoutingTable = RoutingTable.builder()
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            Settings.builder()  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, "test2");
        int numStarted = 0;  
        logger.info("start the test1 replica shards");
        });
        logger.info("start all the primary shards for test1, replicas will start initializing");
        }  
        }  
    public void testRebalanceWhileShardFetching() {  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
                        allocation.setHasPendingAsyncFetch();
