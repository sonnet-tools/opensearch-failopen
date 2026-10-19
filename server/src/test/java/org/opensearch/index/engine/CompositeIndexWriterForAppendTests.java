                compositeIndexWriter.beforeRefresh();  
            run.set(false);  
        Path dataPath = engineConfig.getStore().shardPath().resolveIndex();  
            }
                            newDeleteTombstoneDoc(id),
                    mergeLatch.countDown();
            }
            indexWriterFactory
            newSoftDeletesPolicy(),  
                            BucketedCompositeDirectory.CHILD_DIRECTORY_PREFIX + associatedCriteria + "_" + UUID.randomUUID()
                    } catch (AlreadyClosedException e) {
                    CompositeIndexWriter.LiveIndexWriterDeletesMap currentMap = mapRef.get();  
        };
                for (Map.Entry<String, String> entry : compositeIndexWriterForRollback.getLiveCommitData()) {
            CompositeIndexWriter.DisposableIndexWriter,
                IndexOutput out = super.createOutput(name, context);  
                engineConfig,
        refreshThread.join(1000);
        } finally {
        AtomicReference<Error> thrownError = new AtomicReference<>();
    public void testHasBlocksMergeFullyDelSegments() throws Exception {
            config(),  
        });  
                try {
                    String id = Integer.toString(randomIntBetween(1, 100));
                } catch (IOException e) {
        Directory dir = new FilterDirectory(newDirectory()) {  
                        throw new OutOfMemoryError("Simulated write failure");
                        );  
            refresher.join();  
        // Add a document successfully
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            } catch (Exception ignored) {}  
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
        }
                    computeCount.incrementAndGet();
        }
        } finally {  
        }
            compositeIndexWriter.beforeRefresh();  
        ReleasableLock lock = compositeIndexWriter.getNewWriteLock().acquire();
import org.apache.lucene.store.FilterDirectory;
                return new CompositeIndexWriter.DisposableIndexWriter(
    public void testGetTragicExceptionWithException() throws IOException {
        } finally {  
    public void testHasPendingMergesInitiallyFalse() throws IOException {
        try {
                        return;  
        // Add a document successfully  
        );
        );  
    public void testTreatDocumentFailureAsFatalErrorOnGroupSpecificIndexWriter() throws IOException {
            assertThrows(AlreadyClosedException.class, compositeIndexWriter::ramBytesUsed);
                return new FilterIndexOutput("failing output", "test", out) {
            parentWriter,
        CompositeIndexWriter compositeIndexWriter = null;
                        throw new OutOfMemoryError("Simulated write failure");  
        LogByteSizeMergePolicy mergePolicy = new LogByteSizeMergePolicy();  
        }
        compositeIndexWriter.getConfig().setRAMBufferSizeMB(128);
        };
            final CountDownLatch mergeLatch = new CountDownLatch(1);  
package org.opensearch.index.engine;
            createWriter(),
            create ? Versions.MATCH_DELETED : Versions.MATCH_ANY,
            addDocException.set(new IOException("simulated"));
            }  
                    Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
            IOUtils.closeWhileHandlingException(compositeIndexWriter, lock);  
            try (Releasable lock = compositeIndexWriter.obtainWriteLockOnAllMap()) {
            DisposableIndexWriter createChildWriterUtil(String associatedCriteria, CriteriaBasedIndexWriterLookup lookup)
            final AtomicBoolean hadPendingMerges = new AtomicBoolean(false);
            // Check for pending merges during merge  
            indexWriterFactory  
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
            newSoftDeletesPolicy(),  
                assertFalse("hasBlocks should be cleared", directoryReader.leaves().get(0).reader().getMetaData().hasBlocks());  
        });  
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
        );
        CountDownLatch latch = new CountDownLatch(1);
                    compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
                    .computeIndexWriterIfAbsentForCriteria("200", this::createChildWriterFactory, new ShardId("foo", "_na_", 1));  
            long flushingBytes = compositeIndexWriter.getFlushingBytes();  
        };
                Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(i), null, DEFAULT_CRITERIA));
        CountDownLatch latch = new CountDownLatch(1);  
        } catch (Error ignored) {}
    }
        }
            public IndexOutput createOutput(String name, IOContext context) throws IOException {
                        public long addDocuments(Iterable<? extends Iterable<? extends IndexableField>> docs) throws IOException {  
            indexWriterFactory
        );
            Engine.Operation.Origin.PRIMARY,  
            assertNotNull(compositeIndexWriter.getTragicException());
                            }
            }
            long flushingBytes = compositeIndexWriter.getFlushingBytes();
                try {
        latch.await();
            compositeIndexWriter.commit();
        } finally {
                assertTrue(compositeIndexWriter.isWriteLockedByCurrentThread());
            UNASSIGNED_SEQ_NO,
            String,  
        // Add a document successfully
            assertEquals("Flushing bytes should be non-negative", 0, flushingBytes);
        } finally {  
            indexer.join();
                Thread.yield();
            try {
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
        });
            newSoftDeletesPolicy(),
            createWriter(),
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
        try {
                    }
        };
        );
        IOUtils.closeWhileHandlingException(compositeIndexWriter, dir);
        refresher.start();
                    }  
            compositeIndexWriter.beforeRefresh();  
        ) {  
            long ramAfterGroup2 = compositeIndexWriter.ramBytesUsed();  
            @Override  
        CountDownLatch latch = new CountDownLatch(1);
                    newSoftDeletesPolicy(),
                        compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
        FlushingIndexWriterFactory indexWriterFactory = new FlushingIndexWriterFactory(dirSupplier, new AtomicBoolean(true));
        }
                disposableIndexWriter = liveIndexWriterDeletesMap.get()
                    currentMap.computeIndexWriterIfAbsentForCriteria("test-criteria", supplier, new ShardId("foo", "_na_", 1));
            indexWriterFactory
            refresher.join();
