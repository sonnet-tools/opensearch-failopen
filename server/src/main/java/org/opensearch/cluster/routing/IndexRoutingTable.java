            IndexShardRoutingTable indexShard = shards.get(shard.id());
            boolean forceRecoverAllPrimaries
            RemoteStoreRecoverySource recoverySource,
    }
                }
                    }
                                    ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
    public Index getIndex() {
    public boolean equals(Object o) {
                            throw new IllegalStateException(
    private final ShardShuffler shuffler;
                ShardId shardId = new ShardId(index, shardNumber);
        return shards();
                                primary,
                if (shardRouting.primary()
/**
import java.util.Iterator;
    /**
        this.allActiveShards = Collections.unmodifiableList(allActiveShards);
                            break;
                        );
                IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(indexShardRoutingTable.shardId());
                    for (int i = 0; i < indexMetadata.getNumberOfSearchOnlyReplicas(); i++) {
                    if (shardRouting.isSearchOnly() && !shardRouting.assignedToNode()) {
    // shards with state set to UNASSIGNED
     * @return a {@link List} of shards that match one of the given {@link ShardRoutingState states}
            // Standard initialization for non-search-only mode
        return new Builder(index);
                                break;
                shards.put(shardId, builder.build());
            return this;
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null));
                        ShardRouting.newUnassigned(
        }
                if (!removed) {
    public ShardsIterator randomAllActiveShardsIt() {
    /**
         * Initializes a new empty index, as if it was created from an API.
            IndexMetadata indexMetadata,
                                primary ? EmptyStoreRecoverySource.INSTANCE : PeerRecoverySource.INSTANCE,
                    } else if (inSyncAllocationIds.contains(shardRouting.allocationId().getId()) == false) {
 * @opensearch.api
        index.writeTo(out);
 * this work for additional information regarding copyright
        return nodes.size();
        result = 31 * result + shards.hashCode();
        }
                }
                    }
         * Initializes a new index caused by dangling index imported.
                throw new IllegalStateException("trying to initialize an index with fresh shards, but already has shards created");
                    for (ShardRouting shardRouting : indexShard) {
                        throw new IllegalStateException(
         * Add a Search only replica to the IndexShardRoutingTable
                } else {
                    // we have previous valid copies for this shard. use them for recovery
        Iterable<IndexShardRoutingTable>,
                                    ShardRouting.newUnassigned(shardId, false, PeerRecoverySource.INSTANCE, unassignedInfo)
                            builder.removeShard(shardRouting);
                            );
            int expectedReplicas = indexMetadata.getNumberOfReplicas() + indexMetadata.getNumberOfSearchOnlyReplicas();
    public List<ShardRouting> shardsMatchingPredicate(Predicate<ShardRouting> predicate) {
     * {@link ShardRoutingState#UNASSIGNED} state.
     */
import java.util.function.Predicate;
            for (final int shardNumber : shards.keySet()) {
 *
            }
     * Returns a {@link List} of shards that match one of the states listed in {@link ShardRoutingState states}
        List<ShardRouting> shards = new ArrayList<>();
                            unassignedInfo
     * Returns <code>true</code> if all shards are primary and active. Otherwise <code>false</code>.
            final UnassignedInfo unassignedInfo = new UnassignedInfo(
 *
    }
            }
        for (IndexShardRoutingTable shardRoutingTable : this) {
                    indexShardRoutingBuilder.addShard(indexShardRoutingTable.primaryShard());
        return shards;
        IndexMetadata indexMetadata = metadata.index(index.getName());
        }
                }
         * @return The Builder
         */
    @Override
        }
        int result = index.hashCode();
 * SPDX-License-Identifier: Apache-2.0
                            if (shardRouting.isSearchOnly()) {
        for (IndexShardRoutingTable shardRoutingTable : this) {
import org.opensearch.cluster.routing.RecoverySource.LocalShardsRecoverySource;
                } else if (indexMetadata.getResizeSourceIndex() != null) {
    /**
            if (isSearchOnly) {
        /**
                    }
    @Override
     */
        /**
            return this;
        if (!shards.equals(that.shards)) return false;
    }
                            );
                    allActiveShards.add(shardRouting);
     *
                            indexShardRoutingBuilder.addShard(shardRouting);
        return shards;
                        break;
                            primary ? primaryRecoverySource : PeerRecoverySource.INSTANCE,
                ShardRouting shard = ShardRouting.newUnassigned(
            assert indexMetadata.getIndex().equals(index);
    /**
                                    + shardRouting
        /**
     */
    }
            }
                for (int i = 0; i <= indexMetadata.getNumberOfReplicas(); i++) {
            if (routingNumberOfReplicas != expectedReplicas && isSearchOnlyClusterBlockEnabled == false) {
                if (shardRouting.assignedToNode()) {
            }
                            if (currentNodeId.equals(excludedNode)) {
        for (int i = 0; i < size; i++) {
            }
                expected.remove(indexShardRoutingTable.shardId().id());
        Builder builder = new Builder(index);
     */
        return builder.build();
    public int hashCode() {
                    PeerRecoverySource.INSTANCE,
        /**
                    );
 * not use this file except in compliance with the License.
                    String currentNodeId = shardRouting.currentNodeId();
            for (final int shardId : shards.keySet()) {
    /**
        public Builder initializeAsRemoteStoreRestore(
            throw new IllegalStateException(index + " exists in routing but does not exist in metadata");
    }
            if (shardRoutingTable.primaryShard().unassigned()) {
                        }
        int count = 0;
        return "IndexRoutingTable{" + "shards=" + shards + ", index=" + index + '}';
    }
        index.writeTo(out);
                        if (shardRouting.unassigned()) {
        return readDiffFrom(IndexRoutingTable::readFrom, in);
                        indexShardRoutingBuilder.addShard(
            // For search-only mode, only initialize search replicas
                                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
    public String prettyPrint() {
            return v;
            }
                        indexShardRoutingBuilder.addShard(
                }
        }
    @Override
        /**
    public int primaryShardsUnassigned() {
        // check index exists
                            break;
            throw new IllegalStateException("Wrong number of shards in routing table, missing: " + expected);
            shards.put(indexShard.shardId().id(), indexShard);
                throw new IllegalStateException("trying to initialize an index with fresh shards, but already has shards created");
        return true;
                        if (shardRouting.unassigned()) {
                    // nothing to do here!
        public Builder addIndexShard(IndexShardRoutingTable indexShard) {
     * @opensearch.api
            return initializeAsRestore(indexMetadata, recoverySource, null, false, unassignedInfo);
                            )
                .append(indexShard.shardId().id())
                    // All the replica shards to be recovered from peer recovery.
            int v = o1.shardId().getIndex().getName().compareTo(o2.shardId().getIndex().getName());
 */
            if (indexShard == null) {
                                + " is a primary that is recovering "
        this.index = index;
            }
     *
                                excluded = true;
    }
        if (indexMetadata.getNumberOfShards() != shards().size()) {
                            } else {
    }
                UnassignedInfo.Reason.EXISTING_INDEX_RESTORED,
        out.writeVInt(shards.size());
import org.opensearch.cluster.metadata.IndexMetadata;
        return primaryShardsUnassigned() == shards.size();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    shardId,
            builder.addIndexShard(IndexShardRoutingTable.Builder.readFromThin(in, index));
    /**
        ) {
        for (IndexShardRoutingTable shardRoutingTable : this) {
        private final Map<Integer, IndexShardRoutingTable> shards = new HashMap<>();
                    );
                            indexShardRoutingBuilder.addShard(
                boolean removed = false;
                        + routingNumberOfReplicas
                        indexShardRoutingBuilder.addShard(
                    throw new IllegalStateException("IndexShardRoutingTable is not present for shardId: " + shardId);
                    indexShardRoutingBuilder.addShard(ShardRouting.newUnassigned(shardId, true, recoverySource, unassignedInfo));
         * if it needs to be created.
                        if (shardRouting.isSearchOnly()) {
        for (IndexShardRoutingTable indexShard : this) {
                if (indexShard.replicaShards().isEmpty()) {
        }
        if (indexMetadata.getIndexUUID().equals(index.getUUID()) == false) {
                    );
                UnassignedInfo.Reason.NEW_INDEX_RESTORED,
                    boolean primary = i == 0;
                        } else {
                    && shardRouting.initializing()
            // Check if search-only mode is enabled
    @Override
                throw new IllegalStateException("trying to initialize an index with fresh shards, but already has shards created");
     * Returns a {@link List} of shards that match the provided {@link Predicate}
 * </p>
            return this;
        public Builder initializeAsFromCloseToOpen(IndexMetadata indexMetadata) {
import org.opensearch.cluster.metadata.Metadata;
                    + recoverySource.snapshot().getRepository()
                counter++;
 * index. The routing table maintains a list of all shards in the index. A
            assert indexMetadata.getIndex().equals(index);
                                indexShardRoutingBuilder.addShard(
            );
import java.util.List;
     */
        }
        /**
            if (v == 0) {
import java.util.Map;
         */
            count += shardRoutingTable.shardsMatchingPredicateCount(predicate);
                                false,
    }
        private Builder initializeEmpty(IndexMetadata indexMetadata, UnassignedInfo unassignedInfo) {
            final Set<Integer> ignoreShards,
                                unassignedInfo
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED, null));
                                unassignedInfo
    }
            if (!shards.isEmpty()) {
                                unassignedInfo
                    && inSyncAllocationIds.contains(shardRouting.allocationId().getId()) == false
                shards.put(shardNumber, new IndexShardRoutingTable.Builder(shards.get(shard.id())).addShard(shard).build());
            ordered.add(indexShard);
                }
                }
            if (!shards.isEmpty()) {
                    throw new IllegalStateException(
                "restore_source["
 *     http://www.apache.org/licenses/LICENSE-2.0
                    // Add only search replicas
    public static Builder builder(Index index) {
            for (ShardRouting shardRouting : shardRoutingTable) {
            }
        StringBuilder sb = new StringBuilder("-- index [" + index + "]\n");
                        );
    // note, we assume that when the index routing is created, ShardRoutings are created for all possible number of
        }
                    + "]"
                    } else {
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
                }
        }
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null));
 * software distributed under the License is distributed on an
            }
                if (indexMetadata.inSyncAllocationIds(shardNumber).isEmpty() == false) {
                shards.put(shardNumber, indexShardRoutingBuilder.build());
                        }
            }
                // first check if there is one that is not assigned to a node, and remove it
            if (shards.isEmpty() == false) {
                        }
            final UnassignedInfo unassignedInfo = new UnassignedInfo(
         */
                    // Replica, if unassigned, trigger peer recovery else no action.
        }
        for (IndexShardRoutingTable shardRoutingTable : this) {
                                primary,
                    }
 * represented as {@link ShardRouting}.
                }
                ShardRouting shard = ShardRouting.newUnassigned(
        public Builder removeReplica() {
                .append(indexShard.shardId().getIndex().getName())
                    }
                if (indexShardRoutingTable.searchOnlyReplicas().isEmpty()) {
    }
        }
                            + inSyncAllocationIds
