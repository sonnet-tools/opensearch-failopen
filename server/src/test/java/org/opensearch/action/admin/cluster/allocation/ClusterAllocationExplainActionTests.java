                public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
            ShardRoutingState.STARTED  
        String explanation;
        ShardRouting shard = clusterState.getRoutingTable().index("idx").shard(0).primaryShard();
        shard = findShardToExplain(request, routingAllocation(clusterState));  
                    .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)  
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        for (RoutingNode routingNode : clusterState.getRoutingNodes()) {
            new ShardId(indexMetadata.getIndex(), 0),
        request = new ClusterAllocationExplainRequest("idx", 0, false, null);
import static org.opensearch.action.admin.cluster.allocation.TransportClusterAllocationExplainAction.findShardToExplain;
/*  
        assertEquals(clusterState.getRoutingTable().index("idx").shard(0).replicaShards().get(0), shard);  
                        + AllocationDecision.fromAllocationStatus(shard.unassignedInfo().getLastAllocationStatus())
        );
        if (primary == false) {
                .index("idx")
        return ClusterState.builder(ClusterName.DEFAULT)
            clusterState,
            explanation = "the shard is in the process of relocating from node [] to node [], wait until " + "relocation has completed";
public class ClusterAllocationExplainActionTests extends OpenSearchTestCase {  
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
        );  
                .get(),
            true,  
        expectThrows(
}
/*
            randomBoolean(),
        DiscoveryNode node = new DiscoveryNode("node-1", buildNewFakeTransportAddress(), Version.CURRENT);  
            System.nanoTime()
        );  
            clusterState.getRoutingNodes(),
import org.opensearch.cluster.routing.RoutingTable;  
                .filter(ShardRouting::unassigned)  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        // prefer unassigned replicas to started replicas
    public void testFindAnyReplicaToExplain() {
 * license agreements. See the NOTICE file distributed with
        cae.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.core.xcontent.XContentBuilder;
            builder.toString()  
                        + "\","
                + cae.getCurrentNode().getId()
        );  
                        + "\"}"  
                        + "\"last_allocation_status\":\""
                + explanation
        assertEquals(
 */
        final ClusterAllocationExplainRequest failingRequest = new ClusterAllocationExplainRequest("idx", 0, primary, explainNode);
            randomBoolean(),
    }  
                + "{\"id\":\""  
 * specific language governing permissions and limitations
            shard,
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(indexMetadata.getIndex()).addShard(searchOnlyShard).build();
        // prefer started replicas to initializing/relocating replicas  
        assertFalse(cae.getShardAllocationDecision().getAllocateDecision().isDecisionTaken());
                    }  
        // find shard with given node
import org.opensearch.cluster.node.DiscoveryNodes;
                        + UnassignedInfo.DATE_TIME_FORMATTER.format(  
                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
    }
    private static RoutingAllocation routingAllocation(ClusterState clusterState) {
            false,
import org.opensearch.test.gateway.TestGatewayAllocator;
                + (shard.unassignedInfo() != null  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.UNASSIGNED);  
                    // no-op  
                + cae.getCurrentNode().getAddress()
        assertEquals(
            null,
            randomBoolean(),
        clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED, ShardRoutingState.UNASSIGNED);  
    }
        // find unassigned replica
        );
