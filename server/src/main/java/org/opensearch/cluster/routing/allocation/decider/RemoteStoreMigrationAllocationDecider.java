                Decision.YES,
            return allocation.decision(  
/*
            return primaryShardNode.isRemoteStoreNode();  
 */
                ).append(" to a remote node").toString();  
                NAME,
                    " since primary shard copy has been migrated to remote",
import org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
                getDecisionDetails(  
                    NAME,
    // handle scenarios for allocation of a new shard's primary copy
 * ownership. Elasticsearch licenses this file to you under  
        if (primaryShardRouting != null) {
 * this file be licensed under the Apache-2.0 license or a
    public static final String NAME = "remote_store_migration";
        return allocation.decision(Decision.YES, NAME, getDecisionDetails(true, replicaShardRouting, targetNode, "", allocation));  
            );
            );
        if (compatibilityMode.equals(CompatibilityMode.STRICT)) {
                return primaryShardDecision(shardRouting, targetNode, allocation);
            );
            .append(" node")
            .append(" migration_direction]: ")  
            RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING,  
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
        String reason,
        this.compatibilityMode = compatibilityMode;
                NAME,  
 * the Apache License, Version 2.0 (the "License"); you may
 * - For other directions ("DOCREP", "NONE"), the decision is always YES
                getDecisionDetails(!isNoDecision, shardRouting, targetNode, reason, allocation)  
                    (shardRouting.assignedToNode() == false) ? "allocated" : "relocated"
        }
            }
 *  
        if (targetNode.isRemoteStoreNode() == false) {
                Decision.YES,
 * Modifications Copyright OpenSearch Contributors. See
        return false;
            boolean isNoDecision = remoteSettingsBackedIndex ^ targetNode.isRemoteStoreNode();
                    allocation
        boolean remoteSettingsBackedIndex = IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings());  
        DiscoveryNode targetNode = node.node();  
/**
        boolean isYes,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .append(shardRouting.primary() ? "primary" : "replica")
        this.migrationDirection = migrationDirection;  
    volatile private CompatibilityMode compatibilityMode;
        if (targetNode.isRemoteStoreNode()) {  
        }
public class RemoteStoreMigrationAllocationDecider extends AllocationDecider {  
    // get detailed reason for the decision  
/*  
    }  
 *      - New replica shards can be allocated to a remote node iff the primary has been migrated/allocated to a remote node
import org.opensearch.cluster.metadata.IndexMetadata;
                return allocation.decision(  
                isNoDecision ? Decision.NO : Decision.YES,
            return allocation.decision(Decision.NO, NAME, getDecisionDetails(false, primaryShardRouting, targetNode, "", allocation));
                getDecisionDetails(true, shardRouting, targetNode, " for strict compatibility mode", allocation)
            if (primaryOnRemote == false) {
        this.compatibilityMode = RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(settings);  
        ShardRouting primaryShardRouting = allocation.routingNodes().activePrimary(shardId);  
 * this work for additional information regarding copyright
            String reason = " for " + (remoteSettingsBackedIndex ? "" : "non ") + "remote store backed index";
    // Checks if primary shard is on a remote node.
 *  
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
    private void setMigrationDirection(Direction migrationDirection) {
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;
            // assuming all nodes are of the same type (all remote or all non-remote)  
 * Unless required by applicable law or agreed to in writing,
    }  
                // allocations and relocations must be to a remote node  
        }  
            return allocation.decision(
                Decision.YES,
                        " since primary shard copy is not yet migrated to remote",
import org.opensearch.node.remotestore.RemoteStoreNodeService.Direction;
import org.opensearch.common.settings.ClusterSettings;  
            return allocation.decision(
            );
    }
import org.opensearch.cluster.node.DiscoveryNode;
package org.opensearch.cluster.routing.allocation.decider;
            }
            .append(" shard copy ")
        }
        } else {  
        ShardRouting shardRouting,  
                NAME,  
                return allocation.decision(Decision.NO, NAME, getDecisionDetails(false, shardRouting, targetNode, reason, allocation));
        clusterSettings.addSettingsUpdateConsumer(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING, this::setMigrationDirection);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            return null;  
        RoutingAllocation allocation  
    private void setCompatibilityMode(CompatibilityMode compatibilityMode) {  
            // remote backed indices on docrep nodes and non remote backed indices on remote nodes are not allowed  
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
            }  
                    getDecisionDetails(  
                getDecisionDetails(true, shardRouting, targetNode, " for DOCREP direction", allocation)
        } else if (migrationDirection.equals(Direction.DOCREP)) {
    private Decision replicaShardDecision(ShardRouting replicaShardRouting, DiscoveryNode targetNode, RoutingAllocation allocation) {
            return replicaShardDecision(shardRouting, targetNode, allocation);
            .append(" be ")
    }
                NAME,
 *
 * under the License.  
    }
 * GitHub history for details.
                        allocation
 *      - New primary shards can only be allocated to a remote node  
            this::setCompatibilityMode
        }  
                    targetNode,  
import org.opensearch.core.index.shard.ShardId;
                        false,
        if (migrationDirection.equals(Direction.NONE)) {
                )  
        if (allocation.debugDecision() == false) {
 * Licensed to Elasticsearch under one or more contributor  
        clusterSettings.addSettingsUpdateConsumer(
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.ShardRouting;
            .append(targetNode.isRemoteStoreNode() ? "remote" : "non-remote")
        );
            if (shardRouting.primary()) {
    public RemoteStoreMigrationAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            boolean primaryOnRemote = RemoteStoreMigrationAllocationDecider.isPrimaryOnRemote(replicaShardRouting.shardId(), allocation);
        DiscoveryNode targetNode,
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            if (remoteSettingsBackedIndex && targetNode.isRemoteStoreNode() == false) {
            .append(" to a ")  
    static boolean isPrimaryOnRemote(ShardId shardId, RoutingAllocation allocation) {
    }  
 * SPDX-License-Identifier: Apache-2.0
        this.migrationDirection = RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING.get(settings);
import org.opensearch.cluster.routing.RoutingNode;  
 */  
 * You may obtain a copy of the License at  
                    Decision.NO,
 * license agreements. See the NOTICE file distributed with
    volatile private Direction migrationDirection;
 * A new allocation decider for migration of document replication clusters to remote store backed clusters:
                    replicaShardRouting,
    }
    private Decision primaryShardDecision(ShardRouting primaryShardRouting, DiscoveryNode targetNode, RoutingAllocation allocation) {  
 * compatible open source license.
 * - For "REMOTE_STORE" migration direction:
 *
}
/*  
        }
            // check for remote store backed indices
    private String getDecisionDetails(
    @Override
            .toString();
                        replicaShardRouting,
            .append(isYes ? "can" : "can not")  
            return allocation.decision(  
 * software distributed under the License is distributed on an
            .append(reason)  
                        targetNode,  
    }
 */  
            .append((shardRouting.assignedToNode() == false) ? "allocated" : "relocated")
                    )  
 * - For STRICT compatibility mode, the decision is always YES  
        return allocation.decision(Decision.YES, NAME, getDecisionDetails(true, primaryShardRouting, targetNode, "", allocation));
                );
 * not use this file except in compliance with the License.
            DiscoveryNode primaryShardNode = allocation.nodes().getNodes().get(primaryShardRouting.currentNodeId());
        return new StringBuilder("[").append(migrationDirection.direction)
                    true,
    ) {
 */
                String reason = new StringBuilder(" because a remote store backed index's shard copy can only be ").append(
            // docrep migration direction is currently not supported  
 * - For remote store backed indices, relocation or allocation/relocation can only be towards a remote node
