        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
                    + "] setting shallow_snapshot_v2 cannot be enabled for repository with __ in the name as this delimiter is used to create pinning entity",
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
 * under the License.  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE)
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
 */  
 * software distributed under the License is distributed on an
        snapshotInfo = createSnapshot(
        assertEquals("there should be only one lock file, but found " + Arrays.toString(lockFiles), 1, lockFiles.length);
        logger.info("--> create first remote index shallow snapshot");  
        logger.info("--> create normal snapshot");  
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(snapshotRepositoryName);
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(snapshotRepositoryName);  
        // Create test-repo-2 with shallow snapshot V2 enabled, this should pass now.
        assertNotNull(snapshotInfo.snapshotId());
import org.opensearch.repositories.RepositoryException;
        createRepository(client, "test-repo-1", snapshotRepoSettings1);
        try {
            "test-repo-1",
        assertEquals(shardShallowCopySnapshot.getRemoteStoreRepository(), remoteStoreRepositoryName);
        assertFalse(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
            .build();
        indexDocuments(client, indexName);
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
            "test-repo-2",
 * compatible open source license.
            createRepository(client, invalidRepoName, snapshotRepoSettings1);  
import org.opensearch.snapshots.SnapshotId;  
        } catch (RepositoryException e) {
        logger.info("--> create second remote index shallow snapshot");
            .prepareGetRepositories(snapshotRepositoryName)
                    || lockFiles[1].contains(snapshotId.getUUID())  
        List<SnapshotId> snapshotIds = repositoryData.getSnapshotIds()
                    || lockFiles[2].contains(snapshotId.getUUID())  
        // Having a snapshot in the same repo should allow disabling and re-enabling shallow snapshot v2 setting
        final Client client = client();  
            .build();  
import org.opensearch.repositories.IndexId;
        // enable shallow snapshot v2 setting in test-repo-1
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
        logger.info("--> create another normal snapshot");
        ensureGreen();  
            .stream()
        final String snapshotRepositoryName = "test-repo";
        logger.info("--> creating an index and indexing documents");  
import org.opensearch.repositories.RepositoriesService;
        Settings indexSettings = getRemoteStoreBackedIndexSettings();
                "["  
            "test-snap-1",
        assertEquals("lock files are " + Arrays.toString(lockFiles), 1, lockFiles.length);
        Settings snapshotRepoSettings = Settings.builder()  
            "test-snap-3",  
        Client client = client();
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHALLOW_SNAPSHOT_V2;  
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
                "[test-repo-1] setting shallow_snapshot_v2 cannot be enabled if there are existing snapshots created with shallow V2 setting using different repository.",  
        try {
        createIndex(remoteStoreIndexName, indexSettings);  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;  
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))  
            snapshotRepositoryName,  
        logger.info("--> create remote index shallow snapshot");
        logger.info("-->  creating snapshot repository");
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);  
        indexDocuments(client, remoteStoreIndexName);  
 * this file be licensed under the Apache-2.0 license or a
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
 * Licensed to Elasticsearch under one or more contributor  
        updateRepository(client, "test-repo-1", snapshotRepoSettings1);
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)  
import org.opensearch.common.settings.Settings;
        assertNotNull(snapshotInfo.snapshotId());
            "test-repo-1",
            .build();
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
        try {
        RepositoryData repositoryData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository);  
            );
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
        );  
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        // Modify repo-1 settings. This should go through
            .stream()  
        final String remoteStoreRepositoryName = "test-rs-repo";
        final String remoteStoreIndexName = "test-rs-idx";  
        );  
            assertTrue(  
 * license agreements. See the NOTICE file distributed with
    // Validate Scenario remoteStoreShallowCopy Snapshot -> remoteStoreShallowCopy Snapshot
        createIndex(indexName);
        List<SnapshotId> snapshotIds = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
        // Create repo with shallow snapshot V2 enabled
 *
        Settings snapshotRepoSettings2 = Settings.builder()
            client,
            .put(buildRemoteStoreNodeAttributes("test-rs-repo", tempDir.resolve("repo")))  
            .put(super.nodeSettings())
            assertTrue(
        // After deleting the snapshot, we will be able to enable shallow snapshot v2 setting in test-repo-1
            .put(repoTypeAttributeKey, FsRepository.TYPE)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            repoName  
        Settings snapshotRepoSettings = Settings.builder()  
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));  
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));  
            .cluster()
        String[] lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);  
}
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        Settings snapshotRepoSettingsForShallowCopy = Settings.builder()
        createIndex(remoteStoreIndexName, indexSettings);  
        logger.info("--> make sure the node's repository can resolve the snapshots");
