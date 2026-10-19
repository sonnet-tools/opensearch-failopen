    }
        assertTrue(e.getMessage().contains("snapshot.repository.max_outstanding_ops"));
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING)
    public void testMaxOutstandingOpsRoundTrip() {
        IllegalArgumentException e = expectThrows(
        );
            .put("snapshot.repository.io_timeout", "10m")
        assertTrue(SnapshotsService.SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING.getDefault(Settings.EMPTY));  
        e = expectThrows(
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            () -> SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING.get(  
        IllegalArgumentException e = expectThrows(
    }  
                Settings.builder().put("snapshot.delete.cleanup_stale_blobs", false).build()
/*  
            IllegalArgumentException.class,
        assertTrue(e.getMessage().contains("disabled"));  
                Settings.builder().put("snapshot.repository.max_outstanding_ops", 0).build()
 * compatible open source license.
    }
        assertEquals(4, (int) SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING.getDefault(Settings.EMPTY));
        Settings settings = Settings.builder().put("snapshot.repository.max_outstanding_ops", 8).build();
        clusterSettings.applySettings(newSettings);  
    public void testSettingsRejectedWhenFeatureFlagDisabled() {  
        // Without @LockFeatureFlag, the flag is off by default
            )  
import org.opensearch.common.settings.ClusterSettings;
    }
    public void testMaxOutstandingOpsDefault() {
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SnapshotsService.SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING)  
    }
            .put("snapshot.repository.max_outstanding_ops", 2)  
        assertEquals(TimeValue.timeValueMinutes(15), SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING.get(settings));  
    }  
        assertTrue(e.getMessage().contains("disabled"));  
        assertTrue(e.getMessage().contains("feature flag"));
        assertTrue(e.getMessage().contains("disabled"));  
        );  
        );
    }
        assertFalse(SnapshotsService.SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING.get(settings));  
            IllegalArgumentException.class,  
    }
 * this file be licensed under the Apache-2.0 license or a
                Settings.builder().put("snapshot.repository.io_timeout", "10m").build()
        );
    public void testIoTimeoutAcceptsMinimum() {  
        assertEquals(TimeValue.timeValueMinutes(30), SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING.getDefault(Settings.EMPTY));
    }  
public class SnapshotResilienceSettingsTests extends OpenSearchTestCase {
            () -> SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING.get(
        assertTrue(
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
        assertEquals(8, (int) SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING.get(settings));  
    }
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)  
import org.opensearch.common.unit.TimeValue;  
        IllegalArgumentException e = expectThrows(
            )  
    public void testSettingsRegisteredInClusterSettings() {
            "io_timeout should be registered",  
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)  
    public void testIoTimeoutRejectsZero() {
                Settings.builder().put("snapshot.repository.max_outstanding_ops", 2).build()
 *
        e = expectThrows(
        assertTrue(e.getMessage().contains("snapshot.repository.io_timeout"));
package org.opensearch.snapshots;
            IllegalArgumentException.class,  
        Settings settings = Settings.builder().put("snapshot.delete.cleanup_stale_blobs", false).build();
        assertTrue(
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)  
import org.opensearch.test.OpenSearchTestCase;
    public void testMaxOutstandingOpsRejectsZero() {  
    public void testCleanupStaleBlobsRoundTrip() {
            "cleanup_stale_blobs should be registered",
    public void testDynamicUpdateAccepted() {
    public void testCleanupStaleBlobsDefault() {
            IllegalArgumentException.class,  
        );
            () -> SnapshotsService.SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING.get(
        assertEquals(TimeValue.timeValueSeconds(1), SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING.get(settings));
        Settings settings = Settings.builder().put("snapshot.repository.io_timeout", "1s").build();
        );  
        assertTrue(e.getMessage().contains("feature flag"));
            )  
import org.opensearch.common.util.FeatureFlags;
    public void testIoTimeoutRoundTrip() {
        Settings newSettings = Settings.builder()
        );
 */  
        Settings settings = Settings.builder().put("snapshot.repository.io_timeout", "15m").build();
            () -> SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING.get(
            )  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(e.getMessage().contains("feature flag"));
            IllegalArgumentException.class,  
                Settings.builder().put("snapshot.repository.io_timeout", "0s").build()
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
import org.opensearch.common.settings.Settings;
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)  
        );
}
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING)
    }
            )
        assertTrue(  
 * SPDX-License-Identifier: Apache-2.0
            .build();
            .put("snapshot.delete.cleanup_stale_blobs", false)
            () -> SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING.get(
    public void testIoTimeoutDefault() {  
            "max_outstanding_ops should be registered",
    }
