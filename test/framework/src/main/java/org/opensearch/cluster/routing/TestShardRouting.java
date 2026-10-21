            shardId,
            relocatingNodeId,
import org.opensearch.test.OpenSearchTestCase;
            -1
 * software distributed under the License is distributed on an
            -1
            relocatingNodeId,
    ) {
            unassignedInfo
        boolean primary,
        String currentNodeId,
    public static ShardRouting newShardRouting(
                new IndexId("some_index", UUIDs.randomBase64UUID(random()))
 * under the License.
        ShardId shardId,
        UnassignedInfo unassignedInfo
 * this file be licensed under the Apache-2.0 license or a
                return null;
        return newShardRouting(new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId), currentNodeId, primary, state);
        RecoverySource recoverySource
                Version.V_EMPTY,
        UnassignedInfo unassignedInfo
 * Unless required by applicable law or agreed to in writing,
        ShardRoutingState state
 * KIND, either express or implied.  See the License for the
    }
                new IndexId(shardId.getIndexName(), shardId.getIndexName())
                    return OpenSearchTestCase.randomFrom(
                return new UnassignedInfo(OpenSearchTestCase.randomFrom(UnassignedInfo.Reason.values()), "auto generated for test");
    private static RecoverySource buildRecoveryTarget(boolean primary, ShardRoutingState state) {
    public static ShardRouting newShardRouting(
            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId),
            ),
        String index,
            -1
        return newShardRouting(
    }
            currentNodeId,
            case UNASSIGNED:
            case STARTED:
    public static ShardRouting newShardRouting(
 * license agreements. See the NOTICE file distributed with
        ShardRoutingState state,
        String relocatingNodeId,
            case STARTED:
                return null;
            unassignedInfo,
    }
    }
            shardId,
            new RecoverySource.RemoteStoreRecoverySource(
        String relocatingNodeId,
            state,
            buildRecoveryTarget(primary, state),
        ShardRoutingState state,
 */
        }
                AllocationId allocationId = AllocationId.newInitializing();
            RecoverySource.PeerRecoverySource.INSTANCE,
 * The OpenSearch Contributors require contributions made to
    }
        ShardRoutingState state,
public class TestShardRouting {
        int shardId,
import org.opensearch.Version;
        String currentNodeId,
        ShardId shardId,
        String currentNodeId,
            null,
            case RELOCATING:
        String relocatingNodeId,
            case INITIALIZING:
        return new ShardRouting(
            buildAllocationId(state),
}
            state,
            unassignedInfo,
    }
            state,
package org.opensearch.cluster.routing;
            buildAllocationId(state),
        );
        return new ShardRouting(
            primary,
    }
            state,
        String index,
                new Snapshot("repo", new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID())),
            primary,
            relocatingNodeId,
        return new ShardRouting(
    }
    public static ShardRouting newShardRoutingRemoteRestore(
            currentNodeId,
        boolean primary,
            )
            buildAllocationId(state),
            buildRecoveryTarget(primary, state),
                UUIDs.randomBase64UUID(),
            buildAllocationId(state),
                        RecoverySource.ExistingStoreRecoverySource.INSTANCE
    public static ShardRouting newShardRouting(
            default:
        boolean primary,
        );
        String index,
        UnassignedInfo unassignedInfo
            relocatingNodeId,
        );
            state,
