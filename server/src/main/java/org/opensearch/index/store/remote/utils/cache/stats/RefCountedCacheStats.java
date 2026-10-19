        long requestCount = requestCount();
            && usage == other.usage
        long evictionWeight,  
     * @param removeWeight   the sum of weights of entries removed from the cache  
            + removeWeight  
        final RefCountedCacheStats otherStats = (RefCountedCacheStats) other;
    private long missCount;
    public long evictionCount() {
 * compatible open source license.
            + ", "
    /**  
     * {@linkplain RefCountedCache#remove removals}.  
    /**
        return Objects.hash(
    @Override
     * @param other another {@link RefCountedCacheStats}
 * Statistics about the performance of a {@link RefCountedCache}.
            + "hitCount="
     */
     * that {@code missCount &gt;= loadSuccessCount + loadFailureCount}. Multiple
            && pinnedUsage == other.pinnedUsage;
     * concurrent misses for the same key will result in a single load operation.  
    /**  
        this.evictionWeight += otherStats.evictionWeight();
            removeWeight,
    public long requestCount() {  
     * by end users and is too fine-grained for a builder.
    public long pinnedUsage() {
     * @param missCount      the number of cache misses*
    private long activeUsage;  
 *
    public long missCount() {
        this.missCount = missCount;  
    @Override
        return hitCount;
        return missCount;
            removeCount,
     *
        this.replaceCount += otherStats.replaceCount();
    /**
        return hitCount + missCount;
     * loaded) value, or null. Multiple concurrent calls to {@link RefCountedCache} lookup methods on an absent
     * value can result in multiple misses, all returning the results of a single cache load  
    }
    public double missRate() {
    public boolean equals(Object o) {  
     * @param removeCount    the number of entries removed from the cache
    private long usage;
     * Returns the number of times an entry has been evicted. This count does not include manual
            return false;
    /**  
        return replaceCount;
            missCount,  
        long hitCount,  
     * Many parameters of the same type in a row is a bad thing, but this class is not constructed  
     * Returns the total pinned weight of the cache.
    private long evictionWeight;
     * Returns the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly
        }
        this.removeCount = removeCount;
public final class RefCountedCacheStats implements IRefCountedCacheStats {  
    @Override  
     *
     * @return the {@code hitCount + missCount}  
     *
    }  
 */  
    }  
            + "missCount="
            && missCount == other.missCount
        this.evictionCount = evictionCount;
        return this;
     * @return the ratio of cache requests which were hits
        this.missCount += otherStats.missCount();
    @Override
     * operation.
 *
     */
            + "removeWeight="
    }
        if (other instanceof RefCountedCacheStats == false) {
    public long hitCount() {
        );
    @Override
        return activeUsage;
            + "usage="
            || (removeWeight < 0)
        this.hitCount += otherStats.hitCount();
     */
    @Override  
        if (o == this) {
            + replaceCount  
        }  
     *
     * @return the total weight of the cache
        this.activeUsage = activeUsage;
     */
        this.activeUsage += otherStats.activeUsage();  
    @Override
    @Override
    /**
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
            && evictionWeight == other.evictionWeight
     *
     * @return the number of times {@link RefCountedCache} lookup methods have returned an uncached (newly  
    public long removeCount() {
    }  
     * @return result of accumulation of the other {@link RefCountedCacheStats} into this one.  
            + "pinnedUsage="
            + usage  
     *
    private long replaceCount;
     * Constructs a new {@code AggregateRefCountedCacheStats} instance.
        long removeWeight,  
            + evictionCount  
     */
    @Override  
     * @return the number of times an entry has been evicted
@PublicApi(since = "2.7.0")
     * Returns the total weight of the cache.  
            + ", "
            + ", "
    private long removeWeight;
            throw new IllegalArgumentException();  
/*  
        return removeWeight;  
    @Override
            || (replaceCount < 0)  
    /**
}  
    /**
     */  
    }
     * @param evictionCount  the number of entries evicted from the cache
package org.opensearch.index.store.remote.utils.cache.stats;
        this.removeWeight += otherStats.removeWeight();
            evictionCount,
     * loaded) value, or null
            || (evictionCount < 0)
     */
    }
     *  
            + ", "
        long activeUsage,
     * <p>
        long requestCount = requestCount();  