import org.opensearch.cluster.routing.RoutingNode;
            )
        assertFalse(cae.getShardAllocationDecision().getMoveDecision().isDecisionTaken());
        expectThrows(IllegalArgumentException.class, () -> findShardToExplain(failingRequest, allocation));
                }
        );
        RoutingAllocation allocation = routingAllocation(clusterState);
        }
    private static ClusterState searchOnlyClusterState() {  
 * The OpenSearch Contributors require contributions made to  
        return new RoutingAllocation(NOOP_DECIDERS, clusterState.getRoutingNodes(), clusterState, null, null, System.nanoTime());  
package org.opensearch.action.admin.cluster.allocation;
/**  
                + shardRoutingState.toString().toLowerCase(Locale.ROOT)
            replicaStates = new ShardRoutingState[] { ShardRoutingState.STARTED };  
            "idx",
        assertTrue(exception.getMessage().contains("unable to find primary shard to explain"));
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, false, null);
    public void testFindShardAssignedToNode() {
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, true, "node-1");
                        throw new UnsupportedOperationException("cannot explain");
        ClusterState clusterState = searchOnlyClusterState();  
            .settings(
            ShardRoutingState.STARTED,
                    if (shard.initializing() || shard.relocating()) {
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        }  
            clusterState.getRoutingTable().index("idx").shard(0).replicaShards().stream().filter(ShardRouting::started).findFirst().get(),
 *
                + "\",\"transport_address\":\""
        final ClusterAllocationExplainRequest anyUnassignedShardsRequest = new ClusterAllocationExplainRequest();  
        ShardRouting foundShard = findShardToExplain(request, allocation);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .shard(0)  
        IndexMetadata indexMetadata = IndexMetadata.builder("idx")
        ShardRouting searchOnlyShard = ShardRouting.newUnassigned(  
 */
                        + "\","  
        RoutingAllocation allocation = new RoutingAllocation(
        String explainNode = null;  
        ClusterState clusterState = ClusterStateCreationUtils.state(  
        assertFalse(cae.getShardAllocationDecision().isDecisionTaken());  
import org.opensearch.cluster.routing.UnassignedInfo;  
/*  
 * Modifications Copyright OpenSearch Contributors. See
            }
            if (routingNode.nodeId().equals(shardToExplain.currentNodeId()) == false) {
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.common.settings.Settings;
        XContentBuilder builder = XContentFactory.jsonBuilder();  
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest();
                        + "\"at\":\""
            randomBoolean(),  
 * the Apache License, Version 2.0 (the "License"); you may
                explainNode = routingNode.nodeId();  
import org.opensearch.cluster.ClusterState;
                        + "\"reason\":\""
        ClusterAllocationExplanation cae = TransportClusterAllocationExplainAction.explainShard(
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
            ShardRoutingState.STARTED,  
            () -> findShardToExplain(request, routingAllocation(clusterState))
        ShardRouting shard = findShardToExplain(request, routingAllocation(clusterState));
 * under the License.  
    public void testFindAnyUnassignedShardToExplain() {
                .stream()
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "search-only shard")
import java.util.Locale;
        assertEquals(  
        assertEquals(clusterState.getRoutingTable().index("idx").shard(0).primaryShard(), shard);
            .routingTable(RoutingTable.builder().add(indexRoutingTable).build())
    }
                        )
import org.opensearch.cluster.ClusterName;  
        final ClusterState allStartedClusterState = ClusterStateCreationUtils.state(  
        } else {
                Settings.builder()  
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, primary, shardToExplain.currentNodeId());  
            : clusterState.getRoutingTable().index("idx").shard(0).replicaShards().get(0);
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), randomFrom(ShardRoutingState.values()));
    }  
        if (shardRoutingState == ShardRoutingState.RELOCATING) {  
        request = new ClusterAllocationExplainRequest();
        );
            new AllocationDeciders(Collections.emptyList()),  
        IllegalArgumentException exception = expectThrows(  
import org.opensearch.cluster.routing.ShardRouting;
            randomFrom(ShardRoutingState.RELOCATING, ShardRoutingState.INITIALIZING),
            "idx",
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
                .findFirst()
        shard = findShardToExplain(request, routingAllocation(clusterState));
        );  
import org.opensearch.cluster.routing.ShardRoutingState;
        ShardRouting shardToExplain = primary  
        ClusterAllocationExplainRequest request = new ClusterAllocationExplainRequest("idx", 0, true, null);  
        assertEquals(shardToExplain, foundShard);  
            .build();  
 * Licensed to Elasticsearch under one or more contributor  
            ShardRoutingState.STARTED,
            ? clusterState.getRoutingTable().index("idx").shard(0).primaryShard()
        assertEquals(clusterState.getRoutingTable().index("idx").shard(0).primaryShard(), shard);  
import org.opensearch.cluster.metadata.Metadata;  
                            Instant.ofEpochMilli(shard.unassignedInfo().getUnassignedTimeInMillis())
        assertEquals(shard.currentNodeId(), cae.getCurrentNode().getId());
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.test.OpenSearchTestCase;  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
            shard  
    }
                public void allocate(RoutingAllocation allocation) {
 * this file be licensed under the Apache-2.0 license or a
            .build();
            () -> findShardToExplain(anyUnassignedShardsRequest, routingAllocation(allStartedClusterState))  
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), shardRoutingState);  
 * GitHub history for details.
                + cae.getCurrentNode().getName()  
    public void testInitializingOrRelocatingShardExplanation() throws Exception {
            ShardRoutingState.UNASSIGNED
 * not use this file except in compliance with the License.
import org.opensearch.Version;
 * Unless required by applicable law or agreed to in writing,
                break;
            ShardRoutingState.STARTED,  
                    : "")
                + "\""
            ShardRoutingState.STARTED
                    .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            explanation = "the shard is in the process of initializing on node [], " + "wait until initialization has completed";  
            shard  
 */  
                + "\"}",
                    } else {
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
            clusterState.getRoutingTable()
                + ",\"current_node\":"
                        return ShardAllocationDecision.NOT_TAKEN;  
 * ownership. Elasticsearch licenses this file to you under  
            null,  
                        + shard.unassignedInfo().getReason()  
import org.opensearch.cluster.routing.IndexRoutingTable;  
            }, null, null)
 */  
import org.opensearch.core.index.shard.ShardId;  
import java.time.Instant;  
        ShardRoutingState[] replicaStates = new ShardRoutingState[0];
                @Override  
 * KIND, either express or implied.  See the License for the
            IllegalArgumentException.class,
 *  
        }
        ShardRouting shard = findShardToExplain(request, routingAllocation(clusterState));
            IllegalArgumentException.class,
    public void testFindPrimaryShardToExplain() {
    private static final AllocationDeciders NOOP_DECIDERS = new AllocationDeciders(Collections.emptyList());
        ShardRouting shard = findShardToExplain(request, routingAllocation(clusterState));
                @Override
        );  
