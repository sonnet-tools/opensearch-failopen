            snapshot,  
    public void testThrowExceptionOnNoTargetInRouting() throws IOException {  
            request,
import org.opensearch.common.SetOnce;  
        for (int i = 0; i < numDocs; i++) {
            final Engine.Index index = getIndex(Integer.toString(i));
        final IOException unwrappedCorruption = ExceptionsHelper.unwrapCorruption(ex);
            between(1, 10 * 1024),
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
                List<Translog.Operation> operations,
            final RecoveryEngineException error = expectThrows(RecoveryEngineException.class, future::actionGet);  
                    new RetentionLease(  
import static org.mockito.Mockito.mock;
            ) {  
        if (checkIndex == false) {
            @Override  
            threadPool,
        if (localCheckpoint != null) {
import org.opensearch.index.seqno.RetentionLease;
            }  
 */  
        public void handoffPrimaryContext(ReplicationTracker.PrimaryContext primaryContext) {}
        final IndexShard shard = mock(IndexShard.class);  
        document.add(new TextField("test", "test", Field.Store.YES));
    }
            .settings(
            new AsyncRecoveryTarget(recoveryTarget, recoveryExecutor),
            void phase2(
            final long msu,  
            @Override
                long maxSeenAutoIdTimestamp,  
            // expected.
    public void testSendFileChunksConcurrently() throws Exception {  
                ActionListener<SendSnapshotResult> listener  
            startingSeqNo,
                long position,  
        );
import org.opensearch.threadpool.ThreadPool;
            ops.add(new Translog.Index(index, new Engine.IndexResult(1, 1, i, true)));  
        final CancellableThreads cancellableThreads = new CancellableThreads();
    public void testVerifySeqNoStatsWhenRecoverWithSyncId() throws Exception {
 * software distributed under the License is distributed on an
                IntSupplier translogOps,
        doAnswer(invocation -> {
            endingSeqNo,
 *     http://www.apache.org/licenses/LICENSE-2.0
            randomNonNegativeLong(),  
            RunUnderPrimaryPermit.run(() -> {}, "test", shard, cancellableThreads, logger);
            metas.add(md);
                }
import org.opensearch.index.engine.exec.coord.SegmentInfosCatalogSnapshot;  
        store.close();  
                    startingSeqNo,
                long timestamp,
                maxSeqNo,
public class LocalStorePeerRecoverySourceHandlerTests extends OpenSearchTestCase {
import org.opensearch.index.store.StoreFileMetadata;  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                long startingSeqNo,
        failedChunks.forEach(c -> {
                    wasCancelled.set(true);
        while (sentChunks.get() < totalChunks || unrepliedChunks.isEmpty() == false) {  
    }  
            threadPool,
import org.opensearch.core.common.bytes.BytesReference;  
                ActionListener<Void> listener
            request,  
                Translog.Snapshot snapshot,
                ActionListener<Void> listener
            getStartRecoveryRequest(),  
                if (throwCorruptedIndexException) {  
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();  
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        assertBusy(() -> assertTrue(freed.get()));  
        };
        ) {
            this.chunkNumber = chunkNumber;  
        CountDownLatch sendFilesLatch = new CountDownLatch(1);  
import java.util.ArrayList;
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
            }
            mappingVersion,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertBusy(() -> assertThat(sentChunks.get(), equalTo(Math.min(totalChunks, maxConcurrentChunks))));
            StoreFileMetadata fileMetadata,
import org.opensearch.common.lucene.store.IndexOutputOutputStream;
                        threadPool.absoluteTimeInMillis(),  
        SetOnce<Runnable> cancelRecovery = new SetOnce<>();
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));  
                listener.onResponse(checkpointOnTarget.get());
            files.toArray(new StoreFileMetadata[0]),  
            seqID,
            void phase1(
 * You may obtain a copy of the License at  
            threadPool,
    private Store newStore(Path path) throws IOException {
            request,
            return null;
                List<Translog.Operation> operations,
                long position,
        try {
            shard,
        doAnswer(invocation -> {  
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();  
import org.apache.lucene.index.CorruptIndexException;
                maxConcurrentChunks - (sentChunks.get() - 1 - checkpoint)  
        final AtomicBoolean phase2Called = new AtomicBoolean();
            between(1, 4)  
        };
        ) {
        final AtomicInteger sentChunks = new AtomicInteger();
import org.opensearch.test.OpenSearchTestCase;
        if (randomBoolean()) {  
                    listener  
        final boolean throwCorruptedIndexException = randomBoolean();
            recoveryTarget,
    }
            RetentionLeases.EMPTY,
            return null;  
        final AtomicBoolean phase1Called = new AtomicBoolean();  
import org.opensearch.action.support.PlainActionFuture;
                    checkpoint = i;
        } catch (CancellableThreads.ExecutionCancelledException e) {  
            recoveryExecutor = threadPool.executor("recovery_executor");
        sendFilesLatch.await();
        final int fileChunkSizeInBytes = between(1, 4096);
                    retentionLeases,
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
                received.set(true);
            int totalTranslogOps,
import org.opensearch.common.lucene.uid.Versions;  
            operations.add(new Translog.Index(index, new Engine.IndexResult(1, 1, i - initialNumberOfDocs, true)));  
                int receivedTotalOps,  
            threadPool,
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))  
                    retentionLeases,  
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
import org.opensearch.index.seqno.SequenceNumbers;
                super.prepareTargetForTranslog(totalTranslogOps, listener);
import org.junit.Before;
                buffer.length + 8,
            handler.canSkipPhase1(
            @Override  
        assertFalse(phase2Called.get());  
            request,
        }
            BytesReference content,  
            between(1, 8)  
            List<FileChunkResponse> chunksToAck = randomSubsetOf(between(1, unrepliedChunks.size()), unrepliedChunks);
                CatalogSnapshot snapshot,
            replyLatch.countDown();  
        });
        }
        final Field versionField = new NumericDocValuesField("_version", Versions.MATCH_ANY);  
    public void testCancelRecoveryDuringPhase1() throws Exception {  
        final List<Translog.Operation> operations = new ArrayList<>();  
 * GitHub history for details.
            shard,
            between(1, 4)  
                    } else {
            future.actionGet();
        }).when(mockShard).failShard(any(), any());
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {  
    static final class FileChunkResponse {
            Document document = new Document();
                    maxSeenAutoIdTimestamp,
        when(replicationGroup.getRoutingTable()).thenReturn(routingTable);
            mockShard,  
        document.add(seqID.seqNo);
                return skippedCount;
                );  
        final ParseContext.Document document = new ParseContext.Document();  
                if (i != ackedChunks.get(i).chunkNumber) {
                boolean lastChunk,
import static java.util.Collections.emptySet;
                recoveryExecutor.execute(() -> listener.onResponse(null));  
            if (randomBoolean()) {
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;  
            between(1, 8),
        replyLatch.await();
        PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
 * ownership. Elasticsearch licenses this file to you under  
            future
            int skippedCount = 0;
        long maxSeqNo = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
        cancelingThread.start();  
                }
        assertFalse(prepareTargetForTranslogCalled.get());
        public void receiveFileInfo(
        long localCheckpoint = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            @Override
        final IndexShard shard = mock(IndexShard.class);
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);  
                    Translog.Operation op = iterator.next();
    class TestRecoveryTargetHandler implements RecoveryTargetHandler {  
        int numOps = randomIntBetween(0, 1000);  
            );
            assertThat(unrepliedChunks, hasSize(sentChunks.get()));
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
            this.listener = listener;
        final IndexShard shard = mock(IndexShard.class);
                BytesReference content,  
            failedEngine.set(true);
    public void testCancellationsDoesNotLeakPrimaryPermits() throws Exception {  
        return new Engine.Index(new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong(), doc);  
        };  
            shard,
        };  
            request,
            .settings(
import org.opensearch.threadpool.TestThreadPool;
        final int expectedOps = (int) (endingSeqNo - startingSeqNo + 1);  
        "index",  
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
        final AtomicBoolean phase1Called = new AtomicBoolean();
        };  
        }
import org.apache.lucene.index.IndexReader;
            between(1, 5),  
    private final ShardId shardId = new ShardId(INDEX_SETTINGS.getIndex(), 1);  
        final AtomicBoolean prepareTargetForTranslogCalled = new AtomicBoolean();
                ActionListener<Void> listener
            randomNonNegativeLong(),  
        @Override
            shard,
            FileSystemUtils.files(
            } else if (randomBoolean()) {  
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));  
import org.junit.After;  
        final RecoverySettings recoverySettings = new RecoverySettings(settings, service);
        handler.sendFiles(
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;  
                final long chunkNumber = chunkNumberGenerator.getAndIncrement();
        } else {
            public int skippedOperations() {  
                long maxSeqNoOfUpdatesOrDeletes,  
 * compatible open source license.
import org.apache.lucene.index.Term;
        assertThat(shippedOps.size(), equalTo(expectedOps));  
            final RetentionLeases retentionLeases,
import static java.util.Collections.emptyMap;
            .build();
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
        sendFilesFuture.actionGet();  
                }  
        expectThrows(DelayRecoveryException.class, () -> {
        );
            );
            @Override
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
            assertNull(unwrappedCorruption);
        // ensure all chunk requests have been completed; otherwise some files on the target are left open.  
 * KIND, either express or implied.  See the License for the
            assertNotNull(ExceptionsHelper.unwrap(e, CancellableThreads.ExecutionCancelledException.class));  
        unrepliedChunks.removeAll(failedChunks);  
        }
            getStartRecoveryRequest(),
            luceneIndex.addFileDetail(md.name(), md.length(), false);  
                    multiFileWriter.writeFileChunk(md, position, content, lastChunk);
import static org.mockito.Mockito.verify;
            ackedChunks.addAll(chunksToAck);  
            for (int i = 0; i < ackedChunks.size(); i++) {  
        final StartRecoveryRequest request = getStartRecoveryRequest();
        @Override
        AssertionError error = expectThrows(AssertionError.class, () -> {
 * SPDX-License-Identifier: Apache-2.0
            final AtomicLong chunkNumberGenerator = new AtomicLong();
                out.write(buffer);  
        }  
        });  
    /*
            ? Store.MetadataSnapshot.EMPTY
            ); // limited by the buffering chunks
        final StartRecoveryRequest startRecoveryRequest = getStartRecoveryRequest();
        RecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {  
                    startingSeqNo,
        final List<FileChunkResponse> unrepliedChunks = new CopyOnWriteArrayList<>();  
        final SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
    }
        assertThat(error.getMessage(), containsString("try to recover [index][1] with sync id but seq_no stats are mismatched:"));
            between(1, 5),
 * specific language governing permissions and limitations
            threadPool,
            indexMetadata.state(IndexMetadata.State.CLOSE);
            int checkpoint = -1;
        Iterator<Translog.Operation> iterator = operations.iterator();
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))
                    endingSeqNo,  
            assertBusy(() -> {  
 * the Apache License, Version 2.0 (the "License"); you may
        document.add(idField);
            ) {  
            threadPool,
            .settings(  
                ActionListener<Void> listener
            null
            recoveryExecutor = threadPool.generic();
            }
                org.apache.lucene.util.Version.LATEST  
                int totalTranslogOps,  
        writer.commit();
                () -> randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE)  
            between(1, 10)
        final AtomicBoolean freed = new AtomicBoolean(true);  
        @Override  
                } else {  
            public Translog.Operation next() {
                    snapshot,  
    }
                newMetadataSnapshot(syncId, Long.toString(localCheckpoint), Long.toString(maxSeqNo), numDocs),  
            between(1, 16),
        IOUtils.close(reader, store, multiFileWriter, targetStore);
            MediaTypeRegistry.JSON,  
        for (int i = 0; i < numDocs; i++) {
    }
            ) {  
        @Override
 * this file be licensed under the Apache-2.0 license or a
        } catch (Exception e) {
            @Override
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.lucene.Lucene;
                long timestamp,  
            public void writeFileChunk(
                for (Translog.Operation operation : operations) {
            startRecoveryRequest,  
                shippedOps.addAll(operations);  
 * Licensed to Elasticsearch under one or more contributor  
                        return op;
            shard,  
                RetentionLeases retentionLeases,
        when(replicationGroup.getRoutingTable()).thenReturn(routingTable);  
        for (int i = initialNumberOfDocs; i < initialNumberOfDocs + numberOfDocsWithValidSequenceNumbers; i++) {
import java.util.List;
        };  
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));
                    cancelRecovery.get().run();  
import org.opensearch.index.engine.RecoveryEngineException;  
            @Override  
                long endingSeqNo,  
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
                if (rarely()) {
                List<Long> phase1ExistingFileSizes,
    }
            mock(RecoveryTargetHandler.class),
            fileChunkSizeInBytes,  
        List<StoreFileMetadata> metas = new ArrayList<>();
                int totalTranslogOps,  
            );  
                final long chunkNumber = chunkNumberGenerator.getAndIncrement();  
                BytesReference content,
        final BytesReference source = new BytesArray(new byte[] { 1 });
                }  
            }  
            randomNonNegativeLong(),
            between(1, 8),
                long position,
                super.phase2(
                boolean skipCreateRetentionLeaseStep  
                if (randomBoolean()) {
        }  
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
                Settings.builder()
                    listener.onFailure(new RuntimeException(new CorruptIndexException("foo", "bar")));
        verify(routingTable, times(5)).getByAllocationId(null);  
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});  
            return null;  
import java.util.stream.Collectors;
            between(1, 4),
    Tests when the replica allocation id is  reflected in source nodes routing table even after 1 retry
import org.opensearch.index.seqno.SeqNoStats;  
                randomIntBetween(0, 100)
                }  
            // verify that both sending and receiving files can be completed with a single thread  
        failedEngine.get();
        }).when(mockShard).failShard(any(), any());
                ActionListener<Void> listener
            }
            ) throws IOException {
        }
            if (randomBoolean()) {
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        }
            Store.MetadataSnapshot sourceMetadata,
        Store targetStore = newStore(createTempDir());
            }
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});  
        for (StoreFileMetadata md : metadata) {  
        document.add(seqID.primaryTerm);  
            ) {
            : new Store.MetadataSnapshot(
        // that the permit is released.
import org.opensearch.test.CorruptionUtils;
import static org.hamcrest.Matchers.instanceOf;  
        for (StoreFileMetadata md : metadata) {
        when(shard.isRelocatedPrimary()).thenReturn(false);  
    private static List<Translog.Operation> generateOperations(int numOps) {  
                    listener.onFailure(new RuntimeException("test - failed to index"));
                StoreFileMetadata md,  
        final IndexShard shard = mock(IndexShard.class);
                    maxSeenAutoIdTimestamp,
            metas.add(md);
import java.nio.file.Path;  
import org.opensearch.index.shard.IndexShardState;
        List<FileChunkResponse> ackedChunks = new ArrayList<>();
 * not use this file except in compliance with the License.
                assertThat(receivedTotalOps, equalTo(numOps));  
        });  
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> {});
                prepareTargetForTranslogCalled.set(true);  
                    return null;  
        writer.close();
        }
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
                    listener.onResponse(SequenceNumbers.NO_OPS_PERFORMED);  
        latch.await();
import org.opensearch.core.common.bytes.BytesArray;
                localCheckpoint,
        for (int i = 0; i < numDocs; i++) {  
        IndexShard shard = mock(IndexShard.class);  
                assertThat(receivedRetentionLease, equalTo(retentionLeases));
        });
                newMetadataSnapshot(syncId, Long.toString(localCheckpointOnTarget), Long.toString(maxSeqNoOnTarget), numDocs)
        );
        when(shard.getRetentionLeases()).thenReturn(mock(RetentionLeases.class));
import org.opensearch.test.IndexSettingsModule;  
                long mappingVersion,  
        assertThat(result.sentOperations, equalTo(expectedOps));
        }
            int expectedSentChunks = sentChunks.get() + chunksToSend;  
                phase2Called.set(true);
        when(shardRouting.currentNodeId()).thenReturn("node");  
            assertEquals(ex.getMessage(), "[File corruption occurred on recovery but checksums are ok]");
                boolean lastChunk,  
        );  
        if (randomBoolean()) {  
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.document.NumericDocValuesField;
import org.opensearch.common.util.io.IOUtils;  
        PlainActionFuture<Void> sendFilesFuture = new PlainActionFuture<>();
        List<Translog.Operation> sortedShippedOps = shippedOps.stream()  
        List<StoreFileMetadata> files = generateFiles(store, between(1, 10), () -> between(1, chunkSize * 20));
                    multiFileWriter.writeFileChunk(md, position, content, lastChunk);
    }
            assertThat(error.getMessage(), equalTo("Phase[2] failed to send/replay operations"));
            final AtomicLong chunkNumberGenerator = new AtomicLong();  
        terminate(threadPool);
            new TestRecoveryTargetHandler(),
                    localCheckpoint.addAndGet(randomIntBetween(1, 100));
        return newStore(path, true);
        final ParsedDocument doc = new ParsedDocument(
        }  
                int totalTranslogOps,
    recoveries should fail
                ActionListener<SendFileResult> listener,
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));  
import java.util.Map;  
            store,
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());  
            shard,  
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
        final List<Translog.Operation> ops = new ArrayList<>();  
                    mappingVersion,
        return operations;
        final AtomicBoolean phase2Called = new AtomicBoolean();
        );
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
        if (randomBoolean()) {
            ackedChunks.sort(Comparator.comparing(c -> c.chunkNumber));
        for (Translog.Operation op : operations) {  
/*  
        Set<Long> sentSeqNos = new HashSet<>();
                });
                logger.info("--> write chunk name={} seq={}, position={}", md.name(), chunkNumber, position);
        }
            between(1, 10)
            between(1, 4)  
import org.opensearch.common.lease.Releasable;  
                long msu,  
            baseDirectoryWrapper.setCheckIndexOnClose(false); // don't run checkindex we might corrupt the index in these tests
        int totalChunks = files.stream().mapToInt(md -> ((int) md.length() + chunkSize - 1) / chunkSize).sum();
                assertThat(receivedMaxSeqNoOfUpdatesOrDeletes, equalTo(maxSeqNoOfUpdatesOrDeletes));  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                ActionListener<Long> listener
            operations.add(new Translog.Index(index, new Engine.IndexResult(1, 1, SequenceNumbers.UNASSIGNED_SEQ_NO, true)));
    }
        });
            between(1, 8)  
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);
                sentChunks.incrementAndGet();
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
            between(1, 8),  
        @Override
            return null;
            .collect(Collectors.toList());
        handler.sendFiles(store, metas.toArray(new StoreFileMetadata[0]), () -> 0, sendFilesFuture);  
import static org.hamcrest.Matchers.hasSize;
            new AsyncRecoveryTarget(target, recoveryExecutor),  
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
        if (throwCorruptedIndexException) {  
    }
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));  
            ) {
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {
                    wasCancelled.set(true);
                ActionListener<Void> listener
                ActionListener<Long> listener  
                long maxSeenAutoIdTimestamp,
            between(1, 5)  
        Directory dir = store.directory();
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
                () -> randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE)
import org.opensearch.core.index.shard.ShardId;
            handler.canSkipPhase1(
            between(1, 8),
        assertFalse(phase1Called.get());  
    public void testSendOperationsConcurrently() throws Throwable {  
            final Engine.Index index = getIndex(Integer.toString(i));  
        List<Translog.Operation> operations = generateOperations(numOps);
            }
        }  
                ActionListener<SendSnapshotResult> listener  
 * this work for additional information regarding copyright
        final int maxConcurrentChunks = between(1, 4);  
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
            new AsyncRecoveryTarget(recoveryTarget, threadPool.generic()),  
            assertNotNull(unwrappedCorruption);
        return new Store.MetadataSnapshot(Collections.emptyMap(), userData, numDocs);
                StoreFileMetadata md,
            mock(RecoveryTargetHandler.class),
        }  
import java.util.Queue;
            final long seqNo = randomValueOtherThanMany(n -> seqNos.add(n) == false, OpenSearchTestCase::randomNonNegativeLong);
                phase1Called.set(true);  
                RetentionLeases retentionLeases,
                List<Translog.Operation> operations,  
        ) {}
            null,  
        when(routingTable.getByAllocationId(any())).thenReturn(null, shardRouting);
            @Override  
                    break;
            ) {
                long mappingVersion,  
        long maxSeenAutoIdTimestamp = randomBoolean() ? -1 : randomNonNegativeLong();
                } else {
            long position,
        final int maxConcurrentChunks = between(1, 8);
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
                new SegmentInfosCatalogSnapshot(Lucene.readSegmentInfos(DirectoryReader.listCommits(dir).get(0))),
                phase2Called.set(true);
        long endingSeqNo = startingSeqNo + randomIntBetween(0, 10000);
                phase2Called.set(true);  
            ) {
        }  
        writer.commit();
import org.opensearch.test.VersionUtils;
        handler.sendFiles(store, files.toArray(new StoreFileMetadata[0]), () -> 0, sendFilesFuture);
                phase1Called.set(true);
        assertTrue(failedEngine.get());
        // we have to use assert busy as we may be interrupted while acquiring the permit, if so we want to check
                    mappingVersion,
            )
import org.opensearch.core.util.FileSystemUtils;
import java.util.Set;
                    )
            writer.addDocument(document);  
        List<StoreFileMetadata> metas = new ArrayList<>();  
                long endingSeqNo,  
        RecoverySourceHandler.SendSnapshotResult result = future.actionGet();
            chunkSize,  
        assertFalse(prepareTargetForTranslogCalled.get());
            @Override
            void phase2(
                long maxSeenAutoIdTimestamp,
            @Override
            between(1, 10)
    */
        });
                ActionListener.completeWith(listener, () -> {
            getStartRecoveryRequest(),  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))  
            maxConcurrentChunks,
        AtomicBoolean received = new AtomicBoolean();
                (p) -> (p.getFileName().toString().equals("write.lock") || p.getFileName().toString().startsWith("extra")) == false
            ) {
            public void writeFileChunk(
            operations.add(op);
        final byte[] source = "{}".getBytes(StandardCharsets.UTF_8);
import org.apache.lucene.index.DirectoryReader;  
                long receivedMappingVersion,
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
        };  
            shard,
                long startingSeqNo,  
        IOUtils.close(store);
            void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
 *
        PlainActionFuture<RecoverySourceHandler.SendSnapshotResult> future = new PlainActionFuture<>();
            @Override  
    }  
        Exception ex = expectThrows(Exception.class, sendFilesFuture::actionGet);
            );  
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        PlainActionFuture<Void> sendFilesFuture = new PlainActionFuture<>();
                long globalCheckpoint,
    }  
