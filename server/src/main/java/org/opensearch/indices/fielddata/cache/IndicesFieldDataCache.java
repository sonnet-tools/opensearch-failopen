    // The synchronized block is to avoid redundant concurrent sweeps; correctness does not depend on it.
                // the head can silently skip entries. Since marks are consumed above before scanning, an entry
    }
            });
import org.opensearch.common.lease.Releasable;
 * Modifications Copyright OpenSearch Contributors. See
                fieldsToClearCopy.put(entry.getKey(), Set.copyOf(entry.getValue()));
    }
/*
import org.opensearch.index.shard.ShardUtils;
     */
            return;
import java.util.Collections;
        public final IndexReader.CacheKey readerKey;
    private final ThreadPool threadPool;
        }
    public IndicesFieldDataCache(Settings settings, IndexFieldDataCache.Listener indicesFieldDataCacheListener) {
        for (IndexFieldDataCache.Listener listener : indexCache.perShardListeners) {
            for (Listener listener : perShardListeners) {
     * Deprecated ctor. Use the ctor with the clusterService argument.
 * license agreements. See the NOTICE file distributed with
 *
        this.indicesToClear = ConcurrentCollections.newConcurrentSet();
            ? Key.NO_SHARD_IDENTITY
import org.opensearch.common.unit.RatioValue;
import org.opensearch.core.index.Index;
    /**
 *
                Set<String> fieldsForIndex = fieldsToClear.get(entry.getKey());
            logger.warn(
        this(settings, indicesFieldDataCacheListener, null, null);
                logger.error("Failed to call node-level listener on field data loading", e);
 * compatible open source license.
        Key key = notification.getKey();
        }
        }
            if (cacheHelper == null) {
 * GitHub history for details.
    // Package-private so tests can inject removal failures.
            }
    private void updateMaximumWeight(ByteSizeValue newMaximumWeight) {
        final IndicesFieldDataCache nodeLevelCache;
    static class IndexFieldCache implements IndexFieldDataCache, IndexReader.ClosedListener {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.common.unit.ByteSizeValue;
            // This method must work to support the interface, but we don't use it directly in the actual cache clear path
            for (Map.Entry<Index, Set<String>> entry : fieldsToClear.entrySet()) {
            }
            );
            final DirectoryReader indexReader,
package org.opensearch.indices.fielddata.cache;
        }
        public static final int NO_SHARD_IDENTITY = -1;
        @Override
    private final Cache<Key, Accountable> cache;
                Collections.addAll(k.listeners, perShardListeners);
     *
        cache.refresh();
 * You may obtain a copy of the License at
        if (clusterService != null) {
         * Identity of the IndexShard that inserted this entry, or {@link #NO_SHARD_IDENTITY} if
            this.nodeLevelCache = nodeLevelCache;
 */
        /**
        if (newMaximumWeight.getBytes() < oldMaximumWeight) {
            try {
    }
            } else {
            } catch (Exception e) {
     */
        return cache;
        CacheBuilder<Key, Accountable> cacheBuilder = CacheBuilder.<Key, Accountable>builder().removalListener(this);
            final Key key = new Key(this, cacheHelper.getKey(), shardId, shardIdentity);
            // so there is no need to batch it.
                    listener.onCache(shardId, fieldName, accountable);
        public final ShardId shardId;
        Index index,
        final boolean wasEvicted = notification.getRemovalReason() == RemovalReason.EVICTED;
            // Copy marked indices/fields before iteration, and only remove keys matching the copies
        IndexFieldDataCache.Listener listener,
                nodeListener.onCache(shardId, fieldName, accountable);
    public void close() {
        }
        @SuppressWarnings("unchecked")
            this.logger = logger;
                k.listeners.add(nodeListener);
         * Listener registered at node level (e.g. the field-data circuit breaker). Always fires
        }
    private Set<Index> indicesToClear;
    public Cache<Key, Accountable> getCache() {
        this.fieldsToClear = new ConcurrentHashMap<>();
    }
            ToIntFunction<ShardId> shardIdentityResolver,
            return weight == 0 ? 1 : weight;
    ) {
            }
        } else {
            final IndicesFieldDataCache nodeLevelCache,
import java.util.ArrayList;
     * {@link ShardId}. The captured value is stored on the {@link Key} and compared with the
     */
            cacheBuilder.setMaximumWeight(sizeInBytes).weigher(new FieldDataWeigher());
import org.apache.lucene.index.IndexReader.CacheKey;
    }
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void clear() {
        Settings settings,
     * @opensearch.api
        final String fieldName;
     * @param index The index to clear
import java.util.Set;
        if (key.shardIdentity != Key.NO_SHARD_IDENTITY && key.shardIdentity != currentShardIdentity) {
    private Map<Index, Set<String>> fieldsToClear;
    /**
    @Deprecated
        /**
import org.opensearch.common.settings.Settings;
import org.opensearch.common.cache.Cache;
        public final List<IndexFieldDataCache.Listener> listeners = new ArrayList<>();
        Property.Dynamic
            int result = indexCache.hashCode();
        public void onClose(CacheKey key) throws IOException {
            final ShardId shardId = ShardUtils.extractShardId(indexReader);
                logger.error("Failed to call listener on field data cache unloading", e);
            // Invalidate the exact key synchronously rather than deferring to the periodic
    );
        public <FD extends LeafFieldData, IFD extends IndexFieldData<FD>> FD load(final LeafReaderContext context, final IFD indexFieldData)
        }
         * {@link System#identityHashCode(Object)} can return any int including 0, so 0 is not
                        removeKey(key);
        final long sizeInBytes = value.ramBytesUsed();
    /**
                return fieldData;
         * safe to use as a sentinel.
            if (cacheHelper == null) {
        // decremented for memory it never accounted for, pushing stats negative (#20363).
 * under the License.
     * @opensearch.internal
        this.threadPool = threadPool;
            result = 31 * result + readerKey.hashCode();
        String fieldName,
            indexCache.nodeListener.onRemoval(key.shardId, indexCache.fieldName, wasEvicted, sizeInBytes);
            for (Map.Entry<Index, Set<String>> entry : fieldsToClearCopy.entrySet()) {
    private void removeKey(Key key) {
                try {
        } catch (Exception e) {
     * returns the current shard's {@code System.identityHashCode} (or 0 if none) for a given
        }
                throw new IllegalArgumentException("Reader " + indexReader + " does not support caching");
        final int currentShardIdentity = key.shardId == null
            this.index = index;
     * Mark all keys in the node-level cache which match the given index for cleanup.
         * at removal time when the entry's captured shard identity no longer matches the current
import org.opensearch.common.cache.RemovalListener;
        } catch (Exception e) {
            final ShardId shardId = ShardUtils.extractShardId(context.reader());
 * KIND, either express or implied.  See the License for the
    public static final RatioValue MAX_SIZE_PERCENTAGE = new RatioValue(35);
        if (!(indicesToClear.isEmpty() && fieldsToClear.isEmpty())) {
        "indices.fielddata.cache.size",
 * SPDX-License-Identifier: Apache-2.0
         * tracking is disabled. Used at removal time to skip stale decrements after shard
    }
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    public static class Key {
    /**
     */
        private final Logger logger;
     * Key for the indices field data cache
            nodeLevelCache.clear(index);
            throws Exception {
import org.opensearch.common.cache.RemovalNotification;
                    Set<String> fieldsOfIndexToClear = fieldsToClearCopy.get(key.indexCache.index);
            final IndexReader.CacheHelper cacheHelper = indexReader.getReaderCacheHelper();
        public final IndexFieldCache indexCache;
                }
    }
        /**
            this(indexCache, readerKey, shardId, NO_SHARD_IDENTITY);
@PublicApi(since = "1.0.0")
        }
        }
            Set<Index> indicesToClearCopy = Set.copyOf(indicesToClear);
        }
        // node-wide, independent of which shard the entry belonged to.
import org.opensearch.common.settings.Setting;
                threadPool.executor(ThreadPool.Names.GENERIC).execute(cache::refresh);
        Key(IndexFieldCache indexCache, IndexReader.CacheKey readerKey, @Nullable ShardId shardId) {
    }
    /**
                    fieldsForIndex.removeAll(entry.getValue());
import org.apache.logging.log4j.LogManager;
        final long sizeInBytes = INDICES_FIELDDATA_CACHE_SIZE_KEY.get(settings).getBytes();
            // cache-scan cleanup: a reader closes only once, and exact-key invalidation is O(1),
 *    http://www.apache.org/licenses/LICENSE-2.0
        // replaced (e.g. after reallocation). Without this check, the replacement shard would be
            Index index,
    /**
        /**
        }
 */
 * ownership. Elasticsearch licenses this file to you under
        final Listener nodeListener;
            }
            if (o == null || getClass() != o.getClass()) return false;
        public boolean equals(Object o) {
 */
                cacheHelper.addClosedListener(IndexFieldCache.this);
                    logger.error("Failed to call listener on field data loading", e);
                    }
