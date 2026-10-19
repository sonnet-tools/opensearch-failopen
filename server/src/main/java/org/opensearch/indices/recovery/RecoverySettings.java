        clusterSettings.addSettingsUpdateConsumer(
 * KIND, either express or implied.  See the License for the
        TimeValue.timeValueMinutes(0),
            this::setRemoteStoreParallelDownloadPartSize
        Property.NodeScope
    public boolean isMergedSegmentReplicationWarmerEnabled() {
        this.replicationMaxBytesPerSec = INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING.get(settings);
     * cannot permanently block primary relocation. Defaults to 30 minutes.
        Property.NodeScope
        TimeValue.timeValueSeconds(5),
    public static final Setting<ByteSizeValue> INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING = Setting
    private void setMergedSegmentWarmerMinSegmentSizeThreshold(ByteSizeValue value) {
    public TimeValue internalActionRetryTimeout() {
        Property.NodeScope
        TimeValue.timeValueSeconds(0),
        clusterSettings.addSettingsUpdateConsumer(INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE, this::setTranslogConcurrentRecoveryEnable);
import org.apache.logging.log4j.Logger;
            recoveryRateLimiter = new SimpleRateLimiter(recoveryMaxBytesPerSec.getMbFrac());
    public int getMaxConcurrentOperations() {
 * Modifications Copyright OpenSearch Contributors. See
        );
    );
    private volatile ByteSizeValue remoteStoreParallelDownloadPartSize;
    private volatile TimeValue internalActionRetryTimeout;
    public void setActivityTimeout(TimeValue activityTimeout) {
import org.opensearch.common.unit.TimeValue;
        4,
        mergedSegmentReplicationRateLimiter = getReplicationRateLimiter(mergedSegmentReplicationMaxBytesPerSec);
        Property.NodeScope
        1,
        this.internalRemoteUploadTimeout = internalRemoteUploadTimeout;
    }
        Property.Dynamic,
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING, this::setRecoveryMaxBytesPerSec);
        "indices.recovery.remote_store.parallel_download.max_concurrent_parts",
    public TimeValue getMergedSegmentReplicationTimeout() {
    public void setInternalRemoteUploadTimeout(TimeValue internalRemoteUploadTimeout) {
        "indices.recovery.max_concurrent_remote_store_streams",
        this.activityTimeout = INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING.get(settings);
        this.maxConcurrentOperations = INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING.get(settings);
    }
            INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING,
    }
        return internalActionRetryTimeout;
        );
    }
     * concurrent remote store downloads. Each prefetched part holds at most
    }
        this.mergedSegmentWarmerMinSegmentSizeThreshold = INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.get(
import java.util.concurrent.TimeUnit;
        "indices.replication.merges.warmer.enabled",
    public RecoverySettings(Settings settings, ClusterSettings clusterSettings) {
    private volatile TimeValue internalActionTimeout;
        Property.Dynamic,
        if (replicationMaxBytesPerSec.getBytes() < 0) {
    );
        clusterSettings.addSettingsUpdateConsumer(INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT, this::setInternalRemoteUploadTimeout);
        Property.NodeScope
        this.translogConcurrentRecoveryBatchSize = translogConcurrentRecoveryBatchSize;
     * Size of each byte-range part when a single large segment file is downloaded from the remote store using
    }
 * SPDX-License-Identifier: Apache-2.0
        }
 * ownership. Elasticsearch licenses this file to you under
            this::setInternalActionLongTimeout
        Property.NodeScope
    );
    }
        }
    /**
    public SimpleRateLimiter mergedSegmentReplicationRateLimiter() {
import org.apache.lucene.store.RateLimiter;
        this.retryDelayStateSync = INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING.get(settings);
    );
    public RateLimiter replicationRateLimiter() {
     */
    }
    public TimeValue internalRemoteUploadTimeout() {
    public void setRetryDelayStateSync(TimeValue retryDelayStateSync) {
        (s) -> Integer.toString(Math.max(1, OpenSearchExecutors.allocatedProcessors(s) / 2)),
        this.mergedSegmentReplicationMaxBytesPerSec = mergedSegmentReplicationMaxBytesPerSec;
        Property.Dynamic,
        this.internalRemoteUploadTimeout = INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT.get(settings);
    private SimpleRateLimiter getReplicationRateLimiter(ByteSizeValue replicationMaxBytesPerSec) {
        return internalActionTimeout;
    private volatile TimeValue retryDelayNetwork;
    public TimeValue retryDelayNetwork() {
    public static final Setting<TimeValue> INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING = Setting.timeSetting(
        1000000,
     * recoveries that don't show any activity for more then this interval will be failed.
 * license agreements. See the NOTICE file distributed with
 * under the License.
            settings
    }
        Property.NodeScope
     */
    // choose 512KB-16B to ensure that the resulting byte[] is not a humongous allocation in G1.
        this.replicationMaxBytesPerSec = replicationMaxBytesPerSec;
        this.mergedSegmentReplicationWarmerEnabled = mergedSegmentReplicationWarmerEnabled;
 *
        this.retryDelayNetwork = INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.get(settings);
     * timeout value to use for requests made as part of the recovery process that are expected to take long time.
        Property.Dynamic,
     */
        this.internalActionRetryTimeout = internalActionRetryTimeout;
        new ByteSizeValue(-1),
    }
    public static final Setting<ByteSizeValue> INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING = Setting.byteSizeSetting(
    private void setPrimaryResyncTimeout(TimeValue primaryResyncTimeout) {
     * Individual speed setting for segment replication, default -1B to reuse the setting of recovery.
            Property.NodeScope
     * multi-part downloads and every file is fetched as a single stream.
        );
    public static final Setting<ByteSizeValue> INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
    private volatile int maxConcurrentRemoteStoreStreams;
    );
        this.primaryResyncTimeout = INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.get(settings);
    private volatile TimeValue internalRemoteUploadTimeout;
        TimeValue.timeValueMinutes(15),
        new TimeValue(1, TimeUnit.HOURS),
        if (recoveryMaxBytesPerSec.getBytes() <= 0) {
    }
        this.remoteStoreParallelDownloadPartSize = partSize;
    /** timeout value to use for the retrying of requests made as part of the recovery process */
@PublicApi(since = "1.0.0")
        Property.Dynamic,
            mergedSegmentReplicationRateLimiter = getReplicationRateLimiter(mergedSegmentReplicationMaxBytesPerSec);
        return isTranslogConcurrentRecoveryEnable;
    public static final Setting<TimeValue> INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING = Setting.positiveTimeSetting(
        Property.Dynamic,
        TimeValue.timeValueMinutes(30),
     */
        mergedSegmentReplicationRateLimiter = getReplicationRateLimiter(mergedSegmentReplicationMaxBytesPerSec);
    private volatile int maxConcurrentFileChunks;
        }
    private volatile SimpleRateLimiter replicationRateLimiter;
    public int getMaxConcurrentFileChunks() {
        );
    );
        clusterSettings.addSettingsUpdateConsumer(
    }
        return maxConcurrentFileChunks;
        return remoteStoreParallelDownloadPartSize;
    }
    public RateLimiter recoveryRateLimiter() {
    }
        "indices.replication.max_bytes_per_sec",
        clusterSettings.addSettingsUpdateConsumer(
        TimeValue.timeValueSeconds(0),
            INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING,
    public int getTranslogConcurrentRecoveryBatchSize() {
    );
     * defaults to `indices.recovery.internal_action_long_timeout`
        new ByteSizeValue(1, ByteSizeUnit.BYTES),
    /**
        if (recoveryMaxBytesPerSec.getBytes() <= 0) {
    }
    public void setIndicesMergedSegmentReplicationWarmerEnabled(boolean mergedSegmentReplicationWarmerEnabled) {
        return translogConcurrentRecoveryBatchSize;
     */
import org.opensearch.common.annotation.PublicApi;
    }
        clusterSettings.addSettingsUpdateConsumer(
        Property.Dynamic,
        "indices.recovery.internal_action_timeout",
/*
    );
     * Controls the maximum number of operation chunk requests that can be sent concurrently from the source node to the target node.
    public static final ByteSizeValue DEFAULT_CHUNK_SIZE = new ByteSizeValue(512 * 1024 - 16, ByteSizeUnit.BYTES);
import org.apache.logging.log4j.LogManager;
    public static final Setting<TimeValue> INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT = Setting.timeSetting(
        "indices.recovery.internal_action_retry_timeout",
        );
    /**
import org.opensearch.common.settings.Setting.Property;
            INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE,
        Property.Dynamic,
            this::setIndicesMergedSegmentReplicationWarmerEnabled
                return new SimpleRateLimiter(recoveryMaxBytesPerSec.getMbFrac());
    /**
    }
    }
    }
public class RecoverySettings {
        Property.Dynamic,
 * compatible open source license.
        (s) -> Integer.toString(Math.max(1, OpenSearchExecutors.allocatedProcessors(s) / 2)),
    /**
        Property.Dynamic,
    private volatile TimeValue retryDelayStateSync;
    );
     * Node-wide budget of prefetched parts shared by all remote store downloads on this node.
     * {@link #INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING} bytes of heap, so the heap used by
    public TimeValue retryDelayStateSync() {
    public ByteSizeValue getMergedSegmentWarmerMinSegmentSizeThreshold() {
            INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING,
    private final ParallelDownloadPermits remoteStoreParallelDownloadPermits;
    }
        return maxConcurrentOperations;
        this.maxConcurrentRemoteStoreStreams = INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING.get(settings);
    private volatile TimeValue activityTimeout;
            INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING,
    );
        this.maxConcurrentFileChunks = maxConcurrentFileChunks;
     * i.e., local node is not yet known on remote node, remote shard not yet started etc.
    }
        this.recoveryMaxBytesPerSec = INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.get(settings);
        this.internalActionLongTimeout = internalActionLongTimeout;
            RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING,
        this.chunkSize = chunkSize;
        Property.NodeScope
    }
    // out-of-order execution of concurrent recovery of translog.
import org.opensearch.core.common.unit.ByteSizeValue;
     * Controls the maximum number of file chunk requests that can be sent concurrently from the source node to the target node.
        );
    private volatile ByteSizeValue mergedSegmentWarmerMinSegmentSizeThreshold;
        this.remoteStoreParallelDownloadPermits = new ParallelDownloadPermits(
        );
            Property.Dynamic,
    private void setMaxConcurrentRemoteStoreStreams(int maxConcurrentRemoteStoreStreams) {
            INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING,
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING, this::setActivityTimeout);
 * Licensed to Elasticsearch under one or more contributor
        new ByteSizeValue(1, ByteSizeUnit.MB),
    /**
    private volatile boolean mergedSegmentReplicationWarmerEnabled;
        this.chunkSize = INDICES_RECOVERY_CHUNK_SIZE_SETTING.get(settings);
/**
        this.internalActionRetryTimeout = INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING.get(settings);
        }
 */
        new ByteSizeValue(100, ByteSizeUnit.MB),
        Property.NodeScope
        (s) -> TimeValue.timeValueMillis(INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.get(s).millis() * 2),
     */
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING, this::setRetryDelayStateSync);
        new ByteSizeValue(40, ByteSizeUnit.MB),
    public static final Setting<TimeValue> INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING = Setting.timeSetting(
     */
     * Controls the maximum number of streams that can be started concurrently per recovery when downloading from the remote store.
    public static final Setting<Integer> INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING = Setting.intSetting(
    );
    }
        } else { // when replicationMaxBytesPerSec = -1B, use setting of recovery
            recoveryRateLimiter = null;
 * this file be licensed under the Apache-2.0 license or a
        new ByteSizeValue(1, ByteSizeUnit.GB),
    public TimeValue getPrimaryResyncTimeout() {
        return mergedSegmentReplicationTimeout;
        return this.maxConcurrentRemoteStoreStreams;
    private volatile SimpleRateLimiter mergedSegmentReplicationRateLimiter;
        Property.NodeScope
        replicationRateLimiter = getReplicationRateLimiter(replicationMaxBytesPerSec);
    private volatile ByteSizeValue recoveryMaxBytesPerSec;
     */
        "indices.translog_concurrent_recovery.enable",
 * GitHub history for details.
        return this.mergedSegmentWarmerMinSegmentSizeThreshold;
    private volatile TimeValue internalActionLongTimeout;
    /** timeout value to use for requests made as part of the recovery process */
        return internalRemoteUploadTimeout;
        this.recoveryMaxBytesPerSec = recoveryMaxBytesPerSec;
        Property.NodeScope
        this.retryDelayStateSync = retryDelayStateSync;
        false,
        Property.Dynamic,
    public void setMergedSegmentReplicationTimeout(TimeValue mergedSegmentReplicationTimeout) {
 * @opensearch.api
    }
    }
    }
    }
    private volatile int translogConcurrentRecoveryBatchSize;
                return null;
    private volatile TimeValue mergedSegmentReplicationTimeout;
        "indices.recovery.internal_action_long_timeout",
    );
        return replicationRateLimiter;
        return chunkSize;
        return remoteStoreParallelDownloadPermits;
    );
        return primaryResyncTimeout;