import org.opensearch.index.engine.SegmentsStats;
                unrepliedChunks.add(new FileChunkResponse(chunkNumber, listener));
import static org.mockito.Mockito.when;
            c.listener.onFailure(new IllegalStateException("test chunk exception"));
        cancelingThread.join();  
        when(shard.state()).thenReturn(IndexShardState.STARTED);
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));  
            store.directory().sync(Collections.singleton(md.name()));  
        doAnswer(invocation -> {  
    private ThreadPool threadPool;  
    public void tearDownThreadPool() {
        for (int i = 0; i < numOps; i++) {
    public void testSendFileChunksStopOnError() throws Exception {  
                if (randomBoolean()) {
        when(shard.state()).thenReturn(IndexShardState.STARTED);
            between(1, 16),
                }
            public void writeFileChunk(
        assertBusy(() -> {  
            null,  
                () -> 0,
        unrepliedChunks.forEach(c -> {
 */  
                    listener
        sendFilesFuture.actionGet();
        final long endingSeqNo = randomLongBetween(startingSeqNo, ops.size() - 1L);  
        final int chunkSize = between(1, 16);
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);  
            threadPool = new TestThreadPool(
                StoreFileMetadata md,
            chunkSize,
                new LatchedActionListener<>(phase1Listener, latch),
import org.opensearch.ExceptionsHelper;
        }
                    startingSeqNo,
                    endingSeqNo,
        };  
import java.io.IOException;  
            files.add(md);
        assertThat(sendFilesError.get(), instanceOf(IOException.class));
            .sorted(Comparator.comparing(Translog.Operation::seqNo))
        int numDocs = randomIntBetween(10, 100);  
            Document document = new Document();  
        RetentionLeases retentionLeases = new RetentionLeases(randomNonNegativeLong(), randomNonNegativeLong(), Collections.emptySet());  
import org.opensearch.common.util.CancellableThreads;
                );  
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),  
                    if (operationsToSkip.contains(op)) {
                RetentionLeases retentionLeases,
            }  
            ActionListener<Void> listener
import java.util.concurrent.atomic.AtomicInteger;
        when(shard.isRelocatedPrimary()).thenReturn(false);
            request,  
            maxSeenAutoIdTimestamp,
            );
        int numDocs = randomIntBetween(10, 100);
                final String leaseId = ReplicationTracker.getPeerRecoveryRetentionLeaseId(startRecoveryRequest.targetNode().getId());
            public int totalOperations() {
            future.actionGet();
            ) {
        handler.sendFiles(
    }  
        }  
            future  
            boolean lastChunk,
        doAnswer(invocation -> {
        final AtomicBoolean phase1Called = new AtomicBoolean();
            }
        final StartRecoveryRequest request = getStartRecoveryRequest();  
        AtomicBoolean failedEngine = new AtomicBoolean(false);  
import org.opensearch.index.mapper.SeqNoFieldMapper;
            @Override  
        List<StoreFileMetadata> files = new ArrayList<>();  
            }
        final StepListener<RecoverySourceHandler.SendFileResult> phase1Listener = new StepListener<>();
            handler.recoverToTarget(future);  
            final Engine.Index index = getIndex(Integer.toString(i));
            handler.recoverToTarget(future);  
            long localCheckpointOnTarget = randomValueOtherThan(  
import java.nio.charset.StandardCharsets;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersion(random()))  
                assertThat(sentChunks.get(), equalTo(expectedSentChunks));
                CatalogSnapshot snapshot,  
                out.write(Numbers.longToBytes(digest.getValue()));
            @Override  
        };  
                listener.onResponse(localCheckpoint.get());
        List<FileChunkResponse> failedChunks = randomSubsetOf(between(1, unrepliedChunks.size()), unrepliedChunks);
        final IndexShard shard = mock(IndexShard.class);
        verify(routingTable, times(2)).getByAllocationId(null);  
    public void setUpThreadPool() {
                ActionListener<SendSnapshotResult> listener
                ActionListener<Void> listener  
            latch.await();
            )
        when(shardRouting.initializing()).thenReturn(true);
        );  
import org.opensearch.common.unit.TimeValue;  
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
            List<String> phase1FileNames,
 *
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        Translog.Snapshot snapshot = newTranslogSnapshot(operations, skipOperations);
import org.opensearch.index.translog.Translog;
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
            ) {
import org.apache.lucene.store.Directory;  
            handler.phase1(
            indexMetadata.state(IndexMetadata.State.CLOSE);
        final ShardRouting shardRouting = mock(ShardRouting.class);
        ) {
        );  
                    checkpointOnTarget.addAndGet(between(1, 20));
        Store targetStore = newStore(createTempDir(), false);
            final CountDownLatch latch = new CountDownLatch(1);  
        Directory dir = store.directory();  
        final StartRecoveryRequest request = getStartRecoveryRequest();
    If the replica allocation id is not reflected in source nodes routing table even after retries,  
        assertTrue(received.get());
                boolean lastChunk,  
            }  
                });
        if (wasFailed.get()) {
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());  
        public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {}
            assertTrue(wasCancelled.get());
            public void cleanFiles(  
            void phase1(
import org.opensearch.index.IndexSettings;
        final AtomicBoolean wasFailed = new AtomicBoolean();
        Store store = newStore(tempDir, false);  
                ActionListener<Long> listener
        );  
            null,
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());  
        Map<String, String> userData = new HashMap<>();
        when(shard.state()).thenReturn(IndexShardState.STARTED);
            final List<Translog.Operation> operations,  
