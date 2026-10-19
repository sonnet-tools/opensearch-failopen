                    }  
                barrier.await();  
                Thread.sleep(10); // Small delay to increase race condition chance
        startLatch.countDown();
        oldDeleter.recordBufferedDeletes("old_buffered");
    public void testMultipleSequentialUpdatesThenRefreshWithLockablePool() throws IOException {
    public void testRamBytesUsedTracksIdToGenEntries() throws IOException {
        deleteEngine.createDeleter(writer1);
        // Delete thread — uses gen 1; once gen 1 is checked out, the assert will fire  
        writer2.close();  
        CountDownLatch refreshStarted = new CountDownLatch(1);  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
                Thread.sleep(30);
            ConcurrentHashMap.newKeySet(),
        // Pre-create gen 1 so deletes can start immediately
    public void testUpdateDocumentEquivalent() throws IOException {
            }
                barrier.await();  
        when(writerWithoutLuceneDelegate.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.empty());
            new Term[] { new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")), new Term(IdFieldMapper.NAME, Uid.encodeId("doc2")) },
        LuceneDocumentInput docB = new LuceneDocumentInput();
     * both updating the same doc that was written in gen 1. Each deletes the prior copy directly  
                refreshing.set(true);
                    try {
    /**  
        deleteFuture.get(5, TimeUnit.SECONDS);
                    }  
                    }  
            Codec.getDefault(),
            baseDir,
        deleteEngine.deleteDocument(deleteInput, writer3);
                        } catch (IllegalStateException e) {
        deleteEngine.onWriterCheckedOut(1L);
        public void lock() {
        verify(gen1Lucene, never()).recordPositionalDelete(anyLong());  
        // doc3 was routed to the still-active gen 2: its entry survived, so its positional delete lands there.
        Writer<?> writerWithoutLuceneDelegate = mock(Writer.class);  
        private final Writer<?> writer;
            executor.submit(() -> {
        Writer<?> mockWriter = createMockWriter(1L);  
        deleter1.recordBufferedDeletes("doc1");
        parentDirectory.close();
                barrier.await();
            try {  
    public void testConcurrentDeleteSameDocumentId() throws Exception {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        deleteEngine.createDeleter(writer1);
                deleteEngine.onWriterCheckedOut(1L);  
        verify(prevGenWriter).recordPositionalDelete(5L);
        Writer<?> previousWriter = mock(Writer.class);
     * the previous generation's deleter lock, while refresh waits only on pool locks.
        verify(mockParentWriter, never()).deleteDocuments(any(Term[].class));
        IllegalArgumentException exception = expectThrows(
            }  
        );  
        assertTrue(deleteEngine.onWriterCheckedOut(1L));  
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
    }  
            try {  
            luceneDataFormat,
    public void testOnWriterCheckedOutRemovesIdToGenEntries() throws IOException {
            baseDir,
        Writer<?> writer2 = createMockWriter(2L);
    }
        assertNotNull(result);
                } catch (Exception e) {  
        // vararg array — Mockito 5 requires one matcher per expanded argument, so a single Term
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        when(writer2.generation()).thenReturn(2L);  
        LuceneDocumentInput docInput = new LuceneDocumentInput();  
        Writer<?> mockWriter = createMockWriter(1L);  
            executor.submit(() -> {
        LuceneWriter gen2Lucene = mock(LuceneWriter.class);  
            null,
        // Generations 1 and 2 both get trackable Lucene child writers.  
        LuceneWriter writer3 = new LuceneWriter(
                try {  
        deleter.recordBufferedDeletes("doc1");  
            } catch (Exception e) {
            ConcurrentHashMap.newKeySet(),  
        executor.submit(() -> {
import static org.mockito.Mockito.times;
        Writer<?> mockWriter = createMockWriter(1L);
                    Thread.yield();  
            baseDir,
            baseDir,  
        deleter.recordBufferedDeletes("doc1");  
        when(writer1.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(prevGenWriter));  
            null,
        deleteEngine.recordWrite("doc_b", new DocumentLocation(2L, -1L));
    public void testDeleteWithRefreshConcurrency() throws Exception {  
            try {  
        AtomicInteger deleteCount = new AtomicInteger(0);
        Writer<?> mockWriter = createMockWriter(1L);  
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 2L);  
        deleteEngine.createDeleter(writer1);  
            null,
        writer1.addDoc(docInput);  
            luceneDataFormat,
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
import java.util.concurrent.ExecutorService;
        // Refresh: checkoutAll must lock every writer (gen1 + gen2); it will block on gen2 (held above).
            luceneDataFormat,
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
        deleteEngine.createDeleter(writer2);
                        successCount.incrementAndGet();
        Writer<?> writer2 = mock(Writer.class);
        deleter.recordBufferedDeletes("doc2");
        // Refresh: checkout all and apply buffered deletes  
        Path parentDir = baseDir.resolve("parent");
            0L,  
    public void testConcurrentRecordWriteAndDelete() throws Exception {
            } catch (Exception e) {
            luceneDataFormat,  
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
    }  
    public void testBufferedDeletesWithGenerationCleanup() throws IOException {  
     */  
        deleteEngine.createDeleter(writer1);
        // A writer without a Lucene delegate cannot support deletes.
                startLatch.await();
            } catch (Exception e) {
            2L,  
    // Update: pool.getAndLock() → deleteEngine.deleteDocument(input, currentWriter) → recordWrite → pool.releaseAndUnlock()
        // Index doc in gen 1
            }
            ConcurrentHashMap.newKeySet(),  
                    deleteEngine.recordWrite("doc1", new DocumentLocation(locked.get().generation(), -1L));
                    }  
            Codec.getDefault(),
                barrier.await();  
            try {
        executor.shutdown();  
     * writer C, not the committed parent). {@code deleteDocument} must defer the positional delete to
                    }
                // Expected
public class LuceneDeleteExecutionEngineTests extends OpenSearchTestCase {
        assertArrayEquals(  
        assertTrue(closeDone.get());
        CyclicBarrier barrier = new CyclicBarrier(numThreads);  
        for (int gen = 1; gen <= numGenerations; gen++) {  
                    } catch (IOException e) {
    }
        writerPool.checkoutAll(checkedOutWriter -> {
            luceneDataFormat,  
            } finally {
                // Expected
        deleteEngine.recordWrite("doc2", new DocumentLocation(1L, 1L));
                try {
        assertTrue(deleteEngine.onWriterCheckedOut(2L));
        deleteEngine.recordWrite("a-considerably-longer-document-identifier", new DocumentLocation(1L, 2L));
        // Production prevents this race with the writer lock; the test verifies late-delete routing.
            null,
                checkoutCompleted.set(true);
        deleteEngine.createDeleter(writer2);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
                    if (result instanceof DeleteResult.Success) {
            null,
            baseDir,
                for (int i = 0; i < 10; i++) {
        Writer<?> writer2 = createMockWriter(2L);  
        Writer<?> mockWriter = createMockWriter(1L);  
        verify(mockParentWriter, never()).deleteDocuments(any(Term[].class));
                    }
        Path baseDir = createTempDir();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        deleteEngine.recordWrite("doc1", new DocumentLocation(current.get().generation(), -1L));  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
    }
        LuceneDocumentInput docInput = new LuceneDocumentInput();  
                barrier.await();
        LuceneWriter writer1 = new LuceneWriter(
            deleteEngine.recordWrite("doc1", new DocumentLocation(lockedWriter.get().generation(), -1L));  
        LuceneWriter writer2 = new LuceneWriter(
        writer3.close();  
        assertTrue(hasDeletes1);
        assertNotNull(result);  
        // Buffered delete applied to parentWriter  
            null,
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
        }
        assertTrue("tracking an id must account for it", afterFirstId > 0L);
                }  
        Writer<?> writer1 = mock(Writer.class);  
                    Thread.yield();  
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2, writer3);  
            null,  
        Writer<?> mockWriter = createMockWriter(1L);
        // Update 1: gen 2 updates doc1 (prior copy in gen 1 deleted directly via gen 1's deleter)
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
     *
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 2L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
            Codec.getDefault(),  
            }
        parentDirectory.close();  
                barrier.await();  
                    for (int i = 0; i < numDeletes; i++) {
            new LuceneShardStatsTracker()
                    Writer<?> mockWriter = createMockWriter(generation);
        assertEquals(3L, deleter3.generation());  
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                try {
            luceneDataFormat,
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicBoolean t1Done = new AtomicBoolean(false);  
import java.util.LinkedList;  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            Codec.getDefault(),
            }  
                }
        LuceneDocumentInput docInput = new LuceneDocumentInput();  
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
            null,
        executor.shutdown();
                    // Expected  
    public void testDeleteDocumentInOldChildWriterEquivalent() throws Exception {
            DeleteInput d1 = new DeleteInput(IdFieldMapper.NAME, "doc1", locked2.get().generation());
    }
                        try {
    }
        int numThreads = 10;  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        Deleter deleter2 = deleteEngine.createDeleter(writer2);
import java.util.concurrent.atomic.AtomicReference;
                startLatch.await();
        assertFalse(deleter2.isActive());
import org.opensearch.common.queue.Lockable;  
import java.util.concurrent.CyclicBarrier;  
        executor.shutdown();  
import org.apache.lucene.index.MergeIndexWriter;  
        // Delete thread — lookupGen uses Term(_id, Uid.encodeId("doc"+i)).bytes() which matches above
        Writer<?> writer1 = createMockWriter(1L);
        deleteEngine.deleteDocument(new DeleteInput(IdFieldMapper.NAME, "doc1", 3L), writer3);
        Writer<?> writer2 = createMockWriter(2L);
            Codec.getDefault(),
                    if (deleter != null && deleter.generation() == generation) {
            }
                // Unexpected  
        assertEquals("nothing tracked yet", 0L, deleteEngine.ramBytesUsed());
    public void testRapidGenerationCreationAndCheckout() throws Exception {
        deleteEngine.createDeleter(writer1);
            return new WriterHolder(w);  
        LuceneDocumentInput docInput = new LuceneDocumentInput();  
        Writer<?> writer3 = createMockWriter(3L);
            }
    }  
        deleteEngine.recordWrite("doc2", new DocumentLocation(1L, 1L));
            Codec.getDefault(),  
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
import static org.mockito.Mockito.never;  
        startLatch.countDown();  
        Writer<?> get() {
            writerPool.releaseAndUnlock(lockedWriter);
    public void testConcurrentGenerationRotation() throws Exception {  
    public void testDeleteDocumentNoRecordedWriteReturnsSuccess() throws IOException {  
        deleteEngine.createDeleter(writer2);  
        Path baseDir = createTempDir();  
        executor.submit(() -> {  
import org.opensearch.index.engine.dataformat.Deleter;
        parentDirectory.close();
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2, writer3);  
        public void unlock() {
        assertNull(exception.get());
        // Thread 3 (refresh): checkoutAll after short delay
        // "doc2" was buffered directly, "doc1" was buffered by deleteDocument → both drain in ONE
        });  
                    if (result instanceof DeleteResult.Success) {
            writerPool.checkoutAll(checkedOut -> {
                // Expected  
    private LockablePool<WriterHolder> buildWriterPool(LuceneDeleteExecutionEngine deleteEngine, LuceneWriter... writers) {
        deleteEngine.createDeleter(writer3);
            try {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            assertTrue(r1 instanceof DeleteResult.Success);
                    try {
                    DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);  
            boolean hasDeletes = deleteEngine.onWriterCheckedOut(gen);
        ExecutorService executor = Executors.newFixedThreadPool(2);
                            recordedDeletes.add(id);  
        when(writer2.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen2Lucene));
        Writer<?> writer3 = createMockWriter(3L);
        executor.submit(() -> {
        for (int i = 0; i < numThreads; i++) {  
                }
                try {  
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
        });
                barrier.await();  
        assertTrue(result instanceof DeleteResult.Success);  
    }
        assertTrue(result instanceof DeleteResult.Success);  
            try {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, docId, 1L);
            DeleteInput d2 = new DeleteInput(IdFieldMapper.NAME, "doc1", locked3.get().generation());
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "new_doc", 2L);
        assertTrue(deleteCompleted.get());
            }
        executor.shutdown();
        deleter.recordBufferedDeletes("doc1");
                    throw new RuntimeException(e);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            } catch (Exception e) {  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        when(prevGenWriter.generation()).thenReturn(1L);  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        WriterHolder locked2 = writerPool.getAndLock(h -> h.get().generation() == 2L);  
        executor.submit(() -> {
        executor.shutdown();
        assertNotNull(deleter);  
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));  
            DeleteResult r1 = deleteEngine.deleteDocument(d1, locked2.get());  
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));
        Writer<?> mockWriter = createMockWriter(1L);  
                    deleteEngine.recordWrite("doc" + i, new DocumentLocation(1L, -1L));  
        LuceneWriter prevGenWriter = mock(LuceneWriter.class);
                exception.set(e);  
                completeLatch.countDown();
        ExecutorService executor = Executors.newFixedThreadPool(4);  
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 0L));  
                // Expected if deleter becomes inactive or was already removed
        });  
        );  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
            assertTrue(hasDeletes);
    // ===== Integration tests using LockablePool + LuceneWriter (matching DataFormatAwareEngine) =====
        Writer<?> writer2 = mock(Writer.class);
            }  
            } catch (Exception e) {
            }
    // These replicate the exact DataFormatAwareEngine pattern:
                    unexpectedException.set(e);
    public void testBufferedDeletesNotLostOnConcurrentDeactivation() throws Exception {
        // parentWriter should have uncommitted changes from applied buffered deletes  
            1L,
        Writer<?> mockWriter2 = createMockWriter(2L);
                    writerPool.releaseAndUnlock(locked);
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));  
        deleteEngine.recordWrite("doc_a", new DocumentLocation(1L, -1L));  
        // New child-side routing: a positional (liveDocs-only) delete is deferred to gen 1's writer  
        deleteEngine.createDeleter(mockWriter);
        assertFalse(deleter.isActive());  
                closeDone.set(true);  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
                    }
            ConcurrentHashMap.newKeySet(),
        mockDataFormat = mock(DataFormat.class);
        assertTrue(deleter2.isActive());
            try {  
    }
        Writer<?> writer3 = createMockWriter(3L);
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
            return lock.tryLock();
            deleteEngine.recordWrite("doc1", new DocumentLocation(locked3.get().generation(), -1L));
        executor.shutdown();  
        assertTrue(t2Done.get());
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc1", locked.get().generation());  
        LuceneWriter prevLuceneWriter = mock(LuceneWriter.class);
        boolean hasDeletes = deleteEngine.onWriterCheckedOut(1L);
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
        // Current generation C=2 (the update lands here) — also trackable, so we can prove it is NOT the  
                Thread.sleep(20);
                        successCount.incrementAndGet();
        assertNotNull(result);
        Deleter deleter1 = deleteEngine.createDeleter(writer1);  
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);  
            } catch (Exception e) {
    }
            baseDir,
                    try {  
        });
    }  
                        break;
        Writer<?> mockWriter1 = createMockWriter(1L);
        deleteEngine.createDeleter(mockWriter);
        CountDownLatch startLatch = new CountDownLatch(1);  
        assertTrue(successfulDeletes.get() > 0);  
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 2L);
        assertEquals("entry cost must not depend on id length", 3 * afterFirstId, deleteEngine.ramBytesUsed());  
            LuceneWriter w = iter.next();
                for (int i = 0; i < 5; i++) {
                Thread.sleep(15);
import static org.mockito.Mockito.verify;
                } finally {  
        assertEquals(0L, deleteEngine.ramBytesUsed());
package org.opensearch.be.lucene.index;
        // Thread 1: update doc_a from gen 3 (previous gen = 1)
        assertNotNull(result);
                    } catch (AssertionError e) {
                    writerPool.releaseAndUnlock(locked);  
            });  
            } catch (Exception e) {  
                });
        public boolean tryLock() {  
        int numThreads = 5;  
        // Thread A (indexer): updateDocs
            new LuceneShardStatsTracker()  
        private final ReentrantLock lock = new ReentrantLock();
        );
     *   2. deleteEngine.deleteDocument(DeleteInput(id, currentWriter.gen()), currentWriter)  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
            Set.of(new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")), new Term(IdFieldMapper.NAME, Uid.encodeId("doc2"))),
                    barrier.await();
    public void testDeleteDocumentWithCurrentGeneration() throws IOException {  
        ExecutorService executor = Executors.newFixedThreadPool(2);  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        deleteEngine.createDeleter(mockWriter);  
     * from gen 1 via that generation's deleter (its read lock permits concurrent deleteDoc), with
        deleteEngine.createDeleter(currentWriter);  
    // ===== Basic functionality tests =====
                for (int i = 0; i < 100; i++) {
        assertTrue(deleter2.isActive());
            try {
    public void testConcurrentIndexAndDeleteDuringRefreshEquivalent() throws Exception {
            } catch (Exception e) {
import org.opensearch.index.engine.dataformat.DataFormat;
            new LuceneShardStatsTracker()
        AtomicInteger successCount = new AtomicInteger(0);
            deleteEngine.recordWrite("doc1", new DocumentLocation(locked2.get().generation(), -1L));
        deleteEngine.onWriterCheckedOut(1L);
    }  
        assertFalse(deleter.isActive());
    /**
     * Concurrent: two indexer threads each hold their own current writer (gen 2, gen 3),
        );
import org.opensearch.test.OpenSearchTestCase;
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
                }
        verify(mockParentWriter, never()).deleteDocuments(any(Term[].class));
        );
     * Multiple sequential updates then refresh. Verifies all buffered deletes from
            null,
        @Override  
    }
            refreshStarted.countDown();  
        assertTrue(t1Done.get());
    public void testConcurrentCloseAndOnWriterCheckedOut() throws Exception {
            } catch (Exception | AssertionError e) {  
        assertFalse(deleter.isActive());
            Codec.getDefault(),  
        assertTrue(successCount.get() > 0);  
        // Parquet-only (no Lucene sub-writer): createDeleter skips and returns null rather than throwing.
    public void testUpdateCase2DeletesFromDifferentActiveWriter() throws IOException {
                        deleter.recordBufferedDeletes("doc_gen_" + gen);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                t2Done.set(true);
        Writer<?> mockWriter = createMockWriter(1L);
                deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());  
        });
        assertTrue(exception.getMessage().contains("not supported"));  
import org.opensearch.index.engine.dataformat.DeleteResult;
                }
                    if (!refreshing.get()) {
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                }
        assertNotNull(result);
        AtomicInteger successCount = new AtomicInteger(0);
        executor.submit(() -> {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer1);
            executor.submit(() -> {
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        deleteEngine.close();  
            ConcurrentHashMap.newKeySet(),
    public void testRamBytesUsedResetOnClose() throws IOException {
        executor.submit(() -> {
            } catch (Exception e) {  
        // Let the refresh thread reach checkoutAll and block on the current writer we hold.
            null,
        when(previousWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(prevLuceneWriter));
        );
                        successCount.incrementAndGet();
        // Thread 1: holds gen 2, deletes doc1 from gen 1 directly via gen 1's deleter  
            ConcurrentHashMap.newKeySet(),  
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        assertFalse(deleter.isActive());  
        Deleter deleter2 = deleteEngine.createDeleter(writer2);
                }
    /**
                        throw new RuntimeException(e);
        CyclicBarrier barrier = new CyclicBarrier(3);
        });
                barrier.await();
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
    public void testUpdateHoldingCurrentWriterDoesNotDeadlockAgainstRefresh() throws Exception {  
        deleteEngine.onWriterCheckedOut(1L);
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();  
            2L,  
    }
    public void testRecordWrite() throws IOException {  
        for (int t = 0; t < 4; t++) {  
        deleteEngine.createDeleter(previousWriter);  
        assertTrue(completeLatch.await(5, TimeUnit.SECONDS));
            try {
                    deleteEngine.deleteDocument(di, locked.get());
    }
        Writer<?> writer1 = createMockWriter(1L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    }  
            0L,
            0L,  
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "concurrent" + i, 1L);
        executor.shutdown();
        AtomicBoolean done = new AtomicBoolean(false);  
            try {  
        ExecutorService executor = Executors.newFixedThreadPool(2);  
        deleter.recordBufferedDeletes("doc1");
            luceneDataFormat,
            try {
                    }
        assertTrue(executor.awaitTermination(15, TimeUnit.SECONDS));
            } catch (Exception e) {
    public void testUpdateFlowWithLockablePool() throws IOException {
            null,  
                    DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();  
                } catch (IOException e) {
        AtomicReference<Exception> exception = new AtomicReference<>();  
        parentWriter.close();
        Writer<?> writer2 = createMockWriter(2L);
        // Previous, still-active generation P=1 holds the prior copy of doc1 (trackable child writer).
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    }
        }  
            0L,
                deleteCompleted.set(true);
        assertTrue(parentWriter.hasUncommittedChanges());
        assertTrue(completeLatch.await(10, TimeUnit.SECONDS));
            luceneDataFormat,  
        executor.submit(() -> {
        }
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 0L));  
import org.opensearch.index.engine.dataformat.DeleteInput;  
import static org.mockito.ArgumentMatchers.anyLong;
        deleter1.recordBufferedDeletes("buffered1");
                }  
                try {  
    }
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));  
     *   1. pool.getAndLock() → currentWriter (gen 2)
        verify(prevLuceneWriter).recordPositionalDelete(7L);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
                }
        CountDownLatch completeLatch = new CountDownLatch(numThreads);  
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
    public void testRefreshFlowWithLockablePool() throws IOException {
            luceneDataFormat,
                    Thread.yield();  
        deleteEngine.deleteDocument(deleteInput, writer1);
                        // Expected after gen 1 is checked out  
        });
    private LuceneDeleteExecutionEngine createDeleteEngine() {  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, currentWriter);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        executor.shutdown();
    }
        checkoutFuture.get(5, TimeUnit.SECONDS);  
                Thread.sleep(5);
        // Supersede doc1's prior copy in the DIFFERENT active generation (gen1). Current design deletes
        boolean hasDeletes2 = deleteEngine.onWriterCheckedOut(2L);  
                deleter.recordBufferedDeletes("gen" + gen + "_doc" + doc);
        deleteEngine.createDeleter(writer1);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        LockablePool<WriterHolder> pool = new LockablePool<>(() -> {  
        }
            ConcurrentHashMap.newKeySet(),  
import java.util.concurrent.ConcurrentHashMap;
            ConcurrentHashMap.newKeySet(),
        deleteEngine.createDeleter(writer3);
            } catch (Exception e) {
import org.apache.lucene.codecs.Codec;
        // Delete may or may not complete depending on timing
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 3L);  
        LuceneWriter writer2 = new LuceneWriter(
        WriterHolder lockedWriter = writerPool.getAndLock(h -> h.get().generation() == 2L);  
        CyclicBarrier barrier = new CyclicBarrier(2);
        Directory parentDirectory = new MMapDirectory(parentDir);
            3L,
            }
                    Thread.sleep(10);
        CountDownLatch startLatch = new CountDownLatch(1);
        Path baseDir = createTempDir();
                startLatch.await();
            } catch (Exception e) {
                deleteEngine.onWriterCheckedOut(1L);  
        startLatch.countDown();
        deleter.recordBufferedDeletes("doc2");  
                deleteEngine.onWriterCheckedOut(1L);
        Writer<?> writer2 = createMockWriter(2L);  
            0L,
        // Writer thread — uses Uid.encodeId so the key matches what deleteDocument looks up
            null,
            Writer<?> writer = createMockWriter(gen);
            new LuceneShardStatsTracker()
                deleteEngine.onWriterCheckedOut(1L);
     */  
            } catch (Exception e) {
        parentWriter.close();
    }  
        writer1.close();
        startLatch.countDown();
        Writer<?> writer1 = mock(Writer.class);
        try {  
        // One batched call per generation; every buffered id still reaches the parent writer.
    public void testDeleteDocumentInParentWriterEquivalent() throws IOException {  
                    }
            Codec.getDefault(),
        deleter.recordBufferedDeletes("doc2");
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
                }
        assertFalse(deleter.isActive());
        );  
                Thread.sleep(20); // Let Thread A acquire the current writer (gen2) and start its update first  
        }
 * compatible open source license.
            null,  
    public void testHighVolumeDeletesAcrossMultipleGenerations() throws Exception {
    }  
     * Verifies buffered deletes are applied to parentWriter and pool items are removed.  
import org.apache.lucene.index.IndexWriterConfig;
        );
        Deleter newDeleter = deleteEngine.createDeleter(newWriter);
    }  
        assertTrue(deleter1.isActive());
        CountDownLatch startLatch = new CountDownLatch(1);
                    }
                    if (r instanceof DeleteResult.Success) {
            1L,
    public void testConcurrentMultipleUpdatesAndRefreshWithLockablePool() throws Exception {
            try {  
        writer3.close();
            null,
        deleteEngine.recordWrite("shared_doc", new DocumentLocation(1L, -1L));
        deleteEngine.createDeleter(mockWriter);
                        String id = "t" + threadId + "_doc" + i;  
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
        assertEquals(numThreads, successCount.get());
                    startLatch.await();
        writer2.close();  
        assertTrue(result);
        writer1.addDoc(docInput);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
    }  
                // Unexpected
        }
                        }
            executor.submit(() -> {
    /** Verifies that concurrent update and refresh complete without taking opposing pool locks. */  
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
                        throw new RuntimeException(e);
            baseDir,  
        executor.shutdown();  
     * while refresh runs. Each indexer holds a different current writer, so their updates proceed
        Writer<?> writer2 = createMockWriter(2L);
                deleteEngine.recordWrite("gen" + gen + "_doc" + doc, new DocumentLocation(gen, -1L));
            null,
import static org.mockito.ArgumentMatchers.any;  
        try {
        writer1.close();
                }
    }
                // Expected when deleter becomes inactive  
                }
        deleteEngine.createDeleter(writer2);  
        ExecutorService executor = Executors.newFixedThreadPool(2);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);  
        deleter1.recordBufferedDeletes("test");  
        assertNotNull(result);
                        deleter.recordBufferedDeletes("doc" + i);
                Thread.sleep(5);
        when(writer1.generation()).thenReturn(1L);  
                    deleteEngine.deleteDocument(di, locked.get());
        parentWriter.close();
    public void testConcurrentDeleterCreation() throws Exception {
        deleter1.recordBufferedDeletes("gen1_doc1");
                }  
        AtomicBoolean refreshing = new AtomicBoolean(false);
            }
