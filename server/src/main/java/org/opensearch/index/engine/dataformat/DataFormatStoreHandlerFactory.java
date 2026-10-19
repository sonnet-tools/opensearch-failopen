     * Creates a per-shard store handler.
public interface DataFormatStoreHandlerFactory {
/*  
import org.opensearch.core.index.shard.ShardId;
 *
/**  
 * this file be licensed under the Apache-2.0 license or a
 *
     * @param isWarm         true if the shard is on a warm node
 */
     *                       when no native store is available
     * @param cacheRegistry  registry for looking up block caches by name; the handler may use this
 *  
     *                       to resolve its preferred cache via a {@link org.opensearch.plugins.BlockCacheConstants}  
}
     * @param shardId        the shard id
 * <p>Returned by {@link StoreStrategy#storeHandler()} for formats that  
import org.opensearch.repositories.NativeStoreRepository;
@FunctionalInterface
    DataFormatStoreHandler create(ShardId shardId, boolean isWarm, NativeStoreRepository repo, BlockCacheRegistry cacheRegistry);
 * need native file tracking (e.g. parquet with a Rust reader). The store
 */  
 * Per-format factory that produces a {@link DataFormatStoreHandler} for a shard.
    /**
 * @opensearch.experimental
@ExperimentalApi  
     *  
     * @return a live handler; the caller owns it and must close it
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * layer invokes {@link #create} once per shard.
     */  
     * @param repo           the native remote store repository, or {@link NativeStoreRepository#EMPTY}  
import org.opensearch.plugins.BlockCacheRegistry;  
import org.opensearch.common.annotation.ExperimentalApi;
     *                       constant. {@code null} if no block cache support is available.
package org.opensearch.index.engine.dataformat;
 * compatible open source license.
