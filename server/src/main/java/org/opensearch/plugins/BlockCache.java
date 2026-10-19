@ExperimentalApi  
    /**
 * is consumed by code that explicitly knows which backend it is talking to.
     *  
    /**  
        return null;  
 * <p>This interface deliberately carries only lifecycle and observability
 * methods. Backend-specific surface (e.g. Caffeine's pin/unpin reference  
     * Used by {@link BlockCacheRegistry} to look up caches by name.  
     * support prefix eviction or have their own eviction mechanism may leave this unimplemented.
    }
     * @return a borrowed (non-owning) handle to the native cache; never {@code null}  
 * Parquet column chunks, remote-object ranges, etc.). The exact key and  
     *
     * when it is deleted.
     * <p>The default implementation is a no-op — pure-Java caches that do not
 *
     * zero for that field rather than throwing. The snapshot is not
        return "";
     * free the underlying pointer directly.
 */
    boolean clear();  
     * <p>Used by {@link org.opensearch.index.store.remote.filecache.NodeCacheServiceCleaner}  
     */
     *
     * Native storage components check {@link NativeStoreHandle#isLive()} and  
}
     * dangling pointer.  
     * Returns optional per-tier stats for tiered caches (e.g. separate data and metadata caches).  
     * activity.
     * Returns a point-in-time snapshot of cache counters.
     * {@code data_cache_stats} and {@code metadata_cache_stats} in the REST response.
     * if this cache has no native backing.
     * <p>The returned handle uses a <em>no-op destructor</em> — calling
     * Release all resources held by this cache. Idempotent: calling more than
     *  
     * Returns the unique name of this cache backend, or an empty string if unnamed.
 * Node-scoped block cache contract — backend-neutral.  
import java.io.Closeable;  
 * The OpenSearch Contributors require contributions made to  
 * keys, native pointers, or anything else.  
     * @return {@code true} if the cache was cleared successfully, {@code false} on failure
     * <p>Implementations that do not track a particular metric should return
     *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    /**
     *  
 * — different backends may use path-and-offset keys, repository-and-range
    void close();
    /**
     * Evict all cache entries whose key starts with the given path prefix.
/**
     *
 * <p>A block cache stores variable-size contiguous byte ranges (file ranges,
     * <p>The returned handle is valid for as long as this {@code BlockCache}
 *
/*  
     * @return counter snapshot; never {@code null}  
     * <p>Implementations that do not support full cache clearing should return {@code false}.
     * cache resource is owned exclusively by the {@link BlockCache} instance and  
     */
     * <p>Pure-Java implementations return {@link NativeStoreHandle#EMPTY}.
 * counting, or Foyer's native cache pointer) lives on concrete subtypes and
     */
    /**
     * is alive. Callers that hold a reference past that lifetime will have a
 *
     * once must be a no-op.
     * Returns a <em>borrowed</em>, non-owning {@link NativeStoreHandle} pointing  
     * @return tiered stats breakdown, or {@code null} if not applicable  
    default BlockCacheTieredStats tieredStats() {
     *
 * <p>Implementations must be thread-safe and idempotent on {@link #close()}.
     *
    default String cacheName() {
     */
     * to deterministically remove all cached byte-range entries for a shard or index
import org.opensearch.common.annotation.ExperimentalApi;
        return NativeStoreHandle.EMPTY;  
    /**  
     * {@link NativeStoreHandle#close()} on it is safe but does nothing. The native
     * its lifecycle is managed by {@link #close()}. Callers must never attempt to
 * Core only ever uses the two methods declared here.  
     *  
package org.opensearch.plugins;
 * value shape is an implementation detail and is not part of this interface
 *  
     */
    /**
     * to the native cache backing this instance, or {@link NativeStoreHandle#EMPTY}
    default NativeStoreHandle nativeCacheHandle() {
     * @return cache name; never {@code null}
    default void evictPrefix(String prefix) {}  
     * @param prefix absolute path prefix; all entries whose key starts with this string are removed
     *
 * @opensearch.experimental
 */  
    }
 * this file be licensed under the Apache-2.0 license or a
 *
     *  
     * guaranteed to be internally consistent across concurrent cache  
     */  
    @Override
     *
     */  
     * Tiered implementations override to provide a breakdown that gets rendered as  
     *  
     * <p>The default implementation returns {@code null}, indicating a single-tier cache.
     * fall back to uncached behaviour when the handle is empty.
    }  
    BlockCacheStats stats();
public interface BlockCache extends Closeable {
     * Remove all entries from this cache.  
