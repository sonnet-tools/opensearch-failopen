        IndexShardTestCase.updateRoutingEntry(target, routing.moveToStarted());
        final IndexShardRecoveryException exception2 = expectThrows(
                    assertThat(  
import org.opensearch.index.engine.ReadOnlyEngine;  
                        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        assertNotEquals(meta, new ShardStateMetadata(!meta.primary, meta.indexUUID, meta.allocationId, meta.indexDataLocation));
            IndexShardClosedException.class,
        }
            .settings(  
        IndexShard shard = newStartedShard(true);
import org.opensearch.index.mapper.MapperService;
            if (newGlobalCheckPoint == UNASSIGNED_SEQ_NO) {  
        );
        // The stub never completes the resync listener, so the resync stays pending.  
        assertThat(replica.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            3,
        assertEquals(1, newShard.recoveryState().getTranslog().totalOperations());  
        assertTrue(primary.scheduledRefresh());  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "txlog-test")  
                randomNonNegativeLong(),  
        assertThat(target.seqNoStats().getGlobalCheckpoint(), equalTo(2L));  
import static org.hamcrest.Matchers.sameInstance;
            @Override
        // we wait for both operations to complete
                false,
        final IndexShard shard = newStartedShard(true);  
            } finally {  
            shard,
        indexDoc(newShard, "_doc", "0");
                final DocsStats docStats = indexShard.docStats();  
                        barrier.await();
                ThreadPool.Names.WRITE,  
            replica.indexerFactory,
                protected void ensureMaxSeqNoEqualsToGlobalCheckpoint(SeqNoStats seqNoStats) {
        );
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1);
        flushShard(shard);
            }, ThreadPool.Names.SAME, "test");
        assertTrue(futureAllPermits.isDone());
        assertEquals(1, preIndex.get());
            } catch (InterruptedException e) {
        }  
     * Index on the specified shard while introducing sequence number gaps.
            when(replicatingStat.getCurrentReplicationTimeMillis()).thenReturn(5000L);  
        assertNull(primary.getPeriodicFlushTask());  
                break;
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
            isPrimaryMode = true;  
        final boolean shouldRollback = Math.max(globalCheckpoint, globalCheckpointOnReplica) < indexShard.seqNoStats().getMaxSeqNo()
    public void testPeriodicFlushTaskDeferredUntilEngineExists() throws Exception {  
        indexDoc(indexShard, "_doc", "0");  
    }
            try {  
import org.apache.lucene.index.CorruptIndexException;
                preDelete.incrementAndGet();
                    ShardRoutingState.INITIALIZING,
        for (int i = 0; i < operations; i++) {
        final IndexShard primaryShard = newStartedShard(
                }  
        final long currentTranslogGeneration = getTranslog(indexShard).getGeneration().translogFileGeneration;  
        }
            .pollingIngestStats(shard.pollingIngestStats())
            ActionListener.wrap(r -> {  
        for (final Runnable assertion : assertions) {
                            postIndexUpdate.incrementAndGet();
            shard.updateGlobalCheckpointOnReplica(shard.getLocalCheckpoint(), "test");  
            .build();
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        assertTrue(segRepException.getMessage().equals("Segment replication failed"));
        recoverShardFromStore(primary);  
            null  
                ((ReleasableRetryableRefreshListener) refreshListener).drainRefreshes();
            shardPath,
        cancellingThread.start();  
        for (int i = 0; i < totalOps; i++) {  
            ActionListener.wrap(r -> {  
    }
                seqNo++; // create gaps in sequence numbers
        closeShard(shard, false);  
                true,
        assertEquals(
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));
            );
        RemoteSegmentStats remoteSegmentStats  
        ShardRouting readonlyShardRouting = newShardRouting(  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                shard.relocated(
    public void testShardActiveDuringInternalRecovery() throws IOException {  
            } catch (final BrokenBarrierException | InterruptedException e) {
            indexShard.refresh("test"); // produce segments
            @Override
            primary.shardId,  
    /**  
    public void testWaitForReplicaSync_Timeout_ThrowsIOException() throws IOException {  
        long primaryTerm;
    /**  
                Settings.builder()  
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(2L + i - 1));  
    public void testPrimaryPromotionDelaysOperations() throws IOException, BrokenBarrierException, InterruptedException {
     * Simulates a scenario that happens when we are async fetching snapshot metadata from GatewayService  
            closeShards(indexShard);
    }
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
            .build();
        assertEquals(getEngine(replicaShard).getClass(), InternalEngine.class);  
            null,  
            IndexShard spyShard = spy(shard);
    public void testTranslogBackedByRemoteStoreMatchesHydrationCondition() {
                    mappingVersion,
        shard.applyIndexOperationOnReplica(
        // Make sure to drain refreshes from the shard. Otherwise, if the refresh is in-progress, it overlaps with  
        );  
import org.opensearch.index.seqno.RetentionLease;
        });  
    public void testShardStateMetaHashCodeEquals() {
        IndexShard shard = newStartedShard(
        indexDoc(shard, "_doc", "1");
        AllocationId allocationId = randomBoolean() ? null : randomAllocationId();
            latch.await();
        settings = Settings.builder()
        for (int i = 0; i < 10; i++) {  
        shard.refresh("created segment 2");
                indexDoc(indexShard, "_doc", id);
                    );
        IndexShard primaryShard = newShard(  
            final SeqNoStats seqNoStats = indexShard.seqNoStats();
        assertNotNull(flushTask);
                final RetentionLeases retentionLeases,  
            closeShards(shard);  
            ShardRoutingState.INITIALIZING,  
        ShardId shardId = new ShardId("index", "_na_", 0);  
import org.opensearch.common.util.concurrent.AtomicArray;
                        "1",
            }
            for (int i = 0; i < numDoc; i++) {
        IndexShard shard = newStartedShard(p -> newShard(true, mock), true);  
                null,
        assertTrue("Expected no results, operations are blocked", results.asList().isEmpty());
                                throw new RuntimeException(e);  
        final ShardRouting originalRouting = shard.routingEntry();  
             * the race, then the other thread lost the race and only one operation should have been executed.
                    Store.MetadataSnapshot readMeta = newShard.snapshotStoreMetadata();
        recoverFromStore(readonlyShard);
            final Thread[] threads = new Thread[operations];
            .build();
        // try to start another time shard on corrupted files  
                randomRealisticUnicodeOfCodepointLengthBetween(1, 10),
            try (Translog.Snapshot snapshot = getTranslog(newShard).newSnapshot()) {
            false,  
            indexDoc(shard, "_doc", "test");
        indexDoc(indexShard, "_doc", "0");
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
            indexShard.getPendingPrimaryTerm() + 1,
        AtomicInteger postIndexCreate = new AtomicInteger();
            public void onFailure(Exception e) {
        // Periodic flush task should be started  
import org.apache.lucene.index.Term;  
            }
        assertDocCount(newShard, 0);
            AllocationId.newRelocation(routing.allocationId())
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<Path>() {
                    engineResetLatch.countDown();
     * This test simulates a scenario seen rarely in ConcurrentSeqNoVersioningIT. Closing a shard while engine is inside  
     * replica is a wiring bug and the assertion surfaces it loudly.
        // now check that it's persistent ie. that the added shards are committed  
        });
        closeShards(shard);
        }  
            shard.indexSettings.getNodeSettings(),  
        assertTrue("it's already recovering, we should ignore new ones", newShard.ignoreRecoveryAttempt());
        );
        CountDownLatch creatingEngineLatch = new CountDownLatch(1);
            latch.countDown();
                    allPermitsTerminated.await();
        return new Result(localCheckpoint, max);
        scopedSettings.applySettings(settings);
            }
                targetShard.getReplicationTracker()
        closeShards(newShard);  
            noopDoc.getFields().stream().map(IndexableField::name).collect(Collectors.toList()),
        delayedOperationsBarrier.await();
            operation1 = null;
            if (rarely()) {
                throw new AssertionError(e);  
            case 0:  
        };  
                    listener.onFailure(e);  
            routing,
        );
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            shard.applyIndexOperationOnReplica(  
        expectThrows(IllegalIndexShardStateException.class, () -> IndexShardTestCase.updateRoutingEntry(shard, originalRouting));
                .getLocalCheckpoint(),  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.common.Randomness;
        try {
                    engineResetLatch.countDown();  
            // we're only checking that listeners are called when the engine is open, before there is no point  
 * software distributed under the License is distributed on an
        IndexShard shard = newStartedShard(true, segRepSettings);
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     * real values from the underlying merge scheduler. An idle Lucene shard with no merges in flight  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        } finally {
                        counter.incrementAndGet();  
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));  
        assertEquals(shard.shardPath().getRootStatePath().toString(), stats.getStatePath());
        closeShards(corruptedShard2);
            .primaryTerm(0, 1)  
        } finally {  
        final ShardRouting originalRouting = shard.routingEntry();
        closeShard(shard, false);  
        searchReplicaShardRouting = ShardRoutingHelper.moveToUnassigned(  
        );
    public void testTranslogRecoverySyncsTranslog() throws IOException {
                }
        closeShards(indexShard);
        IndexShard newShard = newShard(
        CountDownLatch recoveryStartedLatch = new CountDownLatch(1);
                } else {
        closeShards(primary, replica);  
            replicaRouting.currentNodeId(),
        assertEquals(replicaShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
            assertThat(storeStats.sizeInBytes(), greaterThan(0L));  
                        // if rollback happens we roll translog twice: one when we flush a commit before opening a read-only engine
        assertTrue("engine creation should start", creatingEngineLatch.await(30, TimeUnit.SECONDS));  
    public void testPrimaryReplicaResyncOnFailureClearsFlagAndFailsShard() throws Exception {  
        closeShards(newShard);  
            );
            final boolean singlePermit = randomBoolean();  
        for (int i = 0; i < indexThreads.length; i++) {
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
     * and the assertion surfaces it loudly.
        } finally {  
        final int recoveryIndex = randomIntBetween(0, numberOfAcquisitions - 1);
        CountDownLatch latch = new CountDownLatch(1);
import org.apache.lucene.search.TopDocs;  
            indexShard.indexerFactory,
            fail();  
        closeShard(shard, false);
        );
        final int operations = 1024 - scaledRandomIntBetween(0, 1024);
            indexMetadata.build(),
        IndexShard source = newStartedShard(
                final long maxSeqNoOfUpdatesOrDeletes,
     * Applies a dynamic update of {@code index.periodic_flush_interval} to the shard the same way
            }
        assertThat(deleteDoc.getField(SeqNoFieldMapper.TOMBSTONE_NAME).numericValue().longValue(), equalTo(1L));
            1,
        IndexShardTestCase.updateRoutingEntry(shard, routing);  
            primary.awaitShardSearchActive(refreshed -> {
    /**
        assertThat(counter.get(), equalTo(0L));
        if (isPrimary) {
                    numNoops++;
        readonlyShard.markAsRecovering("store", new RecoveryState(readonlyShard.routingEntry(), localNode, null));  
            }
                    }, listener::onFailure)  
import org.opensearch.indices.IndicesQueryCache;  
                final boolean relocating = randomBoolean();
     * primary-side (replicas don't run merges), so calling this method on a replica is a wiring bug
            );
            new SourceToParse(indexName, "doc-0", new BytesArray("{}"), MediaTypeRegistry.JSON)
                .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
                }
            RecoverySource.PeerRecoverySource.INSTANCE  
        assertEquals(remoteSegmentTransferTracker.getUploadBytesFailed(), remoteSegmentStats.getUploadBytesFailed());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
package org.opensearch.index.shard;
            }
        }
            final long expectedLocalCheckpoint;
        assertFalse(primaryShard.getIndexer().config().isReadOnlyReplica());
                        throw new RuntimeException(e);  
        );
            );
                ShardRoutingState.INITIALIZING,
         */
            if (corruptIndexException) {
        shard.relocated(inRecoveryRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
        }  
            latch.countDown();
            recoverShardFromStore(shard);
        } else {  
    /**  
        if (randomBoolean()) {  
        IndexShard shard = newShard(false, segRepSettings, customFactory);  
            .seqNoStats(shard.seqNoStats())
import org.opensearch.test.store.MockFSDirectoryFactory;
            // If a field doesn't exist an empty IndexFieldData is returned and that isn't cached:  
            commitGeneration = segmentInfos.getGeneration();
            routing.currentNodeId(),
            @Override
        assertThat(indexShard.getOperationPrimaryTerm(), equalTo(indexShard.getPendingPrimaryTerm()));  
        // simulate a background maybe sync; it should only run if the knowledge on the replica of the global checkpoint lags the primary
        try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = source.getSegmentInfosSnapshot()) {
                    } catch (InterruptedException | BrokenBarrierException | ExecutionException e) {  
            public void postIndex(ShardId shardId, Engine.Index index, Exception ex) {
                super.prepareForTranslogOperations(totalTranslogOps, ActionListener.wrap(r -> {  
        assertFalse(synced.get());  
                        everyItem(is(in(exposedDocIds)))  
        final AtomicBoolean synced = new AtomicBoolean();
            final String executor = ThreadPool.Names.WRITE;
            int hitClosedExceptions = 0;
            primary.recoveryState().getTranslog()::incrementRecoveredOperations
        try {  
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        final IndexShard indexShard = newShard(false);  
                        if (file.equals("write.lock") || file.startsWith("extra")) {  
        // Get initial flush count  
 * the Apache License, Version 2.0 (the "License"); you may
        assertNull(primary.getPeriodicFlushTask());
        int totalOps = randomInt(10);
        );
            assertFalse(onResponse.get());
                Store store,
                assertThat(docsStats.getAverageSizeInBytes(), greaterThan(0L));  
                RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE  
                } else {  
            Settings.builder()
        assertNotEquals(
                assertThat(e.getMessage(), equalTo("failure"));
        assertTrue("at least 2 files, commit and data: " + storeFileMetadatas.toString(), storeFileMetadatas.size() > 1);
        );
        ShardRouting routing = shard.shardRouting;
        indexOnReplicaWithGaps(replica, between(0, 1000), Math.toIntExact(replica.getLocalCheckpoint()));  
            thread.join();
import static org.hamcrest.Matchers.hasSize;
        // start recovery thread  
            .commitStats(shard.commitStats())
            UUID.randomUUID().toString(),  
        indexDoc(target, "_doc", "1");  
            thread.start();
        assertNotNull(flushTask);  
        try (Translog.Snapshot snapshot = getTranslog(newShard).newSnapshot()) {  
                    allOperationsDone.countDown();
     * <a href="https://github.com/opensearch-project/OpenSearch/issues/11869">#11869</a>:
    public void testGetChangesSnapshotThrowsAssertForSegRep() throws IOException {  
        IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
            translogOps = 0;
                    throw new AssertionError(e);
        target.markAsRecovering("remote_store", new RecoveryState(routing, localNode, null));
            ShardStateMetadata state3 = new ShardStateMetadata(primary, "fooUUID", allocationId);  
import org.opensearch.core.index.shard.ShardId;  
                assertions.add(() -> {  
            assertThat(indexShard.getIndexer(), not(sameInstance(beforeRollbackIndexer)));
import org.opensearch.index.translog.Translog;  
            searchReplicaShardRouting,
        if (shard.indexSettings.isSoftDeleteEnabled()) {
    public void testTranslogFactoryForRemoteTranslogBackedPrimaryShard() throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        final AtomicInteger postDelete = new AtomicInteger();
import org.opensearch.test.FieldMaskingReader;  
        try {
            IndexShardClosedException.class,
                                fail();
                    allOperationsDone.countDown();
                final long maxSeqNoOfUpdatesOrDeletes,
            final long newGlobalCheckPoint;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            readonlyShardRouting,  
     * not closed), rather than silently leaving the shard running.
            indexDoc(shard, "_doc", Integer.toString(i));
        if (randomBoolean()) {
                }
        }  
                                )
                final int totalTranslogOps,  
            @Override  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            final String id = "t_" + i;  
                            }
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-test")
                    false,  
            final CountDownLatch latch = new CountDownLatch(operations);
        indexShard.addShardFailureCallback(ig -> shardFailed.set(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        flushShard(shard);
            AssertionError e = expectThrows(
        assertThat("corruption marker should not be there", corruptedMarkerCount.get(), equalTo(0));
     * recovery thread holds {@code readLock} (via {@code recoverFromTranslog}) and calls
        // Shard is still inactive since we haven't started recovering yet  
        assertTrue(primary.getIndexer().refreshNeeded());
            replayedOps = 5;
        }
     * @param indexShard the shard
            ReplicationFailedException.class,
                Version.CURRENT,  
import org.opensearch.index.mapper.ParsedDocument;
            // Spy on the shard to simulate a replica that's always behind  
            final Thread thread = new Thread(() -> {  
                    latch.countDown();
        populateSampleRemoteTranslogStats(remoteTranslogTransferTracker);  
            EngineConfig configWithWarmer = new EngineConfig.Builder().shardId(config.getShardId())  
            public void onResponse(final Releasable releasable) {
            when(inSyncStat.getCurrentReplicationTimeMillis()).thenReturn(0L);  
            closeShards(shard);
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        assertFalse(indexShard.isPrimaryReplicaResyncInProgress());  
        shardStateMetadata = load(logger, shardStatePath);
        final IndexShard shard = newStartedShard(true);
            AtomicBoolean failureCallbackTriggered = new AtomicBoolean(false);
    public void testRefreshIsNeededWithRefreshListeners() throws IOException, InterruptedException {  
        }
        final int translogOps;  
        expectThrows(AlreadyClosedException.class, () -> shard.acquireLastIndexCommit(false));  
        );
        AtomicBoolean armed = new AtomicBoolean(false);  
        final ShardRouting primaryRouting = promoteReplicaWithResyncSyncer(
    public void testConcurrentTermIncreaseOnReplicaShard() throws BrokenBarrierException, InterruptedException, IOException {  
     * {@code IndexService#updateMetadata} does: update the index settings, then notify the shard.
        int numTotalEntries = randomIntBetween(0, 10);
            PathUtils.get(remoteStorePath)  
                        either(equalTo(translogGen + 1)).or(equalTo(translogGen + 2))
        }  
        assertThat(  
                throw new RuntimeException(e);  
        populateSampleRemoteSegmentStats(remoteSegmentTransferTracker);
            default:
    /**  
                        },
    public void testRunUnderPrimaryPermitDelaysToExecutorWhenBlocked() throws Exception {
            AllocationId allocationId = randomBoolean() ? null : randomAllocationId();
            false,
                        releasable.close();  
        final PlainActionFuture<Releasable> futureAllPermits = new PlainActionFuture<Releasable>() {  
        try {
            }  
import org.opensearch.index.mapper.MappedFieldType;  
                shard.resetEngineToGlobalCheckpoint();
     */  
            targetShard.markAsRecovering("store", new RecoveryState(targetShard.routingEntry(), localNode, null));
            null,
            @Override
        final ShardRouting relocatingRouting = ShardRoutingHelper.relocate(primaryRouting, "other_node");
            final Thread thread = new Thread(() -> {
                } else {
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 1; shard.refreshStats().getTotalTimeInMillis() == initialTotalTime; i++) {  
                replicaRouting.shardId(),  
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<Path>() {  
        assertEquals(
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")  
        // The syncer immediately completes the resync listener successfully.
        CountDownLatch latch = new CountDownLatch(1);
                }  
            .settings(settings)  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                SeqNoFieldMapper.PRIMARY_TERM_NAME  
                    }
    public void testRefreshMetric() throws IOException {
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");  
        }
        }
        final IndexShard replicaShard = newStartedShard(
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();  
    }
        final CyclicBarrier delayedOperationsBarrier = new CyclicBarrier(1 + delayedOperations);
        IndexShard indexShard = null;
        }  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        assertEquals(  
            .shardPath(shard.shardPath())  
            assertNull(result.v2());
import org.opensearch.index.store.StoreUtils;
        }
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        proceedWithCreationLatch.countDown();
            }
        for (long i = 0; i < numDocs; i++) {
                        newPrimaryTerm,
    public void testRecoverFromStore() throws IOException {  
import org.opensearch.common.unit.TimeValue;  
        assertTrue(shard.isRelocatedPrimary());
    }  
        }
            }
        scopedSettings.applySettings(settings);
     */  
            .collect(Collectors.toSet());
                shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        scopedSettings.applySettings(settings);  
    public void testRefreshListenersDuringPeerRecovery() throws IOException {
        }
    public void testPrimaryReplicaResyncTimeoutUnblocksPrimaryRelocation() throws Exception {  
import org.apache.lucene.store.IOContext;
    }  
                try (Releasable dummy = r) {
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
        allOperationsDone.await();
     * Verifies {@code waitForReplicaSync} throws IOException when replicas fail to sync within timeout.
import java.nio.file.Files;  
            expectThrows(AlreadyClosedException.class, () -> indexShard.commitStats());  
        // The promoted primary can now relocate.
            @Override  
                UUID.randomUUID().toString(),
        // all docs are present  
            ),
                    try {
        if (isPrimaryMode) {
        final Releasable allPermits = futureAllPermits.get();
            flushShard(shard);  
            RetentionLeaseSyncer.EMPTY,
            indexShard = newStartedShard(true);
                        }  
        CorruptionUtils.corruptIndex(random(), indexPath, false);  
            indexShard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        IndexShardTestCase.updateRoutingEntry(shard, routing);
                    AssertionError.class,
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            }
        if (randomBoolean()) {
        },  
        try (NodeEnvironment env = newNodeEnvironment()) {
        ShardRouting routing = ShardRoutingHelper.initWithSameId(
        final CountDownLatch latch = new CountDownLatch(1);
        target = reinitShard(target, routing);  
                );
        indexDoc(source, "_doc", "2");  
        Settings settings = Settings.builder()
                        releasable.close();  
        assertEquals(
        assertEquals(1, postDelete.get());  
            equalTo(totalOps - 1L)
                    public void onFailure(Exception e) {
            randomAlphaOfLength(8),
                    releasable.close();
        IndexMetadata metadata = IndexMetadata.builder("test")  
        assertThat(target.getLocalCheckpoint(), equalTo(2L));
        }, false, true);
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-test")
        assertThat(primary.recoveryState().getTranslog().recoveredOperations(), equalTo(numTotalEntries - numCorruptEntries));
                            public void onResponse(Releasable releasable) {  
            when(inSyncStat.getBytesBehindCount()).thenReturn(0L);
        Settings settings = Settings.builder()
            .settings(settings)
            assertThat(e, instanceOf(IllegalStateException.class));
                    default:
     * Verifies {@code waitForReplicaSync} returns immediately on a non-segment-replication index  
        closeShards(primaryShard, replicaShard);
            otherShard,
        closeShards(primary);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            false,
    }  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                } finally {  
        // create the primary shard with a callback that sets a boolean when the global checkpoint sync is invoked
                .build(),
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")  
            Engine.GetResult ignored = shard.get(new Engine.Get(true, false, "test", new Term(IdFieldMapper.NAME, Uid.encodeId("test"))))
            target.routingEntry(),
        CountDownLatch warmerBlocking = new CountDownLatch(1);
import org.opensearch.core.Assertions;
        IndexMetadata metadata = IndexMetadata.builder("test")
                } catch (Exception e) {
        assertEquals(shard.fieldData().stats("foo").getMemorySizeInBytes(), after.getMemorySizeInBytes());
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            ShardId id = new ShardId("foo", "fooUUID", 1);
        closeShards(shard);  
            IndexMetadata.builder(shard.indexSettings.getIndexMetadata())  
        closeShards(primary);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            )
            randomAlphaOfLength(8),
            null,  
        final IndexShard corruptedShard = newShard(  
                .build()
        indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
        final AtomicBoolean relocated = new AtomicBoolean();  
        }  
                        globalCheckpoint,
     * Guards against regressions where the method reverts to using getSegmentInfosSnapshot().
            replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
            Math.toIntExact(primaryShard.getLastKnownGlobalCheckpoint())
                    indexShard.acquirePrimaryOperationPermit(future, ThreadPool.Names.WRITE, "");
        closeShards(shard);
        assertTrue(relocated.get());
        ShardRouting shardRouting = TestShardRouting.newShardRouting(  
            final CyclicBarrier barrier = new CyclicBarrier(1 + operations);
            indexShard.indexerFactory,
            () -> shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {  
        String remoteStorePath = createTempDir().toString();  
                        },
        // Index #0, index #1  
            new Engine.Get(true, true, "0", new Term("_id", Uid.encodeId("0")))
            .build();
import org.opensearch.common.settings.IndexScopedSettings;
        futures.forEach(future -> assertFalse(future.isDone()));  
                } catch (IOException e) {
            assertEquals(0, shard.getActiveMergeCount());
import org.opensearch.cluster.routing.ShardRouting;  
                latch.countDown();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                shardPath,
                );  
        ).collect(Collectors.toList());  
     * primary-side only (replicas receive segments via segment-rep), so calling this method on a
    public static ShardStateMetadata load(Logger logger, Path... shardPaths) throws IOException {  
            Releasable operation1 = acquirePrimaryOperationPermitBlockingly(indexShard);  
        assertFalse("closed indices should skip global checkpoint sync", synced.get());  
                .translogConfig(config.getTranslogConfig())  
        final long externalRefreshCount = shard.refreshStats().getExternalTotal();
        }  
        flushShard(shard);  
                    recoveryState.getIndex().setFileDetailsComplete();
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);  
        final IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();  
            indexShard = newStartedShard();
 */
            IndexShardTestUtils.getFakeDiscoveryNodes(newRouting)
        shard.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
            });
            .settingsVersion(current.getSettingsVersion() + 1)  
        final ShardRouting replicaRouting = shard.routingEntry();
                    .put(indexShard.indexSettings.getSettings())  
        // ensure we only transition after pending operations completed
        allowShardFailures();
            translogOps = 4; // delete #1 won't be replayed.
        engineResetLatch.await();
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
        final IndexShard indexShard,  
            indexShard.getRetentionLeaseSyncer(),
            });  
        try (Store store = createStore(indexShard.indexSettings(), shardPath)) {  
        engineResetLatch.await();
        Randomness.shuffle(operations);
                preDelete.incrementAndGet();
        delayedOperationsLatch.await();
                    indexShard.getOperationPrimaryTerm(),  
        assertTrue(stop.compareAndSet(false, true));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            null
        indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {  
        return fut.get();
            true,
import static org.hamcrest.Matchers.in;  
     * Verifies the primary-only assertion on {@code onMergesDrained}: drain notifications are  
        final IndexSettings remoteStoreIndex = new IndexSettings(
        );  
import org.opensearch.index.mapper.MapperParsingException;
            assertFalse(shard.isRelocatedPrimary());
                        }  
        Thread recoveryThread = new Thread(() -> expectThrows(AlreadyClosedException.class, () -> recoverShardFromStore(shard)));
        assertThat(counter.get(), equalTo((long) delayedOperations));
        IndexShard shard = newStartedShard(true);
            IndexMetadata.builder("docrep")  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        }
        assertEquals(1, postIndexCreate.get());  
            shardRouting,
        // onResponse must have cleared the flag without failing the shard.
        assertEquals(shardStateMetadata, getShardStateMetadata(shard));
        closeShards(shard);  
        assertEquals(TimeValue.timeValueMinutes(1), flushTask.getInterval());
                        latch.countDown();  
                            @Override
            assertThat(e, hasToString(containsString("acquireAllPrimaryOperationsPermits should only be called on primary shard")));
                } catch (InterruptedException e) {
        });
        // all docs are present
        closeShard(indexShard, false); // skip asserting translog and Lucene as we rolled back Lucene but did not execute resync
            Collection<String> catalogFiles = snap.get().getFiles(true);
                    localCheckpoint++;
     * {@code acquireSafeIndexCommit}, and {@code acquireSnapshot}.
        primaryShard.updateLocalCheckpointForShard(replicaAllocationId, replicaLocalCheckpoint);
     * engine. Same rationale as the {@code onMergesDrained} test — tiering only targets DFA shards,
        }, ThreadPool.Names.GENERIC, "");
        closeShards(corruptedShard2);  
        CountDownLatch allPrimaryOperationLocksAcquired = new CountDownLatch(numThreads);  
        // We use Supplier<IOException> instead of IOException to produce meaningful stacktrace  
        final AtomicInteger preIndex = new AtomicInteger();
                replicaRouting.currentNodeId(),
                "a remote-store index is remote-backed in state " + state,  
        if (randomBoolean()) {  
                    assertThat(storeFileMetadatas.recoveryDiff(readMeta).identical.size(), equalTo(storeFileMetadatas.size()));
        try {  
                return in.getPendingDeletions();
        );
    }  
        final Thread[] threads = new Thread[randomIntBetween(2, 5)];
        // Shard should now be active since we did recover:
        // (remember stack trace is filled when exception is instantiated)
        closeShards(indexShard);
            target.routingEntry(),  
     */
        ShardRouting routing = newShard.routingEntry();
        indexDoc(primary, "_doc", "2");  
        final IndexShard newShard = reinitShard(shard, listener);  
                syncer.accept(shard, resyncListener);
        }  
                        throw new AssertionError(e);
    public void testMinimumCompatVersion() throws IOException {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        assertEquals(2, preIndex.get());
                null,
        closeShards(shard);  
            operation1 = acquireReplicaOperationPermitBlockingly(indexShard, primaryTerm);
        final IndexShard indexShard = newShard(false);  
        // Wait until the reset has created the ReadOnlyEngine (installed as current engine)  
        target.syncSegmentsFromGivenRemoteSegmentStore(false, tempRemoteSegmentDirectory, null, false);  
            assert increment > 0;
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {  
            }
                        ThreadPool.Names.WRITE,  
        } else {
        primaryShard.maybeSyncGlobalCheckpoint("test");  
                    latch.countDown();  
                            }
            indexMetadata.build(),
        );
                    MediaTypeRegistry.JSON
                    throw new RuntimeException(e);
    }
            .build();
        closeShards(replicaShard, primaryShard);
     * (the method is a no-op when segment replication is not enabled).
                .build(),
            primarySettings,
            ShardRoutingState.INITIALIZING,  
        IndexShard replica = newShard(primary.shardId(), false, "n2", metadata, null);  
        for (final Thread thread : delayedThreads) {  
    ) {  
                final DocsStats docStats = indexShard.docStats();  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
                        assertThat(indexShard.getActiveOperationsCount(), greaterThan(0));  
            null  
            RetentionLeaseSyncer.EMPTY,  
        final ShardRouting shardRouting = shard.routingEntry();  
        final List<Thread> delayedThreads = new ArrayList<>();
                    final PlainActionFuture<Releasable> permitAcquiredFuture = new PlainActionFuture<>();
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
            shard.getLastKnownGlobalCheckpoint(),
        } else if (randomBoolean()) {
            newShardRouting(
        );
                ""
import org.opensearch.index.engine.Engine;  
                } catch (final BrokenBarrierException | InterruptedException e) {
            final StoreStats storeStats = indexShard.storeStats();
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> { throw new RuntimeException("boom"); };  
                    assertNull(onFailure.get());
            (s, r) -> resyncLatch.countDown(),  
                indexShard.flush(new FlushRequest());
import org.opensearch.index.store.StoreStats;  
            assertThat(  
        final long primaryTerm = indexShard.getPendingPrimaryTerm();
            fail("exception expected");  
        } finally {  
            primaryTerm,
        final long promotedTerm = indexShard.getPendingPrimaryTerm() + 1;
import org.opensearch.common.io.stream.BytesStreamOutput;  
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        indexShard.updateShardState(  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        shard.applyIndexOperationOnReplica(
            }
     */  
import java.util.stream.Stream;
        }  
            return new InternalEngine(configWithWarmer);
        final IndexShard shard = newStartedShard(true);
            () -> indexShard.acquireAllReplicaOperationsPermits(  
            write(state2, env.availableShardPaths(id));
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
        indexDoc(shard, "_doc", "test");
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;  
        // check that corrupt marker is there
            EMPTY_EVENT_LISTENER,
        } else {
        recoveryThread.start();
                    armed.set(true);  
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
                indexShard,  
        }
public class IndexShardTests extends IndexShardTestCase {
            deleteDoc(shard, "1");
        }  
        final ShardRouting shardRouting = newShardRouting(
                    throw new RuntimeException(e);
        closeShards(shard);
            recoverShardFromStore(newShard);  
            searchReplicaShardRouting,
                    shard.resetEngineToGlobalCheckpoint();
                    assertThat(threadPool.relativeTimeInMillis(), greaterThan(shard.getLastSearcherAccess()));
        IndexShardTestCase.updateRoutingEntry(shard, routing);
            shard.shardPath(),
        );
            assertEquals(0, indexShard.getActiveOperationsCount());  
            ShardRoutingState.INITIALIZING,
                .settings(
        try {
        closeShards(shard);  
        }  
                        proceedWithRecoveryLatch.await(30, TimeUnit.SECONDS);
    }
    }  
        indexDoc(shard, "_doc", "1");
     * Verifies {@code waitForReplicaSync} does NOT return immediately when replication is in progress
    public void testTranslogFactoryForRemoteTranslogBackedReplicaShard() throws IOException {  
     * Creates a started replica whose recovery settings use the given primary-replica resync timeout.  
        long commitGeneration;  
        }
    public void testPeriodicFlushTaskExecutesFlush() throws Exception {
            }  
    }
            fail("index not there!");  
                    throw new AssertionError(e);  
                        counter.incrementAndGet();
                assertNull(onFailure.get());  
            latch.await();  
        // complete pending operations  
                assertBusy(() -> {  
                    indexShard.routingEntry().allocationId().getId(),
                            .stream()  
        assertEquals(1, preDelete.get());
        }
            replicaRouting.shardId(),  
                    public void onFailure(Exception e) {
            delayedThreads.add(thread);
            ShardRoutingState.INITIALIZING,  
        final IndexShard indexShard = newStartedShard(true);
            indexThreads[i] = new Thread() {  
        Files.walkFileTree(indexPath, corruptedVisitor);
    public void testTranslogFactoryWithoutRemoteStore() throws IOException {
            indexShard.getGlobalCheckpointSyncer(),
import org.opensearch.core.xcontent.XContentBuilder;
                );  
        Set<Integer> hashCodes = new HashSet<>();  
                @Override
        IndexShard target = newStartedShard(  
                @Override  
            }
    public void testFreezeForTiering_OnReplica_TripsPrimaryAssertion() throws IOException {
            primaryTerm = source.getOperationPrimaryTerm();  
        recoverShardFromStore(newShard);
        assertThat(deleteTombstone.docs(), hasSize(1));
        recoverShardFromStore(replica);  
            shardRouting,
        final IndexShard primaryShard = newStartedShard(  
                "relocation target ["  
        );
        thread.join();  
        assertEquals(0, postIndexException.get());  
            };
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
import org.opensearch.indices.replication.common.ReplicationType;  
        Translog.Snapshot snapshot = TestTranslog.newSnapshotFromOperations(operations);  
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<Path>() {  
             * If one thread tried to set the primary term to a higher value than the other thread and the thread with the higher term won
        latch.await();  
            .primaryTerm(0, 1)  
                    true,
                    ActionListener.wrap(r -> {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
            final AtomicReference<Exception> onFailureException = new AtomicReference<>();  
        return replica;  
        if (Assertions.ENABLED && indexShard.routingEntry().isRelocationTarget() == false) {
        final long firstIncrement = 1 + (randomBoolean() ? 0 : 1);
            .build();
                    allPermitsAcquired.await();
            1,
                    } catch (final BrokenBarrierException | InterruptedException e) {  
            @Override
                        super.onResponse(releasable);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            } catch (InterruptedException | IOException e) {
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        closeShards(shard);
                        throw new AssertionError(e);
        updatePeriodicFlushInterval(primary, "-1");
            randomNonNegativeLong(),
                .settings(
        assertEquals(0, indexingStats.getTotal().getDeleteCurrent());
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
                    totalTranslogOps,  
                ),
        try {  
                IndexShardTestCase.updateRoutingEntry(shard, originalRouting);  
            assertTrue(
                .build(),
    /**
            futures.add(threadId, future);
                indexShard.getPendingPrimaryTerm() + randomIntBetween(1, 100),
            false,
                @Override  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        Files.walkFileTree(indexPath, corruptedVisitor);
            EMPTY_EVENT_LISTENER,
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMinutes(1))  
                null,
                    }
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            final String id = "d_" + i;
                return delete;  
        }  
                exceptionToThrow.set(() -> new CorruptIndexException("Test CorruptIndexException", "Test resource"));  
        // Regular index: periodic flush disabled by default, so no task is started with the engine.
        assertTrue(shard.isRelocatedPrimary());  
                );
        closeShards(indexShard);
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));  
            true,
        } finally {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            search = searcher.search(new TermQuery(new Term("foobar", "bar")), 10);
                    barrier.await();  
        target = reinitShard(target, routing);
                shard.getIndexer().translogManager().rollTranslogGeneration();
            closeShards(shard);  
        final IndexShard indexShard;  
            assertThat(ex.getMessage(), containsString(IndexShard.REPLICA_SYNC_TIMEOUT_MARKER));  
        if (performFlush) {
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
            .build();
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperations());
                        maxSeqNoOfUpdatesOrDeletes,  
        assertEquals(0, postDeleteException.get());
            }  
        // close store.
                    @Override  
            } else {
            primaryTerm,  
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,  
        shard.sync(); // advance local checkpoint
        latch1.await();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    /**
                indexShard = newStartedShard(true);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        routing = newShardRouting(
            indexShard.sync();
        assertEquals(remoteTranslogTransferTracker.getUploadBytesSucceeded(), remoteTranslogStats.getUploadBytesSucceeded());  
        };
        final IndexShardRecoveryException exception1 = expectThrows(
            assertEquals(search.totalHits.value(), 1);
            .commonStats(new CommonStats(new IndicesQueryCache(Settings.EMPTY), shard, new CommonStatsFlags()))
        recoverShardFromStore(primary);
     */
        assertTrue(indexShard.isPrimaryReplicaResyncInProgress());
            .settings(settings)
        shard.getIndexer().translogManager().rollTranslogGeneration();
     * @param operations the number of operations
        Set<String> ids = new HashSet<>();
        );
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        IndexShard newShard = reinitShard(
                .mapToObj(
        IndexMetadata metadata = IndexMetadata.builder("test").settings(settings).primaryTerm(0, 1).build();  
                    }, listener::onFailure)
        IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
        IndexShard replica = newStartedShard(false);  
            if (randomBoolean()) {  
import org.opensearch.index.translog.TestTranslog;
                readyToSnapshotLatch.await();
 */
        IndexShard indexShard = newStartedShard(isPrimary);
                super.indexTranslogOperations(
            shard.indexSettings().getIndexMetadata(),
                oldPrimaryTerm,
        shard.relocated(toNode2.getTargetRelocatingShard().allocationId().getId(), ctx -> relocated.set(true), () -> {});
                        invoked.set(true);
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(externalRefreshCount));
        final AtomicBoolean shardFailed = new AtomicBoolean(false);
        assertDocCount(newShard, 0);
        final int numThreads = randomIntBetween(2, 4);
    }  
        );  
                UNASSIGNED_SEQ_NO,
            }  
        );
                            }
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
                    assertEquals(0, operation.seqNo());
                Releasables.close(operation1);
                randomNonNegativeLong(),  
        final CountDownLatch allPermitsTerminated = new CountDownLatch(1);
import org.opensearch.common.UUIDs;
        assertEquals(0, postDeleteException.get());  
        tracker.addUploadBytesSucceeded(randomIntBetween(1, bytesStarted / 2));  
    public void testOnMergesDrained_NonDfaEngine_ThrowsUnsupported() throws IOException {  
        indexDoc(sourceShard, "_doc", "0", "{\"foo\" : \"bar\"}");  
                    List<String> exposedDocIds = EngineTestCase.getDocIds(getEngine(shard), rarely())
        IndexShard.AsyncShardFlushTask restarted = primary.getPeriodicFlushTask();
import static java.util.Collections.emptySet;
        // Setting the RecoverySource to ExistingStoreRecoverySource to simulate a shard initializing on a new node
        recoverShardFromStore(primaryShard);  
            // we could race and assert on the count before the permit is returned  
            null
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new EngineBackedIndexerFactory(new InternalEngineFactory()),  
                }  
                try (Engine.Searcher searcher = indexShard.acquireSearcher("test")) {
        final CountDownLatch allPermitsAcquired = new CountDownLatch(1);  
            randomAlphaOfLength(8),  
                final String id = Integer.toString(i);
        // Verify getCatalogSnapshot returns non-empty files (proving it's being used)  
        assertTrue(future.actionGet());
            } else {
                VersionFieldMapper.NAME,
            shard.getOperationPrimaryTerm(),
        );
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
        final AtomicReference<ActionListener<PrimaryReplicaSyncer.ResyncTask>> capturedListener = new AtomicReference<>();
                    results.setOnce(threadId, Tuple.tuple(Boolean.TRUE, null));  
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")  
            }
        ShardStateMetadata meta = new ShardStateMetadata(  
        closeShards(primary);  
    public void testShardStatsWithRemoteStoreEnabled() throws IOException {
        );
    }
        shard.indexSettings().updateIndexMetadata(updated);
        final AtomicInteger preDelete = new AtomicInteger();
        // Recovering from store should discard doc #1
            true,
        assertFalse(shard.isActive());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testAcquireReplicaPermitAdvanceMaxSeqNoOfUpdates() throws Exception {
                latch1.countDown();
            @Override  
                snapshotDoneLatch.countDown();
            );  
        closeShards(indexShard);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertThat("store still has a single corrupt marker", corruptedMarkerCount.get(), equalTo(1));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .primaryTerm(0, 1)  
            indexShard.acquireReplicaOperationPermit(opPrimaryTerm, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, listener, executor, info);  
        Thread thread = new Thread(() -> {  
        IndexShard replicaShard = newShard(shardId, false);
                latch.countDown();
            }))
    }
import org.opensearch.index.engine.CommitStats;
            indexShard.routingEntry(),
        // then recovers a new Search Replica and asserts all docs are present
        assertTrue(primary.getIndexer().refreshNeeded());
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
import java.util.function.Function;
            .build();
                    )
            }
     * Pauses {@code resetEngineToGlobalCheckpoint} before translog replay, holds
     * one still owns the only copy of its translog and a docrep shard has no remote copy at all.
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, "SEGMENT")
import org.opensearch.index.engine.NRTReplicationEngine;
    public void testTypelessGet() throws IOException {  
        final ShardPath shardPath = indexShard.shardPath();
    /**
        assertFalse(indexShard.isSyncNeeded());
            {
import java.util.concurrent.atomic.AtomicInteger;  
        recoverReplica(replicaShard, primaryShard, true);  
                    retentionLeases,  
                ShardRouting routing = newShardRouting(
        // we can't issue this request through a client because of the inconsistencies we created with the cluster state  
                    shard.store().getMetadata(wrappedSafeCommit.get());
            ""
    public void testCheckpointRefreshListenerWithNull() throws IOException {  
        cyclicBarrier.await();
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("index")
            Collections.singleton(primaryRouting.allocationId().getId()),  
                    throw new AssertionError(e);
                assertThat(docStats.getDeleted(), equalTo(0L));
        // fail shard  
        primary.markAsRecovering(
                    AllocationId.newRelocation(AllocationId.newInitializing())  
        IndexShard primary = newStartedShard(true, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
        {
                releasable.close();
                        // Shard should now be active since we did recover:
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
        if (randomBoolean()) {  
                relocationException.get(),  
            final IndexShard differentIndex = newShard(new ShardId("index_2", "index_2", 0), true);
                ShardId snapshotShardId,
        return primaryRouting;
            replicaRouting.allocationId()
    public void testOperationPermitOnReplicaShards() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                    maxAutoIdTimestamp,
            shardStateMetadata,
                    }
                        indexShard.getMaxSeqNoOfUpdatesOrDeletes(),  
        ShardRouting shardRouting = shard.routingEntry();  
            ShardRoutingState.INITIALIZING,
        );
                return delete;  
                // advance local checkpoint
            public void onBeginTranslogRecovery() {
import org.opensearch.action.admin.indices.stats.CommonStats;
        } catch (IllegalIndexShardStateException e) {
        target.remoteStore().decRef();
    public static Indexer getIndexerFromShard(IndexShard shard) {
    public void testStressRelocated() throws Exception {
        IndexMetadata metadata = IndexMetadata.builder("test")
                try {
            logger.info("--> flushing shard");
            allocationId = AllocationId.newRelocation(allocationId);
                .externalRefreshListener(config.getExternalRefreshListener())
            }
            .pollingIngestStats(shard.pollingIngestStats())
        assertEquals(primaryShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
        }
                    .field("description", randomUnicodeOfCodepointLength(100))  
            .settings(
            thread.join();
        latch.await();
            }
                indexShard = newStartedShard(false);
import java.util.ArrayList;
            };  
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.ExistingStoreRecoverySource.INSTANCE),
                public void run() {
                    new Translog.Index(
    public void testPrimaryFillsSeqNoGapsOnPromotion() throws Exception {
                    IndexShardTestUtils.getFakeDiscoNode(newShard.routingEntry().currentNodeId()),  
            // but you can not increment with a new primary term until the operations on the older primary term complete
    ) {
        long lastSearchAccess = primary.getLastSearcherAccess();  
                    assertEquals(storeFileMetadatas.size(), storeFileMetadatas.recoveryDiff(readMeta).identical.size());
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
            assertThat(shard.refreshStats().getTotal(), equalTo(refreshCount + 1));  
            IndexShardRecoveryException.class,  
                    super.onResponse(releasable);
    }
            Engine.Warmer warmer = reader -> {  
            final PlainActionFuture<Releasable> onLockAcquired;
        assertThat(newShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(totalOps - 1L));  
                    indexDoc(indexShard, "_doc", Integer.toString(i), "{\"foo\": \"bar\"}");
        storeDirectory = ((FilterDirectory) ((FilterDirectory) target.store().directory()).getDelegate()).getDelegate();
        for (int i = 0; i < threads.length; i++) {
                expectedLocalCheckpoint = newGlobalCheckPoint;  
                    assertFalse(onResponse.get());
                });
            null  
                        shard.getPendingPrimaryTerm(),
            routing.shardId(),  
            TimeValue.timeValueMinutes(1L)  
         * - index #5  
        String historyUUID = shard.getHistoryUUID();  
            indexThread.join();
        RemoteSegmentStoreDirectory tempRemoteSegmentDirectory = createRemoteSegmentStoreDirectory(
                .eventListener(config.getEventListener())  
            @Override  
        assertTrue(primary.getPeriodicFlushTask().isClosed());
        flushShard(source);  
            true,  
import static org.hamcrest.Matchers.is;
        recoverShardFromStore(primary);
        ShardPath shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
            randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, maxSeqNoOfUpdatesOrDeletesBeforeRollback),  
            // are thrown when there is an open file handle on a particular file. FSDirectory attempts to resolve this with hacks by
    }  
            int numNoops = 0;
        assertEquals(getShardStateMetadata(shard), shardStateMetadata);  
        try {
        );  
    public void testCommitLevelRestoreShardFromRemoteStore() throws IOException {
        Thread[] indexThreads = new Thread[numThreads];
        );
            }
            );
        );  
        try (Store store = createStore(replica.indexSettings(), searchReplicaShardPath)) {
        }  
        updateMappings(
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {  
        shard.acquireAllReplicaOperationsPermits(  
                RecoverySource.ExistingStoreRecoverySource.INSTANCE
                        @Override
        shard = reinitShard(shard, new IndexingOperationListener() {  
        flushShard(shard);
        assertEquals(Version.CURRENT.luceneVersion, test.minimumCompatibleVersion());  
import org.opensearch.index.seqno.ReplicationTracker;
            new ShardStateMetadata(routing.primary(), shard.indexSettings().getUUID(), routing.allocationId())
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        recoverReplica(replica, primary, (shard, discoveryNode) -> new RecoveryTarget(shard, discoveryNode, recoveryListener, threadPool) {
                    retentionLeases,  
                final long mappingVersion,
    }
                    public void onResponse(Releasable releasable) {
        // No engine yet: onSettingsChanged must not start the task.
                .indexSettings(config.getIndexSettings())
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueHours(1));
        );  
                }
        shard.onSettingsChanged();  
        ShardRouting routing = ShardRoutingHelper.initWithSameId(
     */
            .primaryTerm(0, primaryTerm)  
        } else {
        assertEquals(0, newShard.recoveryState().getTranslog().totalOperations());
            }
        builder.endObject();
                            .collect(Collectors.toList())  
            assertThat("current routing:" + shard.routingEntry(), shard.routingEntry().relocating(), equalTo(true));
            true,
                randomNonNegativeLong(),
