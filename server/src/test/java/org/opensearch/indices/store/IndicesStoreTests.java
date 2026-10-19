    }
import org.opensearch.test.OpenSearchTestCase;
    @Before  
        assertFalse(IndicesStore.shardCanBeDeleted(localNode.getId(), routingTable.build()));
/*  
 */  
    }
                if (state == ShardRoutingState.UNASSIGNED) {
    private DiscoveryNode localNode;
package org.opensearch.indices.store;
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
                )
 * compatible open source license.
                String relocatingNodeId = state == ShardRoutingState.RELOCATING ? randomAlphaOfLength(10) : null;  
                    state = randomFrom(NOT_STARTED_STATES);  
        IndexShardRoutingTable.Builder routingTable = new IndexShardRoutingTable.Builder(new ShardId("test", "_na_", 1));  
 * KIND, either express or implied.  See the License for the
                String currentNodeId = state == ShardRoutingState.UNASSIGNED ? null : randomAlphaOfLength(10);
                UnassignedInfo unassignedInfo = null;
import java.util.Set;
 *
/*  
        }
 */  
 * GitHub history for details.
                ShardRoutingState state;
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        for (int i = 0; i < numShards; i++) {
    static {  
                );  
 * license agreements. See the NOTICE file distributed with
                        ShardRoutingState.STARTED  
import java.util.Arrays;
                TestShardRouting.newShardRouting(
                    )
                    state = randomFrom(ShardRoutingState.values());
    }
        localNode = new DiscoveryNode("abc", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
 * under the License.  
            for (int j = 0; j < numReplicas; j++) {
/*
import static java.util.Collections.emptySet;
                        replicaOnLocalNode ? localNode.getId() : randomAlphaOfLength(10),
        assertFalse(IndicesStore.shardCanBeDeleted(localNode.getId(), routingTable.build()));
        int localShardId = randomInt(numShards - 1);  
                    ShardRoutingState.STARTED
import org.opensearch.core.index.shard.ShardId;
        int numShards = randomIntBetween(1, 7);
                } else {
                    primaryOnLocalNode ? localNode.getId() : randomAlphaOfLength(10),
        IndexShardRoutingTable.Builder routingTable = new IndexShardRoutingTable.Builder(new ShardId("test", "_na_", 1));
                routingTable.addShard(
                    true,  
 */
 *  
    private static final ShardRoutingState[] NOT_STARTED_STATES;
                }  
            );  
        Set<ShardRoutingState> set = new HashSet<>();
            int localNodeIndex = randomInt(numReplicas);
                    unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);  
        set.remove(ShardRoutingState.STARTED);  
        for (int i = 0; i < numShards; i++) {
                boolean replicaOnLocalNode = i == localShardId && localNodeIndex == j;
    }
            }  
import org.junit.Before;  
        IndexShardRoutingTable.Builder routingTable = new IndexShardRoutingTable.Builder(new ShardId("test", "_na_", 1));
 * You may obtain a copy of the License at  
        assertFalse(IndicesStore.shardCanBeDeleted(localNode.getId(), routingTable.build()));
        NOT_STARTED_STATES = set.toArray(new ShardRoutingState[0]);
import org.opensearch.cluster.node.DiscoveryNode;
                        i,  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        "test",
        int numShards = randomIntBetween(1, 7);
 * Modifications Copyright OpenSearch Contributors. See
                if (j == unStartedShard) {
    public void testShardCanBeDeletedNoShardStarted() throws Exception {
 * specific language governing permissions and limitations
    public void createLocalNode() {
            routingTable.addShard(
                }
                    i,
                    "test",  
            boolean primaryOnLocalNode = i == localShardId && localNodeIndex == numReplicas;  
            int unStartedShard = randomInt(numReplicas);
    public void testShardCanBeDeletedShardExistsLocally() throws Exception {
        }
                    TestShardRouting.newShardRouting(
                );
import org.opensearch.cluster.routing.TestShardRouting;
}  
        int numReplicas = randomInt(2);  
            for (int j = 0; j <= numReplicas; j++) {  
                routingTable.addShard(  
                        false,
import org.opensearch.cluster.routing.ShardRoutingState;
 * the Apache License, Version 2.0 (the "License"); you may
        // Shard exists locally, can't delete shard  
    }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
import static java.util.Collections.emptyMap;  
import java.util.HashSet;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this work for additional information regarding copyright
        set.addAll(Arrays.asList(ShardRoutingState.values()));
import org.opensearch.cluster.routing.UnassignedInfo;  
 * software distributed under the License is distributed on an
                    TestShardRouting.newShardRouting("test", i, currentNodeId, relocatingNodeId, j == 0, state, unassignedInfo)
public class IndicesStoreTests extends OpenSearchTestCase {  
    public void testShardCanBeDeletedNoShardRouting() throws Exception {
import org.opensearch.Version;
 * Licensed to Elasticsearch under one or more contributor  
        int numReplicas = randomInt(2);  
 * SPDX-License-Identifier: Apache-2.0