import java.util.Set;  
        Path baseDir = createTempDir();
        assertFalse(deleter1.isActive());  
        Writer<?> mockWriter = createMockWriter(1L);
        String docId = "shared_doc";
                refreshDone.set(true);
        writer2.close();
                // Unexpected
        assertTrue(result instanceof DeleteResult.Success);
            () -> deleteEngine.deleteDocument(deleteInput, writerWithoutLuceneDelegate)
        Thread.sleep(20);  
        Writer<?> writer1 = createMockWriter(1L);
        assertNotNull(result);
            try {  
        WriterHolder locked3 = writerPool.getAndLock(h -> h.get().generation() == 3L);
        when(writer1.generation()).thenReturn(1L);
        // Setup previous generation with a trackable LuceneWriter (holds the prior version of doc1).
        assertNull(unexpectedException.get());
        }  
        Writer<?> mockWriter = mock(Writer.class);
        });
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "test", 1L);  
    }  
            final String docId = "doc" + i;
        writer1.addDoc(docInput);
            });
        Set<String> recordedDeletes = ConcurrentHashMap.newKeySet();
        );
        barrier.await();
                deleteEngine.onWriterCheckedOut(1L);  
        when(previousWriter.generation()).thenReturn(1L);
        Writer<?> currentWriter = createMockWriter(2L);
        executor.shutdown();
                        long gen = generation.incrementAndGet();
    // ===== Stress tests =====
        CountDownLatch startLatch = new CountDownLatch(1);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer3);
        assertEquals(1L, deleter1.generation());
            } catch (Exception e) {  
        Deleter deleter1 = deleteEngine.createDeleter(writer1);  
                // Unexpected
        // target of a direct child delete; it only records a buffered delete drained at its own checkout.
    }
        // Thread 2: holds gen 3, also deletes doc1 from gen 1 directly via gen 1's deleter
    private DataFormat mockDataFormat;  
            Deleter deleter = deleteEngine.createDeleter(writer);
    }
        assertTrue(result instanceof DeleteResult.Success);  
                    } catch (Exception e) {
        deleteEngine.onWriterCheckedOut(1L);
        writer1.close();
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "new_doc", 2L);
    public void testDeleteDocumentWithPreviousGeneration() throws IOException {
        });
        LuceneWriter writer1 = new LuceneWriter(
    public void testConcurrentWriterCheckoutAndDelete() throws Exception {  
        });
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        AtomicInteger successCount = new AtomicInteger(0);
        Writer<?> oldWriter = createMockWriter(1L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
    }
        executor.submit(() -> {
                // Expected  
        assertNotNull(result);
        LuceneWriter writer1 = new LuceneWriter(  
                        Thread.yield();  
        verify(mockParentWriter, times(numGenerations)).deleteDocuments(batches.capture());
        LuceneWriter gen2Lucene = mock(LuceneWriter.class);
        assertNull(deleteEngine.refresh(null));
    /** A retired generation with a Lucene delegate applies a late delete to the parent writer. */  
        Writer<?> mockWriter = mock(Writer.class);
        AtomicInteger successfulDeletes = new AtomicInteger(0);
     * Concurrent: multiple indexers updating different docs (prior copies in different gens)  
        assertNull(exception.get());  
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
        Writer<?> writer1 = createMockWriter(1L);  
            }  
                deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());  
        });
            }
            3L,