import org.opensearch.index.store.Store;
        indexDoc(shard, "_doc", "0");
            logger.debug("shard was relocated successfully");
            } else {  
            .directory()).getDelegate()).getDelegate());  
        expectThrows(AssertionError.class, () -> primaryShard.getHistoryOperationsFromTranslog(0, 1));  
    }
        closeShards(primary);
                break;
                        // and one after replaying translog (upto the global checkpoint); otherwise we roll translog once.  
        );
        {
                }
        closeShards(primary);
            assertEquals(1, numNoops);
            } finally {  
                        "1",  
     * Verifies {@code waitForReplicaSync} does NOT return immediately when bytesBehind is non-zero,
     * Regression test for
        assertEquals(1, postIndexUpdate.get());
        closeShards(indexShard);
                }  
                        newGlobalCheckPoint,  
        indexDoc(primary, "_doc", "1");
            UUID.randomUUID().toString(),
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        primaryShard.updateGlobalCheckpointForShard(replicaAllocationId, primaryShard.getLastKnownGlobalCheckpoint());
            deleteDoc.getFields().stream().map(IndexableField::name).collect(Collectors.toList()),
                .mapToObj(  
        barrier.await();  
        }
            } catch (final BrokenBarrierException | InterruptedException e) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            );
                public void onResponse(final Releasable releasable) {
        final IndexShard indexShard = newStartedShard(false);
            IndexShardNotStartedException.class,
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
            final Releasable permit = onAcquired.actionGet();
                .getTrackedLocalCheckpointForShard(primaryTarget.routingEntry().allocationId().getId())  
                }
            ShardRoutingState.INITIALIZING,
        ShardRouting inRecoveryRouting = ShardRoutingHelper.relocate(origRouting, "some_node");
        );
                                    throw new RuntimeException(e);  
        ShardStateMetadata shardStateMetadata = load(logger, shardPath.getShardStatePath());
                    throw new AssertionError(e);  
    ) throws Exception {  
        assertThat(primaryTarget.getLocalCheckpoint(), equalTo(totalOps - 1L));  
        } else {
        updateRoutingEntry(newShard, ShardRoutingHelper.moveToStarted(newShard.routingEntry()));
            assertThat(e.getMessage(), containsString("freezeForTiering should only be called on primary shards"));
            meta.hashCode(),  
        assertEquals(primaryShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);  
        indexShard.flush(new FlushRequest());  
    }
                }
    /**
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
import java.util.concurrent.ExecutionException;
            () -> newStartedShard(p -> corruptedShard, true)  
                try {
        IndexMetadata metadata = IndexMetadata.builder("source")  
                );  
            new EngineBackedIndexerFactory(engineConfig -> new ReadOnlyEngine(engineConfig, null, null, true, Function.identity(), true) {
        assertThat(shard.getActiveOperationsCount(), greaterThan(0));  
        snapshotThread.join();  
                    public void onResponse(Releasable releasable) {
            EMPTY_EVENT_LISTENER,
            }  
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                !meta.primary,
import org.opensearch.threadpool.ThreadPool;  
        final Result result = indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(indexShard.getLocalCheckpoint()));
        } finally {
        final IndexShard indexShard = newStartedShard(false);
            } else {
            indexShard = newShard(
            true,
            shardStateMetadata,
        assertEquals(remoteSegmentTransferTracker.getRejectionCount(), remoteSegmentStats.getTotalRejections());  
import org.opensearch.common.concurrent.GatedCloseable;
                    corruptedMarkerCount.incrementAndGet();
        primary.refresh("test");
                null
     * resync has been handed to the syncer and returns the new primary routing.
            assertEquals(1, indexShard.getActiveOperationsCount());  
                        .map(DocIdSeqNoAndSource::getId)
                IndexShardTestCase.updateRoutingEntry(indexShard, routing);
            }, Assert::assertNotNull),
                    assertEquals(newShard.getPendingPrimaryTerm(), operation.primaryTerm());  
        primaryShard.updateGlobalCheckpointForShard(shardRouting.allocationId().getId(), primaryShard.getLastKnownGlobalCheckpoint());  
                );
                            }
            .primaryTerm(0, randomLongBetween(1, Long.MAX_VALUE))
            shard.close("testing", false, false);
            true,  
                    maxSeqNoOfUpdatesOrDeletes,
            public void postDelete(ShardId shardId, Engine.Delete delete, Exception ex) {  
        final ShardRouting replicaRouting = shard.routingEntry();
            .putMapping("{ \"properties\": {} }")
    }  
                public void onFailure(Exception e) {  
        Consumer<IndexShard> assertListenerCalled = shard -> {
                assertThat(docsStats.getCount(), equalTo(numDocs));
        final long maxSeqNoOfUpdatesOrDeletesBeforeRollback = indexShard.getMaxSeqNoOfUpdatesOrDeletes();
        );
                public void onFailure(final Exception e) {
        final CountDownLatch relocationStarted = new CountDownLatch(1);
            UUID.randomUUID().toString(),  
    }
                randomAllocationId(),  
     */
                startRecovery.countDown();  
            .put(settings)
            if (armed.compareAndSet(true, false)) {
            }
        do {  
            SegmentReplicationShardStats behindStat = mock(SegmentReplicationShardStats.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            threads[threadId] = new Thread(() -> {  
            @Override  
        // check that local checkpoint of new primary is properly tracked after primary relocation
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                }  
                .queryCache(config.getQueryCache())
        expectThrows(
                assertThat(indexShard.getOperationPrimaryTerm(), equalTo(primaryTerm));
                snapshotCompletedLatch.countDown();  
        }
    }
                super.indexTranslogOperations(
                    () -> indexShard.acquireReplicaOperationPermit(  
        shard.applyIndexOperationOnReplica(
                    primaryContext -> relocationStarted.countDown(),
        for (int i = 0; i < numberOfAcquisitions; i++) {  
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
            indexShard.indexerFactory,
        expectThrows(AlreadyClosedException.class, shard::getCatalogSnapshot);
        closeShards(shard);
            )
            if (refreshListener instanceof ReleasableRetryableRefreshListener) {  
            shard.getThreadPool()
        shard.markAsRecovering("for testing", new RecoveryState(shard.routingEntry(), localNode, null));
        assertThat(noopTombstone.docs(), hasSize(1));
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            )  
            // simulate promotion  
        ShardRouting origRouting = shard.routingEntry();
            Releasables.close(operation1, operation2);
        final IndexShard shard = newStartedShard(true);  
        assertThat(exception1.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
                    super.onResponse(releasable);  
        final long globalCheckpoint = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
                indexShard.refresh("test");
        final IndexShard indexShard = newStartedShard(true);
import org.opensearch.indices.recovery.RecoveryTarget;
        assertNotEquals(
            false,  
            {
            assertFalse(shard.hasPendingMerges());
        });
        closeShards(shard);
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();  
            // A second attempt to delete the file will properly move it to pending deletion, and be filtered from listAll.
import org.opensearch.core.xcontent.NamedXContentRegistry;
        IndexShardTestCase.updateRoutingEntry(indexShard, routing);
        IndexShardTestCase.updateRoutingEntry(indexShard, relocatingRouting);
            null,  
            recoverySettings,
        long refreshCount = shard.refreshStats().getTotal();
            TimeValue.timeValueMinutes(1L)  
        ParsedDocument noopTombstone = shard.getIndexer().config().getTombstoneDocSupplier().newNoopTombstoneDoc(reason);
            }  
            null,
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            flushShard(shard);
                final long maxSeqNoOfUpdatesOrDeletes,
            );
import org.opensearch.index.engine.EngineTestCase;
        BiConsumer<IndexShard, ActionListener<PrimaryReplicaSyncer.ResyncTask>> syncer
        closeShards(corruptedShard);  
            assertTrue(result.v1());
import java.util.function.Supplier;
            SegmentReplicationShardStats replicatingStat = mock(SegmentReplicationShardStats.class);  
        );
            () -> {},
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
            ActionListener.wrap(r -> {
            newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));  
     * Verifies that {@code isRemoteSegmentStoreInSync} uses {@code getCatalogSnapshot()} (the unified
    }
            shard.getLastKnownGlobalCheckpoint(),
    }
        capturedListener.get().onFailure(new RuntimeException("simulated resync failure"));  
                assertThat(  
        IndexShardTestCase.updateRoutingEntry(shard, inRecoveryRouting);
        final IndexShard newShard = reinitShard(shard);
                public void onAfterTranslogRecovery() {  
            "awaitShardSearchActive must access a searcher to remove search idle state",
        );  
        replica.markAsRecovering("for testing", new RecoveryState(replica.routingEntry(), localNode, localNode));  
            () -> shard.relocated(toNode1.getTargetRelocatingShard().allocationId().getId(), ctx -> relocated.set(true), () -> {})
        IndexShard shard = newStartedShard();
            recoveryThread.start();
            indexDoc(indexShard, "_doc", "" + i, "{\"foo\" : \"" + randomAlphaOfLength(10) + "\"}");  
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");  
        shard.close("do not assert history", false, false);
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                onLockAcquired = new PlainActionFuture<>();  
                } finally {
    }  
            shard.refresh("test");  
                    throw new RuntimeException(e);  
import org.opensearch.index.codec.CodecService;  
            throw new UnsupportedOperationException("search lookup not available");
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(shard.refreshStats().getTotal() - 1 - extraInternalRefreshes));  
     */  
        for (IndexShard.ShardMigrationState state : IndexShard.ShardMigrationState.values()) {
            .settings(settings)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testRunUnderPrimaryPermitRunsUnderPrimaryPermit() throws IOException {
        // Delete files in store directory to restore from remote directory
        IndexShard shard = newStartedShard(false);
        Settings segRepSettings = Settings.builder()
    public void testRunUnderPrimaryPermitOnFailure() throws IOException {
            new ShardStateMetadata(routing.primary(), shard.indexSettings().getUUID(), routing.allocationId())
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test1")
                    }, listener::onFailure)
        final ShardRouting originalRouting = shard.routingEntry();
            .build();
        shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
            seqNo++;
            assertTrue(getResult.exists());
            assertThat(shard.translogStats().estimatedNumberOfOperations(), equalTo(translogStats.estimatedNumberOfOperations()));  
        final CyclicBarrier barrier = new CyclicBarrier(1 + operations);
        );
        final IndexShard shard = newStartedShard(true);  
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertThat(shard.state(), equalTo(IndexShardState.STARTED));  
                    latch.countDown();
            isPrimary ? RecoverySource.ExistingStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE  
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
                try {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        } else {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        indexDoc(target, "_doc", "1");
        }
            assertEquals(after.getEvictions(), before.getEvictions());
            shard.getEngineConfigFactory(),
        }
            indexShard.getRetentionLeaseSyncer(),  
        for (int i = 0; i < thread.length; i++) {  
            () -> synced.set(true),
            0L,
        ((BaseDirectoryWrapper) storeDirectory).setCheckIndexOnClose(false);
                            @Override  
        List<ReferenceManager.RefreshListener> refreshListeners = shard.getIndexer().config().getInternalRefreshListener();
import org.apache.lucene.index.DirectoryReader;
        PlainActionFuture<Releasable> fut = new PlainActionFuture<>();
                relocationException.set(e);
import java.util.Arrays;
import org.apache.lucene.index.IndexCommit;  
        IndexShard indexShard = newStartedShard();  
        }  
        assertEquals(0, postDelete.get());
                // now lock acquisition should have succeeded
                }, ThreadPool.Names.WRITE, id);
        Settings settings = Settings.builder()
        final ShardRouting shardRouting = indexShard.routingEntry();
        target.remoteStore().incRef();  
