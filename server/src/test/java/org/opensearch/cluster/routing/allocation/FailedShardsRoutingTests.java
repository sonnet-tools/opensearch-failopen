 * The OpenSearch Contributors require contributions made to  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
import org.opensearch.cluster.metadata.Metadata;
                            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), null)
        Metadata metadata = Metadata.builder()
            .build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
    }
            .build();  
            "REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY",
        logger.info("--> moving primary shard to node3");
        int shardsToFail = randomIntBetween(1, numberOfReplicas);
    public void testFirstAllocationFailureSingleNode() {  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), not(equalTo(nodeHoldingPrimary)));
        );
                    .build()
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));  
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        clusterState = newState;
            assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1 + i));
        );
        routingNodes = clusterState.getRoutingNodes();
                new MoveAllocationCommand(  
    }
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // start primary shards
            new AllocationCommands(
            .build();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(numberOfReplicas))
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));  
        ShardId shardId = new ShardId(metadata.index("test").getIndex(), 0);  
    }  
        // start another replica shard, while keep one initializing
        );  
            clusterState,
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1 + (i + 1)));  
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                "expected node [" + cursor.getId() + "] with version " + nodeVer + " to be after " + replicaNodeVersion,
        // add a remote node and start primary shard
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
                || primaryShardRouting1.currentNodeId().equals(remoteNode3.getId())
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        DiscoveryNode nonRemoteNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            .put(IndexMetadata.builder("test").settings(settingsBuilder).numberOfShards(1).numberOfReplicas(3))  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
        clusterState = ClusterState.builder(clusterState)
        Metadata metadata = Metadata.builder()  
            .metadata(metadata)
        ShardRouting primaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
        }
            clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next(),  
    }  
        for (int i = 0; i < 4; i++) {
        logger.info("--> moving primary shard to node3");  
        }
        );  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    0,
            .metadata(metadata)
        clusterState = newState;
        ShardRouting startedReplica = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))  
    }  
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),  
import java.util.Set;
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));  
            remoteStoreNodeAttributes,
import org.opensearch.cluster.ClusterState;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        newState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(3));  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        List<DiscoveryNode> replicaShardNodes = List.of(remoteNode2, remoteNode3, nonRemoteNode1, nonRemoteNode2);
            .build();
            assertThat(  
        assertNotEquals(primaryShardRouting1, primaryShardRouting2);  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(remoteNode1)).build();  
            Version.CURRENT
            .build();
                anyOf(equalTo("node1"), equalTo("node2"))
