 *     http://www.apache.org/licenses/LICENSE-2.0
                getTestName(),
                0,
import org.opensearch.common.Numbers;
            between(1, 8),
            ackedChunks.addAll(chunksToAck);
        assertBusy(() -> assertTrue(freed.get()));
        long mappingVersion = randomNonNegativeLong();
        final AtomicInteger sentChunks = new AtomicInteger();
/**
            void phase1(
        String syncId = UUIDs.randomBase64UUID();
            @Override
            randomNonNegativeLong(),
import org.opensearch.common.lease.Releasable;
        };
            ackedChunks.sort(Comparator.comparing(c -> c.chunkNumber));
            @Override
        PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
        }
            ActionListener<Void> listener
        );
                received.set(true);
    recoveries should fail
                org.apache.lucene.util.Version.LATEST
            ) {
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))
            newTranslogSnapshot(operations, Collections.emptyList()),
            endingSeqNo,
import org.junit.After;
            threadPool,
                ActionListener<SendSnapshotResult> listener
                    multiFileWriter.writeFileChunk(md, position, content, lastChunk);
                    listener
            operations.add(op);
            );
            @Override
                ActionListener.completeWith(listener, () -> {
            assertTrue(wasCancelled.get());
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
        final AtomicBoolean phase2Called = new AtomicBoolean();
                () -> randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE)
            @Override
                });
                    cancelRecovery.get().run();
        final IOException unwrappedCorruption = ExceptionsHelper.unwrapCorruption(ex);
        final IndexShard shard = mock(IndexShard.class);
        final TestRecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
                phase2Called.set(true);
    class TestRecoveryTargetHandler implements RecoveryTargetHandler {
            shard,
        final StartRecoveryRequest startRecoveryRequest = getStartRecoveryRequest();
 * GitHub history for details.
        );
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
                    receivedSeqNos.add(operation.seqNo());
                unrepliedChunks.add(new FileChunkResponse(chunkNumber, listener));
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
            randomNonNegativeLong(),
            long position,
                c.listener.onResponse(null);
 * KIND, either express or implied.  See the License for the
        sendFilesFuture.actionGet();
            randomBoolean() || metadataSnapshot.getHistoryUUID() == null ? SequenceNumbers.UNASSIGNED_SEQ_NO : randomNonNegativeLong()
        AtomicBoolean failedEngine = new AtomicBoolean(false);
        ) {
            between(1, 10)
                    checkpointOnTarget.addAndGet(between(1, 20));
        final boolean throwCorruptedIndexException = randomBoolean();
                long maxSeqNoOfUpdatesOrDeletes,
import static org.mockito.Mockito.doAnswer;
        final int expectedOps = (int) (endingSeqNo - startingSeqNo + 1);
        doAnswer(invocation -> {
        SetOnce<Runnable> cancelRecovery = new SetOnce<>();
import org.opensearch.cluster.metadata.IndexMetadata;
        for (StoreFileMetadata md : metadata) {
        writer.close();
            ) {
        );
import org.opensearch.threadpool.ThreadPool;
        final Set<Long> seqNos = new HashSet<>();
        List<StoreFileMetadata> metas = new ArrayList<>();
        };
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
                    startingSeqNo,
        CountDownLatch latch = new CountDownLatch(1);
        });
            }
        assertTrue(failedEngine.get());
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
        Translog.Snapshot snapshot = newTranslogSnapshot(operations, skipOperations);
        for (int i = 0; i < numDocs; i++) {
        final StartRecoveryRequest request = getStartRecoveryRequest();
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
        long maxSeqNoOfUpdatesOrDeletes = randomBoolean() ? -1 : randomNonNegativeLong();
        Store store = newStore(createTempDir(), false);
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        if (localCheckpoint != null) {
                    endingSeqNo,
                    return null;
    private Engine.Index getIndex(final String id) {
        Store store = newStore(tempDir, false);
        }
    }
                BytesReference content,
            int chunksToSend = Math.min(
    public void testThrowExceptionOnNoTargetInRouting() throws IOException {
            maxSeqNoOfUpdatesOrDeletes,
        }
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
            null,
        AtomicBoolean received = new AtomicBoolean();
        AtomicBoolean failedEngine = new AtomicBoolean(false);
        RetentionLeases retentionLeases = new RetentionLeases(randomNonNegativeLong(), randomNonNegativeLong(), Collections.emptySet());
        assertFalse(phase1Called.get());
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            threadPool,
            handler.phase1(
            CRC32 digest = new CRC32();
 */
import java.io.OutputStream;
        assertThat(result.sentOperations, equalTo(expectedOps));
import org.opensearch.index.mapper.SeqNoFieldMapper;
            metas.add(md);
    public void testSendOperationsConcurrently() throws Throwable {
            ) {
import org.opensearch.common.util.CancellableThreads;
        "index",
        }
        ) {}
        }
import org.opensearch.index.seqno.ReplicationTracker;
        final byte[] source = "{}".getBytes(StandardCharsets.UTF_8);
        };
                }
    }
            this.chunkNumber = chunkNumber;
        sendFilesLatch.await();
            between(1, 8),
            }
        assertBusy(() -> assertThat(sentChunks.get(), equalTo(Math.min(totalChunks, maxConcurrentChunks))));
            }
                ActionListener<Long> listener
    }
        final AtomicBoolean wasFailed = new AtomicBoolean();
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        }
                StoreFileMetadata md,
