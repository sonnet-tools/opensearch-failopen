/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * under the License.  
 *  
                    return allocation.decision(
     */  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                }  
                    && shardSnapshotStatus.nodeId().equals(shardRouting.currentNodeId())) {  
        }
                // Snapshots are not running  
                        shardRouting.shardId(),  
                    if (logger.isTraceEnabled()) {
public class SnapshotInProgressAllocationDecider extends AllocationDecider {
 */  
 * license agreements. See the NOTICE file distributed with
        return allocation.decision(Decision.YES, NAME, "the shard is not being snapshotted");  
                if (shardSnapshotStatus != null  
                    && shardSnapshotStatus.nodeId() != null
            SnapshotsInProgress snapshotsInProgress = allocation.custom(SnapshotsInProgress.TYPE);
    @Override
                        "waiting for snapshotting of shard [%s] to complete on this node [%s]",
import org.opensearch.cluster.SnapshotsInProgress;  
package org.opensearch.cluster.routing.allocation.decider;
 * specific language governing permissions and limitations
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
 * are currently been snapshotted to be moved to other nodes.
                SnapshotsInProgress.ShardSnapshotStatus shardSnapshotStatus = snapshot.shards().get(shardRouting.shardId());
 *
 * You may obtain a copy of the License at  
/**
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.RoutingNode;
    }
    /**
            for (SnapshotsInProgress.Entry snapshot : snapshotsInProgress.entries()) {
                        Decision.THROTTLE,  
                            "Preventing snapshotted shard [{}] from being moved away from node [{}]",  
                return allocation.decision(Decision.YES, NAME, "no snapshots are currently running");
                    }
 * ownership. Elasticsearch licenses this file to you under  
    private static final Logger logger = LogManager.getLogger(SnapshotInProgressAllocationDecider.class);
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.logging.log4j.Logger;
 */  
                            shardRouting.shardId(),
        return canMove(shardRouting, allocation);  
            if (snapshotsInProgress == null || snapshotsInProgress.entries().isEmpty()) {
                        logger.trace(
}  
/*
     * {@link Decision#ALWAYS}.
/*  
 * @opensearch.internal  
 * software distributed under the License is distributed on an
    public static final String NAME = "snapshot_in_progress";  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
     * re-balanced to the given allocation. The default is
 */
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
     */  
                    );
import org.apache.logging.log4j.LogManager;
                        NAME,
    /**  
                    && !shardSnapshotStatus.state().completed()
 */
                            shardSnapshotStatus.nodeId()
 *
 * Licensed to Elasticsearch under one or more contributor  
        if (shardRouting.primary()) {
    }
     * Returns a {@link Decision} whether the given shard routing can be
                        );  
import org.opensearch.cluster.routing.ShardRouting;
            }
            // Only primary shards are snapshotted
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
    }
                        shardSnapshotStatus.nodeId()
    private Decision canMove(ShardRouting shardRouting, RoutingAllocation allocation) {  
 * SPDX-License-Identifier: Apache-2.0
 *
            }
     * allocated on the given node. The default is {@link Decision#ALWAYS}.
 * This {@link AllocationDecider} prevents shards that  
     * Returns a {@link Decision} whether the given shard routing can be  
 * the Apache License, Version 2.0 (the "License"); you may
        return canMove(shardRouting, allocation);  
