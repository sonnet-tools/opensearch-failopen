import org.opensearch.test.IndexSettingsModule;
            engine.index(indexOp(doc("init")));  
                            noop.reason()
            targetEngine.setDefaultWriteResultSupplier(failureSupplier);
import java.io.IOException;  
            .tombstoneDocSupplier(tombstoneDocSupplier())  
            .internalRefreshListener(List.of())
                            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
        TranslogConfig tc = new TranslogConfig(shardId, translogPath, engineSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false);  
            // Pre-restart invariants
 *
     *
     * separately by {@link #testSeqNoInvariantsSecondaryFailRollbackFailsFailsEngine}, since  
            long secondaryRows = 0;
            // on failure) so subsequent addDoc calls succeed.
                -1,
    /** Mode 1: secondary fails (with rollback success) — primary stays consistent. */  
            FileBackedFailableIndexingExecutionEngine targetEngine = failPrimary ? fbPrimary : fbSecondary;  
            FileBackedFailableWriter innerWriter = fbPrimary.getLastCreatedWriter();
 * </ul>
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.opensearch.index.store.FsDirectoryFactory;
            }
    ) throws IOException {  
            assertEquals("processed checkpoint advanced through all 10", 9L, engine.getProcessedLocalCheckpoint());  
        EngineConfig config = new EngineConfig.Builder().shardId(shardId)  
                engine.index(indexOp(doc("5")));
            // Index a couple successful docs.  
                // rollback brings it back to ACTIVE (fully reversible). Apply to all writers
import org.apache.lucene.index.IndexWriterConfig;
                            0
        DataFormatAwareEngine engine = createEngine(store, createTempDir());
                    if (result.getResultType() == Engine.Result.Type.FAILURE) {
        when(mapperService.getIndexSettings()).thenReturn(engineSettings);
            assertEquals("global == local after promotion", engine.getProcessedLocalCheckpoint(), globalCheckpoint.get());  
import org.opensearch.common.settings.Settings;
            try {  
    }
        runSeqNoAndRecoveryScenario(/*failPrimary*/ true, /*rollbackFails*/ true);
    public void testSuccessfulIndexProducesConsistentFiles() throws IOException {  
            assertFalse("no file on disk (not flushed)", java.nio.file.Files.exists(innerWriter.getFilePath()));
                    succeeded++;
            }
            commitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, "-1");  
                }
        );
     * does not require rolling back any other writer (no secondary was touched), this mode  
        super.setUp();
 *   <li>{@code testPrimaryFailureWriterStaysOpenInPool} — inner writer NOT closed, same writer reused</li>
            terminate(threadPool);
        return createEngine(s, translogPath, () -> SequenceNumbers.NO_OPS_PERFORMED, true);
import org.opensearch.cluster.metadata.IndexMetadata;
            }
        DocumentMapper documentMapper = mock(DocumentMapper.class);  
                // Primary models a Parquet-style writer: addDoc Failure → PENDING_ROLLBACK, then
            .globalCheckpointSupplier(globalCheckpointSupplier)  
        fbSecondary = new FileBackedFailableIndexingExecutionEngine("parquet", dataDir);  
        Path translogPath = createTempDir();
            fbSecondary.getLastCreatedWriter().writeResultSupplier = null;
    }
        document.add(seqID.seqNoDocValue);
            Map<String, String> commitData = new HashMap<>();
            .dataFormatRegistry(dfaRegistry)
    // ============================================================================
        DocumentInput<?> input = compositeEngine.newDocumentInput();
        }
