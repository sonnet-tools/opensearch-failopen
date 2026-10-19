    @Override
    public AggregateRefCountedCacheStats(
     * by end users and is too fine-grained for a builder.
     */
    public long missCount() {
     * Constructs a new {@code AggregateRefCountedCacheStats} instance.
    /**
     * Getter for fullFileCacheStats.  
            + "fullRefCountedCacheStats="
     */  
        }
        return blockFileCacheStats;  
     *  
    /**  
    }
            + fullFileCacheStats.toString()  
     * @return result of accumulation of the other {@link IRefCountedCacheStats} into this one.
        RefCountedCacheStats pinnedFileCacheStats  
    public double missRate() {
    }
     *
     * Getter for OverallCacheStats.  
        return this.overallCacheStats.evictionWeight();  
     * Returns the number of times an entry has been evicted. This count does not include manual
    public long evictionCount() {
    public long usage() {
     *  
     *  
        this.blockFileCacheStats = blockFileCacheStats;
     * Returns the total pinned weight of the cache.
     * @return the number of times an entry has been evicted
     * {@code hitRate + missRate =~ 1.0}.
    public long pinnedUsage() {  
import org.opensearch.common.annotation.PublicApi;
    public long evictionWeight() {
     * Returns the ratio of cache requests which were hits. This is defined as  
        RefCountedCacheStats fullFileCacheStats,
     * Returns the total weight of the cache.
            + overallCacheStats.toString()  
    }
        return (requestCount == 0) ? 1.0 : (double) hitCount() / requestCount;
    public int hashCode() {
    /**
     */  
        this.fullFileCacheStats = fullFileCacheStats;  
     * @return the ratio of cache requests which were misses  
            + "overallRefCountedCacheStats="
        return this.overallCacheStats.removeWeight();
    public boolean equals(Object o) {  
     */
    public double hitRate() {  
     * operation.  
     *
    }  
     * {@linkplain RefCountedCache#remove removals}.  
     *
            + ", "
 * @opensearch.api  
     * @return the total weight of the cache  
    }
    }
        return overallCacheStats.equals(other.overallCacheStats)
        final AggregateRefCountedCacheStats otherStats = (AggregateRefCountedCacheStats) other;
     * @return the number of times an entry has been replaced
/**  
     */
        RefCountedCacheStats overallCacheStats,  
    @Override
        return this.overallCacheStats.removeCount();
     *
     */  
     * loaded) value, or null  
     * {@code hitCount / requestCount}, or {@code 1.0} when {@code requestCount == 0}. Note that
     * @return {@link RefCountedCacheStats} overallCacheStats.
     * @return the total active weight of the cache  
    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
     */
    public RefCountedCacheStats getOverallCacheStats() {  
        return this.pinnedFileCacheStats.pinnedUsage();
import java.util.Objects;
            + '{'
            + ", "
    private final RefCountedCacheStats fullFileCacheStats;  
            + ", "
        AggregateRefCountedCacheStats other = (AggregateRefCountedCacheStats) o;  
        return (requestCount == 0) ? 0.0 : (double) missCount() / requestCount;
    private final RefCountedCacheStats pinnedFileCacheStats;
    private final RefCountedCacheStats overallCacheStats;
     * Returns the ratio of cache requests which were misses. This is defined as
/*  
        RefCountedCacheStats blockFileCacheStats,
        return this.overallCacheStats.missCount();  
     */
    */
    }  
     * Returns the total active weight of the cache.
     * Returns the number of times {@link RefCountedCache} lookup methods have returned either a cached or
     *
    }
     *  
    /**
     *
    public long requestCount() {
     */
        this.pinnedFileCacheStats.accumulate(otherStats.pinnedFileCacheStats);
            throw new IllegalArgumentException("Invalid Argument passed for Accumulating AggregateRefCountedCacheStats");
    /**
     * @return the ratio of cache requests which were hits
        return overallCacheStats;
@PublicApi(since = "2.7.0")
            + '}';
     * Returns the number of times an entry has been replaced.
        return this;  
     * Returns the number of times an entry has been removed explicitly.
     */
    /**  
        return this.overallCacheStats.requestCount();
        long requestCount = requestCount();  
    }  
     * loaded) value, or null. Multiple concurrent calls to {@link RefCountedCache} lookup methods on an absent
 * Statistics about the Cumulative performance of a {@link RefCountedCache}.
     * @return the sum of weights of evicted entities  
     *
     * that {@code missCount &gt;= loadSuccessCount + loadFailureCount}. Multiple  
 */  
        return Objects.hash(overallCacheStats, fullFileCacheStats, blockFileCacheStats);
    }
            return false;
        return this.overallCacheStats.replaceCount();
    @Override  
    ) {
     *  
    }
     * uncached value. This is defined as {@code hitCount + missCount}.  
     * Returns the number of times {@link RefCountedCache} lookup methods have returned a cached value.  
            && blockFileCacheStats.equals(other.blockFileCacheStats)  
    /**  
public final class AggregateRefCountedCacheStats implements IRefCountedCacheStats {  
 */
            return true;
     * Getter for pinnedFileCacheStats.
     * {@code missCount / requestCount}, or {@code 0.0} when {@code requestCount == 0}.
}  
     * @return {@link RefCountedCacheStats} blockFileCacheStats.  
     * Many parameters of the same type in a row is a bad thing, but this class is not constructed
    /**
    }
     * attempts, and requests which waited for other threads to finish loading. It is thus the case
     */
    public long activeUsage() {
     * weren't cache hits, including requests which resulted in either successful or failed loading
    }
     * Getter for blockFileCacheStats.
            + "blockRefCountedCacheStats="
     */
        } else if (!(o instanceof AggregateRefCountedCacheStats)) {  
    /**
    /**
        }  
    /**  
        return this.overallCacheStats.hitCount();
            + blockFileCacheStats.toString()  
     * <p>  
    /**
    /**
    }
     * @return the {@code hitCount + missCount}
    @Override
     *  
     * @return the number of times an entry has been removed
        this.pinnedFileCacheStats = pinnedFileCacheStats;
     * Returns the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly  
    }
    }  
        this.blockFileCacheStats.accumulate(otherStats.blockFileCacheStats);  
        this.overallCacheStats.accumulate(otherStats.overallCacheStats);
    /**
    public long replaceCount() {  
        return this.overallCacheStats.usage();  
     * @return the number of times {@link RefCountedCache} lookup methods have returned a cached value
     */  
     * @return the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly
     * Returns the sum of weights of explicitly removed entries.
 * SPDX-License-Identifier: Apache-2.0
    /**
    /**
     * value can result in multiple misses, all returning the results of a single cache load
        if (other instanceof AggregateRefCountedCacheStats == false) {
        return pinnedFileCacheStats;
            + pinnedFileCacheStats.toString()  
     */
     */  
        return this.overallCacheStats.evictionCount();
     * @return {@link RefCountedCacheStats} fullFileCacheStats.
     *
    }  
            + "pinnedRefCountedCacheStats="
     * @return the sum of weights of explicitly removed entries
     */
        return getClass().getSimpleName()  
