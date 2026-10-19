            }
        ).buildAsString();
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        client().admin().indices().prepareClose(INDEX_NAME).get();
    }
        for (int i = 0; i < 3; i++) {
    }
        internalCluster().startClusterManagerOnlyNode();
        logger.info("Create shallow snapshot setting enabled repo");
                .put(remoteStoreIndexSettings(0))
            indexSingleDoc(INDEX_NAME);
        // No node settings and request durability
            clusterManagerName = internalCluster().startClusterManagerOnlyNode();
     * This tests validation of the cluster setting when being set.
        client(clusterManagerName).admin()
import java.util.Map;
        assertNotNull(newIndexUUID);
        indexShard.store().incRef();
            "no further periodic flush once the accounting has been discarded",
        );
        final long periodicAfterDisable = indexShard.flushStats().getPeriodic();
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, INDEX_NAME);
            refresh(INDEX_NAME);
                .put(RecoverySettings.INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING.getKey(), "1s")
        int numberOfIterations = randomIntBetween(5, 15);
        assertAcked(
            .setTimeout(TimeValue.timeValueSeconds(5))
    private void enableFlushOnUncommittedSegments() {
        );
import java.util.Arrays;
        final long periodicWhileDisabled = indexShard.flushStats().getPeriodic();
        MatcherAssert.assertThat(
            () -> createIndex(INDEX_NAME, indexSettings)
     */
        verifyRemoteStoreCleanup();
        // 2. Index docs
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
            .setWaitForCompletion(true)
    }
        );
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        ClusterUpdateSettingsRequest req = new ClusterUpdateSettingsRequest().persistentSettings(
            client().admin()
            internalCluster().client()
            .prepareGetSettings(INDEX_NAME)
                    Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
            Settings.builder()
        if (RemoteStoreSettings.isPinnedTimestampsEnabled()) {
                // independent of the randomized merge policy defaults
        String shardPath = getShardLevelBlobPath(
        flushThread.join();
                    + deletedDocs
        // 5. Ensure green and verify number of docs
        // indexing 100 documents (100 bulk requests), no flush will be triggered yet
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9327")
        internalCluster().startClusterManagerOnlyNode();
        }, 30, TimeUnit.SECONDS);
            .prepareReroute()
     */
            .cluster()
        // Flush so that the subsequent sync or flushes are no-op.
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        for (int i = 0; i < 3; i++) {
        assertEquals(0, indexShard.flushStats().getPeriodic());
                )
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
            .get();
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        );
    }
        // republishes it and the count must hold steady however much more the workload writes and refreshes.
                .indices()
        final String snapshot1 = "snapshot1";
            } finally {
                    Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
import org.opensearch.snapshots.SnapshotState;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));
                }
            TRANSLOG,
        String newIndexUUID = client().admin()
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        internalCluster().startClusterManagerOnlyNode();
            .cluster()
        assertBufferInterval(bufferInterval, indexShard);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000L, -1));
        assertEquals(Durability.REQUEST, indexShard.indexSettings().getTranslogDurability());
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
            .get();
            indexSingleDoc(INDEX_NAME);
        int numberOfIterations = randomIntBetween(2, 5);
        );
     */
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);
                    + " gcp="
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));
    public void testSuccessfulShallowV1SnapshotPostIndexClose() throws Exception {
            refresh(INDEX_NAME);
    public Settings indexSettings() {
            SearchPhaseExecutionException.class,
        for (int i = 0; i < 100; i++) {
                MatcherAssert.assertThat(actualFileCount, is(oneOf(numberOfIterations - 1, numberOfIterations, numberOfIterations + 1)));
                    Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(-1))
        String shardPath = getShardLevelBlobPath(client(), INDEX_NAME, getSegmentBasePath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix)
        // Explicit node settings and request durability
        );
                .setPatterns(Arrays.asList("test*"))
    private void testPeerRecovery(int numberOfIterations, boolean invokeFlush) throws Exception {
    public void testStaleCommitDeletionWithMinSegmentFiles_Disabled() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
                }
    }
            .put(remoteStoreIndexSettings(0, 10000L, -1))
            .actionGet();
        assertEquals(0, indexShard.flushStats().getPeriodic());
        // Indexing 500 more docs
        // without the fix the soft-deletes floor never moves off the initial commit and the deleted-docs count can
            "0",
            )
    @Override
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "10s");
                .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
            .updateSettings(
        try (Stream<Path> files = Files.list(segmentDataPath)) {
                flushLatch.countDown();
        assertEquals(durability, indexShard.indexSettings().getTranslogDurability());
 *
            .put("location", shallowSnapshotRepoPath)
        // We also allow (numberOfIterations + 1) as index creation also triggers refresh.
        mockTargetTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        internalCluster().startClusterManagerOnlyNode();
        // 3. Delete data from remote segment store
            long deletedDocs = client().admin().indices().prepareStats(INDEX_NAME).get().getPrimaries().getDocs().getDeleted();
        // soft-deleted tombstones, and the refresh drives a remote segments upload
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
import java.util.Optional;
                    client().prepareIndex(INDEX_NAME)
                .put("index.refresh_interval", "-1")
        handOffLatch.await(30, TimeUnit.SECONDS);
        internalCluster().startClusterManagerOnlyNode();
        ensureStableCluster(3);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // We also allow (numberOfIterations + 1) as index creation also triggers refresh.
            Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build()
     * the index sets no per-index threshold, so lowering
                .get()
                .put(remoteStoreIndexSettings(0))
                .setPersistentSettings(
            indexBulk(INDEX_NAME, 1);
/*
        String newNode = internalCluster().startDataOnlyNodes(1).get(0);
                .prepareUpdateSettings()
            indexBulk(INDEX_NAME, 1);
            Settings.builder()
        // deletion when refresh is in-progress.
    public void testRemoteStoreIndexCreationAndDeletionWithReferencedStore() throws InterruptedException, ExecutionException {
            try (Stream<Path> files = Files.list(translogLocation)) {
        SearchPhaseExecutionException ex = assertThrows(
                    + indexShard.getLastSyncedGlobalCheckpoint()
import java.util.concurrent.CountDownLatch;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
        String shardPath = getShardLevelBlobPath(
     * Turns on {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}, which is disabled by default and has
        delete(translogRepoPath, shardPath);
            .setTimeout(TimeValue.timeValueSeconds(10))
        assertBusy(() -> {
    public void testResumeUploadAfterFailedPrimaryRelocation() throws ExecutionException, InterruptedException, IOException {
        indexBulk(INDEX_NAME, uncommittedOps);
        // Wait for atleast one doc to be ingested.
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class))
        assertEquals(0, snapshotInfo2.failedShards());
    public void testPeriodicFlushOnUncommittedSegmentBytesFromClusterDefault() throws Exception {
import org.opensearch.indices.recovery.RecoverySettings;
            client().admin()
        ensureGreen(INDEX_NAME);
        String indexUUID = client().admin()
            oldPrimary
        assertAcked(
            );
        durability = randomFrom(Durability.values());
            Settings.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                .prepareUpdateSettings()
            prepareCreate(INDEX_NAME).setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1))
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        // In this test, we fail the hand off during the primary relocation. This will undo the drainRefreshes and
                .admin()
            assertEquals(4, actualFileCount);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));
    public void testCloseIndexWithNoOpSyncAndFlushForAsyncTranslog() throws InterruptedException {
import java.nio.file.Files;
    }
            indexSingleDoc(INDEX_NAME);
        // check that there are no duplicate metadata files for translog or upload.
            .build();
            .indices()
        ensureGreen(INDEX_NAME);
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
                .setTransientSettings(
        assertTrue(indexShard.getTranslogSyncProcessor() instanceof BufferedAsyncIOProcessor);
    @Override
        try (Stream<Path> files = Files.list(translogLocation)) {
import org.opensearch.indices.recovery.RecoveryState;
            int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.concurrent.TimeUnit;
        ex = assertThrows(
import org.opensearch.action.bulk.BulkRequestBuilder;
            .setWaitForNoRelocatingShards(true)
     * An explicit per-index threshold overrides the cluster default: with the cluster threshold at 1b, an index which
                .setPersistentSettings(
import java.util.List;
            () -> client(newPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get()
        // No node settings and async durability
    private void verifyRemoteStoreCleanup() throws Exception {
        );
        ensureGreen(INDEX_NAME);
            .build();
        Path translogLocation = getTranslog(indexShard).location();
        client(clusterManagerName).admin()
        ).buildAsString();
    /**
        indexData(numberOfIterations, true, INDEX_NAME);
            .setTimeout(TimeValue.timeValueSeconds(5))
     */
            "0",
            indexSingleDoc(INDEX_NAME);
        } else {
                + " more",
            () -> client(newPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get()
            indexBulk(INDEX_NAME, 1);
        internalCluster().startNodes(3);
    // Test local only translog files which are not uploaded to remote store (no metadata present in remote)
        );
import org.hamcrest.MatcherAssert;
        assertHitCount(
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Durability.ASYNC)
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "1b")
            internalCluster().client()
    public void testRequestDurabilityWhenRestrictSettingImplicitFalse() throws ExecutionException, InterruptedException {
            .setWaitForEvents(Priority.LANGUID)
        // delete the index
            METADATA,
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().startClusterManagerOnlyNode();
            // With pinned timestamp, we also keep md files since last successful fetch
        CountDownLatch flushDone = new CountDownLatch(1);
        Settings indexSettings = Settings.builder()
            refresh(INDEX_NAME);
    }
        );
                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "1gb")
    public void testPeriodicFlushReclaimsSoftDeletesUnderUpdateHeavyWorkload() throws Exception {
        assertEquals(0, indexShard.flushStats().getPeriodic());
                // deletion.
import java.util.stream.Collectors;
    /**
            .setTransientSettings(
        SnapshotInfo snapshotInfo2 = internalCluster().client()
        String dataNode = internalCluster().startNodes(1).get(0);
        );
        Thread.sleep(10000);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            .cluster()
        indexSingleDoc(INDEX_NAME);
            refresh(INDEX_NAME);
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogFlush() throws Exception {
            .indices()
            .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
        );
import org.opensearch.index.translog.Translog;
            indexSingleDoc(INDEX_NAME);
        String replicaNodeName = replicaNodeName(INDEX_NAME);
                if (RemoteStoreSettings.isPinnedTimestampsEnabled()) {
                .prepareUpdateSettings(INDEX_NAME)
            .prepareUpdateSettings()
            Settings.builder()
import org.opensearch.test.InternalTestCluster;
            .actionGet();
            TimeUnit.SECONDS
        createIndex(
        // Delete is async. Give time for it
        cluster().wipeIndices(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        String dataNode = internalCluster().startNodes(1).get(0);
    }
            oldPrimary
        Path indexPath = Path.of(String.valueOf(segmentRepoPath), indexUUID);
        flushAndRefresh(INDEX_NAME);
                .indices()
        indexBulk(INDEX_NAME, 15);
                throw new OpenSearchException("failing recovery for test purposes");
            client(newPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(),
                lessThan(tombstonesCreated)
                }
        logger.info("Starting up another cluster manager with cluster.remote_store.index.restrict.async-durability set to false");
    }
                oldPrimaryIndexShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
import static org.hamcrest.Matchers.greaterThan;
            assertEquals(totalFiles, 501L);
     * This tests multiple cases where the index setting is passed during the index creation with multiple combinations
        ensureGreen(INDEX_NAME);
        indexData(numberOfIterations, true, INDEX_NAME);
            () -> assertHitCount(client(replicaNodeName).prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
        }, 30, TimeUnit.SECONDS);
        internalCluster().startNode(settings);
        assertAcked(
        ensureGreen(INDEX_NAME);
    }
    private void assertBufferInterval(TimeValue expectedBufferInterval, IndexShard indexShard) {
    }
    public void testPeerRecoveryWithLowActivityTimeout() throws Exception {
        );
            .actionGet();
        testPeerRecovery(randomIntBetween(1, 3), true);
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(shallowSnapshotRepoName, snapshot2)
            client().prepareIndex(INDEX_NAME).setId("nudge-" + nudge.incrementAndGet()).setSource("field", "x").get();
                .get()
            () -> assertHitCount(client(replicaNodeName).prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
        IndexShard oldPrimaryIndexShard = getIndexShard(oldPrimary, INDEX_NAME);
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        );
                Settings.builder().put(CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), randomIntBetween(2, 4))
            segmentsPathFixedPrefix
        TimeValue clusterBufferInterval = TimeValue.timeValueSeconds(randomIntBetween(100, 200));
            .cluster()
            )
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000l, -1));
        // 3. Delete metadata from remote translog
import org.opensearch.action.index.IndexResponse;
     */
     * End-to-end reproduction of an update-heavy workload with regular refreshes on a remote-store shard, where
            .get();
            // Reduce the latch for the main thread to flush after some sleep.
     * periodic flushes fire, the safe commit advances past the workload, and a non-flushing expunge-deletes merge
import org.opensearch.common.blobstore.BlobPath;
                .prepareUpdateSettings()
            .execute()
        testRestrictSettingFalse(true, Durability.REQUEST);
        );
                )
            indexSingleDoc(INDEX_NAME);
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
     */
        // enabling it on the live index -- with no per-index setting anywhere -- arms the condition
                0,
        flushThread.start();
            .actionGet();
        testPeerRecovery(1, true);
        Thread.sleep(10000);
            INDEX_NAME,
        for (int i = 0; i < randomIntBetween(1, 3); i++) {
        return getFileCount(indexPath);
    public void testDefaultBufferInterval() throws ExecutionException, InterruptedException {
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
        for (int i = 0; i < 5; i++) {
            } catch (InterruptedException e) {
import org.opensearch.test.transport.MockTransportService;
                )
            () -> internalCluster().client()
            .put(indexSettings())
        String newPrimary = internalCluster().startDataOnlyNodes(1).get(0);
        );
    }
        flush(INDEX_NAME);
                "deleted="
        indexData(5, randomBoolean(), INDEX_NAME);
                .build()
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
            .cluster()
        enableFlushOnUncommittedSegments();
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));
import org.opensearch.transport.TransportService;
        Thread.sleep(1000);
            .prepareUpdateSettings()
        }
    /**
            } else {
            refresh(INDEX_NAME);
            .prepareUpdateSettings()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .get()
                .put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "100")
        assertHitCount(client(oldPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs);
                .cluster()
        final String snapshot2 = "snapshot2";
            .get()
    public void testNoMultipleWriterDuringPrimaryRelocation() throws ExecutionException, InterruptedException {
    public void testClusterBufferIntervalValidation() {
        // Set the index setting (index.remote_store.translog.buffer_interval) with a different value and validate that
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            METADATA,
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
        createIndex(INDEX_NAME, settings.build());
                // to the uncommitted-segment-bytes condition only
        assertEquals("all shards failed", ex.getMessage());
        }, 30, TimeUnit.SECONDS);
        client().admin()
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
    private void clearClusterBufferIntervalSetting(String clusterManagerName) {
        Settings.Builder settings = Settings.builder()
        client().admin()
            getSegmentBasePath(),
                // newPrimaryTranslogRepo.setSleepSeconds(0);
        assertEquals(1, recoverySource.get().getIndex().recoveredFileCount());
            .setWaitForEvents(Priority.LANGUID)
            client().admin()
                .indices()
        // 1. Create index with 0 replica
                .put("index.merge.policy.expunge_deletes_allowed", "0.0")
            INDEX_NAME,
        indexData(numberOfIterations, false, INDEX_NAME);
                .setPersistentSettings(
                .cluster()
        Settings.Builder settings = Settings.builder()
        latch.await();
            "index setting [index.translog.durability=async] is not allowed as cluster setting [cluster.remote_store.index.restrict.async-durability=true]";
        assertBusy(() -> {
            )
            files.forEach(p -> {
                .prepareUpdateSettings()
        ensureStableCluster(2);
                    Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
            .actionGet();
        testPeerRecovery(1, false);
                .indices()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .updateSettings(
        // Closing the index involves translog.sync and shard.flush which are now no-op.
public class RemoteStoreCoreTestCase extends RemoteStoreBaseIntegTestCase {
            lessThanOrEqualTo(periodicAfterDisable + 1)
        ));
import static org.opensearch.index.shard.IndexShardTestCase.getTranslog;
        try (Stream<Path> files = Files.list(translogLocation)) {
    /**
            .execute()
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
            docs + moreDocs + uncommittedOps
        assertBusy(() -> { assertHitCount(client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get(), 6); });
     * take effect on it, and {@code cluster.remote_store.flush_on_uncommitted_segments.enabled} -- which has no
            INDEX_NAME,
                flushDone.countDown();
        client().admin().indices().close(Requests.closeIndexRequest(INDEX_NAME)).actionGet();
    }
    public void testFallbackToNodeToNodeSegmentCopy() throws Exception {
        // published while it was on, so a flush can only still land in the gap before that sync; after that nothing
        assertTrue(oldPrimaryIndexShard.isStartedPrimary());
        assertFalse(recoverySource.isEmpty());
import java.util.stream.Stream;
        client(clusterManagerName).admin()
import org.opensearch.indices.IndicesService;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ensureStableCluster(2);
        });
            .actionGet();
            "0",
    }
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));
        ensureGreen(INDEX_NAME);
                // the random index template may set retention.operations up to 1000 which would retain the whole
                // this is fine
            } catch (IndexShardClosedException e) {
        indexShard.store().decRef();
                )
            // Index single doc to start the asyn io processor to run which will lead to 10s wait time before the next sync.
        updateSettingsRequest.persistentSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "0ms"));
            assertHitCount(client(dataNodes.get(0)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);
        ).buildAsString();
            if (PeerRecoveryTargetService.Actions.HANDOFF_PRIMARY_CONTEXT.equals(action)) {
        }
        // Next, we change the default buffer interval and the same should reflect in the buffer interval of the index created
        final long tombstonesCreated = (long) (rounds - 1) * docCount;
                    + " commitCkpt="
        logger.info("--> Create index and ingest 50 docs");
                .setPersistentSettings(
    }
    /**
    public void testLocalOnlyTranslogCleanupOnNodeRestart() throws Exception {
import static org.hamcrest.Matchers.lessThan;
        int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
            .setWaitForNoRelocatingShards(true)
            .setWaitForStatus(ClusterHealthStatus.GREEN)
            clusterManagerName = internalCluster().startClusterManagerOnlyNode(
        restore(true, INDEX_NAME);
            }
            .setTransientSettings(
        if (setRestrictFalse) {
    public void testOverriddenBufferIntervalValidation() {
            indexSingleDoc(INDEX_NAME);
        internalCluster().startNodes(3);
        ClusterHealthResponse clusterHealthResponse = client().admin()
    public void testAsyncDurabilityWhenRestrictSettingImplicitFalse() throws ExecutionException, InterruptedException {
                .cluster()
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import java.util.concurrent.atomic.AtomicInteger;
            .indices()
        );
        internalCluster().startClusterManagerOnlyNode();
    }
import static org.hamcrest.Matchers.comparesEqualTo;
        client().admin().indices().close(Requests.closeIndexRequest(INDEX_NAME)).actionGet();
        return remoteStoreIndexSettings(0);
        ClusterHealthResponse clusterHealthResponse = client().admin()
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(
                    Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability)
        logger.info("--> restore all indices from the snapshot");
            client(),
        assertEquals("all shards failed", ex.getMessage());
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "1s")
            client().admin()
    }
        ensureGreen(INDEX_NAME);
            .put(remoteStoreIndexSettings(0, 10000L, -1))
                    assertTrue(actualFileCount >= lastNMetadataFilesToKeep);
        );
        ensureGreen(INDEX_NAME);
import org.opensearch.index.IndexSettings;
            .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), "-1");
            getSegmentBasePath(),
        updateSettingsRequest.persistentSettings(
            .indices()
        );
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            INDEX_NAME,
            client().prepareIndex(INDEX_NAME).setId("0").setSource("field", randomAlphaOfLength(100)).get();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
            .prepareHealth()
            .prepareReroute()
    }
        Path shallowSnapshotRepoPath = randomRepoPath();
     */
 * compatible open source license.
            .get();
        });
        assertBusy(() -> {
    public void testOverriddenBufferInterval() throws ExecutionException, InterruptedException {
            client(),
            .prepareUpdateSettings()
            indexBulk(INDEX_NAME, 15);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME, indexSettings));
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            // Reduce the latch for the main thread to flush after some sleep.
            .updateSettings(
        // Case 1 - Test create index fails
     * Tests that when the index setting is not passed during index creation, the buffer interval picked up is the cluster
import org.opensearch.action.admin.indices.flush.FlushRequest;
            indexSingleDoc(INDEX_NAME);
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false)
        indexSingleDoc(INDEX_NAME);
}
        // Case 2 - Test update index fails
            translogPathFixedPrefix
                .cluster()
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogNoDataRefresh() throws Exception {
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
                .prepareUpdateSettings()
import java.io.IOException;
        assertClusterRemoteBufferInterval(IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL, dataNode);
        Thread flushThread = new Thread(() -> {
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        String clusterManagerName = internalCluster().getClusterManagerName();
        client().admin()
    }
        ensureGreen(INDEX_NAME);
     * default.
        String originalIndexUUID = client().admin()
                // otherwise the renewal gate (half the 12h lease period) keeps retention pinned at the initial
        // Delete is async.
            INDEX_NAME,
        ensureGreen(INDEX_NAME);
            () -> client(clusterManagerName).admin()
                handOffLatch.countDown();
                    Settings.builder()
                        .setId(String.valueOf(i))
            assertThat(
            .prepareHealth()
        clearClusterBufferIntervalSetting(clusterManagerName);
        assertEquals(SnapshotState.SUCCESS, snapshotInfo1.state());
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
import org.opensearch.common.util.concurrent.BufferedAsyncIOProcessor;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
        createIndex(INDEX_NAME, indexSettings);
        createRepository("test-repo", "fs", Settings.builder().put("location", absolutePath));
    }
        );
                        is(oneOf(lastNMetadataFilesToKeep - 1, lastNMetadataFilesToKeep, lastNMetadataFilesToKeep + 1))
    private void testRestrictSettingFalse(boolean setRestrictFalse, Durability durability) throws ExecutionException, InterruptedException {
            .setWaitForCompletion(true)
        logger.info("--> Create index with the same name, different UUID");
        createIndex(INDEX_NAME, settings.build());
            .get()
        CountDownLatch flushLatch = new CountDownLatch(1);
     * hands it back to the cluster default.
        assertBufferInterval(bufferInterval, indexShard);
        String dataNode = internalCluster().startNodes(1).get(0);
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        ensureGreen(INDEX_NAME);
            .setWaitForNoRelocatingShards(true)
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));
        indexBulk(INDEX_NAME, 1);
            "failed to parse value [-1] for setting [cluster.remote_store.translog.buffer_interval], must be >= [0ms]",
                .cluster()
                // workload below the global checkpoint no matter how far the safe commit advances
                )
        internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> {
        }, 30, TimeUnit.SECONDS);
        }, 30, TimeUnit.SECONDS);
