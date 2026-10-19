            .setWaitForCompletion(true)  
 */  
        SnapshotInfo snapshotInfo1 = createSnapshotResponse.getSnapshotInfo();  
        keepPinnedTimestampSchedulerUpdated();  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
import org.opensearch.index.remote.RemoteStoreEnums;
        assertTrue(RemoteStoreBaseIntegTestCase.getFileCount(translogPath) > 0);
    }
            .prepareCreateSnapshot(snapshotRepoName, "snap2")
        settings.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);  
        assertBusy(() -> assertTrue(segmentsPostSnapshot2.size() > segmentsPostSnapshot1.size()), 60, TimeUnit.SECONDS);
    }
        ensureStableCluster(2);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED.toString())
    protected Settings nodeSettings(int nodeOrdinal) {
            .indices()
    @Override  
        final String remoteStoreEnabledIndexName = "remote-index-1";
        assertTrue(deleteResponse.isAcknowledged());
        Path translogPath = Path.of(String.valueOf(shardPath), "translog");
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()  
                assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(segmentsPath));
    private void keepPinnedTimestampSchedulerUpdated() {
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        indexRandomDocs(remoteStoreEnabledIndexName, 5);  
        disableRepoConsistencyCheck("Remote store repository is being used in the test");  
            clusterManagerName
    }
            .get();
        assertAcked(
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowV2(snapshotRepoPath));
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);  
public class DeleteSnapshotV2IT extends AbstractSnapshotIntegTestCase {
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
        final Path snapshotRepoPath = randomRepoPath();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    private void deleteSnapshot(Client clusterManagerClient, String repoName, String snapshotName) {
        // Create 2 snapshots for primary term 1
        String indexName3 = "testindex3";
    }
        ensureStableCluster(2);
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
    public void testRemoteStoreCleanupForDeletedIndexForSnapshotV2() throws Exception {
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
        }, 60, TimeUnit.SECONDS);
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
    public static Collection<Object[]> parameters() {
        assertTrue(RemoteStoreBaseIntegTestCase.getFileCount(translogPath) > 0);  
        createSnapshot(snapshotRepoName, "snap1");
        final Path remoteStoreRepoPath = randomRepoPath();  
            .build();
            .until(() -> RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() > currentTime);  
import org.opensearch.repositories.fs.FsRepository;  
            .indices()
            SnapshotMissingException.class,  
        final Path remoteStoreRepoPath = randomRepoPath();  
        assertAcked(client().admin().indices().prepareDelete(indexName1));
        return Arrays.asList(  
            .setWaitForCompletion(true)
            .setWaitForCompletion(true)  
            .build();  
        indexRandomDocs(remoteStoreEnabledIndexName, 5);
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
    public void testDeleteShallowCopyV2() throws Exception {  
        logger.info("Snapshot Path [{}]", absolutePath1);
        long currentTime = System.currentTimeMillis();  
            .cluster()
            .setWaitForCompletion(true)
        createSnapshot(snapshotRepoName, "snap4");
        keepPinnedTimestampSchedulerUpdated();
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);  
        CreateSnapshotResponse createSnapshotResponse = client().admin()
    }
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        assertThrows(
        logger.info("--> delete snapshot 1");
        Path shardPath = Path.of(String.valueOf(indexPath), "0");  
        settings = Settings.builder()  
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());  
            .prepareGetSettings(remoteStoreEnabledIndexName)
        ensureStableCluster(4);  
    private void createSnapshot(String repoName, String snapshotName) {
            try {
        logger.info("--> create two remote index shallow snapshots");  
        keepPinnedTimestampSchedulerUpdated();
        final Client clusterManagerClient = internalCluster().clusterManagerClient();  
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertThat(snapshotInfo2.snapshotId().getName(), equalTo("snap2"));
        // on snapshot deletion, remote store segment files should get cleaned up for deleted index - `remote-index-1`
            var nodes = internalCluster().getDataNodeInstances(Node.class);
    }
        assertBusy(() -> assertFalse(Files.exists(translogPath)), 30, TimeUnit.SECONDS);
            RemoteStorePinnedTimestampService.class,  
    @After  
        // translogPostDeletionOfSnapshot1.size()), 60, TimeUnit.SECONDS);  
        forceMerge(1);
        indexRandomDocs(remoteStoreEnabledIndexName, 5);  
        // To uncomment following, we need to handle deletion of generations in translog cleanup flow
            }
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);  
}
        SnapshotInfo snapshotInfo2 = createSnapshotResponse2.getSnapshotInfo();
    private Settings snapshotV2Settings(Path remoteStoreRepoPath) {  
        // Deleting snap1 will still keep files in primary term 1 due to snap2
        // delete remote store index
            .get()  
        final String remoteStoreEnabledIndexName = "remote-index-1";
        CreateSnapshotResponse createSnapshotResponse = client().admin()  
        final Path remoteStoreRepoPath = randomRepoPath();
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)  
        Path shardPath = Path.of(String.valueOf(indexPath), "0");
        assertAcked(deleteSnapshotResponse);
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
import org.opensearch.node.Node;
            () -> client().admin().cluster().prepareDeleteSnapshot(snapshotRepoName, "random-snapshot").get()
    }
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        Path shardPath = Path.of(String.valueOf(indexPath), "0");
        }, 60, TimeUnit.SECONDS);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        );
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
    public void testRemoteStoreCleanupForDeletedIndexForSnapshotV2MultipleSnapshots() throws Exception {
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        settings = Settings.builder()
        String snapshotName1 = "test-create-snapshot1";
            .cluster()  
import java.nio.file.NoSuchFileException;  
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);
        logger.info("--> delete snapshot 1");
            .prepareGetSettings(remoteStoreEnabledIndexName)
            .prepareDeleteSnapshot(repoName, snapshotName)
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
            .cluster()
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED.toString())  
 * compatible open source license.
            .cluster()
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()
            .pollDelay(Duration.ofSeconds(1))
        indexRandomDocs(remoteStoreEnabledIndexName, 5);  
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(settings);  
    }  
        final String snapshotRepoName = "snapshot-repo-name";  
            .put(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath))
        settings.put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import java.nio.file.Files;
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(settings);
        // Delete is async. Give time for it
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));  
        keepPinnedTimestampSchedulerUpdated();
    public void testRemoteStoreCleanupMultiplePrimaryOnSnapshotDeletion() throws Exception {  
            .get()  
        String indexUUID = client().admin()  
        final Path remoteStoreRepoPath = randomRepoPath();
        Path translogPath = Path.of(String.valueOf(shardPath), "translog", "data", "1");
            .get();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
import java.nio.file.Path;
        return settings;  
        final String snapshotRepoName = "snapshot-repo-name";  
                .setSettings(
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED.toString())
            .put(settings)
        ensureGreen(remoteStoreEnabledIndexName);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        keepPinnedTimestampSchedulerUpdated();
        assertAcked(deleteSnapshotResponse);
        List<Path> segmentsPostSnapshot2 = Files.list(segmentsPath).collect(Collectors.toList());
        deleteSnapshot(clusterManagerClient, snapshotRepoName, "snap2");  
        String indexUUID = client().admin()  
        final int numDocsInIndex2 = 2;  
            .setWaitForCompletion(true)
        settings = Settings.builder()
            .cluster()
        );  
            assertAcked(client().admin().indices().prepareDelete("_all").get());  
        AcknowledgedResponse deleteResponse = client().admin().cluster().prepareDeleteSnapshot(snapshotRepoName, snapshotName2).get();
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
    }  
            .get()  
        final Path snapshotRepoPath = randomRepoPath();
                .preparePutRepository(snapshotRepoName)
            .build();  
            .put(getRemoteStoreBackedIndexSettings())  
            .get();  
        Path segmentsPath = Path.of(String.valueOf(shardPath), "segments");
