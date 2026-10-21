        return this;
     * Returns the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly
        this.overallCacheStats = overallCacheStats;
     * @return the total pinned weight of the cache
     * @return the ratio of cache requests which were hits
    public String toString() {
    }
            + '}';
        return overallCacheStats;
    @Override
     * Getter for blockFileCacheStats.
     *
    }
        RefCountedCacheStats blockFileCacheStats,
 */
        this.blockFileCacheStats.accumulate(otherStats.blockFileCacheStats);
     */
@PublicApi(since = "2.7.0")
        return pinnedFileCacheStats;
public final class AggregateRefCountedCacheStats implements IRefCountedCacheStats {
    public long removeWeight() {
     * Returns the total pinned weight of the cache.
    /**
     * @return the total active weight of the cache
     * Many parameters of the same type in a row is a bad thing, but this class is not constructed
        return getClass().getSimpleName()
        return (requestCount == 0) ? 1.0 : (double) hitCount() / requestCount;
     * @return the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly
        this.overallCacheStats.accumulate(otherStats.overallCacheStats);
            + "fullRefCountedCacheStats="
     */
     * Getter for OverallCacheStats.
        this.fullFileCacheStats.accumulate(otherStats.fullFileCacheStats);
    /**
        return overallCacheStats.equals(other.overallCacheStats)
     */
    private final RefCountedCacheStats blockFileCacheStats;
    @Override
    /**
     *
     * @return the total weight of the cache
    /**
    public long replaceCount() {
        return fullFileCacheStats;
    /**
    public IRefCountedCacheStats accumulate(IRefCountedCacheStats other) {
    /**
     * Returns the sum of weights of explicitly removed entries.
    public boolean equals(Object o) {
     *
    }
            && blockFileCacheStats.equals(other.blockFileCacheStats)
     * {@code missCount / requestCount}, or {@code 0.0} when {@code requestCount == 0}.
/**
    public long hitCount() {
     * operation.
        return this.overallCacheStats.removeWeight();
        RefCountedCacheStats overallCacheStats,
        RefCountedCacheStats pinnedFileCacheStats
    }
     * Returns the number of times {@link RefCountedCache} lookup methods have returned a cached value.
    public long evictionCount() {
package org.opensearch.index.store.remote.utils.cache.stats;
     */
        return this.overallCacheStats.activeUsage();
    public long removeCount() {
    @Override
        this.pinnedFileCacheStats.accumulate(otherStats.pinnedFileCacheStats);
    }
            + ", "
        }
     * <p>
        AggregateRefCountedCacheStats other = (AggregateRefCountedCacheStats) o;
     * Returns the number of times an entry has been removed explicitly.
     * @return the number of times an entry has been replaced
            + '{'
     * @param other another {@link IRefCountedCacheStats}
     * uncached value. This is defined as {@code hitCount + missCount}.
    }
     * Returns the sum of weights of evicted entries. This total does not include manual
    /**
        return this.overallCacheStats.evictionCount();
    private final RefCountedCacheStats pinnedFileCacheStats;
            + "blockRefCountedCacheStats="
    }
     *
    public double missRate() {
     * Getter for fullFileCacheStats.
     * @return the number of times {@link RefCountedCache} lookup methods have returned a cached value
    public long pinnedUsage() {
     * Returns the ratio of cache requests which were hits. This is defined as
     * loaded) value, or null. Multiple concurrent calls to {@link RefCountedCache} lookup methods on an absent
    /**
    /**
    public double hitRate() {
     *
     * {@code hitRate + missRate =~ 1.0}.
            + "overallRefCountedCacheStats="
}
     */
    }
     * @return the sum of weights of evicted entities
        final AggregateRefCountedCacheStats otherStats = (AggregateRefCountedCacheStats) other;
    }
    /**
        return this.overallCacheStats.hitCount();
            + overallCacheStats.toString()
            && pinnedFileCacheStats.equals(other.pinnedFileCacheStats);
    private final RefCountedCacheStats fullFileCacheStats;
    public RefCountedCacheStats getFullFileCacheStats() {
        long requestCount = requestCount();
     * {@linkplain RefCountedCache#remove removals}.
            + "pinnedRefCountedCacheStats="
    ) {
    }
     *
    }
     * that {@code missCount &gt;= loadSuccessCount + loadFailureCount}. Multiple
     */
    }
        } else if (!(o instanceof AggregateRefCountedCacheStats)) {
     * @return {@link RefCountedCacheStats} overallCacheStats.
    public AggregateRefCountedCacheStats(
     *
     */
        if (other instanceof AggregateRefCountedCacheStats == false) {
     * @return the number of times an entry has been evicted
 * this file be licensed under the Apache-2.0 license or a
     * @return the number of times an entry has been removed
            return false;
     */
    }
     *
            + fullFileCacheStats.toString()
    }
        return blockFileCacheStats;
     * loaded) value, or null
        return this.overallCacheStats.requestCount();
     *
    /**
            throw new IllegalArgumentException("Invalid Argument passed for Accumulating AggregateRefCountedCacheStats");
            && fullFileCacheStats.equals(other.fullFileCacheStats)
     * Returns the number of times {@link RefCountedCache} lookup methods have returned either a cached or
     * concurrent misses for the same key will result in a single load operation.
     */
     * value can result in multiple misses, all returning the results of a single cache load
    public long missCount() {
    }
 */
     * Constructs a new {@code AggregateRefCountedCacheStats} instance.
     * weren't cache hits, including requests which resulted in either successful or failed loading
     */
     *
     */
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
     * @return the {@code hitCount + missCount}
     */
    public long requestCount() {
    }
     * Returns the total weight of the cache.
    public int hashCode() {
    /**
     *
     * @return {@link RefCountedCacheStats} fullFileCacheStats.
import org.opensearch.common.annotation.PublicApi;
     */
/*
        return Objects.hash(overallCacheStats, fullFileCacheStats, blockFileCacheStats);
     * @return {@link RefCountedCacheStats} pinnedFileCacheStats.
     */
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
            + blockFileCacheStats.toString()
    }
        }
        long requestCount = requestCount();
        this.blockFileCacheStats = blockFileCacheStats;
            + pinnedFileCacheStats.toString()
 * The OpenSearch Contributors require contributions made to
     *
        if (o == this) {
        return (requestCount == 0) ? 0.0 : (double) missCount() / requestCount;
            + ", "
 * @opensearch.api
            + ", "
     * attempts, and requests which waited for other threads to finish loading. It is thus the case
     * Getter for pinnedFileCacheStats.
    public RefCountedCacheStats getPinnedFileCacheStats() {
        return this.overallCacheStats.replaceCount();
    public long evictionWeight() {
        return this.pinnedFileCacheStats.pinnedUsage();
     * @return the ratio of cache requests which were misses
    }
            return true;
    /**
        return this.overallCacheStats.removeCount();
    /**
    /**
    /**
        return this.overallCacheStats.missCount();
     * {@linkplain RefCountedCache#remove removals}.
    public RefCountedCacheStats getBlockFileCacheStats() {
     * Returns the number of times an entry has been evicted. This count does not include manual
        return this.overallCacheStats.evictionWeight();
     * by end users and is too fine-grained for a builder.
        this.fullFileCacheStats = fullFileCacheStats;
    /**
    public long usage() {
 *
     * {@code hitCount / requestCount}, or {@code 1.0} when {@code requestCount == 0}. Note that
     * Returns the number of times an entry has been replaced.
     * @return result of accumulation of the other {@link IRefCountedCacheStats} into this one.
    public long activeUsage() {
    private final RefCountedCacheStats overallCacheStats;
     */
    }
     *
     *
     * Returns the ratio of cache requests which were misses. This is defined as
 *
     */
 * compatible open source license.
import java.util.Objects;
        return this.overallCacheStats.usage();
    */
    @Override
    }
     * Accumulates the values of another {@link IRefCountedCacheStats} into this one.
    public RefCountedCacheStats getOverallCacheStats() {
     */
    }
     * @return {@link RefCountedCacheStats} blockFileCacheStats.
     * Note that {@code hitRate + missRate =~ 1.0}. Cache misses include all requests which
    /**
        RefCountedCacheStats fullFileCacheStats,
     * @return the sum of weights of explicitly removed entries
     *
     * Returns the total active weight of the cache.
 * Statistics about the Cumulative performance of a {@link RefCountedCache}.
    /**
        this.pinnedFileCacheStats = pinnedFileCacheStats;
     */
