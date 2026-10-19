                    if (fieldsOfIndexToClear != null && fieldsOfIndexToClear.contains(key.indexCache.fieldName)) {
        public void clear(String fieldName) {
            for (Map.Entry<Index, Set<String>> entry : fieldsToClearCopy.entrySet()) {
import org.opensearch.common.Nullable;  
            // so there is no need to batch it.
            });
        cache.invalidateAll();
 * Licensed to Elasticsearch under one or more contributor  
                // skipped here would stay unreclaimed indefinitely. The snapshot is immune to LRU reordering, and  
        }
    private void updateMaximumWeight(ByteSizeValue newMaximumWeight) {
                try {
        return cache;
    ) {  
                    logger.error("Failed to call listener on field data loading", e);
                // invalidating a key that was concurrently removed is a no-op.
/**
            this.shardIdentityResolver = shardIdentityResolver;
 * KIND, either express or implied.  See the License for the
    public void onRemoval(RemovalNotification<Key, Accountable> notification) {  
        }  
import java.util.function.ToLongBiFunction;
            logger.error("Failed to call node-level listener on field data cache unloading", e);
            this.logger = logger;
     *
        Key(IndexFieldCache indexCache, IndexReader.CacheKey readerKey, @Nullable ShardId shardId) {  
        public boolean equals(Object o) {  
 * license agreements. See the NOTICE file distributed with
                k.listeners.add(nodeListener);  
                        continue;
            final IndexReader.CacheHelper cacheHelper = indexReader.getReaderCacheHelper();
        }
        Key(IndexFieldCache indexCache, IndexReader.CacheKey readerKey, @Nullable ShardId shardId, int shardIdentity) {
                throw new IllegalArgumentException("Reader " + indexReader + " does not support caching");  
import org.opensearch.common.annotation.PublicApi;
/*
    }  
 * GitHub history for details.
                return fieldData;
            this.perShardListeners = perShardListeners;  
                Collections.addAll(k.listeners, perShardListeners);
            return (FD) accountable;  
     * Mark all keys in the node-level cache which match the given index for cleanup.
            logger.warn(  
        }
    }
            this(indexCache, readerKey, shardId, NO_SHARD_IDENTITY);
    public void clear(Index index, String field) {
            synchronized (this) {
            // cache-scan cleanup: a reader closes only once, and exact-key invalidation is O(1),
                notifyOnCache(shardId, fieldData);  
        @SuppressWarnings("unchecked")
    public IndexFieldDataCache buildIndexFieldDataCache(IndexFieldDataCache.Listener listener, Index index, String fieldName) {
                } catch (Exception e) {
import org.opensearch.common.unit.RatioValue;  
            // in case new entries are marked for cleanup mid-iteration
import org.opensearch.index.fielddata.LeafFieldData;
                logger.error("Failed to call node-level listener on field data loading", e);
 *
    private final Cache<Key, Accountable> cache;
     */
        "indices.fielddata.cache.size",
     * Mark all keys in the node-level cache which match the given index and field for cleanup.
}
            try {
            String fieldName,
            }  
         * independent of which shard they were charged to.  
    void invalidateKey(Key key) {
                logger.error("Failed to call listener on field data cache unloading", e);
        @Override  
            return result;
 * The field data cache for multiple indices
        // node-wide, independent of which shard the entry belonged to.  
import org.opensearch.common.cache.RemovalListener;
import org.opensearch.common.settings.Setting;  
        for (IndexFieldDataCache.Listener listener : indexCache.perShardListeners) {
            Key key = (Key) o;  
        public <FD extends LeafFieldData, IFD extends IndexFieldData.Global<FD>> IFD load(
         * tracking is disabled. Used at removal time to skip stale decrements after shard
        this.fieldsToClear = new ConcurrentHashMap<>();  
        final long sizeInBytes = INDICES_FIELDDATA_CACHE_SIZE_KEY.get(settings).getBytes();  
     * {@link ShardId}. The captured value is stored on the {@link Key} and compared with the  
            logger.warn("Exception occurred while removing key from cache", e);  
        cache.setMaximumWeight(newMaximumWeight.getBytes());
            if (this == o) return true;
            Index index,
 * the Apache License, Version 2.0 (the "License"); you may
            }  
            // remove this way instead of clearing all, in case a new entry has been marked since copying
        MAX_SIZE_PERCENTAGE.toString(),
                nodeListener.onCache(shardId, fieldName, accountable);  
        final Index index;
    }
import java.util.Collections;
        }
            }
            clusterService.getClusterSettings().addSettingsUpdateConsumer(INDICES_FIELDDATA_CACHE_SIZE_KEY, this::updateMaximumWeight);
        final Accountable value = notification.getValue();
    }
     */  