import org.opensearch.cluster.metadata.RepositoryMetadata;
        String repoTypeAttributeKey = String.format(  
import org.opensearch.index.IndexSettings;  
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        snapshotInfo = createSnapshot("test-repo-1", "test-snap-1", new ArrayList<>());  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            .build();
        shallowCopySnapshotIDs = Arrays.asList(snapshotId1, snapshotId2, snapshotId3);
    // -> remoteStoreShallowCopy Snapshot -> normal snapshot
            .put(SHALLOW_SNAPSHOT_V2.getKey(), true)
        createIndex(indexName);
import static org.hamcrest.Matchers.equalTo;
        return Settings.builder()  
            "test-snap-2",
        ensureGreen();  
            .collect(Collectors.toList());
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettingsForShallowCopy);
        RepositoryMetadata updatedRepositoryMetadata = updatedGetRepositoriesResponse.repositories().get(0);
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))  
            new ShardId(remoteStoreIndexName, indexId.getId(), 0)
        final Client client = client();
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
            assertEquals(
                e.getMessage()  
            "test-snap-4",
public class BlobStoreRepositoryRemoteIndexTests extends BlobStoreRepositoryHelperTests {
        final SnapshotId snapshotId3 = snapshotInfo.snapshotId();
            .put(repoTypeAttributeKey, FsRepository.TYPE)
            Settings.builder().put(snapshotRepoSettings1).put(SHALLOW_SNAPSHOT_V2.getKey(), false).build()
import java.io.IOException;  
        RepositoryData repositoryData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository);
import java.util.List;
        assertThat(snapshotIds, equalTo(originalSnapshots));  
            assertTrue(lockFiles[0].contains(snapshotId.getUUID()) || lockFiles[1].contains(snapshotId.getUUID()));
        assertThat(snapshotIds, equalTo(originalSnapshots));
/*  
        SnapshotInfo snapshotInfo = createSnapshot(
        Settings snapshotRepoSettings = Settings.builder()
                lockFiles[0].contains(snapshotId.getUUID())
 */  
        assertEquals(shardShallowCopySnapshot.getRemoteStoreRepository(), remoteStoreRepositoryName);
 *
 * You may obtain a copy of the License at  
        snapshotInfo = createSnapshot(  
            .get();  
                "[test-repo-2] setting shallow_snapshot_v2 cannot be enabled as this setting can be enabled only on one repository  and one or more repositories in the cluster have the setting as enabled",
        // shallow copy shard metadata - getRemoteStoreShallowCopyShardMetadata
    // Validate Scenario Normal Snapshot -> remoteStoreShallowCopy Snapshot -> normal Snapshot
            "test-snap-1",  
        GetRepositoriesResponse updatedGetRepositoriesResponse = client.admin()  
 *  
        logger.info("--> create remote index shallow snapshot");
import static org.opensearch.repositories.blobstore.BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY;
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.gateway.remote.RemoteClusterStateService;
            "test-repo-1",
/**
        Settings indexSettings = getRemoteStoreBackedIndexSettings();
import org.opensearch.repositories.RepositoryData;  
        final SnapshotId snapshotId3 = snapshotInfo.snapshotId();  
                    || lockFiles[2].contains(snapshotId.getUUID())
        assertFalse(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));  
            "test-snap-2",
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        final List<SnapshotId> originalSnapshots = Arrays.asList(snapshotId1, snapshotId2, snapshotId3);  
        } catch (RepositoryException e) {
            Settings.builder().put(snapshotRepoSettings1).put(SHALLOW_SNAPSHOT_V2.getKey(), false).build()  
            .build();
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
/*  
        );  
            Locale.getDefault(),  
        assertEquals("there should be only one lock file, but found " + Arrays.toString(lockFiles), 1, lockFiles.length);
        }  
        );
        logger.info("--> make sure the node's repository can resolve the snapshots");
 */
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)  
            .put(repoTypeAttributeKey, FsRepository.TYPE)
            updateRepository(client, "test-repo-1", snapshotRepoSettings1);  
            snapshotRepositoryName,  
        // Create pinned timestamp snapshot in test-repo-2  
                    || lockFiles[1].contains(snapshotId.getUUID())
        updateRepository(  
        final String indexName = "test-idx";
        logger.info("--> creating a remote store enabled index and indexing documents");
        String repoSettingsAttributeKeyPrefix = String.format(
 * not use this file except in compliance with the License.
            .put(SHALLOW_SNAPSHOT_V2.getKey(), true)  
            snapshotRepositoryName,
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-2").get();
            Settings.builder().put(snapshotRepoSettings2).put(SHALLOW_SNAPSHOT_V2.getKey(), false).build()  
        final String remoteStoreRepositoryName = "test-rs-repo";  
import java.util.Arrays;  
        String[] lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);  
        assertEquals(shardShallowCopySnapshot.getRepositoryBasePath(), "");
import java.util.Locale;
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));  
        assertTrue(lockFiles[0].endsWith(snapshotId2.getUUID() + ".v2_lock"));  
    public void testRetrieveShallowCopySnapshotCase2() throws IOException {  
        IndexId indexId = repositoryData.resolveIndexId(remoteStoreIndexName);
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        snapshotInfo = createSnapshot(
            .build();  
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-2").get();
        String[] lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
            .build();  
        assertEquals("lock files are " + Arrays.toString(lockFiles), 2, lockFiles.length);
            .put(snapshotRepoSettings)  
            assertEquals(
    }
        indexDocuments(client, remoteStoreIndexName);
        for (SnapshotId snapshotId : shallowCopySnapshotIDs) {
            .put(snapshotRepoSettings)
        IndexSettings indexSetting = getIndexSettings(remoteStoreIndexName);
        IndexId indexId = repositoryData.resolveIndexId(remoteStoreIndexName);
            .put(node().settings())  
        assertFalse(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));  
        createIndex(remoteStoreIndexName, indexSettings);
        } catch (RepositoryException e) {  
        }
        ensureGreen();  
        assertTrue(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));  
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
        indexDocuments(client, remoteStoreIndexName);
 */  
