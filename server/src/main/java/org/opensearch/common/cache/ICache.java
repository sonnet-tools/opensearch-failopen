    void invalidate(ICacheKey<K> key);
 * @opensearch.experimental
        String getCacheName();
    }
 * The OpenSearch Contributors require contributions made to  
 * @param <K> Type of key.
     * actually invalidated.
    }  
     */  
package org.opensearch.common.cache;
public interface ICache<K, V> extends Closeable {
    default ImmutableCacheStatsHolder stats() {  
    interface Factory {
     * Invalidates the key. If a dimension in the key has dropStatsOnInvalidation set to true, the cache also completely  
 * @param <V> Type of value.
import org.opensearch.common.cache.store.config.CacheConfig;  
    /**
    void put(ICacheKey<K> key, V value);
     */  
@ExperimentalApi  
    @ExperimentalApi
    // Return total stats only
    // Return stats aggregated by the provided levels. If levels is null or an empty array, return total stats only.
    ImmutableCacheStatsHolder stats(String[] levels);
        return stats(null);
/**
import java.util.Map;  
    void invalidateAll();  
import org.opensearch.common.annotation.ExperimentalApi;
     * resets stats for that dimension value. It's the caller's responsibility to make sure all keys with that dimension value are
 */
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
 * Represents a cache interface.  
/*  
 * SPDX-License-Identifier: Apache-2.0
    void refresh();  
    /**
}
    long count();
     * Factory to create objects.
    V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception;  
    Iterable<ICacheKey<K>> keys();
 */  
import java.io.Closeable;
 * compatible open source license.
 *
 * this file be licensed under the Apache-2.0 license or a
    V get(ICacheKey<K> key);
 *  
        <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories);  
