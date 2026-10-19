        client = internalCluster().client();
        logger.info("Verify that non remote-backed index is created");  
        initializeCluster(false);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.STRICT;
        logger.info("Attempt clearing compatibility mode");  
        logger.info("Create snapshot of non remote stored backed index");
    public void testNewRestoredIndexIsRemoteStoreBackedForRemoteStoreDirectionAndMixedMode() throws Exception {
    }  
        addRemote = false;  
    }  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.REMOTE_STORE;  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.MIXED;
        restoreSnapshot(snapshotRepoName, snapshotName, restoredIndexName1);
    public void testSwitchToStrictMode() throws Exception {
import java.nio.file.Path;
        logger.info("Add remote and non-remote nodes");  
        assertNonRemoteStoreBackedIndex(TEST_INDEX);
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        );  
    private void createMixedModeCluster() {
            "can not switch to STRICT compatibility mode when the cluster contains both remote and non-remote nodes",
        logger.info("Verify that remote backed index is created");
        stopRemoteNode();
        logger.info("Create repository");
        setClusterMode(MIXED.mode);
 */  
        String snapshotName = "test-snapshot";
        String snapshotRepoName = "test-restore-snapshot-repo";  
    public void testNewIndexIsRemoteStoreBackedForRemoteStoreDirectionAndMixedMode() {
}
        addRemote = remoteClusterManager;  
        assertNonRemoteStoreBackedIndex(restoredIndexName1);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        logger.info("Restore index from snapshot under NONE direction");
        logger.info("Add non-remote node");  
        stopRemoteNode();
    private void stopRemoteNode() throws IOException {
        internalCluster().startClusterManagerOnlyNode();
    // compatibility mode setting test
        String remoteNodeName = internalCluster().startNode();  
        createRepository(snapshotRepoName, "fs", Settings.builder().put("location", snapshotRepoNameAbsolutePath));
        internalCluster().validateClusterFormed();  
        prepareIndexWithoutReplica(Optional.of(indexName2));
    private String nonRemoteNodeName;  
 * compatible open source license.
        internalCluster().validateClusterFormed();
        logger.info("Stop remote node so that cluster had only non-remote nodes");
    public void testClearCompatibilityModeSetting() throws Exception {
        logger.info("Set mixed cluster compatibility mode and remote_store direction");  
        assertRemoteStoreBackedIndex(restoredIndexName2);
        addRemote = true;
    private Client client;
    private String remoteNodeName;
        logger.info("Verify that non remote stored backed index is created");
        assertEquals(  
        String remoteNodeName = internalCluster().startNode();
        assertNodeInCluster(remoteNodeName);
        nonRemoteNodeName = internalCluster().startNode();
        clearClusterMode();
        createMixedModeCluster();  
            exception.getMessage()
import org.opensearch.transport.client.Client;
        addRemote = false;
        logger.info("Restore index from snapshot under REMOTE_STORE direction");
        setClusterMode(MIXED.mode);  
        internalCluster().validateClusterFormed();
    // bootstrap a cluster
/*  
        logger.info("Create a mixed mode cluster");
import java.util.Optional;
        assertNodeInCluster(nonRemoteNodeName);
        Path snapshotRepoNameAbsolutePath = randomRepoPath().toAbsolutePath();
    // remote store backed index setting tests  
        internalCluster().validateClusterFormed();  
        String indexName1 = "test_index_1";  
        setClusterMode(STRICT.mode);
        logger.info("Attempt switching to strict mode");
        createMixedModeCluster();
package org.opensearch.remotemigration;
        ensureStableCluster(2);
        logger.info("Add remote node");
        assertNodeInCluster(nonRemoteNodeName);
 * The OpenSearch Contributors require contributions made to  
        assertNodeInCluster(remoteNodeName);  
        createIndex(TEST_INDEX, 0);
        String indexName2 = "test_index_2";
        assertNodeInCluster(remoteNodeName);
        setClusterMode(MIXED.mode);
        ensureGreen(TimeValue.timeValueSeconds(90), restoredIndexName2);
import java.io.IOException;  
            .put(BlobStoreRepository.SNAPSHOT_SHARD_PATH_PREFIX_SETTING.getKey(), snapshotShardPathFixedPrefix ? "c" : "")
        logger.info("Verify that restored index is non remote-backed");
        logger.info("Initialize cluster");
        String nonRemoteNodeName = internalCluster().startNode(settings);  
public class RemoteStoreMigrationSettingsUpdateIT extends RemoteStoreMigrationShardAllocationBaseTestCase {  
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Initialize cluster: gives non remote cluster manager");  
        logger.info("Create a non remote-backed index");
    }  
        addRemote = true;
import org.opensearch.common.settings.Settings;
        logger.info("Create an index");  
import org.opensearch.test.InternalTestCluster;
import org.opensearch.test.OpenSearchIntegTestCase;  
    private void initializeCluster(boolean remoteClusterManager) {
        SettingsException exception = assertThrows(SettingsException.class, () -> setClusterMode(STRICT.mode));
        String restoredIndexName1 = TEST_INDEX + "-restored1";  
        assertRemoteStoreBackedIndex(indexName2);
        String nonRemoteNodeName = internalCluster().startNode();
        initializeCluster(false);  
        logger.info("Create another index");
    }  
            .build();
        logger.info("Attempt switching to strict mode");
        initializeCluster(false);
        restoreSnapshot(snapshotRepoName, snapshotName, restoredIndexName2);
    }
 *
        addRemote = true;
import org.opensearch.common.unit.TimeValue;  
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(remoteNodeName));  
        Settings settings = Settings.builder()  
 * this file be licensed under the Apache-2.0 license or a
        assertNodeInCluster(nonRemoteNodeName);
        logger.info("Verify that restored index is non remote-backed");
        ensureGreen(restoredIndexName1);
        logger.info("Initialize cluster: gives non remote cluster manager");  
    }
        remoteNodeName = internalCluster().startNode();
        String restoredIndexName2 = TEST_INDEX + "-restored2";  
        addRemote = false;
        setDirection(REMOTE_STORE.direction);
        prepareIndexWithoutReplica(Optional.of(indexName1));
        assertNonRemoteStoreBackedIndex(indexName1);
        createSnapshot(snapshotRepoName, snapshotName, TEST_INDEX);  
import org.opensearch.common.settings.SettingsException;
        setDirection(REMOTE_STORE.direction);