import java.util.Collections;
            void phase1(
                long receivedMappingVersion,
            null,
            null,
        doAnswer(invocation -> {
            )
                    if (operationsToSkip.contains(op)) {
        replyLatch.await();
        final Field versionField = new NumericDocValuesField("_version", Versions.MATCH_ANY);
import org.opensearch.common.UUIDs;
import org.opensearch.index.translog.Translog;
                sentSeqNos.add(op.seqNo());
            assertThat(unrepliedChunks, hasSize(sentChunks.get()));
            new AsyncRecoveryTarget(recoveryTarget, threadPool.generic()),
        AtomicBoolean wasCancelled = new AtomicBoolean();
                ActionListener<Void> listener
            ) throws IOException {
            }
        IndexShard mockShard = mock(IndexShard.class);
            );
        });
                phase2Called.set(true);
        final StartRecoveryRequest request = getStartRecoveryRequest();
            }
    public void testVerifySeqNoStatsWhenRecoverWithSyncId() throws Exception {
            startingSeqNo,
        );
        when(shard.store()).thenReturn(store);
            ) {
                );
        when(replicationGroup.getRoutingTable()).thenReturn(routingTable);
        FileChunkResponse(long chunkNumber, ActionListener<Void> listener) {
            between(1, 5),
        MultiFileWriter multiFileWriter = new MultiFileWriter(targetStore, luceneIndex, "", logger, () -> {});
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
            final List<Translog.Operation> operations,
                int receivedTotalOps,
                if (randomBoolean()) {
        public void receiveFileInfo(
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
    /*
                (p) -> (p.getFileName().toString().equals("write.lock") || p.getFileName().toString().startsWith("extra")) == false
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));
import org.apache.lucene.tests.index.RandomIndexWriter;
        PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
        List<StoreFileMetadata> metas = new ArrayList<>();
        if (wasFailed.get()) {
        };
        for (StoreFileMetadata md : metadata) {
                phase1Called.set(true);
        int numDocs = randomIntBetween(10, 100);
                    cancelRecovery.get().run();
            }
                    }
            if (randomBoolean()) {
            if (randomBoolean()) {
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));
    );
        cancelingThread.join();
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
                }
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        public void indexTranslogOperations(
                recoveryExecutor.execute(() -> listener.onResponse(null));
        int numDocs = between(0, 1000);
import java.util.Arrays;
        IndexShard mockShard = mock(IndexShard.class);
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
 * this work for additional information regarding copyright
            maxConcurrentChunks,
            @Override
        Store.MetadataSnapshot targetStoreMetadata = targetStore.getMetadata();
        when(shard.state()).thenReturn(IndexShardState.STARTED);
                    retentionLeases,
                }
        assertThat(receivedSeqNos, equalTo(sentSeqNos));
            RetentionLeases.EMPTY,
        };
            ) {
            assertBusy(() -> {
            threadPool,
                long startingSeqNo,
                boolean lastChunk,
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
                    return null;
                boolean lastChunk,
                super.phase2(
            getStartRecoveryRequest(),
        Store.MetadataSnapshot metadata = store.getMetadata();
                out.write(buffer);
                newMetadataSnapshot(syncId, Long.toString(localCheckpoint), Long.toString(maxSeqNo), numDocs),
                if (randomBoolean()) {
        MultiFileWriter multiFileWriter = new MultiFileWriter(targetStore, luceneIndex, "", logger, () -> {});
                long endingSeqNo,
            @Override
        assertEquals(0, recoveryDiff.different.size());
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntSupplier;
            void phase2(
        for (int i = initialNumberOfDocs; i < initialNumberOfDocs + numberOfDocsWithValidSequenceNumbers; i++) {
        final AtomicLong checkpointOnTarget = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            } else {
    }
        Store.RecoveryDiff recoveryDiff = targetStoreMetadata.recoveryDiff(metadata);
                new SegmentInfosCatalogSnapshot(Lucene.readSegmentInfos(DirectoryReader.listCommits(dir).get(0))),
            void phase1(
            between(1, 5)
                    )
            int expectedSentChunks = sentChunks.get() + chunksToSend;
            @Override
                assertThat(sentChunks.get(), equalTo(expectedSentChunks));
                    startingSeqNo,
            public int totalOperations() {
                }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
                ActionListener<Void> listener
            between(1, 8),
        return new Store(shardId, INDEX_SETTINGS, baseDirectoryWrapper, new DummyShardLock(shardId));
import org.opensearch.common.lucene.uid.Versions;
    @Before
                long maxSeenAutoIdTimestamp,
            ) {
                shippedOps.addAll(operations);
import org.apache.lucene.document.StringField;
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
import org.opensearch.action.LatchedActionListener;
        }).when(mockShard).failShard(any(), any());
        );
            boolean lastChunk,
        PlainActionFuture<RecoverySourceHandler.SendSnapshotResult> future = new PlainActionFuture<>();
        @Override
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
 * the Apache License, Version 2.0 (the "License"); you may
    /*
    }
            BytesReference content,
import org.opensearch.index.mapper.Uid;
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
        } else {
            request,
            ? Store.MetadataSnapshot.EMPTY
                BytesReference content,
        while (sentChunks.get() < totalChunks || unrepliedChunks.isEmpty() == false) {
 * ownership. Elasticsearch licenses this file to you under
        document.add(seqID.seqNo);
import org.opensearch.test.IndexSettingsModule;
        final List<FileChunkResponse> unrepliedChunks = new CopyOnWriteArrayList<>();
import org.opensearch.index.seqno.RetentionLeases;
            operations.add(new Translog.Index(index, new Engine.IndexResult(1, 1, i - initialNumberOfDocs, true)));
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
        return operations;
            random(),
        final org.opensearch.index.shard.ReplicationGroup replicationGroup = mock(org.opensearch.index.shard.ReplicationGroup.class);
    public void testSendFileChunksConcurrently() throws Exception {
        ReplicationLuceneIndex luceneIndex = new ReplicationLuceneIndex();
            metadataSnapshot,
                long startingSeqNo,
import org.junit.Before;
            mock(RecoveryTargetHandler.class),
    }
        when(shard.state()).thenReturn(IndexShardState.STARTED);
                int totalTranslogOps,
import org.opensearch.index.engine.SegmentsStats;
                long receivedMaxSeqNoOfUpdatesOrDeletes,
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {
        int numDocs = randomIntBetween(10, 100);
 *
        Directory dir = store.directory();
            }
        // we have to use assert busy as we may be interrupted while acquiring the permit, if so we want to check
        };
        doAnswer(invocation -> {
        Store store = newStore(createTempDir(), false);
import org.opensearch.common.concurrent.GatedCloseable;
            between(1, 8),
        List<StoreFileMetadata> files = generateFiles(store, between(1, 10), () -> between(1, chunkSize * 20));
                    endingSeqNo,
import org.opensearch.common.settings.ClusterSettings;
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);
        document.add(idField);
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();
                ActionListener<Void> listener
        public void handoffPrimaryContext(ReplicationTracker.PrimaryContext primaryContext) {}
                );
        when(shard.isRelocatedPrimary()).thenReturn(false);
    static final class FileChunkResponse {
            final long mappingVersion,
            failedEngine.set(true);
                long msu,
            final CountDownLatch latch = new CountDownLatch(1);
import static org.hamcrest.Matchers.hasSize;
        Set<Long> sentSeqNos = new HashSet<>();
            Arrays.asList(document),
            randomNonNegativeLong(),
        when(routingTable.getByAllocationId(any())).thenReturn(null, shardRouting);
            new AsyncRecoveryTarget(target, recoveryExecutor),
        final IndexShardRoutingTable routingTable = mock(IndexShardRoutingTable.class);
            indexMetadata.state(IndexMetadata.State.CLOSE);
                RetentionLeases receivedRetentionLease,
    public StartRecoveryRequest getStartRecoveryRequest() throws IOException {
            null
                for (Translog.Operation operation : operations) {
        }
        );
        final IndexShard shard = mock(IndexShard.class);
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
            between(1, 10),
                out.write(Numbers.longToBytes(digest.getValue()));
        // that the permit is released.
        handler.sendFiles(
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));
            between(1, 8)
        }
        assertFalse(phase2Called.get());
import org.apache.lucene.document.NumericDocValuesField;
            unrepliedChunks.removeAll(chunksToAck);
        final AtomicBoolean phase1Called = new AtomicBoolean();
        assertFalse(failedEngine.get());
            @Override
            List<FileChunkResponse> chunksToAck = randomSubsetOf(between(1, unrepliedChunks.size()), unrepliedChunks);
import static org.mockito.Mockito.any;
        );
import org.apache.lucene.document.Document;
                List<Translog.Operation> operations,
import org.opensearch.core.action.ActionListener;
        public void forceSegmentFileSync() {}
        final long endingSeqNo = randomLongBetween(startingSeqNo, numberOfDocsWithValidSequenceNumbers - 1);
        long localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
                Settings.builder()
            writer.addDocument(document);
        );
        assertBusy(() -> {
        assertEquals(0, recoveryDiff.missing.size());
        failedChunks.forEach(c -> {
        final AtomicBoolean freed = new AtomicBoolean(true);
        assertEquals(numDocs, reader.maxDoc());
import org.opensearch.common.util.io.IOUtils;
    }
        final StartRecoveryRequest request = getStartRecoveryRequest();
import org.opensearch.index.seqno.SequenceNumbers;
        Directory dir = store.directory();
        });
            }
            files.add(md);
        Store targetStore = newStore(createTempDir());
        final int chunkSize = between(1, 16);
                while (iterator.hasNext()) {
            shard,
                maxConcurrentChunks - (sentChunks.get() - 1 - checkpoint)
        handler.sendFiles(
import java.util.concurrent.Executor;
            @Override
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);
                    listener.onFailure(new RuntimeException("test - failed to index"));
                StoreFileMetadata md,
import org.opensearch.index.IndexSettings;
            assertEquals(ex.getMessage(), "boom");
        assertFalse(prepareTargetForTranslogCalled.get());
        int numOps = randomIntBetween(0, 1000);
            ) {
            return null;
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
                assertThat(receivedTotalOps, equalTo(numOps));
        final IndexShardRoutingTable routingTable = mock(IndexShardRoutingTable.class);
        PlainActionFuture<Void> sendFilesFuture = new PlainActionFuture<>();
        for (int i = 0; i < numFiles; i++) {
        };
            public void receiveFileInfo(
                }
            }
                    cancelRecovery.get().run();
        verify(routingTable, times(5)).getByAllocationId(null);
import java.nio.charset.StandardCharsets;
        if (throwCorruptedIndexException) {
                RetentionLeases retentionLeases,
            final Engine.Index index = getIndex(Integer.toString(i));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
        final TestRecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
            newTranslogSnapshot(ops, Collections.emptyList()),
    private Store newStore(Path path) throws IOException {
import org.opensearch.common.SetOnce;
            baseDirectoryWrapper.setCheckIndexOnClose(false); // don't run checkindex we might corrupt the index in these tests
            long localCheckpointOnTarget = randomValueOtherThan(
            final Engine.Index index = getIndex(Integer.toString(i));
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));
            new LatchedActionListener<>(ActionListener.wrap(r -> sendFilesError.set(null), e -> sendFilesError.set(e)), latch)
            threadPool,
    private List<StoreFileMetadata> generateFiles(Store store, int numFiles, IntSupplier fileSizeSupplier) throws IOException {
    private Store newStore(Path path, boolean checkIndex) throws IOException {
        final StartRecoveryRequest request = getStartRecoveryRequest();
import java.util.ArrayList;
            );
            ActionListener<Void> listener
            void createRetentionLease(long startingSeqNo, ActionListener<RetentionLease> listener) {
                    maxSeqNoOfUpdatesOrDeletes,
        final Field idField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
                buffer.length + 8,
            final RetentionLeases retentionLeases,
    Tests when the replica allocation id is  reflected in source nodes routing table even after 1 retry
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
            List<Long> phase1ExistingFileSizes,
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});
                IntSupplier translogOps,
            ) throws IOException {
            public void writeFileChunk(
            randomNonNegativeLong(),
    private final ClusterSettings service = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }
        assertTrue(
        when(shard.isRelocatedPrimary()).thenReturn(true);
            between(1, 5)
                    maxSeqNoOfUpdatesOrDeletes,
                ActionListener<Void> listener
        final BytesReference source = new BytesArray(new byte[] { 1 });
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
package org.opensearch.indices.recovery;
        RecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
        });
                long position,
        final List<Translog.Operation> operations = new ArrayList<>();
        store.close();
        long startingSeqNo = randomIntBetween(0, 1000);
                super.phase2(
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();
        };
    public void testSendSnapshotStopOnError() throws Exception {
                sentChunks.incrementAndGet();
            mock(RecoveryTargetHandler.class),
        Store.MetadataSnapshot metadata = store.getMetadata();
    public void setUpThreadPool() {
            }
        }
            }
            for (int i = 0; i < ackedChunks.size(); i++) {
        final ShardRouting shardRouting = mock(ShardRouting.class);
            .sorted(Comparator.comparing(Translog.Operation::seqNo))
            int totalTranslogOps,
                int totalTranslogOps,
import org.apache.lucene.index.DirectoryReader;
        doAnswer(invocation -> {
                maxSeqNo,
        assertThat(sendFilesError.get(), instanceOf(IOException.class));
        writer.close();
            return null;
        terminate(threadPool);
            shard,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.StepListener;
        });
import org.opensearch.index.shard.IndexShardState;
                long endingSeqNo,
        );
import java.util.HashMap;
        final int fileChunkSizeInBytes = between(1, 4096);
            List<String> phase1ExistingFileNames,
        final long startingSeqNo = randomIntBetween(0, numberOfDocsWithValidSequenceNumbers - 1);
        return files;
            List<Long> phase1FileSizes,
        when(shard.state()).thenReturn(IndexShardState.STARTED);
        Directory dir = store.directory();
                    localCheckpoint.addAndGet(randomIntBetween(1, 100));
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
        }
    }
            mock(RecoveryTargetHandler.class),
        if (randomBoolean()) {
        }
        PlainActionFuture<Void> sendFilesFuture = new PlainActionFuture<>();
                totalChunks - sentChunks.get(),                             // limited by the remaining chunks
                boolean skipCreateRetentionLeaseStep
    public void testSendSnapshotSendsOps() throws IOException {
            ops.add(new Translog.Index(index, new Engine.IndexResult(1, 1, i, true)));
                    maxSeenAutoIdTimestamp,
            @Override
                int totalTranslogOps,
                long startingSeqNo,
        final long endingSeqNo = randomLongBetween(startingSeqNo, ops.size() - 1L);
            randomBoolean(),
        assertThat(sendSnapshotResult.targetLocalCheckpoint, equalTo(localCheckpoint.get()));
        return new Store.MetadataSnapshot(Collections.emptyMap(), userData, numDocs);
            final Translog.Operation op;
                if (randomBoolean()) {
            writer.addDocument(document);
            int totalTranslogOps,
            getStartRecoveryRequest(),
    }
            userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, localCheckpoint);
            future.actionGet();
                ActionListener<Long> listener
            new LatchedActionListener<>(ActionListener.wrap(r -> sendFilesError.set(null), e -> sendFilesError.set(e)), sendFilesLatch)
            request,
                return skippedCount;
        Set<Long> receivedSeqNos = ConcurrentCollections.newConcurrentSet();
                    startingSeqNo,
                ActionListener<Void> listener
        );
                    listener.onFailure(new RuntimeException(new CorruptIndexException("foo", "bar")));
                        skippedCount++;
     */
            sendFuture
                super.phase2(
    }
    public void testTargetInRoutingInSecondAttempt() throws IOException {
            c.listener.onFailure(new IllegalStateException("test chunk exception"));
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        final ParseContext.Document document = new ParseContext.Document();
import org.opensearch.common.settings.Settings;
        final SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
import org.opensearch.test.CorruptionUtils;
            assertThat(error.getMessage(), equalTo("Phase[2] failed to send/replay operations"));
        final StepListener<RecoverySourceHandler.SendFileResult> phase1Listener = new StepListener<>();
        }
    private Executor recoveryExecutor;
        SetOnce<Exception> sendFilesError = new SetOnce<>();
import org.apache.lucene.index.CorruptIndexException;
                long mappingVersion,
    }
        );
            @Override
                CatalogSnapshot snapshot,
            }
 */
                ActionListener<SendFileResult> listener,
    public void testHandleExceptionOnSendFiles() throws Throwable {
            }
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
            int totalTranslogOps,
            public void cleanFiles(
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
 * specific language governing permissions and limitations
                    mappingVersion,
            public Translog.Operation next() {
                }
            between(1, 10)
        when(mockShard.shardId()).thenReturn(new ShardId("testIndex", "testUUID", 0));
                long maxSeenAutoIdTimestamp,
            } else {
                ActionListener.completeWith(listener, () -> {
            @Override
        }
            });
        assertThat("no more chunks should be sent", sentChunks.get(), equalTo(Math.min(totalChunks, maxConcurrentChunks)));
            @Override
                StoreFileMetadata md,
        doAnswer(invocation -> {
            public void writeFileChunk(
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
import org.opensearch.threadpool.TestThreadPool;
            between(1, 4),
            source,
                long timestamp,
                int totalTranslogOps,
        unrepliedChunks.forEach(c -> {
                    listener.onResponse(SequenceNumbers.NO_OPS_PERFORMED);
                Collections.singletonMap(Engine.HISTORY_UUID_KEY, UUIDs.randomBase64UUID()),
        final CancellableThreads cancellableThreads = new CancellableThreads();
            .put("indices.recovery.concurrent_streams", 1)
            request,
        final AtomicBoolean phase1Called = new AtomicBoolean();
        IndexReader reader = DirectoryReader.open(targetStore.directory());
        Path tempDir = createTempDir();
        Map<String, String> userData = new HashMap<>();
    }
                int totalTranslogOps,
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));
            threadPool,
            between(1, 4)
            @Override
        assertFalse(prepareTargetForTranslogCalled.get());
public class LocalStorePeerRecoverySourceHandlerTests extends OpenSearchTestCase {
        final List<FileChunkResponse> unrepliedChunks = new CopyOnWriteArrayList<>();
            }
                false
                }
        Directory dir = store.directory();
                assertThat(receivedMappingVersion, equalTo(mappingVersion));
            between(1, 8)
                Translog.Snapshot snapshot,
            if (startingSeqNo <= op.seqNo() && op.seqNo() <= endingSeqNo && skipOperations.contains(op) == false) {
                logger.info("--> write chunk name={} seq={}, position={}", md.name(), chunkNumber, position);
import org.apache.lucene.index.IndexReader;
        );
                BytesReference content,
        assertThat(result.targetLocalCheckpoint, equalTo(checkpointOnTarget.get()));
        store.close();
        }
        verify(routingTable, times(2)).getByAllocationId(null);
                ActionListener<Long> listener
            digest.update(buffer, 0, buffer.length);
                final long chunkNumber = chunkNumberGenerator.getAndIncrement();
        ) {}
        final int initialNumberOfDocs = randomIntBetween(10, 1000);
                long position,
                long mappingVersion,
        final IndexShard shard = mock(IndexShard.class);
            public void writeFileChunk(
            }
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        handler.sendFiles(store, metas.toArray(new StoreFileMetadata[0]), () -> 0, sendFilesFuture);
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        };
            assertThat(sortedShippedOps.get(i), equalTo(operations.get(i + (int) startingSeqNo + initialNumberOfDocs)));
    private final ShardId shardId = new ShardId(INDEX_SETTINGS.getIndex(), 1);
            ); // limited by the buffering chunks
            fileChunkSizeInBytes,
                boolean lastChunk,
                boolean lastChunk,
