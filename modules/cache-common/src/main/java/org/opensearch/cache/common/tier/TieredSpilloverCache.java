                    future.completeExceptionally(ex);
                new CacheConfig.Builder<K, V>().setRemovalListener(onHeapRemovalListener)
    @Override
    // Package private for testing.
            this.numberOfSegments = numberOfSegments;
                    .setValueSerializer(builder.cacheConfig.getValueSerializer())
                    wasRejectedByPolicy = !evaluatePoliciesList(value, policies);
            }
            return TIERED_SPILLOVER_CACHE_NAME;
        @Override
        Objects.requireNonNull(builder.cacheConfig, "cache config can't be null");
 *
                                statsHolder.incrementMisses(dimensionValues);
                if (cacheValueTuple == null) {
                    try (ReleasableLock ignore = writeLock.acquire()) {
         * @param diskPolicy the policy
        }
        Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
            boolean countEvictionTowardsTotal = false; // Don't count this eviction towards the cache's total if it ends up in the disk tier
            Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
        }
    }
                statsHolder.incrementEvictions(dimensionValues, countEvictionTowardsTotal);
     * @param <K> Type of key
            if (wasEvicted) {
        /**
            public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
            // Handler to handle results post-processing. Takes a Tuple<Tuple<key, value>, boolean>, where the boolean represents whether
         * @param policy the policy
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_SIZE;
         * @param captureStats Whether to record hits/misses for this call of the function
        }
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);
            return new TieredSpilloverCache<>(this);
            // First check in case the key is already present in either of tiers.
         */
        @Override
        void handleRemovalFromDiskTier(RemovalNotification<ICacheKey<K>, V> notification) {
        return statsHolder.getImmutableCacheStatsHolder(levels);
            this.caches.put(diskCache, new TierInfo(isDiskCacheEnabled, TIER_DIMENSION_VALUE_DISK));
            return cacheValueTuple.v1();
                );
                        // The value was just computed and added to the cache by this thread.
                        cachedResultParser,
                            statsHolder.incrementMisses(diskDimensionValues);
        @Override
    // Package private for testing.
            }
