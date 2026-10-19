            refresh(INDEX_NAME);
        ).buildAsString();  
            Settings.builder()  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));  
        assertEquals(indexStats.get(MAX_SEQ_NO_TOTAL) + 1, response.getSeqNo());
            client(),
        ));  
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());  
            IllegalArgumentException.class,
        // overwrite the same document ids round after round; every round turns the previous round's documents into
        // Case 2 - Test update index fails
        ensureStableCluster(2);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
        for (int i = 0; i < 3; i++) {
        client().admin()  
        int lastNMetadataFilesToKeep = indexShard.getRemoteStoreSettings().getMinRemoteSegmentMetadataFiles();
            )
    public void testStaleCommitDeletionWithMinSegmentFiles_3() throws Exception {
        // indexing 100 documents (100 bulk requests), no flush will be triggered yet  
            .cluster()
        internalCluster().startNodes(3);
import org.opensearch.transport.client.Requests;  
            );
            .prepareUpdateSettings()  
            }
                .prepareUpdateSettings()
        }  
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogFlush() throws Exception {
        }, 30, TimeUnit.SECONDS);  
     * Verifies the end-to-end periodic flush trigger on a remote-store shard: with the uncommitted-segment-bytes  
        });
            .setIndices(INDEX_NAME)
    }
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
                    );  
            SEGMENTS,  
                .prepareUpdateSettings()
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));  
                // do not make writes wait on the translog upload batching window  
        flush(INDEX_NAME);  
        assertEquals(0, indexShard.flushStats().getPeriodic());  
            .execute()
            .actionGet();
        // Flush so that the subsequent sync or flushes are no-op.
        // Set the cluster default with a different value, validate that the buffer interval is still the overridden value
            assertEquals(totalFiles, 501L);
            .actionGet();  
                .setPersistentSettings(  
        String dataNode = internalCluster().startDataOnlyNode();  
        );
        assertHitCount(client(oldPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs + moreDocs);  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo1.state());  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));  
        bufferInterval = TimeValue.timeValueSeconds(bufferInterval.seconds() + randomIntBetween(1, 100));
            client().admin()  
        internalCluster().startClusterManagerOnlyNode();  
    }
                new UpdateSettingsRequest(INDEX_NAME).settings(
                for (int i = 0; i < randomIntBetween(1, 5); i++) {  
            .indices()  
import java.util.stream.Stream;
    }
                    + " commitCkpt="
            .cluster()
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "1b")
 * compatible open source license.
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
                .indices()
        // gets indexed, then it goes into the happy case where the close index happens succefully.  
                .get()
        }
            .prepareGetSettings(INDEX_NAME)
        createIndex(
 *
        assertBusy(() -> { assertHitCount(client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get(), 6); });
        String shardPath = getShardLevelBlobPath(
    public void testStaleCommitDeletionWithInvokeFlush() throws Exception {
import org.opensearch.index.IndexService;  
    }
            .findFirst();
        assertAcked(
            Settings.builder()  
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        ensureStableCluster(3);  
        // Next, we change the default buffer interval and the same should reflect in the buffer interval of the index created
            // Index some docs to start the asyn io processor to run which will lead to 10s wait time before the next sync.
        indexShard = getIndexShard(replicaShardNode, INDEX_NAME);  
        internalCluster().startClusterManagerOnlyNode();
                flushDone.countDown();  
                )
            // Reduce the latch for the main thread to flush after some sleep.  
     * End-to-end reproduction of an update-heavy workload with regular refreshes on a remote-store shard, where
    }
        String primaryShardNode = internalCluster().startDataOnlyNodes(1).get(0);
        ensureGreen();
                    Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
            clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000l, -1));
        internalCluster().startClusterManagerOnlyNode();  
        testRestrictSettingFalse(true, Durability.ASYNC);
        // activated. There was a bug in primary relocation of remote store enabled indexes where the new primary
        ensureGreen(INDEX_NAME);
            .indices()  
            .actionGet();  
            .get();
        assertAcked(
            refresh(INDEX_NAME);
    }
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s");
                        .setId(String.valueOf(i))  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));
        indexBulk(INDEX_NAME, 50);
            int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
    public void testRequestDurabilityWhenRestrictSettingImplicitFalse() throws ExecutionException, InterruptedException {
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000l, -1));
    protected BlobPath getSegmentBasePath() {
        clearClusterBufferIntervalSetting(clusterManagerName);
        // never drop below the full tombstone pile -- so ANY reclamation proves the chain. Each retry keeps writing  
        String shardPath = getShardLevelBlobPath(
            refresh(INDEX_NAME);
                new UpdateSettingsRequest(INDEX_NAME).settings(
        assertAcked(
                .setSettings(
    }
            .cluster()
        int moreDocs = randomIntBetween(5, 10);
                    assertTrue(actualFileCount >= lastNMetadataFilesToKeep);
        logger.info("--> Create index and ingest 50 docs");  
import java.io.IOException;  
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);  
            segmentsPathFixedPrefix  
            indexBulk(INDEX_NAME, 15);  
        // dropping the per-index threshold hands the index back to the 1b cluster default  
            getSegmentBasePath(),  
        }, 30, TimeUnit.SECONDS);
        }
                    indexSingleDoc(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
            .get();
import static org.opensearch.index.shard.IndexShardTestCase.getTranslog;  
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
        MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(  
        ex = assertThrows(  
            assertEquals(
        ensureGreen(INDEX_NAME);
        // Closing the index involves translog.sync and shard.flush which are now no-op.
        // 4. Start recovery by changing number of replicas to 1
        final int docCount = 20;
        Settings indexSettings = Settings.builder()  
        // segments_N file is copied to new replica
    // Test local only translog files which are not uploaded to remote store (no metadata present in remote)
            // With pinned timestamp, we also keep md files since last successful fetch  
        flushAndRefresh(INDEX_NAME);
        // close index
        String dataNode = internalCluster().startNodes(1).get(0);
                .setPersistentSettings(  
    }
        assertFalse(indexShard.isSearchIdleSupported());  
        testPeerRecovery(randomIntBetween(1, 3), false);  
            "failed to parse value [-1] for setting [cluster.remote_store.translog.buffer_interval], must be >= [0ms]",
        clusterHealthResponse = client().admin()
            TimeUnit.SECONDS
        );  
                // deletion.
        );
                handOffLatch.countDown();
        // Closing the index involves translog.sync and shard.flush which are now no-op.
        client().admin()  
            .prepareHealth()  
    public void testAsyncDurabilityThrowsExceptionWhenRestrictSettingTrue() throws ExecutionException, InterruptedException {  
        if (RemoteStoreSettings.isPinnedTimestampsEnabled()) {
        for (int i = 0; i < randomIntBetween(1, 3); i++) {
        assertBufferInterval(clusterBufferInterval, indexShard);
            refresh(INDEX_NAME);
            () -> internalCluster().client()  
import org.opensearch.snapshots.SnapshotState;  
                        .setSource("field", "value-" + round + "-" + randomAlphaOfLength(100))
                .admin()
        createRepository("test-repo", "fs", Settings.builder().put("location", absolutePath));
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Durability.ASYNC)  
        SnapshotInfo snapshotInfo2 = internalCluster().client()
        final long tombstonesCreated = (long) (rounds - 1) * docCount;
            client(),  
import java.util.concurrent.ExecutionException;  
            () -> client(clusterManagerName).admin()
        assertAcked(
    }  
            .build();  
     * This tests validation of the cluster setting when being set.
        assertBusy(() -> {
    public void testClusterBufferIntervalValidation() {
package org.opensearch.remotestore;
        }  
    public void testPeerRecoveryWithLowActivityTimeout() throws Exception {  
                .prepareUpdateSettings()  
import org.opensearch.common.Priority;
    }
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
    @Override  
                )
        createIndex(  
                    Settings.builder().putNull(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey())  
                .setPersistentSettings(  
                new UpdateSettingsRequest(INDEX_NAME).settings(
        indexBulk(INDEX_NAME, 50);
     */  
                    + " leases="
import java.nio.file.Files;
        String expectedExceptionMsg =
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
            METADATA,
     * {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size} after the index already exists must
            .prepareReroute()
        String indexUUID = client().admin()
                }
            .get();
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().client().admin().cluster().updateSettings(req).get();  
            indexShard.flushStats().getPeriodic()
            translogPathFixedPrefix
        assertBusy(() -> {  
        ensureGreen(INDEX_NAME);
                    Files.delete(p);
            segmentsPathFixedPrefix
        for (int i = 0; i < 3; i++) {
        String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
        testRestrictSettingFalse(false, Durability.ASYNC);  
import java.util.Map;  
        MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(
    }
        final String snapshot2 = "snapshot2";  
        logger.info("--> wipe all indices");  
                // any segment with at least one reclaimable delete qualifies for the expunge-deletes merge below,
    }
        internalCluster().startClusterManagerOnlyNode();  
    }
            .setTransientSettings(
    }  
     */
        assertFalse(clusterHealthResponse.isTimedOut());
    private void clearClusterBufferIntervalSetting(String clusterManagerName) {  
    public void testOverriddenBufferInterval() throws ExecutionException, InterruptedException {
            .get()
        String replicaShardNode = internalCluster().startDataOnlyNodes(1).get(0);
     */  
            client().admin()  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability)  
            is(oneOf(searchableDocs + 15, searchableDocs + 30))  
        ensureGreen(INDEX_NAME);
    }
        CountDownLatch flushLatch = new CountDownLatch(1);
            METADATA,
    public void testResumeUploadAfterFailedPrimaryRelocation() throws ExecutionException, InterruptedException, IOException {
        }, 30, TimeUnit.SECONDS);
        refresh(INDEX_NAME);  
                .put(RecoverySettings.INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING.getKey(), "1s")
        assertBusy(() -> {
            Settings.builder()
        internalCluster().restartNode(dataNode);  
                .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), "1gb")  
            "0",
import org.opensearch.action.admin.indices.flush.FlushRequest;  
                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "1b")
    }
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));  
    }  
            );  
        assertEquals(0, snapshotInfo1.failedShards());
        MatcherAssert.assertThat(
     */  
 * SPDX-License-Identifier: Apache-2.0
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        assertBusy(
        // Will flush and trim the translog readers  
    public void testCloseIndexWithNoOpSyncAndFlushForAsyncTranslog() throws InterruptedException {
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);  
        client().admin()  
                );
            INDEX_NAME,
            long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
        new Thread(() -> {
        logger.info("--> close index");
                )  
        Path indexPath = Path.of(segmentRepoPath + "/" + shardPath);
            "0",
        }  
            .cluster()
            .actionGet();
import org.opensearch.test.transport.MockTransportService;
                )
            .put(indexSettings())  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
    public void testFlushOnTooManyRemoteTranslogFiles() throws Exception {
        // 2. Index docs  
    }  
        String replicaNodeName = replicaNodeName(INDEX_NAME);
            .prepareUpdateSettings()
            connection.sendRequest(requestId, action, request, options);
        }, 30, TimeUnit.SECONDS);
        enableFlushOnUncommittedSegments();  
        indexBulk(INDEX_NAME, 15);
        final String snapshot1 = "snapshot1";
                oldPrimaryIndexShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
                MatcherAssert.assertThat(actualFileCount, is(oneOf(numberOfIterations - 1, numberOfIterations, numberOfIterations + 1)));
        assertNotNull(newIndexUUID);  
        client(clusterManagerName).admin()
            .cluster()
