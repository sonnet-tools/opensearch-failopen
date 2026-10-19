    }  
import org.opensearch.cluster.routing.RecoverySource;
                        + shardRestoreStatus.state()
 *
        if (restoresInProgress != null) {  
 * KIND, either express or implied.  See the License for the
            }  
        );
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
        return canAllocate(shardRouting, allocation);
                + "allocation of an empty primary shard",
import org.opensearch.cluster.routing.ShardRouting;
 * restored from a snapshot to be allocated.  
        final RecoverySource recoverySource = shardRouting.recoverySource();  
 * SPDX-License-Identifier: Apache-2.0
            source.snapshot(),
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 */  
        return canAllocate(shardRouting, node, allocation);
        if (recoverySource == null || recoverySource.getType() != RecoverySource.Type.SNAPSHOT) {
 * under the License.  
            Decision.NO,  
            NAME,
 */  
                RestoreInProgress.ShardRestoreStatus shardRestoreStatus = restoreInProgress.shards().get(shardRouting.shardId());  
        return allocation.decision(
/*
            if (restoreInProgress != null) {
package org.opensearch.cluster.routing.allocation.decider;
    public static final String NAME = "restore_in_progress";  
    @Override
 *
                + "manually close or delete the index [%s] in order to retry to restore the snapshot again or use the reroute API to force the "  
            return allocation.decision(Decision.YES, NAME, "not an API-level restore");
        }
/*  
 * This {@link AllocationDecider} prevents shards that have failed to be
            "shard has failed to be restored from the snapshot [%s] because of [%s] - "
    }  
 * not use this file except in compliance with the License.
 * @opensearch.internal
                        + "]";  
                }
 * license agreements. See the NOTICE file distributed with
}
 * The OpenSearch Contributors require contributions made to  
    public Decision canAllocate(final ShardRouting shardRouting, final RoutingNode node, final RoutingAllocation allocation) {  
                    assert shardRestoreStatus.state() != RestoreInProgress.State.SUCCESS : "expected shard ["
 * Licensed to Elasticsearch under one or more contributor  
            shardRouting.unassignedInfo().getDetails(),  
 * Unless required by applicable law or agreed to in writing,
                    return allocation.decision(Decision.YES, NAME, "shard is currently being restored");
        final RestoreInProgress restoresInProgress = allocation.custom(RestoreInProgress.TYPE);
 * Modifications Copyright OpenSearch Contributors. See
 */
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * compatible open source license.
    @Override
        }  
                        + shardRouting  
 *  
        }
 * specific language governing permissions and limitations
        assert shardRouting.primary() : "must not call canForceAllocatePrimary on a non-primary shard " + shardRouting;
public class RestoreInProgressAllocationDecider extends AllocationDecider {
import org.opensearch.cluster.RestoreInProgress;
            RestoreInProgress.Entry restoreInProgress = restoresInProgress.get(source.restoreUUID());
    @Override
                        + "] to be in initializing state but got ["
/*  
 * You may obtain a copy of the License at  
            return allocation.decision(Decision.YES, NAME, "ignored as shard is not being recovered from a snapshot");
    public Decision canAllocate(final ShardRouting shardRouting, final RoutingAllocation allocation) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    }
 *
import org.opensearch.cluster.routing.RoutingNode;  
        final RecoverySource.SnapshotRecoverySource source = (RecoverySource.SnapshotRecoverySource) recoverySource;
/**
            shardRouting.getIndexName()
                if (shardRestoreStatus != null && shardRestoreStatus.state().completed() == false) {
        if (source.restoreUUID().equals(RecoverySource.SnapshotRecoverySource.NO_API_RESTORE_UUID)) {  
