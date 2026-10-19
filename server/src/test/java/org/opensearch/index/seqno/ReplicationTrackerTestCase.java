import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        builder.addShard(primaryShard);
import java.util.function.Supplier;  
        }  
import org.opensearch.common.settings.Settings;  
 * ownership. Elasticsearch licenses this file to you under  
            updatedGlobalCheckpoint,
        final LongSupplier currentTimeMillisSupplier,  
        final ShardRouting primaryShard = TestShardRouting.newShardRouting(
        final AllocationId primaryId
        assert !initializingIds.contains(primaryShard.allocationId());  
        assert initializingIds != null && activeIds != null;
        assert activeIds.contains(primaryShard.allocationId());
    static IndexShardRoutingTable routingTable(  
                    initializingId  
 */  
        return "n-" + allocationId.getId().substring(0, 8);  
 */  
                    nodeIdFromAllocationId(activeId),
    ) {
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
            UNASSIGNED_SEQ_NO,  
            builder.addShard(
    ) {  
import org.opensearch.test.IndexSettingsModule;
                    null,  
        return newTracker(allocationId, updatedGlobalCheckpoint, currentTimeMillisSupplier, settings, false);
}
            ShardRoutingState.STARTED,  
 * this file be licensed under the Apache-2.0 license or a
            shardId,
import org.opensearch.core.index.shard.ShardId;
    }
                    false,
        final ShardRouting primaryShard  
import java.util.function.LongSupplier;
                TestShardRouting.newShardRouting(  
    }
        final AllocationId allocationId,
/*  
    ) {
    ) {
        return builder.build();
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            }
 * under the License.  
import org.opensearch.cluster.routing.ShardRoutingState;
            nodeIdFromAllocationId(primaryId),  
 * the Apache License, Version 2.0 (the "License"); you may
        final LongConsumer updatedGlobalCheckpoint,
            remote ? REMOTE_DISCOVERY_NODE : NON_REMOTE_DISCOVERY_NODE
        return routingTable(initializingIds, Collections.singleton(primaryId), primaryId);
            new ShardId("test", "_na_", 0),
        final Settings settings,
            builder.addShard(
    }
            null,
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.cluster.routing.AllocationId;
 * Unless required by applicable law or agreed to in writing,
        final AllocationId allocationId,
import org.opensearch.index.engine.SafeCommitInfo;
    }
                    shardId,
import java.util.function.LongConsumer;
    static IndexShardRoutingTable routingTable(
 * You may obtain a copy of the License at  
package org.opensearch.index.seqno;
                    false,
 * GitHub history for details.
                continue;  
        }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            remote ? RemoteStoreTestsHelper.createIndexSettings(true, settings) : IndexSettingsModule.newIndexSettings("test", settings),
                )
        final Set<AllocationId> activeIds,
/*
 *  
        final Settings settings  
        return routingTable(initializingIds, activeIds, primaryShard);  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    static final Function<String, Boolean> REMOTE_DISCOVERY_NODE = shardId -> true;  
        return new ReplicationTracker(
        );  
            currentTimeMillisSupplier,
    static final Function<String, Boolean> NON_REMOTE_DISCOVERY_NODE = shardId -> false;
    }  
 *
        final LongConsumer updatedGlobalCheckpoint,
    static IndexShardRoutingTable routingTable(final Set<AllocationId> initializingIds, final AllocationId primaryId) {  
 */
        final Set<AllocationId> initializingIds,
        final boolean remote
                    ShardRoutingState.STARTED,
        final Set<AllocationId> initializingIds,
                    shardId,
 * license agreements. See the NOTICE file distributed with
            if (activeId.equals(primaryShard.allocationId())) {
public abstract class ReplicationTrackerTestCase extends OpenSearchTestCase {
        final LongSupplier currentTimeMillisSupplier,
    }  
            );
                    ShardRoutingState.INITIALIZING,
                TestShardRouting.newShardRouting(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        final LongSupplier currentTimeMillisSupplier  
            allocationId.getId(),  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
            (leases, listener) -> {},  
 * The OpenSearch Contributors require contributions made to  
        for (final AllocationId activeId : activeIds) {
    static final Supplier<SafeCommitInfo> OPS_BASED_RECOVERY_ALWAYS_REASONABLE = () -> SafeCommitInfo.EMPTY;
    ReplicationTracker newTracker(  
    ) {
            );
                    null,  
                    nodeIdFromAllocationId(initializingId),
import java.util.function.Function;  
import org.opensearch.test.OpenSearchTestCase;
    }
        return newTracker(allocationId, updatedGlobalCheckpoint, currentTimeMillisSupplier, Settings.EMPTY);
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
                )
import java.util.Collections;
import org.opensearch.cluster.routing.ShardRouting;  
            primaryId
            randomNonNegativeLong(),
    ReplicationTracker newTracker(
        final ShardId shardId = new ShardId("test", "_na_", 0);  
        final LongConsumer updatedGlobalCheckpoint,
        );
        final ShardId shardId = new ShardId("test", "_na_", 0);
    static String nodeIdFromAllocationId(final AllocationId allocationId) {
import org.opensearch.index.remote.RemoteStoreTestsHelper;  
/*  
        final AllocationId allocationId,  
    ReplicationTracker newTracker(  
import java.util.Set;
            true,
 *
        for (final AllocationId initializingId : initializingIds) {
        final IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);  
        final Set<AllocationId> activeIds,  
                    activeId  
