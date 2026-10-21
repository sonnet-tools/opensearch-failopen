        return value;
     */
    }
        } else {
            if (config.getSegmentCount() > 0) {
                    throw new OpenSearchException(String.format(CACHE_DATA_CLEANUP_DURING_INITIALIZATION_EXCEPTION, this.storagePath), e);
                }
                valueSerializer = (Serializer<V, byte[]>) config.getValueSerializer();
        }
                    break;
                                .get(DISK_WRITE_MIN_THREADS_KEY)
        public boolean hasNext() {
    }
         */
    }
            } catch (ClassCastException e) {
    private final String diskCacheAlias;
            this.diskCacheAlias = diskCacheAlias;
            Serializer<K, byte[]> keySerializer = null;
            return new EhcacheDiskCache<>(this);
    /**
        }
    private static final Logger logger = LogManager.getLogger(EhcacheDiskCache.class);
        }
        if (builder.threadPoolAlias == null || builder.threadPoolAlias.isBlank()) {
         * @return builder
}
        this.ehCacheEventListener = new EhCacheEventListener(builder.getRemovalListener(), builder.getWeigher());
        @Override
            return value;
        private String storagePath;
    public static class Builder<K, V> extends ICacheBuilder<K, V> {
    /**
            // If config value is set, use this instead.
     */
            this.threadPoolAlias = builder.threadPoolAlias;
        return () -> new EhCacheKeyIterator<>(cache.iterator());
            return this;
    public void invalidateAll() {
     */
            } catch (Exception ex) {
        }
            throw new OpenSearchException("Exception occurred while trying to fetch item from ehcache disk cache");
        }
        /**
    /**
                .setExpireAfterAccess((TimeValue) settingList.get(DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY).get(settings))
                builder.setNumberOfSegments(config.getSegmentCount());
            return this;
                return false;
     * If enableStatsTracking is set to false in the builder, always returns 0.
        }
        V value = deserializeValue(cache.get(key));
    @Override
            return this;
                .setRemovalListener(config.getRemovalListener())
        @Override
@ExperimentalApi
                    break;
        this.valueSerializer = Objects.requireNonNull(builder.valueSerializer, "Value serializer shouldn't be null");
         * Constructor for byte array wrapper.
            return null;
                    );
    /**
         * @param isEventListenerModeSync mode sync
package org.opensearch.cache.store.disk;
        }
    // Unique id associated with this cache.
                        .defaultPool(THREAD_POOL_ALIAS_PREFIX + "Default#" + UNIQUE_ID, 1, 3) // Default pool used for other tasks
import org.ehcache.config.builders.CacheManagerBuilder;
     * Necessary due to a limitation in how Ehcache compares byte[].
            return iterator.next().getKey();
        }
    }
        }
        // older disk cache data still lying around.
        this.keySerializer = Objects.requireNonNull(builder.keySerializer, "Key serializer shouldn't be null");
import org.opensearch.common.cache.RemovalNotification;
            }
            cacheStatsHolder.incrementMisses(key.dimensions);
        }
                .setDiskCacheAlias(diskCacheAlias)
        }
                    cacheStatsHolder.decrementSizeInBytes(event.getKey().dimensions, getOldValuePairSize(event));
            return this;
     * @param <V> Type of value
                    PooledExecutionServiceConfigurationBuilder.newPooledExecutionServiceConfigurationBuilder()
            V value = null;
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_SEGMENT_KEY;
                .setWeigher(config.getWeigher())
            return configurationBuilder.asynchronous();
        } else {
    }
                @Override
    PersistentCacheManager buildCacheManager() {
                    return INFINITE;
            EventType.EXPIRED,
         * @param cacheType cache type
import org.opensearch.common.cache.serializer.ICacheKeySerializer;
    /**
        // before V hits ehcache.
    }
        }
     * @param key Type of key
        public String getCacheName() {
         */
        };
import org.ehcache.event.EventType;
                    cacheStatsHolder.decrementItems(event.getKey().dimensions);
                .setValueType(config.getValueType())
            }
    final static String CACHE_DATA_CLEANUP_DURING_INITIALIZATION_EXCEPTION = "Failed to delete ehcache disk cache under "
        @Override
        public ICacheKey<K> next() {
        }
        @Override
    @SuppressWarnings({ "rawtypes" }) // We have to use the raw type as there's no way to pass the "generic class" to ehcache
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_STORAGE_PATH_KEY;
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {
        } catch (CacheLoadingException ex) {
            }
            } else {
        this.valueType = Objects.requireNonNull(builder.valueType, "Value type shouldn't be null");
    }
    // Pkg-private for testing.