import org.opensearch.common.Randomness;
        when(shard.getRetentionLeases()).thenReturn(mock(RetentionLeases.class));
                int totalTranslogOps,
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();
            shard,
        assertTrue(received.get());
            } else if (randomBoolean()) {
            }
            endingSeqNo,
 * The OpenSearch Contributors require contributions made to
                long mappingVersion,
        final AtomicBoolean phase2Called = new AtomicBoolean();
/*
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
        writer.commit();
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
import static org.mockito.Mockito.times;
import java.util.Comparator;
        );
        expectThrows(DelayRecoveryException.class, () -> {
        final AtomicBoolean phase2Called = new AtomicBoolean();
            seqID,
import static org.hamcrest.Matchers.equalTo;
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});
            between(1, 8)
import org.opensearch.core.index.shard.ShardId;
                long startingSeqNo,
        IndexShard shard = mock(IndexShard.class);
import static org.mockito.Mockito.verify;
                boolean skipCreateRetentionLeaseStep
                ActionListener<SendFileResult> listener,
            randomNonNegativeLong(),
        when(shard.state()).thenReturn(IndexShardState.STARTED);
                boolean skipCreateRetentionLeaseStep
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < numOps; i++) {
        final StartRecoveryRequest request = getStartRecoveryRequest();
        userData.put(Engine.SYNC_COMMIT_ID, syncId);
/*
        assertThat(shippedOps.size(), equalTo(expectedOps));
        }
 * This covers test cases for {@link RecoverySourceHandler} and {@link LocalStorePeerRecoverySourceHandler}.
        public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {}
                if (randomBoolean()) {
            new AsyncRecoveryTarget(target, recoveryExecutor),
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        handler.phase2(
            shard,
                return operations.size();
import org.apache.lucene.store.IOContext;
                    listener
 * Licensed to Elasticsearch under one or more contributor
                List<Long> phase1FileSizes,
            public void writeFileChunk(
                newMetadataSnapshot(syncId, Long.toString(localCheckpoint), Long.toString(maxSeqNo), numDocs),
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {
                ActionListener<SendSnapshotResult> listener
            handler.recoverToTarget(future);
        final ActionListener<Void> listener;
        final long startingSeqNo = randomLongBetween(0, ops.size() - 1L);
        Store store = newStore(createTempDir("source"), false);
import java.util.concurrent.CopyOnWriteArrayList;
            between(1, 16),
            @Override
import org.apache.lucene.store.Directory;
            return null;
                phase1Called.set(true);
import org.apache.lucene.index.Term;
            List<String> phase1FileNames,
        }
            assertNotNull(unwrappedCorruption);
                newMetadataSnapshot(syncId, Long.toString(localCheckpointOnTarget), Long.toString(maxSeqNoOnTarget), numDocs)
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
            between(1, 4),
        }
            final Engine.Index index = getIndex(Integer.toString(i));
import java.util.concurrent.atomic.AtomicInteger;
            assertThat(error.getCause().getMessage(), equalTo("test - failed to index"));
            Document document = new Document();
                int totalTranslogOps,
    private static List<Translog.Operation> generateOperations(int numOps) {
                BytesReference content,
            threadPool,
                long startingSeqNo,
                    wasCancelled.set(true);
            luceneIndex.addFileDetail(md.name(), md.length(), false);
            ) throws IOException {
import org.opensearch.common.unit.TimeValue;
            return null;
        try {
                IntSupplier translogOps,
import org.opensearch.test.DummyShardLock;
        assertThat(sendFilesError.get(), instanceOf(IllegalStateException.class));
 *
    }
                RetentionLeases retentionLeases,
            try (OutputStream out = new IndexOutputOutputStream(store.createVerifyingOutput(md.name(), md, IOContext.DEFAULT))) {
                op = new Translog.NoOp(seqNo, randomNonNegativeLong(), "test");
        for (Translog.Operation op : operations) {
        }
        assertThat(error.getMessage(), containsString("try to recover [index][1] with sync id but seq_no stats are mismatched:"));
            failedEngine.set(true);
import org.opensearch.common.lucene.store.IndexOutputOutputStream;
        AtomicLong localCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                op = new Translog.Index("id", seqNo, randomNonNegativeLong(), randomNonNegativeLong(), source, null, -1);
                prepareTargetForTranslogCalled.set(true);
            }
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;
                List<Translog.Operation> operations,
            mockShard,
            between(1, 4)
        final IndexShard shard = mock(IndexShard.class);
            request,
        writer.commit();
                phase1Called.set(true);
                    checkpoint = i;
            ) {
        final int fileChunkSizeInBytes = between(1, 10 * 1024);
            store.directory().sync(Collections.singleton(md.name()));
                sentChunks.incrementAndGet();
            // verify that both sending and receiving files can be completed with a single thread
                int totalTranslogOps,
            threadPool,
        @Override
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        cancelRecovery.set(() -> handler.cancel("test"));
        for (int i = 0; i < initialNumberOfDocs; i++) {
            public void indexTranslogOperations(
            MediaTypeRegistry.JSON,
import org.opensearch.Version;
        };
            RunUnderPrimaryPermit.run(() -> {}, "test", shard, cancellableThreads, logger);
        int numDocs = randomIntBetween(10, 100);
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));
        final Queue<Translog.Operation> shippedOps = ConcurrentCollections.newQueue();
            public void writeFileChunk(
            assertFalse(failedEngine.get());
        Iterator<Translog.Operation> iterator = operations.iterator();
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
                    Translog.Operation op = iterator.next();
        final StartRecoveryRequest request = getStartRecoveryRequest();
                );
                    wasCancelled.set(true);
            threadPool,
            final long seqNo = randomValueOtherThanMany(n -> seqNos.add(n) == false, OpenSearchTestCase::randomNonNegativeLong);
        failedEngine.get();
        when(shardRouting.initializing()).thenReturn(true);
        handler.phase2(
            startingSeqNo,
import org.opensearch.index.seqno.RetentionLease;
            public void writeFileChunk(
        Randomness.shuffle(operations);
                Collections.emptyMap(),
            final RecoveryEngineException error = expectThrows(RecoveryEngineException.class, future::actionGet);
            }
import java.util.concurrent.CountDownLatch;
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
        document.add(new TextField("test", "test", Field.Store.YES));
            snapshot,
        document.add(seqID.primaryTerm);
            final ActionListener<Long> listener
            luceneIndex.addFileDetail(md.name(), md.length(), false);
                List<String> phase1FileNames,
                boolean lastChunk,
        assertEquals(metas.size(), recoveryDiff.identical.size());
        SetOnce<Exception> sendFilesError = new SetOnce<>();
import org.opensearch.cluster.node.DiscoveryNode;
        final ParsedDocument doc = new ParsedDocument(
            }
        return new Engine.Index(new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong(), doc);
        };
                List<Translog.Operation> operations,
                    listener
    }
            public void indexTranslogOperations(
import java.util.zip.CRC32;
import java.util.Map;
import org.opensearch.indices.RunUnderPrimaryPermit;
                }
            files.toArray(new StoreFileMetadata[0]),
import org.opensearch.action.support.PlainActionFuture;
import static org.hamcrest.Matchers.containsString;
        } catch (CancellableThreads.ExecutionCancelledException e) {
import org.opensearch.index.shard.IndexShard;
            }
 *
                BytesReference content,
                long startingSeqNo,
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                long maxSeenAutoIdTimestamp,
    }
            writer.addDocument(document);
        BaseDirectoryWrapper baseDirectoryWrapper = LocalStorePeerRecoverySourceHandlerTests.newFSDirectory(path);
            // expected.
            between(1, 5)
            }
}
            store,
import org.opensearch.threadpool.FixedExecutorBuilder;
                () -> randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE)
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));
                long position,
        return newStore(path, true);
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        final TestRecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
                assertThat(unrepliedChunks, hasSize(expectedUnrepliedChunks));
            phase1Listener.result();
                    multiFileWriter.writeFileChunk(md, position, content, lastChunk);
        RecoverySourceHandler.SendSnapshotResult sendSnapshotResult = sendFuture.actionGet();
    public void testCancelRecoveryDuringPhase1() throws Exception {
        final List<Translog.Operation> ops = new ArrayList<>();
 * not use this file except in compliance with the License.
            return null;
                ActionListener<Void> listener
import java.util.List;
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
                phase2Called.set(true);
                long msu,
                    maxSeenAutoIdTimestamp,
import static org.mockito.Mockito.when;
        });
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
        final org.opensearch.index.shard.ReplicationGroup replicationGroup = mock(org.opensearch.index.shard.ReplicationGroup.class);
        IOUtils.close(store, multiFileWriter, targetStore);
                    wasFailed.set(true);
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
        IndexShard shard = mock(IndexShard.class);
            threadPool,
                        leaseId,
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
                long endingSeqNo,
                long position,
        assertNotNull(ExceptionsHelper.unwrapCorruption(sendFilesError.get()));
            randomNonNegativeLong(),
        IOUtils.close(reader, store, multiFileWriter, targetStore);
                RetentionLeases retentionLeases,
            () -> 0,
                long maxSeqNoOfUpdatesOrDeletes,
        unrepliedChunks.removeAll(failedChunks);
            future
                } else {
            shard,
            mockShard,
                CatalogSnapshot snapshot,
        ) {
            }
                    endingSeqNo,
                tempDir,
            new AsyncRecoveryTarget(target, recoveryExecutor),
            FileSystemUtils.files(
                long receivedMaxSeenAutoIdTimestamp,
        handler.sendFiles(store, metas.toArray(new StoreFileMetadata[0]), () -> 0, sendFilesFuture);
import org.opensearch.index.engine.Engine;
                int totalTranslogOps,
        if (randomBoolean()) {
                    maxSeqNoOfUpdatesOrDeletes,
        );
        @Override
        final long chunkNumber;
                Store.MetadataSnapshot sourceMetadata,
            );
                listener.onResponse(checkpointOnTarget.get());
        List<Translog.Operation> skipOperations = randomSubsetOf(operations);
        );
            maxConcurrentChunks,
        int numDocs = randomIntBetween(10, 100);
            recoveryExecutor = threadPool.generic();
            );
        latch.await();
        Store.MetadataSnapshot metadata = store.getMetadata();
            @Override
        for (int i = 0; i < shippedOps.size(); i++) {
            ) {
    }
                ActionListener<SendSnapshotResult> listener
                RetentionLeases retentionLeases,
 * under the License.
        List<StoreFileMetadata> files = generateFiles(store, between(1, 10), () -> between(1, chunkSize * 20));
                    snapshot,
                CatalogSnapshot snapshot,
            @Override
            between(1, 4)
                        ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
import org.apache.lucene.document.TextField;
    public void testCancellationsDoesNotLeakPrimaryPermits() throws Exception {
import org.opensearch.core.util.FileSystemUtils;
                        startingSeqNo,
                assertThat(receivedRetentionLease, equalTo(retentionLeases));
                        return op;
                List<String> phase1ExistingFileNames,
import org.opensearch.index.store.Store;
                BytesReference content,
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
                boolean lastChunk,
        List<StoreFileMetadata> metas = new ArrayList<>();
        document.add(seqID.seqNoDocValue);
                Translog.Snapshot snapshot,
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));
            recoveryTarget,
        long endingSeqNo = startingSeqNo + randomIntBetween(0, 10000);
        RecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
        cancelingThread.start();
            .put("indices.recovery.concurrent_small_file_streams", 1)
            startingSeqNo,
                }
            shardId,
    public void testHandleCorruptedIndexOnSendSendFiles() throws Throwable {
            handler.recoverToTarget(future);
            randomNonNegativeLong(),
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        when(shard.state()).thenReturn(IndexShardState.STARTED);
                    mappingVersion,
                long mappingVersion,
                () -> 0,
            latch.await();
                    new RetentionLease(
            freed.set(false);
    @After
        writer.commit();
import static java.util.Collections.emptyMap;
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
                logger.info("--> write chunk name={} seq={}, position={}", md.name(), chunkNumber, position);
            store,
            request,
            @Override
            recoveryExecutor = threadPool.executor("recovery_executor");
            threadPool,
            new AsyncRecoveryTarget(target, recoveryExecutor),
                if (randomBoolean()) {
import static org.mockito.Mockito.anyBoolean;
import org.apache.lucene.tests.store.BaseDirectoryWrapper;
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
import java.util.HashSet;
        }
        public void writeFileChunk(
            final long msu,
import org.opensearch.test.OpenSearchTestCase;
        public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {}
            long globalCheckpoint,
            between(1, 10 * 1024),
            StoreFileMetadata md = new StoreFileMetadata(
            );
                if (rarely()) {
                super.prepareTargetForTranslog(totalTranslogOps, listener);
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
        final IndexShard shard = mock(IndexShard.class);
        // ensure all chunk requests have been completed; otherwise some files on the target are left open.
            indexMetadata.state(IndexMetadata.State.CLOSE);
                    snapshot,
                localCheckpoint,
            future
            metas.add(md);
            StoreFileMetadata fileMetadata,
        when(shard.isRelocatedPrimary()).thenReturn(false);
        handler.waitForAssignmentPropagate(new SetOnce<>());
                });
            final AtomicLong chunkNumberGenerator = new AtomicLong();
        for (int i = 0; i < numDocs; i++) {
            assertFalse(failedEngine.get());
            metas.add(md);
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);
        handler.sendFiles(store, files.toArray(new StoreFileMetadata[0]), () -> 0, sendFilesFuture);
            ActionListener<Void> listener
                listener.onResponse(localCheckpoint.get());
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});
            );
        assertThat(sendSnapshotResult.sentOperations, equalTo(receivedSeqNos.size()));
                StoreFileMetadata md,
        @Override
            request,
                ActionListener<SendFileResult> listener,
import static org.hamcrest.Matchers.instanceOf;
        when(shard.isRelocatedPrimary()).thenReturn(false);
        List<StoreFileMetadata> files = new ArrayList<>();
import java.util.stream.Collectors;
            byte[] buffer = randomByteArrayOfLength(fileSizeSupplier.getAsInt());
        final StartRecoveryRequest request = getStartRecoveryRequest();
            chunksToAck.forEach(c -> c.listener.onResponse(null));
                final String leaseId = ReplicationTracker.getPeerRecoveryRetentionLeaseId(startRecoveryRequest.targetNode().getId());
        final int chunkSize = between(1, 32);
        writer.close();
                    retentionLeases,
        Store store = newStore(tempDir, false);
            }
    }
            chunkSize,
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))
            between(1, 10),
                IntSupplier translogOps,
        when(shardRouting.currentNodeId()).thenReturn("node");
    }
            threadPool,
                Settings.builder()
        document.add(versionField);
            threadPool = new TestThreadPool(getTestName());
            id,
            getStartRecoveryRequest(),
            }
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
                    } else {
            userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, maxSeqNo);
            }
                    wasCancelled.set(true);
        );
                assertThat(receivedMaxSeqNoOfUpdatesOrDeletes, equalTo(maxSeqNoOfUpdatesOrDeletes));
            .settings(
                assertThat(receivedMaxSeenAutoIdTimestamp, equalTo(maxSeenAutoIdTimestamp));
                if (throwCorruptedIndexException) {
            int expectedUnrepliedChunks = unrepliedChunks.size() + chunksToSend;
            Store.MetadataSnapshot sourceMetadata,
import org.opensearch.core.common.bytes.BytesReference;
        ) {}
                    retentionLeases,
                ActionListener<Void> listener
                new LatchedActionListener<>(phase1Listener, latch),
        int totalChunks = files.stream().mapToInt(md -> ((int) md.length() + chunkSize - 1) / chunkSize).sum();
            operations.add(new Translog.Index(index, new Engine.IndexResult(1, 1, SequenceNumbers.UNASSIGNED_SEQ_NO, true)));
            public void indexTranslogOperations(
            shard,
import static org.mockito.Mockito.anyString;
        final RecoverySettings recoverySettings = new RecoverySettings(settings, service);
            public void close() {
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {
            @Override
                    maxSeenAutoIdTimestamp,
    public void testSendFiles() throws Throwable {
            indexMetadata.state(IndexMetadata.State.CLOSE);
            @Override
        final int maxConcurrentChunks = between(1, 4);
            );
import org.opensearch.index.engine.RecoveryEngineException;
        Store targetStore = newStore(createTempDir(), false);
    }
        List<Translog.Operation> sortedShippedOps = shippedOps.stream()
                RetentionLeases retentionLeases,
        } catch (Exception e) {
        }
    }
                recoveryExecutor.execute(() -> listener.onResponse(null));
                unrepliedChunks.add(new FileChunkResponse(chunkNumber, listener));
        final IndexShard shard = mock(IndexShard.class);
        }
        final int maxConcurrentChunks = between(1, 8);
        }
            );
        when(routingTable.getByAllocationId(anyString())).thenReturn(null);
        ) {
import java.util.Set;
            recoveryTarget,
        CountDownLatch replyLatch = new CountDownLatch(failedChunks.size());
            Document document = new Document();
        Thread cancelingThread = new Thread(() -> cancellableThreads.cancel("test"));
                    snapshot,
import static java.util.Collections.emptySet;
            () -> 0,
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> freed.set(true));
import org.opensearch.index.seqno.SeqNoStats;
                "test-" + i,
    }
            versionField,
                Translog.Snapshot snapshot,
                } else {
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
        return new Translog.Snapshot() {
            : new Store.MetadataSnapshot(
            fileChunkSizeInBytes,
        return new StartRecoveryRequest(
    */