import org.apache.lucene.store.Directory;  
            // Should still be 0 or small since we haven't triggered a flush  
        );  
        FlushingIndexWriterFactory indexWriterFactory = new FlushingIndexWriterFactory(dirSupplier, new AtomicBoolean(true));  
        } finally {  
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
import org.apache.lucene.index.IndexWriter;
            IOUtils.close(compositeIndexWriter);  
        try {
            newSoftDeletesPolicy(),
        refresher.start();  
    public void testRAMBytesUsedWithWriterOnOld() throws Exception {  
        );  
        try {
            for (int i = 0; i < 10; i++) {
        } finally {
        }
        FlushingIndexWriterFactory indexWriterFactory = new FlushingIndexWriterFactory(dirSupplier, new AtomicBoolean(true));
        );
                    ) {
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.lucene.store.IndexOutput;
            latch.await();
            newSoftDeletesPolicy(),
    }  
            ) {  
    }
            softDeletesField,
        try {
    public void testRAMBytesUsedWithTragicExceptionOnOld() throws Exception {  
        } finally {  
        try {
            for (int i = 0; i < 10; i++) {  
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));  
            createWriter(),
                latch.countDown();  
                compositeIndexWriter.beforeRefresh();
        }
                )
            compositeIndexWriter.afterRefresh(true);
                        throw new AssertionError(e);
        assertTrue("Compute operations completed: " + computeCount.get(), computeCount.get() >= 100);  
            }
        } catch (Error ignored) {}
                done.set(true);
        } catch (Error ignored) {}  
@LuceneTestCase.AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/20005")
            config(),
            newUid(doc),  
                            throw ex;
        Thread indexer = new Thread(() -> {
        ReleasableLock lock = compositeIndexWriter.getNewWriteLock().acquire();
                (path, attributes) -> attributes.isDirectory() == true && path.endsWith("extra0") == false
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
        }
            latch.await();
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
        );  
    public void testRAMBytesUsedWithTragicExceptionOnCurrent() throws Exception {  
                IndexOutput out = super.createOutput(name, context);  
            createWriter(),
            }
        }
        Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
        AtomicInteger computeCount = new AtomicInteger(0);  
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);  
    public void testObtainLock() throws Exception {  
                assertNotNull(disposableIndexWriter);
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
            config(),
        } catch (Error ignored) {}  