import org.opensearch.core.common.bytes.BytesArray;
            assertThat(shard.refreshStats().getExternalTotalTimeInMillis(), greaterThanOrEqualTo(initialTotalTime));  
    }
            equalTo(false)
            .build();
import java.util.Collection;  
    }
        final ShardRouting toNode1 = ShardRoutingHelper.relocate(original, "node_1");
        );  
            shardPath,
     * and checking index concurrently. This should always be possible without any exception.
            @Override
        );  
        flushTask.run();
        CountDownLatch snapshotDoneLatch = new CountDownLatch(1);  
        assertEquals(0, indexingStats.getTotal().getIndexCount());  
    }
        recoveryThread.start();
        IndexShard replica = newShard(
        }  
            final CommitStats commitStats = indexShard.commitStats();
                        finish();  
                            releasable.close();
        replica.advanceMaxSeqNoOfUpdatesOrDeletes(currentMaxSeqNoOfUpdates);  
        assertEquals(1, postIndexUpdate.get());
            assertThat("searcher was marked as accessed", shard.getLastSearcherAccess(), equalTo(prevAccessTime));
        assertEquals(primaryShard.getIndexer().config().getTranslogFactory().getClass(), RemoteBlobStoreInternalTranslogFactory.class);
        return allocationId;
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        Thread snapshotThread = new Thread(() -> {
        }
        // Shard is still inactive since we haven't started recovering yet  
 * The OpenSearch Contributors require contributions made to  
            indexShard,
     * primary can relocate, and it must not fail the shard.
        assertThat(getTranslog(indexShard).getGeneration().translogFileGeneration, equalTo(currentTranslogGeneration + 1));  
            newShard = reinitShard(
        closeShards(target);
        assertEquals(translogOps, newShard.recoveryState().getTranslog().recoveredOperations());
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())
            Collections.singleton(primaryRouting.allocationId().getId()),
            ShardStateMetadata shardStateMetadata = load(logger, env.availableShardPaths(id));
            );
    public void testIsRemoteSegmentStoreInSyncUsesCatalogSnapshot() throws Exception {  
        // this time there should not be a sync since all the replica copies are caught up with the primary
            try {  
            },
            try {
import org.opensearch.common.settings.ClusterSettings;  
            }  
                    delayedOperationsBarrier.await();
        final CountDownLatch latch = new CountDownLatch(operations);
            primary.shardId,
        // check state file still exists
            indexShard.getPendingPrimaryTerm() + 1,
                    greaterThanOrEqualTo(storeStats.sizeInBytes() * 80 / 100)
        closeShards(primary);  
        Thread[] thread = new Thread[randomIntBetween(3, 5)];  
        IndexMetadata metadata = IndexMetadata.builder("test")
        final ShardRouting routing = ShardRoutingHelper.relocate(originalRouting, "other_node");
                .build();
                        break;
        closeShards(primaryShard);
                final RetentionLeases retentionLeases,  
    public void testCloseShardWhileResettingEngine() throws Exception {  
        assertEquals(1, newShard.recoveryState().getTranslog().totalOperationsOnStart());
        }
            } else if (recoveryIndex == i) {
        indexShard.flush(new FlushRequest());
                    }
            Settings.builder()  
            verify(spyShard, times(1)).getReplicationStatsForTrackedReplicas();  
        Thread closeShardThread = new Thread(() -> {
        Settings segRepSettings = Settings.builder()  
        }
    public void testShardDoesNotStartIfCorruptedMarkerIsPresent() throws Exception {  
import static org.hamcrest.Matchers.oneOf;
            // and not pending delete.  
            final FlushRequest flushRequest = new FlushRequest();  
        IndexShard shard = newStartedShard(true);
import org.opensearch.index.engine.InternalEngineFactory;  
        TranslogStats translogStats = shard.translogStats();  
    public void testAsyncFsync() throws InterruptedException, IOException {  
            translogOps = 5;
        assertDocs(target, "1");  
                        targetStore.directory().copyFrom(sourceStore.directory(), file, file, IOContext.DEFAULT);  
        recoverShardFromStore(shard);  
    }
        );
    }
    }  
    /**
        // during a node-left scenario. The shard attempts recovery using ExistingStoreRecoverySource,
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
            indexMetadata.build(),
                );
                )
            () -> newStartedShard(p -> corruptedShard, true)
        private final int localCheckpoint;
            )  
        InterruptedException {  
            )
        // The ReadOnlyEngine is now the current engine, but newEngineReference is still null.
                UNASSIGNED_SEQ_NO,
        test.getIndexer().flush();
            false,
        }  
                        assertThat(indexShard.getActiveOperationsCount(), equalTo(IndexShard.OPERATIONS_BLOCKED));
                    } catch (Exception ex) {
            assertEquals(search.totalHits.value(), 1);  
                "test"  
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
        final CountDownLatch latch = new CountDownLatch(1);  
                    indexShard.getPendingPrimaryTerm(),
            new EngineBackedIndexerFactory(new InternalEngineFactory())
                        latch.countDown();
        indexDoc(source, "_doc", "5");
        promoteReplica(
        AtomicInteger postDeleteException = new AtomicInteger();
        );
        ShardStats shardStats = new ShardStats.Builder().shardRouting(shard.routingEntry())
        assertEquals(0, indexingStats.getTotal().getIndexCurrent());
                    }
                    maxAutoIdTimestamp,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        }  
    }  
            settings,
        final ShardPath searchReplicaShardPath = replica.shardPath();
import org.opensearch.index.mapper.SourceToParse;
    public void testCompletionStatsMarksSearcherAccessed() throws Exception {
    }
                storeDirectory.deleteFile(file);
        Settings settings = Settings.builder()
            forceMergeRequest.maxNumSegments(1);  
            "otherNode",
        final CountDownLatch resyncLatch = new CountDownLatch(1);
    }  
            // Advance the global checkpoint to remove the 1st commit; this shard will recover the 2nd commit.  
        snapshotThread.join(5_000);
        Store.MetadataSnapshot storeFileMetadatas = newShard.snapshotStoreMetadata();
        assertThat(noopDoc.getField(SourceFieldMapper.NAME).binaryValue(), equalTo(new BytesRef(reason)));
        CountDownLatch proceedWithCreationLatch = new CountDownLatch(1);  
        boolean gap = false;
            EMPTY_EVENT_LISTENER,  
            @Override
    public Settings threadPoolSettings() {
        assertEquals(0, newShard.recoveryState().getTranslog().recoveredOperations());  
            UUID.randomUUID().toString(),
                    // just like a following shard, we need to skip this check for now.
                }
        assertFalse(indexShard.getReplicationTracker().isPrimaryMode());
            ThreadPool.Names.WRITE,
        final IndexShard corruptedShard = newShard(
 */  
        indexDoc(source, "_doc", "0");
                assertFalse(onResponse.get());
        IndexShard primary = newStartedShard(true);  
            3,  
        final ShardRouting primaryRouting = replica.routingEntry().moveActiveReplicaToPrimary();
        searchReplicaShardRouting = ShardRoutingHelper.initialize(searchReplicaShardRouting, replica.routingEntry().currentNodeId());
            indexShard.routingEntry(),
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        IndexShard shard = newStartedShard(true, segRepSettings);
    public void testGetChangesSnapshotThrowsAssertForRemoteStore() throws IOException {  
                    lessThanOrEqualTo(storeStats.sizeInBytes() * 120 / 100)  
                    assertListenerCalled.accept(replica);
        updatePeriodicFlushInterval(primary, "2m");  
        Version versionCreated = VersionUtils.randomVersion(random());  
            flushShard(target);
        // Execute the periodic flush task  
    private IndexShard newStartedReplicaWithResyncTimeout(TimeValue resyncTimeout) throws IOException {
                } catch (InterruptedException e) {
        } finally {  
                    @Override
        );  
        Settings settings = Settings.builder()
        primaryShard.updateGlobalCheckpointForShard(replicaShard.shardRouting.allocationId().getId(), globalCheckpointOnReplica);
        for (int i = 0; i < 3; i++) {
            shardStateMetadata = load(logger, env.availableShardPaths(id));
            .filter(id -> Long.parseLong(id) <= Math.max(globalCheckpointOnReplica, globalCheckpoint))
                    replica.acquireAllReplicaOperationsPermits(  
        IndexShard replica = newStartedShard(false);
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-test")
                                try (Releasable ignored = releasable) {
import org.opensearch.index.translog.TranslogStats;
    public void testWaitForReplicaSync_AlreadyInSync_ReturnsImmediately() throws IOException {
        });  
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
     * The predicate that decides whether a shard's translog lives in the remote store drives both the recovery-time
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            };
        IndexMetadata metadata = IndexMetadata.builder("test")  
    }
            null,  
            .build();
            }
        assertThat(
    public void testCloseShardWhileEngineIsWarming() throws Exception {
                assertEquals(2, searcher.getIndexReader().numDocs());
        };  
            true,  
            randomAlphaOfLength(8),  
import java.util.List;  
        assertTrue(primary.scheduledRefresh());
            .build();
            () -> newStartedShard(p -> corruptedShard, true)  
            );  
        assertNotNull("enabling index.periodic_flush_interval on a live shard should start the task", flushTask);  
                0L,
        closeShards(replica);  
            // Ignored because corrupted shard can throw various exceptions on close
    }
            hashCodes.add(meta.hashCode());  
        );  
                assertTrue(store.isMarkedCorrupted());  
                shard.flush(new FlushRequest());
        // The resync never completes, so only the timeout can clear the flag. Wait well past the 10s timeout.
            false,
        RemoteTranslogStats remoteTranslogStats = shardStats.getStats().getTranslog().getRemoteTranslogStats();
                cancellingException.set(e);  
            () -> {},  
        IndexShard shard = newStartedShard(true);  
                }
        assertThat(shard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNoBeforeRollback));
            false,
                    latch.countDown();
                @Override
        second.join();
                indexShard.refresh("test");  
            }
                if (ids.add(id) == false) { // this is an update  
            ShardStateMetadata state1 = new ShardStateMetadata(primary, "fooUUID", allocationId);
            }
        assertTrue(shard.isActive());
                    throw new AssertionError(e);  
        int max = offset;  
        recoveryThread.start();  
            while ((operation = snapshot.next()) != null) {  
            threads.add(thread);  
            null,
    public void testResetEngine() throws Exception {  
            null
                randomBoolean(),
                public void onFailure(final Exception e) {
        AtomicBoolean armed = new AtomicBoolean(false);
            null,  
        // the two threads synchronize attempting to acquire an operation permit
             */  
 * SPDX-License-Identifier: Apache-2.0
            replica.getRetentionLeaseSyncer(),
        // check time advances
            true,  
        final int replayedOps;
                ShardRoutingState.STARTED,
        Set<String> docsBelowGlobalCheckpoint = getShardDocUIDs(indexShard).stream()
                    + "] is no longer part of the replication group"
        Thread thread = new Thread(() -> {  
        recoveryEmptyReplica(indexShard, randomBoolean());
                    mappingVersion,
            RecoverySource.ExistingStoreRecoverySource.INSTANCE  
import java.util.concurrent.TimeUnit;
        closeShards(indexShard);
                assertThat(e, instanceOf(RuntimeException.class));
            thread.start();
            .remoteStore()
        IndexShard target = newStartedShard(true);
                        postIndex(shardId, index, result.getFailure());  
        );
        ShardStateMetadata shardStateMetadata = load(logger, shardStatePath);
            expectThrows(AlreadyClosedException.class, () -> indexShard.seqNoStats());
        final AtomicBoolean synced = new AtomicBoolean();
            ""
     * This test simulates a scenario seen rarely in ConcurrentSeqNoVersioningIT. While engine is inside
        int totalOps = randomInt(10);
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(primaryTerm));
            final long newGlobalCheckpoint = indexShard.getLocalCheckpoint();
                    n -> new Translog.Index(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.snapshots.Snapshot;
    }  
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
        assertThat(thirdForceMergeUUID, notNullValue());
                try {  
        // this test indexes docs on a primary, refreshes,
            indexShard.getRetentionLeaseSyncer(),  
    }  
                .getTrackedLocalCheckpointForShard(newShard.routingEntry().allocationId().getId())
            }
            shardRouting,  
            try {
        final long newMaxSeqNoOfUpdates = randomLongBetween(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), Long.MAX_VALUE);
                max = i;  
        closeShards(primary, replica);  
        assertDocs(replica, "1", "2");
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), interval)
        // move to unassigned while the replica is active, then reinit from existing store.
    public void testShardDoesNotStartIfCorruptedMarkerIsPresentSearch() throws Exception {
                }
            0,  
        int totalOps = randomInt(10);
            while (stop.get() == false) {
        Map<String, MappingMetadata> requestedMappingUpdates = ConcurrentCollections.newConcurrentMap();
        final ShardRouting replicaRouting = indexShard.routingEntry();  
        });  
        closeShards(newShard);  
        final long maxSeqNo = indexShard.seqNoStats().getMaxSeqNo();  
        assertEquals(1, preDelete.get());
         * - If flush and then recover from the existing store, delete #1 will be removed while index #0 is still retained and replayed.
            newMaxSeqNoOfUpdates,
            targetShard.recoverFromLocalShards(mappingConsumer, Arrays.asList(sourceShard), future);  
            // it's not called when store is marked as corrupted  
        indexShard.acquireAllPrimaryOperationsPermits(futureAllPermits, TimeValue.timeValueSeconds(30L));
            final int operations = scaledRandomIntBetween(5, 32);  
            allocationId = randomBoolean() ? null : randomAllocationId();
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
        AtomicBoolean synced = new AtomicBoolean();
        assertThat(target.seqNoStats().getGlobalCheckpoint(), equalTo(0L));
        indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED));
    public void testRestoreSearchOnlyShardFromStoreOnNewNode() throws IOException {  
            threadPool
            Engine.GetResult ignored = shard.get(new Engine.Get(true, false, "test", new Term(IdFieldMapper.NAME, Uid.encodeId("test"))))  
        Settings segRepSettings = Settings.builder()
     * Verifies {@code waitForReplicaSync} returns immediately when replicas are already in sync.
        try {
        assertThat(relocated.get(), equalTo(false));
        assertTrue(recoverFromStore(newShard));
                exceptionToThrow.set(() -> new IOException("Test IOException"));  
            if (randomBoolean()) {
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
            .filter(id -> Long.parseLong(id) <= globalCheckpoint)
        indexDoc(source, "_doc", "4");
            public Set<String> getPendingDeletions() throws IOException {  
        );  
            assertEquals(2, indexShard.getActiveOperationsCount());  
                seqNo,
/*
        Settings settings = Settings.builder()
            shardRouting,  
        assertDocCount(newShard, 3);
        int iters = iterations(10, 100);
        assertDocs(target, "0", "2");
    }  
    }
                        latch.await();
            indexShard.acquireAllReplicaOperationsPermits(opPrimaryTerm, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, listener, timeout);  
    }
            @Override  
            Settings.EMPTY  
        assert !gap || (localCheckpoint != max);
        );  
                        assertListenerCalled.accept(replica);  
            Settings.builder().put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), resyncTimeout).build(),
                } else {
     */  
            expectThrows(IllegalArgumentException.class, () -> {
                    corruptedMarkerCount.incrementAndGet();
                    .getLocalCheckpoint(),
            indexShard.acquireAllPrimaryOperationsPermits(new ActionListener<Releasable>() {
     * {@code newEngineReference} is still null -- the window between ReadOnlyEngine installation
        });  
            .settings(newSettings)
import org.opensearch.index.mapper.ParseContext;  
        IndexShard indexShard = null;
                    : ShardStateMetadata.IndexDataLocation.LOCAL  
            .build();
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")  
        indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED));
        assertEquals(TimeValue.timeValueSeconds(30), flushTask.getInterval());  
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
        Settings segRepSettings = Settings.builder()
        closeShards(shard);  
        );
                                lease -> new RetentionLease(
            assertTrue(xContent.contains(expectedSubSequence));  
        try {
import org.opensearch.cluster.metadata.MappingMetadata;
        final long globalCheckpoint = randomLongBetween(shard.getLastKnownGlobalCheckpoint(), shard.getLocalCheckpoint());  
            final long maxSeqNoOfUpdatesOrDeletes = replica.getMaxSeqNoOfUpdatesOrDeletes();
        final IndexShard shard = newStartedShard(true);
        }
import java.nio.file.FileVisitResult;
        for (int i = 0; i < numTotalEntries; i++) {
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            indexShard.acquireReplicaOperationPermit(
                    assertThat(e, instanceOf(ShardNotInPrimaryModeException.class));  
                assertThat(indexShard.getOperationPrimaryTerm(), equalTo(newPrimaryTerm));  
            indexMetadata,
     * Verifies that the ReadOnlyEngine delegates throw {@link AlreadyClosedException} when
            replicaRouting.currentNodeId(),
        // After refresh, remote sync should have completed and catalog snapshot files should match remote  
        assertNotNull(primary.getPeriodicFlushTask());
            EMPTY_EVENT_LISTENER,
            assertThat(indexShard.getActiveOperationsCount(), equalTo(0));
import org.apache.lucene.store.AlreadyClosedException;
        stats.writeTo(out);
            }
            true,
        final ForceMergeRequest secondForceMergeRequest = new ForceMergeRequest().maxNumSegments(1);
                }
                    onResponse.set(true);
                        postDelete.incrementAndGet();
                snapshot,
                replicaRouting.allocationId()  
                }  
                final String expectedThreadPoolName = executorOnDelay.equals(ThreadPool.Names.SAME)
                IntStream.range(0, Math.toIntExact(numDocs)).boxed().collect(Collectors.toList())
                throw new AssertionError(e);
            .build();
        recoverShardFromStore(replica);
            shard.updateGlobalCheckpointOnReplica(3, "test");
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
import org.opensearch.action.admin.indices.flush.FlushRequest;
                        "every operations before the global checkpoint must be reserved",
        }
        Settings settings = Settings.builder()  
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());  
import java.io.IOException;  
                .getTrackedLocalCheckpointForShard(target.routingEntry().allocationId().getId())
        closeShards(indexShard);
        ShardRouting targetRouting = newShardRouting(
            if (randomBoolean()) {
        primary.awaitShardSearchActive(refreshed -> {
            shard.getEngineConfigFactory(),
     * catalog API) rather than the legacy {@code getSegmentInfosSnapshot()}. After indexing and refreshing,
        final ActionListener<Releasable> listener,
            if (ExtrasFS.isExtra(file)) {
        final ShardRouting originalRouting = shard.routingEntry();
            closeShards(replica);
            null  
            );
        assertNotNull(restarted);
        testRestoreShardFromRemoteStore(true);
        } finally {
            ShardRoutingState.RELOCATING,
                indexShard.refresh("test");
        indexShard.flush(new FlushRequest());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }  
        assertEquals(remoteSegmentTransferTracker.getUploadBytesStarted(), remoteSegmentStats.getUploadBytesStarted());
                    cleanLuceneIndex(targetStore.directory());
                ""
                false,  
            Settings.builder()
        final IndexShard shard = newStartedShard(true);
            0L,
            null,
                    public void onResponse(Releasable releasable) {
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(  
            .build();  
            store.markStoreCorrupted(new IOException(corruptionMessage));
            UUID.randomUUID().toString(),  
        for (String file : storeDirectory.listAll()) {
                try {
        );
import java.util.Set;  
            newShard.markAsRecovering(
                @Override
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
            operation2 = null;
        closeShards(primary, replica);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
 * Unless required by applicable law or agreed to in writing,
        final IndexShard indexShard = newStartedShard(false);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            // entries with corrupted source
            .settings(settings)  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final List<Runnable> assertions = new ArrayList<>(numberOfAcquisitions);  
                        listener,
    }
                    assertThat(storeFileMetadatas.recoveryDiff(readMeta).missing.size(), equalTo(0));
    }
                final long maxSeenAutoIdTimestamp,
            true,  
                    assertEquals(file.recovered(), file.length());  
            AssertionError e = expectThrows(AssertionError.class, () -> replica.onMergesDrained(() -> {}));
        // 10s is the shortest timeout the setting accepts.
                    indexShard.acquirePrimaryOperationPermit(permitAcquiredFuture, ThreadPool.Names.SAME, "bla");  
        assertFalse(  
                return FileVisitResult.CONTINUE;  
            {
                    .field("count", randomInt())
    }  
            flushShard(shard);
import static org.hamcrest.Matchers.hasKey;  
            IllegalIndexShardStateException.class,  
                ThreadPool.Names.MANAGEMENT,  
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        );
        return new PrimaryReplicaSyncer.ResyncTask(0, "type", "action", "description", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
                indexShard.acquireReplicaOperationPermit(
                    assertThat(e, hasToString(containsString("shard is not in primary mode")));
        final long maxSeqNoOfUpdatesOrDeletes,  
            storeDirectory.deleteFile(file);  
        int localCheckpoint = offset;
            shard.indexSettings,
            ActionListener.wrap(r -> {
        }
            } catch (InterruptedException | IOException e) {
                final RetentionLeases retentionLeases = indexShard.getRetentionLeases();  
            assertNotNull(getResult.searcher()); // make sure get uses the wrapped reader  
        );
                creatingEngineLatch.countDown();
            @Override
                        TimeValue.timeValueMinutes(30L)  
    public void testReaderWrapperWorksWithGlobalOrdinals() throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            shard.flush(new FlushRequest().force(true).waitIfOngoing(true));  
            indexShard = newStartedShard(
    }  
        CountDownLatch readyToCloseLatch = new CountDownLatch(1);
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
            .primaryTerm(replicaRouting.shardId().id(), shard.getOperationPrimaryTerm() + 1)
import org.opensearch.test.DummyShardLock;
        final IndexShard shard = newStartedShard(false, Settings.EMPTY, new EngineBackedIndexerFactory(new InternalEngineFactory()));
            assertion.run();  
        shard.writeIndexingBuffer();  
            when(behindStat.getCheckpointsBehindCount()).thenReturn(0L);  
            long prevAccessTime = shard.getLastSearcherAccess();
                onLockAcquired = new PlainActionFuture<Releasable>() {
            assertThat("Without flushing, segment sizes should be zero", indexShard.docStats().getTotalSizeInBytes(), equalTo(0L));  
                    newShard.routingEntry(),
            shard.indexSettings().getIndexMetadata(),  
            () -> synced.set(true),
                expectedLocalCheckpoint = SequenceNumbers.NO_OPS_PERFORMED;
        tracker.addUploadBytesStarted(30L);  
/*
     */
        }  
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        // initialize the local knowledge on the primary of the persisted global checkpoint on the replica shard
            meta,
                    ActionListener.wrap(checkpoint -> {
        );  
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test1")  
        }
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            CountDownLatch latch = new CountDownLatch(1);  
        // Shard is still inactive since we haven't started recovering yet  
                throw new AssertionError(e);
                        1,  
 * You may obtain a copy of the License at  
                ThreadPool.Names.FLUSH,
    }  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            }
        for (long i = 0; i < numDocs; i++) {
            EMPTY_EVENT_LISTENER,
                        assertTrue(replica.isActive());
        final IndexShard replicaShard = newStartedShard(
        recoverShardFromStore(shard);  
        assertThat(exception1.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));  
        IndexShard shard = newStartedShard(true);
        closeShard(primaryShard, false);  
                    @Override  
        replica.updateShardState(primaryRouting, replica.getPendingPrimaryTerm() + 1, (shard, resyncListener) -> {  
import org.opensearch.OpenSearchException;  
        final Settings settings = Settings.builder()
            indexShard = newStartedShard(false);
                    newShard.routingEntry(),
                }
            logger.debug("shard relocation was cancelled");
        Store store = shard.store();
        closeShards(sourceShard, targetShard);
                }
        RemoteSegmentTransferTracker remoteSegmentTransferTracker,
                        onFailure.set(e);
        resyncDispatched.await();  
    public void testRecoverFromStoreRemoveStaleOperations() throws Exception {  
        assertEquals(2, preIndex.get());  
        assertTrue(semaphore.tryAcquire(Integer.MAX_VALUE, 10, TimeUnit.SECONDS));  
        routing = TestShardRouting.relocate(shard.shardRouting, "some node", 42L);
        if (engineClosed == false) {
            new SourceToParse(indexName, "doc-2", new BytesArray("{}"), MediaTypeRegistry.JSON)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        IndexShard primary = newStartedShard(true, segRepSettings);  
            @Override  
            // Need to update and sync the global checkpoint and the retention leases for the soft-deletes retention MergePolicy.  
            for (ReplicationLuceneIndex.FileMetadata file : recoveryState.getIndex().fileDetails()) {
        assertEquals(0, indexShard.getActiveOperationsCount());
        final ShardRouting toNode2 = ShardRoutingHelper.relocate(original, "node_2");
import java.util.function.Consumer;
        assertListenerCalled.accept(replica);
        }  
     * a recovery and concurrently clean files. This should always be possible without any exception. Yet there was a bug where IndexShard
            }
import org.opensearch.index.seqno.SequenceNumbers;  
    /**
        doc = indexDoc(primary, "_doc", "2", "{\"foo\" : \"bar\"}");
                        }
            shard.getOperationPrimaryTerm(),  
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
        Files.walkFileTree(indexPath, corruptedVisitor);  
        tracker.incrementTotalUploadsStarted();  
            settings,  
import org.apache.lucene.search.TermQuery;
                    readyToSnapshotLatch.countDown();
            .build();
        // try to start shard on corrupted files
        final long globalCheckpoint = randomLongBetween(shard.getLastKnownGlobalCheckpoint(), shard.getLocalCheckpoint());
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(0, indexingStats.getTotal().getDeleteCount());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(2, preIndex.get());
        final Thread thread = new Thread(() -> {
        allowShardFailures();  
        settings = Settings.builder().put(settings).put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO).build();  
                        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "tlog-repo")  
            }
            .settings(settings)
            EMPTY_EVENT_LISTENER,  
        final String corruptionMessage = "fake ioexception";
                        new ActionListener<Releasable>() {
        assertThat(exception1.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
        indexDoc(indexShard, "_doc", "0");  
                    throw new AssertionError();
                }
        );
                assertThat(docsStats.getDeleted(), equalTo(0L));
            UUID.randomUUID().toString(),
            .build();
            assertTrue(future.actionGet());
            assertTrue(invoked.get());
            ShardRoutingState.INITIALIZING,
                long prevAccessTime = shard.getLastSearcherAccess();
        });
                } catch (IOException e) {
                    randomReplicaOperationPermitAcquisition(  
                throw new RuntimeException(e);  
    public void testPublishingOrderOnPromotion() throws IOException, InterruptedException, BrokenBarrierException {
        closeShards(primary);
                    assertThat(e, instanceOf(ShardNotInPrimaryModeException.class));
            final int threadId = i;
        );  
                break;  
            EMPTY_EVENT_LISTENER,
        final IndexShard newShard = reinitShard(indexShard);  
        // create corrupted marker
            after = shard.fieldData().stats("foo");
                        for (int i = 0; i < 10000; i++) {  
        thread.start();
            assertTrue(getResult.exists());
            .build();  
        newShard.refresh("test");  
                    "Estimated total document size is too large compared with the stored size",  
import static org.mockito.Mockito.doReturn;  
                    : executorOnDelay.toLowerCase(Locale.ROOT);  
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())  
            flushRequest.waitIfOngoing(false);
            () -> newStartedShard(p -> corruptedShard2, true)  
        final IndexShard replica = newStartedShard(false);
        assertEquals(0, newShard.recoveryState().getTranslog().totalOperationsOnStart());
                );
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
            .primaryTerm(0, 1)
    }
            final AtomicBoolean onFailure = new AtomicBoolean();
                public void run() {
        String id = randomRealisticUnicodeOfLengthBetween(1, 10);  
        recoverReplica(replica, primary, (shard, discoveryNode) -> new RecoveryTarget(shard, discoveryNode, recoveryListener, threadPool) {
        // Once the engine is created during recovery, the task starts with the configured interval.
                final ActionListener<Long> listener
        thread.join();  
            });
        IndexShard shard = newStartedShard(false);  
        // ensure that after the local checkpoint throw back and indexing again, the local checkpoint advances  
    /* This test just verifies that we fill up local checkpoint up to max seen seqID on primary recovery */
    public void testRecoverFromLocalShard() throws IOException {  
        final IndexSettings docrepIndex = new IndexSettings(
        final IndexShard indexShard = newStartedShard(true);  
        closeShards(shard);
            true,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            null,
     */  
                    releasable.close();
        );  
     * reports 0 active and {@code false} pending — the same outcome, but derived from the live state.
                    throw new RuntimeException(e);  
            indexShard.runUnderPrimaryPermit(() -> { throw new RuntimeException("failure"); }, e -> {  
        for (int i = 0; i <= maxSeqNo; i++) {
     */  
        Thread recoveryThread = new Thread(() -> {
            new EngineBackedIndexerFactory(config -> new InternalEngine(config, new TranslogEventListener() {
            indexShard.runUnderPrimaryPermit(() -> {  
                engineClosed = false;  
        tracker.incrementTotalUploadsFailed();  
                .build()
import org.opensearch.index.SegmentReplicationShardStats;
            replica.getOperationPrimaryTerm(),  
                VersionFieldMapper.NAME,
            relocated.set(true);
                SeqNoFieldMapper.NAME,  
import static org.mockito.Mockito.mock;
        final Set<String> docsBeforeRollback = getShardDocUIDs(indexShard);  
import org.opensearch.cluster.routing.AllocationId;  
            recoverShardFromStore(differentIndex);  
                                    newGlobalCheckpoint + 1,
    public void testReadSnapshotAndCheckIndexConcurrently() throws Exception {  
                Supplier<IOException> ex = exceptionToThrow.get();  
        // add a replica  
            assertDocCount(targetShard, 2);
        ShardRouting searchReplicaShardRouting = TestShardRouting.newShardRouting(
    }  
        final AtomicLong counter = new AtomicLong();
        final AtomicArray<Tuple<Boolean, Exception>> results = new AtomicArray<>(threads.length);
                ""
                    default:  
            indexShard.engineConfigFactory,
                    Store.MetadataSnapshot readMeta = newShard.snapshotStoreMetadata();
    }
            closeShards(shard);
        }
                indexShard.refresh("test");  
                    @Override
                .threadPool(config.getThreadPool())
        try (Store store = createStore(shardId, new IndexSettings(metadata, Settings.EMPTY), directory, shardPath)) {
                        snapshotDoneLatch.await();  
            IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.DOCREP_NON_MIGRATING)
        final long newPrimaryTerm = indexShard.getPendingPrimaryTerm() + between(1, 10000);
            IOException ex = expectThrows(IOException.class, () -> spyShard.waitForReplicaSync(TimeValue.timeValueMillis(600)));
        target.markAsRecovering("store", new RecoveryState(routing, localNode, null));  
        assertNotNull("task should start once an engine is available", flushTask);
                .analyzer(config.getAnalyzer())  
            },
            isPrimaryMode = false;
        assertRemoteTranslogStats(remoteTranslogTransferTracker, remoteTranslogStats);  
                numCorruptEntries++;  
            }
            shard.updateLocalCheckpointForShard(shard.shardRouting.allocationId().getId(), totalOps - 1);
            .build();
                public void onResponse(Releasable releasable) {  
                    config.getWarmer().warm(reader);
            newShard.acquireSearcher("test");
            }  
        assertTrue("at least 2 files, commit and data: " + storeFileMetadatas.toString(), storeFileMetadatas.size() > 1);  
            SegmentInfos segmentInfos = segmentInfosGatedCloseable.get();
        closeShard(indexShard, false);  
    public void testNoDeadlockOnCloseWhileRecoveringTranslog() throws Exception {  
            if (corruptIndexException && !throwWhenMarkingStoreCorrupted.get()) {
        );
            }  
        // Capture the resync listener during promotion but fail it only afterwards: the real onFailure path fails the shard,
        for (int i = 0; i < thread.length; i++) {
import org.opensearch.common.collect.Tuple;  
            1,
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
        Directory remoteDirectory = ((FilterDirectory) ((FilterDirectory) target.remoteStore().directory()).getDelegate()).getDelegate();
                }
        // The same task is kept and rescheduled with the new interval.  
            indexShard.getGlobalCheckpointSyncer(),
        closeShards(shard);  
                assertNull(requestedMappingUpdates.put(MapperService.SINGLE_MAPPING_NAME, mapping));
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
        assertThat(secondForceMergeUUID, notNullValue());  
    public void testIndexingOperationsListeners() throws IOException {  
    }
        final ShardRouting primaryRouting = promoteReplicaWithPendingResync(indexShard);  
    }  
        }  
        if (Constants.WINDOWS) {  
import org.opensearch.core.tasks.TaskId;
    private static PrimaryReplicaSyncer.ResyncTask newResyncTask() {  
            return new ShardStateMetadata(shardRouting.primary(), shard.indexSettings().getUUID(), shardRouting.allocationId());
        };  
                        .collect(Collectors.toList());
        recoverShardFromStore(test);
            .retentionLeaseStats(shard.getRetentionLeaseStats())  
            .build();
        primaryShard.updateLocalCheckpointForShard(shardRouting.allocationId().getId(), checkpoint);
        IndexShard corruptedShard = newShard(
                replicaRouting.currentNodeId(),
            IndexMetadata.builder("remote")  
            "a docrep shard has no remote translog",
        shardStateMetadata = load(logger, shardStatePath);
        final ShardRouting replicaRouting = shard.routingEntry();
                .build(),
        shard.close("simon says", true, false);
        cleanLuceneIndex(store.directory());
                    @Override  
            null
    }
            null
            }
        );
        closeShards(shard);
        assertDocs(primary, "1", "2");  
        IndexFieldData.Global ifd = indexFieldDataService.getForField(foo, "test", () -> {
import java.util.HashSet;
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
        final SimpleFileVisitor<Path> corruptedVisitor = new SimpleFileVisitor<>() {
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());  
        ShardRouting routing = ShardRoutingHelper.initWithSameId(
            new EngineBackedIndexerFactory(new InternalEngineFactory())  
    public void testOnCloseStats() throws IOException {
            assertThat(ex.getMessage(), containsString("replicas failed to sync within"));
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
            );  
        );
            .primaryTerm(0, 1)  
        final IndexShard indexShard = newShard(false);
    }
        assertThat(
            }
        // engineMutex is held -- this is the code path that deadlocks in production.
        };  
        }
        IndexMetadata metadata = IndexMetadata.builder("test")
            } else {
            indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
    }  
        expectThrows(IndexShardClosedException.class, () -> indexShard.acquirePrimaryOperationPermit(null, ThreadPool.Names.WRITE, ""));  
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);  
        assertEquals(0, postDeleteException.get());
        final String corruptionMessage = "fake ioexception";
        expectedSubSequence.append("\",\"data_path\":\"");  
    }
        }
        target.markAsRecovering("from snapshot", new RecoveryState(routing, localNode, null));
                true,
                SeqNoFieldMapper.TOMBSTONE_NAME,  
import org.opensearch.test.CorruptionUtils;
        tracker.addUploadBytesFailed(randomIntBetween(1, bytesStarted / 2));
        }
            .build();
        primary.refresh("test");
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.REMOTE_MIGRATING_UNSEEDED)
import org.opensearch.env.NodeEnvironment;  
        // reset our boolean so that we can assert after another simulated maybe sync  
        final IndexShard primaryShard = newStartedShard(  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testRecoverFromStoreWithOutOfOrderDelete() throws IOException {  
            while (stop.get() == false) {
     * {@link IndexShard#acquireAllReplicaOperationsPermits(long, long, long, ActionListener, TimeValue)} in order to acquire a permit.  
import org.opensearch.index.mapper.SeqNoFieldMapper;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            } finally {  
                Releasables.close(operation1);  
                    routing.getTargetRelocatingShard().allocationId().getId(),  
                engineResetLatch.countDown();
    private Result indexOnReplicaWithGaps(final IndexShard indexShard, final int operations, final int offset) throws IOException {
            .commitStats(shard.commitStats())
        // try to serialize it to ensure values survive the serialization
import org.apache.lucene.util.Constants;
                assertThat(threadPool.relativeTimeInMillis(), greaterThan(shard.getLastSearcherAccess()));  
        );
        }
        );
        );  
            shardId,
            indexShard.engineConfigFactory,
                    latch.countDown();  
            // Do some updates and deletes, then recheck the correlation again.  
            shardId,  
    public void testPeriodicFlushTaskStartedOnDynamicEnable() throws Exception {
        long initialTotalTime = shard.refreshStats().getTotalTimeInMillis();
        final IndexShard primaryShard = newShard(  
            warmerStarted.await();
                shard.snapshotStoreMetadata();  
                    assertEquals(0, storeFileMetadatas.recoveryDiff(readMeta).missing.size());  
                throw new ReplicationFailedException("Segment replication failed");
                try (Engine.Searcher searcher = indexShard.acquireSearcher("test")) {
        assertEquals(0, storeDirectory.listAll().length);  
            indexShard.engineConfigFactory,  
import org.opensearch.index.seqno.RetentionLeaseSyncer;  
                    assertEquals(2, searcher.getIndexReader().numDocs());
                .build(),  
 * this work for additional information regarding copyright
            1,  
                randomFrom(ShardStateMetadata.IndexDataLocation.values())
        // start search replica
         * - index #0
        indexDoc(source, "_doc", "1");
                public void onFailure(Exception e) {  
                try (Releasable dummy = r) {
        recoverReplica(replica, primary, (shard, discoveryNode) -> new RecoveryTarget(shard, discoveryNode, recoveryListener, threadPool) {
                // corrupt entry  
        // and the new InternalEngine, then paused before translog replay.
        );  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.xcontent.XContentFactory;
                ThreadPool.Names.SAME
                        releasable.close();  
        IndexShard newShard = reinitShard(
                    new Translog.Index(
        final long numDocs = between(10, 100);  
            final AtomicReference<Exception> onFailure = new AtomicReference<>();
        recoverShardFromStore(sourceShard);
            RecoverySource.ExistingStoreRecoverySource.INSTANCE  
            // Windows has buggy File delete logic where AccessDeniedExceptions
            newShard.markAsRecovering("store", new RecoveryState(routing, localNode, null));  
                        1,
                AssertionError.class,
            assertThat(
            shardRouting,
            indexShard.routingEntry(),
            containsInAnyOrder(  
            indexMetadata.build(),
        indexDoc(target, "_doc", "2");
        assertThat(shard.seqNoStats().getMaxSeqNo(), equalTo(globalCheckpoint));
                }
        expectThrows(
        closeShard(shard, false);
        Settings settings = Settings.builder()
                }  
            assertThat(targetShard.getReplicationTracker().getGlobalCheckpoint(), equalTo(1L));
        try (Engine.Searcher searcher = primary.acquireSearcher("test")) {  
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
        assertEquals(remoteTranslogTransferTracker.getUploadBytesStarted(), remoteTranslogStats.getUploadBytesStarted());
    public void testDelegateThrowsAlreadyClosedBeforeNewEngineSet() throws Exception {
        assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));  
            .settings(settings)
            indexMetadata,
        settings = Settings.builder()
                    releasable.close();
        final IndexShard corruptedShard2 = newShard(
        }
        assertEquals(0, postIndexException.get());  
            }, e -> { throw new AssertionError(e); }),  
        final IndexShard corruptedShard2 = newShard(
}  
        }
        allowShardFailures();
    public void testRestoreSearchOnlyShardFromStore() throws IOException {
        shard.refresh("test");  
        expectThrows(AssertionError.class, () -> primaryShard.getHistoryOperationsFromTranslog(0, 1));
            .settings(settings)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                Math.toIntExact(numDocsToDelete),
        final boolean engineClosed;
        Store sourceStore = source.store();
            flushRequest.force(false);
        // promote the replica
     */
            {
            @Override
                    try {
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1);
        shard.updateGlobalCheckpointOnReplica(0, "test"); // stick the global checkpoint here.
        assertFalse(flushTask.isClosed());
            ifd.loadGlobal(searcher.getDirectoryReader());  
    }
        try {
import static org.hamcrest.Matchers.either;
        assertEquals(threads.length, results.asList().size());
        assertThat(requestedMappingUpdates, hasKey("_doc"));
        } catch (IndexShardRelocatedException expected) {}
            0,
                newShard,  
            }  
                .build(),
        );
        );
            randomFrom(ShardStateMetadata.IndexDataLocation.values())
import java.util.concurrent.CyclicBarrier;
    public void testGlobalCheckpointSync() throws IOException {
    /**
        assertFalse(indexShard.isPrimaryReplicaResyncInProgress());
            null,
                    assertThat(  
                            .map(
        final IllegalStateException error = expectThrows(
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
            indexShard.getRetentionLeaseSyncer(),
        // start a replica shard and index the second doc
                }
    }
                operations.add(  
    }
        });
            // Use a very short timeout so the test doesn't take 30s  
    public void testEstimateTotalDocSize() throws Exception {
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
     * resetEngineToGlobalCheckpoint can lead to check index failure in integration tests.
import java.util.function.LongFunction;  
        assertThat(exception2.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
            Settings.builder()
            assertThat(onFailureException.get(), instanceOf(IllegalStateException.class));
        if (shardRouting == null) {
        closeShardThread.join();  
        /*
        IndexShard replicaCorrupted = newShard(
            final long newPrimaryTerm = primaryTerm + 1 + randomInt(20);  
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,  
                );
        closeShards(newShard);
                .internalRefreshListener(config.getInternalRefreshListener())  
            @Override
            }  
            assertEquals(0, indexShard.getActiveOperationsCount());  
        return ShardStateMetadata.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, shardPaths);
                    @Override
            assertThat(shard.refreshStats().getExternalTotal(), equalTo(2L + i));
import org.opensearch.index.remote.RemoteSegmentStats;
        second.start();
        final long initialRefreshes = shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false ? 2L : 3L;
     * When the primary-replica resync completes successfully, its onResponse must clear the in-progress flag so the promoted
                } catch (final InterruptedException e) {
                } catch (AlreadyClosedException ignored) {
                ShardRoutingState.INITIALIZING,  
        latch.await();  
                assertTrue(storeDirectory.getPendingDeletions().contains(file));
        });  
                // relocation source  
            .primaryTerm(0, 1)
                    throw new AssertionError();
            null
        closeShards(primarySource, primaryTarget);
            }
                    mappingVersion,
            null
        assertEquals(2, preIndex.get());  
        final Thread first = new Thread(function.apply(firstIncrement));
                    armed.set(true);  
            while (stop.get() == false) {
        deleteDoc(shard, "1");
                    engineResetLatch.countDown();
            this.maxSeqNo = maxSeqNo;  
        closeShard(indexShard, false);  
                shardPath.resolveIndex(),  
        closeShard(replica, false);
        closeShards(shard);  
        final ShardRouting primaryShardRouting = shard.routingEntry();  
                    1,
            IndexShard spyShard = spy(shard);
                if (indexShard.routingEntry().primary()) {  
                    ActionListener.wrap(r -> {
            .primaryTerm(0, 1)
        closeShards(replicaCorrupted);  
            false,
        });
                newGlobalCheckPoint = SequenceNumbers.NO_OPS_PERFORMED;
            try {  
        ParsedDocument deleteTombstone = shard.getIndexer().config().getTombstoneDocSupplier().newDeleteTombstoneDoc(id);
            primaryTerm,
                final DocsStats docsStats = indexShard.docStats();
            Settings.EMPTY
                TimeValue.timeValueSeconds(30L)
        closeShards(indexShard);
        assertEquals(0, postIndexException.get());
import java.util.stream.IntStream;  
                    }  
        for (long i = 0; i < numDocs; i++) {
                    try (Releasable ignored = permitAcquiredFuture.actionGet()) {
 * compatible open source license.
        } finally {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        Semaphore semaphore = new Semaphore(Integer.MAX_VALUE);
                ThreadPool threadPool = shard.getThreadPool();
                final DocsStats docsStats = indexShard.docStats();
        synchronized (engineMutex) {
                        finish();  
                }  
        expectThrows(
            indexShard.getRetentionLeaseSyncer(),
                indexShard = newShard(routing);
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {  
        final ShardRouting relocationRouting = ShardRoutingHelper.relocate(originalRouting, "other_node");
         */
        // The engine was intentionally failed, so skip the translog/Lucene consistency assertion on close.
        final int operations = 1024 - scaledRandomIntBetween(0, 1024);  
            .build();  
            new SourceToParse(shard.shardId().getIndexName(), "id", new BytesArray("{}"), MediaTypeRegistry.JSON)  
        randomReplicaOperationPermitAcquisition(
    public void testSnapshotStore() throws IOException {
        IndexShard shard = newStartedShard(
        FieldDataStats before = shard.fieldData().stats("foo");
            }
        assertTrue(flushTask.isClosed());  
                () -> indexShard.acquireAllPrimaryOperationsPermits(null, TimeValue.timeValueSeconds(30L))  
     * After the typed-method conversion, non-DFA engines no longer return a hardcoded 0; they read
        final CyclicBarrier barrier = new CyclicBarrier(2);  
        thread.start();
        );
        primary.refresh("test");
            new SourceToParse(indexName, "doc-1", new BytesArray("{}"), MediaTypeRegistry.JSON)
        assertBusy(() -> assertTrue(primary.isSearchIdle()));
            };
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));  
        if (randomBoolean()) {
                    .getTrackedLocalCheckpointForShard(targetShard.routingEntry().allocationId().getId())  
            assertThat("current routing:" + shard.routingEntry(), shard.routingEntry().relocating(), equalTo(false));  
            ShardRoutingState.STARTED,
                    .startObject()  
 * GitHub history for details.
        try {  
        // simulate that the background sync advanced the global checkpoint on the replica  
import org.opensearch.index.translog.listener.TranslogEventListener;
            assertEquals(shardStateMetadata, state1);
                        () -> shard.runTranslogRecovery(shard.getIndexer(), snapshot, Engine.Operation.Origin.LOCAL_RESET, () -> {})  
        relocationThread.start();
        indexDoc(shard, "_doc", "1", "{\"foobar\" : \"bar\"}");
     * resetEngineToGlobalCheckpoint snapshot metadata could fail
        assertEquals(TimeValue.timeValueMinutes(2), restarted.getInterval());
            doReturn(Set.of(behindStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
    }
            closeShards(indexShard);
        }
                        }  
        // Setting is enabled at creation, but the shard has no engine yet. A settings change in this
                    shard.resetEngineToGlobalCheckpoint();
            null,  
            null  
                        null,
    }
        final List<Thread> threads = new ArrayList<>();
                        listener.onResponse(r);
        Thread cancellingThread = new Thread(new AbstractRunnable() {  
        ) {
        assertFalse(flushTask.isScheduled());
        }
                try (Releasable ignored = r) {
            .primaryTerm(0, 1)
        assertDocCount(primaryTarget, totalOps);
            IndexShardTestUtils.getFakeDiscoveryNodes(primaryRouting)
     * This test makes sure that people can use the shard routing entry + take an operation permit to check whether a shard was already
        assertTrue(flushTask.isScheduled());
                true,
            .build();
        IndexShard shard = newStartedShard();  
 * not use this file except in compliance with the License.
        Object engineMutex = shard.getEngineMutex();
                }
    public void testPeriodicFlushTaskRescheduledOnIntervalChange() throws Exception {  
                    case SUCCESS:
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            spyShard.waitForReplicaSync(TimeValue.timeValueSeconds(10));  
        assertTrue(remoteSegmentStats.getTotalRejections() > 0);
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");  
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
import java.util.concurrent.atomic.AtomicReference;
                if (singlePermit) {  
        Settings settings = Settings.builder()
                assertThat(docStats.getCount(), equalTo(numDocs));
                return FileVisitResult.CONTINUE;
        assertThat(noopDoc.getField(SeqNoFieldMapper.TOMBSTONE_NAME).numericValue().longValue(), equalTo(1L));  
        IndexShard newShard = newShard(  
            IntStream.range(0, randomIntBetween(1, 10))  
            IndexShard shard = newShard(  
        final int nbTermUpdates = randomIntBetween(1, 5);
            .build();
        // ensure we are not influencing the indexing stats  
        }
                    maxSeqNoOfUpdatesOrDeletes,
    public void testOperationPermitsOnPrimaryShards() throws Exception {
        shard.close("Unexpected close", true, false);
        recoverShardFromStore(primary);  
            RetentionLeaseSyncer.EMPTY,  
        assertTrue(indexResult.isCreated());
            equalTo(2L)
        } finally {
     * engine. Tiering targets DFA-format indices only; calling this wrapper on a Lucene shard is a  
        indexShard.updateGlobalCheckpointOnReplica(globalCheckpointOnReplica, "test");
                    public void onResponse(Releasable releasable) {
        assertEquals(remoteTranslogTransferTracker.getTotalUploadsFailed(), remoteTranslogStats.getTotalUploadsFailed());
                indexShard.getPendingPrimaryTerm(),
        closeShards(indexShard);  
        // deletion of segment files in the subsequent code block.
            (shard, resyncListener) -> resyncListener.onResponse(newResyncTask())
                            @Override
            new ActionListener<Releasable>() {
        assertFalse(primary.getIndexer().refreshNeeded());  
            @Override
            @Override  
            .settings(settings)  
                @Override
        primary.flushOnIdle(0);
        IndexingOperationListener listener = new IndexingOperationListener() {  
     * If the primary-replica resync never completes, the resync timeout clears the in-progress flag so the promoted primary can  
        }, true, true);
    public void testOnMergesDrained_OnReplica_TripsPrimaryAssertion() throws IOException {
                indexShard.refresh("test");
                if (armed.compareAndSet(true, false)) {
            });
        assertEquals(getEngine(replicaShard).getClass(), NRTReplicationEngine.class);  
            AtomicBoolean called = new AtomicBoolean();  
                }  
         * - delete #1  
                latch.countDown();  
        indexShard.addShardFailureCallback(ig -> shardFailed.set(true));  
        // create corrupted marker
        try (Engine.Searcher searcher = newShard.acquireSearcher("test")) {
            closeShards(indexShard);  
                IdFieldMapper.NAME,
        assertTrue(indexShard.isRelocatedPrimary());
            assertEquals(shardStateMetadata, state3);  
            try {
            indexShard.acquireAllPrimaryOperationsPermits(onAcquired, new TimeValue(Long.MAX_VALUE, TimeUnit.NANOSECONDS));  
                        "{\"foo\" : \"bar}".getBytes(Charset.forName("UTF-8")),
    }
        // this test indexes docs on a primary, refreshes, then recovers a new Search Replica and asserts
        indexDoc(shard, "_doc", "0");
            } finally {  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        for (int i = 0; i < numDocs; i++) {
        final CyclicBarrier barrier = new CyclicBarrier(3);  
                    maxSeqNoOfUpdatesOrDeletes,
            null,
                indexShard.refresh("test");
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())  
            final AtomicBoolean onResponse = new AtomicBoolean();  
            RecoverySource.LocalShardsRecoverySource.INSTANCE  
            fail();
        AtomicBoolean stop = new AtomicBoolean(false);
        assertFalse(shard.isRelocatedPrimary());
        closeShards(shard);
                        postDelete(shardId, delete, result.getFailure());
import org.opensearch.action.index.IndexRequest;
import java.util.concurrent.CountDownLatch;  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
                .retentionLeasesSupplier(config.retentionLeasesSupplier())
        indexShard.flush(new FlushRequest());  
            final AtomicBoolean onResponse = new AtomicBoolean();
                () -> {},
        final ShardRouting routing = ShardRoutingHelper.relocate(originalRouting, "other_node");
 */  
                                fail();  
            shard,
        assertThat(indexShard.getPendingPrimaryTerm(), equalTo(primaryTerm + Math.max(firstIncrement, secondIncrement)));
        }
                    indexShard.acquireAllPrimaryOperationsPermits(future, TimeValue.timeValueHours(1L));  
            indexShard,  
        );  
                ShardRoutingHelper.initWithSameId(primaryShardRouting, RecoverySource.ExistingStoreRecoverySource.INSTANCE)
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
        assertTrue("recovery should start", recoveryStartedLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.common.lease.Releasables;
        MappedFieldType foo = shard.mapperService().fieldType("foo");
            true,
            latch.countDown();
            @Override
        assertTrue("recover even if there is nothing to recover", recoverFromStore(newShard));
            } else {
            ) {  
    }
        }, false, true);  
                onLockAcquired = new PlainActionFuture<>();
        assertFalse(shard.isActive());
                UUIDs.randomBase64UUID(),
        recoverShardFromStore(primary);
            assertDocCount(newShard, 2);
                barrier.await();
            Releasable operation2 = acquirePrimaryOperationPermitBlockingly(indexShard);
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
        // check that corrupt marker is there
    }
        assertThat(shard.refreshStats().getTotal(), equalTo(refreshCount + 2));
    public void testIndexCheckOnStartup() throws Exception {
        shard.applyIndexOperationOnReplica(
                    }
                try {  
            indexDoc(shard, "_doc", Integer.toString(i));
        snapshot = newShard.snapshotStoreMetadata();  
            closeShards(corruptedShard);  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")  
            .getRemoteSegmentTransferTracker(shard.shardId);
        // finalizing a replica involves two refreshes with soft deletes because of estimateNumberOfHistoryOperations()
            newShard.getReplicationTracker()
    private void populateSampleRemoteTranslogStats(RemoteTranslogTransferTracker tracker) {
        closeShard(shard, false);  
                    latch.countDown();  
                    i,
        ReplicationFailedException segRepException = expectThrows(
        }  
    public void testFailShard() throws Exception {
import org.opensearch.index.mapper.SourceFieldMapper;  
        int numDocs = between(1, 10);  
                });  
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(createTempDir());  
        assertEquals(0, preDelete.get());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        operationLatch.countDown();  
     * and {@code newEngineReference.set(newEngine)} inside {@code resetEngineToGlobalCheckpoint}.  
                        fail("unexpected result type:" + result.getResultType());  
                replicaRouting.shardId(),
        assertThat(getShardDocUIDs(indexShard), equalTo(docsBelowGlobalCheckpoint));
            if (indexShard.routingEntry().primary()) {
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();  
        assertEquals(TimeValue.timeValueSeconds(30), flushTask.getInterval());
            () -> {},
        shard.updateLocalCheckpointForShard(shard.shardRouting.allocationId().getId(), 0);  
            0L,  
        routing = ShardRoutingHelper.initialize(routing, newShard.routingEntry().currentNodeId());  
     * Promotes a started replica to primary with a primary-replica resync whose listener never completes, which is what happens
        indexDoc(primary, "_doc", "1");
        long newMaxSeqNoOfUpdates = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        assertFalse(primary.scheduledRefresh());
        );
        // but since no segment info is found, it falls back to Empty Store recovery logic.  
        // check that local checkpoint of new primary is properly tracked after recovery
            .primaryTerm(0, 1)  
        long maxSeqNoBeforeRollback = shard.seqNoStats().getMaxSeqNo();  
                        null,
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
        shard.acquireAllReplicaOperationsPermits(
import org.opensearch.index.fielddata.FieldDataStats;
        assertDocs(target, "1", "2");  
                            shard.sync(new Translog.Location(randomLong(), randomLong(), randomInt()), (ex) -> semaphore.release());
        shard.applyIndexOperationOnReplica(  
            thread[i].start();  
            true,
            indexShard,  
        assertTrue(primary.getIndexer().refreshNeeded());
            }
            closeShards(replica);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    }  
        expectThrows(AlreadyClosedException.class, shard::acquireSafeIndexCommit);
                try {
        ShardRouting searchReplicaShardRouting = TestShardRouting.newShardRouting(
        IndexScopedSettings scopedSettings = primary.indexSettings().getScopedSettings();
                i -> store,
            .build();  
                indexShard.flush(new FlushRequest());
                if (!gap && i == localCheckpoint + 1) {  
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
                meta.indexUUID,
        Settings newSettings = Settings.builder()  
                        fail("unexpected result type:" + result.getResultType());
        recoverReplica(replicaShard, primaryShard, true);
                        closeDoneLatch.await();
                    AllocationId.newRelocation(routing.allocationId())  
    public void testClosesPreventsNewOperations() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        closeShard(source, false);
        final IndexShard primaryShard = newShard(  
        barrier.await();
            public void onFailure(Exception e) {
            "a seeded migrating shard downloaded its translog from the remote store",
    }
        indexDoc(source, "_doc", "3");
            shardPath,  
            closeShards(shard);  
        assertEquals(  
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        if (randomBoolean()) {
            final long numDocsToDelete = randomLongBetween(1, numDocs);  
     */
                final long mappingVersion,
        Settings settings = Settings.builder()  
                .circuitBreakerService(config.getCircuitBreakerService())
import org.opensearch.snapshots.SnapshotId;  
    }
    public void testRollbackReplicaEngineOnPromotion() throws IOException, InterruptedException {  
                    greaterThanOrEqualTo(storeStats.sizeInBytes() * 80 / 100)  
            );  
        } else {  
                    hitClosedExceptions++;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            assertThat(indexShard.getIndexer(), sameInstance(beforeRollbackIndexer));  
import org.opensearch.index.fielddata.IndexFieldDataCache;  
            IndexShardTestCase.updateRoutingEntry(targetShard, ShardRoutingHelper.moveToStarted(targetShard.routingEntry()));  
            assertFalse(refreshed);  
        try (Store store = createStore(indexShard.indexSettings(), shardPath)) {
        );  
            for (final Integer i : ids) {
            );
        IndexShard primary = newStartedShard(true, segRepSettings);
        assertEquals(replicaShard.getIndexer().config().getTranslogFactory().getClass(), InternalTranslogFactory.class);
 *  
            IndexShard shard = indexShard;  
            1L,
        // most of the time this is large enough that most of the time there will be at least one gap  
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();  
        closeShards(primary);  
            () -> randomReplicaOperationPermitAcquisition(
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        } finally {  
            .build();  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);  
                final StoreStats storeStats = indexShard.storeStats();  
                final ActionListener<Long> listener
    }
                    allPermitsAcquired.countDown();
        final IndexShard primaryShard = newShard(
     * {@code engineMutex} via reflection, and asserts {@code getSegmentInfosSnapshot()}  
        closeShards(test);
        }
     */
            }
        Settings settings = Settings.builder()  
        assertThat(indexShardRecoveryException.getMessage(), equalTo("failed recovery"));
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
            synced.get(),
        IndexShardTestCase.updateRoutingEntry(shard, routing);
        } else {
                }  
    public void testSearchShardDoesNotStartIfCorruptedMarkerIsPresent() throws Exception {  
            });
        assertEquals(0, postIndexException.get());
        snapshot = newShard.snapshotStoreMetadata();
                indexShard.getLastKnownGlobalCheckpoint(),
     * <p>
        assertEquals(0, postIndexUpdate.get());
    }
        final String corruptionMessage = "fake ioexception";  
                indexShard.updateGlobalCheckpointForShard(
        IndexMetadata metadata = IndexMetadata.builder("test")
            .seqNoStats(shard.seqNoStats())  
        }  
                        ""
                    id
            primaryTerm,
                SeqNoFieldMapper.NAME,
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        primaryShard.maybeSyncGlobalCheckpoint("test");
            ""
        assertDocCount(shard, 2);
        /*
                    try (Releasable operationLock = acquirePrimaryOperationPermitBlockingly(shard)) {  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")  
import static org.hamcrest.Matchers.instanceOf;
                    ? ShardStateMetadata.IndexDataLocation.REMOTE
        IndexShardTestCase.updateRoutingEntry(indexShard, relocatingRouting);
        assertFalse(primary.getPeriodicFlushTask().isClosed());  
import org.opensearch.index.seqno.RetentionLeases;
        RemoteSegmentStoreDirectory remoteStoreDirectory = ((RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) target
            .build();  
            null,
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
        String historyUUID = shard.getHistoryUUID();
        indexDoc(shard, "_doc", "1", "{\"foo\" : \"bar\"}");
        }  
     * wiring bug, and the typed surface surfaces it loudly rather than silently firing the listener.
                startRecovery.await();
        final ShardRouting relocatingRouting = ShardRoutingHelper.relocate(primaryRouting, "other_node");
        } else {
            ActionListener.wrap(r -> {
    }  
        indexDoc(indexShard, "_doc", "1", "{}");
        // doing it directly instead
        );
        );  
                                    latch.countDown();
                    recoveryStartedLatch.countDown();  
        final CountDownLatch resyncDispatched = new CountDownLatch(1);
        );  
        final long pendingPrimaryTerm = indexShard.getPendingPrimaryTerm();
        indexDoc(test, "_doc", "test");
    /**  
            true,
        final int numberOfAcquisitions = randomIntBetween(1, 10);
    }
    }
                    @Override  
            );  
import org.opensearch.core.action.ActionListener;  
            }
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
        );
        // An unchanged value is a no-op.  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            primarySettings,  
                        "{\"foo\" : \"bar\"}".getBytes(Charset.forName("UTF-8")),  
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
                assertThat(
        try (
            assertEquals(3, searcher.getIndexReader().numDocs());
            assertFalse("idle non-DFA engine reports no pending merges", shard.hasPendingMerges());
                    assertThat(indexShard.getLocalCheckpoint(), equalTo(expectedLocalCheckpoint));  
            null,
            )  
                        retentionLeases.version() + 1,
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                randomNonNegativeLong(),
    }
        assertThat(initialForceMergeUUID, nullValue());
        final IndexShard shard = newStartedShard(false);
        assertEquals(0, indexShard.getActiveOperationsCount());
            try (Engine.Searcher searcher = primary.acquireSearcher("test")) {
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import static org.hamcrest.Matchers.containsString;  
        assertThat(shard.refreshStats().getExternalTotal(), equalTo(externalRefreshCount));
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
    }  
     * {@code getSegmentInfosSnapshot()} through the {@code ReplicationCheckpointUpdater} refresh
    }
import static org.hamcrest.Matchers.equalTo;
            assertThat(shard.refreshStats().getTotal(), equalTo(initialRefreshes + i - 1));
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperationsOnStart());  
        recoveryEmptyReplica(indexShard, randomBoolean());
                    return null;  
            Settings.builder()  
                )
        }
            .build();  
                Settings.builder()
                final StoreStats storeStats = indexShard.storeStats();  
    }  
        try {  
                }
                final ActionListener<Long> listener
            sourceToParse  
            public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
     * when the resync response is lost. Waits until the resync has been handed to the syncer and returns the new primary routing.  
                public void onFailure(final Exception e) {
                IndexShardTestUtils.getFakeDiscoveryNodes(primaryRouting)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            primaryRouting,
                }
            indexDoc(primarySource, "_doc", Integer.toString(i));
            false,
        } finally {
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            if (i < recoveryIndex) {
        final Path indexPath = shardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
            if (randomBoolean()) {
            }
                Settings.builder()
        AllocationId allocationId = AllocationId.newInitializing();  
        final IndexShard shard = newStartedShard(true);
                        break;
        indexDoc(shard, "_doc", "1");  
                preIndex.incrementAndGet();  
        target.refresh("test");
                assertThat(storeStats.sizeInBytes(), greaterThan(numDoc * 100L)); // A doc should be more than 100 bytes.
            null,
            ""
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                @Override  
            assertEquals(1, indexShard.getActiveOperationsCount());
import org.opensearch.common.util.concurrent.AbstractRunnable;
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        indexDoc(primary, "_doc", "2");  
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));  
        cancellingThread.join();  
        });
                try {
                    deleteDoc(indexShard, Integer.toString(i));  
                    Settings.builder()
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            return new InternalEngine(config);  
            }, ThreadPool.Names.SAME, "test");
        };
import static org.hamcrest.Matchers.nullValue;  
        // wait until the thread-pool has moved the timestamp otherwise we can't assert on this below  
     * <p>  
        IndexShard replica = newShard(primary.shardId(), false, "n2", metadata, null);
                null,
            doReturn(Set.of(behindStat)).when(spyShard).getReplicationStatsForTrackedReplicas();  
        } finally {
        final IndexShard primarySource = newStartedShard(true);
            )
import org.opensearch.indices.replication.common.ReplicationFailedException;
        } finally {
    public void testReadSnapshotConcurrently() throws IOException, InterruptedException {
     * acquired the index writer lock before it called into the store that has it's own locking for metadata reads  
        long seqNo = 0;
                } catch (final InterruptedException e) {  
                containsString("in primary mode cannot be a replication target")
            "n1",  
        // check stats on closed and on opened shard
                remoteDirectory.deleteFile(file);
            shard.waitForReplicaSync(TimeValue.timeValueSeconds(1));
                .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())  
        searchReplicaShardRouting = replica.routingEntry();
            MergedSegmentPublisher.EMPTY  
                primaryTerm + increment,  
            public void indexTranslogOperations(
            closeShards(shard);
     */  
     * test one can snapshot the store at various lifecycle stages  
            public void indexTranslogOperations(
        }
            null,  
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
            // fileLength method is called during storeStats try block
                        null,
    }  
        assertFalse(relocated.get());  
            // check that local checkpoint of new primary is properly tracked after recovery  
                assertNull(onFailure.get());  
                        allPrimaryOperationLocksAcquired.countDown();
        final IndexShard shard = newStartedShard(true);
        );
                    .field("point", randomFloat())
                () -> assertThat(indexShard.getActiveOperationsCount(), equalTo(1)),  
                    docsStats.getTotalSizeInBytes(),
        source.refresh("test");  
        final long numDocs = between(10, 100);
        try {
            // flush the buffered deletes
    }
            ShardRouting replicaRouting = indexShard.routingEntry();
        );  
            closeShards(shard);  
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
        IndexShard newShard = reinitShard(shard);
            )
            )
    public void testRestoreShard() throws IOException {  
            try {
                    @Override
        final IndexShard newShard = newShard(  
        final Thread second = new Thread(function.apply(secondIncrement));
        IndexMetadata metadata = IndexMetadata.builder("test")
        assertEquals(0, postDeleteException.get());
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())  
import org.apache.lucene.store.FilterDirectory;  
        }));
        final AtomicBoolean blocked = new AtomicBoolean();  
        synced.set(false);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        FieldDataStats after = null;  
            indexShard.forceMerge(forceMergeRequest);
            );  
                        delayedOperationsLatch.countDown();
        final List<Translog.Operation> operations = Stream.concat(
            IOException ex = expectThrows(IOException.class, () -> spyShard.waitForReplicaSync(TimeValue.timeValueMillis(600)));
                    assertEquals(file.recovered(), 0);
         * This operation completing means that the delay operation executed as part of increasing the primary term has completed and the
                    new RetentionLeases(
            shard.addShardFailureCallback((ig) -> failureCallbackTriggered.set(true));
            indexShard.engineConfigFactory,  
        Store.MetadataSnapshot snapshot = newShard.snapshotStoreMetadata();
            public void restoreShard(
                meta.indexDataLocation == ShardStateMetadata.IndexDataLocation.LOCAL
                assertTrue(refreshed);
        closeShards(primary, replica);  
            IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.REMOTE_MIGRATING_SEEDED)  
            null,
        IndexShardTestCase.updateRoutingEntry(shard, toNode2);
                };  
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");  
            public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
        assertThat(indexShard.getActiveOperationsCount(), equalTo(0));
        // try to start shard on corrupted files  
                }
        Files.walkFileTree(indexPath, corruptedVisitor);  
        IndexShard shard = newStartedShard();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            Settings.EMPTY,
        );
        IndexShard shard = newStartedShard(true);  
            assertThat(shard.state, equalTo(IndexShardState.CLOSED));  
            }
            replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
        );  
            }
        target.restoreFromRemoteStore(future);  
            ShardRoutingHelper.initWithSameId(shard.routingEntry(), RecoverySource.ExistingStoreRecoverySource.INSTANCE),
            assertThat(counter.get(), equalTo(1L));  
    public void testPeriodicFlushTaskNotStartedForRegularIndex() throws Exception {  
                        0,  
        shard.refresh("test");
        }