import java.util.Collections;
                    )
                    statsHolder.incrementHits(diskDimensionValues);
            this.onHeapCacheSizeInBytes = onHeapCacheSizeInBytes;
    public ImmutableCacheStatsHolder stats(String[] levels) {
         * Set removal listener for tiered cache.
        public TieredSpilloverCacheFactory() {}
                        for (Map.Entry<ICache<K, V>, TierInfo> entry : this.caches.entrySet()) {
            this.diskPolicies.add(diskPolicy);
                            List<String> dimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, tierValue);
        public Builder<K, V> setCacheFactories(Map<String, ICache.Factory> cacheFactories) {
        }
                return null;
        }
        @SuppressWarnings({ "unchecked" })
    }
                }
         * A class which receives removal events from the heap tier.
                        return false;
                } else {
            cacheListMap.put(diskCache, new TierInfo(isDiskCacheEnabled, TIER_DIMENSION_VALUE_DISK));
                        tookTimeDiskPolicyThreshold,
                try (ReleasableLock ignore = writeLock.acquire()) {
    public static class Builder<K, V> {
        /**
            this.removalListener = Objects.requireNonNull(builder.removalListener, "Removal listener can't be null");
import org.opensearch.common.settings.Setting;
                }
                boolean wasCacheMiss = computedValueTuple.v2().v1();
            if (cacheValueTuple == null) {
    /**
         * Build tiered spillover cache.
                "Cached result parser fn can't be null"
        }
         */
import java.util.LinkedHashMap;
        public Builder<K, V> setDiskCacheSize(long diskCacheSizeInBytes) {
    TieredSpilloverCache(Builder<K, V> builder) {
         */
    }
import org.opensearch.common.annotation.ExperimentalApi;
        private Tuple<V, Tuple<Boolean, Boolean>> compute(
    @Override
                builder.cacheFactories
import java.util.concurrent.atomic.AtomicBoolean;
        /**
        }
                    .setValueType(builder.cacheConfig.getValueType())
                .get(settings);
        }
                    .setExpireAfterAccess(builder.cacheConfig.getExpireAfterAccess())
            List<String> dimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, removedFromTierValue);
            statsHolder.reset();
            tieredSpilloverCacheSegments[i] = new TieredSpilloverCacheSegment<K, V>(
    Iterable<ICacheKey<K>> getDiskCacheKeys() {
                .get(settings)
                    .setSegmentCount(1) // We don't need to make underlying caches multi-segmented
        public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
            for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
        public Builder<K, V> setNumberOfSegments(int numberOfSegments) {
         */
import org.opensearch.common.cache.CacheType;
            }
                    // Rest will fetch existing future and wait on that to complete.
         * Get a value from the tiered cache, and the name of the tier it was found in.
                currentIterator.remove();
            @Override
public class TieredSpilloverCache<K, V> implements ICache<K, V> {
        }
                    }
     * @param <V> Type of value
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
            statsHolder.decrementItems(dimensionValues);
     * Factory to create TieredSpilloverCache objects.
    public void refresh() {
            if (future == null) {
            return this;
        private long onHeapCacheSizeInBytes;
            }
        // Count for all the tiers irrespective of whether they are enabled or not. As eventually
import org.apache.logging.log4j.Logger;
                    }
                .setDiskCacheSize(diskCacheSize)
         */
        public Iterator<K> iterator() {
            this.cacheConfig = cacheConfig;
        if (onHeapCachePerSegmentSizeInBytes <= 0) {
        for (int i = 0; i < numberOfSegments; i++) {
                                return new Tuple<>(value, tierValue);
 *
            Tuple<V, String> cacheValueTuple = getValueFromTieredCache(true).apply(key);
            this.onDiskRemovalListener = new DiskTierRemovalListener(this);
                // Handle stats for an initial hit from getValueFromTieredCache()
        List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();
         * Set cache type.
         * @return builder
                .setNumberOfSegments(numberOfSegments)
 * then items are eventually evicted from it and removed which will result in cache miss.
                statsHolder,
         * only once.
 * The OpenSearch Contributors require contributions made to
        public ImmutableCacheStatsHolder stats(String[] levels) {
        /**
                } else if (cacheValueTuple.v2().equals(TIER_DIMENSION_VALUE_DISK)) {
        }
                                logger.warn("Exception occurred while putting item onto heap cache", e);
                }
/*
            if (!cacheFactories.containsKey(diskCacheStoreName)) {
                    logger.warn("Exception occurred while putting item to disk cache", ex);
         * Defines cache name
            Function<V, CachedQueryResult.PolicyValues> cachedResultParser = Objects.requireNonNull(
                )
        /**
        }
            }
        // pkg-private for testing
            return this;
        }
                            }
        /**
    TieredSpilloverCacheSegment<K, V> getTieredCacheSegment(ICacheKey<K> key) {
        /**
                            } catch (Exception e) {
        ) {
        public void refresh() {
import org.opensearch.common.collect.Tuple;
                        // Register a miss for the heap cache, and the disk cache if present
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
                // If the value was rejected by policy, it counts as neither a hit or miss.
import org.apache.logging.log4j.LogManager;
            String onHeapCacheStoreName = onHeapSetting.get(settings);
         * @return builder
         * @return builder
                }
    /**
        this.dimensionNames = builder.cacheConfig.getDimensionNames();
                    value = loader.load(key);
    @Override
            statsHolder.incrementItems(dimensionValues);
        }
            public void onRemoval(RemovalNotification<ICacheKey<K>, V> notification) {
                                didAddToCache = true;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;
            TimeValue tookTimePolicyThreshold = TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType).get(settings);
            int numberOfSegments = TIERED_SPILLOVER_SEGMENTS.getConcreteSettingForNamespace(cacheType.getSettingPrefix()).get(settings);
                }
        builder.cacheConfig.getClusterSettings()
                    .setKeyType(builder.cacheConfig.getKeyType())
            }
         * @return TieredSpilloverCache
            // we will see all misses. Instead, handle stats in computeIfAbsent().
         * @param cacheType Cache type
            return diskCache;
    private static final Logger logger = LogManager.getLogger(TieredSpilloverCache.class);
 * @param <V> Type of value
        /**
        return new ConcatenatedIterables<>(iterables);
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
        }
import org.opensearch.common.cache.RemovalNotification;
        public long count() {
            }
            return diskCacheMaxWeight;
                    Tuple<Tuple<ICacheKey<K>, V>, Boolean> futureTuple = future.get();
            if (!VALID_SEGMENT_COUNT_VALUES.contains(numberOfSegments)) {
        void updateStatsOnPut(String destinationTierValue, ICacheKey<K> key, V value) {
            List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();
                    .setStoragePath(builder.cacheConfig.getStoragePath())
        return tieredSpilloverCacheSegment.computeIfAbsent(key, loader);
        /**
                                updateStatsOnPut(TIER_DIMENSION_VALUE_ON_HEAP, key, pair.v2());
                        statsHolder.incrementHits(heapDimensionValues);
                if (value == null) {
        }
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP;
                }
            }
     * iterator supports it.
            }
                        if (ex != null) {
 * and the items evicted from on heap cache are moved to disk based cache. If disk based cache also gets full,
         * Set onHeap cache factory
                                    statsHolder.incrementHits(dimensionValues);
                cacheEntry.getKey().close();
        public Builder<K, V> setOnHeapCacheSizeInBytes(long onHeapCacheSizeInBytes) {
         */
            boolean wasEvicted,
         * @param cacheFactories cache factories
                config.getCachedResultParser(),
        }
         */
            ICacheKey<K> key,
                future = completableFutureMap.get(key);
                    .setCacheAlias("tiered_on_heap#" + segmentNumber)
            );
         */
         * Default constructor
        List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private CacheType cacheType;
        /**
            Setting<String> onDiskSetting = TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_NAME.getConcreteSettingForNamespace(
        public static final String TIERED_SPILLOVER_CACHE_NAME = "tiered_spillover";
        tieredSpilloverCacheSegment.invalidate(key);
                }
        }
                    cacheEntry.getKey().invalidateAll();
import org.opensearch.common.cache.ICache;
import java.io.IOException;
                .addPolicy(
        private class DiskTierRemovalListener implements RemovalListener<ICacheKey<K>, V> {
        private final RemovalListener<ICacheKey<K>, V> onDiskRemovalListener;
            private final Iterator<T>[] iterators;
                    .setWeigher(builder.cacheConfig.getWeigher())
                    // Miss for the heap tier, hit for the disk tier
    }
        long onHeapCacheEntries = 0;
            CompletableFuture<Tuple<Tuple<ICacheKey<K>, V>, Boolean>> future = null;
    @SuppressWarnings({ "unchecked", "rawtypes" })
                    } else {
            // Don't capture stats in the initial getValueFromTieredCache(). If we have concurrent requests for the same key,
     * ConcatenatedIterables which combines cache iterables and supports remove() functionality as well if underlying
    // Package private for testing.
        tieredSpilloverCacheSegment.put(key, value);
            String diskCacheStoreName = onDiskSetting.get(settings);
        return tieredSpilloverCacheSegment.get(key);
        private final List<Predicate<V>> policies;
                onHeapCachePerSegmentSizeInBytes,
    public void close() throws IOException {
            // and it only has to be loaded one time, we should report one miss and the rest hits. But, if we do stats in
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_DISK_STORE_SIZE;
        }
    public void invalidate(ICacheKey<K> key) {
        }
                            String tierValue = cacheEntry.getValue().tierName;
                }
            }
            this.policies = builder.policies;
        private final TieredSpilloverCacheStatsHolder statsHolder;
            public void remove() {
 * @param <K> Type of key
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);
        public Builder<K, V> setDiskCacheFactory(ICache.Factory diskCacheFactory) {
            throw new IllegalArgumentException("Per segment size for disk cache within Tiered cache should be " + "greater than 0");
        }
            this.cacheFactories = cacheFactories;
            boolean canCacheOnDisk = caches.get(diskCache).isEnabled()
import java.util.concurrent.CompletableFuture;
     * This map is used to handle concurrent requests for same key in computeIfAbsent() to ensure we load the value
    public Iterable<ICacheKey<K>> keys() {
    @Override
    @Override
                        TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType)
                .addDiskPolicy(
                } else {
                        config.getClusterSettings(),
                    exceptionOccurredOnDiskCachePut = true;
            }
     * only once.
import org.opensearch.common.settings.Settings;
                for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
        return diskCacheEntries;
                }
            iterableList.add(tieredSpilloverCacheSegments[iter].onHeapCache.keys());
    int getNumberOfSegments() {
                            } else if (captureStats) {
                        TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType)
                }
                }
                } catch (InterruptedException ex) {
        public void invalidate(ICacheKey<K> key) {
    long diskCacheCount() {
            iterableList.add(tieredSpilloverCacheSegments[iter].keys());
            private Iterator<T> currentIterator;
        }
                )
                            V value = cacheEntry.getKey().get(key);
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
        private ICache.Factory onHeapCacheFactory;
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);
        private Map<String, ICache.Factory> cacheFactories;
}
    }
        ConcatenatedIterables(Iterable<K>[] iterables) {
     */
            tieredSpilloverCacheSegments[iter].invalidateAll();
        @Override
            return true;
                // Close all the caches here irrespective of whether they are enabled or not.
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
                builder.cacheType,
        private final ICache<K, V> diskCache;
                new CacheConfig.Builder<K, V>().setRemovalListener(onDiskRemovalListener)
            }
                    // Handle stats
            Iterator<K>[] iterators = (Iterator<K>[]) new Iterator<?>[iterables.length];
            Settings settings = config.getSettings();
                            // Get the tier value corresponding to this cache
        }
import static org.opensearch.common.cache.settings.CacheSettings.VALID_SEGMENT_COUNT_VALUES;
    }
        return tieredSpilloverCacheSegments.length;
            return this;
                removalListener.onRemoval(notification);
                                // listeners/stats. Needs better exception handling at underlying layers.For now swallowing
        @Override
                cacheValueTuple = getValueFromTieredCache(false).apply(key);
                this.tsc = tsc;
                if (!wasRejectedByPolicy) {
            } else if (key.key != null) {
                throw new IllegalArgumentException(
        }
                            }
        }
         * @param numberOfSegments number of segments
            } else {
                return computedValueTuple.v1();
            ICacheKey<K> key = notification.getKey();
            statsHolder.decrementSizeInBytes(dimensionValues, weigher.applyAsLong(key, value));
    }
        }
            // this key/value pair was rejected by the policies,
        @Override
    }
                    if (currentIteratorIndex == iterators.length) {
            @Override
    private final TieredSpilloverCacheStatsHolder statsHolder;
                tsc.handleRemovalFromDiskTier(notification);
    @SuppressWarnings({ "unchecked" })
                    currentIteratorIndex++;
        @Override
                builder.cacheType,
        return new ConcatenatedIterables<>(iterables);
                        onHeapCache.put(key, value);
     * Builder object for tiered spillover cache.
            ICache.Factory diskCacheFactory = cacheFactories.get(diskCacheStoreName);
                return currentIterator.next();
                    .setKeySerializer(builder.cacheConfig.getKeySerializer())
            boolean exceptionOccurredOnDiskCachePut = false;
         */
         * Sets number of segments for tiered cache
        TieredSpilloverCacheSegment<K, V> tieredSpilloverCacheSegment = getTieredCacheSegment(key);
        }
                countEvictionTowardsTotal = true;
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
        }
                // the value once.
        }
        // Pass "tier" as the innermost dimension name, in addition to whatever dimensions are specified for the cache as a whole
                while (!currentIterator.hasNext()) {
            public ConcatenatedIterator(Iterator<T>[] iterators) {
            }
                }
                } catch (Exception ex) {
                future.handle(handler);
 */
                    .setStatsTrackingEnabled(false)
         * Set cache factories
            public boolean hasNext() {
         * @return A tuple of the value and the name of the tier it was found in.
                    value = futureTuple.v1().v2();
            }
            }
            this.onHeapCacheFactory = onHeapCacheFactory;
            @Override
            for (int i = 0; i < iterables.length; i++) {
                    try (ReleasableLock ignore = writeLock.acquire()) {
                }
    private final int numberOfSegments;
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TIERED_SPILLOVER_SEGMENTS;
                // If the value is not going to the disk cache, send this notification to the TSC's removal listener
                cacheType.getSettingPrefix()
import java.util.Map;
 *
                    throw new IllegalStateException(ex);
                        boolean rejectedByPolicy = pairInfo.v2();
        long getOnHeapCacheMaxWeight() {
        }
                        config.getClusterSettings(),
            return new Builder<K, V>().setDiskCacheFactory(diskCacheFactory)
                            }
                tsc.handleRemovalFromHeapTier(notification);
        /**
         * Default constructor
            return this;
                boolean wasRejectedByPolicy = computedValueTuple.v2().v2();
        }
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {
        private final List<Predicate<V>> diskPolicies;
                    }
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;
package org.opensearch.cache.common.tier;
            this.diskCacheMaxWeight = diskCacheSizeInBytes;
         * @param onHeapCacheFactory Factory for onHeap cache.
                    throw new ExecutionException(npe);
        public void close() throws IOException {
    /**
                            logger.warn("Exception occurred while trying to compute the value", ex);
                    // TODO: Catch specific exceptions. Needs better exception handling. We are just swallowing exception
@ExperimentalApi
        /**
            }
        private ToLongBiFunction<ICacheKey<K>, V> weigher;
         * Set disk cache factory
            .addSettingsUpdateConsumer(DISK_CACHE_ENABLED_SETTING_MAP.get(builder.cacheType), this::enableDisableDiskCache);
            // When disk cache is disabled, we are not clearing up the disk cache entries yet as that should be part of
            @Override
            }
                .build();
            String removedFromTierValue,
        }
            boolean wasEvicted = SPILLOVER_REMOVAL_REASONS.contains(notification.getRemovalReason());
        private final List<Predicate<V>> diskPolicies = new ArrayList<>();
            }
                    throw new ExecutionException(ex);
                                if (captureStats) {
    // possible right now because of the way computeIfAbsent is implemented.
        @Override
        private final long onHeapCacheMaxWeight;
                try {
    Iterable<ICacheKey<K>> getOnHeapCacheKeys() {
                        }
                    .build(),
        @Override
            if (!canCacheOnDisk || exceptionOccurredOnDiskCachePut) {
                    completableFutureMap.remove(key);// Remove key from map as not needed anymore.
        final Iterable<K>[] iterables;
        // Removal listener from the spillover cache as a whole
            this.statsHolder = statsHolder;
            LinkedHashMap<ICache<K, V>, TierInfo> cacheListMap = new LinkedHashMap<>();
            }
         * @return buider
                            boolean didAddToCache = false;
        Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
            this.diskCache = builder.diskCacheFactory.create(
            Boolean isDiskCacheEnabled = DISK_CACHE_ENABLED_SETTING_MAP.get(builder.cacheType).get(builder.cacheConfig.getSettings());
            long onHeapCacheSizeInBytes,
    }
            Objects.requireNonNull(builder.diskCacheFactory, "disk cache builder can't be null");
    public static class TieredSpilloverCacheFactory implements ICache.Factory {
                }
     */
