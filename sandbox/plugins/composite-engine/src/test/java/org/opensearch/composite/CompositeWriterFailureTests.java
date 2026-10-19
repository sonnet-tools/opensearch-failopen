        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
}  
                0L,
            assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
            secondaryEngine.getLastCreatedWriter().setResultToReturn(new WriteResult.Failure(secondaryCause, -1, -1, -1));
    // State transitions
                null,
            null,
    public void testPrimaryWriteFailureReturnsFailureImmediately() throws IOException {  
            null,  
    /**
            // FailableWriter mimics Lucene-style strategy: rollback success → RETIRED_FLUSHABLE.  
            }  
import java.io.IOException;
    }
    public void testAddDocAfterCloseThrows() throws IOException {
            WriteResult result = writer.addDoc(createDocumentInput());
            WriteResult result = writer.addDoc(createDocumentInput());
                        throw new IOException("primary close failed");
    }
            // Primary's rollback was called exactly once for this failed addDoc — not twice.
    private CompositeDocumentInput createDocumentInput() {
                        new LuceneShardStatsTracker()
        LuceneDataFormat luceneFormat = new LuceneDataFormat();
import org.opensearch.index.engine.dataformat.Writer;
                    return (Writer<DocumentInput<?>>) (Writer<?>) new LuceneWriter(
            primaryEngine.getLastCreatedWriter().setState(WriterState.RETIRED_FLUSHABLE);  
    }  
        long generation = 42L;  
        try {  
        Set<LuceneWriter> registry = ConcurrentHashMap.newKeySet();
                generation,
            )
     *    adding the lock path to Lucene's static LOCK_HELD set  
            @SuppressWarnings("unchecked")  
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        );  
        // CompositeWriter does not override Writer.rollbackTo — calling it externally
        try {
    }
        expectThrows(IllegalStateException.class, () -> writer.addDoc(createDocumentInput()));
    public void testSecondaryWriteFailureRollsBackPrimary() throws IOException {
            registry,
 * The OpenSearch Contributors require contributions made to  
                try {  
        assertEquals(WriterState.CLOSED, writer.state());
            // Rollback succeeds, original cause is propagated (no signal exception wrapping).
            0L,
            assertEquals("primary flush failed", e.getMessage());
            primaryEngine.getLastCreatedWriter().setResultToReturn(new WriteResult.Failure(new IOException("primary failed"), -1, -1, -1));  
        }
        try {
    }
    private CompositeTestHelper.FailableEngine secondaryEngine;
        // Wire: primary throws on close, Lucene as secondary (real lock)  
    }
import org.opensearch.be.lucene.LuceneDataFormat;  
    }
            expectThrows(UnsupportedOperationException.class, () -> writer.rollbackTo(0));
            assertTrue("primary rollback should have been called by CompositeWriter", primaryEngine.getLastCreatedWriter().rollbackCalled);  
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
     * 3. If primary.close() throws (e.g. Parquet I/O error), the old sequential close skips
                        config.writerGeneration(),
        } finally {  
     *    LockObtainFailedException: "Lock held by this virtual machine"
            assertTrue("expected success", result instanceof WriteResult.Success);
     * 4. Engine fails, shard re-initializes on same node (same JVM). writerGenerationCounter
    public void testRollbackToOnCompositeIsUnsupported() throws IOException {
            assertTrue(result instanceof WriteResult.Failure);  
            () -> new LuceneWriter(  
        try {  
            primaryEngine.getLastCreatedWriter().flushFailure = new IOException("primary flush failed");
            expectThrows(IllegalStateException.class, () -> writer.addDoc(createDocumentInput()));  
            assertSame(secondaryCause, ((WriteResult.Failure) result).cause());  
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithDelegates(  
                        null,
        writer.close();
    }
     */  
                        registry,  
            writer.close();
            public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
import org.apache.lucene.codecs.Codec;
                    throw new RuntimeException(e);
import org.opensearch.be.lucene.index.LuceneWriter;
import org.opensearch.index.engine.dataformat.WriterState;  
import org.apache.lucene.store.LockObtainFailedException;
    public void testRollbackHappensOncePerFailedAddDoc() throws IOException {
    }
        }  
        LockObtainFailedException lockError = expectThrows(
                .setResultToReturn(new WriteResult.Failure(new IOException("primary disk full"), -1, -1, -1));
        // First, prove the failure mode
            null,  
                        null,  
            assertTrue(result instanceof WriteResult.Failure);
        );
            baseDir,  