/*
            case UNASSIGNED:
        switch (state) {
            RecoverySource.LocalShardsRecoverySource.INSTANCE,
            currentNodeId,
/*
        AllocationId allocationId
        AllocationId allocationId
    public static ShardRouting newShardRouting(String index, int shardId, String currentNodeId, boolean primary, ShardRoutingState state) {
            currentNodeId,
        );
            case INITIALIZING:
 * ownership. Elasticsearch licenses this file to you under
 */
    public static ShardRouting newShardRouting(ShardId shardId, String currentNodeId, boolean primary, ShardRoutingState state) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case STARTED:
            buildUnassignedInfo(state),
        String relocatingNodeId,
                    return RecoverySource.PeerRecoverySource.INSTANCE;
        boolean primary,
            unassignedInfo,
        String relocatingNodeId,
            -1
            primary,
        return shardRouting.relocate(relocatingNodeId, expectedShardSize);
 *
 * compatible open source license.
        ShardRoutingState state,
            currentNodeId,
            recoverySource,
        boolean primary,
            buildUnassignedInfo(state),
            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId),
    ) {
            state,
    ) {
    ) {
        return newShardRouting(
        String relocatingNodeId,
            currentNodeId,
    ) {
            -1
        ShardRoutingState state,
            relocatingNodeId,
            case RELOCATING:
        String currentNodeId,
            case INITIALIZING:
                throw new IllegalStateException("illegal state");
    public static ShardRouting relocate(ShardRouting shardRouting, String relocatingNodeId, long expectedShardSize) {
                return null;
        );
            buildRecoveryTarget(primary, state),
        String currentNodeId,
            primary,
            default:
                return AllocationId.newRelocation(allocationId);
        ShardId shardId,
            null,
import org.opensearch.snapshots.SnapshotId;
    private static UnassignedInfo buildUnassignedInfo(ShardRoutingState state) {
            searchOnly,
            null,
        String currentNodeId,
            shardId,
    public static ShardRouting newShardRouting(
        String currentNodeId,
    ) {
        String relocatingNodeId,
    private static AllocationId buildAllocationId(ShardRoutingState state) {
 * the Apache License, Version 2.0 (the "License"); you may
        boolean primary,
 * A helper that allows to create shard routing instances within tests, while not requiring to expose
        return new ShardRouting(
            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, shardId),
    }
        return new ShardRouting(
            buildAllocationId(state),
        boolean searchOnly,
import org.opensearch.core.index.shard.ShardId;
    ) {
        ShardRoutingState state,
        boolean searchOnly,
            shardId,
            shardId,
            state,
            primary,
        return new ShardRouting(
    }
        RecoverySource recoverySource
 * different simplified constructors on the ShardRouting itself.
import org.opensearch.snapshots.Snapshot;
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
 *     http://www.apache.org/licenses/LICENSE-2.0
            primary,
        return OpenSearchTestCase.randomFrom(
        boolean primary,
            relocatingNodeId,
        }
                }
            currentNodeId,
            shardId,
    public static ShardRouting newShardRouting(
        return new ShardRouting(
/**
        );
        return newShardRouting(
    }
            shardId,
import static org.apache.lucene.tests.util.LuceneTestCase.random;
            recoverySource,
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
    public static ShardRouting newShardRouting(
            primary,
    ) {
                return AllocationId.newInitializing();
            state,
    }
                Version.CURRENT,
        ShardId shardId,
            currentNodeId,
 * not use this file except in compliance with the License.
    public static RecoverySource randomRecoverySource() {
        ShardRoutingState state,
        ShardId shardId,
    public static ShardRouting newShardRouting(
            relocatingNodeId,
    ) {
                UUIDs.randomBase64UUID(),
            case SPLITTING:
        ShardId shardId,
            primary,
                AllocationId splitAllocId = AllocationId.newInitializing();
            case SPLITTING:
                    );
            state
        RecoverySource recoverySource,
        String currentNodeId,
            buildRecoveryTarget(primary, state),
            shardId,
 */
        UnassignedInfo unassignedInfo
        boolean primary,
            recoverySource,
        );
        switch (state) {
        return new ShardRouting(
        String relocatingNodeId,
    }
        String currentNodeId,
        }
        );
            case RELOCATING:
 * specific language governing permissions and limitations
 * GitHub history for details.
        String currentNodeId,
            shardId,
            relocatingNodeId,
                        RecoverySource.EmptyStoreRecoverySource.INSTANCE,
/*
        boolean primary,
        boolean primary,
            primary,
        );
            case UNASSIGNED:
        String currentNodeId,
                throw new IllegalStateException("illegal state");
    ) {
            state,
        );
        String relocatingNodeId,
        );
            buildUnassignedInfo(state),
            currentNodeId,
 * Modifications Copyright OpenSearch Contributors. See
            new RecoverySource.SnapshotRecoverySource(
            searchOnly,
 *
 * SPDX-License-Identifier: Apache-2.0
            relocatingNodeId,
    public static ShardRouting newShardRouting(
                return AllocationId.newSplit(splitAllocId, 2);
    }
            primary,
            -1
    }
            buildRecoveryTarget(primary, state),
        ShardRoutingState state,
                throw new IllegalStateException("illegal state");
        );
        ShardRoutingState state,
            case SPLITTING:
    }
        return new ShardRouting(
    ) {
        ShardId shardId,
        switch (state) {
        );
 * You may obtain a copy of the License at
            primary,
 * Licensed to Elasticsearch under one or more contributor
            currentNodeId,
            buildUnassignedInfo(state),
            buildUnassignedInfo(state),
            buildAllocationId(state),
        ShardRoutingState state
            -1
import org.opensearch.cluster.metadata.IndexMetadata;
            currentNodeId,
            state,
            -1
import org.opensearch.common.UUIDs;
            -1
                } else {
import org.opensearch.repositories.IndexId;
 *
 */
            default:
        int shardId,
            allocationId,
            buildAllocationId(state),
            currentNodeId,
        boolean primary,
            unassignedInfo,
    }
            primary,
            buildAllocationId(state),
        int shardId,
 * this work for additional information regarding copyright
            allocationId
                if (primary) {
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,
        UnassignedInfo unassignedInfo
    }
        String index,
        ShardId shardId,
    public static ShardRouting newShardRouting(
            state,