import static org.hamcrest.Matchers.oneOf;
        }  
        assertBusy(() -> {
        flushAndRefresh(INDEX_NAME);
        }
                        actualFileCount,
            SEGMENTS,
            .execute()
        internalCluster().startClusterManagerOnlyNode();  
        ensureGreen(INDEX_NAME);
        );
        assertEquals(0, indexShard.flushStats().getPeriodic());
            indexSingleDoc(INDEX_NAME);
        // the whole workload (the flush is async, so a single trip is not enough on its own)
     * Tests that when the index setting is not passed during index creation, the buffer interval picked up is the cluster
        indexData(5, randomBoolean(), INDEX_NAME);
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();  
            .put(indexSettings())
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
        );
        String shardPath = getShardLevelBlobPath(
            .prepareUpdateSettings()  
                deletedDocs,
                .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), "0ms")
        ensureGreen(INDEX_NAME);
        createIndex(
            exceptionDuringCreateIndex.getMessage()  
            .setWaitForCompletion(true)
    private void verifyRemoteStoreCleanup() throws Exception {  
        String datanode = internalCluster().startDataOnlyNodes(1).get(0);  
import org.opensearch.index.seqno.SequenceNumbers;
                // newPrimaryTranslogRepo.setSleepSeconds(0);  
            INDEX_NAME,
        internalCluster().startNodes(3);  
        assertEquals(expectedBufferInterval, indicesService.getRemoteStoreSettings().getClusterRemoteTranslogBufferInterval());
        } else {
            docs + moreDocs + uncommittedOps
        testRestrictSettingFalse(false, Durability.REQUEST);
            .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
import org.opensearch.OpenSearchException;
        final long maxSeqNoAfterWorkload = indexShard.seqNoStats().getMaxSeqNo();
            IllegalArgumentException.class,
        Thread.sleep(10000);  
            .execute()
        clearClusterBufferIntervalSetting(clusterManagerName);
        // republishes it and the count must hold steady however much more the workload writes and refreshes.
        assertAcked(
    // Without the cleanup change in RemoteFsTranslog.createEmptyTranslog, this test fails with NPE.  
    }
                .setPersistentSettings(Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "-1"))
                .prepareUpdateSettings()
            .actionGet();  
        assertTrue(indexShard.getTranslogSyncProcessor() instanceof BufferedAsyncIOProcessor);
        assertFalse(clusterHealthResponse.isTimedOut());
    }  
                long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
        for (int i = 0; i < 10; i++) {
    public void testNoMultipleWriterDuringPrimaryRelocation() throws ExecutionException, InterruptedException {  
            )
                // workload below the global checkpoint no matter how far the safe commit advances  
        String cm1 = internalCluster().startClusterManagerOnlyNode(
    public void testRemoteStoreIndexCreationAndDeletionWithReferencedStore() throws InterruptedException, ExecutionException {
        String dataNode = internalCluster().startDataOnlyNode();
            .indices()
            .put(indexSettings())
            refresh(INDEX_NAME);
    /**
        String newPrimary = internalCluster().startDataOnlyNodes(1).get(0);  
            TimeUnit.SECONDS
        ensureGreen(INDEX_NAME);
            } else {
            "0",  
        String shardPath = getShardLevelBlobPath(  
        verifyRemoteStoreCleanup();
            long committedCheckpoint = Long.parseLong(indexShard.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            client().prepareIndex(INDEX_NAME).setId("nudge-" + nudge.incrementAndGet()).setSource("field", "x").get();
        flushAndRefresh(INDEX_NAME);  
     */
            latch.countDown();
                Settings.builder().put(CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), randomIntBetween(2, 4))
            .cluster()
    protected final String INDEX_NAME = "remote-store-test-idx-1";
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
                // refreshes are driven manually by the workload below
            .get();
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), clusterBufferInterval))
        TimeValue bufferInterval = TimeValue.timeValueSeconds(-1);
            SearchPhaseExecutionException.class,
        MatcherAssert.assertThat(actualFileCount, is(oneOf(numberOfIterations - 1, numberOfIterations, numberOfIterations + 1)));
            if (PeerRecoveryTargetService.Actions.HANDOFF_PRIMARY_CONTEXT.equals(action)) {
    /**
                flushLatch.await(2, TimeUnit.SECONDS);
            .get()
        ensureGreen(INDEX_NAME);  
import org.opensearch.index.IndexSettings;
                    Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)  
import org.opensearch.common.unit.TimeValue;
        );
        client().admin().indices().close(Requests.closeIndexRequest(INDEX_NAME)).actionGet();  
        assertEquals("all shards failed", ex.getMessage());
                // pin the (suppressed anyway) translog condition high so any observed periodic flush is attributable
                flushAndRefresh(INDEX_NAME);  
        }, 30, TimeUnit.SECONDS);  
            getSegmentBasePath(),
        testRestrictSettingFalse(true, Durability.REQUEST);  
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
            refresh(INDEX_NAME);
            );
        Path segmentDataPath = Path.of(baseRepoPath + "/" + shardPath);  
        assertBufferInterval(bufferInterval, indexShard);  
            periodicWhileDisabled,  
        indexBulk(INDEX_NAME, docs);
            .admin()  
        internalCluster().startClusterManagerOnlyNode(  
        CountDownLatch latch = new CountDownLatch(1);  
    public void testStaleCommitDeletionWithMinSegmentFiles_Disabled() throws Exception {
            docs + moreDocs + uncommittedOps
                flushLatch.countDown();  
            .setTransientSettings(
            clusterManagerName = internalCluster().startClusterManagerOnlyNode(  
            () -> assertHitCount(client(replicaNodeName).prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),  
        assertEquals(0, indexShard.flushStats().getPeriodic());
            indexSingleDoc(INDEX_NAME);  
            Settings.builder()  
                .build()
        indexBulk(INDEX_NAME, 1);
                .setPatterns(Arrays.asList("test*"))
        assertHitCount(client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get(), searchableDocs);  
                .indices()
            .get();
        assertEquals(
        assertThat(
            .cluster()  
        // starts uploading translog and segments even before the cluster manager has started this shard. With this test,  
        }, 30, TimeUnit.SECONDS);  
                    MatcherAssert.assertThat(  
        assertNotEquals(newIndexUUID, originalIndexUUID);
            exception.getMessage()  
            indexSingleDoc(INDEX_NAME);
            long deletedDocs = client().admin().indices().prepareStats(INDEX_NAME).get().getPrimaries().getDocs().getDeleted();  
        handOffLatch.await(30, TimeUnit.SECONDS);
        int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
        Settings.Builder settings = Settings.builder()  
        try (Stream<Path> files = Files.list(translogLocation)) {  
            .prepareHealth()  
        );
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        new Thread(() -> {
            if (PeerRecoveryTargetService.Actions.HANDOFF_PRIMARY_CONTEXT.equals(action)) {
            () -> client(clusterManagerName).admin()
        IllegalArgumentException exception = assertThrows(  
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
            .setWaitForNoRelocatingShards(true)  
        testPeerRecovery(randomIntBetween(1, 3), true);
        );  
        // We also allow (numberOfIterations + 1) as index creation also triggers refresh.  
import static org.hamcrest.Matchers.lessThan;  
        IllegalArgumentException exceptionDuringCreateIndex = assertThrows(  
     */  
        logger.info("--> restore all indices from the snapshot");
            30,
            assertHitCount(client(dataNodes.get(1)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);
                    Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(-1))  
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME, indexSettings));
            .setWaitForEvents(Priority.LANGUID)
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        // Delete is async.  
        client(clusterManagerName).admin()
