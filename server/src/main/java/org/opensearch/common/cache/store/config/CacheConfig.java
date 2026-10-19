            this.valueSerializer = valueSerializer;
        this.settings = builder.settings;  
    }
            return this;  
    }  
            this.weigher = weigher;  
    }
    public boolean getStatsTrackingEnabled() {
            return this;
            return this;
/**
        return dimensionNames;
    public List<String> getDimensionNames() {  
        private long maxSizeInBytes;
        }
            return new CacheConfig<>(this);  
     * @param <V> Type of value.
    public ToLongBiFunction<ICacheKey<K>, V> getWeigher() {
            return this;
        public Builder() {}
    private final ToLongBiFunction<ICacheKey<K>, V> weigher;
     */
        this.weigher = builder.weigher;
        this.keySerializer = builder.keySerializer;  
import org.opensearch.common.cache.ICacheKey;
        }
    }
    private final Serializer<K, ?> keySerializer;
    }
 */  
import java.util.List;
        return storagePath;  
    public String getCacheAlias() {
        return settings;
            this.clusterSettings = clusterSettings;
        }
    public Function<V, CachedQueryResult.PolicyValues> getCachedResultParser() {
     * Represents a function that calculates the size or weight of a key-value pair.
    }
        }
     */  
        this.segmentCount = builder.segmentCount;  
     */
        this.removalListener = builder.removalListener;
            this.expireAfterAccess = expireAfterAccess;  
    /**  
        private Function<V, CachedQueryResult.PolicyValues> cachedResultParser;
        private TimeValue expireAfterAccess;  
            this.maxSizeInBytes = sizeInBytes;
    }
    }  
        public Builder<K, V> setStoragePath(String storagePath) {
        return valueSerializer;
        return removalListener;
        private ClusterSettings clusterSettings;
    }
        }
        public Builder<K, V> setKeyType(Class<K> keyType) {
    /**
        return segmentCount;
        public Builder<K, V> setCachedResultParser(Function<V, CachedQueryResult.PolicyValues> function) {
        public Builder<K, V> setSegmentCount(int segmentCount) {
        this.maxSizeInBytes = builder.maxSizeInBytes;
        public Builder<K, V> setSettings(Settings settings) {  
        }
    private CacheConfig(Builder<K, V> builder) {  
    private final Serializer<V, ?> valueSerializer;  
 * this file be licensed under the Apache-2.0 license or a
        }  
        return keySerializer;  
import org.opensearch.common.unit.TimeValue;
    }  
            this.storagePath = storagePath;  
    private Function<V, CachedQueryResult.PolicyValues> cachedResultParser;  
    }  
            this.statsTrackingEnabled = statsTrackingEnabled;
            return this;
    }
        private Serializer<V, ?> valueSerializer;  
        this.keyType = builder.keyType;
    /** A function which extracts policy-relevant information, such as took time, from values, to allow inspection by policies if present. */
        public Builder<K, V> setStatsTrackingEnabled(boolean statsTrackingEnabled) {  
     */  
 * The OpenSearch Contributors require contributions made to  
        }  
            this.cacheAlias = cacheAlias;
            return this;
            return this;
    /**  
        this.dimensionNames = builder.dimensionNames;
    }  
        this.valueType = builder.valueType;
     */
        }  
import org.opensearch.common.cache.serializer.Serializer;
     * Max size in bytes for the cache. This is needed for backward compatibility.
     */  
 *
        this.cachedResultParser = builder.cachedResultParser;  
            this.segmentCount = segmentCount;
    // Serializers for keys and values. Not required for all caches.
    private final int segmentCount;
 *
    private final boolean statsTrackingEnabled;
        this.cacheAlias = builder.cacheAlias;
        private String cacheAlias;
        return weigher;
        private String storagePath;  
    private final Class<K> keyType;  
        return cacheAlias;
    private final List<String> dimensionNames;
        private RemovalListener<ICacheKey<K>, V> removalListener;  
        public Builder<K, V> setRemovalListener(RemovalListener<ICacheKey<K>, V> removalListener) {  
    }
        public Builder<K, V> setWeigher(ToLongBiFunction<ICacheKey<K>, V> weigher) {
        private List<String> dimensionNames;
        private int segmentCount;
import org.opensearch.common.settings.Settings;
 * Common configurations related to store aware caches.  
        this.statsTrackingEnabled = builder.statsTrackingEnabled;
        }
        private Settings settings;  
