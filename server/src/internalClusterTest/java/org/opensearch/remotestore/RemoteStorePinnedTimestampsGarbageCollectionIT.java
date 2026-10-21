        prepareCluster(1, 2, Settings.EMPTY);
            TRANSLOG,
        }, 30, TimeUnit.SECONDS);
            "0",
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
            translogPathFixedPrefix
            translogPathFixedPrefix
    ActionListener<Void> noOpActionListener = new ActionListener<>() {
            primaryNodeName(INDEX_NAME)
import java.util.List;
        }
            primaryNodeName(INDEX_NAME)
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.collect.Tuple;
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            .put(remoteStoreIndexSettings(0, 1))
        assertBusy(() -> {
        );
            assertEquals(2, metadataFiles.size());
        Set<Long> generations = new HashSet<>();
        ensureGreen(INDEX_NAME);
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        );
        assertBusy(() -> {
            INDEX_NAME,
        ensureGreen(INDEX_NAME);
 * The OpenSearch Contributors require contributions made to
        assertBusy(() -> {
            keepPinnedTimestampSchedulerUpdated();
            TRANSLOG,
        prepareCluster(1, 1, Settings.EMPTY);
        for (int i = 0; i < numDocs; i++) {
            "0",
            .until(() -> RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() > currentTime);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        ensureGreen(INDEX_NAME);
            assertEquals(4, Files.list(translogDataPath).collect(Collectors.toList()).size());
            List<Path> dataFiles = Files.list(translogDataPath).collect(Collectors.toList());
        int numDocs = 5;
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            indexSingleDoc(INDEX_NAME, true);
        String shardDataPath = getShardLevelBlobPath(
            client(),
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            RemoteStorePinnedTimestampService.class,
        ).buildAsString();
            indexSingleDoc(INDEX_NAME, false);
            client(),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            BlobPath.cleanPath(),
            BlobPath.cleanPath(),
            if (i == 2) {
        ).buildAsString();
            "0",
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueMinutes(1));
        for (String mdFile : mdFiles) {
            BlobPath.cleanPath(),
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            translogPathFixedPrefix
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        String shardDataPath = getShardLevelBlobPath(
            "0",
    static final String INDEX_NAME = "remote-store-test-idx-1";
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            DATA,
            "0",
        int numDocsPostFailover = randomIntBetween(15, 20);
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
import java.util.HashSet;
            "0",
            translogPathFixedPrefix
    }
            }
import java.util.concurrent.TimeUnit;
        prepareCluster(1, 1, Settings.EMPTY);
    };
            assertEquals(1, Files.list(translogMetadataPath).collect(Collectors.toList()).size());
}
            RemoteStorePinnedTimestampService.class,
        ).buildAsString();
            TRANSLOG,
        ensureGreen(INDEX_NAME);
        });
