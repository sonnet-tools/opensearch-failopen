        if (value != null) {
        private String storagePath;  
        private final byte[] value;  
import java.util.function.BiFunction;
        /**  
 *  @param <K> Type of key.
    @SuppressWarnings({ "rawtypes", "unchecked" })
     */  
                    ICacheKey key,
                throw new IllegalArgumentException("EhcacheDiskCache requires a key serializer of type Serializer<K, byte[]>");
                    );  
     * @param binary the serialized value
    /**
            return this;  
                future.complete(new Tuple<>(key, value));  
                    ByteArrayWrapper newValue  
        @Override
        public Builder<K, V> setKeyType(Class<K> keyType) {  
        /**
        // Delete all the previous disk cache related files/data only if cache manager doesn't exist. As we can  
         */  
        @Override
            return this;  
     * A wrapper over byte[], with equals() that works using Arrays.equals().
    @SuppressForbidden(reason = "Ehcache uses File.io")
        }
                    long newSize = getNewValuePairSize(event);  
import org.opensearch.common.collect.Tuple;
     */
import java.util.concurrent.CompletableFuture;
                diskCacheAlias = config.getCacheAlias();  
    public static class ByteArrayWrapper {
        };
        public Builder<K, V> setThreadPoolAlias(String threadPoolAlias) {  
        public Builder<K, V> setCacheType(CacheType cacheType) {
        }
 * SPDX-License-Identifier: Apache-2.0
    /**
         * Constructor for byte array wrapper.  
                case REMOVED:
            )  
            }
        }
        /**
     */
        }
 *  @opensearch.experimental
        }
     * @return ImmutableCacheStatsHolder  
        @Override
    @Override
                    assert event.getNewValue() == null;