import java.util.function.ToLongBiFunction;  
    public Serializer<K, ?> getKeySerializer() {
        this.expireAfterAccess = builder.expireAfterAccess;
    public Serializer<V, ?> getValueSerializer() {  
    public int getSegmentCount() {  
        public Builder<K, V> setValueType(Class<V> valueType) {
    /**
        private ToLongBiFunction<ICacheKey<K>, V> weigher;
    public static class Builder<K, V> {
    public String getStoragePath() {
        return clusterSettings;
        return maxSizeInBytes;
    public Settings getSettings() {  
    }  
            this.valueType = valueType;
    /**
        }
    private final RemovalListener<ICacheKey<K>, V> removalListener;  
            return this;  
    }
            return this;
            return this;
     * Defines the expiration time for a cache entry. This is needed for backward compatibility.
            return this;
        public Builder<K, V> setExpireAfterAccess(TimeValue expireAfterAccess) {
import org.opensearch.common.annotation.ExperimentalApi;
            this.dimensionNames = dimensionNames;  
package org.opensearch.common.cache.store.config;
     * Defines the value type.  
            this.cachedResultParser = function;
        private Class<V> valueType;
}  
    private final String storagePath;  
    private final Class<V> valueType;
    public Class<V> getValueType() {
     * Builder class to build Cache config related parameters.  
        }
        return keyType;
    public RemovalListener<ICacheKey<K>, V> getRemovalListener() {
import org.opensearch.common.cache.policy.CachedQueryResult;
 * @opensearch.experimental
    /**
    public TimeValue getExpireAfterAccess() {
        }  
     * @param <K> Type of key.
import org.opensearch.common.settings.ClusterSettings;  
            this.keyType = keyType;  
        return valueType;  
        public Builder<K, V> setValueSerializer(Serializer<V, ?> valueSerializer) {  
    private final String cacheAlias;
    private final long maxSizeInBytes;
/*  
        }  
        public CacheConfig<K, V> build() {
            this.removalListener = removalListener;
            return this;
    public Long getMaxSizeInBytes() {
    }
        }  
public class CacheConfig<K, V> {
        }
        private Serializer<K, ?> keySerializer;
        public Builder<K, V> setCacheAlias(String cacheAlias) {  
        this.storagePath = builder.storagePath;
        this.valueSerializer = builder.valueSerializer;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.cache.RemovalListener;  
@ExperimentalApi
    public Class<K> getKeyType() {
            return this;  
        return cachedResultParser;  
            return this;
        }
        private boolean statsTrackingEnabled = true;
        public Builder<K, V> setMaxSizeInBytes(long sizeInBytes) {  
        public Builder<K, V> setKeySerializer(Serializer<K, ?> keySerializer) {
    private final TimeValue expireAfterAccess;  
            return this;  
        private Class<K> keyType;
 * compatible open source license.
        public Builder<K, V> setClusterSettings(ClusterSettings clusterSettings) {
    private final ClusterSettings clusterSettings;
            this.settings = settings;
    public ClusterSettings getClusterSettings() {  
 */  
            this.keySerializer = keySerializer;
    private final Settings settings;
        return expireAfterAccess;  
        return statsTrackingEnabled;
        this.clusterSettings = builder.clusterSettings;  
    }
            return this;  
     * Defines the key type.
        public Builder<K, V> setDimensionNames(List<String> dimensionNames) {
import java.util.function.Function;