import static org.mockito.Mockito.verify;
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);  
    public void testWaitForReplicaSync_NonSegRepIndex_ReturnsImmediately() throws IOException {  
        } else {  
import java.util.Locale;
            }
        for (long i = 0; i < numDocs; i++) {  
            .getRemoteTranslogTransferTracker(shard.shardId);
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNoOfUpdatesOrDeletesBeforeRollback));
            .commonStats(new CommonStats(new IndicesQueryCache(Settings.EMPTY), shard, new CommonStatsFlags()))  
                gap = true;
        primary.recoveryState().getTranslog().totalOperationsOnStart(snapshot.totalOperations());
        final long extraInternalRefreshes = shard.routingEntry().primary() || shard.indexSettings().isSoftDeleteEnabled() == false ? 0 : 1;  
        assertTrue("disabling index.periodic_flush_interval should close the running task", flushTask.isClosed());
                    assertThat(e, hasToString(containsString("shard is not in primary mode")));
            indexShard,
                (shardId, lockTimeoutMS, details) -> new DummyShardLock(shardId)
        RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();  
        newShard = reinitShard(newShard, ShardRoutingHelper.initWithSameId(routing, RecoverySource.EmptyStoreRecoverySource.INSTANCE));  
                                }  
            if (randomBoolean()) {
                final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            () -> indexShard.acquireAllPrimaryOperationsPermits(null, TimeValue.timeValueSeconds(30L))  
            Translog.Operation operation;
        for (int i = 1; shard.refreshStats().getExternalTotalTimeInMillis() == initialTotalTime; i++) {
        assertEquals(1, postIndexCreate.get());
        IndexShardTestCase.updateRoutingEntry(shard, relocationRouting);
        closeShards(replicaShard);
        assertThat(  
                        assertThat(indexShard.getLocalCheckpoint(), equalTo(expectedLocalCheckpoint));
        );
 * license agreements. See the NOTICE file distributed with
        assertFalse(IndexShard.isTranslogBackedByRemoteStore(docrepIndex, IndexShard.ShardMigrationState.REMOTE_NON_MIGRATING));
        }
                super.indexTranslogOperations(
            }, TimeValue.timeValueSeconds(30));
    public void testShardCanNotBeMarkedAsRelocatedIfRelocationCancelled() throws IOException, InterruptedException {
            primaryTerm,
            assertNotNull(getResult.searcher());  
        assertTrue(refreshListeners.stream().anyMatch(e -> e instanceof CheckpointRefreshListener));
    }
            replica.getGlobalCheckpointSyncer(),  
        try {
    }
        IndexShard target = newStartedShard(
            null,
            3,
        first.join();
        }
        // The timeout is far longer than this test runs, so only the resync failing can clear the flag.  
        latch.await();
            shard.getOperationPrimaryTerm(),  
                targetShard.recoverFromLocalShards(mappingConsumer, Arrays.asList(sourceShard, differentIndex), future);  
                    .toString();
     * Verifies the tiering diagnostic wrappers report correct values on a standard (non-DFA) engine.
        assertTrue(indexShard.isRelocatedPrimary());  
        final IndexShard replicaShard = newStartedShard(  
            replicaRouting.shardId(),
        // The timeout is far longer than this test runs, so nothing can clear the flag while the test checks it.
        assertTrue(recoverFromStore(newShard));
        );  
            true,
            ShardRoutingState.INITIALIZING,
                SeqNoFieldMapper.NAME,
        assertThat("store still has a single corrupt marker", corruptedMarkerCount.get(), equalTo(1));
                try {  
            randomBoolean(),
            shard.getOperationPrimaryTerm(),
        assertEquals(TimeValue.timeValueMinutes(1), flushTask.getInterval());  
                }
        }));  
            newShard.store().cleanupAndVerify("test", storeFileMetadatas);  
        return Settings.builder().put(super.threadPoolSettings()).put("thread_pool.estimated_time_interval", "5ms").build();  
            public void indexTranslogOperations(
                barrier.await();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        }
    public void testPrimaryReplicaResyncOnResponseUnblocksPrimaryRelocation() throws Exception {
        final Path shardStatePath = shard.shardPath().getShardStatePath();
            .build();
                logger.info("File {} was not deleted and is not pending delete, attempting delete again...", file);  
                        null,
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        assertBusy(() -> assertFalse(indexShard.isPrimaryReplicaResyncInProgress()), 30, TimeUnit.SECONDS);  
        String remoteStorePath = createTempDir().toString();
            assertThat(hitClosedExceptions, lessThanOrEqualTo(2));  
            // listAll method is called when marking store as corrupted
        int translogOps = totalOps;  
import static org.hamcrest.Matchers.greaterThan;
import java.nio.file.Path;
            false,
            {
        shard.refresh("test");
    }
import org.opensearch.Version;
            routing,
        Releasables.close(allPermits);
                        assertThat(indexShard.getReplicationGroup(), notNullValue());
                    shard.resetEngineToGlobalCheckpoint();
                postIndex.incrementAndGet();  
    }  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
                public void onBeginTranslogRecovery() {
        assertEquals(RecoverySource.ExistingStoreRecoverySource.INSTANCE, searchReplicaShardRouting.recoverySource());
        );
        String remoteStorePath = createTempDir().toString();  
            false,
        IndexShardTestCase.updateRoutingEntry(shard, relocationRouting);  
    public void testShardStatsWithFailures() throws IOException {
    /**  
                final int totalTranslogOps,  
            .build();
            assertThat(ex.getMessage(), containsString("max bytes behind:"));
        shard.advanceMaxSeqNoOfUpdatesOrDeletes(1); // manually advance msu for this delete
import java.util.concurrent.atomic.AtomicLong;
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        indexShard.relocated(relocatingRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
    }  
                                    latch.countDown();
                try (Engine.Searcher searcher = primary.acquireSearcher("test")) {  
        );
    private AllocationId randomAllocationId() {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                            }
        if ((e = onFailure.get()) != null) {
        shard.writeIndexingBuffer();  
            lastSearchAccess,  
            final TimeValue timeout = TimeValue.timeValueSeconds(30L);
        for (int i = 0; i < totalOps; i++) {  
 *
            List.of(target.store().directory().listAll()).containsAll(lastCommitedSegmentsInSource)
                @Override
        settings = Settings.builder().put(settings).put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO).build();  
        // set up local checkpoints on the shard copies
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.index.seqno.SeqNoStats;
            assertEquals(search.totalHits.value(), 1);  
                    new BytesArray("{}"),  
            newShardRouting(
            indexShard.runUnderPrimaryPermit(
            final String executorOnDelay = randomFrom(  
                }  
        recoveryThread.join();  
            new EngineBackedIndexerFactory(new InternalEngineFactory()),  
            assertThat(e, hasToString(containsString("acquirePrimaryOperationPermit should only be called on primary shard")));
        // check that corrupt marker is there
        expectThrows(  
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader("foo", reader);
            search = searcher.search(new TermQuery(new Term("foobar", "bar")), 10);
            indexShard.getGlobalCheckpointSyncer(),
                super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, ActionListener.wrap(r -> {
            IntStream.range(0, randomIntBetween(0, 10))
                }  
    }  
                    private void finish() {  
                        1,
                ActionListener.completeWith(listener, () -> {  
        allPrimaryOperationLocksAcquired.await();
import static java.util.Collections.emptyMap;  
            // start finalization of recovery
        CountDownLatch latch = new CountDownLatch(10);
            .put(current.getSettings())
            containsInAnyOrder(  
        Settings segRepSettings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
                // our operation should be blocked until the previous operations complete
                    }  
            RecoveryState recoveryState = targetShard.recoveryState();
        shard.failShard("test shard fail", new CorruptIndexException("", ""));
                throw new RuntimeException(e);
        IndexMetadata metadata = IndexMetadata.builder("test")  
                        listener.onResponse(checkpoint);  
        assertFalse(refreshListeners.stream().anyMatch(e -> e instanceof CheckpointRefreshListener));
        latch.await();
        closeShards(indexShard);
        } finally {
            assertTrue(called.get());
            .build();
                if (ex == null) {
            primary.shardId,
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.test.VersionUtils;
        expectThrows(AlreadyClosedException.class, () -> newShard.getIndexer()); // no engine
        indexDoc(primary, "_doc", "2");
            final CountDownLatch latch = new CountDownLatch(1);  
                indexShard.flush(new FlushRequest());  
                    try {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        throw new RuntimeException(e);
                assertThat(indexShard.getOperationPrimaryTerm(), equalTo(primaryTerm));
        final Indexer beforeRollbackIndexer = indexShard.getIndexer();
        return promoteReplicaWithResyncSyncer(replica, (shard, resyncListener) -> {});
                SourceFieldMapper.NAME,
                IndexShard.isTranslogBackedByRemoteStore(remoteStoreIndex, state)
            source.shardId(),
     * a remote-store index always; a migrating docrep shard only once a remote source has seeded it, since an unseeded
        closeShards(newShard);  
        );
            }  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IllegalStateException.class,  
            @Override
            indexMetadata,  
        assertTrue(getResult.exists());
                SourceToParse sourceToParse = new SourceToParse(  
            }))
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;  
        assertTrue(primary.scheduledRefresh());
        }  
import org.opensearch.index.mapper.IdFieldMapper;
        assertThat(  
            .build();
        // create corrupted marker  
        closeShards(primary);
    public void testScheduledRefresh() throws Exception {
         * translog generation has rolled.
        );
        if (shouldRollback) {  
        final ShardRouting replicaRouting = indexShard.routingEntry();  
                if (randomBoolean()) {
        deleteDoc(shard, "0");
                newShardRouting(  
            public String[] listAll() throws IOException {
                };
            equalTo(maxSeqNo == primaryShard.getLastKnownGlobalCheckpoint() && (replicaGlobalCheckpoint < checkpoint))  
                cyclicBarrier.await();
        Files.walkFileTree(indexPath, corruptedVisitor);  
                preIndex.incrementAndGet();  
            store.markStoreCorrupted(new IOException(corruptionMessage));
                        .stream()  
            .build();  
        assertEquals(1, postIndexUpdate.get());
                switch (result.getResultType()) {
        source.refresh("test");
        );
                    case FAILURE:
            0L,
        );
                indexShard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
    }
            .settings(settings)
                IndexShard shard = indexShard;
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                }
import org.opensearch.common.settings.Settings;
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        recoverReplica(shard, primary, true, (a) -> null);
                new EngineBackedIndexerFactory(new InternalEngineFactory()),  
        Settings primarySettings = Settings.builder()
            }
            expectThrows(UnsupportedOperationException.class, () -> shard.onMergesDrained(() -> {}));  
            public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
                return FileVisitResult.CONTINUE;
        try (Engine.Searcher searcher = primary.acquireSearcher("test")) {
            .settings(settings)
                    throw new RuntimeException(e);
                    new ActionListener<Releasable>() {
        assertFalse(primary.scheduledRefresh());
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();
    public void testRecoverFromTranslog() throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        closeShards(newShard);  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
        recoverShardFromStore(primary);  
        );  
        for (int i = 0; i < 2; i++) {
                    lessThanOrEqualTo(storeStats.sizeInBytes() * 120 / 100)
        );
                }
            shardId,
        };
        assertFalse(flushTask.isClosed());  
        getResult.close();
            @Override  
            false,
        try {  
                );  
        shard.acquireAllReplicaOperationsPermits(  
        recoverShardFromStore(primary);  
        Settings settings = Settings.builder()
                indexShard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
            } else {
        closeShards(newShard);  
            assertThat(cancellingException.get(), instanceOf(IllegalIndexShardStateException.class));  
                                } finally {
        };  
            assertThat(indexShard.getLocalCheckpoint(), equalTo(Math.max(globalCheckpoint, globalCheckpointOnReplica)));  
        Collection<String> uploadFiles = remoteStoreDirectory.getSegmentsUploadedToRemoteStore().keySet();
import java.nio.charset.Charset;
                new ActionListener<Releasable>() {  
    }
        );  
        Settings primarySettings = Settings.builder()
            snapshot,  
    }  
        primary.addRefreshListener(doc.getTranslogLocation(), r -> latch.countDown());  
            assertThat(e, hasToString(matches("operation primary term \\[\\d+\\] is too old")));
                        pendingPrimaryTerm,
                operations.add(
        // Execute the flush task
        indexShard.sync(); // advance local checkpoint
                    indexShard.getLastKnownGlobalCheckpoint(),  
            }, Assert::assertNotNull),
            searchReplicaShardRouting,
        final long numDocs = between(10, 20);  
        });
                ShardRoutingState.INITIALIZING,  
                    }  
            replica.getLastKnownGlobalCheckpoint(),
        final String indexName = shard.shardId().getIndexName();
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
    }
                        @Override  
            IndexShardRecoveryException.class,
                engineClosed = true;
            assertThat(counter.get(), equalTo(2L));
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
            }  
            .primaryTerm(0, 1)
            public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
                if (Files.isRegularFile(file) && file.getFileName().toString().startsWith(Store.CORRUPTED_MARKER_NAME_PREFIX)) {
        final IndexShard indexShard = newStartedShard(true);  
                        new ActionListener<Releasable>() {
                );
                assertThat(
            shard.getLastKnownGlobalCheckpoint(),
            replica,
    }
        );  
    }  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    null
    }  
            assertFalse("Catalog snapshot should have files after indexing", catalogFiles.isEmpty());  
        assertFalse(
                randomNonNegativeLong(),  
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
            shard.getEngineConfigFactory(),
     * here we are simulating the scenario that happens when we do async shard fetching from GatewaySerivce while we are finishing
        IndexerFactory customFactory = new EngineBackedIndexerFactory(config -> {  
            ShardRouting primaryRouting = newShardRouting(  
            assertThat(shard.refreshStats().getTotal(), equalTo(initialRefreshes + i));
            assertTrue(onFailure.get());  
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperations());  
                allocationId,  
            newPrimaryTerm,  
        if (randomBoolean()) {  
                assertFalse(b);
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {  
        ShardRouting routing = indexShard.routingEntry();
            primarySettings,
     */  
                    "Estimated total document size is too small compared with the stored size",
            }
        assertEquals(  
        final IndexMetadata indexMetadata = IndexMetadata.builder(replicaRouting.getIndexName())
            public void onResponse(Releasable releasable) {  
                        -1  
     */
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            indexDoc(shard, "_doc", "test");
            .build();
                        docBelowGlobalCheckpoint,
                assertThat(docStats.getCount(), equalTo(numDocs));
import static org.mockito.Mockito.when;
            OpenSearchException e = expectThrows(OpenSearchException.class, shard::storeStats);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            // merge them away
        indexShard.updateShardState(
        assertThat(deleteDoc.getField(IdFieldMapper.NAME).binaryValue(), equalTo(Uid.encodeId(id)));  
        AtomicInteger preDelete = new AtomicInteger();
    public void testDelayedOperationsBeforeAndAfterRelocated() throws Exception {
                        public void onFailure(Exception e) {  
        assertThat(primaryShard.getLocalCheckpoint(), equalTo(numDocs - 1L));
    }
        switch (randomInt(2)) {
            wrapper,  
            TimeValue.timeValueMinutes(1)
            indexDoc(shard, "_doc", "1");  
                assertThat("searcher was marked as accessed", shard.getLastSearcherAccess(), equalTo(prevAccessTime));  
         * - index #3  
            assertTrue(recoverFromStore(newShard));
                final String id = ids.isEmpty() || randomBoolean() ? Integer.toString(i) : randomFrom(ids);
        IndexShard replica,
        final SegmentReplicationCheckpointPublisher publisher = null;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())  
        }
        try (
        }  
        }  
        final ShardRouting relocatingRouting = ShardRoutingHelper.relocate(primaryRouting, "other_node");
            }
        shard.store().close();
            StoreUtils.canOpenIndex(
        // Failing the shard is the behaviour under test, so allow it rather than letting the harness treat it as an error.
        final RecoverySettings recoverySettings = new RecoverySettings(  
        assertTrue(primary.scheduledRefresh()); // make sure we refresh once the shard is inactive
                    listener.onResponse(r);
            .build();
                            public void onResponse(final Releasable releasable) {  
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
            () -> newStartedShard(p -> corruptedShard2, true)
            equalTo(totalOps - 1L)
    }  
import static org.hamcrest.Matchers.containsInAnyOrder;
        closeShards(primary, replica);
            meta = new ShardStateMetadata(  
import java.nio.file.attribute.BasicFileAttributes;  
            .primaryTerm(0, 1)
    public static void write(ShardStateMetadata shardStateMetadata, Path... shardPaths) throws IOException {
                routing = newShardRouting(  
        final ShardRouting original = shard.routingEntry();  
                try (Releasable dummy = r) {
            assertThat(shard.translogStats().estimatedNumberOfOperations(), lessThanOrEqualTo(translogStats.estimatedNumberOfOperations()));
        final IndexShard readonlyShard = reinitShard(
    }  
                } else {
import org.opensearch.index.mapper.Uid;
    /**
                    throw ex.get();
     */  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        );  
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueHours(1));  
            fail("Expected IndexShardRelocatedException");
        }, future);  
        assertEquals(TimeValue.timeValueMinutes(1), primary.getPeriodicFlushTask().getInterval());
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testPrimaryPromotionRollsGeneration() throws Exception {  
        } else {  
                ThreadPool.Names.WRITE,  
        routing = ShardRoutingHelper.newWithRestoreSource(  
     */
                    retentionLeases,  
    /**  
     */
        closeShards(corruptedShard);
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                throw new RuntimeException(e);
        final IndexShard primaryShard = newStartedShard(
        assertEquals(100.0f, newShard.recoveryState().getTranslog().recoveredPercent(), 0.01f);
        final ShardPath shardPath = indexShard.shardPath();  
                            continue;
                    )
            }  
                "store",  
            if (randomBoolean()) {  
            .build();
            });
    private static void assertRemoteTranslogStats(
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueSeconds(10));
                r.close();
            assertTrue("getSegmentInfosSnapshot should not block on engineMutex", snapshotCompletedLatch.await(5, TimeUnit.SECONDS));  
        routing = ShardRoutingHelper.newWithRestoreSource(routing, new RecoverySource.EmptyStoreRecoverySource());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        shard.openEngineAndRecoverFromTranslog();  
        );
        relocationThread.join();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        for (int i = offset + 1; i < operations; i++) {  
        }  
        ParseContext.Document noopDoc = noopTombstone.docs().get(0);  
    }
import java.util.concurrent.atomic.AtomicBoolean;
        recoverShardFromStore(replica);  
            @Override
        try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
        assertNotEquals(meta, new ShardStateMetadata(!meta.primary, meta.indexUUID, randomAllocationId(), meta.indexDataLocation));  
                }
        IndexShard shard = newStartedShard(  
        }
        assertNotSame(flushTask, restarted);  
            indexShard.getRetentionLeaseSyncer(),
        assertThat(newShard.getLocalCheckpoint(), equalTo(totalOps - 1L));
        IndexShard shard = newStartedShard(  
            @Override  
            ) {  
        indexDoc(primary, "_doc", "0", "{\"foo\" : \"bar\"}");
                replicaRouting.currentNodeId(),
                        0,  
                    engineResetLatch.countDown();  
        shard.forceMerge(firstForceMergeRequest);
            shard.acquirePrimaryOperationPermit(onLockAcquired, ThreadPool.Names.WRITE, "i_" + i);
        closeShards(shard);
        shard.store().close();  
                }  
        IndexScopedSettings scopedSettings = primary.indexSettings().getScopedSettings();
    public void testDocStats() throws Exception {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            );
                MockFSDirectoryFactory.checkIndex(logger, shard.store(), shard.shardId);  
    ShardStateMetadata getShardStateMetadata(IndexShard shard) {
        final ShardRouting relocationRouting = ShardRoutingHelper.relocate(originalRouting, "other_node");  
            equalTo(
/*  
import java.util.stream.Collectors;
     */
        assertEquals(getEngine(replicaShard).getClass(), NRTReplicationEngine.class);  
                return operation;
        assertThat(thirdForceMergeUUID, equalTo(secondForceMergeRequest.forceMergeUUID()));
                throw new RuntimeException(e);  
                new IndexId("test", UUIDs.randomBase64UUID(random()))
        final String targetAllocationId = relocatingRouting.getTargetRelocatingShard().allocationId().getId();  
        assertTrue(primary.scheduledRefresh());  
        closeShards(newShard);
                try (Releasable dummy = r) {
        assertThat(indexShard.getLocalCheckpoint(), equalTo((long) result.localCheckpoint));
        XContentBuilder builder = jsonBuilder();
        recoverShardFromStore(primary);
        tracker.incrementTotalUploadsStarted();
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);  
            assertThat(cancellingException.get(), nullValue());
    public void testRelocatedSegRepError() throws IOException, InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
            ShardRoutingHelper.initWithSameId(primaryShardRouting, RecoverySource.ExistingStoreRecoverySource.INSTANCE)  
        } finally {
            indexMetadata,
            .put(IndexMetadata.SETTING_VERSION_CREATED, versionCreated.id)
                final long mappingVersion,
        // onFailure must clear the flag and, because the shard is not closed, fail the shard.
                    listener.onResponse(r);
        int iters = iterations(5, 10);
            assertThat(targetShard.getLocalCheckpoint(), equalTo(1L));
        assertTrue("At lease one remote sync should have been completed", source.isRemoteSegmentStoreInSync());
            indexShard.flush(flushRequest);  
            // engine reference was switched twice: current read/write engine -> ready-only engine -> new read/write engine
    }
            indexShard = newStartedShard(true);
        assertTrue(flushTask.isScheduled());
            //
                        primary.getPendingPrimaryTerm(),
        }
                    }
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
        shard.flush(new FlushRequest());  
        }
            randomAlphaOfLength(10),
    public void testTranslogFactoryForReplicaShardWithoutRemoteStore() throws IOException {  
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
                if (engineClosed) {  
            null,
                return operation;
            assertThat(indexShard.getActiveOperationsCount(), equalTo(0));
        // We use AtomicReference here to inject failure in the middle of the test not immediately
            IllegalIndexShardStateException.class,
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "txlog-test")
                assertThat(onFailure.get(), instanceOf(IndexShardNotStartedException.class));  
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));
        assertFalse(docrepIndex.isRemoteTranslogStoreEnabled());
            thread.start();  
        assertEquals(remoteTranslogTransferTracker.getUploadBytesFailed(), remoteTranslogStats.getUploadBytesFailed());
 * under the License.  
        String remoteStorePath = createTempDir().toString();
    }
        closeShards(indexShard);
