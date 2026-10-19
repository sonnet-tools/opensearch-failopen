        indexData(3, true);
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(nodeSettings);
 *
            assertFalse("target node did not apply the index deletion", targetState.metadata().hasIndex(INDEX_NAME));
            assertAcked(client(clusterManagerNode).admin().indices().prepareDelete(INDEX_NAME).setTimeout("10s"));
        );
 * The OpenSearch Contributors require contributions made to  
            // Applying this state closes the recovering target shard while its engine-open translog hydration is blocked.
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
}  
            unblockNode(TRANSLOG_REPOSITORY_NAME, targetNode);  
            waitForBlock(targetNode, TRANSLOG_REPOSITORY_NAME, TimeValue.timeValueSeconds(30));
 */  
package org.opensearch.remotestore;
                    .cluster()
        }
                client(clusterManagerNode).admin()  
public class RemoteStoreRecoveryClusterStateApplierIT extends AbstractRemoteStoreMockRepositoryIntegTestCase {
            final ClusterState targetState = internalCluster().getInstance(ClusterService.class, targetNode).state();  
import org.opensearch.test.OpenSearchIntegTestCase;  
                    .prepareReroute()
        // Keep the primary on sourceNode until the explicit relocation below.
 * this file be licensed under the Apache-2.0 license or a
/*  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));  
            assertAcked(
/**  
        final String sourceNode = internalCluster().startDataOnlyNode(nodeSettings);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            // The acknowledgement includes the target node, so it proves its cluster-state applier completed without
        } finally {
                .setTransientSettings(Settings.builder().put("cluster.routing.rebalance.enable", "none"))  
        ensureGreen(INDEX_NAME);
        assertEquals(sourceNode, primaryNodeName(INDEX_NAME));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            .build();
            client(clusterManagerNode).admin()  
            .put(buildRemoteStoreNodeAttributes(repositoryLocation, 0d, "metadata", Long.MAX_VALUE))  
            // waiting for the repository read.  
        final Path repositoryLocation = randomRepoPath().toAbsolutePath();
 * Verifies that remote-store recovery does not block the cluster-state applier while hydrating a shard.
    }
        blockNodeOnAnyFiles(TRANSLOG_REPOSITORY_NAME, targetNode);  
import org.opensearch.common.settings.Settings;
        try {
                .cluster()
import org.opensearch.cluster.service.ClusterService;  
        disableRepoConsistencyCheck("Remote Store Creates System Repository");
            );
                .prepareUpdateSettings()
 * SPDX-License-Identifier: Apache-2.0
    public void testIndexDeletionIsAppliedWhileRemoteHydrationIsBlocked() throws Exception {  
        final String targetNode = internalCluster().startDataOnlyNode(nodeSettings);
import org.opensearch.common.unit.TimeValue;
import java.nio.file.Path;
                    .add(new MoveAllocationCommand(INDEX_NAME, 0, sourceNode, targetNode))  
        assertAcked(
import org.opensearch.cluster.ClusterState;
        final Settings nodeSettings = Settings.builder()
 */
        ensureStableCluster(3);  
 * compatible open source license.
