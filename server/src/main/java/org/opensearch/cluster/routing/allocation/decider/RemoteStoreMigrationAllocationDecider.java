            .append(" to a ")
            .toString();
                NAME,
 * under the License.
        return allocation.decision(Decision.YES, NAME, getDecisionDetails(true, primaryShardRouting, targetNode, "", allocation));
            );
            boolean isNoDecision = remoteSettingsBackedIndex ^ targetNode.isRemoteStoreNode();
    private void setMigrationDirection(Direction migrationDirection) {
            return allocation.decision(
import org.opensearch.cluster.metadata.IndexMetadata;
            if (remoteSettingsBackedIndex && targetNode.isRemoteStoreNode() == false) {
/*
        }
            .append(" migration_direction]: ")
            .append((shardRouting.assignedToNode() == false) ? "allocated" : "relocated")
    public RemoteStoreMigrationAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
 * not use this file except in compliance with the License.
 * compatible open source license.
            // remote backed indices on docrep nodes and non remote backed indices on remote nodes are not allowed
package org.opensearch.cluster.routing.allocation.decider;
            return allocation.decision(
            return null;
import org.opensearch.cluster.node.DiscoveryNode;
        );
                NAME,
        ShardRouting shardRouting,
            if (shardRouting.primary()) {
    public static final String NAME = "remote_store_migration";
                String reason = new StringBuilder(" because a remote store backed index's shard copy can only be ").append(
                    )
                Decision.YES,
            // assuming all nodes are of the same type (all remote or all non-remote)
 * Unless required by applicable law or agreed to in writing,
                );
 * GitHub history for details.
    ) {
        }
                        " since primary shard copy is not yet migrated to remote",
            }
 * the Apache License, Version 2.0 (the "License"); you may
                    targetNode,
            .append(shardRouting.primary() ? "primary" : "replica")
                getDecisionDetails(!isNoDecision, shardRouting, targetNode, reason, allocation)
    }
        ShardRouting primaryShardRouting = allocation.routingNodes().activePrimary(shardId);
        DiscoveryNode targetNode = node.node();
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    }
        return allocation.decision(Decision.YES, NAME, getDecisionDetails(true, replicaShardRouting, targetNode, "", allocation));
                getDecisionDetails(
 * The OpenSearch Contributors require contributions made to
 *      - New primary shards can only be allocated to a remote node
 * You may obtain a copy of the License at
 */
    }
        if (allocation.debugDecision() == false) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .append(" node")
    private void setCompatibilityMode(CompatibilityMode compatibilityMode) {
    // get detailed reason for the decision
 */
 *
    }
    }
            String reason = " for " + (remoteSettingsBackedIndex ? "" : "non ") + "remote store backed index";
                NAME,
            .append(" shard copy ")
                ).append(" to a remote node").toString();