import java.util.HashMap;
            try {  
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
        try {
                IndexOutput out = super.createOutput(name, context);
}
                compositeIndexWriter.beforeRefresh();
        } catch (Exception ex) {
            indexedDocs.acquire(100);
                assertFalse("Writer should be closed after tragic exception", compositeIndexWriter.isOpen());
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
        }
            try (
        refresher.start();
                while (run.get()) {
        try {
            indexWriterFactory  
        Thread.sleep(100);
            IOException> supplier = (crit, lookup) -> mock(CompositeIndexWriter.DisposableIndexWriter.class);  
            // Add a few small documents
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);
                Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(i), null, DEFAULT_CRITERIA));
import org.opensearch.common.lucene.uid.Versions;
            mergeThread.join();
            refresher.start();
        }  
                numOps--;
    public void testSetLiveCommitDataWithRollback() throws Exception {
    public void testHasPendingMergesDuringForceMerge() throws IOException, InterruptedException {  
        } finally {
        IOUtils.closeWhileHandlingException(compositeIndexWriter, indexWriterFactory);
        ReleasableLock lock = compositeIndexWriter.getNewWriteLock().acquire();
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {
            }
                return new FilterIndexOutput("failing output", "test", out) {
            config(),
                            operation.uid(),
        try {
        compositeIndexWriter.beforeRefresh();
    }  
            operation = indexForDoc(createParsedDoc("id2", null, "testingNewCriteria"));  
                            thrownError.set(ex);  
        CountDownLatch latch = new CountDownLatch(1);
        Thread refresher = new Thread(() -> {
        AtomicBoolean shouldFail = new AtomicBoolean(false);  
        compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
        } finally {
            compositeIndexWriter = new CompositeIndexWriter(
            compositeIndexWriter.afterRefresh(true);
            latch.await();
        // Add a document successfully  
        if (hitError && thrownError.get() != null) {
        });
            doc,
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));  
        try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {  
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            @Override
        AtomicBoolean stopped = new AtomicBoolean();
            assertNull(compositeIndexWriter.getTragicException());
                            2,  
        }
            } catch (Exception ignored) {}
import java.util.UUID;  
    }
            newSoftDeletesPolicy(),
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
                while (run.get()) {  
            config(),  
        try {
import java.util.concurrent.atomic.AtomicBoolean;  
                    } catch (IOException e) {}
                CompositeIndexWriter.LiveIndexWriterDeletesMap current = mapRef.get();  
        } catch (Error ignored) {}
        Thread computeThread = new Thread(() -> {  
            softDeletesField,
    }
        FlushingIndexWriterFactory indexWriterFactory = new FlushingIndexWriterFactory(dirSupplier, new AtomicBoolean(true));  
        );  
            indexWriterFactory
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
                IndexOutput out = super.createOutput(name, context);  
import static org.mockito.Mockito.mock;  
        }  
        try {  
        CountDownLatch latch = new CountDownLatch(1);
        Thread refresher = new Thread(() -> {  
        try {
            for (int i = 0; i < 10; i++) {
                    }
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
            // Ensure no child directory is pending here.  
        } finally {
    }
                compositeIndexWriter.beforeRefresh();
                };
                            1,
        Supplier<Directory> dirSupplier = () -> new FilterDirectory(newDirectory()) {
    }
                    softDeletesField,  
            @Override
                count++;  
            compositeIndexWriter.beforeRefresh();
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
            parentWriter,  
        Thread refresher = new Thread(() -> {
    public void testConcurrentIndexingDuringRefresh() throws IOException, InterruptedException {
            newSoftDeletesPolicy(),
                    try {  
                        super.writeBytes(b, offset, length);  
            }
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
        } catch (Error ignored) {}
        assertThrows(AlreadyClosedException.class, compositeIndexWriter::getFlushingBytes);  
                    indexWriterFactory
                    new IndexWriter(
        Thread refresher = new Thread(() -> {
            AtomicBoolean run = new AtomicBoolean(true);
            });  
        );
                    @Override
    }
                IndexOutput out = super.createOutput(name, context);
            long directoryCount = Files.find(
                    } catch (IOException e) {  
 * SPDX-License-Identifier: Apache-2.0
        try {
            computeThread.start();
 */  
            new CompositeIndexWriter.LiveIndexWriterDeletesMap()  
            @Override
    }  
            latch.await();
                            final IOException ex = addDocException.getAndSet(null);
            refresher.join();
                }
                };
            refresher.join();
            softDeletesField,  
        Supplier<Directory> dirSupplier = () -> new FilterDirectory(newDirectory()) {  
        try {
                return new FilterIndexOutput("failing output", "test", out) {
            compositeIndexWriter.forceMergeDeletes(true);
            indexWriterFactory  
            refresher.join();
            mergeLatch.await();
        ReleasableLock lock = compositeIndexWriter.getNewWriteLock().acquire();  
            assertEquals(numDocs - numDeletes.get(), directoryReader.numDocs());
        final EngineConfig engineConfig = config();
            config(),  
        } catch (Error ignored) {}  
            }
            indexWriterFactory
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);  
                        }  
            indexWriterFactory
            // After merge completes, should have no pending merges  
                };  
        assertThrows(AlreadyClosedException.class, compositeIndexWriter::ramBytesUsed);
        assertNotNull(finalMap.current);
            }  
            try {
            createWriter(),  
        return new Engine.Index(
                    if (entry.getKey().equals("status")) {
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
        } finally {
        try (
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
        try {
    public void testRAMBytesUsedWithOldAndCurrentWriters() throws Exception {
            @Override  
import java.util.concurrent.CountDownLatch;
                rotationCount.incrementAndGet();
        try {
            latch.await();
                        numDeletes.incrementAndGet();
            UNASSIGNED_SEQ_NO,
            indexWriterFactory
                liveIndexWriterDeletesMap.set(liveIndexWriterDeletesMap.get().invalidateOldMap());
            data = new HashMap<>();
            indexWriterFactory
                newSoftDeletesPolicy(),
            });  
        }
            softDeletesField,  
            compositeIndexWriter.rollback();
            assertThrows(AlreadyClosedException.class, compositeIndexWriter::getFlushingBytes);  
        };
            try (DirectoryReader directoryReader = DirectoryReader.open(compositeIndexWriter.getAccumulatingIndexWriter())) {
            Thread.sleep(100);  
        );
                compositeIndexWriter.beforeRefresh();
        }
import org.apache.lucene.index.IndexableField;  
                newSoftDeletesPolicy(),
        AtomicReference<CompositeIndexWriter.LiveIndexWriterDeletesMap> mapRef = new AtomicReference<>(
        assertFalse("Should have no pending merges initially", compositeIndexWriter.hasPendingMerges());  
                    }
        } finally {
            }
import java.nio.file.Files;
        running.set(false);  
        refresher.start();
            createWriter(),  
        IndexWriter parentWriter = createWriter();
            }