import org.opensearch.common.util.io.IOUtils;
    private final String storagePath;
        this.cacheType = Objects.requireNonNull(builder.cacheType, "Cache type shouldn't be null");
            EventType.REMOVED,
            this.storagePath = storagePath;
        /**
         * @param persistenceContext
        if (future == null) {
            }
            future = completableFuture;
        Iterator<Cache.Entry<ICacheKey, ByteArrayWrapper>> iterator;
            ByteArrayWrapper other = (ByteArrayWrapper) o;
    }
                    ICacheKey key,
    }
        }
        public KeySerializerWrapper(Serializer<K, byte[]> internalKeySerializer) {
import org.ehcache.Cache;
                .build(true);
        if (!loader.isLoaded()) {
        try {
        public Builder<K, V> setCacheType(CacheType cacheType) {
        this.expireAfterAccess = Objects.requireNonNull(builder.getExpireAfterAcess(), "ExpireAfterAccess value shouldn't " + "be null");
            Path ehcacheDirectory = Paths.get(this.storagePath);
        }
            this.weigher = weigher;
        if (builder.isEventListenerModeSync) {
        return cacheStatsHolder.getImmutableCacheStatsHolder(levels);
        // TODO: ehcache doesn't provide a way to refresh a cache.
        }
            if (key.key != null) {
                new OffHeapDiskStoreConfiguration(
            return Arrays.equals(arr, object.value);
        }
         * cache after a restart. See https://www.ehcache.org/documentation/3.0/serializers-copiers
                    break;
            iterator.remove(); // Calls underlying ehcache iterator.remove()
    }
    @SuppressForbidden(reason = "Ehcache uses File.io")
            binary.get(arr);
        if (key == null) {
     * Provides a way to iterate over disk cache keys.
     * @param loader loader to load the value in case key is missing
    EhcacheDiskCache(Builder<K, V> builder) {
            this.diskCacheAlias = "ehcacheDiskCache#" + this.cacheType;
import org.ehcache.expiry.ExpiryPolicy;
                ICacheKey.class,
            this.ehCacheEventListener,
            return this;
import org.ehcache.event.CacheEvent;
                value = pair.v2(); // Returning a value itself assuming that a next get should return the same. Should
    /**
        public ByteArrayWrapper read(ByteBuffer binary) throws ClassNotFoundException, SerializerException {
                builder.setMaximumWeightInBytes(maxSizeInBytes);
            return Arrays.hashCode(value);
                case CREATED:
        V value;
        if (this.storagePath == null || this.storagePath.isBlank()) {
    /**
        @Override
        }
    public V get(ICacheKey<K> key) {
    @SuppressForbidden(reason = "Ehcache uses File.io")
            this.serializer = new ICacheKeySerializer<>(internalKeySerializer);
         */
        BiFunction<Tuple<ICacheKey<K>, V>, Throwable, V> handler = (pair, ex) -> {
            int segmentCount = (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType).get(DISK_SEGMENT_KEY).get(settings);
        public void remove() {
import org.ehcache.config.units.MemoryUnit;
        /**
            return serializer.deserialize(arr);
         * This constructor must be present, but does not have to work as we are not actually persisting the disk
         * Default constructor.
    private final Settings settings;
     */
            throw new IllegalArgumentException("Storage path shouldn't be null or empty");
            try {
        }
            } catch (ClassCastException e) {
 */
        return valueSerializer.deserialize(binary.value);
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
            switch (event.getType()) {
    }
import org.opensearch.common.collect.Tuple;
        public static final String EHCACHE_DISK_CACHE_NAME = "ehcache_disk";
        }
        /**
    /**
import java.util.concurrent.CompletableFuture;
    final static int MINIMUM_MAX_SIZE_IN_BYTES = 1024 * 100; // 100KB
        }
    /**
import org.ehcache.spi.loaderwriter.CacheLoadingException;
        try {
         * @return builder
        private Class<V> valueType;
 * The OpenSearch Contributors require contributions made to
        }
         */
                throw new IllegalArgumentException("EhcacheDiskCache requires a key serializer of type Serializer<K, byte[]>");
                    break;
            throw new OpenSearchException("Exception occurred while put item to ehcache disk cache");
            .withService(
                } catch (IOException e) {
            V value;
        /**
 *  @opensearch.experimental
    private final Class<K> keyType;
        this.keyType = Objects.requireNonNull(builder.keyType, "Key type shouldn't be null");
            return this;
        public ByteArrayWrapperSerializer() {}
     */
            )
         * Sets the key serializer for this cache.
            return CacheManagerBuilder.newCacheManagerBuilder()
            .withService(getListenerConfiguration(builder))
    /**
    }
     * Factory to create an ehcache disk cache.
     * @param key Type of key.
                default:
            if (value == null) {
        /**
        return value;
    @Override
        EhCacheKeyIterator(Iterator<Cache.Entry<ICacheKey, ByteArrayWrapper>> iterator) {
                    Supplier<? extends ByteArrayWrapper> oldValue,
    }
    long getMaximumWeight() {
                    return INFINITE;
                    cacheStatsHolder.incrementEvictions(event.getKey().dimensions);
         * Sets the value serializer for this cache.
                public Duration getExpiryForCreation(ICacheKey key, ByteArrayWrapper value) {
        this.cache = buildCache(Duration.ofMillis(expireAfterAccess.getMillis()), builder);
        public Builder<K, V> setStoragePath(String storagePath) {
     * @return current count of keys
            byte[] arr = new byte[binary.remaining()];
import org.ehcache.config.builders.ResourcePoolsBuilder;
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_CONCURRENCY_KEY;
import java.io.IOException;
        public Builder<K, V> setDimensionNames(List<String> dimensionNames) {
                    this.threadPoolAlias,
            return configurationBuilder.synchronous();
         * @return builder
         * @param valueSerializer the value serializer
        }
        }
            value = compute(key, loader);
        } catch (CacheWritingException ex) {
     */
        }
         * @param valueType type of value
            if (config.getMaxSizeInBytes() > 0) {
     * @return value
            return this;
import org.ehcache.PersistentCacheManager;
        if (value == null) {
import org.opensearch.common.cache.RemovalListener;
import java.util.Arrays;
            })
     * Transform a value from V to ByteArrayWrapper, which can be passed to ehcache.
                case REMOVED:
                // In case storage path is not explicitly set by user, use default path.
         * Thread pool alias for the cache.
        /**
        public ByteBuffer serialize(ICacheKey object) throws SerializerException {
                        new RemovalNotification<>(event.getKey(), deserializeValue(event.getOldValue()), RemovalReason.EVICTED)
            if (config.getCacheAlias() != null && !config.getCacheAlias().isBlank()) {
import org.opensearch.OpenSearchException;
            this.cacheStatsHolder = NoopCacheStatsHolder.getInstance();
            return weigher.applyAsLong(event.getKey(), deserializeValue(event.getOldValue()));
            this.threadPoolAlias = THREAD_POOL_ALIAS_PREFIX + "DiskWrite#" + UNIQUE_ID;
        // This is not always feasible or necessary, like for BytesReference. So, we handle the value serialization
                    );
import org.opensearch.common.cache.CacheType;
        private Serializer<V, byte[]> valueSerializer;
        private String threadPoolAlias;
            this.isEventListenerModeSync = isEventListenerModeSync;
        public void onEvent(CacheEvent<? extends ICacheKey<K>, ? extends ByteArrayWrapper> event) {
            // Handle
                cache.put(pair.v1(), serializeValue(pair.v2()));
        private Class<K> keyType;
        /**
                @Override
     */
