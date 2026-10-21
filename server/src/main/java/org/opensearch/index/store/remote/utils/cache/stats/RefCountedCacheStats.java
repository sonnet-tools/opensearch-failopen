     *
     */
            + replaceCount
        this.missCount = missCount;
            + removeCount
    /**
     * Returns the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly
    @Override
    /**
     */
    /**
 * @opensearch.api
            throw new IllegalArgumentException();
            + ", "
    public long removeCount() {
     * @param hitCount       the number of cache hits
        this.missCount += otherStats.missCount();
     * @return the number of times {@link RefCountedCache} lookup methods have returned a cached value
        return Objects.hash(
        long requestCount = requestCount();
        return (requestCount == 0) ? 1.0 : (double) hitCount / requestCount;
        return evictionWeight;
     *
    private long hitCount;
@PublicApi(since = "2.7.0")
        long removeWeight,
        this.evictionWeight += otherStats.evictionWeight();
     */
            + pinnedUsage
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
     * @return the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly
     *
     * Returns the total weight of the cache.
        this.activeUsage += otherStats.activeUsage();
            + missCount
        long pinnedUsage
            && activeUsage == other.activeUsage
        this.pinnedUsage = pinnedUsage;
            evictionCount,
 *
    @Override
    @Override
     */
        this.removeWeight += otherStats.removeWeight();
     * @return the total pinned weight of the cache
            && missCount == other.missCount
            evictionWeight,
            && pinnedUsage == other.pinnedUsage;
        return (requestCount == 0) ? 0.0 : (double) missCount / requestCount;
     * Returns the number of times an entry has been evicted. This count does not include manual
            throw new IllegalArgumentException("Invalid Argument passed for Accumulating RefCountedCacheStats");
        this.evictionWeight = evictionWeight;
    }
            + ", "
            + ", "
     */
            removeWeight,
    @Override
     * @param evictionWeight the sum of weights of entries evicted from the cache
