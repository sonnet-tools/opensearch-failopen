 *
            IllegalArgumentException.class,
        assertThat(e.getMessage(), containsString("disabled"));
 * SPDX-License-Identifier: Apache-2.0
                .prepareUpdateSettings()
    }
}
                .get()
            .cluster()
                    .put("snapshot.delete.cleanup_stale_blobs", false)
                .cluster()
                    .put("snapshot.repository.max_outstanding_ops", 6)
                .setTransientSettings(Settings.builder().put("snapshot.delete.cleanup_stale_blobs", false).build())
        assertThat(e.getMessage(), containsString("snapshot.repository.io_timeout"));
                    .put("snapshot.repository.io_timeout", "10m")
            () -> client().admin()
        );  
                .prepareUpdateSettings()
        );
import org.opensearch.common.settings.Settings;
            () -> client().admin()  
        internalCluster().startNode();  
        assertThat(e.getMessage(), containsString("disabled"));
            () -> client().admin()  
            .setTransientSettings(  
 */  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(e.getMessage(), containsString("feature flag"));
            IllegalArgumentException.class,
        client().admin()
                .cluster()  
        assertTrue(response.isAcknowledged());
            .prepareUpdateSettings()  
    public void testDynamicUpdateWithFeatureFlagEnabled() {
        );
package org.opensearch.snapshots;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * The OpenSearch Contributors require contributions made to  
            .get();
                Settings.builder()
        IllegalArgumentException e = expectThrows(  
        e = expectThrows(
        return Settings.builder().put(FeatureFlags.SNAPSHOT_RESILIENCE, true).build();
    public void testMaxOutstandingOpsRejectsInvalidValue() {
            IllegalArgumentException.class,
        assertEquals("false", settings.get("snapshot.delete.cleanup_stale_blobs"));
                .get()
    }  
        assertThat(e.getMessage(), containsString("disabled"));  
            () -> client().admin()
        internalCluster().startNode();
    protected Settings featureFlagSettings() {  
        assertEquals("6", settings.get("snapshot.repository.max_outstanding_ops"));  
                .get()
                .prepareUpdateSettings()
        assertThat(e.getMessage(), containsString("feature flag"));  
        // Start a node with the flag explicitly disabled
        internalCluster().startNode();
    public void testSettingsReflectUpdatedValues() {
                .get()  
        IllegalArgumentException e = expectThrows(
    public void testIoTimeoutRejectsInvalidValue() {
    public void testSettingsRejectedWhenFlagDisabled() {  
            () -> client().admin()
            )
                .prepareUpdateSettings()
        e = expectThrows(  
            .cluster()
                Settings.builder()
                .cluster()  
        internalCluster().startNode();  
    }  
            )  
                .setTransientSettings(Settings.builder().put("snapshot.repository.max_outstanding_ops", 0).build())  
                    .put("snapshot.repository.max_outstanding_ops", 2)  
            IllegalArgumentException.class,
import org.opensearch.common.util.FeatureFlags;  
                    .build()
                .setTransientSettings(Settings.builder().put("snapshot.repository.max_outstanding_ops", 2).build())
        assertThat(e.getMessage(), containsString("feature flag"));
public class SnapshotResilienceSettingsIT extends OpenSearchIntegTestCase {  
        Settings settings = client().admin().cluster().prepareState().get().getState().metadata().transientSettings();
                    .put("snapshot.repository.io_timeout", "20m")  
                .cluster()
                    .put("snapshot.delete.cleanup_stale_blobs", false)
        IllegalArgumentException e = expectThrows(
                    .build()  
    }
                .setTransientSettings(Settings.builder().put("snapshot.repository.io_timeout", "10m").build())  
            .prepareUpdateSettings()
            .setTransientSettings(
import static org.hamcrest.Matchers.containsString;  
        ClusterUpdateSettingsResponse response = client().admin()  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals("20m", settings.get("snapshot.repository.io_timeout"));
            .get();
        );
        internalCluster().startNode(Settings.builder().put(FeatureFlags.SNAPSHOT_RESILIENCE, false).build());
    }  
    @Override
            IllegalArgumentException.class,  
 * compatible open source license.
        );
        assertThat(e.getMessage(), containsString("snapshot.repository.max_outstanding_ops"));  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
                .cluster()
                .prepareUpdateSettings()  
    }
/*  
                .setTransientSettings(Settings.builder().put("snapshot.repository.io_timeout", "0s").build())
                .get()  
