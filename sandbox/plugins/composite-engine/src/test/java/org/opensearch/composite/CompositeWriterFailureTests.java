import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
import org.opensearch.be.lucene.index.LuceneWriter;
            generation,
        }
                return new CompositeTestHelper.StubWriter(getDataFormat()) {
        // First, prove the failure mode
    }
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
    @Override
        );
     * always runs regardless of whether other writers throw on close.
            writer.close();
 * The OpenSearch Contributors require contributions made to
     *    secondary writers — Lucene's lock path stays in LOCK_HELD
        assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
     *    committed, the counter produces the same generation → same path →
    }
            writer.close();
import java.util.Set;
                registry,
 */
            writer.close();
        writer.close();
        secondaryEngine = new CompositeTestHelper.FailableEngine("parquet");
        }
import java.util.concurrent.ConcurrentHashMap;
     *
            @Override
            assertTrue(result instanceof WriteResult.Failure);
            assertTrue(result instanceof WriteResult.Failure);
            IOException secondaryCause = new IOException("secondary write failed");
            Codec.getDefault(),
            primaryEngine.getLastCreatedWriter().setState(WriterState.RETIRED_FLUSHABLE);
            // rollback has run, the writer is retired and cannot accept another addDoc that
            @Override
        assertEquals(WriterState.CLOSED, writer.state());
import java.util.Map;
            // call regardless of whether work was done.
            WriteResult result = writer.addDoc(createDocumentInput());
            primaryEngine.getLastCreatedWriter()
     * LuceneWriter.close() → indexWriter.rollback() → NativeFSLock.close() → LOCK_HELD.remove()
