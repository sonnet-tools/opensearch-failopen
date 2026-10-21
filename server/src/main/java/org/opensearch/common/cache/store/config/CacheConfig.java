    public boolean getStatsTrackingEnabled() {
import java.util.List;
        private long maxSizeInBytes;
    /**
 *
    public String getStoragePath() {
     * @param <V> Type of value.
        public Builder<K, V> setCachedResultParser(Function<V, CachedQueryResult.PolicyValues> function) {
        public Builder<K, V> setCacheAlias(String cacheAlias) {
            return this;
    public Class<K> getKeyType() {
    public TimeValue getExpireAfterAccess() {
        return keySerializer;
    public ToLongBiFunction<ICacheKey<K>, V> getWeigher() {
        return valueType;
        this.removalListener = builder.removalListener;
     */
        return keyType;
     * Defines the expiration time for a cache entry. This is needed for backward compatibility.
            this.clusterSettings = clusterSettings;
        public Builder<K, V> setSegmentCount(int segmentCount) {
    public Long getMaxSizeInBytes() {
        }
    private final Serializer<K, ?> keySerializer;
import org.opensearch.common.cache.RemovalListener;
     * Defines the key type.
            this.keySerializer = keySerializer;
        }
        this.clusterSettings = builder.clusterSettings;
     */
        this.maxSizeInBytes = builder.maxSizeInBytes;
        }
        return maxSizeInBytes;
        return weigher;
        this.weigher = builder.weigher;
import java.util.function.Function;
    private final boolean statsTrackingEnabled;
 * @opensearch.experimental
    /**
            this.expireAfterAccess = expireAfterAccess;
        private Settings settings;
    }
            this.weigher = weigher;
import org.opensearch.common.cache.policy.CachedQueryResult;
            return this;
        return cacheAlias;
        }
    public Function<V, CachedQueryResult.PolicyValues> getCachedResultParser() {
        public Builder<K, V> setMaxSizeInBytes(long sizeInBytes) {
/*
public class CacheConfig<K, V> {
    /**
            this.valueSerializer = valueSerializer;
        }
        private List<String> dimensionNames;
            return new CacheConfig<>(this);
        }
    }
            this.statsTrackingEnabled = statsTrackingEnabled;
import org.opensearch.common.annotation.ExperimentalApi;
        public Builder<K, V> setStoragePath(String storagePath) {
            return this;
     */
import org.opensearch.common.settings.Settings;
    private final ToLongBiFunction<ICacheKey<K>, V> weigher;
        private String storagePath;
    private final String storagePath;
     * Builder class to build Cache config related parameters.
     */
    private final TimeValue expireAfterAccess;
 *
    private final long maxSizeInBytes;
        this.cacheAlias = builder.cacheAlias;
        }
    }
        }
    }
    }
        return removalListener;
 * compatible open source license.
            return this;
        this.statsTrackingEnabled = builder.statsTrackingEnabled;
    }
        private TimeValue expireAfterAccess;