import org.opensearch.cluster.routing.RoutingNodes;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
            assertThat(
        ShardRouting startedReplica = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));  
        logger.info("Building initial routing table");
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        logger.info("--> adding 2 nodes on same rack and do rerouting");
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));  
/*  
            .build();  
        }
            false,
        }
    }  
            }
                new MoveAllocationCommand(
        assertThat(routingNodes.node("node3").iterator().next().shardId(), not(equalTo(shardToFail.shardId())));
                fail("shard " + failedShard + " was not failed");  
            .persistentSettings(  
        assertThat(
        );  
        for (final DiscoveryNode cursor : clusterState.nodes().getDataNodes().values()) {
import org.opensearch.test.VersionUtils;
            Version nodeVer = cursor.getVersion();
        logger.info("Building initial routing table");
            assertThat(  
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        // add remote and non-remote nodes and start replica shards  
        assertNotEquals(primaryShardRouting2, primaryShardRouting3);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("Building initial routing table");  
        logger.info("Start the shards (primaries)");
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
                anyOf(equalTo("node2"), equalTo("node1"))  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(replicaShardNodes.get(i)))  
            Settings.builder()  
        logger.info("--> adding additional node");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
 * under the License.  
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));  
        clusterState = newState;
        clusterState = ClusterState.builder(clusterState)
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
            clusterState.getRoutingNodes().node("node3").iterator().next(),
        clusterState = newState;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
            clusterState = allocation.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
            .build();  
        // start one replica so it can take over.  
        // start primary shard
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShardToFail, randomBoolean());
            UUIDs.base64UUID(),
                shardRoutingsToFail.add(shardToFail);
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), lessThan(3));  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
import org.apache.logging.log4j.Logger;
        assertThat(newState, not(clusterState));
        clusterState = newState;
                "expected node [" + cursor.getId() + "] with version " + nodeVer + " to be after " + replicaNodeVersion,  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), lessThan(3));
            assertThat(
        newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();
    public void testFailedShardPrimaryRelocatingToAndFrom() {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
        newState = strategy.applyFailedShard(clusterState, shardToFail, randomBoolean());
        DiscoveryNode remoteNode2 = new DiscoveryNode(
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
    }
        Version replicaNodeVersion = clusterState.nodes().getDataNodes().get(startedReplica.currentNodeId()).getVersion();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
        AllocationService allocation = createAllocationService(Settings.builder().build());
            .build();  
        assertEquals(3, clusterState.getRoutingNodes().shardsWithState(STARTED).size());
    public void testRebalanceFailure() {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        testReplicaIsPromoted(true);
            : settings(Version.CURRENT);
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
                    "node3"
        DiscoveryNode nonRemoteNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));  
            clusterState,
 * SPDX-License-Identifier: Apache-2.0
        final String nodeHoldingPrimary2 = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();  
    public void testSingleShardMultipleAllocationFailures() {  
            Settings.builder()
        assertThat(newState, not(equalTo(clusterState)));
            clusterState,
            anyOf(equalTo(origPrimaryNodeId), equalTo("node3"))  
        ShardRouting newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();
        ShardRouting primaryShardRouting2 = clusterState.routingTable().index("test").shard(0).primaryShard();
        // fail the primary shard, check one replica gets elected to primary, others become INITIALIZING (from it)  
            .metadata(metadata)  
            String failedNode = "node" + Integer.toString(randomInt(numberOfReplicas));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertThat(newPrimaryShard, not(equalTo(secondPrimaryShardToFail)));
        clusterState = ClusterState.builder(clusterState)  
        logger.info("Building initial routing table");
        AllocationService allocation = createAllocationService(Settings.builder().build());  
        logger.info("--> fail primary shard recovering instance on node3 being initialized");
        clusterState = ClusterState.builder(clusterState)
                anyOf(equalTo("node1"), equalTo("node2"))  
        assertThat(newState, not(equalTo(clusterState)));
        for (int i = 0; i < shardsToFail; i++) {  
        ArrayList<FailedShard> failedShards = new ArrayList<>();
        // segment replication enabled  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        logger.info("Building initial routing table");
 * this file be licensed under the Apache-2.0 license or a
                replicaNodeVersion.onOrBefore(nodeVer)
        clusterState = ClusterState.builder(clusterState)  
        AllocationService allocation = createAllocationService(Settings.builder().build());  
        }
        assertNotEquals(primaryShard0, primaryShardRouting1);
        ShardRouting secondPrimaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();  
        assertNotNull(replicaNodeVersion);  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        ShardRouting primaryShard0 = clusterState.routingTable().index("test").shard(0).primaryShard();
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        clusterState = newState;
        logger.info("--> fail primary shard recovering instance on node1 being relocated");  
import java.util.HashSet;
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));  
            false,
            .routingTable(initialRoutingTable)  
        ShardRouting primaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
            );
        clusterState = allocation.reroute(clusterState, "reroute");
 * not use this file except in compliance with the License.
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
public class FailedShardsRoutingTests extends OpenSearchAllocationTestCase {
package org.opensearch.cluster.routing.allocation;
        }
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        AllocationService allocation = createAllocationService(Settings.builder().build());  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        // the primary gets allocated on another node, replicas are initializing
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        ShardRouting firstShard = clusterState.getRoutingNodes().node("node1").iterator().next();
        assertEquals(4, clusterState.getRoutingNodes().shardsWithState(STARTED).size());
        clusterState = allocation.reroute(clusterState, "reroute");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(3));
            .put(IndexMetadata.builder("test").settings(settingsBuilder).numberOfShards(1).numberOfReplicas(4))
                failedNodes.add(failedNode);  
        clusterState = ClusterState.builder(clusterState).routingTable(allocation.reroute(clusterState, "reroute").routingTable()).build();
            .routingTable(initialRoutingTable)
            clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
        assertNotEquals(clusterState, newState);  
            clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(),
        ShardRouting newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();  
        for (int i = 0; i < numberOfReplicas + 1; i++) {
        assertNotEquals(clusterState, newState);
            assertTrue(
        clusterState = newState;
        logger.info("Start the shards (backups)");
            .metadata(metadata)
import org.opensearch.cluster.metadata.IndexMetadata;  
            .build();
        // make sure the failedShard is not INITIALIZING again on node3
            randomBoolean()
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        assertTrue(
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
    public void testReplicaOnOldestVersionIsPromotedDocRep() {  
                            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), null)
        logger.info("Adding single node and performing rerouting");  
import org.opensearch.cluster.routing.RoutingTable;  
        // check promotion of replica to primary
        assertThat(clusterState.getRoutingNodes().node(origReplicaNodeId).iterator().next().state(), equalTo(STARTED));
            );
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        logger.info("Start the shards (backups)");  
            if ("node1".equals(cursor.getId())) {  
        // fail the primary shard, check replicas get removed as well...  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        assertThat(newState, not(equalTo(clusterState)));  
        ShardRouting primaryShardRouting3 = clusterState.routingTable().index("test").shard(0).primaryShard();
        clusterState = ClusterState.builder(clusterState)
import org.apache.logging.log4j.LogManager;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
import java.util.List;
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            false
            UUIDs.base64UUID(),  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
    }  
            Settings.builder()
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        logger.info("Adding two nodes and performing rerouting");
                replicaNodeVersion.onOrBefore(nodeVer)  
    public void testReplicaOnOldestVersionIsPromotedSegRep() {
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
import static org.hamcrest.Matchers.equalTo;  
            "REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_VALUE"  
        commandsResult = allocation.reroute(  
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
        newState = strategy.applyFailedShard(clusterState, shardToFail, randomBoolean());
            Settings.builder()
        Settings.Builder settingsBuilder = settings(Version.CURRENT).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
        clusterState = strategy.reroute(clusterState, "reroute");
 * compatible open source license.
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
        clusterState = allocation.applyFailedShard(
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
                    .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE.direction)  
        assertTrue(  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));  
        clusterState = ClusterState.builder(clusterState)
        AllocationService.CommandsResult commandsResult = allocation.reroute(
    }
 *  
        Metadata metadata = Metadata.builder()
            }  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
            new AllocationCommands(  
                continue;
import java.util.ArrayList;  
            remoteStoreNodeAttributes,
        assertNotEquals(clusterState, newState);
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            if (primaryShardToFail.currentNodeId().equals(cursor.getId())
            randomBoolean()
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .metadata(metadata)  
                || primaryShardRouting3.currentNodeId().equals(nonRemoteNode2.getId())
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
        logger.info("--> shard {} got assigned to node with version {}", startedReplica, replicaNodeVersion);
            .routingTable(initialRoutingTable)  
            buildNewFakeTransportAddress(),  
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),  
                // Skip the node that the primary was on, it doesn't have a replica so doesn't need a version check  
                failedShard.getRoutingEntry().shardId(),  
 * You may obtain a copy of the License at  
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        clusterState = newState;
        replicaNodeVersion = clusterState.nodes().getDataNodes().get(startedReplica.currentNodeId()).getVersion();
                    0,  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        ShardRouting newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();  
        }
 * specific language governing permissions and limitations
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));  
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,  
            }
import org.opensearch.cluster.routing.ShardRouting;
                || secondPrimaryShardToFail.currentNodeId().equals(cursor.getId())) {
        }  
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
            .build();
        clusterState = newState;  
        assertThat(newState, not(equalTo(clusterState)));  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        logger.info("--> shard {} got assigned to node with version {}", startedReplica, replicaNodeVersion);  
        logger.info("Fail the shards on node 3");  
        // add 4 nodes
        logger.info("--> verifying all is allocated");
        newState = allocation.applyFailedShard(clusterState, primaryShardRouting1, randomBoolean());
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));  
            ? settings(Version.CURRENT).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        assertThat(newState, not(equalTo(clusterState)));  
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
        assertThat(newState, not(equalTo(clusterState)));  
        AllocationService strategy = createAllocationService(  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            .build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
    }
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));  
        newState = strategy.applyFailedShard(clusterState, firstShard, randomBoolean());
            DiscoveryNodeRole.BUILT_IN_ROLES,
            .routingTable(initialRoutingTable)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2-1.0", Version.fromString("1.0.0"))))  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        );
        AllocationService allocation = createAllocationService(  
        AllocationService strategy = createAllocationService(
            anyOf(equalTo("node1"), equalTo("node2"))  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        clusterState = allocation.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.anyOf;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String origPrimaryNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));  
        clusterState = ClusterState.builder(clusterState).routingTable(allocation.reroute(clusterState, "reroute").routingTable()).build();
            buildNewFakeTransportAddress(),
        clusterState = ClusterState.builder(clusterState)  
        logger.info("fail the first shard, will have no place to be rerouted to (single node), so stays unassigned");
        assertThat(newPrimaryShard, not(equalTo(primaryShardToFail)));
        // starting primaries  
            Version nodeVer = cursor.getVersion();  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        // fail primary shard again
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        DiscoveryNode remoteNode3 = new DiscoveryNode(
        final ShardRouting firstShard = clusterState.getRoutingNodes().node(nodeHoldingPrimary).iterator().next();
        assertThat(newPrimaryShard.allocationId(), equalTo(startedReplica.allocationId()));
            );  
                failedShards.add(new FailedShard(shardToFail, null, null, randomBoolean()));
        clusterState = commandsResult.getClusterState();
        ShardRouting primaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
                Settings.builder()
            assertThat(  
        clusterState = startShardsAndReroute(allocation, clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(0));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
                        )  
        Set<ShardRouting> shardRoutingsToFail = new HashSet<>();
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)
                .build()
        DiscoveryNode remoteNode1 = new DiscoveryNode(
            .routingTable(routingTable)
        // starting replicas
            UUIDs.base64UUID(),  
            ) != null) {
            ),  
            ShardRouting shardToFail = routingNodes.node(failedNode).iterator().next();  
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
        newState = allocation.applyFailedShard(clusterState, secondPrimaryShardToFail, randomBoolean());
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
        );
            if (routingNodes.getByAllocationId(
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));  
        // add another 1.0 node
        assertEquals(2, clusterState.getRoutingNodes().shardsWithState(STARTED).size());  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                anyOf(equalTo("node1"), equalTo("node2"))
                        )  
        // the primary gets allocated on another node
            );  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));  
    public void testFailPrimaryStartedCheckReplicaElected() {
        }
            primaryShardRouting1.currentNodeId().equals(remoteNode2.getId())  
 *
            .build();
        clusterState = startShardsAndReroute(allocation, clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(0));
import java.util.Map;  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
import static org.hamcrest.Matchers.not;
        );  
            .build();
        assertThat(
    private void testReplicaIsPromoted(boolean isSegmentReplicationEnabled) {
            assertThat(
            Settings.builder()
        Metadata metadata = Metadata.builder()  
        clusterState = commandsResult.getClusterState();  
        ShardRouting expectedCandidateForSegRep = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
        Set<String> failedNodes = new HashSet<>();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
import org.opensearch.Version;  
            .routingTable(initialRoutingTable)  
                        newNode(  
        clusterState = allocation.reroute(clusterState, "reroute");
            .metadata(metadata)
/*
            .routingTable(routingTable)
            .metadata(metadata)  
        logger.info("fail the first shard, will start INITIALIZING on the second node");  
        // start primary shards
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            nodeBuilder.add(newNode("node" + Integer.toString(i)));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4));  
        clusterState = ClusterState.builder(clusterState).routingTable(allocation.reroute(clusterState, "reroute").routingTable()).build();
            "REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_VALUE",
            .build();
        Metadata metadata = Metadata.builder()
            );
        );  
                    "test",
            clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            ),
            );
                )
        logger.info("Adding two nodes and performing rerouting");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
        for (final DiscoveryNode cursor : clusterState.nodes().getDataNodes().values()) {  
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));  
        ShardId shardId = new ShardId(metadata.index("test").getIndex(), 0);
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
            .routingTable(routingTable)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));  
            .build();
        // fail primary shard
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        ShardId shardId = new ShardId(metadata.index("test").getIndex(), 0);
            )
        // fail primary shard again  
            primaryShardRouting3.currentNodeId().equals(nonRemoteNode1.getId())
        clusterState = newState;  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        // remote store migration metadata settings  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        }
                .build()
        assertThat(newPrimaryShard, not(equalTo(primaryShardToFail)));  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                .build()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));  
        ShardRouting primaryShardRouting1 = clusterState.routingTable().index("test").shard(0).primaryShard();  
        ShardRouting shardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
        logger.info("--> all shards allocated, replica that should be promoted: {}", startedReplica);
        // fail the primary shard again, and ensure the same thing happens
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4));
import org.opensearch.common.settings.Settings;  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
            primaryShardRouting2.currentNodeId().equals(remoteNode2.getId())
                continue;
            .build();
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);  
        Map<String, String> remoteStoreNodeAttributes = Map.of(  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            );  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
        assertThat(
        AllocationService strategy = createAllocationService(
        }
        assertEquals(expectedCandidateForSegRep.allocationId(), primaryShardRouting3.allocationId());
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
            .nodes(  
        Settings.Builder settingsBuilder = isSegmentReplicationEnabled
            Settings.builder()
        // start all the replicas
            assertThat(  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 * GitHub history for details.
            clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            Version.CURRENT
        ClusterState newState = strategy.reroute(clusterState, "reroute");  
            .build();
import static org.hamcrest.Matchers.nullValue;  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        );
            .build();
                .build();
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), lessThan(3));
            .build();
            Version.CURRENT  
    public void testFailAllReplicasInitializingOnPrimaryFailWhileHavingAReplicaToElect() {
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;  
    private final Logger logger = LogManager.getLogger(FailedShardsRoutingTests.class);  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        while (!clusterState.routingTable().shardsWithState(UNASSIGNED).isEmpty()) {  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        clusterState = strategy.reroute(clusterState, "reroute");  
    public void testPreferReplicaOnRemoteNodeForPrimaryPromotion() {  
    }  
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));  
        );
        );
        }
            );
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
        assertThat(newState, not(equalTo(clusterState)));
        logger.info("--> building initial routing table");
        clusterState = newState;
        }  
            .build();  
import org.opensearch.cluster.node.DiscoveryNode;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
            .build();
        clusterState = allocation.applyFailedShard(
        assertThat(newPrimaryShard.allocationId(), equalTo(startedReplica.allocationId()));  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        for (String failedNode : failedNodes) {
            buildNewFakeTransportAddress(),
                        newNode(  
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
        // add a single node  
            }
        clusterState = newState;  
            remoteStoreNodeAttributes,
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
            );  
            .build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
 */
        logger.info("Adding third node and reroute");
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
            clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),  
}  
            logger.info("failing shard on node [{}]", failedNode);
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(origReplicaNodeId));  
        assertThat(nodeHoldingPrimary2, not(equalTo(nodeHoldingPrimary)));
            false  
        for (FailedShard failedShard : failedShards) {
                    .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED.mode)
        Metadata metadata = Metadata.builder()
            clusterState,  
        );
        clusterState = ClusterState.builder(clusterState)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(STARTED));
            assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4 - (i + 1)));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        Metadata metadata = Metadata.builder()
        assertThat(newState, not(equalTo(clusterState)));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
 * license agreements. See the NOTICE file distributed with
            .build();  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
                anyOf(equalTo("node2"), equalTo("node1"))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        String origReplicaNodeId = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
        newState = strategy.reroute(clusterState, "reroute");  
                .build()
 * software distributed under the License is distributed on an
                .build()
                            "node4-old",
        logger.info("--> failing primary shard a second time, should select: {}", startedReplica);  
        final String nodeHoldingPrimary = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();  
        // verify that promoted replica again exists on a remote node  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .build()  
        assertThat(newPrimaryShard, not(equalTo(primaryShardToFail)));
            if (!routingNodes.node(failedNode).isEmpty()) {
 */  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
import org.opensearch.common.UUIDs;
        );
        logger.info("Adding {} nodes and performing rerouting", numberOfReplicas + 1);  
                            "node3-old",
    }
        // add 4 nodes  
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
                failedShard.getRoutingEntry().allocationId().getId()
 */  
        Metadata metadata = Metadata.builder()