import java.util.concurrent.locks.ReentrantLock;
        deleter2.recordBufferedDeletes("gen2_doc1");
        mockCommitter = mock(LuceneCommitter.class);
            try {
    public void testConcurrentDeleteAndRefreshWithLockablePool() throws Exception {
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1);  
            }  
        ExecutorService executor = Executors.newFixedThreadPool(2);  
import org.opensearch.common.queue.LockablePool;
            try {
            baseDir,
    }
        // Index doc1 in gen 1
        // Thread that creates additional generations
        CyclicBarrier barrier = new CyclicBarrier(2);  
        assertEquals(1L, deleter.generation());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        // At least some deletes should have succeeded before checkout
            ConcurrentHashMap.newKeySet(),
        Path parentDir = baseDir.resolve("parent");  
        assertTrue(deleter1.isActive());
    public void testRecordWriteOverwritesPreviousGeneration() throws IOException {  
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc_a", locked.get().generation());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        assertNotNull(result);  
        LuceneWriter writer1 = new LuceneWriter(  
        // Initial write in gen 1
            terms.getValue()
     * Full refresh flow exactly as DataFormatAwareEngine.refresh does it:  
        startLatch.countDown();  
                } catch (IOException e) {
        verify(mockParentWriter, times(2)).deleteDocuments(batches.capture());
        executor.shutdown();  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        java.util.Iterator<LuceneWriter> iter = java.util.Arrays.asList(writers).iterator();
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        assertFalse(deleter.isActive());
        );
    }
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();  
        assertTrue(result instanceof DeleteResult.Success);
        // Record the prior version of doc1 in generation 1 at insertion rowId 7.  
            Codec.getDefault(),
        );
            });
        }  
    private LuceneCommitter mockCommitter;
    }  
                startLatch.await();  
        Deleter deleter1 = deleteEngine.createDeleter(writer1);
        deleteEngine.recordWrite("doc1", new DocumentLocation(2L, 9L));
        ExecutorService executor = Executors.newFixedThreadPool(3);  
    public void testCloseIsIdempotent() throws IOException {
            0L,
        // Record some buffered deletes
        assertTrue(result instanceof DeleteResult.Success);
    }
        int numDeletes = 100;
        // Re-recording a tracked id overwrites the value in place: no new entry, no growth.
        } finally {
            final long generation = i;
        Writer<?> writer1 = createMockWriter(1L);
        assertEquals(List.of(2, 1), batches.getAllValues().stream().map(b -> b.length).toList());
        boolean result = deleteEngine.onWriterCheckedOut(999L);
            0L,  
                startLatch.await();
            new LuceneShardStatsTracker()  
            }
        // via gen1's OWN deleter lock — no second writer-holder lock — so this cannot deadlock against  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
                // Expected  
                        successCount.incrementAndGet();
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);  
                    for (int i = 0; i < 20; i++) {
    }
     * Full update flow exactly as DataFormatAwareEngine.updateDocs does it:
            baseDir,
                t1Done.set(true);
        int numThreads = 10;
                startLatch.await();
        });  
                }
        assertTrue(deleter.isActive());
            null,  
    }  
        when(gen2Lucene.generation()).thenReturn(2L);
        Writer<?> writer2 = mock(Writer.class);  