import org.opensearch.common.cache.RemovalListener;
import org.opensearch.common.cache.policy.CachedQueryResult;
            long diskCacheSize = TIERED_SPILLOVER_DISK_STORE_SIZE.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
                    if (pairInfo != null) {
        return statsHolder.count();
            this.isEnabled = new AtomicBoolean(isEnabled);
                    .setDimensionNames(builder.cacheConfig.getDimensionNames())
            return new ConcatenatedIterator<>(iterators);
            updateStatsOnRemoval(TIER_DIMENSION_VALUE_DISK, wasEvicted, notification.getKey(), notification.getValue(), true);
                if (!exceptionOccurredOnDiskCachePut) {
                iterableList.add(cacheEntry.getKey().keys());
                    updateStatsOnPut(TIER_DIMENSION_VALUE_DISK, key, notification.getValue());
                        if (cacheEntry.getValue().isEnabled()) {
    // Package private for testing.
                // Add the value to the onHeap cache. We are calling computeIfAbsent which does another get inside.
        public Builder<K, V> addDiskPolicy(Predicate<V> diskPolicy) {
import java.util.List;
        }
         */
/**
        final String tierName;
        TieredSpilloverCacheSegment(
                                entry.getKey().put(key, value);
            Tuple<V, String> cacheValueTuple;
         * @return builder
            );
                try {
            }
    public long count() {
         * @return builder
                try {
                cacheType.getSettingPrefix()
                try (ReleasableLock ignore = readLock.acquire()) {
         * Set a cache policy to be used to limit access to this cache's disk tier.
                    }
        }
import org.opensearch.common.cache.ICacheKey;
                .setCacheType(cacheType)
         * @param cacheConfig cache config.
        ) throws Exception {
            Objects.requireNonNull(builder.cacheConfig.getClusterSettings(), "cluster settings can't be null");
            try (ReleasableLock ignore = writeLock.acquire()) {
        this.statsHolder.setDiskCacheEnabled(isDiskCacheEnabled);
        }
        public Builder<K, V> setCacheType(CacheType cacheType) {
            Objects.requireNonNull(builder.cacheConfig.getStoragePath(), "Storage path shouldn't be null");
            Objects.requireNonNull(builder.onHeapCacheFactory, "onHeap cache builder can't be null");
                for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
        static class ConcatenatedIterator<T> implements Iterator<T> {
            return this;
                        }
        Boolean isDiskCacheEnabled = DISK_CACHE_ENABLED_SETTING_MAP.get(builder.cacheType).get(builder.cacheConfig.getSettings());
                        tookTimePolicyThreshold,
        // Policies guarding access to the disk tier.
                    "No associated onHeapCache found for tieredSpilloverCache for " + "cacheType:" + cacheType
        private long diskCacheSizeInBytes;
            this.statsHolder.setDiskCacheEnabled(isDiskCacheEnabled);
            return cacheValueTuple.v1();
            int segmentNumber,
                );
import java.util.function.ToLongBiFunction;
            List<String> diskDimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, TIER_DIMENSION_VALUE_DISK);
            cacheListMap.put(onHeapCache, new TierInfo(true, TIER_DIMENSION_VALUE_ON_HEAP));
            );
                    }
            Objects.requireNonNull(builder.cacheConfig, "cache config can't be null");
            return this;
    }
                        if (pair != null && !rejectedByPolicy) {
                diskCachePerSegmentSizeInBytes
        private class HeapTierRemovalListener implements RemovalListener<ICacheKey<K>, V> {
                } catch (Exception ex) {
        @Override
                    }
        public Iterable<ICacheKey<K>> keys() {
            return key -> {
        public Builder<K, V> setOnHeapCacheFactory(ICache.Factory onHeapCacheFactory) {
            this.onHeapCacheMaxWeight = onHeapCacheSizeInBytes;
            private int currentIteratorIndex;
            statsHolder.incrementSizeInBytes(dimensionValues, weigher.applyAsLong(key, value));
        private final List<Predicate<V>> policies = new ArrayList<>();
                return true;
     * @return An iterable over (onHeap + disk) keys
            return onHeapCache;
import java.util.NoSuchElementException;
                    // A hit for the heap tier
                    String.format(Locale.ROOT, INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE, TIERED_SPILLOVER_CACHE_NAME)
                    future = completableFutureMap.putIfAbsent(key, new CompletableFuture<>());
                if (!policy.test(value)) {
         * @return builder
        }
                    )
            return this;
        public String getCacheName() {
                    future.completeExceptionally(npe);
            return this;
        public void invalidateAll() {
                    return false;
        ) {
     */
            this.diskCacheSizeInBytes = diskCacheSizeInBytes;
    static final String ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE = "Segment count cannot be less than one for tiered cache";
        }
        public TieredSpilloverCache<K, V> build() {
            public T next() {
        @SuppressWarnings({ "unchecked" })
         */
        private RemovalListener<ICacheKey<K>, V> removalListener;
                    future.complete(new Tuple<>(new Tuple<>(key, value), wasRejectedByPolicy));
         * @return builder
                .setOnHeapCacheSizeInBytes(onHeapCacheSize)
            this.policies.add(policy);
            boolean wasEvicted = SPILLOVER_REMOVAL_REASONS.contains(notification.getRemovalReason());
            int numberOfSegments,
            };
        // pkg-private for testing
                        if (caches.get(diskCache).isEnabled()) {
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
                if (cacheValueTuple == null) {
            removalListener.onRemoval(notification);
import java.util.Locale;
            return isEnabled.get();
                                }
                    if (wasCacheMiss) {
            if (evaluatePoliciesList(value, policies)) {
            private final TieredSpilloverCacheSegment<K, V> tsc;
                    // in this case as it shouldn't cause upstream request to fail.
                    .setClusterSettings(builder.cacheConfig.getClusterSettings())
        }
            tieredSpilloverCacheSegments[iter].close();
    }
         * @return builder
                                // exception.
            return onHeapCacheMaxWeight;
    // In future we want to just read the stats from the individual tiers' statsHolder objects, but this isn't
    public V get(ICacheKey<K> key) {
            }
    // Package private for testing.
        }
         * Set a cache policy to be used to limit access to this cache.
            @Override
                    updateStatsOnPut(TIER_DIMENSION_VALUE_ON_HEAP, key, value);
            this.weigher = Objects.requireNonNull(builder.cacheConfig.getWeigher(), "Weigher can't be null");
         * @param onHeapCacheSizeInBytes size of onHeap cache in bytes
                statsHolder.removeDimensions(key.dimensions);
    }
                    cacheEntry.getKey().refresh();
        }
            throw new IllegalArgumentException(ZERO_SEGMENT_COUNT_EXCEPTION_MESSAGE);
                    updateStatsOnPut(cacheValueTuple.v2(), key, value);
                }
         */
                // This is needed as there can be many requests for the same key at the same time and we only want to load
            }
        // this will turn to zero once cache is cleared up either via invalidation or manually.
                    }
            this.removalListener = removalListener;
                    new TookTimePolicy<>(
            Tuple<V, String> cacheValueTuple = getValueFromTieredCache(true).apply(key);
         * Sets onHeap cache size
import org.opensearch.common.cache.LoadAwareCacheLoader;
                    .setSettings(builder.cacheConfig.getSettings())
            return this;
                builder.cacheFactories
                }
    }
        long getDiskCacheMaxWeight() {
        TierInfo(boolean isEnabled, String tierName) {
            Builder<K, V> builder,
                    NullPointerException npe = new NullPointerException("Loader returned a null value");
        return onHeapCacheEntries;
            onHeapCacheEntries += tieredSpilloverCacheSegments[iter].onHeapCache.count();
 */
 * @opensearch.experimental
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
        }
 * This cache spillover the evicted items from heap tier to disk tier. All the new items are first cached on heap
    }
        }
        boolean evaluatePoliciesList(V value, List<Predicate<V>> policiesList) {
import java.util.concurrent.locks.ReadWriteLock;
        }
                    .setValueType(builder.cacheConfig.getValueType())
