     */
     * Discards any cached value for key {@code key}, regardless of reference count.  
    /**
    V get(K key);  
     * Associates {@code value} with {@code key} in this cache. If the cache previously contained a  
     *
     * Returns the weighted usage of this cache.
     * will be associated with the given key, and its reference count will be set to one. If the remapping function
     * function and enters the new value. If the mapping function returns null the item is removed from the
 * Custom Cache which support typical cache operations (put, get, ...) and it support reference counting per individual key which might
     * The remappingFunction method for a given key will be invoked at most once.
    /**
     * @return The total weight of all removed entries.  
     */
     * decrement references count for key {@code key}.
    void unpin(K key);
     * @return The total weight of all removed entries.
    long prune(Predicate<K> keyPredicate);
    /**
 */  
     */
    long pinnedUsage();
    /**
     * @return the combined active weight of the values in this cache.
    Integer getRef(K key);  
     * Removes the cache entries which match the predicate criteria for the key  
     * Pins the key in the cache, preventing it from being evicted.
    /**
     */
    }  
     */  
     * Removes all cache entries with a reference count of zero, regardless of current capacity.  
    /**  
     * count.
     * the usage history immediately or at all.  
     * get the reference count for key {@code key}.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.store.remote.utils.cache;
 * change eviction behavior
     * Returns the active usage of this cache.  
    /**  
    V put(K key, V value);  
    /**  
     */
 * compatible open source license.
    /**
     */  
    /**  
    void clear();
     * @param key
    /**
    void decRef(K key);
/*  
     */
    IRefCountedCacheStats stats();
     */  
import java.util.function.BiFunction;  
     * Returns a current snapshot of this cache's cumulative statistics. All statistics are
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
     */  
 * SPDX-License-Identifier: Apache-2.0
     * If the specified key is already associated with a value, attempts to update its value using the given mapping  
     * increment references count for key {@code key}.  
     *  
     */
     * Discards all entries in the cache, regardless of reference count.
     * @param key
     * If the specified key is NOT already associated with a value, then the value of the remapping function  
     * @return the combined weight of the values in this cache
     * value associated with {@code key}, the old value is replaced by {@code value}.
     *
 * @param <K> type of the key  
     *
    long activeUsage();
     * increases the reference count by one when it returns the newly mapped value.
    default long prune() {
    long usage();  
    /**
     * <p>
     */  
     * cached value for {@code key}. Retrieving an item automatically increases its reference  
     * Returns the value associated with {@code key} in this cache, or {@code null} if there is no
     */  
     * <p>
     * The new entry will have the reference count of the previous entry plus one, as this method automatically  
     * <p>  
     */
     * Unpins the key in the cache, allowing it to be evicted.
    /**  
/**  
     */
    void remove(K key);
     * Due to the performance penalty of maintaining statistics, some implementations may not record
    long size();  
 *
     * and have a reference count of zero, regardless of current capacity.
        return prune(key -> true);
     * returns null then nothing is done.
     *
    /**
    V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);  
     * cache, regardless of its reference count. If the mapping function returns non-null the value is updated.
     * initialized to zero, and are monotonically increasing over the lifetime of the cache.  
     * @return the current snapshot of the statistics of this cache
     * @return the combined pinned weight of the values in this cache.  
     */
    /**
     * Returns the pinned usage of this cache.
    void pin(K key);
 * @opensearch.internal  
}
 */
public interface RefCountedCache<K, V> {
 *
import java.util.function.Predicate;
    /**
    /**
    void incRef(K key);
     * Returns the approximate number of entries in this cache.
     */  
     *
 * @param <V> type of the value
 * this file be licensed under the Apache-2.0 license or a