/*  
                    try {
                        deleteEngine.onWriterCheckedOut(i);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            executor.submit(() -> {
            } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.Future;  
        refresh.get(30, TimeUnit.SECONDS);  
        assertEquals("overwriting an id must not grow the footprint", 3 * afterFirstId, deleteEngine.ramBytesUsed());
            2L,  
                } catch (Exception e) {
        });
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 3L);
            for (int doc = 0; doc < docsPerGeneration; doc++) {  
        assertNotNull(result);  
        Writer<?> mockWriter = createMockWriter(1L);  
        // doc1's prior copy lives in the DIFFERENT, still-active generation 1, at insertion rowId 5.  
        assertTrue(refreshDone.get());  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            } catch (IOException e) {
            try {
    private MergeIndexWriter mockParentWriter;
                        break;
    // ===== Multi-threading tests =====
            null,
        assertTrue(hasDeletes);
        executor.shutdown();
            try {  
        // per segment instead of freezing an update packet per delete. The captor is typed to the
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
}  
            WriterHolder h = pool.getAndLock();  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);  
        int numGenerations = 5;  
    // ===== Helper methods =====
    // Pool: new LockablePool<>(() -> { Writer w = new LuceneWriter(...); deleteEngine.createDeleter(w); return WriterHolder(w); })  
     */  
                    Writer<?> writer = createMockWriter(i);  
        } finally {
        writer1.addDoc(docInput);
        LuceneWriter gen1Lucene = mock(LuceneWriter.class);  
        assertTrue(result instanceof DeleteResult.Success);
        }  
            } catch (Exception e) {  
        executor.submit(() -> {
        writer2.close();  
        Deleter oldDeleter = deleteEngine.createDeleter(oldWriter);
        parentWriter.close();
        executor.shutdown();
    public void testDeleteDocumentInBothChildAndParentWriterEquivalent() throws IOException {
    /**  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        });
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 0L));  
        writer2.addDoc(docB);
        verify(currentGenWriter, never()).recordPositionalDelete(anyLong());  
     * no pool lock on gen 1. Both succeed.
        Writer<?> mockWriter = createMockWriter(1L);
     */
        assertNotNull(result);
        LuceneWriter mockLuceneWriter = mock(LuceneWriter.class);  
    }
        CountDownLatch completeLatch = new CountDownLatch(numThreads);  
                try {  
        for (int t = 0; t < 3; t++) {  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        AtomicBoolean refreshCompleted = new AtomicBoolean(false);  
    public void testCloseWithPendingBufferedDeletes() throws IOException {
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());  
        Deleter deleter3 = deleteEngine.createDeleter(writer3);
                            successfulDeletes.incrementAndGet();  
                }
        Future<?> deleteFuture = executor.submit(() -> {
            Codec.getDefault(),
        deleteEngine.createDeleter(writer1);
                deleteEngine.onWriterCheckedOut(1L);
    }
                // Expected
        startLatch.countDown();  
        return mockWriter;  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        LuceneWriter prevLuceneWriter = mock(LuceneWriter.class);
                Thread.sleep(5);
        Path parentDir = baseDir.resolve("parent");
                for (int i = 0; i < numDocs && !done.get(); i++) {
        ArgumentCaptor<Term[]> batches = ArgumentCaptor.forClass(Term[].class);  
        writerPool.checkoutAll(checkedOutWriter -> {
            ConcurrentHashMap.newKeySet(),  
        Writer<?> writer3 = createMockWriter(3L);
        LuceneWriter writer1 = new LuceneWriter(  
            try {  
        assertTrue(result instanceof DeleteResult.Success);
            } catch (Exception e) {
        deleter2.recordBufferedDeletes("buffered2");  
        Writer<?> writer2 = createMockWriter(2L);  
            DeleteResult r2 = deleteEngine.deleteDocument(d2, locked3.get());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    }  
    private LuceneDeleteExecutionEngine createDeleteEngineWithParentWriter(MergeIndexWriter parentWriter) {
        return new LuceneDeleteExecutionEngine(new LuceneDataFormat(), committer);
        assertTrue(refreshCompleted.get());  
            }
    public void testCreateDeleter() throws IOException {  
        // === refresh flow ===  
                    completeLatch.countDown();
            lock.unlock();  
        deleteEngine.recordWrite("test", new DocumentLocation(2L, -1L));
                        if (result instanceof DeleteResult.Success) {
                for (int i = 0; i < 10; i++) {
        Deleter deleter = deleteEngine.createDeleter(mockWriter);  
            try {
                        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc" + i, 1L);  
                deleteEngine.close();
    public void testDeleteWithOldAndCurrentGenerations() throws IOException {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);  
        AtomicBoolean deleteCompleted = new AtomicBoolean(false);
    }
        writer1.close();
import org.apache.lucene.store.MMapDirectory;  
                for (int i = 0; i < 100; i++) {  
                }
        deleteEngine.recordWrite(docId, new DocumentLocation(1L, -1L));
    public void testConcurrentSameDocUpdatesWithLockablePool() throws Exception {
                } finally {
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 1L));
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        @Override
                // Expected  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        writer1.close();
        deleter.recordBufferedDeletes("doc1");  
            }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
            null,
import java.util.concurrent.TimeUnit;
        Writer<?> writer1 = createMockWriter(1L);  
                    barrier.await();  
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
    // ===== Test cases inspired by CompositeIndexWriter patterns =====
        Writer<?> mockWriter = createMockWriter(1L);
        CountDownLatch startLatch = new CountDownLatch(1);  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        Writer<?> mockWriter = createMockWriter(1L);  
import java.util.concurrent.CountDownLatch;
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
import java.util.concurrent.atomic.AtomicBoolean;
                // Expected  
        deleter1.recordBufferedDeletes("gen1_doc2");  
        // === updateDocs flow ===
     *   3. deleteEngine.recordWrite(uid, currentWriter.gen())
        deleteEngine.createDeleter(mockWriter);
        assertFalse(deleter.isActive());  
        executor.submit(() -> {
        assertEquals("footprint is a fixed cost per tracked entry", 2 * afterFirstId, deleteEngine.ramBytesUsed());
    // Refresh: pool.checkoutAll(w -> deleteEngine.onWriterCheckedOut(w.get().generation()))
        java.nio.file.Files.createDirectories(parentDir);
    }
        java.nio.file.Files.createDirectories(parentDir);  
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 3L);
            try {  
        assertFalse(deleter2.isActive());
        Directory parentDirectory = new MMapDirectory(parentDir);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        executor.submit(() -> {  
            } catch (Exception e) {
        deleteEngine.createDeleter(writer1);
        assertTrue(deleteEngine.onWriterCheckedOut(1L));
        // Checkout thread
        LuceneWriter writer2 = new LuceneWriter(
            new LuceneShardStatsTracker()  
        ArgumentCaptor<Term[]> terms = ArgumentCaptor.forClass(Term[].class);
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
        for (int i = 0; i < numThreads; i++) {  
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
                deleteEngine.deleteDocument(deleteInput, mockWriter);
                    // Some may fail if deleter becomes inactive
        parentWriter.close();  
        });  
    }
            writerPool.releaseAndUnlock(locked3);  
                    indexed.incrementAndGet();  
        // Generation 1 (will be checked out) and generation 2 (stays active), both with trackable child writers.
    }  
                } catch (Exception e) {
    public void testDeleteDocumentAfterGenerationRetiredGoesToParentWriter() throws IOException {
        AtomicInteger successCount = new AtomicInteger(0);
    public void setUp() throws Exception {  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();
                writerPool.checkoutAll(checkedOutWriter -> {  
                // Expected  
            Codec.getDefault(),
            baseDir,
        assertEquals("retiring the generation must release its entries", 0L, deleteEngine.ramBytesUsed());
        Future<?> deleterFuture = executor.submit(() -> {  
                        }  
        deleteEngine.onWriterCheckedOut(1L);
    }
        deleteEngine.createDeleter(writer2);  
                    }
        assertArrayEquals(new Term[] { new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")) }, terms.getValue());  
    }
        CyclicBarrier barrier = new CyclicBarrier(3);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
import java.nio.file.Path;
        when(mockLuceneWriter.generation()).thenReturn(generation);
            baseDir,
                for (int i = 0; i < 200; i++) {
        assertTrue(deleteCount.get() > 0);
        Path baseDir = createTempDir();
            deleteEngine.createDeleter(w);
        Path parentDir = baseDir.resolve("parent");  
        AtomicReference<Exception> exception = new AtomicReference<>();
                startLatch.await();  
            1L,
            null,
        // Checkout thread
    public void testDeleteDocumentInChildWriterEquivalent() throws IOException {
import org.apache.lucene.index.Term;
        deleteEngine.recordWrite("old_doc", new DocumentLocation(1L, -1L));
    public void testDeleteDocumentWithoutDeleterThrows() {  
        assertEquals(2L, deleter2.generation());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
import org.opensearch.index.mapper.Uid;  
        LuceneDocumentInput docInput = new LuceneDocumentInput();  
        assertTrue(hasDeletes2);
                done.set(true);
            try {
        executor.shutdown();
                    completeLatch.countDown();
            0L,
        assertNotNull(result);
        // positional delete to its writer.  
import java.util.concurrent.atomic.AtomicInteger;  
        CyclicBarrier barrier = new CyclicBarrier(2);
                // Expected  
            Set.of(terms.getValue())
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
                startLatch.await();  
                        // Generation may not exist yet
    }  
        when(previousWriter.generation()).thenReturn(1L);
        CyclicBarrier barrier = new CyclicBarrier(4);
    }
        deleter.recordBufferedDeletes("doc1");  
        java.nio.file.Files.createDirectories(parentDir);
import org.opensearch.index.mapper.IdFieldMapper;
        Closeable lock = writerPool.evaluateAllAndLock(h -> h.get().generation() == 1L);
        assertFalse(deleter1.isActive());  
        CountDownLatch startLatch = new CountDownLatch(1);
    }
    }  
        AtomicReference<Exception> unexpectedException = new AtomicReference<>();
        when(gen2Lucene.generation()).thenReturn(2L);
        // Recording doc1 twice: the later write (gen 2, rowId 9) must win.  
            }
                deleteEngine.onWriterCheckedOut(2L);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
                barrier.await();
            } catch (Exception e) {
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2);  
            }  
        Writer<?> writer2 = createMockWriter(2L);
        writer1.addDoc(docInput);
    // Updates hold only the current writer's pool lock; previous copies use their deleter lock.
                        successCount.incrementAndGet();
        );
                } finally {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);  
                deleteCompleted.set(true);
                exception.set(e);
        );
            try {  
    // ===== Integration tests covering interaction between LuceneDeleteExecutionEngine and DeleterImpl =====  
        deleteEngine.createDeleter(previousWriter);
                    } catch (IOException e) {  
                    Thread.yield();
                // Unexpected  
        deleter.recordBufferedDeletes("doc1");
        assertNull(lock);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            0L,
        assertNotNull(result);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    deleteEngine.recordWrite("doc_a", new DocumentLocation(locked.get().generation(), -1L));  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
            new LuceneShardStatsTracker()
        Deleter deleter2 = deleteEngine.createDeleter(mockWriter2);
            null,
        docInput.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
    }  
        Writer<?> newWriter = createMockWriter(2L);
                exception.set(e);
        Future<?> writerFuture = executor.submit(() -> {
        Writer<?> writer2 = createMockWriter(2L);
        docA.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);
                DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc3", 1L);  
    }  
        AtomicBoolean t2Done = new AtomicBoolean(false);
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 2L);  
        } finally {  
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2);  
    public void testOnWriterCheckedOutWithNoDeleter() throws IOException {
                throw new RuntimeException(e);
import java.io.Closeable;  
        });
            }  
        ExecutorService executor = Executors.newFixedThreadPool(2);
        assertTrue(result instanceof DeleteResult.Success);
        // Update doc1 from the current generation 2.  
            null,  
        assertFalse(deleter.isActive());
        // recordWrite routes doc1 to generation 1 at insertion rowId 3.
            0L,  
            Codec.getDefault(),
        assertEquals(  
        deleteEngine.close();  
        });  
            IllegalArgumentException.class,  
        writer2.close();  
            Codec.getDefault(),
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc_b", locked.get().generation());
    public void testCompleteDeleteWorkflow() throws IOException {
        // Retiring the generation releases everything it tracked.  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        // Prior copy of doc1 lives in generation 1 (the DIFFERENT active generation).
        }
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
    }  
        // Case 2: the prior copy's positional delete is deferred to the different active generation (P=1)...  
        deleter.recordBufferedDeletes("doc1");
        executor.shutdown();
        when(writer2.generation()).thenReturn(2L);
        // Checking out generation 1 drops its idToGen entries (doc1, doc2) but leaves doc3 -> gen 2 intact.
        assertFalse(deleter1.isActive());
            } catch (Exception e) {
                try {  
        // Thread 2: update doc_b from gen 3 (previous gen = 2)
        // the refresh block-locking gen2. Then release gen2 so checkoutAll can finish.
import java.util.concurrent.Executors;
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
            null,
        when(prevLuceneWriter.generation()).thenReturn(1L);  
                for (int i = 2; i <= 5; i++) {
        });
        // batched call at checkout, so assert the call's contents rather than an invocation count.  
        assertNull(deleteEngine.createDeleter(mockWriter));  
import java.util.List;
        assertArrayEquals(new Term[] { new Term(IdFieldMapper.NAME, Uid.encodeId("doc1")) }, terms.getValue());
                    // Expected for some threads due to race conditions
        deleteEngine.onWriterCheckedOut(1L);
            });
    public void testDeleteWithDocumentInBothGenerations() throws IOException {
        executor.submit(() -> {
        startLatch.countDown();  
        // Checkout removes the generation's deleter but not the writer's Lucene delegate.  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        when(writer1.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen1Lucene));
        LuceneWriter writer1 = new LuceneWriter(  
    public void testOnWriterCheckedOutCalledTwiceForSameGeneration() throws IOException {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, currentWriter);
        int numDocs = scaledRandomIntBetween(50, 200);  
            } catch (Exception e) {
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));  
                    writerPool.releaseAndUnlock(locked);
        Writer<?> mockWriter = createMockWriter(1L);
        WriterHolder current = writerPool.getAndLock(h -> h.get().generation() == 2L);  
                } finally {  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    writerPool.releaseAndUnlock(locked);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    public void testConcurrentDeleteAndWriterCheckout() throws Exception {
        when(mockWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(mockLuceneWriter));  
        Writer<?> mockWriter = createMockWriter(1L);  
            2L,
        Path parentDir = baseDir.resolve("parent");
        ExecutorService executor = Executors.newSingleThreadExecutor();
    }
                } catch (Exception e) {
            baseDir,
        executor.submit(() -> {
        LuceneWriter writer3 = new LuceneWriter(
                    DeleteResult r = deleteEngine.deleteDocument(di, locked.get());
            writerPool.releaseAndUnlock(locked2);
        Writer<?> mockWriter = createMockWriter(1L);
            baseDir,  
        @Override
        deleteEngine.close();
        java.nio.file.Files.createDirectories(parentDir);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(deleted.get() > 0);
        deleteEngine.createDeleter(writer2);
                // Unexpected  
        DeleteInput deleteDoc3 = new DeleteInput(IdFieldMapper.NAME, "doc3", 3L);  
            new LuceneShardStatsTracker()
        );
        executor.submit(() -> {
        }, LinkedList::new, 1);
        when(writer2.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(currentGenWriter));  
        // One batched call per generation, regardless of how many ids that generation buffered.
        // matcher would not match a multi-term call at all.  
            }
        writer1.addDoc(docInput);
        assertTrue(result instanceof DeleteResult.Success);
        deleteEngine.createDeleter(writer1);
        return pool;  
        });
        }
            }
        deleteEngine.createDeleter(currentWriter);
                            deleter.recordBufferedDeletes(id);
        deleteEngine.recordWrite("test", new DocumentLocation(2L, -1L));
                }
                for (int i = 0; i < numDocs && !done.get(); i++) {
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));  
                startLatch.await();
        when(prevLuceneWriter.generation()).thenReturn(1L);
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 2L);
    public void testGetDataFormat() {  
        AtomicBoolean checkoutCompleted = new AtomicBoolean(false);
        ExecutorService executor = Executors.newFixedThreadPool(4);
                barrier.await();
        deleteEngine.close();
    }
            2L,  
        );
    }
                        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc" + i, 1L);
        parentDirectory.close();
            new LuceneShardStatsTracker()  
            return writer;  
        assertTrue(checkoutCompleted.get());  
        Directory parentDirectory = new MMapDirectory(parentDir);
    }
        when(previousWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(prevLuceneWriter));  
        });
        executor.submit(() -> {
    private Writer<?> createMockWriter(long generation) {
            0L,
            luceneDataFormat,
                } catch (Exception e) {
            ConcurrentHashMap.newKeySet(),
            luceneDataFormat,
        executor.submit(() -> {
        writer1.close();  
    }  
        verify(mockParentWriter, times(1)).deleteDocuments(any(Term[].class));
        // gen 1 drained two ids, gen 2 drained one.  
    }
        // Index doc1 in gen 1
        AtomicBoolean closeDone = new AtomicBoolean(false);
                    try {
            });  
        assertTrue(indexed.get() > 0);
        CyclicBarrier barrier = new CyclicBarrier(2);
        AtomicInteger indexed = new AtomicInteger(0);
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));  
        Directory parentDirectory = new MMapDirectory(parentDir);
                refreshCompleted.set(true);
        Writer<?> writer1 = createMockWriter(1L);  
                }
        for (int i = 0; i < numThreads; i++) {
        deleteEngine.deleteDocument(new DeleteInput(IdFieldMapper.NAME, "doc1", current.get().generation()), current.get());
        Directory parentDirectory = new MMapDirectory(parentDir);
            try {
        Writer<?> currentWriter = createMockWriter(2L);
                }
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
            }
        // doc_a in gen 1, doc_b in gen 2
        boolean hasDeletes1 = deleteEngine.onWriterCheckedOut(1L);  
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        writer1.close();
    }
        });
        deleteEngine.createDeleter(writer1);
        // deleteDocument buffers "doc1" on gen 1's deleter
                barrier.await();  
                // Expected
        WriterHolder(Writer<?> writer) {
    }  
        deleteEngine.onWriterCheckedOut(1L);
        long afterFirstId = deleteEngine.ramBytesUsed();
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
                for (int i = 1; i <= 60; i++) {  
                });  
 *
                        deleteCount.incrementAndGet();
        assertNull(exception.get());
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    deleteEngine.deleteDocument(deleteInput, mockWriter);
        Writer<?> writer1 = createMockWriter(1L);
        Deleter deleter1 = deleteEngine.createDeleter(writer1);  
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
        );  
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc1", locked.get().generation());
        });  
            null,
        Writer<?> writer2 = createMockWriter(2L);
                    } catch (IllegalStateException e) {  
            }  
            null,
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.when;  
            baseDir,
        java.nio.file.Files.createDirectories(parentDir);  
            null,  
        int docsPerGeneration = 50;
                barrier.await();
        executor.shutdown();
    public void testOnWriterCheckedOutDeduplicatesRepeatedIds() throws IOException {
            0L,
                    }
        verify(mockParentWriter, times(1)).deleteDocuments(any(Term[].class));
        assertFalse(oldDeleter.isActive());
        Directory parentDirectory = new MMapDirectory(parentDir);
            try {
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc" + i, 1L);
                throw new RuntimeException(e);
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);  
        boolean result = deleteEngine.onWriterCheckedOut(1L);  
        mockParentWriter = mock(MergeIndexWriter.class);  
        Writer<?> writer1 = createMockWriter(1L);  
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
     *   pool.checkoutAll(w -> deleteEngine.onWriterCheckedOut(w.get().generation()))
            new LuceneShardStatsTracker()
        );  
                        // Expected when engine closes
    public void testConcurrentCloseAndDeleteDocument() throws Exception {
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
                writerPool.checkoutAll(checkedOutWriter -> {
        verify(gen2Lucene).recordPositionalDelete(9L);
        AtomicBoolean deleteCompleted = new AtomicBoolean(false);  
import org.opensearch.index.engine.dataformat.DocumentLocation;  
                    deleteEngine.recordWrite("doc_b", new DocumentLocation(locked.get().generation(), -1L));  
        deleteEngine.createDeleter(mockWriter);
import static org.mockito.Mockito.mock;
    /**
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, docId, 2L);
            try {
        executor.submit(() -> {
                    Deleter deleter = deleteEngine.createDeleter(mockWriter);  
        // ...and the current generation (C=2) receives no positional delete (Case 2 != Case 3).
                    writerPool.releaseAndUnlock(locked);  
            3L,
                } finally {  
        ExecutorService executor = Executors.newFixedThreadPool(2);
            ConcurrentHashMap.newKeySet(),
        assertNotNull(result);
        Writer<?> writer1 = createMockWriter(1L);  
        writer1.addDoc(docA);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        executor.shutdown();
                        successCount.incrementAndGet();  
                    Thread.yield();  
        Writer<?> mockWriter = createMockWriter(1L);
        Writer<?> writer2 = createMockWriter(2L);  
                try {  
        assertTrue(parentWriter.hasUncommittedChanges());
        }  
            DeleteResult result = deleteEngine.deleteDocument(deleteInput, lockedWriter.get());  
        assertNotNull(result);  
        LuceneWriter currentGenWriter = mock(LuceneWriter.class);
        // Batched: one call carrying every drained term, so Lucene resolves them in a single pass  
                barrier.await();
        });
        executor.shutdown();
                        deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());  
        assertTrue(deleteEngine.onWriterCheckedOut(1L));
        deleteEngine.createDeleter(writer2);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
        // Updater grabs the CURRENT writer (gen2) FIRST — the exact precondition of the old deadlock.
        writerPool.releaseAndUnlock(current);
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
            luceneDataFormat,  
        LuceneWriter writer3 = new LuceneWriter(
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, newWriter);
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
            luceneDataFormat,
        Writer<?> mockWriter = createMockWriter(1L);  
            lock.lock();
            this.writer = writer;
        docB.setRowId(LuceneDocumentInput.ROW_ID_FIELD, 0);  
                }  
            final int threadId = t;
        });
            0L,  
    /**
        LuceneWriter writer2 = new LuceneWriter(  
        parentWriter.close();
    }
            pool.releaseAndUnlock(h);
            luceneDataFormat,  
        executor.submit(() -> {
     * P's deleter, never C's — distinguishing Case 2 from Case 3 (prior copy in the same writer).
        assertTrue(result instanceof DeleteResult.Success);  
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));  
            ConcurrentHashMap.newKeySet(),
            null,  
        super.setUp();
                for (int i = 0; i < 50; i++) {  
                exception.set(e);  
        return new LuceneDeleteExecutionEngine(mockDataFormat, mockCommitter);
        Path parentDir = baseDir.resolve("parent");
                    // Some failures expected due to race conditions
        LuceneDocumentInput docInput = new LuceneDocumentInput();
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));  
        Writer<?> mockWriter = createMockWriter(1L);
import org.opensearch.be.lucene.LuceneDataFormat;
        CountDownLatch startLatch = new CountDownLatch(1);
                }
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());  
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
            } catch (Exception e) {
                deleteEngine.close();
        // Add some buffered deletes
            new LuceneShardStatsTracker()  
        executor.submit(() -> {
                    Thread.yield();  
                deleteEngine.onWriterCheckedOut(1L);  
        deleteEngine.recordWrite("doc3", new DocumentLocation(2L, 4L));
        // Previous generation (1) with a trackable Lucene child writer so we can verify the direct delete.  
        assertTrue(deleter2.isActive());
        ArgumentCaptor<Term[]> batches = ArgumentCaptor.forClass(Term[].class);
        deleteEngine.createDeleter(writer3);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
                } finally {
            } catch (Exception e) {  
        });
        Directory parentDirectory = new MMapDirectory(parentDir);  
                Thread.sleep(50);
        deleteEngine.createDeleter(writer2);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);
        Deleter deleter = deleteEngine.createDeleter(mockWriter);
        // The same id updated twice within one generation only needs one term delete.  
        when(writer1.generation()).thenReturn(1L);
        // The per-entry cost is a nominal estimate, so it does not vary with the id's length.
 */  
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 3L));  
            }
            Codec.getDefault(),  
            } catch (Exception e) {
        writer2.close();
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
    public void testCreateMultipleDeletersForDifferentGenerations() throws IOException {  
            null,  
            new LuceneShardStatsTracker()
        });
        assertTrue(deleter3.isActive());  
                barrier.await();
        when(writerWithoutLuceneDelegate.generation()).thenReturn(1L);
        assertTrue(result instanceof DeleteResult.Success);
        Writer<?> writer1 = createMockWriter(1L);
            null,  
            Codec.getDefault(),
        Writer<?> mockWriter = createMockWriter(1L);  
            new LuceneShardStatsTracker()
        // Index doc in gen 1  
            new LuceneShardStatsTracker()
        when(writer2.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen2Lucene));
        deleteEngine.createDeleter(writer1);
                    deleteEngine.recordWrite("doc" + i, new DocumentLocation(1L, -1L));
        // Thread B (refresh): checkoutAll
        CyclicBarrier barrier = new CyclicBarrier(2);
        java.nio.file.Files.createDirectories(parentDir);  
        verify(mockParentWriter, times(1)).deleteDocuments(terms.capture());
    public void testClose() throws IOException {
        verify(gen2Lucene).recordPositionalDelete(4L);
        Deleter deleter1 = deleteEngine.createDeleter(mockWriter1);
            Codec.getDefault(),  
                        deleter.recordBufferedDeletes("doc" + i);  
    public void testOnWriterCheckedOut() throws IOException {  
        when(mockWriter.generation()).thenReturn(1L);
                barrier.await();  
        executor.submit(() -> {
        boolean result = deleteEngine.onWriterCheckedOut(1L);
        when(currentGenWriter.generation()).thenReturn(2L);  
     */
                    DeleteInput di = new DeleteInput(IdFieldMapper.NAME, "doc1", locked.get().generation());
                // Expected
                try {
    public void testConcurrentRecordWriteAndOnWriterCheckedOut() throws Exception {  
                WriterHolder locked = writerPool.getAndLock(h -> h.get().generation() == 3L);
        Writer<?> writer1 = createMockWriter(1L);
        });
                Thread.sleep(10);  
            }
        deleteEngine.onWriterCheckedOut(1L);
            }
            DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", lockedWriter.get().generation());
        deleteEngine.createDeleter(mockWriter);
        deleteEngine.close();
                    Thread.yield();
                // Unexpected  
    private static class WriterHolder implements Lockable {  
    public void testDeleteAfterAllGenerationsCheckedOut() throws IOException {  
    public void testCreateDeleterWithoutLuceneWriterReturnsNull() {
                    try {
            try {
        LuceneWriter writer2 = new LuceneWriter(
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
    /**
            null,  
     */  
                    }
        deleteEngine.createDeleter(mockWriter);
            baseDir,  
     * in parallel; each prior copy is deleted directly via its generation's own deleter lock.
        ExecutorService executor = Executors.newFixedThreadPool(4);  
        deleteEngine.onWriterCheckedOut(1L);
            } catch (Exception e) {
        }
        deleterFuture.get(10, TimeUnit.SECONDS);  
                        deleteEngine.deleteDocument(deleteInput, mockWriter);  
     * intermediate updates are correctly applied to parentWriter during checkout.
        assertTrue(result instanceof DeleteResult.Success);
        assertTrue(result instanceof DeleteResult.Success);
        }
            }
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, -1L));  
        LuceneDataFormat luceneDataFormat = new LuceneDataFormat();  
        when(writer2.generation()).thenReturn(2L);
        // The positional delete must be deferred to generation 2's writer (at rowId 9), never gen 1's.
                completeLatch.countDown();
            try {
        deleteEngine.createDeleter(writer2);
            new LuceneShardStatsTracker()
import java.util.Optional;
    public void testConcurrentDeleteOperations() throws Exception {
        }
        assertFalse(result);  
            1L,
        Writer<?> previousWriter = mock(Writer.class);  
        assertFalse(deleteEngine.onWriterCheckedOut(1L));  
import org.mockito.ArgumentCaptor;
            baseDir,  
        deleteEngine.createDeleter(writer2);
        executor.submit(() -> {  
            try {
                    barrier.await();
        when(mockCommitter.getIndexWriter()).thenReturn(mockParentWriter);  
        deleteEngine.recordWrite("test", new DocumentLocation(1L, -1L));
                    DeleteResult r = deleteEngine.deleteDocument(di, locked.get());
import java.io.IOException;
        // Pool item removed — evaluateAllAndLock returns null  
        // Deleting from the current generation (2) must resolve doc1 to generation 1 and defer a
        deleteEngine.onWriterCheckedOut(1L);
                    deleteEngine.recordWrite("doc" + i, new DocumentLocation(1L, -1L));  
    }
                        Deleter deleter = deleteEngine.createDeleter(writer);
        // doc1 was routed to the retired gen 1: its entry is gone, so no positional delete on gen 1's writer.
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2);
                barrier.await();
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);  
        LockablePool<WriterHolder> writerPool = buildWriterPool(deleteEngine, writer1, writer2, writer3);  
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 2L);
        assertTrue(deleteEngine.ramBytesUsed() > 0L);
        LuceneWriter writer1 = new LuceneWriter(
    public void testMultiGenerationDeleteWorkflow() throws IOException {
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer2);  
                // Expected
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();
                    exception.set(e);  
        // Setup current generation deleter  
        when(gen1Lucene.generation()).thenReturn(1L);
        Deleter deleter2 = deleteEngine.createDeleter(writer2);  
                exception.set(e);  
        });
            0L,
                    deleteEngine.onWriterCheckedOut(checkedOut.get().generation());  
                }
            2L,
            });  
                    deleteEngine.createDeleter(writer);
        CountDownLatch completeLatch = new CountDownLatch(2);
            } catch (Exception e) {
        writerFuture.get(10, TimeUnit.SECONDS);
     * Update Case 2: the prior copy lives in a DIFFERENT still-active generation P (not the current  
        Thread.sleep(50);  
        verify(prevLuceneWriter).recordPositionalDelete(3L);  
                barrier.await();
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 3L);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Path baseDir = createTempDir();
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngineWithParentWriter(parentWriter);
            1L,
            1L,
import org.opensearch.index.engine.dataformat.Writer;
        assertTrue("refresh thread did not start", refreshStarted.await(5, TimeUnit.SECONDS));
        });
                    }  
                            break;
        verify(gen1Lucene, never()).recordPositionalDelete(anyLong());  
        when(mockWriter.generation()).thenReturn(generation);
            0L,
        assertTrue(result instanceof DeleteResult.Success);  
            assertTrue(result instanceof DeleteResult.Success);
        executor.submit(() -> {
                // Expected  
        when(writer1.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.of(gen1Lucene));
     */
        }  
    public void testRefreshReturnsNull() throws IOException {
            try {
        for (int i = 0; i < writers.length; i++) {
        writer3.close();
            luceneDataFormat,
     *   4. pool.releaseAndUnlock()  
        when(mockWriter.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME)).thenReturn(Optional.empty());  
        assertFalse(deleter2.isActive());
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 5L));
                    } catch (Exception e) {  
            } catch (IOException e) {
        for (int gen = 1; gen <= numGenerations; gen++) {  
        assertEquals(numThreads, successCount.get());
                        deleteEngine.onWriterCheckedOut(checkedOutWriter.get().generation());
                        DeleteResult result = deleteEngine.deleteDocument(deleteInput, writer1);
                startLatch.await();  
    // ===== Analogous to CompositeIndexWriter update/delete patterns =====
            null,
            try {
     * Guards against the former AB-BA deadlock: updates hold the current writer's pool lock and use  
        assertEquals(2, successCount.get());
        when(committer.getIndexWriter()).thenReturn(parentWriter);  
        parentDirectory.close();  
        verify(mockParentWriter, times(1)).deleteDocuments(any(Term[].class));
        deleter.recordBufferedDeletes("doc2");  
                        deleted.incrementAndGet();
        Path parentDir = baseDir.resolve("parent");
        assertFalse(result);
        executor.submit(() -> {  
                startLatch.await();
        });  
                    if (result != null) {
    }
            luceneDataFormat,
            null,  
            null,
            } catch (Exception e) {
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 7L));
            0L,  
    // ===== Close behavior tests =====  
        AtomicReference<Exception> exception = new AtomicReference<>();
                    DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "shared_doc", 2L);
        parentWriter.close();
        );  
            1L,  
     *        (previous generation resolved internally via lookupGen; deleted via its own deleter lock)
            ConcurrentHashMap.newKeySet(),
        Writer<?> mockWriter = createMockWriter(1L);
        Writer<?> writer1 = createMockWriter(1L);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        MergeIndexWriter parentWriter = new MergeIndexWriter(parentDirectory, new IndexWriterConfig());
        Writer<?> mockWriter = createMockWriter(1L);
        parentDirectory.close();
        executor.submit(() -> {
            }  
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "nonexistent_doc", 1L);
        Deleter deleter = deleteEngine.createDeleter(mockWriter);  