import org.opensearch.common.io.PathUtils;
        Engine.IndexResult indexResult = indexDoc(shard, "some_type", "0", "{\"foo\" : \"bar\"}");
        }  
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMillis(10))
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));  
            Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED),  
                }
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
            assertThat(replica.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(Math.max(currentMaxSeqNoOfUpdates, newMaxSeqNoOfUpdates)));
        // The timeout is far longer than this test runs, so only the resync completing can clear the flag.
            while (done.get() == false) {  
        IndexMetadata metadata = IndexMetadata.builder("index")  
                        try {
                                    assertThat(replica.getOperationPrimaryTerm(), equalTo(opPrimaryTerm));  
                        throw new AssertionError();  
 * specific language governing permissions and limitations
            assertThat(seqNoStats.getLocalCheckpoint(), equalTo(2L));
    }
            Collections.singleton(replicaRouting.allocationId().getId()),
        );
        try (  
        try (Engine.GetResult getResult = shard.get(new Engine.Get(false, false, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))))) {
     * @return a pair of the maximum sequence number and whether or not a gap was introduced
            ShardRoutingState.INITIALIZING,
        shard.forceMerge(secondForceMergeRequest);  
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
        assertTrue(recoverFromStore(newShard));
                postDelete.incrementAndGet();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                new IndexShardRoutingTable.Builder(indexShard.shardId()).addShard(primaryRouting).build(),
            assertThat(e.getMessage(), containsString("onMergesDrained should only be called on primary shards"));
    }
        tracker.addUploadBytesSucceeded(10L);
        assertEquals(1, postDelete.get());
        try {
        final AtomicInteger postIndex = new AtomicInteger();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    "local_node",
        AtomicInteger postIndexUpdate = new AtomicInteger();  
import java.util.concurrent.BrokenBarrierException;
                GatedCloseable<SegmentInfos> snapshot = shard.getSegmentInfosSnapshot();  
        shard.refresh("test");  
    }
                        -1
        try {
    /***
        });
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
         * - index #2
        }
            // Should not throw — returns immediately for non-seg-rep indices  
                }
import org.opensearch.cluster.routing.UnassignedInfo;
                barrier.await();
                        onFailure.set(e);
    private void populateSampleRemoteSegmentStats(RemoteSegmentTransferTracker tracker) {
                    UUID.randomUUID().toString(),
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
            .settings(settings)  
        long initialTotalTime = shard.refreshStats().getExternalTotalTimeInMillis();
        Directory directory = new FilterDirectory(newFSDirectory(shardPath.resolveIndex())) {
            shardPath,
        assertTrue(recoverFromStore(newShard));
        indexDoc(primary, "_doc", "1");  
                newGlobalCheckPoint = randomIntBetween((int) indexShard.getLastKnownGlobalCheckpoint(), (int) localCheckPoint);  
            IndexShardTestCase.updateRoutingEntry(shard, origRouting);  
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), randomFrom("true", "checksum"))
            1,
            2,  
                    "other node",  
        source.refresh("test");
        final String reason = randomUnicodeOfLength(200);  
     * even if checkpointsBehindCount is zero. This catches the DFA metadata mismatch scenario.
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }  
        final ShardId shardId = new ShardId("test", "_na_", 0);
        indexDoc(shard, "_doc", "test");
     * When the primary-replica resync fails, its onFailure must clear the in-progress flag and fail the shard (since the shard is  
            indexDoc(primaryShard, "_doc", Integer.toString(i));
        allPermitsAcquired.await();
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,  
        final ExecutionException e = expectThrows(ExecutionException.class, () -> acquirePrimaryOperationPermitBlockingly(shard));
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = shard.getRemoteStoreStatsTrackerFactory()  
    /**  
        assertEquals(2, preIndex.get());  
            )  
                UNASSIGNED_SEQ_NO,  
        settings = Settings.builder().put(settings).put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO).build();
        final CountDownLatch latch = new CountDownLatch(1);
                    operations,
    }
        IndexShard newShard = reinitShard(shard);  
            }
            ) {  
    public void testRecoverFromCleanStore() throws IOException {  
        final List<PlainActionFuture<Releasable>> futures = new ArrayList<>(threads.length);  
        assertTrue(recoverFromStore(newShard));
        );  
    }  
            public void onFailure(Exception e) {  
            RetentionLeaseSyncer.EMPTY,
            null,
        assertTrue(primary.getIndexer().refreshNeeded());
            false,
                    operations,
        final long secondIncrement = 1 + (randomBoolean() ? 0 : 1);  
            final PlainActionFuture<Releasable> onAcquired = new PlainActionFuture<>();
            primaryTerm,
        latch.await();
        }  
        assertTrue(shard.isRelocatedPrimary());  
            primary.getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
    /**  
import org.opensearch.cluster.routing.ShardRoutingState;
            for (Thread thread : threads) {
    public void testWaitForReplicaSync_ReplicationInProgress_TimesOut() throws IOException {
            assertEquals(0, indexShard.getActiveOperationsCount());  
            TopDocs search = searcher.search(new TermQuery(new Term("foo", "bar")), 10);  
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
        final IndexShard primaryTarget = newShard(primarySource.routingEntry().getTargetRelocatingShard());
            if (engineClosed || randomBoolean()) {  
        }  
            newShardIndexMetadata,
                ""
                new EngineConfigFactory(new IndexSettings(metadata, metadata.getSettings())),
    /**
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
                    "Estimated total document size is too small compared with the stored size",
            for (int j = 0; j < operations; j++) {
            AssertionError e = expectThrows(AssertionError.class, replica::freezeForTiering);
        assertThat(target.seqNoStats().getMaxSeqNo(), equalTo(2L));  
        assertFalse(shard.isRelocatedPrimary());
            doReturn(Set.of(replicatingStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
                    }
        promoteReplica(
        final IndexShard indexShard = newStartedShard(true);  
        }
        assertTrue("engine reset should complete", engineResetLatch.await(30, TimeUnit.SECONDS));
        indexDoc(sourceShard, "_doc", "1", "{\"foo\" : \"bar\"}");
        // try to start another time shard on corrupted files
            shard.getEngineConfigFactory(),
        assertThat(newShard.getHistoryUUID(), not(equalTo(historyUUID)));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testRestoreShardFromRemoteStore(boolean performFlush) throws IOException {
         * - flush (commit point has max_seqno 3, and local checkpoint 1 -> points at gen 2, previous commit point is maintained)
    }  
    }  
            .build();
        final AtomicLong counter = new AtomicLong();
                    assertThat(indexShard.getLastKnownGlobalCheckpoint(), equalTo(newGlobalCheckPoint));
            () -> indexShard.acquireReplicaOperationPermit(
        recoveryEmptyReplica(replica, true);
        assertThat(indexShard.seqNoStats().getMaxSeqNo(), equalTo(maxSeqNo));
    /**
            assertEquals(shardStateMetadata, state1);
        Directory storeDirectory = ((FilterDirectory) ((FilterDirectory) target.store().directory()).getDelegate()).getDelegate();
        indexDoc(shard, "_doc", "0");
            EngineTestCase.generateNewSeqNo(getEngine(primaryShard));  
        scopedSettings.applySettings(settings);
        StringBuilder expectedSubSequence = new StringBuilder("\"shard_path\":{\"state_path\":\"");
                // started replica
            // Some path weirdness on windows
        closeShards(shard);  
                    shard.resetEngineToGlobalCheckpoint();
        RemoteTranslogStats remoteTranslogStats  
            assertThat(relocationException.get(), nullValue());
            shard.addRefreshListener(null, b -> {
            "an unseeded migrating shard still owns the only copy of its translog",  
        CountDownLatch closeDoneLatch = new CountDownLatch(1);
                );  
        assertDocCount(newShard, totalOps);
            indexShard.completionStats();  
            .put(IndexMetadata.SETTING_INGESTION_SOURCE_TYPE, "kafka")
            } catch (IOException | IllegalStateException ignored) {} finally {
            } finally {  
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1s")
        IndexShard shard = newStartedShard(true);
        assertTrue("isRemoteSegmentStoreInSync should return true after refresh", shard.isRemoteSegmentStoreInSync());
            false,
        recoverShardFromStore(primaryShard);
        Settings settings = Settings.builder()  
        assertBusy(() -> assertThat(primary.getThreadPool().relativeTimeInMillis(), greaterThan(lastSearchAccess)));
        );
        assertThat(indexShard.getLocalCheckpoint(), equalTo(maxSeqNo));
            allocationId,  
        closeShards(newShard);
        final long checkpoint = rarely() ? maxSeqNo - scaledRandomIntBetween(0, maxSeqNo) : maxSeqNo;
        final IndexShard indexShard = newStartedShard(true);  
            (shard, listener) -> {},
            new SourceToParse(shard.shardId().getIndexName(), "id-5", new BytesArray("{}"), MediaTypeRegistry.JSON)
            indexShard.indexerFactory,
            IndexShard spyShard = spy(shard);
            () -> synced.set(true),
            }
                engineClosed = false;
        assertEquals(1, latch1.getCount());
            "Failed to sync all files to new shard",
                    proceedWithCreationLatch.await(30, TimeUnit.SECONDS);
            null,  
                switch (result.getResultType()) {  
        assertEquals(1, newShard.recoveryState().getTranslog().recoveredOperations());
            .put(settings)  
        CheckedFunction<DirectoryReader, DirectoryReader, IOException> wrapper = reader -> new FieldMaskingReader("foo", reader);
            shard,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNo));
        final String replicaAllocationId = replicaShard.routingEntry().allocationId().getId();
            .build();
        if (shard.isRelocatedPrimary()) {
            latch.await();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        tracker.incrementRejectionCount();  
                final DocsStats docsStats = indexShard.docStats();
            thread.join();
            .primaryTerm(0, 1)  
        closeShards(shard);
        );
            barrier.await();
            ShardRoutingState.INITIALIZING,
        assertTrue(replicaShard.getIndexer().config().isReadOnlyReplica());
                new RecoveryState(
            when(inSyncStat.getCheckpointsBehindCount()).thenReturn(0L);
        IndexShardTestCase.updateRoutingEntry(shard, originalRouting);
        recoverShardFromStore(primary);
            assertTrue(getResult.searcher().getIndexReader() instanceof FieldMaskingReader);
                    }  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        recoverShardFromStore(newShard);
            operation2 = acquireReplicaOperationPermitBlockingly(indexShard, primaryTerm);
            closeShards(shard);
        IndexShard shard = newStartedShard();  
        ShardStateMetadata.FORMAT.writeAndCleanup(shardStateMetadata, shardPaths);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            false,
            Collections.singleton(replicaRouting.allocationId().getId()),  
        IndexMetadata metadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1).build();
            /*  
            new IndexShardRoutingTable.Builder(primaryRouting.shardId()).addShard(primaryRouting).build(),  
            thread[i] = new Thread() {  
                indexShard,  
        try (Releasable ignored = acquirePrimaryOperationPermitBlockingly(shard)) {  
        target.refresh("test");
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
                assertThat(docStats.getAverageSizeInBytes(), greaterThan(0L));  
    public void testPersistenceStateMetadataPersistence() throws Exception {
    public void testSearchIsReleaseIfWrapperFails() throws IOException {
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        tracker.incrementTotalUploadsStarted();
            for (int i = 0; i < numDoc / 2; i++) {
        do {  
        for (int i = 0; i < totalOps; i++) {
        final Path indexPath = searchReplicaShardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
                @Override
        scopedSettings.applySettings(settings);
                    assertThat(readMeta.getNumDocs(), equalTo(numDocs));
        randomReplicaOperationPermitAcquisition(  
            }
            },  
import java.util.UUID;
        assertEquals(shard.shardPath().isCustomDataPath(), stats.isCustomDataPath());  
        assertTrue(indexShard.isPrimaryReplicaResyncInProgress());
                    .endObject()
        IndexShard shard = newShard(true, Settings.EMPTY, new EngineBackedIndexerFactory(config -> {
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
            }, Assert::assertNotNull),  
     */
        final Result result = indexOnReplicaWithGaps(indexShard, operations, Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED));
        assertSame(flushTask, primary.getPeriodicFlushTask());
                .flushMergesAfter(config.getFlushMergesAfter())
    }
                }
                deleteDoc(indexShard, id);  
                .getLocalCheckpoint(),  
                null,  
            @Override
            final ForceMergeRequest forceMergeRequest = new ForceMergeRequest();
    public void testRefreshLevelRestoreShardFromRemoteStore() throws IOException {  
        final Path indexPath = shardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);  
        final IndexShardRecoveryException exception1 = expectThrows(
        updateMappings(primaryTarget, primarySource.indexSettings().getIndexMetadata());
            assertEquals("fooUUID", state3.indexUUID);
                @Override
                final RetentionLeases retentionLeases,  
                }
                    }
        randomReplicaOperationPermitAcquisition(
            randomAlphaOfLength(10),
            .build();
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
        );  
        }
        int numCorruptEntries = 0;  