import org.opensearch.index.translog.Translog.Durability;
                flushLatch.await(2, TimeUnit.SECONDS);
        mockTargetTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        ensureGreen(INDEX_NAME);
            .build();
        final AtomicInteger nudge = new AtomicInteger();
 */
        client().admin()
    /**
            refresh(INDEX_NAME);
    }
        enableFlushOnUncommittedSegments();
            client().admin()
        String shardPath = getShardLevelBlobPath(
    }
            .setIndices(INDEX_NAME)
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
        // 2. Index docs
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
        MatcherAssert.assertThat(actualFileCount, is(oneOf(numberOfIterations - 1, numberOfIterations, numberOfIterations + 1)));
        String shardPath = getShardLevelBlobPath(
        );
            .getSnapshotInfo();
                try {
        indexData(numberOfIterations, true, INDEX_NAME);
            .cluster()
                deletedDocs,
        // No flush is triggered since max_translog_readers is set to -1
        TimeValue bufferInterval = TimeValue.timeValueSeconds(randomIntBetween(0, 100));
            );
            .setWaitForStatus(ClusterHealthStatus.GREEN)
        String dataNode = internalCluster().startDataOnlyNode();
        assertFalse(clusterHealthResponse.isTimedOut());
        internalCluster().startNodes(3);
        }
     */
    public void testNoSearchIdleForAnyReplicaCount() throws ExecutionException, InterruptedException {
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        // Explicit node settings and async durability
        assertAcked(
        // the buffer interval is updated
import org.opensearch.common.settings.Settings;
        assertEquals(0, indexShard.flushStats().getPeriodic());
            .prepareCreateSnapshot(shallowSnapshotRepoName, snapshot2)
            if (numberOfIterations <= lastNMetadataFilesToKeep) {
            indexSingleDoc(INDEX_NAME);
        indexShard = getIndexShard(replicaShardNode, INDEX_NAME);
                .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), "0ms")
            .indices()
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s");
        assertFalse(clusterHealthResponse.isTimedOut());
            IllegalArgumentException.class,
            // Index another doc and in this case the flush would have happened before the sync.
        internalCluster().startClusterManagerOnlyNode(
        indexSingleDoc(INDEX_NAME);
import org.opensearch.OpenSearchException;
            30,
        MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(
        CountDownLatch latch = new CountDownLatch(1);
        logger.info("--> relocate the shard");
     * pile up unreclaimed. Asserts the full recovery chain through the uncommitted-segment-bytes condition:
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
                    + indexShard.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
        client().admin().indices().close(Requests.closeIndexRequest(INDEX_NAME)).actionGet();
        clusterHealthResponse = client().admin()
            .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
            INDEX_NAME,
        // the whole workload (the flush is async, so a single trip is not enough on its own)
                .setPersistentSettings(Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "-1"))
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
            client().admin()
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
    public void testStaleCommitDeletionWithoutInvokeFlush() throws Exception {
        assertBusy(() -> {
            .prepareGetSettings(INDEX_NAME)
        final int rounds = 8;
        assertBusy(() -> {
            )
                assertThat(getFileCount(indexPath), comparesEqualTo(0));
        internalCluster().startDataOnlyNode();
            // Index some docs to start the asyn io processor to run which will lead to 10s wait time before the next sync.
        assertTrue(getFileCount(indexPath) > 0);
        Settings indexSettings = Settings.builder()
        assertThrows(
                + (periodicWhileDisabled - periodicAfterDisable)
        ensureStableCluster(3);
        );
        createIndex(
        );
            assertTrue(actualFileCount >= 4);
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async"))
     * no per-index counterpart, so the condition cannot be armed through index settings.
        ));
        });
            indexSingleDoc(INDEX_NAME);
            } catch (Exception e) {}
        // Sleep for some time for the next doc to be present in lucene buffer. If flush happens first before the doc #2
            .admin()
        assertBusy(
            client(newNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(),
import org.opensearch.index.shard.IndexShardClosedException;
        }
        logger.info("--> wipe all indices");
            Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), false).build()
            .setWaitForCompletion(true)
        indexBulk(INDEX_NAME, randomIntBetween(5, 10));
                    Settings.builder()
        TimeValue clusterBufferInterval = TimeValue.timeValueSeconds(randomIntBetween(100, 200));
                .get()
            assertEquals(totalFiles, 1L);
        client().admin()
            connection.sendRequest(requestId, action, request, options);
