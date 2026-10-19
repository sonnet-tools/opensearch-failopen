     */  
import org.opensearch.action.search.SearchShardIterator;
     * Whether the original shard group index was pruned.
    public static SearchIndexPruningResult notPruned(GroupShardsIterator<SearchShardIterator> shardIterators) {
        return prunedShardGroupIndexes.get(shardGroupIndex);
     * Number of pruned shard groups.
    /**
    }  
public final class SearchIndexPruningResult {
 * the caller materializes pruning by marking selected {@link SearchShardIterator}s as skipped.
}  
     */
    /**
        return prunedShardGroupIndexes.cardinality();
 * this file be licensed under the Apache-2.0 license or a
    public GroupShardsIterator<SearchShardIterator> shardIterators() {
    }  
import org.opensearch.cluster.routing.GroupShardsIterator;
package org.opensearch.action.search.pruning;
    /**
        this.prunedShardGroupIndexes = copyOf(prunedShardGroupIndexes);
 */  
    }
/**
     */
     * Original shard iterators supplied to the pruning pass.
import java.util.Objects;
        return prunedShardGroupIndexes.isEmpty() == false;  
    }
     * Creates a result representing no pruning.
     * Whether at least one shard group was pruned.  
        return shardIterators.size();  
 * The result records shard group indexes in the original {@link GroupShardsIterator}. It does not mutate iterators;
    /**
    }
     */
    /**  
 *  
        if (prunedShardGroupIndexes.length() > shardIterators.size()) {
 */  
        this.shardIterators = Objects.requireNonNull(shardIterators, "shardIterators must not be null");  
    public static SearchIndexPruningResult pruned(GroupShardsIterator<SearchShardIterator> shardIterators, BitSet prunedShardGroupIndexes) {
     */  
            throw new IllegalArgumentException("pruned shard group count must be between 1 and total shard groups - 1");
    private final GroupShardsIterator<SearchShardIterator> shardIterators;
        Objects.requireNonNull(shardIterators, "shardIterators must not be null");  
        }  
    }
        return shardIterators;
        }  
        int prunedShardGroups = prunedShardGroupIndexes.cardinality();  
 * compatible open source license.
        return (BitSet) Objects.requireNonNull(bitSet, "bitSet must not be null").clone();
    }  
     * Creates a result containing pruned shard group indexes.  
 *
    private static BitSet copyOf(BitSet bitSet) {  
 * The OpenSearch Contributors require contributions made to  
    private final BitSet prunedShardGroupIndexes;  
    /**
    /**
     */  
            throw new IllegalArgumentException("pruned shard group indexes must be within the shard iterator bounds");
 * Immutable result of one index-pruning pass.
     */
    public int prunedShardGroups() {
        Objects.requireNonNull(prunedShardGroupIndexes, "prunedShardGroupIndexes must not be null");
     * Number of original shard groups.  
/*  
        return new SearchIndexPruningResult(shardIterators, prunedShardGroupIndexes);
    public boolean pruned() {
    public boolean isPrunedShardGroup(int shardGroupIndex) {  
        return new SearchIndexPruningResult(shardIterators, new BitSet(shardIterators.size()));
    private SearchIndexPruningResult(GroupShardsIterator<SearchShardIterator> shardIterators, BitSet prunedShardGroupIndexes) {
        if (prunedShardGroups < 1 || prunedShardGroups >= shardIterators.size()) {
    }
    }
import java.util.BitSet;
    public int originalShardGroups() {
 * SPDX-License-Identifier: Apache-2.0