import java.util.Collection;
        });  
        Path shallowSnapshotRepoPath = randomRepoPath();
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);  
     * default.
                // the random index template may set retention.operations up to 1000 which would retain the whole
        }  
            .indices()
    public void testFallbackToNodeToNodeSegmentCopy() throws Exception {
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            // Reduce the latch for the main thread to flush after some sleep.
            .setWaitForCompletion(true)  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), "-1");
            SEGMENTS,
 * The OpenSearch Contributors require contributions made to  
            .get(INDEX_NAME)
                    + indexShard.getLastSyncedGlobalCheckpoint()
        }
            .execute()
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);  
        latch.await();
            INDEX_NAME,  
            try {  
        }).start();
        return getFileCount(indexPath);  
    }
            client().admin()
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);  
        try (Stream<Path> files = Files.list(translogLocation)) {
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureGreen(INDEX_NAME);
            "index setting [index.translog.durability=async] is not allowed as cluster setting [cluster.remote_store.index.restrict.async-durability=true]";
            }
                try {  
                Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), false).build()
            INDEX_NAME,
            .cluster()
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogRefresh() throws Exception {
                .put("index.merge.policy.expunge_deletes_allowed", "0.0")
     * This tests multiple cases where the index setting is passed during the index creation with multiple combinations
        // successful upload, so nudge with write+refresh cycles until the flushes have carried the safe commit past  
        assertThrows(
import org.opensearch.test.InternalTestCluster;
            .updateSettings(
        assertAcked(  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                .cluster()
        int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);
                    Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability)
        client(clusterManagerName).admin()
    public void testPeriodicFlushOnUncommittedSegmentBytes() throws Exception {
            TransportService.class,
        ensureStableCluster(3);
    }
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));
        internalCluster().startClusterManagerOnlyNode();
                // to the uncommitted-segment-bytes condition only
            getSegmentBasePath(),
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        testPeerRecovery(randomIntBetween(1, 2), true);  
            ((BufferedAsyncIOProcessor<?>) indexShard.getTranslogSyncProcessor()).getBufferIntervalSupplier().get()
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        // We validate the same here by failing the peer recovery and ensuring we can index afterward as well.
            indexBulk(INDEX_NAME, 1);
        ).buildAsString();
                bulk.add(
            client().admin()
import java.util.concurrent.atomic.AtomicInteger;
            .prepareReroute()
        RecoveryResponse recoveryResponse = client(replicaNodeName).admin().indices().prepareRecoveries().get();
        client(clusterManagerName).admin()
        );
            .cluster()
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
        IndexShard oldPrimaryIndexShard = getIndexShard(oldPrimary, INDEX_NAME);
                .admin()
        String oldPrimary = internalCluster().startDataOnlyNodes(1).get(0);
                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "1gb")
        flushAndRefresh(INDEX_NAME);  
        client().admin()
            30,  
            .setWaitForEvents(Priority.LANGUID)
