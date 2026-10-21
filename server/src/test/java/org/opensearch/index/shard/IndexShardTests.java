            thread.start();
            .primaryTerm(0, 1)
        final ShardRouting relocationRouting = ShardRoutingHelper.relocate(originalRouting, "other_node");
                        throw new AssertionError(e);
                assertThat(e, instanceOf(RuntimeException.class));
        } else {
        tracker.addUploadBytesFailed(10L);
            randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, maxSeqNoOfUpdatesOrDeletesBeforeRollback),
         * - index #3
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
                    shard.resetEngineToGlobalCheckpoint();
        assertThat(before.getMemorySizeInBytes(), equalTo(0L));
        assertTrue(indexShard.isRelocatedPrimary());
        IndexShardTestCase.updateRoutingEntry(shard, routing);
        for (int i = 0; i < 2; i++) {
        Settings primarySettings = Settings.builder()
                ShardRoutingState.STARTED,
        IndexShard replica = newShard(primary.shardId(), false, "n2", metadata, null);
            shard.indexSettings().getIndexMetadata(),
        for (int i = 0; i < operations; i++) {
            )
        tracker.incrementRejectionCount();
                    warmerStarted.countDown();
            }
            indexMetadata.build(),
                    shard.store().getMetadata(wrappedSafeCommit.get());
import org.opensearch.index.engine.InternalEngine;
    }
import java.util.function.Consumer;
        );
        );
            primarySettings,
        indexOnReplicaWithGaps(shard, between(0, 1000), Math.toIntExact(shard.getLocalCheckpoint()));
            sourceToParse
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
    }
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
        shard.refresh("test");
    public void testRecoverFromStoreWithOutOfOrderDelete() throws IOException {
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        final IndexShard shard = newStartedShard(true);
        indexDoc(shard, "_doc", "0");
                latch.countDown();
        assertTrue(future.actionGet());
            .settings(settings)
    /**
                operations.add(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        closeShards(shard);
 * this work for additional information regarding copyright
                .primaryTermSupplier(config.getPrimaryTermSupplier())
                    try (Releasable operationLock = acquirePrimaryOperationPermitBlockingly(shard)) {
            Settings.builder().put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), resyncTimeout).build(),
        storeDirectory = ((FilterDirectory) ((FilterDirectory) target.store().directory()).getDelegate()).getDelegate();
        });
            .put(current.getSettings())
        shard.updateGlobalCheckpointOnReplica(0, "test"); // stick the global checkpoint here.
        assertTrue(primary.scheduledRefresh()); // make sure we refresh once the shard is inactive
        final ShardRouting replicaRouting = TestShardRouting.newShardRouting(
        Version versionCreated = VersionUtils.randomVersion(random());
            try {
        if (randomBoolean()) {
                numCorruptEntries++;
import java.util.concurrent.atomic.AtomicReference;
        assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
        barrier.await();
                logger,
        }
        CountDownLatch proceedWithRecoveryLatch = new CountDownLatch(1);
            randomAlphaOfLength(10),
        }
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1);
                ShardRoutingState.INITIALIZING,
            indexShard.getPendingPrimaryTerm() + 1,
        try {
            null
            } else {
        IndexShard replicaCorrupted = newShard(
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            closeShards(shard);
        CountDownLatch latch = new CountDownLatch(1);
        }
            ActionListener.wrap(r -> {
            translogOps = 0;
        assertTrue(primary.scheduledRefresh());
                new RecoveryState(
                null,
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        try {
                    lessThanOrEqualTo(storeStats.sizeInBytes() * 120 / 100)
                        @Override
            // Should not throw — returns immediately for non-seg-rep indices
     * A promoted primary must reject relocation hand-off for as long as its primary-replica resync is pending.
            // Do some updates and deletes, then recheck the correlation again.
        final ShardRouting shardRouting = shard.routingEntry();
            replicaRouting.currentNodeId(),
                            postIndexCreate.incrementAndGet();
            newShard.store().cleanupAndVerify("test", storeFileMetadatas);
        );
        final IndexShard newShard = reinitShard(shard, listener);
        assertEquals(0, postDeleteException.get());
                }
            this.maxSeqNo = maxSeqNo;
                preDelete.incrementAndGet();
    }
                assertFalse(onResponse.get());
        // all docs are present
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
                        barrier.await();
        updatePeriodicFlushInterval(primary, "-1");
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            @Override
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
        Settings settings = Settings.builder()
            primary.getIndexer(),
                        assertThat(indexShard.getPendingPrimaryTerm(), equalTo(newPrimaryTerm));
        }
        try {
        closeShards(shard);
        final CyclicBarrier barrier = new CyclicBarrier(1 + operations);
        assertEquals(2, preIndex.get());
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
                assertFalse(onResponse.get());
        StringBuilder expectedSubSequence = new StringBuilder("\"shard_path\":{\"state_path\":\"");
                    engineResetLatch.countDown();
        indexShard.acquireAllPrimaryOperationsPermits(futureAllPermits, TimeValue.timeValueSeconds(30L));
        thread.start();
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        }
            assertEquals(0, indexShard.getActiveOperationsCount());
                    assertThat(e, hasToString(containsString("shard is not in primary mode")));
    private ShardRouting promoteReplicaWithPendingResync(IndexShard replica) throws Exception {
        recoverShardFromStore(primary);
                    assertThat(storeFileMetadatas.recoveryDiff(readMeta).identical.size(), equalTo(storeFileMetadatas.size()));
        final ShardId shardId = new ShardId("index", "_na_", 0);
        shard.writeIndexingBuffer();
        final int numThreads = randomIntBetween(2, 4);
                    try (Releasable ignored = permitAcquiredFuture.actionGet()) {
                Settings.builder()
                        for (int i = 0; i < 10000; i++) {
                indexShard.acquireReplicaOperationPermit(
                RecoverySource.ExistingStoreRecoverySource.INSTANCE
        );
            when(behindStat.getCheckpointsBehindCount()).thenReturn(3L);
        // Once the engine is created during recovery, the task starts with the configured interval.
        RemoteTranslogStats remoteTranslogStats
            indexShard.getGlobalCheckpointSyncer(),
            new SourceToParse(indexName, "doc-1", new BytesArray("{}"), MediaTypeRegistry.JSON)
                assertTrue(refreshed);
        );
import org.apache.lucene.search.TopDocs;
                break;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
            "Failed to sync all files to new shard",
        AtomicInteger postIndexException = new AtomicInteger();
            IndexShardNotStartedException.class,
                indexShard = newShard(routing);
    ShardStateMetadata getShardStateMetadata(IndexShard shard) {
        closeShards(primary);
    }
                ThreadPool.Names.WRITE,
                shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
                );
                final long mappingVersion,
        IndexShard target = newStartedShard(
            }
        final Set<String> docsBeforeRollback = getShardDocUIDs(indexShard);
                barrier.await();
            wrapper,
        // extra0 file is added as a part of https://lucene.apache.org/core/7_2_1/test-framework/org/apache/lucene/mockfile/ExtrasFS.html
                            throw new RuntimeException(e);
                final int totalTranslogOps,
            .build();
        );
            closeShards(indexShard);
            try {
            }
        final IndexMetadata newShardIndexMetadata = IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
        assertDocCount(newShard, 1);
        cleanLuceneIndex(store.directory());
            shardStateMetadata,
        IndexMetadata metadata = IndexMetadata.builder("test")
                        postDelete(shardId, delete, result.getFailure());
        indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
        recoverShardFromStore(replica);
import org.opensearch.common.xcontent.XContentFactory;
                    shardId,
    }
                        onFailure.set(e);
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
                indexShard.refresh("test");
import static org.opensearch.common.lucene.Lucene.cleanLuceneIndex;
        final ActionListener<Releasable> listener,
                randomNonNegativeLong(),
        long primaryTerm;
    private Releasable acquireReplicaOperationPermitBlockingly(IndexShard indexShard, long opPrimaryTerm) throws ExecutionException,
            searchReplicaShardRouting,
            .build();
        try {
import org.opensearch.index.engine.Engine;
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
    public void testLockingBeforeAndAfterRelocated() throws Exception {
            // now loop until we are fast enough... shouldn't take long
            indexShard.forceMerge(forceMergeRequest);
        // Wait until the reset has created the ReadOnlyEngine (installed as current engine)
        try (Store store = createStore(indexShard.indexSettings(), shardPath)) {
        if (shard.isRelocatedPrimary()) {
        closeShards(shard);
        for (final Thread thread : delayedThreads) {
            ShardRoutingState.STARTED,
                }
        Settings settings = Settings.builder()
            )
                        } else {
    }
                    "Estimated total document size is too small compared with the stored size",
            }
        assertRemoteTranslogStats(remoteTranslogTransferTracker, remoteTranslogStats);
import java.nio.charset.Charset;
        }
    }
    private IndexShard newStartedReplicaWithResyncTimeout(TimeValue resyncTimeout) throws IOException {
                SeqNoFieldMapper.PRIMARY_TERM_NAME,
        Settings settings = Settings.builder()
                    "Estimated total document size is too large compared with the stored size",
            shard.getLastKnownGlobalCheckpoint(),
            .primaryTerm(0, 1)
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
                );
     */
        allPrimaryOperationLocksAcquired.await();
    public void testCheckpointRefreshListener() throws IOException {
        Set<String> docBelowGlobalCheckpoint = getShardDocUIDs(shard).stream()
import static org.hamcrest.Matchers.in;
                UUIDs.randomBase64UUID(),
                EMPTY_EVENT_LISTENER,
        // The resync never completes, so only the timeout can clear the flag. Wait well past the 10s timeout.
        );
                assertThat(
                null,
                RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE
        allowShardFailures();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
            .pollingIngestStats(shard.pollingIngestStats())
            public void onFailure(Exception e) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        0,
            }
     * and checking index concurrently. This should always be possible without any exception.
                        docBelowGlobalCheckpoint,
    }
        assertFalse(primaryShard.getIndexer().config().isReadOnlyReplica());
            );
                    throw ex.get();
                Settings.builder()
                storeDirectory.deleteFile(file);
        // Shard is still inactive since we haven't started recovering yet
        assertThat(newShard.getHistoryUUID(), equalTo(historyUUID));
    }
        final IndexShard indexShard = newStartedShard(false);
                .internalRefreshListener(config.getInternalRefreshListener())
            assertThat("current routing:" + shard.routingEntry(), shard.routingEntry().relocating(), equalTo(false));
        );
        assertEquals(0, preDelete.get());
        assertEquals(0, preDelete.get());
        }
            null
        }, true, true);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            null,
        shard.close("simon says", true, false);
            IndexShard shard = indexShard;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                };
            final long newPrimaryTerm = primaryTerm + 1 + randomInt(20);
            shard.refresh("test");
        final String corruptionMessage = "fake ioexception";
        Settings settings = Settings.builder()
                shard.relocated(
                shard.getIndexer().translogManager().rollTranslogGeneration();
        Settings settings = Settings.builder()
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
        assertEquals(getEngine(replicaShard).getClass(), NRTReplicationEngine.class);
            } finally {
        assertEquals(primaryShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
        assertFalse(flushTask.isClosed());
            closeShards(indexShard);
        expectedSubSequence.append("\",\"data_path\":\"");
        assertNull(primary.getPeriodicFlushTask());
        final ShardRouting replicaRouting = shard.routingEntry();
            threadPool
        IndexShard shard = newStartedShard(true);
        final IndexShard primaryShard = newStartedShard(
                randomNonNegativeLong(),
            .primaryTerm(0, 1)
                    assertTrue(searcher.getIndexReader().numDocs() <= docStats.getCount());
            }, e -> { throw new AssertionError(e); }),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                randomNonNegativeLong(),
                        latch.countDown();
        assertFalse(shard.isActive());
            );
        final ShardPath shardPath = shard.shardPath();
                @Override
            for (final Integer i : ids) {
            }
            null
                    indexShard.getMaxSeqNoOfUpdatesOrDeletes(),
        // check time advances
                @Override
            recoverySettings,
            if (randomBoolean()) {
        indexDoc(shard, "_doc", "test");
                    indexShard.markSeqNoAsNoop(i, indexShard.getOperationPrimaryTerm(), "dummy doc");
            new ShardId("index_1", "index_1", 0),
            .build();
        return Settings.builder().put(super.threadPoolSettings()).put("thread_pool.estimated_time_interval", "5ms").build();
    }
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();
            shard.indexSettings.getNodeSettings(),
        source.refresh("test");
            final String id = "d_" + i;
                seqNo,
                        indexShard,
                // in integration tests, this is done as a listener on IndexService.
            otherShard,
        // test global ordinals are evicted
                    blocked.set(true);
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
        assertTrue(future.actionGet());
        closeShards(shard);
                return FileVisitResult.CONTINUE;
        } finally {
        final IndexShard newShard = newShard(
        recoverShardFromStore(shard);
            );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                assertThat(indexShard.getLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            Releasable operation1 = acquirePrimaryOperationPermitBlockingly(indexShard);
        assertNotEquals(meta, new ShardStateMetadata(!meta.primary, meta.indexUUID, meta.allocationId, meta.indexDataLocation));
        assertDocs(target, "0", "2");
            true,
    public void testOnCloseStats() throws IOException {
        );
            () -> indexShard.relocated(targetAllocationId, primaryContext -> {}, () -> {})
                // our operation should still be blocked
                preIndex.incrementAndGet();
import org.opensearch.action.admin.indices.flush.FlushRequest;
            @Override
            } catch (InterruptedException | IOException e) {
            replica.getRetentionLeaseSyncer(),
        IndexMetadata metadata = IndexMetadata.builder("test")
            newShardRouting(
        closeShards(primarySource, primaryTarget);
            final String id = "t_" + i;
        final IndexShard indexShard = newStartedShard(true);
            .build();
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
import org.opensearch.index.seqno.ReplicationTracker;
            IndexShardTestUtils.getFakeDiscoveryNodes(primaryRouting)
            expectThrows(AlreadyClosedException.class, () -> indexShard.storeStats());
        shard.acquireAllReplicaOperationsPermits(
        final AtomicBoolean invoked = new AtomicBoolean();
                            @Override
import java.util.concurrent.BrokenBarrierException;
            searchReplicaShardRouting,
            assertThat(cancellingException.get(), nullValue());
        Result(final int localCheckpoint, final int maxSeqNo) {
        }, false, true);
                        listener.onResponse(r);
    public void testPeriodicFlushTaskDeferredUntilEngineExists() throws Exception {
                            public void onFailure(Exception e) {
        int totalOps = randomInt(10);
                IndexShard shard = indexShard;
    class Result {
        // The promoted primary can now relocate.
    }
                .queryCache(config.getQueryCache())
        } else {
        closeShards(corruptedShard2);
        });
        tracker.incrementTotalUploadsStarted();
            0L,
        assertThat(noopDoc.getField(SourceFieldMapper.NAME).binaryValue(), equalTo(new BytesRef(reason)));
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        // 10s is the shortest timeout the setting accepts.
            );
    }
        switch (randomInt(2)) {
                                }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        Consumer<IndexShard> assertListenerCalled = shard -> {
                            public void onFailure(final Exception e) {
            null,
        }
        int translogOps = totalOps;
        IndexShard replicaShard = newShard(shardId, false);
            () -> {},
            true,
            .settings(settings)
        }
            settings,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            if (engineClosed || randomBoolean()) {
        );
        } finally {
            assertBusy(() -> {
        assertEquals(shard.shardPath().getRootStatePath().toString(), stats.getStatePath());
            .build();
        assertEquals(remoteSegmentTransferTracker.getUploadBytesSucceeded(), remoteSegmentStats.getUploadBytesSucceeded());
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), randomFrom("true", "checksum"))
        Files.walkFileTree(indexPath, corruptedVisitor);
                        public void onResponse(Releasable releasable) {
                    corruptedMarkerCount.incrementAndGet();
            public void onFailure(Exception e) {
        } else {
     * not closed), rather than silently leaving the shard running.
                threads[j].start();
import org.opensearch.index.mapper.ParsedDocument;
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader("foo", reader);
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(primaryTerm));
                indexShard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
            true,
            final Thread thread = new Thread(() -> {
            indexShard.acquireReplicaOperationPermit(
                    AllocationId.newRelocation(AllocationId.newInitializing())
        );
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "txlog-test")
        shard.acquireAllReplicaOperationsPermits(
                    releasable.close();
        try (Releasable ignored = fut.actionGet()) {
        primaryShard.updateGlobalCheckpointForShard(replicaAllocationId, replicaGlobalCheckpoint);
            assertThat(cancellingException.get(), instanceOf(IllegalIndexShardStateException.class));
            IndexShardRecoveryException.class,
            assertTrue(getResult.exists());
            () -> shard.relocated(toNode1.getTargetRelocatingShard().allocationId().getId(), ctx -> relocated.set(true), () -> {})
                .getLocalCheckpoint(),
     * This test makes sure that people can use the shard routing entry + take an operation permit to check whether a shard was already
        AtomicBoolean relocated = new AtomicBoolean();
                .circuitBreakerService(config.getCircuitBreakerService())
        );
                )
            if (corruptIndexException) {
            UUID.randomUUID().toString(),
            IndexShard spyShard = spy(shard);
        );
        routing = ShardRoutingHelper.newWithRestoreSource(
        assertNull(primary.getPeriodicFlushTask());
        closeShard(shard, false);
        thread.start();
        closeShards(primary, replica);
}
        closeShard(primaryShard, false);
                    }
                        globalCheckpoint,
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "txlog-test")
                }
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
        );
        int numDocs = between(1, 10);
        final long newPrimaryTerm = indexShard.getPendingPrimaryTerm() + between(1, 10000);
        IndexShard indexShard = newStartedShard();
            null,
        IndexShard primary = newStartedShard(true, segRepSettings);
        ShardRouting readonlyShardRouting = newShardRouting(
            indexMetadata,
    }
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperationsOnStart());
                .flushMergesAfter(config.getFlushMergesAfter())
            int hitClosedExceptions = 0;
    /**
            primaryTerm,
                            }
            indexShard.getRetentionLeaseSyncer(),
    }
            assertThat(indexShard.getLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                    replica.acquireAllReplicaOperationsPermits(
    }
                    totalTranslogOps,
        expectedSubSequence.append(shard.shardPath().getRootDataPath().toString());
            routing,
            ShardRoutingState.INITIALIZING,
                    .endObject()
        final IndexShard corruptedShard2 = newShard(
    }
        }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
        for (int i = 0; i < 30; i++) { // just a sanity check that we impl hashcode
                        latch.countDown();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            () -> newStartedShard(p -> corruptedShard, true)
        IndexShard shard = newStartedShard(true);
                onLockAcquired,
            },
        AllocationId allocationId = AllocationId.newInitializing();
        recoverShardFromStore(primary);
            }
                        postIndex(shardId, index, result.getFailure());
        final IndexShard primaryShard = newShard(
        // state must defer the task (there is nothing to flush) rather than start it.
                .getTrackedLocalCheckpointForShard(primaryTarget.routingEntry().allocationId().getId())
                };
        try {
        closeShards(shard);
                    if (singlePermit) {
     * here we are mocking a SegmentReplicationcheckpointPublisher and testing on index shard if CheckpointRefreshListener is added to the InternalrefreshListerners List
            ActionListener.wrap(r -> {
            shard.getLastKnownGlobalCheckpoint(),
                    assertThat(onFailure.get(), instanceOf(AlreadyClosedException.class));
 * GitHub history for details.
            },
        });
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        barrier.await();
            indexShard.engineConfigFactory,
                    maxSeenAutoIdTimestamp,
     */
                    greaterThanOrEqualTo(storeStats.sizeInBytes() * 80 / 100)
        }
            ) {
                    indexShard.acquireAllPrimaryOperationsPermits(future, TimeValue.timeValueHours(1L));
            true,
        // now check that it's persistent ie. that the added shards are committed
        {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        closeShards(primary);
        // The stub never completes the resync listener, so the resync stays pending.
                    throw new RuntimeException(e);
        IndexShardTestCase.updateRoutingEntry(shard, routing);
     */
            final AtomicBoolean onResponse = new AtomicBoolean();
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                } catch (IOException e) {
            final List<Integer> ids = randomSubsetOf(
            // to retry in the future while being filtered from listAll invocations.
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertEquals(0, postDeleteException.get());
            shardRouting,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .field("point", randomFloat())
                        assertTrue(replica.isActive());
            .put(settings)
            .retentionLeaseStats(shard.getRetentionLeaseStats())
     * Verifies the primary-only assertion on {@code freezeForTiering}: tiering preparation is
            .settings(
        assertEquals(0, postDeleteException.get());
    }
        assertTrue(indexShard.isSyncNeeded());
                indexDoc(indexShard, "_doc", id);
        IndexShard shard = newStartedShard(false);
                    Store.MetadataSnapshot readMeta = newShard.snapshotStoreMetadata();
        closeShards(shard);
            IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.REMOTE_MIGRATING_SEEDED)
            .build();
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
            AtomicBoolean called = new AtomicBoolean();
                final StoreStats storeStats = indexShard.storeStats();
        latch1.await();
                Supplier<IOException> ex = exceptionToThrow.get();
            // However, this logic is also buggy and after the first delete attempt we are left in a state where the file is still on disk
        // The same task is kept and rescheduled with the new interval.
        closeShards(newShard);
        newShard.refresh("test");
                preDelete.incrementAndGet();
            }
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            indexShard = newStartedShard();
            assertDocCount(newShard, 2);
                        counter.incrementAndGet();
                indexShard.sync(); // advance local checkpoint
        recoverReplica(shard, primary, true, (a) -> null);
                    AssertionError.class,
        recoverShardFromStore(primary);
        assertTrue(flushTask.isScheduled());
        long currentMaxSeqNoOfUpdates = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            shardStateMetadata,
import org.opensearch.test.VersionUtils;
    }
                    .startObject()
        );
            true,
        // Shard is still inactive since we haven't started recovering yet
            } catch (InterruptedException | IOException e) {
        IndexShardTestCase.updateRoutingEntry(shard, inRecoveryRouting);
            .shardPath(shard.shardPath())
        ShardRouting shardRouting = shard.routingEntry();
        closeShards(replica);
            for (Thread thread : threads) {
        closeShards(indexShard);
        final ShardId shardId = new ShardId("test", "_na_", 0);
                        throw new RuntimeException(e);
        assertTrue(refreshListeners.stream().anyMatch(e -> e instanceof CheckpointRefreshListener));
                    .put(indexShard.indexSettings.getSettings())
                    new Translog.Index(
        final AtomicBoolean synced = new AtomicBoolean();
        for (int i = 0; i <= maxSeqNo; i++) {
            EMPTY_EVENT_LISTENER,
        }
        indexDoc(target, "_doc", "1");
        IndexShard shard = newStartedShard(true, segRepSettings);
            indexShard.acquireReplicaOperationPermit(opPrimaryTerm, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, listener, executor, info);
        assertThat(exception2.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
        expectThrows(AlreadyClosedException.class, () -> newShard.getIndexer()); // no engine
            newShardRouting(
            try {
            indexMetadata,
        Map<String, MappingMetadata> requestedMappingUpdates = ConcurrentCollections.newConcurrentMap();
            .build();
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        closeShards(target);
            replica.indexerFactory,
        // but since no segment info is found, it falls back to Empty Store recovery logic.
import java.util.List;
        );
            ) {
            EngineConfig configWithWarmer = new EngineConfig.Builder().shardId(config.getShardId())
            closeShards(replica);
            indexShard.engineConfigFactory,
        indexShard.addShardFailureCallback(ig -> shardFailed.set(true));
            indexShard.shardPath(),
                true,
    }
    }
        final List<Thread> delayedThreads = new ArrayList<>();
                public void onFailure(final Exception e) {
        shard = reinitShard(shard, new IndexingOperationListener() {
        assert indexShard.getReplicationTracker().isPrimaryMode() == isPrimaryMode;
        assertThat(indexShard.seqNoStats().getMaxSeqNo(), equalTo(maxSeqNo));
            indexShard.flush(flushRequest);
        target.syncSegmentsFromGivenRemoteSegmentStore(false, tempRemoteSegmentDirectory, null, false);
                        super.onResponse(releasable);
        );
            shard.getIndexerFactory(),
            default:
                    throw new AssertionError(e);
    /**
        // Re-enabling starts a fresh task.
        );
     * here we are passing null in place of SegmentReplicationCheckpointPublisher and testing  on index shard if CheckpointRefreshListener is not added to the InternalrefreshListerners List
        IndexShard newShard = reinitShard(
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();
        tracker.incrementRejectionCount();
            .settings(settings)
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
            new ShardId("index", "_na_", 0),
        assertNotNull(flushTask);
            closeShards(shard);
        ShardStats shardStats = new ShardStats.Builder().shardRouting(shard.routingEntry())
        assertNotNull("enabling index.periodic_flush_interval on a live shard should start the task", flushTask);
        final IndexShardRecoveryException exception2 = expectThrows(
            ""
    public void testSnapshotStore() throws IOException {
        assertNotNull(primary.getPeriodicFlushTask());
        final IndexMetadata indexMetadata = replica.indexSettings().getIndexMetadata();
import org.opensearch.test.CorruptionUtils;
        stats = new ShardStats(in);
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperations());
                    operations,
        IndexShard shard = newStartedShard();
            false,
                final String id = Integer.toString(i);
                    .getTrackedLocalCheckpointForShard(targetShard.routingEntry().allocationId().getId())
        IndexShard shard = newStartedShard(
                @Override
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
                assertThat(indexShard.getPendingPrimaryTerm(), equalTo(newPrimaryTerm));
                    );
            1,
                        break;
            .getRemoteTranslogTransferTracker(shard.shardId);
            thread[i].join();
            .build();
        indexDoc(shard, "_doc", "test");
        {
     */
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), interval)
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        }
        } else {
        assertThat(indexShard.getLocalCheckpoint(), equalTo((long) result.localCheckpoint));
            .build();
    public void testShardCanNotBeMarkedAsRelocatedIfRelocationCancelled() throws IOException, InterruptedException {
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        final List<PlainActionFuture<Releasable>> futures = new ArrayList<>(threads.length);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(1, postIndexCreate.get());
            final long newGlobalCheckpoint = indexShard.getLocalCheckpoint();
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            }
        assertEquals(1, postIndexCreate.get());
        IndexMetadata metadata = IndexMetadata.builder("test")
            indexShard.indexerFactory,
                .store(config.getStore())
        primary.addRefreshListener(doc.getTranslogLocation(), r -> latch.countDown());
                });
            RetentionLeaseSyncer.EMPTY,
            indexShard,
                }
            Math.toIntExact(primaryShard.getLastKnownGlobalCheckpoint())
            true,
                }
            true,
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test1")
        // Index #0, index #1
            );
        final long firstIncrement = 1 + (randomBoolean() ? 0 : 1);
            (shard, listener) -> {},
