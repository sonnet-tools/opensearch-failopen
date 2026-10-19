import java.util.Map;
                    updateStatsOnPut(cacheValueTuple.v2(), key, value);
        for (int iter = 0; iter < this.numberOfSegments; iter++) {  
    @Override
            return this;
                throw new IllegalArgumentException(  
                        statsHolder.incrementMisses(heapDimensionValues);  
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
            if (canCacheOnDisk) {
            this.statsHolder = statsHolder;  
        return statsHolder.count();  
            iterableList.add(tieredSpilloverCacheSegments[iter].keys());
                    }
         * @return builder  
    int getNumberOfSegments() {  
                            String tierValue = cacheEntry.getValue().tierName;  
            removalListener.onRemoval(notification);
                    throw new ExecutionException(npe);
            this.tierName = tierName;  
                builder.cacheType,
                // Add the value to the onHeap cache. We are calling computeIfAbsent which does another get inside.  
                    statsHolder.incrementHits(heapDimensionValues);
                    }
            statsHolder.incrementItems(dimensionValues);
        }
    static class ConcatenatedIterables<K> implements Iterable<K> {
                .setNumberOfSegments(numberOfSegments)
                                }
    }
     * Factory to create TieredSpilloverCache objects.  
            if (!cacheFactories.containsKey(onHeapCacheStoreName)) {  
            public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {  
        this.numberOfSegments = builder.numberOfSegments;
                for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
         * Set removal listener for tiered cache.  
                return true;  
                }
        public static final String TIERED_SPILLOVER_CACHE_NAME = "tiered_spillover";
        @Override
            @Override
            Function<V, CachedQueryResult.PolicyValues> cachedResultParser = Objects.requireNonNull(
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);  
            String diskCacheStoreName = onDiskSetting.get(settings);
        private final List<Predicate<V>> policies;  
        }
        tieredSpilloverCacheSegment.put(key, value);
                } catch (Exception ex) {
            List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();
            Objects.requireNonNull(builder.onHeapCacheFactory, "onHeap cache builder can't be null");  
                    .setCacheAlias("tiered_on_heap#" + segmentNumber)
            @Override  
            Setting<String> onDiskSetting = TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
    int getSegmentNumber(ICacheKey<K> key) {
                            boolean didAddToCache = false;
 * then items are eventually evicted from it and removed which will result in cache miss.
        TieredSpilloverCacheSegment(
import org.opensearch.common.cache.RemovalListener;  
import org.opensearch.common.annotation.ExperimentalApi;
        }
        private Tuple<V, Tuple<Boolean, Boolean>> compute(  
                    .setWeigher(builder.cacheConfig.getWeigher())
                cacheType.getSettingPrefix()
            }  
        static class ConcatenatedIterator<T> implements Iterator<T> {
                } else {  
        }  
            }  
import java.util.NoSuchElementException;
    }  
     * only once.
        }  
                .setCacheConfig(config)  
import java.util.Iterator;  
    /**
                                entry.getKey().put(key, value);
    @Override
                    }
         * @return builder  
            return this;  
            // First check in case the key is already present in either of tiers.  
            if (key.getDropStatsForDimensions()) {
        }  
    }
    // possible right now because of the way computeIfAbsent is implemented.
    TieredSpilloverCache(Builder<K, V> builder) {
                .getBytes();
            try (ReleasableLock ignore = writeLock.acquire()) {
        }
            return this;  
        }  
            V value,
                    wasRejectedByPolicy = !evaluatePoliciesList(value, policies);
                try {  
    // Package private for testing.  
                }
                } else {  
            };  
        private final List<Predicate<V>> diskPolicies;  
                statsHolder.removeDimensions(key.dimensions);
        Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
                builder.cacheType,
                                // listeners/stats. Needs better exception handling at underlying layers.For now swallowing
        this.tieredSpilloverCacheSegments = new TieredSpilloverCacheSegment[this.numberOfSegments];
        long diskCacheEntries = 0;
            Objects.requireNonNull(builder.cacheConfig.getClusterSettings(), "cluster settings can't be null");  
            return this;
                    .setKeyType(builder.cacheConfig.getKeyType())
        public Builder<K, V> addDiskPolicy(Predicate<V> diskPolicy) {  
                    .setSegmentCount(1) // We don't need to make underlying caches multi-segmented
                    if (pairInfo != null) {  
 * this file be licensed under the Apache-2.0 license or a
         * Set a cache policy to be used to limit access to this cache.
    /**  
        /**
                    completableFutureMap.remove(key);// Remove key from map as not needed anymore.  
        }  
                    .setExpireAfterAccess(builder.cacheConfig.getExpireAfterAccess())
            this.onHeapCacheMaxWeight = onHeapCacheSizeInBytes;
                    } else {  
            }  
    @Override  
import org.opensearch.common.unit.TimeValue;  
        }
    @Override
        ) {
                config.getCachedResultParser(),  
        private Function<ICacheKey<K>, Tuple<V, String>> getValueFromTieredCache(boolean captureStats) {
     */  
        void updateStatsOnRemoval(  
                try {
    }  
            } else {
            boolean wasEvicted = SPILLOVER_REMOVAL_REASONS.contains(notification.getRemovalReason());
    public void invalidateAll() {
    @Override
        return new ConcatenatedIterables<>(iterables);
 * compatible open source license.
            }
        if (builder.numberOfSegments <= 0) {
                            if (cacheValueTuple.v2().equals(entry.getValue().tierName)) {  
                                logger.warn("Exception occurred while putting item onto heap cache", e);  
 * This cache spillover the evicted items from heap tier to disk tier. All the new items are first cached on heap  
         */  
        @Override
         * @return buider
    }
        }
     */  
                }  