package org.opensearch.index.store.remote.utils.cache.stats;
        return fullFileCacheStats;
    private final RefCountedCacheStats blockFileCacheStats;
     *
 * compatible open source license.
     * @return {@link RefCountedCacheStats} pinnedFileCacheStats.
    public IRefCountedCacheStats accumulate(IRefCountedCacheStats other) {
     * @return the total pinned weight of the cache  
    public long hitCount() {
 * The OpenSearch Contributors require contributions made to  
    /**  
     */
    /**
     * Accumulates the values of another {@link IRefCountedCacheStats} into this one.
 *
    public RefCountedCacheStats getPinnedFileCacheStats() {
 *
        if (o == this) {
    }  
    }
            && fullFileCacheStats.equals(other.fullFileCacheStats)
    }  
        return this.overallCacheStats.activeUsage();  
    public long removeWeight() {  
    public long removeCount() {  
     * {@linkplain RefCountedCache#remove removals}.
    public String toString() {
    public RefCountedCacheStats getBlockFileCacheStats() {
     * Returns the sum of weights of evicted entries. This total does not include manual  
    }
     * @param other another {@link IRefCountedCacheStats}
        this.overallCacheStats = overallCacheStats;
        this.fullFileCacheStats.accumulate(otherStats.fullFileCacheStats);
    /**
        long requestCount = requestCount();
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
    public RefCountedCacheStats getFullFileCacheStats() {  
     * Note that {@code hitRate + missRate =~ 1.0}. Cache misses include all requests which  
            && pinnedFileCacheStats.equals(other.pinnedFileCacheStats);
     */
     * concurrent misses for the same key will result in a single load operation.