public class CompositeWriterFailureTests extends OpenSearchTestCase {
            assertTrue("expected success", result instanceof WriteResult.Success);
                };
            0L,
                        null,
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
            assertEquals(0, secondaryEngine.getLastCreatedWriter().addDocCallCount.get());
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
            WriteResult result = writer.addDoc(createDocumentInput());
        Path baseDir = createTempDir();
                0L,
    /**
        LuceneWriter retryWriter = new LuceneWriter(
    }
/**
            // Composite is now RETIRED_FLUSHABLE (Lucene-style sub-writer); the next addDoc
                    }
                        0L,
            assertTrue(result instanceof WriteResult.Failure);
            assertTrue("primary rollback should have been called by CompositeWriter", primaryEngine.getLastCreatedWriter().rollbackCalled);
            IOException e = expectThrows(IOException.class, () -> writer.flush(org.opensearch.index.engine.dataformat.FlushInput.EMPTY));
    private CompositeTestHelper.FailableEngine secondaryEngine;
        retryWriter.close();
     *    re-initializes from maxGenFromCommit. Since the leaked writer's generation was never
    // ──────────────────────────────────────────────────────────────────────────
            public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        };
        } finally {
            assertSame(secondaryCause, ((WriteResult.Failure) result).cause());
import org.opensearch.index.engine.dataformat.DocumentInput;
    }
    public void testPrimaryWriteFailureReturnsFailureImmediately() throws IOException {
            IOException e = expectThrows(IOException.class, () -> writer.flush(org.opensearch.index.engine.dataformat.FlushInput.EMPTY));
 * this file be licensed under the Apache-2.0 license or a
    }
                new LuceneShardStatsTracker()
        LuceneDataFormat luceneFormat = new LuceneDataFormat();
        Map<DataFormat, DocumentInput<?>> secondaryInputs = Map.of(secondaryEngine.getDataFormat(), new MockDocumentInput());
        } finally {
            luceneFormat,
                baseDir,
                try {
        try {
            public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
            // FailableWriter mimics Lucene-style strategy: rollback success → RETIRED_FLUSHABLE.
     *
        );
                .setResultToReturn(new WriteResult.Failure(new IOException("secondary failed"), -1, -1, -1));
        );
        }
            baseDir,
            // Rollback succeeds, original cause is propagated (no signal exception wrapping).
        long generation = 42L;
        } finally {
            () -> new LuceneWriter(
 * compatible open source license.
    public void testSecondaryWriteFailureRollsBackPrimary() throws IOException {
    }
        IndexingExecutionEngine<?, ?> throwingPrimaryEngine = new CompositeTestHelper.StubIndexingExecutionEngine(primaryFormat) {
            throwingPrimaryEngine,
    }
    public void testCloseFromRetiredFlushableTransitionsToClosed() throws IOException {
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryEngine.getDataFormat(), primaryInput, secondaryInputs);
        }
    // ──────────────────────────────────────────────────────────────────────────
                        throw new IOException("primary close failed");
    }
    private CompositeTestHelper.FailableCommitter committer;
            writer.close();
 * Unit tests for {@link CompositeWriter} failure handling: primary/secondary write failures,
            null,
        try {
            // it has anything to undo (idempotent inside the leaf). FailableWriter records the
     * 3. If primary.close() throws (e.g. Parquet I/O error), the old sequential close skips
 */
            expectThrows(UnsupportedOperationException.class, () -> writer.rollbackTo(0));
        } finally {
     */
            primaryEngine.getLastCreatedWriter().flushFailure = new IOException("primary flush failed");
        DataFormat primaryFormat = CompositeTestHelper.stubFormat("parquet", 1, Set.of());
                } catch (IOException e) {
            Codec.getDefault(),
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        } finally {
    public void testSecondaryFlushFailurePropagates() throws IOException {
        try {
import java.nio.file.Path;
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
                null,
        primaryEngine = new CompositeTestHelper.FailableEngine("lucene");
    }
import org.opensearch.index.engine.dataformat.WriterState;
    }
     *    LockObtainFailedException: "Lock held by this virtual machine"
                        luceneFormat,
        Set<LuceneWriter> registry = ConcurrentHashMap.newKeySet();
            // must throw IllegalStateException because state != ACTIVE. Importantly, this
        try {
        LuceneWriter leakedWriter = new LuceneWriter(
    public void testRollbackToOnCompositeIsUnsupported() throws IOException {
                    throw new RuntimeException(e);
            luceneFormat,
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
     * 4. Engine fails, shard re-initializes on same node (same JVM). writerGenerationCounter
        // Without the fix, this throws LockObtainFailedException.
            assertEquals(1, primaryEngine.getLastCreatedWriter().addDocCallCount.get());
                    public void close() throws IOException {
    public void testRollbackHappensOncePerFailedAddDoc() throws IOException {
import org.opensearch.index.engine.dataformat.DataFormat;
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        // Cross-format rollback is handled internally during a failed addDoc.
                .setResultToReturn(new WriteResult.Failure(new IOException("primary disk full"), -1, -1, -1));
        // Wire: primary throws on close, Lucene as secondary (real lock)
    // State transitions
 * SPDX-License-Identifier: Apache-2.0
     * 1. CompositeWriter is created — Lucene (secondary) acquires write.lock via NativeFSLockFactory,
                    );
package org.opensearch.composite;
            writer.close();
        expectThrows(IOException.class, writer::close);
        return createDocumentInput(0L);
            writer.close();
        }
            // Secondary fails on the first addDoc → composite rolls back primary once.
        IndexingExecutionEngine<?, ?> luceneSecondaryEngine = new CompositeTestHelper.StubIndexingExecutionEngine(luceneFormat) {
        }
            null,
/*
            // Composite aggregates worst child state.
                        null,
    private CompositeDocumentInput createDocumentInput() {
        }
            null,
    }
        LockObtainFailedException lockError = expectThrows(
    public void testPrimaryFailureLeavesSecondariesUntouched() throws IOException {
 *
            assertTrue("primary rollback should have been called", primaryEngine.getLastCreatedWriter().rollbackCalled);
import org.opensearch.test.OpenSearchTestCase;
    public void setUp() throws Exception {
    public void testStateActiveAfterSuccessfulAddDoc() throws IOException {
            baseDir,
            assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
                        baseDir,
            WriteResult result = writer.addDoc(createDocumentInput());
        compositeEngine = CompositeTestHelper.buildFailableEngine(primaryEngine, committer, secondaryEngine);
    }
        // Simulate engine restart reusing same generation.
        };
        try {
            assertTrue(result instanceof WriteResult.Failure);
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithDelegates(
            expectThrows(IllegalStateException.class, () -> writer.addDoc(createDocumentInput()));
import org.opensearch.be.lucene.LuceneDataFormat;
    private CompositeIndexingExecutionEngine compositeEngine;
    private CompositeTestHelper.FailableEngine primaryEngine;
     *    adding the lock path to Lucene's static LOCK_HELD set
            // could trigger a second rollback.
                    @Override
        composite.setRowId(DocumentInput.ROW_ID_FIELD, rowId);
            // Primary's rollback was invoked by CompositeWriter so the leaf can decide whether
    }
import org.apache.lucene.codecs.Codec;
                null,
            new LuceneShardStatsTracker()
                        config.writerGeneration(),
            secondaryEngine.getLastCreatedWriter().flushFailure = new IOException("secondary flush failed");
            primaryEngine.getLastCreatedWriter().setResultToReturn(new WriteResult.Failure(new IOException("primary failed"), -1, -1, -1));
                luceneFormat,
        super.setUp();
            // Primary's rollback was called exactly once for this failed addDoc — not twice.
                        Codec.getDefault(),
     * The fix uses IOUtils.close() which closes ALL writers (aggregating exceptions), ensuring
            luceneSecondaryEngine
        // CompositeWriter does not override Writer.rollbackTo — calling it externally
        committer = new CompositeTestHelper.FailableCommitter();
            WriteResult result = writer.addDoc(createDocumentInput());
            assertEquals(WriterState.ACTIVE, writer.state());
            assertTrue(primaryEngine.getLastCreatedWriter().rollbackCalled);
        primaryEngine.getLastCreatedWriter().setState(WriterState.RETIRED_FLUSHABLE);
            }
            registry,
        }
            0L,
            // means there is NO second call into primaryWriter.rollbackLastDoc — once a
    public void testAddDocAfterCloseThrows() throws IOException {
    public void testPrimaryFlushFailurePropagates() throws IOException {
        try {
import org.opensearch.index.engine.dataformat.WriterConfig;
            expectThrows(IllegalStateException.class, () -> writer.addDoc(createDocumentInput()));
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
     * 2. During indexing, a write failure triggers writer retirement → CompositeWriter.close()
            assertEquals("secondary flush failed", e.getMessage());
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        // should hit the interface default which throws UnsupportedOperationException.
        } finally {
import org.opensearch.index.engine.dataformat.Writer;
        // close() — primary throws, but IOUtils.close ensures secondary Lucene writer is still closed
 * rollback behavior, abort state transitions, and flush failure propagation.
        } finally {
            WriteResult result = writer.addDoc(createDocumentInput());
        expectThrows(IllegalStateException.class, () -> writer.addDoc(createDocumentInput()));
            null,
     * Reproduces the production LockObtainFailedException scenario:
                    return (Writer<DocumentInput<?>>) (Writer<?>) new LuceneWriter(
        assertThat(lockError.getMessage(), org.hamcrest.Matchers.containsString("Lock held by this virtual machine"));
            secondaryEngine.getLastCreatedWriter().setResultToReturn(new WriteResult.Failure(secondaryCause, -1, -1, -1));
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
    private CompositeDocumentInput createDocumentInput(long rowId) {
        try {
            @SuppressWarnings("unchecked")
            )
        DocumentInput<?> primaryInput = new MockDocumentInput();
            assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
            writer.close();
                        registry,
            LockObtainFailedException.class,
            }
        } finally {
import java.io.IOException;
        return composite;
            // No secondary writer should have seen the doc.
            generation,
import org.apache.lucene.store.LockObtainFailedException;
    }
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(generation));
            writer.close();
                generation,
        leakedWriter.close();
import org.opensearch.index.engine.dataformat.WriteResult;
            assertEquals(0, secondaryEngine.getLastCreatedWriter().addDocCallCount.get());
            assertEquals("primary flush failed", e.getMessage());
    }
        );
            registry,
                }
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        }
    public void testPrimaryCloseFailureLockLeak() throws IOException {
                        new LuceneShardStatsTracker()
            secondaryEngine.getLastCreatedWriter()
        try {
}
        writer.close();
        try {
                Codec.getDefault(),
            new LuceneShardStatsTracker()
            writer.close();
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
    public void testAddDocAfterRetiredFlushableThrows() throws IOException {
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
        } finally {