import org.opensearch.index.IndexSettings;
            .build();
    /**
            UUID.randomUUID().toString(),
            new IndexFieldDataCache.Listener() {
        final int operations = 1024 - scaledRandomIntBetween(0, 1024);  
        recoveryThread.join();  
                    indexShard.advanceMaxSeqNoOfUpdatesOrDeletes(i);
        routing = ShardRoutingHelper.moveToUnassigned(routing, new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "because I say so"));
import org.apache.lucene.store.Directory;
        }
        expectThrows(
        assertTrue(stop.compareAndSet(false, true));
        final ShardId shardId = new ShardId("index", "_na_", 0);
        final LongFunction<Runnable> function = increment -> () -> {
            indexShard.getGlobalCheckpointSyncer(),  
                            semaphore.acquire();
        closeShards(primaryShard, replicaShard);  
        assertTrue(recoverFromStore(newShard));  
                        assertFalse(replica.isSyncNeeded());  
        Settings primarySettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();  
    }  
                    routing.shardId(),
        Settings settings = Settings.builder()
    private ShardRouting promoteReplicaWithResyncSyncer(  
                releasable.close();  
        for (Thread indexThread : indexThreads) {  
                expectThrows(
                assertFalse(onResponse.get());
        closeShards(newShard);  
                assertions.add(() -> {
            },
    public void testRecoverFromStoreWithNoOps() throws IOException {  
        tracker.addUploadBytesStarted(bytesStarted);
            fut,  
        assertThat(thirdForceMergeUUID, not(equalTo(secondForceMergeUUID)));  
        latch.await();
        IndexShard sourceShard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);  
            targetShard = newShard(targetRouting);
            newShard.checkIndex();
            } else {  
                            latch.countDown();
            assertEquals(0, indexShard.getActiveOperationsCount());
import org.opensearch.index.engine.EngineBackedIndexer;
                                }  
            closeShards(indexShard);
                logger,
        final IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();
        try (Releasable ignored = fut.actionGet()) {  
                final long maxAutoIdTimestamp,
        assertEquals(1, postIndexUpdate.get());
        });  
            closeShards(indexShard);
            1,
     * Verifies that {@code getSegmentInfosSnapshot()} on the ReadOnlyEngine created during
                indexShard.getLastKnownGlobalCheckpoint(),
        }  
        recoveryThread.join();
        assertEquals(meta, new ShardStateMetadata(meta.primary, meta.indexUUID, meta.allocationId, meta.indexDataLocation));
        assertThat(
            public long fileLength(String name) throws IOException {
                    } catch (InterruptedException e) {  
                    relocating ? "sourceNode" : null,
            }
            assertThat(indexShard.getLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                .primaryTermSupplier(config.getPrimaryTermSupplier())
        indexShard.flush(new FlushRequest());  
    }
        } else {
            if (indexShard.state() == IndexShardState.CREATED || indexShard.state() == IndexShardState.RECOVERING) {
        final IndexShard indexShard = newStartedShard(true, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
                )
        );
            .build();  
        final AtomicBoolean shardFailed = new AtomicBoolean(false);
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
            source.refresh("test");
            () -> shard.relocated(relocationRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {})
import org.opensearch.cluster.routing.ShardRoutingHelper;
                        assertThat(indexShard.getPendingPrimaryTerm(), equalTo(newPrimaryTerm));  
    public void testWriteShardState() throws Exception {  
        assertTrue(primary.getIndexer().refreshNeeded());
                Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0).build()  
        final IndexShard shard = newStartedShard(true);  
    /**
            final PlainActionFuture<Releasable> future = new PlainActionFuture<Releasable>() {
            protected void doRun() throws Exception {
                );
        }
            otherShard.getOperationPrimaryTerm(),
            } else {
        assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(newMaxSeqNoOfUpdates));
    }
            .build();
                Releasables.close(operation2);
            EMPTY_EVENT_LISTENER,
            TimeValue.timeValueMinutes(1L)
            @Override  
            primarySettings,
        assertThat(relocated.get(), equalTo(true));
        IndexingStats indexingStats = newShard.indexingStats();
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    public void testSnapshotWhileResettingEngine() throws Exception {
            .build();  
        assertThat(shard.docStats().getCount(), equalTo(numDocs));
                    results.setOnce(threadId, Tuple.tuple(Boolean.FALSE, e));  
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
            .build();
        closeShards(indexShard);
            long opPrimaryTerm = replica.getOperationPrimaryTerm() + 1;
        for (long i = 0; i < numDocs; i++) {  
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
        assert localCheckpoint == indexShard.getLocalCheckpoint();  
            indexShard.engineConfigFactory,
                SnapshotId snapshotId,  
        final IndexShard shard = newStartedShard(true);
        Settings primarySettings = Settings.builder()  
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        closeShards(primary);  
        try {  
        indexDoc(primary, "_doc", "2", "{\"foo\" : \"bar\"}");
            .build();  
        IndexMetadata metadata = IndexMetadata.builder("test")  
        }
         * gaps are filled.  
            expectThrows(AlreadyClosedException.class, () -> indexShard.storeStats());
            warmerBlocking.countDown();
     * Promotes a started replica to primary, driving the primary-replica resync through the supplied syncer. The syncer receives
        routing = ShardRoutingHelper.newWithRestoreSource(
                    indexShard.shardId().getIndexName(),
                barrier.await();  
        // start shard and perform index check on startup. It enforce shard to fail due to corrupted index files
                    Settings.builder()
            .settings(  
                }
                @Override
                }
            newShard.markAsRecovering(
        try {  
        final long primaryTerm = indexShard.getPendingPrimaryTerm();  
        assertBusy(() -> assertTrue("a failed resync must fail the shard", shardFailed.get()));
                    ThreadPool threadPool = shard.getThreadPool();
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")  
        assertEquals(2, postIndex.get());
        for (final Thread thread : threads) {
            try {
        );  
            flushShard(shard);
        proceedWithRecoveryLatch.countDown();
        );
                        0,
                indexShard.flush(new FlushRequest());  
import static org.hamcrest.Matchers.hasToString;
            }
        // check time advances  
                    totalTranslogOps,  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\", \"fielddata\": true }}}")
        indexDoc(shard, "_doc", "test");
                EMPTY_EVENT_LISTENER,
                closeDoneLatch.countDown();
            } catch (InterruptedException e) {
        );  
            globalCheckpoint,  
                }  
            if (randomInt(100) < 10) {
        recoverReplica(shard, primary, true, (a) -> null);
            .build();
            error.getMessage(),
                    if (singlePermit) {
                    "otherNode",  
        assertBusy(() -> assertTrue(primary.isSearchIdle()));
        if (globalCheckpointOnReplica == UNASSIGNED_SEQ_NO && globalCheckpoint == UNASSIGNED_SEQ_NO) {  
            shard.getLastKnownGlobalCheckpoint(),
    }
                    assertEquals(0, storeFileMetadatas.recoveryDiff(readMeta).different.size());
        Settings settings = Settings.builder()
            )
        IndexShard shard = newShard(false, segRepSettings, customFactory);
        final IndexShard replicaShard = newShard(shardId, false);
    }  
     */
        assertThat(before.getMemorySizeInBytes(), equalTo(0L));
                                    lease.id(),  
        }
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    routing.currentNodeId(),
            shardRouting,
        }  
        closeShards(indexShard);
        corruptedMarkerCount.set(0);
            }
 * ownership. Elasticsearch licenses this file to you under  
                    );
            final IndexShard newShard = reinitShard(targetShard);
            primary.getLastSearcherAccess()
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        assertTrue(primary.scheduledRefresh());
        primaryShard.updateGlobalCheckpointForShard(replicaAllocationId, replicaGlobalCheckpoint);  
        barrier.await();
            this.localCheckpoint = localCheckpoint;
            );  
        store.incRef();
    public void testIsSearchIdle() throws Exception {
                shard.shardId(),
        recoveryThread.join();
        closeShards(shard);
            primary.awaitShardSearchActive(aBoolean -> {});
        assertNull("periodic flush task must not start before an engine exists", primary.getPeriodicFlushTask());  
        closeShard(shard, false);  
            shardId,  
        // complete recovery/relocation
                return FileVisitResult.CONTINUE;  
                }, listener::onFailure));
            .build();
        StreamInput in = out.bytes().streamInput();
