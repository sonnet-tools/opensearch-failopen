        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertTrue(RemoteStoreBaseIntegTestCase.getFileCount(translogPath) > 0);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
            for (var node : nodes) {
        );
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
            .indices()
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            RemoteStorePinnedTimestampService.class,
        );
        createSnapshot(snapshotRepoName, "snap2");
                var fileCache = node.fileCache();
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
            .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(0))
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
 * compatible open source license.
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .setWaitForCompletion(true)
            .get();
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        }
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
            .cluster()
            .get();
        assertAcked(deleteSnapshotResponse);
            .until(() -> RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() > currentTime);
    @ParametersFactory
                .setType(FsRepository.TYPE)
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()
    protected Settings.Builder snapshotRepoSettingsForShallowV2(Path path) {
        forceMerge(1);
import org.opensearch.core.common.unit.ByteSizeValue;
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
    }
        Path shardPath = Path.of(String.valueOf(indexPath), "0");
        List<Path> translogPostSnapshot1 = Files.list(translogPath).collect(Collectors.toList());
import java.util.Arrays;
            .put(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath))
    @Override
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
        keepPinnedTimestampSchedulerUpdated();
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
            () -> client().admin().cluster().prepareDeleteSnapshot(snapshotRepoName, "random-snapshot").get()
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        // Create 2 snapshots for primary term 2
        assertBusy(() -> assertTrue(segmentsPostSnapshot2.size() > segmentsPostSnapshot1.size()), 60, TimeUnit.SECONDS);
            .setWaitForCompletion(true)
import java.nio.file.Path;
            .setWaitForCompletion(true)
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
            .prepareCreateSnapshot(repoName, snapshotName)
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);
            } catch (NoSuchFileException e) {
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName));
import org.opensearch.node.Node;
        assertBusy(() -> assertFalse(Files.exists(translogPath)), 30, TimeUnit.SECONDS);
        ensureGreen(remoteStoreEnabledIndexName);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED.toString())
        assertThat(snapshotInfo2.snapshotId().getName(), equalTo("snap2"));
            .cluster()
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        assertAcked(
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        internalCluster().startDataAndWarmNodes(1, settings);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
    }
        }, 60, TimeUnit.SECONDS);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), false)
        indexRandomDocs(indexName1, numDocsInIndex1);
        return Arrays.asList(
        deleteSnapshot(clusterManagerClient, snapshotRepoName, "snap2");
        AcknowledgedResponse deleteResponse = client().admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName2).get();
        internalCluster().startDataAndWarmNodes(1, settings);
        );
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
 */
        Settings settings = Settings.builder()
            .build();
        );
            .pollDelay(Duration.ofSeconds(1))
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
            .setWaitForCompletion(true)
        final Path remoteStoreRepoPath = randomRepoPath();
import java.util.List;
            .build();
            .get();
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
        String indexName3 = "testindex3";
            } catch (NoSuchFileException e) {
        final Path snapshotRepoPath = randomRepoPath();
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
    private void deleteSnapshot(Client clusterManagerClient, String repoName, String snapshotName) {
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo1.snapshotId().getName())
        final int numDocsInIndex1 = 1;
            clusterManagerName
            RemoteStorePinnedTimestampService.class,
            .prepareGetSettings(remoteStoreEnabledIndexName)
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            client.admin()
            assertTrue(segmentsPostDeletionOfSnapshot1.size() < segmentsPostSnapshot2.size());
            }
            .setWaitForCompletion(true)
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        Path segmentsPath = Path.of(String.valueOf(shardPath), "segments");
import static org.hamcrest.Matchers.greaterThan;
            .prepareDeleteSnapshot(repoName, snapshotName)
        indexRandomDocs(indexName2, numDocsInIndex2);
import java.util.concurrent.TimeUnit;
            List<Path> segmentsPostDeletionOfSnapshot1 = Files.list(segmentsPath).collect(Collectors.toList());
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        String indexUUID = client().admin()
import org.opensearch.repositories.fs.FsRepository;
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
            .cluster()
        await().atMost(Duration.ofSeconds(10))
            clusterManagerName
        SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        logger.info("--> delete snapshot 1");
        SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
}
        }, 60, TimeUnit.SECONDS);
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> create two remote index shallow snapshots");
        settings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