import java.util.Objects;
     */  
    }
     */
        long usage,
    }  
     *
            + ", "
    ) {
     * weren't cache hits, including requests which resulted in either successful or failed loading  
 * The OpenSearch Contributors require contributions made to  
        return evictionCount;  
        return hitCount == other.hitCount
        return usage;  
            || (missCount < 0)  
            + ", "
    /**
        return (requestCount == 0) ? 0.0 : (double) missCount / requestCount;
     * Note that {@code hitRate + missRate =~ 1.0}. Cache misses include all requests which
        this.pinnedUsage = pinnedUsage;
    }
     *
     *  
     * @return the number of times an entry has been removed
            + removeCount  
    @Override  
     * @return the sum of weights of evicted entities
    }
            && evictionCount == other.evictionCount  
     * Returns the number of times an entry has been removed explicitly.
     * Returns the ratio of cache requests which were hits. This is defined as  
    public long evictionWeight() {
     *
            + evictionWeight  
        return removeCount;
    private long evictionCount;  
            && removeWeight == other.removeWeight
        } else if (!(o instanceof RefCountedCacheStats)) {  
            && removeCount == other.removeCount  
        this.evictionWeight = evictionWeight;
            throw new IllegalArgumentException("Invalid Argument passed for Accumulating RefCountedCacheStats");
        if ((hitCount < 0)
    private long hitCount;
    @Override  
    @Override
            + ", "
     * @return the number of times {@link RefCountedCache} lookup methods have returned a cached value
        return pinnedUsage;
    @Override
            + "removeCount="
        long replaceCount,
     * @param evictionWeight the sum of weights of entries evicted from the cache  
            activeUsage
    }  
     *  
    /**
            hitCount,
    }  
     * @return the total pinned weight of the cache
/**  
    public long replaceCount() {  
        this.removeWeight = removeWeight;
        this.evictionCount += otherStats.evictionCount();  
     * Accumulates the values of another {@link RefCountedCacheStats} into this one.  
     * {@code hitCount / requestCount}, or {@code 1.0} when {@code requestCount == 0}. Note that
     */
    /**
     * Returns the number of times an entry has been replaced.
     */  
        this.usage += otherStats.usage();
    public long removeWeight() {
     * @param hitCount       the number of cache hits  
     * Returns the ratio of cache requests which were misses. This is defined as  
    @Override
            + "replaceCount="
    public long activeUsage() {  
        long pinnedUsage  
            && activeUsage == other.activeUsage  
        long evictionCount,
    /**  
     *  
            + '}';
        return (requestCount == 0) ? 1.0 : (double) hitCount / requestCount;  
     * @return the total active weight of the cache  
        }
            return true;
     */
            + "activeUsage="
            || (removeCount < 0)
        RefCountedCacheStats other = (RefCountedCacheStats) o;  
     * Returns the sum of weights of explicitly removed entries.  
        return evictionWeight;
    }  
     * {@code hitRate + missRate =~ 1.0}.
        this.usage = usage;  
    /**  
     * @return the number of times an entry has been replaced  
     * Returns the total active weight of the cache.
            replaceCount,  
    @Override  
            + ", "
    private long pinnedUsage;
            + pinnedUsage  
     * Returns the number of times {@link RefCountedCache} lookup methods have returned either a cached or  
        this.removeCount += otherStats.removeCount();  
    public IRefCountedCacheStats accumulate(IRefCountedCacheStats other) {  
 * this file be licensed under the Apache-2.0 license or a
     * {@linkplain RefCountedCache#remove removals}.
    @Override
    public RefCountedCacheStats(
    }
        long removeCount,
     */
 * @opensearch.api  
    private long removeCount;  
            + activeUsage  
        this.hitCount = hitCount;
            + hitCount  
        this.replaceCount = replaceCount;  
        return getClass().getSimpleName()  
     * attempts, and requests which waited for other threads to finish loading. It is thus the case
     *
    }  
     * {@code missCount / requestCount}, or {@code 0.0} when {@code requestCount == 0}.
            + missCount  
    /**
 * SPDX-License-Identifier: Apache-2.0
     */  
            evictionWeight,
    /**
 */
     * Returns the sum of weights of evicted entries. This total does not include manual
    }
     * uncached value. This is defined as {@code hitCount + missCount}.
     * @return the ratio of cache requests which were misses
     */
            + "evictionWeight="
    public long usage() {
            usage,  
     * @param replaceCount   the number of entries replaced explicitly from the cache
    public int hashCode() {  
     * @return the sum of weights of explicitly removed entries
    public double hitRate() {
            && replaceCount == other.replaceCount
     *  
            + "evictionCount="
            + ", "
            + '{'
    }
    public String toString() {
        long missCount,
            || (evictionWeight < 0)) {
     * Returns the number of times {@link RefCountedCache} lookup methods have returned a cached value.
