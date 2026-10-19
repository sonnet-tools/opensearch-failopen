     * @param cacheKey the cache key to invalidate
            addToCleanupKeyToCountMap(shardId, cleanupKey.readerCacheKeyId);
         */  
        Key(ShardId shardId, BytesReference value, String readerCacheKeyId, int indexShardHashCode) {
            if (logger.isDebugEnabled()) {
            if (cleanupKey.entity == null) {
            return this.loaded;
                // entity will only be null when the shard is closed/deleted
            return Collections.emptyList();
        "indices.requests.cache.maximum_cacheable_size",  
         * CacheEntity mainly contains IndexShard, both of these classes do not override equals() and hashCode() methods.  
        "indices.requests.cache.expire",
                        cache.invalidate(key);
        ToLongBiFunction<ICacheKey<Key>, BytesReference> weigher = (k, v) -> k.ramBytesUsed(k.key.ramBytesUsed()) + v.ramBytesUsed();
            IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
                    threadPool.scheduleUnlessShuttingDown(interval, ThreadPool.Names.SAME, this);  
    public static final Setting<TimeValue> INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING = Setting.positiveTimeSetting(  
                    logger.warn("Exception during periodic indices request cache cleanup:", e);
 * There are still several TODOs left in this class, some easily addressable, some more complex, but the support
/**  
                return;
            result = 31 * result + indexShardHashCode;  
    public void onRemoval(RemovalNotification<ICacheKey<Key>, BytesReference> notification) {
import java.util.Objects;  
import org.opensearch.common.lease.Releasable;
        /**
                // The reason of the notification is REPLACED when a cache entry's value is updated, since replacing an entry
            this.cleanupKeyToCountMap = new ConcurrentHashMap<>();
        private final IndicesRequestCacheCleaner cacheCleaner;  
         * Updates the cleanupKeyToCountMap with the given CleanupKey.
 * KIND, either express or implied.  See the License for the
    );
                this.threadPool = threadPool;  
    public static final Setting<Boolean> INDEX_CACHE_REQUEST_ENABLED_SETTING = Setting.boolSetting(  
 * <p>  
import java.util.Set;
                return true;  
    }
        private boolean loaded;
                );
                // Return the modified countMap to retain updates
            return BASE_RAM_BYTES_USED + shardId.getBaseRamBytesUsed() + value.length();
     * If pluggable caching is off, or pluggable caching is on but a store name isn't specified, this setting determines the cache size.
            public void close() {
            .setWeigher(weigher)  
 * license agreements. See the NOTICE file distributed with
            this.keysToClean = ConcurrentCollections.newConcurrentSet();
            cacheEntity.onMiss();  
import org.opensearch.common.cache.ICacheKey;  
        private synchronized boolean canSkipCacheCleanup(double cleanThresholdPercent) {
                    // If ShardId is not present or readerCacheKeyId is not present
 * the Apache License, Version 2.0 (the "License"); you may
        IndexShard indexShard = (IndexShard) cacheEntity.getCacheIdentity();
            BytesReference value = loader.get();  
    /**
         *
                    Integer count = readerCacheKeyMap.get(cleanupKey.readerCacheKeyId);
import org.opensearch.common.cache.LoadAwareCacheLoader;
                }
    static class Key implements Accountable, Writeable {  
 * SPDX-License-Identifier: Apache-2.0
            for (ICacheKey<Key> key : cache.keys()) {
        @Override  
        IndicesRequestCache::validateStalenessSetting,
        if (!CacheService.storeNamePresent(CacheType.INDICES_REQUEST_CACHE, settings)) {
        void onCached(ICacheKey<Key> key, BytesReference value);  
        void onRemoval(RemovalNotification<ICacheKey<Key>, BytesReference> notification);  
        }  
        String shardIdDimensionValue = getShardIdDimensionName(key);
         * Cleans the cache based on the provided staleness threshold.  
    /**
            }  
        }  
 *  
                    // this should never be null  
                // Invalidate a dummy key containing the dimensions we need to drop stats for
         * Called each time this entity has a cache miss.
     *
        void cleanCache() {  
    }  
                // Reschedule itself to run again if not closed
    }
         */
        private final Set<CleanupKey> keysToClean;
     * @param cacheEntity the cache entity to invalidate for  
        @Override
import org.opensearch.index.shard.IndexShard;
                    // Aggregate and add to staleKeysCount atomically if readerCacheKeyId is null
         * Returns <code>true</code> iff the resource behind this entity is still open ie.  
            this.cacheCleaner = new IndicesRequestCacheCleaner(this, threadpool, cleanInterval);
        return key.shardId.toString();
                    return null;  
                    // This should not happen on a full cache cleanup.  
     * scroll requests are never cached, regardless of this setting.  
            IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
     * Basic interface to make this cache testable.
    public static final String INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY =
            this.staleKeysCount = new AtomicInteger(0);  
        Property.NodeScope
    private String getIndexDimensionName(Key key) {
    ) {  
                        // Update the map with the new count
import org.opensearch.common.cache.RemovalNotification;  
         *
            }
                logger.debug(  
    }  
            }
     * @param staleThreshold The staleness threshold to validate.
     * Default value of 0 only allows size == 0 queries, matching earlier behavior.
        Property.Dynamic,  
    private final ClusterService clusterService;
        @Override
        final String readerCacheKeyId;
import org.apache.logging.log4j.Logger;
        this.clusterService = clusterService;
    }
        Property.Dynamic
                staleKeysCount.decrementAndGet();
            if (!entity.getCacheIdentity().equals(that.entity.getCacheIdentity())) return false;
        void updateStalenessThreshold(double stalenessThreshold) {
                }  
                // readers  
                }
        }
        Key key = notification.getKey().key;  
