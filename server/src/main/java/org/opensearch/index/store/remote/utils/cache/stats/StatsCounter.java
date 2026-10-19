     * @param weight Weight of the entry.
 */  
     * Resets the cache usage by entries which are pinned.
     * @param shouldDecrease Should the active usage of the cache be decreased or not.
 */
 * @opensearch.internal  
     * Records the cache usage by entries which are active (being referenced).
     * Resets the cache usage by entries which are active (being referenced).
     * Returns the usage of the cache.
     * may be interleaved with update operations.  
     * Returns the pinned usage of the cache.
     */
     * {@link RefCountedCache#put(Object, Object)}  
 *
     */
     * @param count the number of hits to record
     * This should be called when cache is cleared.  
    /**
    void recordUsage(V value, long weight, boolean pinned, boolean shouldDecrease);
    /**
     *
    long pinnedUsage();
     */
    /**
    void recordPinnedUsage(V value, long weight, boolean shouldDecrease);
}  
    /**
     */
     * Records cache misses. This should be called when a cache request returns a value that was not  
    void recordRemoval(V value, boolean pinned, long weight);
     *
     * Records the cache usage by entries which are pinned.  
    void resetPinnedUsage();
     *
     */  
     * @param value          Entry of the cache.
    /**
 *
     * @param shouldDecrease Should the usage of the cache be decreased or not.
     */
     * key on an absent value should result in a single call to either {@code recordLoadSuccess} or  
     */
    /**
     * Resets the cache usage.
     * @param pinned
     *  
    void resetActiveUsage();
public interface StatsCounter<K, V> {
     * @param weight         Weight of the entry.  
 * compatible open source license.
     * evicted due to the cache's eviction strategy, and not as a result of manual
     * {@link RefCountedCache#remove(Object)}  removals}.
 * SPDX-License-Identifier: Apache-2.0
    long activeUsage();
     * Records the explicit removal of an entry from the cache. This should only been called when an entry is  
    /**
/*  
/**
     * This should be called when cache is cleared.  
    long usage();
     */
     * @param weight the weight of the evicted entry
    void recordActiveUsage(V value, long weight, boolean pinned, boolean shouldDecrease);  
import java.util.function.BiFunction;  
    /**
     */
     * Records cache hits. This should be called when a cache request returns a cached value.
    void resetUsage();
 * this file be licensed under the Apache-2.0 license or a
    /**  
    /**
     * @param weight         Weight of the entry.
     */
    void recordHits(K key, V value, boolean pinned, int count);  
 * Accumulates statistics during the operation of a {@link RefCountedCache} for presentation by  
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
     * Returns a snapshot of this counter's values. Note that this may be an inconsistent view, as it
     * Records the replacement of an entry from the cache. This should only been called when an entry is
     * Records the eviction of an entry from the cache. This should only been called when an entry is  
     * found in the cache. This method should be called by the loading thread, as well as by threads
     */
     */  
     */
     * @param count  the number of misses to record
     * @param value          Entry of the cache.
     * @return a snapshot of this counter's values
     *  
     * replaced as a result of manual
     * {@link RefCountedCache#compute(Object, BiFunction)}
     * removed as a result of manual
     *  
     * Records the usage of the cache. This should be called when an entry is created/removed/replaced in the cache.  
     * {@link RefCountedCache#compute(Object, BiFunction)}  
    IRefCountedCacheStats snapshot();
    /**
    void recordEviction(V value, long weight);  
     */  
     */
package org.opensearch.index.store.remote.utils.cache.stats;
 * {@link RefCountedCache#stats}. This is solely intended for consumption by {@code Cache} implementors.
     * This should be called when cache is cleared.  
     * @return Pinned usage of the cache.  
     * Returns the active usage of the cache.
    /**
     * {@link RefCountedCache#remove(Object)}
     *  
     * This should be called when an entry is pinned/unpinned in the cache.
     * @return Usage of the cache.  
    void recordReplacement(V oldValue, V newValue, long oldWeight, long newWeight, boolean shouldUpdateActiveUsage, boolean isPinned);  
     * @param weight the weight of the removed entry
     * This should be called when an active entry is created/removed/replaced in the cache.
    /**
 * The OpenSearch Contributors require contributions made to  
     * {@code recordLoadFailure} and multiple calls to this method, despite all being served by the
    /**
     * @return Active usage of the cache.  
     * @param pinned  
    /**  
    void recordMisses(K key, int count);  
     * blocking on the load. Multiple concurrent calls to {@link RefCountedCache} lookup methods with the same
     * @param shouldDecrease Should the pinned usage of the cache be decreased or not.  
     * results of a single load operation.
