            return allocation.decision(
                "node version [%s] is the same or newer than snapshot version [%s]",
 * available on the target node.
    ) {
                "can relocate primary shard from a node with version [%s] to a node with equal-or-newer version [%s]",
                // ReplicaAfterPrimaryActiveAllocationDecider should prevent this case from occurring
                recoverySource.version()
                List<ShardRouting> replicas = allocation.routingNodes()
        if (target.node().getVersion().onOrAfter(source.node().getVersion())) {
        final RoutingNode target,
 * under the License.
                }
 *
        SnapshotRecoverySource recoverySource,
    }
            return allocation.decision(
            /* we can allocate if we can restore from a snapshot that is older or on the same version */
 * compatible open source license.
                target.node().getVersion(),
 */
        final RoutingNode target,
                            NAME,
 * this work for additional information regarding copyright
    private Decision isVersionCompatible(
            /* we can allocate if we can recover from a node that is younger or on the same version
                    return isVersionCompatible((SnapshotRecoverySource) shardRouting.recoverySource(), node, allocation);
import java.util.List;
                Decision.YES,
}
        final RoutingNode target,
                            replicaNode.node().getVersion()
            }
                NAME,
public class NodeVersionAllocationDecider extends AllocationDecider {
        final RoutingAllocation allocation
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.cluster.routing.RoutingNodes;
        final RoutingNodes routingNodes,
            if (replicationType == ReplicationType.SEGMENT) {
    @Override
        if (target.node().getVersion().onOrAfter(source.node().getVersion())) {
                Decision.NO,
        final RoutingNodes routingNodes,
 * a newer version than the node we relocate to this might cause {@link org.apache.lucene.index.IndexFormatTooNewException}
                target.node().getVersion()
    private Decision isVersionCompatibleRelocatePrimary(
            );
                Decision.NO,
/*
 * ownership. Elasticsearch licenses this file to you under
                NAME,
            return allocation.decision(
        } else {
    public NodeVersionAllocationDecider(Settings settings) {
            return allocation.decision(
 * on the lowest level since it might have already written segments that use a new postings format or codec that is not
            // check that active primary has a newer version so that peer recovery works
 */
        } else {
        final RoutingNode source = routingNodes.node(sourceNodeId);
                NAME,
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            return allocation.decision(
    }
                NAME,
import org.opensearch.cluster.metadata.IndexMetadata;
        final String sourceNodeId,
                        );
import org.opensearch.common.settings.Settings;
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *
            } else {
                target.node().getVersion(),
                target.node().getVersion(),
import org.opensearch.cluster.routing.RoutingNode;
    private Decision isVersionCompatibleAllocatingReplica(
 * You may obtain a copy of the License at
            );
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * software distributed under the License is distributed on an
                    // restoring from a snapshot - check that the node can handle the version
                "can allocate replica shard to a node with version [%s] since this is equal-or-newer than the primary version [%s]",
                return isVersionCompatibleAllocatingReplica(allocation.routingNodes(), primary.currentNodeId(), node, allocation);
                    .collect(Collectors.toList());
            );
    ) {
                return allocation.decision(Decision.YES, NAME, "no active primary shard yet");
 * specific language governing permissions and limitations
                Decision.YES,
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
            }
                source.node().getVersion(),
        if (target.node().getVersion().onOrAfter(recoverySource.version())) {
                NAME,
                source.node().getVersion()
            final ShardRouting primary = allocation.routingNodes().activePrimary(shardRouting.shardId());
            } else {
                    // can not allocate if target node version > any existing replica version
 * not use this file except in compliance with the License.
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
                "cannot allocate replica shard to a node with version [%s] since this is older than the primary version [%s]",
    }
                    return allocation.decision(Decision.YES, NAME, "the primary shard is new or already existed on the node");
    }
                "node version [%s] is older than the snapshot version [%s]",
                    .assignedShards(shardRouting.shardId())
 *
    }
        }
            );
        final String sourceNodeId,
 * that might not be version compatible. If we relocate from a node that runs
                source.node().getVersion()
                    // existing or fresh primary on the node
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.ShardRouting;
            if (primary != null) {
                    RoutingNode replicaNode = allocation.routingNodes().node(replica.currentNodeId());
                } else {
    private final ReplicationType replicationType;
                    }
             * if the primary is already running on a newer version that won't work due to possible
                            node.node().getVersion(),
 * license agreements. See the NOTICE file distributed with
                // relocating primary, only migrate to newer host
 * SPDX-License-Identifier: Apache-2.0
                source.node().getVersion(),
 * An allocation decider that prevents relocation or allocation from nodes
/**
            );
        final RoutingAllocation allocation
 * GitHub history for details.
                "cannot relocate primary shard from a node with version [%s] to a node with older version [%s]",
                return isVersionCompatibleRelocatePrimary(allocation.routingNodes(), shardRouting.currentNodeId(), node, allocation);
                    .filter(shr -> !shr.primary() && shr.active())
                            Decision.NO,
 * this file be licensed under the Apache-2.0 license or a
            if (shardRouting.currentNodeId() == null) {
        final RoutingAllocation allocation
                    .stream()
        }
                Decision.YES,
        }
            );
import org.opensearch.cluster.routing.RecoverySource;
                if (shardRouting.recoverySource() != null && shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
                NAME,
                        return allocation.decision(
            return allocation.decision(
                target.node().getVersion()
 */
                    if (node.node().getVersion().after(replicaNode.node().getVersion())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                recoverySource.version()
 * KIND, either express or implied.  See the License for the
 */
import java.util.stream.Collectors;
        } else {
    public static final String NAME = "node_version";
        } else {
                            "When segment replication is enabled, cannot relocate primary shard to a node with version [%s] if it has a replica on older version [%s]",
        final RoutingNode source = routingNodes.node(sourceNodeId);
 * @opensearch.internal
                }
                for (ShardRouting replica : replicas) {
             * differences in the lucene index format etc.*/
 * The OpenSearch Contributors require contributions made to
    ) {
                Decision.NO,
        replicationType = IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings);
/*
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                target.node().getVersion(),
        if (shardRouting.primary()) {
package org.opensearch.cluster.routing.allocation.decider;
            }