/*  
     * The fix uses IOUtils.close() which closes ALL writers (aggregating exceptions), ensuring  
                new LuceneShardStatsTracker()  
        try {  
            writer.close();
            0L,
        leakedWriter.close();
public class CompositeWriterFailureTests extends OpenSearchTestCase {
        writer.close();  
        IndexingExecutionEngine<?, ?> throwingPrimaryEngine = new CompositeTestHelper.StubIndexingExecutionEngine(primaryFormat) {
 * SPDX-License-Identifier: Apache-2.0
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        } finally {
            // Secondary fails on the first addDoc → composite rolls back primary once.
 * Unit tests for {@link CompositeWriter} failure handling: primary/secondary write failures,
            IOException secondaryCause = new IOException("secondary write failed");
            expectThrows(IllegalStateException.class, () -> writer.addDoc(createDocumentInput()));
                };
    }
 */  
            writer.close();
        primaryEngine.getLastCreatedWriter().setState(WriterState.RETIRED_FLUSHABLE);
            new LuceneShardStatsTracker()
    private CompositeDocumentInput createDocumentInput(long rowId) {
        committer = new CompositeTestHelper.FailableCommitter();
            luceneSecondaryEngine
            // must throw IllegalStateException because state != ACTIVE. Importantly, this
            Codec.getDefault(),
 */
        );  
            registry,
        Map<DataFormat, DocumentInput<?>> secondaryInputs = Map.of(secondaryEngine.getDataFormat(), new MockDocumentInput());
        try {
            // Composite is now RETIRED_FLUSHABLE (Lucene-style sub-writer); the next addDoc  
            writer.close();  
        } finally {
        );  
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
package org.opensearch.composite;
            // means there is NO second call into primaryWriter.rollbackLastDoc — once a
        try {
            secondaryEngine.getLastCreatedWriter().flushFailure = new IOException("secondary flush failed");
            assertEquals(WriterState.ACTIVE, writer.state());  
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
            // No secondary writer should have seen the doc.
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
            assertEquals(0, secondaryEngine.getLastCreatedWriter().addDocCallCount.get());
            assertTrue(primaryEngine.getLastCreatedWriter().rollbackCalled);
            luceneFormat,
            assertTrue("primary rollback should have been called", primaryEngine.getLastCreatedWriter().rollbackCalled);
 *
                return new CompositeTestHelper.StubWriter(getDataFormat()) {
import org.opensearch.index.engine.dataformat.DataFormat;  
            public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
        secondaryEngine = new CompositeTestHelper.FailableEngine("parquet");
            }
        };  
            primaryEngine.getLastCreatedWriter()  
                    @Override  
import java.util.Set;
        primaryEngine = new CompositeTestHelper.FailableEngine("lucene");  
                baseDir,
