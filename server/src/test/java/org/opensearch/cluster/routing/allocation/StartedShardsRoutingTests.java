            .settings(settings(Version.CURRENT))
            initShard + "isn't started \ncurrent routing table:" + newState.routingTable(),
        ClusterState.Builder stateBuilder = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(shardRouting.relocatingNodeId(), nullValue());
import static org.hamcrest.Matchers.nullValue;
        if (relocatingReplica) {
            replicaId = AllocationId.newRelocation(replicaId);
/*
        newState = startShardsAndReroute(allocation, state, startedShards);
                0,
    public void testRelocatingPrimariesWithInitializingReplicas() {
import org.opensearch.core.index.shard.ShardId;
        startedShards.add(relocatingReplica ? replica.getTargetRelocatingShard() : replica);
        logger.info("--> test starting of shard");
 */
        }
                            new IndexShardRoutingTable.Builder(relocatingPrimary.shardId()).addShard(relocatingPrimary)
 * under the License.
            primaryId
        assertThat("failed to start " + initShard + "\ncurrent routing table:" + newState.routingTable(), newState, not(equalTo(state)));
            )
                relocatingReplica ? Sets.newHashSet(primaryId.getId(), replicaId.getId()) : Sets.newHashSet(primaryId.getId())
            assertNotEquals(replica.allocationId().getRelocationId(), startedReplica.allocationId().getRelocationId());
            .putInSyncAllocationIds(1, Collections.singleton(allocationId.getId()))
            relocatingReplica ? ShardRoutingState.RELOCATING : ShardRoutingState.INITIALIZING,
            "node2",
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertNotEquals(newState, state);
            assertEquals(replica.currentNodeId(), startedReplica.currentNodeId());
import org.opensearch.cluster.ClusterState;
        final IndexMetadata indexMetadata = IndexMetadata.builder("test")
 */
import java.util.List;
        if (relocatingReplica) {
                .build()
            "node1",
        final ShardRouting relocatingShard = TestShardRouting.newShardRouting(
            true,
        ClusterState state = stateBuilder.build();
        ClusterState state = stateBuilder.build();
            RoutingTable.builder()
            newState.routingTable().index("test").shard(initShard.id()).allShardsStarted()
            .settings(settings(Version.CURRENT))
            .numberOfReplicas(1)
        final Index index = indexMetadata.getIndex();
            "node1",
        stateBuilder.routingTable(
        ShardRouting shardRouting = newState.routingTable().index("test").shard(relocatingShard.id()).getShards().get(0);
            newState,
 *     http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> test starting of relocating primary shard together with initializing / relocating replica");
            .numberOfReplicas(0)
        } else {
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.cluster.routing.ShardRoutingState;
                )
import org.opensearch.cluster.routing.RoutingTable;
            assertTrue(startedReplica.initializing());
 * compatible open source license.
 * GitHub history for details.
        newState = startShardsAndReroute(allocation, state, relocatingShard.getTargetRelocatingShard());
 * not use this file except in compliance with the License.
import org.opensearch.core.index.Index;
        boolean relocatingReplica = randomBoolean();
        final ShardRouting relocatingPrimary = TestShardRouting.newShardRouting(
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.routing.AllocationId;
            "node1",
import java.util.ArrayList;
                    IndexRoutingTable.builder(index)
            .numberOfShards(2)
        );
        );
        assertThat(shardRouting.currentNodeId(), equalTo("node2"));
            .metadata(Metadata.builder().put(indexMetadata, false));
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            true,
            assertEquals(replica.relocatingNodeId(), startedReplica.relocatingNodeId());
            assertEquals(replica.currentNodeId(), startedReplica.currentNodeId());
        assertThat(shardRouting.state(), equalTo(ShardRoutingState.STARTED));
 * this work for additional information regarding copyright
                .add(
            ShardRoutingState.RELOCATING,
        final IndexMetadata indexMetadata = IndexMetadata.builder("test")
            .metadata(Metadata.builder().put(indexMetadata, false));
import static org.hamcrest.Matchers.not;
            "node3",
    }
        logger.info("--> building initial cluster state");
            .build();
import org.opensearch.cluster.routing.IndexRoutingTable;
        AllocationId primaryId = AllocationId.newRelocation(AllocationId.newInitializing());
            not(equalTo(state))
                        )
        logger.info("--> building initial cluster state");
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
    }
        );
            "node2",
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        ClusterState.Builder stateBuilder = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
public class StartedShardsRoutingTests extends OpenSearchAllocationTestCase {
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
            allocationId
 * The OpenSearch Contributors require contributions made to
        );
        AllocationService allocation = createAllocationService();