import java.util.concurrent.locks.ReentrantReadWriteLock;
        private final RemovalListener<ICacheKey<K>, V> removalListener;
                throw new IllegalArgumentException(
                        }
import java.util.Iterator;
import java.util.Objects;
                if (!hasNext()) {
                    .setKeyType(builder.cacheConfig.getKeyType())
         * This map is used to handle concurrent requests for same key in computeIfAbsent() to ensure we load the value
        this.numberOfSegments = builder.numberOfSegments;
                iterators[i] = iterables[i].iterator();
        /**
    @Override
        long diskCacheEntries = 0;
    }
        }
            tieredSpilloverCacheSegments[iter].refresh();
                    currentIterator = iterators[currentIteratorIndex];
                && evaluatePoliciesList(notification.getValue(), diskPolicies);
            this.caches = Collections.synchronizedMap(cacheListMap);
    }
        /**
        private int numberOfSegments;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
        @Override
import org.opensearch.common.util.concurrent.ReleasableLock;
    public void put(ICacheKey<K> key, V value) {
        Objects.requireNonNull(builder.cacheConfig.getSettings(), "settings can't be null");
                .setRemovalListener(config.getRemovalListener())
            }
                    .setStatsTrackingEnabled(false)
        }
    /**
        long onHeapCachePerSegmentSizeInBytes = builder.onHeapCacheSizeInBytes / this.numberOfSegments;
        }
            boolean wasCacheMiss = false;
        }
            }
            };
            try (ReleasableLock ignore = readLock.acquire()) {
    }
        }
        /**
        void updateStatsOnRemoval(
        this.statsHolder = new TieredSpilloverCacheStatsHolder(dimensionNames, isDiskCacheEnabled);
                i + 1,
                        Tuple<ICacheKey<K>, V> pair = pairInfo.v1();
        private final long diskCacheMaxWeight;
        if (builder.numberOfSegments <= 0) {
    /**
            private final TieredSpilloverCacheSegment<K, V> tsc;
                this.currentIterator = iterators[currentIteratorIndex];
    @Override
                .setCacheConfig(config)
        }
            BiFunction<Tuple<Tuple<ICacheKey<K>, V>, Boolean>, Throwable, Void> handler = (pairInfo, ex) -> {
        }
            if (canCacheOnDisk) {
        return new ConcatenatedIterables<>(iterables);
            for (Predicate<V> policy : policiesList) {
                    .setDimensionNames(builder.cacheConfig.getDimensionNames())
    @Override
                throw new IllegalArgumentException(
import java.util.concurrent.ExecutionException;
        long diskCachePerSegmentSizeInBytes = builder.diskCacheSizeInBytes / this.numberOfSegments;
                if (cacheValueTuple.v2().equals(TIER_DIMENSION_VALUE_ON_HEAP)) {
            for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
            LoadAwareCacheLoader<ICacheKey<K>, V> loader,
            return null;
                        statsHolder.incrementMisses(heapDimensionValues);
        Map<ICacheKey<K>, CompletableFuture<Tuple<Tuple<ICacheKey<K>, V>, Boolean>>> completableFutureMap = new ConcurrentHashMap<>();
 * SPDX-License-Identifier: Apache-2.0
    private static class TierInfo {
                            }
        return tieredSpilloverCacheSegments[getSegmentNumber(key)];
import java.util.ArrayList;
                        }
                return null;
        @Override
        return key.hashCode() & (this.numberOfSegments - 1);
        this.tieredSpilloverCacheSegments = new TieredSpilloverCacheSegment[this.numberOfSegments];
        }
        ReleasableLock readLock = new ReleasableLock(readWriteLock.readLock());
        @Override
            if (key.getDropStatsForDimensions()) {
            return new ConcatenatedIterables<>(iterables);
        /**
                                // TODO: Catch specific exceptions to know whether this resulted from cache or underlying removal
         */
     */
        ICache<K, V> getDiskCache() {
                        cachedResultParser,
                    return null;
         */
         * @param diskCacheFactory Factory for disk cache.
        boolean isEnabled() {
            }
    }
 * compatible open source license.
            this.onHeapCache = builder.onHeapCacheFactory.create(
    private static final List<RemovalReason> SPILLOVER_REMOVAL_REASONS = List.of(RemovalReason.EVICTED, RemovalReason.CAPACITY);
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
                for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
         */
                            if (cacheValueTuple.v2().equals(entry.getValue().tierName)) {
        ReleasableLock writeLock = new ReleasableLock(readWriteLock.writeLock());
                this.iterators = iterators;
        for (int iter = 0; iter < this.numberOfSegments; iter++) {
    }
        }
         * Sets disk cache siz
                    .build(),
         * @param diskCacheSizeInBytes size of diskCache in bytes
            throw new IllegalArgumentException("Per segment size for onHeap cache within Tiered cache should be " + "greater than 0");
                    statsHolder.incrementHits(heapDimensionValues);
import java.util.function.Predicate;
            }
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
         */
                    statsHolder.incrementMisses(heapDimensionValues);
        /**
                    // Only one of the threads will succeed putting a future into map for the same key.
                this.numberOfSegments,
    int getSegmentNumber(ICacheKey<K> key) {
                        cacheEntry.getKey().invalidate(key);
            boolean wasRejectedByPolicy = false;
            HeapTierRemovalListener(TieredSpilloverCacheSegment<K, V> tsc) {
        List<Iterable<ICacheKey<K>>> iterableList = new ArrayList<>();
                    } else {
            TieredSpilloverCacheStatsHolder statsHolder,
        private CacheConfig<K, V> cacheConfig;
    }
        // Package private for testing
        }
    }
    @Override
    long onHeapCacheCount() {
    static class TieredSpilloverCacheSegment<K, V> implements ICache<K, V> {
                    throw new NoSuchElementException();
            if (cacheValueTuple == null) {
        Iterable<ICacheKey<K>>[] iterables = (Iterable<ICacheKey<K>>[]) iterableList.toArray(new Iterable<?>[0]);
    @Override
            return this;
                    wasCacheMiss = !wasRejectedByPolicy;
                .getBytes();
     * Provides an iteration over both onHeap and disk keys. This is not protected from any mutations to the cache.
        public Builder<K, V> setCacheConfig(CacheConfig<K, V> cacheConfig) {
         * A class which receives removal events from the disk tier.
                this.currentIteratorIndex = 0;
            );
        AtomicBoolean isEnabled;
import org.opensearch.common.cache.store.config.CacheConfig;
     * @param <K> Type of key.
            diskCacheEntries += tieredSpilloverCacheSegments[iter].diskCache.count();
     */
            try (ReleasableLock ignore = writeLock.acquire()) {
    @SuppressWarnings({ "unchecked" })
        /**
            V value = null;
        }
        // Removal listeners for the individual tiers
         * @return builder
                    "No associated diskCache found for tieredSpilloverCache for " + "cacheType:" + cacheType
         * Set cache config.
    }
         */
         * @param removalListener Removal listener
            this.diskCacheFactory = diskCacheFactory;
            tieredSpilloverCacheSegments[iter].enableDisableDiskCache(isDiskCacheEnabled);
            this.iterables = iterables;
            this.onHeapRemovalListener = new HeapTierRemovalListener(this);
        private ICache.Factory diskCacheFactory;
        public Builder<K, V> setRemovalListener(RemovalListener<ICacheKey<K>, V> removalListener) {
                builder,
            return onHeapCache.count() + diskCache.count();
        ICache<K, V> getOnHeapCache() {
        /**
                    .setMaxSizeInBytes(diskCacheSizeInBytes)
            Setting<String> onHeapSetting = TieredSpilloverCacheSettings.TIERED_SPILLOVER_ONHEAP_STORE_NAME.getConcreteSettingForNamespace(
        if (diskCachePerSegmentSizeInBytes <= 0) {
                    new TookTimePolicy<>(
        public Builder<K, V> addPolicy(Predicate<V> policy) {
    public void invalidateAll() {
        public void put(ICacheKey<K> key, V value) {
import java.util.function.BiFunction;
            ICache.Factory onHeapCacheFactory = cacheFactories.get(onHeapCacheStoreName);
        void enableDisableDiskCache(Boolean isDiskCacheEnabled) {
import java.util.function.Function;
        private final RemovalListener<ICacheKey<K>, V> onHeapRemovalListener;
    private final List<String> dimensionNames;
    void enableDisableDiskCache(Boolean isDiskCacheEnabled) {
         */
        private final ICache<K, V> onHeapCache;
            iterableList.add(tieredSpilloverCacheSegments[iter].diskCache.keys());
                    diskCache.put(key, notification.getValue()); // spill over to the disk tier and increment its stats
         */
            TimeValue tookTimeDiskPolicyThreshold = TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(cacheType).get(settings);
    }
        private Function<ICacheKey<K>, Tuple<V, String>> getValueFromTieredCache(boolean captureStats) {
import java.util.concurrent.ConcurrentHashMap;
                                onHeapCache.put(pair.v1(), pair.v2());
                Tuple<V, Tuple<Boolean, Boolean>> computedValueTuple = compute(key, loader, future);
        }
            );
            return this;
            // getValueFromTieredCache(),
import org.opensearch.common.cache.RemovalReason;
                    .setWeigher(builder.cacheConfig.getWeigher())
                            if (didAddToCache) {
    // Used to avoid caching stale entries in lower tiers.
        // Policies guarding access to the cache overall.
                            try (ReleasableLock ignore = writeLock.acquire()) {
        // Package private for testing
            List<String> dimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, destinationTierValue);
            if (!cacheFactories.containsKey(onHeapCacheStoreName)) {
            DiskTierRemovalListener(TieredSpilloverCacheSegment<K, V> tsc) {
            List<String> heapDimensionValues = statsHolder.getDimensionsWithTierValue(key.dimensions, TIER_DIMENSION_VALUE_ON_HEAP);
            // separate cache/clear API.
            // or exception as an input and returns the value. Also before returning value, puts the value in cache if accepted by policies.
                // as the value is leaving the TSC entirely
        void handleRemovalFromHeapTier(RemovalNotification<ICacheKey<K>, V> notification) {
            ICacheKey<K> key,
                    try (ReleasableLock ignore = writeLock.acquire()) {
            this.tierName = tierName;
                    // In case it is not present in any tier, put it inside onHeap cache by default.
    // Package private for testing.
    static class ConcatenatedIterables<K> implements Iterable<K> {
                }
            long onHeapCacheSize = TIERED_SPILLOVER_ONHEAP_STORE_SIZE.getConcreteSettingForNamespace(cacheType.getSettingPrefix())
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP;
            this.diskPolicies = builder.diskPolicies; // Will never be null; builder initializes it to an empty list
         * @return builder
            boolean countEvictionTowardsTotal
        private final Map<ICache<K, V>, TierInfo> caches;
            return new Tuple<>(value, new Tuple<>(wasCacheMiss, wasRejectedByPolicy));
                    .setMaxSizeInBytes(onHeapCacheSizeInBytes)
                    for (Map.Entry<ICache<K, V>, TierInfo> cacheEntry : caches.entrySet()) {
                this.tsc = tsc;
                .setOnHeapCacheFactory(onHeapCacheFactory)
    final TieredSpilloverCacheSegment<K, V>[] tieredSpilloverCacheSegments;
                } finally {
    Map<ICacheKey<K>, CompletableFuture<Tuple<ICacheKey<K>, V>>> completableFutureMap = new ConcurrentHashMap<>();
            } else {
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
            // Values removed from the disk tier leave the TSC entirely
                    wasRejectedByPolicy = futureTuple.v2();
                        // Another thread requesting this key already loaded the value. Register a hit for the heap cache
        public Builder() {}
                    .setCacheAlias("tiered_disk_cache#" + segmentNumber)
        }
                        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cache.common.policy.TookTimePolicy;
            this.cacheType = cacheType;
                    .setSettings(builder.cacheConfig.getSettings())
            );
                            if (value != null) {
        }
            V value,
            updateStatsOnRemoval(TIER_DIMENSION_VALUE_ON_HEAP, wasEvicted, key, notification.getValue(), countEvictionTowardsTotal);
    @SuppressWarnings({ "unchecked" })
            long diskCacheSizeInBytes
        }
        public V get(ICacheKey<K> key) {
            CompletableFuture<Tuple<Tuple<ICacheKey<K>, V>, Boolean>> future
                && wasEvicted
    }
                );
                    .setSegmentCount(1) // We don't need to make underlying caches multi-segmented
