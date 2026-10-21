    @Override
            "TieredSpilloverCacheHolder must specify whether to include an eviction in the total cache stats. Use incrementEvictions(List<String> dimensionValues, boolean includeInTotal)"
        Consumer<Node> missIncrementer = (node) -> {
        // Entries from either tier should be included in the total values.
                // If on-heap tier, increment only the leaf node corresponding to the on heap values; not the total values in its parent
public class TieredSpilloverCacheStatsHolder extends DefaultCacheStatsHolder {
     * @param originalDimensionNames the original dimension names, not including TIER_DIMENSION_NAME
    }
/*
    @Override
    private static List<String> getDimensionNamesWithTier(List<String> dimensionNames) {
                // nodes
            : "Must specify a value for every dimension except tier when removing from StatsHolder";
    }
    }
        validateTierDimensionValue(dimensionValues);
    /** Dimension value for on-heap cache, like OpenSearchOnHeapCache.*/
     */
        result.add(tierValue);
    }
 * When the disk tier isn't present, on-heap misses and evictions should contribute to the total.
            getDimensionNamesWithTier(originalDimensionNames),
        return result;
    @Override
    public static final String TIER_DIMENSION_VALUE_ON_HEAP = "on_heap";
    @Override
     * which specifies whether the eviction should be included in the cache's total evictions, or if it should
     * @param dimensionValues The dimension values
        }
    /**
        // Entries from either tier should be included in the total values.
        super.decrementSizeInBytes(dimensionValues, amountBytes);
     */
        // Hits from either tier should be included in the total values.
 * The OpenSearch Contributors require contributions made to
            } else {
        internalIncrement(dimensionValues, evictionsIncrementer, true);
import java.util.ArrayList;
        return tierDimensionValue;
        validateTierDimensionValue(dimensionValues);
            }
                node.incrementEvictions();
    public void decrementItems(List<String> dimensionValues) {
            if (tierValue.equals(TIER_DIMENSION_VALUE_ON_HEAP) && diskCacheEnabled) {
        );
            if (includeInTotal || node.isAtLowestLevel()) {
 * and disk stats to get a total for the cache as a whole. If the disk tier is present, the total hits, size, and entries
    @Override
 * we have to increment only the leaf nodes corresponding to the on-heap tier itself, and not its ancestors,
    public void removeDimensions(List<String> dimensionValues) {
     * Increment evictions for this set of dimension values.
    private String validateTierDimensionValue(List<String> dimensionValues) {
        dimensionNamesWithTier.add(TIER_DIMENSION_NAME);
    /**
    }
    /** Dimension value for on-disk cache, like EhcacheDiskCache. */
            }
            TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
    // Common values used for tier dimension
        List<String> result = new ArrayList<>(initialDimensions);
 * this file be licensed under the Apache-2.0 license or a
        internalIncrement(dimensionValues, missIncrementer, true);
    static final List<String> TIER_VALUES = List.of(TIER_DIMENSION_VALUE_ON_HEAP, TIER_DIMENSION_VALUE_DISK);
        lock.lock();
 *
 * SPDX-License-Identifier: Apache-2.0
    public void decrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
        List<String> dimensionNamesWithTier = new ArrayList<>(dimensionNames);
    }
        super.incrementSizeInBytes(dimensionValues, amountBytes);
    /**
        Consumer<DefaultCacheStatsHolder.Node> evictionsIncrementer = (node) -> {
    public static final String TIER_DIMENSION_VALUE_DISK = "disk";
        assert tierDimensionValue.equals(TIER_DIMENSION_VALUE_ON_HEAP) || tierDimensionValue.equals(TIER_DIMENSION_VALUE_DISK)
        validateTierDimensionValue(dimensionValues);
import java.util.function.Consumer;
    public void incrementEvictions(List<String> dimensionValues, boolean includeInTotal) {
 * The same goes for evictions. Other stats values add normally.
                // If disk tier, or on-heap tier with a disabled disk tier, increment the leaf node and its parents
    }
        } finally {
 * This means for misses and evictions, if we are incrementing for the on-heap tier and the disk tier is present,
        // Size from either tier should be included in the total values.
 * compatible open source license.
            lock.unlock();
    @Override
        assert dimensionValues.size() == dimensionNames.size() - 1
        validateTierDimensionValue(dimensionValues);
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
    List<String> getDimensionsWithTierValue(List<String> initialDimensions, String tierValue) {
    /**
     * @param includeInTotal Whether to include this eviction in the total for the whole cache's evictions
    public TieredSpilloverCacheStatsHolder(List<String> originalDimensionNames, boolean diskCacheEnabled) {
     * This method shouldn't be used in this class. Instead, use incrementEvictions(dimensionValues, includeInTotal)
    }
    }
 */
        String tierDimensionValue = dimensionValues.get(dimensionValues.size() - 1);
        super.incrementItems(dimensionValues);
    public void incrementEvictions(List<String> dimensionValues) {
        validateTierDimensionValue(dimensionValues);
    // For decrements, we should not create nodes if they are absent. This protects us from erroneously decrementing values for keys
        this.diskCacheEnabled = diskCacheEnabled;
 * which correspond to totals including both tiers. If the disk tier is not present, we do increment the ancestor nodes.
    public static final String TIER_DIMENSION_NAME = "tier";
    }
        };
    public void incrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
    }
        super(
        validateTierDimensionValue(dimensionValues);
        );
        return dimensionNamesWithTier;
            : "Invalid tier dimension value";
package org.opensearch.cache.common.tier;
        try {
                if (node.isAtLowestLevel()) {
    void setDiskCacheEnabled(boolean diskCacheEnabled) {
        };
 *
    /** The name for the tier dimension. */
    public void incrementItems(List<String> dimensionValues) {
        // If the disk tier is present, only misses from the disk tier should be included in total values.
                node.incrementMisses();
/**
        super.incrementHits(dimensionValues);
import java.util.List;
        super.decrementItems(dimensionValues);
        // If we count this eviction towards the total, we should increment all ancestor nodes. If not, only increment the leaf node.
        final String tierValue = validateTierDimensionValue(dimensionValues);
     * @param diskCacheEnabled whether the disk tier starts out enabled
    private boolean diskCacheEnabled;
    // which have been entirely deleted, for example in an async removal listener.
 * should be the sum of both tiers' values, but the total misses and evictions should be the disk tier's values.
 *
    /** Whether the disk cache is currently enabled. */
 * For example, if the heap tier has 5 misses and the disk tier has 4, the total cache has had 4 misses, not 9.
        this.diskCacheEnabled = diskCacheEnabled;
        throw new UnsupportedOperationException(
                    node.incrementMisses();
    public void incrementHits(List<String> dimensionValues) {
 * A tier-aware version of DefaultCacheStatsHolder. Overrides the incrementer functions, as we can't just add the on-heap
        // Size from either tier should be included in the total values.
        // As we are removing nodes from the tree, obtain the lock
}
 */
    @Override
    public void incrementMisses(List<String> dimensionValues) {
     * Add tierValue to the end of a copy of the initial dimension values, so they can appropriately be used in this stats holder.
    }
    }
     * just count towards that tier's evictions.
     * Constructor for the stats holder.
     * @param dimensionValues The dimension values
    @Override
            removeDimensionsHelper(dimensionValues, statsRoot, 0);
    }
     */
     */
                }