import org.opensearch.common.util.set.Sets;
        stateBuilder.routingTable(
            assertEquals(replica.allocationId().getId(), startedReplica.allocationId().getId());
            assertTrue(startedReplica.relocating());
        assertNotEquals(newState, state);
        AllocationService allocation = createAllocationService();
        state = newState;
                                .addShard(replica)
 * You may obtain a copy of the License at
        ClusterState newState = startShardsAndReroute(allocation, state, initShard);
        );
import org.opensearch.cluster.ClusterName;
        List<ShardRouting> startedShards = new ArrayList<>();
            "failed to start " + relocatingShard + "\ncurrent routing table:" + newState.routingTable(),
            ShardRoutingState.RELOCATING,
            .putInSyncAllocationIds(
            relocatingReplica ? "node4" : null,
import java.util.Collections;
        startedShards.add(relocatingPrimary.getTargetRelocatingShard());
        assertTrue(
        final Index index = indexMetadata.getIndex();
/*
    public void testStartedShardsMatching() {
            RoutingTable.builder()
                    IndexRoutingTable.builder(index)
                        .addIndexShard(new IndexShardRoutingTable.Builder(relocatingShard.shardId()).addShard(relocatingShard).build())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new ShardId(index, 0),
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
 */
import org.opensearch.common.settings.Settings;
            .numberOfShards(1)
        AllocationId replicaId = AllocationId.newInitializing();
}
        logger.info("--> test starting of relocating primary shard with initializing / relocating replica");
        ShardRouting startedReplica = newState.routingTable().index("test").shard(0).replicaShards().get(0);
        );
        ClusterState newState = startShardsAndReroute(allocation, state, relocatingPrimary.getTargetRelocatingShard());
        AllocationId allocationId = AllocationId.newRelocation(AllocationId.newInitializing());
 *
 * license agreements. See the NOTICE file distributed with
            replicaId
            .build();
            new ShardId(index, 0),
 * this file be licensed under the Apache-2.0 license or a
            new ShardId(index, 0),
                .add(
import org.opensearch.cluster.metadata.IndexMetadata;
 * specific language governing permissions and limitations
        logger.info("--> testing starting of relocating shards");
        assertThat(
import org.opensearch.Version;
                )
            true,
                                .build()
            ShardRoutingState.INITIALIZING
 * KIND, either express or implied.  See the License for the
        );
            assertNotEquals(replica.allocationId().getId(), startedReplica.allocationId().getId());
/*
        Collections.shuffle(startedShards, random());
        assertTrue(newState.routingTable().index("test").allPrimaryShardsActive());
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.cluster.routing.allocation;
        final ShardRouting initShard = TestShardRouting.newShardRouting(
        }
        assertTrue(newState.routingTable().index("test").shard(0).allShardsStarted());
import org.opensearch.cluster.routing.ShardRouting;
            new ShardId(index, 1),
                .build()
            false,
                        .addIndexShard(new IndexShardRoutingTable.Builder(initShard.shardId()).addShard(initShard).build())
 *
 *
                        .addIndexShard(
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.metadata.Metadata;
        final ShardRouting replica = TestShardRouting.newShardRouting(