import org.opensearch.snapshots.SnapshotInfo;
        flushAndRefresh(INDEX_NAME);
            assertFalse(bulk.get().hasFailures());
        String replicaShardNode = internalCluster().startDataOnlyNodes(1).get(0);
        int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
            .get();
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));
                new UpdateSettingsRequest(INDEX_NAME).settings(
        MatcherAssert.assertThat(actualFileCount, is(oneOf(numberOfIterations, numberOfIterations + 1)));
        assertNotEquals(IndexMetadata.INDEX_UUID_NA_VALUE, originalIndexUUID);
            () -> client(clusterManagerName).admin()
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
            Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build()
        }
        assertEquals(expectedExceptionMsg, exception.getMessage());
                .get()
                // refreshes are driven manually by the workload below
        indexBulk(INDEX_NAME, 15);
        // Set the cluster default with a different value, validate that the buffer interval is still the overridden value
        client(clusterManagerName).admin()
import org.opensearch.cluster.routing.RecoverySource;
        assertBusy(() -> assertFalse(indexShard.shouldPeriodicallyFlush()), 30, TimeUnit.SECONDS);
                .put(remoteStoreIndexSettings(0))
        }
            .prepareUpdateSettings()
        String shardPath = getShardLevelBlobPath(
        testRestrictSettingFalse(false, Durability.REQUEST);
            SEGMENTS,
        MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(
        ensureGreen(INDEX_NAME);
        }
                )
            .cluster()
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
        Settings.Builder settings = Settings.builder()
            .prepareUpdateSettings(INDEX_NAME)
        // overwrite the same document ids round after round; every round turns the previous round's documents into
    }
    public void testRestoreSnapshotToIndexWithSameNameDifferentUUID() throws Exception {
                for (int i = 0; i < randomIntBetween(1, 5); i++) {
        assertHitCount(client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get(), searchableDocs);
            TransportService.class,
        Settings indexSettings = Settings.builder()
            .get()
        IllegalArgumentException exceptionDuringCreateIndex = assertThrows(
        CountDownLatch handOffLatch = new CountDownLatch(1);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
     * threshold lowered to 1b, a refresh-driven segments upload publishes the accounting and the next write
            assertEquals(totalFiles, 101L);
            .cluster()
    protected int getActualFileCount(Path segmentRepoPath, String shardPath) throws IOException {
        }).start();
                    );
                .prepareUpdateSettings()
        testRestrictSettingFalse(true, Durability.ASYNC);
        int lastNMetadataFilesToKeep = indexShard.getRemoteStoreSettings().getMinRemoteSegmentMetadataFiles();
            .get();
            searchableDocs += 15;
        indexBulk(INDEX_NAME, docs);
        assertAcked(
        }
            .get();
        Path segmentDataPath = Path.of(baseRepoPath + "/" + shardPath);
        for (int round = 0; round < rounds; round++) {
        indexSingleDoc(INDEX_NAME);
    }
        String clusterManagerName;
        internalCluster().startClusterManagerOnlyNode();
     * with and without cluster default.
        logger.info("Verify shallow snapshot created before close");
        assertTrue(snapshotInfo1.successfulShards() > 0);
                assertEquals(totalFiles, 1L);
    }
     * pins its own threshold well above what the workload can reach must not flush, and dropping the per-index value
        // which will be the cluster default now.
                .build()
        // 1. Create index with 0 replica
        ensureGreen(INDEX_NAME);
        IndexShard indexShard = getIndexShard(primaryShardNode, INDEX_NAME);
        String newPrimary = internalCluster().startDataOnlyNodes(1).get(0);
        int searchableDocs = 0;
        // We also allow (numberOfIterations + 1) as index creation also triggers refresh.
            .collect(Collectors.toList());
                .prepareUpdateSettings(INDEX_NAME)
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
            .cluster()
            segmentsPathFixedPrefix
            refresh(INDEX_NAME);
                .setPatterns(Arrays.asList("test*"))
        assertAcked(
            .setWaitForStatus(ClusterHealthStatus.GREEN)
                    indexSingleDoc(INDEX_NAME);
        // the periodic flush condition is polled on write operations and the counter is republished on each
            }
            METADATA,
        flushAndRefresh(INDEX_NAME);
            .indices()
        String expectedExceptionMsg =
        IndexShard oldPrimaryIndexShard = getIndexShard(oldPrimary, INDEX_NAME);
        bufferInterval = TimeValue.timeValueSeconds(bufferInterval.seconds() + randomIntBetween(1, 100));
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogRefresh() throws Exception {
        final int docCount = 20;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s")
            segmentsPathFixedPrefix
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogNoDataFlush() throws Exception {
                    Settings.builder()
            .prepareReroute()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void testStaleCommitDeletionWithInvokeFlush() throws Exception {
        String datanode = internalCluster().startDataOnlyNodes(1).get(0);
        assertTrue(snapshotInfo2.successfulShards() > 0);
        } else {
        }).start();
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
                // let the primary's own peer-recovery retention lease follow the global checkpoint at test speed;
                .cluster()
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
        MatcherAssert.assertThat(
        Settings.Builder settings = Settings.builder()
        String clusterManagerName = internalCluster().getClusterManagerName();
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
            "0",
        // we check that we do not overwrite any file on remote store. Here we will also increase the replica count to
                .updateSettings(new UpdateSettingsRequest(INDEX_NAME).settings(indexSettings))
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            segmentsPathFixedPrefix
        flushAndRefresh(INDEX_NAME);
        int uncommittedOps = randomIntBetween(5, 10);
                    Files.delete(p);
import org.opensearch.cluster.health.ClusterHealthStatus;
            .put(indexSettings())
     * Verifies the end-to-end periodic flush trigger on a remote-store shard: with the uncommitted-segment-bytes
        indexBulk(INDEX_NAME, moreDocs);
                    MatcherAssert.assertThat(
            (int) client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value(),
            IllegalArgumentException.class,
        internalCluster().startDataOnlyNode();
        Path indexPath = Path.of(segmentRepoPath + "/" + shardPath);
        for (int i = 0; i < 10; i++) {
import org.opensearch.index.seqno.SequenceNumbers;
        int numberOfIterations = randomIntBetween(1, 5);
            "failed to parse value [-1] for setting [index.remote_store.translog.buffer_interval], must be >= [0ms]",
            indexSingleDoc(INDEX_NAME);
            .setIndices(INDEX_NAME)
     * {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size} after the index already exists must
    }
            client().admin()
            .execute()
        assertFalse(indexShard.isSearchIdleSupported());
        );
        // try restoring the snapshot
                throw new AssertionError(e);
            .setWaitForCompletion(true)
            periodicWhileDisabled,
            METADATA,
            try {
    public void testRequestDurabilityWhenRestrictSettingExplicitFalse() throws ExecutionException, InterruptedException {
                // any segment with at least one reclaimable delete qualifies for the expunge-deletes merge below,
        assertNotNull(originalIndexUUID);
import org.opensearch.index.shard.IndexShard;
            SEGMENTS,
        // Flush so that the subsequent sync or flushes are no-op.
            .setTransientSettings(Settings.builder().putNull(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()))
                .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "0ms")
            periodicWhileDisabled,
        }, 30, TimeUnit.SECONDS);
            SEGMENTS,
        ).buildAsString();
            .cluster()
                } catch (IOException e) {
        String dataNode = internalCluster().startNodes(1).get(0);
        String oldPrimary = internalCluster().startDataOnlyNodes(1).get(0);
        assertHitCount(client(oldPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs + moreDocs);
        }
            .execute()
            .indices()
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            }
            .execute()
        flushAndRefresh(INDEX_NAME);
            IllegalArgumentException.class,
        assertBufferInterval(clusterBufferInterval, indexShard);
            is(oneOf(searchableDocs + 15, searchableDocs + 30))
        String dataNode = internalCluster().startDataOnlyNode();
        refresh(INDEX_NAME);
