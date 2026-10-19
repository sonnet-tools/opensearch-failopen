        for (IndexShardRoutingTable indexShard : this) {
                            builder.removeShard(shardRouting);
        index.writeTo(out);
                final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(shardRouting.id());
    @PublicApi(since = "1.0.0")
            int v = o1.shardId().getIndex().getName().compareTo(o2.shardId().getIndex().getName());
                            shardId,
    private final ShardShuffler shuffler;
        }
                                    + " is a primary that is recovering "
import java.io.IOException;  
        List<ShardRouting> allActiveShards = new ArrayList<>();
        for (IndexShardRoutingTable cursor : shards.values()) {  
            return this;  
                                ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
            );
        return sb.toString();  
        IndexRoutingTable that = (IndexRoutingTable) o;  
    }  
                ShardId shardId = new ShardId(index, shardNumber);  
                if (indexShard.replicaShards().isEmpty()) {  
            RecoverySource recoverySource,
 */  
        if (indexMetadata.getNumberOfShards() != shards().size()) {  
                }  
import java.util.Collections;
/**
    /**
        out.writeMapValues(shards, (stream, value) -> IndexShardRoutingTable.Builder.writeVerifiableTo(value, stream));
         * @return The Builder  
        for (IndexShardRoutingTable indexShard : this) {
                    && shardRouting.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE) {
     *  
                );  
        for (int i = 0; i < size; i++) {
                            ShardRouting.newUnassigned(shardId, false, PeerRecoverySource.INSTANCE, unassignedInfo)
}  
                                primary,  
 * compatible open source license.
        /**
                                primary,  
     *
            return this;  
            IndexShardRoutingTable indexShard = shards.get(shard.id());
                        builder.removeShard(shardRouting);  
                    true,  
                if (indexShardRoutingTable.searchOnlyReplicas().isEmpty()) {
                            )  
                            builder.removeShard(shardRouting);  
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            return this;
 * Licensed to Elasticsearch under one or more contributor  
                for (ShardRouting shardRouting : indexShard) {  
                        for (String excludedNode : excludedNodes) {  
        }
         */
        }  
            shards.put(indexShard.shardId().id(), indexShard);
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.INDEX_CLOSED, null));  
                ShardId shardId = new ShardId(index, shardNumber);
            count += shardRoutingTable.shardsMatchingPredicateCount(predicate);
                    }
                return this;
            IndexShardRoutingTable.Builder.writeToThin(indexShard, out);
            // Only throw if we are NOT in search-only mode. Otherwise, we ignore or log the mismatch.  
                    + "]"
                    String currentNodeId = shardRouting.currentNodeId();  
                for (int i = 0; i < indexMetadata.getNumberOfSearchOnlyReplicas(); i++) {
                }  
import org.opensearch.core.index.Index;  
            assert indexMetadata.getIndex().equals(index);  
         */  
                    throw new IllegalStateException(
                    // nothing to do here!  
        return new PlainShardsIterator(shuffler.shuffle(allActiveShards));
    public int primaryShardsActive() {
        for (IndexShardRoutingTable indexShardRoutingTable : this) {
                IndexShardRoutingTable indexShard = shards.get(shardId);
        public Builder initializeAsRecovery(IndexMetadata indexMetadata) {
        VerifiableWriteable {
         */
    }
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null));  
                                indexShardRoutingBuilder.addShard(  
                        "active shard routing "  
                boolean removed = false;  
        // check the number of shards
                }
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
         * Initializes a new empty index, with an option to control if its from an API or not.  
        }  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    }
     * @param state {@link ShardRoutingState} to retrieve  
 * The OpenSearch Contributors require contributions made to  
                            break;
                shards.put(shardNumber, new IndexShardRoutingTable.Builder(shards.get(shard.id())).addShard(shard).build());
                    + recoverySource.snapshot().getSnapshotId().getName()
                    if (!shardRouting.primary() && !shardRouting.assignedToNode() && !shardRouting.isSearchOnly()) {  
                                + " is a primary that is recovering "
            .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
                );
     * @param predicate {@link Predicate} to apply
import java.util.HashSet;
     */
            Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap,
    }
            return this;  
     * the <code>excludedNodes</code> parameter.