public class EhcacheDiskCache<K, V> implements ICache<K, V> {  
         */  
     * @return current count of keys  
        }  
            return iterator.next().getKey();  
                                .get(DISK_WRITE_MAXIMUM_THREADS_KEY)
        }
            long maxSizeInBytes = (Long) settingList.get(DISK_MAX_SIZE_IN_BYTES_KEY).get(settings);  
    /**
        /**
            return null;  
         */
                return false;
    @Override  
                    this.threadPoolAlias,
        }  
         */
            return weigher.applyAsLong(event.getKey(), deserializeValue(event.getOldValue()));
            EventType.EVICTED,
            return Arrays.equals(arr, object.value);
                .setIsEventListenerModeSync((Boolean) settingList.get(DISK_LISTENER_MODE_SYNC_KEY).get(settings))
        }
        @Override  
    }  
            this.dimensionNames = dimensionNames;
        /**
        public boolean equals(Object o) {
        } else {
        } else {
                public Duration getExpiryForUpdate(  
            return value;  
    private Cache<ICacheKey, ByteArrayWrapper> buildCache(Duration expireAfterAccess, Builder<K, V> builder) {
        // Rest will fetch existing future.  
        CompletableFuture<Tuple<ICacheKey<K>, V>> future = completableFutureMap.putIfAbsent(key, completableFuture);
            })
        return value;  
            throw new OpenSearchException("Exception occurred while put item to ehcache disk cache");
            binary.get(arr);  
import org.opensearch.common.cache.ICache;
         * @param classLoader
            this.storagePath = storagePath;  
    }  
    Map<ICacheKey<K>, CompletableFuture<Tuple<ICacheKey<K>, V>>> completableFutureMap = new ConcurrentHashMap<>();  
    }
            }
                valueSerializer = (Serializer<V, byte[]>) config.getValueSerializer();
                cacheStatsHolder.removeDimensions(key.dimensions);  
            return this;
            return configurationBuilder.asynchronous();
                            this.threadPoolAlias,  
    final static String CACHE_DATA_CLEANUP_DURING_INITIALIZATION_EXCEPTION = "Failed to delete ehcache disk cache under "
            }  
     * Factory to create an ehcache disk cache.
            .withService(getListenerConfiguration(builder))
        if (!EhcacheDiskCacheManager.doesCacheManagerExist(cacheType)) {
    private final String diskCacheAlias;
        if (value == null) {  
        }
        // Creating the cache manager also requires permissions specified in plugin-security.policy
                    break;
        public ICacheKey<K> next() {
        } else {  
        this.expireAfterAccess = Objects.requireNonNull(builder.getExpireAfterAcess(), "ExpireAfterAccess value shouldn't " + "be null");  
        }
        public ByteArrayWrapperSerializer(ClassLoader classLoader, FileBasedPersistenceContext persistenceContext) {}
        /**  
                builder.setNumberOfSegments(segmentCount);
                // Since this comes from the TSC, it already has the segment number at the end.
        }
            this.diskCacheAlias = diskCacheAlias;
                )  
            }  
        return completableFutureMap;
            }
            }
     * @return Iterable
import org.opensearch.common.cache.LoadAwareCacheLoader;
import org.ehcache.event.CacheEvent;
            throw new IllegalStateException(ex);
            try {  
    /**
        this.keyType = Objects.requireNonNull(builder.keyType, "Key type shouldn't be null");
            return this;
     * @param <K> Type of key  
        if (builder.diskCacheAlias == null || builder.diskCacheAlias.isBlank()) {  
            return this;  
        this.ehCacheEventListener = new EhCacheEventListener(builder.getRemovalListener(), builder.getWeigher());  
        private ICacheKeySerializer<K> serializer;  
import java.util.function.ToLongBiFunction;  
                    PooledExecutionServiceConfigurationBuilder.newPooledExecutionServiceConfigurationBuilder()
        return new ByteArrayWrapper(valueSerializer.serialize(value));
        private boolean isEventListenerModeSync;
         * @param valueType type of value
     * Provides a way to iterate over disk cache keys.
    }
        } catch (CacheLoadingException ex) {
import org.opensearch.common.cache.ICacheKey;  
            this.keySerializer = keySerializer;
    final static int MINIMUM_MAX_SIZE_IN_BYTES = 1024 * 100; // 100KB
                    cacheStatsHolder.decrementSizeInBytes(event.getKey().dimensions, getOldValuePairSize(event));  
     * Wrapper over ICacheKeySerializer which is compatible with ehcache's serializer requirements.
import org.ehcache.spi.loaderwriter.CacheLoadingException;
        if (binary == null) {
            throw new IllegalArgumentException("Ehcache Disk tier cache size should be greater than " + MINIMUM_MAX_SIZE_IN_BYTES);  
import java.nio.file.Path;  
                        .defaultPool(THREAD_POOL_ALIAS_PREFIX + "Default#" + UNIQUE_ID, 1, 3) // Default pool used for other tasks  
import java.util.UUID;  
import org.opensearch.cache.EhcacheDiskCacheSettings;
     * This iterator wraps ehCache iterator and only iterates over its keys.
    @Override
    public ImmutableCacheStatsHolder stats(String[] levels) {  
        private final RemovalListener<ICacheKey<K>, V> removalListener;
     * Transform a ByteArrayWrapper, which comes from ehcache, back to V.  
    private final long maxWeightInBytes;
            cacheStatsHolder.incrementMisses(key.dimensions);  
            this.serializer = new ICacheKeySerializer<>(internalKeySerializer);
    }
                    break;  
        return EhcacheDiskCacheManager.createCache(cacheType, this.diskCacheAlias, cacheConfigurationBuilder);
            return serializer.deserialize(arr);
    private ByteArrayWrapper serializeValue(V value) {
                ICacheKey.class,  
            this.threadPoolAlias = THREAD_POOL_ALIAS_PREFIX + "DiskWrite#" + UNIQUE_ID;
    private final EhCacheEventListener ehCacheEventListener;
                .with(CacheManagerBuilder.persistence(new File(storagePath)))
                ResourcePoolsBuilder.newResourcePoolsBuilder().disk(maxWeightInBytes, MemoryUnit.B)
         * @param persistenceContext  
        try {
        // Creating the cache requires permissions specified in plugin-security.policy
import org.ehcache.PersistentCacheManager;  
         * Sets the key serializer for this cache.  
            return this;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.util.io.IOUtils;
        }
        }
            return CacheManagerBuilder.newCacheManagerBuilder()
                .setValueType(config.getValueType())
        @Override
            } catch (ClassCastException e) {
    /**  
                future.get(); // call get to force the exception to be thrown for other concurrent callers
         * Sets the allowed dimension names for keys that will enter this cache.
         * @param threadPoolAlias alias  
import org.ehcache.event.EventType;
                    (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType).get(DISK_WRITE_CONCURRENCY_KEY).get(settings),  
            return configurationBuilder.synchronous();  
        this.cache = buildCache(Duration.ofMillis(expireAfterAccess.getMillis()), builder);
        }  
        public ICacheKey<K> read(ByteBuffer binary) throws ClassNotFoundException, SerializerException {
                throw new ExecutionException(ex);
                    break;  
        // A future that returns a pair of key/value.  
    public static class Builder<K, V> extends ICacheBuilder<K, V> {  
            if (storagePath == null || storagePath.isBlank()) {
                    cacheStatsHolder.incrementEvictions(event.getKey().dimensions);
        private List<String> dimensionNames;  
            binary.get(arr);  
import org.ehcache.config.builders.PooledExecutionServiceConfigurationBuilder;
            if (future.isCompletedExceptionally()) {  
                keySerializer = (Serializer<K, byte[]>) config.getKeySerializer();  
            String diskCacheAlias = (String) settingList.get(DISK_CACHE_ALIAS_KEY).get(settings);
            } catch (ClassCastException e) {
            }  
    @Override  
        public int hashCode() {
        public boolean equals(ICacheKey object, ByteBuffer binary) throws ClassNotFoundException, SerializerException {
            this.threadPoolAlias = builder.threadPoolAlias;  
    }
         * @return builder
    @Override
        CacheEventListenerConfigurationBuilder configurationBuilder = CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(  
        this.maxWeightInBytes = builder.getMaxWeightInBytes();
                value = loader.load(key);
            // If this cache is being used, FeatureFlags.PLUGGABLE_CACHE is already on, so we can always use the DefaultCacheStatsHolder
                    cacheStatsHolder.decrementItems(event.getKey().dimensions);
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_MAX_SIZE_IN_BYTES_KEY;
            .newCacheConfigurationBuilder(
        @SuppressWarnings({ "unchecked" }) // Required to ensure the serializers output byte[]
        }
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_CACHE_ALIAS_KEY;
                throw new IllegalStateException("Future completed exceptionally but no error thrown");
        // In case we use multiple ehCaches, we can define this cache manager at a global level.
        // Handler to handle results post processing. Takes a tuple<key, value> or exception as an input and returns
     * Transform a value from V to ByteArrayWrapper, which can be passed to ehcache.  
         */
        if (builder.threadPoolAlias == null || builder.threadPoolAlias.isBlank()) {  
        // older disk cache data still lying around.  
        }
         * @return builder
                    cacheStatsHolder.incrementSizeInBytes(event.getKey().dimensions, getNewValuePairSize(event));
        cache.clear();
        private ToLongBiFunction<ICacheKey<K>, V> weigher;
         */  
        @Override
        public <K, V> ICache<K, V> create(CacheConfig<K, V> config, CacheType cacheType, Map<String, Factory> cacheFactories) {  
                    segmentCount
    /**
    public class KeySerializerWrapper implements org.ehcache.spi.serialization.Serializer<ICacheKey> {
         * Thread pool alias for the cache.
                    assert event.getNewValue() == null;  
         * Desired storage path for disk cache.
        return valueSerializer.deserialize(binary.value);
        // This is not always feasible or necessary, like for BytesReference. So, we handle the value serialization
            // Handle  
                    this.removalListener.onRemoval(
        }
            return weigher.applyAsLong(event.getKey(), deserializeValue(event.getNewValue()));
        return value;
                    Supplier<? extends ByteArrayWrapper> oldValue,
    }
         */  
     * @param key key to be invalidated.  
    final static String THREAD_POOL_ALIAS_PREFIX = "ehcachePool";  
        public ByteBuffer serialize(ICacheKey object) throws SerializerException {
    private final Settings settings;
                        // like event listeners
            return builder.build();
         * @param keyType type of key  
    public static class ByteArrayWrapperSerializer implements org.ehcache.spi.serialization.Serializer<ByteArrayWrapper> {  
import org.opensearch.common.cache.stats.NoopCacheStatsHolder;
        public Builder<K, V> setKeySerializer(Serializer<K, byte[]> keySerializer) {
            // unless statsTrackingEnabled is explicitly set to false in CacheConfig.
        V value;
        // restart for now which is why need to do this. Clean up in case there was a non graceful restart and we had
                } catch (IOException e) {
     * Invalidate the item.
import org.ehcache.spi.loaderwriter.CacheWritingException;
    private final Serializer<K, byte[]> keySerializer;
@ExperimentalApi
 *
        }
        /**  
import org.opensearch.common.cache.RemovalReason;
    }
         * Default constructor.  
        ).unordered();
            this.cacheType = cacheType;  
        public static final String EHCACHE_DISK_CACHE_NAME = "ehcache_disk";  
         * @return builder  
        }
    PersistentCacheManager buildCacheManager() {  
     * Used in computeIfAbsent to synchronize loading of a given key. This is needed as ehcache doesn't provide a  
import org.ehcache.config.builders.CacheConfigurationBuilder;
        if (this.maxWeightInBytes <= MINIMUM_MAX_SIZE_IN_BYTES) {
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)
     * @param value Type of value.  
            ).withExpiry(new ExpiryPolicy<>() {  
                .build(true);
            return this;
                    break;
                throw new ExecutionException(npe);
         */
        }  
        @Override
     */
            }  
    }
        this.cacheManager = EhcacheDiskCacheManager.getCacheManager(cacheType, this.storagePath, settings, this.threadPoolAlias);
    public long count() {  
    @SuppressWarnings({ "rawtypes", "unchecked" })
        } else {
         * @param isEventListenerModeSync mode sync
        this.valueType = Objects.requireNonNull(builder.valueType, "Value type shouldn't be null");
    /**  
        // not performant in case there are multiple concurrent request for same key. Below is our own custom  
    }  
            this.removalListener = removalListener;
                @Override  
            this.ehCacheEventListener,
        int segmentCount = (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType).get(DISK_SEGMENT_KEY).get(settings);  
            try {
    private final Class<V> valueType;
        // before V hits ehcache.  
        }
                .setWeigher(config.getWeigher())
            EventType.REMOVED,
import org.opensearch.common.cache.serializer.Serializer;  
        }
     */  
         * @return builder
                public Duration getExpiryForAccess(ICacheKey key, Supplier<? extends ByteArrayWrapper> value) {
     */
    private V deserializeValue(ByteArrayWrapper binary) {
         * Sets the value serializer for this cache.
 * The OpenSearch Contributors require contributions made to  
 */
                builder.setMaximumWeightInBytes(maxSizeInBytes);
                        new RemovalNotification<>(event.getKey(), deserializeValue(event.getOldValue()), RemovalReason.EXPLICIT)  
        // create multiple caches via single cache manager for a cache type. We don't persist data between process
            return Arrays.hashCode(value);  
        public ByteArrayWrapper read(ByteBuffer binary) throws ClassNotFoundException, SerializerException {  
    private V compute(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
    public static class EhcacheDiskCacheFactory implements ICache.Factory {
         *   cache after a restart. See https://www.ehcache.org/documentation/3.0/serializers-copiers
            String storagePath = (String) settingList.get(DISK_STORAGE_PATH_KEY).get(settings);  
    /**
                default:
 * this file be licensed under the Apache-2.0 license or a
            this.keyType = keyType;
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_CONCURRENCY_KEY;
            this.valueType = valueType;
        private String threadPoolAlias;
        Iterator<Cache.Entry<ICacheKey, ByteArrayWrapper>> iterator;
import org.opensearch.common.settings.Setting;
                try {
                .setKeyType((config.getKeyType()))  
    }
                case EXPIRED:  
            return Arrays.equals(this.value, other.value);
        // TODO: ehcache doesn't provide a way to refresh a cache.  
                builder.setNumberOfSegments(config.getSegmentCount());  
            this.threadPoolAlias = threadPoolAlias;
            return ByteBuffer.wrap(serializer.serialize(object));  
         * Sets the class type of value.  
                    cacheStatsHolder.decrementItems(event.getKey().dimensions);
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MIN_THREADS_KEY;
        @Override
            ByteArrayWrapper other = (ByteArrayWrapper) o;  
    public void put(ICacheKey<K> key, V value) {  
        /**
            value = completableValue.get();
     */
     * @param key Type of key
        BiFunction<Tuple<ICacheKey<K>, V>, Throwable, V> handler = (pair, ex) -> {
    @Override
    @Override  
import org.ehcache.spi.serialization.SerializerException;  
    // Unique id associated with this cache.
        public void remove() {
        }
    private final Serializer<V, byte[]> valueSerializer;  
        if (this.storagePath == null || this.storagePath.isBlank()) {  
    public void invalidateAll() {
    Map<ICacheKey<K>, CompletableFuture<Tuple<ICacheKey<K>, V>>> getCompletableFutureMap() {
import org.opensearch.common.cache.store.builders.ICacheBuilder;
        // Ehcache doesn't provide any computeIfAbsent function. Exposes putIfAbsent but that works differently and is
         * cache after a restart. See https://www.ehcache.org/documentation/3.0/serializers-copiers  
    public void close() {
        List<String> dimensionNames = Objects.requireNonNull(builder.dimensionNames, "Dimension names can't be null");
                            (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType)
         */  
            EventType.UPDATED,
         * Default constructor. Added to fix javadocs.
                value = pair.v2(); // Returning a value itself assuming that a next get should return the same. Should
            this.value = value;
        } else {
            .withValueSerializer(new ByteArrayWrapperSerializer());  // We pass ByteArrayWrapperSerializer as ehcache's value serializer. If
        }  
            if (value == null) {
 *  
            cache.put(key, serializeValue(value));
                }  
        this.removalListener = builder.getRemovalListener();
        }
        public Builder<K, V> setValueType(Class<V> valueType) {
                @Override
    private static final Logger logger = LogManager.getLogger(EhcacheDiskCache.class);
        public Builder<K, V> setValueSerializer(Serializer<V, byte[]> valueSerializer) {
            binary.get(arr);
        private long getNewValuePairSize(CacheEvent<? extends ICacheKey<K>, ? extends ByteArrayWrapper> event) {
                }  
         * @return builder
import java.nio.file.Paths;
        return maxWeightInBytes;
import org.ehcache.config.builders.CacheManagerBuilder;  
import org.apache.logging.log4j.Logger;
        }  
import org.ehcache.expiry.ExpiryPolicy;
         */
import org.opensearch.common.cache.RemovalListener;
        public KeySerializerWrapper(Serializer<K, byte[]> internalKeySerializer) {  
     */
         * Sets the key type of value.
            } else {
         *  This constructor must be present, but does not have to work as we are not actually persisting the disk
    private final String threadPoolAlias;  
                future.completeExceptionally(npe);  
                    long oldSize = getOldValuePairSize(event);
         * .html#persistent-vs-transient-caches
        }
        this.settings = Objects.requireNonNull(builder.getSettings(), "Settings objects shouldn't be null");
        /**
        private String diskCacheAlias;
    @SuppressWarnings("rawtypes")  
        return () -> new EhCacheKeyIterator<>(cache.iterator());  
     * Computes the value using loader in case key is not present, otherwise fetches it.  
                future.completeExceptionally(ex);
    // Disk cache. Using ByteArrayWrapper to compare two byte[] by values rather than the default reference checks
         * Cache alias  
            return new EhcacheDiskCache<>(this);  
    public void invalidate(ICacheKey<K> key) {  
     */
                    assert event.getOldValue() == null;
    }
     * @param value the value
                public Duration getExpiryForCreation(ICacheKey key, ByteArrayWrapper value) {
                .setDimensionNames(config.getDimensionNames())
        public ByteBuffer serialize(ByteArrayWrapper object) throws SerializerException {
            EventType.CREATED  
                    cacheStatsHolder.incrementItems(event.getKey().dimensions);  
import java.util.Iterator;
            }
            byte[] arr = new byte[binary.remaining()];
import java.util.Objects;
import org.ehcache.impl.config.store.disk.OffHeapDiskStoreConfiguration;  
     * @param loader loader to load the value in case key is missing
            // If we read the storage path directly from the setting, we have to add the segment number at the end.
         * @param valueSerializer the value serializer
         * @param internalKeySerializer serializer for internal key
         */
                .setExpireAfterAccess((TimeValue) settingList.get(DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY).get(settings))
        return value;
    public Iterable<ICacheKey<K>> keys() {
        this.keySerializer = Objects.requireNonNull(builder.keySerializer, "Key serializer shouldn't be null");  
    // A Cache manager can create many caches.
                case UPDATED:
                ByteArrayWrapper.class,
        }  
    }
            future = completableFuture;
        try {
        } else {
         * @param value value to wrap.
    EhcacheDiskCache(Builder<K, V> builder) {  
        Objects.requireNonNull(builder.getWeigher(), "Weigher can't be null");
        CompletableFuture<Tuple<ICacheKey<K>, V>> completableFuture = new CompletableFuture<>();
import java.util.concurrent.ExecutionException;  
 *
            this.diskCacheAlias = "ehcacheDiskCache#" + this.cacheType;
                .setDiskCacheAlias(diskCacheAlias)  
                .setRemovalListener(config.getRemovalListener())  
        public Builder<K, V> setDiskCacheAlias(String diskCacheAlias) {
        this.valueSerializer = Objects.requireNonNull(builder.valueSerializer, "Value serializer shouldn't be null");
package org.opensearch.cache.store.disk;
 * compatible open source license.
        /**
    /**
                        .build()
import java.io.IOException;  
        private CacheType cacheType;
    private CacheEventListenerConfigurationBuilder getListenerConfiguration(Builder<K, V> builder) {
        /**
                }
        public EhcacheDiskCache<K, V> build() {
        V value;  
                throw new NoSuchElementException();
         * This constructor must be present, but does not have to work as we are not actually persisting the disk
        }
            }  
        public Builder<K, V> setDimensionNames(List<String> dimensionNames) {  
        public Builder<K, V> setIsEventListenerModeSync(boolean isEventListenerModeSync) {
        }
    private final Class<K> keyType;
            }  
                .setCacheType(cacheType)
import java.util.Arrays;  
        }  
        return AccessController.doPrivileged(() -> {  
        @Override
    }  
            binary.get(arr);
     */
            int segmentCount = (Integer) EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType).get(DISK_SEGMENT_KEY).get(settings);
            completableFutureMap.remove(key); // Remove key from map as not needed anymore.
                    );
         * @return builder
     * @param <K> Type of key  
    /**  
    private final String storagePath;  
import org.ehcache.event.CacheEventListener;  
            if (config.getCacheAlias() != null && !config.getCacheAlias().isBlank()) {
                    cacheStatsHolder.decrementSizeInBytes(event.getKey().dimensions, getOldValuePairSize(event));  
                        )
import org.opensearch.common.annotation.ExperimentalApi;  
        cacheStatsHolder.reset();  
     * @return value  
     * Wrapper allowing Ehcache to serialize ByteArrayWrapper.
            byte[] arr = new byte[binary.remaining()];
                        .pool(
        }
        @Override  
     * Necessary due to a limitation in how Ehcache compares byte[].  
        this.cacheType = Objects.requireNonNull(builder.cacheType, "Cache type shouldn't be null");
        /**
     */  
         * Constructor for key serializer  
    }
        } else {  
    }  
         */
    }
         * @param dimensionNames A list of dimension names this cache will accept  
                throw new IllegalArgumentException("EhcacheDiskCache requires a value serializer of type Serializer<V, byte[]>");  
import org.opensearch.common.SuppressForbidden;
            segmentCount = builder.getNumberOfSegments();
                .setSettings(settings);
                new OffHeapDiskStoreConfiguration(
 */  
         * Ehcache disk cache name.
     */
                cache.put(pair.v1(), serializeValue(pair.v2()));
            throw new OpenSearchException("Exception occurred while trying to fetch item from ehcache disk cache");
     */
            if (key.getDropStatsForDimensions()) {
         * @param storagePath path for disk cache
import java.util.NoSuchElementException;
import java.util.function.Supplier;
                    cacheStatsHolder.decrementSizeInBytes(event.getKey().dimensions, getOldValuePairSize(event));
    public void refresh() {
        private Serializer<V, byte[]> valueSerializer;
    }
            switch (event.getType()) {
    /**  
    final static String UNIQUE_ID = UUID.randomUUID().toString();
        /**  
     * Wrapper over Ehcache original listener to listen to desired events and notify desired subscribers.
     * computeIfAbsent method.
                storagePath = config.getStoragePath();
     * Relevant stats for this cache, aggregated by levels.
        // Only one of the threads will succeed putting a future into map for the same key.
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;  
            return new ByteArrayWrapper(arr);  
        }
                }  
        }
            return this;
    }  
        private Class<V> valueType;
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_STORAGE_PATH_KEY;
            Map<String, Setting<?>> settingList = EhcacheDiskCacheSettings.getSettingListForCacheType(cacheType);
                    this.removalListener.onRemoval(
        /**
            return this;
        try {
        @Override  
/*  
        }  
    }
     * Gives the current count of keys in disk cache.
    private final Cache<ICacheKey, ByteArrayWrapper> cache;
        public Builder<K, V> setStoragePath(String storagePath) {
    private final RemovalListener<ICacheKey<K>, V> removalListener;
 *  @param <V> Type of value.  
        + "path: %s during initialization. Please clean this up manually and restart the process";  
        if (key == null) {
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
            }  
         *   .html#persistent-vs-transient-caches  
            value = deserializeValue(cache.get(key));  
        private long getOldValuePairSize(CacheEvent<? extends ICacheKey<K>, ? extends ByteArrayWrapper> event) {  
import java.io.File;
        /**
         */
            this.iterator = iterator;
        }
            throw new IllegalArgumentException("Key passed to ehcache disk cache was null.");
    private final TimeValue expireAfterAccess;  
                .setKeySerializer(keySerializer)
        }  
                    cacheStatsHolder.decrementItems(event.getKey().dimensions);
     * If enableStatsTracking is set to false in the builder, always returns 0.
            this.isEventListenerModeSync = isEventListenerModeSync;  
        // Provides capability to make ehCache event listener to run in sync mode. Used for testing too.  
            completableValue = future.handle(handler);
        @Override
 * This variant of disk cache uses Ehcache underneath.
            cacheStatsHolder.incrementHits(key.dimensions);
import org.opensearch.common.cache.CacheType;
                .using(
         * Default constructor
    public V get(ICacheKey<K> key) {  
import org.opensearch.OpenSearchException;  
                    return INFINITE;
     */
            value = compute(key, loader);
        }
    }
            return this;
        @Override
                )
            iterator.remove(); // Calls underlying ehcache iterator.remove()
            throw new RuntimeException(ex);
        EhCacheKeyIterator(Iterator<Cache.Entry<ICacheKey, ByteArrayWrapper>> iterator) {
import java.util.Map;  
        } catch (CacheWritingException ex) {  
        return cacheStatsHolder.getImmutableCacheStatsHolder(levels);
            completableValue = future.handle(handler);
    /**  
import java.util.concurrent.ConcurrentHashMap;
            } else {
        }
        public KeySerializerWrapper(ClassLoader classLoader, FileBasedPersistenceContext persistenceContext) {}
import java.nio.file.Files;
    private final CacheStatsHolder cacheStatsHolder;
/**  
        });
         */
        }  
    @SuppressForbidden(reason = "Ehcache uses File.io")
        if (!loader.isLoaded()) {  
import org.ehcache.config.units.MemoryUnit;  
        }  
                                .get(settings),  
    long getMaximumWeight() {  
                    );
            if (o == null || o.getClass() != ByteArrayWrapper.class) {  
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_WRITE_MAXIMUM_THREADS_KEY;  
            this.cacheStatsHolder = NoopCacheStatsHolder.getInstance();
        /**  
                    this.removalListener.onRemoval(
        // the value. Also before returning value, puts the value in cache.  
     */  
            return iterator.hasNext();
         */
     * Builder object to build Ehcache disk tier.
    }
        if (builder.getStatsTrackingEnabled()) {  
            byte[] arr = new byte[binary.remaining()];
                @Override
    /**
         */
     * @param levels The levels to aggregate by.
            .withKeySerializer(new KeySerializerWrapper(keySerializer))
                    throw new OpenSearchException(String.format(CACHE_DATA_CLEANUP_DURING_INITIALIZATION_EXCEPTION, this.storagePath), e);
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_SEGMENT_KEY;  
            return EHCACHE_DISK_CACHE_NAME;  
         * @return builder  
            // If config value is set, use this instead.
            try {
        @Override
         * @return builder  
import java.util.List;
            .withService(  
            } catch (Exception ex) {  
        EhCacheEventListener(RemovalListener<ICacheKey<K>, V> removalListener, ToLongBiFunction<ICacheKey<K>, V> weigher) {
    @Override
    }
                case EVICTED:
        public Builder() {}
            Path ehcacheDirectory = Paths.get(this.storagePath);
        private Class<K> keyType;  
        private Serializer<K, byte[]> keySerializer;
            Serializer<V, byte[]> valueSerializer = null;
import org.apache.logging.log4j.LogManager;
            cacheStatsHolder.incrementHits(key.dimensions);
}  
            EventType.EXPIRED,  
                                .get(settings)  
import org.opensearch.common.cache.store.config.CacheConfig;  
    @SuppressForbidden(reason = "Ehcache uses File.io")
            if (config.getSegmentCount() > 0) {
            cacheStatsHolder.incrementMisses(key.dimensions);
         * @return builder  
            V value = null;
import org.opensearch.common.settings.Settings;  
        public boolean hasNext() {  
    @SuppressWarnings({ "rawtypes" }) // We have to use the raw type as there's no way to pass the "generic class" to ehcache  
        CacheConfigurationBuilder<ICacheKey, ByteArrayWrapper> cacheConfigurationBuilder = CacheConfigurationBuilder
            this.diskCacheAlias = builder.diskCacheAlias;  
    // Package private for testing  
        public EhcacheDiskCacheFactory() {}
         * @return builder
        public void onEvent(CacheEvent<? extends ICacheKey<K>, ? extends ByteArrayWrapper> event) {  
    /**  
                    return INFINITE;  
        }
        public String getCacheName() {
    @Override
                // be safe to assume if we got no exception and reached here.  
                NullPointerException npe = new NullPointerException("loader returned a null value");
                builder.setMaximumWeightInBytes(config.getMaxSizeInBytes());  
         */  
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_LISTENER_MODE_SYNC_KEY;
            if (key.key != null) {
                    IOUtils.rm(ehcacheDirectory);  
import java.nio.ByteBuffer;
    class EhCacheKeyIterator<K> implements Iterator<ICacheKey<K>> {  
            this.valueSerializer = valueSerializer;  
                        new RemovalNotification<>(event.getKey(), deserializeValue(event.getOldValue()), RemovalReason.INVALIDATED)
         * @param diskCacheAlias disk cache alias
            this.cacheStatsHolder = new DefaultCacheStatsHolder(dimensionNames, EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME);  
            }
        public ByteArrayWrapper(byte[] value) {  
        return cacheStatsHolder.count();
        }
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.opensearch.common.cache.stats.CacheStatsHolder;
         * Sets the desired cache type.
            EhcacheDiskCache.Builder<K, V> builder = (Builder<K, V>) new Builder<K, V>().setStoragePath(storagePath)
                case CREATED:
         */
         * @param persistenceContext
        }  
    private final PersistentCacheManager cacheManager;  
        try {
            }
            Settings settings = config.getSettings();
     * @throws Exception when either internal get or put calls fail.
                // In case storage path is not explicitly set by user, use default path.  
        public ByteArrayWrapperSerializer() {}
                    assert event.getNewValue() == null;
                    cacheStatsHolder.incrementSizeInBytes(event.getKey().dimensions, newSize - oldSize);
            }
                cache.remove(key);  
            this.weigher = weigher;  
            V value;  
    @Override
     * @param key Type of key.
        // serializer directly to ehcache, ehcache requires the classes match exactly before/after serialization.
                        new RemovalNotification<>(event.getKey(), deserializeValue(event.getOldValue()), RemovalReason.EVICTED)  
import org.opensearch.secure_sm.AccessController;  
         * @param keySerializer the key serializer
            return serializer.equals(object, arr);
            if (!hasNext()) {  
        EhcacheDiskCacheManager.closeCache(cacheType, diskCacheAlias, storagePath);  
        if (builder.isEventListenerModeSync) {
        public boolean equals(ByteArrayWrapper object, ByteBuffer binary) throws ClassNotFoundException, SerializerException {
        V value = deserializeValue(cache.get(key));
    }
import java.time.Duration;
         * Determines whether event listener is triggered async/sync.
    /**
     * Puts the item into cache.
        }  
import org.ehcache.Cache;
    }  
                    return expireAfterAccess;
        /**  
                    logger.info("Found older disk cache data lying around during initialization under path: {}", this.storagePath);
            if (pair != null) {  
            }
        /**
            if (Files.exists(ehcacheDirectory)) {  
     * @return the deserialized value
            if (config.getMaxSizeInBytes() > 0) {
                ) {
    }  
            Serializer<K, byte[]> keySerializer = null;
        if (builder.getNumberOfSegments() > 0) {
                                                                     // V is an interface, and we pass its  
     * @param <V> Type of value
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
    // Pkg-private for testing.
        if (future == null) {  
     * @return the serialized value
    /**
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY;  
                    break;  
        }
     */  
        // implementation of computeIfAbsent on top of ehcache. Inspired by OpenSearch Cache implementation.
                    break;
    public V computeIfAbsent(ICacheKey<K> key, LoadAwareCacheLoader<ICacheKey<K>, V> loader) throws Exception {
        this.storagePath = builder.storagePath;
                                .get(DISK_WRITE_MIN_THREADS_KEY)
         * @param classLoader
        } catch (CacheWritingException ex) {
        @Override  
            throw new IllegalArgumentException("Storage path shouldn't be null or empty");
            return ByteBuffer.wrap(object.value);
        }
            } else {
         * @param cacheType cache type
import org.ehcache.core.spi.service.FileBasedPersistenceContext;
import org.opensearch.common.cache.serializer.ICacheKeySerializer;
        CompletableFuture<V> completableValue;
        Objects.requireNonNull(builder.getRemovalListener(), "Removal listener can't be null");  
import org.opensearch.common.cache.RemovalNotification;  
            byte[] arr = new byte[binary.remaining()];  
                .setValueSerializer(valueSerializer)  
    private final CacheType cacheType;  
    class EhCacheEventListener implements CacheEventListener<ICacheKey<K>, ByteArrayWrapper> {  
        } catch (InterruptedException ex) {
        }