import java.util.Arrays;  
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()  
            .build();
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(  
        );
                var fileCache = node.fileCache();  
            .prepareCreateSnapshot(snapshotRepoName, "snap1")  
        );
        CreateSnapshotResponse createSnapshotResponse = client().admin()
import java.util.List;
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        keepPinnedTimestampSchedulerUpdated();
        internalCluster().startDataAndWarmNodes(1, settings);  
            } catch (NoSuchFileException e) {
        }  
            .get();  
        String indexName1 = "testindex1";  
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), false)
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
        indexRandomDocs(indexName2, numDocsInIndex2);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));  
package org.opensearch.snapshots;
        return settings;
        return Settings.builder()  
            .cluster()  
        keepPinnedTimestampSchedulerUpdated();
        // Delete is async. Give time for it
        createSnapshot(snapshotRepoName, "snap3");
            .get();
        // assertBusy(() -> assertEquals(translogPostSnapshot2.size() - translogPostSnapshot1.size(),
        String snapshotRepoName = "test-create-snapshot-repo";  
            .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(0))
import org.junit.After;  
                )
import org.opensearch.cluster.metadata.IndexMetadata;  
        );  
    }  
            for (var node : nodes) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            clusterManagerName
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
import static org.hamcrest.Matchers.equalTo;
                .cluster()
        indexRandomDocs(indexName1, numDocsInIndex1);
            .get();
        final Settings remoteStoreEnabledIndexSettings = Settings.builder()
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));  
        settings.put("location", path);
        CreateSnapshotResponse createSnapshotResponse = client().admin()
            .prepareCreateSnapshot(snapshotRepoName, snapshotName2)
            .prepareGetSettings(remoteStoreEnabledIndexName)
        assertBusy(() -> {
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(settings);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)  
            } catch (NoSuchFileException e) {
        assertAcked(client().admin().indices().prepareDelete(remoteStoreEnabledIndexName));  
            .prepareCreateSnapshot(snapshotRepoName, "snap1")  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        Settings settings = Settings.builder()
        ensureGreen(indexName1, indexName2);  
                    Settings.builder()
        );  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        Path segmentsPath = Path.of(String.valueOf(shardPath), "segments", "data");  
            try {  
        indexRandomDocs(remoteStoreEnabledIndexName, 25);
                .setType(FsRepository.TYPE)  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            clusterManagerName  
        }, 60, TimeUnit.SECONDS);
        // Restart current primary to change the primary term  
        internalCluster().restartNode(primaryNodeName(remoteStoreEnabledIndexName));
            .put(settings)
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
 *
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowV2(snapshotRepoPath));
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 2)
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
    public void teardown() {
import org.opensearch.common.settings.Settings;
        assertBusy(() -> {
import org.opensearch.common.unit.TimeValue;
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()
        indexRandomDocs(indexName3, 1);
        super(nodeSettings);
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        logger.info("--> create two remote index shallow snapshots");  
            .build();  
        String indexName2 = "testindex2";
import java.util.stream.Collectors;
            assertTrue(segmentsPostDeletionOfSnapshot1.size() < segmentsPostSnapshot2.size());  
import org.opensearch.transport.client.Client;
                fileCache.clear();
import org.opensearch.core.common.unit.ByteSizeValue;
        Path translogPath = Path.of(String.valueOf(shardPath), "translog", "data", "1");
    private static final String REMOTE_REPO_NAME = "remote-store-repo-name";  
            .indices()
        Client client = client();  
        SnapshotInfo snapshotInfo1 = createSnapshotResponse.getSnapshotInfo();  
        ensureGreen(remoteStoreEnabledIndexName);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        // Deleting snap2 will not remove primary term 1 as we need to trigger trimUnreferencedReaders once
                fail();  
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;  
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
            RemoteStorePinnedTimestampService.class,
            }
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            .prepareCreateSnapshot(repoName, snapshotName)
import java.util.concurrent.TimeUnit;  
 * SPDX-License-Identifier: Apache-2.0
    @ParametersFactory
import java.util.Collection;
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowV2(snapshotRepoPath));
            .cluster()
        String snapshotName2 = "test-create-snapshot2";
        indexRandomDocs(remoteStoreEnabledIndexName, 5);  
            }  
        createSnapshot(snapshotRepoName, "snap2");
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
            .build();
    protected Settings.Builder snapshotRepoSettingsForShallowV2(Path path) {  
        List<Path> translogPostSnapshot1 = Files.list(translogPath).collect(Collectors.toList());  
import static org.hamcrest.Matchers.greaterThan;
    }
 * The OpenSearch Contributors require contributions made to  
        List<Path> segmentsPostSnapshot1 = Files.list(segmentsPath).collect(Collectors.toList());
        // delete remote store index
        refresh(remoteStoreEnabledIndexName);  
        SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        final String snapshotRepoName = "snapshot-repo-name";  
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
        final String remoteStoreEnabledIndexName = "remote-index-1";
            .cluster()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            RemoteStorePinnedTimestampService.class,
        // test delete non-existent snapshot
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        keepPinnedTimestampSchedulerUpdated();
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        String indexUUID = client().admin()  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
        // List<Path> translogPostDeletionOfSnapshot1 = Files.list(translogPath).collect(Collectors.toList());  
        assertBusy(() -> {
    public DeleteSnapshotV2IT(Settings nodeSettings) {  
            .put(settings)  
            .get();
        assertBusy(() -> assertTrue(translogPostSnapshot2.size() > translogPostSnapshot1.size()), 60, TimeUnit.SECONDS);  
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
 * this file be licensed under the Apache-2.0 license or a
        // Delete is async. Give time for it  
        final int numDocsInIndex1 = 1;
        indexRandomDocs(remoteStoreEnabledIndexName, 25);
        // Create 2 snapshots for primary term 2
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo1.snapshotId().getName())  
        await().atMost(Duration.ofSeconds(10))
    }
import org.opensearch.indices.RemoteStoreSettings;
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        assertAcked(deleteSnapshotResponse);  
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName));
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        final Settings.Builder settings = Settings.builder();
            .put(super.nodeSettings(nodeOrdinal))
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()  
            .setWaitForCompletion(true)  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
                fail();
    }
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
import java.time.Duration;
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            List<Path> segmentsPostDeletionOfSnapshot1 = Files.list(segmentsPath).collect(Collectors.toList());
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName2));  
/*  
        SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        final Path snapshotRepoPath = randomRepoPath();
        List<Path> translogPostSnapshot2 = Files.list(translogPath).collect(Collectors.toList());
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
                assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(translogPath));  
            .cluster()
        internalCluster().startDataAndWarmNodes(3, settings);
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING;
        internalCluster().startDataAndWarmNodes(1, settings);
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo1.snapshotId().getName())
        // Index a doc to trigger trimUnreferencedReaders  
        deleteSnapshot(clusterManagerClient, snapshotRepoName, "snap1");
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
import static org.awaitility.Awaitility.await;  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            client.admin()  
        indexRandomDocs(remoteStoreEnabledIndexName, 5);  
        assertAcked(client().admin().indices().prepareDelete(remoteStoreEnabledIndexName));  
        snapshotInfo = createSnapshotResponse2.getSnapshotInfo();
            .get();