/*
    private final Map<Integer, IndexShardRoutingTable> shards;  
                            ShardRouting.newUnassigned(
                    return this;
        public IndexRoutingTable build() {
        this.index = index;
         */  
                    builder.addShard(shardRouting);  
         */
                    && inSyncAllocationIds.contains(shardRouting.allocationId().getId()) == false  
                if (shardRouting.active()
    }  
        for (IndexShardRoutingTable shardRoutingTable : this) {  
import org.opensearch.common.Randomness;  
            }
     *
         */
         * Initializes an existing index, to be restored from remote store
                        }
        return counter;
                for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
    }
                }  
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
            }
    IndexRoutingTable(Index index, final Map<Integer, IndexShardRoutingTable> shards) {
         * Initializes a new empty index, to be restored from a snapshot
     * @return number of distinct nodes this index has at least one shard allocated on
            return this;
                for (int i = 0; i <= indexMetadata.getNumberOfReplicas(); i++) {
                                    + "from a stale primary but has unexpected allocation ids in the in-sync set "
    @Override
import org.opensearch.cluster.routing.RecoverySource.RemoteStoreRecoverySource;
                    throw new IllegalStateException("IndexShardRoutingTable is not present for shardId: " + shardId);  
                                    + inSyncAllocationIds  
        return shards.values().iterator();
 * GitHub history for details.
        }
        boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
    }
        /**
                    if (inSyncAllocationIds.contains(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)) {
import org.opensearch.core.index.shard.ShardId;
                "restore_source[remote_store]"  
            return initializeAsRestore(indexMetadata, recoverySource, null, false, unassignedInfo);
                            primary ? primaryRecoverySource : PeerRecoverySource.INSTANCE,
import java.util.function.Predicate;  
         * Remove a Search only replica from the IndexShardRoutingTable
                        indexShardRoutingBuilder.addShard(  
            // Check if search-only mode is enabled
                        );
                    }
            if (shards.isEmpty() == false) {  
                        }
                }
                    new UnassignedInfo(UnassignedInfo.Reason.REPLICA_ADDED, null)  
         * Initializes a new empty index, as if it was created from an API.
     */
        ) {
package org.opensearch.cluster.routing;
            for (IndexShardRoutingTable indexShardRoutingTable : this) {
                        builder.removeShard(shardRouting);
         * Adds a new shard routing (makes a copy of it), with reference data used from the index shard routing table  
                        + routingNumberOfReplicas
                        ShardRouting.newUnassigned(
        return shards;
                    boolean primary = i == 0;  
                ShardRouting shard = ShardRouting.newUnassigned(
                        break;  
                    // Add only search replicas
                }
        // check index exists
                    throw new IllegalStateException(  
 * <p>
 * reflected in the routing table or in related classes, replicas are
                            )  
        public Builder initializeAsFromDangling(IndexMetadata indexMetadata) {  
        }
            return new IndexRoutingTable(index, shards);  
        if (this == o) return true;  
     * @param excludedNodes id of nodes that will be excluded
    }
        public Builder addSearchReplica() {
 * The {@link IndexRoutingTable} represents routing information for a single  
         * Initializes an index, to be restored from snapshot
        public Builder initializeAsRemoteStoreRestore(
                    for (int replicaNumber = 0; replicaNumber < indexMetadata.getNumberOfReplicas(); replicaNumber++) {
 *
 * Note: The term replica is not directly  
                    } else {
                    EmptyStoreRecoverySource.INSTANCE,
                shards.put(shardNumber, indexShardRoutingBuilder.build());
                                "a primary shard routing "
         * Initializes an existing index.
                        if (inSyncAllocationIds.size() != 1) {  
         * Initializes an existing index, to be restored from a snapshot
                                false,
     *
                        + "], got ["
            UnassignedInfo unassignedInfo
                                );
     *
                ShardId shardId = new ShardId(index, shardNumber);  
                if (indexMetadata.inSyncAllocationIds(shardNumber).isEmpty() == false) {
        for (IndexShardRoutingTable shardRoutingTable : this) {  
                    }  
                            indexShardRoutingBuilder.addShard(shardRouting);  
                                primary ? recoverySource : PeerRecoverySource.INSTANCE,
     * @return a {@link List} of shards that match one of the given {@link Predicate}  
                shards.put(shardNumber, new IndexShardRoutingTable.Builder(shards.get(shard.id())).addShard(shard).build());
    private final Index index;
        int counter = 0;  
            }  
            final UnassignedInfo unassignedInfo = new UnassignedInfo(
import org.opensearch.cluster.routing.RecoverySource.EmptyStoreRecoverySource;  
        if (!index.equals(that.index)) return false;
            }
     */
                                break;  
     * @opensearch.api  
            assert indexMetadata.getIndex().equals(index);
            final UnassignedInfo unassignedInfo = new UnassignedInfo(
                } else {
                            + "allocation set "  
 * represented as {@link ShardRouting}.
    public int numberOfNodesShardsAreAllocatedOn(String... excludedNodes) {
     */
                }
                    }
    }
            builder.addIndexShard(IndexShardRoutingTable.Builder.readFromThin(in, index));
        public Builder initializeAsFromCloseToOpen(IndexMetadata indexMetadata) {
     * {@link ShardRoutingState#UNASSIGNED} state. Otherwise <code>false</code>.
    }  
                    } else if (inSyncAllocationIds.contains(shardRouting.allocationId().getId()) == false) {  
 * Unless required by applicable law or agreed to in writing,
                    // we have previous valid copies for this shard. use them for recovery  
        /**  
                                );  
                    builder.addShard(shardRouting);
                    IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
            for (final int shardNumber : shards.keySet()) {
            final UnassignedInfo unassignedInfo = new UnassignedInfo(
                    + "]"
        }
            int routingNumberOfReplicas = indexShardRoutingTable.size() - 1;  
            }
                if (shardRouting.primary()
    @Override  
    }
                    shardId,  
            return this;
 * specific language governing permissions and limitations
                        if (shardRouting.isSearchOnly()) {
                    // Replica, if unassigned, trigger peer recovery else no action.
        List<ShardRouting> shards = new ArrayList<>();  
                    for (int i = 0; i < indexMetadata.getNumberOfSearchOnlyReplicas(); i++) {  
                    + recoverySource.snapshot().getRepository()
                        );
            );  
         */  
     * Calculates the number of nodes that hold one or more shards of this index  
            }
        }  
                        }
        }
        Index index = new Index(in);  
    }
                    // Primary is either active or initializing. Do not trigger restore.  
                            }
                    // nothing to do here!
         * Initializes a new index caused by dangling index imported.
            return this;
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.RecoverySource.LocalShardsRecoverySource;
    }  
         */
            for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
    /**
                    false,
     * Returns an unordered iterator over all active shards (including replicas).
                    indexShardRoutingBuilder.addShard(ShardRouting.newUnassigned(shardId, true, recoverySource, unassignedInfo));  
        public Builder addIndexShard(IndexShardRoutingTable indexShard) {  
            for (final int shardId : shards.keySet()) {  
        return counter;  
     * @return number of active primary shards
        return "IndexRoutingTable{" + "shards=" + shards + ", index=" + index + '}';
            boolean asNew,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         */  
            }  
                    + recoverySource.snapshot().getRepository()
 * this work for additional information regarding copyright
        int size = in.readVInt();  
    /**  
import java.util.Map;
                        ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)  
                );
            IndexMetadata indexMetadata,
        }
         */
                            break;  
        return primaryShardsActive() == shards().size();
        }
 * Modifications Copyright OpenSearch Contributors. See
                    + "/"  
                        indexShardRoutingBuilder.addShard(
                // version 0, will get updated when reroute will happen
                counter++;
     */
public class IndexRoutingTable extends AbstractDiffable<IndexRoutingTable>
                }
                                unassignedInfo
                        }  
            }
                if (!removed) {  
            }
                            throw new IllegalStateException(
                    indexShardRoutingBuilder.addShard(
                // first check if there is one that is not assigned to a node, and remove it  
            for (ShardRouting shardRouting : shardRoutingTable) {
        public Builder initializeAsFromOpenToClose(IndexMetadata indexMetadata) {
            if (isSearchOnly) {  
        }  
        }
     */  
    /**
                                primary ? EmptyStoreRecoverySource.INSTANCE : PeerRecoverySource.INSTANCE,
         */
                }
                        + "Replicas: "  
                                true,
     */  
                            } else {  
    }
        Set<String> nodes = new HashSet<>();
                            unassignedInfo
            for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {  
    /**
                v = Integer.compare(o1.shardId().id(), o2.shardId().id());  
        this.allActiveShards = Collections.unmodifiableList(allActiveShards);
                        );
                for (ShardRouting shardRouting : indexShardRoutingTable) {
                            + " has no corresponding entry in the in-sync "
                IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(indexShardRoutingTable.shardId());
        }
                shards.put(shardNumber, indexShardRoutingBuilder.build());  
                    && shardRouting.initializing()  
                            "a primary shard routing "
                                    ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
                        + ", Search Replicas: "
                            )
                throw new IllegalStateException(
        });  
                    for (ShardRouting shardRouting : indexShardRoutingTable) {  
     * Returns <code>true</code> if all shards are primary and active. Otherwise <code>false</code>.
                throw new IllegalStateException("trying to initialize an index with fresh shards, but already has shards created");
                    );  
        return nodes.size();
                UnassignedInfo.Reason.NEW_INDEX_RESTORED,  
                indexShard = new IndexShardRoutingTable.Builder(indexShard).addShard(shard).build();
     */
                }
            }  
        private Builder initializeAsRestore(  
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null));
     * Returns a {@link List} of shards that match one of the states listed in {@link ShardRoutingState states}
                        )  
            shards.put(indexShard.shardId().id(), indexShard);
        for (IndexShardRoutingTable indexShard : ordered) {
                    ShardId shardId = new ShardId(index, shardNumber);
                            primary,  
                            );
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;
        /**
            for (ShardRouting shard : indexShard) {
                        + "] routing table has wrong number of replicas, expected ["
    public static Diff<IndexRoutingTable> readDiffFrom(StreamInput in) throws IOException {
            return v;
    }  
                    indexShardRoutingBuilder.addShard(indexShardRoutingTable.primaryShard());
        out.writeVInt(shards.size());  
                shards.put(shardId, builder.build());
        }
                }
                    }
                if (shardRouting.active()) {
                ShardId shardId = new ShardId(index, shardNumber);
        /**
        return shards();  
import org.opensearch.cluster.metadata.Metadata;
            ordered.add(indexShard);  
            IndexMetadata indexMetadata,
        IndexMetadata indexMetadata = metadata.index(index.getName());  
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(indexShard.shardId());
    public List<ShardRouting> shardsMatchingPredicate(Predicate<ShardRouting> predicate) {
                    );
     * Return the index id
            RemoteStoreRecoverySource recoverySource,  
    public Index getIndex() {  
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED, null));
    }
        }
        public Builder removeReplica() {  
            }
    public Map<Integer, IndexShardRoutingTable> getShards() {
        }  
                }  
 * You may obtain a copy of the License at  
        for (IndexShardRoutingTable shardRoutingTable : this) {
 * @opensearch.api
    public static Builder builder(Index index) {
 * software distributed under the License is distributed on an
    public Map<Integer, IndexShardRoutingTable> shards() {
     * Returns a {@link List} of shards that match the provided {@link Predicate}  
                    }
            if (!shards.isEmpty()) {
    }
        return shards;
                expected.add(i);  
    public boolean allPrimaryShardsActive() {
 *  
                    for (ShardRouting shardRouting : indexShard) {
    public String toString() {
                    false,
     * {@link IndexRoutingTable} excluding the nodes with the node ids give as
 * under the License.  
                }  
        }  
                    // this is a new index but the initial shards should merged from another index  
                                shardId,  
                UnassignedInfo.Reason.EXISTING_INDEX_RESTORED,
        }
        private final Map<Integer, IndexShardRoutingTable> shards = new HashMap<>();  
        return true;  
                for (int i = 0; i <= indexMetadata.getNumberOfReplicas(); i++) {
        }
                        + indexShardRoutingTable.shardId().id()
        public Builder initializeAsNewRestore(  
    /**  
            shards.addAll(shardRoutingTable.shardsMatchingPredicate(predicate));
import org.opensearch.core.common.io.stream.StreamInput;  
    }
 */  
                .append(indexShard.shardId().id())  
        int result = index.hashCode();
                    boolean primary = i == 0;
                }
        public Builder(Index index) {
            if (shardRoutingTable.primaryShard().unassigned()) {
            int expectedReplicas = indexMetadata.getNumberOfReplicas() + indexMetadata.getNumberOfSearchOnlyReplicas();
 * this file be licensed under the Apache-2.0 license or a
            boolean forceRecoverAllPrimaries
                shards.put(shardId, builder.build());
                        } else {
                        throw new IllegalStateException(
                            if (shardRouting.isSearchOnly()) {
                    shards.put(shardNumber, indexShardRoutingBuilder.build());
 * index. The routing table maintains a list of all shards in the index. A
                .append(indexShard.shardId().getIndex().getName())
        public Builder removeSearchReplica() {
            }
 * not use this file except in compliance with the License.
                            ShardRouting.newUnassigned(
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Iterator;
                }
        public Builder addShard(ShardRouting shard) {  
        }  
                    if (!excluded) {
        }
                                + "from a known allocation id but has no corresponding entry in the in-sync set "
            sb.append("----shard_id [")  
    }  
        this.shards = Collections.unmodifiableMap(shards);
        public Builder addReplica() {
            if (v == 0) {
 */
 * </p>  
    public boolean allPrimaryShardsUnassigned() {  
        private Builder initializeEmpty(IndexMetadata indexMetadata, UnassignedInfo unassignedInfo) {
                // first check if there is one that is not assigned to a node, and remove it
    /**
                                shardId,
                                unassignedInfo
                    boolean excluded = false;
                    for (ShardRouting shardRouting : indexShardRoutingTable.searchOnlyReplicas()) {
                        indexShardRoutingBuilder.addShard(  
            shards.addAll(shardRoutingTable.shardsWithState(state));  
 * replica per shard is a {@code primary} replica. The {@code primary} replica
                            indexShardRoutingBuilder.addShard(shardRouting);
                if (!removed) {
            if (!shards.isEmpty()) {
            }
 * words, each instance of a shard is considered a replica while only one
        }
    }
                ShardId shardId = new ShardId(index, shardNumber);  
                    // All the replica shards to be recovered from peer recovery.
                    return this;
        result = 31 * result + shards.hashCode();
    // note, we assume that when the index routing is created, ShardRoutings are created for all possible number of
@PublicApi(since = "1.0.0")
        return new Builder(index);  
        int counter = 0;
    /**
     *  
        return primaryShardsUnassigned() == shards.size();
            return this;
    }  
     */
                    primaryRecoverySource = EmptyStoreRecoverySource.INSTANCE;
                throw new IllegalStateException("trying to initialize an index with fresh shards, but already has shards created");  
        /**
                    );
            // Standard initialization for non-search-only mode
                shards.put(shardNumber, indexShardRoutingBuilder.build());
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (indexShard == null) {
        for (IndexShardRoutingTable shardRoutingTable : this) {
        this.shuffler = new RotationShardShuffler(Randomness.get().nextInt());  
     * Calculates the number of primary shards in active state in routing table  
    }
        /**  
    public Iterator<IndexShardRoutingTable> iterator() {
            return initializeEmpty(indexMetadata, new UnassignedInfo(UnassignedInfo.Reason.INDEX_REOPENED, null));
            }
            boolean isSearchOnly = indexMetadata.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
                                excluded = true;
                        + "]"  
    public int shardsMatchingPredicateCount(Predicate<ShardRouting> predicate) {
    boolean validate(Metadata metadata) {
                    primaryRecoverySource = ExistingStoreRecoverySource.INSTANCE;
            for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
                    // Primary shard to be recovered from remote store.
        }
                    PeerRecoverySource.INSTANCE,
         * Add a Search only replica to the IndexShardRoutingTable
                        }
        if (!shards.equals(that.shards)) return false;  
                if (indexShardRoutingTableMap.containsKey(shardId) == false) {
     * @return id of the index
         * Initializes a new empty index, with an option to control if its from an API or not.  
                    // if writers are red we do not want to re-recover search only shards if already assigned.
                sb.append("--------").append(shard.shortSummary()).append("\n");  
 * for operations on a specific shard.
                "restore_source["
        /**
        for (IndexShardRoutingTable shardRoutingTable : this) {
        }  
import org.opensearch.cluster.AbstractDiffable;
                "restore_source["
    }  
        return shards.get(shardId);
                    if (shardRouting.isSearchOnly() && !shardRouting.assignedToNode()) {
            // For search-only mode, only initialize search replicas
                    }
    }
            final Set<Integer> ignoreShards,  
    @Override  
                    shardId,
                // re-add all the current ones  
                    "Shard ["  
    @Override  
import java.util.ArrayList;
     * @return a {@link List} of shards that match one of the given {@link ShardRoutingState states}
        if (o == null || getClass() != o.getClass()) return false;
                                    + shardRouting  
         * if it needs to be created.
                boolean removed = false;
        ) {  
                // re-add all the current ones
        /**
                    primaryRecoverySource = LocalShardsRecoverySource.INSTANCE;
                } else {
        public Builder initializeAsRestore(IndexMetadata indexMetadata, SnapshotRecoverySource recoverySource) {
                                + shardRouting  
            this.index = index;  
/*  
 * ownership. Elasticsearch licenses this file to you under  
            Set<Integer> expected = new HashSet<>();
        }  
            IndexMetadata indexMetadata,
        ) {  
 * single shard in this context has one more instances namely exactly one
                                + inSyncAllocationIds  
                        if (shardRouting.unassigned()) {
                    );
                    + recoverySource.snapshot().getSnapshotId().getName()
                if (forceRecoverAllPrimaries || indexShardRoutingTable.primaryShard().unassigned()) {
        public Builder initializeAsNew(IndexMetadata indexMetadata) {  
                }
                    for (ShardRouting shardRouting : indexShardRoutingTable.replicaShards()) {  
            } else {
     * Returns <code>true</code> if all primary shards are in  
                    }  
                // version 0, will get updated when reroute will happen
            assert indexMetadata.getIndex().equals(index);
import org.opensearch.cluster.metadata.IndexMetadata;
                    && shardRouting.isSearchOnly() == false) {
                    + "/"  
        index.writeTo(out);
                    indexShardRoutingBuilder.addShard(
        CollectionUtil.timSort(ordered, (o1, o2) -> {  
import org.opensearch.cluster.Diff;  
    public void writeTo(StreamOutput out) throws IOException {
                        );
                                shardId,
                    }  
            if (shardRoutingTable.primaryShard() != null && shardRoutingTable.primaryShard().active()) {
                }  
            for (final int shardNumber : shards.keySet()) {  
                        removed = true;
 */  
import java.util.List;  
            SnapshotRecoverySource recoverySource,
                }  
        Builder builder = new Builder(index);
        }  
                for (int i = 0; i < indexMetadata.getNumberOfSearchOnlyReplicas(); i++) {  
        /**
    implements  
            }
                    if (asNew && ignoreShards.contains(shardNumber)) {
                ShardRouting shard = ShardRouting.newUnassigned(  
    public IndexShardRoutingTable shard(int shardId) {  
                    }
                throw new IllegalStateException("trying to initialize an index with fresh shards, but already has shards created");
                }
                IndexShardRoutingTable indexShardRoutingTable = shards.get(shardId);
 *
                .append("]\n");
                                    ShardRouting.newUnassigned(shardId, false, PeerRecoverySource.INSTANCE, unassignedInfo)
         */
    }
     * Builder of a routing table.
                                indexShardRoutingBuilder.addShard(
                    );
import org.opensearch.core.common.io.stream.VerifiableWriteable;
                if (!shardRouting.index().equals(index)) {
                    if (excludedNodes != null) {
            return this;
        return result;  
        }
                        nodes.add(currentNodeId);
    public static class Builder {  
                            ShardRouting.newUnassigned(
                        ShardRouting.newUnassigned(shardId, false, true, EmptyStoreRecoverySource.INSTANCE, unassignedInfo)
        /**  
        /**
            }
        int count = 0;
        Iterable<IndexShardRoutingTable>,
        return true;
                .append("][")
    public boolean equals(Object o) {
         * Initializes a new empty index, as as a result of closing an opened index.  
            }  
                final RecoverySource primaryRecoverySource;
                        "shard routing has an index [" + shardRouting.index() + "] that is different from the routing table"
import org.apache.lucene.util.CollectionUtil;
    /**
            final Set<Integer> ignoreShards  
                    }  
                    allActiveShards.add(shardRouting);  
     * Calculates the number of primary shards in the routing table the are in
                        }
        for (IndexShardRoutingTable shardRoutingTable : this) {  
    public static IndexRoutingTable readFrom(StreamInput in) throws IOException {
                UnassignedInfo.Reason.EXISTING_INDEX_RESTORED,  
         * Initializes a new empty index, as as a result of opening a closed index.
        /**
                    }  
        List<IndexShardRoutingTable> ordered = new ArrayList<>();
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
            for (int shardNumber = 0; shardNumber < indexMetadata.getNumberOfShards(); shardNumber++) {
                                unassignedInfo
                }
        if (indexMetadata.getIndexUUID().equals(index.getUUID()) == false) {
            for (final int shardId : shards.keySet()) {
    private final List<ShardRouting> allActiveShards;
                } else if (indexMetadata.getResizeSourceIndex() != null) {
            );  
 * can be seen as the "leader" of the shard acting as the primary entry point  
            throw new IllegalStateException(index + " exists in routing but does not exist in metadata");
        StringBuilder sb = new StringBuilder("-- index [" + index + "]\n");
            return initializeAsRestore(indexMetadata, recoverySource, ignoreShards, true, unassignedInfo);
                        if (!shardRouting.primary() && !shardRouting.isSearchOnly()) {
        List<ShardRouting> shards = new ArrayList<>();
 * {@link ShardRouting#primary() primary} and 1 or more replicas. In other  
            }
                expected.remove(indexShardRoutingTable.shardId().id());  
/*  
            for (ShardRouting shardRouting : indexShardRoutingTable) {
            if (routingNumberOfReplicas != expectedReplicas && isSearchOnlyClusterBlockEnabled == false) {
                    // a freshly created index with no restriction  
    public String prettyPrint() {
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;  
 *
                            }
                            indexShardRoutingBuilder.addShard(
         */
                        break;
                        );  
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalStateException(index.getName() + " exists in routing but does not exist in metadata with the same uuid");
                            + shardRouting
    public ShardsIterator randomAllActiveShardsIt() {  
        return index;
                IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingTableMap.get(shardId);  
            for (ShardRouting shardRouting : cursor) {
    }  
                        indexShardRoutingBuilder.addShard(  
        }
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {  
    public int primaryShardsUnassigned() {
    public List<ShardRouting> shardsWithState(ShardRoutingState state) {  
                        if (shardRouting.unassigned()) {  
                    indexShardRoutingBuilder.addShard(  
    /**  
                            + inSyncAllocationIds
        return readDiffFrom(IndexRoutingTable::readFrom, in);  
        }
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
        }
        private final Index index;
                    new UnassignedInfo(UnassignedInfo.Reason.REPLICA_ADDED, null)
            }
        return count;  
        /**  
    public int hashCode() {  
         */
                        } else {
                            );  
         * @return The Builder  
    // shards with state set to UNASSIGNED
 * SPDX-License-Identifier: Apache-2.0
     * {@link ShardRoutingState#UNASSIGNED} state.  
                for (ShardRouting shardRouting : indexShard) {
import org.opensearch.common.annotation.PublicApi;
            }
        }
        return shards;
                counter++;  
        if (!metadata.hasIndex(index.getName())) {  
                        + indexMetadata.getNumberOfSearchOnlyReplicas()  
     */  
                if (shardRouting.assignedToNode()) {
        return builder.build();
                }  
    @Override
            throw new IllegalStateException("Wrong number of shards in routing table, missing: " + expected);
            }  
                        removed = true;
                indexShard = new IndexShardRoutingTable.Builder(shard.shardId()).addShard(shard).build();  
import java.util.HashMap;  
                        // This shards wasn't completely snapshotted - restore it as new shard
        }  
                            if (currentNodeId.equals(excludedNode)) {
            }  
                        + indexMetadata.getNumberOfReplicas()
                                RecoverySource.EmptyStoreRecoverySource.INSTANCE,  