import java.nio.file.SimpleFileVisitor;
        IndexMetadata metadata = IndexMetadata.builder("test")  
        assertEquals(replayedOps, newShard.recoveryState().getTranslog().recoveredOperations());
        assertThat(shard.refreshStats().getTotal(), equalTo(initialRefreshes));  
            when(behindStat.getCurrentReplicationTimeMillis()).thenReturn(0L);
                metadata,  
    public void testRecordsForceMerges() throws IOException {
                        } catch (final BrokenBarrierException | InterruptedException e) {  
            assertBusy(() -> {
            settings,  
        CountDownLatch snapshotCompletedLatch = new CountDownLatch(1);  
            .build();
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
            indexShard,  
                SeqNoFieldMapper.TOMBSTONE_NAME  
                        onResponse.set(true);
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
    public void testRecoveryFailsAfterMovingToRelocatedState() throws InterruptedException, IOException {  
            }  
        try {
        assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
                .mergePolicy(config.getMergePolicy())
        primary.addRefreshListener(doc.getTranslogLocation(), r -> latch1.countDown());  
            Collections.singleton(replicaRouting.allocationId().getId()),  
        );
            () -> indexShard.relocated(targetAllocationId, primaryContext -> {}, () -> {})
        if (globalCheckpoint < maxSeqNo) {
    }
                } finally {
            new ActionListener<Releasable>() {
        CountDownLatch latch = new CountDownLatch(1);
    class Result {  
            closeShards(newShard);
    }
            .settings(settings)
        try {
        IndexShardTestCase.updateRoutingEntry(primarySource, primarySource.routingEntry().relocate(randomAlphaOfLength(10), -1));  
        primaryShard.maybeSyncGlobalCheckpoint("test");  
        CountDownLatch latch = new CountDownLatch(1);
                            throw new RuntimeException(e);
                        1,
            latch.countDown();
        IndexMetadata updated = IndexMetadata.builder(current)
        latch.await();  
        assertThat(
            }  
        shard.applyIndexOperationOnReplica(
        assertTrue(primary.scheduledRefresh());  
            newShardRouting(
        updatePeriodicFlushInterval(primary, "1m");  
        return shard.getIndexerOrNull();  
                                try {
        engineResetLatch.await();
                        indexShard.getLastKnownGlobalCheckpoint(),
        );
        assertDocs(source, "1", "2");  
        assertEquals(getEngine(primaryShard).getClass(), InternalEngine.class);
            .primaryTerm(0, 1)  
        assertEquals(0, indexingStats.getTotal().getIndexFailedCount());
    ) {
        final int replicaLocalCheckpoint = randomIntBetween(0, Math.toIntExact(checkpoint));  
            }
        assertEquals(0, postDelete.get());
    }
        );
                try {
        assertDocCount(newShard, totalOps);
        final ShardId shardId = new ShardId("index", "_na_", 0);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                UUIDs.randomBase64UUID(),  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
                    case FAILURE:  
            SegmentReplicationShardStats behindStat = mock(SegmentReplicationShardStats.class);
        Files.walkFileTree(indexPath, corruptedVisitor);
                    public void onFailure(Exception e) {
        );
        assertEquals(100.0f, newShard.recoveryState().getTranslog().recoveredPercent(), 0.01f);
        }
            new NoneCircuitBreakerService(),  
                ThreadPool.Names.SAME,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                        assertThat(indexShard.getLastKnownGlobalCheckpoint(), equalTo(newGlobalCheckPoint));  
    public void testFreezeForTiering_NonDfaEngine_ThrowsUnsupported() throws IOException {
            }
                ThreadPool.Names.GENERIC,
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        long primaryTerm = shard.getOperationPrimaryTerm();
        indexDoc(test, "_doc", "test");  
                () -> indexShard.acquirePrimaryOperationPermit(null, ThreadPool.Names.WRITE, "")  
                    warmerStarted.countDown();
        );
        assertThat(shard.refreshStats().getExternalTotal(), equalTo(shard.refreshStats().getTotal() - 2 - extraInternalRefreshes));
        final String thirdForceMergeUUID = ((InternalEngine) ((EngineBackedIndexer) shard.getIndexer()).getEngine()).getForceMergeUUID();
            UUID.randomUUID().toString(),
    }
            .shardPath(shard.shardPath())
                    indexShard.getLocalCheckpoint()  
        final AtomicReference<Exception> onFailure = new AtomicReference<>();
 *
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardRouting.getIndexName()).settings(settings).primaryTerm(0, 1);  
        IndexShard indexShard = newStartedShard();  
        );
            globalCheckpoint,
                    ? "generic"
            if (Arrays.asList(storeDirectory.listAll()).contains(file) && storeDirectory.getPendingDeletions().contains(file) == false) {
        shard.markSeqNoAsNoop(1, primaryTerm, "test");  
        ShardRouting searchReplicaShardRouting = TestShardRouting.newShardRouting(
        } catch (AlreadyClosedException e) {
import static org.hamcrest.Matchers.everyItem;  
        testRestoreShardFromRemoteStore(false);
            RetentionLeaseSyncer.EMPTY,  
        otherShard.applyIndexOperationOnReplica(
                        assertThat(indexShard.getOperationPrimaryTerm(), equalTo(primaryTerm + increment));
            .build();  
                    );
        assertEquals(remoteTranslogTransferTracker.getTotalUploadsSucceeded(), remoteTranslogStats.getTotalUploadsSucceeded());  
            indexShard.updateShardState(primaryRouting, newPrimaryTerm, (shard, listener) -> {
        closeShards(shard);
        final IndexShard targetShard;  
        CountDownLatch readyToSnapshotLatch = new CountDownLatch(1);
        closeShards(shard);
        Store.MetadataSnapshot storeFileMetadatas = newShard.snapshotStoreMetadata();
            () -> newStartedShard(p -> replicaCorrupted, true)
        assertDocCount(newShard, 1);
                final List<Translog.Operation> operations,
        Directory storeDirectory = target.store().directory();  
        done.set(true);  
        Thread snapshotter = new Thread(() -> {  
        final int operations = scaledRandomIntBetween(1, 64);  
            IOException ex = expectThrows(IOException.class, () -> spyShard.waitForReplicaSync(TimeValue.timeValueMillis(600)));  
        assertThat(getShardDocUIDs(shard), containsInAnyOrder("doc-0", "doc-1"));
    public void testShardStats() throws IOException {
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            .build();  
        } while (primary.isSearchIdle());  
        }, Assert::assertNotNull), TimeValue.timeValueMinutes(1L));
        Thread relocationThread = new Thread(new AbstractRunnable() {
        assertEquals(1, postIndexCreate.get());  
            shardRouting,
                        .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "seg-repo")
                thread.join();  
                    public void onFailure(Exception e) {
        AtomicReference<Supplier<IOException>> exceptionToThrow = new AtomicReference<>();
import static org.mockito.Mockito.times;  
                    )
            indicesFieldDataCache,
        closeShards(newShard);
                );
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        // recovery can be now finalized
                indexShard.updateGlobalCheckpointOnReplica(newGlobalCheckpoint, "test");
        }
        closeShards(indexShard);
        BytesStreamOutput out = new BytesStreamOutput();  
            IndexShardClosedException.class,  
    }
        recoveryEmptyReplica(indexShard, randomBoolean());  
        IndexShardTestCase.updateRoutingEntry(shard, toNode1);
        snapshotter.join();
                .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
     * Verifies the primary-only assertion on {@code freezeForTiering}: tiering preparation is  
        );
                });
            protected void doRun() throws Exception {
                            } catch (final InterruptedException e) {
                readyToCloseLatch.await();  
        closeShard(primaryShard, false);
            1,  
        AtomicReference<Exception> relocationException = new AtomicReference<>();  
                    sourceToParse
            final long newPrimaryTerm = indexShard.getPendingPrimaryTerm() + between(1, 1000);
                    assertThat(indexShard.getPendingPrimaryTerm(), equalTo(promotedTerm));
        String remoteStorePath = createTempDir().toString();  
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
            }  
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
import org.opensearch.index.fielddata.IndexFieldDataService;
        if (randomBoolean()) {
        final IndexShard shard = newStartedShard(true);
                }
        IndexShard shard = newStartedShard();
                        primary.getPendingPrimaryTerm(),
        String xContent = builder.toString();  
    public void testFailIfIndexNotPresentInRecoverFromStore() throws Exception {  
            null
            searchReplicaShardRouting,
        CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
                indexShard.sync(); // advance local checkpoint
        CountDownLatch latch1 = new CountDownLatch(1);
        expectedSubSequence.append("\",\"is_custom_data_path\":").append(shard.shardPath().isCustomDataPath()).append("}");
                replicaRouting.shardId(),  
            new IndexShardRoutingTable.Builder(primaryRouting.shardId()).addShard(primaryRouting).build(),
                    docsStats.getTotalSizeInBytes(),
     */
                shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
            Settings.EMPTY,  
            latch.await();
        ShardStats stats = new ShardStats.Builder().shardRouting(shard.routingEntry())
        tracker.addUploadBytesFailed(10L);
                new IndexId("test", UUIDs.randomBase64UUID(random()))
                postIndexException.incrementAndGet();  
            target.getReplicationTracker()
                    barrier.await();
            }
        IndexShardTestCase.updateRoutingEntry(shard, routing);  
                    + toNode1.getTargetRelocatingShard().allocationId().getId()
            )
                )
            assertTrue(recoveryState.getIndex().fileDetails().size() > 0);
                    operations,
                    }
        // Safe to remove without impacting the test
        closeShards(replica);  
                    () -> {}
    private ShardRouting promoteReplicaWithPendingResync(IndexShard replica) throws Exception {
            if (randomBoolean()) {
                }
        shard.applyDeleteOperationOnReplica(1, primaryTerm, 2, "id", null);  
            new ClusterService(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS), threadPool),  
            shard.getRetentionLeaseSyncer(),
                indexShard.getPendingPrimaryTerm(),
import java.util.Collections;
                    n -> new Translog.Index(
        );
                }  
        updatePeriodicFlushInterval(primary, "30s");
        shard.prepareForIndexRecovery();
            doReturn(Set.of(inSyncStat)).when(spyShard).getReplicationStatsForTrackedReplicas();
        } catch (InterruptedException e) {  
        for (Thread thread : threads) {  
        );  
        assertThat(shard.getActiveOperationsCount(), equalTo(0));
        assertThat(exception2.getCause().getMessage(), equalTo(corruptionMessage + " (resource=preexisting_corruption)"));
            .settings(settings)  
                e -> fail(e.toString()),
import org.opensearch.indices.recovery.RecoverySettings;
        final ShardId shardId = new ShardId("test", "_na_", 0);
import org.opensearch.cluster.routing.TestShardRouting;  
    public void testRejectOperationPermitWithHigherTermWhenNotStarted() throws IOException {
                @Override  
        recoverShardFromStore(shard);
        assertDocs(primary, "1", "2");
        assertThat(readonlyShard.docStats().getCount(), equalTo(numDocs));
            primary.getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
                indexShard.flush(new FlushRequest());  
                            public void onFailure(Exception e) {
     * the shard and the wrapped resync listener and decides whether to leave it pending, complete it, or fail it. Waits until the  
            indexMetadata,
        } finally {
            primaryTarget.getReplicationTracker()
            assertTrue(ex.getMessage().contains("failed to fetch index version after copying it over"));
     * download (which may reuse local generations) and the discard of a local copy proven corrupt. The two must agree:  
            2,  
import org.junit.Assert;
        closeShards(primaryShard);  
                assertThat(indexShard.getLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                        "{\"foo\" : \"bar\"}".getBytes(Charset.forName("UTF-8")),  
        AtomicBoolean stop = new AtomicBoolean(false);  
    public void testPrimaryHandOffUpdatesLocalCheckpoint() throws IOException {  
    public void testRecoverFromStalePrimaryForceNewHistoryUUID() throws IOException {  
                assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(primaryTerm));
                    relocating ? randomBoolean() : false,  
import static org.hamcrest.Matchers.notNullValue;
import org.apache.lucene.tests.store.BaseDirectoryWrapper;  
                equalTo(1L)
        final int maxSeqNo = result.maxSeqNo;  
import org.opensearch.index.engine.exec.Indexer;
            if (!rarely() || i == operations - 1) { // last operation can't be a gap as it's not a gap anymore
            "node",
                    onFailure.set(true);
            indexShard.engineConfigFactory,  
            shard,
    }
        // try to start shard on corrupted files
        assertEquals(0, postDeleteException.get());  
        stop.set(true);
        final String info
        target.restoreFromRepository(new RestoreOnlyRepository("test") {
    public void testAcquirePrimaryAllOperationsPermits() throws Exception {
        final ShardRouting replicaRouting = indexShard.routingEntry();
                ActionListener<Void> listener
                "peer",  
    }
                public void onResponse(Releasable releasable) {  
        final int replicaGlobalCheckpoint = randomIntBetween(
        closeShards(indexShard);
        });  
            .build();  
        Thread snapshotThread = new Thread(() -> {  
        recoverShardFromStore(newShard);  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        assertEquals(shard.shardPath().getRootDataPath().toString(), stats.getDataPath());
                SeqNoFieldMapper.NAME,
import org.opensearch.index.translog.RemoteTranslogStats;
        /*
                    case SUCCESS:  
        assertEquals(shardStateMetadata, getShardStateMetadata(shard));
                    assertTrue(searcher.getIndexReader().numDocs() <= docsStats.getCount());  
import org.apache.logging.log4j.Logger;  
        ) {
        shard.acquireAllReplicaOperationsPermits(  
            indexDoc(indexShard, "_doc", Long.toString(i), "{}");
            }
            );
                public void onResponse(final Releasable releasable) {
import java.util.concurrent.Semaphore;  
                    assertThat(storeFileMetadatas.recoveryDiff(readMeta).different.size(), equalTo(0));  
        assertTrue(uploadFiles.containsAll(lastCommitedSegmentsInSource));
                future.actionGet();
        assertEquals(shard.fieldData().stats("foo").getEvictions(), before.getEvictions());  
            @Override
                } finally {  
        final long globalCheckpoint,
            case 2: {
        closeShards(newShard, shard);  
            indexShard.indexerFactory,  
        // refresh on: finalize and end of recovery  
            // to retry in the future while being filtered from listAll invocations.
                    Translog.Snapshot snapshot = TestTranslog.newSnapshotFromOperations(operations);  
            IndexShardTestUtils.getFakeDiscoveryNodes(primaryRouting)
        tracker.incrementRejectionCount();
        // Re-enabling starts a fresh task.
            indexMetadata,
                            barrier.await();
        final long globalCheckpointOnReplica = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
    public void testExternalRefreshMetric() throws IOException {
        IndexShard replica = newShard(primary.shardId(), false, "n2", metadata, null);
                resyncDispatched.countDown();
                    );
        recoverShardFromStore(replica);  
        assertThat(e.getMessage(), containsString("primary relocation is forbidden while primary-replica resync is in progress"));
                } finally {
        assertDocs(replica, "1", "2");
        }
        }
        final String secondForceMergeUUID = ((InternalEngine) ((EngineBackedIndexer) shard.getIndexer()).getEngine()).getForceMergeUUID();
                    corruptedMarkerCount.incrementAndGet();
                    docsStats.getTotalSizeInBytes(),  
     * Verifies {@code onMergesDrained} now throws {@link UnsupportedOperationException} on a non-DFA
            // swallowing the exceptions and moving the file to a pending delete state  
                threads[j] = new Thread(() -> {  
        assertEquals(translogOps, newShard.recoveryState().getTranslog().totalOperationsOnStart());
                    )
            // recovery can only be finalized after we release the current primaryOperationLock
            // OK!  
    private static void assertRemoteSegmentStats(
                }
                try (GatedCloseable<IndexCommit> wrappedSafeCommit = shard.acquireSafeIndexCommit()) {
            throw new RuntimeException(e);
            @Override
import org.apache.lucene.index.SegmentInfos;
                            public void onFailure(final Exception e) {
                IndexId indexId,
            RetentionLeaseSyncer.EMPTY,  
        AtomicBoolean done = new AtomicBoolean();
            new RecoverySource.RemoteStoreRecoverySource(
     * @throws IOException if an I/O exception occurs while indexing on the shard
        shard.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
        assertTrue(remoteStoreIndex.isRemoteTranslogStoreEnabled());
    }
            final CountDownLatch latch = new CountDownLatch(1);
            if (engineClosed == false) {
        store.decRef();
        );  
        final int delayedOperations = scaledRandomIntBetween(1, 64);
        assertFalse("a successful resync must not fail the shard", shardFailed.get());  
        if (randomBoolean()) {
        final AtomicBoolean stop = new AtomicBoolean();
                indexDoc(indexShard, "_doc", Integer.toString(i), doc);  
                        opPrimaryTerm,
                try (GatedCloseable<IndexCommit> wrappedIndexCommit = shard.acquireLastIndexCommit(randomBoolean())) {
        );
                SeqNoFieldMapper.PRIMARY_TERM_NAME,
        final Releasable operation2;  
                // our operation should still be blocked
    /**  
            final Thread thread = new Thread(() -> {
        assertEquals(lastSearchAccess, primary.getLastSearcherAccess());
            randomAlphaOfLength(10),  
        AtomicBoolean throwWhenMarkingStoreCorrupted = new AtomicBoolean(false);  
            ActionListener<Releasable> onLockAcquired = new ActionListener<Releasable>() {
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                        ""  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
                @Override
            shard.shardPath(),  
        assertFalse(replica.isActive());
        );
            } else {
        IndexerFactory customFactory = new EngineBackedIndexerFactory(config -> new InternalEngine(config, new TranslogEventListener() {
                } catch (IOException e) {  
        primaryShard.updateLocalCheckpointForShard(replicaShard.shardRouting.allocationId().getId(), primaryShard.getLocalCheckpoint());
    public void testShardActiveDuringPeerRecovery() throws IOException {  
import org.opensearch.cluster.node.DiscoveryNode;
        indexOnReplicaWithGaps(shard, between(0, 1000), Math.toIntExact(shard.getLocalCheckpoint()));
        newShard.markAsRecovering("store", new RecoveryState(routing, localNode, null));  
            IndexShardRecoveryException.class,
            indexShard,
     * @param offset     the starting sequence number  
    public void testReaderWrapperIsUsed() throws IOException {
            assertEquals(1, searcher.getIndexReader().numDocs());
                } finally {  
            }
        IndexShard newShard = newShard(
import org.opensearch.common.lease.Releasable;
        }
        IndexShard test = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
            primarySettings,  
                threads[j].start();  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
                    }
            public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
                .tombstoneDocSupplier(config.getTombstoneDocSupplier())  
                    )  
     * completes within 5 seconds.
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            shardId,  
            fut,  
                Supplier<IOException> ex = exceptionToThrow.get();
            final CyclicBarrier barrier = new CyclicBarrier(2);
     */
            new RecoverySource.SnapshotRecoverySource(  
            @Override
        expectedSubSequence.append(shard.shardPath().getRootDataPath().toString());
            null,
        Store targetStore = target.store();  
            null
                });
            .settings(
import org.apache.lucene.tests.mockfile.ExtrasFS;
            shard.getIndexerFactory(),
        assertFalse(primary.isSearchIdle());  
                String doc = XContentFactory.jsonBuilder()
    public void testSupplyTombstoneDoc() throws Exception {
                        "1",
    }  
            shard.shardPath(),  
                }  
        );  
        tracker.incrementTotalUploadsSucceeded();
            } catch (InterruptedException e) {
        target = reinitShard(target, routing);
            } else {
                    docsStats.getTotalSizeInBytes(),
            opPrimaryTerm,  
            "store index should be corrupted",  
                }  
        assertEquals(1, postDelete.get());
        snapshot = newShard.snapshotStoreMetadata();
    /**  
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
        RemoteSegmentTransferTracker remoteSegmentTransferTracker = shard.getRemoteStoreStatsTrackerFactory()
        updatePeriodicFlushInterval(primary, "30s");
        assertDocs(target, "1", "2");  
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNoOfUpdatesOrDeletesBeforeRollback));
         * - roll generation (to create gen 2)
                new RecoveryState(
        Settings settings = Settings.builder()
            @Override
        IndexShard shard = newStartedShard(p -> newShard(true, publisher), true);
        recoverShardFromStore(primary);
            shard.updateLocalCheckpointForShard(shard.shardRouting.allocationId().getId(), totalOps - 1);
        IndexShard replica = newShard(
            newRouting,
        // but index can't be opened for a failed shard
        assertDocs(replica, "1", "2");
                    true,
                    shardId,  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(1, postIndexCreate.get());  
        for (int i = 0; i < nbTermUpdates; i++) {
                        randomNonNegativeLong(),
        Result(final int localCheckpoint, final int maxSeqNo) {
            .build();
                    assertTrue(searcher.getIndexReader().numDocs() <= docStats.getCount());
            .primaryTerm(0, 1);  
            };
            replica.engineConfigFactory,
        final Exception e;
        final AtomicBoolean invoked = new AtomicBoolean();
                    ThreadPool.Names.WRITE,
                onLockAcquired,
        // Flushing a new commit with local checkpoint=1 allows to skip the translog gen #1 in recovery.
        Settings segRepSettings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        // Periodic flush task should not be started
    /**
        assertTrue("Expected no results, operations are blocked", results.asList().isEmpty());
            shardRouting,
        IndexFieldDataService indexFieldDataService = new IndexFieldDataService(  
        final long opPrimaryTerm,
            false,
            .primaryTerm(0, 1)  
        } else {
            true,
        shard.flush(new FlushRequest().force(true).waitIfOngoing(true));  
import org.opensearch.index.fielddata.IndexFieldData;
    }
        final CountDownLatch latch = new CountDownLatch(2);
        assertThat(indexShard.getLocalCheckpoint(), equalTo((long) maxSeqNo));
    }
        IndexMetadata current = shard.indexSettings().getIndexMetadata();
        // which it must only do once the shard has finished transitioning to primary (otherwise state is still CLOSED and the  
        assertTrue("more than one unique hashcode expected but got: " + hashCodes.size(), hashCodes.size() > 1);
    }  
            indexShard.getPendingPrimaryTerm() + 1,
        final ShardRouting primaryRouting = promoteReplicaWithPendingResync(indexShard);  
            latch.await();  
    public void testRelocatedForRemoteTranslogBackedIndexWithAsyncDurability() throws IOException {
/**
                    ShardRoutingState.INITIALIZING,
            searchReplicaShardPath,  
            indexMetadata,  
        List<Translog.Operation> operations = new ArrayList<>();
        expectedSubSequence.append(shard.shardPath().getRootStatePath().toString());
        IndexShardTestCase.updateRoutingEntry(shard, routing);
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
        IndexMetadata metadata = IndexMetadata.builder("test")  
import org.opensearch.index.engine.EngineConfig;
        IndexShard shard = newStartedShard(true);
    }
        }  
        };  
        recoverFromStore(primary);
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
                postDeleteException.incrementAndGet();
                },
        } else {  
        stats = new ShardStats(in);  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        builder.startObject();  
            replayedOps = 3;
                }, listener::onFailure));  
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), randomFrom("false", "true", "checksum"))  
                @Override
     * the catalog snapshot files should match the remote uploaded files, making the method return true.  
        final Releasable operation1;
    @Override
                            @Override
import java.util.Map;
        // Override two Directory methods to make them fail at our will
        final String initialForceMergeUUID = ((InternalEngine) ((EngineBackedIndexer) shard.getIndexer()).getEngine()).getForceMergeUUID();
        assertThat(getShardDocUIDs(newShard), containsInAnyOrder("doc-0", "doc-2"));
                    ShardRoutingState.RELOCATING,
    public void testIndexingOperationListenersIsInvokedOnRecovery() throws IOException {
            1,
            assertThat(shard.refreshStats().getTotalTimeInMillis(), greaterThanOrEqualTo(initialTotalTime));
        try {
            if (randomBoolean()) {
            return null;
            store.markStoreCorrupted(new IOException(corruptionMessage));  
            assertThat(onFailureException.get(), hasToString(containsString("operation primary term [" + oldPrimaryTerm + "] is too old")));
        allPermitsTerminated.countDown();
        Engine.IndexResult doc = indexDoc(primary, "_doc", "1", "{\"foo\" : \"bar\"}");
        closeShards(newShard);  
            ShardStateMetadata state2 = new ShardStateMetadata(primary, "fooUUID", allocationId);
        assertEquals(IndexShard.OPERATIONS_BLOCKED, indexShard.getActiveOperationsCount());
        results.asList().forEach(result -> {  
        final IndexShard indexShard;  
    public void testRestoreLocalHistoryFromTranslogOnPromotion() throws IOException, InterruptedException {
     * Randomizes the usage of {@link IndexShard#acquireReplicaOperationPermit(long, long, long, ActionListener, String, Object)} and
            .put(primarySettings)  
        IndexShardTestCase.updateRoutingEntry(shard, routing);  
import org.opensearch.index.engine.EngineConfigFactory;  
                    } catch (InterruptedException e) {
                    "Estimated total document size is too large compared with the stored size",
            .build();
        }  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);  
            shard,  
            TimeValue.timeValueMinutes(1L)
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
                        -1  
                    }  
                true,
            final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
     */  
     *  
                indexShard.updateLocalCheckpointForShard(indexShard.routingEntry().allocationId().getId(), indexShard.getLocalCheckpoint());  
            assertThat(ex.getMessage(), containsString("max checkpoints behind: 3"));  
                relocationStarted.await();
        final IndexMetadata indexMetadata = replica.indexSettings().getIndexMetadata();  
        assertEquals(1, preDelete.get());  
     * relocate, and it does so without failing the shard.
        }
        assertNull(primary.getPeriodicFlushTask());
            final long numDocs = randomIntBetween(2, 32); // at least two documents so we have docs to delete
        } while (primary.isSearchIdle());  
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");  
        final Path indexPath = shardPath.getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
                        break;
                        latch.countDown();
        }
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
                Settings.builder()
     * Covers the defensive null-check branches in {@code acquireLastIndexCommit},
            )
        closeShards(source);
        closeShards(shard);  
            @Override
        IndexMetadata metadata = IndexMetadata.builder("test")
        closeShards(shard);
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
        assertTrue(indexShard.isRelocatedPrimary());
            IndexShardRecoveryException.class,
        final IndexShard shard = newStartedShard(true);
                final long maxAutoIdTimestamp,
import org.opensearch.index.engine.exec.IndexerFactory;  
    }
            }),
                            )
        final IndexShard indexShard = newStartedShard(false);
                ShardRouting routing = indexShard.routingEntry();
        Set<String> docBelowGlobalCheckpoint = getShardDocUIDs(shard).stream()  
            }
        );
        flushShard(source); // only flush source
                    indexShard.getMaxSeqNoOfUpdatesOrDeletes(),
            true,  
        CountDownLatch latch = new CountDownLatch(thread.length);
            false,
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        snapshotter.start();
                @Override
        indexShard.acquireReplicaOperationPermit(
        assertEquals(remoteTranslogTransferTracker.getTotalUploadsStarted(), remoteTranslogStats.getTotalUploadsStarted());
        final CountDownLatch startRecovery = new CountDownLatch(1);  
                        public void onResponse(Releasable releasable) {
        Settings primarySettings = Settings.builder()
     * Verifies {@code freezeForTiering} now throws {@link UnsupportedOperationException} on a non-DFA
            Engine.GetResult getResult = newShard.get(new Engine.Get(false, false, "1", new Term(IdFieldMapper.NAME, Uid.encodeId("1"))))  
        IndexShard shard = newStartedShard();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                    shardId,
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())  
            .settings(settings)
        indexDoc(shard, "_doc", "1", "{\"foobar\" : \"bar\"}");  
                    relocating ? AllocationId.newRelocation(AllocationId.newInitializing()) : AllocationId.newInitializing()
                        MapperParsingException.class,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
            isPrimaryMode = true;
        primary.state = IndexShardState.RECOVERING; // translog recovery on the next line would otherwise fail as we are in POST_RECOVERY  
        closeShards(shard);
            true,  
        assertThat("store has to be marked as corrupted", corruptedMarkerCount.get(), equalTo(1));  
            // Spy on the shard to simulate a replica that's already in sync
        );  
        closeShards(target);
            shardRouting,  
     */
                        }
                    assertThat(onFailure.get(), instanceOf(AlreadyClosedException.class));
        final IndexShard indexShard = newStartedShard(true);  
            int numDoc = randomIntBetween(100, 200);  
    public void testPrimaryRelocationBlockedWhilePrimaryReplicaResyncIsPending() throws Exception {  
            // now loop until we are fast enough... shouldn't take long
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            EMPTY_EVENT_LISTENER,  
        assertEquals(1, preDelete.get());
        assertThat(getShardDocUIDs(indexShard), equalTo(docsBeforeRollback));  
            primary.acquireSearcher("test").close();
                latch.countDown();
            when(behindStat.getBytesBehindCount()).thenReturn(26600000000L);
        assertTrue(lastSearchAccess < primary.getLastSearcherAccess());  
        );
                        throw new RuntimeException(ex);
                }
            closeShards(indexShard);  
        assertTrue(blocked.get());  
            when(replicatingStat.getBytesBehindCount()).thenReturn(0L);
    public void testReadOnlyReplicaEngineConfig() throws IOException {  
    public void testResetEngineWithBrokenTranslog() throws Exception {
        if (shardRouting.primary() == false && Assertions.ENABLED) {  
        IndicesFieldDataCache indicesFieldDataCache = new IndicesFieldDataCache(
        indexShard.relocated(relocatingRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
        IndexShard shard = newStartedShard();
                }
        );
        AtomicBoolean relocated = new AtomicBoolean();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        final Settings settings = Settings.builder()  
            .put(IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING.getKey(), "1m")
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
    }  
            } else {
                    corruptedMarkerCount.incrementAndGet();
        primary.runTranslogRecovery(
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
            write(state3, env.availableShardPaths(id));
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
                        barrier.await();
            new ShardStateMetadata(meta.primary, meta.indexUUID, meta.allocationId, meta.indexDataLocation).hashCode()
        CountDownLatch proceedWithRecoveryLatch = new CountDownLatch(1);
            thread[i].join();
                    assertListenerCalled.accept(replica);  
            e = expectThrows(
                                } finally {
            currentClusterStateVersion.incrementAndGet(),
        );  
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());  
        // state must defer the task (there is nothing to flush) rather than start it.
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
            true,  
    }
                    IndexShardTestUtils.getFakeDiscoNode(newShard.routingEntry().currentNodeId()),  
            .build();  
                    );
        }
                    try {  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        // Verify getSegmentInfosSnapshot() on the ReadOnlyEngine doesn't block when
        corruptedMarkerCount.set(0);  
                                    assertThat(replica.getPendingPrimaryTerm(), greaterThanOrEqualTo(opPrimaryTerm));
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
                            try {  
    /**
            randomRealisticUnicodeOfCodepointLengthBetween(1, 10),
            }, Assert::assertNotNull),  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
    }
        );
        primary.recoveryState().getTranslog().totalOperations(snapshot.totalOperations());
            final boolean corruptIndexException = randomBoolean();  
        }  
        assertTrue(primary.isSearchIdle());
        Settings replicaSettings = Settings.builder()
        assertEquals(remoteSegmentTransferTracker.getUploadBytesSucceeded(), remoteSegmentStats.getUploadBytesSucceeded());  
            });
                        "2",  
        IndexShard newShard = reinitShard(  
                shard.getOperationPrimaryTerm(),  
                    id,
        latch.await();
                );
            && indexShard.seqNoStats().getMaxSeqNo() != SequenceNumbers.NO_OPS_PERFORMED;  
     */
            }
                RecoveryState recoveryState,  
        final CountDownLatch operationLatch = new CountDownLatch(1);  
                    indexShard.markSeqNoAsNoop(i, indexShard.getOperationPrimaryTerm(), "dummy doc");  
                shard.shardId(),
        indexOnReplicaWithGaps(shard, between(0, 1000), Math.toIntExact(shard.getLocalCheckpoint()));
        final CountDownLatch engineResetLatch = new CountDownLatch(1);
                    shard.store().getMetadata(wrappedIndexCommit.get());
            final CountDownLatch latch = new CountDownLatch(1);  
        long currentMaxSeqNoOfUpdates = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
                    warmerBlocking.await();  
                .warmer(warmer)  
        final IndexShard otherShard = newStartedShard(false);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
            shard.refresh("test");
        indexDoc(shard, "_doc", "0");
                    return super.fileLength(name);
     * and the typed surface fails fast on misconfiguration.  
        final ShardPath shardPath = indexShard.shardPath();  
        // test global ordinals are evicted  
        try {
            indexShard.routingEntry(),  
                public void onResponse(final Releasable releasable) {  
        Settings settings = Settings.builder()
        assertTrue(primary.isSearchIdle());  
                    },  
                indexShard.syncRetentionLeases();
        final long numDocs = between(10, 100);
            final List<Integer> ids = randomSubsetOf(  
                    onFailureException.set(e);
                }
        }  
                shard.shardRouting.currentNodeId(),  
            indexShard.getLastKnownGlobalCheckpoint(),
                        retentionLeases.leases()
        IndexShard indexShard = null;  
                    final MapperParsingException error = expectThrows(
            snapshotThread.start();
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        );
        indexDoc(shard, "_doc", "test");
        assertTrue(primary.getIndexer().refreshNeeded());  
                } else {  
            // temporary override until LUCENE-8735 is integrated
        IndexShard shard = newStartedShard(true);
                        if (result.isCreated()) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.apache.lucene.search.ReferenceManager;
            new ShardStateMetadata(  
        final ShardRouting replicaRouting = TestShardRouting.newShardRouting(
            .collect(Collectors.toSet());  
                    totalTranslogOps,  
         */
            shard.getLastKnownGlobalCheckpoint(),
        }  
                    return super.listAll();  
import org.opensearch.index.mapper.VersionFieldMapper;  
            false,
        snapshot = newShard.snapshotStoreMetadata();  
    }  
        assertEquals(shardStateMetadata, getShardStateMetadata(shard));  
        shard.recoveryState().getIndex().setFileDetailsComplete();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertThat(secondForceMergeUUID, equalTo(firstForceMergeRequest.forceMergeUUID()));
            IndexShardRecoveryException.class,
            );
            assertBusy(() -> assertThat(indexShard.getActiveOperationsCount(), equalTo(0)));
        final IndexShard indexShard = newStartedReplicaWithResyncTimeout(TimeValue.timeValueHours(1));
        closeShards(shard);  
        }
            indexShard.getGlobalCheckpointSyncer(),
            );
            // However, this logic is also buggy and after the first delete attempt we are left in a state where the file is still on disk
                        throw new AssertionError(e);
                shard.relocated(relocationRouting.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertNotEquals(meta, new ShardStateMetadata(!meta.primary, meta.indexUUID + "foo", meta.allocationId, meta.indexDataLocation));
                    readyToCloseLatch.countDown();  
     */
        }
