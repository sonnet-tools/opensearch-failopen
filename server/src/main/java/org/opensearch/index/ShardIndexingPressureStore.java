/**
                // Write through into the cold store for future reference
 * to track an ongoing request.
        this.maxColdStoreSize = MAX_COLD_STORE_SIZE.get(settings).intValue();
 * is no more live it is removed from the hot store. Objects in the cold store are evicted once the cold store  
     * This is used to update the reference of tracker in cold store, to be re-used later of tracker is removed from hot store upon request
import java.util.Collections;
            // Remove from the hot store
                    (k) -> new ShardIndexingPressureTracker(
 * Shard indexing pressure store acts as a central repository for all the shard-level tracker objects currently being  
            // Attempt from Indexing pressure cold store
 */  
 * in near future, are also part of this store. To limit any memory implications, this store has an upper limit on the maximum number of
package org.opensearch.index;
 * object is instantiated and registered in both the stores for concurrent accesses.
    }
 * object is brought into the hot store again, until it remains active. If not present in the either store, a fresh  
import org.opensearch.common.settings.ClusterSettings;
            shardIndexingPressureColdStore.putIfAbsent(tracker.getShardId(), tracker);  
    );
    }
        Setting.Property.NodeScope,
 * trackers its can hold at any given time, which is a configurable dynamic setting.  
import org.opensearch.core.index.shard.ShardId;
 * Trackers are maintained at two levels for access simplicity and better memory management:
            shardIndexingPressureHotStore.remove(tracker.getShardId(), tracker);
            shardIndexingPressureColdStore.clear();
 * update and evict operations can be abstracted out to support any other strategy such as LRU, if
        ShardIndexingPressureTracker tracker = shardIndexingPressureHotStore.get(shardId);  
                tracker = newTracker == null ? tracker : newTracker;
        if (shardIndexingPressureColdStore.size() > maxColdStoreSize) {
     */
 * <p>
        "shard_indexing_pressure.cache_store.max_size",
 */
 *  
                updateShardIndexingPressureColdStore(tracker);  
    }  
        this.shardIndexingPressureSettings = shardIndexingPressureSettings;  
}
        Setting.Property.Dynamic  
import org.opensearch.common.settings.Settings;  
/*  
 * <p>
                        this.shardIndexingPressureSettings.getShardPrimaryAndCoordinatingBaseLimits(),
public class ShardIndexingPressureStore {  
 * <p>
                );
        if (condition.getAsBoolean()) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    private final ShardIndexingPressureSettings shardIndexingPressureSettings;  
                    shardId,
            // If not already present in cold store instantiate a new one
                        this.shardIndexingPressureSettings.getShardReplicaBaseLimits()
                // Attempt update tracker to the hot store and return the tracker which finally made to the hot store to avoid any race
 * Copyright OpenSearch Contributors.
import java.util.function.BooleanSupplier;
    public static final Setting<Integer> MAX_COLD_STORE_SIZE = Setting.intSetting(  
 * <p>  
        if (isNull(tracker)) {
        shardIndexingPressureColdStore.put(tracker.getShardId(), tracker);
 * <p>
    }  
                ShardIndexingPressureTracker newTracker = shardIndexingPressureHotStore.putIfAbsent(shardId, tracker);  
import org.opensearch.common.settings.Setting;
        }  
        this.maxColdStoreSize = maxColdStoreSize;
        200,
 * Tracking objects when created are part of both the hot store as well as cold store. However, once the object
        return Collections.unmodifiableMap(shardIndexingPressureHotStore);
    }
    private final Map<ShardId, ShardIndexingPressureTracker> shardIndexingPressureColdStore = new HashMap<>();
    public ShardIndexingPressureStore(
    public Map<ShardId, ShardIndexingPressureTracker> getShardIndexingPressureColdStore() {
        ShardIndexingPressureSettings shardIndexingPressureSettings,
import static java.util.Objects.isNull;  
    // This represents the maximum value for the cold store size.
                tracker = shardIndexingPressureHotStore.computeIfAbsent(  
    ) {
import java.util.Map;  
 * 2. shardIndexingPressureColdStore : This acts as the store for all the shard tracking objects which are currently being used  
 * by the framework. In addition to hot trackers, the recently used trackers which are although not currently live, but again can be used
    public Map<ShardId, ShardIndexingPressureTracker> getShardIndexingPressureHotStore() {
    }
            }
    private volatile int maxColdStoreSize;
     * (periodic) operation, can be sized based on workload. It is okay to not to synchronize counters being flushed, as  
            // Try inserting into cold store again in case there was an eviction triggered
 * used at the Node level, for tracking indexing pressure requests.
            } else {
        return tracker;
                        shardId,  
 * discovered a need later.
    }  
    /**  
            if (isNull(tracker)) {
 * During get if tracking object is not present in the hot store, a lookup is made into the cache store. If found,
 * @opensearch.internal
        return Collections.unmodifiableMap(shardIndexingPressureColdStore);  
    private final Map<ShardId, ShardIndexingPressureTracker> shardIndexingPressureHotStore = ConcurrentCollections  
 * reaches its maximum limit. Think of it like a periodic purge when upper limit is hit.
    public ShardIndexingPressureTracker getShardIndexingPressureTracker(ShardId shardId) {
        }  
        ClusterSettings clusterSettings,  
        }  
     * completion. When the cold store size reaches maximum, all the tracker objects in cold store are flushed. Flush is a less frequent
            tracker = shardIndexingPressureColdStore.get(shardId);  
 * Note: The implementation of shardIndexingPressureColdStore methods is such that get,  
    private void setMaxColdStoreSize(int maxColdStoreSize) {
        .newConcurrentMapWithAggressiveConcurrency();
                    )  
        100,  
    private void updateShardIndexingPressureColdStore(ShardIndexingPressureTracker tracker) {  
    public void tryTrackerCleanupFromHotStore(ShardIndexingPressureTracker tracker, BooleanSupplier condition) {  
import java.util.HashMap;
        Settings settings
        1000,
 * Store manages the tracker lifecycle, from creation, access, until it is evicted to be collected.
 * 1. shardIndexingPressureHotStore : As the name suggests, it is hot store for tracker objects which are currently live i.e. being used  
     * objects in the cold store are only empty references, and can be re-initialized if needed.
        clusterSettings.addSettingsUpdateConsumer(MAX_COLD_STORE_SIZE, this::setMaxColdStoreSize);
 * SPDX-License-Identifier: Apache-2.0