import org.opensearch.common.CheckedBiFunction;  
        Supplier<Directory> dirSupplier = () -> new FilterDirectory(newDirectory()) {
            newSoftDeletesPolicy(),  
            softDeletesField,
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
            // This should trigger the failure  
                        Engine.Index operation = indexForDoc(createParsedDoc(id, null, DEFAULT_CRITERIA));
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            softDeletesField,
        };
            int count = 0;  
    public void testFlushingBytesUsedWithTragicExceptionOnOld() throws Exception {
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
                indexWriterFactory  
            newSoftDeletesPolicy(),  
        try {  
            0
import org.apache.lucene.store.AlreadyClosedException;
            newSoftDeletesPolicy(),
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
                currentMapRef.set(invalidated);
                        if (shouldFail.get() && name.endsWith(".cfe")) {
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
            compositeIndexWriter.afterRefresh(true);
            indexWriterFactory  
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {
                    try {
            newSoftDeletesPolicy(),  
            }  
        try {  
        CheckedBiFunction<
                        @Override
            int numOps = 100;
                disposableIndexWriter.getIndexWriter().getDirectory().close();
            rotationThread.join();  
            @Override
            compositeIndexWriter.beforeRefresh();  
        });
                            return super.addDocuments(docs);
            try {
            parentWriter,  
            IOUtils.closeWhileHandlingException(compositeIndexWriter, indexWriterFactory, lock);
        FlushingIndexWriterFactory indexWriterFactory = new FlushingIndexWriterFactory(dirSupplier, new AtomicBoolean(true));
        );
                        newIndexWriterConfig()  
                CompositeIndexWriter.LiveIndexWriterDeletesMap invalidated = transition.invalidateOldMap();
            latch.await();  
            softDeletesField,
                return new FilterIndexOutput("failing output", "test", out) {  
            softDeletesField,
                    @Override  
        AtomicReference<CompositeIndexWriter.LiveIndexWriterDeletesMap> currentMapRef = new AtomicReference<>(map);  
        ReleasableLock lock = compositeIndexWriter.getNewWriteLock().acquire();  
    public void testConcurrentComputeIndexWriterWithMapRotation() throws Exception {  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        refresher.start();  
 * The OpenSearch Contributors require contributions made to  
            IOUtils.close(compositeIndexWriter);
            @Override
            refresher.join();
            Thread indexer = new Thread(() -> {  
        );  
                    @Override
                1,  
            newSoftDeletesPolicy(),  
            indexWriterFactory
            newSoftDeletesPolicy(),
                softDeletesField,  
        // Verify the final map is in a valid state  
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
            createWriter(),  
            for (int i = 0; i < 4; i++) {
                latch.countDown();
    public void testConcurrentBuildTransitionAndInvalidateForIndexWriterDeleteMap() throws InterruptedException {
        };  
                };
            // Rollback without committing
        Thread rotationThread = new Thread(() -> {
            });
                return new FilterIndexOutput("failing output", "test", out) {
            latch.countDown();  
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
        latch.countDown();
    }
import org.apache.lucene.store.FilterIndexOutput;
import org.apache.lucene.store.IOContext;  
            public IndexOutput createOutput(String name, IOContext context) throws IOException {  
            autoGeneratedIdTimestamp,
    }
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
                CompositeIndexWriter.LiveIndexWriterDeletesMap current = currentMapRef.get();
    public Engine.Index appendOnlyPrimary(ParsedDocument doc, boolean retry, final long autoGeneratedIdTimestamp, boolean create) {
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
                }  
                    config(),  
    }  
            config(),
                    throw new RuntimeException(e);
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
            assertEquals(0, directoryCount);
import java.nio.file.Path;  
            mergeThread.start();  
                mapRef.set(invalidated);  
            while (stopped.get() == false) {
            compositeIndexWriter.afterRefresh(true);  
    }
            newSoftDeletesPolicy(),
                    },
            softDeletesField,
            retry,  
            IOUtils.close(compositeIndexWriter);  
                        throw new OutOfMemoryError("Simulated write failure");
            config(),
            for (int i = 0; i < 10; i++) {
        int iterations = 100;
        }
                CompositeIndexWriter.LiveIndexWriterDeletesMap transition = current.buildTransitionMap();  
            } catch (Exception ignored) {}  
            compositeIndexWriter.commit();  
            createWriter(),
                        compositeIndexWriter.deleteDocument(
                createWriter(),
            newSoftDeletesPolicy(),
import org.opensearch.common.util.concurrent.ReleasableLock;  
            Engine.Index operation = indexForDoc(createParsedDoc("id", null, DEFAULT_CRITERIA));  
                CompositeIndexWriter.LiveIndexWriterDeletesMap transition = current.buildTransitionMap();
            softDeletesField,
            public IndexOutput createOutput(String name, IOContext context) throws IOException {  
                config(),  
            indexer.start();
                };
            IOUtils.closeWhileHandlingException(compositeIndexWriter, lock);
            public IndexOutput createOutput(String name, IOContext context) throws IOException {
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
            Map<String, String> data = new HashMap<>();  
                return new FilterIndexOutput("failing output", "test", out) {  
import java.io.IOException;
            createWriter(),
            indexWriterFactory
            // RAM should account for both groups
            public IndexOutput createOutput(String name, IOContext context) throws IOException {
            newSoftDeletesPolicy(),  
                    }  
                return new FilterIndexOutput("failing output", "test", out) {
                );  
    }  
                Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(i), null, DEFAULT_CRITERIA));  
            softDeletesField,  
            assertEquals("Flushing bytes should be non-negative", 0, flushingBytes);
            IOUtils.close(compositeIndexWriter);
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
        CountDownLatch latch = new CountDownLatch(2);  
    }  
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {  
            Throwable tragic = compositeIndexWriter.getTragicException();
        int numDocs = scaledRandomIntBetween(100, 1000);
            );
        assertTrue("Rotation operations completed: " + rotationCount.get(), rotationCount.get() >= 0);
            } catch (Exception e) {
            latch.countDown();
        try {
        }  
            IOUtils.closeWhileHandlingException(compositeIndexWriter, indexWriterFactory, lock);
            IOUtils.close(compositeIndexWriter);
    }
        CompositeIndexWriter.LiveIndexWriterDeletesMap map = new CompositeIndexWriter.LiveIndexWriterDeletesMap();
                Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(i), null, DEFAULT_CRITERIA));
            IOUtils.closeWhileHandlingException(compositeIndexWriter, lock);
        IndexWriter parentWriter = createWriter();  
            indexWriterFactory
        AtomicReference<IOException> addDocException = new AtomicReference<>();
        // Enable failure
        CountDownLatch latch = new CountDownLatch(1);  
            compositeIndexWriter.commit();  
            while (running.get() && count < iterations) {
    public void testFlushingBytesUsedWithWriterOnOld() throws Exception {
        // Add a document successfully
            softDeletesField,
                    if (rarely()) {  
                        compositeIndexWriter.afterRefresh(true);  
import org.opensearch.core.index.shard.ShardId;
                compositeIndexWriter.afterRefresh(true);  
        IOUtils.closeWhileHandlingException(compositeIndexWriter, indexWriterFactory);  
    }  
            computeThread.join();
        IOUtils.closeWhileHandlingException(compositeIndexWriter, indexWriterFactory);
            config(),
            indexWriterFactory
                compositeIndexWriter.beforeRefresh();
        AtomicBoolean run = new AtomicBoolean(true);
        FlushingIndexWriterFactory indexWriterFactory = new FlushingIndexWriterFactory(dirSupplier, new AtomicBoolean(true));
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
            }
                createWriter(),  
        Thread refresher = new Thread(() -> {  
            ).count() - 1;
            softDeletesField,  
            System.nanoTime(),
        while (done.get() == false) {  
            createWriter(),
                        throw new OutOfMemoryError("Simulated write failure");
            config(),  
            indexWriterFactory  
        });  
                        store.newTempDirectory(  
        compositeIndexWriter.afterRefresh(true);
        Supplier<Directory> dirSupplier = () -> new FilterDirectory(newDirectory()) {  
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));  
            config(),  
        AtomicBoolean running = new AtomicBoolean(true);
            newSoftDeletesPolicy(),
        try {
                };
import org.opensearch.index.BucketedCompositeDirectory;  
            compositeIndexWriter.rollback();  
        AtomicBoolean done = new AtomicBoolean(false);
            createWriter(dir),
        // Add a document successfully  
            createWriter(),  
                    String id = Integer.toString(i);  
                        throw new OutOfMemoryError("Simulated write failure");  
            CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
        }
        refresher.start();  
 * this file be licensed under the Apache-2.0 license or a
        compositeIndexWriter.getConfig().setMergePolicy(mergePolicy);
        });
            IOUtils.close(compositeIndexWriter);  
                operation = indexForDoc(createParsedDoc(String.valueOf(i), null, DEFAULT_CRITERIA));
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
            Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(13), null, "testGroupingCriteria1"));  
            expectThrows(IOException.class, () -> compositeIndexWriter.addDocuments(operation.docs(), operation.uid()));
                        compositeIndexWriter.beforeRefresh();
            compositeIndexWriter.softUpdateDocuments(operation.uid(), operation.docs(), 2, 2, primaryTerm.get(), softDeletesField);
                assertEquals(1, directoryReader.leaves().size());
        });  
                CompositeIndexWriter compositeIndexWriterForRollback = new CompositeIndexWriter(
            softDeletesField,
            latch.countDown();  
                for (int i = 0; i < numDocs; i++) {
            }
        } catch (Error e) {  
        ReleasableLock lock = compositeIndexWriter.getNewWriteLock().acquire();  
            expectThrows(AlreadyClosedException.class, () -> compositeIndexWriter.addDocuments(operation.docs(), operation.uid()));
            indexWriterFactory  
                    @Override
    public void testTragicExceptionGetWithTragicExceptionOnCurrent() throws Exception {
                        assertEquals("beforeCommit", entry.getValue());  
        CompositeIndexWriter.LiveIndexWriterDeletesMap finalMap = currentMapRef.get();
            assertFalse("Should have no pending merges after force merge completes", compositeIndexWriter.hasPendingMerges());
        try {
            }
                indexWriterFactory
        IndexWriter parentWriter = createWriter();  
        AtomicReference<CompositeIndexWriter.LiveIndexWriterDeletesMap> liveIndexWriterDeletesMap = new AtomicReference<>(
            CompositeIndexWriter.CriteriaBasedIndexWriterLookup,
                Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(i), null, "testGroupingCriteria2"));
        });  
            rotationThread.start();  
            for (int i = 0; i < 10; i++) {
        refresher.start();
    public void testTragicExceptionGetWithTragicExceptionOnOld() throws Exception {
        // Add a document successfully
            @Override
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);  
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
        } finally {
            latch.countDown();
            try {  
            Thread refresher = new Thread(() -> {
            refresher.join();  
            assertTrue("RAM should account for multiple groups", ramAfterGroup2 >= ramAfterGroup1);
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
        try {
        );
        });
            }
            latch.countDown();  
        // Let it run for a bit
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
                        ),
        );  
            try {
            compositeIndexWriter.beforeRefresh();
            public IndexOutput createOutput(String name, IOContext context) throws IOException {
    }
                IndexOutput out = super.createOutput(name, context);
            }
                    indexedDocs.release();  
    public void testConcurrentIndexAndDeleteDuringRefresh() throws IOException, InterruptedException {
    }  
            public IndexOutput createOutput(String name, IOContext context) throws IOException {
                    }  
            config(),
            config(),
            }
                Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf(i), null, DEFAULT_CRITERIA));
            refresher.join();  
                compositeIndexWriter.beforeRefresh();
            createWriter(),
        Semaphore indexedDocs = new Semaphore(0);
            }
            // Create documents in first criteria group  