import java.util.stream.Collectors;
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            .prepareCreateSnapshot(snapshotRepoName, "snap1")
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        String indexUUID = client().admin()
        String indexUUID = client().admin()
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
                )
    @After
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        String snapshotName2 = "test-create-snapshot2";
import java.nio.file.NoSuchFileException;
            .cluster()
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
    protected Settings nodeSettings(int nodeOrdinal) {
                fail();
        final Path remoteStoreRepoPath = randomRepoPath();
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);
        logger.info("--> create two remote index shallow snapshots");
            .cluster()
        SnapshotInfo snapshotInfo2 = createSnapshotResponse2.getSnapshotInfo();
        // List<Path> translogPostDeletionOfSnapshot1 = Files.list(translogPath).collect(Collectors.toList());
        internalCluster().startDataAndWarmNodes(3, settings);
        // Delete is async. Give time for it
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
            .build();
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        settings = Settings.builder()
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED.toString())
        Path shardPath = Path.of(String.valueOf(indexPath), "0");
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        refresh(remoteStoreEnabledIndexName);
        createSnapshot(snapshotRepoName, "snap1");
        keepPinnedTimestampSchedulerUpdated();
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName2));
        final Path remoteStoreRepoPath = randomRepoPath();
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowV2(snapshotRepoPath));
            }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        keepPinnedTimestampSchedulerUpdated();
        Path segmentsPath = Path.of(String.valueOf(shardPath), "segments", "data");
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
            .prepareGetSettings(remoteStoreEnabledIndexName)
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
                .setSettings(
    }
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
            .get()
        String indexName2 = "testindex2";
        deleteSnapshot(clusterManagerClient, snapshotRepoName, "snap1");
        snapshotInfo = createSnapshotResponse2.getSnapshotInfo();
        Path translogPath = Path.of(String.valueOf(shardPath), "translog", "data", "1");
        ensureGreen(remoteStoreEnabledIndexName);
import org.opensearch.transport.client.Client;
        SnapshotInfo snapshotInfo1 = createSnapshotResponse.getSnapshotInfo();
        settings.put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .cluster()
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
    }
 *
        final Path snapshotRepoPath = randomRepoPath();
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
        List<Path> segmentsPostSnapshot2 = Files.list(segmentsPath).collect(Collectors.toList());
            }
    public void testDeleteShallowCopyV2() throws Exception {
                .preparePutRepository(snapshotRepoName)
        return Settings.builder()
        internalCluster().restartNode(primaryNodeName(remoteStoreEnabledIndexName));
            .put(settings)
    }
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        // delete remote store index
        final String remoteStoreEnabledIndexName = "remote-index-1";
import org.opensearch.indices.RemoteStoreSettings;
            var nodes = internalCluster().getDataNodeInstances(Node.class);
    private Settings snapshotV2Settings(Path remoteStoreRepoPath) {
        // To uncomment following, we need to handle deletion of generations in translog cleanup flow
        );
            .indices()
        final String snapshotRepoName = "snapshot-repo-name";
        indexRandomDocs(remoteStoreEnabledIndexName, 25);
        logger.info("Snapshot Path [{}]", absolutePath1);
            .get();
    public static Collection<Object[]> parameters() {
        keepPinnedTimestampSchedulerUpdated();
        // test delete non-existent snapshot
        final Settings.Builder settings = Settings.builder();
import org.opensearch.index.remote.RemoteStoreEnums;
            .cluster()
        // Deleting snap1 will still keep files in primary term 1 due to snap2
            .put(settings)
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            .cluster()
        // Index a doc to trigger trimUnreferencedReaders
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
 * SPDX-License-Identifier: Apache-2.0
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        keepPinnedTimestampSchedulerUpdated();
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowV2(snapshotRepoPath));
import static org.awaitility.Awaitility.await;
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
import org.opensearch.common.unit.TimeValue;
        assertAcked(deleteSnapshotResponse);
        assertAcked(client().admin().indices().prepareDelete(remoteStoreEnabledIndexName));
import static org.hamcrest.Matchers.equalTo;
        keepPinnedTimestampSchedulerUpdated();
            .setWaitForCompletion(true)
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()
import org.opensearch.test.OpenSearchIntegTestCase;
            try {
    private static final String REMOTE_REPO_NAME = "remote-store-repo-name";
        }, 60, TimeUnit.SECONDS);
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo1.snapshotId().getName())
import java.nio.file.Files;
    }
            .prepareCreateSnapshot(snapshotRepoName, "snap2")
        assertTrue(deleteResponse.isAcknowledged());
        String indexName1 = "testindex1";
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 2)
            .get();
        ensureStableCluster(4);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        CreateSnapshotResponse createSnapshotResponse = client().admin()
            .get();
        // Deleting snap2 will not remove primary term 1 as we need to trigger trimUnreferencedReaders once
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        final String remoteStoreEnabledIndexName = "remote-index-1";
        final String snapshotRepoName = "snapshot-repo-name";
        // assertBusy(() -> assertEquals(translogPostSnapshot2.size() - translogPostSnapshot1.size(),
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED.toString())
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        assertAcked(client().admin().indices().prepareDelete(remoteStoreEnabledIndexName));
        createSnapshot(snapshotRepoName, "snap3");
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING;
                fileCache.clear();
