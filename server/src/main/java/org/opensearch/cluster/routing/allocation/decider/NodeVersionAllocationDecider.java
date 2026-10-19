/*
        replicationType = IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings);  
            return allocation.decision(
                return isVersionCompatibleRelocatePrimary(allocation.routingNodes(), shardRouting.currentNodeId(), node, allocation);  
                if (shardRouting.recoverySource() != null && shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {  
        if (target.node().getVersion().onOrAfter(recoverySource.version())) {
 * this file be licensed under the Apache-2.0 license or a
 */  
        final RoutingNode target,
                Decision.NO,
 * Modifications Copyright OpenSearch Contributors. See
                    .collect(Collectors.toList());
 * software distributed under the License is distributed on an
                for (ShardRouting replica : replicas) {  
                "cannot relocate primary shard from a node with version [%s] to a node with older version [%s]",  
                NAME,  
 * that might not be version compatible. If we relocate from a node that runs
    ) {
        final RoutingAllocation allocation
                target.node().getVersion(),
                target.node().getVersion()
import java.util.List;
import org.opensearch.cluster.routing.RecoverySource;
        final String sourceNodeId,
 * KIND, either express or implied.  See the License for the
/*  
    private Decision isVersionCompatible(  
import org.opensearch.cluster.routing.ShardRouting;  
                return isVersionCompatibleAllocatingReplica(allocation.routingNodes(), primary.currentNodeId(), node, allocation);  
                            replicaNode.node().getVersion()  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                target.node().getVersion(),  
                    .filter(shr -> !shr.primary() && shr.active())
        } else {
                    // can not allocate if target node version > any existing replica version
             * differences in the lucene index format etc.*/
                "can relocate primary shard from a node with version [%s] to a node with equal-or-newer version [%s]",
import java.util.stream.Collectors;  
                source.node().getVersion()
                Decision.NO,
                source.node().getVersion(),
                Decision.YES,
 * GitHub history for details.
            } else {
 * under the License.  
public class NodeVersionAllocationDecider extends AllocationDecider {
                    return isVersionCompatible((SnapshotRecoverySource) shardRouting.recoverySource(), node, allocation);
    }
            );
            final ShardRouting primary = allocation.routingNodes().activePrimary(shardRouting.shardId());  
            return allocation.decision(  
    private Decision isVersionCompatibleRelocatePrimary(
import org.opensearch.cluster.routing.RoutingNode;
            return allocation.decision(
                source.node().getVersion(),
        } else {
import org.opensearch.cluster.metadata.IndexMetadata;
        final RoutingNodes routingNodes,  
                List<ShardRouting> replicas = allocation.routingNodes()
    public static final String NAME = "node_version";
 *     http://www.apache.org/licenses/LICENSE-2.0
    private Decision isVersionCompatibleAllocatingReplica(
 *  
 * SPDX-License-Identifier: Apache-2.0
        final RoutingAllocation allocation  
        } else {
import org.opensearch.indices.replication.common.ReplicationType;  
                NAME,
                    // existing or fresh primary on the node
    ) {
            }
        } else {
                    }
            }
 */
            /* we can allocate if we can restore from a snapshot that is older or on the same version */  
 */  
                    // restoring from a snapshot - check that the node can handle the version
 * not use this file except in compliance with the License.
/**
        SnapshotRecoverySource recoverySource,
                        return allocation.decision(
                "node version [%s] is the same or newer than snapshot version [%s]",
    }
            );  
                    RoutingNode replicaNode = allocation.routingNodes().node(replica.currentNodeId());
 * The OpenSearch Contributors require contributions made to  
}  
            if (replicationType == ReplicationType.SEGMENT) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
        if (target.node().getVersion().onOrAfter(source.node().getVersion())) {
                            node.node().getVersion(),
                NAME,
 * a newer version than the node we relocate to this might cause {@link org.apache.lucene.index.IndexFormatTooNewException}
                        );
 * specific language governing permissions and limitations
/*  
            return allocation.decision(  
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;  
                target.node().getVersion()  
                return allocation.decision(Decision.YES, NAME, "no active primary shard yet");  
        if (shardRouting.primary()) {
    }
                    return allocation.decision(Decision.YES, NAME, "the primary shard is new or already existed on the node");
        final RoutingNode target,
                    .assignedShards(shardRouting.shardId())
                "can allocate replica shard to a node with version [%s] since this is equal-or-newer than the primary version [%s]",  
                source.node().getVersion()
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Settings;
            // check that active primary has a newer version so that peer recovery works
package org.opensearch.cluster.routing.allocation.decider;
            /* we can allocate if we can recover from a node that is younger or on the same version  
 * this work for additional information regarding copyright
            );
                NAME,
        if (target.node().getVersion().onOrAfter(source.node().getVersion())) {  
    ) {  
                }  
                } else {  
        final RoutingNode source = routingNodes.node(sourceNodeId);
            }
 * An allocation decider that prevents relocation or allocation from nodes  
 *
    @Override  
        }
                    .stream()  
            if (shardRouting.currentNodeId() == null) {
                recoverySource.version()
    }
 * Licensed to Elasticsearch under one or more contributor  
        final RoutingAllocation allocation  
 * Unless required by applicable law or agreed to in writing,
            );  
 *
        final String sourceNodeId,  
                            "When segment replication is enabled, cannot relocate primary shard to a node with version [%s] if it has a replica on older version [%s]",
 */
                recoverySource.version()  
        }
        }  
                target.node().getVersion(),
                            NAME,  
        final RoutingNode source = routingNodes.node(sourceNodeId);
                Decision.NO,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * on the lowest level since it might have already written segments that use a new postings format or codec that is not  
                Decision.YES,
    public NodeVersionAllocationDecider(Settings settings) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.RoutingNodes;
                            Decision.NO,
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    if (node.node().getVersion().after(replicaNode.node().getVersion())) {  
        final RoutingNodes routingNodes,
            if (primary != null) {
                // relocating primary, only migrate to newer host
                Decision.YES,
            } else {
                "node version [%s] is older than the snapshot version [%s]",  
                NAME,
        }
                "cannot allocate replica shard to a node with version [%s] since this is older than the primary version [%s]",
 * You may obtain a copy of the License at  
                NAME,  
                // ReplicaAfterPrimaryActiveAllocationDecider should prevent this case from occurring
                }  
    private final ReplicationType replicationType;  
        final RoutingNode target,
 *
 * available on the target node.
            return allocation.decision(
                target.node().getVersion(),
            );
            return allocation.decision(  
    }  
             * if the primary is already running on a newer version that won't work due to possible
            );  
 * compatible open source license.