import org.opensearch.core.common.bytes.BytesArray;
                            System.nanoTime(),  
                        Engine.Index e = new Engine.Index(
        Store s,
            assertEquals("post-replay max seqNo == 9", 9L, reopened.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo());
        document.add(new StoredField(SourceFieldMapper.NAME, ref.bytes, ref.offset, ref.length));  
            for (int i = 0; i < 5; i++) {
    /**
                            idx.primaryTerm(),
                }
            assertEquals(5, secondary.size());
                        result = indexer.noOp(e);  
     * still terminates cleanly. We exercise it for symmetry; the result is identical to mode 3.
            FileBackedFailableWriter innerWriter = fbPrimary.getLastCreatedWriter();  
            fbPrimary.getLastCreatedWriter().rollbackFailure = new IOException("rollback failed");
                }
        );
    }
                            null,
        } finally {  
        ParseContext.Document document = new ParseContext.Document();
                            true,
    public void testIntermittentFailuresProduceConsistentFiles() throws IOException {
                            idx.version(),  
            .eventListener(new Engine.EventListener() {  
        }
    public void testSeqNoInvariantsPrimaryFailRollbackOk() throws IOException {  
    private void bootstrapStoreWithMetadata(Store s, String translogUUID) throws IOException {  
            );
            Supplier<WriteResult> failureSupplier = () -> {
        when(dfaRegistry.getIndexingEngine(any(), any())).thenAnswer(inv -> compositeEngine);
            // writers that throw on rollback. We don't have a setter for this on the engine, so
/**
        try {
 *   <li>{@code testIntermittentFailuresProduceConsistentFiles} — total rows across all files match successes,  
 * this file be licensed under the Apache-2.0 license or a
            "test",
        shardId = new ShardId(new Index("test", "_na_"), 0);
            engine.translogManager().recoverFromTranslog(s -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                -1
            engine.translogManager().recoverFromTranslog(s -> 0, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            // rollback brings the writer back to ACTIVE (fully reversible — no row consumed  
        org.apache.lucene.util.BytesRef ref = source.toBytesRef();
    public void testPrimaryFailureWriterStaysOpenInPool() throws IOException {  
        // localCheckpoint == 9, max == 9, identical to pre-restart.
        DataFormatAwareEngine engine = createEngine(store, translogPath, globalCheckpoint::get);  
 *       inner writer closed, fresh writer created for next doc</li>  
                fbSecondary.getLastCreatedWriter().getFilePath()
import static org.hamcrest.Matchers.equalTo;
            innerWriter.writeResultSupplier = null;  
            .translogConfig(tc)
            Settings.builder()
import org.opensearch.index.translog.Translog;
            // Writer closed and removed from pool
    @Override
                }
    //
                            Engine.Operation.Origin.LOCAL_TRANSLOG_RECOVERY,
            innerWriter.writeResultSupplier = () -> new WriteResult.Failure(new IOException("primary full"), -1, -1, -1);  
            0  
                    return new WriteResult.Failure(new IOException("injected failure on call " + n), -1, -1, -1);
        // Reopen with a fresh failable engine (no failure injection) and replay the translog.  
            commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
    private Store store;
        try {
                Engine.IndexResult r = engine.index(indexOp(doc(Integer.toString(i))));
            // The doc that hits both failures triggers RETIRED_DROP → engine fails.
                new IOException("secondary failed"),
            if (fmt.name().equals("lucene")) return fbPrimary;
    }
                        throw new AssertionError("replay failed for " + op + ": " + result.getFailure());
import org.opensearch.index.store.Store;  
        try (DataFormatAwareEngine engine = createEngine(store, createTempDir())) {
import org.opensearch.test.DummyShardLock;  
        }
            // we install it lazily — after each writer is created, set rollbackFailure on it.
            for (int i = 0; i < 2; i++) {
        );
                        expected++;
        throws IOException {  
        try {  
        document.add(uidField);
        try {
import org.opensearch.index.mapper.ParsedDocument;
                .build()  
    /**
    @Override
        // bootstrapTranslog=false so we don't clobber the existing translog files.  
                    }  
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;  
            Settings.builder()  
            commitData.put(Engine.HISTORY_UUID_KEY, UUID.randomUUID().toString());
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
     */  
import org.opensearch.index.engine.dataformat.DocumentInput;
                        Engine.NoOp e = new Engine.NoOp(
        when(dfaRegistry.format("composite")).thenReturn(compositeEngine.getDataFormat());  
            reopened.close();
        }
     * acked-but-unflushed docs. Verifies the writer was closed and no file was flushed.
        // Successful Index ops must replay successfully; NoOps replay as no-ops. End state:
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            for (int i = 0; i < 9; i++) {  
            .committerFactory(c -> new InMemoryCommitter(s))
     * RETIRED_DROP path: secondary fails AND primary's rollback fails. Composite reports  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.Map;
public class CompositeEngineFailureTests extends OpenSearchTestCase {
                    } else {
        if (bootstrapTranslog) {
            } catch (Exception expected) { /* engine failure may surface as throw */ }
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
        try (
            for (FileBackedFailableWriter w : fbSecondary.getAllWriters()) {  
                            new Term(IdFieldMapper.NAME, Uid.encodeId(idx.id())),
            Store.OnClose.EMPTY,  
import org.opensearch.common.lucene.uid.Versions;  
    // For each failure mode we verify, post-indexing-of-10-docs:  
import org.opensearch.index.engine.EngineConfig;
            assertEquals("max seqNo == last assigned", 9L, engine.getSeqNoStats(globalCheckpoint.get()).getMaxSeqNo());
        org.opensearch.index.mapper.MapperService mapperService = mock(org.opensearch.index.mapper.MapperService.class);
import org.apache.lucene.document.Field;
     * RETIRED_DROP. The engine fails so recovery can replay the translog and restore the
import org.apache.lucene.index.Term;
import org.opensearch.index.engine.dataformat.stub.FileBackedFailableWriter;
                fbSecondary.getLastCreatedWriter().writeResultSupplier = fail ? () -> failResult : null;
import org.opensearch.index.mapper.IdFieldMapper;
import org.apache.lucene.document.NumericDocValuesField;
    // SeqNo / checkpoint / recovery invariants under per-doc failure injection.
                engine.index(indexOp(doc("5")));  
    public void setUp() throws Exception {  
                        throw new AssertionError("unexpected op type: " + op.opType());
            engine.close();
            store.close();
            writer.setLiveCommitData(commitData.entrySet());
            IndexWriter writer = new IndexWriter(
        );
import org.opensearch.core.common.bytes.BytesReference;
    /**
    private ParsedDocument doc(String id) {  
                -1
        document.add(seqID.seqNo);
            int expected = 1;
        try (DataFormatAwareEngine engine = createEngine(store, createTempDir())) {
            })  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            int succeeded = 0;  
                } catch (UnsupportedOperationException e) {  
        }
    private void runSeqNoAndRecoveryScenario(boolean failPrimary, boolean rollbackFails) throws IOException {  
            engine.close();  
 * <ul>  
        return createEngine(s, translogPath, globalCheckpointSupplier, true);
        return new Store(
    }  
        java.util.concurrent.atomic.AtomicLong globalCheckpoint = new java.util.concurrent.atomic.AtomicLong(  
            .primaryTermSupplier(primaryTerm::get)
        when(documentMapper.getVersion()).thenReturn(1L);
                engine.index(indexOp(doc("5")));
            }, reopened.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
        java.util.Set<Long> failedSeqNos = new java.util.HashSet<>();  
            if (failPrimary) {  
import org.opensearch.index.mapper.Uid;
            };
            assertEquals(5, primary.size());
    public void testAbortedWriterClosedAndEngineFailed() throws IOException {
        BytesReference source = new BytesArray("{}");
        CompositeTestHelper.FailableCommitter committer = new CompositeTestHelper.FailableCommitter();
                    Engine.Result result;
                    failedSeqNos.add(result.getSeqNo());
                @Override
            Engine.Operation.Origin.PRIMARY,
                -1,
            assertThat(engine.index(indexOp(doc("6"))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
            // Subsequent index calls fail — engine is closed. The 2 acked docs (seqNos 0, 1)
        DataFormatAwareEngine engine = createEngine(store, translogPath, globalCheckpoint::get);
    /**
                -1,  
    }  
            assertEquals(expected, primaryRows);  
                int n = callIdx.incrementAndGet();
            // Promote global to match local (replication tracker would do this externally)
    public void testSeqNoInvariantsSecondaryFailRollbackOk() throws IOException {
            for (FileBackedFailableWriter w : fbPrimary.getAllWriters()) {
            System.nanoTime(),
            // installed as the default so it survives writer retirement + recreation.
            assertEquals(primaryRows, secondaryRows);
                new IOException("secondary failed"),
     * <p>Note: {@code rollbackFails=true && failPrimary=false} (RETIRED_DROP case) is covered
     * Mode 4: primary fails AND its writer's rollback would fail — but since primary failure
    }
 */  
            // We'll set rollbackFailure inside the loop after the first index call.
                    if (fail == false) {
                new IndexWriterConfig(Lucene.STANDARD_ANALYZER).setMergePolicy(NoMergePolicy.INSTANCE)
    private AtomicLong primaryTerm;  
                engine.index(indexOp(doc("2")));
                public void onFailedEngine(String reason, Exception e) {}
        primaryTerm = new AtomicLong(randomLongBetween(1, Long.MAX_VALUE));  
                            idx.getAutoGeneratedIdTimestamp(),
import java.util.HashMap;  
 * compatible open source license.
import org.opensearch.index.IndexSettings;  
            // Fail on the 4th, 7th, and 9th calls (1-based); succeed otherwise. The supplier is
                fbPrimary.getLastCreatedWriter().getFilePath()
    }
            .flushMergesAfter(TimeValue.timeValueMinutes(5))  
import org.opensearch.index.mapper.DocumentMapper;
            .put("index.composite.primary_data_format", "lucene")
import org.opensearch.common.lucene.Lucene;
            java.util.concurrent.atomic.AtomicInteger callIdx = new java.util.concurrent.atomic.AtomicInteger();  
     * Mode 2: secondary fails AND primary's rollback fails. Composite reports RETIRED_DROP  
            d,
import org.opensearch.index.engine.Engine;  
import java.util.concurrent.atomic.AtomicLong;
        Path translogPath,  
            }
            } catch (Exception expected) { /* RETIRED_DROP fails engine; index call may throw */ }
            assertThat(engine.index(indexOp(doc("6"))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        SeqNoFieldMapper.SequenceIDFields seqID = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
import org.opensearch.common.unit.TimeValue;
            // recovery a fresh engine will replay them. We don't assert translog stats here  
            )  
                    Engine.IndexResult firstResult = engine.index(indexOp(doc(Integer.toString(i))));  
    // 3. After close + reopen + translog replay, localCheckpoint == 9 again  
import org.opensearch.core.index.shard.ShardId;
            // Writer NOT closed, still in pool  
                        );
        } finally {  
                -1
            for (int i = 0; i < 5; i++) {  
                -1,  
    private DataFormatAwareEngine createEngine(
        return new Engine.Index(  
            assertEquals(5, primary.size());
            }  
    private CompositeIndexingExecutionEngine compositeEngine;  
                            idx.seqNo(),
            );
    }
    }
            return null;
 * Unit tests verifying file-level data consistency through the full stack:
        return new ParsedDocument(versionField, seqID, id, null, Arrays.asList(document), source, MediaTypeRegistry.JSON, null, input);
    public void testSecondaryFailureFlushesNMinus1AndClosesWriter() throws IOException {
import org.apache.lucene.store.Directory;
        java.util.concurrent.atomic.AtomicLong globalCheckpoint = new java.util.concurrent.atomic.AtomicLong(  
     */  
 * SPDX-License-Identifier: Apache-2.0
 */  
                return null; // null tells FileBackedFailableWriter to take the success path  
                assertThat(r.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            assertFalse("inner writer still open", innerWriter.isClosed());
        fbPrimary = new FileBackedFailableIndexingExecutionEngine("lucene", dataDir);
     * failing side. Verifies seqNo/checkpoint invariants both pre-restart and post-translog-replay.  
            fbSecondary.getLastCreatedWriter().writeResultSupplier = () -> new WriteResult.Failure(  
            );  
                    continue;
        }  
            List<String> secondary = FileBackedFailableIndexingExecutionEngine.readFlushedFile(
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), "composite")  
            indexSettings,  
                engine.index(indexOp(doc(Integer.toString(i))));
 * Tests:
            // so the translog is the only durable record — restart must replay it.  
            } catch (UnsupportedOperationException e) { /* expected */ }
    private Engine.Index indexOp(ParsedDocument d) {
        runSeqNoAndRecoveryScenario(/*failPrimary*/ false, /*rollbackFails*/ false);
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
import org.opensearch.index.VersionType;
package org.opensearch.composite;
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
    private Store createStore() throws IOException {
            String uuid = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, primaryTerm.get());
import org.apache.lucene.document.StoredField;  
            // Translog should contain 10 ops (7 Index + 3 NoOp). We deliberately do NOT flush
                    replayedCount[0]++;
                fbSecondary.setDefaultWriteResultSupplier(fail ? () -> failResult : null);  
            bootstrapStoreWithMetadata(s, uuid);  
    }  
        }
                engine.index(indexOp(doc(Integer.toString(i))));  
            }
        compositeEngine = new CompositeIndexingExecutionEngine(fbSettings, null, committer, registry, null, null);  
            // Simpler: rely on the fact that on a single-doc test, only the first writer matters.  
    }
                        );
