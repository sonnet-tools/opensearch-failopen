                t1Done.set(true);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        Writer<?> currentWriter = createMockWriter(2L);
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                    deleteEngine.recordWrite("doc" + i, new DocumentLocation(1L, -1L));
                    startLatch.await();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        // per segment instead of freezing an update packet per delete. The captor is typed to the
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
        // Checkout removes the generation's deleter but not the writer's Lucene delegate.
    public void setUp() throws Exception {
        startLatch.countDown();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
     * no pool lock on gen 1. Both succeed.
        // target of a direct child delete; it only records a buffered delete drained at its own checkout.
    }
 */
                Thread.sleep(5);
            this.writer = writer;
            } catch (IOException e) {
        when(mockWriter.generation()).thenReturn(1L);
                for (int i = 0; i < 50; i++) {
    }
        Path baseDir = createTempDir();
            }
        Future<?> refresh = executor.submit(() -> {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, currentWriter);
        assertTrue(result instanceof DeleteResult.Success);
                deleteEngine.close();
        when(mockLuceneWriter.generation()).thenReturn(generation);
        CyclicBarrier barrier = new CyclicBarrier(5);
        LuceneWriter prevLuceneWriter = mock(LuceneWriter.class);
            new LuceneShardStatsTracker()
                    deleteEngine.recordWrite("doc_a", new DocumentLocation(locked.get().generation(), -1L));
        assertTrue(successfulDeletes.get() > 0);
        deleteEngine.onWriterCheckedOut(1L);
            null,
    }
                    }
            try {
                    for (int i = 0; i < 20; i++) {
        writer1.close();
                            successfulDeletes.incrementAndGet();
                // Expected
        });
    }
        assertTrue(deleteEngine.ramBytesUsed() > 0L);
            0L,
                Thread.sleep(50);
        writer1.addDoc(docInput);
        // Previous generation (1) with a trackable Lucene child writer so we can verify the direct delete.
        executor.shutdown();
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
        Writer<?> newWriter = createMockWriter(2L);
            try {
    public void testDeleteDocumentWithPreviousGeneration() throws IOException {
        CyclicBarrier barrier = new CyclicBarrier(2);
        assertTrue(result instanceof DeleteResult.Success);
        Set<String> recordedDeletes = ConcurrentHashMap.newKeySet();
            null,
        Deleter deleter1 = deleteEngine.createDeleter(mockWriter1);
        mockDataFormat = mock(DataFormat.class);
                try {
        parentWriter.close();
    public void testConcurrentDeleteOperations() throws Exception {
        assertTrue("refresh thread did not start", refreshStarted.await(5, TimeUnit.SECONDS));
                deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());
                    Thread.yield();
            0L,
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
            null,
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
        );
        java.nio.file.Files.createDirectories(parentDir);
            new LuceneShardStatsTracker()
                        // Expected after gen 1 is checked out
        deleterFuture.get(10, TimeUnit.SECONDS);
        LuceneDocumentInput docInput = new LuceneDocumentInput();
        deleter1.recordBufferedDeletes("gen1_doc2");
        LuceneWriter mockLuceneWriter = mock(LuceneWriter.class);
import org.opensearch.index.engine.dataformat.DataFormat;
            Set.of(new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")), new Term(IdFieldMapper.NAME, Uid.encodeId("doc2"))),
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    public void testCreateDeleterWithoutLuceneWriterReturnsNull() {
                    try {
     * Concurrent: multiple indexers updating different docs (prior copies in different gens)
        when(writer1.generation()).thenReturn(1L);
            ConcurrentHashMap.newKeySet(),
        assertTrue(hasDeletes);
        @Override
        LuceneWriter writer2 = new LuceneWriter(
        LuceneWriter writer3 = new LuceneWriter(
            0L,
                        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc" + i, 1L);
        parentWriter.close();
                barrier.await();
            new LuceneShardStatsTracker()
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            try {
        deleteEngine.createDeleter(writer1);
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        deleteEngine.deleteDocument(new DeleteInput(IdFieldMapper.NAME, "doc1", current.get().generation()), current.get());
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "new_doc", 2L);
        assertTrue(deleteEngine.onWriterCheckedOut(1L));
            new LuceneShardStatsTracker()
        parentWriter.close();
        LuceneWriter writer2 = new LuceneWriter(
    }
     * Concurrent: two indexer threads each hold their own current writer (gen 2, gen 3),
            try {
                } finally {
            try {
        // "doc2" was buffered directly, "doc1" was buffered by deleteDocument → both drain in ONE
        Writer<?> writer2 = createMockWriter(2L);
     * Full refresh flow exactly as DataFormatAwareEngine.refresh does it:
    public void testDeleteDocumentAfterGenerationRetiredGoesToParentWriter() throws IOException {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        writer2.close();
        java.nio.file.Files.createDirectories(parentDir);
        Writer<?> writer2 = mock(Writer.class);
        int numDeletes = 100;
        CountDownLatch completeLatch = new CountDownLatch(numThreads);
                    }
                } finally {
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        );
            Codec.getDefault(),
                    } catch (IllegalStateException e) {
                    deleteEngine.deleteDocument(di, locked.get());
        assertTrue(result);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        deleteEngine.createDeleter(mockWriter);
        // Setup current generation deleter
import org.opensearch.index.mapper.IdFieldMapper;
            0L,
        for (int t = 0; t < 4; t++) {
        assertTrue(deleter2.isActive());
        deleteEngine.onWriterCheckedOut(1L);
    }
        startLatch.countDown();
        assertTrue(deleter2.isActive());
                    try {
            1L,
            null,
    }
                        successCount.incrementAndGet();
        CountDownLatch startLatch = new CountDownLatch(1);
        writer2.close();
            return lock.tryLock();
                    DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
            } catch (Exception e) {
                        try {
            });
                }
                    }
    public void testConcurrentDeleteAndRefreshWithLockablePool() throws Exception {
                refreshCompleted.set(true);
                refreshing.set(true);
        startLatch.countDown();
        assertTrue("tracking an id must account for it", afterFirstId > 0L);
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                barrier.await();
        Writer<?> mockWriter = createMockWriter(1L);
    }
        deleteEngine.createDeleter(writer2);
        Writer<?> mockWriter = createMockWriter(1L);
        writer1.close();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        for (int i = 0; i < numThreads; i++) {
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "new_doc", 2L);
        });
        AtomicInteger deleteCount = new AtomicInteger(0);
                for (int i = 0; i < 5; i++) {
                    writerPool.releaseAndUnlock(locked);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        Path baseDir = createTempDir();
        assertNotNull(result);
    }
                try {
                }
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        executor.submit(() -> {
            try {
        // Thread 1: holds gen 2, deletes doc1 from gen 1 directly via gen 1's deleter
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 2L);
            }
     * writer C, not the committed parent). {@code deleteDocument} must defer the positional delete to
        assertNotNull(result);
        assertTrue(result instanceof DeleteResult.Success);
        // Thread 3 (refresh): checkoutAll after short delay
    }
    public void testBufferedDeletesWithGenerationCleanup() throws IOException {
        executor.submit(() -> {
        boolean result = deleteEngine.onWriterCheckedOut(1L);
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        assertNotNull(result);
                Thread.sleep(15);
        @Override
        LuceneWriter gen2Lucene = mock(LuceneWriter.class);
        }
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
        deleter.recordBufferedDeletes("doc2");
                } catch (Exception e) {
        Thread.sleep(20);
        executor.submit(() -> {
                    deleteEngine.onWriterCheckedOut(checkedOut.get().generation());
    }
    }
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        parentDirectory.close();
        Deleter newDeleter = deleteEngine.createDeleter(newWriter);
        assertEquals(0L, deleteEngine.ramBytesUsed());
        executor.shutdown();
import java.nio.file.Path;
                } catch (Exception e) {
            terms.getValue()
            0L,
        // Index doc1 in gen 1
            } catch (Exception e) {
        Writer<?> writer1 = createMockWriter(1L);
            } catch (Exception e) {
        CyclicBarrier barrier = new CyclicBarrier(2);
            baseDir,
        Directory parentDirectory = new MMapDirectory(parentDir);
            }
        // Generation 1 (will be checked out) and generation 2 (stays active), both with trackable child writers.
        deleter2.recordBufferedDeletes("gen2_doc1");
        executor.submit(() -> {
            Codec.getDefault(),
        AtomicBoolean refreshDone = new AtomicBoolean(false);
import java.util.concurrent.Future;
        );
                // Expected
                exception.set(e);
    // ===== Basic functionality tests =====
        writer3.close();
        AtomicInteger successCount = new AtomicInteger(0);
        Path baseDir = createTempDir();
            null,
        deleteEngine.recordWrite(docId, new DocumentLocation(1L, -1L));
        } finally {
import org.apache.lucene.store.MMapDirectory;
        // doc1's prior copy lives in the DIFFERENT, still-active generation 1, at insertion rowId 5.
    public void testRefreshReturnsNull() throws IOException {
                }
            } finally {
        deleteEngine.createDeleter(writer1);
            executor.submit(() -> {
                // Expected
        verify(gen1Lucene, never()).recordPositionalDelete(anyLong());
                    for (int i = 0; i < numDeletes; i++) {
        AtomicInteger generation = new AtomicInteger(0);
                    if (deleter != null && deleter.generation() == generation) {
        executor.shutdown();
            try {
        @Override
        Future<?> writerFuture = executor.submit(() -> {
            baseDir,
        deleter1.recordBufferedDeletes("gen1_doc1");
        parentWriter.close();
        assertTrue(result instanceof DeleteResult.Success);
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
            luceneDataFormat,
    public void testOnWriterCheckedOutWithNoBufferedDeletes() throws IOException {
                });
    //
        executor.shutdown();
        return mockWriter;
            }
            final long generation = i;
import java.util.Set;
            new LuceneShardStatsTracker()
        WriterHolder(Writer<?> writer) {
                    DeleteResult r = deleteEngine.deleteDocument(di, locked.get());
        int numThreads = 5;
        deleter.recordBufferedDeletes("doc2");
        CountDownLatch startLatch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
     */
        deleter.recordBufferedDeletes("doc1");
        Writer<?> mockWriter = createMockWriter(1L);
                        long gen = generation.incrementAndGet();
                    Writer<?> writer = createMockWriter(i);
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
     *   4. pool.releaseAndUnlock()
            new LuceneShardStatsTracker()
        // Refresh: checkout all and apply buffered deletes
                    Thread.yield();
            Codec.getDefault(),
        deleter.recordBufferedDeletes("doc1");
        executor.shutdown();
                    Thread.yield();
                // Unexpected
     * Verifies buffered deletes are applied to parentWriter and pool items are removed.
        when(gen2Lucene.generation()).thenReturn(2L);
        assertFalse(deleter.isActive());
                barrier.await();
                // Expected
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        );
    /**
        assertNotNull(result);
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
                }
        LuceneDocumentInput docInput = new LuceneDocumentInput();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        Writer<?> mockWriter = createMockWriter(1L);
        Writer<?> writer2 = createMockWriter(2L);
        Writer<?> previousWriter = mock(Writer.class);
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
                for (int i = 0; i < 100; i++) {
            luceneDataFormat,
            0L,
     * Update Case 2: the prior copy lives in a DIFFERENT still-active generation P (not the current
     * both updating the same doc that was written in gen 1. Each deletes the prior copy directly
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.shutdown();
        executor.shutdown();
        deleteEngine.createDeleter(currentWriter);
        public boolean tryLock() {
        assertTrue(exception.getMessage().contains("not supported"));
        java.nio.file.Files.createDirectories(parentDir);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        // Record some buffered deletes
            null,
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
        deleteEngine.createDeleter(writer1);
     *
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        LuceneWriter prevLuceneWriter = mock(LuceneWriter.class);
            }
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "concurrent" + i, 1L);
    public void testConcurrentRecordWriteAndOnWriterCheckedOut() throws Exception {
        verify(gen2Lucene).recordPositionalDelete(4L);
            } catch (Exception e) {
        deleter.recordBufferedDeletes("doc1");
                exception.set(e);
    }
        deleteEngine.deleteDocument(deleteDoc3, writer3);
        // Production prevents this race with the writer lock; the test verifies late-delete routing.
            luceneDataFormat,
        Writer<?> writer2 = createMockWriter(2L);
        when(writer1.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen1Lucene));
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 3L));
                barrier.await();
                completeLatch.countDown();
        assertNotNull(result);
                // Expected
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 0L));
        when(writer2.generation()).thenReturn(2L);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
                    Thread.yield();
        deleteEngine.deleteDocument(deleteInput, writer3);
            }
                throw new RuntimeException(e);
    }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            Set.of(terms.getValue())
        ExecutorService executor = Executors.newFixedThreadPool(2);
    // Updates hold only the current writer's pool lock; previous copies use their deleter lock.
                barrier.await();
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "shared_doc", 2L);
            null,
            try {
        Deleter deleter1 = deleteEngine.createDeleter(writer1);
                    Thread.yield();
    public void testDeleteDocumentInBothChildAndParentWriterEquivalent() throws IOException {
            } catch (Exception | AssertionError e) {
        Writer<?> writer2 = createMockWriter(2L);
    public void testMultiGenerationDeleteWorkflow() throws IOException {
        // Checkout thread
            try {
        });
        WriterHolder current = writerPool.getAndLock(h -> h.get().generation() == 2L);
            }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
import java.io.IOException;
            0L,
        executor.submit(() -> {
        deleteEngine.onWriterCheckedOut(1L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    startLatch.await();
        assertTrue(t2Done.get());
        executor.shutdown();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        AtomicReference<Exception> exception = new AtomicReference<>();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            0L,
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    public void testConcurrentDeleteSameDocumentId() throws Exception {
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc1", locked.get().generation());
        // Update doc1 from the current generation 2.
                    }
        assertTrue(deleter1.isActive());
                        deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.createDeleter(writer1);
        return pool;
        // Retiring the generation releases everything it tracked.
        Writer<?> mockWriter = createMockWriter(1L);
        startLatch.countDown();
            0L,
        }
    public void testRecordWrite() throws IOException {
                }
            } catch (Exception e) {
            lock.lock();
        // via gen1's OWN deleter lock — no second writer-holder lock — so this cannot deadlock against
        });
                // Expected
        public void lock() {
            });
            null,
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 2L);
                }
            luceneDataFormat,
            0L,
    }
                try {
            0L,
            3L,
            3L,
        Writer<?> mockWriter = createMockWriter(1L);
        // At least some deletes should have succeeded before checkout
        executor.submit(() -> {
        Future<?> deleteFuture = executor.submit(() -> {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            luceneDataFormat,
    public void testClose() throws IOException {
import java.util.concurrent.ConcurrentHashMap;
                closeDone.set(true);
        return new LuceneDeleteExecutionEngine(mockDataFormat, mockCommitter);
        CountDownLatch refreshStarted = new CountDownLatch(1);
            3L,
        int docsPerGeneration = 50;
            Codec.getDefault(),
        Deleter deleter2 = deleteEngine.createDeleter(writer2);
    }
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        AtomicInteger deleted = new AtomicInteger(0);
        deleteEngine.createDeleter(writer2);
    }
    public void testOnWriterCheckedOutRemovesIdToGenEntries() throws IOException {
        assertFalse(deleter2.isActive());
        ArgumentCaptor<Term[]> batches = ArgumentCaptor.forClass(Term[].class);
        deleteEngine.close();
import static org.mockito.Mockito.mock;
            }
            ConcurrentHashMap.newKeySet(),
            }
            1L,
import java.util.concurrent.CountDownLatch;
        AtomicReference<Exception> exception = new AtomicReference<>();
        Writer<?> mockWriter = mock(Writer.class);
        verify(gen2Lucene).recordPositionalDelete(9L);
        when(gen1Lucene.generation()).thenReturn(1L);
            null,
            null,
        assertTrue(result instanceof DeleteResult.Success);
        Writer<?> writer1 = createMockWriter(1L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
import org.apache.lucene.index.Term;
                        successCount.incrementAndGet();
                deleter.recordBufferedDeletes("gen" + gen + "_doc" + doc);
        assertEquals(
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
                deleteEngine.onWriterCheckedOut(1L);
                    // Some may fail if deleter becomes inactive
            DeleteInput d1 = new DeleteInput(IdFieldMapper.NAME, "doc1", locked2.get().generation());
        assertEquals(3L, deleter3.generation());
        });
        try {
        // batched call at checkout, so assert the call's contents rather than an invocation count.
            } catch (Exception e) {
        AtomicReference<Exception> unexpectedException = new AtomicReference<>();
    public void testRecordWriteOverwritesPreviousGeneration() throws IOException {
        // Prior copy of doc1 lives in generation 1 (the DIFFERENT active generation).
        });
                    Thread.yield();
                } catch (IOException e) {
        deleteEngine.createDeleter(writer2);
            writerPool.releaseAndUnlock(locked2);
import java.util.concurrent.ExecutorService;
    /**
        ExecutorService executor = Executors.newFixedThreadPool(4);
            }
            luceneDataFormat,
        verify(mockParentWriter, never()).deleteDocuments(any(Term[].class));
                startLatch.await();
        // A writer without a Lucene delegate cannot support deletes.
    public void testUpdateCase2DeletesFromDifferentActiveWriter() throws IOException {
        assertEquals(1L, deleter.generation());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        java.nio.file.Files.createDirectories(parentDir);
            });
    }
                    }
        LuceneWriter writer1 = new LuceneWriter(
        Writer<?> writer2 = createMockWriter(2L);
        });
        mockParentWriter = mock(MergeIndexWriter.class);
                barrier.await();
        parentWriter.close();
        deleter1.recordBufferedDeletes("buffered1");
        Directory parentDirectory = new MMapDirectory(parentDir);
        CyclicBarrier barrier = new CyclicBarrier(3);
            deleteEngine.recordWrite("doc1", new DocumentLocation(lockedWriter.get().generation(), -1L));
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.recordWrite("test", new DocumentLocation(2L, -1L));
            Codec.getDefault(),
            try {
                        deleteCount.incrementAndGet();
                            recordedDeletes.add(id);
        LuceneWriter writer2 = new LuceneWriter(
                    if (result instanceof DeleteResult.Success) {
            null,
 * SPDX-License-Identifier: Apache-2.0
                        successCount.incrementAndGet();
                try {
        Writer<?> writer1 = createMockWriter(1L);
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
                    exception.set(e);
        executor.submit(() -> {
        boolean hasDeletes1 = deleteEngine.onWriterCheckedOut(1L);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
                    }
                startLatch.await();
        LuceneDocumentInput docInput = new LuceneDocumentInput();
            null,
        Deleter oldDeleter = deleteEngine.createDeleter(oldWriter);
        Path parentDir = baseDir.resolve("parent");
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
                        deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());
    }
            null,
        Writer<?> writer1 = createMockWriter(1L);
    public void testConcurrentIndexAndDeleteDuringRefreshEquivalent() throws Exception {
    }
    public void testRapidGenerationCreationAndCheckout() throws Exception {
        executor.submit(() -> {
    }
import static org.mockito.Mockito.times;
import org.opensearch.index.engine.dataformat.DocumentLocation;
        }
                } catch (Exception e) {
    public void testCreateMultipleDeletersForDifferentGenerations() throws IOException {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.close();
        Future<?> deleterFuture = executor.submit(() -> {
        // Pre-create gen 1 so deletes can start immediately
    }
        writer1.close();
                    try {
        Writer<?> writer1 = createMockWriter(1L);
            executor.submit(() -> {
                    } catch (AssertionError e) {
                        }
    private LockablePool<WriterHolder> buildWriterPool(LuceneDeleteExecutionEngine deleteEngine, LuceneWriter... writers) {
        deleteEngine.createDeleter(currentWriter);
    public void testHighVolumeDeletesAcrossMultipleGenerations() throws Exception {
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 2L);
        Deleter deleter1 = deleteEngine.createDeleter(writer1);
            try {
import java.io.Closeable;
        deleter.recordBufferedDeletes("doc1");
            try {
    // ===== Helper methods =====
        assertFalse(deleter.isActive());
            0L,
            baseDir,
        Writer<?> writer1 = createMockWriter(1L);
            luceneDataFormat,
    // ===== Integration tests using LockablePool + LuceneWriter (matching DataFormatAwareEngine) =====
                barrier.await();
        when(writer2.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen2Lucene));
                }
        // ...and the current generation (C=2) receives no positional delete (Case 2 != Case 3).
        writer1.addDoc(docInput);
        LuceneWriter writer1 = new LuceneWriter(
        when(writer1.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(prevGenWriter));
        assertTrue(deleter3.isActive());
        });
        when(previousWriter.generation()).thenReturn(1L);
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "nonexistent_doc", 1L);
                for (int i = 0; i < numDocs && !done.get(); i++) {
            null,
        Writer<?> writer1 = createMockWriter(1L);
        assertFalse(deleter1.isActive());
        Writer<?> mockWriter = createMockWriter(1L);
        assertTrue(executor.awaitTermination(15, TimeUnit.SECONDS));
        // Case 2: the prior copy's positional delete is deferred to the different active generation (P=1)...
        startLatch.countDown();
        Writer<?> mockWriter2 = createMockWriter(2L);
        deleteEngine.recordWrite("doc1", new DocumentLocation(current.get().generation(), -1L));
        executor.submit(() -> {
                deleteEngine.onWriterCheckedOut(1L);
            lock.unlock();
        Path baseDir = createTempDir();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            null,
                        Thread.yield();
        WriterHolder locked3 = writerPool.getAndLock(h -> h.get().generation() == 3L);
            ConcurrentHashMap.newKeySet(),
                    if (result != null) {
    public void testRamBytesUsedTracksIdToGenEntries() throws IOException {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
     */
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        verify(mockParentWriter, times(1)).deleteDocuments(any(Term[].class));
        assertTrue(hasDeletes1);
import java.util.concurrent.atomic.AtomicReference;
                for (int i = 1; i <= 60; i++) {
        // Buffered delete applied to parentWriter
            try {
                } finally {
    /** Verifies that concurrent update and refresh complete without taking opposing pool locks. */
                    Thread.yield();
        AtomicBoolean checkoutCompleted = new AtomicBoolean(false);
     * Full update flow exactly as DataFormatAwareEngine.updateDocs does it:
                barrier.await();
            });
        LuceneDocumentInput docA = new LuceneDocumentInput();
     * in parallel; each prior copy is deleted directly via its generation's own deleter lock.
    public void testDeleteWithRefreshConcurrency() throws Exception {
        Writer<?> writer3 = createMockWriter(3L);
        Path parentDir = baseDir.resolve("parent");
            try {
        });
        }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        LuceneDocumentInput docInput = new LuceneDocumentInput();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Writer<?> writer3 = createMockWriter(3L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                startLatch.await();
        Path baseDir = createTempDir();
        assertFalse(result);
        when(writer2.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(currentGenWriter));
        Directory parentDirectory = new MMapDirectory(parentDir);
        when(prevLuceneWriter.generation()).thenReturn(1L);
                }
    public void testConcurrentCloseAndDeleteDocument() throws Exception {
                    // Some failures expected due to race conditions
        Writer<?> mockWriter = createMockWriter(1L);
        writer1.close();
        // The same id updated twice within one generation only needs one term delete.
        deleteEngine.createDeleter(writer1);
        // Current generation C=2 (the update lands here) — also trackable, so we can prove it is NOT the
import org.opensearch.index.engine.dataformat.Writer;
    /** A retired generation with a Lucene delegate applies a late delete to the parent writer. */
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 5L));
                // Unexpected
        // Re-recording a tracked id overwrites the value in place: no new entry, no growth.
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
            return new WriterHolder(w);
        );
                deleteEngine.onWriterCheckedOut(1L);
        deleter.recordBufferedDeletes("doc2");
     */
        );
                    deleteEngine.createDeleter(writer);
                        break;
        deleteEngine.recordWrite("doc2", new DocumentLocation(1L, 1L));
        assertEquals(List.of(2, 1), batches.getAllValues().stream().map(b -> b.length).toList());
        executor.shutdown();
        // Thread B (refresh): checkoutAll
        int numThreads = 10;
        assertTrue(completeLatch.await(5, TimeUnit.SECONDS));
        });
        verify(prevLuceneWriter).recordPositionalDelete(7L);
                deleteEngine.onWriterCheckedOut(1L);
        when(mockWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.empty());
    // ===== Integration tests covering interaction between LuceneDeleteExecutionEngine and DeleterImpl =====
        assertNull(exception.get());
        assertNotNull(result);
            Deleter deleter = deleteEngine.createDeleter(writer);
        });
import static org.mockito.Mockito.verify;
            } catch (IOException e) {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            } catch (Exception e) {
        // Delete thread — uses gen 1; once gen 1 is checked out, the assert will fire
    }
        // Update 2: gen 3 updates doc1 (prior copy in gen 2 deleted directly via gen 2's deleter)
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
        Writer<?> writer1 = createMockWriter(1L);
        boolean result = deleteEngine.onWriterCheckedOut(999L);
        deleter.recordBufferedDeletes("doc1");
    public void testDeleteDocumentInOldChildWriterEquivalent() throws Exception {
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
        for (int t = 0; t < 3; t++) {
            assertTrue(r1 instanceof DeleteResult.Success);
        executor.shutdown();
            try {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                Thread.sleep(5);
import org.apache.lucene.index.IndexWriterConfig;
                try {
        // positional delete to its writer.
        );
    public void testDeleteDocumentWithCurrentGeneration() throws IOException {
        writerFuture.get(10, TimeUnit.SECONDS);
    /**
        deleter.recordBufferedDeletes("doc1");
import org.opensearch.index.mapper.Uid;
                for (int i = 0; i < 10; i++) {
    public void testOnWriterCheckedOutDeduplicatesRepeatedIds() throws IOException {
            1L,
        }
        writer1.addDoc(docInput);
        LuceneWriter writer1 = new LuceneWriter(
        Writer<?> mockWriter = createMockWriter(1L);
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        LuceneDocumentInput docInput = new LuceneDocumentInput();
        );
        deleteEngine.createDeleter(mockWriter);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, currentWriter);
            try {
        }
        Directory parentDirectory = new MMapDirectory(parentDir);
        deleteEngine.createDeleter(writer3);
            } catch (Exception e) {
        Deleter deleter3 = deleteEngine.createDeleter(writer3);
            luceneDataFormat,
                    completeLatch.countDown();
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
        });
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 7L));
    private LuceneDeleteExecutionEngine createDeleteEngineWithParentWriter(MergeIndexWriter parentWriter) {
        }
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2, writer3);
    private DataFormat mockDataFormat;
        CountDownLatch startLatch = new CountDownLatch(1);
    public void testOnWriterCheckedOut() throws IOException {
import java.util.LinkedList;
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 0L));
        when(writerWithoutLuceneDelegate.generation()).thenReturn(1L);
            ConcurrentHashMap.newKeySet(),
     * intermediate updates are correctly applied to parentWriter during checkout.
import static org.mockito.ArgumentMatchers.anyLong;
        AtomicBoolean deleteCompleted = new AtomicBoolean(false);
            Codec.getDefault(),
        Writer<?> mockWriter = createMockWriter(1L);
            2L,
     *   pool.checkoutAll(w -> deleteEngine.onWriterCheckedOut(w.get().generation()))
        LockablePool<WriterHolder> pool = new LockablePool<>(() -> {
        LuceneCommitter committer = mock(LuceneCommitter.class);
                try {
    public void testUpdateFlowWithLockablePool() throws IOException {
        parentDirectory.close();
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
            Codec.getDefault(),
            try {
        });
            }
        assertTrue(refreshCompleted.get());
                deleteEngine.deleteDocument(deleteInput, mockWriter);
        assertFalse(deleteEngine.onWriterCheckedOut(1L));
import org.opensearch.index.engine.dataformat.DeleteInput;
        executor.submit(() -> {
        ArgumentCaptor<Term[]> batches = ArgumentCaptor.forClass(Term[].class);
        assertEquals("overwriting an id must not grow the footprint", 3 * afterFirstId, deleteEngine.ramBytesUsed());
                startLatch.await();
import java.util.Optional;
            try {
        writer1.close();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        AtomicBoolean t1Done = new AtomicBoolean(false);
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
                        }
        assertTrue(hasDeletes2);
            null,
        Writer<?> mockWriter = createMockWriter(1L);
            luceneDataFormat,
        assertFalse(deleter.isActive());
            }
        executor.shutdown();
    }
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 3L));
            }
        deleteEngine.createDeleter(mockWriter);
                            break;
        java.nio.file.Files.createDirectories(parentDir);
        // Pool item removed — evaluateAllAndLock returns null
                }
                throw new RuntimeException(e);
            try {
        parentWriter.close();
            1L,
    }
import java.util.List;
        deleteEngine.createDeleter(writer2);
        verify(prevGenWriter).recordPositionalDelete(5L);
        refresh.get(30, TimeUnit.SECONDS);
    }
                        Deleter deleter = deleteEngine.createDeleter(writer);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            } catch (Exception e) {
        assertFalse(deleter.isActive());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        assertFalse(deleter.isActive());
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
 * compatible open source license.
    public void testDeleteWithDocumentInBothGenerations() throws IOException {
        for (int i = 0; i < writers.length; i++) {
            } catch (Exception e) {
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        Writer<?> mockWriter = createMockWriter(1L);
                Thread.sleep(20);
    }
     */
        WriterHolder lockedWriter = writerPool.getAndLock(h -> h.get().generation() == 2L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        AtomicInteger successCount = new AtomicInteger(0);
    }
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        Closeable lock = writerPool.evaluateAllAndLock(h -> h.get().generation() == 1L);
    public void testDeleteDocumentNoRecordedWriteReturnsSuccess() throws IOException {
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 3L);
        Writer<?> mockWriter = mock(Writer.class);
            DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", lockedWriter.get().generation());
        assertNotNull(result);
        assertNotNull(result);
        oldDeleter.recordBufferedDeletes("old_buffered");
        Writer<?> writer1 = createMockWriter(1L);
            baseDir,
        AtomicBoolean refreshCompleted = new AtomicBoolean(false);
        assertNotNull(result);
        parentWriter.close();
        Path parentDir = baseDir.resolve("parent");
        IllegalArgumentException exception = expectThrows(
        verify(mockParentWriter, times(2)).deleteDocuments(batches.capture());
                    deleteEngine.recordWrite("doc" + i, new DocumentLocation(1L, -1L));
        ExecutorService executor = Executors.newFixedThreadPool(4);
                startLatch.await();
            DeleteInput d2 = new DeleteInput(IdFieldMapper.NAME, "doc1", locked3.get().generation());
                Thread.sleep(30);
    // ===== Stress tests =====
        assertFalse(deleter2.isActive());
        assertNull(exception.get());
        });
        verify(gen1Lucene, never()).recordPositionalDelete(anyLong());
                } finally {
        assertNotNull(result);
    // Pool: new LockablePool<>(() -> { Writer w = new LuceneWriter(...); deleteEngine.createDeleter(w); return WriterHolder(w); })
        });
                }
        );
}
        when(writer2.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen2Lucene));
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    }
        }, LinkedList::new, 1);
                }
            () -> deleteEngine.deleteDocument(deleteInput, writerWithoutLuceneDelegate)
        writer3.close();
        // Refresh: checkoutAll must lock every writer (gen1 + gen2); it will block on gen2 (held above).
        // at its own flush, using the recorded insertion rowId — not an in-generation Term delete.
                barrier.await();
        CyclicBarrier barrier = new CyclicBarrier(3);
        // Delete may or may not complete depending on timing
    public void testOnWriterCheckedOutWithNoDeleter() throws IOException {
                        throw new RuntimeException(e);
        int numThreads = 10;
        // Previous, still-active generation P=1 holds the prior copy of doc1 (trackable child writer).
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
        CountDownLatch startLatch = new CountDownLatch(1);
            Codec.getDefault(),
        startLatch.countDown();
        Writer<?> writer3 = createMockWriter(3L);
    // ===== Test cases inspired by CompositeIndexWriter patterns =====
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2);
            for (int doc = 0; doc < docsPerGeneration; doc++) {
            baseDir,
    }
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
            Codec.getDefault(),
            });
            new LuceneShardStatsTracker()