import org.opensearch.index.mapper.Uid;
                        leaseId,
                super.prepareTargetForTranslog(totalTranslogOps, listener);  
            final Translog.Operation op;  
            maxConcurrentChunks,
                long receivedMaxSeenAutoIdTimestamp,
                long mappingVersion,
            void phase1(
            }
                ActionListener<Void> listener
            threadPool,  
    public void testHandleExceptionOnSendFiles() throws Throwable {
                    return null;  
        return new Translog.Snapshot() {  
            threadPool,
                long receivedMaxSeqNoOfUpdatesOrDeletes,
        Store.MetadataSnapshot metadata = store.getMetadata();  
import java.util.Iterator;
import org.apache.lucene.tests.store.BaseDirectoryWrapper;  
                long startingSeqNo,  
        final StartRecoveryRequest request = getStartRecoveryRequest();  
            ) throws IOException {
            }
                return operations.size();
            recoveryTarget,  
        Store store = newStore(createTempDir(), false);
            @Override
            int expectedUnrepliedChunks = unrepliedChunks.size() + chunksToSend;
    }  
        when(routingTable.getByAllocationId(anyString())).thenReturn(null);  
import org.apache.lucene.tests.index.RandomIndexWriter;
    private Translog.Snapshot newTranslogSnapshot(List<Translog.Operation> operations, List<Translog.Operation> operationsToSkip) {
        };  
        String syncId = UUIDs.randomBase64UUID();  
            luceneIndex.addFileDetail(md.name(), md.length(), false);
            }