import org.opensearch.index.engine.dataformat.WriteResult;  
import org.opensearch.index.shard.ShardPath;
    }
        Directory dir = newDirectory();  
                -1,
                fbSecondary.getLastCreatedWriter().getFilePath()
        IndexSettings fbSettings = new IndexSettings(meta, Settings.EMPTY);
                if (result.getResultType() == Engine.Result.Type.SUCCESS) {
import java.util.Arrays;
 * <p>
    private FileBackedFailableIndexingExecutionEngine fbSecondary;
            int recovered = reopened.translogManager().recoverFromTranslog(snapshot -> {
/*  
import static org.mockito.ArgumentMatchers.any;  
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    // 1. localCheckpoint == globalCheckpoint == 9 (seqNos 0..9 consumed, no holes)
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
    }  
        store = createStore();
                WriteResult failResult = new WriteResult.Failure(new IOException("intermittent"), -1, -1, -1);
import org.opensearch.index.seqno.SequenceNumbers;  
                -1,  
    private DataFormatAwareEngine createEngine(Store s, Path translogPath) throws IOException {
                primaryRows += FileBackedFailableIndexingExecutionEngine.readFlushedFile(w.getFilePath()).size();  
        document.add(versionField);  
                secondaryRows += FileBackedFailableIndexingExecutionEngine.readFlushedFile(w.getFilePath()).size();
            int[] replayedCount = new int[1];
            // because reading them via the closed engine throws AlreadyClosedException.
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
        try {  
    /** Mode 3: primary fails immediately (no secondary touched, no rollback needed). */
     * engine is in failed state and translog still has the in-flight ops for recovery.
                    if (firstResult.getResultType() == Engine.Result.Type.SUCCESS) succeeded++;
            .build();
import org.opensearch.index.translog.TranslogConfig;
            shardPath,
            // Subsequent index ops must throw — engine has been failed.  
                new IOException("secondary failed"),
        Path dataDir = createTempDir("file-backed-data");
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;
            for (int i = 0; i < 5; i++) {
            assertEquals(10, engine.translogManager().getTranslogStats().estimatedNumberOfOperations());
    }
            assertEquals("post-replay localCheckpoint == 9", 9L, reopened.getProcessedLocalCheckpoint());
                Translog.Operation op;  
    }  
        } finally {  
                assertThat(engine.index(indexOp(doc(Integer.toString(i)))).getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
            List<String> primary = FileBackedFailableIndexingExecutionEngine.readFlushedFile(innerWriter.getFilePath());  
     */
            // Fresh writer created for next doc
            }
            );  
            commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);  
 * DataFormatAwareEngine → CompositeIndexingExecutionEngine → CompositeWriter → FileBackedFailableWriter.  
            List<String> secondary = FileBackedFailableIndexingExecutionEngine.readFlushedFile(
            try {
            globalCheckpoint.set(engine.getProcessedLocalCheckpoint());
            .threadPool(threadPool)
 *   <li>{@code testSecondaryFailureFlushesNMinus1AndClosesWriter} — flushed file has N-1 docs after rollback,
            assertEquals(expected, secondaryRows);
import org.opensearch.index.mapper.ParseContext;  
import static org.mockito.Mockito.mock;
                    Engine.IndexResult r = engine.index(indexOp(doc(Integer.toString(i))));
            expectThrows(org.apache.lucene.store.AlreadyClosedException.class, () -> engine.index(indexOp(doc("6"))));
        } finally {
                Engine.IndexResult result = engine.index(indexOp(doc(Integer.toString(i))));  
import org.opensearch.index.seqno.RetentionLeases;
            assertEquals("replay processed all 10 translog ops", 10, recovered);  
                            doc(idx.id()),  
    // ============================================================================  
                .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            "test",
        assert !(rollbackFails && !failPrimary) : "RETIRED_DROP path is exercised by a dedicated test";
            assertNotSame(innerWriter, fbPrimary.getLastCreatedWriter());
import java.nio.file.Path;
            engine.refresh("verify");
        }  
                            noop.seqNo(),  
import org.opensearch.threadpool.TestThreadPool;  
    private DataFormatAwareEngine createEngine(Store s, Path translogPath, java.util.function.LongSupplier globalCheckpointSupplier)
                // created by this engine, since the composite recreates a writer per refresh.  
        try (DataFormatAwareEngine engine = createEngine(store, createTempDir())) {
        threadPool = new TestThreadPool(getClass().getName());
            );  
        DataFormatRegistry dfaRegistry = mock(DataFormatRegistry.class);
            FileBackedFailableWriter innerWriter = fbPrimary.getLastCreatedWriter();
            Versions.MATCH_ANY,
 *   <li>{@code testAbortedWriterClosedNoFileOnDisk} — inner writer closed, no file on disk (not flushed)</li>
        when(dfaRegistry.getDeleteExecutionEngine(any())).thenAnswer(inv -> mock(DeleteExecutionEngine.class));
                    }  
                }
    }
        runSeqNoAndRecoveryScenario(/*failPrimary*/ true, /*rollbackFails*/ false);