import org.opensearch.common.unit.TimeValue;
    protected BlobPath getSegmentBasePath() {
        // segments_N file is copied to new replica
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);
            if (PeerRecoveryTargetService.Actions.HANDOFF_PRIMARY_CONTEXT.equals(action)) {
        delete(segmentRepoPath, shardPath);
        ensureGreen(INDEX_NAME);
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
            .findFirst();
            .cluster()
        internalCluster().startClusterManagerOnlyNode();
            IllegalArgumentException.class,
        }
        // Total tlog files would be incremented by 500
        ensureGreen(INDEX_NAME);
                .setPersistentSettings(
                Settings.builder().put(CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), randomIntBetween(2, 4))
    }
            is(oneOf(searchableDocs, searchableDocs + 15))
        assertBusy(
                // pin the (suppressed anyway) translog condition high so any observed periodic flush is attributable
 * The OpenSearch Contributors require contributions made to
     * is able to reclaim the tombstones.
        cluster().wipeIndices(INDEX_NAME);
        String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
import static org.hamcrest.Matchers.is;
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
        assertBusy(() -> {
        Optional<RecoveryState> recoverySource = recoveryResponse.shardRecoveryStates()
        final long maxSeqNoAfterWorkload = indexShard.seqNoStats().getMaxSeqNo();
            client(),
            assertHitCount(client(dataNodes.get(0)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);
            indexBulk(INDEX_NAME, 1);
            .cluster()
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
            .get();
                // do not make writes wait on the translog upload batching window
        assertBusy(() -> {
            .add(new MoveAllocationCommand(INDEX_NAME, 0, newPrimary, newNode))
        RecoveryResponse recoveryResponse = client(replicaNodeName).admin().indices().prepareRecoveries().get();
            .get();
        );
        String oldPrimary = internalCluster().startDataOnlyNodes(1).get(0);
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
        client(clusterManagerName).admin()
    }
    public void testAsyncTranslogDurabilityRestrictionsThroughIdxTemplates() throws Exception {
        );
                )
            long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
            SearchPhaseExecutionException.class,
            .admin()
                bulk.add(
                .admin()
        assertEquals(
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "5s"))
        IllegalArgumentException exception = assertThrows(
                Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), false).build()
            }
import java.util.Collection;
        createIndex(INDEX_NAME, indexSettings);
        // successful upload, so nudge with write+refresh cycles until the flushes have carried the safe commit past
            getSegmentBasePath(),
     * every successful segments upload suppresses the translog based flush condition and soft-deleted documents
            )
        }
            .actionGet();
                new UpdateSettingsRequest(INDEX_NAME).settings(
        assertTrue(indexShard.getTranslogSyncProcessor() instanceof BufferedAsyncIOProcessor);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000l, -1));
        assertBufferInterval(clusterBufferInterval, indexShard);
        ensureGreen();
        testPeerRecovery(randomIntBetween(1, 2), true);
        ensureGreen(INDEX_NAME);
        internalCluster().startNode(settings);
    }
        // switching it back off stops the flushes again. The next successful segments sync discards the accounting
                        .setSource("field", "value-" + round + "-" + randomAlphaOfLength(100))