/*
    public TimeValue internalActionLongTimeout() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING,
            this::setMaxConcurrentRemoteStoreStreams
            INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.get(settings)
    }
        clusterSettings.addSettingsUpdateConsumer(INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING, this::setPrimaryResyncTimeout);
    public static final Setting<ByteSizeValue> INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
        .byteSizeSetting(
    public TimeValue activityTimeout() {
    );
        return activityTimeout;
    public boolean isTranslogConcurrentRecoveryEnable() {
            }
            remoteStoreParallelDownloadPermits::setMaxPermits
    /**
     */
    /**
    }
    }
        if (mergedSegmentReplicationMaxBytesPerSec.getBytes() < 0) {
    );
        if (replicationMaxBytesPerSec.getBytes() >= 0) {
 * this work for additional information regarding copyright
    /** how long to wait before retrying after network related issues */
        this.internalActionTimeout = INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.get(settings);
    private void setRemoteStoreParallelDownloadPartSize(ByteSizeValue partSize) {
            this::setMergedSegmentReplicationTimeout
        Property.Dynamic,
        isTranslogConcurrentRecoveryEnable = translogConcurrentRecoveryEnable;
        "indices.recovery.recovery_activity_timeout",
    // Considering the worst-case scenario, with 1000 concurrent recovery tasks, each task recovering 1 million translogs, the bitset
        Property.NodeScope
        clusterSettings.addSettingsUpdateConsumer(
     */
 * Unless required by applicable law or agreed to in writing,
            this::setTranslogConcurrentRecoveryBatchSize
    }
            this::setMergedSegmentReplicationMaxBytesPerSec
    public int getMaxConcurrentRemoteStoreStreams() {
    private volatile TimeValue primaryResyncTimeout;
        this.internalActionLongTimeout = INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING.get(settings);
     * defaults to twice `indices.recovery.internal_action_timeout`.
                return null;
    }
 */
        this.mergedSegmentReplicationTimeout = mergedSegmentReplicationTimeout;
    private volatile ByteSizeValue replicationMaxBytesPerSec;
import org.apache.lucene.store.RateLimiter.SimpleRateLimiter;
        } else {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        (s) -> Setting.parseInt(s, 1, "indices.recovery.max_concurrent_remote_store_streams"),
        "indices.replication.merges.warmer.max_bytes_per_sec",
        this.primaryResyncTimeout = primaryResyncTimeout;
        clusterSettings.addSettingsUpdateConsumer(
        }
        Property.Dynamic,
        } else {
 *
    );
 * the Apache License, Version 2.0 (the "License"); you may
    }
        "indices.recovery.chunk_size",
    private volatile SimpleRateLimiter recoveryRateLimiter;
    public static final Setting<TimeValue> INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING = Setting.timeSetting(
        "indices.recovery.max_bytes_per_sec",
        this.maxConcurrentRemoteStoreStreams = maxConcurrentRemoteStoreStreams;
        this.mergedSegmentReplicationWarmerEnabled = INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.get(settings);
import org.opensearch.common.settings.Setting;
        Property.NodeScope
        return retryDelayStateSync;
 * Settings for the recovery mechanism
        5,
    public void setInternalActionTimeout(TimeValue internalActionTimeout) {
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING, this::setInternalActionTimeout);
    public static final Setting<Boolean> INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE = Setting.boolSetting(
        Property.Dynamic,
    private void setReplicationMaxBytesPerSec(ByteSizeValue replicationMaxBytesPerSec) {
    private volatile ByteSizeValue mergedSegmentReplicationMaxBytesPerSec;
        return recoveryRateLimiter;
/*
    public void setInternalActionRetryTimeout(TimeValue internalActionRetryTimeout) {
    private volatile ByteSizeValue chunkSize;
    private void setMaxConcurrentFileChunks(int maxConcurrentFileChunks) {
    public static final Setting<Integer> INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE = Setting.intSetting(
     * multiple parallel range requests. Files no larger than one part are downloaded as a single stream.
        TimeValue.timeValueMinutes(1),
    }
    public static final Setting<Integer> INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING = Setting.intSetting(
            "indices.replication.merges.warmer.min_segment_size_threshold",
            if (replicationMaxBytesPerSec.getBytes() == 0) {
        Property.Dynamic,
    }
                return new SimpleRateLimiter(replicationMaxBytesPerSec.getMbFrac());
        clusterSettings.addSettingsUpdateConsumer(
    }
    public static final Setting<Boolean> INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING = Setting.boolSetting(
     * Dynamic setting to set a threshold for minimum size of a merged segment to be warmed.
 * not use this file except in compliance with the License.
        new ByteSizeValue(-1),
        "indices.recovery.internal_remote_upload_timeout",
    );
        // and we want to give the cluster-manager time to remove a faulty node
    public static final Setting<Integer> INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING = new Setting<>(
 *
 * The OpenSearch Contributors require contributions made to
    private void setTranslogConcurrentRecoveryBatchSize(int translogConcurrentRecoveryBatchSize) {
        Property.NodeScope
            } else {
        Property.NodeScope
    }
            } else {
     * Individual speed setting for merged segment replication, default -1B to reuse the setting of recovery.
    /**
    }
 * specific language governing permissions and limitations
        (s) -> Setting.parseInt(s, 0, "indices.recovery.remote_store.parallel_download.max_concurrent_parts"),
    // Limiting the maximum value to 1 million is to avoid excessive memory usage of the bitset in LocalCheckpointTracker during
        1,
    public TimeValue internalActionTimeout() {
        this.mergedSegmentReplicationMaxBytesPerSec = INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.get(settings);
        this.mergedSegmentReplicationTimeout = INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING.get(settings);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return retryDelayNetwork;
        1000,
    private volatile int maxConcurrentOperations;
        Property.NodeScope
    public static final Setting<TimeValue> INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING = Setting.positiveTimeSetting(
        replicationRateLimiter = getReplicationRateLimiter(replicationMaxBytesPerSec);
        this.isTranslogConcurrentRecoveryEnable = INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE.get(settings);
    }
        new ByteSizeValue(16, ByteSizeUnit.MB),
     * not fire within this duration, the shard's {@code primaryReplicaResyncInProgress} flag is forcibly cleared so that it
    private void setMergedSegmentReplicationMaxBytesPerSec(ByteSizeValue mergedSegmentReplicationMaxBytesPerSec) {
    private void setTranslogConcurrentRecoveryEnable(boolean translogConcurrentRecoveryEnable) {
        1,
    }
        "indices.replication.merges.warmer.timeout",
     */
    public void setRetryDelayNetwork(TimeValue retryDelayNetwork) {
    );
            replicationRateLimiter = getReplicationRateLimiter(replicationMaxBytesPerSec);
        this.mergedSegmentWarmerMinSegmentSizeThreshold = value;
        this.retryDelayNetwork = retryDelayNetwork;
            if (recoveryMaxBytesPerSec.getBytes() <= 0) {
package org.opensearch.indices.recovery;
            this::setMergedSegmentWarmerMinSegmentSizeThreshold
        DEFAULT_CHUNK_SIZE,
        500000,
    );
import org.opensearch.index.store.ParallelDownloadPermits;
     * Timeout for the primary-replica resync that runs after a replica is promoted to primary. If the resync listener does
     */
        Property.NodeScope
     * A budget of zero disables multi-part parallel downloads.
     * parallel part downloads is bounded by {@code max_concurrent_parts * part_size}. Setting this to 0 disables
    }
        TimeValue.timeValueMinutes(15),
        false,
            recoveryRateLimiter.setMBPerSec(recoveryMaxBytesPerSec.getMbFrac());
    /**
        return mergedSegmentReplicationWarmerEnabled;
        Property.Dynamic,
        Property.NodeScope
     */
        this.activityTimeout = activityTimeout;
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING, this::setRetryDelayNetwork);
        2,
        Property.Dynamic,
        Property.Dynamic,
    public static final Setting<ByteSizeValue> INDICES_RECOVERY_CHUNK_SIZE_SETTING = Setting.byteSizeSetting(
        Property.NodeScope
    // occupancy is approximately 125MB
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_CHUNK_SIZE_SETTING, this::setChunkSize);
    /**
        );
            this::setInternalActionRetryTimeout
        "indices.recovery.retry_delay_network",
    public void setInternalActionLongTimeout(TimeValue internalActionLongTimeout) {
        this.translogConcurrentRecoveryBatchSize = INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE.get(settings);
    public static final Setting<TimeValue> INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING = Setting.timeSetting(
        "indices.recovery.retry_delay_state_sync",
    private volatile boolean isTranslogConcurrentRecoveryEnable;
        return mergedSegmentReplicationRateLimiter;
    /**
        clusterSettings.addSettingsUpdateConsumer(
import org.opensearch.common.settings.ClusterSettings;
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING, this::setMaxConcurrentFileChunks);
            recoveryRateLimiter = new SimpleRateLimiter(recoveryMaxBytesPerSec.getMbFrac());
            INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING,
     * how long to wait before retrying after issues cause by cluster state syncing between nodes
        logger.debug("using recovery max_bytes_per_sec[{}]", recoveryMaxBytesPerSec);
        this.internalActionTimeout = internalActionTimeout;
        this.remoteStoreParallelDownloadPartSize = INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING.get(settings);
        );
     */
        return internalActionLongTimeout;
 *
 * You may obtain a copy of the License at
            new ByteSizeValue(500, ByteSizeUnit.MB),
        // doesn't have to be fast as nodes are reconnected every 10s by default (see InternalClusterService.ReconnectToNodes)
        "indices.recovery.max_concurrent_operations",
        Property.Dynamic,
    public ParallelDownloadPermits getRemoteStoreParallelDownloadPermits() {
        "indices.translog_concurrent_recovery.batch_size",
        Property.NodeScope
        "indices.recovery.remote_store.parallel_download.part_size",
        );
    public static final Setting<Integer> INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING = new Setting<>(
        } else if (recoveryRateLimiter != null) {
    public static final Setting<TimeValue> INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING = Setting.positiveTimeSetting(
            recoveryRateLimiter = null;
    public void setChunkSize(ByteSizeValue chunkSize) {
        clusterSettings.addSettingsUpdateConsumer(INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING, this::setMaxConcurrentOperations);
        TimeValue.timeValueMillis(500),
            INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING,
    public static final Setting<TimeValue> INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING = Setting.positiveTimeSetting(
        "indices.replication.resync_timeout",
import org.opensearch.core.common.unit.ByteSizeUnit;
        );
    /**
    }
    );
        Property.NodeScope
    public ByteSizeValue getChunkSize() {
     */
     * Dynamic setting to enable the merged segment warming(pre-copy) feature, default: false
import org.opensearch.common.settings.Settings;
        this.maxConcurrentOperations = maxConcurrentOperations;
    public static final Setting<ByteSizeValue> INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
        clusterSettings.addSettingsUpdateConsumer(
    public ByteSizeValue getRemoteStoreParallelDownloadPartSize() {
}
        Property.Dynamic,
    }
    }
    private void setMaxConcurrentOperations(int maxConcurrentOperations) {
     * Control the maximum waiting time for replicate merged segment to the replica
 * software distributed under the License is distributed on an
        "indices.recovery.max_concurrent_file_chunks",
 */
        );
 */
            }
        this.maxConcurrentFileChunks = INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING.get(settings);
        INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING::get,
        clusterSettings.addSettingsUpdateConsumer(
     * Node-wide cap on the number of byte-range parts that may be prefetched ahead of the sequential writer across all
    private void setRecoveryMaxBytesPerSec(ByteSizeValue recoveryMaxBytesPerSec) {
    );
        );
        Property.Dynamic,
        TimeValue.timeValueSeconds(10),
    /**
    }
        clusterSettings.addSettingsUpdateConsumer(INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING, this::setReplicationMaxBytesPerSec);
    private static final Logger logger = LogManager.getLogger(RecoverySettings.class);
