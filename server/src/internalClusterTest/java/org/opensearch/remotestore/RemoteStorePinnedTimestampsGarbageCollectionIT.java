        for (int i = 0; i < numDocs; i++) {  
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
        ).buildAsString();
    public void testLiveIndexWithPinnedTimestamps() throws Exception {  
                remoteStorePinnedTimestampService.pinTimestamp(System.currentTimeMillis(), "xyz", noOpActionListener);
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        List<String> mdFiles = metadataFiles.stream().map(p -> p.getFileName().toString()).collect(Collectors.toList());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        for (int i = 0; i < numDocsPostFailover; i++) {
        String shardDataPath = getShardLevelBlobPath(  
            }
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);  
    public void testIndexDeletionNoPinnedTimestamps() throws Exception {
            RemoteStorePinnedTimestampService.class,  
        );  
            client(),
        prepareCluster(1, 1, Settings.EMPTY);
            .put(remoteStoreIndexSettings(0, 1))  
 *
            client(),
            METADATA,
    private static void keepPinnedTimestampSchedulerUpdated() {  
    public void testLiveIndexNoPinnedTimestampsWithExtraGenSetting() throws Exception {
            generations.addAll(LongStream.rangeClosed(minMaxGen.v1(), minMaxGen.v2()).boxed().collect(Collectors.toList()));
            BlobPath.cleanPath(),
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            client(),  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
            .build();  
        int numDocs = randomIntBetween(5, 10);
            client(),
            .put(super.nodeSettings(nodeOrdinal))  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void testIndexDeletionWithPinnedTimestamps() throws Exception {
            TRANSLOG,
            RemoteStorePinnedTimestampService.class,
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            RemoteStorePinnedTimestampService.class,
            indexSingleDoc(INDEX_NAME, false);  
        for (int i = 0; i < numDocs; i++) {
            .put(remoteStoreIndexSettings(0, 1))
        long currentTime = System.currentTimeMillis();
            DATA,
        String shardDataPath = getShardLevelBlobPath(  
            assertEquals(3, metadataFiles.size());  
        ensureGreen(INDEX_NAME);  
            keepPinnedTimestampSchedulerUpdated();
            .build();  
        }
        }  
        });
    }
            client(),
import java.time.Duration;
        Settings indexSettings = Settings.builder()
            TRANSLOG,
 */  
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        );  
            keepPinnedTimestampSchedulerUpdated();
        String shardDataPath = getShardLevelBlobPath(
            .pollDelay(Duration.ofSeconds(1))  
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 3)  
            List<Path> dataFiles = Files.list(translogDataPath).collect(Collectors.toList());
        Settings indexSettings = Settings.builder()  
    }
            primaryNodeName(INDEX_NAME)  
            translogPathFixedPrefix  
            TRANSLOG,
            RemoteStorePinnedTimestampService.class,
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
            indexSingleDoc(INDEX_NAME, true);
        });
import java.util.stream.Collectors;  
    }
        for (int i = 0; i < numDocs; i++) {
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            TRANSLOG,
            TRANSLOG,  
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            INDEX_NAME,  
    public void testLiveIndexNoPinnedTimestamps() throws Exception {  
        prepareCluster(1, 1, Settings.EMPTY);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
import java.nio.file.Path;  
 * SPDX-License-Identifier: Apache-2.0
        int numDocs = randomIntBetween(5, 9);
            assertEquals(1, Files.list(translogMetadataPath).collect(Collectors.toList()).size());
        assertBusy(() -> {  
            .put(remoteStoreIndexSettings(0, 1))
        });  
        );
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            primaryNodeName(INDEX_NAME)
            "0",
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        await().atMost(Duration.ofSeconds(10))
import java.io.IOException;
            INDEX_NAME,
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            translogPathFixedPrefix
            .build();
            translogPathFixedPrefix
            METADATA,  
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            "0",
        createIndex(INDEX_NAME, indexSettings);
        @Override
            .build();
        int numDocs = randomIntBetween(5, 10);
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueMinutes(1));  
        String shardDataPath = getShardLevelBlobPath(
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());  
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
            assertEquals(4, Files.list(translogDataPath).collect(Collectors.toList()).size());  
            "0",  
        String shardDataPath = getShardLevelBlobPath(
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueMinutes(1));  
            assertEquals(5, metadataFiles.size());  
 * The OpenSearch Contributors require contributions made to  
    public void testLiveIndexWithPinnedTimestampsMultiplePrimaryTerms() throws Exception {  
        prepareCluster(1, 1, Settings.EMPTY);  
            INDEX_NAME,
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");  
            primaryNodeName(INDEX_NAME)  
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);  
            translogPathFixedPrefix  
        for (int i = 0; i < numDocs; i++) {  
        for (int i = 0; i < numDocs; i++) {
            .build();
            indexSingleDoc(INDEX_NAME, true);
        }
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
            TRANSLOG,
            TRANSLOG,
        );
            INDEX_NAME,  
            .build();  
        ensureGreen(INDEX_NAME);  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            keepPinnedTimestampSchedulerUpdated();
        createIndex(INDEX_NAME, indexSettings);
            primaryNodeName(INDEX_NAME)
            RemoteStorePinnedTimestampService.class,
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueMinutes(1));
        String shardDataPath = getShardLevelBlobPath(
        }
