        switch (state) {
 */
 * KIND, either express or implied.  See the License for the
                } else {
 *
/*  
    }  
                    primary,
        public void update(ShardRouting shardRouting) {  
        for (int shard = 0; shard < indexMetadata.getNumberOfShards(); shard++) {
                primaryInactive++;
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(indexMetadata.getIndex());  
                    relocating++;
                return TestShardRouting.newShardRouting(  
                if (shardRouting.primary()) {  
import org.opensearch.cluster.metadata.IndexMetadata;
            case INITIALIZING:
        for (int replicas = indexMetadata.getNumberOfReplicas(); replicas > 0; replicas--) {
            }
                    null,
                return TestShardRouting.newShardRouting(  
 * software distributed under the License is distributed on an
                return TestShardRouting.newShardRouting(  
            if (unassigned > 0 || initializing > 0) {  
import org.opensearch.OpenSearchException;
/*
        public int active;
                    shardId,
                    return ClusterHealthStatus.YELLOW;  
            case RELOCATING:
 *  
                    "node_" + Integer.toString(node_id++),
                }
            builder.addIndexShard(genShardRoutingTable(indexMetadata, shard, counter));
                active++;
 * Modifications Copyright OpenSearch Contributors. See  
                    return ClusterHealthStatus.RED;
        public int primaryActive;  
                return ClusterHealthStatus.YELLOW;
            if (shardRouting.initializing()) {  
 */  
 */
                    ShardRoutingState.RELOCATING  
 * Licensed to Elasticsearch under one or more contributor  
            state = ShardRoutingState.STARTED;  
                throw new OpenSearchException("Unknown state: " + state.name());  
        public int relocating;  
            }
public class RoutingTableGenerator {  
                    shardId,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
                    shardId,
        ShardRouting shardRouting = genShardRouting(index, shardId, true);
 * specific language governing permissions and limitations
 * under the License.  
                if (inactivePrimaryCausesRed == false) {
                    ShardRoutingState.INITIALIZING  
                    index,
        counter.update(shardRouting);  
                if (shardRouting.relocating()) {  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                    primary,
                    primary,
        }
            case STARTED:
    }  
            if (shardRouting.active()) {
        } else {  
package org.opensearch.cluster.routing;
        public ClusterHealthStatus status() {
                    index,
                }
                    "node_" + Integer.toString(node_id++),  
            default:
                }
            counter.update(shardRouting);
            state = ShardRoutingState.INITIALIZING;
        }
                    null,
 * SPDX-License-Identifier: Apache-2.0
            shardRouting = genShardRouting(index, shardId, false);  
import static org.opensearch.cluster.health.ClusterShardHealth.getInactivePrimaryHealth;
 * license agreements. See the NOTICE file distributed with
                    inactivePrimaryCausesRed = getInactivePrimaryHealth(shardRouting) == ClusterHealthStatus.RED;  
            }
                }
                    "node_" + Integer.toString(node_id++),  
                if (inactivePrimaryCausesRed) {  
    private static int node_id = 1;
            builder.addShard(shardRouting);
        int stateRandomizer = RandomizedContext.current().getRandom().nextInt(40);
        if (stateRandomizer > 5) {
 * this work for additional information regarding copyright
                    ShardRoutingState.STARTED  
 * The OpenSearch Contributors require contributions made to  
    private ShardRouting genShardRouting(String index, int shardId, boolean primary) {  
        } else if (stateRandomizer > 3) {
import org.opensearch.core.index.shard.ShardId;
                    "node_" + Integer.toString(node_id++),  
            } else {
        }
        builder.addShard(shardRouting);
    }
 * this file be licensed under the Apache-2.0 license or a
        }  
import org.opensearch.cluster.health.ClusterHealthStatus;  
        public int primaryInactive;
 *
                unassigned++;  
        return builder.build();
                initializing++;
 * Unless required by applicable law or agreed to in writing,
                );
            if (primaryInactive > 0) {
}
            if (shardRouting.primary()) {  
                );
 * ownership. Elasticsearch licenses this file to you under  
/*
                return;  
    public IndexRoutingTable genIndexRoutingTable(IndexMetadata indexMetadata, ShardCounter counter) {
 * compatible open source license.
        }
                    primaryActive++;
 *     http://www.apache.org/licenses/LICENSE-2.0
            state = ShardRoutingState.RELOCATING;
                    index,
 * GitHub history for details.
        public int unassigned;
    public IndexShardRoutingTable genShardRoutingTable(IndexMetadata indexMetadata, int shardId, ShardCounter counter) {
 * You may obtain a copy of the License at  
    public static class ShardCounter {
        ShardRoutingState state;
        return builder.build();
    }  
        final String index = indexMetadata.getIndex().getName();  
            return ClusterHealthStatus.GREEN;  
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(new ShardId(index, "_na_", shardId));
                );
        private boolean inactivePrimaryCausesRed = false;
            }
            }
        public int initializing;
import com.carrotsearch.randomizedtesting.RandomizedContext;  