import java.util.zip.CRC32;
                assertThat(unrepliedChunks, hasSize(expectedUnrepliedChunks));
            @Override  
                    wasFailed.set(true);  
 */
        RandomIndexWriter writer = new RandomIndexWriter(random(), dir, newIndexWriterConfig());
            @Override
                } else {
                }
        final StartRecoveryRequest request = getStartRecoveryRequest();
                long startingSeqNo,
        IndexShard mockShard = mock(IndexShard.class);
        };  
        }  
                logger.info("--> write chunk name={} seq={}, position={}", md.name(), chunkNumber, position);  
 */
            phase1Listener.result();  
            }
        Randomness.shuffle(operations);  
        AtomicBoolean wasCancelled = new AtomicBoolean();  
            );
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
                        ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
                Store.MetadataSnapshot sourceMetadata,  
        final long startingSeqNo = randomIntBetween(0, numberOfDocsWithValidSequenceNumbers - 1);
        final long endingSeqNo = randomLongBetween(startingSeqNo, numberOfDocsWithValidSequenceNumbers - 1);  
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
    private final ClusterSettings service = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    maxSeqNoOfUpdatesOrDeletes,
            final long timestamp,
            @Override
        assertThat(result.targetLocalCheckpoint, equalTo(checkpointOnTarget.get()));
            randomNonNegativeLong(),  
            threadPool,  
            ) {  
                super.prepareTargetForTranslog(totalTranslogOps, listener);  
        when(shard.isRelocatedPrimary()).thenReturn(true);
import org.opensearch.index.mapper.IdFieldMapper;
            getStartRecoveryRequest(),
    }