/**
         * @return builder
        private final List<Predicate<V>> diskPolicies = new ArrayList<>();
                }
        }
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);  
            if (cacheValueTuple == null) {
                    for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
            long onHeapCacheSize = TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(cacheType.getSettingPrefix())  
                countEvictionTowardsTotal = true;
        private final TieredSpilloverCacheStatsHolder statsHolder;
                if (cacheValueTuple.v2().equals(TIER_DIMENSION_VALUE_ON_HEAP)) {  
            // or exception as an input and returns the value. Also before returning value, puts the value in cache if accepted by policies.
            if (future == null) {
        }
                    cacheEntry.getKey().invalidateAll();
            this.cacheFactories = cacheFactories;
                    // Miss for the heap tier, hit for the disk tier
            }  
                            } catch (Exception e) {
                }  
    }
            cacheListMap.put(onHeapCache, new TierInfo(true, TIER_DIMENSION_VALUE_ON_HEAP));
                // If the value is not going to the disk cache, send this notification to the TSC's removal listener
            };
            for (int i = 0; i < iterables.length; i++) {
            long diskCacheSize = TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(cacheType.getSettingPrefix())  
        return tieredSpilloverCacheSegments.length;
                tsc.handleRemovalFromDiskTier(notification);
                }
    @Override
            statsHolder.incrementSizeInBytes(dimensionValues, weigher.applyAsLong(key, value));  
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
import java.util.List;
                    "No associated diskCache found for tieredSpilloverCache for " + "cacheType:" + cacheType
                return currentIterator.next();
            return this;
        long getDiskCacheMaxWeight() {  
            // When disk cache is disabled, we are not clearing up the disk cache entries yet as that should be part of
                this.tsc = tsc;  
            );
        AtomicBoolean isEnabled;
                iterators[i] = iterables[i].iterator();
     * Provides an iteration over both onHeap and disk keys. This is not protected from any mutations to the cache.  
        }
        /**
import org.opensearch.common.util.concurrent.ReleasableLock;
    Iterable<ICacheKey<K>> getOnHeapCacheKeys() {  
    @Override
        return tieredSpilloverCacheSegments[getSegmentNumber(key)];
            throw new IllegalArgumentException("Per segment size for onHeap cache within Tiered cache should be " + "greater than 0");  
        @Override
import org.opensearch.common.cache.LoadAwareCacheLoader;
            this.diskPolicies = builder.diskPolicies; // Will never be null; builder initializes it to an empty list  
         * Sets disk cache siz
                } catch (InterruptedException ex) {
            }
        }
            this.policies = builder.policies;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;
                    .setKeyType(builder.cacheConfig.getKeyType())
                    }
                        tookTimePolicyThreshold,
            tieredSpilloverCacheSegments[iter].close();
                if (!exceptionOccurredOnDiskCachePut) {
            updateStatsOnRemoval(TIER_DIMENSION_VALUE_ON_HEAP, wasEvicted, key, notification.getValue(), countEvictionTowardsTotal);  
                .setOnHeapCacheFactory(onHeapCacheFactory)
        }
                                onHeapCache.put(pair.v1(), pair.v2());  
            Setting<String> onHeapSetting = TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
            statsHolder.decrementItems(dimensionValues);
 *  
            int numberOfSegments = TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(cacheType.getSettingPrefix()).get(settings);
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;  
                } catch (Exception ex) {
         */  
        return diskCacheEntries;
                    } else {
        public V get(ICacheKey<K> key) {
         * Set onHeap cache factory
            }  
                    .build(),
            }
                    .setSettings(builder.cacheConfig.getSettings())  
    @Override
                "Cached result parser fn can't be null"
                            List<String> dimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, tierValue);
                    )  
     */
                        cachedResultParser,  
                }
            if (!cacheFactories.containsKey(diskCacheStoreName)) {
        @Override  
         */
                    .setDimensionNames(builder.cacheConfig.getDimensionNames())
     * Builder object for tiered spillover cache.
            CompletableFuture<Tuple<Tuple<ICacheKey<K>, V>, Boolean>> future = null;
import java.util.Objects;  
        return tieredSpilloverCacheSegment.computeIfAbsent(key, loader);
                        for (Map.Entry<ICache<K, V>, TierInfo> entry : this.caches.entrySet()) {
         */
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);  
                onHeapCachePerSegmentSizeInBytes,  
        }  
                    .setKeySerializer(builder.cacheConfig.getKeySerializer())
        public Builder<K, V> addPolicy(Predicate<V> policy) {
                    // in this case as it shouldn't cause upstream request to fail.
                    String.format(Locale.ROOT, INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE, TIERED_SPILLOVER_CACHE_NAME)
            @Override  
                        boolean rejectedByPolicy = pairInfo.v2();
            );
        this.statsHolder.setDiskCacheEnabled(isDiskCacheEnabled);  
            updateStatsOnRemoval(TIER_DIMENSION_VALUE_DISK, wasEvicted, notification.getKey(), notification.getValue(), true);  
        }  
        }
        }
         * @param diskCacheSizeInBytes size of diskCache in bytes  
                    )