import org.apache.lucene.index.MergeIndexWriter;
    }
        );
                writerPool.checkoutAll(checkedOutWriter -> {
            writerPool.releaseAndUnlock(locked3);
        assertTrue(result instanceof DeleteResult.Success);
            try {
        // matcher would not match a multi-term call at all.
    }
        });
    public void testCreateDeleter() throws IOException {
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        assertSame(mockDataFormat, deleteEngine.getDataFormat());
            baseDir,
        writer2.addDoc(docB);
        when(writer1.generation()).thenReturn(1L);
    }
        assertTrue(deleter1.isActive());
        // parentWriter should have uncommitted changes from applied buffered deletes
        assertNull(deleteEngine.createDeleter(mockWriter));
            } catch (Exception e) {
        deleteEngine.close();
        LuceneWriter writer3 = new LuceneWriter(
        // The per-entry cost is a nominal estimate, so it does not vary with the id's length.
import org.opensearch.be.lucene.LuceneDataFormat;
        assertTrue(parentWriter.hasUncommittedChanges());
            luceneDataFormat,
        deleteEngine.recordWrite("old_doc", new DocumentLocation(1L, -1L));
        } finally {
        // One batched call per generation, regardless of how many ids that generation buffered.
        assertTrue(result instanceof DeleteResult.Success);
                deleteCompleted.set(true);
                }
                }
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc1", locked.get().generation());
            }
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2, writer3);
        assertNotNull(result);
                try {
                // Expected
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        for (int i = 0; i < numThreads; i++) {
            null,
        writer1.addDoc(docA);
        // doc_a in gen 1, doc_b in gen 2
        deleteEngine.onWriterCheckedOut(1L);
        // Parquet-only (no Lucene sub-writer): createDeleter skips and returns null rather than throwing.
            ConcurrentHashMap.newKeySet(),
        verify(mockParentWriter, times(1)).deleteDocuments(any(Term[].class));
    }
                    deleteEngine.recordWrite("doc" + i, new DocumentLocation(1L, -1L));
                barrier.await();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.createDeleter(mockWriter);
import java.util.concurrent.locks.ReentrantLock;
            }
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                    DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        Writer<?> writer1 = mock(Writer.class);
        // Index doc in gen 1
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
            try {
        mockCommitter = mock(LuceneCommitter.class);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
                    completeLatch.countDown();
        Writer<?> mockWriter = createMockWriter(1L);
                    if (r instanceof DeleteResult.Success) {
    }
    }
        executor.shutdown();
            baseDir,
            2L,
            luceneDataFormat,
    /**
     */
        LuceneWriter writer1 = new LuceneWriter(
            baseDir,
                exception.set(e);
    // ===== Close behavior tests =====
    /**
            executor.submit(() -> {
     * Guards against the former AB-BA deadlock: updates hold the current writer's pool lock and use
        // Setup previous generation with a trackable LuceneWriter (holds the prior version of doc1).
        });
     * the previous generation's deleter lock, while refresh waits only on pool locks.
     * P's deleter, never C's — distinguishing Case 2 from Case 3 (prior copy in the same writer).
        Writer<?> writer1 = mock(Writer.class);
    }
    public void testBufferedDeletesNotLostOnConcurrentDeactivation() throws Exception {
            null,
        deleteEngine.createDeleter(writer3);
            } catch (Exception e) {
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
        assertNull(deleteEngine.refresh(null));
                // Unexpected
        assertTrue(deleted.get() > 0);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
    public void testUpdateHoldingCurrentWriterDoesNotDeadlockAgainstRefresh() throws Exception {
            2L,
            2L,
            try {
                for (int i = 0; i < numDocs && !done.get(); i++) {
        assertNull(unexpectedException.get());
            Codec.getDefault(),
import java.util.concurrent.atomic.AtomicInteger;
    /**
        when(gen2Lucene.generation()).thenReturn(2L);
                    deleteEngine.deleteDocument(di, locked.get());
        // Checkout thread
        assertNull(exception.get());
        assertTrue(deleteEngine.onWriterCheckedOut(1L));
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        assertTrue(result instanceof DeleteResult.Success);
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
                    } catch (Exception e) {
    public void testMultipleSequentialUpdatesThenRefreshWithLockablePool() throws IOException {
        executor.shutdown();
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, newWriter);
                try {
            null,
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
            0L,
                    } catch (IOException e) {
        Thread.sleep(50);
            boolean hasDeletes = deleteEngine.onWriterCheckedOut(gen);
        } finally {
                startLatch.await();
        assertTrue(deleter2.isActive());
        CountDownLatch completeLatch = new CountDownLatch(numThreads);
                        deleter.recordBufferedDeletes("doc_gen_" + gen);
                    deleteEngine.deleteDocument(deleteInput, mockWriter);
            } catch (Exception e) {
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, docId, 2L);
    public void testCloseIsIdempotent() throws IOException {
        docA.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        assertArrayEquals(new Term[] { new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")) }, terms.getValue());
        assertTrue(indexed.get() > 0);
        assertEquals("nothing tracked yet", 0L, deleteEngine.ramBytesUsed());
            ConcurrentHashMap.newKeySet(),
package org.opensearch.be.lucene.index;
        deleteEngine.createDeleter(writer2);
            deleteEngine.recordWrite("doc1", new DocumentLocation(locked2.get().generation(), -1L));
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 2L);
     *   3. deleteEngine.recordWrite(uid, currentWriter.gen())
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 2L);
        // deleteDocument buffers "doc1" on gen 1's deleter
            LuceneWriter w = iter.next();
            baseDir,
        // Initial write in gen 1
            1L,
                // Expected
import org.apache.lucene.store.Directory;
        when(mockCommitter.getIndexWriter()).thenReturn(mockParentWriter);
        Directory parentDirectory = new MMapDirectory(parentDir);
        // One batched call per generation; every buffered id still reaches the parent writer.
        );
                checkoutCompleted.set(true);
                    DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
            });
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        parentDirectory.close();
        deleteEngine.createDeleter(writer2);
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
        AtomicBoolean done = new AtomicBoolean(false);
        java.nio.file.Files.createDirectories(parentDir);
        Directory parentDirectory = new MMapDirectory(parentDir);
    private Writer<?> createMockWriter(long generation) {
    }
        CountDownLatch completeLatch = new CountDownLatch(2);
        writer1.addDoc(docInput);
        Writer<?> writer1 = mock(Writer.class);
                    }
        deleter2.recordBufferedDeletes("buffered2");
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    public void testDeleteWithOldAndCurrentGenerations() throws IOException {
        super.setUp();
                    barrier.await();
                    barrier.await();
        assertNotNull(result);
        deleteEngine.createDeleter(writer1);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        assertFalse(oldDeleter.isActive());
        String docId = "shared_doc";
            2L,
    }
        assertTrue(result instanceof DeleteResult.Success);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
            new LuceneShardStatsTracker()
                // Expected if deleter becomes inactive or was already removed
    private LuceneCommitter mockCommitter;
     * Multiple sequential updates then refresh. Verifies all buffered deletes from
    }
        deleteEngine.createDeleter(mockWriter);
                }
                        deleteEngine.deleteDocument(deleteInput, mockWriter);
            luceneDataFormat,
        assertEquals(2L, deleter2.generation());
        executor.submit(() -> {
                for (int i = 0; i < 200; i++) {
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 3L);
                    }
        private final Writer<?> writer;
    public void testCloseWithPendingBufferedDeletes() throws IOException {
import org.apache.lucene.codecs.Codec;
            } catch (Exception e) {
            Writer<?> writer = createMockWriter(gen);
            new LuceneShardStatsTracker()
        deleteEngine.onWriterCheckedOut(1L);
            } catch (Exception e) {
        java.nio.file.Files.createDirectories(parentDir);
                        break;
        assertEquals(2, successCount.get());
        CyclicBarrier barrier = new CyclicBarrier(2);
        Writer<?> writer1 = createMockWriter(1L);
        Path baseDir = createTempDir();
        assertNotNull(deleter);
        deleteEngine.onWriterCheckedOut(1L);
        Writer<?> mockWriter = createMockWriter(1L);
            } catch (Exception e) {
                DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc3", 1L);
        executor.submit(() -> {
        verify(mockParentWriter, never()).deleteDocuments(any(Term[].class));
                    try {
                        successCount.incrementAndGet();
        );
                }
                } catch (Exception e) {
                        // Generation may not exist yet
                }
                deleteEngine.onWriterCheckedOut(1L);
            executor.submit(() -> {
        writer2.close();
                } finally {
                // Expected
        LuceneWriter prevGenWriter = mock(LuceneWriter.class);
    private static class WriterHolder implements Lockable {
            new LuceneShardStatsTracker()
        deleteEngine.onWriterCheckedOut(1L);
        Writer<?> writer1 = createMockWriter(1L);
 * this file be licensed under the Apache-2.0 license or a
        verify(mockParentWriter, never()).deleteDocuments(any(Term[].class));
        assertFalse(deleter2.isActive());
        public void unlock() {
        LuceneDocumentInput docInput = new LuceneDocumentInput();
    public void testConcurrentCloseAndOnWriterCheckedOut() throws Exception {
        executor.shutdown();
            }
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
        Writer<?> writer2 = createMockWriter(2L);
        deleteEngine.recordWrite("test", new DocumentLocation(2L, -1L));
     * while refresh runs. Each indexer holds a different current writer, so their updates proceed
            } catch (Exception e) {
        deleteEngine.createDeleter(writer2);
                        throw new RuntimeException(e);
    public void testUpdateDocumentEquivalent() throws IOException {
        when(mockWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(mockLuceneWriter));
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
                }
        deleteEngine.recordWrite("shared_doc", new DocumentLocation(1L, -1L));
        writer1.addDoc(docInput);
                    deleteEngine.recordWrite("doc_b", new DocumentLocation(locked.get().generation(), -1L));
                        deleter.recordBufferedDeletes("doc" + i);
        verify(currentGenWriter, never()).recordPositionalDelete(anyLong());
        });
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 0L));
            null,
        Path parentDir = baseDir.resolve("parent");
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc" + i, 1L);
        });
                Thread.sleep(20); // Let Thread A acquire the current writer (gen2) and start its update first
        deleter.recordBufferedDeletes("doc1");
            null,
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 1L));
                    } catch (Exception e) {
        parentDirectory.close();
import static org.mockito.Mockito.when;
            try {
                } finally {
        );
            1L,
        Path parentDir = baseDir.resolve("parent");
            Codec.getDefault(),
    /**
                }
                t2Done.set(true);
        writer1.close();
        Deleter deleter2 = deleteEngine.createDeleter(writer2);
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
                    try {
            try {
        // Supersede doc1's prior copy in the DIFFERENT active generation (gen1). Current design deletes
            }
import java.util.concurrent.CyclicBarrier;
        executor.submit(() -> {
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        when(writerWithoutLuceneDelegate.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.empty());
                        deleteEngine.onWriterCheckedOut(i);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            0L,
            } catch (Exception e) {
        LuceneWriter writer1 = new LuceneWriter(
        Deleter deleter1 = deleteEngine.createDeleter(writer1);
        assertTrue(successCount.get() > 0);
        boolean hasDeletes = deleteEngine.onWriterCheckedOut(1L);
            try {
                    // Expected
                    Thread.yield();
        LuceneWriter writer1 = new LuceneWriter(
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer1);
    // Refresh: pool.checkoutAll(w -> deleteEngine.onWriterCheckedOut(w.get().generation()))
                    try {
        AtomicReference<Exception> exception = new AtomicReference<>();
                            deleter.recordBufferedDeletes(id);
        deleteEngine.deleteDocument(deleteInput, writer1);
     */
            luceneDataFormat,
        Writer<?> writer2 = mock(Writer.class);
            final String docId = "doc" + i;
        when(writer1.generation()).thenReturn(1L);
        docB.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        Writer<?> get() {
    public void testConcurrentGenerationRotation() throws Exception {
            try {
        // Updater grabs the CURRENT writer (gen2) FIRST — the exact precondition of the old deadlock.
        Writer<?> mockWriter = createMockWriter(1L);
        assertFalse(deleter1.isActive());
    }
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
import org.mockito.ArgumentCaptor;
            }
    }
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 3L);
        when(currentGenWriter.generation()).thenReturn(2L);