import org.opensearch.common.settings.ClusterSettings;
            }
        } else {
        } else if (migrationDirection.equals(Direction.DOCREP)) {
                    getDecisionDetails(
 * this file be licensed under the Apache-2.0 license or a
/*
    private Decision replicaShardDecision(ShardRouting replicaShardRouting, DiscoveryNode targetNode, RoutingAllocation allocation) {
            .append(isYes ? "can" : "can not")
                return allocation.decision(
    private Decision primaryShardDecision(ShardRouting primaryShardRouting, DiscoveryNode targetNode, RoutingAllocation allocation) {
        if (compatibilityMode.equals(CompatibilityMode.STRICT)) {
                Decision.YES,
 * software distributed under the License is distributed on an
    }
import org.opensearch.cluster.routing.ShardRouting;
public class RemoteStoreMigrationAllocationDecider extends AllocationDecider {
 * Modifications Copyright OpenSearch Contributors. See
/*
    }
                Decision.YES,
        return false;
        if (primaryShardRouting != null) {
            .append(" be ")
        if (targetNode.isRemoteStoreNode()) {
                        replicaShardRouting,
            );
 *
        return new StringBuilder("[").append(migrationDirection.direction)
 * - For other directions ("DOCREP", "NONE"), the decision is always YES
            // docrep migration direction is currently not supported
import org.opensearch.common.settings.Settings;
                // allocations and relocations must be to a remote node
                    NAME,
                    true,
import org.opensearch.node.remotestore.RemoteStoreNodeService.Direction;
 *
 * license agreements. See the NOTICE file distributed with
            DiscoveryNode primaryShardNode = allocation.nodes().getNodes().get(primaryShardRouting.currentNodeId());
                    allocation
        boolean remoteSettingsBackedIndex = IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings());
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
 * specific language governing permissions and limitations
        if (migrationDirection.equals(Direction.NONE)) {
                return allocation.decision(Decision.NO, NAME, getDecisionDetails(false, shardRouting, targetNode, reason, allocation));
    // handle scenarios for allocation of a new shard's primary copy
                    " since primary shard copy has been migrated to remote",
                return primaryShardDecision(shardRouting, targetNode, allocation);
        boolean isYes,
        }
                        allocation
}
        clusterSettings.addSettingsUpdateConsumer(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING, this::setMigrationDirection);
    // Checks if primary shard is on a remote node.
                    replicaShardRouting,
 *     http://www.apache.org/licenses/LICENSE-2.0
    static boolean isPrimaryOnRemote(ShardId shardId, RoutingAllocation allocation) {
            );
 * A new allocation decider for migration of document replication clusters to remote store backed clusters:
            if (primaryOnRemote == false) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        }
        String reason,
 */
        }
                getDecisionDetails(true, shardRouting, targetNode, " for strict compatibility mode", allocation)
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        }
 * - For "REMOTE_STORE" migration direction:
 */
            }
                getDecisionDetails(true, shardRouting, targetNode, " for DOCREP direction", allocation)
                    (shardRouting.assignedToNode() == false) ? "allocated" : "relocated"
            return allocation.decision(
/**
 * Licensed to Elasticsearch under one or more contributor
            .append(reason)
        this.migrationDirection = migrationDirection;
 * @opensearch.internal
        this.migrationDirection = RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING.get(settings);
    volatile private Direction migrationDirection;
    private String getDecisionDetails(
    @Override
 *
        RoutingAllocation allocation
            boolean primaryOnRemote = RemoteStoreMigrationAllocationDecider.isPrimaryOnRemote(replicaShardRouting.shardId(), allocation);
            return replicaShardDecision(shardRouting, targetNode, allocation);
            .append(targetNode.isRemoteStoreNode() ? "remote" : "non-remote")
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.RoutingNode;
 * SPDX-License-Identifier: Apache-2.0
            return allocation.decision(
                        false,
        if (targetNode.isRemoteStoreNode() == false) {
            // check for remote store backed indices
                        targetNode,
            this::setCompatibilityMode
        clusterSettings.addSettingsUpdateConsumer(
import org.opensearch.core.index.shard.ShardId;
            return allocation.decision(Decision.NO, NAME, getDecisionDetails(false, primaryShardRouting, targetNode, "", allocation));
        DiscoveryNode targetNode,
        this.compatibilityMode = RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(settings);
 * ownership. Elasticsearch licenses this file to you under
            RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING,
                    Decision.NO,
        this.compatibilityMode = compatibilityMode;
            );
 * - For remote store backed indices, relocation or allocation/relocation can only be towards a remote node
import org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
    volatile private CompatibilityMode compatibilityMode;
 * KIND, either express or implied.  See the License for the
                isNoDecision ? Decision.NO : Decision.YES,
 * - For STRICT compatibility mode, the decision is always YES
                )
            return primaryShardNode.isRemoteStoreNode();
                NAME,
 *      - New replica shards can be allocated to a remote node iff the primary has been migrated/allocated to a remote node
