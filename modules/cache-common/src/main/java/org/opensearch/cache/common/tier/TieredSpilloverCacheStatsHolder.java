            : "Invalid tier dimension value";  
        }
        internalIncrement(dimensionValues, evictionsIncrementer, true);  
    }
                // nodes
        super(
    List<String> getDimensionsWithTierValue(List<String> initialDimensions, String tierValue) {  
        return result;  
     */  
    /** Dimension value for on-disk cache, like EhcacheDiskCache. */  
            lock.unlock();
                if (node.isAtLowestLevel()) {
}
    public void incrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
        // Entries from either tier should be included in the total values.
     */  
 * this file be licensed under the Apache-2.0 license or a
/*  
/**
            } else {
    }
        // Size from either tier should be included in the total values.  
 */
        this.diskCacheEnabled = diskCacheEnabled;  
        validateTierDimensionValue(dimensionValues);  
    }
    public void incrementMisses(List<String> dimensionValues) {  
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
                }
    public static final String TIER_DIMENSION_NAME = "tier";
    public void incrementEvictions(List<String> dimensionValues, boolean includeInTotal) {
 * This means for misses and evictions, if we are incrementing for the on-heap tier and the disk tier is present,
        validateTierDimensionValue(dimensionValues);
    }
            "TieredSpilloverCacheHolder must specify whether to include an eviction in the total cache stats. Use incrementEvictions(List<String> dimensionValues, boolean includeInTotal)"
     * @param dimensionValues The dimension values
    public TieredSpilloverCacheStatsHolder(List<String> originalDimensionNames, boolean diskCacheEnabled) {
        return dimensionNamesWithTier;  
    private String validateTierDimensionValue(List<String> dimensionValues) {  
 * The OpenSearch Contributors require contributions made to  
 *  
        } finally {  
        super.decrementSizeInBytes(dimensionValues, amountBytes);
    @Override
    }  
                node.incrementMisses();
    @Override
        try {
        // As we are removing nodes from the tree, obtain the lock
 * SPDX-License-Identifier: Apache-2.0
    /**
        Consumer<DefaultCacheStatsHolder.Node> evictionsIncrementer = (node) -> {
     */  
        Consumer<Node> missIncrementer = (node) -> {
        // If we count this eviction towards the total, we should increment all ancestor nodes. If not, only increment the leaf node.  
import java.util.List;
 * A tier-aware version of DefaultCacheStatsHolder. Overrides the incrementer functions, as we can't just add the on-heap
 *
     * @param dimensionValues The dimension values
    }
     * just count towards that tier's evictions.
        super.decrementItems(dimensionValues);  
                    node.incrementMisses();  
    }  
 * we have to increment only the leaf nodes corresponding to the on-heap tier itself, and not its ancestors,
        assert tierDimensionValue.equals(TIER_DIMENSION_VALUE_ON_HEAP) || tierDimensionValue.equals(TIER_DIMENSION_VALUE_DISK)
        );
     * Add tierValue to the end of a copy of the initial dimension values, so they can appropriately be used in this stats holder.
 */  
            }
        dimensionNamesWithTier.add(TIER_DIMENSION_NAME);
 * and disk stats to get a total for the cache as a whole. If the disk tier is present, the total hits, size, and entries  
    private static List<String> getDimensionNamesWithTier(List<String> dimensionNames) {  
            if (tierValue.equals(TIER_DIMENSION_VALUE_ON_HEAP) && diskCacheEnabled) {
        // Entries from either tier should be included in the total values.
        List<String> result = new ArrayList<>(initialDimensions);
            if (includeInTotal || node.isAtLowestLevel()) {
    }
        validateTierDimensionValue(dimensionValues);  
    @Override  
    public void decrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
        throw new UnsupportedOperationException(  
    public void incrementHits(List<String> dimensionValues) {
    /**
     * which specifies whether the eviction should be included in the cache's total evictions, or if it should  
 *  
 * When the disk tier isn't present, on-heap misses and evictions should contribute to the total.
        String tierDimensionValue = dimensionValues.get(dimensionValues.size() - 1);
     * @param includeInTotal Whether to include this eviction in the total for the whole cache's evictions
 * which correspond to totals including both tiers. If the disk tier is not present, we do increment the ancestor nodes.  
    // which have been entirely deleted, for example in an async removal listener.
        super.incrementSizeInBytes(dimensionValues, amountBytes);
    @Override
     * @param originalDimensionNames the original dimension names, not including TIER_DIMENSION_NAME
    public void incrementItems(List<String> dimensionValues) {
 * The same goes for evictions. Other stats values add normally.
import java.util.function.Consumer;
    /**  
    static final List<String> TIER_VALUES = List.of(TIER_DIMENSION_VALUE_ON_HEAP, TIER_DIMENSION_VALUE_DISK);  
    public static final String TIER_DIMENSION_VALUE_DISK = "disk";
        // If the disk tier is present, only misses from the disk tier should be included in total values.  
        super.incrementItems(dimensionValues);
    }  
        validateTierDimensionValue(dimensionValues);
                // If disk tier, or on-heap tier with a disabled disk tier, increment the leaf node and its parents  
        // Hits from either tier should be included in the total values.
            : "Must specify a value for every dimension except tier when removing from StatsHolder";
     */
        super.incrementHits(dimensionValues);
     * This method shouldn't be used in this class. Instead, use incrementEvictions(dimensionValues, includeInTotal)
    }
            TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
    /**
    // For decrements, we should not create nodes if they are absent. This protects us from erroneously decrementing values for keys
    public void decrementItems(List<String> dimensionValues) {  
    /** Whether the disk cache is currently enabled. */
     * @param diskCacheEnabled whether the disk tier starts out enabled
    }  
    }
                // If on-heap tier, increment only the leaf node corresponding to the on heap values; not the total values in its parent  
 * For example, if the heap tier has 5 misses and the disk tier has 4, the total cache has had 4 misses, not 9.
            removeDimensionsHelper(dimensionValues, statsRoot, 0);
        validateTierDimensionValue(dimensionValues);
        final String tierValue = validateTierDimensionValue(dimensionValues);
        validateTierDimensionValue(dimensionValues);
    }
        );
 * compatible open source license.
    // Common values used for tier dimension
        assert dimensionValues.size() == dimensionNames.size() - 1  
    @Override  
        List<String> dimensionNamesWithTier = new ArrayList<>(dimensionNames);
    public void incrementEvictions(List<String> dimensionValues) {
        };  
 * should be the sum of both tiers' values, but the total misses and evictions should be the disk tier's values.
    @Override
    }
public class TieredSpilloverCacheStatsHolder extends DefaultCacheStatsHolder {
        // Size from either tier should be included in the total values.  
        this.diskCacheEnabled = diskCacheEnabled;
        lock.lock();  
        result.add(tierValue);
    @Override
                node.incrementEvictions();  
        };
     * Constructor for the stats holder.  
        return tierDimensionValue;
    /** The name for the tier dimension. */  
import java.util.ArrayList;  
    void setDiskCacheEnabled(boolean diskCacheEnabled) {  
     * Increment evictions for this set of dimension values.  
    /** Dimension value for on-heap cache, like OpenSearchOnHeapCache.*/  
    @Override
        internalIncrement(dimensionValues, missIncrementer, true);
package org.opensearch.cache.common.tier;
    public static final String TIER_DIMENSION_VALUE_ON_HEAP = "on_heap";
    private boolean diskCacheEnabled;
            getDimensionNamesWithTier(originalDimensionNames),  
    public void removeDimensions(List<String> dimensionValues) {
            }