import static org.hamcrest.Matchers.notNullValue;
        }
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
        indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .commitStats(shard.commitStats())
    /**
                    } else {
        }
                public void onFailure(Exception e) {
            newShard.checkIndex();
            assertThat(shard.state, equalTo(IndexShardState.CLOSED));
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    }
                barrier.await();
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }
            public void indexTranslogOperations(
                null,
            .primaryTerm(0, 1)
        CountDownLatch latch = new CountDownLatch(10);
            }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    recoveryState.getIndex().setFileDetailsComplete();
        assertTrue("it's already recovering, we should ignore new ones", newShard.ignoreRecoveryAttempt());
            routing,
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    case FAILURE:
            .build();
        final ShardRouting primaryRouting = promoteReplicaWithPendingResync(indexShard);
        final IndexShard corruptedShard = newShard(
        for (final Thread thread : threads) {
            .build();
     * Verifies {@code waitForReplicaSync} returns immediately on a non-segment-replication index
        IndexShard primary = newStartedShard(true, segRepSettings);
            closeShards(shard);
                // advance local checkpoint
            }
            null,
            indexShard.getGlobalCheckpointSyncer(),
            Engine.GetResult getResult = newShard.get(new Engine.Get(false, false, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))))
                    public void onResponse(Releasable releasable) {
            indexShard,
    public void testPersistenceStateMetadataPersistence() throws Exception {
        tracker.addUploadBytesStarted(bytesStarted);
            .build();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        assertThat("corruption marker should not be there", corruptedMarkerCount.get(), equalTo(0));
 * under the License.
            try {
        }, ThreadPool.Names.GENERIC, "");
            RetentionLeaseSyncer.EMPTY,
            final long numDocs = randomIntBetween(2, 32); // at least two documents so we have docs to delete
    }
            replicaRouting.shardId(),
                        "1",
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
        } catch (IllegalIndexShardStateException e) {
    private void populateSampleRemoteTranslogStats(RemoteTranslogTransferTracker tracker) {
                // started replica
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
                randomNonNegativeLong(),
            closeShards(corruptedShard);
            }, Assert::assertNotNull),
        String remoteStorePath = createTempDir().toString();
     */
            }, ThreadPool.Names.SAME, "test");
            shard.getLastKnownGlobalCheckpoint(),
            assertThat("Without flushing, segment sizes should be zero", indexShard.docStats().getTotalSizeInBytes(), equalTo(0L));
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-test")
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
        AtomicBoolean armed = new AtomicBoolean(false);
import org.opensearch.threadpool.ThreadPool;
            });
        assertTrue(remoteSegmentStats.getTotalRejections() > 0);
            // temporary override until LUCENE-8735 is integrated
                @Override
                    throw new RuntimeException(e);