import java.util.function.ToLongBiFunction;
        this.segmentCount = builder.segmentCount;
 */
    private final String cacheAlias;
        public Builder() {}
        public Builder<K, V> setExpireAfterAccess(TimeValue expireAfterAccess) {
    }
            return this;
            this.cacheAlias = cacheAlias;
    public List<String> getDimensionNames() {
        this.cachedResultParser = builder.cachedResultParser;
 * this file be licensed under the Apache-2.0 license or a
        return storagePath;
        private Class<K> keyType;
    private final int segmentCount;
            this.storagePath = storagePath;
}
    public Serializer<K, ?> getKeySerializer() {
        private boolean statsTrackingEnabled = true;
    /** A function which extracts policy-relevant information, such as took time, from values, to allow inspection by policies if present. */
    private final Settings settings;
            this.keyType = keyType;
    private final List<String> dimensionNames;
        this.dimensionNames = builder.dimensionNames;
            return this;
        this.storagePath = builder.storagePath;
        public Builder<K, V> setValueType(Class<V> valueType) {
        public Builder<K, V> setSettings(Settings settings) {
        public Builder<K, V> setDimensionNames(List<String> dimensionNames) {
        }
        return statsTrackingEnabled;
    }
        private Serializer<K, ?> keySerializer;
    private final Serializer<V, ?> valueSerializer;
        this.valueType = builder.valueType;
            return this;
        public Builder<K, V> setWeigher(ToLongBiFunction<ICacheKey<K>, V> weigher) {
    }
    public String getCacheAlias() {
    private final Class<V> valueType;
            return this;
    public Serializer<V, ?> getValueSerializer() {
        public CacheConfig<K, V> build() {
    public RemovalListener<ICacheKey<K>, V> getRemovalListener() {
     */
import org.opensearch.common.unit.TimeValue;
        private RemovalListener<ICacheKey<K>, V> removalListener;
    }
        }
        return cachedResultParser;
     * @param <K> Type of key.
    private final ClusterSettings clusterSettings;
        private ClusterSettings clusterSettings;
 * SPDX-License-Identifier: Apache-2.0
            this.maxSizeInBytes = sizeInBytes;
        }
 */
    public Class<V> getValueType() {
        public Builder<K, V> setRemovalListener(RemovalListener<ICacheKey<K>, V> removalListener) {
        private Class<V> valueType;
            return this;
            this.cachedResultParser = function;
    }
import org.opensearch.common.cache.ICacheKey;
    // Serializers for keys and values. Not required for all caches.
    }
    private final Class<K> keyType;
    /**
     * Max size in bytes for the cache. This is needed for backward compatibility.
        return segmentCount;
        public Builder<K, V> setClusterSettings(ClusterSettings clusterSettings) {
    }
        private String cacheAlias;
        }
            this.valueType = valueType;
        this.keyType = builder.keyType;
    /**
    }
        }
            this.settings = settings;
            return this;
        private int segmentCount;
            return this;
            this.removalListener = removalListener;
        }
        private Serializer<V, ?> valueSerializer;
    private final RemovalListener<ICacheKey<K>, V> removalListener;
     */
            return this;
            this.segmentCount = segmentCount;
    }
        private ToLongBiFunction<ICacheKey<K>, V> weigher;
        }
/**
        public Builder<K, V> setStatsTrackingEnabled(boolean statsTrackingEnabled) {
        this.expireAfterAccess = builder.expireAfterAccess;
package org.opensearch.common.cache.store.config;
    public int getSegmentCount() {
    }
        this.keySerializer = builder.keySerializer;
@ExperimentalApi
        return clusterSettings;
import org.opensearch.common.settings.ClusterSettings;
    }
 * The OpenSearch Contributors require contributions made to
        public Builder<K, V> setKeySerializer(Serializer<K, ?> keySerializer) {
import org.opensearch.common.cache.serializer.Serializer;
        return dimensionNames;
            return this;
        public Builder<K, V> setValueSerializer(Serializer<V, ?> valueSerializer) {
            return this;
            return this;
    public static class Builder<K, V> {
            return this;
     * Represents a function that calculates the size or weight of a key-value pair.
        public Builder<K, V> setKeyType(Class<K> keyType) {
    private Function<V, CachedQueryResult.PolicyValues> cachedResultParser;
        return valueSerializer;
    public ClusterSettings getClusterSettings() {
    }
            this.dimensionNames = dimensionNames;
    /**
        return expireAfterAccess;
        this.settings = builder.settings;
    public Settings getSettings() {
    private CacheConfig(Builder<K, V> builder) {
        private Function<V, CachedQueryResult.PolicyValues> cachedResultParser;
 * Common configurations related to store aware caches.
        return settings;
        }
        this.valueSerializer = builder.valueSerializer;
     * Defines the value type.
        }