import java.nio.file.Path;
            INDEX_NAME,
    /**
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        // allow any flush armed before the disarming sync to complete before sampling the steady state
        new Thread(() -> {
            (int) client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value(),
        assertAcked(
            if (randomBoolean()) {
        // starts uploading translog and segments even before the cluster manager has started this shard. With this test,
    }
        // so the retention lease and the async flush pipeline keep advancing.
        latch.await();
        createRepository(shallowSnapshotRepoName, "fs", settings);
        );
        );
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        int numberOfIterations = randomIntBetween(1, 5);
            .execute()
            indexShard.flushStats().getPeriodic()
    /**
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        ensureGreen(INDEX_NAME);
        assertAcked(
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .getSnapshotInfo();
        logger.info("Verify shallow snapshot created after close");
        assertEquals(
        try (Stream<Path> files = Files.list(translogLocation)) {
            .execute()
import org.opensearch.transport.client.Requests;
        });
                new UpdateSettingsRequest(INDEX_NAME).settings(
    // Without the cleanup change in RemoteFsTranslog.createEmptyTranslog, this test fails with NPE.
        });
            indexSingleDoc(INDEX_NAME);
    }
 * SPDX-License-Identifier: Apache-2.0
    private void assertClusterRemoteBufferInterval(TimeValue expectedBufferInterval, String dataNode) {
    protected void delete(Path baseRepoPath, String shardPath) throws IOException {
            latch.countDown();
                )
            METADATA,
        ensureGreen(INDEX_NAME);
        TimeValue bufferInterval = TimeValue.timeValueSeconds(-1);
        // workload below must not produce a periodic flush
        }, 30, TimeUnit.SECONDS);
                client().admin().indices().prepareForceMerge(INDEX_NAME).setOnlyExpungeDeletes(true).setFlush(false).get().getFailedShards()
                long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
import org.opensearch.plugins.Plugin;
        // We validate the same here by failing the peer recovery and ensuring we can index afterward as well.
            TransportService.class,
        // Wait for atleast one doc to be ingested.
        for (int i = 0; i < 5; i++) {
            .cluster()
        indexBulk(INDEX_NAME, 50);
        return BlobPath.cleanPath();
            )
            .get()
        Path absolutePath = randomRepoPath().toAbsolutePath();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        }, 30, TimeUnit.SECONDS);
import org.opensearch.test.OpenSearchIntegTestCase;
        ).buildAsString();
        assertAcked(
        logger.info("Starting up cluster manager with cluster.remote_store.index.restrict.async-durability set to true");
import org.opensearch.index.IndexService;
        );
        ensureGreen(INDEX_NAME);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), "3");
        assertEquals(0, snapshotInfo1.failedShards());
    public void testCloseIndexWithNoOpSyncAndFlushForSyncTranslog() throws InterruptedException {
        new Thread(() -> {
                    + " leases="
                    // With pinned timestamp, we also keep md files since last successful fetch
                } else {
                .build()
        assertEquals(durability, indexShard.indexSettings().getTranslogDurability());
        // Set the index setting (index.remote_store.translog.buffer_interval) with null and validate the buffer interval
            assertEquals(
        client().admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setIndices(INDEX_NAME).setWaitForCompletion(true).get();
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Durability.ASYNC)
        assertNotEquals(newIndexUUID, originalIndexUUID);
            indexSingleDoc(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        internalCluster().restartNode(dataNode);
            .prepareUpdateSettings()
import org.opensearch.common.Priority;
    }
        createIndex(
            client(),
        int moreDocs = randomIntBetween(5, 10);
        assertBufferInterval(bufferInterval, indexShard);
            .setWaitForEvents(Priority.LANGUID)
package org.opensearch.remotestore;
        createIndex(INDEX_NAME);
        String dataNode = internalCluster().startNodes(1).get(0);
        // the threshold is low enough to trip on anything, but the condition is off fleet-wide (its default), so the
    }
            BulkRequestBuilder bulk = client().prepareBulk();
        assertAcked(
import org.opensearch.indices.RemoteStoreSettings;
        indexBulk(INDEX_NAME, 50);
            .get(INDEX_NAME)
                .indices()
        logger.info("--> take a snapshot");
            INDEX_NAME,
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        }
            30,
        logger.info("--> close index");
            .get();
        internalCluster().startNodes(3);
        ensureStableCluster(3);
            }
        );
                // checkpoint for the whole test regardless of commits
                .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "20kb")
        ensureGreen(INDEX_NAME);
            }
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING;
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability)
    }
                .setSettings(
        Settings.Builder settings = Settings.builder()
    public void testFlushOnTooManyRemoteTranslogFiles() throws Exception {
            long committedCheckpoint = Long.parseLong(indexShard.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
            .prepareGetSettings(INDEX_NAME)
        );
                // As delete is async its possible that the file gets created before the deletion or after
            expectedBufferInterval,
    }
import org.opensearch.action.search.SearchPhaseExecutionException;
            .get();
            exceptionDuringCreateIndex.getMessage()
    public void testAsyncDurabilityWhenRestrictSettingExplicitFalse() throws ExecutionException, InterruptedException {
import org.opensearch.test.InternalSettingsPlugin;
    public void testPerIndexFlushOnUncommittedSegmentsThresholdOverridesClusterDefault() throws Exception {
        }
        assertFalse(indexShard.isSearchIdleSupported());
                .put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "0ms")
        String cm1 = internalCluster().startClusterManagerOnlyNode(
        assertEquals(expectedBufferInterval, indicesService.getRemoteStoreSettings().getClusterRemoteTranslogBufferInterval());
            for (int i = 0; i < docCount; i++) {
        assertBufferInterval(IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL, indexShard);
        assertFalse(clusterHealthResponse.isTimedOut());
        client(clusterManagerName).admin()
            .prepareHealth()
            long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
        refresh(INDEX_NAME);
    }
            assertHitCount(client(dataNodes.get(1)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);
                    + indexShard.getRetentionLeases(),
    public void testPeriodicFlushOnUncommittedSegmentBytes() throws Exception {
        IndexResponse response = indexSingleDoc(INDEX_NAME);
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "1b")
    /**
                .cluster()
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
            TimeUnit.SECONDS
        assertAcked(
        ensureGreen(INDEX_NAME);
        assertHitCount(client(oldPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs);
            assertThat(committedCheckpoint, greaterThanOrEqualTo(maxSeqNoAfterWorkload));
        client(clusterManagerName).admin()
    }
    }
                .indices()
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000l, -1));
        assertFalse(indexShard.isSearchIdleSupported());
            .filter(rs -> rs.getRecoverySource().getType() == RecoverySource.Type.PEER)
                .preparePutTemplate("test")
        // 4. Start recovery by changing number of replicas to 1
        );
        ensureGreen(TimeValue.timeValueSeconds(30), INDEX_NAME);
        // gets indexed, then it goes into the happy case where the close index happens succefully.
        assertEquals(oldPrimary, primaryNodeName(INDEX_NAME));
            "at most one flush may land in the gap before the disarming sync, got "
        // dropping the per-index threshold hands the index back to the 1b cluster default
        );
        assertHitCount(
        flushAndRefresh(INDEX_NAME);
            refresh(INDEX_NAME);
                    // Ignore
    }
        flushAndRefresh(INDEX_NAME);
                    Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
        );
                .prepareUpdateSettings()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
                )
        assertBusy(() -> {
        client(clusterManagerName).admin()
            indexSingleDoc(INDEX_NAME);
        );
    public void testStaleCommitDeletionWithMinSegmentFiles_3() throws Exception {
     * operation's periodic flush poll fires the async flush.
    public void testAsyncDurabilityThrowsExceptionWhenRestrictSettingTrue() throws ExecutionException, InterruptedException {
        // close index
            .put(indexSettings())
            );
        IndexShard indexShard = getIndexShard(datanode, INDEX_NAME);
    }
    }
        int docs = randomIntBetween(5, 10);
        assertEquals(0, indexShard.flushStats().getPeriodic());
        assertNotEquals(IndexMetadata.INDEX_UUID_NA_VALUE, newIndexUUID);
        createIndex(INDEX_NAME);
        Settings indexSettings = Settings.builder()
            refresh(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        );
        assertThat(
            SEGMENTS,
            .indices()
        String primaryShardNode = internalCluster().startDataOnlyNodes(1).get(0);
        assertFalse(indexShard.shouldPeriodicallyFlush());
        testPeerRecovery(randomIntBetween(1, 3), false);
                flushAndRefresh(INDEX_NAME);
            .execute()
            .actionGet();
            .buildAsString();
        assertEquals(expectedExceptionMsg, exception.getMessage());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .updateSettings(
        // never drop below the full tombstone pile -- so ANY reclamation proves the chain. Each retry keeps writing
import java.util.concurrent.ExecutionException;
        // Simulating a condition where store is already in use by increasing ref count, this helps in testing index
            refresh(INDEX_NAME);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));
                new UpdateSettingsRequest(INDEX_NAME).settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            });
     * per-index counterpart -- must gate the condition on a live index in both directions.
        client().admin()
        // Disabling max translog readers
            Settings.builder()
            refresh(INDEX_NAME);
            client(),
            "0",
     * Same trigger as {@link #testPeriodicFlushOnUncommittedSegmentBytes()}, but driven purely from the cluster level:
    protected final String INDEX_NAME = "remote-store-test-idx-1";
            .prepareCreateSnapshot(shallowSnapshotRepoName, snapshot1)
        assertEquals(
    }
            .build();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(cm1));
                        .putNull(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey())
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
            .cluster()
                        actualFileCount,
        }
        for (int i = 0; i < 10; i++) {
        }
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), clusterBufferInterval))
        SnapshotInfo snapshotInfo1 = internalCluster().client()
                );
        testRestrictSettingFalse(false, Durability.ASYNC);
        flushDone.await(5, TimeUnit.SECONDS);
        internalCluster().client().admin().cluster().updateSettings(req).get();
        Thread.sleep(1000);
        ensureGreen(INDEX_NAME);
                )
            exception.getMessage()
    }
            try {
        clearClusterBufferIntervalSetting(clusterManagerName);
            .put(indexSettings())
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async"))
                .prepareUpdateSettings(INDEX_NAME)
            assertHitCount(client(dataNodes.get(1)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);
            getSegmentBasePath(),
        logger.info("--> relocate the shard");
        // activated. There was a bug in primary relocation of remote store enabled indexes where the new primary
    }
            indexSingleDoc(INDEX_NAME);
            getSegmentBasePath(),
            .stream()
        flush(INDEX_NAME);
        int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
        }
            client().admin()
    }
     * This tests validation which kicks in during index creation failing creation if the value is less than minimum allowed value.
    public void testRemoteTranslogCleanup() throws Exception {
        refresh(INDEX_NAME);
        // drainSync performed as part of relocation handoff (before performing the handoff transport action).
        // For remote store, it is possible that the refreshes gets triggered and the refreshed segments for last 15 docs are uploaded
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "1b")
            latch.countDown();
        assertEquals(indexStats.get(MAX_SEQ_NO_TOTAL) + 1, response.getSeqNo());
            docs + moreDocs + uncommittedOps
        assertEquals(SnapshotState.SUCCESS, snapshotInfo2.state());
                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "5kb")
        // Will flush and trim the translog readers
        );
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), clusterBufferInterval))
                .preparePutTemplate("test")
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
import static org.hamcrest.Matchers.oneOf;
                    Settings.builder().putNull(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey())
        assertBusy(() -> {
            ((BufferedAsyncIOProcessor<?>) indexShard.getTranslogSyncProcessor()).getBufferIntervalSupplier().get()
            connection.sendRequest(requestId, action, request, options);
                .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1gb")
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
                .actionGet()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
     */
                .admin()
        // In this test, we trigger a force flush on existing primary while the primary mode on new primary has been
        exception = assertThrows(
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
        for (int i = 0; i < 500; i++) {
            refresh(INDEX_NAME);
        // Closing the index involves translog.sync and shard.flush which are now no-op.