import java.util.concurrent.Semaphore;
            assertTrue("RamBytesUsed bytes should be non-negative ", ramBytesUsed > 0);  
        // Compute thread
        indexer.join();  
        // Thread that continuously builds transition maps and invalidates old ones
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {  
                                throw ex;  
            IOUtils.close(compositeIndexWriter);
            Engine.Index operation = indexForDoc(createParsedDoc("foo", null, DEFAULT_CRITERIA));
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
        assertNotNull(compositeIndexWriter.getTragicException());
            compositeIndexWriter.setLiveCommitData(data.entrySet());
        boolean hitError = false;
    }
                    lookup
        Supplier<Directory> dirSupplier = () -> new FilterDirectory(newDirectory()) {
        shouldFail.set(true);
            config(),
                }
            IOUtils.closeWhileHandlingException(compositeIndexWriter, indexWriterFactory, lock);  
            newSoftDeletesPolicy(),
        compositeIndexWriter.getConfig().setMaxBufferedDocs(2);
                    }
        mergePolicy.setMergeFactor(2);
    public void testGetIndexWriterWithRotatingMapAlwaysPutWriterInCurrentMap() throws IOException, InterruptedException {  
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
            Thread mergeThread = new Thread(() -> {  
                } catch (Exception e) {
                    compositeIndexWriter.forceMerge(1, true);  
            }  
            createWriter(),
            // Remove known extra files - "extra0" file is added by the ExtrasFS, which is part of Lucene's test framework.  
    }
            try {
                        }
                    }
                    }
        // Add a document successfully  
            compositeIndexWriter.commit();