/*
            + activeUsage
     */
            + "evictionCount="
        );
    public boolean equals(Object o) {
            + "usage="
            replaceCount,
    /**
            + "replaceCount="
    /**
     * loaded) value, or null
            || (replaceCount < 0)
     * Returns the sum of weights of explicitly removed entries.
     * @return the number of times an entry has been evicted
            + "missCount="
    }
     * Returns the number of times {@link RefCountedCache} lookup methods have returned a cached value.
     * @return the total weight of the cache
            && replaceCount == other.replaceCount
     */
    }
            + "activeUsage="
     * uncached value. This is defined as {@code hitCount + missCount}.
     * weren't cache hits, including requests which resulted in either successful or failed loading
    private long removeCount;
            || (evictionCount < 0)
     * Returns the ratio of cache requests which were misses. This is defined as
        return hitCount + missCount;
    }
    }
        }
    @Override
    /**
    /**
            + ", "
 *
            || (evictionWeight < 0)) {
     * Returns the total active weight of the cache.
     * <p>
            removeCount,
            return true;
    }
            + "hitCount="
    @Override
    /**
            usage,
            && usage == other.usage
        return hitCount == other.hitCount
     * Note that {@code hitRate + missRate =~ 1.0}. Cache misses include all requests which
     * {@linkplain RefCountedCache#remove removals}.
     */
    }
     * concurrent misses for the same key will result in a single load operation.
    /**
 * this file be licensed under the Apache-2.0 license or a
    private long evictionWeight;
     * @param missCount      the number of cache misses*
            + '}';
        return usage;
        long usage,
            activeUsage
/**
            return false;
    /**
     * Returns the number of times an entry has been replaced.
     */
    public long removeWeight() {
    public long replaceCount() {
     * {@code hitRate + missRate =~ 1.0}.
     * Accumulates the values of another {@link RefCountedCacheStats} into this one.
    ) {
        long removeCount,
    }
    public IRefCountedCacheStats accumulate(IRefCountedCacheStats other) {
        long activeUsage,
            + usage
     * Constructs a new {@code AggregateRefCountedCacheStats} instance.
     * {@code hitCount / requestCount}, or {@code 1.0} when {@code requestCount == 0}. Note that
            || (removeCount < 0)
    public double missRate() {
    @Override
            || (removeWeight < 0)
     * @param replaceCount   the number of entries replaced explicitly from the cache
     * Returns the number of times an entry has been removed explicitly.
     */
    @Override
        long hitCount,
     *
    /**
        return evictionCount;
     *
 * compatible open source license.
            && evictionWeight == other.evictionWeight
        this.removeCount += otherStats.removeCount();
     */
        long requestCount = requestCount();
     * by end users and is too fine-grained for a builder.
     * Returns the total pinned weight of the cache.
    @Override
        this.removeWeight = removeWeight;
            + hitCount
    public long missCount() {
            + "pinnedUsage="
    }
     *
        return removeWeight;
            + evictionCount
     *
        if ((hitCount < 0)
    public long requestCount() {
    }
    }
     *
    private long activeUsage;
     * @param evictionCount  the number of entries evicted from the cache
 * SPDX-License-Identifier: Apache-2.0
    @Override
     *
     * {@code missCount / requestCount}, or {@code 0.0} when {@code requestCount == 0}.
     * @return result of accumulation of the other {@link RefCountedCacheStats} into this one.
    /**
    private long usage;
        this.hitCount = hitCount;
package org.opensearch.index.store.remote.utils.cache.stats;
        return this;
    @Override
    /**
        long replaceCount,
import org.opensearch.common.annotation.PublicApi;
     * @param removeCount    the number of entries removed from the cache
            || (missCount < 0)
        return missCount;
    public long evictionWeight() {
            + ", "
     */
    @Override
            + "removeCount="
    }
     * loaded) value, or null. Multiple concurrent calls to {@link RefCountedCache} lookup methods on an absent
    public long activeUsage() {
    @Override
     * @param removeWeight   the sum of weights of entries removed from the cache
 * The OpenSearch Contributors require contributions made to
    private long removeWeight;
 */
    /**
            && evictionCount == other.evictionCount
     * @param other another {@link RefCountedCacheStats}
        return activeUsage;
        long evictionCount,
    @Override
     * @return the ratio of cache requests which were hits
            hitCount,
        this.replaceCount += otherStats.replaceCount();
        if (other instanceof RefCountedCacheStats == false) {
    private long evictionCount;
    public long pinnedUsage() {
     */
    }
        this.hitCount += otherStats.hitCount();
     * @return the {@code hitCount + missCount}
        final RefCountedCacheStats otherStats = (RefCountedCacheStats) other;
public final class RefCountedCacheStats implements IRefCountedCacheStats {
     *
            + "evictionWeight="
        return hitCount;
     * that {@code missCount &gt;= loadSuccessCount + loadFailureCount}. Multiple
    public int hashCode() {
            missCount,
     * @return the ratio of cache requests which were misses
            && removeWeight == other.removeWeight
    @Override
        }
            + '{'
     * @return the number of times an entry has been replaced
        RefCountedCacheStats other = (RefCountedCacheStats) o;
     * {@linkplain RefCountedCache#remove removals}.
     *
        this.evictionCount = evictionCount;
    public long usage() {
        } else if (!(o instanceof RefCountedCacheStats)) {
            + "removeWeight="
    }
    }
        long missCount,
        if (o == this) {
        }
    private long pinnedUsage;
            + removeWeight
    public long evictionCount() {
 * Statistics about the performance of a {@link RefCountedCache}.
    /**
     * Many parameters of the same type in a row is a bad thing, but this class is not constructed
            + ", "
     * @return the number of times an entry has been removed
    @Override
        return replaceCount;
     *
    private long missCount;
        this.evictionCount += otherStats.evictionCount();
        long evictionWeight,
            + ", "
            + ", "
     */
        return pinnedUsage;
    }
     */
    }
    public RefCountedCacheStats(
    private long replaceCount;
        this.usage += otherStats.usage();
     * @return the total active weight of the cache
    public double hitRate() {
     * attempts, and requests which waited for other threads to finish loading. It is thus the case
}
     * Returns the ratio of cache requests which were hits. This is defined as
        this.replaceCount = replaceCount;
     *
     * operation.
        return getClass().getSimpleName()
        this.usage = usage;
     *
 */
    @Override
     * @return the sum of weights of explicitly removed entries
        return removeCount;
     * @return the sum of weights of evicted entities
     * Returns the number of times {@link RefCountedCache} lookup methods have returned either a cached or
            + ", "
import java.util.Objects;
    }
    public long hitCount() {
        this.removeCount = removeCount;
    public String toString() {
            + evictionWeight
     * Returns the sum of weights of evicted entries. This total does not include manual
     * value can result in multiple misses, all returning the results of a single cache load
            && removeCount == other.removeCount
     *
        this.activeUsage = activeUsage;
