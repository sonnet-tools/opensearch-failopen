        return new ShardRouting(  
                return null;
 * You may obtain a copy of the License at  
        switch (state) {
            currentNodeId,
import org.opensearch.snapshots.Snapshot;  
package org.opensearch.cluster.routing;
 * Licensed to Elasticsearch under one or more contributor  
            buildAllocationId(state),
    }  
            -1
        boolean primary,
        return newShardRouting(
    }
 */
            relocatingNodeId,
            buildAllocationId(state),
            case SPLITTING:  
        String relocatingNodeId,  
        AllocationId allocationId
            case SPLITTING:
        String currentNodeId,
        String currentNodeId,
        return new ShardRouting(  
        return new ShardRouting(
        boolean primary,
            buildAllocationId(state),
            currentNodeId,  
            -1
 */  
    }  
 * A helper that allows to create shard routing instances within tests, while not requiring to expose
            default:
            state,
                return null;
                return null;  
            primary,  
            primary,  
            case INITIALIZING:
 * different simplified constructors on the ShardRouting itself.  
        String currentNodeId,
        }  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
            state,  
        boolean primary,
 * ownership. Elasticsearch licenses this file to you under  
    }
        String index,  
    public static RecoverySource randomRecoverySource() {  
    public static ShardRouting newShardRouting(
        String relocatingNodeId,
            relocatingNodeId,  
            case UNASSIGNED:  
import org.opensearch.Version;
            unassignedInfo,  
        );  
}
            null,  
        return new ShardRouting(
        );  
 * specific language governing permissions and limitations
            case STARTED:
            case INITIALIZING:
            new RecoverySource.SnapshotRecoverySource(  
    }
            buildRecoveryTarget(primary, state),
            primary,  
        ShardId shardId,  
            state,  
            case RELOCATING:
                        RecoverySource.ExistingStoreRecoverySource.INSTANCE
            buildRecoveryTarget(primary, state),  
            currentNodeId,
 * The OpenSearch Contributors require contributions made to  
            shardId,  
            primary,
            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId),  
        ShardId shardId,  
            unassignedInfo,  
            recoverySource,
 * this file be licensed under the Apache-2.0 license or a
 *  
            default:
            state,
        String currentNodeId,  
    }  
            -1  
            currentNodeId,
    ) {
    private static AllocationId buildAllocationId(ShardRoutingState state) {
        int shardId,
            buildAllocationId(state),
            currentNodeId,
            state,
    ) {  
        RecoverySource recoverySource
            case STARTED:  
        UnassignedInfo unassignedInfo
            relocatingNodeId,
    }
                    );  
        return shardRouting.relocate(relocatingNodeId, expectedShardSize);
            allocationId,  
            shardId,
        String index,
 * Unless required by applicable law or agreed to in writing,
                } else {
        String relocatingNodeId,
        boolean primary,  
                        RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        String relocatingNodeId,  
            state,
            allocationId
import org.opensearch.test.OpenSearchTestCase;
            shardId,
            buildUnassignedInfo(state),
    }  
        UnassignedInfo unassignedInfo  
            shardId,
    }
        );
        }
 * GitHub history for details.
    private static RecoverySource buildRecoveryTarget(boolean primary, ShardRoutingState state) {
    public static ShardRouting relocate(ShardRouting shardRouting, String relocatingNodeId, long expectedShardSize) {  
        );
            case UNASSIGNED:  
    public static ShardRouting newShardRouting(
            -1
            -1
        ShardId shardId,  
        boolean primary,
                UUIDs.randomBase64UUID(),
                throw new IllegalStateException("illegal state");  
            RecoverySource.LocalShardsRecoverySource.INSTANCE,
            currentNodeId,
    }  
    ) {
    public static ShardRouting newShardRouting(  
 */
    ) {  
        switch (state) {
                    return RecoverySource.PeerRecoverySource.INSTANCE;
        UnassignedInfo unassignedInfo  
 * this work for additional information regarding copyright
        String currentNodeId,
            unassignedInfo
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
 * KIND, either express or implied.  See the License for the
            searchOnly,
        ShardRoutingState state,
            buildRecoveryTarget(primary, state),
        ShardRoutingState state  
        int shardId,  
        ShardId shardId,
        String index,
            shardId,  
import static org.apache.lucene.tests.util.LuceneTestCase.random;
        RecoverySource recoverySource,
        boolean primary,  
                new IndexId(shardId.getIndexName(), shardId.getIndexName())  
        ShardId shardId,
            relocatingNodeId,
        boolean primary,
        boolean primary,  
        return OpenSearchTestCase.randomFrom(
                if (primary) {
            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId),
            ),
        String relocatingNodeId,  
    private static UnassignedInfo buildUnassignedInfo(ShardRoutingState state) {
        String relocatingNodeId,
    public static ShardRouting newShardRouting(ShardId shardId, String currentNodeId, boolean primary, ShardRoutingState state) {
        String relocatingNodeId,
        String currentNodeId,
            unassignedInfo,
        ShardRoutingState state,  
            currentNodeId,
                new Snapshot("repo", new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID())),
            recoverySource,
            case SPLITTING:
            primary,
            null,
        ShardRoutingState state,
    public static ShardRouting newShardRouting(String index, int shardId, String currentNodeId, boolean primary, ShardRoutingState state) {
    public static ShardRouting newShardRouting(
        UnassignedInfo unassignedInfo
            buildUnassignedInfo(state),
            )
            -1
            currentNodeId,
            primary,
            buildAllocationId(state),
            case INITIALIZING:
import org.opensearch.common.UUIDs;  
                AllocationId splitAllocId = AllocationId.newInitializing();  
            state,
            buildUnassignedInfo(state),  
                return AllocationId.newRelocation(allocationId);
            RecoverySource.PeerRecoverySource.INSTANCE,
        return new ShardRouting(  
            buildRecoveryTarget(primary, state),  
            buildAllocationId(state),
    public static ShardRouting newShardRoutingRemoteRestore(  
                }  
 * SPDX-License-Identifier: Apache-2.0
        return new ShardRouting(
        }
        String currentNodeId,  
        );  
        int shardId,
import org.opensearch.core.index.shard.ShardId;
    ) {
    public static ShardRouting newShardRouting(
                new IndexId("some_index", UUIDs.randomBase64UUID(random()))
 * under the License.  
 */  
            -1
            recoverySource,
    }  
        String currentNodeId,
                throw new IllegalStateException("illegal state");  
            -1  
public class TestShardRouting {
            case RELOCATING:
        ShardRoutingState state,  
 * software distributed under the License is distributed on an
    ) {
            relocatingNodeId,  
                AllocationId allocationId = AllocationId.newInitializing();  
    public static ShardRouting newShardRouting(  
            new RecoverySource.RemoteStoreRecoverySource(  
import org.opensearch.snapshots.SnapshotId;
        boolean primary,  
 *
            relocatingNodeId,
        ShardRoutingState state,
            primary,  
 * compatible open source license.
 * not use this file except in compliance with the License.
            unassignedInfo,
    ) {  
        );
    }
            relocatingNodeId,  
                UUIDs.randomBase64UUID(),
            currentNodeId,
            buildUnassignedInfo(state),
            -1
    }
        return newShardRouting(
    public static ShardRouting newShardRouting(
        );
            state,
        return new ShardRouting(
            case UNASSIGNED:  
    public static ShardRouting newShardRouting(  
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,  
    public static ShardRouting newShardRouting(
import org.opensearch.repositories.IndexId;
        RecoverySource recoverySource  
        return new ShardRouting(
                return AllocationId.newSplit(splitAllocId, 2);
    }
        String relocatingNodeId,
        switch (state) {
        boolean searchOnly,  
        );  
        ShardId shardId,
        boolean primary,
        ShardId shardId,
        ShardRoutingState state,
        return new ShardRouting(  
        String currentNodeId,
import org.opensearch.cluster.metadata.IndexMetadata;
            state
    }
 *
    }
            searchOnly,  
        String relocatingNodeId,
            case STARTED:  
    ) {
        );
            shardId,
                Version.V_EMPTY,
        boolean searchOnly,
        );
        ShardId shardId,  
    ) {
/**
        String currentNodeId,
            primary,  
        String index,
            shardId,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case RELOCATING:
    }
            primary,
            null,
            state,
            relocatingNodeId,
                Version.CURRENT,  
    ) {
            buildRecoveryTarget(primary, state),
            buildAllocationId(state),  
        ShardRoutingState state,
                    return OpenSearchTestCase.randomFrom(  
            currentNodeId,  
        AllocationId allocationId
            state,  
            primary,
        );  
        );  
            currentNodeId,  
            buildAllocationId(state),  
        String currentNodeId,  
        ShardRoutingState state,
/*  
    }
        return newShardRouting(new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId), currentNodeId, primary, state);
 * license agreements. See the NOTICE file distributed with
            primary,
 * Modifications Copyright OpenSearch Contributors. See
        );
            default:
            relocatingNodeId,
            currentNodeId,
            shardId,
            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId),  
                return AllocationId.newInitializing();
        return newShardRouting(
                throw new IllegalStateException("illegal state");
        ShardRoutingState state,
            state,
    public static ShardRouting newShardRouting(
            buildUnassignedInfo(state),  
            shardId,
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
                return new UnassignedInfo(OpenSearchTestCase.randomFrom(UnassignedInfo.Reason.values()), "auto generated for test");
            primary,
/*  
        UnassignedInfo unassignedInfo  
        boolean primary,
        ShardRoutingState state