import org.opensearch.Version;  
            fbPrimary.getLastCreatedWriter().rollbackFailure = new IOException("primary rollback fails");  
import org.opensearch.index.engine.DataFormatAwareEngine;
        when(mapperService.documentMapper()).thenReturn(documentMapper);
     * → engine MUST fail (acked docs would otherwise be lost until restart). Verify the
                s.directory(),  
            }
            assertEquals(5, secondary.size());
import java.util.List;
                    .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
    // --- Tests ---
            fbSecondary.setDefaultWriteResultSupplier(null);  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            // Flushed file has N-1 docs, cross-format consistent
            org.opensearch.index.engine.exec.Indexer indexer = reopened;  
        Path translogPath = createTempDir();
            );  
import java.util.UUID;  
            SequenceNumbers.NO_OPS_PERFORMED
import org.opensearch.common.util.BigArrays;  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        DataFormatAwareEngine reopened = createEngine(store, translogPath, globalCheckpoint::get, false);
import java.util.function.Supplier;
import org.apache.lucene.index.NoMergePolicy;  
                    if (op instanceof Translog.Index idx) {  
        try (DataFormatAwareEngine engine = createEngine(store, createTempDir())) {
                .build()
            assertTrue("inner writer closed", innerWriter.isClosed());  
                    else failedSeqNos.add(firstResult.getSeqNo());
            // Model a Parquet-style format: addDoc failure transitions to PENDING_ROLLBACK, then
        }
            .store(s)  
            long primaryRows = 0;
            primaryTerm.get(),
            }  
        }
            shardId,
    }  
        IndexSettings engineSettings = IndexSettingsModule.newIndexSettings(  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            dir,
            .indexSettings(engineSettings)
            } catch (UnsupportedOperationException e) { /* expected */ }  
            engine.refresh("test");
                if (i == 0 && rollbackFails && failPrimary == false) {
            assertEquals("3 failures injected", 7, succeeded);  
            .mergePolicy(NoMergePolicy.INSTANCE)
        Field uidField = new Field("_id", Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE);
        document.add(seqID.primaryTerm);  
        return new DataFormatAwareEngine(config);  
     * Drives 10 indexing operations with failures injected at calls 4, 7, 9 on the configured
                return replayedCount[0];  
        );  
 *   <li>{@code testSuccessfulIndexProducesConsistentFiles} — both format files have N lines, cross-format match</li>
 *       cross-format consistency across multiple writer generations</li>
    // 2. Failed seqNos persisted as Translog.NoOp; successful ops as Translog.Index
        when(registry.format("lucene")).thenReturn(fbPrimary.getDataFormat());
