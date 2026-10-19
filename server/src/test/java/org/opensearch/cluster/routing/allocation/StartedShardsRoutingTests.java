import org.opensearch.cluster.routing.ShardRoutingState;  
        assertThat(
import org.opensearch.cluster.node.DiscoveryNodes;  
            new ShardId(index, 0),  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertEquals(replica.currentNodeId(), startedReplica.currentNodeId());
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
}
        ClusterState.Builder stateBuilder = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.core.index.Index;
            "failed to start " + relocatingShard + "\ncurrent routing table:" + newState.routingTable(),
        newState = startShardsAndReroute(allocation, state, relocatingShard.getTargetRelocatingShard());  
        ClusterState state = stateBuilder.build();
            .numberOfReplicas(0)  
        ClusterState newState = startShardsAndReroute(allocation, state, initShard);  
            newState,  
import org.opensearch.cluster.routing.TestShardRouting;
            .settings(settings(Version.CURRENT))
        ShardRouting shardRouting = newState.routingTable().index("test").shard(relocatingShard.id()).getShards().get(0);  
                                .build()
            newState.routingTable().index("test").shard(initShard.id()).allShardsStarted()
            "node2",
            "node3",
        final IndexMetadata indexMetadata = IndexMetadata.builder("test")
        ClusterState.Builder stateBuilder = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
                .add(
        assertTrue(newState.routingTable().index("test").shard(0).allShardsStarted());  
                        .addIndexShard(
    public void testRelocatingPrimariesWithInitializingReplicas() {  
        boolean relocatingReplica = randomBoolean();  
import org.opensearch.common.util.set.Sets;  
        logger.info("--> test starting of shard");
 * license agreements. See the NOTICE file distributed with
        AllocationService allocation = createAllocationService();
                )  
            ShardRoutingState.INITIALIZING  
            RoutingTable.builder()
            "node1",
        logger.info("--> building initial cluster state");  
        );
        assertThat(shardRouting.state(), equalTo(ShardRoutingState.STARTED));
import org.opensearch.cluster.routing.IndexRoutingTable;
            .numberOfReplicas(1)
        logger.info("--> testing starting of relocating shards");
        assertNotEquals(newState, state);
 */
            .build();
            relocatingReplica ? "node4" : null,  
            assertNotEquals(replica.allocationId().getRelocationId(), startedReplica.allocationId().getRelocationId());
                        .addIndexShard(new IndexShardRoutingTable.Builder(relocatingShard.shardId()).addShard(relocatingShard).build())  
            .putInSyncAllocationIds(  
 */  
            true,
    public void testStartedShardsMatching() {
        stateBuilder.routingTable(
import static org.hamcrest.Matchers.not;  
 *  
                0,
import org.opensearch.core.index.shard.ShardId;
            true,
import org.opensearch.cluster.routing.AllocationId;
 * compatible open source license.
    }
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.RoutingTable;
    }
                )
        final Index index = indexMetadata.getIndex();
        final ShardRouting initShard = TestShardRouting.newShardRouting(
            .putInSyncAllocationIds(1, Collections.singleton(allocationId.getId()))
        );
        final ShardRouting relocatingShard = TestShardRouting.newShardRouting(
        Collections.shuffle(startedShards, random());  
        );
 * software distributed under the License is distributed on an
        } else {
public class StartedShardsRoutingTests extends OpenSearchAllocationTestCase {  
package org.opensearch.cluster.routing.allocation;
            false,
 * under the License.  
        ClusterState state = stateBuilder.build();
import org.opensearch.cluster.metadata.Metadata;
        assertNotEquals(newState, state);
        if (relocatingReplica) {
 * The OpenSearch Contributors require contributions made to  
        final IndexMetadata indexMetadata = IndexMetadata.builder("test")  
        assertThat(shardRouting.relocatingNodeId(), nullValue());  
            new ShardId(index, 1),  
                        )
        assertThat("failed to start " + initShard + "\ncurrent routing table:" + newState.routingTable(), newState, not(equalTo(state)));
            new ShardId(index, 0),
import java.util.List;  
 * GitHub history for details.
 * specific language governing permissions and limitations
                .build()
            .numberOfShards(2)
            assertEquals(replica.relocatingNodeId(), startedReplica.relocatingNodeId());
            replicaId = AllocationId.newRelocation(replicaId);
            "node1",
            initShard + "isn't started \ncurrent routing table:" + newState.routingTable(),  
            not(equalTo(state))
        logger.info("--> building initial cluster state");
        AllocationService allocation = createAllocationService();
        startedShards.add(relocatingReplica ? replica.getTargetRelocatingShard() : replica);
        AllocationId allocationId = AllocationId.newRelocation(AllocationId.newInitializing());
            ShardRoutingState.RELOCATING,
            .metadata(Metadata.builder().put(indexMetadata, false));
        assertTrue(
        final ShardRouting replica = TestShardRouting.newShardRouting(  
            true,  
 * Licensed to Elasticsearch under one or more contributor  
        if (relocatingReplica) {
            assertEquals(replica.currentNodeId(), startedReplica.currentNodeId());
import org.opensearch.Version;  
 * not use this file except in compliance with the License.
        logger.info("--> test starting of relocating primary shard together with initializing / relocating replica");
            ShardRoutingState.RELOCATING,  
import java.util.ArrayList;
import org.opensearch.cluster.metadata.IndexMetadata;
            .numberOfShards(1)
                        .addIndexShard(new IndexShardRoutingTable.Builder(initShard.shardId()).addShard(initShard).build())
 * Unless required by applicable law or agreed to in writing,
        ClusterState newState = startShardsAndReroute(allocation, state, relocatingPrimary.getTargetRelocatingShard());
            assertTrue(startedReplica.relocating());  
            assertNotEquals(replica.allocationId().getId(), startedReplica.allocationId().getId());
/*
            .settings(settings(Version.CURRENT))  
 * SPDX-License-Identifier: Apache-2.0
            RoutingTable.builder()
        );
        }  
import java.util.Collections;
            .build();
 * this work for additional information regarding copyright
                                .addShard(replica)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        newState = startShardsAndReroute(allocation, state, startedShards);
 * KIND, either express or implied.  See the License for the
                .add(  
        );
            "node2",
            assertEquals(replica.allocationId().getId(), startedReplica.allocationId().getId());  
        );  
        ShardRouting startedReplica = newState.routingTable().index("test").shard(0).replicaShards().get(0);
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.cluster.ClusterName;
        startedShards.add(relocatingPrimary.getTargetRelocatingShard());
        List<ShardRouting> startedShards = new ArrayList<>();  
 * You may obtain a copy of the License at  
                relocatingReplica ? Sets.newHashSet(primaryId.getId(), replicaId.getId()) : Sets.newHashSet(primaryId.getId())
            )  
        AllocationId primaryId = AllocationId.newRelocation(AllocationId.newInitializing());
        final Index index = indexMetadata.getIndex();  
            assertTrue(startedReplica.initializing());  
        );  
import static org.hamcrest.Matchers.nullValue;
 *
        logger.info("--> test starting of relocating primary shard with initializing / relocating replica");  
            allocationId
        assertTrue(newState.routingTable().index("test").allPrimaryShardsActive());  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            relocatingReplica ? ShardRoutingState.RELOCATING : ShardRoutingState.INITIALIZING,
            .metadata(Metadata.builder().put(indexMetadata, false));  
        );
            new ShardId(index, 0),
        state = newState;  
        stateBuilder.routingTable(  
        }  
import org.opensearch.cluster.ClusterState;
 */
                            new IndexShardRoutingTable.Builder(relocatingPrimary.shardId()).addShard(relocatingPrimary)
import org.opensearch.common.settings.Settings;
                    IndexRoutingTable.builder(index)
 * the Apache License, Version 2.0 (the "License"); you may
        final ShardRouting relocatingPrimary = TestShardRouting.newShardRouting(
        assertThat(shardRouting.currentNodeId(), equalTo("node2"));
            replicaId  
 * Modifications Copyright OpenSearch Contributors. See  
/*
            "node1",  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
/*  
            primaryId
        AllocationId replicaId = AllocationId.newInitializing();
import static org.hamcrest.Matchers.equalTo;
                    IndexRoutingTable.builder(index)  
                .build()