import org.apache.lucene.document.TextField;
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));  
import org.apache.lucene.document.Document;  
 * Unless required by applicable law or agreed to in writing,
            shard,  
                List<Long> phase1FileSizes,  
                );  
        CountDownLatch replyLatch = new CountDownLatch(failedChunks.size());  
                long endingSeqNo,
        PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
    private Store newStore(Path path, boolean checkIndex) throws IOException {
        assertFalse(phase2Called.get());
            }  
    }
    }  
        handler.sendFiles(store, metas.toArray(new StoreFileMetadata[0]), () -> 0, sendFilesFuture);
import static org.mockito.Mockito.anyString;  
                c.listener.onFailure(new RuntimeException("test"));  
import java.util.Comparator;
                long mappingVersion,
            mock(RecoveryTargetHandler.class),
            List<String> phase1ExistingFileNames,
        IOUtils.close(store, multiFileWriter, targetStore);
                prepareTargetForTranslogCalled.set(true);
import java.util.concurrent.atomic.AtomicLong;
        when(shard.state()).thenReturn(IndexShardState.STARTED);
 * This covers test cases for {@link RecoverySourceHandler} and {@link LocalStorePeerRecoverySourceHandler}.
        );
    public void testSendSnapshotStopOnError() throws Exception {
                List<String> phase1FileNames,
        };  
            between(1, 4),