import org.apache.logging.log4j.LogManager;
            this.removalListener = Objects.requireNonNull(builder.removalListener, "Removal listener can't be null");
    // Package private for testing.
                    wasCacheMiss = !wasRejectedByPolicy;  
    @SuppressWarnings({ "unchecked" })
    final TieredSpilloverCacheSegment<K, V>[] tieredSpilloverCacheSegments;
        /**
                    .setSettings(builder.cacheConfig.getSettings())  
import org.opensearch.common.collect.Tuple;  
         */
        }
            }
                return null;
        tieredSpilloverCacheSegment.invalidate(key);
                        // Register a miss for the heap cache, and the disk cache if present
                        }  
                    new TookTimePolicy<>(
        }
            Objects.requireNonNull(builder.cacheConfig.getStoragePath(), "Storage path shouldn't be null");
        boolean evaluatePoliciesList(V value, List<Predicate<V>> policiesList) {  
import java.util.Locale;  
                .setCacheType(cacheType)
        for (int iter = 0; iter < this.numberOfSegments; iter++) {  
    }  
    public V get(ICacheKey<K> key) {
    @SuppressWarnings({ "unchecked" })  
            return onHeapCache;
                        cacheEntry.getKey().invalidate(key);  
     * @param <V> Type of value  
            private final TieredSpilloverCacheSegment<K, V> tsc;  
    @Override
import java.util.concurrent.ConcurrentHashMap;
        public Builder() {}
        }
                                statsHolder.incrementMisses(dimensionValues);
            this.removalListener = removalListener;
         * @param cacheFactories cache factories
        private final ICache<K, V> onHeapCache;
                    throw new NoSuchElementException();  
            public boolean hasNext() {
        }
                    future.completeExceptionally(ex);
                .build();  
        ReleasableLock readLock = new ReleasableLock(readWriteLock.readLock());
            );
                }
                            if (value != null) {
        /**  
        public void close() throws IOException {
        @Override
import java.util.concurrent.ExecutionException;  
                    try (ReleasableLock ignore = writeLock.acquire()) {
        private final RemovalListener<ICacheKey<K>, V> onDiskRemovalListener;
            return isEnabled.get();
        /**  
                tsc.handleRemovalFromHeapTier(notification);
                )
        List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();
    Iterable<ICacheKey<K>> getDiskCacheKeys() {
                while (!currentIterator.hasNext()) {
    }  
        /**
        final String tierName;
                throw new IllegalArgumentException(
            return this;
                        TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType)
                if (cacheValueTuple == null) {  
         */
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE;
            this.onDiskRemovalListener = new DiskTierRemovalListener(this);  
        private final ICache<K, V> diskCache;
            if (cacheValueTuple == null) {
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
        private class DiskTierRemovalListener implements RemovalListener<ICacheKey<K>, V> {
            }
         */  
                        onHeapCache.put(key, value);  
        }
            @Override
        TierInfo(boolean isEnabled, String tierName) {
                } else if (cacheValueTuple.v2().equals(TIER_DIMENSION_VALUE_DISK)) {  
                        statsHolder.incrementHits(heapDimensionValues);  
            this.diskCacheFactory = diskCacheFactory;
         * @return builder
import org.opensearch.common.settings.Setting;
        }
                    .setDimensionNames(builder.cacheConfig.getDimensionNames())
            this.numberOfSegments = numberOfSegments;
        }
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {  
        @Override
                // If the value was rejected by policy, it counts as neither a hit or miss.  
                    // In case it is not present in any tier, put it inside onHeap cache by default.
        void handleRemovalFromDiskTier(RemovalNotification<ICacheKey<K>, V> notification) {
        Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
         */
/*  
        }
        // pkg-private for testing  
            this.weigher = Objects.requireNonNull(builder.cacheConfig.getWeigher(), "Weigher can't be null");
         */
            this.isEnabled = new AtomicBoolean(isEnabled);
        private ICache.Factory onHeapCacheFactory;  
            boolean canCacheOnDisk = caches.get(diskCache).isEnabled()
                for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {  
         * @param diskCacheFactory Factory for disk cache.  
        boolean isEnabled() {  
            boolean wasCacheMiss = false;
        private class HeapTierRemovalListener implements RemovalListener<ICacheKey<K>, V> {
        }  
            return onHeapCacheMaxWeight;
                // as the value is leaving the TSC entirely
import java.util.concurrent.CompletableFuture;
            // Values removed from the disk tier leave the TSC entirely  
    }
            @Override  
         */
import org.opensearch.common.cache.store.config.CacheConfig;
        private int numberOfSegments;  
        this.dimensionNames = builder.cacheConfig.getDimensionNames();  
import org.opensearch.common.cache.ICacheKey;
            for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {  
        @Override
            TieredSpilloverCacheStatsHolder statsHolder,  
        public Builder<K, V> setDiskCacheSize(long diskCacheSizeInBytes) {  
         */  
        /**  
        private RemovalListener<ICacheKey<K>, V> removalListener;
         * @param onHeapCacheFactory Factory for onHeap cache.
            this.diskCacheSizeInBytes = diskCacheSizeInBytes;
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
    }
        }
                if (!hasNext()) {
        List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();  
        Objects.requireNonNull(builder.cacheConfig, "cache config can't be null");
        private CacheConfig<K, V> cacheConfig;  
                    .setValueType(builder.cacheConfig.getValueType())
        private final long onHeapCacheMaxWeight;
    public static class TieredSpilloverCacheFactory implements ICache.Factory {
            for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
        }  
            long onHeapCacheSizeInBytes,  
        }
            Builder<K, V> builder,
        public Builder<K, V> setCacheType(CacheType cacheType) {  
                .get(settings)
        }
        private long diskCacheSizeInBytes;
            if (wasEvicted) {
        public Builder<K, V> setCacheFactories(Map<String, ICache.Factory> cacheFactories) {
         * Build tiered spillover cache.  
    }  
        ICache<K, V> getOnHeapCache() {  
        ConcatenatedIterables(Iterable<K>[] iterables) {
         * Set cache type.
        private Map<String, ICache.Factory> cacheFactories;
            }
                    // TODO: Catch specific exceptions. Needs better exception handling. We are just swallowing exception  
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();  
                new CacheConfig.Builder<K, V>().setRemovalListener(onHeapRemovalListener)  
                    .setStatsTrackingEnabled(false)
                cacheType.getSettingPrefix()  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE;
            this.statsHolder.setDiskCacheEnabled(isDiskCacheEnabled);
package org.opensearch.cache.common.tier;
            boolean wasEvicted = SPILLOVER_REMOVAL_REASONS.contains(notification.getRemovalReason());
                    throw new IllegalStateException(ex);
 * @param <K> Type of key
            this.onHeapCacheSizeInBytes = onHeapCacheSizeInBytes;  
                new CacheConfig.Builder<K, V>().setRemovalListener(onDiskRemovalListener)  
 * @opensearch.experimental
    public static class Builder<K, V> {
        }  
                i + 1,
        private final RemovalListener<ICacheKey<K>, V> removalListener;  
                                    statsHolder.incrementHits(dimensionValues);
        }
                            V value = cacheEntry.getKey().get(key);
                );  
                                return new Tuple<>(value, tierValue);  
                .setRemovalListener(config.getRemovalListener())
        /**
            Tuple<V, String> cacheValueTuple;
        }  
        ICache<K, V> getDiskCache() {
        @Override
            }  
        return key.hashCode() & (this.numberOfSegments - 1);  
            }
                    logger.warn("Exception occurred while putting item to disk cache", ex);
    /**
        public void put(ICacheKey<K> key, V value) {
import java.util.function.Predicate;  
            boolean countEvictionTowardsTotal = false; // Don't count this eviction towards the cache's total if it ends up in the disk tier  
                        if (ex != null) {
        }
        for (int i = 0; i < numberOfSegments; i++) {  
                        TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType)
                        }
         * @param cacheType Cache type  
            );
            try (ReleasableLock ignore = writeLock.acquire()) {
        public void refresh() {  
                statsHolder.incrementEvictions(dimensionValues, countEvictionTowardsTotal);  
                    exceptionOccurredOnDiskCachePut = true;  
        }
 */  
            } else {
         */
                    .setValueSerializer(builder.cacheConfig.getValueSerializer())  
    // In future we want to just read the stats from the individual tiers' statsHolder objects, but this isn't  
         * Get a value from the tiered cache, and the name of the tier it was found in.
            }  
        long getOnHeapCacheMaxWeight() {
            ICache.Factory diskCacheFactory = cacheFactories.get(diskCacheStoreName);
                            } else if (captureStats) {
                }  
        private long onHeapCacheSizeInBytes;
                        cachedResultParser,
                    }
     * ConcatenatedIterables which combines cache iterables and supports remove() functionality as well if underlying  
            CompletableFuture<Tuple<Tuple<ICacheKey<K>, V>, Boolean>> future  
    }  
    public void put(ICacheKey<K> key, V value) {
            onHeapCacheEntries += tieredSpilloverCacheSegments[iter].onHeapCache.count();  
    void enableDisableDiskCache(Boolean isDiskCacheEnabled) {
                                // TODO: Catch specific exceptions to know whether this resulted from cache or underlying removal  
         * @return builder
                    currentIteratorIndex++;  
                    updateStatsOnPut(TIER_DIMENSION_VALUE_DISK, key, notification.getValue());  
                    .setStoragePath(builder.cacheConfig.getStoragePath())
}
            ICache.Factory onHeapCacheFactory = cacheFactories.get(onHeapCacheStoreName);
            DiskTierRemovalListener(TieredSpilloverCacheSegment<K, V> tsc) {
                }
            this.caches = Collections.synchronizedMap(cacheListMap);
        }
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_SEGMENTS;  
        }
                        // Another thread requesting this key already loaded the value. Register a hit for the heap cache
                if (!policy.test(value)) {
                    diskCache.put(key, notification.getValue()); // spill over to the disk tier and increment its stats
                    NullPointerException npe = new NullPointerException("Loader returned a null value");  
            return this;
            private final Iterator<T>[] iterators;
                        if (cacheEntry.getValue().isEnabled()) {  
                        tookTimeDiskPolicyThreshold,
         * @param cacheConfig cache config.
                } finally {
            iterableList.add(tieredSpilloverCacheSegments[iter].onHeapCache.keys());  
        public void invalidateAll() {
        // Removal listener from the spillover cache as a whole
                        }  
                    new TookTimePolicy<>(  
            return new Builder<K, V>().setDiskCacheFactory(diskCacheFactory)  
                    try (ReleasableLock ignore = writeLock.acquire()) {
            int segmentNumber,
        // Count for all the tiers irrespective of whether they are enabled or not. As eventually
        /**
        public Builder<K, V> setCacheConfig(CacheConfig<K, V> cacheConfig) {
                        }
import org.opensearch.common.cache.RemovalReason;
    }  
        /**
                            logger.warn("Exception occurred while trying to compute the value", ex);
         * Default constructor
            // this key/value pair was rejected by the policies,  
         * Sets number of segments for tiered cache  
                    if (wasCacheMiss) {  
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;
        }
     * This map is used to handle concurrent requests for same key in computeIfAbsent() to ensure we load the value
         */
                                didAddToCache = true;
        public Builder<K, V> setRemovalListener(RemovalListener<ICacheKey<K>, V> removalListener) {
    static final String ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE = "Segment count cannot be less than one for tiered cache";
            this.diskPolicies.add(diskPolicy);
    public ImmutableCacheStatsHolder stats(String[] levels) {  
                    return null;  
            private Iterator<T> currentIterator;
                    value = futureTuple.v1().v2();  
@ExperimentalApi  
                removalListener.onRemoval(notification);  
        public Builder<K, V> setOnHeapCacheFactory(ICache.Factory onHeapCacheFactory) {
                            }
            // and it only has to be loaded one time, we should report one miss and the rest hits. But, if we do stats in
                }
                            }
                        if (caches.get(diskCache).isEnabled()) {
        private CacheType cacheType;
            boolean countEvictionTowardsTotal
         * A class which receives removal events from the heap tier.
                            try (ReleasableLock ignore = writeLock.acquire()) {
                    .setSegmentCount(1) // We don't need to make underlying caches multi-segmented  
                    .setStatsTrackingEnabled(false)  
            TimeValue tookTimeDiskPolicyThreshold = TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType).get(settings);
                    future = completableFutureMap.putIfAbsent(key, new CompletableFuture<>());
        @SuppressWarnings({ "unchecked" })  
    private static final List<RemovalReason> SPILLOVER_REMOVAL_REASONS = List.of(RemovalReason.EVICTED, RemovalReason.CAPACITY);
        }  
            int numberOfSegments,
                                if (captureStats) {  
         * Set cache config.
                this.iterators = iterators;
        if (onHeapCachePerSegmentSizeInBytes <= 0) {
            public T next() {
         */
                            if (didAddToCache) {
        public TieredSpilloverCache<K, V> build() {  
    public long count() {  
         * @return builder
         * @param removalListener Removal listener
                builder.cacheFactories  
                .setDiskCacheSize(diskCacheSize)
        /**
        public long count() {
            return this;  
         * Sets onHeap cache size
        }
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);  
         * @param policy the policy
            return cacheValueTuple.v1();
        @Override
        // Policies guarding access to the cache overall.
                this.tsc = tsc;
            }
            cacheListMap.put(diskCache, new TierInfo(isDiskCacheEnabled, TIER_DIMENSION_VALUE_DISK));  
    private final TieredSpilloverCacheStatsHolder statsHolder;
                    value = loader.load(key);  
                    .setWeigher(builder.cacheConfig.getWeigher())
            // separate cache/clear API.
        }
    }  
                                updateStatsOnPut(TIER_DIMENSION_VALUE_ON_HEAP, key, pair.v2());  
    }
            return this;
        final Iterable<K>[] iterables;  
            return key -> {  
public class TieredSpilloverCache<K, V> implements ICache<K, V> {
            HeapTierRemovalListener(TieredSpilloverCacheSegment<K, V> tsc) {
                builder,
            return null;
            }
            try (ReleasableLock ignore = readLock.acquire()) {  
                diskCachePerSegmentSizeInBytes
        // Pass "tier" as the innermost dimension name, in addition to whatever dimensions are specified for the cache as a whole
        // Package private for testing
            .addSettingsUpdateConsumer(DISK_CACHE_ENABLED_SETTING_MAP.get(builder.cacheType), this::enableDisableDiskCache);
    public void refresh() {
        }  
            }
                cacheEntry.getKey().close();
    // Package private for testing.  
    }
            return new ConcatenatedIterables<>(iterables);  
            Objects.requireNonNull(builder.diskCacheFactory, "disk cache builder can't be null");
        @SuppressWarnings({ "unchecked" })
                    Tuple<Tuple<ICacheKey<K>, V>, Boolean> futureTuple = future.get();
    long onHeapCacheCount() {  
                this.numberOfSegments,
                // Close all the caches here irrespective of whether they are enabled or not.
        return onHeapCacheEntries;
                // Handle stats for an initial hit from getValueFromTieredCache()
import org.opensearch.common.settings.Settings;
            Boolean isDiskCacheEnabled = DISK_CACHE_ENABLED_SETTING_MAP.get(builder.cacheType).get(builder.cacheConfig.getSettings());  
            return diskCacheMaxWeight;
    }
import java.util.Collections;
import java.util.function.BiFunction;
        // Package private for testing
        ) {  
         * @return builder  
            }
            this.onHeapRemovalListener = new HeapTierRemovalListener(this);
                currentIterator.remove();
            }  
    private final int numberOfSegments;
                return null;
                                // exception.
import org.apache.logging.log4j.Logger;
     */
            String onHeapCacheStoreName = onHeapSetting.get(settings);
            boolean wasEvicted,
                    // Rest will fetch existing future and wait on that to complete.
    /**
            return true;  
import org.opensearch.common.cache.RemovalNotification;
         * @param onHeapCacheSizeInBytes size of onHeap cache in bytes
                );  
            }
                )  
                        }  
            tieredSpilloverCacheSegments[iter].refresh();  
            }
        /**  
                this.currentIterator = iterators[currentIteratorIndex];  
                }
    // Package private for testing.
         * @return builder  
                future.handle(handler);
 * The OpenSearch Contributors require contributions made to  
         */  
    // Package private for testing.
                    try (ReleasableLock ignore = writeLock.acquire()) {
            return cacheValueTuple.v1();  
        /**  
 * @param <V> Type of value
            long diskCacheSizeInBytes
    }  
        }  
        /**
        public TieredSpilloverCacheFactory() {}  
         */
                    .setValueType(builder.cacheConfig.getValueType())
            throw new IllegalArgumentException("Per segment size for disk cache within Tiered cache should be " + "greater than 0");  
        // this will turn to zero once cache is cleared up either via invalidation or manually.
                .setOnHeapCacheSizeInBytes(onHeapCacheSize)
        void enableDisableDiskCache(Boolean isDiskCacheEnabled) {  
         */
        return statsHolder.getImmutableCacheStatsHolder(levels);
            return this;
                Tuple<V, Tuple<Boolean, Boolean>> computedValueTuple = compute(key, loader, future);  
        }
                    statsHolder.incrementMisses(heapDimensionValues);
import org.opensearch.common.cache.ICache;  
            this.cacheType = cacheType;
            if (!VALID_SEGMENT_COUNT_VALUES.contains(numberOfSegments)) {  
            this.cacheConfig = cacheConfig;  
                }
            return TIERED_SPILLOVER_CACHE_NAME;
            );
                cacheValueTuple = getValueFromTieredCache(false).apply(key);
import java.util.function.Function;
            Iterator<K>[] iterators = (Iterator<K>[]) new Iterator<?>[iterables.length];  
import java.io.IOException;  
                try {
        }  
            return onHeapCache.count() + diskCache.count();
        @Override  
                try (ReleasableLock ignore = readLock.acquire()) {
                    .setMaxSizeInBytes(onHeapCacheSizeInBytes)  
            BiFunction<Tuple<Tuple<ICacheKey<K>, V>, Boolean>, Throwable, Void> handler = (pairInfo, ex) -> {
        @Override
    public Iterable<ICacheKey<K>> keys() {
                        config.getClusterSettings(),  
        private ToLongBiFunction<ICacheKey<K>, V> weigher;
            this.caches.put(diskCache, new TierInfo(isDiskCacheEnabled, TIER_DIMENSION_VALUE_DISK));  
         * Defines cache name
            this.diskCache = builder.diskCacheFactory.create(
                    // Only one of the threads will succeed putting a future into map for the same key.  
                    }
            List<String> diskDimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, TIER_DIMENSION_VALUE_DISK);  
    Map<ICacheKey<K>, CompletableFuture<Tuple<ICacheKey<K>, V>>> completableFutureMap = new ConcurrentHashMap<>();
     * @param <K> Type of key.
            // Don't capture stats in the initial getValueFromTieredCache(). If we have concurrent requests for the same key,  
    }
            return new Tuple<>(value, new Tuple<>(wasCacheMiss, wasRejectedByPolicy));
         * @return A tuple of the value and the name of the tier it was found in.  
        public Iterator<K> iterator() {
    private final List<String> dimensionNames;  
        public Iterable<ICacheKey<K>> keys() {  
                    currentIterator = iterators[currentIteratorIndex];
import org.opensearch.common.cache.CacheType;
            }
                .addPolicy(  
                // the value once.
                throw new IllegalArgumentException(
                    "No associated onHeapCache found for tieredSpilloverCache for " + "cacheType:" + cacheType
            if (evaluatePoliciesList(value, policies)) {
        Map<ICacheKey<K>, CompletableFuture<Tuple<Tuple<ICacheKey<K>, V>, Boolean>>> completableFutureMap = new ConcurrentHashMap<>();
            throw new IllegalArgumentException(ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE);
            return diskCache;  
        if (diskCachePerSegmentSizeInBytes <= 0) {
        @Override  
         * @param captureStats Whether to record hits/misses for this call of the function
        }
    static class TieredSpilloverCacheSegment<K, V> implements ICache<K, V> {
import java.util.concurrent.atomic.AtomicBoolean;
            tieredSpilloverCacheSegments[iter].enableDisableDiskCache(isDiskCacheEnabled);
            this.diskCacheMaxWeight = diskCacheSizeInBytes;
                    // A hit for the heap tier
        @Override
            }  
                .get(settings);
         */
                            }
        }
            Tuple<V, String> cacheValueTuple = getValueFromTieredCache(true).apply(key);
        // Policies guarding access to the disk tier.
import java.util.ArrayList;
        Objects.requireNonNull(builder.cacheConfig.getSettings(), "settings can't be null");  
    // Used to avoid caching stale entries in lower tiers.  
            Settings settings = config.getSettings();
        /**
        long diskCachePerSegmentSizeInBytes = builder.diskCacheSizeInBytes / this.numberOfSegments;
            iterableList.add(tieredSpilloverCacheSegments[iter].diskCache.keys());
         * Set disk cache factory
            return new TieredSpilloverCache<>(this);
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
        private final long diskCacheMaxWeight;
                statsHolder,  
        return tieredSpilloverCacheSegment.get(key);
        }
        /**
    }
     * @param <K> Type of key
        public void invalidate(ICacheKey<K> key) {  
import org.opensearch.common.cache.policy.CachedQueryResult;  
    public void close() throws IOException {
 *
        }
import java.util.concurrent.locks.ReentrantReadWriteLock;  
            } else if (key.key != null) {  
                    .setClusterSettings(builder.cacheConfig.getClusterSettings())
        public Builder<K, V> setNumberOfSegments(int numberOfSegments) {
                            }  
         * Set a cache policy to be used to limit access to this cache's disk tier.
            List<String> dimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, removedFromTierValue);
                future = completableFutureMap.get(key);  
                for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
                        config.getClusterSettings(),
            Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
         * @param numberOfSegments number of segments
        long onHeapCachePerSegmentSizeInBytes = builder.onHeapCacheSizeInBytes / this.numberOfSegments;  
            ICacheKey<K> key,
        this.statsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, isDiskCacheEnabled);
    private static class TierInfo {  
            // we will see all misses. Instead, handle stats in computeIfAbsent().  
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
                    if (currentIteratorIndex == iterators.length) {
                    updateStatsOnPut(TIER_DIMENSION_VALUE_ON_HEAP, key, value);
                    throw new ExecutionException(ex);  
                boolean wasCacheMiss = computedValueTuple.v2().v1();
                );
import java.util.concurrent.locks.ReadWriteLock;
                this.currentIteratorIndex = 0;
            );  
            String removedFromTierValue,
import org.opensearch.cache.common.policy.TookTimePolicy;  
        private final RemovalListener<ICacheKey<K>, V> onHeapRemovalListener;  
         * @return builder
                // This is needed as there can be many requests for the same key at the same time and we only want to load
        ) throws Exception {
        public String getCacheName() {
        }
            LinkedHashMap<ICache<K, V>, TierInfo> cacheListMap = new LinkedHashMap<>();
            public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
            statsHolder.decrementSizeInBytes(dimensionValues, weigher.applyAsLong(key, value));  
        /**
    }  
         * @return builder
                }
        void handleRemovalFromHeapTier(RemovalNotification<ICacheKey<K>, V> notification) {  
                if (!wasRejectedByPolicy) {
                    return false;  
         * This map is used to handle concurrent requests for same key in computeIfAbsent() to ensure we load the value
         * Default constructor
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public void invalidate(ICacheKey<K> key) {
        public Builder<K, V> setOnHeapCacheSizeInBytes(long onHeapCacheSizeInBytes) {
 * SPDX-License-Identifier: Apache-2.0
        public Builder<K, V> setDiskCacheFactory(ICache.Factory diskCacheFactory) {  
         * only once.  
        ReleasableLock writeLock = new ReleasableLock(readWriteLock.writeLock());
        public ImmutableCacheStatsHolder stats(String[] levels) {  
                    .build(),  
        }  
        List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();  
        }
        for (int iter = 0; iter < this.numberOfSegments; iter++) {  
    }
    @Override
            List<String> heapDimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, TIER_DIMENSION_VALUE_ON_HEAP);
            }
                            // Get the tier value corresponding to this cache
                    // Handle stats
 * and the items evicted from on heap cache are moved to disk based cache. If disk based cache also gets full,
        /**
        return new ConcatenatedIterables<>(iterables);
         */  
        private ICache.Factory diskCacheFactory;
                    }  
            diskCacheEntries += tieredSpilloverCacheSegments[iter].diskCache.count();  
            private int currentIteratorIndex;  
            tieredSpilloverCacheSegments[iter].invalidateAll();
                if (value == null) {
    // Package private for testing.
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP;  
                && evaluatePoliciesList(notification.getValue(), diskPolicies);
         * @param diskPolicy the policy  
         * Set cache factories  
                            statsHolder.incrementMisses(diskDimensionValues);
        private final Map<ICache<K, V>, TierInfo> caches;
                        return false;
     * iterator supports it.
            }
                    cacheEntry.getKey().refresh();  
        Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
            V value = null;
    }
                    .setMaxSizeInBytes(diskCacheSizeInBytes)
    TieredSpilloverCacheSegment<K, V> getTieredCacheSegment(ICacheKey<K> key) {
        private final List<Predicate<V>> policies = new ArrayList<>();  
            this.onHeapCacheFactory = onHeapCacheFactory;  
    long diskCacheCount() {  
            return new ConcatenatedIterator<>(iterators);
            Objects.requireNonNull(builder.cacheConfig, "cache config can't be null");
                    .setCacheAlias("tiered_disk_cache#" + segmentNumber)  
            this.onHeapCache = builder.onHeapCacheFactory.create(
            for (Predicate<V> policy : policiesList) {
            public void remove() {  
            boolean exceptionOccurredOnDiskCachePut = false;
import java.util.function.ToLongBiFunction;
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;  
        builder.cacheConfig.getClusterSettings()
                iterableList.add(cacheEntry.getKey().keys());  
            tieredSpilloverCacheSegments[i] = new TieredSpilloverCacheSegment<K, V>(
                try (ReleasableLock ignore = writeLock.acquire()) {  
            List<String> dimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, destinationTierValue);
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
            ICacheKey<K> key = notification.getKey();
 *  
        // pkg-private for testing
            public ConcatenatedIterator(Iterator<T>[] iterators) {  
                        // The value was just computed and added to the cache by this thread.
            if (!canCacheOnDisk || exceptionOccurredOnDiskCachePut) {  
                        Tuple<ICacheKey<K>, V> pair = pairInfo.v1();
                .addDiskPolicy(
    /**  
        /**  
                    future.complete(new Tuple<>(new Tuple<>(key, value), wasRejectedByPolicy));
            return this;
     * @return An iterable over (onHeap + disk) keys
    @SuppressWarnings({ "unchecked" })
    }
        }  
        long onHeapCacheEntries = 0;
                builder.cacheFactories
     */
            Tuple<V, String> cacheValueTuple = getValueFromTieredCache(true).apply(key);  
            statsHolder.reset();
            LoadAwareCacheLoader<ICacheKey<K>, V> loader,
            ICacheKey<K> key,  
                }
            this.iterables = iterables;  
            TimeValue tookTimePolicyThreshold = TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType).get(settings);  
            this.policies.add(policy);  
                    wasRejectedByPolicy = futureTuple.v2();
                boolean wasRejectedByPolicy = computedValueTuple.v2().v2();
        // Removal listeners for the individual tiers
    private static final Logger logger = LogManager.getLogger(TieredSpilloverCache.class);
                    future.completeExceptionally(npe);
                && wasEvicted  
                }
        }
            // getValueFromTieredCache(),
            }
         * @return TieredSpilloverCache
            boolean wasRejectedByPolicy = false;  
                }
            // Handler to handle results post-processing. Takes a Tuple<Tuple<key, value>, boolean>, where the boolean represents whether
                    statsHolder.incrementHits(diskDimensionValues);  
 */
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
                if (cacheValueTuple == null) {
        void updateStatsOnPut(String destinationTierValue, ICacheKey<K> key, V value) {  
import java.util.LinkedHashMap;
            private final TieredSpilloverCacheSegment<K, V> tsc;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;
         * A class which receives removal events from the disk tier.  
        return new ConcatenatedIterables<>(iterables);  
        Boolean isDiskCacheEnabled = DISK_CACHE_ENABLED_SETTING_MAP.get(builder.cacheType).get(builder.cacheConfig.getSettings());
                        if (pair != null && !rejectedByPolicy) {  
                return computedValueTuple.v1();  