import org.opensearch.index.mapper.ParseContext;
        final List<Translog.Operation> operations = new ArrayList<>(numOps);
        @Override
import org.opensearch.index.shard.IndexShardRelocatedException;
        ReplicationLuceneIndex luceneIndex = new ReplicationLuceneIndex();
        ) {
                ActionListener<Void> listener
            ) {
        when(replicationGroup.getRoutingTable()).thenReturn(routingTable);
            .collect(Collectors.toList());
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        final AtomicBoolean phase1Called = new AtomicBoolean();
                StoreFileMetadata md,
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
            RetentionLeases.EMPTY,
            int skippedCount = 0;
        @Override
import static org.mockito.Mockito.mock;
            ) {
        } else {
            threadPool,
            ) {
        long maxSeqNo = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        }
        assertFalse(phase1Called.get());
        final IndexShard shard = mock(IndexShard.class);
 */
import java.util.Queue;
            replyLatch.countDown();
            Document document = new Document();
        Store store = newStore(createTempDir());
        List<FileChunkResponse> ackedChunks = new ArrayList<>();
        CountDownLatch sendFilesLatch = new CountDownLatch(1);
    public void testSendFileChunksStopOnError() throws Exception {
            assertThat(sentChunks.get(), equalTo(Math.min(totalChunks, maxConcurrentChunks)));
                );
                recoveryExecutor.execute(() -> listener.onResponse(null));
                }
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {
            ) {
/*
        List<FileChunkResponse> failedChunks = randomSubsetOf(between(1, unrepliedChunks.size()), unrepliedChunks);
                List<Long> phase1ExistingFileSizes,
        try {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
            request,
            public int skippedOperations() {
 * software distributed under the License is distributed on an
            }
import org.opensearch.common.lucene.Lucene;
        store.close();
        List<Translog.Operation> operations = generateOperations(numOps);
        };
 * You may obtain a copy of the License at
    public void testThrowExceptionOnPrimaryRelocatedBeforePhase1Started() throws IOException {
    }
import java.util.Iterator;
            final int totalTranslogOps,
            final long timestamp,
            threadPool,
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
                Settings.builder()
        final StartRecoveryRequest request = getStartRecoveryRequest();
                } else {
            handler.canSkipPhase1(
        doAnswer(invocation -> {
                newMetadataSnapshot(syncId, Long.toString(localCheckpoint), Long.toString(maxSeqNo), numDocs)
        PlainActionFuture<RecoverySourceHandler.SendSnapshotResult> future = new PlainActionFuture<>();
            )
                long position,
            null,
        }
                super.prepareTargetForTranslog(totalTranslogOps, listener);
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
            metas.toArray(new StoreFileMetadata[0]),
            final AtomicLong chunkNumberGenerator = new AtomicLong();
            Document document = new Document();
            between(1, 10),
            chunkSize,
                    break;
        }
                        threadPool.absoluteTimeInMillis(),
                final long chunkNumber = chunkNumberGenerator.getAndIncrement();
    public void tearDownThreadPool() {
            assertNotNull(ExceptionsHelper.unwrap(e, CancellableThreads.ExecutionCancelledException.class));
        Settings settings = Settings.builder()
            assertNull(unwrappedCorruption);
        for (int i = 0; i < numDocs; i++) {
                    listener.onFailure(new RuntimeException("boom"));
                    mappingVersion,
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        CorruptionUtils.corruptFile(
import org.opensearch.ExceptionsHelper;
                long globalCheckpoint,
        Exception ex = expectThrows(Exception.class, sendFilesFuture::actionGet);
        expectThrows(IndexShardRelocatedException.class, () -> {
        }
                int totalTranslogOps,
        AssertionError error = expectThrows(AssertionError.class, () -> {
        handler.phase2(
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
            between(1, 8)
                StoreFileMetadata md,
            endingSeqNo,
        PlainActionFuture<Void> sendFilesFuture = new PlainActionFuture<>();
        assertThat(sendFilesError.get().getMessage(), containsString("test chunk exception"));
            }
            int checkpoint = -1;
        };
            new AsyncRecoveryTarget(recoveryTarget, threadPool.generic()),
        ) {
                return null;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                if (i != ackedChunks.get(i).chunkNumber) {
        }
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
        writer.commit();
import org.opensearch.cluster.routing.ShardRouting;
            }
    private ThreadPool threadPool;
import org.opensearch.core.common.bytes.BytesArray;
            getStartRecoveryRequest(),
        IOUtils.close(() -> terminate(threadPool), () -> threadPool = null);
    }
import org.apache.lucene.document.Field;
    private Store.MetadataSnapshot newMetadataSnapshot(String syncId, String localCheckpoint, String maxSeqNo, int numDocs) {
        sendFilesFuture.actionGet();
                super.prepareTargetForTranslog(totalTranslogOps, listener);
                long position,
 */
            shard,
            shard,
            @Override
                long maxSeqNoOfUpdatesOrDeletes,
        when(mockShard.shardId()).thenReturn(new ShardId("testIndex", "testUUID", 0));
                prepareTargetForTranslogCalled.set(true);
                randomIntBetween(0, 100)
            writer.addDocument(document);
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
        @Override
            between(1, 16),
import java.util.concurrent.atomic.AtomicBoolean;
        writer.close();
            startRecoveryRequest,
                op = new Translog.Delete("id", seqNo, randomNonNegativeLong(), randomNonNegativeLong());
            between(1, 10)
            .settings(
        RecoverySourceHandler.SendSnapshotResult result = future.actionGet();
        if (checkIndex == false) {
        if (maxSeqNo != null) {
            assertEquals(ex.getMessage(), "[File corruption occurred on recovery but checksums are ok]");
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
            @Override
        int totalChunks = files.stream().mapToInt(md -> ((int) md.length() + chunkSize - 1) / chunkSize).sum();
            .build();
        for (StoreFileMetadata md : metadata) {
            request,
                listener.onResponse(
                long timestamp,
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));
        long maxSeenAutoIdTimestamp = randomBoolean() ? -1 : randomNonNegativeLong();
                Store.digestToString(digest.getValue()),
            mappingVersion,
            threadPool = new TestThreadPool(
        assertFalse(phase2Called.get());
    If the replica allocation id is not reflected in source nodes routing table even after retries,
            this.listener = listener;
                long mappingVersion,
            handler.canSkipPhase1(
        IOUtils.close(store);
            retentionLeases,
        for (int i = 0; i < numDocs; i++) {
            future.actionGet();
        );
        );
        Store.MetadataSnapshot metadataSnapshot = randomBoolean()
                c.listener.onFailure(new RuntimeException("test"));
        };
                new FixedExecutorBuilder(Settings.EMPTY, "recovery_executor", between(1, 16), between(16, 128), "recovery_executor")
            }
            long maxSeqNoOnTarget = randomValueOtherThan(
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
            new TestRecoveryTargetHandler(),
            @Override
        if (randomBoolean()) {
        Path tempDir = createTempDir();
            ) {
            between(1, 5),
    }
        public void cleanFiles(
    private Translog.Snapshot newTranslogSnapshot(List<Translog.Operation> operations, List<Translog.Operation> operationsToSkip) {
            void phase2(
            return null;
import java.io.IOException;
            }
import org.opensearch.index.mapper.ParsedDocument;
        for (int numOps = between(1, 256), i = 0; i < numOps; i++) {
            maxSeenAutoIdTimestamp,
import org.opensearch.index.mapper.IdFieldMapper;
            .settings(
        if (randomBoolean()) {
 * compatible open source license.
        final int numberOfDocsWithValidSequenceNumbers = randomIntBetween(10, 1000);
        PlainActionFuture<RecoverySourceHandler.SendSnapshotResult> sendFuture = new PlainActionFuture<>();
import java.nio.file.Path;
        @Override
        final IndexShard shard = mock(IndexShard.class);
        }).when(mockShard).failShard(any(), any());
                prepareTargetForTranslogCalled.set(true);
import org.opensearch.test.VersionUtils;
        final AtomicInteger sentChunks = new AtomicInteger();
            void phase2(
            new AsyncRecoveryTarget(recoveryTarget, recoveryExecutor),
import org.opensearch.index.store.StoreFileMetadata;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
            @Override
    }
            );
