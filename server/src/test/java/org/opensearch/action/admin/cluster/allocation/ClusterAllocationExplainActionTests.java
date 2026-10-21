        );
        expectThrows(IllegalArgumentException.class, () -> findShardToExplain(failingRequest, allocation));
                    } else {
        ShardRouting searchOnlyShard = ShardRouting.newUnassigned(
 * not use this file except in compliance with the License.
            null,
        assertFalse(cae.getShardAllocationDecision().getAllocateDecision().isDecisionTaken());
 *    http://www.apache.org/licenses/LICENSE-2.0
            new AllocationDeciders(Collections.emptyList()),
        ShardRouting shard = findShardToExplain(request, routingAllocation(clusterState));
        ShardRouting shard = clusterState.getRoutingTable().index("idx").shard(0).primaryShard();
        }
                + "\"},\"explanation\":\""
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), randomFrom(ShardRoutingState.values()));
        ShardRouting shard = findShardToExplain(request, routingAllocation(clusterState));
    private static final AllocationDeciders NOOP_DECIDERS = new AllocationDeciders(Collections.emptyList());
            IllegalArgumentException.class,
 * Tests for the {@link TransportClusterAllocationExplainAction} class.
        request = new ClusterAllocationExplainRequest();
        shard = findShardToExplain(request, routingAllocation(clusterState));
        ShardRouting foundShard = findShardToExplain(request, allocation);
                + "{\"id\":\""
        );
 * The OpenSearch Contributors require contributions made to
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, primary, shardToExplain.currentNodeId());
                .index("idx")
 * this work for additional information regarding copyright
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, false, null);
        ClusterState clusterState = searchOnlyClusterState();
 * compatible open source license.
        return new RoutingAllocation(NOOP_DECIDERS, clusterState.getRoutingNodes(), clusterState, null, null, System.nanoTime());
        ShardRoutingState[] replicaStates = new ShardRoutingState[0];
            () -> findShardToExplain(request, routingAllocation(clusterState))
import org.opensearch.common.xcontent.XContentFactory;
            true,
                + cae.getCurrentNode().getId()
            shard
                public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
                            Instant.ofEpochMilli(shard.unassignedInfo().getUnassignedTimeInMillis())
            clusterState.getRoutingNodes(),
        // find unassigned replica
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
                        + "\","
        // shard is not assigned to given node
}
import org.opensearch.cluster.routing.allocation.AllocationService;
    public void testInitializingOrRelocatingShardExplanation() throws Exception {
        // find unassigned primary
                + "\",\"transport_address\":\""
 *
            }, null, null)
                }
        if (primary == false) {
                    if (shard.initializing() || shard.relocating()) {
import java.time.Instant;
        RoutingAllocation allocation = routingAllocation(clusterState);
 *
        clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED, ShardRoutingState.UNASSIGNED);
    }
    private static ClusterState searchOnlyClusterState() {
            explanation = "the shard is in the process of relocating from node [] to node [], wait until " + "relocation has completed";
        // find shard with given node
 * KIND, either express or implied.  See the License for the
        return ClusterState.builder(ClusterName.DEFAULT)
            "idx",
            replicaStates = new ShardRoutingState[] { ShardRoutingState.STARTED };
        ClusterState clusterState = ClusterStateCreationUtils.state(
        expectThrows(
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "search-only shard")
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.core.xcontent.XContentBuilder;
                + "\",\"name\":\""
            false,
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest();
                + shardRoutingState.toString().toLowerCase(Locale.ROOT)
            ShardRoutingState.STARTED
                        )
                        return ShardAllocationDecision.NOT_TAKEN;
                    // no-op
                        + shard.unassignedInfo().getReason()
        assertEquals(shard.currentNodeId(), cae.getCurrentNode().getId());
        for (RoutingNode routingNode : clusterState.getRoutingNodes()) {
        String explainNode = null;
                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            }
            clusterState,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.routing.IndexRoutingTable;
 * Unless required by applicable law or agreed to in writing,
        );
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        IllegalArgumentException exception = expectThrows(
                .stream()
            : clusterState.getRoutingTable().index("idx").shard(0).replicaShards().get(0);
                .shard(0)
                .findFirst()
 */
        String explanation;
    public void testFindShardAssignedToNode() {
        Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
    }
        );
    }
                .get(),
                .replicaShards()
            .build();
            System.nanoTime()
            "{\"index\":\"idx\",\"shard\":0,\"primary\":true,\"current_state\":\""