import org.opensearch.common.cache.policy.CachedQueryResult;
            this.stalenessThreshold = stalenessThreshold;  
     * @opensearch.internal
            if (cleanupKey.entity == null) {
            result = 31 * result + Objects.hashCode(readerCacheKeyId);  
        Loader(CacheEntity entity, CheckedSupplier<BytesReference, IOException> loader) {
        String readerCacheKeyId = delegatingCacheHelper.getDelegatingCacheKey().getId();
                    oldStalenessThreshold  
                    return new CachedQueryResult.PolicyValues(-1);
            loaded = true;
        private void updateStaleCountOnEntryRemoval(  
    }  
     *  
public final class IndicesRequestCache implements RemovalListener<ICacheKey<IndicesRequestCache.Key>, BytesReference>, Closeable {  
import org.opensearch.core.common.io.stream.StreamOutput;  
        cacheCleanupManager.updateStaleCountOnEntryRemoval(cleanupKey, notification);  
         */  
            result = 31 * result + readerCacheKeyId.hashCode();
        public boolean equals(Object o) {
 * You may obtain a copy of the License at  
            .addSettingsUpdateConsumer(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING, this::setStalenessThreshold);
 * under the License.  
    @Override  
            .setRemovalListener(this)  
package org.opensearch.indices;
import org.opensearch.threadpool.ThreadPool;  
                    // so decrement staleKeysCount  
    public static final String INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY = "indices.requests.cache.cleanup.interval";
            }
                        }  
            .setKeyType(Key.class)
        cache.invalidateAll();  
    }
                    logger.debug(
        this.clusterService.getClusterSettings()  
    }
                // we would have accounted this in staleKeysCount when the closing/deletion of shard would have closed the associated
    private static final Logger logger = LogManager.getLogger(IndicesRequestCache.class);
    CacheConfig<Key, BytesReference> getCacheConfig(Settings settings, NodeEnvironment nodeEnvironment) {
     * <p>package private for testing  
                    } else {
         *
import java.util.concurrent.ConcurrentHashMap;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                indexShardCacheEntity.onRemoval(notification);
        IndicesService.IndexShardCacheEntity indexShardCacheEntity = (IndicesService.IndexShardCacheEntity) cacheEntityLookup.apply(
        // hashcode(default) to identify the older indexShard but with same shardId.
            if (indexShard == null) {
         */
                    cleanupKeysFromFullClean.add(new Tuple<>(indexShard.shardId(), indexShard.hashCode()));
         */
         * @return The percentage of stale keys in the cache as a double. Returns 0 if there are no keys in the cache or no stale keys.
            key.shardId
        public void close() {
    private String getShardIdDimensionName(Key key) {
     * The IndicesRequestCacheCleanupManager manages the cleanup of stale keys in IndicesRequestCache.  
         */  
                            + staleKeysInCachePercentage
 * Unless required by applicable law or agreed to in writing,
            // If the key exists, its value is incremented by 1.  
                        // If cache entity is null, it means that index or shard got deleted/closed meanwhile.
                this.cacheCleanupManager = cacheCleanupManager;
         * indicating that the cache cleanup process can be skipped.
import org.opensearch.common.cache.RemovalListener;
                    // If it is in the map, it is not stale yet.
        }
                return 0;
                    // but do not decrement the staleKeysCount
         * Clean cache based on stalenessThreshold
            return result;
         * ShardID class properly overrides equals() and hashCode() methods.
    );  
        NodeEnvironment nodeEnvironment
                    int newCount = count - 1;  
        /**
                            + " is less than the threshold : "
                    cleanupKeysFromClosedShards.add(new Tuple<>(indexShard.shardId(), indexShard.hashCode()));
            }
                // does not affect the staleness count, we skip such notifications.  
                } else {
        // pkg-private for testing
            this.entity = entity;
            });
            @Override
import java.io.IOException;  
         * This method is called when a CleanupKey is added to the keysToClean set.
                    OpenSearchDirectoryReader.addReaderCloseListener(reader, cleanupKey);  
    public void close() throws IOException {
        }
import org.opensearch.common.settings.Setting;
            ShardId shardId = indexShard.shardId();  
            if (cleanupKey.entity == null) {  
                return;
        "indices.requests.cache.cleanup.staleness_threshold";  
    class IndicesRequestCacheCleanupManager implements Closeable {
                if (readerCacheKeyMap == null || !readerCacheKeyMap.containsKey(cleanupKey.readerCacheKeyId)) {  
            }  
         *
import java.util.HashSet;  
        // Pass a new removal notification containing Key rather than ICacheKey<Key> to the CacheEntity for backwards compatibility.
        this.expire = INDICES_CACHE_QUERY_EXPIRE.exists(settings) ? INDICES_CACHE_QUERY_EXPIRE.get(settings) : null;
        /**
                return;
import org.opensearch.core.common.io.stream.StreamInput;
        "index.requests.cache.enable",
        assert readerCacheKeyId != null;  
        /**
            if (cleanupKeysFromOutdatedReaders.isEmpty() && cleanupKeysFromFullClean.isEmpty() && cleanupKeysFromClosedShards.isEmpty()) {
 * specific language governing permissions and limitations
            if (!value.equals(key.value)) return false;
         */
     * If the staleness threshold is not valid, it throws an OpenSearchParseException.  
    }  
        }  
        void enqueueCleanupKey(CleanupKey cleanupKey) {
    /**  
                } catch (IOException e) {  
        return cache.count();  
import org.opensearch.core.common.unit.ByteSizeValue;
        /**  
/*
 *
            threadPool,  
         *  
 * software distributed under the License is distributed on an
            // shardId) from current IndexShard.  
            Set<List<String>> dimensionListsToDrop = new HashSet<>();
         */
        public Collection<Accountable> getChildResources() {
                closed.compareAndSet(false, true);  
        ) {  
            .getReaderCacheHelper();
            })
     * It also keeps track of the number of stale keys in the cache (staleKeysCount) and a staleness threshold,
        private void forceCleanCache() {
        List<String> dimensions = List.of(indexDimensionValue, shardIdDimensionValue);  
        private final class IndicesRequestCacheCleaner implements Runnable, Releasable {
                    // Add both shardId and indexShardHashCode to uniquely identify an indexShard.  
            }  
        new TimeValue(0),  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
        public long ramBytesUsed() {  
    // package private for testing
     * Validates the staleness setting for the cache cleanup threshold.  
                    // Set took time to -1, which will always be rejected by the policy.
 */  
    static String validateStalenessSetting(String staleThreshold) {
import java.util.Iterator;
            }
        private void incrementStaleKeysCount(CleanupKey cleanupKey) {  
            if (indexShard == null) {
            if (!Objects.equals(readerCacheKeyId, that.readerCacheKeyId)) return false;
import org.opensearch.env.NodeEnvironment;
         *  
                        staleKeysCount.addAndGet(count);
import org.opensearch.common.cache.service.CacheService;
        0,
            this.value = value;
            return true;
    // pkg-private for testing
        String threshold = INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.get(settings);
            if (o == null || getClass() != o.getClass()) return false;
        String readerCacheKeyId = delegatingCacheHelper.getDelegatingCacheKey().getId();
            CleanupKey cleanupKey = new CleanupKey(cacheEntity, readerCacheKeyId);
    }
                this.interval = interval;
                    cache.invalidate(key);  
    }
            this.readerCacheKeyId = readerCacheKeyId;
        }
                return;  
 * Licensed to Elasticsearch under one or more contributor  
        private volatile double stalenessThreshold;
        DirectoryReader reader,  
     * @param reader the reader to invalidate the cache entry for
            // If the key was present, enqueue it for cleanup
                    // Check if countMap is empty after removal to decide if we need to remove the shardId entry
                logger.warn("IndexShard is null for CleanupKey: {} while cleaning Indices Request Cache", cleanupKey.readerCacheKeyId);  
                return false;  
        /**  
    );  
        /**
         * If the CleanupKey's readerCacheKeyId is null or the CleanupKey's entity is not open, it increments the staleKeysCount
         * @param notification RemovalNotification of the cache entry evicted
            for (Iterator<CleanupKey> iterator = keysToClean.iterator(); iterator.hasNext();) {  
        Function<ShardId, Optional<CacheEntity>> cacheEntityFunction,
     * A setting to enable or disable request caching on an index level. Its dynamic by default
 */  
     *
 * is functional.
            CleanupKey that = (CleanupKey) o;  
        }
            this.readerCacheKeyId = in.readOptionalString();
            for (List<String> closedDimensions : dimensionListsToDrop) {
                logger.warn("IndexShard is null for CleanupKey: {} while cleaning Indices Request Cache", cleanupKey.readerCacheKeyId);  
        }
                        if (cleanupKeysFromOutdatedReaders.contains(cleanupKey)) {
    void invalidate(IndicesService.IndexShardCacheEntity cacheEntity, DirectoryReader reader, BytesReference cacheKey) {
        CacheConfig<Key, BytesReference> config = getCacheConfig(settings, nodeEnvironment);  
         * Hence we decrement {@link #staleKeysCount} if we do not find the shardId or readerCacheKeyId in the map.  
        true,
 *    http://www.apache.org/licenses/LICENSE-2.0
     * since we are checking on the cluster state IndexMetadata always.  
        public boolean equals(Object o) {
            if (this == o) return true;  
         */  
 * GitHub history for details.
            e.addSuppressed(e);  
 * similar requests that are potentially expensive (because of aggs for example). The cache is fully coherent
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
        }  
                Tuple<ShardId, Integer> shardIdInfo = new Tuple<>(delegatingKey.shardId, delegatingKey.indexShardHashCode);
 * The OpenSearch Contributors require contributions made to  
                }
     *
        AtomicInteger getStaleKeysCount() {
         * The method increments the count of the CleanupKey in the map.  
            this.shardId = in.readOptionalWriteable(ShardId::new);
            // Remove the current CleanupKey from the registeredClosedListeners map
    /**
        IndicesService.IndexShardCacheEntity cacheEntity,
        /**  
        Loader cacheLoader = new Loader(cacheEntity, loader);  
                        return null;
                ICacheKey<Key> dummyKey = new ICacheKey<>(null, closedDimensions);  
        Property.IndexScope
        if (indexShardCacheEntity != null) {
        cacheCleanupManager.close();
            if (wasRegistered != null) {
                    // Update staleKeysCount based on specific readerCacheKeyId, then remove it from the countMap
            // key as part of tiered/disk cache. The key is not passed between nodes at this point.
        @Override  
                        readerCacheKeyMap.put(cleanupKey.readerCacheKeyId, newCount);  
    public static final Setting<TimeValue> INDICES_CACHE_QUERY_EXPIRE = Setting.positiveTimeSetting(
        }
 * @opensearch.internal
            throw e;
            long totalKeysInCache = count();
            out.writeOptionalString(readerCacheKeyId);
            // If a store name is present, cache implementations instead determine their own sizes based on their own implementation  
            int result = shardId.hashCode();  
            .setStoragePath(nodeEnvironment.nodePaths()[0].path.toString() + "/request_cache");
        // package private for testing
                }
        final Key key = new Key(indexShard.shardId(), cacheKey, readerCacheKeyId, System.identityHashCode(indexShard));
         * @param cleanupKey   the CleanupKey that has been evicted from the cache  
            Key key = (Key) o;
        private final AtomicInteger staleKeysCount;
            cacheCleanupManager.updateStaleCountOnCacheInsert(cleanupKey);  
        public int hashCode() {
         */  
            // If the key doesn't exist, it's added with a value of 1.
     * */  
    /**
        boolean isOpen();  
            }  
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
        } catch (OpenSearchParseException e) {
        INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY,  
                final IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();  
            if (indexShardHashCode != key.indexShardHashCode) return false;  
        CacheService cacheService,
            return staleKeysCount;  
            // Contains CleanupKey objects for a closed shard.  
            if (!Objects.equals(readerCacheKeyId, key.readerCacheKeyId)) return false;  
            }
     * Invalidates the given the cache entry for the given key and it's context
                    // null indicates full cleanup
import java.util.function.Function;
 * not use this file except in compliance with the License.
            public void run() {
            this.loader = loader;  
            private final AtomicBoolean closed = new AtomicBoolean(false);
        cacheCleanupManager.forceCleanCache();
        }
     * <p>This method checks if the provided staleness threshold is a valid percentage or a valid double value.
                        CleanupKey cleanupKey = new CleanupKey(cacheEntity, delegatingKey.readerCacheKeyId);  
        private final CheckedSupplier<BytesReference, IOException> loader;
 * <p>  
     * Returns the current size of the cache  
import org.opensearch.common.settings.Settings;  
            return false;
    private final ConcurrentMap<CleanupKey, Boolean> registeredClosedListeners = ConcurrentCollections.newConcurrentMap();
            if (totalKeysInCache == 0 || staleKeysCount.get() == 0) {  
            if (staleKeysInCachePercentage < cleanThresholdPercent) {  
                            cache.invalidate(key);
    @Override
        }
        public void writeTo(StreamOutput out) throws IOException {
            IndexShard indexShard = (IndexShard) cleanupKey.entity.getCacheIdentity();
     */
                    return readerCacheKeyMap;  
                    cleanupKeysFromOutdatedReaders.add(cleanupKey);  
 * this file be licensed under the Apache-2.0 license or a
     */  
     * This refers to the number of documents returned, not the size in bytes.  
     * which is used to determine when the cache should be cleaned.  
            .setExpireAfterAccess(expire) // for backward compatibility
            if (key.indexShardHashCode == System.identityHashCode(indexShardCacheEntity.getCacheIdentity())) {
import java.util.Optional;
         * Calculates and returns the percentage of stale keys in the cache.  
                        // Returning null removes the entry for shardId
        @Override
         * Skip decrementing staleKeysCount if we find the shardId or readerCacheKeyId in the map since it would have not been accounted for in the staleKeysCount in
        ).orElse(null);  
        // In case this event happens for an old shard, we can safely ignore this as we don't keep track for old  
         * If the ShardId associated with the CleanupKey does not exist in the map, a new entry is created.
            .setDimensionNames(List.of(INDEX_DIMENSION_NAME, SHARD_ID_DIMENSION_NAME))
    int numRegisteredCloseListeners() { // for testing
            }
                    });
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.util.Accountable;
         * @param cleanupKey the CleanupKey to be updated in the map
        private final ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap;  
            .setValueType(BytesReference.class)
    BytesReference getOrCompute(  
    /**
        "1%",  
            final Set<Tuple<ShardId, Integer>> cleanupKeysFromClosedShards = new HashSet<>();
         *  
import java.io.Closeable;
            return true;  
            threadpool.schedule(cacheCleaner, cleanInterval, ThreadPool.Names.SAME);
     */
    );
    public static final Setting<String> INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING = new Setting<>(
                    // Since the shard is closed, the cache should drop stats for this shard.
         * <p>This method is called when an entry is evicted from the cache.  
        return key.shardId.getIndexName();  
                    return readerCacheKeyMap.isEmpty() ? null : readerCacheKeyMap;  
import org.opensearch.common.unit.RatioValue;
        final CacheEntity entity;  
import java.util.Collection;
                logger.warn("IndexShard is null for CleanupKey: {}", cleanupKey.readerCacheKeyId);  
         *  
                        return null;  
        Property.Deprecated
        @Override
         * Handles the eviction of a cache entry.
            cache.refresh();
 * level setting that can be dynamically changed and defaults to false.
            }
            if (!shardId.equals(key.shardId)) return false;
                    countMap.computeIfPresent(cleanupKey.readerCacheKeyId, (readerCacheKey, count) -> {  
import java.util.concurrent.ConcurrentMap;
        this.cache = cacheService.createCache(config, CacheType.INDICES_REQUEST_CACHE);
         * @param cleanThresholdPercent The staleness threshold as a percentage.
                if (cleanupKey.readerCacheKeyId == null) {
                    staleKeysCount.addAndGet(totalSum);
            }
                Boolean previous = registeredClosedListeners.putIfAbsent(cleanupKey, Boolean.TRUE);
}
        }  
            cleanupKeyToCountMap.compute(shardId, (key, readerCacheKeyMap) -> {
    // pkg-private for testing  
                if (cleanupKeysFromFullClean.contains(shardIdInfo) || cleanupKeysFromClosedShards.contains(shardIdInfo)) {
import org.opensearch.core.common.bytes.BytesReference;
import org.apache.lucene.util.RamUsageEstimator;  
                    staleKeysCount.decrementAndGet();
     * Deprecated; once pluggable caching is no longer behind a feature flag (likely in 2.19), this setting will no longer have any effect.
        "0%",
        return RatioValue.parseRatioValue(threshold).getAsRatio();  
        public final int indexShardHashCode; // While ShardId is usually sufficient to uniquely identify an
    private static class Loader implements LoadAwareCacheLoader<ICacheKey<Key>, BytesReference> {
            if (!registeredClosedListeners.containsKey(cleanupKey)) {  
    );
            // cache until size-based eviction reaches it. Remove matches with exact-key invalidate() rather
                cacheCleanupManager.enqueueCleanupKey(this);
     */
                    "Staleness threshold for indices request cache changed to {} from {}",
        void onHit();
                    dimensionListsToDrop.add(key.dimensions);
        }
            incrementStaleKeysCount(cleanupKey);  
            double staleKeysInCachePercentage = staleKeysInCachePercentage();
        return new ICacheKey<>(key, dimensions);
import org.opensearch.common.cache.serializer.BytesReferenceSerializer;  
            .setKeySerializer(new IRCKeyWriteableSerializer())
 *  
            private final ThreadPool threadPool;
    public static final String SHARD_ID_DIMENSION_NAME = "shards";
import org.apache.lucene.index.IndexReader;
     *
        this.cacheEntityLookup = cacheEntityFunction;
        this.cacheCleanupManager = new IndicesRequestCacheCleanupManager(
                try {
        public final ShardId shardId; // use as identity equality
                try {
        }
        /**
 * ownership. Elasticsearch licenses this file to you under  
            .setValueSerializer(new BytesReferenceSerializer())  
            ShardId shardId = indexShard.shardId();  
    }  
    // pkg-private for testing
                } else {
            private final IndicesRequestCacheCleanupManager cacheCleanupManager;  
    }  
            if (notification.getRemovalReason() == RemovalReason.REPLACED) {
     */
                    if (countMap.isEmpty()) {  
        INDICES_CACHE_CLEAN_INTERVAL_SETTING,
            }  
        assert reader.getReaderCacheHelper() != null;  
        void onMiss();
            if (this == o) return true;
            this.entity = entity;
    void forceCleanCache() {  
    ImmutableCacheStatsHolder stats(String[] levels) {  
        }  
            result = 31 * result + value.hashCode();
            final Set<CleanupKey> cleanupKeysFromOutdatedReaders = new HashSet<>();  
        this.cacheCleanupManager.updateStalenessThreshold(RatioValue.parseRatioValue(threshold).getAsRatio());
                } else if (!cleanupKey.entity.isOpen()) {
                if (closed.get() == false) {
     * Sets the maximum size of a query which is allowed in the request cache.
                    CacheEntity cacheEntity = cacheEntityLookup.apply(delegatingKey.shardId).orElse(null);
 * Currently, the cache is only enabled for count requests, and can only be opted in on an index
        private synchronized void cleanCache(double stalenessThreshold) {
    /**
     */
        cache.invalidateAll();
         * Therefore, to avoid modifying CacheEntity and IndexShard classes to override these methods, we use ShardID as the key.
         */
            INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING.get(settings),
                            + stalenessThreshold  
 * are no longer used or closed shards.
         * Enqueue cleanup key.  
            if (cleanThresholdPercent == 0.0) {
    }
            final Set<Tuple<ShardId, Integer>> cleanupKeysFromFullClean = new HashSet<>();
import org.opensearch.common.cache.CacheType;
            }  
    private class CleanupKey implements IndexReader.ClosedListener {
    IndicesRequestCache(
            keysToClean.add(cleanupKey);
import org.opensearch.common.settings.Setting.Property;
         * <p>
                        dimensionListsToDrop.add(key.dimensions);  
                if (logger.isDebugEnabled()) {
        assert reader.getReaderCacheHelper() instanceof OpenSearchDirectoryReader.DelegatingCacheHelper;
            // Using computeIfPresent to atomically operate on the countMap for a given shardId
            if (o == null || getClass() != o.getClass()) {  
                        // Return null to remove the key after updating staleKeysCount
        OpenSearchDirectoryReader.DelegatingCacheHelper delegatingCacheHelper = (OpenSearchDirectoryReader.DelegatingCacheHelper) reader  
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;
     * @opensearch.internal
         * @param cleanupKey the CleanupKey that has been marked for cleanup
            // Contains CleanupKey objects for a full cache cleanup.
            if (indexShard == null) {
        Property.NodeScope,
        }
         * Updates the count of stale keys in the cache.  
            out.writeInt(indexShardHashCode); // We are serializing/de-serializing this as we need to store the  
        assert reader.getReaderCacheHelper() instanceof OpenSearchDirectoryReader.DelegatingCacheHelper;
        }
        ClusterService clusterService,
        private CleanupKey(CacheEntity entity, String readerCacheKeyId) {  
import org.opensearch.common.collect.Tuple;
            // The cleanup marks are consumed above before this scan, so a key skipped here would stay in the
         *
            return ((double) staleKeysCount.get() / totalKeysInCache);  
    public static final String INDEX_DIMENSION_NAME = "indices";  
            .setCachedResultParser((bytesReference) -> {  
         * Determines whether the cache cleanup process can be skipped based on the staleness threshold.
            return result;
        // indexShard but in case where the same indexShard is deleted and reallocated on same node, we need the  
        public boolean isLoaded() {  
                if (cleanupKey.readerCacheKeyId == null) {
import org.opensearch.common.cache.store.config.CacheConfig;  
            }
                    }
                    // If after modification, the readerCacheKeyMap is empty, we return null to remove the ShardId entry
     */  
                    }  
            // key as part of tiered/disk cache. The key is not passed between nodes at this point.
import org.opensearch.common.cache.ICache;
        }
    // pkg-private for testing
    /**
    long count() {
            // than through the keys() iterator, which may be walking a point-in-time copy that does not support  
                    // Return the current map
         * <p>It increments the staleKeysCount by the count of the CleanupKey in the cleanupKeyToCountMap.  
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
         * @return true if the cache cleanup process can be skipped, false otherwise.
        }
            // size settings.
         * {@link #incrementStaleKeysCount} would have removed the entries from the map and increment the {@link #staleKeysCount}
        CheckedSupplier<BytesReference, IOException> loader,
        /**
        return cache.stats(levels);
                }  
        @Override
            // Here we match the hashcode to avoid scenario where we deduct stats of older IndexShard(with same
     * Unique key for the cache
            // removal (see OpenSearchOnHeapCache#keys()); invalidating a concurrently removed key is a no-op.
            cleanCache(0);
 * eviction to evict old reader associated cache entries as well as scheduler reaper to clean readers that
                    assert (count != null && count >= 0);
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> getCleanupKeyToCountMap() {  
        Object getCacheIdentity();  
import java.util.List;
        String indexDimensionValue = getIndexDimensionName(key);
    private final static long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(Key.class);
     *
    private ICacheKey<Key> getICacheKey(Key key) {  
    private final ICache<Key, BytesReference> cache;  
import java.util.concurrent.atomic.AtomicInteger;  
        /**
import org.opensearch.core.index.shard.ShardId;  
            IndicesRequestCacheCleaner(IndicesRequestCacheCleanupManager cacheCleanupManager, ThreadPool threadPool, TimeValue interval) {
        }
            // TODO: more detailed ram usage?  
     * Fundamentally non-cacheable queries like DFS queries, queries using the `now` keyword, and
        IndexShard indexShard = ((IndexShard) cacheEntity.getCacheIdentity());
     * @throws OpenSearchParseException If the staleness threshold is not a valid percentage or double value.
    // These values determine the valid names for levels in the cache stats API
import java.util.function.ToLongBiFunction;
                if (cleanupKeysFromClosedShards.contains(shardIdInfo)) {
        } else {
    }
            this.stalenessThreshold = stalenessThreshold;
     */
                return;
         * @param cleanupKey the cleanup key
                return;
        cacheCleanupManager.enqueueCleanupKey(new CleanupKey(entity, null));  
            // see if it's the first time we see this reader, and make sure to register a cleanup key
            ShardId shardId = indexShard.shardId();  
        public final BytesReference value;  
    }
         * Returns the cache identity. this is, similar to {@link #isOpen()} the resource identity behind this cache entity.  
            double oldStalenessThreshold = this.stalenessThreshold;  
        public final String readerCacheKeyId;
    }
        }
        @Override
        Property.NodeScope
            this.indexShardHashCode = indexShardHashCode;  
        }  
                } else {
            cleanupKeyToCountMap.computeIfAbsent(shardId, k -> new ConcurrentHashMap<>()).merge(readerCacheKeyId, 1, Integer::sum);  
    ) throws Exception {
        }
                }
 */
                    // Proceed to adjust the count for the readerCacheKeyId in the map  
            return value;  
        if (cacheLoader.isLoaded()) {
            RatioValue.parseRatioValue(staleThreshold);
                    // The shard is closed  
        return registeredClosedListeners.size();
        ThreadPool threadPool,  
        cache.close();  
                return;
            // If a store name is absent, use the max size based on the IRC setting into the config.
                    if (cacheEntity == null) {  
            }
            cleanupKeyToCountMap.computeIfPresent(shardId, (currentShardId, countMap) -> {  
                cache.invalidate(dummyKey);
            cacheEntity.onHit();
        /**  
        private void updateStaleCountOnCacheInsert(CleanupKey cleanupKey) {  
         * Called after the value was loaded.
        BytesReference value = cache.computeIfAbsent(getICacheKey(key), cacheLoader);
         * Why use ShardID as the key ?
        }
import org.opensearch.common.CheckedSupplier;  
                    this.stalenessThreshold,
                    if (newCount > 0) {
     * Otherwise, the implementation-specific size setting like indices.requests.cache.opensearch_onheap.size is used instead.  
 */
 *
        @Override
            this.readerCacheKeyId = Objects.requireNonNull(readerCacheKeyId);
            // Contains CleanupKey objects with open shard but invalidated readerCacheKeyId.
        cache.invalidate(getICacheKey(new Key(indexShard.shardId(), cacheKey, readerCacheKeyId, System.identityHashCode(indexShard))));
            if (canSkipCacheCleanup(stalenessThreshold)) {
                        // So we will delete this key.
    /**
         */
    final Function<ShardId, Optional<CacheEntity>> cacheEntityLookup;  
        private final CacheEntity entity;  
            this.indexShardHashCode = in.readInt(); // We are serializing/de-serializing this as we need to store the
            }  
     *
            out.writeOptionalWriteable(shardId);  
                } catch (Exception e) {
        10_000,  
         */
import org.opensearch.common.cache.RemovalReason;
            @Override  
    }
            CleanupKey cleanupKey,
                return countMap;  
                if (previous == null) {
    }
        }  
        /**  
 * The indices request cache allows to cache a shard level request stage responses, helping with improving
         */  
                    // Reduce the count by 1
        public BytesReference load(ICacheKey<Key> key) throws Exception {
            if (logger.isDebugEnabled()) {
                    // Return null to automatically remove the mapping for shardId
        Settings settings,  
    public static final Setting<ByteSizeValue> INDICES_CACHE_QUERY_SIZE = Setting.memorySizeSetting(
        IndicesRequestCacheCleanupManager(ThreadPool threadpool, TimeValue cleanInterval, double stalenessThreshold) {
         * by the total count of keys associated with the CleanupKey's ShardId in the cleanupKeyToCountMap and removes the ShardId from the map.
        @Override  
                    int totalSum = countMap.values().stream().mapToInt(Integer::intValue).sum();  
            configBuilder.setMaxSizeInBytes(sizeInBytes);
    void clear(CacheEntity entity) {
                return;
                    );
                    }
        BytesReference cacheKey
/*  
            }
                logger.debug("Cleaning Indices Request Cache with threshold : " + stalenessThreshold);  
                return;
        public void onClose(IndexReader.CacheKey cacheKey) {  
        void addToCleanupKeyToCountMap(ShardId shardId, String readerCacheKeyId) {
import java.util.Collections;
    interface CacheEntity extends Accountable {
        }
            Boolean wasRegistered = registeredClosedListeners.remove(this);  
 * Modifications Copyright OpenSearch Contributors. See
        INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        );  
     * Loader for the request cache  
    final IndicesRequestCacheCleanupManager cacheCleanupManager;
                    this.cacheCleanupManager.cleanCache();  
        Key(StreamInput in) throws IOException {  
         * entities associated with it can remain in the cache. ie. IndexShard is still open.
        public int hashCode() {
            }
                    return CachedQueryResult.getPolicyValues(bytesReference);
            RemovalNotification<ICacheKey<Key>, BytesReference> notification
 * this work for additional information regarding copyright
        return staleThreshold;  
import org.apache.logging.log4j.LogManager;
            }
        }
            this.value = in.readBytesReference();  
            });
            }
            this.shardId = shardId;  
         */
        }
                iterator.remove();
         * Called when this entity instance is removed
import org.opensearch.cluster.service.ClusterService;
                CleanupKey cleanupKey = iterator.next();
                } else {
            private final TimeValue interval;
    }
     * @return The validated staleness threshold.  
    void invalidateAll() {
                        "Skipping Indices Request cache cleanup since the percentage of stale keys : "  
            .setClusterSettings(clusterService.getClusterSettings())
        return configBuilder.build();
    }
        }  
            }  
import org.opensearch.common.unit.TimeValue;
                        readerCacheKeyMap.remove(cleanupKey.readerCacheKeyId);  
        /**
            .getReaderCacheHelper();
    void setStalenessThreshold(String threshold) {
     */  
        "indices.requests.cache.size",
     * Returns the current cache stats. Pkg-private for testing.
    }
         * For instance IndexShard is the identity while a CacheEntity is per DirectoryReader. Yet, we group by IndexShard instance.
        private synchronized double staleKeysInCachePercentage() {
        }
        0,
    /*
    private final TimeValue expire;
         * Force Clean cache without checking stalenessThreshold
                dummyKey.setDropStatsForDimensions(true);
        CacheConfig.Builder<Key, BytesReference> configBuilder = new CacheConfig.Builder<Key, BytesReference>().setSettings(settings)
         * Called each time this entity has a cache hit.  
            return cleanupKeyToCountMap;
        }
                    // it should have already been accounted for and hence been removed from this map
                Key delegatingKey = key.key;  
         * We consider all removal notifications except with the reason Replaced
                }
         * @param stalenessThreshold The staleness threshold as a double.
                return false;
                }
            cleanCache(stalenessThreshold);
                    } else {
     * If Staleness threshold is 0, we do not keep track of stale keys in the cache
     *
         * <p>If the percentage of stale keys is less than the provided staleness threshold returns true,
/*  
    public static final Setting<Integer> INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING = Setting.intSetting(
        long sizeInBytes = INDICES_CACHE_QUERY_SIZE.get(settings).getBytes();  
import org.opensearch.OpenSearchParseException;
        OpenSearchDirectoryReader.DelegatingCacheHelper delegatingCacheHelper = (OpenSearchDirectoryReader.DelegatingCacheHelper) reader  
                }
            entity.onCached(key, value);
    }  
        try {  
        // shards as part of request cache.
        }  
        Property.NodeScope,
        Property.NodeScope  
         * <p>If the percentage of stale keys in the cache is less than this threshold,the cache cleanup process is skipped.
        Property.Dynamic,  
            out.writeBytesReference(value);
    private double getStalenessThreshold(Settings settings) {
            this.cacheCleaner.close();
            int result = entity.getCacheIdentity().hashCode();
 * with the semantics of NRT (the index reader cache key is part of the cache key), and relies on size based  
            }
        // for testing
        return value;
    /**
     */  
        /**
            getStalenessThreshold(settings)
        CleanupKey cleanupKey = new CleanupKey(indexShardCacheEntity, key.readerCacheKeyId);
import java.util.concurrent.atomic.AtomicBoolean;
                        // Remove the readerCacheKeyId entry if new count is zero
    );