import org.apache.lucene.tests.util.LuceneTestCase;
                    }
                dataPath,
            createWriter(),
        Thread refresher = new Thread(() -> {
                            softDeletesField
            }  
        );  
import org.apache.lucene.index.DirectoryReader;
            } catch (Exception ignored) {}
        CountDownLatch latch = new CountDownLatch(1);
    }
public class CompositeIndexWriterForAppendTests extends CriteriaBasedCompositeIndexWriterBaseTests {  
            IOUtils.close(compositeIndexWriter);  
                CompositeIndexWriter.LiveIndexWriterDeletesMap invalidated = transition.invalidateOldMap();
    public void testGetFlushingBytesAfterSmallDocuments() throws IOException {
        } finally {  
        };  
            config(),
                }  
                softDeletesField,
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
            config(),
    }
        AtomicInteger rotationCount = new AtomicInteger(0);
        }
        Thread refreshThread = new Thread(() -> {
            }  
                            Error ex = new OutOfMemoryError("Simulated write failure");
import java.util.Map;
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.index.VersionType;
            VersionType.INTERNAL,
            createWriter(),
            if (tragic != null) {  
 *
        } catch (Error ignored) {}
        ) {  
            }  
        try {  
            latch.countDown();
            stopped.set(true);
        } finally {  
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(  
        // Add a document successfully  
            createWriter(),
            new CompositeIndexWriter.LiveIndexWriterDeletesMap()
            indexWriterFactory
            while (run.get()) {
                    @Override
import java.util.function.Supplier;  
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
    // For refresh
        Supplier<Directory> dirSupplier = () -> new FilterDirectory(newDirectory()) {
            }  
            compositeIndexWriter.afterRefresh(true);
            config(),
                disposableIndexWriter.getIndexWriter().close();  
                }
    public void testChildDirectoryDeletedPostRefresh() throws IOException, InterruptedException {
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
        );  
                latch.await();
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
        }
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
            indexWriterFactory
        Thread refresher = new Thread(() -> {
        } catch (Error ignored) {}
            Thread.sleep(50); // Give merge time to start
            if (compositeIndexWriter != null) {  
            IOUtils.close(compositeIndexWriter);
        );
            config(),
            softDeletesField,
            softDeletesField,  
                throw new AssertionError(e);  
        });
        AtomicInteger numDeletes = new AtomicInteger();
            run.set(false);
            } finally {
            softDeletesField,
            for (int i = 0; i < 10; i++) {
            1,  
        compositeIndexWriter.getConfig().setRAMBufferSizeMB(128);  
            while (stopped.get() == false) {
                    @Override  
            softDeletesField,
            CompositeIndexWriter.DisposableIndexWriter disposableIndexWriter;  
            newSoftDeletesPolicy(),  
                IndexOutput out = super.createOutput(name, context);
            // Create documents in first criteria group  
                compositeIndexWriter.addDocuments(operation.docs(), operation.uid());  
        indexer.start();  
        refreshThread.start();
                IOUtils.closeWhileHandlingException(compositeIndexWriter);
        } finally {  
/*  
        );
            config(),  
            fail(ex.getMessage());
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {
        );
import org.opensearch.index.mapper.ParsedDocument;
                        throw new OutOfMemoryError("Simulated write failure");
import java.util.concurrent.atomic.AtomicReference;
                            primaryTerm.get(),
            data.put("status", "beforeCommit");
    public void testRollbackWithWriterOnOld() throws Exception {
import org.opensearch.common.lease.Releasable;
        try {  
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {
                };  
                            false,  
            data.put("status", "beforeRollback");  
            )
        }  
                    public void writeBytes(byte[] b, int offset, int length) throws IOException {  
        assertNotNull(finalMap.old);  
            } catch (Exception ignored) {}  
            newSoftDeletesPolicy(),
    }
                            if (ex != null) {
            softDeletesField,  
            } catch (Exception ignored) {}
                assertFalse(disposableIndexWriter.getLookupMap().isClosed());
            hitError = true;
    }
            config(),
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
                    createWriter(),
                throws IOException {  
                }
            softDeletesField,
            latch.await();
        String id = Integer.toString(randomIntBetween(1, 100));
            }
        );
        Engine.Index operation = indexForDoc(createParsedDoc(String.valueOf("-1"), null, DEFAULT_CRITERIA));
        try {  
import org.apache.lucene.index.LogByteSizeMergePolicy;
        try {  
            long ramAfterGroup1 = compositeIndexWriter.ramBytesUsed();  
 * compatible open source license.
            while (numOps > 0) {
        CompositeIndexWriter compositeIndexWriter = new CompositeIndexWriter(
            // Add a few small documents  
                liveIndexWriterDeletesMap.set(liveIndexWriterDeletesMap.get().buildTransitionMap());  
            // Reopen writer  
        // Add a document successfully
        } finally {
        try {
    public void testFlushingBytesWithTragicExceptionOnCurrent() throws Exception {
            compositeIndexWriter.addDocuments(operation.docs(), operation.uid());
                    @Override
            long ramBytesUsed = compositeIndexWriter.ramBytesUsed();
    public void testGetTragicExceptionWithOutOfMemoryError() throws Exception {