import org.opensearch.common.queue.LockablePool;
            null,
        Writer<?> mockWriter = createMockWriter(1L);
                // Unexpected
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
        assertNull(lock);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
        Writer<?> mockWriter = createMockWriter(1L);
                try {
            assertTrue(r2 instanceof DeleteResult.Success);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            Codec.getDefault(),
        executor.submit(() -> {
        executor.shutdown();
            try {
            } catch (Exception e) {
        });
        assertEquals("retiring the generation must release its entries", 0L, deleteEngine.ramBytesUsed());
    }
        // Recording doc1 twice: the later write (gen 2, rowId 9) must win.
    }
        executor.submit(() -> {
                Thread.sleep(10);
                }
        Writer<?> writer2 = mock(Writer.class);
        Path parentDir = baseDir.resolve("parent");
        assertEquals(1L, deleter1.generation());
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2, writer3);
            DeleteResult r1 = deleteEngine.deleteDocument(d1, locked2.get());
        assertFalse(result);
        Deleter deleter1 = deleteEngine.createDeleter(writer1);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
        LuceneWriter writer2 = new LuceneWriter(
            ConcurrentHashMap.newKeySet(),
        deleteEngine.recordWrite("doc2", new DocumentLocation(1L, 1L));
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
                deleteCompleted.set(true);
        Writer<?> mockWriter = createMockWriter(1L);
        ExecutorService executor = Executors.newSingleThreadExecutor();
            ConcurrentHashMap.newKeySet(),
                // Unexpected
        barrier.await();
        AtomicInteger successCount = new AtomicInteger(0);
        executor.submit(() -> {
        ExecutorService executor = Executors.newFixedThreadPool(2);
    }
        writer2.close();
                    Writer<?> mockWriter = createMockWriter(generation);
            null,
    public void testDeleteDocumentInParentWriterEquivalent() throws IOException {
        assertFalse(deleter.isActive());
            } catch (Exception e) {
        LuceneWriter writer2 = new LuceneWriter(
                } catch (Exception e) {
            executor.submit(() -> {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        // The positional delete must be deferred to generation 2's writer (at rowId 9), never gen 1's.
    }
        boolean hasDeletes2 = deleteEngine.onWriterCheckedOut(2L);
                    }
            try {
        CountDownLatch startLatch = new CountDownLatch(1);
        }
        Writer<?> currentWriter = createMockWriter(2L);
    // Update: pool.getAndLock() → deleteEngine.deleteDocument(input, currentWriter) → recordWrite → pool.releaseAndUnlock()
            null,
    }
        when(gen1Lucene.generation()).thenReturn(1L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        assertEquals(numThreads, successCount.get());
            0L,
                barrier.await();
        when(writer1.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen1Lucene));
    }
        parentDirectory.close();
        DeleteInput deleteDoc3 = new DeleteInput(IdFieldMapper.NAME, "doc3", 3L);
                }
        assertTrue(closeDone.get());
                    }
            }
                    deleteEngine.deleteDocument(di, locked.get());
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // New child-side routing: a positional (liveDocs-only) delete is deferred to gen 1's writer
        deleteEngine.createDeleter(mockWriter);
        deleteEngine.recordWrite("doc_b", new DocumentLocation(2L, -1L));
        when(committer.getIndexWriter()).thenReturn(parentWriter);
        deleteEngine.recordWrite("doc1", new DocumentLocation(2L, 9L));
            null,
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
                        successCount.incrementAndGet();
        executor.submit(() -> {
    }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        parentDirectory.close();
        LuceneWriter writer2 = new LuceneWriter(
public class LuceneDeleteExecutionEngineTests extends OpenSearchTestCase {
        assertArrayEquals(new Term[] { new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")) }, terms.getValue());
import org.opensearch.index.engine.dataformat.Deleter;
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1);
        deleteEngine.createDeleter(writer1);
        );
        verify(prevLuceneWriter).recordPositionalDelete(3L);
    public void testConcurrentMultipleUpdatesAndRefreshWithLockablePool() throws Exception {
        for (int gen = 1; gen <= numGenerations; gen++) {
        AtomicBoolean closeDone = new AtomicBoolean(false);
            null,
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        Directory parentDirectory = new MMapDirectory(parentDir);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    @Override
        assertFalse(deleter.isActive());
        Writer<?> writer2 = createMockWriter(2L);
        deleteEngine.recordWrite("a-considerably-longer-document-identifier", new DocumentLocation(1L, 2L));
        assertTrue(result instanceof DeleteResult.Success);
            new LuceneShardStatsTracker()
        for (int gen = 1; gen <= numGenerations; gen++) {
            } catch (Exception e) {
                    deleteEngine.recordWrite("doc1", new DocumentLocation(locked.get().generation(), -1L));
            } catch (Exception e) {
        assertArrayEquals(
    public void testConcurrentDeleterCreation() throws Exception {
            try {
        CyclicBarrier barrier = new CyclicBarrier(4);
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
            } catch (Exception e) {
import java.util.concurrent.atomic.AtomicBoolean;
                        deleter.recordBufferedDeletes("doc" + i);
                } catch (IOException e) {
        });
        // gen 1 drained two ids, gen 2 drained one.
                // Expected when deleter becomes inactive
        assertTrue(result instanceof DeleteResult.Success);
        when(prevGenWriter.generation()).thenReturn(1L);
            return writer;
            baseDir,
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2);
            new LuceneShardStatsTracker()
                exception.set(e);
                        String id = "t" + threadId + "_doc" + i;
                    }
        assertTrue(checkoutCompleted.get());
        CountDownLatch startLatch = new CountDownLatch(1);
/*
        Writer<?> mockWriter = createMockWriter(1L);
        Writer<?> writer3 = createMockWriter(3L);
                        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer1);
        );
    }
        writer3.close();
        Writer<?> previousWriter = mock(Writer.class);
        // Thread 2: update doc_b from gen 3 (previous gen = 2)
        deleteEngine.createDeleter(previousWriter);
        Writer<?> writerWithoutLuceneDelegate = mock(Writer.class);
        Writer<?> mockWriter = createMockWriter(1L);
        });
                writerPool.checkoutAll(checkedOutWriter -> {
    }
        Deleter deleter2 = deleteEngine.createDeleter(writer2);
        LuceneWriter writer1 = new LuceneWriter(
            deleteEngine.recordWrite("doc1", new DocumentLocation(locked3.get().generation(), -1L));
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2);
            2L,
        Writer<?> writer2 = createMockWriter(2L);
        AtomicInteger successfulDeletes = new AtomicInteger(0);
        executor.shutdown();
            }
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
            ConcurrentHashMap.newKeySet(),
        try {
        // Thread A (indexer): updateDocs
            refreshStarted.countDown();
        AtomicInteger successCount = new AtomicInteger(0);
        int numDocs = scaledRandomIntBetween(50, 200);
        assertFalse(deleter.isActive());
            } catch (Exception e) {
        Writer<?> mockWriter = createMockWriter(1L);
        writer1.close();
                deleteEngine.close();
        Path parentDir = baseDir.resolve("parent");
    }
            baseDir,
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
                startLatch.await();
        AtomicBoolean t2Done = new AtomicBoolean(false);
            }
            ConcurrentHashMap.newKeySet(),
        // recordWrite routes doc1 to generation 1 at insertion rowId 3.
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    }
    public void testConcurrentRecordWriteAndDelete() throws Exception {
            pool.releaseAndUnlock(h);
        deleteEngine.deleteDocument(new DeleteInput(IdFieldMapper.NAME, "doc1", 3L), writer3);
    public void testConcurrentDeleteAndWriterCheckout() throws Exception {
        }
            }
                deleteEngine.onWriterCheckedOut(1L);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        writerPool.releaseAndUnlock(current);
                deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());
                // Unexpected
                    indexed.incrementAndGet();
        assertEquals("entry cost must not depend on id length", 3 * afterFirstId, deleteEngine.ramBytesUsed());
            1L,
            baseDir,
                barrier.await();
                        } catch (IllegalStateException e) {
        deleteEngine.onWriterCheckedOut(1L);
        writer1.addDoc(docInput);
            null,
import org.opensearch.index.engine.dataformat.DeleteResult;
                    Thread.sleep(10);
        deleteEngine.createDeleter(writer1);
            new LuceneShardStatsTracker()
                        // Expected when engine closes
                barrier.await();
        int numGenerations = 5;
                        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc" + i, 1L);
            final int threadId = t;
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
    public void testRefreshFlowWithLockablePool() throws IOException {
        assertTrue(deleter.isActive());
        writerPool.checkoutAll(checkedOutWriter -> {
                startLatch.await();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
        }
        // Deleting from the current generation (2) must resolve doc1 to generation 1 and defer a
            0L,
                for (int i = 2; i <= 5; i++) {
        // Checking out generation 1 drops its idToGen entries (doc1, doc2) but leaves doc3 -> gen 2 intact.
                });
        assertNotNull(result);
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 3L);
            } catch (Exception e) {
        // Generations 1 and 2 both get trackable Lucene child writers.
        LuceneWriter gen1Lucene = mock(LuceneWriter.class);
            ConcurrentHashMap.newKeySet(),
        deleteEngine.recordWrite("doc3", new DocumentLocation(2L, 4L));
        });
    public void testCompleteDeleteWorkflow() throws IOException {
            writerPool.releaseAndUnlock(lockedWriter);
                for (int i = 0; i < 10; i++) {
        }
        deleteEngine.createDeleter(writer2);
                // Unexpected
        deleteEngine.onWriterCheckedOut(1L);
        assertEquals(numThreads, successCount.get());
                        successCount.incrementAndGet();
    }
                } finally {
                    }
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc1", locked.get().generation());
        Writer<?> mockWriter = createMockWriter(1L);
            DeleteResult result = deleteEngine.deleteDocument(deleteInput, lockedWriter.get());
        deleteEngine.createDeleter(mockWriter);
        });
            ConcurrentHashMap.newKeySet(),
                completeLatch.countDown();
        CyclicBarrier barrier = new CyclicBarrier(2);
        boolean result = deleteEngine.onWriterCheckedOut(1L);
        LuceneWriter currentGenWriter = mock(LuceneWriter.class);
            new LuceneShardStatsTracker()
        });
            }
            assertTrue(hasDeletes);
        assertTrue(refreshDone.get());
        assertFalse(deleter.isActive());
        // === refresh flow ===
        executor.submit(() -> {
            }
            DeleteResult r2 = deleteEngine.deleteDocument(d2, locked3.get());
        Path baseDir = createTempDir();
                    }
            baseDir,
            new LuceneShardStatsTracker()
        // Delete thread — lookupGen uses Term(_id, Uid.encodeId("doc"+i)).bytes() which matches above
        CyclicBarrier barrier = new CyclicBarrier(2);
        CountDownLatch startLatch = new CountDownLatch(1);
                barrier.await();
            new Term[] { new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")), new Term(IdFieldMapper.NAME, Uid.encodeId("doc2")) },
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
                // Expected
                    }
        writerPool.checkoutAll(checkedOutWriter -> {
            } catch (Exception e) {
        Writer<?> writer2 = createMockWriter(2L);
            try {
        assertTrue(result instanceof DeleteResult.Success);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        ExecutorService executor = Executors.newFixedThreadPool(2);
            luceneDataFormat,
    // ===== Analogous to CompositeIndexWriter update/delete patterns =====
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
        assertNotNull(result);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        executor.shutdown();
        Future<?> checkoutFuture = executor.submit(() -> {
        });
        assertTrue(result instanceof DeleteResult.Success);
            null,
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.createDeleter(mockWriter);
            IllegalArgumentException.class,
                    writerPool.releaseAndUnlock(locked);
        deleteEngine.onWriterCheckedOut(1L);
                    // Expected for some threads due to race conditions
        LuceneWriter gen1Lucene = mock(LuceneWriter.class);
        assertTrue(result instanceof DeleteResult.Success);
            }
                done.set(true);
        );
        deleter1.recordBufferedDeletes("doc1");
        // Thread 2: holds gen 3, also deletes doc1 from gen 1 directly via gen 1's deleter
            baseDir,
        // vararg array — Mockito 5 requires one matcher per expanded argument, so a single Term
    }
            }
    }
        assertTrue(deleteCount.get() > 0);
        // Let the refresh thread reach checkoutAll and block on the current writer we hold.
        when(prevLuceneWriter.generation()).thenReturn(1L);
        // Index doc1 in gen 1
        Deleter deleter1 = deleteEngine.createDeleter(writer1);
        LuceneWriter writer3 = new LuceneWriter(
            new LuceneShardStatsTracker()
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
                exception.set(e);
                        Writer<?> writer = createMockWriter(gen);
        executor.submit(() -> {
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                barrier.await();
                for (int i = 0; i < 100; i++) {
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, docId, 1L);
        );
                // Expected
    private LuceneDeleteExecutionEngine createDeleteEngine() {
        deleteEngine.createDeleter(writer1);
        // === updateDocs flow ===
        Writer<?> mockWriter1 = createMockWriter(1L);
                // Expected
        LuceneWriter gen2Lucene = mock(LuceneWriter.class);
        });
        deleter.recordBufferedDeletes("doc2");
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        when(previousWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(prevLuceneWriter));
        deleter.recordBufferedDeletes("doc1");
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc_a", locked.get().generation());
            Codec.getDefault(),
        executor.submit(() -> {
            ConcurrentHashMap.newKeySet(),
import static org.mockito.ArgumentMatchers.any;
        assertTrue(result instanceof DeleteResult.Success);
        });
    public void testConcurrentWriterCheckoutAndDelete() throws Exception {
        AtomicBoolean deleteCompleted = new AtomicBoolean(false);
        assertEquals(numGenerations * docsPerGeneration, batches.getAllValues().stream().mapToInt(b -> b.length).sum());
                        deleted.incrementAndGet();
        // Thread 1: update doc_a from gen 3 (previous gen = 1)
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
                    writerPool.releaseAndUnlock(locked);
        assertEquals("footprint is a fixed cost per tracked entry", 2 * afterFirstId, deleteEngine.ramBytesUsed());
    public void testOnWriterCheckedOutCalledTwiceForSameGeneration() throws IOException {
    }
        }
                refreshDone.set(true);
 *
        // Record the prior version of doc1 in generation 1 at insertion rowId 7.
        deleteEngine.createDeleter(writer1);
        deleteFuture.get(5, TimeUnit.SECONDS);
        executor.shutdown();
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
            } catch (Exception e) {
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc_b", locked.get().generation());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    } catch (IOException e) {
        long afterFirstId = deleteEngine.ramBytesUsed();
        }
        deleteEngine.createDeleter(writer3);
            Codec.getDefault(),
            null,
        // Writer thread — uses Uid.encodeId so the key matches what deleteDocument looks up
        when(previousWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(prevLuceneWriter));
        Writer<?> writer2 = createMockWriter(2L);
        // the refresh block-locking gen2. Then release gen2 so checkoutAll can finish.
        parentDirectory.close();
        when(writer2.generation()).thenReturn(2L);
                        if (result instanceof DeleteResult.Success) {
        WriterHolder locked2 = writerPool.getAndLock(h -> h.get().generation() == 2L);
            ConcurrentHashMap.newKeySet(),
        ExecutorService executor = Executors.newFixedThreadPool(2);
        private final ReentrantLock lock = new ReentrantLock();
            baseDir,
        startLatch.countDown();
        for (int i = 0; i < numThreads; i++) {
     *   2. deleteEngine.deleteDocument(DeleteInput(id, currentWriter.gen()), currentWriter)
            WriterHolder h = pool.getAndLock();
            deleteEngine.createDeleter(w);
    public void testRamBytesUsedResetOnClose() throws IOException {
    public void testGetDataFormat() {
        when(previousWriter.generation()).thenReturn(1L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        }
        AtomicInteger indexed = new AtomicInteger(0);
    public void testDeleteAfterAllGenerationsCheckedOut() throws IOException {
            luceneDataFormat,
    public void testDeleteDocumentInChildWriterEquivalent() throws IOException {
        verify(mockParentWriter, times(1)).deleteDocuments(any(Term[].class));
        });
                    throw new RuntimeException(e);
        executor.submit(() -> {
            Codec.getDefault(),
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        // Update 1: gen 2 updates doc1 (prior copy in gen 1 deleted directly via gen 1's deleter)
        assertTrue(deleteEngine.onWriterCheckedOut(2L));
        }
                barrier.await();
                deleteEngine.onWriterCheckedOut(1L);
            null,
            ConcurrentHashMap.newKeySet(),
    // ===== Multi-threading tests =====
            ConcurrentHashMap.newKeySet(),
     *        (previous generation resolved internally via lookupGen; deleted via its own deleter lock)
                startLatch.await();
        // doc1 was routed to the retired gen 1: its entry is gone, so no positional delete on gen 1's writer.
                }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        AtomicBoolean refreshing = new AtomicBoolean(false);
        executor.submit(() -> {
            }
        writer2.close();
    }
                    DeleteResult r = deleteEngine.deleteDocument(di, locked.get());
            null,
        try {
        AtomicInteger successCount = new AtomicInteger(0);
    }
                barrier.await();
        assertNotNull(result);
        );
        return new LuceneDeleteExecutionEngine(new LuceneDataFormat(), committer);
        deleteEngine.close();
                    if (result instanceof DeleteResult.Success) {
        checkoutFuture.get(5, TimeUnit.SECONDS);
        assertTrue(deleteCompleted.get());
        LuceneDocumentInput docB = new LuceneDocumentInput();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            }
        Writer<?> writer1 = createMockWriter(1L);
                startLatch.await();
    }
    }
        // Batched: one call carrying every drained term, so Lucene resolves them in a single pass
        deleteEngine.recordWrite("doc_a", new DocumentLocation(1L, -1L));
import org.opensearch.common.queue.Lockable;
        }
        java.util.Iterator<LuceneWriter> iter = java.util.Arrays.asList(writers).iterator();
     * from gen 1 via that generation's deleter (its read lock permits concurrent deleteDoc), with
import java.util.concurrent.Executors;
        Writer<?> oldWriter = createMockWriter(1L);
                // Expected
            baseDir,
                    if (r instanceof DeleteResult.Success) {
        deleteEngine.createDeleter(writer1);
                deleteEngine.recordWrite("gen" + gen + "_doc" + doc, new DocumentLocation(gen, -1L));
                    Deleter deleter = deleteEngine.createDeleter(mockWriter);
    public void testDeleteDocumentWithoutDeleterThrows() {
            writerPool.checkoutAll(checkedOut -> {
        deleteEngine.createDeleter(writer2);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        );
        assertFalse(deleter1.isActive());
        when(mockWriter.generation()).thenReturn(generation);
                try {
        deleteEngine.createDeleter(writer2);
     *   1. pool.getAndLock() → currentWriter (gen 2)
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 1L);
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 3L);
            assertTrue(result instanceof DeleteResult.Success);
    public void testConcurrentSameDocUpdatesWithLockablePool() throws Exception {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        assertTrue(deleteEngine.onWriterCheckedOut(1L));
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            }
        });
    }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        Deleter deleter2 = deleteEngine.createDeleter(mockWriter2);
                    }
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                startLatch.await();
        assertTrue(parentWriter.hasUncommittedChanges());
        });
            }
            luceneDataFormat,
        Writer<?> writer1 = createMockWriter(1L);
        executor.submit(() -> {
 * The OpenSearch Contributors require contributions made to
                deleteEngine.onWriterCheckedOut(2L);
        deleteEngine.createDeleter(previousWriter);
            } finally {
                    unexpectedException.set(e);
            Codec.getDefault(),
                // Expected
            null,
        // doc3 was routed to the still-active gen 2: its entry survived, so its positional delete lands there.
        // Add some buffered deletes
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    // These replicate the exact DataFormatAwareEngine pattern:
        // Index doc in gen 1
                try {
            }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
                    writerPool.releaseAndUnlock(locked);
                Thread.sleep(5);
import static org.mockito.Mockito.never;
                Thread.sleep(10); // Small delay to increase race condition chance
        // Thread that creates additional generations
                    if (!refreshing.get()) {
                    writerPool.releaseAndUnlock(locked);
import org.opensearch.test.OpenSearchTestCase;
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
        verify(mockParentWriter, times(numGenerations)).deleteDocuments(batches.capture());
        Writer<?> writer2 = createMockWriter(2L);
        when(writer2.generation()).thenReturn(2L);
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
        deleteEngine.createDeleter(writer2);
    private MergeIndexWriter mockParentWriter;
    }
                    barrier.await();
        writer2.close();
        assertTrue(t1Done.get());
        deleter1.recordBufferedDeletes("test");
     */
        deleteEngine.close();