import org.opensearch.cluster.routing.RecoverySource;
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        // 1. Create index with 0 replica
        internalCluster().startDataOnlyNode();  
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))  
            assertTrue(actualFileCount >= 4);
        // drainSync performed as part of relocation handoff (before performing the handoff transport action).  
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));  
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
        // which will be the cluster default now.
        assertNotEquals(IndexMetadata.INDEX_UUID_NA_VALUE, newIndexUUID);
        indexBulk(INDEX_NAME, moreDocs);
            .setWaitForCompletion(true)
                throw new OpenSearchException("failing recovery for test purposes");  
        indexShard.store().incRef();
        CountDownLatch handOffLatch = new CountDownLatch(1);  
        internalCluster().startNodes(3);
                .cluster()  
            .get()
    /**
                // this is fine
        createIndex(INDEX_NAME, settings.build());
            assertFalse(bulk.get().hasFailures());
            indexSingleDoc(INDEX_NAME);  
            () -> createIndex(INDEX_NAME, indexSettings)
            TRANSLOG,  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9327")  
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogNoDataRefresh() throws Exception {
                throw new AssertionError(e);
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            segmentsPathFixedPrefix
        ClusterUpdateSettingsRequest req = new ClusterUpdateSettingsRequest().persistentSettings(
            .indices()  
            .build();
        final int rounds = 8;  
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s")
                )
        indexShard.store().decRef();
                .cluster()
            }
            indexSingleDoc(INDEX_NAME);  
    public void testPerIndexFlushOnUncommittedSegmentsThresholdOverridesClusterDefault() throws Exception {
        for (int i = 0; i < 500; i++) {  
    private void enableFlushOnUncommittedSegments() {  
        // soft-deleted tombstones, and the refresh drives a remote segments upload  
                .get()  
            refresh(INDEX_NAME);  
     * threshold lowered to 1b, a refresh-driven segments upload publishes the accounting and the next write
        assertBufferInterval(clusterBufferInterval, indexShard);  
        createIndex(INDEX_NAME, indexSettings);  
        // 2. Index docs  
            indexSingleDoc(INDEX_NAME);
        // deletion when refresh is in-progress.
                .put(RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS.getKey(), "100")
            .execute()
            .cluster()
        flushAndRefresh(INDEX_NAME);
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(shallowSnapshotRepoName, snapshot2)  
                    // With pinned timestamp, we also keep md files since last successful fetch  
    public void testLocalOnlyTranslogCleanupOnNodeRestart() throws Exception {
        // Set the index setting (index.remote_store.translog.buffer_interval) with a different value and validate that
    public void testSuccessfulShallowV1SnapshotPostIndexClose() throws Exception {
        updateSettingsRequest.persistentSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "0ms"));
            .setTimeout(TimeValue.timeValueSeconds(10))
        ).buildAsString();
            .indices()
        } else {  
        Settings.Builder settings = Settings.builder()  
            internalCluster().client()  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                .get()  
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING;
     * This tests validation which kicks in during index creation failing creation if the value is less than minimum allowed value.  
            .getSnapshotInfo();  
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
            "no further periodic flush once the accounting has been discarded",
    public void testRequestDurabilityWhenRestrictSettingExplicitFalse() throws ExecutionException, InterruptedException {
            .put(RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), "3");  
        ensureGreen(INDEX_NAME);
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), clusterBufferInterval))
                    + " gcp="  
        final long periodicWhileDisabled = indexShard.flushStats().getPeriodic();  
            client(newNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(),  
        assertFalse(indexShard.shouldPeriodicallyFlush());
            .setWaitForNoRelocatingShards(true)  
        assertTrue(indexShard.getTranslogSyncProcessor() instanceof BufferedAsyncIOProcessor);
        );
            )
        assertBufferInterval(bufferInterval, indexShard);
            assertHitCount(client(dataNodes.get(1)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
        MatcherAssert.assertThat(actualFileCount, is(oneOf(numberOfIterations, numberOfIterations + 1)));
            .actionGet();
        internalCluster().startNode(settings);
            .prepareReroute()
     * take effect on it, and {@code cluster.remote_store.flush_on_uncommitted_segments.enabled} -- which has no
import org.opensearch.common.blobstore.BlobPath;
    }  
        createIndex(INDEX_NAME);
    protected int getActualFileCount(Path segmentRepoPath, String shardPath) throws IOException {
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    Settings.builder()  
        assertAcked(
            } catch (Exception e) {}
        String originalIndexUUID = client().admin()
            getSegmentBasePath(),
        assertEquals(
        createIndex(INDEX_NAME);
                assertEquals(totalFiles, 1L);  
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
        exception = assertThrows(
        // try restoring the snapshot
        mockTargetTransportService.addSendBehavior((connection, requestId, action, request, options) -> {  
        IndexShard oldPrimaryIndexShard = getIndexShard(oldPrimary, INDEX_NAME);  
            indexSingleDoc(INDEX_NAME);  
        ensureStableCluster(3);
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode(  
        logger.info("--> relocate the shard");
        // the threshold is low enough to trip on anything, but the condition is off fleet-wide (its default), so the  
            client().admin()  
            () -> client(newPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get()  
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        client().admin()  
            refresh(INDEX_NAME);  
        Settings indexSettings = Settings.builder()
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
    }
            try {  
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));
            assertThat(indexShard.flushStats().getPeriodic(), greaterThan(0L));  
        // published while it was on, so a flush can only still land in the gap before that sync; after that nothing  
        client(clusterManagerName).admin()
                .prepareUpdateSettings(INDEX_NAME)
    }  
        );  
        try (Stream<Path> files = Files.list(segmentDataPath)) {
            INDEX_NAME,
        flush(INDEX_NAME);  
    public Settings indexSettings() {
        );  
        }
        Path absolutePath = randomRepoPath().toAbsolutePath();  
     * Turns on {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}, which is disabled by default and has  
            .updateSettings(
            .setWaitForEvents(Priority.LANGUID)
                Settings.builder().put(CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING.getKey(), randomIntBetween(2, 4))  
            Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), false).build()
        });
     * periodic flushes fire, the safe commit advances past the workload, and a non-flushing expunge-deletes merge
     */
            METADATA,  
                + (periodicWhileDisabled - periodicAfterDisable)  
            "0",  
        for (int i = 0; i < 10; i++) {
            long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();  
        assertBusy(() -> {
            assertEquals(totalFiles, 101L);
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
            indexBulk(INDEX_NAME, 1);  
        internalCluster().startDataOnlyNode();
    }
            Settings.builder()
        assertEquals(1, recoverySource.get().getIndex().recoveredFileCount());
        ClusterHealthResponse clusterHealthResponse = client().admin()
                        .putNull(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey())
            .cluster()
     * pins its own threshold well above what the workload can reach must not flush, and dropping the per-index value
            INDEX_NAME,
import org.opensearch.indices.recovery.PeerRecoveryTargetService;  
            client(newPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(),  
        assertBusy(() -> {
            .get();
            INDEX_NAME,
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Durability.ASYNC)
        assertBusy(() -> {
        assertEquals(oldPrimary, primaryNodeName(INDEX_NAME));
        );
        );  
        // No node settings and async durability
        internalCluster().startClusterManagerOnlyNode();
            (int) client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value(),
                } catch (IOException e) {
                .prepareUpdateSettings()
        return remoteStoreIndexSettings(0);
        // enabling it on the live index -- with no per-index setting anywhere -- arms the condition
            assertHitCount(client(dataNodes.get(0)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        indexBulk(INDEX_NAME, 15);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            INDEX_NAME,  
                .setPersistentSettings(
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "10s");
    }
            .setTimeout(TimeValue.timeValueSeconds(5))
        // 3. Delete data from remote segment store
public class RemoteStoreCoreTestCase extends RemoteStoreBaseIntegTestCase {
            try (Stream<Path> files = Files.list(translogLocation)) {
        IndexShard indexShard = getIndexShard(primaryShardNode, INDEX_NAME);
            }
                // let the primary's own peer-recovery retention lease follow the global checkpoint at test speed;
            () -> client(newPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get()
        logger.info("Starting up cluster manager with cluster.remote_store.index.restrict.async-durability set to true");
    }  
            connection.sendRequest(requestId, action, request, options);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));
        // For remote store, it is possible that the refreshes gets triggered and the refreshed segments for last 15 docs are uploaded  
     * is able to reclaim the tombstones.
                new UpdateSettingsRequest(INDEX_NAME).settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
        ensureGreen(INDEX_NAME);
            .getSetting(INDEX_NAME, IndexMetadata.SETTING_INDEX_UUID);  
            .stream()  
            assertEquals(totalFiles, 1L);  
        // the buffer interval is updated  
        // check that there are no duplicate metadata files for translog or upload.
        String clusterManagerName = internalCluster().getClusterManagerName();  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000L, -1));  
        internalCluster().startClusterManagerOnlyNode();
        // workload below must not produce a periodic flush
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .actionGet();
                }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        ensureGreen(INDEX_NAME);
        String newNode = internalCluster().startDataOnlyNodes(1).get(0);
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "1s")  
            }
                    + indexShard.getRetentionLeases(),  
        }
     * every successful segments upload suppresses the translog based flush condition and soft-deleted documents
                .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
    }  
        );
            .updateSettings(  
        // In this test, we fail the hand off during the primary relocation. This will undo the drainRefreshes and
import org.opensearch.test.InternalSettingsPlugin;
            .indices()  
        indexBulk(INDEX_NAME, randomIntBetween(5, 10));
                .preparePutTemplate("test")  
            .put("location", shallowSnapshotRepoPath)
        assertEquals("all shards failed", ex.getMessage());
            indexSingleDoc(INDEX_NAME);
     */  
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
        // We also allow (numberOfIterations + 1) as index creation also triggers refresh.  
    public void testRemoteTranslogCleanup() throws Exception {
            // Index another doc and in this case the flush would have happened before the sync.  
            SEGMENTS,
        for (int i = 0; i < 5; i++) {
import org.opensearch.index.shard.IndexShard;  
        internalCluster().startClusterManagerOnlyNode();
            .prepareUpdateSettings(INDEX_NAME)  
        String shardPath = getShardLevelBlobPath(client(), INDEX_NAME, getSegmentBasePath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix)  
    public void testStaleCommitDeletionWithoutInvokeFlush() throws Exception {  
import org.hamcrest.MatcherAssert;
    private void assertBufferInterval(TimeValue expectedBufferInterval, IndexShard indexShard) {
        // Simulating a condition where store is already in use by increasing ref count, this helps in testing index  
        assertHitCount(
            .execute()
                .build()  
            client(),  
import java.util.stream.Collectors;  
import org.opensearch.index.translog.Translog;
        assertEquals(
     * An explicit per-index threshold overrides the cluster default: with the cluster threshold at 1b, an index which  
                .prepareUpdateSettings(INDEX_NAME)
        // Wait for atleast one doc to be ingested.  
        }
        }
                .indices()
        flushThread.start();  
            )
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            refresh(INDEX_NAME);
        indexBulk(INDEX_NAME, uncommittedOps);
            // Index single doc to start the asyn io processor to run which will lead to 10s wait time before the next sync.
            if (randomBoolean()) {
            .collect(Collectors.toList());  
        int uncommittedOps = randomIntBetween(5, 10);
        }).start();
            }
            .get();
            SearchPhaseExecutionException.class,
            .filter(rs -> rs.getRecoverySource().getType() == RecoverySource.Type.PEER)
        delete(segmentRepoPath, shardPath);
            } catch (IndexShardClosedException e) {
            latch.countDown();
        Settings indexSettings = Settings.builder()
        // No flush is triggered since max_translog_readers is set to -1
            assertThat(committedCheckpoint, greaterThanOrEqualTo(maxSeqNoAfterWorkload));
        flushAndRefresh(INDEX_NAME);  
        if (setRestrictFalse) {
        internalCluster().startNodes(3);
        );
    public void testAsyncTranslogDurabilityRestrictionsThroughIdxTemplates() throws Exception {  
import java.util.concurrent.TimeUnit;
        );
    protected void delete(Path baseRepoPath, String shardPath) throws IOException {
        assertTrue(oldPrimaryIndexShard.isStartedPrimary());  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
            IllegalArgumentException.class,
        String clusterManagerName;
                } else {
        client().admin().indices().prepareClose(INDEX_NAME).get();
                .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "0ms")
        // Total tlog files would be incremented by 500
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
        logger.info("--> relocate the shard");
                .put(remoteStoreIndexSettings(0))  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
            .get()  
import org.opensearch.transport.TransportService;
        client().admin()  
                .put("index.refresh_interval", "-1")
     * with and without cluster default.  
            indexSingleDoc(INDEX_NAME);  
        Thread.sleep(10000);  
            indexSingleDoc(INDEX_NAME);
                .setTransientSettings(
        assertTrue(snapshotInfo2.successfulShards() > 0);  
        CountDownLatch latch = new CountDownLatch(1);  
        flushAndRefresh(INDEX_NAME);  
                )
import java.util.List;
        assertEquals(expectedExceptionMsg, exception.getMessage());
            .prepareUpdateSettings()  
        String newIndexUUID = client().admin()
            .prepareCreateSnapshot(shallowSnapshotRepoName, snapshot1)  
            client(),
        refresh(INDEX_NAME);  
        latch.await();
            .setWaitForStatus(ClusterHealthStatus.GREEN)
        ClusterHealthResponse clusterHealthResponse = client().admin()
                )
    }
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));  
import static org.hamcrest.Matchers.is;
        int docs = randomIntBetween(5, 10);
        ensureGreen(INDEX_NAME);
        // Explicit node settings and request durability
            indexBulk(INDEX_NAME, 1);
        assertFalse(indexShard.isSearchIdleSupported());
            IllegalArgumentException.class,  
        // switching it back off stops the flushes again. The next successful segments sync discards the accounting
