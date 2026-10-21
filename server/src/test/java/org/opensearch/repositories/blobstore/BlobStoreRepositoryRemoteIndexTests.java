        logger.info("--> creating an index and indexing documents");
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        assertFalse(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
 * Tests for the {@link BlobStoreRepository} and its subclasses.
import org.opensearch.index.IndexSettings;
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        indexDocuments(client, indexName);
        }
        logger.info("--> creating a remote store enabled index and indexing documents");
        IndexId indexId = repositoryData.resolveIndexId(remoteStoreIndexName);
 *    http://www.apache.org/licenses/LICENSE-2.0
            "test-snap-3",
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE)
import org.opensearch.indices.RemoteStoreSettings;
        final String snapshotRepositoryName = "test-repo";
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
        String[] lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
        logger.info("--> create normal snapshot");
        assertThat(snapshotIds, equalTo(originalSnapshots));
        indexDocuments(client, remoteStoreIndexName);
            "test-snap-1",
        SnapshotInfo snapshotInfo = createSnapshot(
        Settings snapshotRepoSettings2 = Settings.builder()
        // enable shallow snapshot v2 setting in test-repo-1
        // shallow copy shard metadata - getRemoteStoreShallowCopyShardMetadata
import java.util.Locale;
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(snapshotRepositoryName);
        String invalidRepoName = "test" + SnapshotsService.SNAPSHOT_PINNED_TIMESTAMP_DELIMITER + "repo-1";
            Settings.builder().put(snapshotRepoSettings1).put(SHALLOW_SNAPSHOT_V2.getKey(), false).build()
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettingsForShallowCopy);
        final String remoteStoreRepositoryName = "test-rs-repo";
        logger.info("-->  creating snapshot repository");
            repoName
        String[] lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
    }
import java.util.List;
        snapshotInfo = createSnapshot(
        VerifyRepositoryResponse verifyRepositoryResponse = client.admin().cluster().prepareVerifyRepository("test-repo-1").get();
        }
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
        final String snapshotRepositoryName = "test-repo";
/**
            Settings.builder().put(snapshotRepoSettings1).put("max_snapshot_bytes_per_sec", "10k").build()
            .build();
 * under the License.
            .build();
        final String indexName = "test-idx";
        SnapshotInfo snapshotInfo = createSnapshot(
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        createIndex(indexName);
        logger.info("--> make sure the node's repository can resolve the snapshots");
            .build();
        Settings snapshotRepoSettings = Settings.builder()
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettingsForShallowCopy);
        assertEquals("there should be no lock files present in directory, but found " + Arrays.toString(lockFiles), 0, lockFiles.length);
    public void testRetrieveShallowCopySnapshotCase1() throws IOException {
        shallowCopySnapshotIDs = Arrays.asList(snapshotId1, snapshotId2, snapshotId3);
        logger.info("--> creating a remote store enabled index and indexing documents");
            snapshotRepositoryName,
        final SnapshotId snapshotId1 = snapshotInfo.snapshotId();
        snapshotInfo = createSnapshot(
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
        return Settings.builder()
        String[] lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
 * not use this file except in compliance with the License.
        logger.info("--> create first remote index shallow snapshot");
import java.nio.file.Path;
            "test-snap-4",
    }
        final List<SnapshotId> originalSnapshots = Arrays.asList(snapshotId1, snapshotId2, snapshotId3, snapshotId4);
        logger.info("--> create remote index shallow snapshot");
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
        Settings snapshotRepoSettings1 = Settings.builder()
import java.io.IOException;
        assertFalse(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
            .put(repoTypeAttributeKey, FsRepository.TYPE)
                    || lockFiles[2].contains(snapshotId.getUUID())
import org.opensearch.snapshots.SnapshotId;
        assertTrue(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
        assertTrue(lockFiles[0].endsWith(snapshotId.getUUID() + ".v2_lock"));
            assertEquals(
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    }
 * Modifications Copyright OpenSearch Contributors. See
            "test-repo-1",
        final Client client = client();
        updatedRepositoryMetadata = updatedGetRepositoriesResponse.repositories().get(0);
        updateRepository(
        snapshotInfo = createSnapshot(
 * this work for additional information regarding copyright
                lockFiles[0].contains(snapshotId.getUUID())
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
 *
        try {
        assertEquals(shardShallowCopySnapshot.getRemoteStoreRepository(), remoteStoreRepositoryName);
        );
            .collect(Collectors.toList());
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
            new ShardId(remoteStoreIndexName, indexId.getId(), 0)
        RepositoryData repositoryData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository);
        updateRepository(
 * specific language governing permissions and limitations
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        updateRepository(
import java.util.Arrays;
                    + "] setting shallow_snapshot_v2 cannot be enabled for repository with __ in the name as this delimiter is used to create pinning entity",
    @Override
        assertFalse(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
            client,
            .build();
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.core.index.shard.ShardId;
        assertNotNull(verifyRepositoryResponse.getNodes());
        createIndex(remoteStoreIndexName, indexSettings);
        final String remoteStoreIndexName = "test-rs-idx";
        indexDocuments(client, remoteStoreIndexName);
            "test-snap-3",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * ownership. Elasticsearch licenses this file to you under
        // Having a snapshot in the same repo should allow disabling and re-enabling shallow snapshot v2 setting
        ensureGreen();
        assertEquals("lock files are " + Arrays.toString(lockFiles), 3, lockFiles.length);
        indexDocuments(client, indexName);
        GetRepositoriesResponse getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-1").get();
            .put(repoTypeAttributeKey, FsRepository.TYPE)
import org.opensearch.repositories.fs.FsRepository;
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
                "["
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
        indexDocuments(client, indexName);
        for (SnapshotId snapshotId : shallowCopySnapshotIDs) {
            );
            assertEquals(
        logger.info("--> creating a remote store enabled index and indexing documents");
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        assertNotNull(snapshotInfo.snapshotId());
        final SnapshotId snapshotId1 = snapshotInfo.snapshotId();
        IndexId indexId = repositoryData.resolveIndexId(remoteStoreIndexName);
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
 * license agreements. See the NOTICE file distributed with
        ensureGreen();
            .put(buildRemoteStoreNodeAttributes("test-rs-repo", tempDir.resolve("repo")))
            snapshotId2,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        final Client client = client();
            .getSnapshotIds()
        );
        snapshotInfo = createSnapshot(
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
 */
