     *
import org.opensearch.common.annotation.ExperimentalApi;
     * @return the total pinned weight of the cache
     * Accumulates the values of another {@link IRefCountedCacheStats} into this one.
     * Returns the sum of weights of explicitly removed entries.  
     * Returns the number of times {@link IRefCountedCacheStats} lookup methods have returned an uncached (newly
     */  
     */
    /**
     * @return the number of times an entry has been evicted
    public long usage();
    /**  
     * Returns the number of times an entry has been replaced.
     * value can result in multiple misses, all returning the results of a single cache load
     * {@code missCount / requestCount}, or {@code 0.0} when {@code requestCount == 0}.
    public long hitCount();
    /**
    /**  
     *
    public double hitRate();
     * Returns the number of times an entry has been evicted.
    /**
    public long evictionCount();  
     * Returns the number of times an entry has been removed explicitly.
     * Returns the number of times {@link IRefCountedCacheStats} lookup methods have returned a cached value.
     */  
     *
@ExperimentalApi
    /**  
 *  Statistics about the performance of a {@link RefCountedCache}.
     * Returns the total weight of the cache.
     *  
package org.opensearch.index.store.remote.utils.cache.stats;
     */  
     *
    public long removeWeight();
     *  
     */  
    /**
     * @return the ratio of cache requests which were misses  
     * Returns the number of times {@link IRefCountedCacheStats} lookup methods have returned either a cached or
     * Note that {@code hitRate + missRate =~ 1.0}. Cache misses include all requests which  
    /**
    /**
     * that {@code missCount &gt;= loadSuccessCount + loadFailureCount}. Multiple  
    public long activeUsage();  
    /**  
    public long requestCount();
 * compatible open source license.
     * loaded) value, or null
     */
 */  
     * {@code hitCount / requestCount}, or {@code 1.0} when {@code requestCount == 0}. Note that  
     */
     * uncached value. This is defined as {@code hitCount + missCount}.  
     * Returns the ratio of cache requests which were misses. This is defined as
    /**
     *
     * @return result of accumulation of the other {@link IRefCountedCacheStats} into this one.  
     * @param other another {@link IRefCountedCacheStats}
 */  
     */
     * attempts, and requests which waited for other threads to finish loading. It is thus the case
     */
     */
     * Returns the sum of weights of evicted entries.  
     * {@code hitRate + missRate =~ 1.0}.
     * @return the total active weight of the cache
     * weren't cache hits, including requests which resulted in either successful or failed loading
     * Returns the total pinned weight of the cache.  
     */  
     *  
    public long removeCount();  
     */
 *
     * @return the sum of weights of explicitly removed entries
    public long evictionWeight();
 * The OpenSearch Contributors require contributions made to  
     * @return the sum of weights of evicted entities
     */
     * operation.
     *
     * @return the total weight of the cache  
     *  
     * @return the number of times {@link IRefCountedCacheStats} lookup methods have returned a cached value  
    public IRefCountedCacheStats accumulate(IRefCountedCacheStats other) throws IllegalArgumentException;
 * SPDX-License-Identifier: Apache-2.0
    public double missRate();
    /**  
    /**
     */
     * @return the {@code hitCount + missCount}
}
     * Returns the ratio of cache requests which were hits. This is defined as
     *
     * @return the number of times an entry has been replaced  
 * this file be licensed under the Apache-2.0 license or a
     *
public interface IRefCountedCacheStats {
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
     * @return the number of times an entry has been removed
     * concurrent misses for the same key will result in a single load operation.
    public long missCount();
     * @return the ratio of cache requests which were hits  
    public long pinnedUsage();
     * Returns the total active weight of the cache.
     *
     * @return the number of times {@link IRefCountedCacheStats} lookup methods have returned an uncached (newly
/**
/*  
    /**
     * loaded) value, or null. Multiple concurrent calls to {@link IRefCountedCacheStats} lookup methods on an absent  
    public long replaceCount();