import org.opensearch.common.util.concurrent.BufferedAsyncIOProcessor;
        // delete the index  
        cluster().wipeIndices(INDEX_NAME);
        Settings.Builder settings = Settings.builder()
        assertEquals(Durability.REQUEST, indexShard.indexSettings().getTranslogDurability());
    public void testDefaultBufferInterval() throws ExecutionException, InterruptedException {
        indexData(numberOfIterations, false, INDEX_NAME);  
            .buildAsString();
import org.opensearch.action.search.SearchPhaseExecutionException;
        final AtomicInteger nudge = new AtomicInteger();  
import org.opensearch.cluster.metadata.IndexMetadata;
            assertHitCount(client(dataNodes.get(0)).prepareSearch(INDEX_NAME).setSize(0).get(), 50);  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;  
            searchableDocs += 15;
        assertEquals(0, indexShard.flushStats().getPeriodic());
        }  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo2.state());
        ensureGreen(INDEX_NAME);
            .cluster()
        );
                client().admin().indices().prepareForceMerge(INDEX_NAME).setOnlyExpungeDeletes(true).setFlush(false).get().getFailedShards()  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))  
    }  
        int actualFileCount = getActualFileCount(segmentRepoPath, shardPath);  
        cluster().wipeIndices(INDEX_NAME);
            .admin()
        // Case 1 - Test create index fails
            .getSnapshotInfo();
                .updateSettings(new UpdateSettingsRequest(INDEX_NAME).settings(indexSettings))  
    private void testPeerRecovery(int numberOfIterations, boolean invokeFlush) throws Exception {
        enableFlushOnUncommittedSegments();
        assertFalse(clusterHealthResponse.isTimedOut());
            indexSingleDoc(INDEX_NAME);
            .build();
        logger.info("--> take a snapshot");  
        TimeValue bufferInterval = TimeValue.timeValueSeconds(randomIntBetween(0, 100));
                .setPersistentSettings(
        // We also allow (numberOfIterations + 1) as index creation also triggers refresh.
            )  
                .indices()
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));  
        Path indexPath = Path.of(String.valueOf(segmentRepoPath), indexUUID);
                "deleted="
            assertEquals(4, actualFileCount);  
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
    }
        }, 30, TimeUnit.SECONDS);  
                )
                .prepareUpdateSettings(INDEX_NAME)  
        String dataNode = internalCluster().startNodes(1).get(0);
        MatcherAssert.assertThat(
        assertBufferInterval(IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL, indexShard);  
            client().admin()
        indexSingleDoc(INDEX_NAME);  
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async"))
        indexData(numberOfIterations, true, INDEX_NAME);
    }
                // As delete is async its possible that the file gets created before the deletion or after  
        ensureStableCluster(2);
        refresh(INDEX_NAME);  
        );
        logger.info("Starting up another cluster manager with cluster.remote_store.index.restrict.async-durability set to false");
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)  
        restore(true, INDEX_NAME);  
            } catch (InterruptedException e) {  
            assertThat(
        int numberOfIterations = randomIntBetween(1, 5);
        // 1. Create index with 0 replica
        // Indexing 500 more docs
    }
import org.opensearch.action.bulk.BulkRequestBuilder;  
        indexSingleDoc(INDEX_NAME);  
    private void testRestrictSettingFalse(boolean setRestrictFalse, Durability durability) throws ExecutionException, InterruptedException {  
        updateSettingsRequest.persistentSettings(
        assertNotNull(originalIndexUUID);
            refresh(INDEX_NAME);
        );
        CountDownLatch flushDone = new CountDownLatch(1);
        assertHitCount(client(oldPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs);
    }
                0,
                .actionGet()
import static org.hamcrest.Matchers.comparesEqualTo;
        createIndex(INDEX_NAME, settings.build());
            TransportService.class,  
    }  
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);  
        assertBusy(() -> {
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);  
        String newPrimary = internalCluster().startDataOnlyNodes(1).get(0);
        ensureGreen(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();  
            is(oneOf(searchableDocs, searchableDocs + 15))  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 10000l, -1));  
                .cluster()
        Path translogLocation = getTranslog(indexShard).location();
        SearchPhaseExecutionException ex = assertThrows(
     * pile up unreclaimed. Asserts the full recovery chain through the uncommitted-segment-bytes condition:  
        String dataNode = internalCluster().startDataOnlyNodes(1).get(0);
import org.opensearch.action.index.IndexResponse;
            prepareCreate(INDEX_NAME).setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1))
        );  
                .setPatterns(Arrays.asList("test*"))
