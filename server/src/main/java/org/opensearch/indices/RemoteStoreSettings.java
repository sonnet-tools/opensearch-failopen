        },
    /**
        );
    }
    }
    private void setPathHashAlgorithm(RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm) {
        this.flushOnUncommittedSegmentsThresholdSize = flushOnUncommittedSegmentsThresholdSize;
    private volatile int maxRemoteTranslogReaders;
            CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
     */
        10,
            this::setClusterRemoteTranslogBufferInterval
    }
     * Controls the fixed prefix for the segments path on remote store.
}
        "cluster.remote_store.uploaded_segments_cleanup_threshold",
                throw new IllegalArgumentException(
     * ({@code index.remote_store.flush_on_uncommitted_segments.threshold_size}, see
        Property.Dynamic
    public boolean isClusterServerSideEncryptionEnabled() {
                );
    public static final Setting<RemoteStoreEnums.PathType> CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING = new Setting<>(
        RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.toString(),
    public static final Setting<TimeValue> CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING = Setting.timeSetting(
        Property.NodeScope,
            CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING,
    private volatile TimeValue clusterRemoteTranslogTransferTimeout;
        "cluster.remote_store.pinned_timestamps.enabled",
        Property.Dynamic
    private void setClusterRemoteTranslogBufferInterval(TimeValue clusterRemoteTranslogBufferInterval) {
     * repositories that supports metadata read and write with metadata and is applicable for only remote store enabled clusters.
    /**
    public static final Setting<Boolean> CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED = Setting.boolSetting(
        RemoteStoreEnums.PathType.HASHED_PREFIX.toString(),
        return isPinnedTimestampsEnabled;
        this.clusterRemoteSegmentTransferTimeout = clusterRemoteSegmentTransferTimeout;
    public static final Setting<Boolean> CLUSTER_REMOTE_STORE_FENCING_ENABLED = Setting.boolSetting(
     * is either {@code HASHED_PREFIX} or {@code HASHED_INFIX}.
        uploadedSegmentsCleanupThreshold = CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.get(settings);
        true,
    }
    }
        return maxRemoteTranslogReaders;
        "cluster.remote_store.index.segment_metadata.retention.max_count",
            CLUSTER_REMOTE_SEGMENT_TRANSFER_TIMEOUT_SETTING,
        return pinnedTimestampsSchedulerInterval;
    /**
     * This setting is used to disable uploading translog.ckp file as metadata to translog.tlog. This setting is effective only for
    }
    /**
    private static volatile TimeValue pinnedTimestampsLookbackInterval;
    private final String translogPathFixedPrefix;
        isClusterServerSideEncryptionRepoEnabled = clusterServerSideEncryptionEnabled;
     */
     * Controls the threshold for the number of segments uploaded to remote store map.
        Property.NodeScope,
        "cluster.remote_store.fencing.enabled",
        Property.NodeScope,
    public String getTranslogPathFixedPrefix() {
     * resolved live in the same way as {@link #CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED}. An
        Property.Dynamic
        "cluster.remote_store.translog.buffer_interval",
            }
        v -> {
    /**
        translogPathFixedPrefix = CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(settings);
     * the primary's write witness and toggling it on a live index would leave a window in which a stale primary is
    public static final Setting<Boolean> CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED = Setting.boolSetting(
        Property.Final
    private static volatile TimeValue pinnedTimestampsSchedulerInterval;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.remote.RemoteStoreEnums;
        clusterSettings.addSettingsUpdateConsumer(
     * This setting is used to set the remote store blob store path hash algorithm strategy. This setting is effective only for
     * remote-store-backed indices <b>at creation time only</b>: the per-index setting is final, because the fence is
import org.opensearch.common.settings.Settings;
    private static final int MAX_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD = 100000;
            CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING,
            }
        flushOnUncommittedSegmentsThresholdSize = CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.get(settings);
    }
    public static final Setting<String> CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX = Setting.simpleString(
                        + MIN_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD
        TimeValue.timeValueMinutes(1),
/**
        // opt-in, so that enabling it is a deliberate operator decision on a cluster which is actually affected by the
     */
     * This setting is used to set the remote store blob store path type strategy. This setting is effective only for
    public static final Setting<String> CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX = Setting.simpleString(
    public RemoteStoreEnums.PathHashAlgorithm getPathHashAlgorithm() {
    }
    public TimeValue getClusterRemoteTranslogTransferTimeout() {
/*
 * compatible open source license.
    /**
        Property.NodeScope,
                    "Value must be -1 or between "
    /**
        TimeValue.timeValueMinutes(1),
    public static final Setting<Integer> CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING = Setting.intSetting(
    }
        return segmentsPathFixedPrefix;
    private void setPathType(RemoteStoreEnums.PathType pathType) {
        pathHashAlgorithm = clusterSettings.get(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING);
     * Controls pinned timestamp scheduler interval
     */
     */
import org.opensearch.common.settings.Setting.Property;
        return pathType;
        this.clusterRemoteTranslogTransferTimeout = clusterRemoteTranslogTransferTimeout;
    }
    private void setTranslogMetadataEnabled(boolean isTranslogMetadataEnabled) {
        false,
        Property.Dynamic
    // Visible for testing
        pinnedTimestampsLookbackInterval = CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_LOOKBACK_INTERVAL.get(settings);
        isPinnedTimestampsEnabled = CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.get(settings);
        "cluster.remote_store.segment.transfer_timeout",
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_REMOTE_STORE_TRANSLOG_METADATA, this::setTranslogMetadataEnabled);
        minRemoteSegmentMetadataFiles = CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.get(settings);
     */
        clusterSettings.addSettingsUpdateConsumer(
                        + " and "
    public static final Setting<Integer> CLUSTER_REMOTE_MAX_TRANSLOG_READERS = Setting.intSetting(
    );
        -1,
    }
     * the whole cluster, and only the threshold
    private volatile TimeValue clusterRemoteTranslogBufferInterval;
        "cluster.remote_store.segments.path.prefix",
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING, this::setPathType);
    );
        false,
        pinnedTimestampsSchedulerInterval = CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_SCHEDULER_INTERVAL.get(settings);
        );
        clusterSettings.addSettingsUpdateConsumer(
        TimeValue.timeValueMinutes(1),
     */
     */
    public boolean isFlushOnUncommittedSegmentsEnabled() {
    public static void setPinnedTimestampsLookbackInterval(TimeValue pinnedTimestampsLookbackInterval) {
        );
public class RemoteStoreSettings {
    public int getUploadedSegmentsCleanupThreshold() {
        TimeValue.timeValueMinutes(3),
        v -> {
    }
    );
        "cluster.remote_store.pinned_timestamps.scheduler_interval",
import org.opensearch.core.common.unit.ByteSizeValue;
        Property.NodeScope,
        clusterSettings.addSettingsUpdateConsumer(
     * explicit {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} always wins.
    }
    private void setClusterServerSideEncryptionEnabled(boolean clusterServerSideEncryptionEnabled) {
    private void setUploadedSegmentsCleanupThreshold(int uploadedSegmentsCleanupThreshold) {
        this.isTranslogMetadataEnabled = isTranslogMetadataEnabled;
    private void setFlushOnUncommittedSegmentsEnabled(boolean flushOnUncommittedSegmentsEnabled) {
        Property.Dynamic
    public static final Setting<ByteSizeValue> CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE = Setting.byteSizeSetting(
    );
        this.flushOnUncommittedSegmentsEnabled = flushOnUncommittedSegmentsEnabled;
    /**
        "cluster.remote_store.server_side_encryption",
     */
import org.opensearch.index.IndexSettings;
    }
    );
        "cluster.remote_store.translog.transfer_timeout",
        RemoteStoreSettings.pinnedTimestampsLookbackInterval = pinnedTimestampsLookbackInterval;
        maxRemoteTranslogReaders = CLUSTER_REMOTE_MAX_TRANSLOG_READERS.get(settings);
                );
        true,
     * afterwards; an explicit {@code index.remote_store.fencing.enabled} in the create request always wins.
        this.uploadedSegmentsCleanupThreshold = uploadedSegmentsCleanupThreshold;
    );
        return clusterRemoteTranslogBufferInterval;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_REMOTE_MAX_TRANSLOG_READERS, this::setMaxRemoteTranslogReaders);
     * Controls the maximum referenced remote translog files. If breached the shard will be flushed.
    public static final Setting<TimeValue> CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_LOOKBACK_INTERVAL = Setting.timeSetting(
        Setting.Property.NodeScope
    public static final Setting<Boolean> CLUSTER_REMOTE_STORE_TRANSLOG_METADATA = Setting.boolSetting(
        IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,
        clusterSettings.addSettingsUpdateConsumer(
        Setting.Property.NodeScope
import org.opensearch.common.unit.TimeValue;
        false,
                        + MAX_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD
    }
     * {@link #CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE}) is worth tuning per index. Unlike
        TimeValue.timeValueMinutes(5),
    private void setMinRemoteSegmentMetadataFiles(int minRemoteSegmentMetadataFiles) {
    );
    }
        Property.Dynamic
    private volatile RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm;
    /**
        Property.NodeScope
        TimeValue.timeValueSeconds(30),
        return uploadedSegmentsCleanupThreshold;
            if (v == 0) {
    public int getMinRemoteSegmentMetadataFiles() {
@PublicApi(since = "2.14.0")
     * Controls pinned timestamp feature enablement
        IndexSettings.MINIMUM_REMOTE_TRANSLOG_BUFFER_INTERVAL,
        // suppressed translog-size flush
            this::setMinRemoteSegmentMetadataFiles
        },
        Setting.Property.Dynamic
    /**
        "cluster.remote_store.index.path.type",
    public static final Setting<TimeValue> CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_SCHEDULER_INTERVAL = Setting.timeSetting(
    private void setClusterRemoteTranslogTransferTimeout(TimeValue clusterRemoteTranslogTransferTimeout) {
     */
    /**
        Property.NodeScope,
        clusterRemoteSegmentTransferTimeout = CLUSTER_REMOTE_SEGMENT_TRANSFER_TIMEOUT_SETTING.get(settings);
        DEFAULT_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD,
        Property.NodeScope,
    public static final Setting<Boolean> CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED = Setting.boolSetting(
     * When the map size exceeds this threshold, stale segment cleanup is triggered even without a flush/commit.
 */
        flushOnUncommittedSegmentsEnabled = CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.get(settings);
import org.opensearch.core.common.unit.ByteSizeUnit;
            this::setUploadedSegmentsCleanupThreshold
    public static final Setting<TimeValue> CLUSTER_REMOTE_SEGMENT_TRANSFER_TIMEOUT_SETTING = Setting.timeSetting(
        clusterSettings.addSettingsUpdateConsumer(
import org.opensearch.common.annotation.ExperimentalApi;
    /**
    @ExperimentalApi
            this::setClusterRemoteSegmentTransferTimeout
    public static final Setting<TimeValue> CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING = Setting.timeSetting(
 * Settings for remote store
        return pinnedTimestampsLookbackInterval;
        );
package org.opensearch.indices;
        Property.Dynamic
        pathType = clusterSettings.get(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING);
        "cluster.remote_store.translog.path.prefix",
 */
    private static volatile boolean isPinnedTimestampsEnabled;
    public static final Setting<RemoteStoreEnums.PathHashAlgorithm> CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING = new Setting<>(
    }
    public String getSegmentsPathFixedPrefix() {
        clusterSettings.addSettingsUpdateConsumer(
        -1,
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED, this::setClusterServerSideEncryptionEnabled);
    );
    public TimeValue getClusterRemoteTranslogBufferInterval() {
        this.maxRemoteTranslogReaders = maxRemoteTranslogReaders;
     */
    private void setMaxRemoteTranslogReaders(int maxRemoteTranslogReaders) {
    );
    }
        segmentsPathFixedPrefix = CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(settings);
    /**
        Property.NodeScope,
        this.pathHashAlgorithm = pathHashAlgorithm;
        return flushOnUncommittedSegmentsThresholdSize;
    }
    private static final int DEFAULT_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD = 1000;
        "cluster.remote_store.index.translog.translog_metadata",
        return isClusterServerSideEncryptionRepoEnabled;
    }
                throw new IllegalArgumentException(
    }
    }
    private volatile int minRemoteSegmentMetadataFiles;
        Property.Dynamic
    /**
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
            if (v != -1 && v < MIN_CLUSTER_REMOTE_MAX_TRANSLOG_READERS) {
     * Controls timeout value while uploading segment files to remote segment store
    /**
        1000,
        Property.NodeScope,
        Property.NodeScope,
    public boolean isTranslogMetadataEnabled() {
    );
    private void setClusterRemoteSegmentTransferTimeout(TimeValue clusterRemoteSegmentTransferTimeout) {
        Setting.Property.NodeScope
    public RemoteStoreEnums.PathType getPathType() {
                    "Value 0 is not allowed for this setting as it would delete all the data from remote segment store"
        );
    );
 * @opensearch.api
        clusterRemoteTranslogBufferInterval = CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(settings);
    /**
    );
            }
        "",
        Setting.Property.NodeScope,
     * remote store enabled cluster.
    @ExperimentalApi
     * Cluster-wide switch for the periodic flush condition driven by uncommitted segment bytes on remote-store shards,
        "cluster.remote_store.flush_on_uncommitted_segments.threshold_size",
    }
        return isTranslogMetadataEnabled;
        v -> {
    /**
    );
        this.minRemoteSegmentMetadataFiles = minRemoteSegmentMetadataFiles;
        );
    public RemoteStoreSettings(Settings settings, ClusterSettings clusterSettings) {
     */
        this.pathType = pathType;
            CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED,
        Property.NodeScope,
    }
    );
     * Controls timeout value while uploading translog and checkpoint files to remote translog
        IndexSettings.DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
        "cluster.remote_store.index.path.hash_algorithm",
    private volatile boolean flushOnUncommittedSegmentsEnabled;
     * {@code -1} disables threshold-based cleanup.
            CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING,
    }
    private volatile boolean isClusterServerSideEncryptionRepoEnabled;
        Property.NodeScope,
    private volatile ByteSizeValue flushOnUncommittedSegmentsThresholdSize;
    );
     * checked against neither the fence nor the replicas. Flipping this setting therefore affects only indices created
        return translogPathFixedPrefix;
                throw new IllegalArgumentException("Cannot set value lower than " + MIN_CLUSTER_REMOTE_MAX_TRANSLOG_READERS);
    public static TimeValue getPinnedTimestampsLookbackInterval() {
     */
     * {@code value < 1} will disable deletion of stale segment metadata files.
     */
    @ExperimentalApi
    }
    );
        "cluster.remote_store.pinned_timestamps.lookback_interval",
        Property.Dynamic
        Property.Final
        this.clusterRemoteTranslogBufferInterval = clusterRemoteTranslogBufferInterval;
     * Dynamic cluster-level default for {@code index.remote_store.fencing.enabled}. Applied to
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
    public static final Setting<Integer> CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING = Setting.intSetting(
     * disabled by default. There is deliberately no per-index counterpart: enablement is an operational decision about
            this::setFlushOnUncommittedSegmentsThresholdSize
    public ByteSizeValue getFlushOnUncommittedSegmentsThresholdSize() {
     * flipping it takes effect on every remote-store index immediately, in both directions.
    );
        return clusterRemoteTranslogTransferTimeout;
        return this.minRemoteSegmentMetadataFiles;
        },
        Property.Dynamic
    public TimeValue getClusterRemoteSegmentTransferTimeout() {
     */
 *
    private volatile RemoteStoreEnums.PathType pathType;
        RemoteStoreEnums.PathType::parseString,
    /**
        return clusterRemoteSegmentTransferTimeout;
    private static final int MIN_CLUSTER_REMOTE_MAX_TRANSLOG_READERS = 100;
    private final String segmentsPathFixedPrefix;
     * Controls minimum number of metadata files to keep in remote segment store.
        Property.Dynamic,
        );
            CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
import org.opensearch.common.settings.Setting;
        TimeValue.timeValueMinutes(30),
     * Dynamic cluster-level default for {@code index.remote_store.flush_on_uncommitted_segments.threshold_size},
     * Controls the ServerSideEncryption Settings.
import org.opensearch.common.annotation.PublicApi;
            this::setFlushOnUncommittedSegmentsEnabled
        return flushOnUncommittedSegmentsEnabled;
     */
    private static final int MIN_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD = 100;
    @ExperimentalApi
    }
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING, this::setPathHashAlgorithm);
    }
        IndexSettings.MINIMUM_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
    private volatile int uploadedSegmentsCleanupThreshold;
    @ExperimentalApi
        isClusterServerSideEncryptionRepoEnabled = CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.get(settings);
        Property.Dynamic
     */
     * Used to specify the default translog buffer interval for remote store backed indexes.
    );
     * remote store enabled cluster. This setting will come to effect if the {@link #CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING}
     * Controls allowed timestamp values to be pinned from past
    public static TimeValue getPinnedTimestampsSchedulerInterval() {
     * {@link #CLUSTER_REMOTE_STORE_FENCING_ENABLED} this is resolved live rather than stamped at index creation, so
        "cluster.remote_store.translog.max_readers",
        return pathHashAlgorithm;
        -1,
        "cluster.remote_store.flush_on_uncommitted_segments.enabled",
    }
        TimeValue.timeValueMinutes(10),
        TimeValue.timeValueSeconds(30),
    }
            this::setClusterRemoteTranslogTransferTimeout
import org.opensearch.common.settings.ClusterSettings;
        RemoteStoreEnums.PathHashAlgorithm::parseString,
     */
        Property.NodeScope,
            if (v != -1 && (v < MIN_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD || v > MAX_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD)) {
    public static boolean isPinnedTimestampsEnabled() {
        isTranslogMetadataEnabled = clusterSettings.get(CLUSTER_REMOTE_STORE_TRANSLOG_METADATA);
     * Controls the fixed prefix for the translog path on remote store.
    private volatile TimeValue clusterRemoteSegmentTransferTimeout;
    private volatile boolean isTranslogMetadataEnabled;
 *
    }
        clusterRemoteTranslogTransferTimeout = CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.get(settings);
    private void setFlushOnUncommittedSegmentsThresholdSize(ByteSizeValue flushOnUncommittedSegmentsThresholdSize) {
    public int getMaxRemoteTranslogReaders() {
        "",