/*
            .put(super.nodeSettings())
    public void testRetrieveShallowCopySnapshotCase2() throws IOException {
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHALLOW_SNAPSHOT_V2;
            .put(SHALLOW_SNAPSHOT_V2.getKey(), true)
        } catch (RepositoryException e) {
 * Licensed to Elasticsearch under one or more contributor
            .build();
        final String remoteStoreRepositoryName = "test-rs-repo";
            snapshotId,
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(snapshotRepositoryName);
        Settings indexSettings = getRemoteStoreBackedIndexSettings();
    public void testRepositoryCreationShallowV2() throws Exception {
        try {
        final SnapshotId snapshotId = snapshotInfo.snapshotId();
            );
            .put(repoTypeAttributeKey, FsRepository.TYPE)
        assertEquals(3, lockFiles.length);
            snapshotRepositoryName,
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        createIndex(indexName);
            .put(REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
import org.opensearch.transport.client.Client;
        RepositoryMetadata updatedRepositoryMetadata = updatedGetRepositoriesResponse.repositories().get(0);
        AcknowledgedResponse deleteSnapshotResponse = client().admin().cluster().prepareDeleteSnapshot("test-repo-2", "test-snap-2").get();
        assertAcked(deleteSnapshotResponse);
        }
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepositoryName, "test-snap-2", new ArrayList<>(List.of(remoteStoreIndexName)));
    public void testGetRemoteStoreShallowCopyShardMetadata() throws IOException {
            createRepository(client, "test-repo-2", snapshotRepoSettings2);
            "test-repo-2",
        Settings snapshotRepoSettingsForShallowCopy = Settings.builder()
        // Create repo with shallow snapshot V2 enabled
        shallowCopySnapshotIDs = Arrays.asList(snapshotId1, snapshotId2, snapshotId3);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
 * compatible open source license.
import java.util.ArrayList;
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
        );
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-2").get();
            repoName
        final SnapshotId snapshotId3 = snapshotInfo.snapshotId();
            .put(node().settings())
import org.opensearch.snapshots.SnapshotInfo;
 * Unless required by applicable law or agreed to in writing,
        );
            client,
        );
        final String remoteStoreIndexName = "test-rs-idx";
            createRepository(client, invalidRepoName, snapshotRepoSettings1);
        return Settings.builder()
            "test-snap-2",
            .build();
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()))
        final SnapshotId snapshotId2 = snapshotInfo.snapshotId();
        logger.info("-->  creating snapshot repository");
            .put(SHALLOW_SNAPSHOT_V2.getKey(), true)
        indexDocuments(client, remoteStoreIndexName);
    // Validate Scenario remoteStoreShallowCopy Snapshot -> remoteStoreShallowCopy Snapshot
            .collect(Collectors.toList());
        getRepositoriesResponse = client.admin().cluster().prepareGetRepositories("test-repo-2").get();
            assertTrue(lockFiles[0].contains(snapshotId.getUUID()) || lockFiles[1].contains(snapshotId.getUUID()));
/*
                e.getMessage()
        // Create pinned timestamp snapshot in test-repo-2
        assertEquals("there should be only one lock file, but found " + Arrays.toString(lockFiles), 1, lockFiles.length);
        Settings indexSettings = getRemoteStoreBackedIndexSettings();
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false)
        updateRepository(client, "test-repo-1", snapshotRepoSettings1);
        assertFalse(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
import org.opensearch.indices.replication.common.ReplicationType;
            .stream()
        );
            .build();
            .put(snapshotRepoSettings)
            .cluster()
        logger.info("--> create first snapshot");
            .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo"))
 * The OpenSearch Contributors require contributions made to
        logger.info("--> create second remote index shallow snapshot");
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        Settings snapshotRepoSettings = Settings.builder()
    }
        assertTrue(lockFiles[0].endsWith(snapshotId2.getUUID() + ".v2_lock"));
import org.opensearch.env.Environment;
                    || lockFiles[1].contains(snapshotId.getUUID())
            "test-repo-1",
        String repoSettingsAttributeKeyPrefix = String.format(
            assertTrue(
        // After deleting the snapshot, we will be able to enable shallow snapshot v2 setting in test-repo-1
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
        updateRepository(client, snapshotRepositoryName, snapshotRepoSettingsForShallowCopy);
            .put(repoSettingsAttributeKeyPrefix + "location", repoPath)
                    || lockFiles[2].contains(snapshotId.getUUID())
        );
                    + invalidRepoName
        );
        List<SnapshotId> snapshotIds = repositoryData.getSnapshotIds()
        assertEquals("there should be only one lock file, but found " + Arrays.toString(lockFiles), 1, lockFiles.length);
            snapshotRepositoryName,
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
            indexId,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
            client,
        final String remoteStoreRepositoryName = "test-rs-repo";
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
        final String indexName = "test-idx";
        RemoteStoreShardShallowCopySnapshot shardShallowCopySnapshot = repository.getRemoteStoreShallowCopyShardMetadata(
        assertEquals(shardShallowCopySnapshot.getRepositoryBasePath(), "");
                    || lockFiles[1].contains(snapshotId.getUUID())
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .build();
            "test-snap-1",
            .put(snapshotRepoSettings)
        logger.info("--> verify the repository");
public class BlobStoreRepositoryRemoteIndexTests extends BlobStoreRepositoryHelperTests {
        createIndex(indexName);
import org.opensearch.gateway.remote.RemoteClusterStateService;
            Locale.getDefault(),
        createIndex(remoteStoreIndexName, indexSettings);
        );
        // As snapshot is present, even after disabling shallow snapshot setting in test-repo-2, we will not be able to
/*
 * software distributed under the License is distributed on an
                e.getMessage()
            indexId,
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertTrue(lockFiles[0].endsWith(snapshotId2.getUUID() + ".v2_lock"));
        // Modify repo-1 settings. This should go through
        for (SnapshotId snapshotId : shallowCopySnapshotIDs) {
        List<SnapshotId> snapshotIds = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
            .build();
            assertEquals(
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
        updateRepository(
        // Create test-repo-2 with shallow snapshot V2 enabled, this should pass now.
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
import org.opensearch.test.OpenSearchIntegTestCase;
        } catch (RepositoryException e) {
            .put(node().settings())
        Path tempDir = createTempDir();
        logger.info("--> create remote index shallow snapshot");
            assertTrue(
        final String indexName = "test-idx";
        );
}
            client,
            .put(REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        Settings snapshotRepoSettings = Settings.builder()
            snapshotRepositoryName,
            Locale.getDefault(),
        Settings snapshotRepoSettingsForShallowCopy = Settings.builder()
        createIndex(remoteStoreIndexName, indexSettings);
    // Validate Scenario Normal Snapshot -> remoteStoreShallowCopy Snapshot -> normal Snapshot
        createRepository(client, snapshotRepositoryName, snapshotRepoSettings);
        logger.info("-->  creating snapshot repository");
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
            .get();
        );
 * You may obtain a copy of the License at
import java.util.stream.Collectors;
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(snapshotRepositoryName);
            .build();
                "[test-repo-2] setting shallow_snapshot_v2 cannot be enabled as this setting can be enabled only on one repository  and one or more repositories in the cluster have the setting as enabled",
    }
        }
        RemoteStoreShardShallowCopySnapshot shardShallowCopySnapshot = repository.getRemoteStoreShallowCopyShardMetadata(
import org.opensearch.repositories.RepositoryException;
    protected Settings nodeSettings() {
        updatedGetRepositoriesResponse = client.admin().cluster().prepareGetRepositories(snapshotRepositoryName).get();
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), tempDir.getParent())
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
 */
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
        assertTrue(SHALLOW_SNAPSHOT_V2.get(getRepositoriesResponse.repositories().get(0).settings()));
        Settings indexSettings = getRemoteStoreBackedIndexSettings();
            Settings.builder().put(snapshotRepoSettings2).put(SHALLOW_SNAPSHOT_V2.getKey(), false).build()
            .prepareGetRepositories(snapshotRepositoryName)
        assertEquals(shardShallowCopySnapshot.getIndexUUID(), indexSetting.getUUID());
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE)
        try {
        assertEquals(shardShallowCopySnapshot.getRemoteStoreRepository(), remoteStoreRepositoryName);
        logger.info("--> make sure the node's repository can resolve the snapshots");
        ensureGreen();
        );
        final List<SnapshotId> originalSnapshots = Arrays.asList(snapshotId1, snapshotId2, snapshotId3);
            );
            new ShardId(remoteStoreIndexName, indexSetting.getUUID(), 0)
            .put(node().settings())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            updateRepository(client, "test-repo-1", snapshotRepoSettings1);
        assertEquals("lock files are " + Arrays.toString(lockFiles), 1, lockFiles.length);
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
 *
        }
        IndexSettings indexSetting = getIndexSettings(remoteStoreIndexName);
            );
        SnapshotInfo snapshotInfo = createSnapshot("test-repo-2", "test-snap-2", new ArrayList<>());
        final SnapshotId snapshotId3 = snapshotInfo.snapshotId();
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        );
            "test-snap-2",
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
            .put(node().settings())
        RepositoryData repositoryData = OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository);