import org.opensearch.snapshots.SnapshotsService;
import org.opensearch.transport.client.Client;
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        List<SnapshotId> shallowCopySnapshotIDs = Arrays.asList(snapshotId1, snapshotId2);
            snapshotRepositoryName,  
        final String indexName = "test-idx";
        final String remoteStoreIndexName = "test-rs-idx";
        final SnapshotId snapshotId2 = snapshotInfo.snapshotId();
        updateRepository(  
import org.opensearch.indices.replication.common.ReplicationType;  
    @Override  
        VerifyRepositoryResponse verifyRepositoryResponse = client.admin().cluster().prepareVerifyRepository("test-repo-1").get();
            client,
        final String indexName = "test-idx";
/*
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        createRepository(client, "test-repo-2", snapshotRepoSettings2);  
import org.opensearch.test.OpenSearchIntegTestCase;  
        indexDocuments(client, indexName);
        );  
        );  
 * Tests for the {@link BlobStoreRepository} and its subclasses.
        updateRepository(
                e.getMessage()  
        RemoteStoreShardShallowCopySnapshot shardShallowCopySnapshot = repository.getRemoteStoreShallowCopyShardMetadata(
            .put(node().settings())
        String invalidRepoName = "test" + SnapshotsService.SNAPSHOT_PINNED_TIMESTAMP_DELIMITER + "repo-1";
        assertTrue(lockFiles[0].endsWith(snapshotId1.getUUID() + ".v2_lock"));
            indexId,
            repoName
            .build();
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
        Settings snapshotRepoSettingsForShallowCopy = Settings.builder()
        SnapshotInfo snapshotInfo = createSnapshot(
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
        }  
        logger.info("--> creating a remote store enabled index and indexing documents");  
            indexId,
        logger.info("--> verify the repository");
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        );  
        Settings snapshotRepoSettingsForShallowCopy = Settings.builder()  
package org.opensearch.repositories.blobstore;
            .put(REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            snapshotId,
        // Create another repo with shallow snapshot V2 enabled, this should fail.  
    protected Settings nodeSettings() {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        SnapshotInfo snapshotInfo = createSnapshot("test-repo-2", "test-snap-2", new ArrayList<>());
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
            );
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        updateRepository(client, "test-repo-1", snapshotRepoSettings1);
        // Disable shallow snapshot V2 setting on test-repo-1
            "test-snap-3",
        indexDocuments(client, indexName);
    }
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);  
    }
 * KIND, either express or implied.  See the License for the
            .collect(Collectors.toList());
 * this work for additional information regarding copyright
        for (SnapshotId snapshotId : shallowCopySnapshotIDs) {  
            snapshotRepositoryName,
import java.nio.file.Path;
        logger.info("--> create third remote index shallow snapshot");  
        // As snapshot is present, even after disabling shallow snapshot setting in test-repo-2, we will not be able to
        return Settings.builder()
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
 * Unless required by applicable law or agreed to in writing,
        assertTrue(lockFiles[0].endsWith(snapshotId2.getUUID() + ".v2_lock"));
                lockFiles[0].contains(snapshotId.getUUID())
        final Client client = client();
        );
            .put(REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        assertEquals("lock files are " + Arrays.toString(lockFiles), 3, lockFiles.length);
    public void testRepositoryCreationShallowV2() throws Exception {  
        final List<SnapshotId> originalSnapshots = Arrays.asList(snapshotId1, snapshotId2, snapshotId3, snapshotId4);  
        GetRepositoriesResponse getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        Settings snapshotRepoSettings1 = Settings.builder()  
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(snapshotRepositoryName);  
        assertTrue(lockFiles[0].endsWith(snapshotId.getUUID() + ".v2_lock"));
            );
            .put(node().settings())  
                e.getMessage()
 * SPDX-License-Identifier: Apache-2.0
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettingsForShallowCopy);  
        assertAcked(deleteSnapshotResponse);
            snapshotId2,  
 * The OpenSearch Contributors require contributions made to  
            new ShardId(remoteStoreIndexName, indexSetting.getUUID(), 0)  
    public void testGetRemoteStoreShallowCopyShardMetadata() throws IOException {
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false)  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.stream.Collectors;  
        assertFalse(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
import org.opensearch.repositories.fs.FsRepository;
        logger.info("-->  creating snapshot repository");  
            Locale.getDefault(),
        logger.info("--> creating an index and indexing documents");  
 * the Apache License, Version 2.0 (the "License"); you may
            .getSnapshotIds()
        shallowCopySnapshotIDs = Arrays.asList(snapshotId1, snapshotId2, snapshotId3);
    }  
    }
        RemoteStoreShardShallowCopySnapshot shardShallowCopySnapshot = repository.getRemoteStoreShallowCopyShardMetadata(  
        }
        final SnapshotId snapshotId = snapshotInfo.snapshotId();
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepositoryName, "test-snap-2", new ArrayList<>(List.of(remoteStoreIndexName)));  
        );
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
        final SnapshotId snapshotId1 = snapshotInfo.snapshotId();  
        snapshotInfo = createSnapshot(
            .put(node().settings())
            client,  
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        for (SnapshotId snapshotId : shallowCopySnapshotIDs) {  
        }
        final String remoteStoreIndexName = "test-rs-idx";
        final SnapshotId snapshotId4 = snapshotInfo.snapshotId();
        );  
            );
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettingsForShallowCopy);  
        final String snapshotRepositoryName = "test-repo";  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
 * specific language governing permissions and limitations
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        Path tempDir = createTempDir();
            snapshotRepositoryName,  
        logger.info("-->  creating snapshot repository");
        logger.info("--> creating a remote store enabled index and indexing documents");  
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
    public void testRetrieveShallowCopySnapshotCase1() throws IOException {
    }
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        );
        assertEquals(3, lockFiles.length);  
            .put(node().settings())
    private Settings buildRemoteStoreNodeAttributes(String repoName, Path repoPath) {
            snapshotRepositoryName,
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
        final SnapshotId snapshotId2 = snapshotInfo.snapshotId();
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
        assertEquals(shardShallowCopySnapshot.getIndexUUID(), indexSetting.getUUID());  
            Settings.builder().put(snapshotRepoSettings1).put("max_snapshot_bytes_per_sec", "10k").build()
import org.opensearch.snapshots.SnapshotInfo;
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), tempDir.getParent())  
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        assertNotNull(verifyRepositoryResponse.getNodes());  
import org.opensearch.env.Environment;
            .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo"))
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
        createIndex(indexName);
        assertEquals("there should be only one lock file, but found " + Arrays.toString(lockFiles), 1, lockFiles.length);
        AcknowledgedResponse deleteSnapshotResponse = client().admin().cluster().prepareDeleteSnapshot("test-repo-2", "test-snap-2").get();  
            client,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        updateRepository(
            createRepository(client, "test-repo-2", snapshotRepoSettings2);
        Settings indexSettings = getRemoteStoreBackedIndexSettings();
import org.opensearch.core.index.shard.ShardId;  
import java.util.ArrayList;
        assertEquals("there should be no lock files present in directory, but found " + Arrays.toString(lockFiles), 0, lockFiles.length);  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)  
import org.opensearch.indices.RemoteStoreSettings;
        snapshotInfo = createSnapshot(
            .build();
        );
        logger.info("--> create first snapshot");  
            .build();
        updatedGetRepositoriesResponse = client.admin().cluster().prepareGetRepositories(snapshotRepositoryName).get();
                    + invalidRepoName
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);  
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);  
        }
            );
        final String snapshotRepositoryName = "test-repo";
            .put(snapshotRepoSettings)  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE)
        final SnapshotId snapshotId1 = snapshotInfo.snapshotId();
        updatedRepositoryMetadata = updatedGetRepositoriesResponse.repositories().get(0);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            assertEquals(
        );  
        final String remoteStoreRepositoryName = "test-rs-repo";