package org.opensearch.snapshots;
                fail();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    public void testRemoteStoreCleanupForDeletedIndexForSnapshotV2() throws Exception {
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(settings);
        ensureStableCluster(2);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        // Restart current primary to change the primary term
        List<Path> translogPostSnapshot2 = Files.list(translogPath).collect(Collectors.toList());
        keepPinnedTimestampSchedulerUpdated();
        // Create 2 snapshots for primary term 1
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
            .get();
        // delete remote store index
            .get();
            clusterManagerName
        assertTrue(RemoteStoreBaseIntegTestCase.getFileCount(translogPath) > 0);
import java.util.Collection;
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        final Settings remoteStoreEnabledIndexSettings = Settings.builder()
                    Settings.builder()
    public void testRemoteStoreCleanupMultiplePrimaryOnSnapshotDeletion() throws Exception {
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        return settings;
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        settings = Settings.builder()
        indexRandomDocs(remoteStoreEnabledIndexName, 25);
        final String snapshotRepoName = "snapshot-repo-name";
            .indices()
        logger.info("--> delete snapshot 1");
            .put(getRemoteStoreBackedIndexSettings())
    }
/*
        final Path remoteStoreRepoPath = randomRepoPath();
    private void keepPinnedTimestampSchedulerUpdated() {
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
            .build();
        assertBusy(() -> {
            .build();
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
import org.junit.After;
            try {
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .put(settings)
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        final String remoteStoreEnabledIndexName = "remote-index-1";
        CreateSnapshotResponse createSnapshotResponse = client().admin()
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
            .cluster()
            .prepareCreateSnapshot(snapshotRepoName, snapshotName2)
        assertAcked(client().admin().indices().prepareDelete(indexName1));
        String snapshotName1 = "test-create-snapshot1";
        Path translogPath = Path.of(String.valueOf(shardPath), "translog", "data", "1");
        ensureStableCluster(2);
        );
        final int numDocsInIndex2 = 2;
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(settings);
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        assertBusy(() -> {
        ensureGreen(indexName1, indexName2);
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()
        // Delete is async. Give time for it
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
        Path shardPath = Path.of(String.valueOf(indexPath), "0");
        keepPinnedTimestampSchedulerUpdated();
    }
            assertAcked(client().admin().indices().prepareDelete("_all").get());
            .get()
public class DeleteSnapshotV2IT extends AbstractSnapshotIntegTestCase {
        long currentTime = System.currentTimeMillis();
        assertBusy(() -> {
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowV2(snapshotRepoPath));
        indexRandomDocs(indexName3, 1);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        // translogPostDeletionOfSnapshot1.size()), 60, TimeUnit.SECONDS);
        SnapshotInfo snapshotInfo1 = createSnapshotResponse.getSnapshotInfo();
            SnapshotMissingException.class,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
                .cluster()
        return settings;
    private void createSnapshot(String repoName, String snapshotName) {
        settings.put("location", path);
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);
    public void teardown() {
        Path translogPath = Path.of(String.valueOf(shardPath), "translog");
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        super(nodeSettings);
                assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(translogPath));
            .prepareGetSettings(remoteStoreEnabledIndexName)
        // on snapshot deletion, remote store segment files should get cleaned up for deleted index - `remote-index-1`
            .put(super.nodeSettings(nodeOrdinal))
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
            RemoteStorePinnedTimestampService.class,
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
            .build();
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
            .get()
        // Delete is async. Give time for it
        List<Path> segmentsPostSnapshot1 = Files.list(segmentsPath).collect(Collectors.toList());
                assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(segmentsPath));
        assertThrows(
 * The OpenSearch Contributors require contributions made to
        createSnapshot(snapshotRepoName, "snap4");
        final Path snapshotRepoPath = randomRepoPath();
    }
        settings = Settings.builder()
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(settings);
    }
    public DeleteSnapshotV2IT(Settings nodeSettings) {
        String snapshotRepoName = "test-create-snapshot-repo";
        Client client = client();
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testRemoteStoreCleanupForDeletedIndexForSnapshotV2MultipleSnapshots() throws Exception {
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
    }
import java.time.Duration;
            .get();
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.common.settings.Settings;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .prepareCreateSnapshot(snapshotRepoName, "snap1")
        assertAcked(deleteSnapshotResponse);
        assertBusy(() -> assertTrue(translogPostSnapshot2.size() > translogPostSnapshot1.size()), 60, TimeUnit.SECONDS);