import org.opensearch.repositories.IndexId;
    }
import org.opensearch.indices.recovery.RecoveryState;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        retentionLeases.primaryTerm(),  
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
        assertRemoteSegmentStats(remoteSegmentTransferTracker, remoteSegmentStats);
        assertThat(requestedMappingUpdates.get("_doc").source().string(), equalTo("{\"properties\":{\"foo\":{\"type\":\"text\"}}}"));  
            0L,  
            shard.getOperationPrimaryTerm(),
        closeShards(indexShard);
            assertEquals(search.totalHits.value(), 0);
        final IndexShardRecoveryException indexShardRecoveryException = expectThrows(
                assertThat(indexShard.getPendingPrimaryTerm(), equalTo(primaryTerm));
        try {
            shardPath,
 * Simple unit-test IndexShard related operations.
                assertions.add(() -> assertTrue(invoked.get()));
        futures.forEach(future -> assertTrue(future.isDone()));
            }
         * The flow of this test:
                final int totalTranslogOps,  
        }
        latch.await();
        promoteReplica(
        assertEquals(0, preDelete.get());  
            shardRouting,
        List<ReferenceManager.RefreshListener> refreshListeners = shard.getIndexer().config().getInternalRefreshListener();  
            public void onFailure(Exception e) {  
                    assertThat(error.getMessage(), containsString("failed to parse field [foo] of type [text]"));
        newShard.markAsRecovering("store", new RecoveryState(newShard.routingEntry(), localNode, null));
        assertEquals(versionCreated.luceneVersion, test.minimumCompatibleVersion());
        IndexShard newShard = reinitShard(
    public void testConcurrentAcquireAllReplicaOperationsPermitsWithPrimaryTermUpdate() throws Exception {
        IndexShard shard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, wrapper);
            }
    public void testRelocatedShardCanNotBeRevived() throws IOException, InterruptedException {
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())  
        final ShardRouting newRouting = indexShard.routingEntry().moveActiveReplicaToPrimary();
        }, ThreadPool.Names.GENERIC, "");  
                ).getMessage(),  
     * here we are passing null in place of SegmentReplicationCheckpointPublisher and testing  on index shard if CheckpointRefreshListener is not added to the InternalrefreshListerners List
                    } else {
        final IndexShard source = newStartedShard(true);
        }
        );
    /**
        // failure is skipped as "shutting down").
        assertTrue(flushTask.isScheduled());  
            try {  
     * (currentReplicationTimeMillis > 0), even if checkpoints and bytes behind are zero.  
            indexMetadata,
                        "{\"foo\" : \"bar}".getBytes(Charset.forName("UTF-8")),
                final AtomicBoolean invoked = new AtomicBoolean();  
            ShardRoutingHelper.initWithSameId(shardRouting, RecoverySource.EmptyStoreRecoverySource.INSTANCE)  
import org.opensearch.common.CheckedFunction;  
            "store",
                    } catch (InterruptedException e) {  
        indexDoc(source, "_doc", "2");  
        primary.onSettingsChanged();
            }  
        String remoteStorePath = createTempDir().toString();  
            0L,  
        updateMappings(otherShard, shard.indexSettings().getIndexMetadata());  
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        final ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
    private Releasable acquireReplicaOperationPermitBlockingly(IndexShard indexShard, long opPrimaryTerm) throws ExecutionException,
            target.routingEntry(),  
        assertEquals(0, postIndexException.get());
        indexDoc(shard, "_doc", "1");  
                throw new RuntimeException(e);
        );
                new SourceToParse(shard.shardId.getIndexName(), Long.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON)
        assertThat(getShardDocUIDs(shard), equalTo(docBelowGlobalCheckpoint));  
        thread.start();
                if (operation.opType() == Translog.Operation.Type.NO_OP) {
            Consumer<MappingMetadata> mappingConsumer = mapping -> {
            }  
        IndexShard shard = newStartedShard(true, segRepSettings);  
        indexShard.updateGlobalCheckpointOnReplica(globalCheckpointOnReplica, "test");
            permit.close();
        } catch (IndexShardRecoveryException ex) {
            .build();
    public void testRelocatedShardCanNotBeRevivedConcurrently() throws IOException, InterruptedException, BrokenBarrierException {  
                        indexShard,
        shard.refresh("created segment 1");
    }
     */
        // ensure relocated successfully once pending operations are done
        shard.acquireAllReplicaOperationsPermits(shard.getOperationPrimaryTerm(), globalCheckpoint, 0L, ActionListener.wrap(r -> {  
                public void onFailure(final Exception e) {  
        }
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final IndexShard replica = newShard(  
    public void testRelocateMissingTarget() throws Exception {
        final ShardId shardId = new ShardId("index", "_na_", 0);
        // Task should be closed after shard close
                long localCheckPoint = indexShard.getLastKnownGlobalCheckpoint() + randomInt(100);  
                throw new UnsupportedOperationException("get your numbers straight");
        }  
        } else {
        closeShards(indexShard);  
        );
            .state(IndexMetadata.State.CLOSE)
            RecoverySource.ExistingStoreRecoverySource.INSTANCE  
import java.util.function.BiConsumer;  
                        -1
        final ForceMergeRequest firstForceMergeRequest = new ForceMergeRequest().maxNumSegments(1);  
        assertEquals(initialPeriodicFlushCount + 1, primary.flushStats().getPeriodic());
        final IndexShard shard = newStartedShard(false);  
        closeShards(primary);
        if (randomBoolean()) {
        CountDownLatch latch1 = new CountDownLatch(1);
                assertThat(  
                try {  
import org.opensearch.action.admin.indices.stats.ShardStats;  
            // Should have checked stats exactly once and returned — no polling loop
                if (file.reused()) {  
        );
        assertEquals(1, postIndexCreate.get());
        IndexScopedSettings scopedSettings = primary.indexSettings().getScopedSettings();  
        IndexShard shard = newStartedShard(true, segRepSettings);
            @Override
            new RecoveryState(primary.routingEntry(), IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()), null)  
            boolean primary = randomBoolean();  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())  
            fail("we are already recovering, can't mark again");
            assertThat(indexShard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(maxSeqNo));  
    }  
        IndexShard replica = newShard(  
                        assertThat(TestTranslog.getCurrentTerm(getTranslog(indexShard)), equalTo(newPrimaryTerm));
    }
                        break;
            // Diagnostic accessors remain safe to call.  
        assertEquals(shard.fieldData().stats("foo").getMemorySizeInBytes(), before.getMemorySizeInBytes());
                }
        // Verify periodic flush count increased
        // The timeout must only clear the flag: the promoted primary still accepts writes and can now relocate.
                    for (String file : sourceStore.directory().listAll()) {
        IndexShardTestCase.updateRoutingEntry(newShard, newShard.routingEntry().moveToStarted());
        IndexShard.AsyncShardFlushTask flushTask = primary.getPeriodicFlushTask();
                RecoverySource.ExistingStoreRecoverySource.INSTANCE
            assertEquals("idle non-DFA engine reports 0 active merges", 0, shard.getActiveMergeCount());  
        resyncLatch.await();  
        });  
                // in integration tests, this is done as a listener on IndexService.
                indexDoc(indexShard, "_doc", id);  
        // ensure we wait for all primary operation locks to be acquired
        // this test indexes docs on a primary, refreshes, then recovers a new Search Replica and asserts
            assertTrue(failureCallbackTriggered.get());  
        assertDocs(primary, "1", "2");
        long initialPeriodicFlushCount = primary.flushStats().getPeriodic();
            assertThat(ex.getMessage(), containsString(IndexShard.REPLICA_SYNC_TIMEOUT_MARKER));
            new EngineBackedIndexerFactory(config -> new InternalEngine(config, new TranslogEventListener() {  
        {
            .primaryTerm(0, 1)
        assertEquals(TimeValue.timeValueMinutes(1), flushTask.getInterval());
    /**  
                public void onResponse(final Releasable releasable) {
        assertNotNull(flushTask);
                cyclicBarrier.await();  
        indexDoc(shard, "_doc", "0");
        for (int i = 0; i < delayedOperations; i++) {  
        final ShardId shardId = new ShardId("index", "_na_", 0);
            newMaxSeqNoOfUpdates,
        assertThat(snapshot.getSegmentsFile().name(), equalTo("segments_3"));
            // we might have trimmed some operations if the translog retention policy is ignored (when soft-deletes enabled).  
        EngineTestCase.generateNewSeqNo(getEngine(source)); // create a gap in the history
        source.refresh("test");  
        final IndexShardRecoveryException exception2 = expectThrows(  
            };  
        } catch (AlreadyClosedException e) {
     * {@link IndexShard#resetEngineToGlobalCheckpoint()} does not block on {@code engineMutex}.
        SourceToParse sourceToParse = new SourceToParse(shard.shardId().getIndexName(), "1", new BytesArray("{}"), MediaTypeRegistry.JSON);
        IndexShard shard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        );
            primary.getIndexer(),
                AssertionError.class,
    public void testCheckpointRefreshListener() throws IOException {
            new SourceToParse(shard.shardId().getIndexName(), "id-2", new BytesArray("{}"), MediaTypeRegistry.JSON)
                    )  
        org.opensearch.index.engine.Engine.GetResult getResult = shard.get(
            }
        assertEquals(1, latch.getCount());
        final IndexShard shard = newStartedShard(true);  
        final ShardRouting replicaRouting = indexShard.routingEntry();  
        assertSame(flushTask, primary.getPeriodicFlushTask());
        shard.getIndexer().translogManager().rollTranslogGeneration(); // isolate the delete in it's own generation
        final CountDownLatch latch = new CountDownLatch(1);
        final ShardPath shardPath = shard.shardPath();
        if (globalCheckpoint < maxSeqNo) {
            recoverFromStore(newShard);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
            indexShard.getGlobalCheckpointSyncer(),
        );
            assertThat(after.getMemorySizeInBytes(), equalTo(0L));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
            RetentionLeaseSyncer.EMPTY,  
        );
                    throw ex.get();
        shard.state = IndexShardState.STARTED; // It will generate exception  
                if (throwWhenMarkingStoreCorrupted.get() && ex != null) {  
        barrier.await();  
        // initialize the local knowledge on the primary of the persisted global checkpoint on the primary
        );  
                                    lease.timestamp(),
            assertEquals(2, indexShard.getActiveOperationsCount());
            threads[threadId].start();  
            assertThat(
        assertTrue(recoverFromStore(newShard));  
        assertThat(
    public void testClosedIndicesSkipSyncGlobalCheckpoint() throws Exception {
        IndexShardTestCase.updateRoutingEntry(shard, original);  
        closeShards(indexShard);
            .build();
    }  
                called.set(true);  
        ParseContext.Document deleteDoc = deleteTombstone.docs().get(0);  
        AtomicReference<Exception> cancellingException = new AtomicReference<>();
                    }
        );  
    public void testDoNotTrimCommitsWhenOpenReadOnlyEngine() throws Exception {
            new SourceToParse(shard.shardId().getIndexName(), "id-3", new BytesArray("{}"), MediaTypeRegistry.JSON)  
        closeShards(readonlyShard);  
        Settings settings = Settings.builder()
            public void onResponse(Releasable releasable) {
                .indexSort(config.getIndexSort())
        closeShards(shard);
        closeShard(indexShard, false);  
        assertEquals(shard.fieldData().stats("foo").getEvictions(), before.getEvictions());
        closeShards(shard);
    private static void updatePeriodicFlushInterval(IndexShard shard, String interval) {
            closeShards(indexShard);  
            ),  
                throwWhenMarkingStoreCorrupted.set(randomBoolean());
                assertThat(indexShard.getPendingPrimaryTerm(), equalTo(newPrimaryTerm));
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertTrue(indexShard.isSyncNeeded());  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "txlog-test")  
                        throw new RuntimeException(e);
            shardStateMetadata = load(logger, env.availableShardPaths(id));  
        {  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            primary.shardId,  
        private final int maxSeqNo;
            .retentionLeaseStats(shard.getRetentionLeaseStats())
                assertThat(snapshot.totalOperations(), equalTo(newShard.indexSettings.isSoftDeleteEnabled() ? 0 : 2));  
    public void testSyncSegmentsFromGivenRemoteSegmentStore() throws IOException {
            if (rarely()) {  
        try (GatedCloseable<org.opensearch.index.engine.exec.coord.CatalogSnapshot> snap = shard.getCatalogSnapshot()) {
        }  
        IndexShard shard = newStartedShard(true);  
        latch.await();
            TopDocs search = searcher.search(new TermQuery(new Term("foo", "bar")), 10);  
    }
            expectThrows(UnsupportedOperationException.class, shard::freezeForTiering);
                                    ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE  
import static org.hamcrest.Matchers.not;
            )
        final IllegalIndexShardStateException e = expectThrows(  
        indexDoc(shard, "_doc", "0", "{\"foo\" : \"bar\"}");
            RecoverySource.EmptyStoreRecoverySource.INSTANCE  
                final String id = Integer.toString(i);
            shard.mapperService(),
        assertEquals(1, postDelete.get());
                .queryCachingPolicy(config.getQueryCachingPolicy())
            shard.indexSettings.getIndexMetadata(),
        IndexShard replica = newStartedShard(false);
                    engineResetLatch.countDown();
                        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            SegmentReplicationShardStats inSyncStat = mock(SegmentReplicationShardStats.class);  
            ShardRoutingState.INITIALIZING,
        final long globalCheckpoint = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());  
                assertThat(Thread.currentThread().getName(), containsString(expectedThreadPoolName));
    }
        final AtomicBoolean synced = new AtomicBoolean();
            null  
                RetentionLeaseSyncer.EMPTY,  
                .getLocalCheckpoint(),
        final CountDownLatch allOperationsDone = new CountDownLatch(threads.length);
            () -> synced.set(true),
            IndexShard spyShard = spy(shard);
                            throw new RuntimeException(e);
        replica = reinitShard(replica, searchReplicaShardRouting);  
            // relocation target
        closeShards(target);  
            indexShard.shardPath(),
                if (snapshot != null) snapshot.close();
        sourceShard.refresh("test");
            new EngineBackedIndexerFactory(new InternalEngineFactory())  
        final IndexShardRecoveryException exception1 = expectThrows(  
    }
        AtomicInteger preIndex = new AtomicInteger();
        final Settings settings = Settings.builder()  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            RecoverySource.EmptyStoreRecoverySource.INSTANCE  
            }
            write(state1, env.availableShardPaths(id));  
import org.opensearch.cluster.routing.RecoverySource;
            ShardRoutingState.INITIALIZING,  
                );
        final ShardRouting primaryRouting = newShardRouting(
        Thread recoveryThread = new Thread(() -> {  
     * here we are mocking a SegmentReplicationcheckpointPublisher and testing on index shard if CheckpointRefreshListener is added to the InternalrefreshListerners List
    public void testLockingBeforeAndAfterRelocated() throws Exception {
                    maxSeenAutoIdTimestamp,
        final Snapshot snapshot = new Snapshot("foo", new SnapshotId("bar", UUIDs.randomBase64UUID()));  
        // promote the replica
        ) {
            when(replicatingStat.getCheckpointsBehindCount()).thenReturn(0L);
        assert indexShard.getReplicationTracker().isPrimaryMode() == isPrimaryMode;  
            if (randomBoolean()) {  
import org.opensearch.index.translog.InternalTranslogFactory;
                        } else {
    }  
            .build();
            null,  
        IndexMetadata metadata = IndexMetadata.builder("test")
    }
            replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
                .store(config.getStore())
        assertTrue("engine reset should complete", engineResetLatch.await(30, TimeUnit.SECONDS));
        } catch (RuntimeException ex) {
        for (int i = 0; i < iters; i++) {
import static org.opensearch.common.lucene.Lucene.cleanLuceneIndex;  
            closeShards(differentIndex);  
                        listener.onResponse(r);
        closeShards(primaryShard, replicaShard);
        ((BaseDirectoryWrapper) storeDirectory).setCheckIndexOnClose(false);  
            5,  
                )  
            primaryTerm,
        engineResetLatch.await();  
import org.opensearch.cluster.metadata.IndexMetadata;  
        PlainActionFuture<Releasable> fut = new PlainActionFuture<>();  
                for (int i = 0; i <= localCheckPoint; i++) {
        }
import org.opensearch.action.support.PlainActionFuture;
            closeShards(indexShard);  
        );  
import static org.mockito.Mockito.spy;
        shard.applyIndexOperationOnReplica(
                        1,  
import org.apache.lucene.util.BytesRef;
                invoked.set(true);  
                assertBusy(() -> assertEquals(0, indexShard.getActiveOperationsCount()));
        final long translogGen = engineClosed ? -1 : getTranslog(indexShard).getGeneration().translogFileGeneration;  
                    .put(indexShard.indexSettings.getSettings())
                    assertTrue(onResponse.get());
            }  
    public void testPeriodicFlushTaskStoppedOnDynamicDisable() throws Exception {
                ActionListener<Releasable> listener = new ActionListener<Releasable>() {  
                assertFalse(onResponse.get());
        );  
            indexShard.indexerFactory,  
        closeShards(primary);  
        assertEquals(100.0f, newShard.recoveryState().getTranslog().recoveredPercent(), 0.01f);  
        CountDownLatch warmerStarted = new CountDownLatch(1);  
        closeShards(primary);
        assertFalse(primary.isSearchIdle());  
        logger.info("shard routing to {}", shardRouting);  
    private void randomReplicaOperationPermitAcquisition(
        stats.toXContent(builder, EMPTY_PARAMS);
                Collections.singleton(indexShard.routingEntry().allocationId().getId()),  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
            shard.getGlobalCheckpointSyncer(),  
        assertThat(newShard.getHistoryUUID(), equalTo(historyUUID));
        assertThat(getShardDocUIDs(shard), containsInAnyOrder("doc-0", "doc-1", "doc-2"));
        newShard.close("test", false, false);
import org.opensearch.core.common.io.stream.StreamInput;
            @Override  
                assertThat(indexShard.getLastKnownGlobalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));  
    /**
                Releasables.close(operation2);  
                )
            new ShardId("index_1", "index_1", 0),
            primarySettings,
        assertTrue(future.actionGet());
     * the close thread holds {@code engineMutex} and waits for {@code writeLock}, while the  
        Settings settings = Settings.builder()
    }
    }
            try {
            assertThat(commitStats.getGeneration(), equalTo(2L));
                }  
            Collections.singleton(newRouting.allocationId().getId()),
        recoverShardFromStore(primary);
            }  
            barrier.await();
        closeShards(primary);  
            }
        closeShardThread.start();
            // now loop until we are fast enough... shouldn't take long
        assertTrue(primary.getIndexer().refreshNeeded());
                either(instanceOf(IllegalIndexShardStateException.class)).or(instanceOf(IllegalStateException.class))
                        shard.getPendingPrimaryTerm(),
            ) {
        for (ReferenceManager.RefreshListener refreshListener : target.getIndexer().config().getInternalRefreshListener()) {
        );
                final List<Translog.Operation> operations,
            IndexShardRecoveryException.class,
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));  
        for (int i = 0; i < iters; i++) {
        futures.forEach(future -> assertFalse(future.isDone()));
        final long globalCheckpointOnReplica = randomLongBetween(UNASSIGNED_SEQ_NO, indexShard.getLocalCheckpoint());
            });
        AtomicInteger postDelete = new AtomicInteger();  
            }  
            assertThat("we have to have more than one segment", searcher.getDirectoryReader().leaves().size(), greaterThan(1));
import org.apache.lucene.index.IndexableField;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        thread.join();
            }
            thread.join();
            RecoverySource.ExistingStoreRecoverySource.INSTANCE
            assertEquals(RecoveryState.Stage.DONE, recoveryState.getStage());  
            for (int i = 0; i < numDocs; i++) {
            case 1: {
        } catch (RuntimeException e) {
        AtomicInteger postIndexException = new AtomicInteger();
        final IndexShard shard = newStartedShard(true);
        Settings settings = Settings.builder()  
     * A promoted primary must reject relocation hand-off for as long as its primary-replica resync is pending.
        // extra0 file is added as a part of https://lucene.apache.org/core/7_2_1/test-framework/org/apache/lucene/mockfile/ExtrasFS.html
        IndexShardTestCase.updateRoutingEntry(indexShard, relocatingRouting);
        }  
            final long globalCheckpoint = replica.getLastKnownGlobalCheckpoint();  
            }
            latch.await();
        final int maxSeqNo = randomIntBetween(0, 128);
            wrapper,
            })
        closeShards(shard);
     */
        shard = reinitShard(shard);  
                @Override
            indexThreads[i].start();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT.toString())
        assertThat(shard.refreshStats().getExternalTotal(), equalTo(2L)); // refresh on: finalize and end of recovery
        Files.walkFileTree(indexPath, corruptedVisitor);
            }
     * listener -- if both paths synchronize on {@code engineMutex}, the cycle deadlocks.  
                indexShard.applyIndexOperationOnReplica(  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertDocs(replica, "1", "2");
        shard.refresh("test");
                        getTranslog(indexShard).getGeneration().translogFileGeneration,
            randomAlphaOfLength(10),  
        shard.acquireAllReplicaOperationsPermits(
        final IndexShard indexShard = newStartedShard(true);  
        latch1.await();
        assertTrue(  
                    IndexShardTestUtils.getFakeDiscoNode(newShard.routingEntry().currentNodeId())
            }
        long globalCheckpointOnReplica = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, primaryShard.getLocalCheckpoint());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * promoted to a primary.  
            when(behindStat.getCheckpointsBehindCount()).thenReturn(3L);  
        indexDoc(primary, "_doc", "1", "{\"foo\" : \"bar\"}");
            replicaRouting,
            new IndexShardRoutingTable.Builder(newRouting.shardId()).addShard(newRouting).build(),  
        shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
                    blocked.set(true);
            indexShard.refresh("test");  
        final Thread recoveryThread = new Thread(() -> {
            .settings(settings)
    /**
        final AtomicInteger corruptedMarkerCount = new AtomicInteger();
        snapshotThread.start();
            )
        Collection<String> lastCommitedSegmentsInSource = SegmentInfos.readLatestCommit(source.store().directory()).files(false);  
            }, e -> fail(e.toString()), executorOnDelay, "test");  
                1,
                } catch (final BrokenBarrierException | InterruptedException e) {  
                );  
                @Override  
        long numDocs = randomLongBetween(1, 20);  
    /**  
        final boolean isPrimary = randomBoolean();
                        releasable.close();
                    "local_node",
            replicaSettings,
        for (String file : remoteDirectory.listAll()) {  
                .similarity(config.getSimilarity())
    public void testTieringMergeWrappers_NonDfaEngine_DiagnosticsReportRealValues() throws IOException {  
        assertDocCount(newShard, 1);
        for (int i = 0; i < 30; i++) { // just a sanity check that we impl hashcode
        );
                                operationLatch.await();
        }
        try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
        first.start();
    public void testPeriodicFlushTaskStartedForIngestionIndex() throws Exception {  
import org.opensearch.index.engine.InternalEngine;
                shardRouting,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "because I say so")
                Version.CURRENT,
        } else {
        recoverReplica(primaryTarget, primarySource, true);  
            randomAlphaOfLength(10),
            final long oldPrimaryTerm = indexShard.getPendingPrimaryTerm() - 1;
                // initializing replica / primary  
            shardRouting,  
 * KIND, either express or implied.  See the License for the
                    }
            assertThat(indexShard.getActiveOperationsCount(), is(oneOf(0, IndexShard.OPERATIONS_BLOCKED)));
                shard.close("testing", false, false);
        final CountDownLatch delayedOperationsLatch = new CountDownLatch(delayedOperations);  
            null,  
            randomReplicaOperationPermitAcquisition(
        assertNotNull(shardPath);
        assertTrue(
        recoverShardFromStore(primary);  
            new ShardId("index", "_na_", 0),
                final List<Translog.Operation> operations,
        assertEquals(versionCreated.luceneVersion, test.minimumCompatibleVersion());
        Settings settings = Settings.builder()  
                indexShard.updateRetentionLeasesOnReplica(
        indexDoc(indexShard, "_doc", "0", "{}");
        final boolean isPrimaryMode;
                } catch (final BrokenBarrierException | InterruptedException e) {
        IndexShard indexShard = newShard(false);
            .build();
            primary.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        int bytesStarted = randomIntBetween(100, 1000);
    public void testWaitForReplicaSync_BytesBehindNonZero_TimesOut() throws IOException {
                            postIndexCreate.incrementAndGet();  
         * This operation completing means that the delay operation executed as part of increasing the primary term has completed and the  
        promoteReplicaWithResyncSyncer(indexShard, (shard, resyncListener) -> capturedListener.set(resyncListener));  
                });
        // most of the time this is large enough that most of the time there will be at least one gap
        final IndexMetadata newShardIndexMetadata = IndexMetadata.builder(shard.indexSettings().getIndexMetadata())  