/*  
        clusterState = strategy.applyFailedShards(clusterState, failedShards);
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
        clusterState = newState;
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
        testReplicaIsPromoted(false);
        assertNotNull(replicaNodeVersion);
        );
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), nullValue());  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), lessThan(3));  
        assertNotEquals(primaryShardRouting1.currentNodeId(), primaryShardRouting2.currentNodeId());
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
 * this work for additional information regarding copyright
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;  
        // verify that promoted replica exists on a non-remote node
                    "test",
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
        logger.info("Adding two nodes and performing rerouting");
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 * Unless required by applicable law or agreed to in writing,
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShardToFail, randomBoolean());  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
            assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        // start the shards, should have 1 primary and 1 replica available  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
        int numberOfReplicas = scaledRandomIntBetween(2, 10);  
            );
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
        assertThat(newPrimaryShard.allocationId(), equalTo(startedReplica.allocationId()));
            )
        Metadata metadata = Metadata.builder()
        clusterState = newState;
        AllocationService strategy = createAllocationService(  
                anyOf(equalTo("node2"), equalTo("node1"))
import org.opensearch.core.index.shard.ShardId;
            .nodes(DiscoveryNodes.builder().add(newNode("node1-1.0", Version.fromString("1.0.0"))))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        }  
    public void testFailAllReplicasInitializingOnPrimaryFail() {
                    )
                DiscoveryNodes.builder(clusterState.nodes())
        // fail the primary shard again and make sure the correct replica is promoted
            .routingTable(initialRoutingTable)
                fail("shard was re-assigned to failed node " + failedNode);  
                    .add(
        newState = allocation.applyFailedShard(clusterState, primaryShardRouting2, randomBoolean());
            assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4 - (i + 1)));  
        clusterState = newState;
            assertTrue(
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),  
import org.opensearch.indices.replication.common.ReplicationType;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            .metadata(metadata)  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));  
        }  
        routingNodes = clusterState.getRoutingNodes();  
                    )
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShard0, randomBoolean());  
        ShardRouting shardToFail = routingNodes.node("node3").iterator().next();
        assertTrue(
            .metadata(metadata)
        );
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            if (shardRoutingsToFail.contains(shardToFail) == false) {
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))  
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShardToFail, randomBoolean());
            .build();
        // verify that promoted replica exists on a remote node
                )  
        startedReplica = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
 *
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        logger.info("fail the primary shard, will have no place to be rerouted to (single node), so stays unassigned");  
        AllocationService strategy = createAllocationService(
                    .add(
        );
        // the primary gets allocated on another node  
    public void testFirstAllocationFailureTwoNodes() {
            .build();  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    "node3"
                anyOf(equalTo("node1"), equalTo("node2"))
        clusterState = newState;
        Metadata metadata = Metadata.builder()
            .build();
            not(equalTo(shardToFail.currentNodeId()))
                anyOf(equalTo("node2"), equalTo("node1"))
                // Skip the node that the primary was on, it doesn't have a replica so doesn't need a version check
        newState = strategy.applyFailedShard(clusterState, firstShard, randomBoolean());  
            .routingTable(initialRoutingTable)
        clusterState = allocation.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
                || primaryShardRouting2.currentNodeId().equals(remoteNode3.getId())  
        logger.info("Start the shards (primaries)");
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
