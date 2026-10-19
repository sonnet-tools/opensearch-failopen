@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                .setIgnoreUnavailable(true)
            GetSnapshotsResponse snapshotResponse = client().admin()
}
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }  
import org.opensearch.common.settings.Settings;  
import org.opensearch.test.OpenSearchIntegTestCase;  
        });
        return Settings.builder()
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getKey(), 3)  
        internalCluster().startDataOnlyNodes(2);
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING.getKey(), true).build();
 * The OpenSearch Contributors require contributions made to  
                SnapshotState state = snapshotResponse.getSnapshots().get(0).state();
import org.opensearch.common.util.FeatureFlags;
package org.opensearch.snapshots;
        createRepository("test-repo", "mock");
            SnapshotsInProgress snapshotsInProgress = clusterService().state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
    public void testSnapshotMarkerCleanedUpAfterClusterManagerFailover() throws Exception {
        assertBusy(() -> {
                .get();  
    @Override  
        client().admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
        logger.info("--> block cluster-manager from finalizing snapshot on index file");  
    @Override
        logger.info("--> starting cluster-manager and data nodes");  
public class SnapshotCleanupRetryIT extends AbstractSnapshotIntegTestCase {
        logger.info("--> verify index deletion is unblocked");
                assertTrue("Snapshot should be completed but was " + state, state.completed());  
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.getKey(), "1s")
            }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    protected Settings featureFlagSettings() {
    }  
import org.opensearch.cluster.SnapshotsInProgress;
        internalCluster().startClusterManagerOnlyNodes(3);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        indexRandomDocs("test-idx", randomIntBetween(10, 50));
        logger.info("--> wait for snapshot to hit the block");  
 *
        assertBusy(() -> {  
        }, 60, TimeUnit.SECONDS);
                .setSnapshots("test-snap")
        logger.info("--> wait for snapshot marker to be cleaned up after new cluster-manager takes over");  
import org.opensearch.common.unit.TimeValue;
                .cluster()
/*  
            assertTrue("Snapshot marker should be cleaned up", snapshotsInProgress.entries().isEmpty());  
    }  
            if (snapshotResponse.getSnapshots().isEmpty() == false) {
        assertAcked(prepareCreate("test-idx", 0, indexSettingsNoReplicas(1)));
import java.util.concurrent.TimeUnit;
            .put(super.nodeSettings(nodeOrdinal))
 */  
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(30));
        String blockedNode = blockClusterManagerFromFinalizingSnapshotOnIndexFile("test-repo");
        logger.info("--> stopping cluster-manager node to induce failover");  
    protected Settings nodeSettings(int nodeOrdinal) {  
        logger.info("--> start snapshot (non-blocking)");  
        assertAcked(client().admin().indices().prepareDelete("test-idx").get());
        internalCluster().stopCurrentClusterManagerNode();
        ensureGreen();  
            .build();
                .prepareGetSnapshots("test-repo")  