import org.opensearch.snapshots.SnapshotsService;
        createRepository(client, "test-repo-1", snapshotRepoSettings1);
        snapshotInfo = createSnapshot(
 */
        logger.info("--> creating an index and indexing documents");
            "test-repo-1",
        final Client client = client();
        lockFiles = getLockFilesInRemoteStore(remoteStoreIndexName, remoteStoreRepositoryName);
                "[test-repo-1] setting shallow_snapshot_v2 cannot be enabled if there are existing snapshots created with shallow V2 setting using different repository.",
import org.opensearch.cluster.metadata.RepositoryMetadata;
            .put(snapshotRepoSettings)
import org.opensearch.repositories.RepositoriesService;
    // -> remoteStoreShallowCopy Snapshot -> normal snapshot
        final String snapshotRepositoryName = "test-repo";
import org.opensearch.repositories.RepositoryData;
import static org.hamcrest.Matchers.equalTo;
        updateRepository(client, "test-repo-1", snapshotRepoSettings1);
                lockFiles[0].contains(snapshotId.getUUID())
        Settings snapshotRepoSettingsForShallowCopy = Settings.builder()
            snapshotRepositoryName,
                e.getMessage()
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, repoName)
        }
package org.opensearch.repositories.blobstore;
        for (SnapshotId snapshotId : shallowCopySnapshotIDs) {
 *
        final SnapshotId snapshotId4 = snapshotInfo.snapshotId();
        Client client = client();
            );
        // Disable shallow snapshot V2 setting on test-repo-1
        GetRepositoriesResponse updatedGetRepositoriesResponse = client.admin()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
        );
        );
            snapshotRepositoryName,
        createRepository(client, "test-repo-2", snapshotRepoSettings2);
            new ArrayList<>(Arrays.asList(indexName, remoteStoreIndexName))
            .put(node().settings())
        String repoTypeAttributeKey = String.format(
            .stream()
        snapshotInfo = createSnapshot("test-repo-1", "test-snap-1", new ArrayList<>());
        assertNotNull(snapshotInfo.snapshotId());
        assertEquals("lock files are " + Arrays.toString(lockFiles), 2, lockFiles.length);
        logger.info("--> create third remote index shallow snapshot");
import static org.opensearch.repositories.blobstore.BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY;
        assertEquals("there should be only one lock file, but found " + Arrays.toString(lockFiles), 1, lockFiles.length);
        logger.info("--> create another normal snapshot");
        final String remoteStoreIndexName = "test-rs-idx";
        assertThat(snapshotIds, equalTo(originalSnapshots));
            Settings.builder().put(snapshotRepoSettings1).put(SHALLOW_SNAPSHOT_V2.getKey(), false).build()
        // Create another repo with shallow snapshot V2 enabled, this should fail.
        final SnapshotId snapshotId2 = snapshotInfo.snapshotId();
        } catch (RepositoryException e) {
        List<SnapshotId> shallowCopySnapshotIDs = Arrays.asList(snapshotId1, snapshotId2);
    private Settings buildRemoteStoreNodeAttributes(String repoName, Path repoPath) {
        assertTrue(lockFiles[0].endsWith(snapshotId1.getUUID() + ".v2_lock"));
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import org.opensearch.repositories.IndexId;
            snapshotRepositoryName,