import org.opensearch.cluster.node.DiscoveryNode;
        ShardRoutingState shardRoutingState = randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.RELOCATING);
            "{\"index\":\"idx\",\"shard\":0,\"primary\":true,\"current_state\":\""  
                    ? ",\"unassigned_info\":{"
                }
import org.opensearch.cluster.routing.allocation.AllocationService;
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED, replicaStates);
 * SPDX-License-Identifier: Apache-2.0
        );
    }
    }
            new AllocationService(null, new TestGatewayAllocator(), new ShardsAllocator() {  
                + "\",\"name\":\""
 * this work for additional information regarding copyright
        // no unassigned shard to explain
import org.opensearch.cluster.routing.RecoverySource;
        );
        clusterState = ClusterStateCreationUtils.state(
 *
        Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
            .metadata(metadata)  
                + "\"},\"explanation\":\""  
            null,
            .nodes(DiscoveryNodes.builder().add(node).localNodeId(node.getId()))
        final boolean primary = randomBoolean();  
                .replicaShards()
        // shard is not assigned to given node
import org.opensearch.cluster.metadata.IndexMetadata;
 * Tests for the {@link TransportClusterAllocationExplainAction} class.
        // find unassigned primary
            allocation,  
    public void testFindPrimaryShardToExplainWithNoPrimaryShard() {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * compatible open source license.
            "idx",