import org.apache.lucene.store.Directory;
        Deleter deleter1 = deleteEngine.createDeleter(writer1);  
        assertSame(mockDataFormat, deleteEngine.getDataFormat());
        AtomicInteger deleted = new AtomicInteger(0);
            assertTrue(r2 instanceof DeleteResult.Success);  
                    deleteEngine.deleteDocument(di, locked.get());  
                try {  
                        Writer<?> writer = createMockWriter(gen);  
            }
                    Thread.yield();
        });  
            new LuceneShardStatsTracker()
        );  
        DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);
        DeleteInput deleteInput = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
            } finally {
        Future<?> checkoutFuture = executor.submit(() -> {  
        deleteEngine.createDeleter(writer2);
                    if (r instanceof DeleteResult.Success) {  
        AtomicInteger generation = new AtomicInteger(0);  
            ConcurrentHashMap.newKeySet(),  
        Writer<?> writer1 = mock(Writer.class);
                try {
    }  
        java.nio.file.Files.createDirectories(parentDir);  
                } finally {
        AtomicBoolean refreshDone = new AtomicBoolean(false);
        CyclicBarrier barrier = new CyclicBarrier(5);
        deleteEngine.deleteDocument(deleteDoc3, writer3);
        deleteEngine.recordWrite("doc1", new DocumentLocation(1L, 3L));  
        Path baseDir = createTempDir();  
            ConcurrentHashMap.newKeySet(),
        LuceneWriter gen1Lucene = mock(LuceneWriter.class);
        LuceneDeleteExecutionEngine deleteEngine = createDeleteEngine();  
        assertFalse(deleter.isActive());  
        LuceneDocumentInput docA = new LuceneDocumentInput();  
        parentDirectory.close();
        assertEquals(numGenerations * docsPerGeneration, batches.getAllValues().stream().mapToInt(b -> b.length).sum());
        try {
    }
        // at its own flush, using the recorded insertion rowId — not an in-generation Term delete.
                    startLatch.await();
        // Update 2: gen 3 updates doc1 (prior copy in gen 2 deleted directly via gen 2's deleter)
                    DeleteResult result = deleteEngine.deleteDocument(deleteInput, mockWriter);  
        LuceneWriter writer2 = new LuceneWriter(
        LuceneCommitter committer = mock(LuceneCommitter.class);
        when(gen1Lucene.generation()).thenReturn(1L);
        Future<?> refresh = executor.submit(() -> {
    public void testOnWriterCheckedOutWithNoBufferedDeletes() throws IOException {
    //  
    @Override