import org.opensearch.cluster.ClusterName;
                + ",\"current_node\":"
                + "\"}",
        );
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), shardRoutingState);
            if (routingNode.nodeId().equals(shardToExplain.currentNodeId()) == false) {
        // no unassigned shard to explain
 */
        final ClusterAllocationExplainRequest anyUnassignedShardsRequest = new ClusterAllocationExplainRequest();
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
    }
            new ShardId(indexMetadata.getIndex(), 0),
                @Override
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
/**
 */
        } else {
 * GitHub history for details.
import static org.opensearch.action.admin.cluster.allocation.TransportClusterAllocationExplainAction.findShardToExplain;
public class ClusterAllocationExplainActionTests extends OpenSearchTestCase {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testFindAnyReplicaToExplain() {
            ShardRoutingState.STARTED,
        );
        if (shardRoutingState == ShardRoutingState.RELOCATING) {
        assertEquals(
        assertEquals(shardToExplain, foundShard);
            randomBoolean(),
        ShardRouting shardToExplain = primary
        );
import org.opensearch.test.gateway.TestGatewayAllocator;
            ? clusterState.getRoutingTable().index("idx").shard(0).primaryShard()
                        + "\"last_allocation_status\":\""
        ClusterAllocationExplanation cae = TransportClusterAllocationExplainAction.explainShard(
            IllegalArgumentException.class,
                        + "\","
import org.opensearch.test.OpenSearchTestCase;
            builder.toString()
                + (shard.unassignedInfo() != null
            ShardRoutingState.STARTED,
                + cae.getCurrentNode().getName()
            .nodes(DiscoveryNodes.builder().add(node).localNodeId(node.getId()))
                    ? ",\"unassigned_info\":{"
        );
        final ClusterState allStartedClusterState = ClusterStateCreationUtils.state(
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(indexMetadata.getIndex()).addShard(searchOnlyShard).build();
        DiscoveryNode node = new DiscoveryNode("node-1", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
            null,
            .routingTable(RoutingTable.builder().add(indexRoutingTable).build())
        // prefer unassigned replicas to started replicas
            randomBoolean(),
        assertEquals(
            allocation,
            shard,
import org.opensearch.Version;
        RoutingAllocation allocation = new RoutingAllocation(
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
        assertFalse(cae.getShardAllocationDecision().getMoveDecision().isDecisionTaken());
import org.opensearch.cluster.routing.RecoverySource;
    public void testFindPrimaryShardToExplain() {
        assertEquals(clusterState.getRoutingTable().index("idx").shard(0).replicaShards().get(0), shard);
 * SPDX-License-Identifier: Apache-2.0
        shard = findShardToExplain(request, routingAllocation(clusterState));
                + cae.getCurrentNode().getAddress()
import org.opensearch.core.index.shard.ShardId;
import java.util.Collections;
/*
import org.opensearch.core.xcontent.ToXContent;
        XContentBuilder builder = XContentFactory.jsonBuilder();
                .filter(ShardRouting::unassigned)
            randomBoolean(),
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED, replicaStates);
            clusterState.getRoutingTable()
            explanation = "the shard is in the process of initializing on node [], " + "wait until initialization has completed";
    }
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            "idx",
                        + "\"at\":\""
import org.opensearch.cluster.ClusterState;
        }
import org.opensearch.cluster.routing.ShardRoutingState;
            .metadata(metadata)
/*
        final boolean primary = randomBoolean();
 * this file be licensed under the Apache-2.0 license or a
            randomBoolean(),
import org.opensearch.cluster.metadata.IndexMetadata;
    }
 *
                    }
        cae.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertFalse(cae.getShardAllocationDecision().isDecisionTaken());
        // prefer started replicas to initializing/relocating replicas
        ShardRouting shard = findShardToExplain(request, routingAllocation(clusterState));
import org.opensearch.cluster.routing.allocation.AllocationDecision;
            .settings(
package org.opensearch.action.admin.cluster.allocation;
        }
        assertEquals(clusterState.getRoutingTable().index("idx").shard(0).primaryShard(), shard);
        );
import org.opensearch.cluster.metadata.Metadata;
            () -> findShardToExplain(anyUnassignedShardsRequest, routingAllocation(allStartedClusterState))
        IndexMetadata indexMetadata = IndexMetadata.builder("idx")
        clusterState = ClusterStateCreationUtils.state(
 */
        final ClusterAllocationExplainRequest failingRequest = new ClusterAllocationExplainRequest("idx", 0, primary, explainNode);
import org.opensearch.common.settings.Settings;
import java.util.Locale;
            "idx",
                }
        );
    private static RoutingAllocation routingAllocation(ClusterState clusterState) {
                        throw new UnsupportedOperationException("cannot explain");
            ShardRoutingState.STARTED,
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
                + explanation
            ShardRoutingState.STARTED,
                Settings.builder()
                break;
        request = new ClusterAllocationExplainRequest("idx", 0, false, null);
    public void testFindAnyUnassignedShardToExplain() {
    public void testFindPrimaryShardToExplainWithNoPrimaryShard() {
                @Override
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            shard
                    : "")
                        + AllocationDecision.fromAllocationStatus(shard.unassignedInfo().getLastAllocationStatus())
            .build();
                public void allocate(RoutingAllocation allocation) {
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.node.DiscoveryNodes;
            )
                + "\""
import org.opensearch.cluster.node.DiscoveryNode;
            randomFrom(ShardRoutingState.RELOCATING, ShardRoutingState.INITIALIZING),
import org.opensearch.cluster.routing.UnassignedInfo;
                explainNode = routingNode.nodeId();
/*
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, true, "node-1");
            new AllocationService(null, new TestGatewayAllocator(), new ShardsAllocator() {
        ShardRoutingState shardRoutingState = randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.RELOCATING);
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.UNASSIGNED);
        assertTrue(exception.getMessage().contains("unable to find primary shard to explain"));
                        + UnassignedInfo.DATE_TIME_FORMATTER.format(
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, true, null);
        assertEquals(clusterState.getRoutingTable().index("idx").shard(0).primaryShard(), shard);
 * ownership. Elasticsearch licenses this file to you under
            clusterState.getRoutingTable().index("idx").shard(0).replicaShards().stream().filter(ShardRouting::started).findFirst().get(),
            ShardRoutingState.UNASSIGNED
        assertEquals(
    }
import org.opensearch.cluster.routing.RoutingTable;
            null,
        );
            ShardRoutingState.STARTED
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.RoutingNode;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        + "\"}"
                        + "\"reason\":\""
 * under the License.