import org.opensearch.index.engine.dataformat.WriteResult;  
        }
        }  
            throwingPrimaryEngine,
            WriteResult result = writer.addDoc(createDocumentInput());
        } finally {
    public void testSecondaryFlushFailurePropagates() throws IOException {
     *    secondary writers — Lucene's lock path stays in LOCK_HELD  
        } finally {
            writer.close();  
    public void testPrimaryCloseFailureLockLeak() throws IOException {
        retryWriter.close();
        // Without the fix, this throws LockObtainFailedException.
import java.util.concurrent.ConcurrentHashMap;
        super.setUp();
                    }  
                    public void close() throws IOException {
    }  
    public void testStateActiveAfterSuccessfulAddDoc() throws IOException {
            // Composite aggregates worst child state.
    public void testPrimaryFailureLeavesSecondariesUntouched() throws IOException {  
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
 * compatible open source license.
            assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
            // could trigger a second rollback.
            generation,  
        } finally {
    // ──────────────────────────────────────────────────────────────────────────  
            writer.close();
            @Override  
        assertThat(lockError.getMessage(), org.hamcrest.Matchers.containsString("Lock held by this virtual machine"));  
    }
            assertTrue(result instanceof WriteResult.Failure);
        DataFormat primaryFormat = CompositeTestHelper.stubFormat("parquet", 1, Set.of());
     *
import org.opensearch.index.engine.dataformat.WriterConfig;
    public void testCloseFromRetiredFlushableTransitionsToClosed() throws IOException {  
    private CompositeTestHelper.FailableCommitter committer;  
        return composite;
    private CompositeTestHelper.FailableEngine primaryEngine;
        }
            @Override
            new LuceneShardStatsTracker()
            secondaryEngine.getLastCreatedWriter()
     * Reproduces the production LockObtainFailedException scenario:  
            IOException e = expectThrows(IOException.class, () -> writer.flush(org.opensearch.index.engine.dataformat.FlushInput.EMPTY));
                } catch (IOException e) {  
                        baseDir,
            writer.close();  
            IOException e = expectThrows(IOException.class, () -> writer.flush(org.opensearch.index.engine.dataformat.FlushInput.EMPTY));  
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryEngine.getDataFormat(), primaryInput, secondaryInputs);
        // Cross-format rollback is handled internally during a failed addDoc.
        };
            generation,  
 * rollback behavior, abort state transitions, and flush failure propagation.  
                }
     * LuceneWriter.close() → indexWriter.rollback() → NativeFSLock.close() → LOCK_HELD.remove()
     * 2. During indexing, a write failure triggers writer retirement → CompositeWriter.close()
                null,
        // Simulate engine restart reusing same generation.  
        } finally {
        IndexingExecutionEngine<?, ?> luceneSecondaryEngine = new CompositeTestHelper.StubIndexingExecutionEngine(luceneFormat) {
                .setResultToReturn(new WriteResult.Failure(new IOException("secondary failed"), -1, -1, -1));  
        } finally {
import java.util.Map;  
        return createDocumentInput(0L);
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(generation));
        } finally {
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        }  
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));  
        compositeEngine = CompositeTestHelper.buildFailableEngine(primaryEngine, committer, secondaryEngine);  
import org.opensearch.index.engine.dataformat.DocumentInput;
    // ──────────────────────────────────────────────────────────────────────────
                registry,
        expectThrows(IOException.class, writer::close);
    }
            assertEquals(0, secondaryEngine.getLastCreatedWriter().addDocCallCount.get());
import java.nio.file.Path;
     * 1. CompositeWriter is created — Lucene (secondary) acquires write.lock via NativeFSLockFactory,
     *    re-initializes from maxGenFromCommit. Since the leaked writer's generation was never
    }
    }  
            baseDir,  
        // should hit the interface default which throws UnsupportedOperationException.  
     *    committed, the counter produces the same generation → same path →  
/**
        }  
                        luceneFormat,
    public void setUp() throws Exception {
                luceneFormat,  
            // Primary's rollback was invoked by CompositeWriter so the leaf can decide whether  
        // close() — primary throws, but IOUtils.close ensures secondary Lucene writer is still closed  
    public void testAddDocAfterRetiredFlushableThrows() throws IOException {  
            // it has anything to undo (idempotent inside the leaf). FailableWriter records the
        }
        try {  
        }
        composite.setRowId(DocumentInput.ROW_ID_FIELD, rowId);  
            luceneFormat,
            WriteResult result = writer.addDoc(createDocumentInput());
    @Override  
            // call regardless of whether work was done.
            assertEquals("secondary flush failed", e.getMessage());  
            null,
            Codec.getDefault(),
            writer.close();  
     * always runs regardless of whether other writers throw on close.
        Path baseDir = createTempDir();
        CompositeWriter writer = new CompositeWriter(compositeEngine, new WriterConfig(0));
        DocumentInput<?> primaryInput = new MockDocumentInput();  
                    );
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
        try {  
import org.opensearch.test.OpenSearchTestCase;
                        0L,  
            WriteResult result = writer.addDoc(createDocumentInput());  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(result instanceof WriteResult.Failure);
    public void testPrimaryFlushFailurePropagates() throws IOException {
        LuceneWriter leakedWriter = new LuceneWriter(
            // rollback has run, the writer is retired and cannot accept another addDoc that  
        assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());  
            writer.close();
            assertEquals(1, primaryEngine.getLastCreatedWriter().addDocCallCount.get());
    private CompositeIndexingExecutionEngine compositeEngine;
     *
                Codec.getDefault(),  
                        Codec.getDefault(),
        LuceneWriter retryWriter = new LuceneWriter(
            LockObtainFailedException.class,