import java.util.concurrent.ConcurrentHashMap;
    }
    /**
    private Cache<ICacheKey, ByteArrayWrapper> buildCache(Duration expireAfterAccess, Builder<K, V> builder) {
            long maxSizeInBytes = (Long) settingList.get(DISK_MAX_SIZE_IN_BYTES_KEY).get(settings);
         */
            return EHCACHE_DISK_CACHE_NAME;
            cacheStatsHolder.incrementHits(key.dimensions);
            .newCacheConfigurationBuilder(
            completableValue = future.handle(handler);
            }
import java.io.File;
import java.nio.file.Path;
            this.threadPoolAlias = threadPoolAlias;
            Settings settings = config.getSettings();
         */
            completableValue = future.handle(handler);
import org.apache.logging.log4j.Logger;
                    break;
import org.opensearch.common.cache.ICache;
        private long getNewValuePairSize(CacheEvent<? extends ICacheKey<K>, ? extends ByteArrayWrapper> event) {
         */
        try {
         * @param internalKeySerializer serializer for internal key
                ResourcePoolsBuilder.newResourcePoolsBuilder().disk(maxWeightInBytes, MemoryUnit.B)
    // Disk cache. Using ByteArrayWrapper to compare two byte[] by values rather than the default reference checks
    @Override
         * .html#persistent-vs-transient-caches
    final static String THREAD_POOL_ALIAS_PREFIX = "ehcachePool";
        if (this.maxWeightInBytes <= MINIMUM_MAX_SIZE_IN_BYTES) {
            segmentCount = builder.getNumberOfSegments();
import java.nio.ByteBuffer;
import java.util.UUID;
        }
            throw new IllegalStateException(ex);
            byte[] arr = new byte[binary.remaining()];
        if (builder.diskCacheAlias == null || builder.diskCacheAlias.isBlank()) {
         * Desired storage path for disk cache.
import org.ehcache.event.CacheEventListener;
            this.iterator = iterator;
                diskCacheAlias = config.getCacheAlias();
            return this;
         * @return builder
                    cacheStatsHolder.incrementItems(event.getKey().dimensions);
    private V deserializeValue(ByteArrayWrapper binary) {
     * computeIfAbsent method.
            }
        private ICacheKeySerializer<K> serializer;
        /**
import org.opensearch.common.cache.stats.CacheStatsHolder;
    private final Cache<ICacheKey, ByteArrayWrapper> cache;
        public Builder() {}
import org.opensearch.common.cache.ICacheKey;
         *   .html#persistent-vs-transient-caches
         * @param diskCacheAlias disk cache alias
                    cacheStatsHolder.decrementItems(event.getKey().dimensions);
            EhcacheDiskCache.Builder<K, V> builder = (Builder<K, V>) new Builder<K, V>().setStoragePath(storagePath)
        return value;
         */
            throw new RuntimeException(ex);
                }
    @Override
            ).withExpiry(new ExpiryPolicy<>() {
                ) {
        // Handler to handle results post processing. Takes a tuple<key, value> or exception as an input and returns
    /**
    }
        // Creating the cache requires permissions specified in plugin-security.policy
            String diskCacheAlias = (String) settingList.get(DISK_CACHE_ALIAS_KEY).get(settings);
                )
    }
    private final EhCacheEventListener ehCacheEventListener;
        }
        this.storagePath = builder.storagePath;
    public class KeySerializerWrapper implements org.ehcache.spi.serialization.Serializer<ICacheKey> {
import java.util.NoSuchElementException;
            }
                .with(CacheManagerBuilder.persistence(new File(storagePath)))
import java.util.function.BiFunction;
        if (!EhcacheDiskCacheManager.doesCacheManagerExist(cacheType)) {
                case EVICTED:
                    assert event.getNewValue() == null;
                                .get(settings)
        }
            } else {
 *  @param <V> Type of value.
import org.opensearch.common.settings.Setting;
         * Determines whether event listener is triggered async/sync.
            }
        }
        }
        private List<String> dimensionNames;
    private V compute(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
            try {
            byte[] arr = new byte[binary.remaining()];
        }
     * Puts the item into cache.
                .setIsEventListenerModeSync((Boolean) settingList.get(DISK_LISTENER_MODE_SYNC_KEY).get(settings))
import java.util.function.Supplier;
        V value;
        });
    private final PersistentCacheManager cacheManager;
                        new RemovalNotification<>(event.getKey(), deserializeValue(event.getOldValue()), RemovalReason.INVALIDATED)
 * this file be licensed under the Apache-2.0 license or a
            byte[] arr = new byte[binary.remaining()];
    // A Cache manager can create many caches.
    public void invalidate(ICacheKey<K> key) {
        }
        + "path: %s during initialization. Please clean this up manually and restart the process";
                case UPDATED:
        @Override
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MAXIMUM_THREADS_KEY;
                    (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType).get(DISK_WRITE_CONCURRENCY_KEY).get(settings),
 */
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_LISTENER_MODE_SYNC_KEY;
        }
                    IOUtils.rm(ehcacheDirectory);
import java.util.Map;
        }
        @SuppressWarnings({ "unchecked" }) // Required to ensure the serializers output byte[]
        public boolean equals(ICacheKey object, ByteBuffer binary) throws ClassNotFoundException, SerializerException {
    }
    @SuppressForbidden(reason = "Ehcache uses File.io")
                    assert event.getNewValue() == null;
                public Duration getExpiryForUpdate(
            if (o == null || o.getClass() != ByteArrayWrapper.class) {
        public EhcacheDiskCacheFactory() {}
            return Arrays.equals(this.value, other.value);
                cacheStatsHolder.removeDimensions(key.dimensions);
                    long oldSize = getOldValuePairSize(event);
         */
     * This iterator wraps ehCache iterator and only iterates over its keys.
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
    public void refresh() {
                NullPointerException npe = new NullPointerException("loader returned a null value");
            return weigher.applyAsLong(event.getKey(), deserializeValue(event.getNewValue()));
            this.value = value;
                .using(
        int segmentCount = (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType).get(DISK_SEGMENT_KEY).get(settings);
            } else {
                // Since this comes from the TSC, it already has the segment number at the end.
        }
                    this.removalListener.onRemoval(
    private final CacheStatsHolder cacheStatsHolder;
    public void close() {
        /**
        CompletableFuture<Tuple<ICacheKey<K>, V>> completableFuture = new CompletableFuture<>();
    public long count() {
     */
         */
         */
    @Override
            }
            Map<String, Setting<?>> settingList = EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType);
                                                                     // V is an interface, and we pass its
            completableFutureMap.remove(key); // Remove key from map as not needed anymore.
         * @param keySerializer the key serializer
    @SuppressWarnings({ "rawtypes", "unchecked" })
        /**
        public ByteArrayWrapper(byte[] value) {
     * Wrapper over ICacheKeySerializer which is compatible with ehcache's serializer requirements.
        }
    @SuppressWarnings("rawtypes")
    private final Class<V> valueType;
        }
                .setValueSerializer(valueSerializer)
     * @param binary the serialized value
        } catch (InterruptedException ex) {
     * @return the serialized value
import java.util.concurrent.ExecutionException;
                    assert event.getOldValue() == null;
         * @param threadPoolAlias alias
     * Computes the value using loader in case key is not present, otherwise fetches it.
        @Override
         * Sets the desired cache type.
                        // like event listeners
    }
                            this.threadPoolAlias,
import org.opensearch.common.cache.stats.NoopCacheStatsHolder;
        private final RemovalListener<ICacheKey<K>, V> removalListener;
    private final CacheType cacheType;
        public ByteBuffer serialize(ByteArrayWrapper object) throws SerializerException {
        EhcacheDiskCacheManager.closeCache(cacheType, diskCacheAlias, storagePath);
    public ImmutableCacheStatsHolder stats(String[] levels) {
            return iterator.hasNext();
         * @param keyType type of key
        // In case we use multiple ehCaches, we can define this cache manager at a global level.
         */
        List<String> dimensionNames = Objects.requireNonNull(builder.dimensionNames, "Dimension names can't be null");
        public Builder<K, V> setValueType(Class<V> valueType) {
        }
    @Override
         * @param classLoader
         */
            if (storagePath == null || storagePath.isBlank()) {
    final static String UNIQUE_ID = UUID.randomUUID().toString();
        CacheConfigurationBuilder<ICacheKey, ByteArrayWrapper> cacheConfigurationBuilder = CacheConfigurationBuilder
         * Ehcache disk cache name.
        // not performant in case there are multiple concurrent request for same key. Below is our own custom
import org.opensearch.common.cache.serializer.Serializer;
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
    @Override
    // Package private for testing
        public ICacheKey<K> read(ByteBuffer binary) throws ClassNotFoundException, SerializerException {
        // Ehcache doesn't provide any computeIfAbsent function. Exposes putIfAbsent but that works differently and is
        public int hashCode() {
        try {
        /**
                    break;
                future.get(); // call get to force the exception to be thrown for other concurrent callers
            return builder.build();
        this.settings = Objects.requireNonNull(builder.getSettings(), "Settings objects shouldn't be null");
            EventType.CREATED
            value = completableValue.get();
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MIN_THREADS_KEY;
import org.ehcache.spi.loaderwriter.CacheWritingException;
                        .build()
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)
         * Sets the allowed dimension names for keys that will enter this cache.
    }
        @Override
                    );
                keySerializer = (Serializer<K, byte[]>) config.getKeySerializer();
import org.opensearch.common.cache.RemovalReason;
        @Override
        public Builder<K, V> setThreadPoolAlias(String threadPoolAlias) {
    @SuppressWarnings({ "rawtypes", "unchecked" })
                .setCacheType(cacheType)
        public Builder<K, V> setKeySerializer(Serializer<K, byte[]> keySerializer) {
        this.cacheManager = EhcacheDiskCacheManager.getCacheManager(cacheType, this.storagePath, settings, this.threadPoolAlias);
         */
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_CACHE_ALIAS_KEY;
         */
            // If we read the storage path directly from the setting, we have to add the segment number at the end.
            return ByteBuffer.wrap(object.value);
                    cacheStatsHolder.incrementSizeInBytes(event.getKey().dimensions, newSize - oldSize);
    /**
            this.keySerializer = keySerializer;
        Objects.requireNonNull(builder.getRemovalListener(), "Removal listener can't be null");
                value = loader.load(key);
                        .pool(
            if (future.isCompletedExceptionally()) {
                }
import org.opensearch.common.cache.store.config.CacheConfig;
         * @return builder
     */
        // Rest will fetch existing future.
         */
            return serializer.equals(object, arr);
                    cacheStatsHolder.decrementItems(event.getKey().dimensions);
        @Override
        /**
         * @param persistenceContext
    Map<ICacheKey<K>, CompletableFuture<Tuple<ICacheKey<K>, V>>> getCompletableFutureMap() {
                builder.setNumberOfSegments(segmentCount);
                ByteArrayWrapper.class,
            EventType.UPDATED,
 *
    @Override
                cache.remove(key);
            this.dimensionNames = dimensionNames;
        }
import org.ehcache.config.builders.PooledExecutionServiceConfigurationBuilder;
    private ByteArrayWrapper serializeValue(V value) {
     * @param value the value
            // unless statsTrackingEnabled is explicitly set to false in CacheConfig.
     * @throws Exception when either internal get or put calls fail.
        return maxWeightInBytes;
     * Wrapper over Ehcache original listener to listen to desired events and notify desired subscribers.
     * Used in computeIfAbsent to synchronize loading of a given key. This is needed as ehcache doesn't provide a
            this.keyType = keyType;
        // Only one of the threads will succeed putting a future into map for the same key.
        return cacheStatsHolder.count();
     */
import org.opensearch.common.annotation.ExperimentalApi;
            cache.put(key, serializeValue(value));
                @Override
        if (value != null) {
            this.valueType = valueType;
                                .get(settings),
         * @return builder
         * @return builder
import org.ehcache.config.builders.CacheConfigurationBuilder;
        public Builder<K, V> setDiskCacheAlias(String diskCacheAlias) {
            if (pair != null) {
            return this;
         *   cache after a restart. See https://www.ehcache.org/documentation/3.0/serializers-copiers
        }
        if (builder.getStatsTrackingEnabled()) {
        @Override
        public Builder<K, V> setIsEventListenerModeSync(boolean isEventListenerModeSync) {
import org.opensearch.common.cache.store.builders.ICacheBuilder;
            }
        // Creating the cache manager also requires permissions specified in plugin-security.policy
        // Delete all the previous disk cache related files/data only if cache manager doesn't exist. As we can
                .setSettings(settings);
            binary.get(arr);
                future.completeExceptionally(ex);
        // the value. Also before returning value, puts the value in cache.
    /**
     * @return Iterable
            value = deserializeValue(cache.get(key));
import java.util.Iterator;
                builder.setMaximumWeightInBytes(config.getMaxSizeInBytes());
    private CacheEventListenerConfigurationBuilder getListenerConfiguration(Builder<K, V> builder) {
            try {
     * Invalidate the item.
        private String diskCacheAlias;
     * @return ImmutableCacheStatsHolder
         * Constructor for key serializer
            return ByteBuffer.wrap(serializer.serialize(object));
            .withValueSerializer(new ByteArrayWrapperSerializer());  // We pass ByteArrayWrapperSerializer as ehcache's value serializer. If
            this.cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME);
                                .get(DISK_WRITE_MAXIMUM_THREADS_KEY)
     * Wrapper allowing Ehcache to serialize ByteArrayWrapper.
        @Override
        private CacheType cacheType;
     */
 * This variant of disk cache uses Ehcache underneath.
        private ToLongBiFunction<ICacheKey<K>, V> weigher;
import java.util.function.ToLongBiFunction;
            }
        return new ByteArrayWrapper(valueSerializer.serialize(value));
            cacheStatsHolder.incrementHits(key.dimensions);
        /**
            }
        } else {
        if (builder.getNumberOfSegments() > 0) {
            this.valueSerializer = valueSerializer;
        @Override
        /**
        // implementation of computeIfAbsent on top of ehcache. Inspired by OpenSearch Cache implementation.
import org.opensearch.secure_sm.AccessController;
                .setDimensionNames(config.getDimensionNames())
    }
        }
            binary.get(arr);
    private final TimeValue expireAfterAccess;
        public Builder<K, V> setKeyType(Class<K> keyType) {
import java.util.Objects;
    }
    /**
        CompletableFuture<V> completableValue;
    private final long maxWeightInBytes;
        EhCacheEventListener(RemovalListener<ICacheKey<K>, V> removalListener, ToLongBiFunction<ICacheKey<K>, V> weigher) {
         * Sets the key type of value.
                    assert event.getNewValue() == null;
                )
        return AccessController.doPrivileged(() -> {
                    logger.info("Found older disk cache data lying around during initialization under path: {}", this.storagePath);
        }
                    cacheStatsHolder.incrementSizeInBytes(event.getKey().dimensions, getNewValuePairSize(event));
                throw new ExecutionException(ex);
 *
/**
import org.opensearch.common.unit.TimeValue;
import org.ehcache.spi.serialization.SerializerException;
        ).unordered();
        // create multiple caches via single cache manager for a cache type. We don't persist data between process
    private final String threadPoolAlias;
        }
         */
                storagePath = config.getStoragePath();
     */
    public static class ByteArrayWrapper {
     * Builder object to build Ehcache disk tier.
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY;
        cacheStatsHolder.reset();
     * A wrapper over byte[], with equals() that works using Arrays.equals().
            throw new IllegalArgumentException("Ehcache Disk tier cache size should be greater than " + MINIMUM_MAX_SIZE_IN_BYTES);
         * @return builder
            return this;
            EventType.EVICTED,
                    cacheStatsHolder.decrementSizeInBytes(event.getKey().dimensions, getOldValuePairSize(event));
            if (key.getDropStatsForDimensions()) {
 * SPDX-License-Identifier: Apache-2.0
        Objects.requireNonNull(builder.getWeigher(), "Weigher can't be null");
        return EhcacheDiskCacheManager.createCache(cacheType, this.diskCacheAlias, cacheConfigurationBuilder);
        public Builder<K, V> setValueSerializer(Serializer<V, byte[]> valueSerializer) {
     */
                throw new IllegalStateException("Future completed exceptionally but no error thrown");
                future.complete(new Tuple<>(key, value));
    private final RemovalListener<ICacheKey<K>, V> removalListener;
    }
        private long getOldValuePairSize(CacheEvent<? extends ICacheKey<K>, ? extends ByteArrayWrapper> event) {
        public boolean equals(Object o) {
        public KeySerializerWrapper(ClassLoader classLoader, FileBasedPersistenceContext persistenceContext) {}
            return new ByteArrayWrapper(arr);
                    cacheStatsHolder.decrementSizeInBytes(event.getKey().dimensions, getOldValuePairSize(event));
    private final Serializer<V, byte[]> valueSerializer;
            throw new IllegalArgumentException("Key passed to ehcache disk cache was null.");
         */
        // serializer directly to ehcache, ehcache requires the classes match exactly before/after serialization.
import java.nio.file.Files;
     */
    private final Serializer<K, byte[]> keySerializer;
        }
import org.apache.logging.log4j.LogManager;
            this.removalListener = removalListener;
        /**
        }
            this.cacheType = cacheType;
        }
         * Cache alias
        // restart for now which is why need to do this. Clean up in case there was a non graceful restart and we had
    }
     * Relevant stats for this cache, aggregated by levels.
         * Sets the class type of value.
    @Override
                .setKeyType((config.getKeyType()))
            if (Files.exists(ehcacheDirectory)) {
        } else {
            if (!hasNext()) {
                    segmentCount
        if (binary == null) {
import org.opensearch.common.SuppressForbidden;
public class EhcacheDiskCache<K, V> implements ICache<K, V> {
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_MAX_SIZE_IN_BYTES_KEY;
        } else {
            // If this cache is being used, FeatureFlags.PLUGGABLE_CACHE is already on, so we can always use the DefaultCacheStatsHolder
        public ByteArrayWrapperSerializer(ClassLoader classLoader, FileBasedPersistenceContext persistenceContext) {}
        }
     * @param <K> Type of key
            this.diskCacheAlias = builder.diskCacheAlias;
import org.opensearch.common.cache.LoadAwareCacheLoader;
    }
        // Provides capability to make ehCache event listener to run in sync mode. Used for testing too.
import java.time.Duration;
        }
 *  @param <K> Type of key.
import org.opensearch.cache.EhcacheDiskCacheSettings;
        public EhcacheDiskCache<K, V> build() {
     */
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
        } catch (CacheWritingException ex) {
        /**
                // be safe to assume if we got no exception and reached here.
/*
import java.util.List;
            }
        @Override
    Map<ICacheKey<K>, CompletableFuture<Tuple<ICacheKey<K>, V>>> completableFutureMap = new ConcurrentHashMap<>();
    public Iterable<ICacheKey<K>> keys() {
        /**
         * @return builder
                        new RemovalNotification<>(event.getKey(), deserializeValue(event.getOldValue()), RemovalReason.EXPLICIT)
                    ByteArrayWrapper newValue
         * Default constructor. Added to fix javadocs.
         * Default constructor
                throw new IllegalArgumentException("EhcacheDiskCache requires a value serializer of type Serializer<V, byte[]>");
                    long newSize = getNewValuePairSize(event);
            .withKeySerializer(new KeySerializerWrapper(keySerializer))
        public boolean equals(ByteArrayWrapper object, ByteBuffer binary) throws ClassNotFoundException, SerializerException {
    public void put(ICacheKey<K> key, V value) {
                }
     * @param <K> Type of key
        this.removalListener = builder.getRemovalListener();
        } else {
                future.completeExceptionally(npe);
            Serializer<V, byte[]> valueSerializer = null;
                try {
import java.nio.file.Paths;
            }
     * @return the deserialized value
         * @return builder
        cache.clear();
     */
            cacheStatsHolder.incrementMisses(key.dimensions);
        return completableFutureMap;
                public Duration getExpiryForAccess(ICacheKey key, Supplier<? extends ByteArrayWrapper> value) {
         * @param dimensionNames A list of dimension names this cache will accept
     * Gives the current count of keys in disk cache.
     * @param value Type of value.
        CompletableFuture<Tuple<ICacheKey<K>, V>> future = completableFutureMap.putIfAbsent(key, completableFuture);
    public static class ByteArrayWrapperSerializer implements org.ehcache.spi.serialization.Serializer<ByteArrayWrapper> {
 *
    class EhCacheKeyIterator<K> implements Iterator<ICacheKey<K>> {
                throw new ExecutionException(npe);
        private Serializer<K, byte[]> keySerializer;
                case EXPIRED:
                throw new NoSuchElementException();
    class EhCacheEventListener implements CacheEventListener<ICacheKey<K>, ByteArrayWrapper> {
            String storagePath = (String) settingList.get(DISK_STORAGE_PATH_KEY).get(settings);
        } else {
        @Override
        this.maxWeightInBytes = builder.getMaxWeightInBytes();
                    return expireAfterAccess;
 * compatible open source license.
         * @param classLoader
import org.opensearch.common.settings.Settings;
     * @param key key to be invalidated.
    /**
        }
            }
        CacheEventListenerConfigurationBuilder configurationBuilder = CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(
        // A future that returns a pair of key/value.
    }
        private boolean isEventListenerModeSync;
                        )
        private final byte[] value;
         *  This constructor must be present, but does not have to work as we are not actually persisting the disk
    public static class EhcacheDiskCacheFactory implements ICache.Factory {
     * @param levels The levels to aggregate by.
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)
    @Override
     * Transform a ByteArrayWrapper, which comes from ehcache, back to V.
import org.ehcache.core.spi.service.FileBasedPersistenceContext;
                .setKeySerializer(keySerializer)
         * @param storagePath path for disk cache
            binary.get(arr);
                    this.removalListener.onRemoval(
import org.ehcache.impl.config.store.disk.OffHeapDiskStoreConfiguration;
         * @param value value to wrap.
                    this.removalListener.onRemoval(
            }
    }