import org.apache.lucene.util.CollectionUtil;
        int size = in.readVInt();
        for (IndexShardRoutingTable shardRoutingTable : this) {
    }
                if (forceRecoverAllPrimaries || indexShardRoutingTable.primaryShard().unassigned()) {
                }
        VerifiableWriteable {
            }
    }
     */
                        + indexMetadata.getNumberOfReplicas()
         * @return The Builder
 */
    }
                return this;
    /**
                }
                        builder.removeShard(shardRouting);
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.INDEX_REOPENED, null));
                    shards.put(shardNumber, indexShardRoutingBuilder.build());
        for (IndexShardRoutingTable shardRoutingTable : this) {
                                    + inSyncAllocationIds
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                        removed = true;
import java.util.Collections;
                        builder.removeShard(shardRouting);
     */
                    IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                .append("]\n");
        }
                }
import java.util.Set;
                        )
    public static Diff<IndexRoutingTable> readDiffFrom(StreamInput in) throws IOException {
    }
import org.opensearch.cluster.Diff;
                // version 0, will get updated when reroute will happen
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
                v = Integer.compare(o1.shardId().id(), o2.shardId().id());
     *
import org.opensearch.core.common.io.stream.StreamOutput;
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        public Builder initializeAsFromOpenToClose(IndexMetadata indexMetadata) {
        return new PlainShardsIterator(shuffler.shuffle(allActiveShards));
     * @param predicate {@link Predicate} to apply
                    if (!shardRouting.primary() && !shardRouting.assignedToNode() && !shardRouting.isSearchOnly()) {
    public Map<Integer, IndexShardRoutingTable> getShards() {
    private final Map<Integer, IndexShardRoutingTable> shards;
                shards.put(shardId, builder.build());
 */
        }
import org.opensearch.common.Randomness;
            final UnassignedInfo unassignedInfo = new UnassignedInfo(
 * specific language governing permissions and limitations
    }
        return primaryShardsActive() == shards().size();
        /**
                }
     *
                    }
                            + "allocation set "
                if (shardRouting.active()) {
    public Iterator<IndexShardRoutingTable> iterator() {
                    for (ShardRouting shardRouting : indexShardRoutingTable) {
    IndexRoutingTable(Index index, final Map<Integer, IndexShardRoutingTable> shards) {
                            ShardRouting.newUnassigned(
                indexShard = new IndexShardRoutingTable.Builder(shard.shardId()).addShard(shard).build();
                    if (inSyncAllocationIds.contains(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)) {
            throw new IllegalStateException(index.getName() + " exists in routing but does not exist in metadata with the same uuid");
 * Note: The term replica is not directly
                } else {
         * Initializes an existing index, to be restored from remote store
            }
import org.opensearch.common.annotation.PublicApi;
                    // if writers are red we do not want to re-recover search only shards if already assigned.
 *
import org.opensearch.core.common.io.stream.VerifiableWriteable;
            Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap,
        /**
                    + recoverySource.snapshot().getSnapshotId().getName()
            for (ShardRouting shard : indexShard) {
                                shardId,
         */
            sb.append("----shard_id [")
                    && shardRouting.isSearchOnly() == false) {
                .append("][")
                // re-add all the current ones
        public Builder removeSearchReplica() {
import org.opensearch.core.index.Index;
 * can be seen as the "leader" of the shard acting as the primary entry point
                // first check if there is one that is not assigned to a node, and remove it
        return index;
        }
                for (ShardRouting shardRouting : indexShard) {
        }
                }
        private final Index index;
                                ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
        private Builder initializeAsRestore(
                );
         * Remove a Search only replica from the IndexShardRoutingTable
        }
     * Calculates the number of primary shards in the routing table the are in
                                    + "from a stale primary but has unexpected allocation ids in the in-sync set "
                }
                    primaryRecoverySource = EmptyStoreRecoverySource.INSTANCE;