import org.opensearch.indices.recovery.RecoverySettings;
        createRepository(shallowSnapshotRepoName, "fs", settings);  
        logger.info("--> Create index with the same name, different UUID");  
            .updateSettings(
        indexSingleDoc(INDEX_NAME);  
            expectedBufferInterval,
            periodicWhileDisabled,
            } finally {
                .cluster()  
     * hands it back to the cluster default.
            METADATA,
        ensureGreen(INDEX_NAME);
            "at most one flush may land in the gap before the disarming sync, got "
    }  
    }
import java.util.Arrays;  
    /**
            client(),
    private void assertClusterRemoteBufferInterval(TimeValue expectedBufferInterval, String dataNode) {  
            .actionGet();  
        // Explicit node settings and async durability
        ensureGreen(INDEX_NAME);
        for (int round = 0; round < rounds; round++) {
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false)
        );  
        assertBusy(() -> {
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);
        client(clusterManagerName).admin()
        flushDone.await(5, TimeUnit.SECONDS);
        );  
        // Set the index setting (index.remote_store.translog.buffer_interval) with null and validate the buffer interval  
            .get();
import org.opensearch.indices.recovery.RecoveryState;
    /**  
     * no per-index counterpart, so the condition cannot be armed through index settings.
        ensureGreen(INDEX_NAME);
        );  
        assertTrue(snapshotInfo1.successfulShards() > 0);
            .put(remoteStoreIndexSettings(0, 10000L, -1))
 */  
        ).buildAsString();
        // No node settings and request durability  
            .get()
        internalCluster().startNode(settings);
        );
        mockTargetTransportService.addSendBehavior((connection, requestId, action, request, options) -> {
        });
    public void testAsyncDurabilityWhenRestrictSettingImplicitFalse() throws ExecutionException, InterruptedException {
            });
            .prepareCreateSnapshot(shallowSnapshotRepoName, snapshot2)
        logger.info("Create shallow snapshot setting enabled repo");  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class))
            .get();  
            client().admin()  
        createIndex(INDEX_NAME, indexSettings);