/*
     */
     * The size after which the cache will begin to evict entries.
        }
        }
            if (this == o) return true;
            logger.error("Failed to call node-level listener on field data cache unloading", e);
import org.opensearch.core.index.shard.ShardId;
 * not use this file except in compliance with the License.
        if (sizeInBytes > 0) {
        return new IndexFieldCache(logger, this, index, fieldName, shardIdentityResolver, indicesFieldDataCacheListener, listener);
    private static final Logger logger = LogManager.getLogger(IndicesFieldDataCache.class);
         * Per-shard listeners (e.g. {@link org.opensearch.index.fielddata.ShardFieldData}). Skipped
            final Key key = new Key(this, cacheHelper.getKey(), shardId, shardIdentity);
        ClusterService clusterService,
                } catch (Exception e) {
import org.apache.logging.log4j.Logger;
                        removeKey(key);
            // noinspection unchecked
        @Override
            }
            final Accountable accountable = nodeLevelCache.getCache().computeIfAbsent(key, k -> {
public class IndicesFieldDataCache implements RemovalListener<IndicesFieldDataCache.Key, Accountable>, Releasable {
     * reallocation (#20363).
            return (IFD) accountable;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            // Do it asynchronously to avoid blocking cluster applier thread
     */
 * software distributed under the License is distributed on an
    public IndicesFieldDataCache(
import org.apache.lucene.index.LeafReaderContext;
import java.util.HashMap;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.threadpool.ThreadPool;
        @Override
 * Licensed to Elasticsearch under one or more contributor
     *
            Logger logger,
            Listener... perShardListeners
    private final IndexFieldDataCache.Listener indicesFieldDataCacheListener;
                }
    }
                cache.refresh();
        }
         */
            if (!readerKey.equals(key.readerKey)) return false;
    ) {
     */
import org.opensearch.common.Nullable;
            Map<Index, Set<String>> fieldsToClearCopy = new HashMap<>();
            if (!indexCache.equals(key.indexCache)) return false;
                for (Key key : getCache().keysSnapshot()) {
import org.opensearch.common.settings.Setting.Property;
 *
/*
     * Computes a weight based on ramBytesUsed
         */
import org.opensearch.common.cache.RemovalReason;
                    }
     * current shard's identity at removal time to skip stale per-shard decrements after shard
                if (fieldsForIndex != null) {
 * the Apache License, Version 2.0 (the "License"); you may
                OpenSearchDirectoryReader.addReaderCloseListener(indexReader, IndexFieldCache.this);
}
            nodeLevelCache.clear(index, fieldName);
        MAX_SIZE_PERCENTAGE.toString(),
    public IndexFieldDataCache buildIndexFieldDataCache(IndexFieldDataCache.Listener listener, Index index, String fieldName) {
        long oldMaximumWeight = cache.getMaximumWeight();
            this.readerKey = readerKey;
    }
            }
         * independent of which shard they were charged to.
            }
            int weight = (int) Math.min(ramUsage.ramBytesUsed(), Integer.MAX_VALUE);
            });
            clusterService.getClusterSettings().addSettingsUpdateConsumer(INDICES_FIELDDATA_CACHE_SIZE_KEY, this::updateMaximumWeight);
    public static class FieldDataWeigher implements ToLongBiFunction<Key, Accountable> {
    @PublicApi(since = "1.0.0")
        @Override
                // invalidating a key that was concurrently removed is a no-op.
        public <FD extends LeafFieldData, IFD extends IndexFieldData.Global<FD>> IFD load(
        ToIntFunction<ShardId> shardIdentityResolver
         * on removal regardless of shard identity, since its accounting tracks node-wide bytes
        }
import org.opensearch.index.fielddata.LeafFieldData;
                // LRU list without holding the LRU lock, so a concurrent cache hit relinking the current entry to
import org.opensearch.common.cache.CacheBuilder;
            // Evict entries if needed, if the new size is smaller than the old.
        final Index index;
    public static final Setting<ByteSizeValue> INDICES_FIELDDATA_CACHE_SIZE_KEY = Setting.memorySizeSetting(
            return result;
        }
         */
        @Override
            synchronized (this) {
        try {
        // Per-shard listeners are skipped if the shard that originally cached this entry has been
        }
                notifyOnCache(shardId, fieldData);
            invalidateKey(key);
    public void onRemoval(RemovalNotification<Key, Accountable> notification) {
        }
    public IndexFieldDataCache buildIndexFieldDataCache(
     * A specific cache instance for the relevant parameters of it (index, fieldNames, fieldType).
import java.util.List;
     * @param index The index to clear
    public void clear(Index index, String field) {
        IndexFieldDataCache.Listener indicesFieldDataCacheListener,
 *
        public void clear(String fieldName) {
import java.util.concurrent.ConcurrentHashMap;
         * shard's identity, to avoid stale decrements after shard reallocation.
            String fieldName,
import org.apache.lucene.index.IndexReader;
        indicesToClear.add(index);
 */
         * Sentinel meaning "no shard identity captured" — either tracking is disabled, the entry
import org.opensearch.index.fielddata.IndexFieldDataCache;
            this.shardIdentityResolver = shardIdentityResolver;
    }
     * @opensearch.internal
    }
         */
        private final Listener[] perShardListeners;
        @SuppressWarnings("unchecked")
        IndexFieldCache indexCache = key.indexCache;
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
            return (FD) accountable;
                final LeafFieldData fieldData = indexFieldData.loadDirect(context);
            this.nodeListener = nodeListener;
            } catch (Exception e) {
 * @opensearch.api
        fieldsOfIndex.add(field);
        ) {
    public void clear(Index index) {
            }
        getCache().invalidate(key);
     * Build a cache that captures shard identity at load time. {@code shardIdentityResolver}
            final int shardIdentity = shardId == null ? Key.NO_SHARD_IDENTITY : shardIdentityResolver.applyAsInt(shardId);
     *
        @Override
            this.perShardListeners = perShardListeners;
        ) throws Exception {
            }
                // Iterate a point-in-time copy of the keys rather than Cache.keys(): the live iterator walks the
        @Override
    @Override
            final IFD indexFieldData
    }
        final Accountable value = notification.getValue();
        IndexFieldCache(
                }
            final int shardIdentity = shardId == null ? Key.NO_SHARD_IDENTITY : shardIdentityResolver.applyAsInt(shardId);
            // noinspection unchecked
         * reallocation (#20363). Not part of equals/hashCode.
 * this file be licensed under the Apache-2.0 license or a
        // Node-level listener (e.g. circuit breaker) must always fire — its accounting is
    void invalidateKey(Key key) {
                Collections.addAll(k.listeners, perShardListeners);
 * specific language governing permissions and limitations
            // remove this way instead of clearing all, in case a new entry has been marked since copying
    }
    }
            this.indexCache = indexCache;
            return true;
            : indexCache.shardIdentityResolver.applyAsInt(key.shardId);
    }
         * as "always allow per-shard listeners through". Chosen as -1 because
                listener.onRemoval(key.shardId, indexCache.fieldName, wasEvicted, sizeInBytes);
        if (threadPool == null) {
     * @param field The field to clear
        cache = cacheBuilder.build();
                notifyOnCache(shardId, ifd);
        cache.setMaximumWeight(newMaximumWeight.getBytes());
            Key key = (Key) o;
     */
import java.io.IOException;
import org.apache.lucene.util.Accountable;
            if (threadPool != null) {
         * predates identity capture, or the shard was unresolvable at load time. The staleness
                k.listeners.add(nodeListener);
            // This method must work to support the interface, but we don't use it directly in the actual cache clear path
import org.apache.lucene.index.DirectoryReader;
        Set<String> fieldsOfIndex = fieldsToClear.computeIfAbsent(index, (idx) -> { return ConcurrentCollections.newConcurrentSet(); });
                final Accountable ifd = (Accountable) indexFieldData.loadGlobalDirect(indexReader);
    /**
        this.indicesFieldDataCacheListener = indicesFieldDataCacheListener;
import java.util.function.ToLongBiFunction;
            Listener nodeListener,
        ThreadPool threadPool
import java.util.function.ToIntFunction;
                throw new IllegalArgumentException("Reader " + context.reader() + " does not support caching");
import org.opensearch.index.fielddata.IndexFieldData;
            logger.warn("Exception occurred while removing key from cache", e);
            // in case new entries are marked for cleanup mid-iteration
        Property.NodeScope,
            // Don't call cache.refresh() here as it would have bad performance implications.
 * The field data cache for multiple indices
        Key(IndexFieldCache indexCache, IndexReader.CacheKey readerKey, @Nullable ShardId shardId, int shardIdentity) {
        assert key != null;
     * Mark all keys in the node-level cache which match the given index and field for cleanup.
                    if (indicesToClearCopy.contains(key.indexCache.index)) {
        public final int shardIdentity;
                    if (fieldsOfIndexToClear != null && fieldsOfIndexToClear.contains(key.indexCache.fieldName)) {
            indicesToClear.removeAll(indicesToClearCopy);
import java.util.Map;
            this.fieldName = fieldName;
                // skipped here would stay unreclaimed indefinitely. The snapshot is immune to LRU reordering, and
            try {
        public void clear() {
            final Accountable accountable = nodeLevelCache.getCache().computeIfAbsent(key, k -> {
                "IndicesFieldDataCache ctor got null clusterService argument! Cluster setting updates for cache size will not work!"
        cache.invalidateAll();
    /**
        }
    @Override
        final ToIntFunction<ShardId> shardIdentityResolver;
            this.shardId = shardId;
        }
        return buildIndexFieldDataCache(listener, index, fieldName, shardId -> Key.NO_SHARD_IDENTITY);
            final IndexReader.CacheHelper cacheHelper = context.reader().getCoreCacheHelper();
        public int hashCode() {
            this.shardIdentity = shardIdentity;
                        continue;
 * The OpenSearch Contributors require contributions made to
/**
                return ifd;
        private void notifyOnCache(ShardId shardId, Accountable accountable) {
        try {
            nodeLevelCache.getCache().invalidate(new Key(this, key, null));
            logger.warn("IndicesFieldDataCache ctor got null threadPool! Evictions on cache resize will happen on cluster applier thread!");
        public long applyAsLong(Key key, Accountable ramUsage) {
         * check in {@link IndicesFieldDataCache#onRemoval(RemovalNotification)} treats this value