import org.opensearch.core.index.shard.ShardId;
        public Builder initializeAsFromDangling(IndexMetadata indexMetadata) {
            IndexMetadata indexMetadata,
import java.util.ArrayList;
                    indexShardRoutingBuilder.addShard(
                "restore_source["
        if (!metadata.hasIndex(index.getName())) {
                                shardId,
            return initializeAsRestore(indexMetadata, recoverySource, ignoreShards, true, unassignedInfo);
        return shards.get(shardId);
        }
                    for (int replicaNumber = 0; replicaNumber < indexMetadata.getNumberOfReplicas(); replicaNumber++) {
 * ownership. Elasticsearch licenses this file to you under
                    builder.addShard(shardRouting);
            for (ShardRouting shardRouting : indexShardRoutingTable) {
                    );
        }
        out.writeMapValues(shards, (stream, value) -> IndexShardRoutingTable.Builder.writeVerifiableTo(value, stream));
        ) {
        }
         */
            final Set<Integer> ignoreShards
}
 * compatible open source license.
            for (IndexShardRoutingTable indexShardRoutingTable : this) {
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;
/*
import org.opensearch.cluster.routing.RecoverySource.RemoteStoreRecoverySource;
                            indexShardRoutingBuilder.addShard(shardRouting);
                        + "]"
        Set<String> nodes = new HashSet<>();
                        + indexMetadata.getNumberOfSearchOnlyReplicas()
                    }
import org.opensearch.cluster.AbstractDiffable;
     * Builder of a routing table.
     * Returns <code>true</code> if all primary shards are in
                throw new IllegalStateException(
    public boolean allPrimaryShardsUnassigned() {
public class IndexRoutingTable extends AbstractDiffable<IndexRoutingTable>
     * @return number of distinct nodes this index has at least one shard allocated on
                        + "], got ["
            for (final int shardId : shards.keySet()) {
                            ShardRouting.newUnassigned(
        }
 * for operations on a specific shard.
        });
                    );
 * The OpenSearch Contributors require contributions made to
    /**
        }
                        );
                                + "from a known allocation id but has no corresponding entry in the in-sync set "
                    + "]"
    public static IndexRoutingTable readFrom(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
            for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
                    new UnassignedInfo(UnassignedInfo.Reason.REPLICA_ADDED, null)
                ShardId shardId = new ShardId(index, shardNumber);
                if (shardRouting.active()
                        removed = true;
            this.index = index;
            }
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
    public String toString() {
                    false,
            }
        }
                        "shard routing has an index [" + shardRouting.index() + "] that is different from the routing table"
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
         */
                IndexShardRoutingTable indexShardRoutingTable = shards.get(shardId);
         * Initializes a new empty index, as as a result of closing an opened index.
 * this file be licensed under the Apache-2.0 license or a
    public int shardsMatchingPredicateCount(Predicate<ShardRouting> predicate) {
                expected.add(i);
 * Unless required by applicable law or agreed to in writing,
        this.shuffler = new RotationShardShuffler(Randomness.get().nextInt());
            .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
            }
                    primaryRecoverySource = LocalShardsRecoverySource.INSTANCE;
                        }
                    }
            }
        return counter;
        public Builder initializeAsNew(IndexMetadata indexMetadata) {
        public Builder initializeAsRestore(IndexMetadata indexMetadata, SnapshotRecoverySource recoverySource) {
                            shardId,
                    + "/"
            IndexMetadata indexMetadata,
        public Builder addSearchReplica() {
        List<ShardRouting> allActiveShards = new ArrayList<>();
                    boolean primary = i == 0;
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
 * The {@link IndexRoutingTable} represents routing information for a single
                if (indexShardRoutingTableMap.containsKey(shardId) == false) {
    @Override
    implements
            for (ShardRouting shardRouting : cursor) {
            assert indexMetadata.getIndex().equals(index);
 */
            shards.addAll(shardRoutingTable.shardsWithState(state));
                    primaryRecoverySource = ExistingStoreRecoverySource.INSTANCE;
    public Map<Integer, IndexShardRoutingTable> shards() {
     */
    }
        public IndexRoutingTable build() {
        /**
    private final Index index;
                    boolean excluded = false;
        }
    public List<ShardRouting> shardsWithState(ShardRoutingState state) {
            for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
                }
                final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(shardRouting.id());
                    }
            UnassignedInfo unassignedInfo
    }
    }
                }
    @PublicApi(since = "1.0.0")
                                true,
    }
                    return this;
     * @return a {@link List} of shards that match one of the given {@link Predicate}
                    new UnassignedInfo(UnassignedInfo.Reason.REPLICA_ADDED, null)
    public IndexShardRoutingTable shard(int shardId) {
    public static class Builder {
            }
                        ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
            } else {
     * Calculates the number of primary shards in active state in routing table
                    + "/"
            boolean isSearchOnly = indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
        }
    }
 * reflected in the routing table or in related classes, replicas are
     * {@link ShardRoutingState#UNASSIGNED} state. Otherwise <code>false</code>.
                        }
                        // This shards wasn't completely snapshotted - restore it as new shard
                        indexShardRoutingBuilder.addShard(
        CollectionUtil.timSort(ordered, (o1, o2) -> {
         */
     * Calculates the number of nodes that hold one or more shards of this index
                );
        }
                        "active shard routing "
                        break;
                // re-add all the current ones
     * {@link IndexRoutingTable} excluding the nodes with the node ids give as
                        + indexShardRoutingTable.shardId().id()
                            }
         * Initializes a new empty index, as as a result of opening a closed index.
 * single shard in this context has one more instances namely exactly one
     */
                            builder.removeShard(shardRouting);
                    EmptyStoreRecoverySource.INSTANCE,
            return this;
     * the <code>excludedNodes</code> parameter.
                    builder.addShard(shardRouting);
        ) {
     * Returns an unordered iterator over all active shards (including replicas).
            }
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        for (IndexShardRoutingTable indexShard : ordered) {
        // check the number of shards
                counter++;
                                primary ? recoverySource : PeerRecoverySource.INSTANCE,
        }
        List<IndexShardRoutingTable> ordered = new ArrayList<>();
         * Initializes an index, to be restored from snapshot
         */
import org.opensearch.cluster.routing.RecoverySource.EmptyStoreRecoverySource;
        /**
                if (!shardRouting.index().equals(index)) {
        }
            }
    public int primaryShardsActive() {
        for (IndexShardRoutingTable cursor : shards.values()) {
        for (IndexShardRoutingTable indexShard : this) {
                    ShardId shardId = new ShardId(index, shardNumber);
        return true;
         */
                                "a primary shard routing "
                for (int i = 0; i < indexMetadata.getNumberOfSearchOnlyReplicas(); i++) {
        boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
                for (int i = 0; i <= indexMetadata.getNumberOfReplicas(); i++) {
 * Licensed to Elasticsearch under one or more contributor
        }
                }
                                + inSyncAllocationIds
         * Adds a new shard routing (makes a copy of it), with reference data used from the index shard routing table
        public Builder initializeAsNewRestore(
         * Initializes an existing index.
            return this;
                ShardId shardId = new ShardId(index, shardNumber);
         * Initializes a new empty index, with an option to control if its from an API or not.
        public Builder initializeAsRecovery(IndexMetadata indexMetadata) {
 * GitHub history for details.
                        nodes.add(currentNodeId);
    /**
        this.shards = Collections.unmodifiableMap(shards);
        return shards.values().iterator();
            for (final int shardNumber : shards.keySet()) {
         * Initializes a new empty index, to be restored from a snapshot
         * Initializes an existing index, to be restored from a snapshot
                            "a primary shard routing "
                }
     *
        for (IndexShardRoutingTable indexShardRoutingTable : this) {
        int counter = 0;
                            }
    }
                    // nothing to do here!
            SnapshotRecoverySource recoverySource,
                for (ShardRouting shardRouting : indexShard) {
                                indexShardRoutingBuilder.addShard(
     * @return number of active primary shards
        IndexRoutingTable that = (IndexRoutingTable) o;
                                    + " is a primary that is recovering "
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        return counter;
    public void writeTo(StreamOutput out) throws IOException {
        }
            Set<Integer> expected = new HashSet<>();
                IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingTableMap.get(shardId);
import java.io.IOException;
                ShardId shardId = new ShardId(index, shardNumber);
                    // Primary is either active or initializing. Do not trigger restore.
                        );
     */
            for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
/*
            return this;
                for (int i = 0; i < indexMetadata.getNumberOfSearchOnlyReplicas(); i++) {
        return shards;
        return sb.toString();
                        if (inSyncAllocationIds.size() != 1) {
        return count;
                if (!removed) {
            boolean asNew,
                    // this is a new index but the initial shards should merged from another index
                IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(indexShard.shardId());
                        + "Replicas: "
                    for (ShardRouting shardRouting : indexShardRoutingTable.replicaShards()) {
    }
                shards.put(shardNumber, new IndexShardRoutingTable.Builder(shards.get(shard.id())).addShard(shard).build());
        return result;
     * Return the index id
                    "Shard ["
import java.util.HashMap;
        public Builder(Index index) {
 * replica per shard is a {@code primary} replica. The {@code primary} replica
import org.opensearch.core.common.io.stream.StreamInput;
         */
 *
     * @param excludedNodes id of nodes that will be excluded
        /**
                                );
            shards.addAll(shardRoutingTable.shardsMatchingPredicate(predicate));
 * You may obtain a copy of the License at
            if (shardRoutingTable.primaryShard() != null && shardRoutingTable.primaryShard().active()) {
                        + ", Search Replicas: "
    }
                        }
            IndexShardRoutingTable.Builder.writeToThin(indexShard, out);
                    indexShardRoutingBuilder.addShard(
     * @param state {@link ShardRoutingState} to retrieve
import java.util.HashSet;
                    if (!excluded) {
package org.opensearch.cluster.routing;
                    // a freshly created index with no restriction
                                );
                    indexShardRoutingBuilder.addShard(
                            ShardRouting.newUnassigned(shardId, false, PeerRecoverySource.INSTANCE, unassignedInfo)
        if (o == null || getClass() != o.getClass()) return false;
            }
            int routingNumberOfReplicas = indexShardRoutingTable.size() - 1;
        }
                indexShard = new IndexShardRoutingTable.Builder(indexShard).addShard(shard).build();
            return this;
                    }
                        ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
    }
        }
            RecoverySource recoverySource,
                }
        public Builder addReplica() {
         * Initializes a new empty index, with an option to control if its from an API or not.
                    if (asNew && ignoreShards.contains(shardNumber)) {
            );
                final RecoverySource primaryRecoverySource;
                    return this;
                                shardId,
                    true,
                    throw new IllegalStateException(
         */
                        );
                IndexShardRoutingTable indexShard = shards.get(shardId);
                        if (!shardRouting.primary() && !shardRouting.isSearchOnly()) {
        /**
                            + " has no corresponding entry in the in-sync "
            for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
 * {@link ShardRouting#primary() primary} and 1 or more replicas. In other
                            )
        public Builder addShard(ShardRouting shard) {
                sb.append("--------").append(shard.shortSummary()).append("\n");
        /**
/*
                    && shardRouting.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE) {
        List<ShardRouting> shards = new ArrayList<>();
        /**
                }
    /**
            // Only throw if we are NOT in search-only mode. Otherwise, we ignore or log the mismatch.
                                + shardRouting
                    }
     * @return id of the index
    private final List<ShardRouting> allActiveShards;
                ShardId shardId = new ShardId(index, shardNumber);
         */
                        + "] routing table has wrong number of replicas, expected ["
 * license agreements. See the NOTICE file distributed with
                            + shardRouting
                "restore_source[remote_store]"
         */
            return this;
                    false,
                    + recoverySource.snapshot().getRepository()
                        for (String excludedNode : excludedNodes) {
                // version 0, will get updated when reroute will happen
                }
                shards.put(shardNumber, indexShardRoutingBuilder.build());
        int counter = 0;
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.INDEX_CLOSED, null));
     *
            shards.put(indexShard.shardId().id(), indexShard);
            return this;
            );
@PublicApi(since = "1.0.0")
    public boolean allPrimaryShardsActive() {
    }
         */
                UnassignedInfo.Reason.EXISTING_INDEX_RESTORED,
                    if (excludedNodes != null) {
        Index index = new Index(in);
                for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
            return new IndexRoutingTable(index, shards);
                            ShardRouting.newUnassigned(
                boolean removed = false;
 * under the License.
 * <p>
                            )
 * words, each instance of a shard is considered a replica while only one
            }
        if (this == o) return true;
        }
        }
            }
 * KIND, either express or implied.  See the License for the
                        } else {
                );
        if (!index.equals(that.index)) return false;
    public int numberOfNodesShardsAreAllocatedOn(String... excludedNodes) {
                    shardId,
                    }
                    // Primary shard to be recovered from remote store.
    boolean validate(Metadata metadata) {
                    for (ShardRouting shardRouting : indexShardRoutingTable.searchOnlyReplicas()) {
                shards.put(shardNumber, indexShardRoutingBuilder.build());
                    + recoverySource.snapshot().getSnapshotId().getName()
                            primary,