import org.opensearch.core.index.Index;  
            false,
                try {  
import org.opensearch.threadpool.ThreadPool;
    public void testSeqNoInvariantsPrimaryFailRollbackFails() throws IOException {  
            // remain durably persisted in the translog files on disk; on the next shard
                    fbPrimary.getLastCreatedWriter().rollbackFailure = new IOException("primary rollback fails");  
            if (fmt.name().equals("parquet")) return fbSecondary;  
     */
    public void tearDown() throws Exception {  
        IndexMetadata meta = IndexMetadata.builder("test-fb").settings(sb.build()).build();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
            }  
        sb.putList("index.composite.secondary_data_formats", "parquet");  
            List<String> primary = FileBackedFailableIndexingExecutionEngine.readFlushedFile(
            try {
    // --- Infrastructure ---  
            writer.commit();  
import org.opensearch.index.engine.dataformat.DataFormat;
            assertEquals(primary.size(), secondary.size());  
                            System.nanoTime(),  
                            noop.primaryTerm(),
                if (n == 4 || n == 7 || n == 9) {  
        when(registry.getIndexingEngine(any(), any())).thenAnswer(inv -> {  
        Settings.Builder sb = Settings.builder()
                        result = indexer.index(e);  
                    } else if (op instanceof Translog.NoOp noop) {
    private FileBackedFailableIndexingExecutionEngine fbPrimary;
            fbSecondary.getLastCreatedWriter().writeResultSupplier = () -> new WriteResult.Failure(  
                engine.index(indexOp(doc(Integer.toString(i))));
import org.opensearch.index.mapper.SourceFieldMapper;  
            new FsDirectoryFactory()
        );
            fbSecondary.getLastCreatedWriter().writeResultSupplier = () -> new WriteResult.Failure(
            try {  
            // For "rollback fails" scenarios, the rollback target's writer factory should produce  
                fbPrimary.setDefaultStateAfterRollback(org.opensearch.index.engine.dataformat.WriterState.ACTIVE);
            .externalRefreshListener(List.of())
    public void testSeqNoInvariantsSecondaryFailRollbackFailsFailsEngine() throws IOException {
            assertEquals("3 failed seqNos recorded", 3, failedSeqNos.size());
import org.opensearch.index.engine.dataformat.stub.FileBackedFailableIndexingExecutionEngine;
                } else {  
            fbSecondary.setDefaultWriteResultSupplier(null);
            innerWriter.setStateAfterRollback(org.opensearch.index.engine.dataformat.WriterState.ACTIVE);
            commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(SequenceNumbers.NO_OPS_PERFORMED));
        } finally {
            engine.close();  
        ) {
                        assertThat(r.getResultType(), equalTo(Engine.Result.Type.SUCCESS));  
                    assertTrue(fail);
    private ThreadPool threadPool;  
            new Term(IdFieldMapper.NAME, Uid.encodeId(d.id())),
            new DummyShardLock(shardId),
                // primary.rollbackLastDoc when the secondary fails; we want that to throw.)
        boolean bootstrapTranslog
            // Wire secondary failure + primary rollback failure.
            for (int i = 0; i < 10; i++) {
        ShardPath shardPath = new ShardPath(false, path, path, shardId);  
}
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    private ShardId shardId;
        Field versionField = new NumericDocValuesField("_version", 0);  
            expectThrows(org.apache.lucene.store.AlreadyClosedException.class, () -> engine.index(indexOp(doc("3"))));
                // After the first writer is created, install rollbackFailure on the primary if needed.
            SequenceNumbers.NO_OPS_PERFORMED
import org.apache.lucene.index.IndexWriter;
            DataFormat fmt = inv.getArgument(1);
                    }
            assertTrue("inner writer closed", innerWriter.isClosed());
                // (For "rollback fails" with secondary failure mode: the composite calls  
            VersionType.INTERNAL,  
                while ((op = snapshot.next()) != null) {
        }
            .mapperService(mapperService)
                boolean fail = (i % 3 == 2);
            -1,  
        });
    }  
        Path path = createTempDir().resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            for (int i = 0; i < 5; i++) {
        java.util.function.LongSupplier globalCheckpointSupplier,
                            SequenceNumbers.UNASSIGNED_SEQ_NO,  
     * that path now intentionally fails the engine and so the 10-doc loop cannot complete.
        when(registry.format("parquet")).thenReturn(fbSecondary.getDataFormat());
        super.tearDown();  
