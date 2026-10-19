        validateRemoteIndexPathFile(true);
     */  
        // Only clean remote-index-path dirs needed for subsequent case assertions.  
            .get()
    }  
            )  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
import org.opensearch.index.remote.RemoteIndexPathUploader;
    @Override
            .prepareGetSettings(INDEX_NAME)  
 */  
        // Case 2 - Hashed_infix, we would not have the remote index path file created here.  
            assertTrue(FileSystemUtils.exists(segmentRepoPath.resolve(RemoteIndexPath.DIR)));
            .get();
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 1));
    protected Settings nodeSettings(int nodeOrdinal) {
        // Case 1 - Hashed_prefix, we would need the remote index path file to be created.  
 * SPDX-License-Identifier: Apache-2.0
            .get();
 * The OpenSearch Contributors require contributions made to  
            assertTrue(Arrays.stream(files).anyMatch(file -> file.toString().contains(fileName)));
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 1));  
        client(clusterManagerNode).admin()
            assertTrue(Arrays.stream(files).anyMatch(file -> file.toString().contains(fileName)));
        if (exists) {
    private void validateRemoteIndexPathFile(boolean exists) throws IOException {  
 *
            .cluster()
        validateRemoteIndexPathFile(false);
        String indexUUID = client().admin()
     * Checks that the remote index path file gets created for the intended remote store path type and does not get created
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
            files = FileSystemUtils.files(segmentRepoPath.resolve(RemoteIndexPath.DIR));
        internalCluster().startDataOnlyNodes(2);
            .setTransientSettings(
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED))
            )  
            .prepareUpdateSettings()  
import java.util.concurrent.ExecutionException;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            String segmentPathFile = files[0].toString();
    }
            .indices()
            assertEquals(1, files.length);
            .cluster()
    public void testRemoteIndexPathFileCreation() throws ExecutionException, InterruptedException, IOException {
                Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_INFIX)
    /**  
            .cluster()
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;  
}
    private String generatePartFileName(String indexUUID) {
            assertEquals(1, files.length);  
import java.io.IOException;
import org.opensearch.common.util.io.IOUtils;
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);
            .prepareUpdateSettings()  
        // Translog data dirs are cleaned asynchronously by the REMOTE_PURGE thread pool
import org.opensearch.index.remote.RemoteStoreEnums;
        return String.join(RemoteIndexPathUploader.DELIMITER, indexUUID, "2", RemoteIndexPath.DEFAULT_VERSION);
            .setTransientSettings(
import org.opensearch.test.OpenSearchIntegTestCase;  
            assertNotEquals(translogPathFile, segmentPathFile);  
        client(clusterManagerNode).admin()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     * wherever not required.
        asyncUploadMockFsRepo = false;
                Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX)
            Path[] files = FileSystemUtils.files(translogRepoPath.resolve(RemoteIndexPath.DIR));  
import java.nio.file.Path;  
            .prepareUpdateSettings()  
package org.opensearch.remotestore;
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();  
    }
            .get();
        assertEquals(exists, FileSystemUtils.exists(translogRepoPath.resolve(RemoteIndexPath.DIR)));
import org.opensearch.core.util.FileSystemUtils;
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
import java.util.Arrays;
            String translogPathFile = files[0].toString();  
        client(clusterManagerNode).admin()
 * compatible open source license.
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        // Case 3 - fixed, we would not have the remote index path file created here either.  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.remote.RemoteIndexPath;  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        IOUtils.rm(translogRepoPath.resolve(RemoteIndexPath.DIR));  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    private final String INDEX_NAME = "remote-store-test-idx-1";
    }
        IOUtils.rm(segmentRepoPath.resolve(RemoteIndexPath.DIR));
        String fileName = generatePartFileName(indexUUID);  
public class RemoteStoreUploadIndexPathIT extends RemoteStoreBaseIntegTestCase {  
/*  
        validateRemoteIndexPathFile(false);  
        }
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 1));  
        // and must not be deleted manually here to avoid a race (NoSuchFileException).