import org.opensearch.test.OpenSearchIntegTestCase;
                remoteStorePinnedTimestampService.pinTimestamp(System.currentTimeMillis(), "xyz", noOpActionListener);
        @Override
        client().admin().indices().prepareDelete(INDEX_NAME).get();
            METADATA,
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        for (int i = 0; i < numDocs; i++) {
        String shardMetadataPath = getShardLevelBlobPath(
        Settings indexSettings = Settings.builder()
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        createIndex(INDEX_NAME, indexSettings);
    public void testIndexDeletionWithPinnedTimestamps() throws Exception {
            .put(remoteStoreIndexSettings(0, 1))
        }
            translogPathFixedPrefix
            METADATA,
            BlobPath.cleanPath(),
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        ensureGreen(INDEX_NAME);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), false)
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
        prepareCluster(1, 1, Settings.EMPTY);
    }
            .pollDelay(Duration.ofSeconds(1))
        Settings indexSettings = Settings.builder()
        for (int i = 0; i < numDocs; i++) {
            }
            RemoteStorePinnedTimestampService.class,
            assertEquals(2, metadataFiles.size());
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueMinutes(1));
        }
            keepPinnedTimestampSchedulerUpdated();
            "0",
            client(),
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            INDEX_NAME,
        ).buildAsString();
        ensureGreen(INDEX_NAME);
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            TRANSLOG,
            indexSingleDoc(INDEX_NAME, true);
            indexSingleDoc(INDEX_NAME, false);
            TRANSLOG,
        String shardMetadataPath = getShardLevelBlobPath(
    }
        return Settings.builder()
        for (int i = 0; i < numDocs; i++) {
    private void verifyTranslogDataFileCount(List<Path> metadataFiles, Path translogDataPath) throws IOException {
            client(),
            BlobPath.cleanPath(),
        });
            .build();
            BlobPath.cleanPath(),
        internalCluster().restartNode(primaryNodeName(INDEX_NAME));
            keepPinnedTimestampSchedulerUpdated();
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            .put(remoteStoreIndexSettings(0, 1))
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        public void onResponse(Void unused) {}
            INDEX_NAME,
        for (int i = 0; i < numDocs; i++) {
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
            assertEquals(3, metadataFiles.size());
        await().atMost(Duration.ofSeconds(10))
            DATA,
        assertBusy(() -> {
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueMinutes(1));
            RemoteStorePinnedTimestampService.class,
        ensureGreen(INDEX_NAME);
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
        }
        );
            translogPathFixedPrefix
            assertEquals(2, metadataFiles.size());
            .build();
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            INDEX_NAME,
            client(),
            .build();
            .put(super.nodeSettings(nodeOrdinal))
        createIndex(INDEX_NAME, indexSettings);
            if (i == 2) {
            translogPathFixedPrefix
            .put(remoteStoreIndexSettings(0, 1))
 */
            TRANSLOG,
        createIndex(INDEX_NAME, indexSettings);
            TRANSLOG,
        assertBusy(() -> {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            INDEX_NAME,
        assertNoFailures(client().admin().indices().prepareRefresh(INDEX_NAME).setIndicesOptions(IndicesOptions.lenientExpandOpen()).get());
        });
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
        assertBusy(() -> {
        @Override
            DATA,
            generations.addAll(LongStream.rangeClosed(minMaxGen.v1(), minMaxGen.v2()).boxed().collect(Collectors.toList()));
public class RemoteStorePinnedTimestampsGarbageCollectionIT extends RemoteStoreBaseIntegTestCase {
            "0",
            DATA,
        ).buildAsString();
    public void testLiveIndexNoPinnedTimestampsWithExtraGenSettingWithinLimit() throws Exception {
            "0",
import static org.awaitility.Awaitility.await;
            RemoteStorePinnedTimestampService.class,
    @Override
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
            client(),
        );
            .build();
/*
            INDEX_NAME,
import org.opensearch.core.action.ActionListener;
    }
        Settings indexSettings = Settings.builder()
        }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            BlobPath.cleanPath(),
        prepareCluster(1, 1, Settings.EMPTY);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        });
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        ).buildAsString();
            client(),
            }
            TRANSLOG,
        int numDocs = randomIntBetween(5, 10);
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
        String shardDataPath = getShardLevelBlobPath(
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        ).buildAsString();
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            "0",
        Settings indexSettings = Settings.builder()
            TRANSLOG,
            client(),
import java.io.IOException;
            translogPathFixedPrefix
        String shardMetadataPath = getShardLevelBlobPath(
import java.util.stream.LongStream;
            DATA,
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            TRANSLOG,
        createIndex(INDEX_NAME, indexSettings);
    }
            .build();
        keepPinnedTimestampSchedulerUpdated();
            client(),
    }
            .put(remoteStoreIndexSettings(0, 1))
        Settings indexSettings = Settings.builder()
        String shardDataPath = getShardLevelBlobPath(
            primaryNodeName(INDEX_NAME)
        ).buildAsString();
        String shardDataPath = getShardLevelBlobPath(
            keepPinnedTimestampSchedulerUpdated();
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            TRANSLOG,
    private void ingestDocs() {
        ).buildAsString();
            assertEquals(5, metadataFiles.size());
            assertTrue(metadataFiles.size() >= numDocs + 1);
            indexSingleDoc(INDEX_NAME, true);
import org.apache.lucene.tests.util.LuceneTestCase;
        assertEquals(generations.size() * 2, Files.list(translogDataPath).collect(Collectors.toList()).size());
        prepareCluster(1, 1, Settings.EMPTY);
        ).buildAsString();
        ensureGreen(INDEX_NAME);
import org.opensearch.common.settings.Settings;
            indexSingleDoc(INDEX_NAME, true);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
            translogPathFixedPrefix
            INDEX_NAME,
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        flushAndRefresh(INDEX_NAME);
            client(),
        for (int i = 0; i < numDocs; i++) {
    }
        String shardMetadataPath = getShardLevelBlobPath(
            .build();
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
import java.time.Duration;
import org.opensearch.action.support.IndicesOptions;
            if (i == 2) {
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING;
        int numDocs = randomIntBetween(5, 10);
import java.util.Set;
        String shardMetadataPath = getShardLevelBlobPath(
        int numDocs = randomIntBetween(5, 10);
        createIndex(INDEX_NAME, indexSettings);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
            indexSingleDoc(INDEX_NAME, true);
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 10)
    public void testLiveIndexWithPinnedTimestamps() throws Exception {
            TRANSLOG,
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            BlobPath.cleanPath(),
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            "0",
            translogPathFixedPrefix
 * compatible open source license.
        ingestDocs();
        }
        int numDocs = randomIntBetween(5, 10);
import org.opensearch.common.unit.TimeValue;
            Tuple<Long, Long> minMaxGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(mdFile);
        client().admin().indices().prepareDelete(INDEX_NAME).get();
            BlobPath.cleanPath(),
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
    private static void keepPinnedTimestampSchedulerUpdated() {
            indexSingleDoc(INDEX_NAME, true);
            BlobPath.cleanPath(),
                remoteStorePinnedTimestampService.pinTimestamp(System.currentTimeMillis(), "xyz", noOpActionListener);
        for (int i = 0; i < numDocsPostFailover; i++) {
        assertBusy(() -> {
        keepPinnedTimestampSchedulerUpdated();
        assertNoFailures(client().admin().indices().prepareRefresh(INDEX_NAME).setIndicesOptions(IndicesOptions.lenientExpandOpen()).get());
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            DATA,
        long currentTime = System.currentTimeMillis();
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 3)
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
    protected Settings nodeSettings(int nodeOrdinal) {
        Settings indexSettings = Settings.builder()
            BlobPath.cleanPath(),
        createIndex(INDEX_NAME, indexSettings);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        String shardDataPath = getShardLevelBlobPath(
    public void testLiveIndexWithPinnedTimestampsMultiplePrimaryTerms() throws Exception {
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        }
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        }, 30, TimeUnit.SECONDS);
            RemoteStorePinnedTimestampService.class,
    }
        ingestDocs();
            translogPathFixedPrefix
            client(),
package org.opensearch.remotestore;
            TRANSLOG,
        for (int i = 0; i < numDocs; i++) {
        int numDocs = randomIntBetween(5, 10);
    public void testIndexDeletionNoPinnedTimestamps() throws Exception {
            INDEX_NAME,
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            translogPathFixedPrefix
            METADATA,
            INDEX_NAME,
        ).buildAsString();
            keepPinnedTimestampSchedulerUpdated();
        Settings indexSettings = Settings.builder()
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            indexSingleDoc(INDEX_NAME, true);
            INDEX_NAME,
            "0",
        int numDocs = randomIntBetween(5, 9);
            BlobPath.cleanPath(),
                remoteStorePinnedTimestampService.pinTimestamp(System.currentTimeMillis(), "xyz", noOpActionListener);
            keepPinnedTimestampSchedulerUpdated();
        String shardMetadataPath = getShardLevelBlobPath(
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        public void onFailure(Exception e) {}
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 3)
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            METADATA,
        });
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
    public void testLiveIndexNoPinnedTimestampsWithExtraGenSetting() throws Exception {
        assertBusy(() -> {
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
            INDEX_NAME,
            .build();
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        ).buildAsString();
            INDEX_NAME,
import org.opensearch.indices.RemoteStoreSettings;
@LuceneTestCase.AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/16088")
        }
    }
            RemoteStorePinnedTimestampService.class,
            translogPathFixedPrefix
        for (int i = 0; i < numDocs; i++) {
        });
            METADATA,
    }
 *
import org.opensearch.common.blobstore.BlobPath;
import java.nio.file.Files;
        prepareCluster(1, 1, Settings.EMPTY);
            DATA,
            INDEX_NAME,
            "0",
            client(),
    public void testLiveIndexNoPinnedTimestamps() throws Exception {
        flushAndRefresh(INDEX_NAME);
            .put(remoteStoreIndexSettings(0, 1))
            assertEquals(3, metadataFiles.size());
import java.util.stream.Collectors;
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        createIndex(INDEX_NAME, indexSettings);
        );
import java.nio.file.Path;
            METADATA,
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        List<String> mdFiles = metadataFiles.stream().map(p -> p.getFileName().toString()).collect(Collectors.toList());
        assertBusy(() -> {
        int numDocs = randomIntBetween(15, 20);
            .put(remoteStoreIndexSettings(1, 1))
        }
        });
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            BlobPath.cleanPath(),
            primaryNodeName(INDEX_NAME)
        }
            client(),
            assertFalse(dataFiles.isEmpty());
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            primaryNodeName(INDEX_NAME)
        String shardDataPath = getShardLevelBlobPath(
        );
        );
        ).buildAsString();
            primaryNodeName(INDEX_NAME)
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
            primaryNodeName(INDEX_NAME)
            .build();
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            keepPinnedTimestampSchedulerUpdated();
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
 * this file be licensed under the Apache-2.0 license or a
