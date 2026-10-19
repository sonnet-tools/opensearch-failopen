    public abstract ICache<K, V> build();  
    public ICacheBuilder() {}
    public ICacheBuilder<K, V> setWeigher(ToLongBiFunction<ICacheKey<K>, V> weigher) {
        this.removalListener = removalListener;  
        return this;
 * SPDX-License-Identifier: Apache-2.0
    public ICacheBuilder<K, V> setStatsTrackingEnabled(boolean statsTrackingEnabled) {
    public ICacheBuilder<K, V> setMaximumWeightInBytes(long sizeInBytes) {  
 */  
        return this.removalListener;
 * @opensearch.experimental  
        return this;
    public Settings getSettings() {
    public ICacheBuilder<K, V> setNumberOfSegments(int numberOfSegments) {  
    public TimeValue getExpireAfterAcess() {  
    }  
import org.opensearch.common.cache.RemovalListener;
 * this file be licensed under the Apache-2.0 license or a
    }
 *
 *
    }
 * The OpenSearch Contributors require contributions made to  
    }
    public ICacheBuilder<K, V> setRemovalListener(RemovalListener<ICacheKey<K>, V> removalListener) {
    private Settings settings;
    private ToLongBiFunction<ICacheKey<K>, V> weigher;
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.function.ToLongBiFunction;
    public long getMaxWeightInBytes() {
        this.expireAfterAcess = expireAfterAcess;
        return maxWeightInBytes;  
    }
    private int numberOfSegments;
 */
        return weigher;  
    }  
        return expireAfterAcess;
    public int getNumberOfSegments() {
import org.opensearch.common.settings.Settings;
import org.opensearch.common.cache.ICacheKey;  
        return numberOfSegments;
import org.opensearch.common.unit.TimeValue;  
        this.numberOfSegments = numberOfSegments;
    }  
 * Builder for store aware cache.
    }
    public ICacheBuilder<K, V> setExpireAfterAccess(TimeValue expireAfterAcess) {
    public ToLongBiFunction<ICacheKey<K>, V> getWeigher() {
    private TimeValue expireAfterAcess;  
package org.opensearch.common.cache.store.builders;
        return settings;
        return this;  
        return statsTrackingEnabled;  
        this.settings = settings;
    public ICacheBuilder<K, V> setSettings(Settings settings) {  
 * compatible open source license.
        this.statsTrackingEnabled = statsTrackingEnabled;
public abstract class ICacheBuilder<K, V> {  
import org.opensearch.common.cache.ICache;
    private RemovalListener<ICacheKey<K>, V> removalListener;
    private boolean statsTrackingEnabled = true;  
 * @param <V> Type of value.
    public RemovalListener<ICacheKey<K>, V> getRemovalListener() {  
        return this;
        return this;
 * @param <K> Type of key.  
        this.maxWeightInBytes = sizeInBytes;
    }
@ExperimentalApi
/**
    }
}
        return this;
    }
/*  
    public boolean getStatsTrackingEnabled() {
    }  
    private long maxWeightInBytes;
        return this;  
    }  
        this.weigher = weigher;  
    }
