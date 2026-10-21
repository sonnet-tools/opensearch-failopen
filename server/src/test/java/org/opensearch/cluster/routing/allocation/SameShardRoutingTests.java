        // can force allocate to a different node
import org.opensearch.common.settings.Settings;
 * GitHub history for details.
                    .add(
                            buildNewFakeTransportAddress(),
                            "node3",
                        )
        }
 * ownership. Elasticsearch licenses this file to you under
 *
        logger.info("--> start all primary shards, no replica will be started since its on the same host");
package org.opensearch.cluster.routing.allocation;
        clusterState = strategy.reroute(clusterState, "reroute");
            Settings.EMPTY,
import org.opensearch.Version;
import org.opensearch.cluster.routing.RoutingTable;
            .build();
            }
import java.util.Collections;
import org.apache.logging.log4j.Logger;
            new RoutingNodes(clusterState, false),
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
    private final Logger logger = LogManager.getLogger(SameShardRoutingTests.class);
                            CLUSTER_MANAGER_DATA_ROLES,
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.STARTED), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute");
            )
 * KIND, either express or implied.  See the License for the
                            CLUSTER_MANAGER_DATA_ROLES,
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.STARTED), equalTo(2));
 * Unless required by applicable law or agreed to in writing,
                            "node3",
import org.opensearch.cluster.ClusterInfo;
        SameShardAllocationDecider decider = new SameShardAllocationDecider(
            new AllocationDeciders(Collections.emptyList()),
                            "test2",
import org.opensearch.cluster.routing.ShardRoutingState;
            .build();
        logger.info("--> add another node, with a different host, replicas will be allocating");
        }
import static org.hamcrest.Matchers.equalTo;
        RoutingAllocation routingAllocation = new RoutingAllocation(
            )
/*
                        new DiscoveryNode(
import org.opensearch.common.settings.ClusterSettings;
                            Version.CURRENT
import org.opensearch.cluster.ClusterName;
        // can't force allocate same shard copy to the same node
import static java.util.Collections.emptyMap;
public class SameShardRoutingTests extends OpenSearchAllocationTestCase {
                            "node1",
                            "test1",
                            Version.CURRENT
        ShardRouting primaryShard = clusterState.routingTable().index(index).shard(0).primaryShard();
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.snapshots.SnapshotShardSizeInfo;
                    .add(
                            "test1",
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().shardsWithState(INITIALIZING)) {
            .routingTable(routingTable)
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> adding two nodes with the same host");
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at
                unassignedNode = node;
 * under the License.
        assertEquals(Decision.Type.NO, decision.type());
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import org.opensearch.cluster.node.DiscoveryNodes;
        );
import org.opensearch.cluster.routing.RoutingNodes;
                    .add(
import org.opensearch.cluster.routing.allocation.decider.Decision;
        );
 * license agreements. See the NOTICE file distributed with
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                            buildNewFakeTransportAddress(),
                            "test1",
                    )
                            emptyMap(),
            .nodes(
        AllocationService strategy = createAllocationService(
 */
        RoutingNode routingNode = clusterState.getRoutingNodes().node(primaryShard.currentNodeId());
/*
 */
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.INITIALIZING), equalTo(2));
                            buildNewFakeTransportAddress(),
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.INITIALIZING), equalTo(2));
                        new DiscoveryNode(
            ClusterInfo.EMPTY,
 * not use this file except in compliance with the License.
                    )
            .nodes(
        Index index = clusterState.getMetadata().index("idx").getIndex();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        Decision decision = decider.canForceAllocatePrimary(newPrimary, routingNode, routingAllocation);
 * Modifications Copyright OpenSearch Contributors. See
            if (node.isEmpty()) {
import static org.opensearch.cluster.routing.allocation.RoutingNodesUtils.numberOfShardsOfType;
        assertEquals(Decision.Type.YES, decision.type());
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomIntBetween(2, 4), 1);
            assertThat(shardRouting.currentNodeId(), equalTo("node3"));
        clusterState = ClusterState.builder(clusterState)
                            CLUSTER_MANAGER_DATA_ROLES,
        for (RoutingNode node : clusterState.getRoutingNodes()) {
 * this file be licensed under the Apache-2.0 license or a
                            "node2",
    }
                            "test2",
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
    public void testForceAllocatePrimaryOnSameNodeNotAllowed() {
        assertThat(numberOfShardsOfType(clusterState.getRoutingNodes(), ShardRoutingState.INITIALIZING), equalTo(0));
            .build();
 *
            .build();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                break;
import org.apache.logging.log4j.LogManager;
            .metadata(metadata)
                        )
            clusterState,
                    )
                            "test1",
 * compatible open source license.
        decision = decider.canForceAllocatePrimary(newPrimary, unassignedNode, routingAllocation);
 * specific language governing permissions and limitations
 */
import org.opensearch.cluster.routing.ShardRouting;
        clusterState = ClusterState.builder(clusterState)
 * software distributed under the License is distributed on an
}
                DiscoveryNodes.builder(clusterState.nodes())
 *
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.node.DiscoveryNode;
                        new DiscoveryNode(
import org.opensearch.cluster.routing.RoutingNode;
import org.opensearch.cluster.metadata.Metadata;
                            "node3",
                            Version.CURRENT
                        )
            Settings.builder().put(SameShardAllocationDecider.CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey(), true).build()
                            emptyMap(),
            System.nanoTime()
import org.opensearch.cluster.routing.TestShardRouting;
                DiscoveryNodes.builder()
                            "node2",
                            "node1",
import org.opensearch.core.index.Index;
        RoutingNode unassignedNode = null;
        ShardRouting newPrimary = TestShardRouting.newShardRouting(primaryShard.shardId(), null, true, ShardRoutingState.UNASSIGNED);
/*
 * The OpenSearch Contributors require contributions made to
                            emptyMap(),
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                            "node2",
 * the Apache License, Version 2.0 (the "License"); you may
            SnapshotShardSizeInfo.EMPTY,
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                            "node1",
    public void testSameHost() {
