    }
    public IndexRoutingTable index(Index index) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            shards.addAll(indexRoutingTable.shardsWithState(state));
         * must be thrown away. If you need to build a new RoutingTable as a
 * specific language governing permissions and limitations
            }
    }
                throw new IndexNotFoundException(index);
            return this;
     * Get's the {@link IndexShardRoutingTable} for the given shard id from the given {@link IndexRoutingTable}
        }
        IndexRoutingTable indexRouting = index(index.getName());
                shards.add(shardRouting);
                    indexMetadata
     *
            if (indexRoutingTable == null) {
 */
        }
                indicesRouting.put(indexRoutingTable.getIndex().getName(), indexRoutingTable);
 *
            final ShardRouting shardRoutingEntry
        @Override
            this.version = version;
                    // now, add "empty" ones
    public boolean hasIndex(Index index) {
    }
     * @throws IndexNotFoundException If the index passed does not exists
        return shardRoutingTable(indexRouting, shardId);
     * @param indices The indices to return all the shards (replicas)
 * not use this file except in compliance with the License.
            this.version = version;
            IndexRoutingTable indexRoutingTable = index(index);
            }
     * @param indexRouting IndexRoutingTable
import org.opensearch.index.IndexNotFoundException;
                    for (int i = 0; i < (numberOfReplicas - currentNumberOfReplicas); i++) {
import java.util.Set;
import java.util.ArrayList;
        return shards;
        return true;
    @Nullable
        }
    public Map<String, IndexRoutingTable> indicesRouting() {
                        set.add(new PlainShardIterator(shardRouting.shardId(), Collections.emptyList()));
        }
}
            if (indexRoutingTable == null) {
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsNewRestore(
                if (indexRoutingTable == null) {
     * @return All the shards matching the specific index
     *
                IndexShardRoutingTable shardRoutings = indexRoutingTable.shards().get(0);
        // use list here since we need to maintain identity across shards
     *
            count += indexRoutingTable.shardsMatchingPredicateCount(predicate);
        for (String index : indices) {
        Predicate<ShardRouting> predicate
                    continue;
                indexMetadata,
                    // ignore index missing failure, its closed...
    }
                IndexRoutingTable indexRoutingTable = indicesRouting.get(index);
    public IndexShardRoutingTable shardRoutingTable(String index, int shardId) {
        return indicesRouting.get(index.getName());
    public static IndexShardRoutingTable shardRoutingTable(IndexRoutingTable indexRouting, int shardId) {
    public List<ShardRouting> shardsWithState(ShardRoutingState state) {
            return this;
    public Map<String, IndexRoutingTable> getIndicesRouting() {
    }
    }
    public ShardRouting getByAllocationId(ShardId shardId, String allocationId) {
         *
import org.opensearch.core.common.io.stream.StreamOutput;
        public Builder add(IndexRoutingTable.Builder indexRoutingTableBuilder) {
        for (IndexRoutingTable indexRoutingTable : this) {
         * @param indices          the indices to update the number of replicas for
                }
     * Return GroupShardsIterator where each assigned shard routing has it's own shard iterator.
                indexBuilder = new IndexRoutingTable.Builder(index);
            indicesRouting.put(indexRoutingTable.getIndex().getName(), indexRoutingTable);
        String[] indices,
                throw new IllegalStateException("once build is called the builder cannot be reused");
                if (currentNumberOfReplicas < numberOfReplicas) {
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
    private static Predicate<ShardRouting> ACTIVE_PREDICATE = ShardRouting::active;
                // re-add all the shards
            for (String index : indices) {
    /**
         */
                ignoreShards
    }
    /**
        return indexRouting != null && indexRouting.getIndex().equals(index);
        for (int i = 0; i < size; i++) {
            return this;
    }
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                    // ignore index missing failure, its closed...
            version = routingTable.version;
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
    }
        IndexRoutingTable indexRouting = index(shardId.getIndexName());
        public Builder addAsNew(IndexMetadata indexMetadata) {
            }
            }
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
    public boolean hasIndex(String index) {
            return add(indexRoutingBuilder);
    }
        Builder builder = new Builder();
     * All the shards (replicas) for all indices in this routing table.
 * software distributed under the License is distributed on an
import java.util.List;
    }
        public Builder updateNumberOfReplicas(final int numberOfReplicas, final String[] indices) {
                .initializeAsRemoteStoreRestore(indexMetadata, recoverySource, indexShardRoutingTableMap, forceRecoveryPrimary);
            final Set<Integer> ignoreShards
        // use list here since we need to maintain identity across shards
            if (indexBuilder == null) {
            }
        return new PlainShardsIterator(shards);
            Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap,
            sb.append(entry.prettyPrint()).append('\n');
    }
        public Builder addAsRestore(IndexMetadata indexMetadata, SnapshotRecoverySource recoverySource) {
            return new RoutingTable(version, indicesRouting.apply(part.indicesRouting));
        if (indexRouting == null) {
            IndexRoutingTable indexRoutingTable = index(index);
        return new RoutingTableDiff(in);
            return this;
        public Builder add(IndexRoutingTable indexRoutingTable) {
            if (indexMetadata.getState() == IndexMetadata.State.OPEN) {
            return null;
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            }
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsNew(
        RoutingTableDiff(RoutingTable before, RoutingTable after) {
                        shards.add(shardRouting);
            assert isIndexVerifiedBeforeClosed(indexMetadata);
     * @return All the shard routing entries for the given index and shard id
     * @return All the shards
        }
                for (ShardRouting shardRoutingEntry : routingNode) {
        ) {
    /**
 * GitHub history for details.
        }
        @Override
            // this is being called without pre initializing the routing table, so we must copy over the version as well
            return this;
     * All the shards for the provided indices on the node which match the predicate
        builder.version = in.readLong();
            throw new ShardNotFoundException(new ShardId(indexRouting.getIndex(), shardId));
 * You may obtain a copy of the License at
    public IndexRoutingTable index(String index) {
import org.opensearch.cluster.metadata.Metadata;
        }
                recoverySource
            return this;
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
            for (ShardRouting shardRoutingEntry : shardRoutingEntries) {
            add(indexRoutingBuilder);
                        builder.addReplica();
    /**
@PublicApi(since = "1.0.0")
 * @opensearch.api
     * cases to iterate over all primary shards (and not just one shard in replication group).
                }
        return sb.toString();
        public Builder addAsNewRestore(
    public int shardsMatchingPredicateCount(Predicate<ShardRouting> predicate) {
import org.opensearch.cluster.DiffableUtils;
     * @throws IndexNotFoundException if provided index does not exist
                        builder.removeSearchReplica();
        for (final IndexRoutingTable index : indicesRouting.values()) {
    public static class Builder {
        RoutingTableDiff(StreamInput in) throws IOException {
        return GroupShardsIterator.sortAndCreate(set);
                        if (includeRelocationTargets && shardRouting.relocating()) {
    public GroupShardsIterator<ShardIterator> allActiveShardsGrouped(String[] indices, boolean includeEmpty) {
                    set.add(primary.shardsIt());
        public Builder(RoutingTable routingTable) {
        IndexRoutingTable indexRouting = index(index);
        }
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
/**
                    .initializeAsFromCloseToOpen(indexMetadata);
        }
import org.opensearch.common.Nullable;
         * Builds the routing table. Note that once this is called the builder
 * version of the current routing state.
    }
        }
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        StringBuilder sb = new StringBuilder("routing_table (version ").append(version).append("):\n");
    public String toString() {
        /**
                add(indexRoutingBuilder);
        public Builder addAsFromOpenToClose(IndexMetadata indexMetadata) {
        String[] indices = indicesRouting.keySet().toArray(new String[0]);
     * @throws ShardNotFoundException if provided shard id is unknown
        return new RoutingTableDiff(previousState, this);
            }
        List<ShardRouting> shards = new ArrayList<>();
        for (IndexRoutingTable indexRoutingTable : this) {
    @Override
            builder.add(index);
                IndexRoutingTable.Builder builder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
    }
                }
     */
        ArrayList<ShardIterator> set = new ArrayList<>();
        }
    }
            }
    public List<ShardRouting> allShards() {
        return shardRoutingTable == null ? null : shardRoutingTable.getByAllocationId(allocationId);
                    for (int i = 0; i < (currentNumberOfReplicas - numberOfReplicas); i++) {
            Map<String, IndexRoutingTable.Builder> indexRoutingTableBuilders = new HashMap<>();
            add(indexRoutingBuilder);
    @PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to
        public void writeTo(StreamOutput out) throws IOException {
                // we simply ignore indices that don't exists (make sense for operations that use it currently)
                    // now, add "empty" ones
        return GroupShardsIterator.sortAndCreate(set);
import org.opensearch.common.annotation.PublicApi;
    }
import org.opensearch.core.common.io.stream.StreamInput;
     */
        private final Diff<Map<String, IndexRoutingTable>> indicesRouting;
                        set.add(shardRouting.shardsIt());
 *
    }
        }
        private static void addShard(
         * @return the builder
import org.opensearch.cluster.metadata.IndexMetadata;
            if (indexRoutingTable == null) {
        // use list here since we need to maintain identity across shards
                throw new IllegalStateException("once build is called the builder cannot be reused");
     * @return All the primary shards grouped into a single shard element group each
        public Builder addAsRemoteStoreRestore(
     *
    public GroupShardsIterator<ShardIterator> activePrimaryShardsGrouped(String[] indices, boolean includeEmpty) {
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
        IndexRoutingTable indexRoutingTable = index(index);
            return this;
import java.util.function.Predicate;
     */
            version = after.version;
     */
        return allSatisfyingPredicateShardsGrouped(indices, includeEmpty, ASSIGNED_PREDICATE);
    @Override
import java.util.HashMap;
                }
        public Builder version(long version) {
         * @return the builder
 */
                    if (predicate.test(shardRouting)) {
                }
            final Map<String, IndexRoutingTable.Builder> indexRoutingTableBuilders,
        return new Builder(routingTable);
        }
            }
    /**
            }
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsRestore(
            IndexRoutingTable indexRoutingTable = index(index);
        for (IndexRoutingTable indexRoutingTable : this) {
         */
        public Builder remove(String index) {
            if (indicesRouting == null) {
     * All the shards (replicas) for the provided index.
        public Builder addAsFromDangling(IndexMetadata indexMetadata) {
            }
    }
        }
                    }
        out.writeMapValues(indicesRouting, (stream, value) -> value.writeVerifiableTo((BufferedChecksumStreamOutput) stream));
 *
     * @param includeEmpty if true, a shard iterator will be added for non-assigned shards as well
        return count;
        }
    @Override
     * @throws IndexNotFoundException if provided index does not exist
        return indicesRouting();
                .initializeAsFromOpenToClose(indexMetadata);
    public Diff<RoutingTable> diff(RoutingTable previousState) {
            }
        @Override
import java.util.Map;
            add(indexRoutingTableBuilder.build());
        List<ShardRouting> shards = new ArrayList<>();
            );
        if (indexShard == null) {
 * Unless required by applicable law or agreed to in writing,
            return table;
                // we simply ignore indices that don't exists (make sense for operations that use it currently)
            if (indicesRouting == null) {
            return "RoutingTableDiff{" + "version=" + version + ", indicesRouting=" + indicesRouting + '}';
        String[] indices,
     * of the primary shard). This is handy for components that expect to get group iterators, but still want in some
    }
                if (indexRoutingTable == null) {
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        }
        for (String index : indices) {
/*
    public ShardsIterator allShards(String[] indices) {
            return this;
            if (indicesRouting == null) {
        ArrayList<ShardIterator> set = new ArrayList<>();
    /**
        for (final IndexRoutingTable entry : indicesRouting.values()) {
 * Represents a global cluster-wide routing table for all indices including the
     * All shards for the provided {@link ShardId}
        return allShardsSatisfyingPredicate(indices, predicate, false);
    public static RoutingTable readFrom(StreamInput in) throws IOException {
        }
    private static class RoutingTableDiff implements Diff<RoutingTable>, StringKeyDiffProvider<IndexRoutingTable> {
     * @param includeEmpty             if true, a shard iterator will be added for non-assigned shards as well
            IndexMetadata indexMetadata,
        out.writeVInt(indicesRouting.size());
                // re-add all the shards
            Iterable<ShardRouting> shardRoutingEntries = Iterables.concat(routingNodes.unassigned(), routingNodes.unassigned().ignored());
                    // every relocating shard has a double entry, ignore the target one.
                add(indexRoutingBuilder);
        final IndexShardRoutingTable shardRoutingTable = indexRoutingTable.shard(shardId.getId());
            }
            );
            }
import org.opensearch.common.util.iterable.Iterables;
        return this.version;
            return this;
    }
     * @param shardId ShardId
            for (IndexRoutingTable.Builder indexBuilder : indexRoutingTableBuilders.values()) {
import org.opensearch.cluster.Diff;
    public Iterator<IndexRoutingTable> iterator() {
    @Override
                continue;
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        int size = in.readVInt();
        ) {
                if (primary.active()) {
        out.writeLong(version);
        ) {
                throw new IllegalStateException("once build is called the builder cannot be reused");
        }
            new DiffableUtils.DiffableValueReader<>(IndexRoutingTable::readFrom, IndexRoutingTable::readDiffFrom);
    }
                        }
                } else if (includeEmpty) { // we need this for counting properly, just make it an empty one
        return new RoutingTableIncrementalDiff(previousState, this);
            for (RoutingNode routingNode : routingNodes) {
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
     * @throws IndexNotFoundException If an index passed does not exists
        }
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
     */
            throw new ShardNotFoundException(shardId);
     *
                addShard(indexRoutingTableBuilders, shardRoutingEntry);
        }
     */
        for (String index : indices) {
        return indicesRouting;
        }
        }
                    for (int i = 0; i < (numberOfSearchReplicas - currentNumberOfSearchReplicas); i++) {
     *
        out.writeLong(version);
     * @param index The index to return all the shards (replicas).
            if (indicesRouting == null) {
        Predicate<ShardRouting> predicate,
            return this;
 * KIND, either express or implied.  See the License for the
            return this;
        final IndexRoutingTable indexRoutingTable = index(shardId.getIndexName());
    /**
    @Override
     * @return IndexShardRoutingTable
            return this;
        private long version;
import org.opensearch.cluster.routing.RecoverySource.RemoteStoreRecoverySource;
            for (String index : indices) {
     */
            indicesRouting = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), DIFF_VALUE_READER);
                recoverySource,
    /**
    }
 * the Apache License, Version 2.0 (the "License"); you may
        /**
                    } else if (includeEmpty) { // we need this for counting properly, just make it an empty one
            return this;
     * @return All the shard routing entries for the given index and shard id
                } else if (currentNumberOfSearchReplicas > numberOfSearchReplicas) {
        }
            }
    ) {
            }
     *
        }
                    }
 * compatible open source license.
 */
     * @opensearch.api
    // index to IndexRoutingTable map
                    }
        }
            IndexRoutingTable.Builder indexBuilder = indexRoutingTableBuilders.get(index.getName());
            }
            throw new IndexNotFoundException(index);
        return shard;
                if (currentNumberOfSearchReplicas < numberOfSearchReplicas) {
     * @param predicate condition to match
        boolean includeRelocationTargets
     * or throws a {@link ShardNotFoundException} if no shard by the given id is found in the IndexRoutingTable.
    /**
        private static final DiffableUtils.DiffableValueReader<String, IndexRoutingTable> DIFF_VALUE_READER =
        if (shard == null) {
    private final Map<String, IndexRoutingTable> indicesRouting;
/*
        }
                int currentNumberOfReplicas = indexRoutingTable.shards().get(0).writerReplicas().size();
     * @param predicate condition to match
import org.opensearch.core.index.shard.ShardId;
    }
    /**
        }
        }
            }
            IndexRoutingTable index = IndexRoutingTable.readFrom(in);
        return allShardsSatisfyingPredicate(indices, predicate, false);
                for (ShardRouting shardRouting : indexShardRoutingTable) {
        }
        }
            throw new IndexNotFoundException(index);
        public Builder() {
    public static final RoutingTable EMPTY_ROUTING_TABLE = builder().build();
     */
    public void writeTo(StreamOutput out) throws IOException {
        return allShardsSatisfyingPredicate(indices, shardRouting -> true, false);
                }
    public List<ShardRouting> allShards(String index) {
    private final long version;
        }
    public GroupShardsIterator<ShardIterator> allAssignedShardsGrouped(String[] indices, boolean includeEmpty) {
     * @throws ShardNotFoundException if provided shard id is unknown
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        if (indexRouting == null || indexRouting.getIndex().equals(shardId.getIndex()) == false) {
                    if (shardRoutingEntry.initializing() && shardRoutingEntry.relocatingNodeId() != null) continue;
     * @return iterator over shards matching the predicate for the specific indices
                    if (predicate.test(shardRouting)) {
                indexMetadata,
                throw new IllegalStateException("once build is called the builder cannot be reused");
                    builder.addIndexShard(indexShardRoutingTable);
import java.util.Collections;
     * Builder for the routing table. Note that build can only be called one time.
    public static Diff<RoutingTable> readDiffFrom(StreamInput in) throws IOException {
        return shards;
            indexBuilder.addShard(shardRoutingEntry);
    }
                indexRoutingTableBuilders.put(index.getName(), indexBuilder);
     */
    public ShardsIterator allShardsSatisfyingPredicate(Predicate<ShardRouting> predicate) {
        return indicesRouting.values().iterator();
        this.version = version;
        }
     * @return version of the {@link RoutingTable}
 * license agreements. See the NOTICE file distributed with
            out.writeLong(version);
        return allShardsSatisfyingPredicate(indices, shardRouting -> true, true);
import org.opensearch.core.common.io.stream.VerifiableWriteable;
     * All shards for the provided index and shard id
import java.util.Iterator;
        }
/*
                    continue;
    }
        return builder.build();
        }
 *
            indicesRouting = DiffableUtils.diff(before.indicesRouting, after.indicesRouting, DiffableUtils.getStringKeySerializer());
            indicesRouting = null;
            indicesRouting.remove(index);
                IndexRoutingTable indexRoutingTable = indicesRouting.get(index);
     * Return GroupShardsIterator where each active shard routing has it's own shard iterator.
                ShardRouting primary = indexShardRoutingTable.primaryShard();
    }
    public static Builder builder() {
 * @see IndexRoutingTable
        public DiffableUtils.MapDiff<String, IndexRoutingTable, Map<String, IndexRoutingTable>> provideDiff() {
            if (indexRoutingTable.validate(metadata) == false) {
                    for (int i = 0; i < (currentNumberOfSearchReplicas - numberOfSearchReplicas); i++) {
         * copy of this one you'll need to build a new RoutingTable.Builder.
                        builder.addSearchReplica();
    }
    }
                int currentNumberOfSearchReplicas = shardRoutings.searchOnlyReplicas().size();
                );
     * Returns the version of the {@link RoutingTable}.
            version = in.readLong();
        }
         * @param numberOfSearchReplicas the number of replicas
    }
         * Update the number of replicas for the specified indices.
                    }
        return indicesRouting.get(index);
    }
            }
 * under the License.
    public static Builder builder(RoutingTable routingTable) {
 *
        IndexShardRoutingTable shard = indexRouting.shard(shardId.id());
    private GroupShardsIterator<ShardIterator> allSatisfyingPredicateShardsGrouped(
    private static Predicate<ShardRouting> ASSIGNED_PREDICATE = ShardRouting::assignedToNode;
package org.opensearch.cluster.routing;
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;
            }
                indicesRouting.put(index, builder.build());
            return (DiffableUtils.MapDiff<String, IndexRoutingTable, Map<String, IndexRoutingTable>>) indicesRouting;
         * Update the number of search replicas for the specified indices.
import org.opensearch.cluster.Diffable;
        this.indicesRouting = Collections.unmodifiableMap(indicesRouting);
        return indicesRouting.containsKey(index);
     * @param indices indices to return all the shards.
                throw new IllegalStateException("once build is called the builder cannot be reused");
        }
 * this work for additional information regarding copyright
         *
    public IndexShardRoutingTable shardRoutingTable(ShardId shardId) {
                }
        if (indexRoutingTable == null) {
    public long version() {
            Index index = shardRoutingEntry.index();
        }
     */
 * Modifications Copyright OpenSearch Contributors. See
        return allSatisfyingPredicateShardsGrouped(indices, includeEmpty, ACTIVE_PREDICATE);
    }
         * @param numberOfReplicas the number of replicas
                    .initializeAsRecovery(indexMetadata);
                add(indexRoutingBuilder);
                    set.add(new PlainShardIterator(primary.shardId(), Collections.emptyList()));
import org.opensearch.index.shard.ShardNotFoundException;
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        }
    }
    /**
                IndexRoutingTable.Builder builder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
                continue;
        if (indexRoutingTable == null) {
import org.opensearch.core.index.Index;
import java.io.IOException;
                        builder.removeReplica();
        }
        }
     * All the *active* primary shards for the provided indices grouped (each group is a single element, consisting
    }
            }
 * this file be licensed under the Apache-2.0 license or a
            for (IndexRoutingTable indexRoutingTable : routingTable) {
    }
    }
        int count = 0;
        public Builder updateNodes(long version, RoutingNodes routingNodes) {
         * @param indices          the indices to update the number of replicas for
         */
            List<ShardRouting> allShardsIndex = allShards(index);
                    }
     * @return iterator over shards matching the predicate
            }
    /**
            return this;
    }
            if (indicesRouting == null) {
    public ShardsIterator allShardsSatisfyingPredicate(String[] indices, Predicate<ShardRouting> predicate) {
        }
        return shards;
     * All the shards on the node which match the predicate
            for (ShardRouting shardRouting : indexShardRoutingTable) {
    ) {
        IndexShardRoutingTable indexShard = indexRouting.shard(shardId);
            RoutingTable table = new RoutingTable(version, indicesRouting);
            index.writeTo(out);
        public String toString() {
        String[] indices = indicesRouting.keySet().toArray(new String[0]);
            SnapshotRecoverySource recoverySource,
        /**
    public RoutingTable(long version, final Map<String, IndexRoutingTable> indicesRouting) {
                return false;
        boolean includeEmpty,
                    builder.addIndexShard(indexShardRoutingTable);
        for (String index : indices) {
                indicesRouting.put(index, builder.build());
        List<ShardRouting> shards = new ArrayList<>();
                }
                    addShard(indexRoutingTableBuilders, shardRoutingEntry);
 */
    }
        public Builder addAsRecovery(IndexMetadata indexMetadata) {
    }
     */
            }
                add(indexRoutingBuilder);
        @Override
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
public class RoutingTable implements Iterable<IndexRoutingTable>, Diffable<RoutingTable>, VerifiableWriteable {
                } else if (currentNumberOfReplicas > numberOfReplicas) {
        public RoutingTable apply(RoutingTable part) {
                }
        }
                add(indexBuilder);
        public Builder updateNumberOfSearchReplicas(final int numberOfSearchReplicas, final String[] indices) {
        return new Builder();
    private ShardsIterator allShardsSatisfyingPredicate(
            shards.addAll(allShardsIndex);
            if (indexMetadata.getState() == IndexMetadata.State.OPEN) {
 * ownership. Elasticsearch licenses this file to you under
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
        private Map<String, IndexRoutingTable> indicesRouting = new HashMap<>();
        List<ShardRouting> shards = new ArrayList<>();
                    .initializeAsFromDangling(indexMetadata);
    public ShardsIterator allShardsIncludingRelocationTargets(String[] indices) {
            IndexMetadata indexMetadata,
    public boolean validate(Metadata metadata) {
            boolean forceRecoveryPrimary
            add(indexRoutingBuilder);
     *
        return indexShard;
            }
                }
        private final long version;
            indicesRouting.writeTo(out);
     */
        public RoutingTable build() {
        public Builder addAsFromCloseToOpen(IndexMetadata indexMetadata) {
    public Diff<RoutingTable> incrementalDiff(RoutingTable previousState) {
            throw new IndexNotFoundException(shardId.getIndex());
            RemoteStoreRecoverySource recoverySource,
 * Licensed to Elasticsearch under one or more contributor
                    }
                            shards.add(shardRouting.getTargetRelocatingShard());