import java.util.Map;
     * @param index The index to clear
        this(settings, indicesFieldDataCacheListener, null, null);
            this.indexCache = indexCache;
        @Override
            // This method must work to support the interface, but we don't use it directly in the actual cache clear path  
            }  
    }  
import org.apache.lucene.util.Accountable;
    public static class Key {
        IndexFieldDataCache.Listener listener,
        IndexFieldDataCache.Listener indicesFieldDataCacheListener,
        } catch (Exception e) {
            for (Map.Entry<Index, Set<String>> entry : fieldsToClear.entrySet()) {
                    }  
        if (key.shardIdentity != Key.NO_SHARD_IDENTITY && key.shardIdentity != currentShardIdentity) {
    public static final RatioValue MAX_SIZE_PERCENTAGE = new RatioValue(35);
        @Override
            ? Key.NO_SHARD_IDENTITY
            this.readerKey = readerKey;  
            // Invalidate the exact key synchronously rather than deferring to the periodic  
        } else {
 * ownership. Elasticsearch licenses this file to you under  
            indicesToClear.removeAll(indicesToClearCopy);  
            return (IFD) accountable;
                final Accountable ifd = (Accountable) indexFieldData.loadGlobalDirect(indexReader);  
        final IndicesFieldDataCache nodeLevelCache;
            }
 */  
         * {@link System#identityHashCode(Object)} can return any int including 0, so 0 is not
                for (Key key : getCache().keysSnapshot()) {
        public void clear() {
                cacheHelper.addClosedListener(IndexFieldCache.this);
         * Per-shard listeners (e.g. {@link org.opensearch.index.fielddata.ShardFieldData}). Skipped
                }
import java.io.IOException;
        }
            }  
            indexCache.nodeListener.onRemoval(key.shardId, indexCache.fieldName, wasEvicted, sizeInBytes);
    /**  
        }
     */
        ) {  
        ) throws Exception {
                threadPool.executor(ThreadPool.Names.GENERIC).execute(cache::refresh);  
        /**  
        @Override  
                    listener.onCache(shardId, fieldName, accountable);  
         * Sentinel meaning "no shard identity captured" — either tracking is disabled, the entry  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.Set;
    private Map<Index, Set<String>> fieldsToClear;
            } catch (Exception e) {
        public int hashCode() {
 * not use this file except in compliance with the License.
            if (!readerKey.equals(key.readerKey)) return false;
        // decremented for memory it never accounted for, pushing stats negative (#20363).  
import org.opensearch.core.index.shard.ShardId;
        assert key != null;
            Listener... perShardListeners
        }
     *  
    /**
        this.indicesFieldDataCacheListener = indicesFieldDataCacheListener;
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.index.LeafReaderContext;  
        Property.NodeScope,  
        @SuppressWarnings("unchecked")
     * current shard's identity at removal time to skip stale per-shard decrements after shard
        }
                    fieldsForIndex.removeAll(entry.getValue());
                // LRU list without holding the LRU lock, so a concurrent cache hit relinking the current entry to
        final String fieldName;  
        public final List<IndexFieldDataCache.Listener> listeners = new ArrayList<>();
        private void notifyOnCache(ShardId shardId, Accountable accountable) {
        }
        final ToIntFunction<ShardId> shardIdentityResolver;
        public long applyAsLong(Key key, Accountable ramUsage) {
        /**  
        /**  
            if (threadPool != null) {
            this.shardId = shardId;
            final ShardId shardId = ShardUtils.extractShardId(indexReader);  
 * The OpenSearch Contributors require contributions made to  
        @Override
            }  
    public void close() {
    }  
            return true;  
 * compatible open source license.
            ToIntFunction<ShardId> shardIdentityResolver,  
    }
        if (newMaximumWeight.getBytes() < oldMaximumWeight) {
            final DirectoryReader indexReader,  
            cacheBuilder.setMaximumWeight(sizeInBytes).weigher(new FieldDataWeigher());  
        if (!(indicesToClear.isEmpty() && fieldsToClear.isEmpty())) {  
         * predates identity capture, or the shard was unresolvable at load time. The staleness
@PublicApi(since = "1.0.0")  
            // noinspection unchecked  
import org.opensearch.common.settings.Setting.Property;
 *
        Set<String> fieldsOfIndex = fieldsToClear.computeIfAbsent(index, (idx) -> { return ConcurrentCollections.newConcurrentSet(); });  
     * Build a cache that captures shard identity at load time. {@code shardIdentityResolver}
         */
 *  
import org.opensearch.core.index.Index;  
     * returns the current shard's {@code System.identityHashCode} (or 0 if none) for a given
import org.opensearch.common.cache.Cache;
 * SPDX-License-Identifier: Apache-2.0
        Settings settings,  
/*  
        getCache().invalidate(key);  
            try {
            Map<Index, Set<String>> fieldsToClearCopy = new HashMap<>();
public class IndicesFieldDataCache implements RemovalListener<IndicesFieldDataCache.Key, Accountable>, Releasable {
         * as "always allow per-shard listeners through". Chosen as -1 because  
 */
            Logger logger,
 */  
        // replaced (e.g. after reallocation). Without this check, the replacement shard would be
                // the head can silently skip entries. Since marks are consumed above before scanning, an entry
        }
        long oldMaximumWeight = cache.getMaximumWeight();  
                OpenSearchDirectoryReader.addReaderCloseListener(indexReader, IndexFieldCache.this);  
        private final Logger logger;
                throw new IllegalArgumentException("Reader " + context.reader() + " does not support caching");
                        removeKey(key);  
        try {  
            });  
    public Cache<Key, Accountable> getCache() {
            final Accountable accountable = nodeLevelCache.getCache().computeIfAbsent(key, k -> {
            if (!indexCache.equals(key.indexCache)) return false;
     * @param index The index to clear  
    private static final Logger logger = LogManager.getLogger(IndicesFieldDataCache.class);  
            final Key key = new Key(this, cacheHelper.getKey(), shardId, shardIdentity);  
        cache.refresh();
        fieldsOfIndex.add(field);
         * reallocation (#20363). Not part of equals/hashCode.  
     * Deprecated ctor. Use the ctor with the clusterService argument.
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                Collections.addAll(k.listeners, perShardListeners);
     * @opensearch.api
import org.apache.lucene.index.IndexReader;
    /**  
            final Accountable accountable = nodeLevelCache.getCache().computeIfAbsent(key, k -> {
        ToIntFunction<ShardId> shardIdentityResolver
import java.util.HashMap;
import org.opensearch.common.settings.Settings;
            // Do it asynchronously to avoid blocking cluster applier thread
                        removeKey(key);
        Property.Dynamic
    /**  
     * reallocation (#20363).
    public IndicesFieldDataCache(
 * Unless required by applicable law or agreed to in writing,
    }  
            invalidateKey(key);
            : indexCache.shardIdentityResolver.applyAsInt(key.shardId);  
        this.indicesToClear = ConcurrentCollections.newConcurrentSet();
                    }
            // Don't call cache.refresh() here as it would have bad performance implications.  
        }  
            this.fieldName = fieldName;
        @Override  
            nodeLevelCache.getCache().invalidate(new Key(this, key, null));
import org.opensearch.index.fielddata.IndexFieldData;
                    if (indicesToClearCopy.contains(key.indexCache.index)) {  
            throws Exception {
            this.index = index;
            final Key key = new Key(this, cacheHelper.getKey(), shardId, shardIdentity);
            logger.warn("IndicesFieldDataCache ctor got null threadPool! Evictions on cache resize will happen on cluster applier thread!");  
        cache = cacheBuilder.build();
        return buildIndexFieldDataCache(listener, index, fieldName, shardId -> Key.NO_SHARD_IDENTITY);  
package org.opensearch.indices.fielddata.cache;
         * check in {@link IndicesFieldDataCache#onRemoval(RemovalNotification)} treats this value
         */
     * Key for the indices field data cache
            nodeLevelCache.clear(index, fieldName);
import org.apache.lucene.index.IndexReader.CacheKey;
        public <FD extends LeafFieldData, IFD extends IndexFieldData<FD>> FD load(final LeafReaderContext context, final IFD indexFieldData)  
            final ShardId shardId = ShardUtils.extractShardId(context.reader());
import org.opensearch.core.common.unit.ByteSizeValue;
    // The synchronized block is to avoid redundant concurrent sweeps; correctness does not depend on it.
import org.opensearch.threadpool.ThreadPool;  
                k.listeners.add(nodeListener);
    }
        }
            int weight = (int) Math.min(ramUsage.ramBytesUsed(), Integer.MAX_VALUE);
                    Set<String> fieldsOfIndexToClear = fieldsToClearCopy.get(key.indexCache.index);
import java.util.ArrayList;  
            int result = indexCache.hashCode();
            Listener nodeListener,
     */
         * on removal regardless of shard identity, since its accounting tracks node-wide bytes
import org.opensearch.index.shard.ShardUtils;
            if (cacheHelper == null) {
        if (clusterService != null) {  
            Set<Index> indicesToClearCopy = Set.copyOf(indicesToClear);  
        public final IndexFieldCache indexCache;  
import org.opensearch.common.cache.RemovalReason;  
    );
            for (Listener listener : perShardListeners) {
    public void clear(Index index) {
     */
    /**
            return weight == 0 ? 1 : weight;  
    /**  
     * @opensearch.internal  
        @Override
    public static class FieldDataWeigher implements ToLongBiFunction<Key, Accountable> {
    ) {
        }
            this.nodeLevelCache = nodeLevelCache;  
        indicesToClear.add(index);  
    public void clear() {
import java.util.List;  
import org.opensearch.cluster.service.ClusterService;
         * at removal time when the entry's captured shard identity no longer matches the current
import org.apache.logging.log4j.LogManager;
import java.util.function.ToIntFunction;
        @Override
    }
        // Per-shard listeners are skipped if the shard that originally cached this entry has been
                "IndicesFieldDataCache ctor got null clusterService argument! Cluster setting updates for cache size will not work!"
            final IndexReader.CacheHelper cacheHelper = context.reader().getCoreCacheHelper();  
    // Package-private so tests can inject removal failures.
            }
         */
    public IndicesFieldDataCache(Settings settings, IndexFieldDataCache.Listener indicesFieldDataCacheListener) {
        }
                }
    }  
            } else {
    @Override  
    /**  
        ClusterService clusterService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public final ShardId shardId;
    public IndexFieldDataCache buildIndexFieldDataCache(
 *  
            this.nodeListener = nodeListener;
 * under the License.  
                // Iterate a point-in-time copy of the keys rather than Cache.keys(): the live iterator walks the  
 */
        }
     *  
     * Computes a weight based on ramBytesUsed
 * this file be licensed under the Apache-2.0 license or a
         * shard's identity, to avoid stale decrements after shard reallocation.  
        } catch (Exception e) {  
            }  
        try {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                fieldsToClearCopy.put(entry.getKey(), Set.copyOf(entry.getValue()));  
        public static final int NO_SHARD_IDENTITY = -1;
    }
         */  
            final int shardIdentity = shardId == null ? Key.NO_SHARD_IDENTITY : shardIdentityResolver.applyAsInt(shardId);
    private void removeKey(Key key) {
import java.util.concurrent.ConcurrentHashMap;  
        return new IndexFieldCache(logger, this, index, fieldName, shardIdentityResolver, indicesFieldDataCacheListener, listener);
            // noinspection unchecked
import org.apache.logging.log4j.Logger;
        // Node-level listener (e.g. circuit breaker) must always fire — its accounting is
    public static final Setting<ByteSizeValue> INDICES_FIELDDATA_CACHE_SIZE_KEY = Setting.memorySizeSetting(  
     */
         * Listener registered at node level (e.g. the field-data circuit breaker). Always fires
        final Listener nodeListener;
        Index index,  
        CacheBuilder<Key, Accountable> cacheBuilder = CacheBuilder.<Key, Accountable>builder().removalListener(this);
        }
            final IndicesFieldDataCache nodeLevelCache,  
        public final IndexReader.CacheKey readerKey;
import org.opensearch.index.fielddata.IndexFieldDataCache;  
    }
            final IFD indexFieldData
                Set<String> fieldsForIndex = fieldsToClear.get(entry.getKey());
import org.opensearch.common.cache.CacheBuilder;  
    private final ThreadPool threadPool;
     * @opensearch.internal
     * The size after which the cache will begin to evict entries.
            );
     * A specific cache instance for the relevant parameters of it (index, fieldNames, fieldType).
        }
    static class IndexFieldCache implements IndexFieldDataCache, IndexReader.ClosedListener {  
    @Override
import org.opensearch.common.lease.Releasable;
        IndexFieldCache(
            result = 31 * result + readerKey.hashCode();  
        this.threadPool = threadPool;
                notifyOnCache(shardId, ifd);
                cache.refresh();
            this.shardIdentity = shardIdentity;
            nodeLevelCache.clear(index);
/*  
        if (sizeInBytes > 0) {
 * @opensearch.api
    /**
        final boolean wasEvicted = notification.getRemovalReason() == RemovalReason.EVICTED;
        }
            final int shardIdentity = shardId == null ? Key.NO_SHARD_IDENTITY : shardIdentityResolver.applyAsInt(shardId);
                listener.onRemoval(key.shardId, indexCache.fieldName, wasEvicted, sizeInBytes);  
        }
        }  
            // This method must work to support the interface, but we don't use it directly in the actual cache clear path  
            // Evict entries if needed, if the new size is smaller than the old.  
        IndexFieldCache indexCache = key.indexCache;  
            // Copy marked indices/fields before iteration, and only remove keys matching the copies
            return;
    }
        final int currentShardIdentity = key.shardId == null
        String fieldName,
                }  
            if (cacheHelper == null) {
                return ifd;
            } catch (Exception e) {
    @PublicApi(since = "1.0.0")  
        public void onClose(CacheKey key) throws IOException {
        /**
         * Identity of the IndexShard that inserted this entry, or {@link #NO_SHARD_IDENTITY} if
    }  
    @Deprecated  
     */
        Key key = notification.getKey();
        ThreadPool threadPool  
            if (o == null || getClass() != o.getClass()) return false;
         * safe to use as a sentinel.
     */
        final long sizeInBytes = value.ramBytesUsed();  
import org.opensearch.common.cache.RemovalNotification;
                final LeafFieldData fieldData = indexFieldData.loadDirect(context);
                if (fieldsForIndex != null) {  
    private final IndexFieldDataCache.Listener indicesFieldDataCacheListener;  
     * @param field The field to clear  
 * Modifications Copyright OpenSearch Contributors. See
        if (threadPool == null) {
        public final int shardIdentity;
        private final Listener[] perShardListeners;
    private Set<Index> indicesToClear;  
 * You may obtain a copy of the License at  
