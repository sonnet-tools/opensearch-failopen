            for (IndexRoutingTable indexRoutingTable : routingTable) {  
        final IndexShardRoutingTable shardRoutingTable = indexRoutingTable.shard(shardId.getId());
/**
        }
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                    }  
            throw new IndexNotFoundException(index);
            }
import org.opensearch.index.IndexNotFoundException;
                }
                    continue;
        private long version;  
import org.opensearch.index.shard.ShardNotFoundException;  
            RemoteStoreRecoverySource recoverySource,
            indicesRouting.put(indexRoutingTable.getIndex().getName(), indexRoutingTable);  
            if (indexBuilder == null) {
        }  
     *
        for (int i = 0; i < size; i++) {
    }
     */  
     * @return All the shards matching the specific index
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            final Set<Integer> ignoreShards  
    public List<ShardRouting> shardsWithState(ShardRoutingState state) {
         */
     *
     * @throws IndexNotFoundException if provided index does not exist
        return true;
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsRestore(
        return new RoutingTableDiff(previousState, this);
}
            if (indicesRouting == null) {
                    // ignore index missing failure, its closed...  
            }
                add(indexRoutingBuilder);  
        @Override  
                throw new IllegalStateException("once build is called the builder cannot be reused");
                        builder.removeReplica();
    public boolean hasIndex(Index index) {
            return this;
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
        return indicesRouting.values().iterator();
                    }
                    .initializeAsFromDangling(indexMetadata);
     * @return iterator over shards matching the predicate for the specific indices  
            final ShardRouting shardRoutingEntry  
     */
     *  
        }
 * Represents a global cluster-wide routing table for all indices including the  
import org.opensearch.core.index.shard.ShardId;
    }
     * @return All the shards  
 * @see IndexRoutingTable  
        }  
    public ShardsIterator allShardsIncludingRelocationTargets(String[] indices) {  
        ArrayList<ShardIterator> set = new ArrayList<>();  
                    for (int i = 0; i < (numberOfSearchReplicas - currentNumberOfSearchReplicas); i++) {  
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;  
 * @opensearch.api
            }
                .initializeAsFromOpenToClose(indexMetadata);
                if (primary.active()) {
        public Builder addAsFromOpenToClose(IndexMetadata indexMetadata) {
     * @throws ShardNotFoundException if provided shard id is unknown  
        }  
    }  
                }
                indexRoutingTableBuilders.put(index.getName(), indexBuilder);  
                    .initializeAsFromCloseToOpen(indexMetadata);
            IndexRoutingTable index = IndexRoutingTable.readFrom(in);
            Map<String, IndexRoutingTable.Builder> indexRoutingTableBuilders = new HashMap<>();  
    public void writeTo(StreamOutput out) throws IOException {
        }
        return indicesRouting();
            // this is being called without pre initializing the routing table, so we must copy over the version as well  
        return count;  
            if (indexRoutingTable == null) {
            Iterable<ShardRouting> shardRoutingEntries = Iterables.concat(routingNodes.unassigned(), routingNodes.unassigned().ignored());
    }
        }
     * Return GroupShardsIterator where each active shard routing has it's own shard iterator.
            return this;
            return this;
        }
 * The OpenSearch Contributors require contributions made to  
    public GroupShardsIterator<ShardIterator> allAssignedShardsGrouped(String[] indices, boolean includeEmpty) {
                }  
        List<ShardRouting> shards = new ArrayList<>();  
    }
            shards.addAll(allShardsIndex);