package org.opensearch.indices.recovery;
/*
            }
/*
            byte[] buffer = randomByteArrayOfLength(fileSizeSupplier.getAsInt());
        long mappingVersion = randomNonNegativeLong();
            request,  
import org.opensearch.index.mapper.ParseContext;
        assertFalse(failedEngine.get());
        return files;  
    }
            );
        );  
            }
        public void writeFileChunk(  
import java.io.OutputStream;
            retentionLeases,  
        final int chunkSize = between(1, 32);  
        }  
            }
        Store store = newStore(tempDir, false);
            indexMetadata.state(IndexMetadata.State.CLOSE);
        when(shard.store()).thenReturn(store);  
        final IndexShardRoutingTable routingTable = mock(IndexShardRoutingTable.class);
        @Override  
            threadPool,
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        CountDownLatch latch = new CountDownLatch(1);  
                RetentionLeases retentionLeases,
            ) throws IOException {
        } else {  
import org.opensearch.action.LatchedActionListener;  
                    receivedSeqNos.add(operation.seqNo());
                while (iterator.hasNext()) {  
        store.close();  
                op = new Translog.NoOp(seqNo, randomNonNegativeLong(), "test");  
        for (int i = 0; i < shippedOps.size(); i++) {
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        int numDocs = randomIntBetween(10, 100);
        @Override
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
            threadPool = new TestThreadPool(getTestName());  
        List<StoreFileMetadata> metas = new ArrayList<>();  
            () -> 0,
import org.opensearch.index.shard.IndexShard;
        IndexShard shard = mock(IndexShard.class);
        doAnswer(invocation -> {  
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));  
            @Override  
        ) {
                long position,  
    }
        writer.close();
    private Executor recoveryExecutor;
        IndexShard mockShard = mock(IndexShard.class);
                if (randomBoolean()) {
import org.opensearch.core.action.ActionListener;
                    retentionLeases,  
        final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, service);  
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
            userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, localCheckpoint);
            return null;
            assertThat(error.getCause().getMessage(), equalTo("test - failed to index"));
        final AtomicLong checkpointOnTarget = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        writer.close();
        SetOnce<Exception> sendFilesError = new SetOnce<>();
        Store store = newStore(createTempDir("source"), false);
            .put("indices.recovery.concurrent_streams", 1)
        final List<FileChunkResponse> unrepliedChunks = new CopyOnWriteArrayList<>();
                boolean skipCreateRetentionLeaseStep
import org.apache.lucene.document.Field;
                tempDir,  
            }
            }
            sendFuture
                assertThat(receivedMaxSeenAutoIdTimestamp, equalTo(maxSeenAutoIdTimestamp));
            }  
            Arrays.asList(document),
        PlainActionFuture<RecoverySourceHandler.SendSnapshotResult> future = new PlainActionFuture<>();
            }
        }
        assertEquals(0, recoveryDiff.missing.size());
            List<Long> phase1ExistingFileSizes,
        BaseDirectoryWrapper baseDirectoryWrapper = LocalStorePeerRecoverySourceHandlerTests.newFSDirectory(path);  
        ) {}
            Document document = new Document();
            randomNonNegativeLong(),
        List<Translog.Operation> skipOperations = randomSubsetOf(operations);
        store.close();
        when(mockShard.shardId()).thenReturn(new ShardId("testIndex", "testUUID", 0));
            CRC32 digest = new CRC32();  
import org.opensearch.common.settings.Settings;
            } else {
            public void writeFileChunk(
                getTestName(),
                unrepliedChunks.add(new FileChunkResponse(chunkNumber, listener));
        final IndexShardRoutingTable routingTable = mock(IndexShardRoutingTable.class);  
        final StartRecoveryRequest request = getStartRecoveryRequest();  
                super.phase2(  
                int totalTranslogOps,
        Path tempDir = createTempDir();
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
    }
        when(shard.isRelocatedPrimary()).thenReturn(false);  
        assertThat(sendSnapshotResult.sentOperations, equalTo(receivedSeqNos.size()));
                Store.digestToString(digest.getValue()),
        assertThat(sendFilesError.get().getMessage(), containsString("test chunk exception"));
            newTranslogSnapshot(operations, Collections.emptyList()),
import java.util.function.IntSupplier;  
        expectThrows(IndexShardRelocatedException.class, () -> {
            between(1, 10),
                StoreFileMetadata md,  
        );  
        Store.MetadataSnapshot metadata = store.getMetadata();
        userData.put(Engine.SYNC_COMMIT_ID, syncId);  
                op = new Translog.Index("id", seqNo, randomNonNegativeLong(), randomNonNegativeLong(), source, null, -1);
        final long startingSeqNo = randomLongBetween(0, ops.size() - 1L);
        assertThat(sendFilesError.get(), instanceOf(IllegalStateException.class));  
                Translog.Snapshot snapshot,
            public void indexTranslogOperations(
            }  
        handler.phase2(  
            assertFalse(failedEngine.get());
        Store.MetadataSnapshot targetStoreMetadata = targetStore.getMetadata();
        assertThat("no more chunks should be sent", sentChunks.get(), equalTo(Math.min(totalChunks, maxConcurrentChunks)));
        when(mockShard.shardId()).thenReturn(new ShardId("testIndex", "testUUID", 0));
        );  
            () -> 0,
                long position,
                    snapshot,
                CatalogSnapshot snapshot,
                        skippedCount++;  
import org.opensearch.index.seqno.RetentionLeases;
            new AsyncRecoveryTarget(target, recoveryExecutor),
import org.opensearch.common.concurrent.GatedCloseable;
                RetentionLeases retentionLeases,
                    endingSeqNo,
        final AtomicBoolean phase2Called = new AtomicBoolean();
            writer.addDocument(document);
        @Override
import org.apache.lucene.document.StringField;  
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);  
            metas.add(md);
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
import java.util.HashSet;  
        if (randomBoolean()) {
        }
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(() -> freed.set(true));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                newMetadataSnapshot(syncId, Long.toString(localCheckpoint), Long.toString(maxSeqNo), numDocs),  
        return new StartRecoveryRequest(
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
        AtomicLong localCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertThat(sortedShippedOps.get(i), equalTo(operations.get(i + (int) startingSeqNo + initialNumberOfDocs)));
            chunksToAck.forEach(c -> c.listener.onResponse(null));
        for (int numOps = between(1, 256), i = 0; i < numOps; i++) {
        List<StoreFileMetadata> files = generateFiles(store, between(1, 10), () -> between(1, chunkSize * 20));  
            failedEngine.set(true);
        SetOnce<Exception> sendFilesError = new SetOnce<>();
        handler.phase2(
        handler.waitForAssignmentPropagate(new SetOnce<>());
    }
                int totalTranslogOps,
                    wasCancelled.set(true);  
            randomNonNegativeLong(),
    public void testSendSnapshotSendsOps() throws IOException {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 5))
            assertEquals(ex.getMessage(), "boom");
import org.opensearch.Version;
        when(shard.segmentStats(anyBoolean(), anyBoolean())).thenReturn(mock(SegmentsStats.class));
        doAnswer(invocation -> {
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {  
import java.util.HashMap;
    public void testSendFiles() throws Throwable {
                int totalTranslogOps,
 * license agreements. See the NOTICE file distributed with
                ActionListener<SendFileResult> listener,
        return new Store(shardId, INDEX_SETTINGS, baseDirectoryWrapper, new DummyShardLock(shardId));
            new AsyncRecoveryTarget(recoveryTarget, threadPool.generic()),  
            int chunksToSend = Math.min(
import static org.hamcrest.Matchers.equalTo;
            StoreFileMetadata md = new StoreFileMetadata(
        final TestRecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {  
        final TestRecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
            public void writeFileChunk(  
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
    public void testHandleCorruptedIndexOnSendSendFiles() throws Throwable {  
        }  
        final List<Translog.Operation> operations = new ArrayList<>(numOps);
        );  
                StoreFileMetadata md,
                if (randomBoolean()) {
            versionField,  
        if (maxSeqNo != null) {
                IntSupplier translogOps,
        public void cleanFiles(
            digest.update(buffer, 0, buffer.length);
    /*  
        assertNotNull(ExceptionsHelper.unwrapCorruption(sendFilesError.get()));  
            }
        when(shard.state()).thenReturn(IndexShardState.STARTED);
            );
                int totalTranslogOps,
        PlainActionFuture<Void> sendFilesFuture = new PlainActionFuture<>();
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any());
            } else {
        );
            ActionListener<Void> listener  
        final IndexShard shard = mock(IndexShard.class);  
        final StartRecoveryRequest request = getStartRecoveryRequest();
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
                Translog.Snapshot snapshot,
        when(shard.acquireSafeCatalogSnapshot()).thenReturn(mock(GatedCloseable.class));
            metadataSnapshot,  
        Directory dir = store.directory();
                IntSupplier translogOps,
            new LatchedActionListener<>(ActionListener.wrap(r -> sendFilesError.set(null), e -> sendFilesError.set(e)), sendFilesLatch)
            return null;
                RetentionLeases receivedRetentionLease,  
import org.opensearch.index.seqno.ReplicationTracker;  
        RecoverySourceHandler.SendSnapshotResult sendSnapshotResult = sendFuture.actionGet();
import java.util.concurrent.CopyOnWriteArrayList;  
                0,  
            final long mappingVersion,
            mockShard,  
        ReplicationLuceneIndex luceneIndex = new ReplicationLuceneIndex();
        final Queue<Translog.Operation> shippedOps = ConcurrentCollections.newQueue();
            }
            between(1, 5)
                ActionListener.completeWith(listener, () -> {
import org.apache.lucene.store.IOContext;
import java.util.Arrays;
import org.opensearch.common.Randomness;
    private Engine.Index getIndex(final String id) {
        Directory dir = store.directory();
                Collections.emptyMap(),  
                    cancelRecovery.get().run();
            @Override
        );  
        assertThat(sendSnapshotResult.targetLocalCheckpoint, equalTo(localCheckpoint.get()));  
        for (StoreFileMetadata md : metadata) {
import org.opensearch.index.engine.Engine;
            @Override  
            fileChunkSizeInBytes,  
    @Before  
                Collections.singletonMap(Engine.HISTORY_UUID_KEY, UUIDs.randomBase64UUID()),
            document.add(new StringField("id", Integer.toString(i), Field.Store.YES));
    public void testTargetInRoutingInSecondAttempt() throws IOException {  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
                Settings.builder()  
            final int totalTranslogOps,
import org.opensearch.index.store.Store;
        Store store = newStore(createTempDir(), false);
    }  
            between(1, 8)
            ) {
        ReplicationLuceneIndex luceneIndex = new ReplicationLuceneIndex();
                if (randomBoolean()) {
        final int initialNumberOfDocs = randomIntBetween(10, 1000);
            between(1, 8)  
    private List<StoreFileMetadata> generateFiles(Store store, int numFiles, IntSupplier fileSizeSupplier) throws IOException {
    @After  
                boolean lastChunk,
            request,  
        }  
        final int fileChunkSizeInBytes = between(1, 10 * 1024);
            writer.addDocument(document);
        Set<Long> receivedSeqNos = ConcurrentCollections.newConcurrentSet();  
            }
import org.opensearch.common.Numbers;
import java.util.Collections;  
            void phase2(
import java.util.concurrent.atomic.AtomicBoolean;  
    private Store.MetadataSnapshot newMetadataSnapshot(String syncId, String localCheckpoint, String maxSeqNo, int numDocs) {
                sentChunks.incrementAndGet();  
        when(shard.acquireSafeIndexCommit()).thenReturn(mock(GatedCloseable.class));
            if (startingSeqNo <= op.seqNo() && op.seqNo() <= endingSeqNo && skipOperations.contains(op) == false) {
                int totalTranslogOps,  
        ) {}  
                long msu,
                super.phase2(  
                    cancelRecovery.get().run();  
            @Override
                c.listener.onResponse(null);
            new AsyncRecoveryTarget(target, recoveryExecutor),
        assertEquals(0, recoveryDiff.different.size());
            }
    }
            threadPool,
            ) {
            random(),
import org.opensearch.cluster.metadata.IndexMetadata;  
            }
        long maxSeqNoOfUpdatesOrDeletes = randomBoolean() ? -1 : randomNonNegativeLong();
            try (OutputStream out = new IndexOutputOutputStream(store.createVerifyingOutput(md.name(), md, IOContext.DEFAULT))) {
        final IndexShard shard = mock(IndexShard.class);
        ) {
            new LatchedActionListener<>(ActionListener.wrap(r -> sendFilesError.set(null), e -> sendFilesError.set(e)), latch)
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(  
        document.add(seqID.seqNoDocValue);
import static org.mockito.Mockito.anyBoolean;
            );  
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
            ) {
            long maxSeqNoOnTarget = randomValueOtherThan(
        }
        IndexReader reader = DirectoryReader.open(targetStore.directory());  
        Store.RecoveryDiff recoveryDiff = targetStoreMetadata.recoveryDiff(metadata);
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(0, 5))
        }
                    maxSeqNoOfUpdatesOrDeletes,  
        public void forceSegmentFileSync() {}
            }
    }
            randomBoolean() || metadataSnapshot.getHistoryUUID() == null ? SequenceNumbers.UNASSIGNED_SEQ_NO : randomNonNegativeLong()  
            public void close() {  
        int numDocs = randomIntBetween(10, 100);  
            unrepliedChunks.removeAll(chunksToAck);
        document.add(versionField);  
                long startingSeqNo,  
        final IndexShard shard = mock(IndexShard.class);
            randomNonNegativeLong(),
                ActionListener<SendFileResult> listener,  
    public StartRecoveryRequest getStartRecoveryRequest() throws IOException {
        final org.opensearch.index.shard.ReplicationGroup replicationGroup = mock(org.opensearch.index.shard.ReplicationGroup.class);
        writer.commit();
import static org.hamcrest.Matchers.containsString;  
        writer.commit();  
            public void indexTranslogOperations(  
            new AsyncRecoveryTarget(target, recoveryExecutor),
                }
            id,
        AtomicBoolean failedEngine = new AtomicBoolean(false);
    public void testThrowExceptionOnPrimaryRelocatedBeforePhase1Started() throws IOException {
                long maxSeqNoOfUpdatesOrDeletes,
            store,
            metas.toArray(new StoreFileMetadata[0]),  
            void createRetentionLease(long startingSeqNo, ActionListener<RetentionLease> listener) {  
        );
        );
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID(random()))
        final ActionListener<Void> listener;  
                sentSeqNos.add(op.seqNo());
        Settings settings = Settings.builder()
        for (int i = 0; i < numDocs; i++) {
        final Set<Long> seqNos = new HashSet<>();  
                BytesReference content,
import org.opensearch.threadpool.FixedExecutorBuilder;  
        }
        final TestRecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
import java.util.concurrent.Executor;
                BytesReference content,
        for (int i = 0; i < initialNumberOfDocs; i++) {
        final Field idField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
            assertFalse(failedEngine.get());
        final RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(  
                );
}  
                super.phase1(snapshot, startingSeqNo, translogOps, listener, skipCreateRetentionLeaseStep);  
        Store.MetadataSnapshot metadataSnapshot = randomBoolean()  
                return null;
        assertFalse(phase1Called.get());
        when(shard.indexSettings()).thenReturn(new IndexSettings(indexMetadata.build(), Settings.EMPTY));  
                listener.onResponse(
            source,
            between(1, 5)
            between(1, 10),
            newTranslogSnapshot(ops, Collections.emptyList()),
                Settings.builder()  
        cancelRecovery.set(() -> handler.cancel("test"));  
                phase1Called.set(true);
        IOUtils.close(() -> terminate(threadPool), () -> threadPool = null);
                List<String> phase1ExistingFileNames,
                BytesReference content,
            endingSeqNo,  
        MultiFileWriter multiFileWriter = new MultiFileWriter(targetStore, luceneIndex, "", logger, () -> {});
            long globalCheckpoint,  
            shard,  
        final org.opensearch.index.shard.ReplicationGroup replicationGroup = mock(org.opensearch.index.shard.ReplicationGroup.class);
    );
        }  
        RecoveryTargetHandler recoveryTarget = new TestRecoveryTargetHandler() {
            });  
        public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {}
        FileChunkResponse(long chunkNumber, ActionListener<Void> listener) {
    }  
            freed.set(false);  
import org.opensearch.test.DummyShardLock;
            int totalTranslogOps,  
        RecoverySourceHandler handler = new LocalStorePeerRecoverySourceHandler(
        Path tempDir = createTempDir();
 *  
                    }  
            RetentionLeases.EMPTY,
        assertEquals(metas.size(), recoveryDiff.identical.size());  
        final StartRecoveryRequest request = getStartRecoveryRequest();
                op = new Translog.Delete("id", seqNo, randomNonNegativeLong(), randomNonNegativeLong());
            shardId,
        long startingSeqNo = randomIntBetween(0, 1000);  
                new FixedExecutorBuilder(Settings.EMPTY, "recovery_executor", between(1, 16), between(16, 128), "recovery_executor")  
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
            startingSeqNo,  
            @Override
                    maxSeenAutoIdTimestamp,
                    maxSeqNoOfUpdatesOrDeletes,
            );
            final ActionListener<Long> listener  
            public void indexTranslogOperations(
        when(shard.seqNoStats()).thenReturn(mock(SeqNoStats.class));
                    mappingVersion,
        int totalChunks = files.stream().mapToInt(md -> ((int) md.length() + chunkSize - 1) / chunkSize).sum();  
            Document document = new Document();
                boolean lastChunk,  
        handler.phase2(
                        startingSeqNo,
                prepareTargetForTranslogCalled.set(true);
                long maxSeqNoOfUpdatesOrDeletes,  
import org.opensearch.indices.RunUnderPrimaryPermit;
            List<Long> phase1FileSizes,  
            threadPool,
import org.opensearch.action.StepListener;
            @Override
import org.opensearch.common.UUIDs;
        PlainActionFuture<RecoverySourceHandler.SendSnapshotResult> sendFuture = new PlainActionFuture<>();
                    snapshot,  
        for (int i = 0; i < numFiles; i++) {
            startingSeqNo,
        Store.MetadataSnapshot metadata = store.getMetadata();
                recoveryExecutor.execute(() -> listener.onResponse(null));  
                    listener
                boolean lastChunk,
            writer.addDocument(document);
        int numDocs = between(0, 1000);
            randomBoolean(),
            userData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, maxSeqNo);
            null,  
                "test-" + i,  
                false  
            @Override  
            int totalTranslogOps,
                }
        final long chunkNumber;
        Store store = newStore(createTempDir());
                }
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.ShardRouting;  
            threadPool,
            maxSeqNoOfUpdatesOrDeletes,
        assertThat(receivedSeqNos, equalTo(sentSeqNos));
            public void receiveFileInfo(
        };
        final int numberOfDocsWithValidSequenceNumbers = randomIntBetween(10, 1000);  
        );
                newMetadataSnapshot(syncId, Long.toString(localCheckpoint), Long.toString(maxSeqNo), numDocs)
import java.util.concurrent.CountDownLatch;
        };
            ActionListener<Void> listener
 * under the License.  
                boolean skipCreateRetentionLeaseStep  
        writer.close();  
            public void writeFileChunk(
            @Override
                    listener.onFailure(new RuntimeException("boom"));  
     */
                StoreFileMetadata md,  
            between(1, 10),
        CorruptionUtils.corruptFile(  
import org.opensearch.index.shard.IndexShardRelocatedException;  
        MultiFileWriter multiFileWriter = new MultiFileWriter(targetStore, luceneIndex, "", logger, () -> {});
                recoveryExecutor.execute(() -> listener.onResponse(null));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final AtomicInteger sentChunks = new AtomicInteger();
        assertTrue(
                assertThat(receivedMappingVersion, equalTo(mappingVersion));
            endingSeqNo,
        public void indexTranslogOperations(
                int totalTranslogOps,
        assertEquals(numDocs, reader.maxDoc());
                int totalTranslogOps,
        RecoveryTargetHandler target = new TestRecoveryTargetHandler() {
                long startingSeqNo,
        Thread cancelingThread = new Thread(() -> cancellableThreads.cancel("test"));
            .put("indices.recovery.concurrent_small_file_streams", 1)  
 * The OpenSearch Contributors require contributions made to  
        try {
            document.add(newField("field", randomUnicodeOfCodepointLengthBetween(1, 10), TextField.TYPE_STORED));
    }  
            Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
import org.opensearch.index.mapper.ParsedDocument;  
/**
                totalChunks - sentChunks.get(),                             // limited by the remaining chunks
                long position,
import static org.mockito.Mockito.doAnswer;
                long mappingVersion,
            assertThat(sentChunks.get(), equalTo(Math.min(totalChunks, maxConcurrentChunks)));
        }  
                BytesReference content,
