        clusterSettings.applySettings(
public class RemoteStoreSettingsDynamicUpdateTests extends OpenSearchTestCase {
        // Setting value to 0 should fail and retain the existing value
    public void testDisableMaxRemoteReferencedTranslogFiles() {
                    Settings.builder()
        assertEquals(TimeValue.timeValueSeconds(40), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());
        clusterSettings.applySettings(
    }
    public void testClusterRemoteTranslogTransferTimeout() {
 *
        // Test override with valid value
        clusterSettings.applySettings(
                .build()
            () -> clusterSettings.applySettings(
        assertEquals(15, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
            Settings.builder()
        // Setting value < default (10)
    }
        for (String invalid : new String[] { "0b", "-1" }) {
        assertEquals(-1, remoteStoreSettings.getMaxRemoteTranslogReaders());
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), 0)
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), -5)
        assertEquals(100000, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
            IllegalArgumentException.class,
            )
            () -> clusterSettings.applySettings(
        clusterSettings.applySettings(
            () -> clusterSettings.applySettings(
import org.opensearch.core.common.unit.ByteSizeUnit;
                    .build()
            remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize()
                Settings.builder()
            )
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.getKey(), "40s").build());
    public void testSegmentMetadataRetention() {
        clusterSettings.applySettings(
        );
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 100000).build()
        assertEquals(TimeValue.timeValueSeconds(40), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());
                .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), -1)
            IllegalArgumentException.class,
import org.opensearch.core.common.unit.ByteSizeValue;
        clusterSettings.applySettings(
        assertEquals(100, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
        // Default value
    public void testFlushOnUncommittedSegmentsEnabled() {
            IllegalArgumentException.class,
            assertEquals(new ByteSizeValue(1, ByteSizeUnit.BYTES), remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize());
        clusterSettings.applySettings(
        assertThrows(
        );
        // Test 0 should fail (not -1 and below minimum)
        );
        // Setting value > default (10)
            Settings.builder()
            () -> clusterSettings.applySettings(
        clusterSettings.applySettings(
        assertEquals(500, remoteStoreSettings.getMaxRemoteTranslogReaders());
        assertTrue(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
        // Test default value
        // opt-in: disabled unless the operator turns it on
        clusterSettings.applySettings(
        assertThrows(
            )
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), -5).build()
}
    private final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 0).build()
        clusterSettings.applySettings(
            )
                .build()
        assertThrows(
            Settings.builder()
        );
 */
        // Test default value
 * The OpenSearch Contributors require contributions made to
            Settings.builder()
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true).build()
        );
        assertEquals(5000, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
    }
            )
                () -> clusterSettings.applySettings(
        // Test override with value less than minimum
        assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "500").build()
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
            () -> clusterSettings.applySettings(
                )
        // Test override with valid value
        assertEquals(new ByteSizeValue(128, ByteSizeUnit.MB), remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize());
import org.opensearch.test.OpenSearchTestCase;
            )
                .build()
        );
    }
            Settings.builder()
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), -1).build()
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING;
        );
        // Test value below minimum (but not -1) should fail
        assertThrows(
            );
            () -> clusterSettings.applySettings(
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false).build()
        );
    }
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "128mb")
        clusterSettings.applySettings(
        clusterSettings.applySettings(
import org.opensearch.common.settings.Settings;
            () -> clusterSettings.applySettings(
        assertEquals(10, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
        assertEquals(-1, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        assertThrows(
        );
            IndexSettings.DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
            IllegalArgumentException.class,
    }
                .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), 15)
    private final RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(Settings.EMPTY, clusterSettings);
            IllegalArgumentException.class,
        );
        // Test override with valid value
                Settings.builder()
                Settings.builder()
        assertEquals(1000, remoteStoreSettings.getMaxRemoteTranslogReaders());
        // Setting min value
        assertEquals(-1, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
        assertEquals(new ByteSizeValue(1, ByteSizeUnit.BYTES), remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize());
/*
        assertEquals(15, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
                IllegalArgumentException.class,
        );
        );
        assertEquals(TimeValue.timeValueSeconds(30), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());
                        .build()
        // Setting value < -1 should fail and retain the existing value
        clusterSettings.applySettings(
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "-1").build()
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 200000)
    public void testFlushOnUncommittedSegmentsThresholdSize() {
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "99").build()
        // Test boundary values
        assertEquals(-1, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
                .build()
 * this file be licensed under the Apache-2.0 license or a
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), invalid)
            () -> clusterSettings.applySettings(
        );
        );
            assertThrows(
import org.opensearch.common.unit.TimeValue;
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 50).build()
 * compatible open source license.
        assertEquals(1000, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
        // Test override with valid value
                    .build()
import org.opensearch.index.IndexSettings;
        assertEquals(500, remoteStoreSettings.getMaxRemoteTranslogReaders());
        // Test override with invalid time value
        );
    public void testMaxRemoteReferencedTranslogFiles() {
package org.opensearch.indices;
        assertEquals(1000, remoteStoreSettings.getMaxRemoteTranslogReaders());
        );
            () -> clusterSettings.applySettings(
        // Test default value
        assertEquals(TimeValue.timeValueSeconds(40), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());
    public void testUploadedSegmentsCleanupThreshold() {
        );
        assertThrows(
            IllegalArgumentException.class,
        );
            )
                .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), 5)
            )
        );
        }
            IllegalArgumentException.class,
        );
                    .build()
            IllegalArgumentException.class,
        // Test value below -1 should fail
        // Test default value
        assertEquals(5, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
                Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.getKey(), "10s").build()
        );
            )
                Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.getKey(), "123").build()
import org.opensearch.common.settings.ClusterSettings;
        // Test disable with -1
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "1b")
    }
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 100).build()
        assertThrows(
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 5000).build()
        // Test value above maximum should fail
        assertEquals(
        assertThrows(
        assertEquals(15, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        // Test override with value less than minimum
        // the minimum is one byte: a zero or negative threshold would flush on every successful segments sync
                .build()
        );
        assertThrows(
        );