import org.opensearch.cluster.DiffableUtils;  
    public RoutingTable(long version, final Map<String, IndexRoutingTable> indicesRouting) {
        return allSatisfyingPredicateShardsGrouped(indices, includeEmpty, ASSIGNED_PREDICATE);  
    /**
     */
                        if (includeRelocationTargets && shardRouting.relocating()) {
    public static Diff<RoutingTable> readDiffFrom(StreamInput in) throws IOException {
        List<ShardRouting> shards = new ArrayList<>();
    }  
        public Builder addAsRemoteStoreRestore(  
            if (indexRoutingTable.validate(metadata) == false) {
        return indexShard;
         */
            return null;
            if (indicesRouting == null) {  
    @Override  
    /**  
            add(indexRoutingTableBuilder.build());
    }
import org.opensearch.common.annotation.PublicApi;  
import java.util.Map;
        /**
            return (DiffableUtils.MapDiff<String, IndexRoutingTable, Map<String, IndexRoutingTable>>) indicesRouting;
            }  
    }
    }  
            return this;
     *
    @Override
     * @param index The index to return all the shards (replicas).  
 */  
import org.opensearch.cluster.metadata.Metadata;
    public Diff<RoutingTable> incrementalDiff(RoutingTable previousState) {
                        }
         * @return the builder
                    set.add(new PlainShardIterator(primary.shardId(), Collections.emptyList()));
        IndexRoutingTable indexRouting = index(shardId.getIndexName());
        for (final IndexRoutingTable index : indicesRouting.values()) {
                recoverySource  
        if (indexRoutingTable == null) {
            );  
import org.opensearch.common.util.iterable.Iterables;
        return allShardsSatisfyingPredicate(indices, predicate, false);
                throw new IllegalStateException("once build is called the builder cannot be reused");
            sb.append(entry.prettyPrint()).append('\n');
    @PublicApi(since = "1.0.0")  
        @Override
    }
        }  
        // use list here since we need to maintain identity across shards
     *
            }
     * @param indices indices to return all the shards.
            Index index = shardRoutingEntry.index();
            }  
        }
            version = in.readLong();  
    public Map<String, IndexRoutingTable> getIndicesRouting() {
            if (indexMetadata.getState() == IndexMetadata.State.OPEN) {  
                    for (int i = 0; i < (numberOfReplicas - currentNumberOfReplicas); i++) {  
        public RoutingTable build() {  
            add(indexRoutingBuilder);
         * @param indices          the indices to update the number of replicas for
            final Map<String, IndexRoutingTable.Builder> indexRoutingTableBuilders,
            indicesRouting = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * You may obtain a copy of the License at  
import org.opensearch.cluster.metadata.IndexMetadata;
        return new Builder();  
import java.util.List;
    public static class Builder {
            for (String index : indices) {
                }
    }  
        }
 */  
        builder.version = in.readLong();
    public Iterator<IndexRoutingTable> iterator() {  
                continue;
        out.writeMapValues(indicesRouting, (stream, value) -> value.writeVerifiableTo((BufferedChecksumStreamOutput) stream));  
 */
        boolean includeRelocationTargets  
        public Builder add(IndexRoutingTable.Builder indexRoutingTableBuilder) {
        public Builder addAsRecovery(IndexMetadata indexMetadata) {
                }  
                IndexShardRoutingTable shardRoutings = indexRoutingTable.shards().get(0);  
            }  
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsNew(  
         * @param numberOfSearchReplicas the number of replicas
        @Override
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            indicesRouting = DiffableUtils.readJdkMapDiff(in, DiffableUtils.getStringKeySerializer(), DIFF_VALUE_READER);
            }  
        List<ShardRouting> shards = new ArrayList<>();  
                    for (int i = 0; i < (currentNumberOfSearchReplicas - numberOfSearchReplicas); i++) {
        }
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                for (ShardRouting shardRoutingEntry : routingNode) {
     * @throws IndexNotFoundException if provided index does not exist
                if (currentNumberOfReplicas < numberOfReplicas) {
 * Unless required by applicable law or agreed to in writing,
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
                ShardRouting primary = indexShardRoutingTable.primaryShard();  
        return indicesRouting.containsKey(index);
                    // ignore index missing failure, its closed...
        String[] indices,
        }
        }
public class RoutingTable implements Iterable<IndexRoutingTable>, Diffable<RoutingTable>, VerifiableWriteable {
        return shard;
                addShard(indexRoutingTableBuilders, shardRoutingEntry);
 *  
    public GroupShardsIterator<ShardIterator> allActiveShardsGrouped(String[] indices, boolean includeEmpty) {
 * license agreements. See the NOTICE file distributed with
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
                continue;
        out.writeLong(version);
            return this;
        return allSatisfyingPredicateShardsGrouped(indices, includeEmpty, ACTIVE_PREDICATE);  
        // use list here since we need to maintain identity across shards
        RoutingTableDiff(RoutingTable before, RoutingTable after) {  
                }
     * All shards for the provided index and shard id  
                    .initializeAsRecovery(indexMetadata);
 * GitHub history for details.
 * compatible open source license.
        }  
                        set.add(shardRouting.shardsIt());
            out.writeLong(version);
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())  
            if (indicesRouting == null) {  
/*  
        return new PlainShardsIterator(shards);  
    public String toString() {
            return this;
            }  
                indicesRouting.put(indexRoutingTable.getIndex().getName(), indexRoutingTable);
 *     http://www.apache.org/licenses/LICENSE-2.0
        return GroupShardsIterator.sortAndCreate(set);
 * this file be licensed under the Apache-2.0 license or a
            }
            IndexMetadata indexMetadata,
            }
    public IndexShardRoutingTable shardRoutingTable(String index, int shardId) {
 * Licensed to Elasticsearch under one or more contributor  
            index.writeTo(out);
            }
        return shards;
     * @param predicate condition to match  
            version = routingTable.version;
        private static void addShard(
                    builder.addIndexShard(indexShardRoutingTable);
     * @throws ShardNotFoundException if provided shard id is unknown
import org.opensearch.common.Nullable;
        ) {
     * Return GroupShardsIterator where each assigned shard routing has it's own shard iterator.
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
        /**
    @Nullable
        IndexRoutingTable indexRouting = index(index);  
        return new Builder(routingTable);
        public Builder addAsFromCloseToOpen(IndexMetadata indexMetadata) {
    public boolean hasIndex(String index) {
                if (indexRoutingTable == null) {
        }  
    }
                } else if (currentNumberOfSearchReplicas > numberOfSearchReplicas) {  
                    // every relocating shard has a double entry, ignore the target one.  
            throw new IndexNotFoundException(shardId.getIndex());
            return add(indexRoutingBuilder);  
                add(indexRoutingBuilder);  
    public static final RoutingTable EMPTY_ROUTING_TABLE = builder().build();
        public Builder() {  
                            shards.add(shardRouting.getTargetRelocatingShard());  
        IndexRoutingTable indexRoutingTable = index(index);  
     * @param predicate condition to match
        IndexRoutingTable indexRouting = index(index.getName());  
    private static Predicate<ShardRouting> ASSIGNED_PREDICATE = ShardRouting::assignedToNode;
 * specific language governing permissions and limitations
         */
        }
            return this;  
                // we simply ignore indices that don't exists (make sense for operations that use it currently)
                        set.add(new PlainShardIterator(shardRouting.shardId(), Collections.emptyList()));  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                add(indexBuilder);
        private static final DiffableUtils.DiffableValueReader<String, IndexRoutingTable> DIFF_VALUE_READER =
        public Builder add(IndexRoutingTable indexRoutingTable) {
    public boolean validate(Metadata metadata) {
     * of the primary shard). This is handy for components that expect to get group iterators, but still want in some
        for (IndexRoutingTable indexRoutingTable : this) {  
                if (currentNumberOfSearchReplicas < numberOfSearchReplicas) {
        return shardRoutingTable == null ? null : shardRoutingTable.getByAllocationId(allocationId);
         * must be thrown away. If you need to build a new RoutingTable as a  
    public ShardsIterator allShards(String[] indices) {
            );
    @Override
    }
            }  
            if (indicesRouting == null) {
        }  
                }  
    }  
    public IndexRoutingTable index(Index index) {
            return table;  
    @Override
    public IndexRoutingTable index(String index) {
            add(indexRoutingBuilder);
    }  
        ) {
     * @return All the shard routing entries for the given index and shard id  
         * Builds the routing table. Note that once this is called the builder
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                recoverySource,
        }
                        builder.addReplica();
                indexMetadata,
        public void writeTo(StreamOutput out) throws IOException {  
            IndexMetadata indexMetadata,
        }  
     * @param indices The indices to return all the shards (replicas)
import java.util.HashMap;
    /**  
     *
        IndexShardRoutingTable indexShard = indexRouting.shard(shardId);
            return this;
                IndexRoutingTable.Builder builder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
    }
    }
        return this.version;
        public DiffableUtils.MapDiff<String, IndexRoutingTable, Map<String, IndexRoutingTable>> provideDiff() {  
            for (ShardRouting shardRoutingEntry : shardRoutingEntries) {  
            return "RoutingTableDiff{" + "version=" + version + ", indicesRouting=" + indicesRouting + '}';  
            indicesRouting.writeTo(out);
        this.version = version;  
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {  
                int currentNumberOfSearchReplicas = shardRoutings.searchOnlyReplicas().size();
                IndexRoutingTable indexRoutingTable = indicesRouting.get(index);
     *
     * @param includeEmpty             if true, a shard iterator will be added for non-assigned shards as well  
        }
        public Builder updateNumberOfReplicas(final int numberOfReplicas, final String[] indices) {  
    public ShardsIterator allShardsSatisfyingPredicate(String[] indices, Predicate<ShardRouting> predicate) {
        }  
        public RoutingTable apply(RoutingTable part) {
                }  
 * not use this file except in compliance with the License.
                    if (predicate.test(shardRouting)) {  
    }  
                .initializeAsRemoteStoreRestore(indexMetadata, recoverySource, indexShardRoutingTableMap, forceRecoveryPrimary);
            if (indexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {  
         * @param numberOfReplicas the number of replicas
        List<ShardRouting> shards = new ArrayList<>();  
                }
        Predicate<ShardRouting> predicate  
import org.opensearch.cluster.Diff;
        }  
    ) {
        return sb.toString();
         * Update the number of replicas for the specified indices.  
        private Map<String, IndexRoutingTable> indicesRouting = new HashMap<>();
    public ShardRouting getByAllocationId(ShardId shardId, String allocationId) {
        }
            return this;
                IndexRoutingTable.Builder builder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
     * cases to iterate over all primary shards (and not just one shard in replication group).  
        if (shard == null) {
import java.util.Set;  
        }
    }
        private final long version;
        String[] indices,
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
            shards.addAll(indexRoutingTable.shardsWithState(state));
        }
 *
     * All the shards (replicas) for the provided index.
    }
        if (indexRouting == null) {
            if (indexRoutingTable == null) {  
        return allShardsSatisfyingPredicate(indices, shardRouting -> true, false);  
        }
            Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap,  
                    for (int i = 0; i < (currentNumberOfReplicas - numberOfReplicas); i++) {
            return this;
import java.util.Iterator;  
                throw new IllegalStateException("once build is called the builder cannot be reused");
            }
     * or throws a {@link ShardNotFoundException} if no shard by the given id is found in the IndexRoutingTable.  
        return indicesRouting;
     */
        }
         * copy of this one you'll need to build a new RoutingTable.Builder.
        /**
     * All the *active* primary shards for the provided indices grouped (each group is a single element, consisting
        Builder builder = new Builder();
 * ownership. Elasticsearch licenses this file to you under  
        public Builder addAsNewRestore(  
            IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex()).initializeAsNewRestore(
            }
        StringBuilder sb = new StringBuilder("routing_table (version ").append(version).append("):\n");  
     * @return IndexShardRoutingTable
    private GroupShardsIterator<ShardIterator> allSatisfyingPredicateShardsGrouped(  
        }
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
                throw new IllegalStateException("once build is called the builder cannot be reused");
                        builder.removeSearchReplica();
            indexBuilder.addShard(shardRoutingEntry);
        out.writeLong(version);
                    }
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
     * @throws IndexNotFoundException If an index passed does not exists
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            for (IndexRoutingTable.Builder indexBuilder : indexRoutingTableBuilders.values()) {
     * @return All the primary shards grouped into a single shard element group each  
                shards.add(shardRouting);  
        for (IndexRoutingTable indexRoutingTable : this) {
        }  
 *
        if (indexShard == null) {
    }
            RoutingTable table = new RoutingTable(version, indicesRouting);
     * @param includeEmpty if true, a shard iterator will be added for non-assigned shards as well  
        }  
    }
        for (String index : indices) {  
import org.opensearch.core.index.Index;  
                } else if (currentNumberOfReplicas > numberOfReplicas) {  
                ignoreShards
                if (indexRoutingTable == null) {  
                    } else if (includeEmpty) { // we need this for counting properly, just make it an empty one
        return indicesRouting.get(index);
        }  
@PublicApi(since = "1.0.0")
         * @param indices          the indices to update the number of replicas for  
         *
                );
     * @param indexRouting IndexRoutingTable
        return allShardsSatisfyingPredicate(indices, predicate, false);  
                    indexMetadata
 * SPDX-License-Identifier: Apache-2.0
                    }
            }  
        }  
    /**
            if (indexRoutingTable == null) {  
                // re-add all the shards  
            for (RoutingNode routingNode : routingNodes) {
    public static Builder builder(RoutingTable routingTable) {  
                    addShard(indexRoutingTableBuilders, shardRoutingEntry);  
            IndexRoutingTable.Builder indexBuilder = indexRoutingTableBuilders.get(index.getName());  
     */
        for (String index : indices) {
                return false;
        public Builder version(long version) {
import java.util.ArrayList;  
            }  
        out.writeVInt(indicesRouting.size());  
                indexMetadata,  
     * @throws IndexNotFoundException If the index passed does not exists
                int currentNumberOfReplicas = indexRoutingTable.shards().get(0).writerReplicas().size();
                indicesRouting.put(index, builder.build());
    public static IndexShardRoutingTable shardRoutingTable(IndexRoutingTable indexRouting, int shardId) {  
            }
    public List<ShardRouting> allShards(String index) {
import org.opensearch.core.common.io.stream.VerifiableWriteable;
                    }  
    public GroupShardsIterator<ShardIterator> activePrimaryShardsGrouped(String[] indices, boolean includeEmpty) {  
     * @return All the shard routing entries for the given index and shard id
                add(indexRoutingBuilder);  
        }
        public Builder addAsRestore(IndexMetadata indexMetadata, SnapshotRecoverySource recoverySource) {  
                throw new IndexNotFoundException(index);  
        }  
    public Diff<RoutingTable> diff(RoutingTable previousState) {  
                IndexRoutingTable indexRoutingTable = indicesRouting.get(index);
    public Map<String, IndexRoutingTable> indicesRouting() {  
            this.version = version;
        String[] indices = indicesRouting.keySet().toArray(new String[0]);
    }  
    /**
    }
package org.opensearch.cluster.routing;
            }  
            for (ShardRouting shardRouting : indexShardRoutingTable) {
                // re-add all the shards  
    private final Map<String, IndexRoutingTable> indicesRouting;  
     */
     * @opensearch.api
            return this;
    }
     * @return version of the {@link RoutingTable}
    /**
    /**  
            throw new ShardNotFoundException(shardId);
     */
     * @param shardId ShardId  
            return new RoutingTable(version, indicesRouting.apply(part.indicesRouting));
        return indicesRouting.get(index.getName());  
        for (String index : indices) {
     * Returns the version of the {@link RoutingTable}.  
    }  
     *
    public static Builder builder() {
    /**
        if (indexRoutingTable == null) {
    private static Predicate<ShardRouting> ACTIVE_PREDICATE = ShardRouting::active;  
                    // now, add "empty" ones
     * @return iterator over shards matching the predicate
        int count = 0;
        return shards;  
        // use list here since we need to maintain identity across shards
    }  
     * Builder for the routing table. Note that build can only be called one time.
         * Update the number of search replicas for the specified indices.
        return new RoutingTableDiff(in);  
    // index to IndexRoutingTable map
     * All the shards for the provided indices on the node which match the predicate  
        return shards;  
 * version of the current routing state.
            }  
        RoutingTableDiff(StreamInput in) throws IOException {
        }
     */
        return allShardsSatisfyingPredicate(indices, shardRouting -> true, true);
 * Modifications Copyright OpenSearch Contributors. See
        public Builder addAsFromDangling(IndexMetadata indexMetadata) {
            }
    }  
 *
/*
     * All the shards on the node which match the predicate
import java.io.IOException;
                add(indexRoutingBuilder);  
                for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
    public long version() {
    private final long version;  
        this.indicesRouting = Collections.unmodifiableMap(indicesRouting);
                IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(indexMetadata.getIndex())
    /**  
        final IndexRoutingTable indexRoutingTable = index(shardId.getIndexName());  
                // we simply ignore indices that don't exists (make sense for operations that use it currently)
                    if (shardRoutingEntry.initializing() && shardRoutingEntry.relocatingNodeId() != null) continue;
        public Builder updateNumberOfSearchReplicas(final int numberOfSearchReplicas, final String[] indices) {
                } else if (includeEmpty) { // we need this for counting properly, just make it an empty one  
            this.version = version;  
    public static RoutingTable readFrom(StreamInput in) throws IOException {  
            new DiffableUtils.DiffableValueReader<>(IndexRoutingTable::readFrom, IndexRoutingTable::readDiffFrom);  
     * Get's the {@link IndexShardRoutingTable} for the given shard id from the given {@link IndexRoutingTable}
    }
        ) {
 * KIND, either express or implied.  See the License for the
            count += indexRoutingTable.shardsMatchingPredicateCount(predicate);
    public IndexShardRoutingTable shardRoutingTable(ShardId shardId) {
        IndexShardRoutingTable shard = indexRouting.shard(shardId.id());  
         * @return the builder  
 *
        String[] indices = indicesRouting.keySet().toArray(new String[0]);
        private final Diff<Map<String, IndexRoutingTable>> indicesRouting;
            return this;  
            }
    }
            if (indexMetadata.getState() == IndexMetadata.State.OPEN) {
            for (String index : indices) {  
        public Builder(RoutingTable routingTable) {
        }  
import org.opensearch.cluster.routing.RecoverySource.RemoteStoreRecoverySource;  
         *  
                    set.add(primary.shardsIt());
        return new RoutingTableIncrementalDiff(previousState, this);
        }  
            return this;  
            version = after.version;
            }
            }  
    private static class RoutingTableDiff implements Diff<RoutingTable>, StringKeyDiffProvider<IndexRoutingTable> {  
            List<ShardRouting> allShardsIndex = allShards(index);  
     */
                        shards.add(shardRouting);
    /**
    ) {
                indicesRouting.put(index, builder.build());
        Predicate<ShardRouting> predicate,
 * software distributed under the License is distributed on an
     * All shards for the provided {@link ShardId}
    @Override  
 * this work for additional information regarding copyright
import org.opensearch.cluster.Diffable;
    }
                    }
        for (final IndexRoutingTable entry : indicesRouting.values()) {
        return indexRouting != null && indexRouting.getIndex().equals(index);
                    if (predicate.test(shardRouting)) {  
     */  
import org.opensearch.core.common.io.stream.StreamInput;  
            indicesRouting.remove(index);
            IndexRoutingTable indexRoutingTable = index(index);
            SnapshotRecoverySource recoverySource,
    public ShardsIterator allShardsSatisfyingPredicate(Predicate<ShardRouting> predicate) {  
        for (String index : indices) {
            IndexRoutingTable indexRoutingTable = index(index);
            assert isIndexVerifiedBeforeClosed(indexMetadata);  
            IndexRoutingTable indexRoutingTable = index(index);
        public String toString() {
    }
                indexBuilder = new IndexRoutingTable.Builder(index);
            throw new IndexNotFoundException(index);
            boolean forceRecoveryPrimary
                }
        }
                    builder.addIndexShard(indexShardRoutingTable);
/*  
    /**
     */  
    }  
        public Builder addAsNew(IndexMetadata indexMetadata) {
        boolean includeEmpty,
    }
    private ShardsIterator allShardsSatisfyingPredicate(  
    /**  
     */
            builder.add(index);  
        ArrayList<ShardIterator> set = new ArrayList<>();
        }  
                        builder.addSearchReplica();
        return builder.build();  
                throw new IllegalStateException("once build is called the builder cannot be reused");
        return GroupShardsIterator.sortAndCreate(set);
                    continue;
 * under the License.  
    }
        }
    }
            indicesRouting = DiffableUtils.diff(before.indicesRouting, after.indicesRouting, DiffableUtils.getStringKeySerializer());
    public List<ShardRouting> allShards() {
                    // now, add "empty" ones
        for (IndexRoutingTable indexRoutingTable : this) {  
        return shardRoutingTable(indexRouting, shardId);
     * All the shards (replicas) for all indices in this routing table.
        public Builder updateNodes(long version, RoutingNodes routingNodes) {
    }
    public int shardsMatchingPredicateCount(Predicate<ShardRouting> predicate) {
            throw new ShardNotFoundException(new ShardId(indexRouting.getIndex(), shardId));  
        int size = in.readVInt();  
        if (indexRouting == null || indexRouting.getIndex().equals(shardId.getIndex()) == false) {  
import java.util.function.Predicate;
import java.util.Collections;
        public Builder remove(String index) {  
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            if (indicesRouting == null) {
            add(indexRoutingBuilder);
            return this;
