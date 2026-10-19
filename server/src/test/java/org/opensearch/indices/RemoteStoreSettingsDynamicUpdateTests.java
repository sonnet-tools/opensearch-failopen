                .build()  
            () -> clusterSettings.applySettings(
        // Test override with valid value  
        for (String invalid : new String[] { "0b", "-1" }) {
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), -5).build()  
            () -> clusterSettings.applySettings(
import org.opensearch.test.OpenSearchTestCase;
                .build()
        assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());  
        assertEquals(1000, remoteStoreSettings.getMaxRemoteTranslogReaders());
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "128mb")  
            () -> clusterSettings.applySettings(
    private final RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(Settings.EMPTY, clusterSettings);
        );
            )  
        assertEquals(-1, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());  
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.getKey(), "40s").build());
            Settings.builder()
        assertEquals(15, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());  
        assertThrows(
            )
                Settings.builder()
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 100).build()
    public void testDisableMaxRemoteReferencedTranslogFiles() {
            Settings.builder()  
                    .build()  
        assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING;  
        assertEquals(TimeValue.timeValueSeconds(40), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());  
    }
                    Settings.builder()
        assertTrue(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
            IllegalArgumentException.class,
        // Test override with value less than minimum
            )
            Settings.builder()
 * compatible open source license.
        assertEquals(TimeValue.timeValueSeconds(30), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());
                        .build()
        );
        );
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 50).build()  
                    .build()
            IllegalArgumentException.class,  
        assertEquals(15, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        // Test disable with -1
        // Test default value
                () -> clusterSettings.applySettings(
    public void testFlushOnUncommittedSegmentsEnabled() {
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), -1).build()
        assertThrows(
        assertThrows(
        clusterSettings.applySettings(  
        assertEquals(5000, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());  
import org.opensearch.core.common.unit.ByteSizeUnit;
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 100000).build()  
        );  
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 200000)  
        // Setting value < -1 should fail and retain the existing value  
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "500").build()  
    public void testFlushOnUncommittedSegmentsThresholdSize() {
    }
    }
            IllegalArgumentException.class,
                Settings.builder()
        // Test override with valid value
        // Test value below minimum (but not -1) should fail
                .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), -1)  
                .build()  
        );
        // Setting value to 0 should fail and retain the existing value
    }  
            assertThrows(
            IllegalArgumentException.class,  
public class RemoteStoreSettingsDynamicUpdateTests extends OpenSearchTestCase {
                    .build()
            );  
        );
            () -> clusterSettings.applySettings(
package org.opensearch.indices;
        );
        assertEquals(new ByteSizeValue(128, ByteSizeUnit.MB), remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize());  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(10, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        assertEquals(1000, remoteStoreSettings.getMaxRemoteTranslogReaders());
        // Test value above maximum should fail
        clusterSettings.applySettings(  
        assertEquals(100, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());  
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 5000).build()
import org.opensearch.index.IndexSettings;  
        // Test default value
                Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.getKey(), "123").build()  
        assertEquals(TimeValue.timeValueSeconds(40), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());  
                IllegalArgumentException.class,  
        assertEquals(
            () -> clusterSettings.applySettings(
        assertThrows(
import org.opensearch.common.unit.TimeValue;  
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false).build()
        assertEquals(new ByteSizeValue(1, ByteSizeUnit.BYTES), remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize());
        clusterSettings.applySettings(
        // Default value
        clusterSettings.applySettings(
        );
import org.opensearch.common.settings.Settings;
            IllegalArgumentException.class,
        // Test override with valid value
            Settings.builder()
        );
            )
        assertThrows(  
            )
            () -> clusterSettings.applySettings(  
                .build()
        );
    public void testMaxRemoteReferencedTranslogFiles() {  
        clusterSettings.applySettings(
                .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), 5)
        // Test default value
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "-1").build()
        clusterSettings.applySettings(
    }
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), invalid)  
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING.getKey(), 0).build()
        );
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "1b")
            Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true).build()  
    }  
                .build()
        );  
        // Test override with valid value
            IllegalArgumentException.class,  
        );
        );  
        assertEquals(500, remoteStoreSettings.getMaxRemoteTranslogReaders());
        );
        );
        // Test override with value less than minimum
    private final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        // Setting min value  
import org.opensearch.core.common.unit.ByteSizeValue;
        // the minimum is one byte: a zero or negative threshold would flush on every successful segments sync
                Settings.builder()
        // opt-in: disabled unless the operator turns it on
            () -> clusterSettings.applySettings(
            assertEquals(new ByteSizeValue(1, ByteSizeUnit.BYTES), remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize());
 * The OpenSearch Contributors require contributions made to  
                )
        clusterSettings.applySettings(
            )
            () -> clusterSettings.applySettings(
                Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "99").build()
        );
        assertEquals(15, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        assertThrows(  
        // Test 0 should fail (not -1 and below minimum)
/*  
    public void testSegmentMetadataRetention() {  
        );  
}
        );
            )
        assertEquals(-1, remoteStoreSettings.getMaxRemoteTranslogReaders());
            IllegalArgumentException.class,  
        );
    }
        // Test override with invalid time value
        assertEquals(1000, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());  
            remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize()
            () -> clusterSettings.applySettings(
 *
        clusterSettings.applySettings(
        clusterSettings.applySettings(
        assertEquals(5, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());
        // Test boundary values
 */  
            IndexSettings.DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,  
            )
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        );  
        }
        // Test default value  
        // Setting value < default (10)
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), 0)  
        assertEquals(TimeValue.timeValueSeconds(40), remoteStoreSettings.getClusterRemoteTranslogTransferTimeout());  
        );
    public void testClusterRemoteTranslogTransferTimeout() {  
        assertEquals(-1, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());  
        clusterSettings.applySettings(  
        assertThrows(  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(100000, remoteStoreSettings.getUploadedSegmentsCleanupThreshold());
        assertThrows(
            )  
                Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING.getKey(), "10s").build()  
        assertEquals(-1, remoteStoreSettings.getMinRemoteSegmentMetadataFiles());  
        assertEquals(500, remoteStoreSettings.getMaxRemoteTranslogReaders());
    public void testUploadedSegmentsCleanupThreshold() {
            Settings.builder()
        clusterSettings.applySettings(
        clusterSettings.applySettings(  
        clusterSettings.applySettings(  
        assertThrows(  
import org.opensearch.common.settings.ClusterSettings;
        );
        // Setting value > default (10)
        // Test value below -1 should fail
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), -5)
                .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), 15)
