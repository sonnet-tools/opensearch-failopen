    private volatile TimeValue primaryResyncTimeout;
        2,  
public class RecoverySettings {  
            recoveryRateLimiter.setMBPerSec(recoveryMaxBytesPerSec.getMbFrac());  
    );
        } else { // when replicationMaxBytesPerSec = -1B, use setting of recovery  
        new ByteSizeValue(1, ByteSizeUnit.GB),
        new ByteSizeValue(-1),
    public void setMergedSegmentReplicationTimeout(TimeValue mergedSegmentReplicationTimeout) {  
    }  
     * Individual speed setting for merged segment replication, default -1B to reuse the setting of recovery.
    public static final Setting<Integer> INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING = new Setting<>(
    );
        this.internalActionTimeout = internalActionTimeout;
    public int getMaxConcurrentFileChunks() {  
 * not use this file except in compliance with the License.
        false,
        this.mergedSegmentReplicationWarmerEnabled = mergedSegmentReplicationWarmerEnabled;  
        if (recoveryMaxBytesPerSec.getBytes() <= 0) {  
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public RecoverySettings(Settings settings, ClusterSettings clusterSettings) {
            replicationRateLimiter = getReplicationRateLimiter(replicationMaxBytesPerSec);
        this.mergedSegmentReplicationTimeout = mergedSegmentReplicationTimeout;
 */  
import org.opensearch.common.settings.Setting;
    // out-of-order execution of concurrent recovery of translog.  
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_CHUNK_SIZE_SETTING, this::setChunkSize);
        "indices.recovery.max_concurrent_remote_store_streams",
        Property.Dynamic,
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING, this::setRecoveryMaxBytesPerSec);
            settings
import org.opensearch.common.unit.TimeValue;
     * Dynamic setting to enable the merged segment warming(pre-copy) feature, default: false  
        new ByteSizeValue(40, ByteSizeUnit.MB),  
        );
            recoveryRateLimiter = new SimpleRateLimiter(recoveryMaxBytesPerSec.getMbFrac());
        clusterSettings.addSettingsUpdateConsumer(
        return internalActionRetryTimeout;
        return internalRemoteUploadTimeout;
import org.apache.lucene.store.RateLimiter.SimpleRateLimiter;
        "indices.recovery.remote_store.parallel_download.part_size",
        Property.Dynamic,  
    public static final Setting<Integer> INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING = Setting.intSetting(
        Property.NodeScope  
        return maxConcurrentOperations;  
     */  
        Property.Dynamic,
            this::setMergedSegmentReplicationMaxBytesPerSec  
 * compatible open source license.
        // and we want to give the cluster-manager time to remove a faulty node
    }
                return null;
    /** timeout value to use for requests made as part of the recovery process */
 *
        clusterSettings.addSettingsUpdateConsumer(
        if (recoveryMaxBytesPerSec.getBytes() <= 0) {
    private void setMergedSegmentReplicationMaxBytesPerSec(ByteSizeValue mergedSegmentReplicationMaxBytesPerSec) {
     * Control the maximum waiting time for replicate merged segment to the replica
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING, this::setRetryDelayNetwork);
     * Node-wide cap on the number of byte-range parts that may be prefetched ahead of the sequential writer across all
        this.maxConcurrentFileChunks = INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING.get(settings);  
    private volatile SimpleRateLimiter replicationRateLimiter;
    public void setChunkSize(ByteSizeValue chunkSize) {
    public TimeValue getMergedSegmentReplicationTimeout() {  
        "indices.recovery.recovery_activity_timeout",
    }
        TimeValue.timeValueMinutes(1),
    private SimpleRateLimiter getReplicationRateLimiter(ByteSizeValue replicationMaxBytesPerSec) {
     * Individual speed setting for segment replication, default -1B to reuse the setting of recovery.  
    public static final Setting<ByteSizeValue> INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING = Setting  
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING, this::setRetryDelayStateSync);
        TimeValue.timeValueMinutes(30),
            INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING,
    private volatile ByteSizeValue mergedSegmentWarmerMinSegmentSizeThreshold;  
    public TimeValue internalActionRetryTimeout() {
        this.internalActionTimeout = INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.get(settings);
    private volatile int translogConcurrentRecoveryBatchSize;
/**  
        this.internalRemoteUploadTimeout = INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.get(settings);
    );
    private volatile int maxConcurrentRemoteStoreStreams;
        "indices.replication.resync_timeout",  
    public static final Setting<Boolean> INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE = Setting.boolSetting(
    );
    private void setMaxConcurrentOperations(int maxConcurrentOperations) {  
    }  
        (s) -> Integer.toString(Math.max(1, OpenSearchExecutors.allocatedProcessors(s) / 2)),
        TimeValue.timeValueSeconds(0),
        this.primaryResyncTimeout = primaryResyncTimeout;  
    public void setRetryDelayStateSync(TimeValue retryDelayStateSync) {  
        "indices.recovery.internal_remote_upload_timeout",
        Property.Dynamic,
        clusterSettings.addSettingsUpdateConsumer(
        Property.NodeScope
        TimeValue.timeValueSeconds(5),  
        );  
        "indices.recovery.retry_delay_network",
        Property.Dynamic,
        1000000,
    }
    private volatile boolean isTranslogConcurrentRecoveryEnable;
        );  
            RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING,
    public TimeValue internalActionTimeout() {  
        Property.NodeScope  
        replicationRateLimiter = getReplicationRateLimiter(replicationMaxBytesPerSec);  
    public ByteSizeValue getMergedSegmentWarmerMinSegmentSizeThreshold() {
            this::setInternalActionLongTimeout  
            INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING,
        this.isTranslogConcurrentRecoveryEnable = INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE.get(settings);
    public static final Setting<ByteSizeValue> INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING = Setting.byteSizeSetting(
        (s) -> Setting.parseInt(s, 1, "indices.recovery.max_concurrent_remote_store_streams"),
    );
        Property.Dynamic,
    public void setIndicesMergedSegmentReplicationWarmerEnabled(boolean mergedSegmentReplicationWarmerEnabled) {
 * software distributed under the License is distributed on an
        Property.Dynamic,
        Property.Dynamic,
        TimeValue.timeValueMinutes(15),  
    }
    /**  
     */
        "indices.replication.merges.warmer.enabled",  
    /**
        (s) -> Setting.parseInt(s, 0, "indices.recovery.remote_store.parallel_download.max_concurrent_parts"),
    public static final Setting<TimeValue> INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING = Setting.timeSetting(
 * Unless required by applicable law or agreed to in writing,
        this.internalActionLongTimeout = INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING.get(settings);
    );
    private void setRemoteStoreParallelDownloadPartSize(ByteSizeValue partSize) {
                return null;
import org.opensearch.core.common.unit.ByteSizeValue;
        this.retryDelayNetwork = INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.get(settings);  
    }
     * defaults to `indices.recovery.internal_action_long_timeout`
     * not fire within this duration, the shard's {@code primaryReplicaResyncInProgress} flag is forcibly cleared so that it
     * Dynamic setting to set a threshold for minimum size of a merged segment to be warmed.
    }
        );
        this.maxConcurrentOperations = INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING.get(settings);
    private volatile TimeValue retryDelayStateSync;
        }  
        return retryDelayStateSync;
        Property.NodeScope
 * @opensearch.api  
    }  
     */
        clusterSettings.addSettingsUpdateConsumer(
        clusterSettings.addSettingsUpdateConsumer(
        } else {
        this.replicationMaxBytesPerSec = INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING.get(settings);
     */
    public static final Setting<TimeValue> INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING = Setting.timeSetting(
    );
    public ByteSizeValue getChunkSize() {
    }  
        false,  
        } else if (recoveryRateLimiter != null) {
    public static final Setting<TimeValue> INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING = Setting.timeSetting(
     * Node-wide budget of prefetched parts shared by all remote store downloads on this node.  
        return remoteStoreParallelDownloadPartSize;
    public static final Setting<TimeValue> INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING = Setting.positiveTimeSetting(
            this::setMergedSegmentReplicationTimeout
        mergedSegmentReplicationRateLimiter = getReplicationRateLimiter(mergedSegmentReplicationMaxBytesPerSec);  
        this.maxConcurrentFileChunks = maxConcurrentFileChunks;
    // occupancy is approximately 125MB
     * Timeout for the primary-replica resync that runs after a replica is promoted to primary. If the resync listener does
        // doesn't have to be fast as nodes are reconnected every 10s by default (see InternalClusterService.ReconnectToNodes)
import org.apache.lucene.store.RateLimiter;  
            INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE,
    private volatile TimeValue internalActionLongTimeout;  
        TimeValue.timeValueMillis(500),
            if (replicationMaxBytesPerSec.getBytes() == 0) {
    /** how long to wait before retrying after network related issues */  
            INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.get(settings)
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING, this::setInternalActionTimeout);  
        this.retryDelayStateSync = retryDelayStateSync;
        "indices.recovery.max_concurrent_operations",
        );
    public static final Setting<Integer> INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE = Setting.intSetting(  
        return translogConcurrentRecoveryBatchSize;  
            } else {  
    }
    public TimeValue getPrimaryResyncTimeout() {
    /**  
    public static final Setting<TimeValue> INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING = Setting.timeSetting(
        return chunkSize;
 * this file be licensed under the Apache-2.0 license or a
     * recoveries that don't show any activity for more then this interval will be failed.
        (s) -> Integer.toString(Math.max(1, OpenSearchExecutors.allocatedProcessors(s) / 2)),  
        Property.NodeScope
        clusterSettings.addSettingsUpdateConsumer(
    }
import org.opensearch.core.common.unit.ByteSizeUnit;  
    }
        return recoveryRateLimiter;
            INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING,
            INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING,  
 * Settings for the recovery mechanism
        this.mergedSegmentReplicationMaxBytesPerSec = INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.get(settings);  
        Property.Dynamic,
    );
     * concurrent remote store downloads. Each prefetched part holds at most  
        "indices.translog_concurrent_recovery.enable",
            } else {  
        "indices.replication.max_bytes_per_sec",  
     */  
        TimeValue.timeValueMinutes(0),
    }  
    }
    private volatile ByteSizeValue chunkSize;
        return primaryResyncTimeout;
     * {@link #INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING} bytes of heap, so the heap used by
 *
    public static final Setting<TimeValue> INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING = Setting.positiveTimeSetting(
    /**
        Property.Dynamic,
        return maxConcurrentFileChunks;
    public TimeValue activityTimeout() {
            INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING,
        return replicationRateLimiter;
     * defaults to twice `indices.recovery.internal_action_timeout`.
 */
    public boolean isTranslogConcurrentRecoveryEnable() {  
    public static final Setting<TimeValue> INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING = Setting.positiveTimeSetting(  
        Property.NodeScope
        this.mergedSegmentWarmerMinSegmentSizeThreshold = value;
    }  
        Property.Dynamic,
        this.remoteStoreParallelDownloadPartSize = partSize;
        this.remoteStoreParallelDownloadPartSize = INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING.get(settings);  
        Property.Dynamic,
        this.recoveryMaxBytesPerSec = INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.get(settings);
        1,
        this.chunkSize = INDICES_RECOVERY_CHUNK_SIZE_SETTING.get(settings);
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.TimeUnit;
    /**
    private volatile TimeValue internalRemoteUploadTimeout;  
        }  
        return activityTimeout;  
    public void setActivityTimeout(TimeValue activityTimeout) {
        );
            new ByteSizeValue(500, ByteSizeUnit.MB),  
        if (mergedSegmentReplicationMaxBytesPerSec.getBytes() < 0) {
/*  
    }
        this.translogConcurrentRecoveryBatchSize = INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE.get(settings);
        }  
    public void setRetryDelayNetwork(TimeValue retryDelayNetwork) {
    }
}  
        Property.Dynamic,  
        this.remoteStoreParallelDownloadPermits = new ParallelDownloadPermits(
    );  
    public ByteSizeValue getRemoteStoreParallelDownloadPartSize() {  
        5,
        this.mergedSegmentReplicationTimeout = INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING.get(settings);
 * KIND, either express or implied.  See the License for the
    private volatile TimeValue internalActionTimeout;
            recoveryRateLimiter = null;
 * Modifications Copyright OpenSearch Contributors. See
        this.maxConcurrentRemoteStoreStreams = maxConcurrentRemoteStoreStreams;  
     * cannot permanently block primary relocation. Defaults to 30 minutes.  
        "indices.recovery.remote_store.parallel_download.max_concurrent_parts",  
        clusterSettings.addSettingsUpdateConsumer(
        mergedSegmentReplicationRateLimiter = getReplicationRateLimiter(mergedSegmentReplicationMaxBytesPerSec);
        (s) -> TimeValue.timeValueMillis(INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.get(s).millis() * 2),  
        this.mergedSegmentWarmerMinSegmentSizeThreshold = INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.get(  
        return mergedSegmentReplicationTimeout;
            if (recoveryMaxBytesPerSec.getBytes() <= 0) {
        new ByteSizeValue(100, ByteSizeUnit.MB),
    }
        Property.NodeScope  
@PublicApi(since = "1.0.0")
    private volatile TimeValue mergedSegmentReplicationTimeout;
        this.maxConcurrentOperations = maxConcurrentOperations;
                return new SimpleRateLimiter(recoveryMaxBytesPerSec.getMbFrac());
        Property.NodeScope  
    }
        this.retryDelayNetwork = retryDelayNetwork;
     * A budget of zero disables multi-part parallel downloads.
 */
        return mergedSegmentReplicationRateLimiter;  
        this.chunkSize = chunkSize;  
    /**
        "indices.recovery.max_concurrent_file_chunks",
    }  
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING, this::setMaxConcurrentOperations);  
    }
/*
    private static final Logger logger = LogManager.getLogger(RecoverySettings.class);
        TimeValue.timeValueMinutes(15),
import org.apache.logging.log4j.LogManager;
 * SPDX-License-Identifier: Apache-2.0
        clusterSettings.addSettingsUpdateConsumer(INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING, this::setPrimaryResyncTimeout);  
        );  
    private volatile ByteSizeValue recoveryMaxBytesPerSec;
    }  
    }
    public static final Setting<TimeValue> INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING = Setting.positiveTimeSetting(
    );
    );
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING, this::setMaxConcurrentFileChunks);
    public void setInternalActionRetryTimeout(TimeValue internalActionRetryTimeout) {  
    );  
    }
            this::setIndicesMergedSegmentReplicationWarmerEnabled
        Property.NodeScope  
 * license agreements. See the NOTICE file distributed with
    private void setRecoveryMaxBytesPerSec(ByteSizeValue recoveryMaxBytesPerSec) {
    }  
    }
    );
        "indices.replication.merges.warmer.max_bytes_per_sec",
        this.activityTimeout = activityTimeout;  
        Property.NodeScope
    private volatile int maxConcurrentFileChunks;
     * how long to wait before retrying after issues cause by cluster state syncing between nodes
            mergedSegmentReplicationRateLimiter = getReplicationRateLimiter(mergedSegmentReplicationMaxBytesPerSec);
     * Size of each byte-range part when a single large segment file is downloaded from the remote store using
    }
            recoveryRateLimiter = null;  
    public static final ByteSizeValue DEFAULT_CHUNK_SIZE = new ByteSizeValue(512 * 1024 - 16, ByteSizeUnit.BYTES);
    public RateLimiter recoveryRateLimiter() {  
        clusterSettings.addSettingsUpdateConsumer(
        Property.Dynamic,  
    public static final Setting<Integer> INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING = Setting.intSetting(
            this::setInternalActionRetryTimeout
    private volatile ByteSizeValue remoteStoreParallelDownloadPartSize;
        .byteSizeSetting(
        clusterSettings.addSettingsUpdateConsumer(INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING, this::setReplicationMaxBytesPerSec);
    }
    private volatile TimeValue retryDelayNetwork;
        return remoteStoreParallelDownloadPermits;
    private volatile SimpleRateLimiter recoveryRateLimiter;
        "indices.recovery.internal_action_long_timeout",
        Property.NodeScope
            recoveryRateLimiter = new SimpleRateLimiter(recoveryMaxBytesPerSec.getMbFrac());
    public static final Setting<Boolean> INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING = Setting.boolSetting(
        );  
        "indices.recovery.chunk_size",
    }
     */  
        return this.maxConcurrentRemoteStoreStreams;
        new ByteSizeValue(16, ByteSizeUnit.MB),  
            }
        new ByteSizeValue(-1),
        );
    public static final Setting<ByteSizeValue> INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(  
    // Considering the worst-case scenario, with 1000 concurrent recovery tasks, each task recovering 1 million translogs, the bitset
    private void setMergedSegmentWarmerMinSegmentSizeThreshold(ByteSizeValue value) {
        this.maxConcurrentRemoteStoreStreams = INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING.get(settings);
     * multiple parallel range requests. Files no larger than one part are downloaded as a single stream.
        this.retryDelayStateSync = INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING.get(settings);
    public ParallelDownloadPermits getRemoteStoreParallelDownloadPermits() {  
 * You may obtain a copy of the License at  
    private volatile ByteSizeValue mergedSegmentReplicationMaxBytesPerSec;
    );
        Property.NodeScope  
    private volatile TimeValue activityTimeout;  
    public boolean isMergedSegmentReplicationWarmerEnabled() {
                return new SimpleRateLimiter(replicationMaxBytesPerSec.getMbFrac());
        return mergedSegmentReplicationWarmerEnabled;
        this.internalActionRetryTimeout = INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING.get(settings);  
            }
        500000,
        isTranslogConcurrentRecoveryEnable = translogConcurrentRecoveryEnable;
    }
    }
    private void setPrimaryResyncTimeout(TimeValue primaryResyncTimeout) {
        if (replicationMaxBytesPerSec.getBytes() >= 0) {  
    public void setInternalActionTimeout(TimeValue internalActionTimeout) {  
        new ByteSizeValue(1, ByteSizeUnit.MB),
    }  
        Property.NodeScope
    }  
     * Controls the maximum number of streams that can be started concurrently per recovery when downloading from the remote store.
    }
    }
        this.internalRemoteUploadTimeout = internalRemoteUploadTimeout;  
    public int getMaxConcurrentOperations() {
 * this work for additional information regarding copyright
    }
        Property.Dynamic,  
        Property.Dynamic,  
        );
        this.internalActionLongTimeout = internalActionLongTimeout;
    public RateLimiter replicationRateLimiter() {
            this::setRemoteStoreParallelDownloadPartSize
 * ownership. Elasticsearch licenses this file to you under  
    );
        Property.Dynamic,  
        } else {
        new ByteSizeValue(1, ByteSizeUnit.BYTES),
    public static final Setting<ByteSizeValue> INDICES_RECOVERY_CHUNK_SIZE_SETTING = Setting.byteSizeSetting(
            this::setMergedSegmentWarmerMinSegmentSizeThreshold  
/*  
    private void setReplicationMaxBytesPerSec(ByteSizeValue replicationMaxBytesPerSec) {  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    );
        return internalActionLongTimeout;  
        logger.debug("using recovery max_bytes_per_sec[{}]", recoveryMaxBytesPerSec);  
        return this.mergedSegmentWarmerMinSegmentSizeThreshold;  
    private volatile ByteSizeValue replicationMaxBytesPerSec;
    public static final Setting<ByteSizeValue> INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
    );
        if (replicationMaxBytesPerSec.getBytes() < 0) {
        1,  
        );
    }
        }  
    }  
    public static final Setting<Integer> INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING = new Setting<>(
     */  
            this::setTranslogConcurrentRecoveryBatchSize  
        "indices.recovery.max_bytes_per_sec",
    }  
    private volatile int maxConcurrentOperations;  
    /**
        "indices.recovery.retry_delay_state_sync",  
import org.apache.logging.log4j.Logger;
    }
     * Controls the maximum number of file chunk requests that can be sent concurrently from the source node to the target node.
            this::setMaxConcurrentRemoteStoreStreams  
    private final ParallelDownloadPermits remoteStoreParallelDownloadPermits;  
        );
        Property.NodeScope
            INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING,
    private volatile SimpleRateLimiter mergedSegmentReplicationRateLimiter;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    private volatile TimeValue internalActionRetryTimeout;
        1000,  
    /**
        clusterSettings.addSettingsUpdateConsumer(INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE, this::setTranslogConcurrentRecoveryEnable);  
        }  
    }
    // choose 512KB-16B to ensure that the resulting byte[] is not a humongous allocation in G1.
 *  
    );
    }
        return internalActionTimeout;
    );  
    /**  
    private void setMaxConcurrentFileChunks(int maxConcurrentFileChunks) {
    public static final Setting<ByteSizeValue> INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
            remoteStoreParallelDownloadPermits::setMaxPermits
     * multi-part downloads and every file is fetched as a single stream.  
        this.activityTimeout = INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING.get(settings);  
    );
    /** timeout value to use for the retrying of requests made as part of the recovery process */
        this.mergedSegmentReplicationWarmerEnabled = INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.get(settings);
        this.internalActionRetryTimeout = internalActionRetryTimeout;
        clusterSettings.addSettingsUpdateConsumer(  
            INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING,  
    private void setTranslogConcurrentRecoveryBatchSize(int translogConcurrentRecoveryBatchSize) {  
        this.mergedSegmentReplicationMaxBytesPerSec = mergedSegmentReplicationMaxBytesPerSec;
        Property.NodeScope  
    );
        Property.NodeScope
        Property.NodeScope  
 *
     */
     */
            Property.NodeScope
 * under the License.  
        "indices.recovery.internal_action_retry_timeout",  
     * Controls the maximum number of operation chunk requests that can be sent concurrently from the source node to the target node.
        DEFAULT_CHUNK_SIZE,  
        return isTranslogConcurrentRecoveryEnable;
import org.opensearch.common.settings.ClusterSettings;  
        this.replicationMaxBytesPerSec = replicationMaxBytesPerSec;
     * parallel part downloads is bounded by {@code max_concurrent_parts * part_size}. Setting this to 0 disables
    private void setMaxConcurrentRemoteStoreStreams(int maxConcurrentRemoteStoreStreams) {
            INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING,  
        );
        this.translogConcurrentRecoveryBatchSize = translogConcurrentRecoveryBatchSize;
        new TimeValue(1, TimeUnit.HOURS),
            "indices.replication.merges.warmer.min_segment_size_threshold",
    public TimeValue retryDelayStateSync() {
        4,
import org.opensearch.common.settings.Settings;  
        this.recoveryMaxBytesPerSec = recoveryMaxBytesPerSec;
    /**  
    }  
        TimeValue.timeValueSeconds(0),
     */
        Property.Dynamic,  
    public TimeValue retryDelayNetwork() {  
        clusterSettings.addSettingsUpdateConsumer(  
    public static final Setting<TimeValue> INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT = Setting.timeSetting(  
        "indices.translog_concurrent_recovery.batch_size",
    public SimpleRateLimiter mergedSegmentReplicationRateLimiter() {
        Property.NodeScope
        1,
    private void setTranslogConcurrentRecoveryEnable(boolean translogConcurrentRecoveryEnable) {
    public void setInternalRemoteUploadTimeout(TimeValue internalRemoteUploadTimeout) {
    /**  
    public TimeValue internalRemoteUploadTimeout() {  
        "indices.recovery.internal_action_timeout",
        Property.NodeScope  
        TimeValue.timeValueSeconds(10),
    public TimeValue internalActionLongTimeout() {
        replicationRateLimiter = getReplicationRateLimiter(replicationMaxBytesPerSec);
    // Limiting the maximum value to 1 million is to avoid excessive memory usage of the bitset in LocalCheckpointTracker during
 * Licensed to Elasticsearch under one or more contributor  
        this.primaryResyncTimeout = INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.get(settings);
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING, this::setActivityTimeout);
            Property.Dynamic,
import org.opensearch.index.store.ParallelDownloadPermits;
     */
 * GitHub history for details.
     */  
    /**
 * specific language governing permissions and limitations
     * i.e., local node is not yet known on remote node, remote shard not yet started etc.  
package org.opensearch.indices.recovery;
    public int getMaxConcurrentRemoteStoreStreams() {
    /**
        return retryDelayNetwork;
 */  
        Property.NodeScope
     * timeout value to use for requests made as part of the recovery process that are expected to take long time.
        Property.NodeScope
    public int getTranslogConcurrentRecoveryBatchSize() {
        Property.Dynamic,
        INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING::get,  
    /**
     */
        Property.Dynamic,  
        Property.Dynamic,  
    /**  
        "indices.replication.merges.warmer.timeout",
import org.opensearch.common.settings.Setting.Property;
        clusterSettings.addSettingsUpdateConsumer(INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT, this::setInternalRemoteUploadTimeout);  
    public void setInternalActionLongTimeout(TimeValue internalActionLongTimeout) {
    private volatile boolean mergedSegmentReplicationWarmerEnabled;  
