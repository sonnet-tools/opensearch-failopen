 * this file be licensed under the Apache-2.0 license or a
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomIntBetween(2, 4), 1);
                            emptyMap(),
                            Version.CURRENT  
 * GitHub history for details.
package org.opensearch.cluster.routing.allocation;
import org.opensearch.cluster.routing.ShardRoutingState;
                            "test1",  
                        new DiscoveryNode(  
                            buildNewFakeTransportAddress(),  
import java.util.Collections;  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        );
        }
        Index index = clusterState.getMetadata().index("idx").getIndex();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                            buildNewFakeTransportAddress(),
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(Decision.Type.YES, decision.type());
        Decision decision = decider.canForceAllocatePrimary(newPrimary, routingNode, routingAllocation);
 * Unless required by applicable law or agreed to in writing,
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.STARTED), equalTo(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();
 */  
 */
import org.opensearch.cluster.routing.RoutingNodes;
import org.opensearch.cluster.node.DiscoveryNodes;  
                break;  
                            buildNewFakeTransportAddress(),  
                        )
 * not use this file except in compliance with the License.
            if (node.isEmpty()) {
}  
            assertThat(shardRouting.currentNodeId(), equalTo("node3"));
/*  
                        new DiscoveryNode(
        RoutingNode routingNode = clusterState.getRoutingNodes().node(primaryShard.currentNodeId());
                            emptyMap(),
 * SPDX-License-Identifier: Apache-2.0
                            "node3",
    public void testForceAllocatePrimaryOnSameNodeNotAllowed() {
import org.opensearch.Version;  
import static org.hamcrest.Matchers.equalTo;
        logger.info("--> add another node, with a different host, replicas will be allocating");
import org.opensearch.cluster.routing.allocation.decider.Decision;
import org.opensearch.cluster.node.DiscoveryNode;
import org.apache.logging.log4j.Logger;
 * specific language governing permissions and limitations
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.STARTED), equalTo(2));
            clusterState,
                            "test1",
 *
            Settings.builder().put(SameShardAllocationDecider.CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey(), true).build()  
                            emptyMap(),
 *
        decision = decider.canForceAllocatePrimary(newPrimary, unassignedNode, routingAllocation);  
            .metadata(metadata)  
                    .add(  
import org.opensearch.common.settings.ClusterSettings;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    public void testSameHost() {
        RoutingNode unassignedNode = null;
import org.opensearch.cluster.metadata.Metadata;
            )
        ShardRouting newPrimary = TestShardRouting.newShardRouting(primaryShard.shardId(), null, true, ShardRoutingState.UNASSIGNED);  
                            "node2",
                            CLUSTER_MANAGER_DATA_ROLES,
                DiscoveryNodes.builder()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * You may obtain a copy of the License at  
    private final Logger logger = LogManager.getLogger(SameShardRoutingTests.class);
                        )
import org.opensearch.cluster.routing.RoutingTable;  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
import org.opensearch.cluster.routing.ShardRouting;
                DiscoveryNodes.builder(clusterState.nodes())
        // can force allocate to a different node
            .build();
                            CLUSTER_MANAGER_DATA_ROLES,
/*  
        SameShardAllocationDecider decider = new SameShardAllocationDecider(  
        AllocationService strategy = createAllocationService(
import org.apache.logging.log4j.LogManager;
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        RoutingAllocation routingAllocation = new RoutingAllocation(
                            "node1",
        );  
                        new DiscoveryNode(  
            Settings.EMPTY,
        logger.info("--> start all primary shards, no replica will be started since its on the same host");
                            "test1",
            .build();
        clusterState = ClusterState.builder(clusterState)
                unassignedNode = node;
            new RoutingNodes(clusterState, false),
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;  
                    )  
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.INITIALIZING), equalTo(2));
                    .add(
import org.opensearch.core.index.Index;  
            .nodes(  
            System.nanoTime()
import org.opensearch.snapshots.SnapshotShardSizeInfo;
import org.opensearch.cluster.routing.RoutingNode;
                            "node3",  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        }
import static org.opensearch.cluster.routing.allocation.RoutingNodesUtils.numberOfShardsOfType;
            )  
 *  
            ClusterInfo.EMPTY,  
                    )
                    )
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.routing.TestShardRouting;  
 * under the License.  
                            "node3",
import org.opensearch.cluster.ClusterInfo;
        Metadata metadata = Metadata.builder()  
            .build();
 * ownership. Elasticsearch licenses this file to you under  
                            Version.CURRENT
                            "node1",
        logger.info("--> adding two nodes with the same host");
        assertEquals(Decision.Type.NO, decision.type());
                            Version.CURRENT  
    }  
public class SameShardRoutingTests extends OpenSearchAllocationTestCase {
                            "node1",  
/*
                            CLUSTER_MANAGER_DATA_ROLES,  
import static java.util.Collections.emptyMap;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexMetadata;  
        );  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
                    .add(
                            "test2",
 * KIND, either express or implied.  See the License for the
        clusterState = ClusterState.builder(clusterState)
                            "test2",
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.INITIALIZING), equalTo(2));
                            "node2",
        for (RoutingNode node : clusterState.getRoutingNodes()) {  
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().shardsWithState(INITIALIZING)) {  
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.INITIALIZING), equalTo(0));
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = strategy.reroute(clusterState, "reroute");
 * compatible open source license.
            .nodes(  
        clusterState = strategy.reroute(clusterState, "reroute");  
                            "node2",  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
                        )
        ShardRouting primaryShard = clusterState.routingTable().index(index).shard(0).primaryShard();  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            }
            new AllocationDeciders(Collections.emptyList()),  
            SnapshotShardSizeInfo.EMPTY,
import org.opensearch.cluster.ClusterState;
        // can't force allocate same shard copy to the same node
                            "test1",
import org.opensearch.cluster.ClusterName;  
 */  
            .routingTable(routingTable)
 * Licensed to Elasticsearch under one or more contributor  