import org.opensearch.cluster.routing.ShardRoutingHelper;
            },
    public void testWaitForReplicaSync_NonSegRepIndex_ReturnsImmediately() throws IOException {
        }, Assert::assertNotNull), TimeValue.timeValueMinutes(1L));
                    }
        );
        cancellingThread.join();
        );
        CountDownLatch latch = new CountDownLatch(1);
            try {
    public void testRestoreLocalHistoryFromTranslogOnPromotion() throws IOException, InterruptedException {
        // create corrupted marker
            .collect(Collectors.toSet());
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        assertNotNull(restarted);
        // Delete files in store directory to restore from remote directory
            synced.get(),
                    routing.getTargetRelocatingShard().allocationId().getId(),
        recoverShardFromStore(primaryShard);
                assertThat(indexShard.getLastKnownGlobalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            closeShards(indexShard);
        final ShardRouting replicaRouting = indexShard.routingEntry();
        RemoteSegmentStoreDirectory tempRemoteSegmentDirectory = createRemoteSegmentStoreDirectory(
        }
     * Verifies that {@code getSegmentInfosSnapshot()} on the ReadOnlyEngine created during
        assertEquals(1, postIndexUpdate.get());
            if (engineClosed == false) {
                } finally {
                .build()
        assertTrue(
            newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
    }
        assertEquals(replicaShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
            indexDoc(shard, "_doc", "1");
        final String reason = randomUnicodeOfLength(200);
        }
            shard.shardPath(),
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
                cyclicBarrier.await();
                public void onResponse(final Releasable releasable) {
            int numDoc = randomIntBetween(100, 200);
                } catch (final BrokenBarrierException | InterruptedException e) {
        int totalOps = randomInt(10);
            thread[i] = new Thread() {
    }
                } catch (Exception e) {
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
        tracker.incrementTotalUploadsStarted();
                latch.countDown();
        shard.applyDeleteOperationOnReplica(1, primaryTerm, 2, "id", null);
        indexDoc(shard, "_doc", "0");
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
                barrier.await();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            null,
        primary.recoveryState().getTranslog().totalOperationsOnStart(snapshot.totalOperations());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Files.walkFileTree(indexPath, corruptedVisitor);
        expectThrows(
                        assertThat(indexShard.getReplicationGroup(), notNullValue());
            targetShard.markAsRecovering("store", new RecoveryState(targetShard.routingEntry(), localNode, null));
        assertThat(e.getMessage(), containsString("primary relocation is forbidden while primary-replica resync is in progress"));
    public void testRelocatedShardCanNotBeRevived() throws IOException, InterruptedException {
        recoverShardFromStore(primary);
                Supplier<IOException> ex = exceptionToThrow.get();
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            null
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            assertTrue(xContent.contains(expectedSubSequence));
            // listAll method is called when marking store as corrupted
                    assertEquals(storeFileMetadatas.size(), storeFileMetadatas.recoveryDiff(readMeta).identical.size());
            new IndexShardRoutingTable.Builder(newRouting.shardId()).addShard(newRouting).build(),
                indexShard.getLastKnownGlobalCheckpoint(),
        closeShards(primary, replica);
                    throw ex.get();
        return replica;
    }
            () -> newStartedShard(p -> corruptedShard, true)
        if (randomBoolean()) {
        scopedSettings.applySettings(settings);
            doReturn(Set.of(inSyncStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
            shard.getEngineConfigFactory(),
            if (randomBoolean()) {
                new IndexId("test", UUIDs.randomBase64UUID(random()))
            SegmentReplicationShardStats replicatingStat = mock(SegmentReplicationShardStats.class);
                )
            indexShard.runUnderPrimaryPermit(
import org.opensearch.core.Assertions;
                    "Estimated total document size is too small compared with the stored size",
        try {
            if (indexShard.routingEntry().primary()) {
        );
        updatePeriodicFlushInterval(primary, "30s");
            .commitStats(shard.commitStats())
    }
                assertThat(docStats.getCount(), equalTo(numDocs));
            false,
        try (
        IndexShardTestCase.updateRoutingEntry(indexShard, routing);
        );
            }
                    allPermitsAcquired.await();
            assertThat(storeStats.sizeInBytes(), greaterThan(0L));
    public void testRecoverFromCleanStore() throws IOException {
                assertions.add(() -> assertTrue(invoked.get()));
        RemoteSegmentTransferTracker remoteSegmentTransferTracker = shard.getRemoteStoreStatsTrackerFactory()
        );
        IndexShardTestCase.updateRoutingEntry(shard, routing);
                indexShard.refresh("test");
        settings = Settings.builder().put(settings).put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO).build();
                max = i;
        assertThat(shard.getActiveOperationsCount(), equalTo(0));
        } else {
        closeShards(primary);
            target.routingEntry(),
     * Verifies {@code waitForReplicaSync} does NOT return immediately when bytesBehind is non-zero,
            } else if (recoveryIndex == i) {
            replica.engineConfigFactory,
            shard.updateLocalCheckpointForShard(shard.shardRouting.allocationId().getId(), totalOps - 1);
        }
        assertThat(thirdForceMergeUUID, not(equalTo(secondForceMergeUUID)));
        updateRoutingEntry(newShard, ShardRoutingHelper.moveToStarted(newShard.routingEntry()));
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                protected void ensureMaxSeqNoEqualsToGlobalCheckpoint(SeqNoStats seqNoStats) {
        IndexShard shard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, wrapper);
                    maxSeqNoOfUpdatesOrDeletes,
     * {@link IndexShard#acquireAllReplicaOperationsPermits(long, long, long, ActionListener, TimeValue)} in order to acquire a permit.
    public void testIndexCheckOnStartup() throws Exception {
        }
        relocationThread.start();
        closeShards(indexShard);
            ShardRoutingState.RELOCATING,
                } catch (InterruptedException e) {
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            @Override
        assertEquals(0, postIndexException.get());
        shard.state = IndexShardState.STARTED; // It will generate exception
            .build();
                        try {
import org.opensearch.core.index.shard.ShardId;
            // Spy on the shard to simulate a replica that's already in sync
            final IndexShard differentIndex = newShard(new ShardId("index_2", "index_2", 0), true);
            false,
        recoverShardFromStore(primary);
    public void testRelocatedShardCanNotBeRevivedConcurrently() throws IOException, InterruptedException, BrokenBarrierException {
        final String corruptionMessage = "fake ioexception";
            IndexShardTestCase.updateRoutingEntry(targetShard, ShardRoutingHelper.moveToStarted(targetShard.routingEntry()));
        indexShard.flush(new FlushRequest());
        final Settings settings = Settings.builder()
        final int delayedOperations = scaledRandomIntBetween(1, 64);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        expectThrows(AlreadyClosedException.class, shard::getCatalogSnapshot);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        listener,
            .seqNoStats(shard.seqNoStats())
                latch.countDown();
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
        );
            .primaryTerm(0, 1)
        IndexScopedSettings scopedSettings = primary.indexSettings().getScopedSettings();
            protected void doRun() throws Exception {
                assertEquals(2, searcher.getIndexReader().numDocs());
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
                    throw new RuntimeException(e);
        engineResetLatch.await();
import org.opensearch.index.mapper.MappedFieldType;
            0L,
        for (int i = 0; i < numTotalEntries; i++) {
            .settingsVersion(current.getSettingsVersion() + 1)
     */
                @Override
            randomAlphaOfLength(10),
                engineClosed = false;
        if (randomBoolean()) {
            shard,
        IndexMetadata current = shard.indexSettings().getIndexMetadata();
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
        assertThat(getShardDocUIDs(newShard), containsInAnyOrder("doc-0", "doc-2"));
        Thread thread = new Thread(() -> {
        primary.refresh("test");
        indexDoc(shard, "_doc", "test");
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-test")
        routing = ShardRoutingHelper.newWithRestoreSource(
            Settings.builder()
            new EngineBackedIndexerFactory(engineConfig -> new ReadOnlyEngine(engineConfig, null, null, true, Function.identity(), true) {
        closeShards(shard);
        // The timeout is far longer than this test runs, so nothing can clear the flag while the test checks it.
        assertFalse(relocated.get());
        closeShards(indexShard);
            EngineTestCase.generateNewSeqNo(getEngine(primaryShard));
                    assertThat(e, hasToString(containsString("shard is not in primary mode")));
            }
        );
    }
import static org.hamcrest.Matchers.nullValue;
     */
        final int operations = 1024 - scaledRandomIntBetween(0, 1024);
        assertEquals(shard.fieldData().stats("foo").getMemorySizeInBytes(), after.getMemorySizeInBytes());
    public void testCloseShardWhileResettingEngine() throws Exception {
        }
            assertFalse("idle non-DFA engine reports no pending merges", shard.hasPendingMerges());
        );
                        latch.await();
            1,
        assertNotEquals(meta, new ShardStateMetadata(!meta.primary, meta.indexUUID + "foo", meta.allocationId, meta.indexDataLocation));
                }
            RetentionLeaseSyncer.EMPTY,
        tracker.incrementTotalUploadsFailed();
            assertTrue(future.actionGet());
        engineResetLatch.await();
                ThreadPool.Names.GENERIC,
            final CyclicBarrier barrier = new CyclicBarrier(2);
                    }
            shardPath,
        ShardRouting routing = shard.shardRouting;
     */
            assertThat(
        for (int i = offset + 1; i < operations; i++) {
        ShardStateMetadata shardStateMetadata = load(logger, shardStatePath);
                public void run() {
        for (int i = 0; i < nbTermUpdates; i++) {
                throw new AssertionError(e);
        MappedFieldType foo = shard.mapperService().fieldType("foo");
        assertNotSame(flushTask, restarted);
        IndexShard replica,
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            if (indexShard.state() == IndexShardState.CREATED || indexShard.state() == IndexShardState.RECOVERING) {
        assertEquals(TimeValue.timeValueMinutes(1), primary.getPeriodicFlushTask().getInterval());
                indexShard.flush(new FlushRequest());
            IndexShard spyShard = spy(shard);
        final IndexShard replica = newShard(
        final IndexShard indexShard = newShard(false);
            equalTo(totalOps - 1L)
        final Result result = indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(indexShard.getLocalCheckpoint()));
        IndexShard shard = newStartedShard(
                        null,
        );
                    cleanLuceneIndex(targetStore.directory());
            indexMetadata,
import org.opensearch.cluster.node.DiscoveryNode;
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final CyclicBarrier barrier = new CyclicBarrier(3);
        for (int i = 0; i < totalOps; i++) {
        }
            seqNo++;
            when(inSyncStat.getBytesBehindCount()).thenReturn(0L);
        } else {
        CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueSeconds(10));
import static org.hamcrest.Matchers.oneOf;
        recoverShardFromStore(test);
        assertEquals(remoteTranslogTransferTracker.getUploadBytesSucceeded(), remoteTranslogStats.getUploadBytesSucceeded());
            .build();
        resyncLatch.await();
            0,
            assertEquals(after.getEvictions(), before.getEvictions());
        assertThat(indexShard.getPendingPrimaryTerm(), equalTo(primaryTerm + Math.max(firstIncrement, secondIncrement)));
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                    final PlainActionFuture<Releasable> permitAcquiredFuture = new PlainActionFuture<>();
        closeShardThread.join();
                    numNoops++;
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    public void testRestoreShardFromRemoteStore(boolean performFlush) throws IOException {
    public void testWaitForReplicaSync_Timeout_ThrowsIOException() throws IOException {
            settings,
                    latch.countDown();
                        1,
            false,
        }
            shardStateMetadata = load(logger, env.availableShardPaths(id));
 * this file be licensed under the Apache-2.0 license or a
    }
        // engineMutex is held -- this is the code path that deadlocks in production.
                }, listener::onFailure));
    public void testTypelessGet() throws IOException {
                    indexShard.getLocalCheckpoint()
        assertDocCount(newShard, totalOps);
                    retentionLeases,
        XContentBuilder builder = jsonBuilder();
        final long globalCheckpointOnReplica = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
                } else {
                final long maxAutoIdTimestamp,
        assertThat(
        assertFalse(
            equalTo(
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
        assertEquals(2, preIndex.get());
                releasable.close();
                () -> indexShard.acquirePrimaryOperationPermit(null, ThreadPool.Names.WRITE, "")
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.ExistingStoreRecoverySource.INSTANCE),
            .build();
        builder.endObject();
        Store store = shard.store();
import org.opensearch.index.store.StoreStats;
                    try {
                shard.resetEngineToGlobalCheckpoint();
    /**
            for (int i = 0; i < numDoc; i++) {
            return new InternalEngine(configWithWarmer);
            otherShard.getOperationPrimaryTerm(),
    }
                            barrier.await();
        scopedSettings.applySettings(settings);
package org.opensearch.index.shard;
            "n1",
        );
        closeShards(shard);
    /**
                () -> {},
                Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0).build()
        closeShards(indexShard);
                        indexShard.getLastKnownGlobalCheckpoint(),
        for (int i = 0; i < iters; i++) {
        // try to start shard on corrupted files
        primary.awaitShardSearchActive(refreshed -> {
        assertTrue("more than one unique hashcode expected but got: " + hashCodes.size(), hashCodes.size() > 1);
                assertFalse(b);
                    assertEquals(0, storeFileMetadatas.recoveryDiff(readMeta).different.size());
        recoveryEmptyReplica(replica, true);
        assertTrue(recoverFromStore(newShard));
/*
import org.opensearch.core.xcontent.XContentBuilder;
        assertDocs(source, "1", "2");
                    )
                allocationId,
            assertFalse(refreshed);
            fail();
                } catch (IOException e) {
                replicaRouting.shardId(),
        latch.await();
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
    }
            public long fileLength(String name) throws IOException {
            wrapper,
                        }
        // Capture the resync listener during promotion but fail it only afterwards: the real onFailure path fails the shard,
                    case SUCCESS:
        do {
        final SegmentReplicationCheckpointPublisher publisher = null;
        IndexShard shard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
                final RetentionLeases retentionLeases,
        assertEquals(0, postDelete.get());
                assertThat(docsStats.getCount(), equalTo(numDocs));
import java.util.stream.Collectors;
            closeShards(shard);
            thread.join();
        assertDocCount(newShard, 0);
            search = searcher.search(new TermQuery(new Term("foobar", "bar")), 10);
            true,
                        0,
    public void testEstimateTotalDocSize() throws Exception {
    public void testIsRemoteSegmentStoreInSyncUsesCatalogSnapshot() throws Exception {
            operation1 = null;
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            final int operations = scaledRandomIntBetween(5, 32);
            fail("Expected IndexShardRelocatedException");
        Settings settings = Settings.builder()
            if (!rarely() || i == operations - 1) { // last operation can't be a gap as it's not a gap anymore
            indexShard,
                    corruptedMarkerCount.incrementAndGet();
            if (randomBoolean()) {
            noopDoc.getFields().stream().map(IndexableField::name).collect(Collectors.toList()),
            @Override
        shard.prepareForIndexRecovery();
             * the race, then the other thread lost the race and only one operation should have been executed.
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNo));
            AssertionError e = expectThrows(
                    false,
                    assertThat(threadPool.relativeTimeInMillis(), greaterThan(shard.getLastSearcherAccess()));
    public void testRecoverFromStoreRemoveStaleOperations() throws Exception {
            false,
        IndexShard shard = newStartedShard();
                }
        assertEquals(replicaShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
                        if (file.equals("write.lock") || file.startsWith("extra")) {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                    },
            IndexMetadata.builder("docrep")
        shard.acquireAllReplicaOperationsPermits(
                    config.getWarmer().warm(reader);
        IndexerFactory customFactory = new EngineBackedIndexerFactory(config -> {
        for (long i = 0; i < numDocs; i++) {
    }
            @Override
                ShardRoutingState.INITIALIZING,
            Releasables.close(operation1, operation2);
        for (int i = 0; i < totalOps; i++) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            }
 * Licensed to Elasticsearch under one or more contributor
        // The timeout is far longer than this test runs, so only the resync completing can clear the flag.
            assertThat(shard.refreshStats().getTotal(), equalTo(refreshCount + 1));
        final int numberOfAcquisitions = randomIntBetween(1, 10);
            // but you can not increment with a new primary term until the operations on the older primary term complete
            barrier.await();
                throw new RuntimeException(e);
                @Override
        scopedSettings.applySettings(settings);
                if (ex == null) {
            lastSearchAccess,
            shard.getLastKnownGlobalCheckpoint(),
                    Translog.Snapshot snapshot = TestTranslog.newSnapshotFromOperations(operations);
        assertTrue(shard.isRelocatedPrimary());
                    }
        final IndexShard shard = newStartedShard(true);
        } while (primary.isSearchIdle());
        final ShardPath shardPath = indexShard.shardPath();
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        long commitGeneration;
        final Path indexPath = shardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
import org.apache.lucene.store.AlreadyClosedException;
        scopedSettings.applySettings(settings);
        shard.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
    /**
    public void testRunUnderPrimaryPermitRunsUnderPrimaryPermit() throws IOException {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
            public void onResponse(final Releasable releasable) {
            assertTrue(onFailure.get());
            StoreUtils.canOpenIndex(
                        break;
            }
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
            @Override
        Settings segRepSettings = Settings.builder()
        final ShardRouting newRouting = indexShard.routingEntry().moveActiveReplicaToPrimary();
            recoverShardFromStore(differentIndex);
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        assertTrue(recoverFromStore(newShard));
        },
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
        } finally {
                    shard.resetEngineToGlobalCheckpoint();
import org.opensearch.indices.recovery.RecoveryState;
                    ShardRoutingState.INITIALIZING,
            search = searcher.search(new TermQuery(new Term("foobar", "bar")), 10);
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        final IndexShard shard = newStartedShard(true);
        });
        // most of the time this is large enough that most of the time there will be at least one gap
import static org.mockito.Mockito.mock;
        final boolean isPrimary = randomBoolean();
            assertEquals(0, indexShard.getActiveOperationsCount());
        primaryShard.updateLocalCheckpointForShard(replicaAllocationId, replicaLocalCheckpoint);
        assertEquals(IndexShard.OPERATIONS_BLOCKED, indexShard.getActiveOperationsCount());
        assertEquals(shardStateMetadata, getShardStateMetadata(shard));
        }
                    }
            });
        AtomicBoolean stop = new AtomicBoolean(false);
                        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(newShard.getHistoryUUID(), not(equalTo(historyUUID)));
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
        }
                }
                AssertionError.class,
                    super.onResponse(releasable);
                    assertFalse(onResponse.get());
            .build();
        shard.acquireAllReplicaOperationsPermits(
                    releasable.close();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
        assertEquals(0, newShard.recoveryState().getTranslog().recoveredOperations());
                                } finally {
        closeShards(shard);
                    n -> new Translog.Index(
 * license agreements. See the NOTICE file distributed with
    }
     * Verifies {@code waitForReplicaSync} returns immediately when replicas are already in sync.
            .build();
        target.restoreFromRemoteStore(future);
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        final IndexShard shard = newStartedShard(true);
        final IndexShard indexShard = newStartedShard(false);
        } else {
            indexShard.acquireAllReplicaOperationsPermits(opPrimaryTerm, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, listener, timeout);
        Settings settings = Settings.builder()
        final long secondIncrement = 1 + (randomBoolean() ? 0 : 1);
                        retentionLeases.primaryTerm(),
        // create the primary shard with a callback that sets a boolean when the global checkpoint sync is invoked
                return FileVisitResult.CONTINUE;
            containsInAnyOrder(
        final IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();
            indexShard.routingEntry(),
                throw new RuntimeException(e);
            }
        Settings primarySettings = Settings.builder()
        StreamInput in = out.bytes().streamInput();
            .build();
        final IndexShardRecoveryException indexShardRecoveryException = expectThrows(
        IndexShard.AsyncShardFlushTask restarted = primary.getPeriodicFlushTask();
import static org.hamcrest.Matchers.is;
        // we can't issue this request through a client because of the inconsistencies we created with the cluster state
                if (throwWhenMarkingStoreCorrupted.get() && ex != null) {
        Settings settings = Settings.builder()
            }
    /**
                    assertEquals(0, storeFileMetadatas.recoveryDiff(readMeta).missing.size());
            1,
        );
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            )
                    public void onResponse(Releasable releasable) {
            .put(settings)
        assertDocCount(newShard, 0);
            final long oldPrimaryTerm = indexShard.getPendingPrimaryTerm() - 1;
    }
                postDelete.incrementAndGet();
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            shard.updateGlobalCheckpointOnReplica(3, "test");
        return primaryRouting;
        flushShard(shard);
        final ShardRouting relocationRouting = ShardRoutingHelper.relocate(originalRouting, "other_node");
        assertFalse(IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.REMOTE_NON_MIGRATING));
        assertFalse(primary.scheduledRefresh());
            try {
            final Thread thread = new Thread(() -> {
                    super.onResponse(releasable);
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
            closeShards(indexShard);
                }
                        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "tlog-repo")
        for (long i = 0; i < numDocs; i++) {
    public void testCloseShardWhileEngineIsWarming() throws Exception {
        }
import org.opensearch.common.settings.Settings;
     * listener -- if both paths synchronize on {@code engineMutex}, the cycle deadlocks.
            null,
            @Override
                    listener.onFailure(e);
    }
            newShard.markAsRecovering(
                assertThat("searcher was marked as accessed", shard.getLastSearcherAccess(), equalTo(prevAccessTime));
        IndexShardTestCase.updateRoutingEntry(primarySource, primarySource.routingEntry().relocate(randomAlphaOfLength(10), -1));
                0L,
        org.opensearch.index.engine.Engine.GetResult getResult = shard.get(
    public void testDelayedOperationsBeforeAndAfterRelocated() throws Exception {
                }
        assertFalse("a successful resync must not fail the shard", shardFailed.get());
        int numCorruptEntries = 0;
                    onFailureException.set(e);
            replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
        tracker.incrementTotalUploadsStarted();
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
        assertThat(deleteDoc.getField(SeqNoFieldMapper.TOMBSTONE_NAME).numericValue().longValue(), equalTo(1L));
        } catch (InterruptedException e) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    throw new AssertionError();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                        getTranslog(indexShard).getGeneration().translogFileGeneration,
            shardRouting,
        assertTrue(remoteStoreIndex.isRemoteTranslogStoreEnabled());
        );
            1,
import org.opensearch.index.seqno.RetentionLease;
        final ShardRouting original = shard.routingEntry();
            })
                        opPrimaryTerm,
            indexShard.indexerFactory,
        assertEquals(1, postIndexCreate.get());
        source.refresh("test");
        assertEquals(shardStateMetadata, getShardStateMetadata(shard));
        };
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
                    corruptedMarkerCount.incrementAndGet();
            true,
        closeShards(shard);
                .eventListener(config.getEventListener())
            @Override
     * @param indexShard the shard
                preIndex.incrementAndGet();
            doReturn(Set.of(behindStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
        Thread thread = new Thread(() -> {
        );
                return FileVisitResult.CONTINUE;
            @Override
            IllegalStateException.class,
        closeShards(newShard);
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
            shard.mapperService(),
            newShardIndexMetadata,
            shard.indexSettings,
        getResult.close();
            SegmentInfos segmentInfos = segmentInfosGatedCloseable.get();
        );
                }
     * Verifies {@code waitForReplicaSync} does NOT return immediately when replication is in progress
                            semaphore.acquire();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.core.tasks.TaskId;
            UUID.randomUUID().toString(),
    public void testPrimaryReplicaResyncTimeoutUnblocksPrimaryRelocation() throws Exception {
        final long numDocs = between(10, 100);
                ActionListener<Void> listener
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        final ShardRouting shardRouting = indexShard.routingEntry();
            .filter(id -> Long.parseLong(id) <= globalCheckpoint)
                final ActionListener<Long> listener
            0L,
                deleteDoc(indexShard, id);
        );
    }
 * You may obtain a copy of the License at
                try {
    public void testPrimaryPromotionRollsGeneration() throws Exception {
        Settings settings = Settings.builder()
        do {
                indexShard.getPendingPrimaryTerm(),
                        releasable.close();
        }
        recoverFromStore(primary);
     */
        );
     * @param operations the number of operations
                        ""
                }
                postIndex.incrementAndGet();
        assertThat(
        promoteReplicaWithResyncSyncer(indexShard, (shard, resyncListener) -> capturedListener.set(resyncListener));
                                    lease.timestamp(),
        Store targetStore = target.store();
            @Override
        assertTrue("recovery should start", recoveryStartedLatch.await(30, TimeUnit.SECONDS));
                super.indexTranslogOperations(
                    return super.fileLength(name);
        Files.walkFileTree(indexPath, corruptedVisitor);
import org.opensearch.cluster.metadata.MappingMetadata;
            assertDocCount(targetShard, 2);
                assertThat(indexShard.getOperationPrimaryTerm(), equalTo(primaryTerm));
        final IndexSettings docrepIndex = new IndexSettings(
                    mappingVersion,
        } finally {
    /**
            }
        Thread snapshotThread = new Thread(() -> {
    /**
        assertThat(exception1.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
        try {
                        } catch (final BrokenBarrierException | InterruptedException e) {
                    }
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
        );
                called.set(true);
                onLockAcquired = new PlainActionFuture<Releasable>() {
        IndexShard shard = newStartedShard(true);
            "store",
        closeShards(primary);
            IndexShard spyShard = spy(shard);
    private static void assertRemoteSegmentStats(
            snapshotThread.start();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.apache.lucene.util.Constants;
            when(replicatingStat.getBytesBehindCount()).thenReturn(0L);
            source.shardId(),
                            }
        );
    /**
        }
                } finally {
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
                Store store,
                public void onFailure(Exception e) {
                }
    public void testShardStatsWithRemoteStoreEnabled() throws IOException {
        );
        assertNotNull(flushTask);
        ShardRouting routing = ShardRoutingHelper.initWithSameId(
        indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED));
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
            if (randomInt(100) < 10) {
import org.opensearch.index.translog.TranslogStats;
        final long maxSeqNo = indexShard.seqNoStats().getMaxSeqNo();
                shardPath,
    public void testRefreshLevelRestoreShardFromRemoteStore() throws IOException {
                                throw new RuntimeException(e);
                } catch (AlreadyClosedException ignored) {
        }
                                )
                @Override
        // complete pending operations
                shardRouting,
                );
            indexShard.getRetentionLeaseSyncer(),
        };
            };
                    assertThat(storeFileMetadatas.recoveryDiff(readMeta).different.size(), equalTo(0));
        IndexFieldDataService indexFieldDataService = new IndexFieldDataService(
            assertEquals(2, indexShard.getActiveOperationsCount());
        // ensure we only transition after pending operations completed
            case 0:
            doReturn(Set.of(replicatingStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
        final AtomicInteger postDelete = new AtomicInteger();
                operations.add(
            () -> newStartedShard(p -> corruptedShard2, true)
    public void testShardStats() throws IOException {
            assertFalse(shard.hasPendingMerges());
                    operations,
        allowShardFailures();
            assertEquals(0, indexShard.getActiveOperationsCount());
            ShardRoutingState.INITIALIZING,
        final IndexShard shard = newStartedShard(true);
        assertThat(getShardDocUIDs(indexShard), equalTo(docsBelowGlobalCheckpoint));
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())
                shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
                    @Override
        final Result result = indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED));
            EMPTY_EVENT_LISTENER,
            () -> randomReplicaOperationPermitAcquisition(
            .build();
        Settings settings = Settings.builder()
                        releasable.close();
                        randomNonNegativeLong(),
    }
    public static Indexer getIndexerFromShard(IndexShard shard) {
        assertFalse(shard.isRelocatedPrimary());
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.ExistingStoreRecoverySource.INSTANCE),
        // Setting the RecoverySource to ExistingStoreRecoverySource to simulate a shard initializing on a new node
            1L,
        }
            ShardStateMetadata state1 = new ShardStateMetadata(primary, "fooUUID", allocationId);
        try {
     * acquired the index writer lock before it called into the store that has it's own locking for metadata reads
                Releasables.close(operation1);
            // and not pending delete.
                if (file.reused()) {
            false,
import static org.hamcrest.Matchers.containsInAnyOrder;
            assertThat(targetShard.getLocalCheckpoint(), equalTo(1L));
            indexMetadata,
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
        IndexShard replica = newShard(primary.shardId(), false, "n2", metadata, null);
            // If a field doesn't exist an empty IndexFieldData is returned and that isn't cached:
            closeShards(indexShard);
                shard.close("testing", false, false);
            indexMetadata.build(),
                        null,
                    ActionListener.wrap(r -> {
        closeShards(replicaCorrupted);
        });
                        () -> shard.runTranslogRecovery(shard.getIndexer(), snapshot, Engine.Operation.Origin.LOCAL_RESET, () -> {})
                gap = true;
                TimeValue.timeValueSeconds(30L)
import java.util.Map;
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
            () -> indexShard.acquireReplicaOperationPermit(
                throwWhenMarkingStoreCorrupted.set(randomBoolean());
                        barrier.await();
            ThreadPool.Names.WRITE,
            randomNonNegativeLong(),
            true,
        IndexShardTestCase.updateRoutingEntry(indexShard, relocatingRouting);
            randomAlphaOfLength(10),
        closeShards(replicaShard);
    public void testTranslogFactoryForRemoteTranslogBackedPrimaryShard() throws IOException {
                .indexSettings(config.getIndexSettings())
     * Regression test for
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        closeShard(indexShard, false); // skip asserting translog and Lucene as we rolled back Lucene but did not execute resync
        ParseContext.Document noopDoc = noopTombstone.docs().get(0);
                IndexShard.isTranslogBackedByRemoteStore(remoteStoreIndex, state)
            }
                } catch (InterruptedException e) {
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<Path>() {
                    public void onResponse(Releasable releasable) {
        final long numDocs = between(10, 100);
        for (int i = 0; i < numDocs; i++) {
        assert !gap || (localCheckpoint != max);
    }
        } else {
        // close store.
                assertThat(
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueHours(1));
                    relocating ? "sourceNode" : null,
import org.opensearch.index.seqno.SeqNoStats;
        assertEquals(shardStateMetadata, getShardStateMetadata(shard));
        IndexScopedSettings scopedSettings = primary.indexSettings().getScopedSettings();
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
    }
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();
        closeShards(newShard);
                primaryTerm + increment,
                    );
        assertEquals(0, indexingStats.getTotal().getIndexCurrent());
        try {
        shardStateMetadata = load(logger, shardStatePath);
    public static void write(ShardStateMetadata shardStateMetadata, Path... shardPaths) throws IOException {
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
                try (Engine.Searcher searcher = indexShard.acquireSearcher("test")) {
        synced.set(false);
        assertTrue(flushTask.isClosed());
        );
                .tombstoneDocSupplier(config.getTombstoneDocSupplier())
            null,
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            randomAlphaOfLength(8),
        final AtomicBoolean synced = new AtomicBoolean();
                }, ThreadPool.Names.WRITE, id);
            randomBoolean(),
        expectedSubSequence.append("\",\"is_custom_data_path\":").append(shard.shardPath().isCustomDataPath()).append("}");
                    public void onFailure(Exception e) {
        // ensure that after the local checkpoint throw back and indexing again, the local checkpoint advances
     * This test simulates a scenario seen rarely in ConcurrentSeqNoVersioningIT. While engine is inside
            public String[] listAll() throws IOException {
            PathUtils.get(remoteStorePath)
            assertThat(indexShard.getActiveOperationsCount(), equalTo(0));
                // relocation source
    public void testWaitForReplicaSync_AlreadyInSync_ReturnsImmediately() throws IOException {
    }
                },
                    assertThat(error.getMessage(), containsString("failed to parse field [foo] of type [text]"));
        final String corruptionMessage = "fake ioexception";
        expectThrows(AssertionError.class, () -> primaryShard.getHistoryOperationsFromTranslog(0, 1));
import java.util.concurrent.atomic.AtomicLong;
        } else {
                }
            replica.getOperationPrimaryTerm(),
                oldPrimaryTerm,
        );
            RecoverySource.PeerRecoverySource.INSTANCE
        IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
        Settings settings = Settings.builder()
                randomBoolean(),
        ShardRouting routing = indexShard.routingEntry();
            closeShards(differentIndex);
    /**
                );
                        counter.incrementAndGet();
                try {
                ShardRoutingState.INITIALIZING,
        final IndexShard shard = newStartedShard(true);
import org.opensearch.indices.IndicesQueryCache;
                .warmer(warmer)
        IndexMetadata metadata = IndexMetadata.builder("test")
                    AllocationId.newRelocation(routing.allocationId())
import java.util.function.BiConsumer;
                ShardRoutingHelper.initWithSameId(primaryShardRouting, RecoverySource.ExistingStoreRecoverySource.INSTANCE)
        assertBusy(() -> assertThat(primary.getThreadPool().relativeTimeInMillis(), greaterThan(lastSearchAccess)));
                Releasables.close(operation2);
            )
     */
        searchReplicaShardRouting = replica.routingEntry();
        assertEquals(RecoverySource.ExistingStoreRecoverySource.INSTANCE, searchReplicaShardRouting.recoverySource());
                );
        assertThat(
                final DocsStats docStats = indexShard.docStats();
        CountDownLatch warmerStarted = new CountDownLatch(1);
            shardId,
            shard.close("testing", false, false);
        assertTrue(primary.isSearchIdle());
            }
            .primaryTerm(0, 1)
        IndexShard newShard = newShard(
            replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
            recoverShardFromStore(shard);
    public void testRefreshListenersDuringPeerRecovery() throws IOException {
        final Releasable operation1;
            .directory()).getDelegate()).getDelegate());
        IndexMetadata metadata = IndexMetadata.builder("index")
import org.opensearch.common.lease.Releasables;
        );
                return operation;
        Settings segRepSettings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        routing = ShardRoutingHelper.moveToUnassigned(routing, new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "because I say so"));
            assertThat(e.getMessage(), containsString("freezeForTiering should only be called on primary shards"));
                .indexSort(config.getIndexSort())
        );
        target.markAsRecovering("from snapshot", new RecoveryState(routing, localNode, null));
        AtomicReference<Exception> relocationException = new AtomicReference<>();
        String remoteStorePath = createTempDir().toString();
        // initialize the local knowledge on the primary of the persisted global checkpoint on the primary
            indexShard.getRetentionLeaseSyncer(),
                            @Override
            ) {
        // The engine was intentionally failed, so skip the translog/Lucene consistency assertion on close.
            threads.add(thread);
        assertThat(getShardDocUIDs(shard), containsInAnyOrder("doc-0", "doc-1", "doc-2"));
        assertEquals(0, newShard.recoveryState().getTranslog().totalOperationsOnStart());
        }
                                operationLatch.await();
            expectThrows(AlreadyClosedException.class, () -> indexShard.commitStats());
        // try to start shard on corrupted files
            deleteDoc(shard, "1");
                        throw new AssertionError(e);
        IndexShard newShard = reinitShard(shard);
            shardPath,
                }
        Settings settings = Settings.builder()
            public void onBeginTranslogRecovery() {
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("index")
            ShardRoutingState.INITIALIZING,
 *
            assertThat(shard.translogStats().estimatedNumberOfOperations(), equalTo(translogStats.estimatedNumberOfOperations()));
        assertTrue(primary.getIndexer().refreshNeeded());
                UNASSIGNED_SEQ_NO,
        Object engineMutex = shard.getEngineMutex();
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
            newShard.acquireSearcher("test");
    public void testOperationPermitOnReplicaShards() throws Exception {
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
            primary.shardId,
        assertTrue(recoverFromStore(newShard));
        try {
                shard.flush(new FlushRequest());
        /*
            IndexShardRecoveryException.class,
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
import org.opensearch.cluster.routing.UnassignedInfo;
        final Thread second = new Thread(function.apply(secondIncrement));
            for (int j = 0; j < operations; j++) {
 *
            .primaryTerm(0, 1);
            assertThat(hitClosedExceptions, lessThanOrEqualTo(2));
        proceedWithRecoveryLatch.countDown();
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
        primary.recoveryState().getTranslog().totalOperations(snapshot.totalOperations());
        assertBusy(() -> assertTrue(primary.isSearchIdle()));
        deleteDoc(shard, "0");
            new SourceToParse(shard.shardId().getIndexName(), "id", new BytesArray("{}"), MediaTypeRegistry.JSON)
        IndexShard shard = newStartedShard(false);
            2,
            when(behindStat.getBytesBehindCount()).thenReturn(26600000000L);
        results.asList().forEach(result -> {
    public static ShardStateMetadata load(Logger logger, Path... shardPaths) throws IOException {
            shard,
            .primaryTerm(replicaRouting.shardId().id(), shard.getOperationPrimaryTerm() + 1)
                }
        };
        assertThat(shard.refreshStats().getExternalTotal(), equalTo(externalRefreshCount));
                    shard.resetEngineToGlobalCheckpoint();
        assertBusy(() -> assertFalse(indexShard.isPrimaryReplicaResyncInProgress()), 30, TimeUnit.SECONDS);
        final List<Runnable> assertions = new ArrayList<>(numberOfAcquisitions);
        try (
import org.opensearch.indices.replication.common.ReplicationFailedException;
        flushShard(shard);
                    latch.countDown();
        // simulate a background maybe sync; it should only run if the knowledge on the replica of the global checkpoint lags the primary
                    id,
            null,
        }
        CorruptionUtils.corruptIndex(random(), indexPath, false);
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        IndexShard shard = newStartedShard(true, segRepSettings);
        expectThrows(AssertionError.class, () -> primaryShard.getHistoryOperationsFromTranslog(0, 1));
        );
        closeShards(indexShard);
                            continue;
                indexShard = newStartedShard(true);
        });
    public void testAsyncFsync() throws InterruptedException, IOException {
                assertNull(requestedMappingUpdates.put(MapperService.SINGLE_MAPPING_NAME, mapping));
        closeShards(primary);
                VersionFieldMapper.NAME,
import org.apache.lucene.search.ReferenceManager;
        final int replicaLocalCheckpoint = randomIntBetween(0, Math.toIntExact(checkpoint));
            () -> shard.relocated(relocationRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {})
    public void testRecoverFromStoreWithNoOps() throws IOException {
        try {
        Collection<String> lastCommitedSegmentsInSource = SegmentInfos.readLatestCommit(source.store().directory()).files(false);
                false,
        Set<String> docsBelowGlobalCheckpoint = getShardDocUIDs(indexShard).stream()
 * Simple unit-test IndexShard related operations.
    }
            } catch (InterruptedException e) {
                    case FAILURE:
    public void testAcquireReplicaPermitAdvanceMaxSeqNoOfUpdates() throws Exception {
        allPermitsTerminated.countDown();
        final IndexShardRecoveryException exception1 = expectThrows(
        final int replayedOps;
        CountDownLatch recoveryStartedLatch = new CountDownLatch(1);
                    "otherNode",
        );
            assertThat(ex.getMessage(), containsString("max bytes behind:"));
        assertEquals(0, postIndexException.get());
     * {@code acquireSafeIndexCommit}, and {@code acquireSnapshot}.
        IndexShard newShard = newShard(
            fail();
    }
                        either(equalTo(translogGen + 1)).or(equalTo(translogGen + 2))
        assertThat("store still has a single corrupt marker", corruptedMarkerCount.get(), equalTo(1));
                                    assertThat(replica.getOperationPrimaryTerm(), equalTo(opPrimaryTerm));
                "store",
            );
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
        recoverReplica(replicaShard, primaryShard, true);
            );
            int numNoops = 0;
                        primary.getPendingPrimaryTerm(),
        );
            closeShards(newShard);
            indexThread.join();
        ShardStats stats = new ShardStats.Builder().shardRouting(shard.routingEntry())
        recoverShardFromStore(newShard);
            indexMetadata,
            ShardRoutingState.INITIALIZING,
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        }
        for (int i = 0; i < totalOps; i++) {
                    : executorOnDelay.toLowerCase(Locale.ROOT);
                    );
        final CountDownLatch resyncDispatched = new CountDownLatch(1);
            null,
        final ShardRouting originalRouting = shard.routingEntry();
                .getTrackedLocalCheckpointForShard(target.routingEntry().allocationId().getId())
        assertTrue(primary.scheduledRefresh());
        final ShardPath shardPath = indexShard.shardPath();
        IndexShard corruptedShard = newShard(
        IndexMetadata metadata = IndexMetadata.builder("test")
            SegmentReplicationShardStats behindStat = mock(SegmentReplicationShardStats.class);
        } finally {
                creatingEngineLatch.countDown();
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        assertDocs(replica, "1", "2");
                    }
        assertFalse(docrepIndex.isRemoteTranslogStoreEnabled());
            .build();
        assertFalse(synced.get());
        RemoteSegmentStoreDirectory remoteStoreDirectory = ((RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) target
        final IndexMetadata indexMetadata = IndexMetadata.builder(replicaRouting.getIndexName())
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
            }
        final IndexSettings remoteStoreIndex = new IndexSettings(
            .primaryTerm(0, randomLongBetween(1, Long.MAX_VALUE))
            assertEquals(RecoveryState.Stage.DONE, recoveryState.getStage());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                );
        final IndexShard shard = newStartedShard(false);
        assertFalse(replica.isActive());
            assertEquals(search.totalHits.value(), 1);
    public void testShardStatsWithFailures() throws IOException {
        }
            final CountDownLatch latch = new CountDownLatch(1);
            assertThat(onFailureException.get(), instanceOf(IllegalStateException.class));
        } finally {
    }
                public void run() {
        final IndexShard indexShard = newStartedShard(true);
            thread[i].start();
        ShardRouting routing = ShardRoutingHelper.initWithSameId(
import java.io.IOException;
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.core.common.bytes.BytesArray;
        indexDoc(source, "_doc", "4");
    public void testRecoverFromStalePrimaryForceNewHistoryUUID() throws IOException {
            }))
        }
        IndexShard shard = newStartedShard(true);
            ""
                            @Override
            shard.getOperationPrimaryTerm(),
            IndexShardTestUtils.getFakeDiscoveryNodes(primaryRouting)
            indexShard.updateShardState(primaryRouting, newPrimaryTerm, (shard, listener) -> {
            assertEquals(search.totalHits.value(), 1);
    public void testRelocatedForRemoteTranslogBackedIndexWithAsyncDurability() throws IOException {
                final DocsStats docsStats = indexShard.docStats();
            newShard.markAsRecovering("store", new RecoveryState(routing, localNode, null));
        closeShards(primary);
        shard.applyIndexOperationOnReplica(
            primaryTerm,
            thread.join();
        recoverReplica(replica, primary, (shard, discoveryNode) -> new RecoveryTarget(shard, discoveryNode, recoveryListener, threadPool) {
            false,
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        final IndexShardRecoveryException exception1 = expectThrows(
        assertTrue("isRemoteSegmentStoreInSync should return true after refresh", shard.isRemoteSegmentStoreInSync());
        assertEquals(replayedOps, newShard.recoveryState().getTranslog().recoveredOperations());
        expectThrows(AlreadyClosedException.class, shard::acquireSafeIndexCommit);
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            assertThat(indexShard.getLocalCheckpoint(), equalTo(Math.max(globalCheckpoint, globalCheckpointOnReplica)));
                    () -> {}
    ) {
            randomAlphaOfLength(10),
            // start finalization of recovery
                }, listener::onFailure));
            shard.getEngineConfigFactory(),
        randomReplicaOperationPermitAcquisition(
        indexDoc(source, "_doc", "5");
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(primaryTerm));
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexShard shard = newStartedShard(
        assertEquals(0, indexingStats.getTotal().getDeleteCount());
                    + toNode1.getTargetRelocatingShard().allocationId().getId()
        closeShards(shard);
        assertDocs(replica, "1", "2");
import java.util.concurrent.atomic.AtomicInteger;
                    assertEquals(newShard.getPendingPrimaryTerm(), operation.primaryTerm());
            flushShard(target);
import org.opensearch.index.mapper.Uid;
                    "other node",
        final ShardRouting relocatingRouting = ShardRoutingHelper.relocate(primaryRouting, "other_node");
            && indexShard.seqNoStats().getMaxSeqNo() != SequenceNumbers.NO_OPS_PERFORMED;
            }
                .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        assertThat(exception1.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
import static org.hamcrest.Matchers.instanceOf;
                    assertThat(readMeta.getNumDocs(), equalTo(numDocs));
    public void testOnMergesDrained_OnReplica_TripsPrimaryAssertion() throws IOException {
        ParseContext.Document deleteDoc = deleteTombstone.docs().get(0);
        });
        final List<Thread> threads = new ArrayList<>();
    public void testTranslogBackedByRemoteStoreMatchesHydrationCondition() {
     * real values from the underlying merge scheduler. An idle Lucene shard with no merges in flight
        closeShards(primary);
        closeShards(primaryShard);
        // The timeout must only clear the flag: the promoted primary still accepts writes and can now relocate.
                equalTo(1L)
        }
    }
/**
            public void onResponse(Releasable releasable) {
import org.opensearch.index.engine.EngineConfigFactory;
        for (int i = 0; i < 3; i++) {
        closeShards(primary);
        );
        assertDocs(target, "1", "2");
                // our operation should be blocked until the previous operations complete
            } catch (InterruptedException e) {
        closeShards(primaryShard);
        Settings primarySettings = Settings.builder()
                indexShard,
        store.incRef();
            null,
                    assertThat(indexShard.getLastKnownGlobalCheckpoint(), equalTo(newGlobalCheckPoint));
        recoverShardFromStore(replica);
                ""
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                SeqNoFieldMapper.NAME,
            closeShards(shard);
        target = reinitShard(target, routing);
            false,
                indexShard,
        IndexShard target = newStartedShard(
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMillis(10))
            shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
            );
        for (int i = 0; i < iters; i++) {
            closeShards(indexShard);
            }
        if (globalCheckpoint < maxSeqNo) {
        assertEquals(100.0f, newShard.recoveryState().getTranslog().recoveredPercent(), 0.01f);
                null,
        );
        );
        primaryShard.updateGlobalCheckpointForShard(shardRouting.allocationId().getId(), primaryShard.getLastKnownGlobalCheckpoint());
        closeShards(shard);
            "awaitShardSearchActive must access a searcher to remove search idle state",
                    assertThat(indexShard.getPendingPrimaryTerm(), equalTo(promotedTerm));
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            .settings(settings)
            indexShard.getPendingPrimaryTerm() + 1,
     * primary can relocate, and it must not fail the shard.
                .translogConfig(config.getTranslogConfig())
        final IndexShard indexShard = newShard(false);
            latch.await();
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
        assertEquals(TimeValue.timeValueMinutes(1), flushTask.getInterval());
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "txlog-test")
    }
        assertFalse(indexShard.isSyncNeeded());
                if (armed.compareAndSet(true, false)) {
                randomAllocationId(),
    }
            };
                relocationException.set(e);
            );
            .settings(settings)
import org.opensearch.common.CheckedFunction;
            shardRouting,
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(relocated.get());
            shardRouting,
        assertThat(deleteTombstone.docs(), hasSize(1));
        Settings primarySettings = Settings.builder()
            "store index should be corrupted",
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            }),
            shardRouting,
        latch1.await();
            .remoteStore()
        assertEquals(0, indexingStats.getTotal().getDeleteCurrent());
                    retentionLeases,
    public void testPrimaryReplicaResyncOnFailureClearsFlagAndFailsShard() throws Exception {
        AtomicReference<Supplier<IOException>> exceptionToThrow = new AtomicReference<>();
        final ShardRouting replicaRouting = indexShard.routingEntry();
            ShardRoutingState.INITIALIZING,
        try {
        // all docs are present
            assertThat(seqNoStats.getLocalCheckpoint(), equalTo(2L));
        assertEquals(getEngine(replicaShard).getClass(), InternalEngine.class);
        assertTrue(shard.isRelocatedPrimary());
        );
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final IllegalIndexShardStateException e = expectThrows(
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertEquals(2, preIndex.get());
            }
            shard.acquirePrimaryOperationPermit(onLockAcquired, ThreadPool.Names.WRITE, "i_" + i);
        final int operations = 1024 - scaledRandomIntBetween(0, 1024);
                ThreadPool.Names.WRITE,
                try {
                    ThreadPool.Names.WRITE,
                ""
        for (long i = 0; i < numDocs; i++) {
                    shard.resetEngineToGlobalCheckpoint();
            searchReplicaShardRouting,
    }
        final ShardRouting routing = ShardRoutingHelper.relocate(originalRouting, "other_node");
        shard.refresh("test");
        assertTrue(replicaShard.getIndexer().config().isReadOnlyReplica());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(noopTombstone.docs(), hasSize(1));
                IdFieldMapper.NAME,
            () -> shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {
import static org.hamcrest.Matchers.hasSize;
        }
            .build();
            .settings(settings)
        assertNotEquals(meta, new ShardStateMetadata(!meta.primary, meta.indexUUID, randomAllocationId(), meta.indexDataLocation));
            .settings(settings)
            }
            .build();
        });
    }
        // failure is skipped as "shutting down").
                            .map(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            }, TimeValue.timeValueSeconds(30));
     * catalog API) rather than the legacy {@code getSegmentInfosSnapshot()}. After indexing and refreshing,
            ShardRoutingState.INITIALIZING,
                throw new UnsupportedOperationException("get your numbers straight");
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                        @Override
    }
    public void testMinimumCompatVersion() throws IOException {
                indexShard.refresh("test");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                replicaRouting.currentNodeId(),
        assertEquals(getShardStateMetadata(shard), shardStateMetadata);
    }
            // swallowing the exceptions and moving the file to a pending delete state
                true,
            // are thrown when there is an open file handle on a particular file. FSDirectory attempts to resolve this with hacks by
     * (the method is a no-op when segment replication is not enabled).
            flushShard(shard);
                final List<Translog.Operation> operations,
            new ShardStateMetadata(routing.primary(), shard.indexSettings().getUUID(), routing.allocationId())
        final CountDownLatch resyncLatch = new CountDownLatch(1);
        final IndexShardRecoveryException exception1 = expectThrows(
            long opPrimaryTerm = replica.getOperationPrimaryTerm() + 1;
                );
        assertThat(counter.get(), equalTo((long) delayedOperations));
        }
                final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
        }
        Settings settings = Settings.builder()
        closeShards(newShard);
        final long promotedTerm = indexShard.getPendingPrimaryTerm() + 1;
        Set<Integer> hashCodes = new HashSet<>();
                    relocating ? AllocationId.newRelocation(AllocationId.newInitializing()) : AllocationId.newInitializing()
            (shard, resyncListener) -> resyncListener.onResponse(newResyncTask())
import org.opensearch.index.IndexSettings;
        Store sourceStore = source.store();
                    newShard.routingEntry(),
                    )
import org.opensearch.index.mapper.ParseContext;
        shard.onSettingsChanged();
        primaryShard.maybeSyncGlobalCheckpoint("test");
     * Covers the defensive null-check branches in {@code acquireLastIndexCommit},
        long initialTotalTime = shard.refreshStats().getExternalTotalTimeInMillis();
                final List<Translog.Operation> operations,
import org.opensearch.index.engine.NRTReplicationEngine;
            assertNotNull(getResult.searcher()); // make sure get uses the wrapped reader
     * When the primary-replica resync fails, its onFailure must clear the in-progress flag and fail the shard (since the shard is
            primary.awaitShardSearchActive(refreshed -> {
            allocationId,
import org.opensearch.test.DummyShardLock;
        shard.getIndexer().translogManager().rollTranslogGeneration(); // isolate the delete in it's own generation
    }
                public void onBeginTranslogRecovery() {
        IndexShard indexShard = newStartedShard(isPrimary);
        recoveryThread.join();
        for (int i = 0; i < 10; i++) {
        assertDocs(primary, "1", "2");
     */
        assertTrue(primary.getIndexer().refreshNeeded());
            }
        closeShards(primary, replica);
        final IndexShard replicaShard = newStartedShard(
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
        ShardStateMetadata.FORMAT.writeAndCleanup(shardStateMetadata, shardPaths);
            replicaSettings,
        // No engine yet: onSettingsChanged must not start the task.
        // this test indexes docs on a primary, refreshes, then recovers a new Search Replica and asserts
            () -> {},
            assertNull(result.v2());
                ).getMessage(),
                    }, listener::onFailure)
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
                }
                    } catch (InterruptedException e) {
    public void testRunUnderPrimaryPermitDelaysToExecutorWhenBlocked() throws Exception {
                () -> assertThat(indexShard.getActiveOperationsCount(), equalTo(1)),
                throw new RuntimeException(e);
            primary.getLastSearcherAccess()
        assertTrue(primary.getIndexer().refreshNeeded());
                } else {
        assertTrue(primary.scheduledRefresh());
                                }
                switch (result.getResultType()) {
            assertThat(shard.refreshStats().getTotal(), equalTo(initialRefreshes + i));
        if (randomBoolean()) {
        assertTrue(primary.getIndexer().refreshNeeded());
        indexShard.acquireReplicaOperationPermit(
        RemoteTranslogStats remoteTranslogStats = shardStats.getStats().getTranslog().getRemoteTranslogStats();
     * here we are simulating the scenario that happens when we do async shard fetching from GatewaySerivce while we are finishing
            }
        IndexFieldData.Global ifd = indexFieldDataService.getForField(foo, "test", () -> {
                @Override
            public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
            shard.getOperationPrimaryTerm(),
                        }
        closeShards(corruptedShard);
            .build();
        target = reinitShard(target, routing);
import org.opensearch.index.fielddata.IndexFieldDataCache;
            Settings.EMPTY,
        randomReplicaOperationPermitAcquisition(
        replica.advanceMaxSeqNoOfUpdatesOrDeletes(currentMaxSeqNoOfUpdates);
            randomAlphaOfLength(8),
        );
                expectThrows(
    }
                cyclicBarrier.await();
            shardPath,
                r.close();
        ShardRouting routing = ShardRoutingHelper.initWithSameId(
                    onResponse.set(true);
        // ensure we are not influencing the indexing stats
                )
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                }
        private final int localCheckpoint;
                assertThat(indexShard.getOperationPrimaryTerm(), equalTo(newPrimaryTerm));
            TimeValue.timeValueMinutes(1L)
        for (ReferenceManager.RefreshListener refreshListener : target.getIndexer().config().getInternalRefreshListener()) {
            true,
        IndexShard newShard = reinitShard(
                }
        Settings segRepSettings = Settings.builder()
        final String targetAllocationId = relocatingRouting.getTargetRelocatingShard().allocationId().getId();
            expectThrows(AlreadyClosedException.class, () -> indexShard.seqNoStats());
                } finally {
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            assertThat("current routing:" + shard.routingEntry(), shard.routingEntry().relocating(), equalTo(true));
            long prevAccessTime = shard.getLastSearcherAccess();
            replica.getLastKnownGlobalCheckpoint(),
        builder.startObject();
                        throw new RuntimeException(e);
        assertEquals(
import static org.hamcrest.Matchers.hasToString;
                assertThat(threadPool.relativeTimeInMillis(), greaterThan(shard.getLastSearcherAccess()));
            /*
    public void testShardActiveDuringInternalRecovery() throws IOException {
        primary.runTranslogRecovery(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                public void onResponse(final Releasable releasable) {
                        throw new RuntimeException(ex);
        }, false, true);
        closeShards(newShard);
                final String expectedThreadPoolName = executorOnDelay.equals(ThreadPool.Names.SAME)
    }
                public void onResponse(final Releasable releasable) {
        // (remember stack trace is filled when exception is instantiated)
        final IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();
            Settings.EMPTY
    public void testReaderWrapperIsUsed() throws IOException {
        closeShards(indexShard);
            }
            // Should have checked stats exactly once and returned — no polling loop
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertBusy(() -> assertTrue(primary.isSearchIdle()));
        closeShards(corruptedShard2);
                indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
        shard.applyIndexOperationOnReplica(
            .build();
        long numDocs = randomLongBetween(1, 20);
        IndexShard replica = newShard(
                )
        assertThat(primary.recoveryState().getTranslog().recoveredOperations(), equalTo(numTotalEntries - numCorruptEntries));
                closeDoneLatch.countDown();
        CountDownLatch snapshotCompletedLatch = new CountDownLatch(1);
        shard.getIndexer().translogManager().rollTranslogGeneration();
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        // initialize the local knowledge on the primary of the persisted global checkpoint on the replica shard
        recoverReplica(replica, primary, (shard, discoveryNode) -> new RecoveryTarget(shard, discoveryNode, recoveryListener, threadPool) {
                final DocsStats docStats = indexShard.docStats();
        try {
        indexOnReplicaWithGaps(shard, between(0, 1000), Math.toIntExact(shard.getLocalCheckpoint()));
                        "{\"foo\" : \"bar}".getBytes(Charset.forName("UTF-8")),
        ShardRouting targetRouting = newShardRouting(
                Math.toIntExact(numDocsToDelete),
        try (Engine.GetResult getResult = shard.get(new Engine.Get(false, false, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))))) {
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
                public void onFailure(final Exception e) {
     * If the primary-replica resync never completes, the resync timeout clears the in-progress flag so the promoted primary can
            ShardStateMetadata shardStateMetadata = load(logger, env.availableShardPaths(id));
    /**
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(2L + i - 1));
        final int replicaGlobalCheckpoint = randomIntBetween(
                assertFalse(onResponse.get());
                indexShard.applyIndexOperationOnReplica(
        assertThat(indexShard.getActiveOperationsCount(), equalTo(0));
        assertTrue(primary.getIndexer().refreshNeeded());
            closeShards(indexShard);
            ShardRoutingState.INITIALIZING,
        final IndexShard primaryTarget = newShard(primarySource.routingEntry().getTargetRelocatingShard());
        AtomicInteger postIndexCreate = new AtomicInteger();
        assertEquals(1, latch.getCount());
        } while (primary.isSearchIdle());
            {
        }
            indexShard.getLastKnownGlobalCheckpoint(),
            }
             * If one thread tried to set the primary term to a higher value than the other thread and the thread with the higher term won
            try {
        // try to start another time shard on corrupted files
         * This operation completing means that the delay operation executed as part of increasing the primary term has completed and the
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        Thread[] indexThreads = new Thread[numThreads];
            shard.getThreadPool()
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                    @Override
        assertEquals(TimeValue.timeValueMinutes(1), flushTask.getInterval());
            1,
        String remoteStorePath = createTempDir().toString();
        assertThat(primaryTarget.getLocalCheckpoint(), equalTo(totalOps - 1L));
        shard.applyIndexOperationOnReplica(
            } else {
        indexShard.flush(new FlushRequest());
            }
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        if (randomBoolean()) {
        recoverReplica(shard, primary, true, (a) -> null);
        // recovery can be now finalized
        flushShard(source); // only flush source
        if (randomBoolean()) {
            new SourceToParse(shard.shardId().getIndexName(), "id-3", new BytesArray("{}"), MediaTypeRegistry.JSON)
    }
        indexShard.updateGlobalCheckpointOnReplica(globalCheckpointOnReplica, "test");
        }));
        } else {
                try (Releasable dummy = r) {
        // Execute the periodic flush task
            null
    public void testTranslogFactoryForReplicaShardWithoutRemoteStore() throws IOException {
            }
            Translog.Operation operation;
        closeShards(shard);
                replicaRouting.currentNodeId(),
        assertEquals(2, postIndex.get());
            null,
        }
    public void testRelocateMissingTarget() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            UUID.randomUUID().toString(),
    public void testGetChangesSnapshotThrowsAssertForSegRep() throws IOException {
            // now loop until we are fast enough... shouldn't take long
            .putMapping("{ \"properties\": {} }")
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1);
                try {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .settings(
        tracker.addUploadBytesSucceeded(randomIntBetween(1, bytesStarted / 2));
            try {
     * the close thread holds {@code engineMutex} and waits for {@code writeLock}, while the
        CountDownLatch latch1 = new CountDownLatch(1);
            assertThat(shard.refreshStats().getTotalTimeInMillis(), greaterThanOrEqualTo(initialTotalTime));
        ShardPath shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
        assertTrue(primary.getIndexer().refreshNeeded());
        int localCheckpoint = offset;
         * gaps are filled.
        final IndexShard shard = newStartedShard(true);
            @Override
                    null
        IndexMetadata metadata = IndexMetadata.builder("test")
        IndexingOperationListener listener = new IndexingOperationListener() {
        assertFalse(indexShard.getReplicationTracker().isPrimaryMode());
        Store.MetadataSnapshot storeFileMetadatas = newShard.snapshotStoreMetadata();
                }
import org.apache.lucene.store.IOContext;
        IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
        IndexShardTestCase.updateRoutingEntry(shard, routing);
        assertEquals(1, preDelete.get());
        final Snapshot snapshot = new Snapshot("foo", new SnapshotId("bar", UUIDs.randomBase64UUID()));
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
            readonlyShardRouting,
        final AtomicBoolean synced = new AtomicBoolean();
            .build();
        );
                    assertThat(e, instanceOf(ShardNotInPrimaryModeException.class));
     *
            } else {
    }
                switch (result.getResultType()) {
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
     * Randomizes the usage of {@link IndexShard#acquireReplicaOperationPermit(long, long, long, ActionListener, String, Object)} and
    public void testOperationPermitsOnPrimaryShards() throws Exception {
            public void restoreShard(
        final Indexer beforeRollbackIndexer = indexShard.getIndexer();
        );
                startRecovery.await();
        final IndexShard primaryShard = newStartedShard(
        Settings settings = Settings.builder()
                    List<String> exposedDocIds = EngineTestCase.getDocIds(getEngine(shard), rarely())
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(2L + i));
     * Verifies {@code freezeForTiering} now throws {@link UnsupportedOperationException} on a non-DFA
        }
        IndexShard indexShard = null;
                    try {
            futures.add(threadId, future);
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
            isPrimaryMode = true;
        indexDoc(shard, "_doc", "1");
            when(behindStat.getCurrentReplicationTimeMillis()).thenReturn(0L);
                if (engineClosed) {
    public void testPeriodicFlushTaskStartedForIngestionIndex() throws Exception {
import static org.hamcrest.Matchers.containsString;
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
            throw new RuntimeException(e);
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = shard.getRemoteStoreStatsTrackerFactory()
        IndicesFieldDataCache indicesFieldDataCache = new IndicesFieldDataCache(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    proceedWithCreationLatch.await(30, TimeUnit.SECONDS);
import org.apache.lucene.search.TermQuery;
            Engine.Warmer warmer = reader -> {
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
        delayedOperationsLatch.await();
            .seqNoStats(shard.seqNoStats())
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(remoteSegmentTransferTracker.getUploadBytesFailed(), remoteSegmentStats.getUploadBytesFailed());
        shard = reinitShard(shard);
            null
        assertTrue(getResult.exists());
            ReplicationFailedException.class,
            });
        closeShard(shard, false);
                indexShard.updateRetentionLeasesOnReplica(
    /**
            indexShard.completionStats();
            indexShard.getGlobalCheckpointSyncer(),
            shard.addShardFailureCallback((ig) -> failureCallbackTriggered.set(true));
            ),
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    /**
                } finally {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            primaryTerm,
            new IndexShardRoutingTable.Builder(primaryRouting.shardId()).addShard(primaryRouting).build(),
            allocationId = randomBoolean() ? null : randomAllocationId();
                    barrier.await();
                            .stream()
            });
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        assertThat(
        final ForceMergeRequest secondForceMergeRequest = new ForceMergeRequest().maxNumSegments(1);
        latch.await();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final Path indexPath = shardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
                throw new RuntimeException(e);
    public void testRollbackReplicaEngineOnPromotion() throws IOException, InterruptedException {
            assertThat(after.getMemorySizeInBytes(), equalTo(0L));
                Collections.singleton(indexShard.routingEntry().allocationId().getId()),
        final IndexShard shard = newStartedShard(true);
        Files.walkFileTree(indexPath, corruptedVisitor);
            }
        snapshot = newShard.snapshotStoreMetadata();
                .externalRefreshListener(config.getExternalRefreshListener())
        if (engineClosed == false) {
import java.util.concurrent.TimeUnit;
        assertEquals(versionCreated.luceneVersion, test.minimumCompatibleVersion());
            Collections.singleton(primaryRouting.allocationId().getId()),
                        indexShard.getMaxSeqNoOfUpdatesOrDeletes(),
            }))
        );
        Engine.IndexResult doc = indexDoc(primary, "_doc", "1", "{\"foo\" : \"bar\"}");
        );
        // ensure relocated successfully once pending operations are done
        testRestoreShardFromRemoteStore(false);
        recoverShardFromStore(primary);
            null,
        assertEquals(1, postIndexCreate.get());
            replayedOps = 5;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new ShardStateMetadata(routing.primary(), shard.indexSettings().getUUID(), routing.allocationId())
            () -> indexShard.acquireAllReplicaOperationsPermits(
            IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.DOCREP_NON_MIGRATING)
            .primaryTerm(0, 1)
                SnapshotId snapshotId,
            2,
        final long currentTranslogGeneration = getTranslog(indexShard).getGeneration().translogFileGeneration;
            .build();
     * Verifies {@code onMergesDrained} now throws {@link UnsupportedOperationException} on a non-DFA
            Settings.builder()
    @Override
    /**
        corruptedMarkerCount.set(0);
            indexDoc(shard, "_doc", "test");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        primary.markAsRecovering(
        shard.refresh("created segment 1");
                newShard,
                }
                .getLocalCheckpoint(),
        settings = Settings.builder().put(settings).put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO).build();
            true,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            () -> synced.set(true),
        assertTrue(recoverFromStore(newShard));
    }
            globalCheckpoint,
    }
        );
        proceedWithCreationLatch.countDown();
        AtomicInteger postIndexUpdate = new AtomicInteger();
                });
        cyclicBarrier.await();
import org.opensearch.index.fielddata.FieldDataStats;
import java.nio.file.SimpleFileVisitor;
            routing.currentNodeId(),
        // Task should be closed after shard close
            RetentionLeaseSyncer.EMPTY,
            } catch (InterruptedException e) {
            thread.join();
        final long globalCheckpoint,
        ShardRouting origRouting = shard.routingEntry();
            new RecoveryState(primary.routingEntry(), IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()), null)
                replicaRouting.currentNodeId(),
     * The predicate that decides whether a shard's translog lives in the remote store drives both the recovery-time
            IndexShardTestCase.updateRoutingEntry(shard, origRouting);
            )
        }
            randomAlphaOfLength(10),
import org.opensearch.index.mapper.MapperService;
        closeShard(replica, false);
                        .stream()
            snapshot,
            assertion.run();
            null
            true,
                    assertThat(indexShard.getLocalCheckpoint(), equalTo(expectedLocalCheckpoint));
        indexShard.updateShardState(
        assertTrue("engine reset should complete", engineResetLatch.await(30, TimeUnit.SECONDS));
            thread.join();
                    shard.store().getMetadata(wrappedIndexCommit.get());
            null,
        assertThat(noopDoc.getField(SeqNoFieldMapper.TOMBSTONE_NAME).numericValue().longValue(), equalTo(1L));
                } finally {
                        fail("unexpected result type:" + result.getResultType());
        recoveryEmptyReplica(indexShard, randomBoolean());
        for (int i = 0; i < numberOfAcquisitions; i++) {
            primaryTerm = source.getOperationPrimaryTerm();
                )
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
        final AtomicReference<Exception> onFailure = new AtomicReference<>();
import org.opensearch.index.store.Store;
            List.of(target.store().directory().listAll()).containsAll(lastCommitedSegmentsInSource)
        } catch (RuntimeException ex) {
    public void testStressRelocated() throws Exception {
        Settings primarySettings = Settings.builder()
                    @Override
            assertEquals(shardStateMetadata, state3);
        }
                exceptionToThrow.set(() -> new CorruptIndexException("Test CorruptIndexException", "Test resource"));
        );
            Settings.builder()
            warmerBlocking.countDown();
                break;
    /**
                @Override
                )
        IndexMetadata metadata = IndexMetadata.builder("test")
            IndexMetadata.builder("remote")
                    } catch (final BrokenBarrierException | InterruptedException e) {
                replicaRouting.allocationId()
        final IndexShard shard = newStartedShard(true);
        }
    }
            newShardRouting(
            .primaryTerm(0, 1)
        assertThat(relocated.get(), equalTo(false));
        final IndexShard readonlyShard = reinitShard(
            shardId,
            }
import org.opensearch.action.admin.indices.stats.CommonStats;
            try {
                    throw new AssertionError(e);
        }
        shard.indexSettings().updateIndexMetadata(updated);
            .build();
        assertThat(
                    indexShard.acquirePrimaryOperationPermit(permitAcquiredFuture, ThreadPool.Names.SAME, "bla");
            operation2 = acquireReplicaOperationPermitBlockingly(indexShard, primaryTerm);
     * engine. Same rationale as the {@code onMergesDrained} test — tiering only targets DFA shards,
                    n -> new Translog.Index(
        final long pendingPrimaryTerm = indexShard.getPendingPrimaryTerm();
                }
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
        return fut.get();
        closeShards(primary);
            .build();
    public void testRecoveryFailsAfterMovingToRelocatedState() throws InterruptedException, IOException {
        final long globalCheckpoint = randomLongBetween(shard.getLastKnownGlobalCheckpoint(), shard.getLocalCheckpoint());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        // Override two Directory methods to make them fail at our will
                final DocsStats docsStats = indexShard.docStats();
        assertEquals(1, latch1.getCount());
            new SourceToParse(indexName, "doc-2", new BytesArray("{}"), MediaTypeRegistry.JSON)
            randomFrom(ShardStateMetadata.IndexDataLocation.values())
            @Override
    }
        indexDoc(indexShard, "_doc", "0");
        shard.applyIndexOperationOnReplica(
        closeShards(indexShard);
                                    newGlobalCheckpoint + 1,
        {
    }
        TranslogStats translogStats = shard.translogStats();
                } else {
        /*
            allocationId = AllocationId.newRelocation(allocationId);
        }
        IndexShard shard = newStartedShard(p -> newShard(true, mock), true);
        } catch (RuntimeException e) {
    }
        assertFalse(primary.getIndexer().refreshNeeded());
        assertSame(flushTask, primary.getPeriodicFlushTask());
            AllocationId.newRelocation(routing.allocationId())
            false,
        assertThat(exception2.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
import org.opensearch.action.index.IndexRequest;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * when the resync response is lost. Waits until the resync has been handed to the syncer and returns the new primary routing.
                try (GatedCloseable<IndexCommit> wrappedSafeCommit = shard.acquireSafeIndexCommit()) {
            RetentionLeaseSyncer.EMPTY,
    ) {
        IndexShardTestCase.updateRoutingEntry(target, routing.moveToStarted());
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            replicaRouting.shardId(),
                Version.CURRENT,
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import static org.hamcrest.Matchers.everyItem;
                RetentionLeaseSyncer.EMPTY,
        assertFalse(primary.getPeriodicFlushTask().isClosed());
                "test"
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
        }
        final ShardRouting shardRouting = newShardRouting(
     * wiring bug, and the typed surface surfaces it loudly rather than silently firing the listener.
                assertTrue(store.isMarkedCorrupted());
                try (Releasable dummy = r) {
        expectThrows(
            true,
            null
                super.prepareForTranslogOperations(totalTranslogOps, ActionListener.wrap(r -> {
                } finally {
            RetentionLeaseSyncer.EMPTY,
                    totalTranslogOps,
            verify(spyShard, times(1)).getReplicationStatsForTrackedReplicas();
            assertThat(e, instanceOf(IllegalStateException.class));
            } else {
        try (Engine.Searcher searcher = primary.acquireSearcher("test")) {
        assertTrue(indexShard.isRelocatedPrimary());
        if (performFlush) {
                if (singlePermit) {
        final IndexShard otherShard = newStartedShard(false);
                    listener.onResponse(r);
        final CountDownLatch latch = new CountDownLatch(operations);
                    default:
                public void onAfterTranslogRecovery() {
        final IndexShard indexShard;
    private void populateSampleRemoteSegmentStats(RemoteSegmentTransferTracker tracker) {
            public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
            indexShard.engineConfigFactory,
        primary.refresh("test");
        newShard.markAsRecovering("store", new RecoveryState(routing, localNode, null));
            // it's not called when store is marked as corrupted
        indexShard.updateGlobalCheckpointOnReplica(globalCheckpointOnReplica, "test");
        // Setting is enabled at creation, but the shard has no engine yet. A settings change in this
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(createTempDir());
            indexDoc(shard, "_doc", Integer.toString(i));
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
            } catch (final BrokenBarrierException | InterruptedException e) {
            assertEquals(shardStateMetadata, state1);
            final long globalCheckpoint = replica.getLastKnownGlobalCheckpoint();
        // Periodic flush task should be started
        assertThat(secondForceMergeUUID, equalTo(firstForceMergeRequest.forceMergeUUID()));
        first.join();
        } finally {
            null,
                }
        final IndexShard primaryShard = newShard(
            target.getReplicationTracker()
        } finally {
            {
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
                                    lease.id(),
                try {
        Settings replicaSettings = Settings.builder()
        indexDoc(source, "_doc", "2");
            );
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
                        listener.onResponse(checkpoint);
        }
            }, ThreadPool.Names.SAME, "test");
            .settings(settings)
            globalCheckpoint,
        assertFalse(shard.isRelocatedPrimary());
        final Releasable allPermits = futureAllPermits.get();
            () -> newStartedShard(p -> replicaCorrupted, true)
            RetentionLeaseSyncer.EMPTY,
        try (Store store = createStore(replica.indexSettings(), searchReplicaShardPath)) {
        if (randomBoolean()) {
        });
    }
            TopDocs search = searcher.search(new TermQuery(new Term("foo", "bar")), 10);
    public void testIndexingOperationListenersIsInvokedOnRecovery() throws IOException {
        snapshotThread.join();
        // The ReadOnlyEngine is now the current engine, but newEngineReference is still null.
            final String executorOnDelay = randomFrom(
                    "local_node",
        } catch (IndexShardRelocatedException expected) {}
        closeShards(newShard);
        );
        AtomicBoolean stop = new AtomicBoolean(false);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
            indexShard.getPendingPrimaryTerm() + 1,
                }
        shard.close("Unexpected close", true, false);
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
            final int threadId = i;
        final IndexShard shard = newStartedShard(true);
                    } catch (InterruptedException e) {
        closeShard(indexShard, false);
            );
                final long maxSeqNoOfUpdatesOrDeletes,
import org.opensearch.index.remote.RemoteSegmentStats;
                );
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
         * - If flush and then recover from the existing store, delete #1 will be removed while index #0 is still retained and replayed.
        engineResetLatch.await();
                            releasable.close();
        assertTrue("engine creation should start", creatingEngineLatch.await(30, TimeUnit.SECONDS));
            }
        );
            permit.close();
        indexDoc(primary, "_doc", "1");
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
        final ShardRouting replicaRouting = indexShard.routingEntry();
        closeShards(test);
            after = shard.fieldData().stats("foo");
        recoverShardFromStore(replica);
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        assertThat(shard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNoBeforeRollback));
    public void testRefreshMetric() throws IOException {
        int numTotalEntries = randomIntBetween(0, 10);
        assertEquals(0, indexingStats.getTotal().getIndexFailedCount());
     * replica is a wiring bug and the assertion surfaces it loudly.
import java.util.concurrent.ExecutionException;
        // check that corrupt marker is there
        );
        IndexShardTestCase.updateRoutingEntry(shard, routing);
     */
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        );
                    try {
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        );
        assertEquals(1, newShard.recoveryState().getTranslog().totalOperationsOnStart());
    }
        assertEquals(TimeValue.timeValueSeconds(30), flushTask.getInterval());
        final IndexShard indexShard = newStartedShard(true);
                future.actionGet();
            null
         */
            Collections.singleton(replicaRouting.allocationId().getId()),
                SeqNoFieldMapper.PRIMARY_TERM_NAME
    }
                if (!gap && i == localCheckpoint + 1) {
                // corrupt entry
            });
                @Override
        );
        recoverFromStore(readonlyShard);
            primarySettings,
            shard.shardPath(),
        indexDoc(shard, "_doc", "0");
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            true,
        Store.MetadataSnapshot snapshot = newShard.snapshotStoreMetadata();
                    throw new AssertionError(e);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // The syncer immediately completes the resync listener successfully.
                .mapToObj(
        } finally {
    }
            equalTo(false)
        snapshotter.start();
        }
import org.opensearch.index.mapper.SeqNoFieldMapper;
                            postIndexUpdate.incrementAndGet();
                        newGlobalCheckPoint,
                                fail();
        thread.start();
        IndexShard shard = newStartedShard(true);
        // onFailure must clear the flag and, because the shard is not closed, fail the shard.
            ShardRoutingState.INITIALIZING,
        );
            }
        final CyclicBarrier barrier = new CyclicBarrier(2);
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
                targetShard.recoverFromLocalShards(mappingConsumer, Arrays.asList(sourceShard, differentIndex), future);
    /***
                });
     */
        final IndexShard shard = newStartedShard(false);
        final AtomicLong counter = new AtomicLong();
        }
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        assertDocCount(shard, 2);
                final ActionListener<Long> listener
            // Windows has buggy File delete logic where AccessDeniedExceptions
        closeShards(source);
        snapshot = newShard.snapshotStoreMetadata();
        closeShards(indexShard);
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        ShardStateMetadata shardStateMetadata = load(logger, shardPath.getShardStatePath());
            primarySettings,
                snapshot,
        final long externalRefreshCount = shard.refreshStats().getExternalTotal();
        assertEquals(TimeValue.timeValueMinutes(1), flushTask.getInterval());
                    mappingVersion,
     * a recovery and concurrently clean files. This should always be possible without any exception. Yet there was a bug where IndexShard
                new ActionListener<Releasable>() {
            shard,
                if (ids.add(id) == false) { // this is an update
            .build();
            recoveryThread.start();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexShard source = newStartedShard(
            null,
        );
        assertThat(shard.docStats().getCount(), equalTo(numDocs));
    }
        IndexShard replica = newStartedShard(false);
        final CountDownLatch latch = new CountDownLatch(1);
                    Settings.builder()
            }
        final ShardRouting originalRouting = shard.routingEntry();
        final Path indexPath = searchReplicaShardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            EMPTY_EVENT_LISTENER,
 * not use this file except in compliance with the License.
                .analyzer(config.getAnalyzer())
        assertTrue("at least 2 files, commit and data: " + storeFileMetadatas.toString(), storeFileMetadatas.size() > 1);
                final long maxSeqNoOfUpdatesOrDeletes,
import java.util.concurrent.atomic.AtomicBoolean;
            .build();
                return delete;
        );
            false,
            case 2: {
        indexDoc(indexShard, "_doc", "0");
                    @Override
        shard.acquireAllReplicaOperationsPermits(shard.getOperationPrimaryTerm(), globalCheckpoint, 0L, ActionListener.wrap(r -> {
        searchReplicaShardRouting = ShardRoutingHelper.moveToUnassigned(
            EMPTY_EVENT_LISTENER,
import static org.mockito.Mockito.when;
                ShardRouting routing = newShardRouting(
                    Settings.builder()
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            indexShard = newStartedShard(
    public void testResetEngineWithBrokenTranslog() throws Exception {
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        IndexMetadata updated = IndexMetadata.builder(current)
        // but index can't be opened for a failed shard
            @Override
    }
    public void testRejectOperationPermitWithHigherTermWhenNotStarted() throws IOException {
        assertNotNull(flushTask);
        return promoteReplicaWithResyncSyncer(replica, (shard, resyncListener) -> {});
        final long initialRefreshes = shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false ? 2L : 3L;
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
                ActionListener.completeWith(listener, () -> {
        closeShardThread.start();
            if (randomBoolean()) {
import org.opensearch.index.engine.exec.IndexerFactory;
        indexDoc(target, "_doc", "1");
            }, Assert::assertNotNull),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            indexThreads[i].start();
        Engine.IndexResult indexResult = indexDoc(shard, "some_type", "0", "{\"foo\" : \"bar\"}");
                } catch (final InterruptedException e) {
            final boolean corruptIndexException = randomBoolean();
                    delayedOperationsBarrier.await();
        SourceToParse sourceToParse = new SourceToParse(shard.shardId().getIndexName(), "1", new BytesArray("{}"), MediaTypeRegistry.JSON);
        assertEquals(
    public void testSearchIsReleaseIfWrapperFails() throws IOException {
        allowShardFailures();
        try {
                invoked.set(true);
        for (Thread indexThread : indexThreads) {
                    .getLocalCheckpoint(),
        try (Store store = createStore(shardId, new IndexSettings(metadata, Settings.EMPTY), directory, shardPath)) {
                    shardId,
            final IndexShard newShard = reinitShard(targetShard);
        primaryShard.maybeSyncGlobalCheckpoint("test");
        assertThat(newShard.getLocalCheckpoint(), equalTo(totalOps - 1L));
        IndexShard newShard = newShard(
        }
        IndexMetadata metadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1).build();
import java.util.ArrayList;
                    assertEquals(file.recovered(), file.length());
import org.opensearch.common.util.concurrent.AtomicArray;
    public void testRestoreShard() throws IOException {
        assertDocs(target, "1");
        // promote the replica
                        1,
        assertEquals(shard.fieldData().stats("foo").getEvictions(), before.getEvictions());
            }
        closeShard(shard, false);
            while (done.get() == false) {
            assertEquals(search.totalHits.value(), 1);
        try {
        CountDownLatch latch1 = new CountDownLatch(1);
                indexShard = newStartedShard(false);
                            public void onResponse(Releasable releasable) {
            0L,
        assertThat(deleteDoc.getField(IdFieldMapper.NAME).binaryValue(), equalTo(Uid.encodeId(id)));
        Thread recoveryThread = new Thread(() -> expectThrows(AlreadyClosedException.class, () -> recoverShardFromStore(shard)));
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                    ActionListener.wrap(checkpoint -> {
                SeqNoFieldMapper.NAME,
            indicesFieldDataCache,
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
        ShardStateMetadata meta = new ShardStateMetadata(
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
     * Simulates a scenario that happens when we are async fetching snapshot metadata from GatewayService
        assertDocs(replica, "1", "2");
        final PlainActionFuture<Releasable> futureAllPermits = new PlainActionFuture<Releasable>() {
            assertTrue(recoverFromStore(newShard));
                assertThat(indexShard.getOperationPrimaryTerm(), equalTo(primaryTerm));
                    throw new RuntimeException(e);
            }
            indexMetadata.build(),
        final IndexShard indexShard = newShard(false);
        shard.forceMerge(firstForceMergeRequest);
    }
        int iters = iterations(5, 10);
        assertEquals(1, postDelete.get());
                        postDelete.incrementAndGet();
    /**
            1,
        }
                IntStream.range(0, Math.toIntExact(numDocs)).boxed().collect(Collectors.toList())
        CountDownLatch warmerBlocking = new CountDownLatch(1);
        assertEquals(remoteTranslogTransferTracker.getUploadBytesStarted(), remoteTranslogStats.getUploadBytesStarted());
                return delete;
        indexDoc(primary, "_doc", "2", "{\"foo\" : \"bar\"}");
            if (i < recoveryIndex) {
            throw new UnsupportedOperationException("search lookup not available");
                    IndexShardTestUtils.getFakeDiscoNode(newShard.routingEntry().currentNodeId()),
        final IndexShard indexShard = newStartedShard(true);
            shardId,
                        },
     * download (which may reuse local generations) and the discard of a local copy proven corrupt. The two must agree:
            assertThat(indexShard.getActiveOperationsCount(), is(oneOf(0, IndexShard.OPERATIONS_BLOCKED)));
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .build();
                        closeDoneLatch.await();
        } finally {
        }
            error.getMessage(),
import org.opensearch.test.FieldMaskingReader;
            .settings(settings)
            )
            randomAlphaOfLength(8),
        final ShardPath searchReplicaShardPath = replica.shardPath();
            indexMetadata,
            ifd.loadGlobal(searcher.getDirectoryReader());
            shard.getGlobalCheckpointSyncer(),
import org.opensearch.index.engine.CommitStats;
            .primaryTerm(0, 1)
        indexDoc(shard, "_doc", "1");
import static org.hamcrest.Matchers.hasKey;
        return shard.getIndexerOrNull();
        ) {
    }
            );
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                    indexShard.shardId().getIndexName(),
        );
        closeShards(target);
                metadata,
                startRecovery.countDown();
        assertEquals(0, indexShard.getActiveOperationsCount());
        shard.updateLocalCheckpointForShard(shard.shardRouting.allocationId().getId(), 0);
        int totalOps = randomInt(10);
            .build();
                }
            }
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
        assertFalse(flushTask.isClosed());
 */
    }
            logger.info("--> flushing shard");
        shard.markAsRecovering("for testing", new RecoveryState(shard.routingEntry(), localNode, null));
        final String secondForceMergeUUID = ((InternalEngine) ((EngineBackedIndexer) shard.getIndexer()).getEngine()).getForceMergeUUID();
        assert localCheckpoint == indexShard.getLocalCheckpoint();
                                try {
            EMPTY_EVENT_LISTENER,
                        // if rollback happens we roll translog twice: one when we flush a commit before opening a read-only engine
        }
            },
            assertTrue(
                    }
                    docsStats.getTotalSizeInBytes(),
                ),
            AssertionError e = expectThrows(AssertionError.class, () -> replica.onMergesDrained(() -> {}));
        recoveryEmptyReplica(indexShard, randomBoolean());
            assertEquals(0, shard.getActiveMergeCount());
    public void testReadOnlyReplicaEngineConfig() throws IOException {
        tracker.addUploadBytesStarted(30L);
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
import static org.hamcrest.Matchers.equalTo;
        if ((e = onFailure.get()) != null) {
        for (Thread thread : threads) {
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
        assertBusy(() -> assertTrue("a failed resync must fail the shard", shardFailed.get()));
        for (String file : storeDirectory.listAll()) {
            @Override
    public void testRefreshIsNeededWithRefreshListeners() throws IOException, InterruptedException {
        closeShard(shard, false);
        barrier.await();
     * Promotes a started replica to primary with a primary-replica resync whose listener never completes, which is what happens
    public void testShardStateMetaHashCodeEquals() {
        );
        }
import org.opensearch.cluster.routing.TestShardRouting;
        }
        }
            public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {
            warmerStarted.await();
import org.apache.lucene.index.DirectoryReader;
        CountDownLatch latch = new CountDownLatch(1);
        final Exception e;
    public void testCheckpointRefreshListenerWithNull() throws IOException {
            operation2 = null;
            @Override
                    allOperationsDone.countDown();
        // we wait for both operations to complete
            assertThat("we have to have more than one segment", searcher.getDirectoryReader().leaves().size(), greaterThan(1));
        }
                final long maxSeenAutoIdTimestamp,
     * This test simulates a scenario seen rarely in ConcurrentSeqNoVersioningIT. Closing a shard while engine is inside
            .settings(settings)
                    randomReplicaOperationPermitAcquisition(
        assertNull("periodic flush task must not start before an engine exists", primary.getPeriodicFlushTask());
import org.apache.lucene.util.BytesRef;
                }
            indexShard.getRetentionLeaseSyncer(),
            deleteDoc.getFields().stream().map(IndexableField::name).collect(Collectors.toList()),
            indexShard.engineConfigFactory,
        assertFalse(primary.scheduledRefresh());
        assertFalse("closed indices should skip global checkpoint sync", synced.get());
        );
        recoveryThread.start();
        } else if (randomBoolean()) {
                        "1",
        indexDoc(shard, "_doc", "1");
        final RecoverySettings recoverySettings = new RecoverySettings(
                }
                    docsStats.getTotalSizeInBytes(),
        primary.addRefreshListener(doc.getTranslogLocation(), r -> latch1.countDown());
            ""
        indexDoc(shard, "_doc", "0");
        assertTrue("at least 2 files, commit and data: " + storeFileMetadatas.toString(), storeFileMetadatas.size() > 1);
            // OK!
        // Verify periodic flush count increased
        AtomicInteger postDelete = new AtomicInteger();
                    results.setOnce(threadId, Tuple.tuple(Boolean.FALSE, e));
        indexDoc(sourceShard, "_doc", "0", "{\"foo\" : \"bar\"}");
        RemoteSegmentStats remoteSegmentStats
        for (String file : remoteDirectory.listAll()) {
        indexDoc(primary, "_doc", "2");
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        } finally {
         * - index #5
                    throw new AssertionError(e);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertFalse("Catalog snapshot should have files after indexing", catalogFiles.isEmpty());
        try {
    public void testShardDoesNotStartIfCorruptedMarkerIsPresentSearch() throws Exception {
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private Result indexOnReplicaWithGaps(final IndexShard indexShard, final int operations, final int offset) throws IOException {
                ((ReleasableRetryableRefreshListener) refreshListener).drainRefreshes();
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
            .build();
            assertThat(indexShard.getIndexer(), sameInstance(beforeRollbackIndexer));
                }
            latch.await();
        // create corrupted marker
        ).collect(Collectors.toList());
        Settings settings = Settings.builder()
        });
        // check stats on closed and on opened shard
        assertTrue(primary.getIndexer().refreshNeeded());
            }, Assert::assertNotNull),
                .settings(
     * {@code getSegmentInfosSnapshot()} through the {@code ReplicationCheckpointUpdater} refresh
                try (Engine.Searcher searcher = primary.acquireSearcher("test")) {
        final int nbTermUpdates = randomIntBetween(1, 5);
        if (shardRouting == null) {
        latch.await();
                        null,
        recoverShardFromStore(shard);
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
        assertSame(flushTask, primary.getPeriodicFlushTask());
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        final Thread[] threads = new Thread[randomIntBetween(2, 5)];
            // fileLength method is called during storeStats try block
    public void testDelegateThrowsAlreadyClosedBeforeNewEngineSet() throws Exception {
                        assertThat(indexShard.getOperationPrimaryTerm(), equalTo(primaryTerm + increment));
        assertEquals(
                IndexShardTestCase.updateRoutingEntry(indexShard, routing);
    public void testFreezeForTiering_OnReplica_TripsPrimaryAssertion() throws IOException {
                } else {
        final IndexShard indexShard = newStartedShard(true);
            final long numDocsToDelete = randomLongBetween(1, numDocs);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        closeShards(primary, replica);
        );
        CountDownLatch snapshotDoneLatch = new CountDownLatch(1);
            assertThat(counter.get(), equalTo(1L));
        final IndexShardRecoveryException exception2 = expectThrows(
                }
        private final int maxSeqNo;
            latch.countDown();
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test1")
        try (Translog.Snapshot snapshot = getTranslog(newShard).newSnapshot()) {
            )
                    recoveryStartedLatch.countDown();
                // now lock acquisition should have succeeded
        primary.refresh("test");
        );
                    primaryContext -> relocationStarted.countDown(),
        recoveryThread.join();
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        latch.await();
                ""
                assertNull(onFailure.get());
            IntStream.range(0, randomIntBetween(0, 10))
                    // just like a following shard, we need to skip this check for now.
        final long translogGen = engineClosed ? -1 : getTranslog(indexShard).getGeneration().translogFileGeneration;
    public void testWriteShardState() throws Exception {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    allPermitsAcquired.countDown();
        } finally {
        }, ThreadPool.Names.GENERIC, "");
        indexDoc(indexShard, "_doc", "1", "{}");
                GatedCloseable<SegmentInfos> snapshot = shard.getSegmentInfosSnapshot();
    }
        closeShards(primary);
                "a remote-store index is remote-backed in state " + state,
    public void testCommitLevelRestoreShardFromRemoteStore() throws IOException {
                    readyToCloseLatch.countDown();
        assertTrue(primary.scheduledRefresh());
                    () -> indexShard.acquireReplicaOperationPermit(
    }
        });
import static java.util.Collections.emptySet;
                final String id = Integer.toString(i);
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
        // deletion of segment files in the subsequent code block.
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    }
            recoverShardFromStore(newShard);
import org.opensearch.indices.recovery.RecoverySettings;
        final CountDownLatch latch = new CountDownLatch(1);
            .build();
        );
import org.apache.lucene.index.IndexCommit;
     */
                    }
            newMaxSeqNoOfUpdates,
        );
        IndexShard shard = newStartedShard();
            () -> synced.set(true),
        assertNull(primary.getPeriodicFlushTask());
                    sourceToParse
            routing.shardId(),
                            }
                break;
            .getRemoteSegmentTransferTracker(shard.shardId);
                engineClosed = false;
    }
            shard.updateLocalCheckpointForShard(shard.shardRouting.allocationId().getId(), totalOps - 1);
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        recoveryThread.join();
        assertThat(thirdForceMergeUUID, notNullValue());
        allOperationsDone.await();
        CountDownLatch creatingEngineLatch = new CountDownLatch(1);
        assertTrue(semaphore.tryAcquire(Integer.MAX_VALUE, 10, TimeUnit.SECONDS));
                shard.shardRouting.currentNodeId(),
                    assertEquals(0, operation.seqNo());
        }
            if (corruptIndexException && !throwWhenMarkingStoreCorrupted.get()) {
            .settings(settings)
import org.opensearch.indices.recovery.RecoveryTarget;
                @Override
        }
            } else {
                    } catch (Exception ex) {
            latch.countDown();
        shard.store().close();
                    private void finish() {
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
            assertEquals("idle non-DFA engine reports 0 active merges", 0, shard.getActiveMergeCount());
            return new ShardStateMetadata(shardRouting.primary(), shard.indexSettings().getUUID(), shardRouting.allocationId());
                        "1",
        final IndexShard shard = newStartedShard(true);
         */
    public void testSearchShardDoesNotStartIfCorruptedMarkerIsPresent() throws Exception {
        assertFalse(indexShard.isPrimaryReplicaResyncInProgress());
        primaryShard.updateGlobalCheckpointForShard(replicaAllocationId, primaryShard.getLastKnownGlobalCheckpoint());
        assertFalse(shard.isActive());
        );
            .primaryTerm(0, 1)
        final long globalCheckpoint = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
            indexShard = newStartedShard(false);
            }
        IndexShard shard = newStartedShard(true);
        closeShards(shard);
        }
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            1,
                for (int i = 0; i <= localCheckPoint; i++) {
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
        final CountDownLatch allPermitsAcquired = new CountDownLatch(1);
         * translog generation has rolled.
        assertThat(getShardDocUIDs(indexShard), equalTo(docsBeforeRollback));
            target.routingEntry(),
            () -> indexShard.acquireAllPrimaryOperationsPermits(null, TimeValue.timeValueSeconds(30L))
     * {@link IndexShard#resetEngineToGlobalCheckpoint()} does not block on {@code engineMutex}.
import org.opensearch.index.engine.InternalEngineFactory;
        );
            assertThat(relocationException.get(), nullValue());
            }
        assertThat(shard.refreshStats().getTotal(), equalTo(refreshCount + 2));
            assertThat("searcher was marked as accessed", shard.getLastSearcherAccess(), equalTo(prevAccessTime));
                (shardId, lockTimeoutMS, details) -> new DummyShardLock(shardId)
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(externalRefreshCount));
            .commonStats(new CommonStats(new IndicesQueryCache(Settings.EMPTY), shard, new CommonStatsFlags()))
        // Verify getCatalogSnapshot returns non-empty files (proving it's being used)
        );
        assertEquals(translogOps, newShard.recoveryState().getTranslog().recoveredOperations());
                indexShard.getLastKnownGlobalCheckpoint(),
                assertBusy(() -> {
        }
        assertTrue("engine reset should complete", engineResetLatch.await(30, TimeUnit.SECONDS));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                new EngineConfigFactory(new IndexSettings(metadata, metadata.getSettings())),
        target.remoteStore().incRef();
        final ShardRouting originalRouting = shard.routingEntry();
                assertThat(Thread.currentThread().getName(), containsString(expectedThreadPoolName));
        assertDocs(primary, "1", "2");
        closeShards(shard);
        try (Releasable ignored = acquirePrimaryOperationPermitBlockingly(shard)) {
        closeShards(indexShard);
        assertTrue("Expected no results, operations are blocked", results.asList().isEmpty());
            assertBusy(() -> assertThat(indexShard.getActiveOperationsCount(), equalTo(0)));
                try {
        Thread[] thread = new Thread[randomIntBetween(3, 5)];
        assertTrue(recoverFromStore(newShard));
 * Unless required by applicable law or agreed to in writing,
                    id
        for (long i = 0; i < numDocs; i++) {
        IndexShard indexShard = newStartedShard();
                public void onResponse(final Releasable releasable) {
            .build();
            .put(primarySettings)
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            null,
            null,
            )
                    } catch (InterruptedException e) {
        // Shard should now be active since we did recover:
            IllegalIndexShardStateException.class,
            replica,
     * Promotes a started replica to primary, driving the primary-replica resync through the supplied syncer. The syncer receives
                Settings.builder()
                .build(),
            .build();
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        closeShard(indexShard, false);
                final boolean relocating = randomBoolean();
            .build();
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
            assertTrue(getResult.exists());
        assertEquals(remoteTranslogTransferTracker.getTotalUploadsFailed(), remoteTranslogStats.getTotalUploadsFailed());
        assertTrue(primary.isSearchIdle());
    }
                new EngineBackedIndexerFactory(new InternalEngineFactory()),
            @Override
        Translog.Snapshot snapshot = TestTranslog.newSnapshotFromOperations(operations);
            "otherNode",
            primary.recoveryState().getTranslog()::incrementRecoveredOperations
    public void testTranslogRecoverySyncsTranslog() throws IOException {
        assertTrue(flushTask.isScheduled());
        } finally {
    }
        for (IndexShard.ShardMigrationState state : IndexShard.ShardMigrationState.values()) {
        };
        assertThat(shard.seqNoStats().getMaxSeqNo(), equalTo(globalCheckpoint));
            .build();
                new SourceToParse(shard.shardId.getIndexName(), Long.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON)
            indexMetadata,
        shardStateMetadata = load(logger, shardStatePath);
            randomReplicaOperationPermitAcquisition(
            3,
     */
            false,
            indexShard.routingEntry(),
                    @Override
        assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
     * @throws IOException if an I/O exception occurs while indexing on the shard
                @Override
        closeShard(indexShard, false);
import java.util.function.LongFunction;
        indexShard.flush(new FlushRequest());
import org.opensearch.index.mapper.MapperParsingException;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
     * primary-side (replicas don't run merges), so calling this method on a replica is a wiring bug
         * - roll generation (to create gen 2)
            meta.hashCode(),
                        shard.getPendingPrimaryTerm(),
        assertEquals(0, newShard.recoveryState().getTranslog().totalOperations());
            .build();
        if (Constants.WINDOWS) {
import java.util.Arrays;
                "peer",
        Randomness.shuffle(operations);
                RecoverySource.ExistingStoreRecoverySource.INSTANCE
        String historyUUID = shard.getHistoryUUID();
        // set up local checkpoints on the shard copies
        indexDoc(source, "_doc", "3");
                indexShard.getPendingPrimaryTerm(),
        IndexShard target = newStartedShard(true);
        if (isPrimary) {
            new ShardStateMetadata(meta.primary, meta.indexUUID, meta.allocationId, meta.indexDataLocation).hashCode()
        assertEquals(1, postIndexCreate.get());
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            assertTrue(ex.getMessage().contains("failed to fetch index version after copying it over"));
                exceptionToThrow.set(() -> new IOException("Test IOException"));
/*
    }
            AtomicBoolean failureCallbackTriggered = new AtomicBoolean(false);
    /**
            }
    /**
            primary.shardId,
        // check that corrupt marker is there
                }
        } catch (AlreadyClosedException e) {
        // refresh on: finalize and end of recovery
                );
        final ShardRouting primaryShardRouting = shard.routingEntry();
        final String thirdForceMergeUUID = ((InternalEngine) ((EngineBackedIndexer) shard.getIndexer()).getEngine()).getForceMergeUUID();
                    assertTrue(onResponse.get());
                });
import org.apache.lucene.index.CorruptIndexException;
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            .retentionLeaseStats(shard.getRetentionLeaseStats())
        });
        }
        closeShards(corruptedShard);
                        "{\"foo\" : \"bar}".getBytes(Charset.forName("UTF-8")),
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        target.markAsRecovering("store", new RecoveryState(routing, localNode, null));
        });
        // this test indexes docs on a primary, refreshes,
        }
    }
        final ShardId shardId = new ShardId("index", "_na_", 0);
            .build();
    public void testResetEngine() throws Exception {
        if (Assertions.ENABLED && indexShard.routingEntry().isRelocationTarget() == false) {
        recoverShardFromStore(replica);
            ShardRoutingHelper.initWithSameId(shardRouting, RecoverySource.EmptyStoreRecoverySource.INSTANCE)
                    throw new AssertionError(e);
    /**
            }
        }
        assertEquals(1, postIndexUpdate.get());
        final ShardRouting routing = ShardRoutingHelper.relocate(originalRouting, "other_node");
            } finally {
                }
    }
                        -1
                        }
 * Modifications Copyright OpenSearch Contributors. See
        final IndexShard newShard = reinitShard(shard);
        assertThat(indexShard.getLocalCheckpoint(), equalTo(maxSeqNo));
            final CountDownLatch latch = new CountDownLatch(operations);
            "an unseeded migrating shard still owns the only copy of its translog",
        source.refresh("test");
    public void testScheduledRefresh() throws Exception {
        assertThat(target.seqNoStats().getGlobalCheckpoint(), equalTo(2L));
            null
            MergedSegmentPublisher.EMPTY
            } else {
            assertTrue(result.v1());
        // create corrupted marker
        closeShards(indexShard);
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
            )
                    engineResetLatch.countDown();
import org.opensearch.index.translog.listener.TranslogEventListener;
        closeShards(shard);
                });
        IndexShardTestCase.updateRoutingEntry(shard, toNode1);
            RecoveryState recoveryState = targetShard.recoveryState();
            .primaryTerm(0, 1)
    /**
        assertEquals(1, newShard.recoveryState().getTranslog().totalOperations());
import java.nio.file.attribute.BasicFileAttributes;
        indexShard.addShardFailureCallback(ig -> shardFailed.set(true));
        assertThat(shard.refreshStats().getTotal(), equalTo(initialRefreshes));
            new SourceToParse(shard.shardId().getIndexName(), "id-5", new BytesArray("{}"), MediaTypeRegistry.JSON)
        final CountDownLatch delayedOperationsLatch = new CountDownLatch(delayedOperations);
                );
        Collection<String> uploadFiles = remoteStoreDirectory.getSegmentsUploadedToRemoteStore().keySet();
        if (shouldRollback) {
            IndexShardClosedException.class,
            shardPath,
                    true,
    public void testShardDoesNotStartIfCorruptedMarkerIsPresent() throws Exception {
            };
            indexShard.engineConfigFactory,
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        IndexShard shard = newStartedShard();
        target.refresh("test");
        final ShardRouting primaryRouting = promoteReplicaWithResyncSyncer(
    }
                latch1.countDown();
                        onResponse.set(true);
            primary.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        AtomicBoolean throwWhenMarkingStoreCorrupted = new AtomicBoolean(false);
        indexShard.relocated(relocatingRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
         */
        AtomicReference<Exception> cancellingException = new AtomicReference<>();
        assertEquals(1, postIndexUpdate.get());
            indexMetadata.build(),
        shard.refresh("test");
            ActionListener.wrap(r -> {
        if (globalCheckpointOnReplica == UNASSIGNED_SEQ_NO && globalCheckpoint == UNASSIGNED_SEQ_NO) {
        IndexShardTestCase.updateRoutingEntry(indexShard, relocatingRouting);
        final long extraInternalRefreshes = shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false ? 0 : 1;
                ThreadPool.Names.MANAGEMENT,
            shardRouting,
        recoverShardFromStore(primaryShard);
    }
                    latch.countDown();
                throw new AssertionError(e);
                return FileVisitResult.CONTINUE;
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(0, postDeleteException.get());
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            true,
import org.apache.lucene.store.Directory;
        }
            if (randomBoolean()) {
                    new Translog.Index(
            final String executor = ThreadPool.Names.WRITE;
                true,
            assertThat(shard.translogStats().estimatedNumberOfOperations(), lessThanOrEqualTo(translogStats.estimatedNumberOfOperations()));
        for (int i = 1; shard.refreshStats().getTotalTimeInMillis() == initialTotalTime; i++) {
        // check that corrupt marker is there
        );
            settings,
        );
            true,
                    + "] is no longer part of the replication group"
        target.refresh("test");
        });
            Engine.GetResult ignored = shard.get(new Engine.Get(true, false, "test", new Term(IdFieldMapper.NAME, Uid.encodeId("test"))))
            .build();
            shard.indexSettings.getIndexMetadata(),
    public void testConcurrentAcquireAllReplicaOperationsPermitsWithPrimaryTermUpdate() throws Exception {
            primary.shardId,
                .build()
                newShardRouting(
            Settings.EMPTY
        final ShardId shardId = new ShardId("index", "_na_", 0);
                SourceToParse sourceToParse = new SourceToParse(
            // we could race and assert on the count before the permit is returned
            store.markStoreCorrupted(new IOException(corruptionMessage));
        final long maxSeqNoOfUpdatesOrDeletesBeforeRollback = indexShard.getMaxSeqNoOfUpdatesOrDeletes();
import org.opensearch.index.engine.NRTReplicationEngineFactory;
import static org.mockito.Mockito.doReturn;
        assertFalse(primary.isSearchIdle());
        indexDoc(primary, "_doc", "1");
                );
        // try to serialize it to ensure values survive the serialization
            shard.waitForReplicaSync(TimeValue.timeValueSeconds(1));
import java.util.UUID;
            new SourceToParse(indexName, "doc-0", new BytesArray("{}"), MediaTypeRegistry.JSON)
        });
            final AtomicBoolean onResponse = new AtomicBoolean();
            Settings.EMPTY,
        } else {
        }
        snapshotter.join();
    public void testShardActiveDuringPeerRecovery() throws IOException {
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader("foo", reader);
        stats.toXContent(builder, EMPTY_PARAMS);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        flushShard(shard);
        closeShards(replica);
        newShard = reinitShard(newShard, ShardRoutingHelper.initWithSameId(routing, RecoverySource.EmptyStoreRecoverySource.INSTANCE));
        );
        // doing it directly instead
    public void testFailIfIndexNotPresentInRecoverFromStore() throws Exception {
                    new RetentionLeases(
            }
            5,
        );
        }
        indexShard.flush(new FlushRequest());
            assertEquals(3, searcher.getIndexReader().numDocs());
            true,
        expectThrows(
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
            assertEquals(search.totalHits.value(), 0);
        indexDoc(primary, "_doc", "1", "{\"foo\" : \"bar\"}");
        primary.onSettingsChanged();
import org.apache.logging.log4j.Logger;
            final long maxSeqNoOfUpdatesOrDeletes = replica.getMaxSeqNoOfUpdatesOrDeletes();
            indexShard.refresh("test"); // produce segments
            } finally {
                seqNo++; // create gaps in sequence numbers
                        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        // then recovers a new Search Replica and asserts all docs are present
                final int totalTranslogOps,
        );
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        shard.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
                e -> fail(e.toString()),
                snapshotDoneLatch.countDown();
        shard.writeIndexingBuffer();
                IndexShardTestUtils.getFakeDiscoveryNodes(primaryRouting)
    public void testPeriodicFlushTaskRescheduledOnIntervalChange() throws Exception {
                        assertThat(indexShard.getLocalCheckpoint(), equalTo(expectedLocalCheckpoint));
                final long mappingVersion,
            }
/*
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
        assertTrue(recoverFromStore(newShard));
        closeShards(primary);
        closeShards(primary);
                );
            // Diagnostic accessors remain safe to call.
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
            searchReplicaShardPath,
        // simulate that the background sync advanced the global checkpoint on the replica
            }
     * Applies a dynamic update of {@code index.periodic_flush_interval} to the shard the same way
    }
    public void testPeriodicFlushTaskNotStartedForRegularIndex() throws Exception {
        assertEquals(1, postIndexUpdate.get());
                            @Override
            final long newPrimaryTerm = indexShard.getPendingPrimaryTerm() + between(1, 1000);
                final AtomicBoolean invoked = new AtomicBoolean();
                    public void onFailure(Exception e) {
        );
        try (GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> snap = shard.getCatalogSnapshot()) {
    public void testGlobalCheckpointSync() throws IOException {
        } else {
        assertTrue(recoverFromStore(newShard));
                    armed.set(true);
                    ActionListener.wrap(r -> {
        final Thread first = new Thread(function.apply(firstIncrement));
            if (Arrays.asList(storeDirectory.listAll()).contains(file) && storeDirectory.getPendingDeletions().contains(file) == false) {
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperationsOnStart());
        IndexShard newShard = reinitShard(
    }
            indexShard = newStartedShard(true);
                AssertionError.class,
        IndexShardTestCase.updateRoutingEntry(shard, routing);
        recoverShardFromStore(primary);
            assertEquals(2, indexShard.getActiveOperationsCount());
            Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED),
                        0,
        latch.await();
            }
            assertEquals(0, indexShard.getActiveOperationsCount());
                final long maxAutoIdTimestamp,
        Settings segRepSettings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        long seqNo = 0;
                indexShard.flush(new FlushRequest());
    public void testDoNotTrimCommitsWhenOpenReadOnlyEngine() throws Exception {
        // which it must only do once the shard has finished transitioning to primary (otherwise state is still CLOSED and the
            indexShard.runUnderPrimaryPermit(() -> { throw new RuntimeException("failure"); }, e -> {
        Settings settings = Settings.builder()
            )
                readyToCloseLatch.await();
        allPermitsAcquired.await();
        assertTrue(stop.compareAndSet(false, true));
            indexShard.getRetentionLeaseSyncer(),
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
     */
            );
    public void testNoDeadlockOnCloseWhileRecoveringTranslog() throws Exception {
    }
import org.opensearch.core.action.ActionListener;
                                    throw new RuntimeException(e);
        test.getIndexer().flush();
            assertThat(commitStats.getGeneration(), equalTo(2L));
            public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {
                indexShard.syncRetentionLeases();
                thread.join();
        );
        IndexShard primaryShard = newShard(
            null
            return new InternalEngine(config);
     */
        recoveryThread.join();
        operationLatch.countDown();
            null
            shardRouting,
        latch.await();
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
            EMPTY_EVENT_LISTENER,
        IndexShard newShard = reinitShard(shard);
     * Verifies the primary-only assertion on {@code onMergesDrained}: drain notifications are
            assertTrue("getSegmentInfosSnapshot should not block on engineMutex", snapshotCompletedLatch.await(5, TimeUnit.SECONDS));
 */
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMinutes(1))
        assertEquals(shard.fieldData().stats("foo").getEvictions(), before.getEvictions());
            fut,
        final IndexShard indexShard = newStartedShard(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                } else {
        ParsedDocument noopTombstone = shard.getIndexer().config().getTombstoneDocSupplier().newNoopTombstoneDoc(reason);
        closeShard(source, false);
            );
                throw new ReplicationFailedException("Segment replication failed");
        recoverShardFromStore(primary);
        IndexShard replica = newShard(primary.shardId(), false, "n2", metadata, null);
            store.markStoreCorrupted(new IOException(corruptionMessage));
            new NoneCircuitBreakerService(),
        final AtomicBoolean blocked = new AtomicBoolean();
        } finally {
        final ShardRouting replicaRouting = shard.routingEntry();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.index.seqno.RetentionLeases;
                    maxAutoIdTimestamp,
        try {
            }
        routing = TestShardRouting.relocate(shard.shardRouting, "some node", 42L);
            final long expectedLocalCheckpoint;
        indexDoc(source, "_doc", "0");
                    IndexShardTestUtils.getFakeDiscoNode(newShard.routingEntry().currentNodeId())
            .build();
     * and the assertion surfaces it loudly.
        assertTrue(indexShard.isPrimaryReplicaResyncInProgress());
        // An unchanged value is a no-op.
            new Engine.Get(true, true, "0", new Term("_id", Uid.encodeId("0")))
        final AtomicBoolean shardFailed = new AtomicBoolean(false);
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
    public void testDocStats() throws Exception {
        String remoteStorePath = createTempDir().toString();
                    return super.listAll();
        updateMappings(primaryTarget, primarySource.indexSettings().getIndexMetadata());
                            throw new RuntimeException(e);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                indexShard.getPendingPrimaryTerm() + randomIntBetween(1, 100),
                        new ActionListener<Releasable>() {
                true,
        thread.join();
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperations());
        final IndexShard shard = newStartedShard(true);
        assertEquals(0, postIndexUpdate.get());
            when(replicatingStat.getCheckpointsBehindCount()).thenReturn(0L);
        try {
        final ShardPath shardPath = indexShard.shardPath();
                }
 * ownership. Elasticsearch licenses this file to you under
        );
                            public void onResponse(final Releasable releasable) {
import static org.hamcrest.Matchers.either;
            when(inSyncStat.getCheckpointsBehindCount()).thenReturn(0L);
                        fail("unexpected result type:" + result.getResultType());
        assertEquals(2, preIndex.get());
            // Need to update and sync the global checkpoint and the retention leases for the soft-deletes retention MergePolicy.
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())
            3,
            operation1 = acquireReplicaOperationPermitBlockingly(indexShard, primaryTerm);
        );
            while ((operation = snapshot.next()) != null) {
            shardRouting,
        promoteReplica(
        shard.markSeqNoAsNoop(1, primaryTerm, "test");
        );
        scopedSettings.applySettings(settings);
            threads[threadId].start();
        assertDocCount(newShard, 3);
        CountDownLatch allPrimaryOperationLocksAcquired = new CountDownLatch(numThreads);
    }
            replayedOps = 3;
    private AllocationId randomAllocationId() {
        expectThrows(
        closeShards(newShard);
                meta.indexUUID,
        );
        IndexShardTestCase.updateRoutingEntry(shard, routing);
import org.junit.Assert;
        int max = offset;
        final Path indexPath = shardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
            public void onResponse(Releasable releasable) {
                remoteDirectory.deleteFile(file);
            ActionListener.wrap(r -> {
                        // and one after replaying translog (upto the global checkpoint); otherwise we roll translog once.
import org.opensearch.cluster.routing.AllocationId;
                        1,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
                }
    public void testPrimaryPromotionDelaysOperations() throws IOException, BrokenBarrierException, InterruptedException {
            false,
            final boolean singlePermit = randomBoolean();
     * Pauses {@code resetEngineToGlobalCheckpoint} before translog replay, holds
    /**
                    routing.shardId(),
        assertThat(target.seqNoStats().getGlobalCheckpoint(), equalTo(0L));
            Collections.singleton(replicaRouting.allocationId().getId()),
        flushShard(source);
        }
        assertEquals(1, postDelete.get());
                @Override
            assertThat(ex.getMessage(), containsString("replicas failed to sync within"));
        assertTrue(lastSearchAccess < primary.getLastSearcherAccess());
        assertListenerCalled.accept(replica);
            storeDirectory.deleteFile(file);
        final IndexShard shard = newStartedShard(true);
        Thread snapshotThread = new Thread(() -> {
            opPrimaryTerm,
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
    /**
                    MediaTypeRegistry.JSON
            Collections.singleton(newRouting.allocationId().getId()),
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
            fail("we are already recovering, can't mark again");
        closeShards(shard);
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
            () -> newStartedShard(p -> corruptedShard, true)
    }
        IndexMetadata metadata = IndexMetadata.builder("test")
     */
        final Settings settings = Settings.builder()
        assertThat(readonlyShard.docStats().getCount(), equalTo(numDocs));
            @Override
    }
        recoverShardFromStore(primary);
                    try {
            true,
        // Recovering from store should discard doc #1
    }
        assertTrue(blocked.get());
        for (int i = 1; shard.refreshStats().getExternalTotalTimeInMillis() == initialTotalTime; i++) {
        final ExecutionException e = expectThrows(ExecutionException.class, () -> acquirePrimaryOperationPermitBlockingly(shard));
        IndexShardTestCase.updateRoutingEntry(shard, relocationRouting);
                .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
                replicaRouting.shardId(),
                ThreadPool threadPool = shard.getThreadPool();
                    @Override
        final long checkpoint = rarely() ? maxSeqNo - scaledRandomIntBetween(0, maxSeqNo) : maxSeqNo;
            return null;
        );
            primaryRouting,
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            forceMergeRequest.maxNumSegments(1);
        FieldDataStats after = null;
                final DocsStats docsStats = indexShard.docStats();
    }
        ) {
                                    ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
            };
                .build(),
        final int maxSeqNo = randomIntBetween(0, 128);
        final AtomicReference<ActionListener<PrimaryReplicaSyncer.ResyncTask>> capturedListener = new AtomicReference<>();
            ),
        updateMappings(otherShard, shard.indexSettings().getIndexMetadata());
            shard.indexSettings().getIndexMetadata(),
    }
        );
        recoverShardFromStore(primary);
        latch.await();
                    corruptedMarkerCount.incrementAndGet();
        IndexShard newShard = reinitShard(
        CountDownLatch latch = new CountDownLatch(thread.length);
            write(state3, env.availableShardPaths(id));
    /**
import org.opensearch.common.settings.IndexScopedSettings;
        // The timeout is far longer than this test runs, so only the resync failing can clear the flag.
            assertThat(e, hasToString(matches("operation primary term \\[\\d+\\] is too old")));
                    assertThat(storeFileMetadatas.recoveryDiff(readMeta).missing.size(), equalTo(0));
                assertions.add(() -> {
        Settings newSettings = Settings.builder()
        // Flushing a new commit with local checkpoint=1 allows to skip the translog gen #1 in recovery.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                try (Releasable dummy = r) {
            }
    public void testCompletionStatsMarksSearcherAccessed() throws Exception {
            indexShard.getGlobalCheckpointSyncer(),
        indexDoc(shard, "_doc", "1", "{\"foobar\" : \"bar\"}");
                    .field("count", randomInt())
            indexShard.engineConfigFactory,
        newShard.close("test", false, false);
import org.opensearch.common.concurrent.GatedCloseable;
        RemoteSegmentTransferTracker remoteSegmentTransferTracker,
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
                    assertThat(
                    true,
        final IndexShard primarySource = newStartedShard(true);
                engineClosed = true;
import static org.hamcrest.Matchers.greaterThan;
        assertTrue(primary.scheduledRefresh());
        }
        });
        indexDoc(sourceShard, "_doc", "1", "{\"foo\" : \"bar\"}");
import java.nio.file.Path;
            assertThat(targetShard.getReplicationTracker().getGlobalCheckpoint(), equalTo(1L));
        capturedListener.get().onFailure(new RuntimeException("simulated resync failure"));
        }
                "relocation target ["
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                try (Engine.Searcher searcher = indexShard.acquireSearcher("test")) {
        // start recovery thread
    }
            @Override
            );
                        break;
        if (globalCheckpoint < maxSeqNo) {
        assertThat(
        // and the new InternalEngine, then paused before translog replay.
     * relocate, and it does so without failing the shard.
        assertEquals(remoteSegmentTransferTracker.getUploadBytesStarted(), remoteSegmentStats.getUploadBytesStarted());
                try {
        // Verify getSegmentInfosSnapshot() on the ReadOnlyEngine doesn't block when
        for (int i = 0; i < threads.length; i++) {
            () -> synced.set(true),
    }
            flushShard(shard);
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
        Files.walkFileTree(indexPath, corruptedVisitor);
                .retentionLeasesSupplier(config.retentionLeasesSupplier())
        assertTrue("disabling index.periodic_flush_interval should close the running task", flushTask.isClosed());
        Thread snapshotter = new Thread(() -> {
            ShardStateMetadata state3 = new ShardStateMetadata(primary, "fooUUID", allocationId);
        }
        final IndexShard replicaShard = newStartedShard(
            for (int i = 0; i < numDoc / 2; i++) {
            closeShards(indexShard);
            assertEquals(1, numNoops);
                        throw new AssertionError();
    }
            1,
                                try (Releasable ignored = releasable) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        closeShard(shard, false);
            indexShard.indexerFactory,
                    public void onFailure(Exception e) {
        closeShards(primaryShard, replicaShard);
        target.markAsRecovering("remote_store", new RecoveryState(routing, localNode, null));
            fail("exception expected");
            }
            assertThat(shard.refreshStats().getTotal(), equalTo(initialRefreshes + i - 1));
import org.opensearch.index.engine.ReadOnlyEngine;
     * completes within 5 seconds.
        Settings segRepSettings = Settings.builder()
                    final MapperParsingException error = expectThrows(
    /**
                    engineResetLatch.countDown();
import org.opensearch.index.mapper.SourceFieldMapper;
     * (currentReplicationTimeMillis > 0), even if checkpoints and bytes behind are zero.
        }
        indexDoc(indexShard, "_doc", "0", "{}");
        stop.set(true);
                assertTrue(storeDirectory.getPendingDeletions().contains(file));
        );
        shard.applyIndexOperationOnReplica(
        expectThrows(AlreadyClosedException.class, () -> shard.acquireLastIndexCommit(false));
        final LongFunction<Runnable> function = increment -> () -> {
        recoveryThread.start();
        flushTask.run();
                routing = newShardRouting(
                indexShard.updateGlobalCheckpointOnReplica(newGlobalCheckpoint, "test");
            }
        // We use AtomicReference here to inject failure in the middle of the test not immediately
        assertTrue(primary.getPeriodicFlushTask().isClosed());
     */
        indexDoc(shard, "_doc", "0");
                }
            @Override
        shard.advanceMaxSeqNoOfUpdatesOrDeletes(1); // manually advance msu for this delete
        );
            UUID.randomUUID().toString(),
        settings = Settings.builder()
import org.opensearch.index.store.StoreUtils;
        IndexScopedSettings scopedSettings = primary.indexSettings().getScopedSettings();
        if (randomBoolean()) {
        final List<Translog.Operation> operations = Stream.concat(
            replicaRouting.allocationId()
        Set<String> ids = new HashSet<>();
            assertEquals(shardStateMetadata, state1);
            if (refreshListener instanceof ReleasableRetryableRefreshListener) {
                ActionListener<Releasable> listener = new ActionListener<Releasable>() {
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
    public Settings threadPoolSettings() {
            )
            assertThat(
            try {
            false,
        closeShards(sourceShard, targetShard);
        assertEquals(shard.shardPath().getRootDataPath().toString(), stats.getDataPath());
                UUID.randomUUID().toString(),
                    hitClosedExceptions++;
        indexDoc(test, "_doc", "test");
            indexMetadata,
            ShardRoutingHelper.initWithSameId(primaryShardRouting, RecoverySource.ExistingStoreRecoverySource.INSTANCE)
        assertEquals(lastSearchAccess, primary.getLastSearcherAccess());
                    assertNull(onFailure.get());
        );
                resyncDispatched.countDown();
        }
    }
            IndexShardTestUtils.getFakeDiscoveryNodes(newRouting)
            if (rarely()) {
            TimeValue.timeValueMinutes(1L)
        shard.forceMerge(secondForceMergeRequest);
                    Store.MetadataSnapshot readMeta = newShard.snapshotStoreMetadata();
        closeShards(newShard);
    }
            }
        IndexShard shard = newStartedShard();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            0L,
        recoveryEmptyReplica(indexShard, randomBoolean());
import org.opensearch.core.common.io.stream.StreamInput;
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "because I say so")
        assertNotNull("task should start once an engine is available", flushTask);
import org.opensearch.cluster.routing.ShardRouting;
                try {
                    default:
                assertThat(docsStats.getAverageSizeInBytes(), greaterThan(0L));
                indexShard.refresh("test");
        populateSampleRemoteSegmentStats(remoteSegmentTransferTracker);
            currentClusterStateVersion.incrementAndGet(),
    public void testPeriodicFlushTaskStoppedOnDynamicDisable() throws Exception {
            shard.addRefreshListener(null, b -> {
    }
import java.util.concurrent.Semaphore;
                        .collect(Collectors.toList());
        final int translogOps;
            }
        final IndexShard indexShard,
                .threadPool(config.getThreadPool())
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
            @Override
            shardStateMetadata = load(logger, env.availableShardPaths(id));
                }
                throw new RuntimeException(e);
            expectThrows(UnsupportedOperationException.class, shard::freezeForTiering);
            indexShard.routingEntry(),
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
            .build();
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
                try {
                    case SUCCESS:
     * Creates a started replica whose recovery settings use the given primary-replica resync timeout.
            primaryTerm,
            final Releasable permit = onAcquired.actionGet();
                if (operation.opType() == Translog.Operation.Type.NO_OP) {
                        maxSeqNoOfUpdatesOrDeletes,
        recoverShardFromStore(primary);
        boolean gap = false;
            final PlainActionFuture<Releasable> future = new PlainActionFuture<Releasable>() {
                    routing.currentNodeId(),
                onLockAcquired = new PlainActionFuture<>();
            source.refresh("test");
        assertEquals(0, postDelete.get());
            ActionListener<Releasable> onLockAcquired = new ActionListener<Releasable>() {
            }
        final IndexShard replicaShard = newStartedShard(
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
import static org.hamcrest.Matchers.not;
            case 1: {
                threads[j] = new Thread(() -> {
        assertTrue(flushTask.isScheduled());
        latch.await();
        };
        final String initialForceMergeUUID = ((InternalEngine) ((EngineBackedIndexer) shard.getIndexer()).getEngine()).getForceMergeUUID();
            final CountDownLatch latch = new CountDownLatch(1);
            TopDocs search = searcher.search(new TermQuery(new Term("foo", "bar")), 10);
        closeShards(indexShard);
import org.opensearch.common.io.stream.BytesStreamOutput;
                );
     * Verifies {@code waitForReplicaSync} throws IOException when replicas fail to sync within timeout.
        shard.relocated(toNode2.getTargetRelocatingShard().allocationId().getId(), ctx -> relocated.set(true), () -> {});
            // we're only checking that listeners are called when the engine is open, before there is no point
        updatePeriodicFlushInterval(primary, "1m");
            UUID.randomUUID().toString(),
        routing = ShardRoutingHelper.newWithRestoreSource(routing, new RecoverySource.EmptyStoreRecoverySource());
        assertThat(shard.refreshStats().getExternalTotal(), equalTo(2L)); // refresh on: finalize and end of recovery
        InterruptedException {
                    )
                ThreadPool.Names.SAME,
            .build();
    ) throws Exception {
                new RecoveryState(
            )
            }, e -> fail(e.toString()), executorOnDelay, "test");
            @Override
                        assertListenerCalled.accept(replica);
        indexDoc(test, "_doc", "test");
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), randomFrom("false", "true", "checksum"))
                UNASSIGNED_SEQ_NO,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertTrue(segRepException.getMessage().equals("Segment replication failed"));
        final IndexShard replicaShard = newShard(shardId, false);
        );
        closeShard(shard, false);
 */
            assertEquals("fooUUID", state3.indexUUID);
            .build();
                    indexShard.routingEntry().allocationId().getId(),
            .settings(settings)
        final AtomicBoolean relocated = new AtomicBoolean();
        assertEquals(1, preDelete.get());
                        "{\"foo\" : \"bar\"}".getBytes(Charset.forName("UTF-8")),
             */
        final CountDownLatch allOperationsDone = new CountDownLatch(threads.length);
            isPrimary ? RecoverySource.ExistingStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
        // add a replica
            translogOps = 4; // delete #1 won't be replayed.
                                lease -> new RetentionLease(
        );
            indexThreads[i] = new Thread() {
        long initialPeriodicFlushCount = primary.flushStats().getPeriodic();
     * {@code engineMutex} via reflection, and asserts {@code getSegmentInfosSnapshot()}
            new ClusterService(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS), threadPool),
            TimeValue.timeValueMinutes(1L)
    }
            indexShard.routingEntry(),
     * {@code newEngineReference} is still null -- the window between ReadOnlyEngine installation
        Thread cancellingThread = new Thread(new AbstractRunnable() {
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1s")
            .commonStats(new CommonStats(new IndicesQueryCache(Settings.EMPTY), shard, new CommonStatsFlags()))
            indexShard.indexerFactory,
        shard.recoveryState().getIndex().setFileDetailsComplete();
        }
        /*
            ActionListener.wrap(r -> {
        closeShards(primary, replica);
            {
        IndexShard indexShard = null;
import java.util.function.Function;
import org.opensearch.snapshots.SnapshotId;
        final int operations = 1024 - scaledRandomIntBetween(0, 1024);
        assertThat("store still has a single corrupt marker", corruptedMarkerCount.get(), equalTo(1));
    public void testRecordsForceMerges() throws IOException {
                }
        final boolean shouldRollback = Math.max(globalCheckpoint, globalCheckpointOnReplica) < indexShard.seqNoStats().getMaxSeqNo()
                        new ActionListener<Releasable>() {
                assertThat(snapshot.totalOperations(), equalTo(newShard.indexSettings.isSoftDeleteEnabled() ? 0 : 2));
     * Guards against regressions where the method reverts to using getSegmentInfosSnapshot().
        String historyUUID = shard.getHistoryUUID();
                indexShard.refresh("test");
                either(instanceOf(IllegalIndexShardStateException.class)).or(instanceOf(IllegalStateException.class))
            closeShards(shard);
                ShardRouting routing = indexShard.routingEntry();
                }
        String id = randomRealisticUnicodeOfLengthBetween(1, 10);
            shard,
        }
        closeShards(shard);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertDocCount(newShard, totalOps);
            null
            latch.await();
        final AtomicArray<Tuple<Boolean, Exception>> results = new AtomicArray<>(threads.length);
            null,
     * the catalog snapshot files should match the remote uploaded files, making the method return true.
            shardRouting,
            }
        // After refresh, remote sync should have completed and catalog snapshot files should match remote
            @Override
        }
            assertThat(replica.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(Math.max(currentMaxSeqNoOfUpdates, newMaxSeqNoOfUpdates)));
            } else {
                    listener.onResponse(r);
        CountDownLatch closeDoneLatch = new CountDownLatch(1);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    throw new RuntimeException(e);
            if (randomBoolean()) {
            );
        final Thread recoveryThread = new Thread(() -> {
        final CountDownLatch latch = new CountDownLatch(1);
            IndexMetadata.builder(shard.indexSettings.getIndexMetadata())
            @Override
    }
        indexDoc(source, "_doc", "2");
    public void testSyncSegmentsFromGivenRemoteSegmentStore() throws IOException {
            .build();
        assertEquals(0, postIndexException.get());
                            }
            RecoverySource.LocalShardsRecoverySource.INSTANCE
        source.refresh("test");
            // we might have trimmed some operations if the translog retention policy is ignored (when soft-deletes enabled).
            indexShard.sync();
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
        final String indexName = shard.shardId().getIndexName();
        );
            0,
        primary.state = IndexShardState.RECOVERING; // translog recovery on the next line would otherwise fail as we are in POST_RECOVERY
        }
                }
                try (GatedCloseable<IndexCommit> wrappedIndexCommit = shard.acquireLastIndexCommit(randomBoolean())) {
        final IndexShard indexShard = newStartedShard(false);
        indexDoc(primary, "_doc", "2");
    public void testWaitForReplicaSync_ReplicationInProgress_TimesOut() throws IOException {
            () -> synced.set(true),
            }
        assertThat(relocated.get(), equalTo(true));
                        }
        // ensure we wait for all primary operation locks to be acquired
        );
    public void testTieringMergeWrappers_NonDfaEngine_DiagnosticsReportRealValues() throws IOException {
                    }
        searchReplicaShardRouting = ShardRoutingHelper.initialize(searchReplicaShardRouting, replica.routingEntry().currentNodeId());
        closeShards(indexShard);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
        store.decRef();
        try {
        String xContent = builder.toString();
                false,
        ) {
    public void testRecoverFromLocalShard() throws IOException {
        );
        IndexShard indexShard = null;
                shard.relocated(relocationRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
import org.opensearch.index.fielddata.IndexFieldData;
        final IndexShard shard = newStartedShard(true);
    ) {
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            latch.await();
        assertEquals(1, postDelete.get());
                    indexShard.getPendingPrimaryTerm(),
        assertEquals(
                }
                    public void onResponse(Releasable releasable) {
     * engine. Tiering targets DFA-format indices only; calling this wrapper on a Lucene shard is a
        assertEquals(
            recoverFromStore(newShard);
                    assertListenerCalled.accept(replica);
        );
        routing = ShardRoutingHelper.initialize(routing, newShard.routingEntry().currentNodeId());
                MockFSDirectoryFactory.checkIndex(logger, shard.store(), shard.shardId);
        int iters = iterations(10, 100);
                        assertFalse(replica.isSyncNeeded());
     * resetEngineToGlobalCheckpoint can lead to check index failure in integration tests.
        // Get initial flush count
        CountDownLatch readyToSnapshotLatch = new CountDownLatch(1);
                            } catch (final InterruptedException e) {
        closeShards(shard);
    }
        for (long i = 0; i < numDocs; i++) {
                VersionFieldMapper.NAME,
        assertTrue(indexShard.isPrimaryReplicaResyncInProgress());
                );
                .getLocalCheckpoint(),
import java.util.concurrent.CyclicBarrier;
        IndexShard shard = newShard(false, segRepSettings, customFactory);
                    greaterThanOrEqualTo(storeStats.sizeInBytes() * 80 / 100)
     */
        recoverShardFromStore(shard);
        final IndexShard indexShard;
        assertEquals(100.0f, newShard.recoveryState().getTranslog().recoveredPercent(), 0.01f);
            TimeValue.timeValueMinutes(1)
                        targetStore.directory().copyFrom(sourceStore.directory(), file, file, IOContext.DEFAULT);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        settings = Settings.builder().put(settings).put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO).build();
 *
        closeShards(indexShard);
        expectedSubSequence.append(shard.shardPath().getRootStatePath().toString());
                        finish();
        indexDoc(shard, "_doc", "1", "{\"foo\" : \"bar\"}");
        // onResponse must have cleared the flag without failing the shard.
            true,
    public void testRunUnderPrimaryPermitOnFailure() throws IOException {
        return new Result(localCheckpoint, max);
            @Override
            shard,
        CountDownLatch latch = new CountDownLatch(1);
        IndexShardTestCase.updateRoutingEntry(shard, toNode2);
            newShard.markAsRecovering(
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        assertThat(thirdForceMergeUUID, equalTo(secondForceMergeRequest.forceMergeUUID()));
        final IndexShard source = newStartedShard(true);
                final RetentionLeases retentionLeases,
        // move to unassigned while the replica is active, then reinit from existing store.
                .queryCachingPolicy(config.getQueryCachingPolicy())
        );
                    relocating ? randomBoolean() : false,
        shard.acquireAllReplicaOperationsPermits(
import org.opensearch.test.store.MockFSDirectoryFactory;
        if (shardRouting.primary() == false && Assertions.ENABLED) {
            // engine reference was switched twice: current read/write engine -> ready-only engine -> new read/write engine
        long globalCheckpointOnReplica = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, primaryShard.getLocalCheckpoint());
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
            } else {
        indexDoc(newShard, "_doc", "0");
            public void indexTranslogOperations(
        CountDownLatch readyToCloseLatch = new CountDownLatch(1);
import org.opensearch.common.Randomness;
    public void testIndexingOperationsListeners() throws IOException {
                    maxAutoIdTimestamp,
        );
     * Verifies the tiering diagnostic wrappers report correct values on a standard (non-DFA) engine.
        final CountDownLatch allPermitsTerminated = new CountDownLatch(1);
                long prevAccessTime = shard.getLastSearcherAccess();
            replica.getGlobalCheckpointSyncer(),
        shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
import org.opensearch.OpenSearchException;
            ShardRoutingState.INITIALIZING,
            logger.debug("shard relocation was cancelled");
            boolean primary = randomBoolean();
        long maxSeqNoBeforeRollback = shard.seqNoStats().getMaxSeqNo();
     * primary-side only (replicas receive segments via segment-rep), so calling this method on a
            ShardRouting replicaRouting = indexShard.routingEntry();
        PlainActionFuture<Releasable> fut = new PlainActionFuture<>();
     * <p>
        IndexShardTestCase.updateRoutingEntry(shard, original);
        assertEquals(2, preIndex.get());
                newGlobalCheckPoint = SequenceNumbers.NO_OPS_PERFORMED;
        final long globalCheckpointOnReplica = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
        promoteReplica(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Execute the flush task
        final long maxSeqNoOfUpdatesOrDeletes,
        IndexShard shard = newStartedShard(true, segRepSettings);
     * the shard and the wrapped resync listener and decides whether to leave it pending, complete it, or fail it. Waits until the
        for (int i = 0; i < delayedOperations; i++) {
            translogOps = 5;
     * one still owns the only copy of its translog and a docrep shard has no remote copy at all.
            } else {
                RecoveryState recoveryState,
                final long maxSeqNoOfUpdatesOrDeletes,
            .build();
            primarySettings,
            IndexShardRecoveryException.class,
        IndexingStats indexingStats = newShard.indexingStats();
        // the two threads synchronize attempting to acquire an operation permit
    public void testReaderWrapperWorksWithGlobalOrdinals() throws IOException {
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Directory storeDirectory = target.store().directory();
                expectedLocalCheckpoint = newGlobalCheckPoint;
            assertThat(counter.get(), equalTo(2L));
        );
                    docsStats.getTotalSizeInBytes(),
            primarySettings,
        snapshot = newShard.snapshotStoreMetadata();
                postIndexException.incrementAndGet();
            Releasable operation2 = acquirePrimaryOperationPermitBlockingly(indexShard);
            final SeqNoStats seqNoStats = indexShard.seqNoStats();
                assertThat(indexShard.getPendingPrimaryTerm(), equalTo(primaryTerm));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                ShardId snapshotShardId,
            replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            assertTrue(failureCallbackTriggered.get());
        stats.writeTo(out);
                    : ShardStateMetadata.IndexDataLocation.LOCAL
        RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
                @Override
            indexShard.acquireAllPrimaryOperationsPermits(onAcquired, new TimeValue(Long.MAX_VALUE, TimeUnit.NANOSECONDS));
        // Periodic flush task should not be started
            () -> newStartedShard(p -> corruptedShard2, true)
            }
        indexDoc(primary, "_doc", "2");
            new RecoverySource.SnapshotRecoverySource(
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
                1,
        IndexShard shard = newStartedShard();
        assertTrue(
    public void testClosesPreventsNewOperations() throws Exception {
        shard.store().close();
                    latch.countDown();
        final CountDownLatch relocationStarted = new CountDownLatch(1);
                return operation;
    }
                UNASSIGNED_SEQ_NO,
            doReturn(Set.of(behindStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
            target.routingEntry(),
 */
            shardId,
        closeShards(newShard, shard);
            primaryTerm,
                } else {
            targetShard = newShard(targetRouting);
        };
                        retentionLeases.version() + 1,
        shard.refresh("test");
            final TimeValue timeout = TimeValue.timeValueSeconds(30L);
                () -> indexShard.acquireAllPrimaryOperationsPermits(null, TimeValue.timeValueSeconds(30L))
            }
            null,
import org.opensearch.common.io.PathUtils;
        IndexShard replica = newStartedShard(false);
        final long opPrimaryTerm,
                        1,
        // Safe to remove without impacting the test
        assertTrue("recover even if there is nothing to recover", recoverFromStore(newShard));
import java.nio.file.Files;
        );
        assertThat(shard.refreshStats().getExternalTotal(), equalTo(shard.refreshStats().getTotal() - 2 - extraInternalRefreshes));
            "node",
            @Override
        assertEquals(remoteTranslogTransferTracker.getTotalUploadsSucceeded(), remoteTranslogStats.getTotalUploadsSucceeded());
        }
            targetShard.recoverFromLocalShards(mappingConsumer, Arrays.asList(sourceShard), future);
            assertFalse(onResponse.get());
        AtomicInteger postDeleteException = new AtomicInteger();
        assertThat(primaryShard.getLocalCheckpoint(), equalTo(numDocs - 1L));
        assertThat(
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
            final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            indexShard = newShard(
                    }
                        .map(DocIdSeqNoAndSource::getId)
                if (randomBoolean()) {
            @Override
                        invoked.set(true);
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
            ShardStateMetadata state2 = new ShardStateMetadata(primary, "fooUUID", allocationId);
        closeShards(newShard);
                    }
                }
        } finally {
import static org.hamcrest.Matchers.sameInstance;
        }
import static java.util.Collections.emptyMap;
            .build();
                    results.setOnce(threadId, Tuple.tuple(Boolean.TRUE, null));
    }
        ShardRouting searchReplicaShardRouting = TestShardRouting.newShardRouting(
        IndexShard replica = newStartedShard(false);
                        proceedWithRecoveryLatch.await(30, TimeUnit.SECONDS);
import org.opensearch.common.collect.Tuple;
                    @Override
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
        assertEquals(versionCreated.luceneVersion, test.minimumCompatibleVersion());
        snapshotThread.start();
         * - index #0
            primary.shardId,
     */
    }
        ShardRouting inRecoveryRouting = ShardRoutingHelper.relocate(origRouting, "some_node");
        String remoteStorePath = createTempDir().toString();
        Settings settings = Settings.builder()
            latch.await();
        closeShards(replicaShard, primaryShard);
            // simulate promotion
            // Advance the global checkpoint to remove the 1st commit; this shard will recover the 2nd commit.
import org.opensearch.index.translog.InternalTranslogFactory;
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        assertFalse(primary.isSearchIdle());
            .settings(settings)
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
                latch.countDown();
            final PlainActionFuture<Releasable> onAcquired = new PlainActionFuture<>();
            assertThat(e, hasToString(containsString("acquireAllPrimaryOperationsPermits should only be called on primary shard")));
            null,
        // check that local checkpoint of new primary is properly tracked after primary relocation
        );
            when(behindStat.getCheckpointsBehindCount()).thenReturn(0L);
    public void testOnMergesDrained_NonDfaEngine_ThrowsUnsupported() throws IOException {
        assertTrue(uploadFiles.containsAll(lastCommitedSegmentsInSource));
        AtomicInteger preIndex = new AtomicInteger();
            }
        assertFalse(refreshListeners.stream().anyMatch(e -> e instanceof CheckpointRefreshListener));
        };
                        public void onFailure(Exception e) {
        }
        try (
        assertEquals(meta, new ShardStateMetadata(meta.primary, meta.indexUUID, meta.allocationId, meta.indexDataLocation));
        Thread recoveryThread = new Thread(() -> {
        final long numDocs = between(10, 20);
            IndexShard shard = newShard(
            } finally {
        Directory directory = new FilterDirectory(newFSDirectory(shardPath.resolveIndex())) {
import java.util.concurrent.CountDownLatch;
                }
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNo));
        // wait until the thread-pool has moved the timestamp otherwise we can't assert on this below
        try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = source.getSegmentInfosSnapshot()) {
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1);
        second.start();
        assertNotNull(shardPath);
        IndexMetadata metadata = IndexMetadata.builder("test")
        };
        snapshot = newShard.snapshotStoreMetadata();
            indexShard.getGlobalCheckpointSyncer(),
            false,
            final AtomicReference<Exception> onFailure = new AtomicReference<>();
                final String id = ids.isEmpty() || randomBoolean() ? Integer.toString(i) : randomFrom(ids);
        final IndexShard indexShard = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        assertThat(requestedMappingUpdates.get("_doc").source().string(), equalTo("{\"properties\":{\"foo\":{\"type\":\"text\"}}}"));
        }
        CountDownLatch latch = new CountDownLatch(1);
            null,
            replicaRouting,
        closeShards(newShard);
        assertTrue(indexShard.isRelocatedPrimary());
        final boolean isPrimaryMode;
            null,
import org.opensearch.index.SegmentReplicationShardStats;
                assertThat(onFailure.get(), instanceOf(IndexShardNotStartedException.class));
            0L,
    private static PrimaryReplicaSyncer.ResyncTask newResyncTask() {
                Releasables.close(operation1);
        IndexerFactory customFactory = new EngineBackedIndexerFactory(config -> new InternalEngine(config, new TranslogEventListener() {
            assertThat(onFailureException.get(), hasToString(containsString("operation primary term [" + oldPrimaryTerm + "] is too old")));
        final Settings settings = Settings.builder()
                );
            final AtomicReference<Exception> onFailureException = new AtomicReference<>();
                        latch.countDown();
        flushShard(shard);
            EMPTY_EVENT_LISTENER,
    }
                randomNonNegativeLong(),
        try {
        ((BaseDirectoryWrapper) storeDirectory).setCheckIndexOnClose(false);
            IntStream.range(0, randomIntBetween(1, 10))
                    maxSeqNoOfUpdatesOrDeletes,
                        if (result.isCreated()) {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                engineResetLatch.countDown();
    public void testExternalRefreshMetric() throws IOException {
            false,
        FieldDataStats before = shard.fieldData().stats("foo");
                        -1
                        // Shard should now be active since we did recover:
    /**
            latch.countDown();
                shard.shardId(),
        latch.await();
        thread.join();
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
        final ShardRouting originalRouting = shard.routingEntry();
        indexDoc(source, "_doc", "1");
                    );
            }
        shard.refresh("test");
        target.restoreFromRepository(new RestoreOnlyRepository("test") {
            .pollingIngestStats(shard.pollingIngestStats())
            indexShard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
            {
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
                    } catch (InterruptedException | BrokenBarrierException | ExecutionException e) {
                postDeleteException.incrementAndGet();
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
            }
        second.join();
        final ShardRouting primaryRouting = replica.routingEntry().moveActiveReplicaToPrimary();
            latch.countDown();
                                    assertThat(replica.getPendingPrimaryTerm(), greaterThanOrEqualTo(opPrimaryTerm));
                    readyToSnapshotLatch.countDown();
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                        1,
                    engineResetLatch.countDown();
            // check that local checkpoint of new primary is properly tracked after recovery
    public void testPrimaryRelocationBlockedWhilePrimaryReplicaResyncIsPending() throws Exception {
        // start a replica shard and index the second doc
                    .field("description", randomUnicodeOfCodepointLength(100))
        primaryShard.updateLocalCheckpointForShard(shardRouting.allocationId().getId(), checkpoint);
        );
                    allPermitsTerminated.await();
        assertThat(secondForceMergeUUID, notNullValue());
        }
        long newMaxSeqNoOfUpdates = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        updateMappings(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Files.walkFileTree(indexPath, corruptedVisitor);
        );
        // complete recovery/relocation
    public void testPrimaryHandOffUpdatesLocalCheckpoint() throws IOException {
        IndexShard shard = newStartedShard(true, segRepSettings);
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> { throw new RuntimeException("boom"); };
                }
            for (int i = 0; i < numDocs; i++) {
                }
                    for (String file : sourceStore.directory().listAll()) {
        assertThat(replica.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        final CountDownLatch latch = new CountDownLatch(2);
        ParsedDocument deleteTombstone = shard.getIndexer().config().getTombstoneDocSupplier().newDeleteTombstoneDoc(id);
            // Ignored because corrupted shard can throw various exceptions on close
        closeShards(shard);
                }
            expectThrows(UnsupportedOperationException.class, () -> shard.onMergesDrained(() -> {}));
                    new BytesArray("{}"),
                onLockAcquired = new PlainActionFuture<>();
                assertThat(docStats.getCount(), equalTo(numDocs));
    }
        primaryShard.maybeSyncGlobalCheckpoint("test");
import org.opensearch.common.util.concurrent.AbstractRunnable;
        assertEquals(1, preDelete.get());
        if (shard.indexSettings.isSoftDeleteEnabled()) {
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        ((BaseDirectoryWrapper) storeDirectory).setCheckIndexOnClose(false);
import org.apache.lucene.index.Term;
        final ForceMergeRequest firstForceMergeRequest = new ForceMergeRequest().maxNumSegments(1);
        AtomicBoolean done = new AtomicBoolean();
        // Regular index: periodic flush disabled by default, so no task is started with the engine.
            // Spy on the shard to simulate a replica that's always behind
            e = expectThrows(
                @Override
            }
        final IndexShard replica = newStartedShard(false);
        IndexMetadata metadata = IndexMetadata.builder("test")
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
            delayedThreads.add(thread);
        relocationThread.join();
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<Path>() {
import org.opensearch.common.UUIDs;
        IndexShardTestCase.updateRoutingEntry(shard, originalRouting);
    public void testPeriodicFlushTaskStartedOnDynamicEnable() throws Exception {
        replica = reinitShard(replica, searchReplicaShardRouting);
        );
import org.opensearch.index.engine.EngineConfig;
                indexShard.updateLocalCheckpointForShard(indexShard.routingEntry().allocationId().getId(), indexShard.getLocalCheckpoint());
            try (Translog.Snapshot snapshot = getTranslog(newShard).newSnapshot()) {
                        retentionLeases.leases()
            ShardRoutingState.INITIALIZING,
        promoteReplica(
                    }
                    }
                assertThat(docsStats.getDeleted(), equalTo(0L));
        final AtomicInteger postIndex = new AtomicInteger();
        );
     * a remote-store index always; a migrating docrep shard only once a remote source has seeded it, since an unseeded
                }
            );
    private ShardRouting promoteReplicaWithResyncSyncer(
        assertEquals(0, postIndexException.get());
        Thread relocationThread = new Thread(new AbstractRunnable() {
        final IllegalStateException error = expectThrows(
                        shard.getPendingPrimaryTerm(),
        );
        assertEquals(1, postDelete.get());
        assertEquals(0, storeDirectory.listAll().length);
            relocated.set(true);
            indexShard.getGlobalCheckpointSyncer(),
                indexShard.flush(new FlushRequest());
            .settings(
        assertEquals(0, indexShard.getActiveOperationsCount());
        final int maxSeqNo = result.maxSeqNo;
        long initialTotalTime = shard.refreshStats().getTotalTimeInMillis();
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
        expectThrows(
                if (indexShard.routingEntry().primary()) {
            flushRequest.force(false);
            isPrimaryMode = true;
        Settings settings = Settings.builder()
                        throw new RuntimeException(e);
        } finally {
            } catch (final BrokenBarrierException | InterruptedException e) {
            }
        barrier.await();
        AllocationId allocationId = randomBoolean() ? null : randomAllocationId();
                SeqNoFieldMapper.NAME,
            newShard = reinitShard(
        futures.forEach(future -> assertFalse(future.isDone()));
        assertDocs(replica, "1", "2");
     */
        final IndexShard indexShard = newStartedShard(true);
    }
        IndexShard shard = newStartedShard(true);
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-test")
                    ShardRoutingState.RELOCATING,
        );
            }
        final CountDownLatch startRecovery = new CountDownLatch(1);
                    indexShard.getLastKnownGlobalCheckpoint(),
            .primaryTerm(0, 1)
        indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
                final StoreStats storeStats = indexShard.storeStats();
                final int totalTranslogOps,
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
 * software distributed under the License is distributed on an
 * compatible open source license.
                    maxSeqNoOfUpdatesOrDeletes,
            shard.getOperationPrimaryTerm(),
        assertEquals(threads.length, results.asList().size());
     * and {@code newEngineReference.set(newEngine)} inside {@code resetEngineToGlobalCheckpoint}.
    public void testClosedIndicesSkipSyncGlobalCheckpoint() throws Exception {
                    operations,
                    }
 * The OpenSearch Contributors require contributions made to
            });
        recoverReplica(replica, primary, (shard, discoveryNode) -> new RecoveryTarget(shard, discoveryNode, recoveryListener, threadPool) {
            indexShard.indexerFactory,
        closeShards(indexShard);
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
                    assertTrue(searcher.getIndexReader().numDocs() <= docsStats.getCount());
        delayedOperationsBarrier.await();
        expectThrows(IndexShardClosedException.class, () -> indexShard.acquirePrimaryOperationPermit(null, ThreadPool.Names.WRITE, ""));
        };
            if (armed.compareAndSet(true, false)) {
     */
                releasable.close();
        );
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        final ShardRouting relocatingRouting = ShardRoutingHelper.relocate(primaryRouting, "other_node");
            //
        closeShards(shard);
        final Path shardStatePath = shard.shardPath().getShardStatePath();
            newRouting,
        recoverShardFromStore(newShard);
            final AtomicBoolean onFailure = new AtomicBoolean();
         * - delete #1
            IndexShardRecoveryException.class,
                UUIDs.randomBase64UUID(),
                i -> store,
            final ForceMergeRequest forceMergeRequest = new ForceMergeRequest();
        final String info
        );
                assertThat(e.getMessage(), equalTo("failure"));
        assertThat(
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            )
    }
                try {
            .build();
        recoverShardFromStore(primary);
                super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, ActionListener.wrap(r -> {
            shard.getEngineConfigFactory(),
        BiConsumer<IndexShard, ActionListener<PrimaryReplicaSyncer.ResyncTask>> syncer
                targetShard.getReplicationTracker()
        assertTrue(futureAllPermits.isDone());
                        delayedOperationsLatch.countDown();
            null,
                        }
    }
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            .primaryTerm(0, 1)
            }
        assertThat(target.seqNoStats().getMaxSeqNo(), equalTo(2L));
                long localCheckPoint = indexShard.getLastKnownGlobalCheckpoint() + randomInt(100);
        indexShard.sync(); // advance local checkpoint
        final ShardId shardId = new ShardId("test", "_na_", 0);
        final IndexShard shard = newStartedShard(false, Settings.EMPTY, new EngineBackedIndexerFactory(new InternalEngineFactory()));
            } catch (IOException | IllegalStateException ignored) {} finally {
        recoverShardFromStore(newShard);
            spyShard.waitForReplicaSync(TimeValue.timeValueSeconds(10));
                logger.info("File {} was not deleted and is not pending delete, attempting delete again...", file);
                    throw new AssertionError();
        Thread recoveryThread = new Thread(() -> {
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
            indexShard = newStartedShard(true);
     * promoted to a primary.
            @Override
                return in.getPendingDeletions();
                } catch (final BrokenBarrierException | InterruptedException e) {
                } catch (final BrokenBarrierException | InterruptedException e) {
            .collect(Collectors.toSet());
            if (ExtrasFS.isExtra(file)) {
        logger.info("shard routing to {}", shardRouting);
        assertThat(exception1.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
                randomFrom(ShardStateMetadata.IndexDataLocation.values())
import org.opensearch.index.engine.EngineBackedIndexer;
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        indexShard.flush(new FlushRequest());
        EngineTestCase.generateNewSeqNo(getEngine(source)); // create a gap in the history
            ShardRouting primaryRouting = newShardRouting(
        assertEquals(1, preDelete.get());
        assertThat(shard.getActiveOperationsCount(), greaterThan(0));
            indexShard.refresh("test");
                    mappingVersion,
        assertFalse(flushTask.isScheduled());
                assertNull(onFailure.get());
            this.localCheckpoint = localCheckpoint;
        );
        final AtomicLong counter = new AtomicLong();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                    barrier.await();
        }));
        );
        assertThat(indexShardRecoveryException.getMessage(), equalTo("failed recovery"));
import java.util.Collection;
        IndexShardTestCase.updateRoutingEntry(indexShard, relocatingRouting);
    public void testReadSnapshotAndCheckIndexConcurrently() throws Exception {
import java.util.Set;
            while (stop.get() == false) {
        latch.await();
                assertions.add(() -> {
                try {
            };
    }
        // finalizing a replica involves two refreshes with soft deletes because of estimateNumberOfHistoryOperations()
            IndexShardClosedException.class,
            shard.shardPath(),
    }
        Settings settings = Settings.builder()
            new ShardStateMetadata(
import org.apache.lucene.tests.mockfile.ExtrasFS;
                    ThreadPool threadPool = shard.getThreadPool();
            ShardRoutingState.INITIALIZING,
        for (int i = 0; i < thread.length; i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            shard.getRetentionLeaseSyncer(),
        IndexMetadata metadata = IndexMetadata.builder("test")
                    retentionLeases,
                }
        }
        );
                        "{\"foo\" : \"bar\"}".getBytes(Charset.forName("UTF-8")),
        try {
            if (rarely()) {
            indexDoc(shard, "_doc", Integer.toString(i));
            }
 * specific language governing permissions and limitations
        indexDoc(shard, "_doc", "1", "{\"foobar\" : \"bar\"}");
            assertTrue(recoveryState.getIndex().fileDetails().size() > 0);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        final IndexShard corruptedShard = newShard(
                    )
            };
        IndexShard shard = newStartedShard(
        for (int i = 0; i < thread.length; i++) {
        try (NodeEnvironment env = newNodeEnvironment()) {
        final long primaryTerm = indexShard.getPendingPrimaryTerm();
        // start shard and perform index check on startup. It enforce shard to fail due to corrupted index files
    public void testWaitForReplicaSync_BytesBehindNonZero_TimesOut() throws IOException {
        assertEquals(TimeValue.timeValueSeconds(30), flushTask.getInterval());
     * <a href="https://github.com/opensearch-project/OpenSearch/issues/11869">#11869</a>:
        target.remoteStore().decRef();
        assertEquals(shard.fieldData().stats("foo").getMemorySizeInBytes(), before.getMemorySizeInBytes());
            @Override
        assertEquals(remoteTranslogTransferTracker.getUploadBytesFailed(), remoteTranslogStats.getUploadBytesFailed());
        AtomicBoolean armed = new AtomicBoolean(false);
            new EngineBackedIndexerFactory(config -> new InternalEngine(config, new TranslogEventListener() {
     */
                        -1
            primaryTerm,
        // We use Supplier<IOException> instead of IOException to produce meaningful stacktrace
        }
        for (int i = 0; i < indexThreads.length; i++) {
        final AtomicBoolean shardFailed = new AtomicBoolean(false);
                }
    }
        );
                    ShardRoutingState.INITIALIZING,
                        -1
        indexShard.updateShardState(
            3,
                }
     * Verifies that {@code isRemoteSegmentStoreInSync} uses {@code getCatalogSnapshot()} (the unified
        // check that local checkpoint of new primary is properly tracked after recovery
        try {
                .build(),
                    "Estimated total document size is too large compared with the stored size",
        assertEquals(initialPeriodicFlushCount + 1, primary.flushStats().getPeriodic());
        final AtomicBoolean stop = new AtomicBoolean();
            indexShard.getRetentionLeaseSyncer(),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                }
                    "local_node",
import org.opensearch.index.mapper.IdFieldMapper;
    }
        } else {
                }
        final int recoveryIndex = randomIntBetween(0, numberOfAcquisitions - 1);
        // start search replica
                    i,
     * reports 0 active and {@code false} pending — the same outcome, but derived from the live state.
            when(replicatingStat.getCurrentReplicationTimeMillis()).thenReturn(5000L);
            IOException ex = expectThrows(IOException.class, () -> spyShard.waitForReplicaSync(TimeValue.timeValueMillis(600)));
        closeShards(shard);
                replicaRouting.shardId(),
        Files.walkFileTree(indexPath, corruptedVisitor);
 * KIND, either express or implied.  See the License for the
                );
        IndexShard test = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            final CyclicBarrier barrier = new CyclicBarrier(1 + operations);
                    latch.countDown();
                assertThat(docStats.getAverageSizeInBytes(), greaterThan(0L));
            for (ReplicationLuceneIndex.FileMetadata file : recoveryState.getIndex().fileDetails()) {
            });
    }
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueHours(1));
        assertDocCount(primaryTarget, totalOps);
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
                IndexShardTestCase.updateRoutingEntry(shard, originalRouting);
                randomRealisticUnicodeOfCodepointLengthBetween(1, 10),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        recoverReplica(primaryTarget, primarySource, true);
                    ? "generic"
        final ShardRouting toNode2 = ShardRoutingHelper.relocate(original, "node_2");
        assertThat(initialForceMergeUUID, nullValue());
        // most of the time this is large enough that most of the time there will be at least one gap
                    indexDoc(indexShard, "_doc", Integer.toString(i), "{\"foo\": \"bar\"}");
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final CountDownLatch operationLatch = new CountDownLatch(1);
        try {
        final long newMaxSeqNoOfUpdates = randomLongBetween(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), Long.MAX_VALUE);
        closeShards(primary);
            equalTo(maxSeqNo == primaryShard.getLastKnownGlobalCheckpoint() && (replicaGlobalCheckpoint < checkpoint))
                assertThat(
                if (snapshot != null) snapshot.close();
        // check time advances
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                SeqNoFieldMapper.TOMBSTONE_NAME,
        final int operations = scaledRandomIntBetween(1, 64);
    }
        futures.forEach(future -> assertFalse(future.isDone()));
            null
     * @return a pair of the maximum sequence number and whether or not a gap was introduced
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        // this test indexes docs on a primary, refreshes, then recovers a new Search Replica and asserts
    /* This test just verifies that we fill up local checkpoint up to max seen seqID on primary recovery */
        }
            shard.getEngineConfigFactory(),
            assertThat(indexShard.getIndexer(), not(sameInstance(beforeRollbackIndexer)));
import java.util.stream.Stream;
                shard.getOperationPrimaryTerm(),
        shard.flush(new FlushRequest());
            .build();
    }
import org.opensearch.index.engine.exec.Indexer;
            fail("index not there!");
            final PlainActionFuture<Releasable> onLockAcquired;
        engineResetLatch.await();
            searchReplicaShardRouting,
    public void testRestoreSearchOnlyShardFromStore() throws IOException {
            "a seeded migrating shard downloaded its translog from the remote store",
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
                indexShard.updateGlobalCheckpointForShard(
    public void testPeriodicFlushTaskExecutesFlush() throws Exception {
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
        randomReplicaOperationPermitAcquisition(
        IndexMetadata metadata = IndexMetadata.builder("source")
                        "every operations before the global checkpoint must be reserved",
            @Override
            SegmentReplicationShardStats behindStat = mock(SegmentReplicationShardStats.class);
                try (Releasable dummy = r) {
    }
        IndexMetadata metadata = IndexMetadata.builder("test")
        testRestoreShardFromRemoteStore(true);
    }
     */
            new EngineBackedIndexerFactory(config -> new InternalEngine(config, new TranslogEventListener() {
import static org.mockito.Mockito.times;
            }
            if (newGlobalCheckPoint == UNASSIGNED_SEQ_NO) {
    public void testRelocatedSegRepError() throws IOException, InterruptedException {
     * Verifies that the ReadOnlyEngine delegates throw {@link AlreadyClosedException} when
                final RetentionLeases retentionLeases,
                shard.snapshotStoreMetadata();
            indexShard,
            ) {
                !meta.primary,
        done.set(true);
        closeShard(primaryShard, false);
            SegmentReplicationShardStats inSyncStat = mock(SegmentReplicationShardStats.class);
import org.apache.lucene.index.SegmentInfos;
                    newShard.routingEntry(),
            shardRouting,
            IllegalIndexShardStateException.class,
        assertNotEquals(
            primary.acquireSearcher("test").close();
            final long newGlobalCheckPoint;
                        }
        List<ReferenceManager.RefreshListener> refreshListeners = shard.getIndexer().config().getInternalRefreshListener();
            .build();
            // relocation target
        shard.applyIndexOperationOnReplica(
        // reset our boolean so that we can assert after another simulated maybe sync
                    totalTranslogOps,
                    return null;
            .settings(settings)
            expectThrows(IllegalArgumentException.class, () -> {
            }
            thread.start();
    private void randomReplicaOperationPermitAcquisition(
                assertThat(storeStats.sizeInBytes(), greaterThan(numDoc * 100L)); // A doc should be more than 100 bytes.
        assertTrue("Expected no results, operations are blocked", results.asList().isEmpty());
import org.opensearch.index.mapper.SourceToParse;
    }
        IndexShard shard = newStartedShard(p -> newShard(true, publisher), true);
        try {
        recoveryThread.start();
        closeShards(indexShard);
            // flush the buffered deletes
        IndexShard shard = newStartedShard(true);
                        onFailure.set(e);
                throw new RuntimeException(e);
    }
     */
        primaryShard.updateGlobalCheckpointForShard(replicaShard.shardRouting.allocationId().getId(), globalCheckpointOnReplica);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        snapshotThread.join(5_000);
        assertEquals(TimeValue.timeValueMinutes(2), restarted.getInterval());
            assertThat(ex.getMessage(), containsString(IndexShard.REPLICA_SYNC_TIMEOUT_MARKER));
    }
            new EngineBackedIndexerFactory(new InternalEngineFactory())
            .settings(settings)
import org.opensearch.common.settings.ClusterSettings;
            .primaryTerm(0, 1)
            }
        final IndexShard corruptedShard2 = newShard(
                        ""
public class IndexShardTests extends IndexShardTestCase {
                            latch.countDown();
            // Use a very short timeout so the test doesn't take 30s
        futures.forEach(future -> assertTrue(future.isDone()));
        latch.await();
                        ThreadPool.Names.WRITE,
        closeShards(shard);
            new ActionListener<Releasable>() {
                        },
        assertThat(indexShard.getOperationPrimaryTerm(), equalTo(indexShard.getPendingPrimaryTerm()));
            assertEquals(1, indexShard.getActiveOperationsCount());
        assertEquals(0, postDeleteException.get());
            assertThat(
     * After the typed-method conversion, non-DFA engines no longer return a hardcoded 0; they read
    public void testPublishingOrderOnPromotion() throws IOException, InterruptedException, BrokenBarrierException {
            .build();
            }
        );
            closeShards(replica);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            }
        }
                .similarity(config.getSimilarity())
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
            primary.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
    public void testTranslogFactoryForRemoteTranslogBackedReplicaShard() throws IOException {
        IndexShard primary = newStartedShard(true);
                assertBusy(() -> assertEquals(0, indexShard.getActiveOperationsCount()));
        try {
                    ? ShardStateMetadata.IndexDataLocation.REMOTE
                            )
            if (randomBoolean()) {
            assert increment > 0;
        // this time there should not be a sync since all the replica copies are caught up with the primary
        final long globalCheckpoint = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
        final long numDocs = between(10, 100);
                SourceFieldMapper.NAME,
        tracker.incrementTotalUploadsSucceeded();
        PlainActionFuture<Releasable> fut = new PlainActionFuture<>();
            }
    }
    }
        ReplicationFailedException segRepException = expectThrows(
            false,
            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
        closeShards(indexShard);
                meta.indexDataLocation == ShardStateMetadata.IndexDataLocation.LOCAL
        otherShard.applyIndexOperationOnReplica(
    public void testPrimaryReplicaResyncOnResponseUnblocksPrimaryRelocation() throws Exception {
            write(state2, env.availableShardPaths(id));
         * - index #2
            );
import org.opensearch.index.engine.EngineTestCase;
            );
        // try to start another time shard on corrupted files
        indexDoc(indexShard, "_doc", "0");
            indexShard.runUnderPrimaryPermit(() -> {
            // entries with corrupted source
        if (randomBoolean()) {
            EMPTY_EVENT_LISTENER,
        );
        Store.MetadataSnapshot storeFileMetadatas = newShard.snapshotStoreMetadata();
            logger.debug("shard was relocated successfully");
        assertTrue("At lease one remote sync should have been completed", source.isRemoteSegmentStoreInSync());
        final ShardId shardId = new ShardId("index", "_na_", 0);
                        snapshotDoneLatch.await();
            .build();
        // try to start shard on corrupted files
            final StoreStats storeStats = indexShard.storeStats();
                try (Releasable ignored = r) {
        // promote the replica
import org.opensearch.index.translog.Translog;
        );
import static org.mockito.Mockito.verify;
        assertEquals(0, postIndexException.get());
            .build();
            assertTrue(getResult.searcher().getIndexReader() instanceof FieldMaskingReader);
import java.util.Collections;
            equalTo(totalOps - 1L)
        Settings settings = Settings.builder()
                        listener.onResponse(r);
        Settings segRepSettings = Settings.builder()
            shardRouting,
     */
            false,
            EMPTY_EVENT_LISTENER,
        }
                        .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-repo")
        }
     * test one can snapshot the store at various lifecycle stages
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                cancellingException.set(e);
                    indexShard.acquirePrimaryOperationPermit(future, ThreadPool.Names.WRITE, "");
     * When the primary-replica resync completes successfully, its onResponse must clear the in-progress flag so the promoted
import org.opensearch.repositories.IndexId;
            IndexShard spyShard = spy(shard);
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
            shard.updateGlobalCheckpointOnReplica(shard.getLocalCheckpoint(), "test");
                    docsStats.getTotalSizeInBytes(),
            store.markStoreCorrupted(new IOException(corruptionMessage));
            shard.refresh("test");
        {
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
            });
        assertThat(indexShard.getLocalCheckpoint(), equalTo((long) maxSeqNo));
        );
import org.opensearch.index.fielddata.IndexFieldDataService;
        assertEquals(remoteSegmentTransferTracker.getRejectionCount(), remoteSegmentStats.getTotalRejections());
import java.util.stream.IntStream;
        );
        long lastSearchAccess = primary.getLastSearcherAccess();
                    try {
            randomRealisticUnicodeOfCodepointLengthBetween(1, 10),
        assertEquals(primaryShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
        // Make sure to drain refreshes from the shard. Otherwise, if the refresh is in-progress, it overlaps with
            newMaxSeqNoOfUpdates,
        assertThat(newShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(totalOps - 1L));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                }
                        primary.getPendingPrimaryTerm(),
                    armed.set(true);
                final RetentionLeases retentionLeases = indexShard.getRetentionLeases();
    }
            } else {
            ShardRoutingState.INITIALIZING,
                    1,
        assertDocs(target, "1", "2");
        List<ReferenceManager.RefreshListener> refreshListeners = shard.getIndexer().config().getInternalRefreshListener();
        );
        deleteDoc(shard, "1");
                    );
        IndexShard sourceShard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            TimeValue.timeValueMinutes(1L)
    public void testSnapshotWhileResettingEngine() throws Exception {
        assertFalse(indexShard.isPrimaryReplicaResyncInProgress());
                new IndexShardRoutingTable.Builder(indexShard.shardId()).addShard(primaryRouting).build(),
        if (randomBoolean()) {
         * - flush (commit point has max_seqno 3, and local checkpoint 1 -> points at gen 2, previous commit point is maintained)
        closeShards(shard);
            thread.start();
        }
            public void indexTranslogOperations(
                .build(),
                @Override
            assertTrue(invoked.get());
                }
        } else {
                    assertThat(
        IndexShard shard = newStartedShard(true);
        assertTrue(stop.compareAndSet(false, true));
                .mergePolicy(config.getMergePolicy())
import org.opensearch.cluster.metadata.IndexMetadata;
                public void onFailure(final Exception e) {
                .getTrackedLocalCheckpointForShard(newShard.routingEntry().allocationId().getId())
        } else {
                    }
            assertNotNull(getResult.searcher());
import org.opensearch.Version;
        tracker.addUploadBytesSucceeded(10L);
            new IndexShardRoutingTable.Builder(primaryRouting.shardId()).addShard(primaryRouting).build(),
            indexDoc(primarySource, "_doc", Integer.toString(i));
            protected void doRun() throws Exception {
        }
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
        updatePeriodicFlushInterval(primary, "2m");
        assertThat(target.getLocalCheckpoint(), equalTo(2L));
        shard.failShard("test shard fail", new CorruptIndexException("", ""));
        }
            AssertionError e = expectThrows(AssertionError.class, replica::freezeForTiering);
        shard.applyIndexOperationOnReplica(
        }
        assertThat(shard.state(), equalTo(IndexShardState.STARTED));
        IndexShard indexShard = newShard(false);
            newShard.getReplicationTracker()
            ShardId id = new ShardId("foo", "fooUUID", 1);
        closeShards(shard);
                final List<Translog.Operation> operations,
                shard.shardId(),
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            primaryTerm,
        assertDocCount(newShard, 1);
        }
import org.opensearch.action.admin.indices.stats.ShardStats;
                public void onResponse(Releasable releasable) {
            new ActionListener<Releasable>() {
         * This operation completing means that the delay operation executed as part of increasing the primary term has completed and the
            }
        IndexShard shard = newShard(false, segRepSettings, customFactory);
                assertThat(
        Directory storeDirectory = ((FilterDirectory) ((FilterDirectory) target.store().directory()).getDelegate()).getDelegate();
        }
                        releasable.close();
        final ShardRouting replicaRouting = shard.routingEntry();
                            .collect(Collectors.toList())
                assertThat(docStats.getDeleted(), equalTo(0L));
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
                .build(),
            }
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\", \"fielddata\": true }}}")
            if (randomBoolean()) {
    public void testRestoreSearchOnlyShardFromStoreOnNewNode() throws IOException {
            when(inSyncStat.getCurrentReplicationTimeMillis()).thenReturn(0L);
        for (final Runnable assertion : assertions) {
        closeShards(indexShard);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            null
        ShardRouting searchReplicaShardRouting = TestShardRouting.newShardRouting(
                        "2",
        );
        IndexShard shard = newStartedShard();
        closeShards(readonlyShard);
        expectThrows(IllegalIndexShardStateException.class, () -> IndexShardTestCase.updateRoutingEntry(shard, originalRouting));
                IndexId indexId,
import org.opensearch.snapshots.Snapshot;
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
                        newPrimaryTerm,
        IndexShard shard = newStartedShard(true);
                    localCheckpoint++;
                new IndexId("test", UUIDs.randomBase64UUID(random()))
            commitGeneration = segmentInfos.getGeneration();
                public void onFailure(final Exception e) {
    public void testPrimaryFillsSeqNoGapsOnPromotion() throws Exception {
            false,
        assertEquals(primaryShard.getIndexer().config().getTranslogFactory().getClass(), RemoteBlobStoreInternalTranslogFactory.class);
            new IndexFieldDataCache.Listener() {
        indexDoc(shard, "_doc", "test");
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<>() {
        }
        final IndexShard primaryShard = newStartedShard(
            Collections.singleton(primaryRouting.allocationId().getId()),
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
import org.opensearch.index.translog.TestTranslog;
                            shard.sync(new Translog.Location(randomLong(), randomLong(), randomInt()), (ex) -> semaphore.release());
            equalTo(2L)
        shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        indexDoc(target, "_doc", "2");
     */
        try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                null
        IndexShardTestCase.updateRoutingEntry(shard, relocationRouting);
        assertEquals(0, indexingStats.getTotal().getIndexCount());
            meta,
import org.opensearch.index.translog.RemoteTranslogStats;
import org.opensearch.action.support.PlainActionFuture;
    }
        closeShards(newShard);
                }
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(indexResult.isCreated());
        return new PrimaryReplicaSyncer.ResyncTask(0, "type", "action", "description", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
        closeShards(shard);
     * even if checkpointsBehindCount is zero. This catches the DFA metadata mismatch scenario.
            .build();
        IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
                    UUID.randomUUID().toString(),
        }
                relocationStarted.await();
            false,
            {
        assertEquals(getEngine(replicaShard).getClass(), NRTReplicationEngine.class);
        Settings settings = Settings.builder()
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
        }
                .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
    public void testSupplyTombstoneDoc() throws Exception {
        return allocationId;
        assertEquals(remoteTranslogTransferTracker.getTotalUploadsStarted(), remoteTranslogStats.getTotalUploadsStarted());
        });
                        finish();
        assertTrue(shard.isActive());
            assertThat(indexShard.getActiveOperationsCount(), equalTo(0));
            indexShard.acquireAllPrimaryOperationsPermits(new ActionListener<Releasable>() {
            IndexShardRecoveryException.class,
            Collections.singleton(replicaRouting.allocationId().getId()),
            indexDoc(primaryShard, "_doc", Integer.toString(i));
            indexShard,
                indexShard.refresh("test");
        assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(newMaxSeqNoOfUpdates));
                        assertThat(indexShard.getActiveOperationsCount(), equalTo(IndexShard.OPERATIONS_BLOCKED));
                    .put(indexShard.indexSettings.getSettings())
        return ShardStateMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, shardPaths);
        }
            }
                                    latch.countDown();
import org.apache.lucene.tests.store.BaseDirectoryWrapper;
        primaryShard.updateLocalCheckpointForShard(replicaShard.shardRouting.allocationId().getId(), primaryShard.getLocalCheckpoint());
        AtomicBoolean synced = new AtomicBoolean();
            .settings(
            indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
                // initializing replica / primary
            @Override
                readyToSnapshotLatch.await();
            .build();
        routing = newShardRouting(
            hashCodes.add(meta.hashCode());
        IndexMetadata metadata = IndexMetadata.builder("test").settings(settings).primaryTerm(0, 1).build();
        final CyclicBarrier delayedOperationsBarrier = new CyclicBarrier(1 + delayedOperations);
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
        final IndexShard indexShard = newStartedShard(true);
            Engine.GetResult ignored = shard.get(new Engine.Get(true, false, "test", new Term(IdFieldMapper.NAME, Uid.encodeId("test"))))
        final ShardRouting relocatingRouting = ShardRoutingHelper.relocate(primaryRouting, "other_node");
        shard.relocated(inRecoveryRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
        IndexShard replica = newShard(
        final IndexShard targetShard;
        shard.sync(); // advance local checkpoint
            indexDoc(indexShard, "_doc", "" + i, "{\"foo\" : \"" + randomAlphaOfLength(10) + "\"}");
            if (randomBoolean()) {
            shard.applyIndexOperationOnReplica(
            fut,
        final boolean engineClosed;
                final long mappingVersion,
                    .toString();
            "a docrep shard has no remote translog",
                indexDoc(indexShard, "_doc", Integer.toString(i), doc);
                    warmerBlocking.await();
        // Failing the shard is the behaviour under test, so allow it rather than letting the harness treat it as an error.
     */
            @Override
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
    }
    }
            } else {
            AllocationId allocationId = randomBoolean() ? null : randomAllocationId();
    public void testGetChangesSnapshotThrowsAssertForRemoteStore() throws IOException {
        indexDoc(primary, "_doc", "1");
import java.util.function.Supplier;
import org.opensearch.cluster.routing.ShardRoutingState;
        closeShards(primaryShard, replicaShard);
        doc = indexDoc(primary, "_doc", "2", "{\"foo\" : \"bar\"}");
            .shardPath(shard.shardPath())
            // Some path weirdness on windows
            meta = new ShardStateMetadata(
            )
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
import org.opensearch.index.codec.CodecService;
            shard.getOperationPrimaryTerm(),
    }
        first.start();
     * recovery thread holds {@code readLock} (via {@code recoverFromTranslog}) and calls
        ShardRouting searchReplicaShardRouting = TestShardRouting.newShardRouting(
            }
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
    public void testFailShard() throws Exception {
                .mapToObj(
            IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.REMOTE_MIGRATING_UNSEEDED)
        primary.flushOnIdle(0);
import org.opensearch.cluster.routing.RecoverySource;
        String remoteStorePath = createTempDir().toString();
        closeShards(shard);
            public void onFailure(Exception e) {
     * {@code IndexService#updateMetadata} does: update the index settings, then notify the shard.
            assertThat(shard.refreshStats().getExternalTotalTimeInMillis(), greaterThanOrEqualTo(initialTotalTime));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        settings = Settings.builder()
        assertThat(getShardDocUIDs(shard), equalTo(docBelowGlobalCheckpoint));
                }
            }
            barrier.await();
        assertEquals(1, newShard.recoveryState().getTranslog().recoveredOperations());
        synchronized (engineMutex) {
import java.util.HashSet;
            closeShards(shard);
        try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
        closeShards(target);
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                        assertThat(indexShard.getActiveOperationsCount(), greaterThan(0));
        try (Store store = createStore(indexShard.indexSettings(), shardPath)) {
            public Set<String> getPendingDeletions() throws IOException {
        try (Engine.Searcher searcher = newShard.acquireSearcher("test")) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                super.indexTranslogOperations(
                @Override
        recoverReplica(replicaShard, primaryShard, true);
        }
            .primaryTerm(0, 1)
        try (Engine.Searcher searcher = primary.acquireSearcher("test")) {
    }
        }
        final ShardRouting primaryRouting = promoteReplicaWithPendingResync(indexShard);
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
    public void testFreezeForTiering_NonDfaEngine_ThrowsUnsupported() throws IOException {
                    new ActionListener<Releasable>() {
        replica.updateShardState(primaryRouting, replica.getPendingPrimaryTerm() + 1, (shard, resyncListener) -> {
                null,
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
        assertEquals(shard.shardPath().isCustomDataPath(), stats.isCustomDataPath());
        );
    public void testReadSnapshotConcurrently() throws IOException, InterruptedException {
                syncer.accept(shard, resyncListener);
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
            )
                containsString("in primary mode cannot be a replication target")
        CountDownLatch proceedWithCreationLatch = new CountDownLatch(1);
        final IndexShard newShard = reinitShard(indexShard);
    public void testConcurrentTermIncreaseOnReplicaShard() throws BrokenBarrierException, InterruptedException, IOException {
            newPrimaryTerm,
            );
        if (isPrimaryMode) {
    }
            UUID.randomUUID().toString(),
                        break;
            (s, r) -> resyncLatch.countDown(),
        shard.refresh("created segment 2");
        );
                .settings(
     * Index on the specified shard while introducing sequence number gaps.
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
        assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
        final CountDownLatch latch = new CountDownLatch(1);
        final ShardRouting primaryRouting = newShardRouting(
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
        assertTrue(primary.scheduledRefresh());
            flushRequest.waitIfOngoing(false);
                    assertEquals(2, searcher.getIndexReader().numDocs());
            primaryTarget.getReplicationTracker()
                public void onResponse(Releasable releasable) {
            public void onFailure(Exception e) {
        // check state file still exists
        }
        final Thread thread = new Thread(() -> {
        IndexMetadata metadata = IndexMetadata.builder("test")
                            try {
        indexOnReplicaWithGaps(replica, between(0, 1000), Math.toIntExact(replica.getLocalCheckpoint()));
        }
                    public void onFailure(Exception e) {
        AtomicInteger preDelete = new AtomicInteger();
        long primaryTerm = shard.getOperationPrimaryTerm();
                );
            }
            @Override
        long refreshCount = shard.refreshStats().getTotal();
        Directory remoteDirectory = ((FilterDirectory) ((FilterDirectory) target.remoteStore().directory()).getDelegate()).getDelegate();
            IOException ex = expectThrows(IOException.class, () -> spyShard.waitForReplicaSync(TimeValue.timeValueMillis(600)));
        closeShards(shard);
    public void testRecoverFromStore() throws IOException {
import java.util.Locale;
                        allPrimaryOperationLocksAcquired.countDown();
            Settings.builder()
import org.apache.lucene.store.FilterDirectory;
        resyncDispatched.await();
            indexShard,
            }
            EMPTY_EVENT_LISTENER,
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(shard.refreshStats().getTotal() - 1 - extraInternalRefreshes));
import org.opensearch.common.unit.TimeValue;
    private static void assertRemoteTranslogStats(
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<Path>() {
            CountDownLatch latch = new CountDownLatch(1);
        final ShardRouting replicaRouting = indexShard.routingEntry();
     */
            flushShard(shard);
                ThreadPool.Names.SAME
        closeShards(primary);
            IOException ex = expectThrows(IOException.class, () -> spyShard.waitForReplicaSync(TimeValue.timeValueMillis(600)));
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            isPrimaryMode = false;
    /**
                        null,
            Settings.builder()
        // fail shard
        } catch (AlreadyClosedException e) {
        }
        } finally {
        populateSampleRemoteTranslogStats(remoteTranslogTransferTracker);
            IndexShardClosedException.class,
                    )
        );
            closeShards(shard);
     * resetEngineToGlobalCheckpoint snapshot metadata could fail
        }, future);
        IndexShard shard = newShard(true, Settings.EMPTY, new EngineBackedIndexerFactory(config -> {
        }
                snapshotCompletedLatch.countDown();
        } catch (IndexShardRecoveryException ex) {
            assertThat(ex.getMessage(), containsString(IndexShard.REPLICA_SYNC_TIMEOUT_MARKER));
                SeqNoFieldMapper.NAME,
            // A second attempt to delete the file will properly move it to pending deletion, and be filtered from listAll.
            write(state1, env.availableShardPaths(id));
                    IndexShardTestUtils.getFakeDiscoNode(newShard.routingEntry().currentNodeId()),
        assertEquals(100.0f, newShard.recoveryState().getTranslog().recoveredPercent(), 0.01f);
        final Releasable operation2;
                            }
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNoOfUpdatesOrDeletesBeforeRollback));
        assertThat(getShardDocUIDs(shard), containsInAnyOrder("doc-0", "doc-1"));
                Version.CURRENT,
            final FlushRequest flushRequest = new FlushRequest();
        final IndexShard primaryShard = newStartedShard(
        indexDoc(shard, "_doc", "1");
            shard.getOperationPrimaryTerm(),
            final Thread[] threads = new Thread[operations];
        final long primaryTerm = indexShard.getPendingPrimaryTerm();
    public void testIsSearchIdle() throws Exception {
        thread.join();
    }
            primarySettings,
        shard.openEngineAndRecoverFromTranslog();
        );
                    allOperationsDone.countDown();
                SeqNoFieldMapper.TOMBSTONE_NAME
import static org.mockito.Mockito.spy;
     * @param offset     the starting sequence number
            while (stop.get() == false) {
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
                        assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
        );
            );
                    }, listener::onFailure)
                shardPath.resolveIndex(),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_VERSION_CREATED, versionCreated.id)
import org.opensearch.index.mapper.VersionFieldMapper;
            primary.awaitShardSearchActive(aBoolean -> {});
                        pendingPrimaryTerm,
                        releasable.close();
        assertEquals(1, preIndex.get());
            .settings(newSettings)
    /**
            assertThat(e, hasToString(containsString("acquirePrimaryOperationPermit should only be called on primary shard")));
        sourceShard.refresh("test");
        shard.close("do not assert history", false, false);
        );
            UUID.randomUUID().toString(),
            assertTrue(called.get());
        readonlyShard.markAsRecovering("store", new RecoveryState(readonlyShard.routingEntry(), localNode, null));
            }, Assert::assertNotNull),
                        throw new AssertionError(e);
import org.opensearch.env.NodeEnvironment;
                Settings.builder()
                        TimeValue.timeValueMinutes(30L)
        }
        assertEquals(Version.CURRENT.luceneVersion, test.minimumCompatibleVersion());
            Collection<String> catalogFiles = snap.get().getFiles(true);
                    deleteDoc(indexShard, Integer.toString(i));
        closeShards(shard);
            .filter(id -> Long.parseLong(id) <= Math.max(globalCheckpointOnReplica, globalCheckpoint))
        final IndexShard indexShard = newStartedShard(false);
            }
        assertThat(requestedMappingUpdates, hasKey("_doc"));
        target = reinitShard(target, routing);
        int bytesStarted = randomIntBetween(100, 1000);
            }
                                } finally {
            latch.await();
import org.apache.lucene.index.IndexableField;
        corruptedMarkerCount.set(0);
            ""
            }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .state(IndexMetadata.State.CLOSE)
                    lessThanOrEqualTo(storeStats.sizeInBytes() * 120 / 100)
        closeShards(primaryShard, replicaShard);
        final AtomicInteger preDelete = new AtomicInteger();
    }
        Semaphore semaphore = new Semaphore(Integer.MAX_VALUE);
                String doc = XContentFactory.jsonBuilder()
        assertTrue(shard.isRelocatedPrimary());
            // merge them away
            null,
            .build();
            flushShard(shard);
                    latch.countDown();
        // Shard is still inactive since we haven't started recovering yet
                }
                    @Override
                indexShard.flush(new FlushRequest());
        );
            final Thread thread = new Thread(() -> {
                    assertEquals(file.recovered(), 0);
import java.nio.file.FileVisitResult;
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
        Settings settings = Settings.builder()
    }
                    }
        assertEquals(
import org.opensearch.common.lease.Releasable;
        List<Translog.Operation> operations = new ArrayList<>();
    }
                    assertListenerCalled.accept(replica);
            final CommitStats commitStats = indexShard.commitStats();
                .build(),
                barrier.await();
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
                    indexShard.getOperationPrimaryTerm(),
                ""
        final String replicaAllocationId = replicaShard.routingEntry().allocationId().getId();
        closeShards(indexShard);
            }
        assertDocs(primary, "1", "2");
        closeShards(newShard);
                Releasables.close(operation2);
     */
        recoverShardFromStore(sourceShard);
                final ActionListener<Long> listener
        assertRemoteSegmentStats(remoteSegmentTransferTracker, remoteSegmentStats);
        Thread closeShardThread = new Thread(() -> {
        );
            .build();
            final CountDownLatch latch = new CountDownLatch(1);
            shardId,
            threads[threadId] = new Thread(() -> {
        assertNotEquals(
            assertEquals(1, indexShard.getActiveOperationsCount());
                                fail();
            .settings(settings)
            indexShard.indexerFactory,
            new RecoverySource.RemoteStoreRecoverySource(
                expectedLocalCheckpoint = SequenceNumbers.NO_OPS_PERFORMED;
        final long globalCheckpoint = randomLongBetween(shard.getLastKnownGlobalCheckpoint(), shard.getLocalCheckpoint());
            @Override
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testTranslogFactoryWithoutRemoteStore() throws IOException {
            .build();
                        assertThat(indexShard.getLastKnownGlobalCheckpoint(), equalTo(newGlobalCheckPoint));
            while (stop.get() == false) {
        }
                    )
            indexDoc(shard, "_doc", "test");
            OpenSearchException e = expectThrows(OpenSearchException.class, shard::storeStats);
                        MapperParsingException.class,
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        final IndexShard primaryShard = newShard(
                        everyItem(is(in(exposedDocIds)))
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueHours(1));
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNoOfUpdatesOrDeletesBeforeRollback));
            Consumer<MappingMetadata> mappingConsumer = mapping -> {
        final IndexShard shard = newStartedShard(true);
            UUID.randomUUID().toString(),
    /**
            } finally {
            containsInAnyOrder(
            new SourceToParse(shard.shardId().getIndexName(), "id-2", new BytesArray("{}"), MediaTypeRegistry.JSON)
            primary.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
     * resync has been handed to the syncer and returns the new primary routing.
                    onFailure.set(true);
            replicaRouting.currentNodeId(),
        Releasables.close(allPermits);
    }
                    }, listener::onFailure)
            randomAlphaOfLength(8),
        IndexShard replica = newShard(
            .build();
        final ShardRouting toNode1 = ShardRoutingHelper.relocate(original, "node_1");
            }
                indexShard.flush(new FlushRequest());
                } catch (IOException e) {
         * The flow of this test:
    }
            try (Engine.Searcher searcher = primary.acquireSearcher("test")) {
            IndexShardRecoveryException.class,
                newGlobalCheckPoint = randomIntBetween((int) indexShard.getLastKnownGlobalCheckpoint(), (int) localCheckPoint);
            } else {
            assertThat(e.getMessage(), containsString("onMergesDrained should only be called on primary shards"));
            shard.getLastKnownGlobalCheckpoint(),
        IndexMetadata metadata = IndexMetadata.builder("test")
        // during a node-left scenario. The shard attempts recovery using ExistingStoreRecoverySource,
            () -> {},
     * and the typed surface fails fast on misconfiguration.
            .build();
    public void testRecoverFromTranslog() throws IOException {
        indexShard.relocated(relocatingRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        assertThat(counter.get(), equalTo(0L));
            shardPath,
                .build();
                ThreadPool.Names.FLUSH,
            assertFalse(shard.isRelocatedPrimary());
        assertThat(getTranslog(indexShard).getGeneration().translogFileGeneration, equalTo(currentTranslogGeneration + 1));
        } else {
import org.opensearch.index.seqno.SequenceNumbers;
                    releasable.close();
        }
     * <p>
            // recovery can only be finalized after we release the current primaryOperationLock
                throw new AssertionError(e);
                                    latch.countDown();
                relocationException.get(),
            .primaryTerm(0, primaryTerm)
            assertEquals(1, searcher.getIndexReader().numDocs());
        updatePeriodicFlushInterval(primary, "30s");
        if (randomBoolean()) {
                    engineResetLatch.countDown();
                }
                } catch (final InterruptedException e) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    assertThat(e, instanceOf(ShardNotInPrimaryModeException.class));
            }
        tracker.addUploadBytesFailed(randomIntBetween(1, bytesStarted / 2));
                    indexShard.advanceMaxSeqNoOfUpdatesOrDeletes(i);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testAcquirePrimaryAllOperationsPermits() throws Exception {
        ShardRouting routing = newShard.routingEntry();
            }
                    }
    private static void updatePeriodicFlushInterval(IndexShard shard, String interval) {
        cancellingThread.start();
            null,
        final AtomicInteger preIndex = new AtomicInteger();
            }
        }
                indexDoc(indexShard, "_doc", id);
        );
                super.indexTranslogOperations(
        ShardId shardId = new ShardId("index", "_na_", 0);
        assertFalse(
            assertThat(ex.getMessage(), containsString("max checkpoints behind: 3"));