import java.util.List;  
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
        prepareCluster(1, 1, Settings.EMPTY);
            DATA,
            client(),
    }
            keepPinnedTimestampSchedulerUpdated();  
package org.opensearch.remotestore;
        int numDocs = randomIntBetween(5, 10);
@LuceneTestCase.AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/16088")
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
        }, 30, TimeUnit.SECONDS);
            .build();  
    }  
            TRANSLOG,
            DATA,  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
            METADATA,
        prepareCluster(1, 2, Settings.EMPTY);
        flushAndRefresh(INDEX_NAME);  
            assertEquals(3, metadataFiles.size());
            if (i == 2) {
        String shardMetadataPath = getShardLevelBlobPath(  
            BlobPath.cleanPath(),  
            INDEX_NAME,
            translogPathFixedPrefix
        createIndex(INDEX_NAME, indexSettings);
        int numDocs = randomIntBetween(15, 20);
    }  
            translogPathFixedPrefix
        );
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 3)
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen(INDEX_NAME);
            }  
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");  
            translogPathFixedPrefix
public class RemoteStorePinnedTimestampsGarbageCollectionIT extends RemoteStoreBaseIntegTestCase {  
    }
        @Override
        });
        Settings indexSettings = Settings.builder()
            assertEquals(2, metadataFiles.size());
            BlobPath.cleanPath(),
            .put(remoteStoreIndexSettings(1, 1))  
        Settings indexSettings = Settings.builder()
        String shardDataPath = getShardLevelBlobPath(
            primaryNodeName(INDEX_NAME)
        assertEquals(generations.size() * 2, Files.list(translogDataPath).collect(Collectors.toList()).size());  
/*  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
    public void testLiveIndexNoPinnedTimestampsWithExtraGenSettingWithinLimit() throws Exception {
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());  
        ).buildAsString();  
        ensureGreen(INDEX_NAME);
        });
        ).buildAsString();
        for (int i = 0; i < numDocs; i++) {
        int numDocs = 5;  
            BlobPath.cleanPath(),
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);  
            BlobPath.cleanPath(),
            INDEX_NAME,
            INDEX_NAME,
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        for (int i = 0; i < numDocs; i++) {  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        assertBusy(() -> {  
            .put(remoteStoreIndexSettings(0, 1))  
            BlobPath.cleanPath(),
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        Settings indexSettings = Settings.builder()  
            client(),
    static final String INDEX_NAME = "remote-store-test-idx-1";
        ).buildAsString();
            TRANSLOG,
        ingestDocs();
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
            BlobPath.cleanPath(),
            INDEX_NAME,
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
            client(),  
            primaryNodeName(INDEX_NAME)  
            METADATA,  
            translogPathFixedPrefix
    }
    private void ingestDocs() {
            INDEX_NAME,  
            indexSingleDoc(INDEX_NAME, true);
import org.opensearch.common.unit.TimeValue;  
            client(),  
            keepPinnedTimestampSchedulerUpdated();
            BlobPath.cleanPath(),  
        assertBusy(() -> {
            BlobPath.cleanPath(),  
        ).buildAsString();  
            client(),  
        });  
import java.nio.file.Files;
        internalCluster().restartNode(primaryNodeName(INDEX_NAME));
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());  
        ingestDocs();  
        flushAndRefresh(INDEX_NAME);
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());  
            "0",
        }
        String shardMetadataPath = getShardLevelBlobPath(
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(  
    }
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        assertNoFailures(client().admin().indices().prepareRefresh(INDEX_NAME).setIndicesOptions(IndicesOptions.lenientExpandOpen()).get());
        int numDocsPostFailover = randomIntBetween(15, 20);
        ).buildAsString();
            RemoteStorePinnedTimestampService.class,
        ).buildAsString();
            TRANSLOG,  
            INDEX_NAME,
        assertBusy(() -> {
                remoteStorePinnedTimestampService.pinTimestamp(System.currentTimeMillis(), "xyz", noOpActionListener);
            }  
        public void onResponse(Void unused) {}  
    }
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
            INDEX_NAME,  
            client(),
        assertBusy(() -> {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
}
import java.util.concurrent.TimeUnit;
            translogPathFixedPrefix  
import java.util.HashSet;
            "0",  
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);  
            translogPathFixedPrefix
        ).buildAsString();
            keepPinnedTimestampSchedulerUpdated();  
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.core.action.ActionListener;
        assertBusy(() -> {
            RemoteStorePinnedTimestampService.class,
import org.opensearch.common.blobstore.BlobPath;  
            BlobPath.cleanPath(),  
            INDEX_NAME,
            assertFalse(dataFiles.isEmpty());  
        }
        createIndex(INDEX_NAME, indexSettings);  
        ensureGreen(INDEX_NAME);  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        prepareCluster(1, 1, Settings.EMPTY);
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
            assertEquals(2, metadataFiles.size());
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
            .put(remoteStoreIndexSettings(0, 1))
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
        keepPinnedTimestampSchedulerUpdated();
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            indexSingleDoc(INDEX_NAME, true);
            DATA,  
        ).buildAsString();
        createIndex(INDEX_NAME, indexSettings);  
        String shardMetadataPath = getShardLevelBlobPath(  
        ).buildAsString();
        );
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
            TRANSLOG,  
            "0",
            indexSingleDoc(INDEX_NAME, false);
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING;  
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 10)
        Set<Long> generations = new HashSet<>();
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;  
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
import static org.awaitility.Awaitility.await;
    @Override  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.apache.lucene.tests.util.LuceneTestCase;
            assertTrue(metadataFiles.size() >= numDocs + 1);
            translogPathFixedPrefix  
        ensureGreen(INDEX_NAME);
            .until(() -> RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() > currentTime);
            List<Path> metadataFiles = Files.list(translogMetadataPath).collect(Collectors.toList());
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);  
        }
    };
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), false)
        String shardMetadataPath = getShardLevelBlobPath(
        assertBusy(() -> {  
import org.opensearch.indices.RemoteStoreSettings;  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(  
 * compatible open source license.
            METADATA,
        for (int i = 0; i < numDocs; i++) {  
            indexSingleDoc(INDEX_NAME, true);  
            if (i == 2) {
            "0",  
            BlobPath.cleanPath(),
            DATA,
            translogPathFixedPrefix  
            "0",
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            .put(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.getKey(), 0)
            INDEX_NAME,
            if (i == 2) {  
            BlobPath.cleanPath(),
import org.opensearch.common.collect.Tuple;
            translogPathFixedPrefix
import java.util.stream.LongStream;
            client(),  
        int numDocs = randomIntBetween(5, 10);
        }, 30, TimeUnit.SECONDS);
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
            BlobPath.cleanPath(),
            DATA,
        client().admin().indices().prepareDelete(INDEX_NAME).get();
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);  
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        ).buildAsString();
        for (String mdFile : mdFiles) {
            primaryNodeName(INDEX_NAME)
        }
        return Settings.builder()
            "0",
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            indexSingleDoc(INDEX_NAME, true);
        ).buildAsString();  
            .build();
        int numDocs = randomIntBetween(5, 10);
        assertNoFailures(client().admin().indices().prepareRefresh(INDEX_NAME).setIndicesOptions(IndicesOptions.lenientExpandOpen()).get());
import org.opensearch.common.settings.Settings;
        String shardMetadataPath = getShardLevelBlobPath(
        Settings indexSettings = Settings.builder()  
                RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            assertEquals(2, metadataFiles.size());
            "0",
            verifyTranslogDataFileCount(metadataFiles, translogDataPath);
            DATA,
import java.util.Set;
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        createIndex(INDEX_NAME, indexSettings);  
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
                remoteStorePinnedTimestampService.pinTimestamp(System.currentTimeMillis(), "xyz", noOpActionListener);
        keepPinnedTimestampSchedulerUpdated();  
        assertBusy(() -> {
        prepareCluster(1, 1, Settings.EMPTY);
            Tuple<Long, Long> minMaxGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(mdFile);  
        Path translogDataPath = Path.of(translogRepoPath + "/" + shardDataPath + "/1");
        });
        }  
            TRANSLOG,
import org.opensearch.test.OpenSearchIntegTestCase;
            indexSingleDoc(INDEX_NAME, true);
    private void verifyTranslogDataFileCount(List<Path> metadataFiles, Path translogDataPath) throws IOException {
        public void onFailure(Exception e) {}  
        Settings indexSettings = Settings.builder()
            TRANSLOG,  
        createIndex(INDEX_NAME, indexSettings);
    ActionListener<Void> noOpActionListener = new ActionListener<>() {
            METADATA,
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            .put(remoteStoreIndexSettings(0, 1))
        }
            client(),
            "0",  
            "0",  
        ensureGreen(INDEX_NAME);
        client().admin().indices().prepareDelete(INDEX_NAME).get();
        );  
        assertBusy(() -> {
        ensureGreen(INDEX_NAME);  
            keepPinnedTimestampSchedulerUpdated();  
        Path translogMetadataPath = Path.of(translogRepoPath + "/" + shardMetadataPath);
            "0",
        String shardMetadataPath = getShardLevelBlobPath(
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        ).buildAsString();  
