        OpenSearchDirectoryReader.DelegatingCacheHelper delegatingCacheHelper = (OpenSearchDirectoryReader.DelegatingCacheHelper) reader
                            + stalenessThreshold
        return cache.stats(levels);
            public void run() {
        DirectoryReader reader,
 * Licensed to Elasticsearch under one or more contributor
            this.cacheCleaner.close();
                    this.cacheCleanupManager.cleanCache();
     * <p>This method checks if the provided staleness threshold is a valid percentage or a valid double value.
     * Validates the staleness setting for the cache cleanup threshold.
import java.util.Set;
                this.interval = interval;
                    return readerCacheKeyMap;
    @Override
        String indexDimensionValue = getIndexDimensionName(key);
            if (!shardId.equals(key.shardId)) return false;
            result = 31 * result + Objects.hashCode(readerCacheKeyId);
        // shards as part of request cache.
         */
                    }
        public boolean isLoaded() {
                    countMap.computeIfPresent(cleanupKey.readerCacheKeyId, (readerCacheKey, count) -> {
         * Hence we decrement {@link #staleKeysCount} if we do not find the shardId or readerCacheKeyId in the map.
            cleanupKeyToCountMap.computeIfAbsent(shardId, k -> new ConcurrentHashMap<>()).merge(readerCacheKeyId, 1, Integer::sum);
     *
import java.util.Objects;
                    Integer count = readerCacheKeyMap.get(cleanupKey.readerCacheKeyId);
 * <p>
         */
            if (cleanupKey.entity == null) {
        private void forceCleanCache() {
        } catch (OpenSearchParseException e) {
         * <p>
                    staleKeysCount.addAndGet(totalSum);
    private double getStalenessThreshold(Settings settings) {
            }
                return;
        private synchronized void cleanCache(double stalenessThreshold) {
        /**
        }
    );
            this.readerCacheKeyId = Objects.requireNonNull(readerCacheKeyId);
            // If the key exists, its value is incremented by 1.
    ) {
 * are no longer used or closed shards.
            }
                    // Set took time to -1, which will always be rejected by the policy.
     * Fundamentally non-cacheable queries like DFS queries, queries using the `now` keyword, and
     * @param cacheKey the cache key to invalidate
        Property.NodeScope
        private synchronized boolean canSkipCacheCleanup(double cleanThresholdPercent) {
        CacheConfig<Key, BytesReference> config = getCacheConfig(settings, nodeEnvironment);
    }
 * this file be licensed under the Apache-2.0 license or a
    // pkg-private for testing
     * Returns the current cache stats. Pkg-private for testing.
            }
            if (indexShard == null) {
     * @param staleThreshold The staleness threshold to validate.
         * Called each time this entity has a cache hit.
     *
        }
         * Updates the cleanupKeyToCountMap with the given CleanupKey.
        this.cacheCleanupManager.updateStalenessThreshold(RatioValue.parseRatioValue(threshold).getAsRatio());
                if (cleanupKeysFromFullClean.contains(shardIdInfo) || cleanupKeysFromClosedShards.contains(shardIdInfo)) {
/**
     *
import java.util.Collections;
     * A setting to enable or disable request caching on an index level. Its dynamic by default
            incrementStaleKeysCount(cleanupKey);
        this.clusterService.getClusterSettings()
         * Returns <code>true</code> iff the resource behind this entity is still open ie.
            cleanupKeyToCountMap.compute(shardId, (key, readerCacheKeyMap) -> {
            if (!entity.getCacheIdentity().equals(that.entity.getCacheIdentity())) return false;
        }
/*
    }
         * <p>It increments the staleKeysCount by the count of the CleanupKey in the cleanupKeyToCountMap.
                logger.warn("IndexShard is null for CleanupKey: {}", cleanupKey.readerCacheKeyId);
    private class CleanupKey implements IndexReader.ClosedListener {
                        if (cleanupKeysFromOutdatedReaders.contains(cleanupKey)) {
}
            if (key.indexShardHashCode == System.identityHashCode(indexShardCacheEntity.getCacheIdentity())) {
 * license agreements. See the NOTICE file distributed with
        // package private for testing
        this.expire = INDICES_CACHE_QUERY_EXPIRE.exists(settings) ? INDICES_CACHE_QUERY_EXPIRE.get(settings) : null;
 *
         * Called after the value was loaded.
            if (!Objects.equals(readerCacheKeyId, key.readerCacheKeyId)) return false;
         * Therefore, to avoid modifying CacheEntity and IndexShard classes to override these methods, we use ShardID as the key.
                if (previous == null) {
    long count() {
        OpenSearchDirectoryReader.DelegatingCacheHelper delegatingCacheHelper = (OpenSearchDirectoryReader.DelegatingCacheHelper) reader
         * @return The percentage of stale keys in the cache as a double. Returns 0 if there are no keys in the cache or no stale keys.
     * If Staleness threshold is 0, we do not keep track of stale keys in the cache
                return;
import org.opensearch.threadpool.ThreadPool;
            // cache until size-based eviction reaches it. Remove matches with exact-key invalidate() rather
            return result;
            .setRemovalListener(this)
/*
     * Deprecated; once pluggable caching is no longer behind a feature flag (likely in 2.19), this setting will no longer have any effect.
    ImmutableCacheStatsHolder stats(String[] levels) {
            this.entity = entity;
 * You may obtain a copy of the License at
                    return readerCacheKeyMap.isEmpty() ? null : readerCacheKeyMap;
        return staleThreshold;
        private boolean loaded;
        /**
         *
            // Contains CleanupKey objects with open shard but invalidated readerCacheKeyId.
    /*
import org.opensearch.common.cache.policy.CachedQueryResult;
        }
            return ((double) staleKeysCount.get() / totalKeysInCache);
                return 0;
     * @throws OpenSearchParseException If the staleness threshold is not a valid percentage or double value.
            if (this == o) return true;
                        return null;
import org.opensearch.common.lease.Releasable;
            this.cacheCleaner = new IndicesRequestCacheCleaner(this, threadpool, cleanInterval);
 *
            this.indexShardHashCode = indexShardHashCode;
 * this work for additional information regarding copyright
            if (o == null || getClass() != o.getClass()) {
        IndicesRequestCacheCleanupManager(ThreadPool threadpool, TimeValue cleanInterval, double stalenessThreshold) {
        Key(ShardId shardId, BytesReference value, String readerCacheKeyId, int indexShardHashCode) {
            private final IndicesRequestCacheCleanupManager cacheCleanupManager;
            this.stalenessThreshold = stalenessThreshold;
     */
        }
         * Enqueue cleanup key.
     * Returns the current size of the cache
                    // Return the current map
        "index.requests.cache.enable",
        }
            configBuilder.setMaxSizeInBytes(sizeInBytes);
         */
        void onMiss();
         * @param cleanupKey the CleanupKey that has been marked for cleanup
import java.util.function.Function;
            .setCachedResultParser((bytesReference) -> {
                    // null indicates full cleanup
    public static final String INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY =
            if (logger.isDebugEnabled()) {
        return cache.count();
 *    http://www.apache.org/licenses/LICENSE-2.0
                return;
         * Calculates and returns the percentage of stale keys in the cache.
        @Override
         */
    public static final Setting<ByteSizeValue> INDICES_CACHE_QUERY_SIZE = Setting.memorySizeSetting(
                }
            double oldStalenessThreshold = this.stalenessThreshold;
import org.opensearch.common.unit.RatioValue;
    BytesReference getOrCompute(
                    int totalSum = countMap.values().stream().mapToInt(Integer::intValue).sum();
            ShardId shardId = indexShard.shardId();
                logger.debug(
            this.shardId = shardId;
            this.cleanupKeyToCountMap = new ConcurrentHashMap<>();
        IndexShard indexShard = (IndexShard) cacheEntity.getCacheIdentity();
                closed.compareAndSet(false, true);
 * SPDX-License-Identifier: Apache-2.0
         * Force Clean cache without checking stalenessThreshold
                try {
                // Invalidate a dummy key containing the dimensions we need to drop stats for
         * by the total count of keys associated with the CleanupKey's ShardId in the cleanupKeyToCountMap and removes the ShardId from the map.
 * Unless required by applicable law or agreed to in writing,
    );
         *
            cleanupKeyToCountMap.computeIfPresent(shardId, (currentShardId, countMap) -> {
    private final TimeValue expire;
                        // If cache entity is null, it means that index or shard got deleted/closed meanwhile.
        public int hashCode() {
    ) throws Exception {
            }
        "1%",
                    // Update staleKeysCount based on specific readerCacheKeyId, then remove it from the countMap
                            cache.invalidate(key);
import org.opensearch.index.shard.IndexShard;
                if (cleanupKey.readerCacheKeyId == null) {
     * Unique key for the cache
                    if (cacheEntity == null) {
            throw e;
        long sizeInBytes = INDICES_CACHE_QUERY_SIZE.get(settings).getBytes();
                    } else {
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
import org.opensearch.core.common.io.stream.StreamOutput;
        Property.NodeScope,
    }
    private static class Loader implements LoadAwareCacheLoader<ICacheKey<Key>, BytesReference> {
import java.util.Optional;
        this.cacheCleanupManager = new IndicesRequestCacheCleanupManager(
         * <p>If the percentage of stale keys is less than the provided staleness threshold returns true,
        // hashcode(default) to identify the older indexShard but with same shardId.
            return BASE_RAM_BYTES_USED + shardId.getBaseRamBytesUsed() + value.length();
                    CacheEntity cacheEntity = cacheEntityLookup.apply(delegatingKey.shardId).orElse(null);
import org.apache.logging.log4j.Logger;
     * Default value of 0 only allows size == 0 queries, matching earlier behavior.
            if (o == null || getClass() != o.getClass()) return false;
import java.util.HashSet;
import java.io.IOException;
        ).orElse(null);
import org.opensearch.core.index.shard.ShardId;
        Settings settings,
        this.cache = cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE);
    private final ClusterService clusterService;
            }
        ThreadPool threadPool,
                    // Add both shardId and indexShardHashCode to uniquely identify an indexShard.
     *
    int numRegisteredCloseListeners() { // for testing
    private String getIndexDimensionName(Key key) {
        Function<ShardId, Optional<CacheEntity>> cacheEntityFunction,
         */
    IndicesRequestCache(
        }
        }
        }
        return key.shardId.getIndexName();
        @Override
    }
         * For instance IndexShard is the identity while a CacheEntity is per DirectoryReader. Yet, we group by IndexShard instance.
                return;
        }
         *
        10_000,
         */
                // Return the modified countMap to retain updates
        CleanupKey cleanupKey = new CleanupKey(indexShardCacheEntity, key.readerCacheKeyId);
        /**
        }
        final CacheEntity entity;
                iterator.remove();
     * @param cacheEntity the cache entity to invalidate for
        private final ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap;
            IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
            if (indexShard == null) {
        private void incrementStaleKeysCount(CleanupKey cleanupKey) {
    }
        Loader(CacheEntity entity, CheckedSupplier<BytesReference, IOException> loader) {
         * The method increments the count of the CleanupKey in the map.
                }
    public static final Setting<TimeValue> INDICES_CACHE_QUERY_EXPIRE = Setting.positiveTimeSetting(
        /**
import java.util.Collection;
                    }
            this.staleKeysCount = new AtomicInteger(0);
         */
                if (cleanupKey.readerCacheKeyId == null) {
                    cleanupKeysFromClosedShards.add(new Tuple<>(indexShard.shardId(), indexShard.hashCode()));
    }
            return result;
        private CleanupKey(CacheEntity entity, String readerCacheKeyId) {
            for (List<String> closedDimensions : dimensionListsToDrop) {
            if (!registeredClosedListeners.containsKey(cleanupKey)) {
 * is functional.
 * compatible open source license.
            getStalenessThreshold(settings)
            if (cleanupKey.entity == null) {
                return;
            if (cleanupKey.entity == null) {
         * @param cleanupKey   the CleanupKey that has been evicted from the cache
        return key.shardId.toString();
        // In case this event happens for an old shard, we can safely ignore this as we don't keep track for old
            // see if it's the first time we see this reader, and make sure to register a cleanup key
        }
    }
        } else {
        /**
    /**
 * level setting that can be dynamically changed and defaults to false.
        }
 * eviction to evict old reader associated cache entries as well as scheduler reaper to clean readers that
     * @return The validated staleness threshold.
        assert reader.getReaderCacheHelper() instanceof OpenSearchDirectoryReader.DelegatingCacheHelper;
        /**
        BytesReference cacheKey
import org.opensearch.common.settings.Settings;
        @Override
    }
            if (wasRegistered != null) {
            result = 31 * result + value.hashCode();
    /**
        new TimeValue(0),
 */
            .setDimensionNames(List.of(INDEX_DIMENSION_NAME, SHARD_ID_DIMENSION_NAME))
/*
        return RatioValue.parseRatioValue(threshold).getAsRatio();
        void onCached(ICacheKey<Key> key, BytesReference value);
    static class Key implements Accountable, Writeable {
                cache.invalidate(dummyKey);
                        // Remove the readerCacheKeyId entry if new count is zero
        }
        /**
        IndicesService.IndexShardCacheEntity cacheEntity,
            Boolean wasRegistered = registeredClosedListeners.remove(this);
                if (cleanupKeysFromClosedShards.contains(shardIdInfo)) {
     */
            if (logger.isDebugEnabled()) {
        public final ShardId shardId; // use as identity equality
         * @param cleanupKey the cleanup key
                    oldStalenessThreshold
     * which is used to determine when the cache should be cleaned.
         * CacheEntity mainly contains IndexShard, both of these classes do not override equals() and hashCode() methods.
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                        // So we will delete this key.
        cacheCleanupManager.enqueueCleanupKey(new CleanupKey(entity, null));
import org.apache.lucene.index.IndexReader;
        }
    }
                        dimensionListsToDrop.add(key.dimensions);
        String threshold = INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.get(settings);
        @Override
                    "Staleness threshold for indices request cache changed to {} from {}",
                        // Return null to remove the key after updating staleKeysCount
        void cleanCache() {
        0,
            return cleanupKeyToCountMap;
import org.opensearch.common.cache.ICache;
                    );
     * This refers to the number of documents returned, not the size in bytes.
        Key(StreamInput in) throws IOException {
                        // Update the map with the new count
            }
    private final static long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(Key.class);
        }
         *
                }
        private synchronized double staleKeysInCachePercentage() {
 * GitHub history for details.
                    if (newCount > 0) {
        true,
    public static final Setting<Boolean> INDEX_CACHE_REQUEST_ENABLED_SETTING = Setting.boolSetting(
        void onRemoval(RemovalNotification<ICacheKey<Key>, BytesReference> notification);
                } else {
                    cleanupKeysFromFullClean.add(new Tuple<>(indexShard.shardId(), indexShard.hashCode()));
            cleanCache(0);
         * <p>If the percentage of stale keys in the cache is less than this threshold,the cache cleanup process is skipped.
            final Set<Tuple<ShardId, Integer>> cleanupKeysFromFullClean = new HashSet<>();
        /**
        cacheCleanupManager.forceCleanCache();
         * Called each time this entity has a cache miss.
    private ICacheKey<Key> getICacheKey(Key key) {
        IndicesRequestCache::validateStalenessSetting,
 *
import org.opensearch.common.settings.Setting;
                } else if (!cleanupKey.entity.isOpen()) {
        "indices.requests.cache.expire",
            // If the key doesn't exist, it's added with a value of 1.
                        staleKeysCount.addAndGet(count);
import java.util.function.ToLongBiFunction;
        }
         */
         *
            result = 31 * result + indexShardHashCode;
            this.shardId = in.readOptionalWriteable(ShardId::new);
            }
        cache.invalidateAll();
                if (closed.get() == false) {
            threadPool,
            .setExpireAfterAccess(expire) // for backward compatibility
            cache.refresh();
    }
            .getReaderCacheHelper();
     * @param reader the reader to invalidate the cache entry for
        Key key = notification.getKey().key;
import org.opensearch.common.cache.serializer.BytesReferenceSerializer;
 * KIND, either express or implied.  See the License for the
        public void onClose(IndexReader.CacheKey cacheKey) {
import org.opensearch.env.NodeEnvironment;
                }
            }
     * If pluggable caching is off, or pluggable caching is on but a store name isn't specified, this setting determines the cache size.
        IndicesService.IndexShardCacheEntity indexShardCacheEntity = (IndicesService.IndexShardCacheEntity) cacheEntityLookup.apply(
            }
import org.apache.lucene.index.DirectoryReader;
        private volatile double stalenessThreshold;
         * @return true if the cache cleanup process can be skipped, false otherwise.
    }
import org.opensearch.common.cache.ICacheKey;
        /**
                    // Since the shard is closed, the cache should drop stats for this shard.
    );
                // Reschedule itself to run again if not closed
    void invalidate(IndicesService.IndexShardCacheEntity cacheEntity, DirectoryReader reader, BytesReference cacheKey) {
    public static final String INDEX_DIMENSION_NAME = "indices";
        }
        "indices.requests.cache.cleanup.staleness_threshold";
            ShardId shardId = indexShard.shardId();
import org.opensearch.common.cache.service.CacheService;
            return staleKeysCount;
                Tuple<ShardId, Integer> shardIdInfo = new Tuple<>(delegatingKey.shardId, delegatingKey.indexShardHashCode);
                            + " is less than the threshold : "
     * @opensearch.internal
        }
            }
        public long ramBytesUsed() {
        try {
            this.keysToClean = ConcurrentCollections.newConcurrentSet();
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            cacheCleanupManager.updateStaleCountOnCacheInsert(cleanupKey);
    /**
            if (notification.getRemovalReason() == RemovalReason.REPLACED) {
import java.io.Closeable;
         * Returns the cache identity. this is, similar to {@link #isOpen()} the resource identity behind this cache entity.
                CleanupKey cleanupKey = iterator.next();
            this.readerCacheKeyId = in.readOptionalString();
            out.writeOptionalWriteable(shardId);
            // key as part of tiered/disk cache. The key is not passed between nodes at this point.
        Property.Dynamic,
         */
            final Set<Tuple<ShardId, Integer>> cleanupKeysFromClosedShards = new HashSet<>();
        CacheConfig.Builder<Key, BytesReference> configBuilder = new CacheConfig.Builder<Key, BytesReference>().setSettings(settings)
        Property.Dynamic,
    final IndicesRequestCacheCleanupManager cacheCleanupManager;
         * We consider all removal notifications except with the reason Replaced
            this.indexShardHashCode = in.readInt(); // We are serializing/de-serializing this as we need to store the
                    // Reduce the count by 1
        // indexShard but in case where the same indexShard is deleted and reallocated on same node, we need the
    class IndicesRequestCacheCleanupManager implements Closeable {
            }
import org.opensearch.core.common.io.stream.Writeable;
    void invalidateAll() {
            if (this == o) return true;
        ) {
                    staleKeysCount.decrementAndGet();
     * <p>package private for testing
        @Override
            CleanupKey cleanupKey = new CleanupKey(cacheEntity, readerCacheKeyId);
        boolean isOpen();
            }
     * It also keeps track of the number of stale keys in the cache (staleKeysCount) and a staleness threshold,
        public final BytesReference value;
        @Override
        "0%",
                    }
                logger.warn("IndexShard is null for CleanupKey: {} while cleaning Indices Request Cache", cleanupKey.readerCacheKeyId);
                }
                        CleanupKey cleanupKey = new CleanupKey(cacheEntity, delegatingKey.readerCacheKeyId);
            this.value = value;
     */
                    return new CachedQueryResult.PolicyValues(-1);
            result = 31 * result + readerCacheKeyId.hashCode();
    public static final Setting<Integer> INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING = Setting.intSetting(
    public static final Setting<TimeValue> INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING = Setting.positiveTimeSetting(
            }
    public void close() throws IOException {
                staleKeysCount.decrementAndGet();
 * <p>
import org.opensearch.core.common.bytes.BytesReference;
    }
                }
            // Remove the current CleanupKey from the registeredClosedListeners map
        public boolean equals(Object o) {
         * ShardID class properly overrides equals() and hashCode() methods.
                return false;
        return configBuilder.build();
                } else {
            return this.loaded;
         * @param notification RemovalNotification of the cache entry evicted
    );
    public static final String INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY = "indices.requests.cache.cleanup.interval";
                return true;
import org.apache.lucene.util.RamUsageEstimator;
        Property.Dynamic
            // removal (see OpenSearchOnHeapCache#keys()); invalidating a concurrently removed key is a no-op.
            // Here we match the hashcode to avoid scenario where we deduct stats of older IndexShard(with same
            return value;
        cache.invalidate(getICacheKey(new Key(indexShard.shardId(), cacheKey, readerCacheKeyId, System.identityHashCode(indexShard))));
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        public boolean equals(Object o) {
            threadpool.schedule(cacheCleaner, cleanInterval, ThreadPool.Names.SAME);
                    // If it is in the map, it is not stale yet.
            .setKeySerializer(new IRCKeyWriteableSerializer())
        List<String> dimensions = List.of(indexDimensionValue, shardIdDimensionValue);
        if (indexShardCacheEntity != null) {
package org.opensearch.indices;
 * Modifications Copyright OpenSearch Contributors. See
     * Sets the maximum size of a query which is allowed in the request cache.
    CacheConfig<Key, BytesReference> getCacheConfig(Settings settings, NodeEnvironment nodeEnvironment) {
import org.opensearch.common.cache.LoadAwareCacheLoader;
 * software distributed under the License is distributed on an
        // Pass a new removal notification containing Key rather than ICacheKey<Key> to the CacheEntity for backwards compatibility.
            // The cleanup marks are consumed above before this scan, so a key skipped here would stay in the
         * If the ShardId associated with the CleanupKey does not exist in the map, a new entry is created.
                indexShardCacheEntity.onRemoval(notification);
import org.opensearch.common.cache.CacheType;
        if (!CacheService.storeNamePresent(CacheType.INDICES_REQUEST_CACHE, settings)) {
                // entity will only be null when the shard is closed/deleted
        Property.NodeScope
         * Clean cache based on stalenessThreshold
    private final ICache<Key, BytesReference> cache;
        "indices.requests.cache.maximum_cacheable_size",
    }
        this.clusterService = clusterService;
 * not use this file except in compliance with the License.
                    // Return null to automatically remove the mapping for shardId
                    OpenSearchDirectoryReader.addReaderCloseListener(reader, cleanupKey);
            for (ICacheKey<Key> key : cache.keys()) {
 * ownership. Elasticsearch licenses this file to you under
            .setClusterSettings(clusterService.getClusterSettings())
                    cache.invalidate(key);
 */
import org.opensearch.common.cache.RemovalReason;
        );
    private final ConcurrentMap<CleanupKey, Boolean> registeredClosedListeners = ConcurrentCollections.newConcurrentMap();
            .getReaderCacheHelper();
                return;
                return countMap;
     * scroll requests are never cached, regardless of this setting.
         *
    final Function<ShardId, Optional<CacheEntity>> cacheEntityLookup;
            keysToClean.add(cleanupKey);
import org.opensearch.common.CheckedSupplier;
            }
     */
        INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
            }
        /**
        }
                logger.warn("IndexShard is null for CleanupKey: {} while cleaning Indices Request Cache", cleanupKey.readerCacheKeyId);
                    // The shard is closed
            entity.onCached(key, value);
        /**
    /**
         */
        }
     *
    interface CacheEntity extends Accountable {
            final Set<CleanupKey> cleanupKeysFromOutdatedReaders = new HashSet<>();
 *
                    threadPool.scheduleUnlessShuttingDown(interval, ThreadPool.Names.SAME, this);
            @Override
                        // Returning null removes the entry for shardId
        /**
                    logger.warn("Exception during periodic indices request cache cleanup:", e);
            CleanupKey that = (CleanupKey) o;
         */
        cache.close();
         * Handles the eviction of a cache entry.
         * Updates the count of stale keys in the cache.
    /**
                    this.stalenessThreshold,
 * under the License.
        BytesReference value = cache.computeIfAbsent(getICacheKey(key), cacheLoader);
        private final Set<CleanupKey> keysToClean;
                return;
                dummyKey.setDropStatsForDimensions(true);
            if (cleanThresholdPercent == 0.0) {
                    // Proceed to adjust the count for the readerCacheKeyId in the map
            if (!Objects.equals(readerCacheKeyId, that.readerCacheKeyId)) return false;
                    // This should not happen on a full cache cleanup.
     * The IndicesRequestCacheCleanupManager manages the cleanup of stale keys in IndicesRequestCache.
            .setStoragePath(nodeEnvironment.nodePaths()[0].path.toString() + "/request_cache");
        CheckedSupplier<BytesReference, IOException> loader,
import org.opensearch.common.cache.RemovalNotification;
        final String readerCacheKeyId;
    /**
            double staleKeysInCachePercentage = staleKeysInCachePercentage();
    }
            // Contains CleanupKey objects for a full cache cleanup.
            this.stalenessThreshold = stalenessThreshold;
                // we would have accounted this in staleKeysCount when the closing/deletion of shard would have closed the associated
         * Why use ShardID as the key ?
        public void close() {
     * Loader for the request cache
        final Key key = new Key(indexShard.shardId(), cacheKey, readerCacheKeyId, System.identityHashCode(indexShard));
        assert readerCacheKeyId != null;
            // If a store name is present, cache implementations instead determine their own sizes based on their own implementation
                    if (countMap.isEmpty()) {
            long totalKeysInCache = count();
         * This method is called when a CleanupKey is added to the keysToClean set.
                    } else {
            public void close() {
         * entities associated with it can remain in the cache. ie. IndexShard is still open.
        }
    }
        }
        INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY,
        String shardIdDimensionValue = getShardIdDimensionName(key);
            INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING.get(settings),
                }
                    });
        public int hashCode() {
        Property.NodeScope
import org.opensearch.common.cache.store.config.CacheConfig;
    /**
    }
     */
     * */
         * indicating that the cache cleanup process can be skipped.
                // readers
            IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
                } else {
        cacheCleanupManager.updateStaleCountOnEntryRemoval(cleanupKey, notification);
                        return null;
        }
            return true;
 * @opensearch.internal
            return Collections.emptyList();
        @Override
            private final TimeValue interval;
     */
         */
        String readerCacheKeyId = delegatingCacheHelper.getDelegatingCacheKey().getId();
            cleanCache(stalenessThreshold);
            loaded = true;
        void addToCleanupKeyToCountMap(ShardId shardId, String readerCacheKeyId) {
         * Skip decrementing staleKeysCount if we find the shardId or readerCacheKeyId in the map since it would have not been accounted for in the staleKeysCount in
import org.opensearch.cluster.service.ClusterService;
    /**
     * Otherwise, the implementation-specific size setting like indices.requests.cache.opensearch_onheap.size is used instead.
            int result = shardId.hashCode();
            return false;
import org.opensearch.core.common.unit.ByteSizeValue;
    static String validateStalenessSetting(String staleThreshold) {
        String readerCacheKeyId = delegatingCacheHelper.getDelegatingCacheKey().getId();
        }
                    // If ShardId is not present or readerCacheKeyId is not present
         */
                        }
        cache.invalidateAll();
            if (indexShardHashCode != key.indexShardHashCode) return false;
            // size settings.
        NodeEnvironment nodeEnvironment
            if (staleKeysInCachePercentage < cleanThresholdPercent) {
            // TODO: more detailed ram usage?
import org.opensearch.common.cache.RemovalListener;
import java.util.List;
            .setValueSerializer(new BytesReferenceSerializer())
        @Override
            .setValueType(BytesReference.class)
        INDICES_CACHE_CLEAN_INTERVAL_SETTING,
 */
                    // but do not decrement the staleKeysCount
        ToLongBiFunction<ICacheKey<Key>, BytesReference> weigher = (k, v) -> k.ramBytesUsed(k.key.ramBytesUsed()) + v.ramBytesUsed();
        public void writeTo(StreamOutput out) throws IOException {
         * @param stalenessThreshold The staleness threshold as a double.
     * @opensearch.internal
            for (Iterator<CleanupKey> iterator = keysToClean.iterator(); iterator.hasNext();) {
        @Override
        assert reader.getReaderCacheHelper() != null;
    public static final String SHARD_ID_DIMENSION_NAME = "shards";
            IndicesRequestCacheCleaner(IndicesRequestCacheCleanupManager cacheCleanupManager, ThreadPool threadPool, TimeValue interval) {
    private String getShardIdDimensionName(Key key) {
        public BytesReference load(ICacheKey<Key> key) throws Exception {
            }
         * Called when this entity instance is removed
            }
import java.util.concurrent.atomic.AtomicBoolean;
                ICacheKey<Key> dummyKey = new ICacheKey<>(null, closedDimensions);
        this.cacheEntityLookup = cacheEntityFunction;
            if (cleanupKeysFromOutdatedReaders.isEmpty() && cleanupKeysFromFullClean.isEmpty() && cleanupKeysFromClosedShards.isEmpty()) {
        }
            });
        return value;
            // Contains CleanupKey objects for a closed shard.
        Property.IndexScope
            this.value = in.readBytesReference();
                return;
                try {
                Boolean previous = registeredClosedListeners.putIfAbsent(cleanupKey, Boolean.TRUE);
                // does not affect the staleness count, we skip such notifications.
    }
            addToCleanupKeyToCountMap(shardId, cleanupKey.readerCacheKeyId);
    public void onRemoval(RemovalNotification<ICacheKey<Key>, BytesReference> notification) {
        if (cacheLoader.isLoaded()) {
                logger.debug("Cleaning Indices Request Cache with threshold : " + stalenessThreshold);
            IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
            if (!value.equals(key.value)) return false;
        "indices.requests.cache.size",
    );
            ShardId shardId = indexShard.shardId();
        /**
    void clear(CacheEntity entity) {
 * Currently, the cache is only enabled for count requests, and can only be opted in on an index
    }
            out.writeBytesReference(value);
         *
            private final AtomicBoolean closed = new AtomicBoolean(false);
                if (readerCacheKeyMap == null || !readerCacheKeyMap.containsKey(cleanupKey.readerCacheKeyId)) {
        void enqueueCleanupKey(CleanupKey cleanupKey) {
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
 * There are still several TODOs left in this class, some easily addressable, some more complex, but the support
            }
            this.readerCacheKeyId = readerCacheKeyId;
        Object getCacheIdentity();
                    // so decrement staleKeysCount
         * Determines whether the cache cleanup process can be skipped based on the staleness threshold.
        public final String readerCacheKeyId;
         *
                        readerCacheKeyMap.remove(cleanupKey.readerCacheKeyId);
                // The reason of the notification is REPLACED when a cache entry's value is updated, since replacing an entry
            key.shardId
                    return null;
            }
import org.opensearch.common.settings.Setting.Property;
                        cache.invalidate(key);
        }
        private final class IndicesRequestCacheCleaner implements Runnable, Releasable {
    private static final Logger logger = LogManager.getLogger(IndicesRequestCache.class);
        void updateStalenessThreshold(double stalenessThreshold) {
                            + staleKeysInCachePercentage
            // shardId) from current IndexShard.
                Key delegatingKey = key.key;
        CacheService cacheService,
            return true;
            }
        }
 * The OpenSearch Contributors require contributions made to
            out.writeOptionalString(readerCacheKeyId);
import java.util.concurrent.ConcurrentHashMap;
            // than through the keys() iterator, which may be walking a point-in-time copy that does not support
    void setStalenessThreshold(String threshold) {
            .addSettingsUpdateConsumer(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING, this::setStalenessThreshold);
                    // this should never be null
            private final ThreadPool threadPool;
     * Basic interface to make this cache testable.
            cacheEntity.onHit();
    void forceCleanCache() {
        }
    }
        return registeredClosedListeners.size();
        // for testing
         *
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.collect.Tuple;
         */
            this.entity = entity;
    }
        }
         * <p>This method is called when an entry is evicted from the cache.
            }
            }
                    // it should have already been accounted for and hence been removed from this map
            // Using computeIfPresent to atomically operate on the countMap for a given shardId
         * @param cleanThresholdPercent The staleness threshold as a percentage.
public final class IndicesRequestCache implements RemovalListener<ICacheKey<IndicesRequestCache.Key>, BytesReference>, Closeable {
        0,
    // pkg-private for testing
                    return CachedQueryResult.getPolicyValues(bytesReference);
        IndexShard indexShard = ((IndexShard) cacheEntity.getCacheIdentity());
                    cleanupKeysFromOutdatedReaders.add(cleanupKey);
        private final AtomicInteger staleKeysCount;
            int result = entity.getCacheIdentity().hashCode();
                if (logger.isDebugEnabled()) {
        public final int indexShardHashCode; // While ShardId is usually sufficient to uniquely identify an
            RatioValue.parseRatioValue(staleThreshold);
        AtomicInteger getStaleKeysCount() {
                    dimensionListsToDrop.add(key.dimensions);
                    logger.debug(
            // If a store name is absent, use the max size based on the IRC setting into the config.
                final IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
            });
     */
    // pkg-private for testing
        Property.Deprecated
        cacheCleanupManager.close();
        }
     */
            .setKeyType(Key.class)
import java.util.concurrent.ConcurrentMap;
    }
        private void updateStaleCountOnEntryRemoval(
            })
        ClusterService clusterService,
            // If the key was present, enqueue it for cleanup
         * If the CleanupKey's readerCacheKeyId is null or the CleanupKey's entity is not open, it increments the staleKeysCount
    // These values determine the valid names for levels in the cache stats API
                );
        @Override
     * since we are checking on the cluster state IndexMetadata always.
        assert reader.getReaderCacheHelper() instanceof OpenSearchDirectoryReader.DelegatingCacheHelper;
     */
import org.opensearch.OpenSearchParseException;
         * Cleans the cache based on the provided staleness threshold.
        // pkg-private for testing
import org.opensearch.core.common.io.stream.StreamInput;
     * Invalidates the given the cache entry for the given key and it's context
                }
     */
 * similar requests that are potentially expensive (because of aggs for example). The cache is fully coherent
    }
    /**
        public Collection<Accountable> getChildResources() {
         * {@link #incrementStaleKeysCount} would have removed the entries from the map and increment the {@link #staleKeysCount}
                }
 * The indices request cache allows to cache a shard level request stage responses, helping with improving
                        "Skipping Indices Request cache cleanup since the percentage of stale keys : "
                return;
        Property.NodeScope,
            }
        }
            @Override
            if (canSkipCacheCleanup(stalenessThreshold)) {
                    // Aggregate and add to staleKeysCount atomically if readerCacheKeyId is null
            if (totalKeysInCache == 0 || staleKeysCount.get() == 0) {
import java.util.concurrent.atomic.AtomicInteger;
        private final CheckedSupplier<BytesReference, IOException> loader;
                } catch (Exception e) {
import java.util.Iterator;
                        readerCacheKeyMap.put(cleanupKey.readerCacheKeyId, newCount);
            Set<List<String>> dimensionListsToDrop = new HashSet<>();
                return false;
        }
                }
            }
            if (indexShard == null) {
        return new ICacheKey<>(key, dimensions);
                } else {
     *
    public static final Setting<String> INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING = new Setting<>(
    // pkg-private for testing
                this.cacheCleanupManager = cacheCleanupManager;
    );
         */
        void onHit();
        private final CacheEntity entity;
                    assert (count != null && count >= 0);
    // package private for testing
     *
                cacheCleanupManager.enqueueCleanupKey(this);
            BytesReference value = loader.get();
         * @param cleanupKey the CleanupKey to be updated in the map
            Key key = (Key) o;
    @Override
import org.apache.logging.log4j.LogManager;
            RemovalNotification<ICacheKey<Key>, BytesReference> notification
            CleanupKey cleanupKey,
            e.addSuppressed(e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    /**
import org.apache.lucene.util.Accountable;
            // key as part of tiered/disk cache. The key is not passed between nodes at this point.
 */
                } catch (IOException e) {
            out.writeInt(indexShardHashCode); // We are serializing/de-serializing this as we need to store the
                this.threadPool = threadPool;
        /**
            this.loader = loader;
        /**
        private void updateStaleCountOnCacheInsert(CleanupKey cleanupKey) {
        private final IndicesRequestCacheCleaner cacheCleaner;
                    int newCount = count - 1;
        Loader cacheLoader = new Loader(cacheEntity, loader);
        }
 * with the semantics of NRT (the index reader cache key is part of the cache key), and relies on size based
     *
            cacheEntity.onMiss();
     * If the staleness threshold is not valid, it throws an OpenSearchParseException.
                    // If after modification, the readerCacheKeyMap is empty, we return null to remove the ShardId entry
            .setWeigher(weigher)
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> getCleanupKeyToCountMap() {
                    // Check if countMap is empty after removal to decide if we need to remove the shardId entry
