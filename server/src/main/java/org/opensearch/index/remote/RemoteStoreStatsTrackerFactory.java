        static final int MOVING_AVERAGE_WINDOW_SIZE = 20;
    }
    }  
        return movingAverageWindowSize;  
    }  
import org.opensearch.core.index.shard.ShardId;  
    public void afterIndexShardClosed(ShardId shardId, IndexShard indexShard, Settings indexSettings) {  
package org.opensearch.index.remote;
    int getMovingAverageWindowSize() {
import org.opensearch.index.shard.IndexShard;
        remoteTranslogTrackerMap.put(shardId, new RemoteTranslogTransferTracker(shardId, movingAverageWindowSize));
}
import org.apache.logging.log4j.Logger;
        Defaults.MOVING_AVERAGE_WINDOW_SIZE,
        logger.trace("Created RemoteTranslogTransferTracker for shardId={}", shardId);
     * Keeps map of remote-backed index shards and their corresponding stats tracker.  
            logger.trace("Deleted RemoteSegmentTransferTracker for shardId={}", shardId);  
    // visible for testing
     */
    private volatile int movingAverageWindowSize;
        RemoteSegmentTransferTracker remoteSegmentTransferTracker = remoteSegmentTrackerMap.remove(shardId);
        }
    public RemoteSegmentTransferTracker getRemoteSegmentTransferTracker(ShardId shardId) {
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
        static final int MOVING_AVERAGE_WINDOW_SIZE_MIN_VALUE = 5;  
public class RemoteStoreStatsTrackerFactory implements IndexEventListener {  
    public static final Setting<Integer> MOVING_AVERAGE_WINDOW_SIZE = Setting.intSetting(  
     */  
    @Override
        Defaults.MOVING_AVERAGE_WINDOW_SIZE_MIN_VALUE,  
        "remote_store.moving_average_window_size",
        clusterSettings.addSettingsUpdateConsumer(MOVING_AVERAGE_WINDOW_SIZE, this::updateMovingAverageWindowSize);
import org.opensearch.cluster.service.ClusterService;  
        Setting.Property.NodeScope
    private static final Logger logger = LogManager.getLogger(RemoteStoreStatsTrackerFactory.class);
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        return remoteSegmentTrackerMap.get(shardId);  
        if (indexShard.indexSettings().isRemoteStoreEnabled() == false && indexShard.indexSettings().isAssignedOnRemoteNode() == false) {
 */  
    }
            logger.trace("Deleted RemoteTranslogTransferTracker for shardId={}", shardId);
import org.opensearch.common.settings.ClusterSettings;
            new RemoteSegmentTransferTracker(shardId, indexShard.store().getDirectoryFileTransferTracker(), movingAverageWindowSize)
        logger.trace("Created RemoteSegmentTransferTracker for shardId={}", shardId);  
        if (remoteTranslogTransferTracker != null) {
            shardId,  
import org.apache.logging.log4j.LogManager;
     * Number of data points to consider for a moving average statistic
        this.movingAverageWindowSize = MOVING_AVERAGE_WINDOW_SIZE.get(settings);
    public void afterIndexShardCreated(IndexShard indexShard) {  
        }  
     */
        // Update movingAverageWindowSize only if the trackers were successfully updated
        remoteSegmentTrackerMap.put(
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Setting;  
import org.opensearch.common.annotation.PublicApi;
    }
    /**  
        remoteSegmentTrackerMap.values().forEach(tracker -> tracker.updateMovingAverageWindowSize(updatedSize));
    }
    );  
/**  
    private final Map<ShardId, RemoteSegmentTransferTracker> remoteSegmentTrackerMap = ConcurrentCollections.newConcurrentMap();  
 * SPDX-License-Identifier: Apache-2.0
        );
    public RemoteStoreStatsTrackerFactory(ClusterService clusterService, Settings settings) {
        return remoteTranslogTrackerMap.get(shardId);
import org.opensearch.index.shard.IndexEventListener;
import java.util.Map;
    }  
            return;
        Setting.Property.Dynamic,
    private final Map<ShardId, RemoteTranslogTransferTracker> remoteTranslogTrackerMap = ConcurrentCollections.newConcurrentMap();
    /**
    }
 *
 * Factory to manage stats trackers for Remote Store operations
 * this file be licensed under the Apache-2.0 license or a
     * Keeps map of remote-backed index shards and their corresponding stats tracker.
 */
 * @opensearch.api  
        remoteTranslogTrackerMap.values().forEach(tracker -> tracker.updateMovingAverageWindowSize(updatedSize));
    static class Defaults {
    public RemoteTranslogTransferTracker getRemoteTranslogTransferTracker(ShardId shardId) {  
/*  
        movingAverageWindowSize = updatedSize;
        ShardId shardId = indexShard.shardId();
    /**
    private void updateMovingAverageWindowSize(int updatedSize) {  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = remoteTranslogTrackerMap.remove(shardId);  
@PublicApi(since = "2.10.0")
        if (remoteSegmentTransferTracker != null) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
 *
        }  
    @Override