import org.opensearch.common.settings.Settings;  
        client().admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setIndices(INDEX_NAME).setWaitForCompletion(true).get();
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);  
                lessThan(tombstonesCreated)
import org.opensearch.index.shard.IndexShardClosedException;
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                .cluster()
    }
                // otherwise the renewal gate (half the 12h lease period) keeps retention pinned at the initial  
        ensureGreen(TimeValue.timeValueSeconds(30), INDEX_NAME);
    /**
        });  
            .setWaitForStatus(ClusterHealthStatus.GREEN)
            .add(new MoveAllocationCommand(INDEX_NAME, 0, newPrimary, newNode))  
import org.opensearch.indices.IndicesService;
            indexSingleDoc(INDEX_NAME);
            .prepareGetSettings(INDEX_NAME)
        SnapshotInfo snapshotInfo1 = internalCluster().client()  
        indexData(numberOfIterations, true, INDEX_NAME);
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(cm1));  
            indexSingleDoc(INDEX_NAME);
        try (Stream<Path> files = Files.list(translogLocation)) {
            .cluster()
            .get();
        assertEquals(durability, indexShard.indexSettings().getTranslogDurability());  
        }  
            .setTimeout(TimeValue.timeValueSeconds(5))
        IndexResponse response = indexSingleDoc(INDEX_NAME);
        // Disabling max translog readers
        assertEquals(durability, indexShard.indexSettings().getTranslogDurability());
            indexBulk(INDEX_NAME, 1);
        indexData(numberOfIterations, true, INDEX_NAME);  
            indexSingleDoc(INDEX_NAME);
    @Override  
                .put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "0ms")
            .prepareUpdateSettings()  
        // allow any flush armed before the disarming sync to complete before sampling the steady state
            if (numberOfIterations <= lastNMetadataFilesToKeep) {  
        assertBusy(
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1));
                    + indexShard.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)
    /**
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
        );
        TimeValue clusterBufferInterval = TimeValue.timeValueSeconds(randomIntBetween(100, 200));  
        testPeerRecovery(1, true);
        int searchableDocs = 0;
                    + deletedDocs  
        ensureGreen(INDEX_NAME);
            getSegmentBasePath(),
            segmentsPathFixedPrefix  
        assertClusterRemoteBufferInterval(IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL, dataNode);
     * operation's periodic flush poll fires the async flush.
        String shardPath = getShardLevelBlobPath(
    }
        String clusterManagerName = internalCluster().getClusterManagerName();
        int numberOfIterations = randomIntBetween(2, 5);
            internalCluster().client()  
            METADATA,
            }  
            .cluster()
        // Wait for atleast one doc to be ingested.  
                .prepareUpdateSettings()
            .prepareUpdateSettings()
        TimeValue clusterBufferInterval = TimeValue.timeValueSeconds(randomIntBetween(100, 200));  
            long totalFiles = files.filter(f -> f.getFileName().toString().endsWith(Translog.TRANSLOG_FILE_SUFFIX)).count();
    }
                .preparePutTemplate("test")  
        }, 30, TimeUnit.SECONDS);  
            .setWaitForCompletion(true)
    public void testAsyncDurabilityWhenRestrictSettingExplicitFalse() throws ExecutionException, InterruptedException {  
            .setWaitForStatus(ClusterHealthStatus.GREEN)
        assertHitCount(
        // Flush so that the subsequent sync or flushes are no-op.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        ));
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "5s"))  
        assertFalse(recoverySource.isEmpty());  
            .build();
        ).buildAsString();  
        ensureGreen(INDEX_NAME);  
        Settings.Builder settings = Settings.builder()  
        // the periodic flush condition is polled on write operations and the counter is republished on each
            .execute()
        // In this test, we trigger a force flush on existing primary while the primary mode on new primary has been
        }
            "0",
        client(clusterManagerName).admin()
        flushThread.join();
                }
                if (RemoteStoreSettings.isPinnedTimestampsEnabled()) {
        assertBusy(() -> assertFalse(indexShard.shouldPeriodicallyFlush()), 30, TimeUnit.SECONDS);
        logger.info("Verify shallow snapshot created before close");
    }  
                )
                assertThat(getFileCount(indexPath), comparesEqualTo(0));
        client().admin().indices().close(Requests.closeIndexRequest(INDEX_NAME)).actionGet();
        assertAcked(  
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, INDEX_NAME);
            (int) client(dataNode).prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value(),
        assertHitCount(client(oldPrimary).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), docs);
        String dataNode = internalCluster().startNodes(1).get(0);  
     * Same trigger as {@link #testPeriodicFlushOnUncommittedSegmentBytes()}, but driven purely from the cluster level:
        // without the fix the soft-deletes floor never moves off the initial commit and the deleted-docs count can
    }  
            for (int i = 0; i < docCount; i++) {  
        Thread.sleep(1000);
                .indices()  
            .setTransientSettings(Settings.builder().putNull(CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()))
import org.opensearch.indices.RemoteStoreSettings;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 10000L, -1));
        assertTrue(getFileCount(indexPath) > 0);
     */
        // Sleep for some time for the next doc to be present in lucene buffer. If flush happens first before the doc #2
    public void testPeriodicFlushOnUncommittedSegmentBytesFromClusterDefault() throws Exception {
        int numberOfIterations = randomIntBetween(5, 15);
        client(clusterManagerName).admin()
            indexSingleDoc(INDEX_NAME);  
        String dataNode = internalCluster().startNodes(1).get(0);
            files.forEach(p -> {
        Thread.sleep(1000);
                    client().prepareIndex(INDEX_NAME)
            client().admin()
        // we check that we do not overwrite any file on remote store. Here we will also increase the replica count to
        );  
        assertBufferInterval(bufferInterval, indexShard);  
        for (int i = 0; i < 5; i++) {  
            .setIndices(INDEX_NAME)  
        // Delete is async. Give time for it
    /**
        String dataNode = internalCluster().startNodes(1).get(0);
            client().prepareIndex(INDEX_NAME).setId("0").setSource("field", randomAlphaOfLength(100)).get();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    public void testRestoreSnapshotToIndexWithSameNameDifferentUUID() throws Exception {
            .setWaitForNoRelocatingShards(true)  
        assertEquals(0, snapshotInfo2.failedShards());
            refresh(INDEX_NAME);
        );  
                // checkpoint for the whole test regardless of commits
        assertNotEquals(IndexMetadata.INDEX_UUID_NA_VALUE, originalIndexUUID);
    public void testPeerRecoveryWithRemoteStoreAndRemoteTranslogNoDataFlush() throws Exception {
    /**  
        Settings.Builder settings = Settings.builder()
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        for (int i = 0; i < 100; i++) {
        // so the retention lease and the async flush pipeline keep advancing.
        ensureGreen(INDEX_NAME);
            .prepareGetSettings(INDEX_NAME)  
            Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build()
     * the index sets no per-index threshold, so lowering  
                .get()
        assertFalse(indexShard.isSearchIdleSupported());
    }  
        assertAcked(
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
                .put(remoteStoreIndexSettings(0))
     * per-index counterpart -- must gate the condition on a live index in both directions.  
/*  
                // independent of the randomized merge policy defaults  
                .build()  
                .put(remoteStoreIndexSettings(0))
            .get();  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
import org.opensearch.plugins.Plugin;  
        Thread flushThread = new Thread(() -> {
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);  
                .admin()
        );
                    Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false)
        IndexShard indexShard = getIndexShard(dataNode, INDEX_NAME);  
        assertBusy(() -> {  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertEquals(expectedExceptionMsg, exception.getMessage());  
            oldPrimary
            .indices()
                    Settings.builder()
        Optional<RecoveryState> recoverySource = recoveryResponse.shardRecoveryStates()
            lessThanOrEqualTo(periodicAfterDisable + 1)  
            .execute()
    public void testPeriodicFlushReclaimsSoftDeletesUnderUpdateHeavyWorkload() throws Exception {
        assertEquals(  
        durability = randomFrom(Durability.values());  
            BulkRequestBuilder bulk = client().prepareBulk();
        assertAcked(
            () -> assertHitCount(client(replicaNodeName).prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
        return BlobPath.cleanPath();
        IndexShard indexShard = getIndexShard(datanode, INDEX_NAME);  
                .cluster()
            "failed to parse value [-1] for setting [index.remote_store.translog.buffer_interval], must be >= [0ms]",
                .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), "async"))
            Settings.builder().put(IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING.getKey(), true).build()  
        );  
import java.util.Optional;
                .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "20kb")  
        delete(translogRepoPath, shardPath);
        );
                .indices()
            .put(remoteStoreIndexSettings(0, 10000L, -1))  
import org.opensearch.cluster.health.ClusterHealthStatus;  
        // 3. Delete metadata from remote translog
        testPeerRecovery(1, false);
            .put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)
import java.nio.file.Path;
            )
                    // Ignore  
 * this file be licensed under the Apache-2.0 license or a
        Settings indexSettings = Settings.builder()
        logger.info("Verify shallow snapshot created after close");
                + " more",
                        .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "1b")  
        assertEquals(0, indexShard.flushStats().getPeriodic());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.index.translog.Translog.Durability;  
                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "5kb")
        assertAcked(
import java.util.concurrent.CountDownLatch;
                    Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), bufferInterval)  
        String oldPrimary = internalCluster().startDataOnlyNodes(1).get(0);
        );  
import static org.hamcrest.Matchers.greaterThan;  
        );
        // 5. Ensure green and verify number of docs  
            .put(indexSettings())  
    public void testNoSearchIdleForAnyReplicaCount() throws ExecutionException, InterruptedException {
            .prepareHealth()  
import org.opensearch.snapshots.SnapshotInfo;
        final long periodicAfterDisable = indexShard.flushStats().getPeriodic();
        client().admin().indices().close(Requests.closeIndexRequest(INDEX_NAME)).actionGet();
        int numberOfIterations = randomIntBetween(1, 5);
    public void testCloseIndexWithNoOpSyncAndFlushForSyncTranslog() throws InterruptedException {
                    Settings.builder()
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            refresh(INDEX_NAME);  
                .prepareUpdateSettings()  
        indexSingleDoc(INDEX_NAME);
    public void testOverriddenBufferIntervalValidation() {
}  
                )
            oldPrimary
                        is(oneOf(lastNMetadataFilesToKeep - 1, lastNMetadataFilesToKeep, lastNMetadataFilesToKeep + 1))
